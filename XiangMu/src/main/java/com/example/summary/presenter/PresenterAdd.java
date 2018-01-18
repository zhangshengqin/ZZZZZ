package com.example.summary.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.summary.bean.AddBean;
import com.example.summary.model.IModel;
import com.example.summary.model.ModelAdd;
import com.example.summary.view.IView;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by z on 2018/1/12.
 */

public class PresenterAdd implements IPresenter{
    private IView iView;
    private Context context;
    private DisposableSubscriber<AddBean> subscriber;

    public PresenterAdd(IView iView,Context context) {
        this.iView = iView;
        this.context=context;
    }

    public void delechView(){
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
        IModel model=new ModelAdd(this);
        model.getData(baseUrl, map);
    }
    public void getNews(Flowable<AddBean> flowable){
        subscriber=flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<AddBean>() {
                    @Override
                    public void onNext(AddBean addBean) {
                        if(addBean.getCode().equals("0")){
                            Toast.makeText(context,addBean.getMsg(),Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
