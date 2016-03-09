package com.weileng.self.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.weileng.self.R;
import com.weileng.self.constant.MkUrl;
import com.weileng.self.net.AsyncHttpResponseCallback;
import com.weileng.self.net.BaseNetEntity;
import com.weileng.self.net.bean.request.LoginReqBean;
import com.weileng.self.net.bean.response.LoginGetBeanData;
import com.weileng.self.utils.ConnectUtils;
import com.weileng.self.utils.EncodeUtil;

/**
 * Created by lt on 2016/3/9.
 */
public class LoginActivity extends BaseActivity {
    private EditText mUserEd, mPwdEd;
    private Button mBtnLogin;

    private String cName = "";
    private String cPwd = "";

    @Override
    public void initParameter() {
        setContentView(R.layout.login_activity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_ok:
                if (!checkIsNull(mUserEd, mPwdEd)) {
                    return;
                } else {
                    // 登录
                    LoginStart();
                }
                break;
        }
    }


    public void initView() {
        mUserEd = (EditText) findViewById(R.id.ed_login_uname);
        mPwdEd = (EditText) findViewById(R.id.ed_login_pwd);
        mBtnLogin = (Button) findViewById(R.id.btn_login_ok);

        mUserEd.setText("13828821554");
        mPwdEd.setText("111111");

        setOnClick(mBtnLogin);
    }

    /**
     * 检查是否为空
     *
     * @param mUser
     * @param mPwd
     * @return
     */
    private boolean checkIsNull(EditText mUser, EditText mPwd) {
        cName = mUser.getText().toString().trim();
        cPwd = mPwd.getText().toString().trim();
        if (cName.equals("")) {
            showToast("请输入手机号码");
            return false;
        } else if (cPwd.equals("")) {
            showToast("请输入密码");
            return false;
        } else if (cName.length() < 11 || cName.length() > 11) {
            showToast("手机号码长度不对");
            return false;
        }
        return true;
    }

    /**
     * 登录
     */
    public void LoginStart() {
        // 网络异常提示
        if (!ConnectUtils.isNetworkConnected(this)) {
            Toast.makeText(this, R.string.network_isnot_available,
                    Toast.LENGTH_SHORT).show();
            return;
        }

        LoginReqBean sendData = new LoginReqBean();
        sendData.Pwd = EncodeUtil.encode(cPwd);
        sendData.UserName = cName;

        BaseNetEntity baseNetEntity = new BaseNetEntity();
        baseNetEntity.sendPostJson(LoginActivity.this, "正在登录中...", true, new AsyncHttpResponseCallback<LoginGetBeanData
                >(LoginGetBeanData.class) {
            @Override
            public void onSuccess(LoginGetBeanData bean) {
                String resultCode = bean.getResultCode();
                String resultDesc = bean.getResultDesc();

                if ("0000".equals(resultCode)) {
                    skipActivity(LoginActivity.this, MainActivity.class);
                    showToast("登录成功!");
                }
            }
        }, sendData, MkUrl.USER_LOGIN, null);

    }

}
