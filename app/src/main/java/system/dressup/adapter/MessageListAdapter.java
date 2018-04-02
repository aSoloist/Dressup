package system.dressup.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import system.dressup.R;
import system.dressup.model.MessageList;

/**
 * Created by idea on 2018/4/2.
 *
 * @author Soloist
 */

public class MessageListAdapter extends ArrayAdapter<MessageList> {

    private int resourceId;

    public MessageListAdapter(Context context, int textViewResourceId, List<MessageList> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MessageList messageList = getItem(position);
        View view;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        } else {
            view = convertView;
        }

        ImageView headerImage = (ImageView) view.findViewById(R.id.header_image);
        TextView username = (TextView) view.findViewById(R.id.username);
        TextView message = (TextView) view.findViewById(R.id.message);

        assert messageList != null;
        headerImage.setImageResource(messageList.getHeaderImageId());
        username.setText(messageList.getUsername());
        message.setText(messageList.getMessage());

        return view;
    }
}
