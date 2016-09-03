package com.fzc.animationlearn.activity.activity;

import android.animation.Animator;
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
    private final AnimatorSet animatorSet = new AnimatorSet.Builder()
            .

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
        mObjectAnimator.setTarget(mPropertyView);

        mObjectAnimator.setPropertyName(TRANSLATION_Y);
        mObjectAnimator.setFloatValues(0, 50, 150, 350, 750, 350, 150, 50, 0);

        mObjectAnimator.setDuration(5 * 1000);
        mObjectAnimator.setRepeatCount(-1);


        mObjectAnimator.start();
    }

    private void endAnimation() {
//        mObjectAnimator.end();
        mObjectAnimator.cancel();
    }


}
