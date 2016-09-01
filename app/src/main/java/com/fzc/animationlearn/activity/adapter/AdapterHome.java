package com.fzc.animationlearn.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fzc.animationlearn.R;
import com.fzc.animationlearn.activity.activity.ActivityPropertyAnimation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fanzhengchen on 9/1/16.
 */
public class AdapterHome extends AdapterBase<AdapterHome.ViewHolderHome> {


    private List<String> data;
    private ArrayList<String> strings;

    public AdapterHome(List<String> data) {
        this.data = data;
    }

    @Override
    public ViewHolderHome onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderHome(mInflater.inflate(R.layout.item_home_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderHome holder, int position) {
        holder.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return getCollectionCount(data);
    }

    class ViewHolderHome extends RecyclerView.ViewHolder {
        @BindView(R.id.home_list_item_text)
        TextView homeListItemText;

        public ViewHolderHome(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setText(String text) {
            homeListItemText.setText(text);
        }

        @OnClick(R.id.home_list_item_parent)
        public void subMenu() {
            final int position = getAdapterPosition();
            switch (position) {
                case 0: {
                    ActivityPropertyAnimation.start(mActivity);
                    break;
                }
            }
        }
    }

}
