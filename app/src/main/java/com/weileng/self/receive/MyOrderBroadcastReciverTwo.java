package com.weileng.self.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyOrderBroadcastReciverTwo extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
//		abortBroadcast();//开启此处，可以截断广播,不让它传到third中
		String strMsg = intent.getStringExtra("msg"); //获取广播的原始数据
		
		
		Log.e("INFO", "第二个:"+strMsg);
		Bundle extras=new Bundle();
		extras.putString("msg", "第二个界面传过来的"+strMsg);
		setResultExtras(extras); //继续向下川
		
		setResultData("第二个:"+strMsg); // "第二个:"+strMsg这是two中新的数据，传递到third中,在third中是用getResultData来获得setResultData("")中的数据
	}

}
