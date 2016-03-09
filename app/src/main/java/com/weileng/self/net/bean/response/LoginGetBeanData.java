package com.weileng.self.net.bean.response;

import java.io.Serializable;

public class LoginGetBeanData extends BaseNetBean {

	public int Count;
	public Items Item;
	public int TimeStamp;

	public Items getItem() {
		return Item;
	}

	public void setItem(Items item) {
		Item = item;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public int getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(int timeStamp) {
		TimeStamp = timeStamp;
	}

	public class Items implements Serializable {
		private String Token;
		private boolean IsAdmin;
		public String StoreNo;
		public boolean IsSetStore;// 是否设置过店铺信息

		public String getToken() {
			return Token;
		}

		public void setToken(String token) {
			Token = token;
		}

		public boolean isIsAdmin() {
			return IsAdmin;
		}

		public void setIsAdmin(boolean isAdmin) {
			IsAdmin = isAdmin;
		}
	}
}
