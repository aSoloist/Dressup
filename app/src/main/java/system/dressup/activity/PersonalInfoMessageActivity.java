package system.dressup.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import system.dressup.R;
import system.dressup.adapter.MessageListAdapter;
import system.dressup.model.MessageList;

/**
 * Created by idea on 2018/4/2.
 *
 * @author Soloist
 */

public class PersonalInfoMessageActivity extends ItemActivity {

    private List<MessageList> messageLists = new ArrayList<>();

    public static void actionStart(Activity activity) {
        Intent intent = new Intent(activity, PersonalInfoMessageActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.right_in, R.anim.do_nothing);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.personal_info_message);
        super.onCreate(savedInstanceState);

        title.setText("我的消息");
        other.setText("");
        getList();
        ListView listView = (ListView) findViewById(R.id.message_list);
        listView.setAdapter(new MessageListAdapter(PersonalInfoMessageActivity.this, R.layout.message_list, messageLists));
    }

    private void getList() {
        messageLists.add(new MessageList(R.drawable.timg1, "测试用户", "测试内容"));
    }
}
