package ljust.com.spotitest;

import javax.inject.Inject;

import ljust.com.spotitest.entity.Authorization;

/**
 * Holds access token for HTTP requests
 */
public class AuthorizationManager {

    private Authorization mAuthorization;

    @Inject
    public AuthorizationManager() {}

    public void setAuthorization(Authorization authorization) {
        mAuthorization = authorization;
    }

    public String getAccessToken() {
        return mAuthorization.accessToken();
    }
}
