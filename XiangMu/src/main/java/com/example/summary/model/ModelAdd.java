package com.example.summary.model;

import com.example.summary.bean.AddBean;
import com.example.summary.presenter.PresenterAdd;
import com.example.summary.retrofit.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by z on 2018/1/12.
 */

public class ModelAdd implements IModel{
    private PresenterAdd presenterAdd;

    public ModelAdd(PresenterAdd presenterAdd) {
        this.presenterAdd = presenterAdd;
    }

    @Override
    public void getData(String basrUrl, Map<String, String> map) {
        Flowable<AddBean> flowable = RetrofitUtils.getInstance(basrUrl).getApiService().getAdd(map);
        presenterAdd.getNews(flowable);
    }
}
