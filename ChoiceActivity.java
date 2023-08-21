package com.example.physcheck;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3;
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn1:
                intent = new Intent(this, SpravkaActivity.class);
                break;
            case R.id.btn2:
                intent= new Intent(this, TermodinamicActivity.class);
                break;
            case R.id.btn3:
                intent = new Intent(this, ElectricityActivity.class);
        }
        startActivity(intent);
    }
}
