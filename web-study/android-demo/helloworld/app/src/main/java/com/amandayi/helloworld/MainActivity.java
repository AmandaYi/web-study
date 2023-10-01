package com.amandayi.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtn;
    private Button mbtn2;

    private Button push_et;

    private Button push_radio_btn,push_checkbox,push_image_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//  找到xml里面的button
        mBtn = findViewById(R.id.btn_1);

        mBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TextViewActivity.class);
                startActivity(intent);
            }
        });

        mbtn2 = findViewById(R.id.btn_5);

        mbtn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ButtonActivity.class);
                startActivity(intent);
            }
        });
//        点击进入登录页面
        push_et=findViewById(R.id.push_et);
        push_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"进入登录页面",Toast.LENGTH_SHORT).show();

//                登录
                Intent i = new Intent(MainActivity.this,EditTextActivity.class);
                startActivity(i);
            }
        });

        push_radio_btn = findViewById(R.id.push_radio_btn);
        push_radio_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"进入单选页面",Toast.LENGTH_SHORT).show();

//                登录
                Intent i = new Intent(MainActivity.this,RadioButtonActivity.class);
                startActivity(i);
            }
        });
        push_checkbox = findViewById(R.id.push_radio_btn);
        push_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"进入单选页面",Toast.LENGTH_SHORT).show();

//                登录
                Intent i = new Intent(MainActivity.this,CheckBoxActivity.class);
                startActivity(i);
            }
        });

        push_image_view = findViewById(R.id.push_image_view);
        push_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"进入图片页面",Toast.LENGTH_SHORT).show();

//                登录
                Intent i = new Intent(MainActivity.this,ImageViewActivity.class);
                startActivity(i);
            }
        });
    }

}
