package com.weileng.self.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.weileng.self.R;

/**
 * 正在加载中dialog
 * 
 * @author qiwenming
 * 
 */
public class LoadingDialog extends Dialog {

	private Context context;
	private static LoadingDialog lodingDialog;

	public LoadingDialog(Context context) {
		super(context);
		this.context = context;
	}

	public LoadingDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		this.context = context;
	}

	public LoadingDialog(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (lodingDialog == null) {
			return;
		}

		ImageView imageView = (ImageView) lodingDialog
				.findViewById(R.id.loadingImageView);
		AnimationDrawable animationDrawable = (AnimationDrawable) imageView
				.getBackground();
		animationDrawable.start();//开始动画
	}

	/**
	 * 创建dialog
	 * 
	 * @param context
	 * @return
	 */
	public static LoadingDialog createDialog(Context context) {
		lodingDialog = new LoadingDialog(context, R.style.MyDialog_two);
		lodingDialog.setContentView(R.layout.loading_dialog_layout);
		lodingDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
		lodingDialog.setCancelable(false);
		return lodingDialog;
	}

	/**
	 * 设置消息 内容
	 * 
	 * @param strMessage
	 */
	public void setMessage(String strMessage) {
		TextView tvMsg = (TextView) lodingDialog
				.findViewById(R.id.id_tv_loadingmsg);

		if (tvMsg != null) {
			tvMsg.setText(strMessage);
		}

	}
}
