package com.example.cglin.progressbardemo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    //声明变量
    private ProgressBar firstBar=null;
    private ProgressBar secondBar=null;
    private Button myButton=null;
    private  int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //根据控件的ID取得代表控件的对象
        firstBar=(ProgressBar)findViewById(R.id.firstBar);
        secondBar=(ProgressBar)findViewById(R.id.secondBar);
        myButton=(Button)findViewById(R.id.myButton);
        //设置BUTTON的监听器
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    //设置进度条处于可见的状态
                    firstBar.setVisibility(View.VISIBLE);
                    secondBar.setVisibility(View.VISIBLE);
                }
                else if(i<100){
                    //将主进度条设置为i的位置
                    firstBar.setProgress(i);
                    //设置第二进度条位置
                    firstBar.setSecondaryProgress(i+10);
                }
                else{
                    //设置进度条不可见状态
                    firstBar.setVisibility(View.GONE);
                    secondBar.setVisibility(View.GONE);
                }
                i=i+10;
            }

        });
    }

}
