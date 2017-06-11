package ljust.com.spotitest;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ljust.com.spotitest.fragments.SpotFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onStart() {
        mFragmentManager.beginTransaction().add(R.id.fragment_container, SpotFragment.create(), "spot").commit();
        super.onStart();
    }
}
