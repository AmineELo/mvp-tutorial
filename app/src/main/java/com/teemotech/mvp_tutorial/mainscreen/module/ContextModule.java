package com.teemotech.mvp_tutorial.mainscreen.module;

import android.content.Context;

import com.teemotech.mvp_tutorial.utils.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @ActivityScope
    @Provides
    public Context providesContext(){
        return context;
    }
}
