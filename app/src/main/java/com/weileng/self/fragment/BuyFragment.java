package com.weileng.self.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weileng.self.R;
import com.weileng.self.widget.TopBarLayout;

public class BuyFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("BuyFragment");
		View mView= inflater.inflate(R.layout.main_buy, container, false);
		TopBarLayout mTbContent = (TopBarLayout)mView.findViewById(R.id.topbar);
		mTbContent.setTitle("买萌");
		mTbContent.setleftBackViewTypeMode();

		return mView;
	}
}
