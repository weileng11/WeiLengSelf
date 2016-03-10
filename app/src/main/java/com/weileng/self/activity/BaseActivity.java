package com.weileng.self.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.weileng.self.db.BaseDao;
import com.weileng.self.db.DatabaseHelper;
import com.weileng.self.db.IOperateType;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/3/8.
 */
public abstract class BaseActivity extends AppCompatActivity  implements
        View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParameter();
        initView();

    }

    public abstract void initParameter();

    public abstract void initView();

    /**
     * 得到操作数据库的dao
     * @param clazz
     * @return
     */
    public/*protected*/ <T extends IOperateType> BaseDao<T> getDao(final Class<T> clazz){
        BaseDao<T> baseDao=new BaseDao<T>() {

            @Override
            public Dao<T, Integer> getDao() throws SQLException {
                // TODO Auto-generated method stub
                return getHelper().getDao(clazz);
            }
        };
        return baseDao;
    }
    private DatabaseHelper dataHelper = null;
    private DatabaseHelper getHelper() {
        if (dataHelper == null) {
            dataHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return dataHelper;
    }
    private void replaceHelper(){
        if(dataHelper!=null){
            OpenHelperManager.releaseHelper();
            dataHelper=null;
        }
    }

    /**
     * set views click
     * @param view
     */
    protected void setOnClick(View...view){
        for(int i=0;i<view.length;i++){
            view[i].setOnClickListener(BaseActivity.this);
        }
    }

    /**
     * 返回键
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * @param text 自定义文本
     * 显示Toast
     */
    public void showToast(CharSequence text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param resId 显示资源文件里的文本
     * 显示Toast
     */
    public void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 跳转后，当前界面自销毁
     */
    public void skipActivity(Activity aty, Class<?> cls) {
        showActivity(aty, cls);
        aty.finish();
    }

    /**
     * 跳转后，当前界面自销毁
     */
    public void skipActivity(Activity aty, Intent it) {
        showActivity(aty, it);
        aty.finish();
    }

    /**
     * 跳转后，当前界面自销毁
     */
    public void skipActivity(Activity aty, Class<?> cls, Bundle extras) {
        showActivity(aty, cls, extras);
        aty.finish();
    }

    /**
     * Activity跳转
     */
    public void showActivity(Activity aty, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(aty, cls);
        aty.startActivity(intent);
    }

    /**
     * Activity跳转
     */
    public void showActivity(Activity aty, Intent it) {
        aty.startActivity(it);
    }

    /**
     * Activity跳转
     */
    public void showActivity(Activity aty, Class<?> cls, Bundle extras) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        intent.setClass(aty, cls);
        aty.startActivity(intent);
    }
}
