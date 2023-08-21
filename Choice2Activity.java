package com.example.physcheck;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Choice2Activity extends AppCompatActivity implements View.OnClickListener {
    Intent intent = null;
    Button btnform, btnname;
    RadioGroup rg;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice2);
        btnform=findViewById(R.id.btnform);
        btnname=findViewById(R.id.btnname);
        btnform.setOnClickListener(this);
        btnname.setOnClickListener(this);
        rg = findViewById(R.id.rg);
        rb = findViewById(R.id.rbeasy);
        rb.setChecked(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnform:
                switch(rg.getCheckedRadioButtonId()) {
                    case R.id.rbeasy:
                    intent = new Intent(this, TesteActivity.class);
                    break;
                    case R.id.rbmedium:
                        intent = new Intent(this, TestmActivity.class);
                        break;
                    case R.id.rbhard:
                        intent = new Intent(this, TestActivity.class);
                        break;
                }
                break;
            case R.id.btnname:
                switch(rg.getCheckedRadioButtonId()) {
                    case R.id.rbeasy:
                        intent = new Intent(this, Teste2Activity.class);
                        break;
                    case R.id.rbmedium:
                        intent = new Intent(this, Testm2Activity.class);
                        break;
                    case R.id.rbhard:
                        intent = new Intent(this, Test2Activity.class);
                        break;
                }
        }
        startActivity(intent);
    }
}
