package com.fzc.animationlearn.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.fzc.animationlearn.R;
import com.fzc.animationlearn.activity.adapter.AdapterDrag;
import com.fzc.viewdraghelper.DragView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 9/3/16.
 */
public class ActivityViewDragHelper extends ActivityBase {

    @BindView(R.id.drag_view)
    DragView mDragView;
    @BindView(R.id.back_view)
    View backView;
    @BindView(R.id.recycler_view_drag)
    RecyclerView mRecyclerViewDrag;
    @BindView(R.id.icon_reveal)
    ImageView revealImageView;

    private AdapterDrag mAdapter;
    private final List<String> mData = new ArrayList<>();

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, ActivityViewDragHelper.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drag_helper);
        ButterKnife.bind(this);
        mRecyclerViewDrag.setLayoutManager(new LinearLayoutManager(this));
        initData();
    }

    private void initData() {
        for (int i = 0; i < 10; ++i) {
            mData.add(i + "");
        }
        mAdapter = new AdapterDrag(mData);
        mRecyclerViewDrag.setAdapter(mAdapter);
    }
}
