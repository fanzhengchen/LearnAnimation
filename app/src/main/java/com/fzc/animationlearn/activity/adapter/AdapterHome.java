package com.fzc.animationlearn.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fzc.animationlearn.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by fanzhengchen on 9/1/16.
 */
public class AdapterHome extends AdapterBase<AdapterHome.ViewHolderHome>{


    private List<String> data;
    private ArrayList<String> strings;

    public AdapterHome(List<String> data) {
        Collections.copy(data, this.data);
    }

    @Override
    public ViewHolderHome onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderHome holder, int position) {

    }

    @Override
    public int getItemCount() {
        return getCollectionCount(data);
    }

    public static class ViewHolderHome extends RecyclerView.ViewHolder {
        @BindView(R.id.home_list_item_text)
        TextView homeListItemText;

        public ViewHolderHome(View itemView) {
            super(itemView);
        }
    }

}
