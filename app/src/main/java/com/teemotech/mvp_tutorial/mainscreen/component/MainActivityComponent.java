package com.teemotech.mvp_tutorial.mainscreen.component;

import com.teemotech.mvp_tutorial.data.component.AppComponent;
import com.teemotech.mvp_tutorial.mainscreen.MainActivity;
import com.teemotech.mvp_tutorial.mainscreen.module.MainActivityModule;
import com.teemotech.mvp_tutorial.utils.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
