package ljust.com.spotitest.dagger.modules;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ljust.com.spotitest.MainActivity;
import ljust.com.spotitest.dagger.scopes.ActivityScope;
import ljust.com.spotitest.dagger.scopes.FragmentScope;
import ljust.com.spotitest.view.SpotFragment;

/**
 * Provides dependencies for MainActivity
 */
@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = SpotFragmentModule.class)
    abstract SpotFragment spotFragmentInjector();

    @Binds
    @ActivityScope
    abstract Activity activity(MainActivity activity);
}
