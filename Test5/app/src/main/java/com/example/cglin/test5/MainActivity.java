package com.example.cglin.test5;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //对控件对象进行声明

    private RadioGroup genderGroup=null;
    private RadioButton femaleButton=null;
    private RadioButton maleButton=null;
    private CheckBox swimBox=null;
    private CheckBox runBox=null;
    private CheckBox readBox=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //通过控件的ID得到代表控件的对象
        genderGroup= (RadioGroup) findViewById(R.id.genderGroup);
        femaleButton=(RadioButton) findViewById(R.id.femaleButton);
        maleButton=(RadioButton) findViewById(R.id.maleButton);
        swimBox=(CheckBox) findViewById(R.id.swimbox);
        runBox=(CheckBox)findViewById(R.id.runbox);
        readBox=(CheckBox)findViewById(R.id.readbox);

        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(femaleButton.getId()==checkedId){
                    System.out.println("famale");
                    //提示信息
                     Toast.makeText(MainActivity.this,"female",Toast.LENGTH_SHORT).show();
                }else if(maleButton.getId()==checkedId){
                    System.out.println("male");
                }
            }
        });

        swimBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    System.out.println("swim is checked");
                }
                else
                {
                    System.out.println("unchecked");
                }
            }
        });
        runBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    System.out.println("swim is checked");
                }
                else
                {
                    System.out.println("unchecked");
                }
            }
        });

        readBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                  System.out.println("swim is checked");
             }
            else
            {
                System.out.println("unchecked");
            }
          }
        });



    }
}
