package com.amandayi.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
public class ButtonActivity extends AppCompatActivity {

    private Button mbtn;
    private TextView text_view_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

       TextView text_view_1 = findViewById(R.id.text_view_1);
        text_view_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"我是文本内容",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void  showToast(View view){
        Toast.makeText(this,"你好",Toast.LENGTH_SHORT).show();
    }

}
