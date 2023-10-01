package com.amandayi.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {


    //    获取用户名和密码
    private EditText username;
    private EditText password;
    //    获取登录按钮
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        //    获取用户名和密码
          EditText username = findViewById(R.id.et_username);
          EditText password = findViewById(R.id.et_password);
        //    获取登录按钮
          Button btn_login = findViewById(R.id.et_login);


          username.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {

              }

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {
                  Toast.makeText(EditTextActivity.this, s.toString(),Toast.LENGTH_SHORT).show();
              }

              @Override
              public void afterTextChanged(Editable s) {

              }
          });
          password.addTextChangedListener(new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {

              }

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Toast.makeText(EditTextActivity.this,s.toString(),Toast.LENGTH_SHORT).show();
              }

              @Override
              public void afterTextChanged(Editable s) {

              }
          });
//          登录
          btn_login.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(EditTextActivity.this,"登陆中",Toast.LENGTH_SHORT).show();
              }
          });
    }

}
