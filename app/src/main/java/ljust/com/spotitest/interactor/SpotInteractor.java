package ljust.com.spotitest.interactor;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import ljust.com.spotitest.AuthorizationManager;
import ljust.com.spotitest.SpotifyApi;
import ljust.com.spotitest.entity.NewReleases;
import retrofit2.Retrofit;

/**
 * Interactor for SpotPresenter which is the backend entry point
 */
public class SpotInteractor {

    private SpotifyApi mSpotifyApi;
    private AuthorizationManager mAuthManager;

    @Inject
    public SpotInteractor(@Named("spotifyRetrofit")Retrofit retrofit,
                          @Named("defaultTokenManager")AuthorizationManager manager){
        mSpotifyApi = retrofit.create(SpotifyApi.class);
        mAuthManager = manager;
    }

    public Observable<NewReleases> getData(String country, int offset, int limit) {
        return mSpotifyApi.getNewReleases(country, offset, limit, "Bearer " + mAuthManager.getAccessToken());
    }
}
