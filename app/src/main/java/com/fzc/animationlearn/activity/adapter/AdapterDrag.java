package com.fzc.animationlearn.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fzc.animationlearn.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 9/6/16.
 */
public class AdapterDrag extends AdapterBase<AdapterDrag.ViewHolder> {


    private List<String> mData;

    public AdapterDrag(List<String> data) {
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_drag_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return getCollectionCount(mData);
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.drag_text)
        TextView dragTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setText(String text) {
            dragTextView.setText(text);
        }
    }
}
