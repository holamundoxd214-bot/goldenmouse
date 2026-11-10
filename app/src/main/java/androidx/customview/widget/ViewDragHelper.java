package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {
    class androidx.customview.widget.ViewDragHelper$1 implements Interpolator {
        androidx.customview.widget.ViewDragHelper$1() {
            super();
        }

        public float getInterpolation(float arg2) {
            --arg2;
            return arg2 * arg2 * arg2 * arg2 * arg2 + 1f;
        }
    }

    class androidx.customview.widget.ViewDragHelper$2 implements Runnable {
        androidx.customview.widget.ViewDragHelper$2(ViewDragHelper arg1) {
            ViewDragHelper.this = arg1;
            super();
        }

        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    }

    public abstract class Callback {
        public Callback() {
            super();
        }

        public int clampViewPositionHorizontal(View arg1, int arg2, int arg3) {
            return 0;
        }

        public int clampViewPositionVertical(View arg1, int arg2, int arg3) {
            return 0;
        }

        public int getOrderedChildIndex(int arg1) {
            return arg1;
        }

        public int getViewHorizontalDragRange(View arg1) {
            return 0;
        }

        public int getViewVerticalDragRange(View arg1) {
            return 0;
        }

        public void onEdgeDragStarted(int arg1, int arg2) {
        }

        public boolean onEdgeLock(int arg1) {
            return 0;
        }

        public void onEdgeTouched(int arg1, int arg2) {
        }

        public void onViewCaptured(View arg1, int arg2) {
        }

        public void onViewDragStateChanged(int arg1) {
        }

        public void onViewPositionChanged(View arg1, int arg2, int arg3, int arg4, int arg5) {
        }

        public void onViewReleased(View arg1, float arg2, float arg3) {
        }

        public abstract boolean tryCaptureView(View arg1, int arg2);
    }

    private static final int BASE_SETTLE_DURATION = 0x100;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private int mActivePointerId;
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    private static final Interpolator sInterpolator;

    static {
        ViewDragHelper.sInterpolator = new androidx.customview.widget.ViewDragHelper$1();
    }

    private ViewDragHelper(Context arg2, ViewGroup arg3, Callback arg4) {
        super();
        this.mActivePointerId = -1;
        this.mSetIdleRunnable = new androidx.customview.widget.ViewDragHelper$2(this);
        if(arg3 != null) {
            if(arg4 != null) {
                this.mParentView = arg3;
                this.mCallback = arg4;
                ViewConfiguration v3 = ViewConfiguration.get(arg2);
                int v4 = ((int)(arg2.getResources().getDisplayMetrics().density * 20f + 0.5f));
                this.mDefaultEdgeSize = v4;
                this.mEdgeSize = v4;
                this.mTouchSlop = v3.getScaledTouchSlop();
                this.mMaxVelocity = ((float)v3.getScaledMaximumFlingVelocity());
                this.mMinVelocity = ((float)v3.getScaledMinimumFlingVelocity());
                this.mScroller = new OverScroller(arg2, ViewDragHelper.sInterpolator);
                return;
            }

            throw new IllegalArgumentException("Callback may not be null");
        }

        throw new IllegalArgumentException("Parent view may not be null");
    }

    public void abort() {
        this.cancel();
        if(this.mDragState == 2) {
            int v0 = this.mScroller.getCurrX();
            int v1 = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int v5 = this.mScroller.getCurrX();
            int v6 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, v5, v6, v5 - v0, v6 - v1);
        }

        this.setDragState(0);
    }

    protected boolean canScroll(View arg13, boolean arg14, int arg15, int arg16, int arg17, int arg18) {
        if((arg13 instanceof ViewGroup)) {
            View v0 = arg13;
            int v2 = arg13.getScrollX();
            int v3 = arg13.getScrollY();
            int v4;
            for(v4 = ((ViewGroup)v0).getChildCount() - 1; v4 >= 0; --v4) {
                View v6 = ((ViewGroup)v0).getChildAt(v4);
                int v5 = arg17 + v2;
                if(v5 >= v6.getLeft() && v5 < v6.getRight()) {
                    int v7 = arg18 + v3;
                    if(v7 >= v6.getTop() && v7 < v6.getBottom() && (this.canScroll(v6, true, arg15, arg16, v5 - v6.getLeft(), v7 - v6.getTop()))) {
                        return 1;
                    }
                }
            }
        }

        if((arg14) && ((arg13.canScrollHorizontally(-arg15)) || (arg13.canScrollVertically(-arg16)))) {
            return 1;
        }

        return 0;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        this.clearMotionHistory();
        VelocityTracker v0 = this.mVelocityTracker;
        if(v0 != null) {
            v0.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(View arg3, int arg4) {
        if(arg3.getParent() == this.mParentView) {
            this.mCapturedView = arg3;
            this.mActivePointerId = arg4;
            this.mCallback.onViewCaptured(arg3, arg4);
            this.setDragState(1);
            return;
        }

        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper\'s tracked parent view (" + this.mParentView + ")");
    }

    private boolean checkNewEdgeDrag(float arg4, float arg5, int arg6, int arg7) {
        arg4 = Math.abs(arg4);
        arg5 = Math.abs(arg5);
        if((this.mInitialEdgesTouched[arg6] & arg7) == arg7 && (this.mTrackingEdges & arg7) != 0 && (this.mEdgeDragsLocked[arg6] & arg7) != arg7 && (this.mEdgeDragsInProgress[arg6] & arg7) != arg7) {
            int v0 = this.mTouchSlop;
            if(arg4 <= (((float)v0)) && arg5 <= (((float)v0))) {
                return 0;
            }

            if(arg4 < arg5 * 0.5f && (this.mCallback.onEdgeLock(arg7))) {
                this.mEdgeDragsLocked[arg6] |= arg7;
                return 0;
            }

            if((this.mEdgeDragsInProgress[arg6] & arg7) != 0) {
                return 0;
            }

            if(arg4 <= (((float)this.mTouchSlop))) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private boolean checkTouchSlop(View arg5, float arg6, float arg7) {
        if(arg5 == null) {
            return 0;
        }

        int v1 = this.mCallback.getViewHorizontalDragRange(arg5) > 0 ? 1 : 0;
        int v5 = this.mCallback.getViewVerticalDragRange(arg5) > 0 ? 1 : 0;
        if(v1 != 0 && v5 != 0) {
            if(arg6 * arg6 + arg7 * arg7 > (((float)(this.mTouchSlop * this.mTouchSlop)))) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(v1 != 0) {
            if(Math.abs(arg6) > (((float)this.mTouchSlop))) {
                return 1;
            }

            return 0;
        }

        if(v5 != 0 && Math.abs(arg7) > (((float)this.mTouchSlop))) {
            return 1;
        }

        return 0;
    }

    public boolean checkTouchSlop(int arg5) {
        int v0 = this.mInitialMotionX.length;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(this.checkTouchSlop(arg5, v2)) {
                return 1;
            }
        }

        return 0;
    }

    public boolean checkTouchSlop(int arg7, int arg8) {
        if(!this.isPointerDown(arg8)) {
            return 0;
        }

        int v0 = (arg7 & 1) == 1 ? 1 : 0;
        arg7 = (arg7 & 2) == 2 ? 1 : 0;
        float v3 = this.mLastMotionX[arg8] - this.mInitialMotionX[arg8];
        float v4 = this.mLastMotionY[arg8] - this.mInitialMotionY[arg8];
        if(v0 != 0 && arg7 != 0) {
            if(v3 * v3 + v4 * v4 > (((float)(this.mTouchSlop * this.mTouchSlop)))) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(v0 != 0) {
            if(Math.abs(v3) > (((float)this.mTouchSlop))) {
                return 1;
            }

            return 0;
        }

        if(arg7 != 0 && Math.abs(v4) > (((float)this.mTouchSlop))) {
            return 1;
        }

        return 0;
    }

    private float clampMag(float arg2, float arg3, float arg4) {
        float v1 = Math.abs(arg2);
        if(Float.compare(v1, arg3) < 0) {
            return 0;
        }

        if(v1 > arg4) {
            if(arg2 > 0f) {
                return arg4;
            }

            return -arg4;
        }

        return arg2;
    }

    private int clampMag(int arg1, int arg2, int arg3) {
        int v0 = Math.abs(arg1);
        if(v0 < arg2) {
            return 0;
        }

        if(v0 > arg3) {
            if(arg1 > 0) {
                return arg3;
            }

            return -arg3;
        }

        return arg1;
    }

    private void clearMotionHistory() {
        float[] v0 = this.mInitialMotionX;
        if(v0 == null) {
            return;
        }

        Arrays.fill(v0, 0f);
        Arrays.fill(this.mInitialMotionY, 0f);
        Arrays.fill(this.mLastMotionX, 0f);
        Arrays.fill(this.mLastMotionY, 0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private void clearMotionHistory(int arg3) {
        if(this.mInitialMotionX != null) {
            if(!this.isPointerDown(arg3)) {
            }
            else {
                this.mInitialMotionX[arg3] = 0f;
                this.mInitialMotionY[arg3] = 0f;
                this.mLastMotionX[arg3] = 0f;
                this.mLastMotionY[arg3] = 0f;
                this.mInitialEdgesTouched[arg3] = 0;
                this.mEdgeDragsInProgress[arg3] = 0;
                this.mEdgeDragsLocked[arg3] = 0;
                this.mPointersDown &= ~(1 << arg3);
            }
        }
    }

    private int computeAxisDuration(int arg4, int arg5, int arg6) {
        if(arg4 == 0) {
            return 0;
        }

        int v0 = this.mParentView.getWidth();
        int v1 = v0 / 2;
        float v2 = (((float)Math.abs(arg4))) / (((float)v0));
        float v0_1 = 1f;
        float v1_1 = ((float)v1);
        v1_1 += this.distanceInfluenceForSnapDuration(Math.min(v0_1, v2)) * v1_1;
        int v3 = Math.abs(arg5);
        v3 = v3 > 0 ? Math.round(Math.abs(v1_1 / (((float)v3))) * 1000f) * 4 : ((int)(((((float)Math.abs(arg4))) / (((float)arg6)) + v0_1) * 256f));
        return Math.min(v3, 600);
    }

    private int computeSettleDuration(View arg7, int arg8, int arg9, int arg10, int arg11) {
        float v1_1;
        float v2_1;
        float v0_1;
        arg10 = this.clampMag(arg10, ((int)this.mMinVelocity), ((int)this.mMaxVelocity));
        arg11 = this.clampMag(arg11, ((int)this.mMinVelocity), ((int)this.mMaxVelocity));
        int v0 = Math.abs(arg8);
        int v1 = Math.abs(arg9);
        int v2 = Math.abs(arg10);
        int v3 = Math.abs(arg11);
        int v4 = v2 + v3;
        int v5 = v0 + v1;
        if(arg10 != 0) {
            v0_1 = ((float)v2);
            v2_1 = ((float)v4);
        }
        else {
            v0_1 = ((float)v0);
            v2_1 = ((float)v5);
        }

        v0_1 /= v2_1;
        if(arg11 != 0) {
            v1_1 = ((float)v3);
            v2_1 = ((float)v4);
        }
        else {
            v1_1 = ((float)v1);
            v2_1 = ((float)v5);
        }

        return ((int)((((float)this.computeAxisDuration(arg8, arg10, this.mCallback.getViewHorizontalDragRange(arg7)))) * v0_1 + (((float)this.computeAxisDuration(arg9, arg11, this.mCallback.getViewVerticalDragRange(arg7)))) * (v1_1 / v2_1)));
    }

    public boolean continueSettling(boolean arg11) {
        int v2 = 2;
        if(this.mDragState == v2) {
            boolean v0 = this.mScroller.computeScrollOffset();
            int v6 = this.mScroller.getCurrX();
            int v7 = this.mScroller.getCurrY();
            int v8 = v6 - this.mCapturedView.getLeft();
            int v9 = v7 - this.mCapturedView.getTop();
            if(v8 != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, v8);
            }

            if(v9 != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, v9);
            }

            if(v8 != 0 || v9 != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, v6, v7, v8, v9);
            }

            if((v0) && v6 == this.mScroller.getFinalX() && v7 == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                v0 = false;
            }

            if(v0) {
                goto label_44;
            }

            if(arg11) {
                this.mParentView.post(this.mSetIdleRunnable);
                goto label_44;
            }

            this.setDragState(0);
        }

    label_44:
        if(this.mDragState == v2) {
            return 1;
        }

        return 0;
    }

    public static ViewDragHelper create(ViewGroup arg1, float arg2, Callback arg3) {
        ViewDragHelper v1 = ViewDragHelper.create(arg1, arg3);
        v1.mTouchSlop = ((int)((((float)v1.mTouchSlop)) * (1f / arg2)));
        return v1;
    }

    public static ViewDragHelper create(ViewGroup arg2, Callback arg3) {
        return new ViewDragHelper(arg2.getContext(), arg2, arg3);
    }

    private void dispatchViewReleased(float arg4, float arg5) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, arg4, arg5);
        this.mReleaseInProgress = false;
        if(this.mDragState == 1) {
            this.setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float arg1) {
        return ((float)Math.sin(((double)((arg1 - 0.5f) * 0.471239f))));
    }

    private void dragTo(int arg11, int arg12, int arg13, int arg14) {
        int v0 = this.mCapturedView.getLeft();
        int v1 = this.mCapturedView.getTop();
        if(arg13 != 0) {
            arg11 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, arg11, arg13);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, arg11 - v0);
        }

        int v6 = arg11;
        if(arg14 != 0) {
            arg12 = this.mCallback.clampViewPositionVertical(this.mCapturedView, arg12, arg14);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, arg12 - v1);
        }

        int v7 = arg12;
        if(arg13 == 0) {
            if(arg14 != 0) {
            }
            else {
                return;
            }
        }

        this.mCallback.onViewPositionChanged(this.mCapturedView, v6, v7, v6 - v0, v7 - v1);
    }

    private void ensureMotionHistorySizeForId(int arg10) {
        float[] v0 = this.mInitialMotionX;
        if(v0 != null) {
            if(v0.length <= arg10) {
            }
            else {
                return;
            }
        }

        ++arg10;
        float[] v1 = new float[arg10];
        float[] v2 = new float[arg10];
        float[] v3 = new float[arg10];
        float[] v4 = new float[arg10];
        int[] v5 = new int[arg10];
        int[] v6 = new int[arg10];
        int[] v10 = new int[arg10];
        if(v0 != null) {
            System.arraycopy(v0, 0, v1, 0, v0.length);
            System.arraycopy(this.mInitialMotionY, 0, v2, 0, this.mInitialMotionY.length);
            System.arraycopy(this.mLastMotionX, 0, v3, 0, this.mLastMotionX.length);
            System.arraycopy(this.mLastMotionY, 0, v4, 0, this.mLastMotionY.length);
            System.arraycopy(this.mInitialEdgesTouched, 0, v5, 0, this.mInitialEdgesTouched.length);
            System.arraycopy(this.mEdgeDragsInProgress, 0, v6, 0, this.mEdgeDragsInProgress.length);
            System.arraycopy(this.mEdgeDragsLocked, 0, v10, 0, this.mEdgeDragsLocked.length);
        }

        this.mInitialMotionX = v1;
        this.mInitialMotionY = v2;
        this.mLastMotionX = v3;
        this.mLastMotionY = v4;
        this.mInitialEdgesTouched = v5;
        this.mEdgeDragsInProgress = v6;
        this.mEdgeDragsLocked = v10;
    }

    public View findTopChildUnder(int arg4, int arg5) {
        int v0;
        for(v0 = this.mParentView.getChildCount() - 1; v0 >= 0; --v0) {
            View v1 = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(v0));
            if(arg4 >= v1.getLeft() && arg4 < v1.getRight() && arg5 >= v1.getTop() && arg5 < v1.getBottom()) {
                return v1;
            }
        }

        return null;
    }

    public void flingCapturedView(int arg11, int arg12, int arg13, int arg14) {
        if(this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), ((int)this.mVelocityTracker.getXVelocity(this.mActivePointerId)), ((int)this.mVelocityTracker.getYVelocity(this.mActivePointerId)), arg11, arg13, arg12, arg14);
            this.setDragState(2);
            return;
        }

        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    private boolean forceSettleCapturedViewAt(int arg11, int arg12, int arg13, int arg14) {
        int v2 = this.mCapturedView.getLeft();
        int v3 = this.mCapturedView.getTop();
        int v4 = arg11 - v2;
        int v5 = arg12 - v3;
        if(v4 == 0 && v5 == 0) {
            this.mScroller.abortAnimation();
            this.setDragState(0);
            return 0;
        }

        this.mScroller.startScroll(v2, v3, v4, v5, this.computeSettleDuration(this.mCapturedView, v4, v5, arg13, arg14));
        this.setDragState(2);
        return 1;
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    private int getEdgesTouched(int arg4, int arg5) {
        int v0 = arg4 < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if(arg5 < this.mParentView.getTop() + this.mEdgeSize) {
            v0 |= 4;
        }

        if(arg4 > this.mParentView.getRight() - this.mEdgeSize) {
            v0 |= 2;
        }

        if(arg5 > this.mParentView.getBottom() - this.mEdgeSize) {
            return v0 | 8;
        }

        return v0;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int arg2, int arg3) {
        return this.isViewUnder(this.mCapturedView, arg2, arg3);
    }

    public boolean isEdgeTouched(int arg5) {
        int v0 = this.mInitialEdgesTouched.length;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(this.isEdgeTouched(arg5, v2)) {
                return 1;
            }
        }

        return 0;
    }

    public boolean isEdgeTouched(int arg2, int arg3) {
        if((this.isPointerDown(arg3)) && (this.mInitialEdgesTouched[arg3] & arg2) != 0) {
            return 1;
        }

        return 0;
    }

    public boolean isPointerDown(int arg2) {
        if((this.mPointersDown & 1 << arg2) != 0) {
            return 1;
        }

        return 0;
    }

    private boolean isValidPointerForActionMove(int arg2) {
        if(!this.isPointerDown(arg2)) {
            Log.e("ViewDragHelper", "Ignoring pointerId=" + arg2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return 0;
        }

        return 1;
    }

    public boolean isViewUnder(View arg2, int arg3, int arg4) {
        boolean v1 = false;
        if(arg2 == null) {
            return 0;
        }

        if(arg3 >= arg2.getLeft() && arg3 < arg2.getRight() && arg4 >= arg2.getTop() && arg4 < arg2.getBottom()) {
            v1 = true;
        }

        return v1;
    }

    public void processTouchEvent(MotionEvent arg10) {
        int v10;
        int v3;
        float v0_1;
        float v1_1;
        int v0 = arg10.getActionMasked();
        int v1 = arg10.getActionIndex();
        if(v0 == 0) {
            this.cancel();
        }

        VelocityTracker v2 = this.mVelocityTracker;
        if(v2 == null) {
            v2 = VelocityTracker.obtain();
            this.mVelocityTracker = v2;
        }

        v2.addMovement(arg10);
        int v2_1 = 0;
        if(v0 == 0) {
            v0_1 = arg10.getX();
            v1_1 = arg10.getY();
            v10 = arg10.getPointerId(0);
            View v2_4 = this.findTopChildUnder(((int)v0_1), ((int)v1_1));
            this.saveInitialMotion(v0_1, v1_1, v10);
            this.tryCaptureViewForDrag(v2_4, v10);
            v0 = this.mInitialEdgesTouched[v10];
            v1 = this.mTrackingEdges;
            if((v0 & v1) == 0) {
                return;
            }

            this.mCallback.onEdgeTouched(v0 & v1, v10);
        }
        else if(v0 == 1) {
            if(this.mDragState == 1) {
                this.releaseViewForPointerUp();
            }

            this.cancel();
            return;
        }
        else if(v0 == 2) {
            if(this.mDragState == 1) {
                if(!this.isValidPointerForActionMove(this.mActivePointerId)) {
                    return;
                }

                v0 = arg10.findPointerIndex(this.mActivePointerId);
                v1_1 = arg10.getX(v0);
                v0_1 = arg10.getY(v0);
                float[] v2_3 = this.mLastMotionX;
                v3 = this.mActivePointerId;
                v1 = ((int)(v1_1 - v2_3[v3]));
                v0 = ((int)(v0_1 - this.mLastMotionY[v3]));
                this.dragTo(this.mCapturedView.getLeft() + v1, this.mCapturedView.getTop() + v0, v1, v0);
                this.saveLastMotion(arg10);
                return;
            }

            v0 = arg10.getPointerCount();
            while(v2_1 < v0) {
                v1 = arg10.getPointerId(v2_1);
                if(!this.isValidPointerForActionMove(v1)) {
                }
                else {
                    float v4_1 = arg10.getX(v2_1);
                    float v5_1 = arg10.getY(v2_1);
                    float v6_1 = v4_1 - this.mInitialMotionX[v1];
                    float v7 = v5_1 - this.mInitialMotionY[v1];
                    this.reportNewEdgeDrags(v6_1, v7, v1);
                    if(this.mDragState == 1) {
                        break;
                    }
                    else {
                        View v4_2 = this.findTopChildUnder(((int)v4_1), ((int)v5_1));
                        if((this.checkTouchSlop(v4_2, v6_1, v7)) && (this.tryCaptureViewForDrag(v4_2, v1))) {
                            break;
                        }
                    }
                }

                ++v2_1;
            }

            this.saveLastMotion(arg10);
            return;
        }
        else if(v0 == 3) {
            if(this.mDragState == 1) {
                this.dispatchViewReleased(0f, 0f);
            }

            this.cancel();
            return;
        }
        else if(v0 == 5) {
            v0 = arg10.getPointerId(v1);
            float v2_2 = arg10.getX(v1);
            float v10_1 = arg10.getY(v1);
            this.saveInitialMotion(v2_2, v10_1, v0);
            if(this.mDragState == 0) {
                this.tryCaptureViewForDrag(this.findTopChildUnder(((int)v2_2), ((int)v10_1)), v0);
                v10 = this.mInitialEdgesTouched[v0];
                v1 = this.mTrackingEdges;
                if((v10 & v1) == 0) {
                    return;
                }

                this.mCallback.onEdgeTouched(v10 & v1, v0);
                return;
            }

            if(!this.isCapturedViewUnder(((int)v2_2), ((int)v10_1))) {
                return;
            }

            this.tryCaptureViewForDrag(this.mCapturedView, v0);
            return;
        }
        else if(v0 != 6) {
        }
        else {
            v0 = arg10.getPointerId(v1);
            if(this.mDragState == 1 && v0 == this.mActivePointerId) {
                v1 = arg10.getPointerCount();
                while(true) {
                    v3 = -1;
                    if(v2_1 >= v1) {
                        break;
                    }

                    int v4 = arg10.getPointerId(v2_1);
                    if(v4 == this.mActivePointerId) {
                    }
                    else {
                        View v5 = this.findTopChildUnder(((int)arg10.getX(v2_1)), ((int)arg10.getY(v2_1)));
                        View v6 = this.mCapturedView;
                        if(v5 == v6 && (this.tryCaptureViewForDrag(v6, v4))) {
                            v10 = this.mActivePointerId;
                            goto label_48;
                        }
                    }

                    ++v2_1;
                }

                v10 = v3;
            label_48:
                if(v10 != v3) {
                    goto label_50;
                }

                this.releaseViewForPointerUp();
            }

        label_50:
            this.clearMotionHistory(v0);
            return;
        }
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        this.dispatchViewReleased(this.clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), this.clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float arg3, float arg4, int arg5) {
        int v0_1;
        boolean v0 = this.checkNewEdgeDrag(arg3, arg4, arg5, 1);
        if(this.checkNewEdgeDrag(arg4, arg3, arg5, 4)) {
            v0_1 = (((int)v0)) | 4;
        }

        if(this.checkNewEdgeDrag(arg3, arg4, arg5, 2)) {
            v0_1 = (((int)v0)) | 2;
        }

        if(this.checkNewEdgeDrag(arg4, arg3, arg5, 8)) {
            v0_1 = (((int)v0)) | 8;
        }

        if(v0) {
            this.mEdgeDragsInProgress[arg5] |= ((int)v0);
            this.mCallback.onEdgeDragStarted(((int)v0), arg5);
        }
    }

    private void saveInitialMotion(float arg3, float arg4, int arg5) {
        this.ensureMotionHistorySizeForId(arg5);
        float[] v0 = this.mInitialMotionX;
        this.mLastMotionX[arg5] = arg3;
        v0[arg5] = arg3;
        v0 = this.mInitialMotionY;
        this.mLastMotionY[arg5] = arg4;
        v0[arg5] = arg4;
        this.mInitialEdgesTouched[arg5] = this.getEdgesTouched(((int)arg3), ((int)arg4));
        this.mPointersDown |= 1 << arg5;
    }

    private void saveLastMotion(MotionEvent arg7) {
        int v0 = arg7.getPointerCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            int v2 = arg7.getPointerId(v1);
            if(!this.isValidPointerForActionMove(v2)) {
            }
            else {
                float v3 = arg7.getX(v1);
                float v4 = arg7.getY(v1);
                this.mLastMotionX[v2] = v3;
                this.mLastMotionY[v2] = v4;
            }
        }
    }

    void setDragState(int arg3) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if(this.mDragState != arg3) {
            this.mDragState = arg3;
            this.mCallback.onViewDragStateChanged(arg3);
            if(this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(int arg1) {
        this.mEdgeSize = arg1;
    }

    public void setEdgeTrackingEnabled(int arg1) {
        this.mTrackingEdges = arg1;
    }

    public void setMinVelocity(float arg1) {
        this.mMinVelocity = arg1;
    }

    public boolean settleCapturedViewAt(int arg4, int arg5) {
        if(this.mReleaseInProgress) {
            return this.forceSettleCapturedViewAt(arg4, arg5, ((int)this.mVelocityTracker.getXVelocity(this.mActivePointerId)), ((int)this.mVelocityTracker.getYVelocity(this.mActivePointerId)));
        }

        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean shouldInterceptTouchEvent(MotionEvent arg18) {
        int v1_2;
        float v7;
        ViewDragHelper v0 = this;
        MotionEvent v1 = arg18;
        int v2 = v1.getActionMasked();
        int v3 = v1.getActionIndex();
        if(v2 == 0) {
            v0.cancel();
        }

        VelocityTracker v4 = v0.mVelocityTracker;
        if(v4 == null) {
            v4 = VelocityTracker.obtain();
            v0.mVelocityTracker = v4;
        }

        v4.addMovement(v1);
        int v4_1 = 2;
        if(v2 != 0) {
            if(v2 != 1) {
                if(v2 == v4_1) {
                    if(v0.mInitialMotionX == null) {
                    }
                    else if(v0.mInitialMotionY == null) {
                    }
                    else {
                        v2 = v1.getPointerCount();
                        for(v3 = 0; v3 < v2; ++v3) {
                            v4_1 = v1.getPointerId(v3);
                            if(!v0.isValidPointerForActionMove(v4_1)) {
                            }
                            else {
                                v7 = v1.getX(v3);
                                float v8 = v1.getY(v3);
                                float v9 = v7 - v0.mInitialMotionX[v4_1];
                                float v10 = v8 - v0.mInitialMotionY[v4_1];
                                View v7_1 = v0.findTopChildUnder(((int)v7), ((int)v8));
                                int v8_1 = v7_1 == null || !v0.checkTouchSlop(v7_1, v9, v10) ? 0 : 1;
                                if(v8_1 != 0) {
                                    int v11 = v7_1.getLeft();
                                    int v12 = ((int)v9);
                                    v12 = v0.mCallback.clampViewPositionHorizontal(v7_1, v11 + v12, v12);
                                    int v13 = v7_1.getTop();
                                    int v14 = ((int)v10);
                                    int v5 = v0.mCallback.clampViewPositionVertical(v7_1, v13 + v14, v14);
                                    v14 = v0.mCallback.getViewHorizontalDragRange(v7_1);
                                    int v15 = v0.mCallback.getViewVerticalDragRange(v7_1);
                                    if(v14 != 0) {
                                        if(v14 <= 0) {
                                        }
                                        else if(v12 == v11) {
                                            goto label_96;
                                        }

                                        goto label_100;
                                    }

                                label_96:
                                    if(v15 == 0) {
                                        break;
                                    }

                                    if(v15 <= 0) {
                                        goto label_100;
                                    }

                                    if(v5 != v13) {
                                        goto label_100;
                                    }

                                    break;
                                }

                            label_100:
                                v0.reportNewEdgeDrags(v9, v10, v4_1);
                                if(v0.mDragState == 1) {
                                    break;
                                }

                                if(v8_1 == 0) {
                                    goto label_108;
                                }

                                if(!v0.tryCaptureViewForDrag(v7_1, v4_1)) {
                                    goto label_108;
                                }

                                break;
                            }

                        label_108:
                        }

                        this.saveLastMotion(arg18);
                    }

                    goto label_135;
                }
                else if(v2 != 3) {
                    if(v2 == 5) {
                        v2 = v1.getPointerId(v3);
                        v7 = v1.getX(v3);
                        float v1_1 = v1.getY(v3);
                        v0.saveInitialMotion(v7, v1_1, v2);
                        v3 = v0.mDragState;
                        if(v3 == 0) {
                            v1_2 = v0.mInitialEdgesTouched[v2];
                            v3 = v0.mTrackingEdges;
                            if((v1_2 & v3) != 0) {
                                v0.mCallback.onEdgeTouched(v1_2 & v3, v2);
                            }
                            else {
                            }
                        }
                        else if(v3 == v4_1) {
                            View v1_3 = v0.findTopChildUnder(((int)v7), ((int)v1_1));
                            if(v1_3 == v0.mCapturedView) {
                                v0.tryCaptureViewForDrag(v1_3, v2);
                            }
                            else {
                            }
                        }
                        else {
                        }
                    }
                    else if(v2 != 6) {
                    }
                    else {
                        v0.clearMotionHistory(v1.getPointerId(v3));
                    }

                    goto label_135;
                }
            }

            v0.cancel();
        }
        else {
            float v2_1 = v1.getX();
            float v3_1 = v1.getY();
            v1_2 = v1.getPointerId(0);
            v0.saveInitialMotion(v2_1, v3_1, v1_2);
            View v2_2 = v0.findTopChildUnder(((int)v2_1), ((int)v3_1));
            if(v2_2 == v0.mCapturedView && v0.mDragState == v4_1) {
                v0.tryCaptureViewForDrag(v2_2, v1_2);
            }

            v2 = v0.mInitialEdgesTouched[v1_2];
            v3 = v0.mTrackingEdges;
            if((v2 & v3) == 0) {
                goto label_135;
            }

            v0.mCallback.onEdgeTouched(v2 & v3, v1_2);
        }

    label_135:
        if(v0.mDragState == 1) {
            return 1;
        }

        return 0;
    }

    public boolean smoothSlideViewTo(View arg1, int arg2, int arg3) {
        this.mCapturedView = arg1;
        this.mActivePointerId = -1;
        boolean v1 = this.forceSettleCapturedViewAt(arg2, arg3, 0, 0);
        if(!v1 && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }

        return v1;
    }

    boolean tryCaptureViewForDrag(View arg3, int arg4) {
        if(arg3 == this.mCapturedView && this.mActivePointerId == arg4) {
            return 1;
        }

        if(arg3 != null && (this.mCallback.tryCaptureView(arg3, arg4))) {
            this.mActivePointerId = arg4;
            this.captureChildView(arg3, arg4);
            return 1;
        }

        return 0;
    }
}

