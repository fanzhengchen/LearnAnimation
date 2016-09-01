package com.fzc.animationlearn.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.Collection;

/**
 * Created by fanzhengchen on 9/1/16.
 */
public abstract class AdapterBase<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    protected Context mContext;
    protected Activity mActivity;
    protected LayoutInflater mInflater;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mContext = recyclerView.getContext();
        mInflater = LayoutInflater.from(mContext);
        mActivity = (Activity) mContext;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mContext = null;
    }

    protected int getCollectionCount(Collection collection) {
        return collection == null ? 0 : collection.size();
    }

}
