package com.example.summary.presenter;

import com.example.summary.bean.RegBean;
import com.example.summary.model.IModel;
import com.example.summary.model.ModelReg;
import com.example.summary.view.IView;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by z on 2018/1/11.
 */

public class PresenterReg implements IPresenter{
    private IView iView;
    private DisposableSubscriber<RegBean> subscriber;

    public PresenterReg(IView iView) {
        this.iView = iView;

    }
    public void delethView(){
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
        IModel model=new ModelReg(this);
        model.getData(baseUrl,map);
    }
    public void getNews(Flowable<RegBean> flowable){
        subscriber=flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<RegBean>() {
                    @Override
                    public void onNext(RegBean regBean) {
                        iView.Success(regBean);
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
