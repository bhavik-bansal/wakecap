package com.wakecap.rest;


import com.readystatesoftware.chuck.ChuckInterceptor;
import com.wakecap.Application;
import com.wakecap.utils.Config;
import com.wakecap.utils.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient.Builder provideBuilder() {

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.authenticator(new TokenAuthenticator());
        builder.addInterceptor(new ChuckInterceptor(Application.getInstance()));
        builder.interceptors().add(chain -> {
            Request.Builder builder1 = chain.request().newBuilder()
                    .header("X-Requested-With", "XMLHttpRequest")
                    .header("Authorization", Constants.ACCESS_TOKEN)
                    .header("Content-Type", "application/json");

            Request newRequest = builder1.build();
            return chain.proceed(newRequest);
        });


        builder.readTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS).
                connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        return builder;
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient.Builder builder) {
        // Set the custom client when building adapter
        return new Retrofit.Builder()
                .baseUrl(Config.getBaseUrl() + "/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }


    @Provides
    @Singleton
    RestClient provideRestClient(Retrofit retrofit) {
        return retrofit.create(RestClient.class);
    }

}
