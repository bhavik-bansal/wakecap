package com.booko.rest;

import com.booko.model.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 */
public interface RestClient {

    @GET("{id}/projects")
    Call<APIResponse> getProjects(@Path("id") int networkId);
}




