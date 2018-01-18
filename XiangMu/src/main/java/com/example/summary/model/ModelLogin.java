package com.example.summary.model;

import com.example.summary.bean.LoginBean;
import com.example.summary.presenter.PresenterLogin;
import com.example.summary.retrofit.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by z on 2018/1/11.
 */

public class ModelLogin implements IModel{
    private PresenterLogin presenterLogin;

    public ModelLogin(PresenterLogin presenterLogin) {
        this.presenterLogin = presenterLogin;
    }

    @Override
    public void getData(String basrUrl, Map<String, String> map) {
        Flowable<LoginBean> flowable = RetrofitUtils.getInstance(basrUrl).getApiService().getLogin(map);
        presenterLogin.getNews(flowable);
    }
}
