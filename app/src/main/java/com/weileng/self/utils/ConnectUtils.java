package com.weileng.self.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

/**
 * 
 * 网络连接类
 * 
 * 
 */
public class ConnectUtils {
	public static final String TAG = "ConnectUtil";
	/**
	 * 
	 * @return 网络是否连接
	 */
	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) {
		} else {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}
    /**
     * 
     * @param context
     * @return 是否wifi连接
     */
	public static boolean isWifiConnected(Context context) {
		return getNetworkState(context, ConnectivityManager.TYPE_WIFI) == State.CONNECTED;
	}

	public static boolean isMobileConnected(Context context) {
		return getNetworkState(context, ConnectivityManager.TYPE_MOBILE) == State.CONNECTED;
	}

	private static State getNetworkState(Context context, int networkType) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getNetworkInfo(networkType);

		return info == null ? null : info.getState();
	}

	

}
