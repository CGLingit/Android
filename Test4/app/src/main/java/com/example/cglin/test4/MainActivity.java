package com.example.cglin.test4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView symbol;
    private EditText first;
    private EditText second;
    private Button cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //根据控件的ID和取得代表控件的对象
        first=(EditText)findViewById(R.id.first);
        second=(EditText)findViewById(R.id.second);
        symbol=(TextView)findViewById(R.id.symblo);
        findViewById(R.id.cal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //取得两个EditText控件的值
                String firstStr=first.getText().toString();
                String secondStr=second.getText().toString();
                //将这两个值存放到Intent对象当中
                Intent i=new Intent(MainActivity.this,ResultActivity.class);
                i.putExtra("one",firstStr);
                i.putExtra("two",secondStr);
                startActivity(i);
            }
        });


    }
}
