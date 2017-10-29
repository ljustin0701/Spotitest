package ljust.com.spotitest.entity;

import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.ryanharter.auto.value.parcel.ParcelAdapter;

import java.util.List;
import java.util.Map;

@AutoValue
public abstract class SimpleAlbum implements Parcelable {

    @JsonProperty("album_type")
    public abstract String albumType();

    @JsonProperty("artists")
    @ParcelAdapter(SimpleArtist.SimpleArtistsParcelAdapter.class)
    public abstract List<SimpleArtist> artists();

    @JsonProperty("available_markets")
    public abstract List<String> availableMarkets();

    @JsonProperty("external_urls")
    public abstract Map<String, String> externalUrls();

    @JsonProperty("href")
    public abstract String href();

    @JsonProperty("id")
    public abstract String id();

    @JsonProperty("images")
    public abstract List<Image> images();

    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("type")
    public abstract String type();

    @JsonProperty("uri")
    public abstract String uri();

    @JsonCreator
    public static SimpleAlbum create(@JsonProperty("album_type") String albumType,
                                     @JsonProperty("artists") List<SimpleArtist> artists,
                                     @JsonProperty("available_markets") List<String> availableMarkets,
                                     @JsonProperty("external_urls") Map<String, String> externalUrls,
                                     @JsonProperty("href") String href,
                                     @JsonProperty("id") String id,
                                     @JsonProperty("images") List<Image> images,
                                     @JsonProperty("name") String name,
                                     @JsonProperty("type") String type,
                                     @JsonProperty("uri") String uri) {
        return new AutoValue_SimpleAlbum(albumType, artists, availableMarkets, externalUrls, href, id, images, name, type, uri);
    }
}
