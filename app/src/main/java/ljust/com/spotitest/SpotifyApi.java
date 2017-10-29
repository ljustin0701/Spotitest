package ljust.com.spotitest;

import io.reactivex.Observable;
import ljust.com.spotitest.entity.NewReleases;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Spotify public web api
 */
public interface SpotifyApi {

    @GET("v1/browse/new-releases")
    Observable<NewReleases> getNewReleases(@Query("country")String country,
                                           @Query("offset")int offset,
                                           @Query("limit")int limit,
                                           @Header("Authorization")String authHeader);

}
