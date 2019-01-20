package com.wakecap.rest;

import com.wakecap.model.APIResponse;
import com.wakecap.model.ItemsData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 */
public interface RestClient {

    @GET("sites/10010001/workers")
    Call<APIResponse<ItemsData>> getWorkers();
}




