package system.dressup.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import system.dressup.R;
import system.dressup.listener.BackOnClickListener;

/**
 * Created by idea on 2018/4/2.
 *
 * @author Soloist
 */

public class PersonalInfoFigureActivity extends ItemActivity {

    public static void actionStart(Activity activity) {
        Intent intent = new Intent(activity, PersonalInfoFigureActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.right_in, R.anim.do_nothing);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.personal_info_figure);
        super.onCreate(savedInstanceState);

        title.setText("身材信息");
        other.setText("相机");
    }

}
