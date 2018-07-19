package com.teemotech.mvp_tutorial.mainscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.teemotech.mvp_tutorial.R;

public class MainActivity extends AppCompatActivity implements MainScreenViewInterface {

    private ImageView randomUserImage;
    private TextView randomUserFullName, randomUserEmail;
    private MainScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

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
