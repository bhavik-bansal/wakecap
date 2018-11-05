package com.booko.dagger;


import com.booko.rest.NetworkModule;
import com.booko.viewmodel.HomeViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bhavik
 */

@Singleton
@Component(modules =  NetworkModule.class)
public interface DaggerComponent {
    void inject(HomeViewModel viewModel);

}