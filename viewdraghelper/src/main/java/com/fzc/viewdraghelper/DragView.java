package com.fzc.viewdraghelper;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by fanzhengchen on 9/3/16.
 */
public class DragView extends FrameLayout {

    private ViewDragHelper mDragHelper;
    private DragCallBack mDragCallBack;
    private View mContentView;
    private View mMenuView;
    private int mCurrentTop = 0;
    private View mAnimationView = null;
    private ObjectAnimator mRotateAnimator = null;

    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mDragCallBack = new DragCallBack();
        mDragHelper = ViewDragHelper.create(this, 10, mDragCallBack);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mContentView = getChildAt(1);
        if (mMenuView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) mMenuView;
            if (viewGroup.getChildCount() > 0) {
                mAnimationView = viewGroup.getChildAt(0);
                mRotateAnimator = ObjectAnimator.ofFloat(mAnimationView, "rotation", 360)
                        .setDuration(1000);
                mRotateAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        mDragHelper.shouldInterceptTouchEvent(ev);
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("on touch");
        mDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            invalidate();
        }
    }

    public class DragCallBack extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return child == mContentView;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            if (top < 0) {
                return 0;
            }
            return Math.max(Math.min(top, mMenuView.getHeight()), 0);
        }

        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            startRotate();
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    mDragHelper.smoothSlideViewTo(mContentView, 0, 0);
                    invalidate();
                    endRotate();
                }
            }, 2000);
        }

        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
        }
    }

    private void startRotate() {
        if (mRotateAnimator != null) {
            mRotateAnimator.start();
        }
    }

    private void endRotate() {
        if (mRotateAnimator != null) {
            mRotateAnimator.end();
        }
    }

}
