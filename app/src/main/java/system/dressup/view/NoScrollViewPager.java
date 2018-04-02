package system.dressup.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by idea on 2018/4/2.
 *
 * @author Soloist
 */

public class NoScrollViewPager extends ViewPager {
    // 手指滑动
    private boolean isCanScroll = false;

    // 页面跳转滑动
    private boolean isPageChangeScroll = false;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isCanScroll && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isCanScroll && super.onInterceptTouchEvent(ev);
    }

    public void setCanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    public void setPageChangeScroll(boolean isPageChangeScroll) {
        this.isPageChangeScroll = isPageChangeScroll;
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, isPageChangeScroll);
    }
}
