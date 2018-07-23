package com.teemotech.mvp_tutorial;

import android.app.Application;

import com.teemotech.mvp_tutorial.data.component.AppComponent;
import com.teemotech.mvp_tutorial.data.component.DaggerAppComponent;
import com.teemotech.mvp_tutorial.data.module.AppModule;

public class ApplicationEntry extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
