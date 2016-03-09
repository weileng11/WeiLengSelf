package com.weileng.self.net;

import android.os.Handler;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.weileng.self.R;
import com.weileng.self.WlApplication;
import com.weileng.self.dialog.LoadingDialog;
import com.weileng.self.net.bean.AppContext;
import com.weileng.self.net.bean.response.BaseNetBean;
import com.weileng.self.utils.ConnectUtils;

import org.json.JSONObject;

public abstract class AsyncHttpResponseCallback<T> implements Listener
{
	private Class<T> beanClass;
//	protected ProgressDialog pd;
	protected LoadingDialog ld;
    private boolean isShowErr = true;//用于标记 如果是401错误 那么就不弹出 “请求服务器失败”
    protected Handler delayShowHandler;
	
	public Handler getDelayShowHandler() {
		return delayShowHandler;
	}

	public void setDelayShowHandler(Handler delayShowHandler) {
		this.delayShowHandler = delayShowHandler;
	}
	
	public AsyncHttpResponseCallback(Class<T> beanClass) {
		this.beanClass = beanClass;
	}
	
/*	public void setProgressDialog(ProgressDialog pd){
		this.pd = pd;
	}
	
	public ProgressDialog getProgressDialog(){
		return this.pd;
	}*/
	
	public void setLoadingDialog(LoadingDialog ld){
		this.ld = ld;
	}
	
	public LoadingDialog getLoadingDialog(){
		return this.ld;
	}

	@Override
	public void onResponse(Object responseObj) {
		//Log.i("AsyncHttpResponseCallback_onResponse", responseObj.toString());
		//接收到服务端应答，则发送消息让加载框消失
		if(delayShowHandler != 	null){
			delayShowHandler.removeMessages(BaseNetEntity.SHOW_DIALOG_MSG);
		}
		
		if(ld != null && ld.isShowing()){
			ld.dismiss();
		}	
	
		if(responseObj instanceof JSONObject){
			JSONObject jo = (JSONObject)responseObj;
			String joStr = jo.toString();
			Gson gson = new Gson();
			T bean = gson.fromJson(joStr, beanClass); 
			if(bean instanceof BaseNetBean){
				BaseNetBean bnBean = (BaseNetBean)bean;
				if(!"0000".equals(bnBean.getResultCode())){
					if("8000".equals(bnBean.getResultCode())){
						//短信余额不足
						Toast.makeText(WlApplication.applicationContext, bnBean.getResultDesc(), Toast.LENGTH_LONG).show();
					}else{
						String failDesc = bnBean.getResultDesc();
						onResponeFailure(failDesc);
						return;
					}
					
				}
			}
			onSuccess(bean);
		}
	}

	public static final String ErrStr_401="authentication";
	public class MyErrorListener implements ErrorListener{
		@Override
		public void onErrorResponse(VolleyError arg0) {		
			//网络错误，则发送消息让加载框消失
			if(delayShowHandler != 	null){
				delayShowHandler.removeMessages(BaseNetEntity.SHOW_DIALOG_MSG);
			}
			
			if(ld != null && ld.isShowing()){ 
			  ld.dismiss();
		    }
			isShowErr = true;
			//如果是 返回的 networkResponse为null，或者是401，那么重新登录  
			NetworkResponse network = arg0.networkResponse;
			String message = arg0.getMessage();
			//Log.d("NetworkResponseMessage", null);
			if( null!= AppContext.activityContext)
				//把message 转为小写在比较
				if( (null!=message && null==network && message.toLowerCase().contains(ErrStr_401) ) || (null!=network && 401==network.statusCode)  ){
	//				Toast.makeText(MsApplication.applicationContext, "此账号已在别处登录，重新登录", 0).show();
	//				AppRestartUtil.restartMyApp();
//					if(MsApplication.isNeedLogin){
//						MsApplication.isNeedLogin = false;
//						AppRestartUtil.autoLogin();
//					}else{
					//异地登录
//						ToReloginDialog dialog = new ToReloginDialog(AppContext.activityContext, R.style.MyDialog);
//						dialog.show();
				//	}
					isShowErr = false;
	 			   // return;
				}
			
			onFailure(arg0);
		}
	}

	public abstract void onSuccess(T bean);

	/**
	 * 接口应答非正常情况返回，返回码不等于“0000”
	 */
	public void onResponeFailure(String failDesc){
		if(!"未找到数据".equals(failDesc))
		 Toast.makeText(WlApplication.applicationContext, failDesc, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 网络异常或服务器异常
	 */
	public void onFailure(Throwable error) {
//		super.onFailure(error);
		if(isShowErr){//不是401错误 那么就弹出 “请求服务器失败”
			if (!ConnectUtils.isNetworkConnected(WlApplication.applicationContext)) {
				Toast.makeText(WlApplication.applicationContext, R.string.network_isnot_available, Toast.LENGTH_SHORT).show();
				return;
			}else{
				Toast.makeText(WlApplication.applicationContext, "请求服务器失败", Toast.LENGTH_LONG).show();
				System.out.println("####### onFailure=" + error);
			}
		}
	}

}
