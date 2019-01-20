package com.wakecap.viewmodel;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.wakecap.Application;
import com.wakecap.model.APIResponse;
import com.wakecap.model.ItemsData;
import com.wakecap.rest.RestClient;
import com.wakecap.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    RestClient client;

    public HomeViewModel(){
        client = Application.getInstance().getComponent().client();
    }

    public LiveData<APIResponse<ItemsData>> getData() {
        MutableLiveData<APIResponse<ItemsData>> data = new MutableLiveData<>();
        client.getWorkers().enqueue(new Callback<APIResponse<ItemsData>>() {
            @Override
            public void onResponse(Call<APIResponse<ItemsData>> call, Response<APIResponse<ItemsData>> response) {
                if (response.code() == 200){
                    data.setValue(APIResponse.success(response.body()));
                }else{
                    data.setValue(APIResponse.error(response.body().getMessage(),null));
                }
            }

            @Override
            public void onFailure(Call<APIResponse<ItemsData>> call, Throwable t) {
                data.setValue(APIResponse.error(Constants.SERVER_ERROR,null));
            }
        });
        return data;
    }
}
