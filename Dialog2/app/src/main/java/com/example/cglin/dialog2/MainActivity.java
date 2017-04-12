package com.example.cglin.dialog2;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private TextView showdate;
    private Button setdate;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showdate=(TextView) this.findViewById(R.id.showtime);
        setdate=(Button) this.findViewById(R.id.setdate);
        Calendar c=Calendar.getInstance(Locale.CHINA);

        Date mydate=new Date();
        c.setTime(mydate);

        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);

        setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog my_datePickDialog=new DatePickerDialog(MainActivity.this,Datelistener,year,month,day);
                DatePicker datePicker=my_datePickDialog.getDatePicker();
                long maxdate=System.currentTimeMillis();
                long mindate=0;
                datePicker.setMaxDate(maxdate);
                datePicker.setMinDate(mindate);

                my_datePickDialog.show();
            }
        });
    }
    private DatePickerDialog.OnDateSetListener Datelistener=new DatePickerDialog.OnDateSetListener()
    {

        @Override
        public void onDateSet(DatePicker v, int y, int m, int d) {


            //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
            year=y;
            month=m;
            day=d;
            //更新日期
            updateDate();

        }
        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate()
        {
            //在TextView上显示日期
            showdate.setText("当前日期："+year+"-"+(month+1)+"-"+day);
        }
    };

}
