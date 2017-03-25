package com.example.cglin.test1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);启动activity_main这个视图
        setContentView(R.layout.activity_main);
        //获取.xml中StartBtn这个按钮，并设置监听器
        findViewById(R.id.StartBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AnotherAty.class);

               // i.putExtra("data","helllo badai");


                //新建个Bundle
                Bundle b=new Bundle();

                //传递一个字符串，名字为name,信息为hi badai
                b.putString("name","hi badai");
                //传递整数，名字为age,信息为22
                b.putInt("age",22);

                //第一种方法传递资源包
                //i.putExtras(b);

                //第二种方法传递资源包
                i.putExtra("data",b);

                //启动这个activity
                startActivity(i);
            }
        });


    }
}
