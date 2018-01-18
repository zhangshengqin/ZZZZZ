package text.bwei.com.yukao11yue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import text.bwei.com.yukao11yue.api.Api;
import text.bwei.com.yukao11yue.bean.Dianying;
import text.bwei.com.yukao11yue.bean.MessEvent;
import text.bwei.com.yukao11yue.common.PlayerManager;
import text.bwei.com.yukao11yue.fragment.JianjieFragment;
import text.bwei.com.yukao11yue.fragment.PinglunFragment;
import text.bwei.com.yukao11yue.presenter.DainYingPresenter;
import text.bwei.com.yukao11yue.view.IsecondView;

/**
 * Created by dell on 2017/12/7.
 */

public class SecondActivity extends AppCompatActivity implements PlayerManager.PlayerStateListener, IsecondView {

    private PlayerManager player;
    private String mediaId;
    private TextView textView;

    String[] strings = new String[]{"简介", "评论"};
    private TabLayout mTablayout;
    private ViewPager mVp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        textView = (TextView) findViewById(R.id.text1);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mVp = (ViewPager) findViewById(R.id.viewpager);
        EventBus.getDefault().register(this);
        initPlayer();
        DainYingPresenter dainYingPresenter = new DainYingPresenter(this);
        dainYingPresenter.getSecond(Api.URL, mediaId);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void F(MessEvent messEvent) {
        mediaId = messEvent.getMediaId();
        String title = messEvent.getTitle();
        textView.setText(title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    private void initPlayer() {
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (player.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }


    @Override
    public void onComplete() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        player.stop();
    }

    @Override
    public void onError() {
    }

    @Override
    public void onLoading() {
    }

    @Override
    public void onPlay() {
    }

    @Override
    public void shouVido(Dianying.RetBean list) {
        String hdurl = list.getHDURL();
        player.play(hdurl);

        for (int i = 0; i < strings.length; i++) {
            mTablayout.addTab(mTablayout.newTab().setText(strings[i]));
        }

        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (strings[position]){
                    case "简介":
                        fragment = new JianjieFragment();
                        break;
                    case "评论":
                        fragment = new PinglunFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return strings.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return strings[position];
            }
        });

        mTablayout.setupWithViewPager(mVp);




    }
}
