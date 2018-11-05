package com.booko.viewmodel;


import com.booko.BookoApplication;
import com.booko.rest.RestClient;

import javax.inject.Inject;

public class HomeViewModel {
    @Inject
    RestClient client;

    public HomeViewModel(){
        BookoApplication.getInstance().getComponent().inject(this);
    }

    public void checkApi() {

    }
}
