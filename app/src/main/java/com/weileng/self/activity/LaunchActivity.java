package com.weileng.self.activity;

import android.os.Bundle;

import com.weileng.self.R;

/**
 * @author  lt
 * @time 2016/3/8
 * @deprecate 启动页面
 */
public class LaunchActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lauch_activity);

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                    skipActivity(LaunchActivity.this,MainActivity.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
