package com.weileng.self.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.weileng.self.R;
import com.weileng.self.adapter.FragmentAdapter;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    public static final int TAB_HOME = 0;
    public static final int TAB_CATAGORY = 1;
    public static final int TAB_CAR = 2;
    public static final int TAB_BUY = 3;
    public static final int TAB_MORE = 4;

    private ViewPager viewPager;
    private RadioButton main_tab_home, main_tab_catagory, main_tab_car,
            main_tab_buy, main_tab_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addListener();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        main_tab_home = (RadioButton) findViewById(R.id.main_tab_home);
        main_tab_catagory = (RadioButton) findViewById(R.id.main_tab_catagory);
        main_tab_car = (RadioButton) findViewById(R.id.main_tab_car);
        main_tab_buy = (RadioButton) findViewById(R.id.main_tab_buy);
        main_tab_more = (RadioButton) findViewById(R.id.main_tab_more);
        main_tab_home.setOnClickListener(MainActivity.this);
        main_tab_catagory.setOnClickListener(MainActivity.this);
        main_tab_car.setOnClickListener(MainActivity.this);
        main_tab_buy.setOnClickListener(this);
        main_tab_more.setOnClickListener(this);

        FragmentAdapter adapter = new FragmentAdapter(
                getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    private void addListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int id) {
                switch (id) {
                    case TAB_HOME:
                        main_tab_home.setChecked(true);
                        break;
                    case TAB_CATAGORY:
                        main_tab_catagory.setChecked(true);
                        break;
                    case TAB_CAR:
                        main_tab_car.setChecked(true);
                        break;
                    case TAB_BUY:
                        main_tab_buy.setChecked(true);
                        break;
                    case TAB_MORE:
                        main_tab_more.setChecked(true);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_tab_home:
                viewPager.setCurrentItem(TAB_HOME);
                break;
            case R.id.main_tab_catagory:
                viewPager.setCurrentItem(TAB_CATAGORY);
                break;
            case R.id.main_tab_car:
                viewPager.setCurrentItem(TAB_CAR);
                break;
            case R.id.main_tab_buy:
                viewPager.setCurrentItem(TAB_BUY);
                break;
            case R.id.main_tab_more:
                viewPager.setCurrentItem(TAB_MORE);
                break;

            default:
                break;
        }
    }

    private int backKeyCount; // 返回按键次数
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (backKeyCount == 0) {
                String  tip = "再按一次退出应用";
                Toast.makeText(this, tip, 0).show();
                backKeyCount++;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        backKeyCount = 0;
                    }
                }, 1500);
            } else {
                backKeyCount = 0;
                finish();
            }
        }
        return false;
    }
}
