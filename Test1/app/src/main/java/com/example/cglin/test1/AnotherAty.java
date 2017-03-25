package com.example.cglin.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherAty extends AppCompatActivity {

    //定义那个视图中的tv
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_aty);

        //获取Intent
        Intent i=getIntent();
        //第一种方法接收Bundle
        //Bundle data=i.getExtras();

        //第二种方法接受Bundel
        Bundle data=i.getBundleExtra("data");

        //
        tv=(TextView) findViewById(R.id.tv);

        //tv.setText(i.getStringExtra("data"));
        tv.setText(String.format("name=%s,age=%d",data.getString("name"),data.getInt("age")));

    }
}
