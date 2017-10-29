package ljust.com.spotitest.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import ljust.com.spotitest.SpotApp;
import ljust.com.spotitest.dagger.modules.AppModule;

/**
 * There will only be one Application instance therefore Singleton
 */
@Singleton
@Component(modules = AppModule.class )
public interface AppComponent extends AndroidInjector<SpotApp> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<SpotApp> {
    }
}
