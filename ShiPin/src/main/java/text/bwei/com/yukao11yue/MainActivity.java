package text.bwei.com.yukao11yue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import text.bwei.com.yukao11yue.adapter.MyShouYeAdapter;
import text.bwei.com.yukao11yue.api.Api;
import text.bwei.com.yukao11yue.bean.ShouYe;
import text.bwei.com.yukao11yue.presenter.ShouyePresenter;
import text.bwei.com.yukao11yue.view.Iview;

public class MainActivity extends AppCompatActivity implements Iview {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        ShouyePresenter shouyePresenter = new ShouyePresenter(MainActivity.this);
        shouyePresenter.getShouye(Api.URL);
    }




    @Override
    public void showshouye(List<ShouYe.RetBean.ListBean> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyShouYeAdapter(list, MainActivity.this));
    }
}
