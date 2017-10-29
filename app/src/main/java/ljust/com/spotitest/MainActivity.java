package ljust.com.spotitest;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

import javax.inject.Inject;
import javax.inject.Named;

import ljust.com.spotitest.entity.Authorization;
import ljust.com.spotitest.view.SpotFragment;

/**
 * Single Main Activity with fragment swapping
 */
public class MainActivity extends BaseActivity {

    private static final int LOGIN_REQUEST_CODE = 100;
    private static final String CLIENT_ID = "INSERT_CLIENT_ID";

    @Inject @Named("activityFragmentManager")
    FragmentManager mFragmentManager;
    @Inject @Named("defaultTokenManager")
    AuthorizationManager mAuthManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            startAuthentication();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == LOGIN_REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);

            switch (response.getType()) {
                case TOKEN:
                    Authorization authorization = Authorization.create(response.getAccessToken(), response.getExpiresIn());
                    mAuthManager.setAuthorization(authorization);
                    mFragmentManager.beginTransaction().add(R.id.fragment_container, SpotFragment.create(), "spot").commit();
                    Toast.makeText(this, "Spotify Authenticated!", Toast.LENGTH_SHORT).show();
                    break;

                case ERROR:
                    Toast.makeText(this, "Spotify Authentication Error", Toast.LENGTH_SHORT).show();
                    break;

                default:
                    Toast.makeText(this, "Authentication was cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void startAuthentication() {
        Toast.makeText(this, "Authenticating Spotify...", Toast.LENGTH_SHORT).show();
        AuthenticationRequest request = new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, "Spotitest://callback").build();
        AuthenticationClient.openLoginActivity(MainActivity.this, LOGIN_REQUEST_CODE, request);
    }

}
