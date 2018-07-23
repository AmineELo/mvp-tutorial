package com.teemotech.mvp_tutorial.mainscreen.module;

import com.teemotech.mvp_tutorial.mainscreen.MainScreenModel;
import com.teemotech.mvp_tutorial.mainscreen.MainScreenModelInterface;
import com.teemotech.mvp_tutorial.mainscreen.MainScreenViewInterface;
import com.teemotech.mvp_tutorial.utils.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private MainScreenViewInterface view;

    public MainActivityModule(MainScreenViewInterface view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public MainScreenViewInterface provideMainScreenView(){
        return view;
    }

    @ActivityScope
    @Provides
    public MainScreenModelInterface provideMainScreenModel(){
        return new MainScreenModel();
    }
}
