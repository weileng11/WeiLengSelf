package com.weileng.self.activity;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.weileng.self.R;
import com.weileng.self.adapter.CommonAdapter;
import com.weileng.self.adapter.ViewHolder;
import com.weileng.self.db.BaseDao;
import com.weileng.self.db.bean.WeilengBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lt on 2016/3/9.
 */
public class DbWlActivity extends BaseActivity {
    private Button mInsertBtn, mDeleteBtn, mUpdateBtn;
    private ListView mLv;

    private List<WeilengBean> dataList = new ArrayList<WeilengBean>();

    private BaseAdapter mAdapter;
    @Override
    public void initParameter() {
        setContentView(R.layout.db_activity);
    }
    @Override
    public void initView() {
        mInsertBtn = (Button) findViewById(R.id.btn_insert);
        mDeleteBtn = (Button) findViewById(R.id.btn_delete);
        mUpdateBtn = (Button) findViewById(R.id.btn_update);
        mLv = (ListView) findViewById(R.id.lv);
        setOnClick(mInsertBtn, mDeleteBtn, mUpdateBtn);

        //初始化适配器
        mAdapter = new CommonAdapter<WeilengBean>(DbWlActivity.this, dataList,
                R.layout.db_item) {
            @Override
            public void convert(ViewHolder helper, WeilengBean item) {
                   helper.setText(R.id.txv_name,item.mUserName);
                   helper.setText(R.id.txv_age,String.valueOf(item.mAge));
            }
        };
        mLv.setAdapter(mAdapter);
    }

    private  int id=1;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_insert:
                dbToInsertData(id);
                break;
            case R.id.btn_delete:
                deleteData();
                break;
            case R.id.btn_update:
                updateData();
                break;

        }
    }

    public void updateData(){
        BaseDao<WeilengBean>  baseDao=getDao(WeilengBean.class);
        dataList.get(3).mUserName="加油55555555555";
        try{
            baseDao.update(dataList.get(3));
            mAdapter.notifyDataSetChanged();
//            if(dataList.size()>0&&dataList!=null){
//                dataList.clear();
//            }
//            //查询数据
//            List<WeilengBean>  queryList= baseDao.queryAll();
//            if(queryList.size()>0&&queryList!=null){
//                dataList.addAll(queryList);
//                mAdapter.notifyDataSetChanged();
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteData(){
        BaseDao<WeilengBean>  baseDao=getDao(WeilengBean.class);
        try{
            baseDao.deleteById("Id","2");
            if(dataList.size()>0&&dataList!=null){
                dataList.clear();
            }
            //查询数据
            List<WeilengBean>  queryList= baseDao.queryAll();
            if(queryList.size()>0&&queryList!=null){
                dataList.addAll(queryList);
                mAdapter.notifyDataSetChanged();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

   public void dbToInsertData(int mid){
       WeilengBean mBean=new WeilengBean();
       mBean.Id=mid;
       mBean.mUserName="weileng"+mid;
       mBean.mAge=19+mid;
       BaseDao<WeilengBean>  baseDao=getDao(WeilengBean.class);
       try{
          baseDao.save(mBean);
           id++;
           if(dataList.size()>0&&dataList!=null){
               dataList.clear();
           }
          //查询数据
         List<WeilengBean>  queryList= baseDao.queryAll();
         if(queryList.size()>0&&queryList!=null){
             dataList.addAll(queryList);
             mAdapter.notifyDataSetChanged();
         }
       }catch (Exception e){
           e.printStackTrace();
       }
   }


}
