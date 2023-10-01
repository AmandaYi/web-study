package com.amandayi.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView image_view_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        image_view_1 = findViewById(R.id.image_view_1);
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png?where=super").into(image_view_1);
    }
}
