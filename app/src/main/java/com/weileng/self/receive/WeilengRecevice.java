package com.weileng.self.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by lt on 2016/3/11.
 */
public class WeilengRecevice extends BroadcastReceiver {
    public static final String TAG = "WeilengRecevice";
    public static int m = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.w(TAG, "intent:" + intent);
        String name = intent.getStringExtra("name");
        Log.w(TAG, "name:" + name + " m=" + m);
        m++;

        Bundle bundle = intent.getExtras();

//        abortBroadcast();   //接收到广播后中断广播
    }
}
