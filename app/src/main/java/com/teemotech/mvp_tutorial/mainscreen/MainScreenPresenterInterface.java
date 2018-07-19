package com.teemotech.mvp_tutorial.mainscreen;

public interface MainScreenPresenterInterface {
    void getRandomUser();
    void bindView(MainScreenViewInterface view);
    void unbindView();
}
