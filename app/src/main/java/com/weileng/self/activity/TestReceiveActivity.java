package com.weileng.self.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.view.View;

import com.weileng.self.R;

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
//        mBroadcastReceiver = new WeilengRecevice();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(BROADCAST_ACTION);
//        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 测试有序广播
     */
    public void testyxRecevice(View v){
        // TODO Auto-generated method stub
//        Intent intent=new Intent("com.pzf.mybroadcast");
//        Bundle bundle=new Bundle();
//        bundle.putString("a", "aaa");
//        intent.putExtras(bundle);
//        //有序广播
//        sendOrderedBroadcast(intent, "com.pzf.permission");

        Intent intent=new Intent("com.pzf.mybroadcast");//清单文件中配置的
        intent.putExtra("msg", "ni hao ");
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);  //android 4.0以后必须加入这个获取自身的包名
        sendOrderedBroadcast(intent, null);//receiverPermission:是自定义个权限
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
