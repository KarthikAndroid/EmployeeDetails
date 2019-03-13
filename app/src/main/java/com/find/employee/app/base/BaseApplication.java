package com.find.employee.app.base;


import android.app.Application;

import com.find.employee.app.di.component.AppComponent;
import com.find.employee.app.di.component.DaggerAppComponent;
import com.find.employee.app.di.module.AppModule;
import com.find.employee.app.di.module.NetModule;



public class BaseApplication extends Application {


    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

//    @Override
//    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
//        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
//        component.inject(this);
//
//        return component;
//    }
}
