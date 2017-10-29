package ljust.com.spotitest.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Image {

    @JsonProperty("height")
    public abstract int height();

    @JsonProperty("url")
    public abstract String url();

    @JsonProperty("width")
    public abstract int width();

    @JsonCreator
    public static Image create(@JsonProperty("height") int height,
                               @JsonProperty("url") String url,
                               @JsonProperty("width") int width) {
        return new AutoValue_Image(height, url, width);
    }
}
