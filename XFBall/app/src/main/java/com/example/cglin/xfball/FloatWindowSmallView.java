package com.example.cglin.xfball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/4/12.
 */

public class FloatWindowSmallView extends LinearLayout {
    //记录小浮窗口的宽度
    public static int viewWidth;
    //记录小悬浮窗口的高度
    public static int viewHeight;
    //记录系统状态栏的高度
    public static int statusBarHeight;
    //用于更新小悬浮窗口的位置
    private WindowManager windowManager;
    //小悬浮窗口的参数
    private WindowManager.LayoutParams mParams;
    //记录当前手指位置在屏幕的横坐标值
    private float xInScreen;
    //记录当前手指位置在屏幕的纵坐标值
    private float yInScreen;
    //记录当前手指按下屏幕时的横坐标值
    private float xDownInScreen;
    //记录当前手指按下屏幕时的纵坐标值
    private float yDownInScreen;
    //记录手指按下时在小悬浮窗View上的横坐标的值
    private float xInView;
    //记录手指按下时在小悬浮窗View上的纵坐标的值
    private float yInView;

    public FloatWindowSmallView(Context context) {
        super(context);
        windowManager=(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.activity_float_window_small,this);
        View view =findViewById(R.id.float_window_small);
        viewHeight=view.getLayoutParams().height;
        viewWidth=view.getLayoutParams().width;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //手指按下时记录必要数据，纵坐标的值需要减去状态栏高度
                xInView=event.getX();
                yInView=event.getY();
                xDownInScreen=event.getRawX();
                yDownInScreen=event.getRawY() - getStatusBarHeight();
                xInScreen=event.getRawX();
                yInScreen=event.getRawY() - getStatusBarHeight();
                break;
            case MotionEvent.ACTION_MOVE:
                xInScreen=event.getRawX();
                yInScreen=event.getRawY() - getStatusBarHeight();
                updateViewPosition();
                break;
            case MotionEvent.ACTION_UP:
                // 如果手指离开屏幕时，xDownInScreen和xInScreen相等，且yDownInScreen和yInScreen相等，
                // 则视为触发了单击事件。
                if(xDownInScreen==xInScreen && yDownInScreen==yInScreen){
                    openBigWindow();
                }
                break;
            default:
                break;
        }
        return true;
    }
    //将小悬浮窗口的参数传入，用于更新小悬浮窗口的位置
    public void setParams(WindowManager.LayoutParams params){
        mParams = params;
    }

//更新小悬浮窗口在屏幕中的位置
    private void updateViewPosition() {
        mParams.x=(int) (xInScreen - xInView);
        mParams.y=(int) (yInScreen - yInView);
        windowManager.updateViewLayout(this,mParams);
    }

//打开大悬浮窗口，同时关掉小悬浮窗口
    private void openBigWindow() {
        MyWindowManager.createBigWindow(getContext());
        MyWindowManager.removeSmallWindow(getContext());
    }

//获取状态栏的高度
// return 返回状态栏高度的像素值
private int getStatusBarHeight() {

    if (statusBarHeight== 0) {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object o = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = (Integer) field.get(o);
            statusBarHeight = getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return statusBarHeight;
}

}
