package ljust.com.spotitest.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.util.List;

import javax.annotation.Nullable;

@AutoValue
public abstract class Page<T> {

    @JsonProperty("href")
    public abstract String href();

    @JsonProperty("items")
    public abstract List<T> items();

    @JsonProperty("limit")
    public abstract int limit();

    @JsonProperty("next")
    public abstract String next();

    @JsonProperty("offset")
    public abstract int offset();

    @JsonProperty("previous")
    @Nullable
    public abstract String previous();

    @JsonProperty("total")
    public abstract int total();

    @JsonCreator
    public static <T> Page<T> create(@JsonProperty("href") String href,
                                     @JsonProperty("items") List<T> items,
                                     @JsonProperty("limit") int limit,
                                     @JsonProperty("next") String next,
                                     @JsonProperty("offset") int offset,
                                     @JsonProperty("previous") String previous,
                                     @JsonProperty("total") int total) {
        return new AutoValue_Page<>(href, items, limit, next, offset, previous, total);
    }
}
