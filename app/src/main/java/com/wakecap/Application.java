package com.wakecap;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.wakecap.dagger.DaggerComponent;
import com.wakecap.dagger.DaggerDaggerComponent;
import com.wakecap.rest.NetworkModule;

public class Application extends MultiDexApplication {

    private DaggerComponent component;
    private static Application instance;

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

    public static Application getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
