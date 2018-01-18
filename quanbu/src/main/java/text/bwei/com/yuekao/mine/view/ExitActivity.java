package text.bwei.com.yuekao.mine.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import text.bwei.com.yuekao.R;


public class ExitActivity extends AppCompatActivity {

    @BindView(R.id.btn_exit)
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_exit)
    public void onViewClicked() {
        SharedPreferences user = getSharedPreferences("USER", MODE_PRIVATE);
        user.edit().clear().commit();
        finish();
    }
}