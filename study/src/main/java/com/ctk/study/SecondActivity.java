package com.ctk.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class SecondActivity extends AppCompatActivity {

//    public static void start(Context context,String data1,String data2) {
//        Intent starter = new Intent(context, SecondActivity.class);
//        starter.putExtra("data1",data1);
//        starter.putExtra("data2",data2);
//        context.startActivity(starter);
//    }

    private String data1;
    private String data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        JumpUtils.jumpInject(this);
    }
}