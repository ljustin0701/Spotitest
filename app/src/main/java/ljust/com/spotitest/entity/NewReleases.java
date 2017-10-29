package ljust.com.spotitest.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class NewReleases {

    @JsonProperty("albums")
    public abstract Page<SimpleAlbum> albums();

    @JsonCreator
    public static NewReleases create(@JsonProperty("albums") Page<SimpleAlbum> albums) {
        return new AutoValue_NewReleases(albums);
    }

}
