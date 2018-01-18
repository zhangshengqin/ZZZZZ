package text.bwei.com.yuekao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.yuekao.goods.adapter.view.GoodsActivity;
import text.bwei.com.yuekao.mine.LoginConstract;
import text.bwei.com.yuekao.mine.bean.LoginBean;
import text.bwei.com.yuekao.mine.presenter.LoginPresenter;
import text.bwei.com.yuekao.mine.view.SignUpActivity;
import text.bwei.com.yuekao.utils.Api;
import text.bwei.com.yuekao.utils.Toasts;

public class MainActivity extends AppCompatActivity implements LoginConstract.ILoginView {

    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.login_user)
    EditText loginUser;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_tv_Sign_up)
    TextView loginTvSignUp;
    @BindView(R.id.login_tv_retrieve_password)
    TextView loginTvRetrievePassword;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
    }

    @OnClick({R.id.login_back, R.id.login_btn, R.id.login_tv_Sign_up, R.id.login_tv_retrieve_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.login_btn:
                String mobile = loginUser.getText().toString().trim();
                String pwd = loginPwd.getText().toString().trim();
                loginPresenter.onSignUp(Api.UserURL, mobile, pwd);
                break;
            case R.id.login_tv_Sign_up:
                Intent in = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(in);
                break;
            case R.id.login_tv_retrieve_password:
                break;
        }
    }

    @Override
    public void showLogin(LoginBean.DataBean db) {
        SharedPreferences sp = getSharedPreferences("USER", MODE_PRIVATE);
        sp.edit().putInt("uid", db.getUid())
                .putString("name", db.getUsername())
                .putString("pwd", db.getPassword())
                .commit();
        Toasts.showLong(this, "登录成功");
        Intent intent = new Intent(this, GoodsActivity.class);
        Log.d("---","uid=" + db.getUid());
        intent.putExtra("uid",db.getUid());
        startActivity(intent);
//        finish();
    }

    @Override
    public void showerroe(String e) {
        Toasts.showLong(this, e);
    }

}