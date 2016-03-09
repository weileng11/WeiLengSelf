package com.weileng.self.activity;

import android.view.View;

import com.weileng.self.R;

/**
 * @author  lt
 * @time 2016/3/8
 * @deprecate 启动页面
 */
public class LaunchActivity extends BaseActivity {
    @Override
    public void initParameter() {
        setContentView(R.layout.lauch_activity);
    }

    @Override
    public void initView() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                    skipActivity(LaunchActivity.this,LoginActivity.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public void onClick(View v) {

    }
}
