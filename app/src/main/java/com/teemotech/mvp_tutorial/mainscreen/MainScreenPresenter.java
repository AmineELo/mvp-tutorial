package com.teemotech.mvp_tutorial.mainscreen;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.teemotech.mvp_tutorial.mainscreen.model.RandomUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.inject.Inject;

public class MainScreenPresenter implements MainScreenPresenterInterface {

    private MainScreenModelInterface model;
    private MainScreenViewInterface view;

    private final String URL = "https://randomuser.me/api/";

    @Inject
    public MainScreenPresenter(MainScreenModelInterface model, MainScreenViewInterface view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getRandomUser(Context context) {
        Response.Listener listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                view.updateView(randomUserData(response));
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
        model.performRequest(Request.Method.GET, URL, listener, errorListener, context);
    }

    private RandomUser randomUserData(String response){
        RandomUser randomUser = new RandomUser();
        try {
            JSONObject reponse = (JSONObject) new JSONTokener(response).nextValue();
            JSONArray results = reponse.getJSONArray("results");

            JSONObject name = results.getJSONObject(0).getJSONObject("name");

            String imageUrl = results.getJSONObject(0).getJSONObject("picture").getString("medium");
            String fullName = name.getString("title")
                    + " " + name.getString("first")
                    + " " + name.getString("last");

            String email = results.getJSONObject(0).getString("email");


            randomUser = new RandomUser(imageUrl, fullName, email);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return randomUser;
    }
}
