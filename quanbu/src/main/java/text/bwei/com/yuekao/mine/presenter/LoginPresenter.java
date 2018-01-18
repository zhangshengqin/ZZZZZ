package text.bwei.com.yuekao.mine.presenter;


import text.bwei.com.yuekao.mine.LoginConstract;
import text.bwei.com.yuekao.mine.bean.LoginBean;
import text.bwei.com.yuekao.mine.model.LoginModel;

public class LoginPresenter implements LoginConstract.ILoginPresenter {
    LoginConstract.ILoginView iLoginView;
    LoginConstract.ILoginModel iLoginModel;

    public LoginPresenter(LoginConstract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iLoginModel = new LoginModel();
    }

    @Override
    public void onSignUp(String url, String mobile, String password) {
        iLoginModel.RequestData(url, mobile, password, new LoginConstract.OnRequestListener() {
            @Override
            public void OnSuccess(LoginBean.DataBean db) {
                iLoginView.showLogin(db);
            }

            @Override
            public void OnError(String e) {
                iLoginView.showerroe(e);
            }
        });
    }
}