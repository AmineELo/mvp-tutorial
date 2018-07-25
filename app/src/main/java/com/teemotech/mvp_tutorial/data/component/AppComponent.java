package com.teemotech.mvp_tutorial.data.component;

import android.app.Application;
import android.content.Context;

import com.teemotech.mvp_tutorial.ApplicationEntry;
import com.teemotech.mvp_tutorial.data.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Application application();
}
