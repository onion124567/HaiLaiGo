package com.haitago.business.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.haitago.R;
import com.haitago.business.baseandcommon.BaseActivity;
import com.haitago.utils.DialogManager;
import com.haitago.utils.InputNullException;
import com.haitago.utils.PreferencesHelper;
import com.haitago.utils.StrUtils;

/**
 * Created by onion on 2017/3/8.
 */
public class LoginActivity extends BaseActivity {
    TextView btn_login;
    EditText et_pwd, edit_name;
    ImageView img_clean_name, img_clean_pwd;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        edit_name = (EditText) findViewById(R.id.edit_name);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        img_clean_name = (ImageView) findViewById(R.id.img_clean_name);
        img_clean_pwd = (ImageView) findViewById(R.id.img_clean_pwd);
        img_clean_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_pwd.getText().clear();
            }
        });
        img_clean_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_name.getText().clear();
            }
        });
        et_pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    img_clean_pwd.setVisibility(View.VISIBLE);
                else
                    img_clean_pwd.setVisibility(View.GONE);
            }
        });
        edit_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    img_clean_name.setVisibility(View.VISIBLE);
                else
                    img_clean_name.setVisibility(View.GONE);
            }
        });
        btn_login = (TextView) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                loginAction();
            }
        });



        setEdit_name();
    }


    private void loginAction() {
        String name, pwd;
        try {
            name = StrUtils.checkEditString(edit_name, "用户名不能为空");
            pwd = StrUtils.checkEditString(et_pwd, "密码不能为空");
            DialogManager.showNetLoadingView(this);
//            getPresenter().login(name, StrUtils.string2md5(pwd));
        } catch (InputNullException e) {
            e.printStackTrace();
            showToast(e.getMessage());
        }
    }

    public void loginSuccess() {
        DialogManager.dismissNetLoadingView();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

//    public void todoCompleteUserInfo(Intent intent) {
//        DialogManager.dismissNetLoadingView();
//        startActivityForResult(intent, Config.START);
//    }

    private void setEdit_name() {
        userName = PreferencesHelper.getInstance().getUserLoginName();
        if (userName != null) {
            edit_name.setText("" + userName);
        }
    }

}
