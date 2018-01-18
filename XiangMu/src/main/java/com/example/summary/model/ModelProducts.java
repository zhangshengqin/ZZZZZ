package com.example.summary.model;

import com.example.summary.bean.ProductsBean;
import com.example.summary.presenter.PresenterProducts;
import com.example.summary.retrofit.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by z on 2018/1/11.
 */

public class ModelProducts implements IModel{
    private PresenterProducts presenterProducts;

    public ModelProducts(PresenterProducts presenterProducts) {
        this.presenterProducts = presenterProducts;
    }

    @Override
    public void getData(String basrUrl, Map<String, String> map) {
        Flowable<ProductsBean> flowable = RetrofitUtils.getInstance(basrUrl).getApiService().getProducts(map);
        presenterProducts.getNews(flowable);
    }
}
