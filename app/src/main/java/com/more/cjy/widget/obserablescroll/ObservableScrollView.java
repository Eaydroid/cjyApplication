package com.more.cjy.widget.obserablescroll;/*
 * Copyright 2014 Soichiro Kashima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * ScrollView that its scroll position can be observed.
 */
public class ObservableScrollView extends ScrollView implements Scrollable{

    // Fields that should be saved onSaveInstanceState
    private int mPrevScrollY;
    private int mScrollY;

    // Fields that don't need to be saved onSaveInstanceState
    private ObservableScrollViewCallbacks mCallbacks;
    private List<ObservableScrollViewCallbacks> mCallbackCollection;
    private ScrollState mScrollState;
    private boolean mFirstScroll;
    private boolean mDragging;
    private boolean mIntercepted;
    private MotionEvent mPrevMoveEvent;
    private ViewGroup mTouchInterceptionViewGroup;
    private ScrollViewListener scrollViewListener = null;
    private MyMotionEventListener motionEventListener;
    private int[] li2 = new int[2];
    private boolean startIsTop = true;

    public boolean isStartTop() {
        return startIsTop;
    }

    public MyMotionEventListener getMotionEventListener() {
        return motionEventListener;
    }

    public void setMotionEventListener(MyMotionEventListener motionEventListener) {
        this.motionEventListener = motionEventListener;
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    public interface MyMotionEventListener {
        void onActionDown(MotionEvent event);
        void onActionMove(MotionEvent event);
        void onActionUpOrCancel(MotionEvent event);
    }

    public ObservableScrollView(Context context){
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        mPrevScrollY = ss.prevScrollY;
        mScrollY = ss.scrollY;
        super.onRestoreInstanceState(ss.getSuperState());
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.prevScrollY = mPrevScrollY;
        ss.scrollY = mScrollY;
        return ss;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (hasNoCallbacks()){
            return;
        }
        mScrollY = t;

        dispatchOnScrollChanged(t, mFirstScroll, mDragging);
        if (mFirstScroll) {
            mFirstScroll = false;
        }

        if (mPrevScrollY < t) {
            mScrollState = ScrollState.UP;
        } else if (t < mPrevScrollY) {
            mScrollState = ScrollState.DOWN;
            //} else {
            // Keep previous state while dragging.
            // Never makes it STOP even if scrollY not changed.
            // Before Android 4.4, onTouchEvent calls onScrollChanged directly for ACTION_MOVE,
            // which makes mScrollState always STOP when onUpOrCancelMotionEvent is called.
            // STOP state is now meaningless for ScrollView.
        }
        mPrevScrollY = t;

        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        Log.d("cjy", "onOverScrolled scrollY = " + scrollY);
        if(scrollViewListener != null) {
            scrollViewListener.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (hasNoCallbacks()) {
            return super.onInterceptTouchEvent(ev);
        }
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                // Whether or not motion events are consumed by children,
                // flag initializations which are related to ACTION_DOWN events should be executed.
                // Because if the ACTION_DOWN is consumed by children and only ACTION_MOVEs are
                // passed to parent (this view), the flags will be invalid.
                // Also, applications might implement initialization codes to onDownMotionEvent,
                // so call it here.
                mFirstScroll = mDragging = true;
                dispatchOnDownMotionEvent();
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public double getSplineFlingDistance(int velocityY) {

        final double l = getG(velocityY);
        final double decelMinusOne = (float) (Math.log(0.78) / Math.log(0.9)) - 1.0;
        return ViewConfiguration.getScrollFriction() * (SensorManager.GRAVITY_EARTH // g (m/s^2)
                * 39.37f // inch/meter
                * (getResources().getDisplayMetrics().density * 160.0f)
                * 0.84f) * Math.exp((float) (Math.log(0.78) / Math.log(0.9)) / decelMinusOne * l);
    }

    /**
     *
     * @param velocityY 初速度
     * @return 滑动的距离
     * @author xuekai
     */
    public double getDis(int velocityY) {

        final double l = getG(velocityY);
        final double decelMinusOne = (float) (Math.log(0.78) / Math.log(0.9)) - 1.0;
        return ViewConfiguration.getScrollFriction() * (SensorManager.GRAVITY_EARTH // g (m/s^2)
                * 39.37f // inch/meter
                * (getResources().getDisplayMetrics().density * 160.0f)
                * 0.84f) * Math.exp((float) (Math.log(0.78) / Math.log(0.9)) / decelMinusOne * l);
    }




    public double getG(int velocityY) {
        return Math.log(0.35f * Math.abs(velocityY) / (ViewConfiguration.getScrollFriction() * SensorManager.GRAVITY_EARTH
                * 39.37f // inch/meter
                * (getResources().getDisplayMetrics().density * 160.0f)
                * 0.84f));

    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override
    public void fling(int velocityY) {
        if(velocityY < 0) {
            startIsTop= false;
        }
        super.fling(velocityY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        getLocationOnScreen(li2);
        if (hasNoCallbacks()) {
            return super.onTouchEvent(ev);
        }
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                if(motionEventListener != null) {
                    motionEventListener.onActionDown(ev);
                }
                break;
            case MotionEvent.ACTION_UP:
               /* handler.sendMessageDelayed(handler.obtainMessage(), 5);*/
                if(motionEventListener != null) {
                    motionEventListener.onActionUpOrCancel(ev);
                }
                startIsTop = li2[1] == 0;
                 break;
            case MotionEvent.ACTION_CANCEL:
                mIntercepted = false;
                mDragging = false;
                dispatchOnUpOrCancelMotionEvent(mScrollState);
                if(motionEventListener != null) {
                    motionEventListener.onActionUpOrCancel(ev);
                }
                startIsTop = li2[1] == 0;
                break;
            case MotionEvent.ACTION_MOVE:
                if(motionEventListener != null) {
                    motionEventListener.onActionMove(ev);
                }
//                if(popup_is_show) {
//                    return false;
//                }
                if (mPrevMoveEvent == null) {
                    mPrevMoveEvent = ev;
                }
                float diffY = ev.getY() - mPrevMoveEvent.getY();
                mPrevMoveEvent = MotionEvent.obtainNoHistory(ev);
                if (getCurrentScrollY() - diffY <= 0) {
                    // Can't scroll anymore.

                    if (mIntercepted) {
                        // Already dispatched ACTION_DOWN event to parents, so stop here.
                        return false;
                    }

                    // Apps can set the interception target other than the direct parent.
                    final ViewGroup parent;
                    if (mTouchInterceptionViewGroup == null) {
                        parent = (ViewGroup) getParent();
                    } else {
                        parent = mTouchInterceptionViewGroup;
                    }

                    // Get offset to parents. If the parent is not the direct parent,
                    // we should aggregate offsets from all of the parents.
                    float offsetX = 0;
                    float offsetY = 0;
                    for (View v = this; v != null && v != parent; v = (View) v.getParent()) {
                        offsetX += v.getLeft() - v.getScrollX();
                        offsetY += v.getTop() - v.getScrollY();
                    }
                    final MotionEvent event = MotionEvent.obtainNoHistory(ev);
                    event.offsetLocation(offsetX, offsetY);

                    if (parent.onInterceptTouchEvent(event)) {
                        mIntercepted = true;

                        // If the parent wants to intercept ACTION_MOVE events,
                        // we pass ACTION_DOWN event to the parent
                        // as if these touch events just have began now.
                        event.setAction(MotionEvent.ACTION_DOWN);

                        // Return this onTouchEvent() first and set ACTION_DOWN event for parent
                        // to the queue, to keep events sequence.
                        post(new Runnable() {
                            @Override
                            public void run() {
                                parent.dispatchTouchEvent(event);
                            }
                        });
                        return false;
                    }
                    // Even when this can't be scrolled anymore,
                    // simply returning false here may cause subView's click,
                    // so delegate it to super.
                    return super.onTouchEvent(ev);
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public void setScrollViewCallbacks(ObservableScrollViewCallbacks listener) {
        mCallbacks = listener;
    }

    @Override
    public void addScrollViewCallbacks(ObservableScrollViewCallbacks listener) {
        if (mCallbackCollection == null) {
            mCallbackCollection = new ArrayList<>();
        }
        mCallbackCollection.add(listener);
    }

    @Override
    public void removeScrollViewCallbacks(ObservableScrollViewCallbacks listener) {
        if (mCallbackCollection != null) {
            mCallbackCollection.remove(listener);
        }
    }

    @Override
    public void clearScrollViewCallbacks() {
        if (mCallbackCollection != null) {
            mCallbackCollection.clear();
        }
    }

    @Override
    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        mTouchInterceptionViewGroup = viewGroup;
    }

    @Override
    public void scrollVerticallyTo(int y) {
        scrollTo(0, y);
    }

    @Override
    public int getCurrentScrollY() {
        return mScrollY;
    }

    private void dispatchOnDownMotionEvent() {
        if (mCallbacks != null) {
            mCallbacks.onDownMotionEvent();
        }
        if (mCallbackCollection != null) {
            for (int i = 0; i < mCallbackCollection.size(); i++) {
                ObservableScrollViewCallbacks callbacks = mCallbackCollection.get(i);
                callbacks.onDownMotionEvent();
            }
        }
    }

    private void dispatchOnScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        if (mCallbacks != null) {
            mCallbacks.onScrollChanged(scrollY, firstScroll, dragging);
        }
        if (mCallbackCollection != null) {
            for (int i = 0; i < mCallbackCollection.size(); i++) {
                ObservableScrollViewCallbacks callbacks = mCallbackCollection.get(i);
                callbacks.onScrollChanged(scrollY, firstScroll, dragging);
            }
        }
    }

    private void dispatchOnUpOrCancelMotionEvent(ScrollState scrollState) {
        if (mCallbacks != null) {
            mCallbacks.onUpOrCancelMotionEvent(scrollState);
        }
        if (mCallbackCollection != null) {
            for (int i = 0; i < mCallbackCollection.size(); i++) {
                ObservableScrollViewCallbacks callbacks = mCallbackCollection.get(i);
                callbacks.onUpOrCancelMotionEvent(scrollState);
            }
        }
    }

    private boolean hasNoCallbacks() {
        return mCallbacks == null && mCallbackCollection == null;
    }

    static class SavedState extends View.BaseSavedState{
        int prevScrollY;
        int scrollY;

        /**
         * Called by onSaveInstanceState.
         */
        SavedState(Parcelable superState) {
            super(superState);
        }

        /**
         * Called by CREATOR.
         */
        private SavedState(Parcel in) {
            super(in);
            prevScrollY = in.readInt();
            scrollY = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(prevScrollY);
            out.writeInt(scrollY);
        }

        public static final Creator<SavedState> CREATOR
            = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }

    public interface ScrollViewListener {
        void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy);
        void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY);
    }
}
