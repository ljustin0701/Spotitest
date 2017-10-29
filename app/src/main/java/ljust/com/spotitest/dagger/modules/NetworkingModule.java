package ljust.com.spotitest.dagger.modules;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import ljust.com.spotitest.AuthorizationManager;
import ljust.com.spotitest.dagger.scopes.ActivityScope;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Module for providing retrofit stuff
 */
@Module
@ActivityScope
public abstract class NetworkingModule {

    @Provides
    @ActivityScope
    @Named("spotifyRetrofit")
    static Retrofit providesRetrofit(@Named("defaultObjectMapper") ObjectMapper objectMapper) {
        return new Retrofit.Builder()
                .baseUrl("https://api.spotify.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
    }

    @Provides
    @ActivityScope
    @Named("defaultObjectMapper")
    static ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
