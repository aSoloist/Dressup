package system.dressup.listener;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by idea on 2018/4/2.
 *
 * @author Soloist
 */

public class ChangePageOnClickListener implements View.OnClickListener {

    private Class<? extends AppCompatActivity> clazz;

    private Activity activity;

    public ChangePageOnClickListener(Class<? extends AppCompatActivity> clazz, Activity activity) {
        this.clazz = clazz;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        try {
            Method method = clazz.getMethod("actionStart", Activity.class);
            method.invoke(this, activity);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
