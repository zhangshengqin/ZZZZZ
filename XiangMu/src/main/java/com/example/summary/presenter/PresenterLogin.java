package com.example.summary.presenter;

import android.util.Log;

import com.example.summary.bean.LoginBean;
import com.example.summary.model.IModel;
import com.example.summary.model.ModelLogin;
import com.example.summary.view.IView;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by z on 2018/1/11.
 */

public class PresenterLogin implements IPresenter{
    private IView iView;

    private DisposableSubscriber<LoginBean> subscriber;

    public PresenterLogin(IView iView) {
        this.iView = iView;

    }
    public void delethView(){
        if(iView!=null){
            iView=null;
        }
        if(subscriber!=null){
            subscriber=null;
        }
    }

    @Override
    public void getData(String baseUrl, Map<String, String> map) {
        IModel model=new ModelLogin(this);
        model.getData(baseUrl,map);
    }
    public void getNews(Flowable<LoginBean> flowable){
            subscriber=flowable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSubscriber<LoginBean>() {
                        @Override
                        public void onNext(LoginBean loginBean) {
                            Log.i("P层登陆",loginBean.toString());
                            iView.Success(loginBean);
                        }

                        @Override
                        public void onError(Throwable t) {
                            iView.Failed(t);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }

}
