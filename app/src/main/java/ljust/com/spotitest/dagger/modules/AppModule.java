package ljust.com.spotitest.dagger.modules;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import ljust.com.spotitest.MainActivity;
import ljust.com.spotitest.dagger.scopes.ActivityScope;

/**
 * Presents the entry point for AndroidInjection
 */
@Module(includes = AndroidInjectionModule.class)
public abstract class AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();

}
