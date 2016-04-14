package com.weileng.self.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyOrderBroadcastReciver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String strMsg = intent.getStringExtra("msg");
		Log.e("INFO", "第一个:"+strMsg);
		Bundle extras=new Bundle();
		extras.putString("msg", "第一个界面传过来的"+strMsg);
		setResultExtras(extras); //继续向下川
		
	}
	
}
