package com.fzc.animationlearn.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.fzc.animationlearn.R;
import com.fzc.animationlearn.activity.adapter.AdapterHome;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityHome extends ActivityBase {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private AdapterHome adapterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
