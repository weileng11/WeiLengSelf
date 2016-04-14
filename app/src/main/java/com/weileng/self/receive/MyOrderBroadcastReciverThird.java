package com.weileng.self.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyOrderBroadcastReciverThird extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String resultData = getResultData();//获取two中setResultData中的数据
		Bundle bundle = getResultExtras(true);//获取two中setResultExtras中的数据
		String bundleData = bundle.getString("msg", "");//获取two中setResultExtras()中的数据
		
		String strMsg = intent.getStringExtra("msg");//获取广播的原始数据
		Log.e("INFO", "第三个:"+strMsg);
		
		Log.e("INFO", "two中传到third新的数据："+resultData);
		Log.e("INFO", "two中setResultExtras(extras)传到third新的数据："+bundleData);
	}

}
