package com.booko;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.booko.dagger.DaggerComponent;
import com.booko.dagger.DaggerDaggerComponent;
import com.booko.rest.NetworkModule;

public class BookoApplication extends MultiDexApplication {

    private DaggerComponent component;
    private static BookoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        buildDaggerModules();
    }

    void buildDaggerModules(){
       component =  DaggerDaggerComponent.builder()
                .networkModule(new NetworkModule())
                .build();
    }

    public DaggerComponent getComponent(){
        return component;
    }

    public static BookoApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
