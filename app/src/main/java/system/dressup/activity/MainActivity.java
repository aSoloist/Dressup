package system.dressup.activity;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import system.dressup.fragment.MainPageFragment;
import system.dressup.fragment.PersonalFragment;
import system.dressup.fragment.ScheduleFragment;
import system.dressup.fragment.ShareFragment;
import system.dressup.fragment.WardrobeFragment;
import system.dressup.R;
import system.dressup.view.NoScrollViewPager;

/**
 * Created by idea on 2018/3/21.
 *
 * @author Soloist
 */

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    private BottomNavigationView navigationView;
    private NoScrollViewPager viewPager;

    private Fragment mainPage = new MainPageFragment();
    private Fragment schedule = new ScheduleFragment();
    private Fragment wardrobe = new WardrobeFragment();
    private Fragment share = new ShareFragment();
    private Fragment personal = new PersonalFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        viewPager = (NoScrollViewPager) findViewById(R.id.viewPage);
        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        Log.i("返回", "主页");
                        return mainPage;
                    case 1:
                        Log.i("返回", "日程");
                        return schedule;
                    case 2:
                        Log.i("返回", "衣柜");
                        return wardrobe;
                    case 3:
                        Log.i("返回", "分享");
                        return share;
                    case 4:
                        Log.i("返回", "个人");
                        return personal;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        disableShiftMode(navigationView);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                viewPager.setCurrentItem(item.getOrder());
                Log.i("选择了", item.getOrder() + "");
                return true;
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        navigationView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);

        try {
            Field mShiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            mShiftingMode.setAccessible(true);
            mShiftingMode.setBoolean(menuView, false);
            mShiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
