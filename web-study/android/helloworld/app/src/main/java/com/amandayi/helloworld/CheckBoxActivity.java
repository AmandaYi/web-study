package com.amandayi.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
   private CheckBox c1, c2, c3, c4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        init();
    }
    private void init(){
        c1 = findViewById(R.id.cb_1);
        c2 = findViewById(R.id.cb_2);
        c3 = findViewById(R.id.cb_3);
        c4 = findViewById(R.id.cb_4);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"选择了"+c1.getText():"未选"+c1.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"选择了"+c2.getText():"未选"+c2.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"选择了"+c3.getText():"未选"+c3.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"选择了"+c4.getText():"未选"+c4.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
