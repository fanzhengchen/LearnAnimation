package com.fzc.animationlearn.activity.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import com.fzc.animationlearn.R;

/**
 * Created by fanzhengchen on 9/1/16.
 */
public abstract class ActivityBase extends AppCompatActivity {


    protected int getFeature() {
        return Window.FEATURE_CONTENT_TRANSITIONS;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(getFeature());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
        getWindow().setEnterTransition(transition);
    }

    protected int getColorCompat(@ColorRes int resId) {
        return ContextCompat.getColor(this, resId);
    }
}
