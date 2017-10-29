package ljust.com.spotitest.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.ryanharter.auto.value.parcel.TypeAdapter;

import java.util.List;
import java.util.Map;

@AutoValue
public abstract class SimpleArtist implements Parcelable {

    @JsonProperty("external_urls")
    public abstract Map<String, String> externalUrls();

    @JsonProperty("href")
    public abstract String href();

    @JsonProperty("id")
    public abstract String id();

    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("type")
    public abstract String type();

    @JsonProperty("uri")
    public abstract String uri();

    @JsonCreator
    public static SimpleArtist create(@JsonProperty("external_urls") Map<String, String> externalUrls,
                                      @JsonProperty("href") String href,
                                      @JsonProperty("id") String id,
                                      @JsonProperty("name") String name,
                                      @JsonProperty("type") String type,
                                      @JsonProperty("uri") String uri) {
        return new AutoValue_SimpleArtist(externalUrls, href, id, name, type, uri);
    }

    public static final class SimpleArtistsParcelAdapter implements TypeAdapter<List<SimpleArtist>> {

        @Override
        public List<SimpleArtist> fromParcel(Parcel in) {
            return in.createTypedArrayList(new Creator<SimpleArtist>() {
                @Override
                public SimpleArtist createFromParcel(Parcel source) {
                    return AutoValue_SimpleArtist.CREATOR.createFromParcel(source);
                }

                @Override
                public SimpleArtist[] newArray(int size) {
                    return new SimpleArtist[size];
                }
            });
        }

        @Override
        public void toParcel(List<SimpleArtist> value, Parcel dest) {
            dest.writeTypedList(value);
        }
    }
}
