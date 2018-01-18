package com.example.summary.model;

import com.example.summary.bean.DetailBean;
import com.example.summary.presenter.PresenterDetail;
import com.example.summary.retrofit.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by z on 2018/1/12.
 */

public class ModelDetail implements IModel{
    private PresenterDetail presenterDetail;

    public ModelDetail(PresenterDetail presenterDetail) {
        this.presenterDetail = presenterDetail;
    }

    @Override
    public void getData(String basrUrl, Map<String, String> map) {
        Flowable<DetailBean> flowable = RetrofitUtils.getInstance(basrUrl).getApiService().getDetail(map);
        presenterDetail.getNews(flowable);
    }
}
