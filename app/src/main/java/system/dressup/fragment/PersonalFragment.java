package system.dressup.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import system.dressup.R;
import system.dressup.activity.PersonalInfoCollectionActivity;
import system.dressup.activity.PersonalInfoFigureActivity;
import system.dressup.activity.PersonalInfoMessageActivity;
import system.dressup.listener.ChangePageOnClickListener;

/**
 * Created by idea on 2018/3/21.
 *
 * @author Soloist
 */

public class PersonalFragment extends Fragment {

    Activity activity;

    private CardView personalInfoFigure;
    private CardView personalInfoCollection;
    private CardView personalInfoMessage;
    private CardView personalInfoFeedback;
    private CardView personalInfoSafety;
    private CardView personalInfoClear;
    private CardView personalInfoAbout;
    private CardView personalInfoExit;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.personal_layout, container, false);
    }

    @Override
    public void onStart() {
        personalInfoFigure = (CardView) activity.findViewById(R.id.personal_info_figure);
        personalInfoCollection = (CardView) activity.findViewById(R.id.personal_info_collection);
        personalInfoMessage = (CardView) activity.findViewById(R.id.personal_info_message);
        personalInfoFeedback = (CardView) activity.findViewById(R.id.personal_info_feedback);
        personalInfoSafety = (CardView) activity.findViewById(R.id.personal_info_safety);
        personalInfoClear = (CardView) activity.findViewById(R.id.personal_info_clear);
        personalInfoAbout = (CardView) activity.findViewById(R.id.personal_info_about);
        personalInfoAbout = (CardView) activity.findViewById(R.id.personal_info_exit);

        personalInfoFigure.setOnClickListener(new ChangePageOnClickListener(PersonalInfoFigureActivity.class, activity));
        personalInfoCollection.setOnClickListener(new ChangePageOnClickListener(PersonalInfoCollectionActivity.class, activity));
        personalInfoMessage.setOnClickListener(new ChangePageOnClickListener(PersonalInfoMessageActivity.class, activity));
        super.onStart();
    }
}
