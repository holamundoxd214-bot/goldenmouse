package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    FakeDrag(ViewPager2 arg1, ScrollEventAdapter arg2, RecyclerView arg3) {
        super();
        this.mViewPager = arg1;
        this.mScrollEventAdapter = arg2;
        this.mRecyclerView = arg3;
    }

    private void addFakeMotionEvent(long arg9, int arg11, float arg12, float arg13) {
        MotionEvent v9 = MotionEvent.obtain(this.mFakeDragBeginTime, arg9, arg11, arg12, arg13, 0);
        this.mVelocityTracker.addMovement(v9);
        v9.recycle();
    }

    boolean beginFakeDrag() {
        if(this.mScrollEventAdapter.isDragging()) {
            return 0;
        }

        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = 0f;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        this.beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        if(!this.mScrollEventAdapter.isIdle()) {
            this.mRecyclerView.stopScroll();
        }

        this.addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0f, 0f);
        return 1;
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker v0 = this.mVelocityTracker;
        if(v0 == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
            this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
            return;
        }

        v0.clear();
    }

    boolean endFakeDrag() {
        if(!this.mScrollEventAdapter.isFakeDragging()) {
            return 0;
        }

        this.mScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker v0 = this.mVelocityTracker;
        v0.computeCurrentVelocity(1000, ((float)this.mMaximumVelocity));
        if(!this.mRecyclerView.fling(((int)v0.getXVelocity()), ((int)v0.getYVelocity()))) {
            this.mViewPager.snapToPage();
        }

        return 1;
    }

    boolean fakeDragBy(float arg10) {
        int v1 = 0;
        if(!this.mScrollEventAdapter.isFakeDragging()) {
            return 0;
        }

        float v0 = this.mRequestedDragDistance - arg10;
        this.mRequestedDragDistance = v0;
        int v10 = Math.round(v0 - (((float)this.mActualDraggedDistance)));
        this.mActualDraggedDistance += v10;
        long v3 = SystemClock.uptimeMillis();
        int v0_1 = this.mViewPager.getOrientation() == 0 ? 1 : 0;
        int v2 = v0_1 != 0 ? v10 : 0;
        if(v0_1 != 0) {
        }
        else {
            v1 = v10;
        }

        arg10 = 0f;
        float v6 = v0_1 != 0 ? this.mRequestedDragDistance : 0f;
        if(v0_1 != 0) {
        }
        else {
            arg10 = this.mRequestedDragDistance;
        }

        this.mRecyclerView.scrollBy(v2, v1);
        this.addFakeMotionEvent(v3, 2, v6, arg10);
        return 1;
    }

    boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }
}

