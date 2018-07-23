package com.teemotech.mvp_tutorial.mainscreen;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.teemotech.mvp_tutorial.utils.VolleySingleton;

import javax.inject.Inject;

public class MainScreenModel implements MainScreenModelInterface {

    @Override
    public void performRequest(int type, String url, Response.Listener success, Response.ErrorListener error, Context context) {
        StringRequest stringRequest = new StringRequest(type, url, success, error);
        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
