package com.teemotech.mvp_tutorial.mainscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.teemotech.mvp_tutorial.ApplicationEntry;
import com.teemotech.mvp_tutorial.R;
import com.teemotech.mvp_tutorial.mainscreen.component.DaggerMainActivityComponent;
import com.teemotech.mvp_tutorial.mainscreen.model.RandomUser;
import com.teemotech.mvp_tutorial.mainscreen.module.MainActivityModule;

public class MainActivity extends AppCompatActivity implements MainScreenViewInterface {

    private ImageView randomUserImage;
    private TextView randomUserFullName, randomUserEmail;
    private MainScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        injectMainActivityComponent();

        MainScreenModel model = new MainScreenModel();
        presenter = new MainScreenPresenter(model, this);
        presenter.bindView(this);

        presenter.getRandomUser();
    }

    private void bindViews(){
        randomUserImage = findViewById(R.id.randomUserImage);
        randomUserFullName = findViewById(R.id.randomUserName);
        randomUserEmail = findViewById(R.id.randomUserEmail);
    }

    private void injectMainActivityComponent(){
        DaggerMainActivityComponent
                .builder()
                .appComponent(((ApplicationEntry)getApplicationContext()).getAppComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onDestroy() {
        presenter.unbindView();
        super.onDestroy();
    }

    @Override
    public void updateView(RandomUser randomUser) {
        Picasso.get().load(randomUser.getImageUrl()).into(randomUserImage);
        randomUserFullName.setText(randomUser.getName());
        randomUserEmail.setText(randomUser.getEmail());
    }
}
