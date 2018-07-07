package com.example.rock_boy69.car_parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    private Button mRegBtn;
    private Button mLogin;

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        mLogin = (Button) findViewById(R.id.start_login_btn);


        mImageView = (ImageView) findViewById(R.id.imageViewId);
        mImageView.setImageResource(R.drawable.logoinicial);



        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login_intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(login_intent);

            }
        });


    }
}
