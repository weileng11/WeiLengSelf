package com.weileng.self.net.bean.response;

import java.io.Serializable;

public class BaseNetBean implements Serializable {
	private String ResultCode;
	private String ResultDesc;
	
	public String getResultCode() {
		return ResultCode;
	}
	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}
	public String getResultDesc() {
		return ResultDesc;
	}
	public void setResultDesc(String resultDesc) {
		ResultDesc = resultDesc;
	}

}
