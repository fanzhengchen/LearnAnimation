package com.fzc.animationlearn.activity;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fzc.animationlearn.activity.annotation.DivierOrientation;

import static android.view.ViewGroup.MarginLayoutParams;

/**
 * Created by fanzhengchen on 9/1/16.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    @DivierOrientation
    private int mOrientation;
    private int mHeight;
    private ColorDrawable mDivider;

    public DividerItemDecoration(int color) {
        mDivider = new ColorDrawable();
        mDivider.setColor(color);
        mHeight = 2;
//        mHeight = (int)Resources.getSystem().getDisplayMetrics().density;
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int count = parent.getChildCount();
        for (int i = 0; i < count; ++i) {
            View childView = parent.getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();
            int left = childView.getLeft() + lp.leftMargin;
            int right = childView.getRight() + left;
            int top = childView.getBottom() + lp.bottomMargin;
            int bottom = top + mHeight;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
    }

    private void setOrientation(@DivierOrientation int orientation) {
        mOrientation = orientation;
    }

//    private int dp2Pixes(int dip) {
//        return dip * Resources.getSystem().getDisplayMetrics().densityDpi;
//    }
}
