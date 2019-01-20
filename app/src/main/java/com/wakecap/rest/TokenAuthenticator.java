package com.wakecap.rest;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 */

class TokenAuthenticator implements Authenticator {
    private static final String TAG = TokenAuthenticator.class.getSimpleName();

    @Override
    public Request authenticate(Route route, Response response) {
        return response.request().newBuilder()
                .build();
    }
}
