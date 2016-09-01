package com.fzc.animationlearn.activity.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fzc.animationlearn.R;
import com.fzc.animationlearn.activity.DividerItemDecoration;
import com.fzc.animationlearn.activity.adapter.AdapterHome;

import java.util.Arrays;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityHome extends ActivityBase {

    @BindArray(R.array.array_animation)
    String[] mArray;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private AdapterHome mAdapterHome;
    private DividerItemDecoration mItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mItemDecoration = new DividerItemDecoration(getColorCompat(R.color.divider_color));
        mAdapterHome = new AdapterHome(Arrays.asList(mArray));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapterHome);
        mRecyclerView.addItemDecoration(mItemDecoration);
    }
}
