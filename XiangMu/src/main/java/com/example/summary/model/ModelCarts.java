package com.example.summary.model;

import com.example.summary.bean.CartsBean;
import com.example.summary.presenter.PresenterCarts;
import com.example.summary.retrofit.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by z on 2018/1/13.
 */

public class ModelCarts implements CardIModel{
    private PresenterCarts presenterCarts;

    public ModelCarts(PresenterCarts presenterCarts) {
        this.presenterCarts = presenterCarts;
    }

    @Override
    public void getData(String basrUrl, Map<String, String> map) {
        Flowable<CartsBean> flowable = RetrofitUtils.getInstance(basrUrl).getApiService().getCarts(map);
        presenterCarts.getNews(flowable);
    }
}
