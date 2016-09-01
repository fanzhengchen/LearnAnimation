package com.fzc.animationlearn.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.Collection;

/**
 * Created by fanzhengchen on 9/1/16.
 */
public abstract class AdapterBase<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    protected Context context;
    protected LayoutInflater inflater;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        context = null;
    }
    
    protected int getCollectionCount(Collection collection) {
        return collection == null ? 0 : collection.size();
    }

}
