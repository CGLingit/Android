package com.example.cglin.dialog1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.setTitle("Welcome");
        dialog.setMessage("欢迎使用本程序");
        dialog.setPositiveButton("肯定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //确定完成的事情

            }
        });
        dialog.setNegativeButton("否定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //否定的事情
            }
        });

        dialog.create();
        dialog.show();

    }
}
