package com.fzc.viewdraghelper;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by fanzhengchen on 9/3/16.
 */
public class DragView extends FrameLayout {

    private ViewDragHelper mDragHelper;
    private DragCallBack mDragCallBack;

    public DragView(Context context) {
        super(context, null);
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mDragCallBack = new DragCallBack();
        mDragHelper = ViewDragHelper.create(this, 1, mDragCallBack);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public class DragCallBack extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return false;
        }
    }
}
