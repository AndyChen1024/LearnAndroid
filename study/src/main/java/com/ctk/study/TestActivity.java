package com.ctk.study;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.ctk.study.databinding.ActivityTestBinding;
import com.ctk.study.myinterface.Jump;

public class TestActivity extends AppCompatActivity {

    private String data1;
    private String data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test);



        binding.btnTest.setOnClickListener(v -> {

            data1 = binding.etStr1.getText().toString();
            data2 = binding.etStr2.getText().toString();

            LogUtils.d(data1);
            LogUtils.d(data2);
            if(StringUtils.isEmpty(data1)){
                ToastUtils.showShort(binding.etStr1.getHint());
                return;
            }
            if(StringUtils.isEmpty(data2)){
                ToastUtils.showShort(binding.etStr2.getHint());
                return;
            }

//            SecondActivity.start(this,data1,data2);
            startActivity(new Intent(this,SecondActivity.class));


        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, TestActivity.class);

        context.startActivity(starter);
    }
}