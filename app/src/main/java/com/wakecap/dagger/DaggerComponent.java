package com.wakecap.dagger;


import com.wakecap.rest.NetworkModule;
import com.wakecap.rest.RestClient;
import com.wakecap.viewmodel.HomeViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bhavik
 */

@Singleton
@Component(modules =  NetworkModule.class)
public interface DaggerComponent {
    RestClient client();
}