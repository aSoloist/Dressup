package system.dressup.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import system.dressup.R;
import system.dressup.listener.BackOnClickListener;

/**
 * Created by idea on 2018/4/2.
 *
 * @author Soloist
 */

public class ItemActivity extends AppCompatActivity {

    protected Button back;
    protected TextView title;
    protected Button other;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        back = (Button) findViewById(R.id.back);
        title = (TextView) findViewById(R.id.title);
        other = (Button) findViewById(R.id.other);
        back.setOnClickListener(new BackOnClickListener(this));
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.do_nothing, R.anim.right_out);
    }
}
