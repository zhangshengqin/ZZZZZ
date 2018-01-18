package text.bwei.com.yuekao.details.car.view;


import text.bwei.com.yuekao.details.car.bean.MessageBean;

public interface Iview {
    void onSuccess(Object o);
    void onFailed(Exception e);
    void delSuccess(MessageBean listMessageBean);
}