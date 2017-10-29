package ljust.com.spotitest.entity;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Authorization {

    public abstract String accessToken();

    public abstract int expiresIn();

    public static Authorization create(String accessToken,
                                       int expiresIn) {
        return new AutoValue_Authorization(accessToken, expiresIn);
    }

}
