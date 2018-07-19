package com.teemotech.mvp_tutorial.mainscreen;

import android.content.Context;

import com.android.volley.Response;

public interface MainScreenModelInterface {

    void performRequest(int type, String url, Response.Listener success, Response.ErrorListener error, Context context);
}
