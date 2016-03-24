package com.weileng.self.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;

import com.weileng.self.R;
import com.weileng.self.receive.WeilengRecevice;

/**
 * Created by lt on 2016/3/11.
 * 测试广播
 * http://www.cnblogs.com/lwbqqyumidi/p/4168017.html
 * http://blog.csdn.net/xiazdong/article/details/7768807/
 */
public class TestReceiveActivity extends BaseActivity {
    public static final String BROADCAST_ACTION = "com.weileng.self";
    private BroadcastReceiver mBroadcastReceiver;

    @Override
    public void initParameter() {
        setContentView(R.layout.testreceive_activity);
    }

    @Override
    public void initView() {
        //动态注册广播
        mBroadcastReceiver = new WeilengRecevice();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 发送广播
     * @param v
     */
    public void testRecevice(View v) {
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION);
        intent.putExtra("name", "weileng");
        sendBroadcast(intent);
//        sendOrderedBroadcast(intent,null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }
}
