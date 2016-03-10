package com.weileng.self;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/3/8.
 */
public class WlApplication extends Application{

    public static Context applicationContext;
    private static WlApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        instance = this;
    }

    public WlApplication getInstance(){
        return  instance;
    }

    //
}
