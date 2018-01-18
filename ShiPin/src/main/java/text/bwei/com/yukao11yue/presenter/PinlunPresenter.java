package text.bwei.com.yukao11yue.presenter;

import java.util.List;

import text.bwei.com.yukao11yue.bean.Pinlun;
import text.bwei.com.yukao11yue.model.Imodel;
import text.bwei.com.yukao11yue.model.Onthree;
import text.bwei.com.yukao11yue.model.model;
import text.bwei.com.yukao11yue.view.IpinlunView;

/**
 * Created by dell on 2017/12/8.
 */

public class PinlunPresenter {
    IpinlunView ipinlunView;
    Imodel imodel;

    public PinlunPresenter(IpinlunView ipinlunView) {
        this.ipinlunView = ipinlunView;
        imodel = new model();
    }

    public void getPinPlun(String url, String mediaId, int pnum) {
        imodel.RequstPinlun(url, mediaId, pnum, new Onthree() {
            @Override
            public void datapinlun(List<Pinlun.RetBean.ListBean> list) {
                ipinlunView.showpinlu(list);
            }
        });


    }


}
