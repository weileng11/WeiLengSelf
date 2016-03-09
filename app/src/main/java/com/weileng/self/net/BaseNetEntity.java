package com.weileng.self.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.weileng.self.WlApplication;
import com.weileng.self.dialog.LoadingDialog;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BaseNetEntity {
	public Context context = WlApplication.applicationContext;
	public AsyncHttpResponseCallback hanlder;
	public static final int SHOW_DIALOG_MSG = 1;
	
	public void send(String ...params){}

	public void send(){}
	// 请求头
/*	protected Header[] headers = getHeader();

	public Header[] getHeader() {
		Header[] headers = new Header[2];
		SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		String token = defaultSharedPreferences.getString("token", ""); 
		headers[0] = new BasicHeader("Token", token);
		headers[1] = new BasicHeader("Content-Type", "multipart/form-data;application/json; charset=utf-8");
		return headers;
	}*/
	
	public <T> String getSendData(T beanClass) {
		if(beanClass==null){
			return "";
		}
		T bean = beanClass;
		Gson gson = new Gson();
		String str = gson.toJson(bean);
		System.err.println("########"+str);
		return str;
	}
	
	private boolean isReConnect = false;
	/**
	 * @param context 
	 * @param Message 提示框显示内容
	 * @param isShowDialog 是否显示提示框
	 * @param hanlder 结果回调
	 * @param beanClass 请求实体类
	 * @param url 请求url
	 * @param isReConnect 是否重连
	 */
	public <T> void sendPostJson(final Context context, final String Message, boolean isShowDialog, final AsyncHttpResponseCallback hanlder,
			T beanClass, String url,boolean isReConnect,String tag){
		this.isReConnect = isReConnect;
		sendPostJson(context,Message, isShowDialog,hanlder, beanClass,url,tag);
	}
	
	/**
	 * @param context 
	 * @param Message 提示框显示内容
	 * @param isShowDialog 是否显示提示框
	 * @param hanlder 结果回调
	 * @param beanClass 请求实体类
	 * @param url 请求url
	 * 发送post请求的方法
	 */
	public <T> void sendPostJson(final Context context, final String Message, boolean isShowDialog, final AsyncHttpResponseCallback hanlder,
			T beanClass, String url,final String tag){
		String jsonString = getSendData(beanClass); 
        try {
        	if(isShowDialog){
        		LoadingDialog ld = LoadingDialog.createDialog(context);
        		hanlder.setLoadingDialog(ld);
				ld.setCanceledOnTouchOutside(false);
	        	if(Message == null){
	        		ld.setMessage("正在加载数据");
	        	}else{
	        		ld.setMessage(Message);
	        	}
	        	ld.show();
//	        	
//	        	ld.setOnDismissListener(new OnDismissListener() {
//					
//					@Override
//					public void onDismiss(DialogInterface dialog) {
//						if(tag!=null){
//							cancleRequest(tag);
//						}
//						
//					}
//				});
        	}
        	
        	RequestQueue mQueue = Volley.newRequestQueue(context);  
        	 Request request=new MyJsonObjectRequest(Method.POST, url, new JSONObject(jsonString),  
        			hanlder, hanlder.new MyErrorListener());
        	 if(tag!=null){
         		request.setTag(tag);
         	}
        	 mQueue.add(request);  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param context 
	 * @param Message 提示框显示内容
	 * @param isShowDialog 是否显示提示框
	 * @param hanlder 结果回调
	 * @param （参数需跟在url后，则此参数为空）
	 * @param url 请求url
	 * 发送get请求的方法
	 */
	public void sendGetParams(final Context context, final String Message, boolean isShowDialog, final AsyncHttpResponseCallback hanlder,
			Object beanObj, String url,final String tag){
		if(isShowDialog){
    		LoadingDialog ld = LoadingDialog.createDialog(context);
    		hanlder.setLoadingDialog(ld);
			ld.setCancelable(false);
        	if(Message == null){
        		ld.setMessage("正在加载数据");
        	}else{
        		ld.setMessage(Message);
        	}
        	ld.show();
        	
//        	ld.setOnDismissListener(new OnDismissListener() {
//				
//				@Override
//				public void onDismiss(DialogInterface dialog) {
//					if(tag!=null){
//						cancleRequest(tag);
//					}
//					
//				}
//			});
    	}
    	
        	RequestQueue mQueue = Volley.newRequestQueue(context);  
        	Request	request=new MyJsonObjectRequest(Method.GET, url, null,  
        			hanlder, hanlder.new MyErrorListener());
        	if(tag!=null){
        		request.setTag(tag);
        	}
        	mQueue.add(request);  
	}
	
	private class MyJsonObjectRequest extends JsonObjectRequest{
		int SOCKET_TIMEOUT = 5000;
		public MyJsonObjectRequest(int method, String url, JSONObject jsonRequest, Listener<JSONObject> listener, ErrorListener errorListener){
			super(method, url, jsonRequest, listener, errorListener);
			if(isReConnect){
				setRetryPolicy(new DefaultRetryPolicy(5000, 0, 1.0f));
			}else{
				setRetryPolicy(new DefaultRetryPolicy(SOCKET_TIMEOUT, 3, 2.0f));
			}
		}
		
		@Override
		public Map<String, String> getHeaders() throws AuthFailureError {
			// TODO Auto-generated method stub
			Map headers = new HashMap();
			SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
			String token = defaultSharedPreferences.getString("token", ""); 
			headers.put("Token", token);
			headers.put("Content-Type", "application/json; charset=utf-8");
			return headers;
		}
		
	/*	@Override
		public RetryPolicy getRetryPolicy() {
			// TODO Auto-generated method stub
			RetryPolicy retryPolicy = new DefaultRetryPolicy(SOCKET_TIMEOUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);  
			return retryPolicy;  
		}*/
		
		@Override
		public byte[] getBody() {
			return super.getBody();
		}
	}
	
	public static void cancleRequest(String tag){
		if(tag==null){
			return;
		}
		Volley.newRequestQueue(WlApplication.applicationContext).cancelAll(tag);
	}
}
