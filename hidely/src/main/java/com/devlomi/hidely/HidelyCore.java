package com.devlomi.hidely;

import android.animation.Animator;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;

public class HidelyCore {
    private static final LinearOutSlowInInterpolator linearOutSlowIn = new LinearOutSlowInInterpolator();
    private static final FastOutLinearInInterpolator fastOutLinearIn = new FastOutLinearInInterpolator();

    View view;
    HidelyAnimationCallbacks callbacks;

    public void setAnimationListener(HidelyAnimationCallbacks callbacks) {
        this.callbacks = callbacks;
    }

    public HidelyCore(View view) {
        this.view = view;
    }

    public boolean isShowing() {
        return view.getVisibility() == View.VISIBLE;
    }

    public void show() {
        view.setAlpha(0f);
        view.setScaleY(0f);
        view.setScaleX(0f);
        view.animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(100)
                .setInterpolator(linearOutSlowIn)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        if (callbacks != null)
                            callbacks.onAnimationStart();

                        view.setVisibility(View.VISIBLE);


                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        if (callbacks != null)
                            callbacks.onAnimationEnd();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
    }

    public void hide() {
        view.animate()
                .scaleX(0f)
                .scaleY(0f)
                .alpha(0f)
                .setDuration(100)
                .setInterpolator(fastOutLinearIn)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        if (callbacks != null)
                            callbacks.onAnimationStart();
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        view.setVisibility(View.INVISIBLE);

                        if (callbacks != null)
                            callbacks.onAnimationEnd();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
    }


}
