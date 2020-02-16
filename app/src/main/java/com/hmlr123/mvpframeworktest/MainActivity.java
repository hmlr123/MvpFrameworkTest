package com.hmlr123.mvpframeworktest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hmlr123.mvpframeworktest.view.MultipleInterfaceActivity;
import com.hmlr123.mvpframeworktest.view.SingleInterfaceActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mButton1;

    private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
    }

    private void initButton() {
        mButton1 = findViewById(R.id.button1);

        mButton2 = findViewById(R.id.button2);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent(this, SingleInterfaceActivity.class);
                break;
            case R.id.button2:
                intent = new Intent(this, MultipleInterfaceActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
