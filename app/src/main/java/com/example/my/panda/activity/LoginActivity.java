package com.example.my.panda.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.my.panda.R;

public class LoginActivity extends AppCompatActivity {

    private ImageView imageview_personal_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        imageview_personal_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initView() {
        imageview_personal_back = (ImageView) findViewById(R.id.imageview_personal_back);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
