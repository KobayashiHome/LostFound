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
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;


public class login extends AppCompatActivity {

    private EditText luser;
    private EditText lpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化Bmob
        Bmob.initialize(this, "273f3246412dd9a47fb0163e2d6291f9");



        Button button_registerd = (Button) findViewById(R.id.registered_button);
        Button button_login = (Button) findViewById(R.id.login_button);
        luser = (EditText) findViewById(R.id.login_user);
        lpass = (EditText) findViewById(R.id.login_pass);
        //跳转注册页面
        button_registerd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,Registered.class);
                startActivity(intent);
                finish();
            }
        });
        //进行查询登录
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = luser.getText().toString();
                String pass = lpass.getText().toString();
                //进行数据查询
                BmobQuery<User> bmobQuery = new BmobQuery<User>();

                bmobQuery.getObject(user, new QueryListener<User>() {
                    @Override
                    public void done(User object,BmobException e) {
                        if(e==null){
                            Toast.makeText(login.this,"登陆失败",Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(login.this,"登陆成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(login.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });



            }
        });

    }
}
