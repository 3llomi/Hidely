package com.devlomi.hidely.hidelyviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.devlomi.hidely.HidelyAnimationCallbacks;
import com.devlomi.hidely.HidelyCore;
import com.devlomi.hidely.HidelyInterface;


public class HidelyRelativeLayout extends RelativeLayout implements HidelyInterface {
    private HidelyCore hidelyCore;

    public HidelyRelativeLayout(@NonNull Context context) {
        super(context);
        initCore();
    }

    public HidelyRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initCore();
    }

    public HidelyRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCore();
    }


    private void initCore() {
        hidelyCore = new HidelyCore(this);
    }


    @Override
    public void show() {
        if (hidelyCore != null)
            hidelyCore.show();
    }

    @Override
    public void hide() {
        if (hidelyCore != null)
            hidelyCore.hide();
    }

    @Override
    public boolean isShowing() {
        return hidelyCore == null ? false : hidelyCore.isShowing();
    }

    @Override
    public void setAnimationCallbacks(HidelyAnimationCallbacks animationCallbacks) {
        hidelyCore.setAnimationListener(animationCallbacks);
    }
}
