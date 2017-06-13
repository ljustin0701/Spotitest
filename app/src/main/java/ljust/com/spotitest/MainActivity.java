package ljust.com.spotitest;

import android.app.FragmentManager;
import android.os.Bundle;

import javax.inject.Inject;
import javax.inject.Named;

import ljust.com.spotitest.view.SpotFragment;

/**
 * Single Main Activity with fragment swapping
 */
public class MainActivity extends BaseActivity {

    @Inject
    @Named("activityFragmentManager")
    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        mFragmentManager.beginTransaction().add(R.id.fragment_container, SpotFragment.create(), "spot").commit();
        super.onStart();
    }

}
