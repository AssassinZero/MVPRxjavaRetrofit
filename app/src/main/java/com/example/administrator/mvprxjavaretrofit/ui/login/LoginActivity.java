package com.example.administrator.mvprxjavaretrofit.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.mvprxjavaretrofit.R;
import com.example.administrator.mvprxjavaretrofit.base.BaseActivity;
import com.example.administrator.mvprxjavaretrofit.bean.UserInfo;
import com.example.administrator.mvprxjavaretrofit.ui.ip.QueryIPActivity;
import com.example.administrator.mvprxjavaretrofit.ui.register.RegisterActivity;
import com.example.administrator.mvprxjavaretrofit.utils.ToastUtils;
import com.example.administrator.mvprxjavaretrofit.widget.ClearEditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity  extends BaseActivity implements LoginContract.ILoginView  {

    @InjectView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.et_login_userName)
    ClearEditText etLoginUserName;
    @InjectView(R.id.et_login_pwd)
    ClearEditText etLoginPwd;
    @InjectView(R.id.btn_login)
    Button btnLogin;
    @InjectView(R.id.pb_progress)
    ProgressBar pbProgress;
    private LoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        tvTitle.setText("用户登录");
        mLoginPresenter = new LoginPresenter(this);
    }
    @Override
    public Context getCurContext() {
        return mActivity;
    }

    @Override
    public void showProgress() {
        pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void showInfo(String info) {
        ToastUtils.showToast(mActivity, info);
    }

    @Override
    public void showErrorMsg(String msg) {
        ToastUtils.showToast(mActivity, msg);
    }

    @Override
    public void toMain() {
        startActivity(new Intent(mActivity, QueryIPActivity.class));
    }

    @Override
    public void toRegister() {
        startActivity(new Intent(mActivity, RegisterActivity.class));
    }

    @Override
    public UserInfo getUserLoginInfo() {
        return new UserInfo(etLoginUserName.getText().toString().trim(), etLoginPwd.getText().toString().trim());
    }


    public void onRegister(View view) {
        toRegister();
    }

    @OnClick({R.id.iv_title_back, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_back:
                finish();
                break;
            case R.id.btn_login:
                mLoginPresenter.login();
                break;
        }
    }
}
