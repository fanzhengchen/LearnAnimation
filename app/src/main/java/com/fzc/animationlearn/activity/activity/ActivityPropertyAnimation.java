package com.fzc.animationlearn.activity.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.fzc.animationlearn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fanzhengchen on 9/1/16.
 */
public class ActivityPropertyAnimation extends ActivityBase {


    @BindView(R.id.property_view)
    View mPropertyView;

    private final ObjectAnimator mObjectAnimator = new ObjectAnimator();
    private final ObjectAnimator mAnimator = new ObjectAnimator();
    private final AnimatorSet animatorSet = new AnimatorSet();

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, ActivityPropertyAnimation.class);
        activity.startActivity(intent, ActivityOptions
                .makeSceneTransitionAnimation(activity).toBundle());
    }


    @OnClick(R.id.start_button)
    public void onClickStartButton() {
        startAnimation();
    }

    @OnClick(R.id.end_button)
    public void onClickStopButton() {
        endAnimation();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        ButterKnife.bind(this);
    }

    private void startAnimation() {


        int startColor = getColorCompat(R.color.lightGreen);
        int endColor = getColorCompat(R.color.colorAccent);
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(mPropertyView, "translationX", 0, 300)
                        .setDuration(3000),
                ObjectAnimator.ofFloat(mPropertyView, "translationY", 0, 600)
                        .setDuration(5000),
                ObjectAnimator.ofFloat(mPropertyView, "rotationX", 0, 359)
                        .setDuration(5000),
                ObjectAnimator.ofArgb(mPropertyView, "backgroundColor", startColor, endColor)
                        .setDuration(5000)
        );
//        animatorSet.
//        animatorSet.setDuration(5000);
        animatorSet.start();
    }

    private void endAnimation() {

    }


}
