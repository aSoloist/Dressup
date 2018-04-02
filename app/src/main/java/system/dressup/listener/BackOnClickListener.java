package system.dressup.listener;

import android.app.Activity;
import android.view.View;

/**
 * Created by idea on 2018/4/2.
 *
 * @author Soloist
 */

public class BackOnClickListener implements View.OnClickListener {

    private Activity activity;

    public BackOnClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
            activity.onBackPressed();
    }

}
