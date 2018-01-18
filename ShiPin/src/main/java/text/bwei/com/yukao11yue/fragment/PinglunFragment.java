package text.bwei.com.yukao11yue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import text.bwei.com.yukao11yue.R;
import text.bwei.com.yukao11yue.adapter.PinlunAdapter;
import text.bwei.com.yukao11yue.api.Api;
import text.bwei.com.yukao11yue.bean.MessEvent;
import text.bwei.com.yukao11yue.bean.Pinlun;
import text.bwei.com.yukao11yue.presenter.PinlunPresenter;
import text.bwei.com.yukao11yue.view.IpinlunView;

/**
 * Created by dell on 2017/12/8.
 */

public class PinglunFragment extends Fragment implements IpinlunView {

    private View inflate;
    private RecyclerView recyclerView;
    private String mediaId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.pinlun, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        recyclerView = inflate.findViewById(R.id.recy_pinlun);
        PinlunPresenter pinlunPresenter = new PinlunPresenter(this);
        pinlunPresenter.getPinPlun(Api.URL, mediaId, 10);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Fa(MessEvent messEvent) {
        mediaId = messEvent.getMediaId();
    }


    @Override
    public void showpinlu(List<Pinlun.RetBean.ListBean> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new PinlunAdapter(list, getActivity()));


    }
}
