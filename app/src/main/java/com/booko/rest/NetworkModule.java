package com.booko.rest;


import com.booko.utils.Config;
import com.booko.utils.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient.Builder provideBuilder() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(Config.getLoggingInterceptor());

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.authenticator(new TokenAuthenticator());
        builder.addInterceptor(httpLoggingInterceptor);
        builder.interceptors().add(chain -> {
            Request.Builder builder1 = chain.request().newBuilder()
                    .header("Client-Id", Constants.CLIENT_ID)
                    .header("Authorization", "791e8311f701d285842d33a2304d86a429fe381e")
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
    public RestClient provideRestClient(Retrofit retrofit) {
        return retrofit.create(RestClient.class);
    }

}
