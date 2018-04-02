package system.dressup.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import system.dressup.R;

/**
 * Created by idea on 2018/4/2.
 *
 * @author Soloist
 */

public class PersonalInfoCollectionActivity extends ItemActivity {

    public static void actionStart(Activity activity) {
        Intent intent = new Intent(activity, PersonalInfoCollectionActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.right_in, R.anim.do_nothing);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.personal_info_collection);
        super.onCreate(savedInstanceState);

        title.setText("我的收藏");
        other.setText("");
    }
}
