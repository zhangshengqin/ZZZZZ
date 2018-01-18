package com.example.summary.model;

import com.example.summary.bean.RegBean;
import com.example.summary.presenter.PresenterReg;
import com.example.summary.retrofit.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by z on 2018/1/11.
 */

public class ModelReg implements IModel{
    private PresenterReg presenterReg;

    public ModelReg(PresenterReg presenterReg) {
        this.presenterReg = presenterReg;
    }

    @Override
    public void getData(String basrUrl, Map<String, String> map) {
        Flowable<RegBean> flowable = RetrofitUtils.getInstance(basrUrl).getApiService().getReg(map);
        presenterReg.getNews(flowable);
    }
}
