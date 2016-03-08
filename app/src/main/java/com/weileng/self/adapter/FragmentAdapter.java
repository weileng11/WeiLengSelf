package com.weileng.self.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.weileng.self.activity.MainActivity;
import com.weileng.self.fragment.BuyFragment;
import com.weileng.self.fragment.CarFragment;
import com.weileng.self.fragment.CategoryFragment;
import com.weileng.self.fragment.HomeFragment;
import com.weileng.self.fragment.MoreFragment;

public class FragmentAdapter extends FragmentPagerAdapter{
	public final static int TAB_COUNT = 5;
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int id) {
		switch (id) {
		case MainActivity.TAB_HOME:
			HomeFragment homeFragment = new HomeFragment();
			return homeFragment;
		case MainActivity.TAB_CATAGORY:
			CategoryFragment categoryFragment = new CategoryFragment();
			return categoryFragment;
		case MainActivity.TAB_CAR:
			CarFragment carFragment = new CarFragment();
			return carFragment;
		case MainActivity.TAB_BUY:
			BuyFragment buyFragment = new BuyFragment();
			return buyFragment;
		case MainActivity.TAB_MORE:
			MoreFragment moreFragment = new MoreFragment();
			return moreFragment;
		}
		return null;
	}

	@Override
	public int getCount() {
		return TAB_COUNT;
	}
}
