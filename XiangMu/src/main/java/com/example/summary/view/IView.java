package com.example.summary.view;

/**
 * Created by z on 2018/1/11.
 */

public interface IView {
    void Success(Object o);
    void Failed(Throwable t);
}
