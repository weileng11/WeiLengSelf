package com.weileng.self.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weileng.self.R;

/**
 *
 * @MkTopBarLayout的用法
 * 其中1-2步骤必须， 其他的步骤是右边的按钮操作</br>
 *  1.在布局文件中加入这个控件 </br>
 *     </br>
         android:id="@+id/topbar"  </br>
         android:layout_width="match_parent"  </br>
         android:layout_height="wrap_content" /> </br>
    2.在activity中初始化 （例如：） </br>
        MkTopBarLayout topBarLayout = (MkTopBarLayout) findViewById(R.id.topbar);  </br>
		topBarLayout.setTitle("商品销售");//设置标题  </br></br>
		
	------------------右边按钮相关操作---------------------------------	 </br>
	3.如果要出现右边的按钮和设置它的模式可以使用  </br>
	   topBarLayout.setRigthViewTypeMode(mode); </br>
	4.设置右边按钮文字可以使用 </br>
	   topBarLayout.setRightViewText(text); </br>
	5.如果是设置右边按钮者监听，那么可以使用  </br>
	  topBarLayout.setRightTxvOnClickListener(listener); </br>
	6.如果想要对右边按钮做更多的操作，可以获取右边按钮后，自己设置 </br>
	  topBarLayout.getRightView(); </br>
 */
public class TopBarLayout extends LinearLayout {
	private TextView titleView;
	private TextView rightView;
	private ImageButton rightIm;
	private View view;
	private LinearLayout llback;
	private ImageView backView;
	
	//右边图标
	private LinearLayout llRight;
	private static Context mcontext;
	
//	private rightListenter mListenter;

	public TopBarLayout(Context context) {
		super(context);
//		this.mListenter=listenter;
	}
	
	public TopBarLayout(final Context context, AttributeSet attrs) {
		super(context,attrs);
		 mcontext=context;
		 LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	     view = inflater.inflate(R.layout.mk_topbar_layout, this);
	     view.setBackgroundColor(getResources().getColor(R.color.title_bg_blue_44b5f5));
	     //view.setBackgroundResource(R.color.title_bg_blue);
	     llback=(LinearLayout)findViewById(R.id.ll_back);
	     backView=(ImageView)findViewById(R.id.back_img);
	     llRight=(LinearLayout)findViewById(R.id.ll_right);
	     
	     setLeftTxvOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(context instanceof Activity){
					((Activity)context).finish();
				}
			}
		});
	     rightView = ((TextView)view.findViewById(R.id.txt_right));
	     titleView = ((TextView)view.findViewById(R.id.txv_title));
	     rightIm=(ImageButton)view.findViewById(R.id.scan_right);
	}
	
	
	/**
	 * 设置右边按钮的监听
	 * @param onClickListener
	 */
	public void setRightLLOnClickListener(OnClickListener onClickListener){
		llRight.setOnClickListener(onClickListener);
	}
	
	/**
	 * 设置右边图标布局显示
	 * 
	 */
	public void setRightLLVisibility(){
		llRight.setVisibility(View.VISIBLE);
	}
	
	private RightViewTypeMode nowMode;
	
	/**
	 * 隐藏左边返回键+图标
	 * @param
	 */
	public void setleftViewTypeMode(){
		llback.setVisibility(View.GONE);
	}
	
	/**
	 * 隐藏返回键+图标
	 * @param
	 */
	public void setleftBackViewTypeMode(){
		backView.setVisibility(View.GONE);
	}
	
	/**
	 * 设置右边按钮的 模式
	 * TEXT 文本
	 * SCAN 扫描图标
	 * ADD  添加图标
	 * @param mode
	 */
	public void setRigthViewTypeMode(RightViewTypeMode mode){
		nowMode=mode;
		if(RightViewTypeMode.TEXT==mode){//文本
			rightView.setVisibility(View.VISIBLE);
			rightView.setBackgroundColor(Color.TRANSPARENT);
		}else if(RightViewTypeMode.SCAN==mode){//扫描
			rightIm.setVisibility(View.VISIBLE);
		}else if(RightViewTypeMode.ADD==mode){//添加
			rightIm.setVisibility(View.VISIBLE);
//			rightIm.setImageResource(R.drawable.mk_topbar_add);
		}
	}
	
	/**
	 * 设置右边按钮的文字
	 * @param text
	 */
	public void setRightViewText(CharSequence text){
		rightView.setVisibility(View.VISIBLE);
		rightView.setText(text);
	}
	
	/**
	 * 设置右边图标
	 * @param
	 */
	public void setRightViewIcon(int rightIcon){
		rightIm.setVisibility(View.VISIBLE);
		rightIm.setBackgroundResource(rightIcon);
	}

	/**
	 * 获得标题控件
	 * @return
	 */
	public TextView getTitleView() {
		return titleView;
	}

	/**
	 * 设置标题
	 * @param text
	 */
	public void setTitle(CharSequence text){
		titleView.setText(text);
	}
	
	public void setTitle(int resId){
		titleView.setText(resId);
	}
	
	/**
	 * 设置左边键按钮的监听
	 * @param onClickListener
	 */
	public void setLeftTxvOnClickListener(OnClickListener onClickListener){
		llback.setOnClickListener(onClickListener);
	}
	
	/**
	 * 设置右边按钮的监听
	 * @param onClickListener
	 */
	public void setRightTxvOnClickListener(OnClickListener onClickListener){
		if(nowMode==RightViewTypeMode.TEXT){
			rightView.setOnClickListener(onClickListener);
		}else{
			rightIm.setOnClickListener(onClickListener);
		}
	}

	
	/**
	 * 设置背景颜色
	 * @param alpha
	 * @param red
	 * @param green
	 * @param blue
	 */
	public void setBackgroundTransparence(int alpha, int red, int green, int blue)
	{
		view.setBackgroundColor(Color.argb( alpha,  red,  green,  blue));
	}
	
	/**
	 * @author qiwenming 
	 * @date 2015-9-29 下午1:23:01 
	 * @ClassName: RightViewTypeMode 
	 * @Description: 右边按钮的模式
	 */
	public enum RightViewTypeMode{
		/**
		 * 扫描
		 */
		SCAN,
		/**
		 * 文本
		 */
		TEXT,
		/**
		 * 添加
		 */
		ADD
	}
}
