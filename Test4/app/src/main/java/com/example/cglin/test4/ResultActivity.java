package com.example.cglin.test4;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView myTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //记得这个步骤，很重要
        myTextview=(TextView) findViewById(R.id.myTextview);
        //接受Intent
        Intent i=getIntent();
        String str1=i.getStringExtra("one");
        String str2=i.getStringExtra("two");
        //字符串不能计算，转化为整形
        int int1=Integer.parseInt(str1);
        int int2=Integer.parseInt(str2);
        //计算积
        int result=int1 * int2;



        myTextview.setText(result+"");
    }
}
