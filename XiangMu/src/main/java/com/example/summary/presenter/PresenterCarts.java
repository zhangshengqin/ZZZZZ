package com.example.summary.presenter;

import android.util.Log;

import com.example.summary.bean.CartsBean;
import com.example.summary.model.CardIModel;
import com.example.summary.model.ModelCarts;
import com.example.summary.view.IView;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by z on 2018/1/13.
 */

public class PresenterCarts implements CardIPresenter{
    private IView iView;
    private DisposableSubscriber subscriber;
    public PresenterCarts(IView iView) {
        this.iView = iView;
    }
    public void deletchView(){
        if(iView!=null){
            iView=null;
        }
        if(subscriber!=null){
            if(!subscriber.isDisposed()){
                subscriber.dispose();
            }
        }
    }

    @Override
    public void getData(String baseUrl, Map<String, String> map) {
        CardIModel model=new ModelCarts(this);
        model.getData(baseUrl, map);
    }
    public void getNews(Flowable<CartsBean> flowable){
        subscriber = (DisposableSubscriber) flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CartsBean>() {
                    @Override
                    public void onNext(CartsBean cartsBean) {
                        Log.e("PresenterCards",cartsBean.getMsg());
                        iView.Success(cartsBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("PresenterCards","falsed");
                        iView.Failed(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        /*subscriber=(DisposableSubscriber) flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CartsBean>() {
                    @Override
                    public void onNext(CartsBean cartsBean) {
                        Log.i("cccccccccc",cartsBean.toString());
                        iView.Success(cartsBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        iView.Failed(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
    }
}
