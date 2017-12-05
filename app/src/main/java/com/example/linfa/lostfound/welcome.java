package com.example.linfa.lostfound;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        final Intent it = new Intent(this, login.class);//跳转到login
        Timer timer = new Timer();//计时器
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(it);//执行
                finish();//关闭自己
            }
        };
        timer.schedule(task, 1000 * 2);//计时 3秒后跳转

    }
}
