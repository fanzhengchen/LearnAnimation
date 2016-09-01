package com.fzc.animationlearn.activity.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fzc.animationlearn.R;

/**
 * Created by fanzhengchen on 9/1/16.
 */
public class ActivityPropertyAnimation extends ActivityBase {



    public static void start(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ActivityPropertyAnimation.class);
        activity.startActivity(intent, ActivityOptions
                .makeSceneTransitionAnimation(activity).toBundle());
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
    }
}
