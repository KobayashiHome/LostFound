package com.example.linfa.lostfound;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Bean.User;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class Registered extends AppCompatActivity {
    private EditText Ruser;
    private EditText Rpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        Bmob.initialize(this, "273f3246412dd9a47fb0163e2d6291f9");


        Button button_login = (Button) findViewById(R.id.login_button);
        Button button_registered = (Button) findViewById(R.id.registered_button);

        Ruser = (EditText) findViewById(R.id.registered_user);
        Rpass = (EditText) findViewById(R.id.registered_pass);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registered.this,login.class);
                startActivity(intent);
                finish();
            }
        });
        button_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = Ruser.getText().toString();
                String pass = Rpass.getText().toString();
                //添加数据
                User p2 = new User();
                p2.setUsername(user);
                p2.setPassword(pass);
                p2.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                            Toast.makeText(Registered.this,"注册成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registered.this,login.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(Registered.this,"注册失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}
