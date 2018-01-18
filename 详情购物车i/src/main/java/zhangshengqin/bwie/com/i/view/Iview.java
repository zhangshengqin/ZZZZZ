package zhangshengqin.bwie.com.i.view;

import zhangshengqin.bwie.com.i.bean.MessageBean;

/**
 * Created by 额头发 on 2018/1/8.
 */

public interface Iview {
    void onSuccess(Object o);
    void onFailed(Exception e);
    void delSuccess(MessageBean listMessageBean);
}
