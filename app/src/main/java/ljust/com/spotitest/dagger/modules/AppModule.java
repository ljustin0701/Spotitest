package ljust.com.spotitest.dagger.modules;

import android.app.Application;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import ljust.com.spotitest.AuthorizationManager;
import ljust.com.spotitest.MainActivity;
import ljust.com.spotitest.SpotApp;
import ljust.com.spotitest.dagger.scopes.ActivityScope;

/**
 * Presents the entry point for AndroidInjection
 */
@Module(includes = AndroidInjectionModule.class)
public abstract class AppModule {

    @Binds
    abstract Application application(SpotApp spotApp);

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();

    @Provides
    @Singleton
    @Named("defaultTokenManager")
    static AuthorizationManager accessTokenManager() {
        return new AuthorizationManager();
    }
}
