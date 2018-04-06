package com.devlomi.hidely.hidelyviews;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.devlomi.hidely.HidelyAnimationCallbacks;
import com.devlomi.hidely.HidelyCore;
import com.devlomi.hidely.HidelyInterface;


public class HidelyButton extends AppCompatButton implements HidelyInterface {

    private HidelyCore hidelyCore;


    public HidelyButton(Context context) {
        super(context);
        initCore();
    }

    public HidelyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCore();
    }

    public HidelyButton(Context context, AttributeSet attrs, int defStyleAttr) {
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
