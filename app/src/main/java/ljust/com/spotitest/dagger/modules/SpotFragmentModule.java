package ljust.com.spotitest.dagger.modules;

import android.app.Fragment;

import dagger.Binds;
import dagger.Module;
import ljust.com.spotitest.dagger.scopes.FragmentScope;
import ljust.com.spotitest.view.SpotFragment;

/**
 * Provides dependencies for SpotFragment
 */
@Module(includes = BaseFragmentModule.class)
public abstract class SpotFragmentModule {
    @Binds
    @FragmentScope
    abstract Fragment fragment(SpotFragment mainFragment);
}
