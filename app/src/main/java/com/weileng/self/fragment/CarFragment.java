package com.weileng.self.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weileng.self.R;
import com.weileng.self.widget.TopBarLayout;

public class CarFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		System.out.println("CarFragment");
		View mView= inflater.inflate(R.layout.main_car, container, false);
		TopBarLayout mTbContent = (TopBarLayout)mView.findViewById(R.id.topbar);
		mTbContent.setTitle("CarFragment");
		mTbContent.setleftBackViewTypeMode();

		return mView;
	}
}
