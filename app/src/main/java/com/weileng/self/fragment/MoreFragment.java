package com.weileng.self.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weileng.self.R;
import com.weileng.self.widget.TopBarLayout;

public class MoreFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		System.out.println("MoreFragment");
		View mView= inflater.inflate(R.layout.main_more, container, false);
		TopBarLayout mTbContent = (TopBarLayout)mView.findViewById(R.id.topbar);
		mTbContent.setTitle("更多");
		mTbContent.setleftBackViewTypeMode();
		return mView;
	}
}
