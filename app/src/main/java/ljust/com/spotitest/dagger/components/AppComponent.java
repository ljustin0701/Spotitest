package ljust.com.spotitest.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import ljust.com.spotitest.SpotApp;
import ljust.com.spotitest.dagger.modules.AppModule;

/**
 * There will only be one Application instance therefore Singleton
 */
@Singleton
@Component(modules = AppModule.class )
public interface AppComponent {
    void inject(SpotApp app);
}
