package com.fzc.animationlearn.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fzc.animationlearn.R;
import com.fzc.viewdraghelper.DragView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 9/3/16.
 */
public class ActivityViewDragHelper extends ActivityBase {

    @BindView(R.id.drag_view)
    DragView mDragView;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, ActivityViewDragHelper.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drag_helper);
        ButterKnife.bind(this);
    }
}
