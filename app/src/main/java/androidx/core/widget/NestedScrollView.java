package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View$BaseSavedState;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.R$attr;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollFeedbackProviderCompat;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView extends FrameLayout implements NestedScrollingChild3, NestedScrollingParent3, ScrollingView {
    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
            super();
        }

        public void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
            super.onInitializeAccessibilityEvent(arg1, arg2);
            arg2.setClassName(ScrollView.class.getName());
            boolean v0 = ((NestedScrollView)arg1).getScrollRange() > 0 ? true : false;
            arg2.setScrollable(v0);
            arg2.setScrollX(((NestedScrollView)arg1).getScrollX());
            arg2.setScrollY(((NestedScrollView)arg1).getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(((AccessibilityRecord)arg2), ((NestedScrollView)arg1).getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(((AccessibilityRecord)arg2), ((NestedScrollView)arg1).getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
            super.onInitializeAccessibilityNodeInfo(arg2, arg3);
            arg3.setClassName(ScrollView.class.getName());
            if(((NestedScrollView)arg2).isEnabled()) {
                int v1 = ((NestedScrollView)arg2).getScrollRange();
                if(v1 > 0) {
                    arg3.setScrollable(true);
                    if(((NestedScrollView)arg2).getScrollY() > 0) {
                        arg3.addAction(AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                        arg3.addAction(AccessibilityActionCompat.ACTION_SCROLL_UP);
                    }

                    if(((NestedScrollView)arg2).getScrollY() >= v1) {
                        return;
                    }

                    arg3.addAction(AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    arg3.addAction(AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
            }
        }

        public boolean performAccessibilityAction(View arg4, int arg5, Bundle arg6) {
            if(super.performAccessibilityAction(arg4, arg5, arg6)) {
                return 1;
            }

            if(!((NestedScrollView)arg4).isEnabled()) {
                return 0;
            }

            int v3 = ((NestedScrollView)arg4).getHeight();
            Rect v1 = new Rect();
            if((((NestedScrollView)arg4).getMatrix().isIdentity()) && (((NestedScrollView)arg4).getGlobalVisibleRect(v1))) {
                v3 = v1.height();
            }

            if(arg5 != 0x1000) {
                if(arg5 != 0x2000 && arg5 != 0x1020038) {
                    if(arg5 != 0x102003A) {
                        return 0;
                    }
                    else {
                        goto label_38;
                    }
                }

                v3 = Math.max(((NestedScrollView)arg4).getScrollY() - (v3 - ((NestedScrollView)arg4).getPaddingBottom() - ((NestedScrollView)arg4).getPaddingTop()), 0);
                if(v3 != ((NestedScrollView)arg4).getScrollY()) {
                    ((NestedScrollView)arg4).smoothScrollTo(0, v3, true);
                    return 1;
                }

                return 0;
            }

        label_38:
            v3 = Math.min(((NestedScrollView)arg4).getScrollY() + (v3 - ((NestedScrollView)arg4).getPaddingBottom() - ((NestedScrollView)arg4).getPaddingTop()), ((NestedScrollView)arg4).getScrollRange());
            if(v3 != ((NestedScrollView)arg4).getScrollY()) {
                ((NestedScrollView)arg4).smoothScrollTo(0, v3, true);
                return 1;
            }

            return 0;
        }
    }

    final class Api35Impl {
        private Api35Impl() {
            super();
        }

        public static void setFrameContentVelocity(View arg0, float arg1) {
            try {
                arg0.setFrameContentVelocity(arg1);
                return;
            }
            catch(LinkageError ) {
                return;
            }
        }
    }

    class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {
        DifferentialMotionFlingTargetImpl(NestedScrollView arg1) {
            NestedScrollView.this = arg1;
            super();
        }

        public float getScaledScrollFactor() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        public boolean startDifferentialMotionFling(float arg2) {
            if(arg2 == 0f) {
                return 0;
            }

            this.stopDifferentialMotionFling();
            NestedScrollView.this.fling(((int)arg2));
            return 1;
        }

        public void stopDifferentialMotionFling() {
            NestedScrollView.-$$Nest$fgetmScroller(NestedScrollView.this).abortAnimation();
        }
    }

    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView arg1, int arg2, int arg3, int arg4, int arg5);
    }

    class SavedState extends View$BaseSavedState {
        class androidx.core.widget.NestedScrollView$SavedState$1 implements Parcelable$Creator {
            androidx.core.widget.NestedScrollView$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg1) {
                return new SavedState(arg1);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        public int scrollPosition;

        static {
            SavedState.CREATOR = new androidx.core.widget.NestedScrollView$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg1) {
            super(arg1);
            this.scrollPosition = arg1.readInt();
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeInt(this.scrollPosition);
        }
    }

    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = null;
    static final int ANIMATED_SCROLL_GAP = 0xFA;
    private static final float DECELERATION_RATE = 0f;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 0xFA;
    private static final float FLING_DESTRETCH_FACTOR = 4f;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = null;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    DifferentialMotionFlingController mDifferentialMotionFlingController;
    final DifferentialMotionFlingTargetImpl mDifferentialMotionFlingTarget;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    ScrollFeedbackProviderCompat mScrollFeedbackProvider;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    static OverScroller -$$Nest$fgetmScroller(NestedScrollView arg0) {
        return arg0.mScroller;
    }

    static {
        NestedScrollView.DECELERATION_RATE = ((float)(Math.log(0.78) / Math.log(0.9)));
        NestedScrollView.ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
        NestedScrollView.SCROLLVIEW_STYLEABLE = new int[]{0x101017A};
    }

    public NestedScrollView(Context arg2) {
        this(arg2, null);
    }

    public NestedScrollView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.nestedScrollViewStyle);
    }

    public NestedScrollView(Context arg6, AttributeSet arg7, int arg8) {
        super(arg6, arg7, arg8);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        DifferentialMotionFlingTargetImpl v2 = new DifferentialMotionFlingTargetImpl(this);
        this.mDifferentialMotionFlingTarget = v2;
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(this.getContext(), ((DifferentialMotionFlingTarget)v2));
        this.mEdgeGlowTop = EdgeEffectCompat.create(arg6, arg7);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(arg6, arg7);
        this.mPhysicalCoeff = arg6.getResources().getDisplayMetrics().density * 160f * 386.087799f * 0.84f;
        this.initScrollView();
        TypedArray v6 = arg6.obtainStyledAttributes(arg7, NestedScrollView.SCROLLVIEW_STYLEABLE, arg8, 0);
        this.setFillViewport(v6.getBoolean(0, false));
        v6.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(((ViewGroup)this));
        this.mChildHelper = new NestedScrollingChildHelper(((View)this));
        this.setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(((View)this), NestedScrollView.ACCESSIBILITY_DELEGATE);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        this.stopNestedScroll(1);
    }

    public void addView(View arg2) {
        if(this.getChildCount() <= 0) {
            super.addView(arg2);
            return;
        }

        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View arg2, int arg3) {
        if(this.getChildCount() <= 0) {
            super.addView(arg2, arg3);
            return;
        }

        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View arg2, int arg3, ViewGroup$LayoutParams arg4) {
        if(this.getChildCount() <= 0) {
            super.addView(arg2, arg3, arg4);
            return;
        }

        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View arg2, ViewGroup$LayoutParams arg3) {
        if(this.getChildCount() <= 0) {
            super.addView(arg2, arg3);
            return;
        }

        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int arg9) {
        View v0 = this.findFocus();
        if((((NestedScrollView)v0)) == this) {
            v0 = null;
        }

        View v1 = FocusFinder.getInstance().findNextFocus(((ViewGroup)this), v0, arg9);
        int v2 = this.getMaxScrollAmount();
        if(v1 == null || !this.isWithinDeltaOfScreen(v1, v2, this.getHeight())) {
            int v5 = 130;
            if(arg9 == 33 && this.getScrollY() < v2) {
                v2 = this.getScrollY();
            }
            else if(arg9 == v5 && this.getChildCount() > 0) {
                v1 = this.getChildAt(0);
                v2 = Math.min(v1.getBottom() + v1.getLayoutParams().bottomMargin - (this.getScrollY() + this.getHeight() - this.getPaddingBottom()), v2);
            }

            if(v2 == 0) {
                return 0;
            }

            if(arg9 == v5) {
            }
            else {
                v2 = -v2;
            }

            this.scrollBy(v2, 0, 1, true);
        }
        else {
            v1.getDrawingRect(this.mTempRect);
            this.offsetDescendantRectToMyCoords(v1, this.mTempRect);
            this.scrollBy(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
            v1.requestFocus(arg9);
        }

        if(v0 != null && (v0.isFocused()) && (this.isOffScreen(v0))) {
            arg9 = this.getDescendantFocusability();
            this.setDescendantFocusability(0x20000);
            this.requestFocus();
            this.setDescendantFocusability(arg9);
        }

        return 1;
    }

    private boolean canOverScroll() {
        int v0 = this.getOverScrollMode();
        if(v0 != 0 && (v0 != 1 || this.getScrollRange() <= 0)) {
            return 0;
        }

        return 1;
    }

    private boolean canScroll() {
        if(this.getChildCount() > 0) {
            View v0 = this.getChildAt(0);
            ViewGroup$LayoutParams v2 = v0.getLayoutParams();
            if(v0.getHeight() + ((FrameLayout$LayoutParams)v2).topMargin + ((FrameLayout$LayoutParams)v2).bottomMargin > this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()) {
                return 1;
            }
        }

        return 0;
    }

    private static int clamp(int arg1, int arg2, int arg3) {
        if(arg2 < arg3) {
            if(arg1 < 0) {
            }
            else if(arg2 + arg1 > arg3) {
                return arg3 - arg2;
            }
            else {
                return arg1;
            }
        }

        return 0;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        int v8;
        if(this.mScroller.isFinished()) {
            return;
        }

        this.mScroller.computeScrollOffset();
        int v1 = this.mScroller.getCurrY();
        int v2 = this.consumeFlingInVerticalStretch(v1 - this.mLastScrollerY);
        this.mLastScrollerY = v1;
        int[] v3 = this.mScrollConsumed;
        v3[1] = 0;
        this.dispatchNestedPreScroll(0, v2, v3, null, 1);
        v2 -= this.mScrollConsumed[1];
        int v6 = this.getScrollRange();
        if(Build$VERSION.SDK_INT >= 35) {
            Api35Impl.setFrameContentVelocity(((View)this), Math.abs(this.mScroller.getCurrVelocity()));
        }

        if(v2 != 0) {
            int v4 = this.getScrollY();
            this.overScrollByCompat(0, v2, this.getScrollX(), v4, 0, v6, 0, 0, false);
            v8 = v6;
            v1 = this.getScrollY() - v4;
            v4 = v2 - v1;
            int[] v7 = this.mScrollConsumed;
            v7[1] = 0;
            this.dispatchNestedScroll(0, v1, 0, v4, this.mScrollOffset, 1, v7);
            v2 = v4 - this.mScrollConsumed[1];
        }
        else {
            v8 = v6;
        }

        if(v2 != 0) {
            v1 = this.getOverScrollMode();
            if(v1 == 0 || v1 == 1 && v8 > 0) {
                if(v2 < 0) {
                    if(this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb(((int)this.mScroller.getCurrVelocity()));
                    }
                }
                else if(this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb(((int)this.mScroller.getCurrVelocity()));
                }
            }

            this.abortAnimatedScroll();
        }

        if(!this.mScroller.isFinished()) {
            this.postInvalidateOnAnimation();
            return;
        }

        this.stopNestedScroll(1);
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect arg11) {
        if(this.getChildCount() == 0) {
            return 0;
        }

        int v0 = this.getHeight();
        int v2 = this.getScrollY();
        int v3 = v2 + v0;
        int v4 = this.getVerticalFadingEdgeLength();
        if(arg11.top > 0) {
            v2 += v4;
        }

        View v5 = this.getChildAt(0);
        ViewGroup$LayoutParams v6 = v5.getLayoutParams();
        v4 = arg11.bottom < v5.getHeight() + ((FrameLayout$LayoutParams)v6).topMargin + ((FrameLayout$LayoutParams)v6).bottomMargin ? v3 - v4 : v3;
        if(arg11.bottom > v4 && arg11.top > v2) {
            int v10 = arg11.height() > v0 ? arg11.top - v2 : arg11.bottom - v4;
            return Math.min(v10, v5.getBottom() + ((FrameLayout$LayoutParams)v6).bottomMargin - v3);
        }

        if(arg11.top < v2 && arg11.bottom < v4) {
            int v1 = arg11.height() > v0 ? -(v4 - arg11.bottom) : -(v2 - arg11.top);
            return Math.max(v1, -this.getScrollY());
        }

        return 0;
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int v0 = this.getChildCount();
        int v1 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if(v0 == 0) {
            return v1;
        }

        View v2 = this.getChildAt(0);
        int v2_1 = v2.getBottom() + v2.getLayoutParams().bottomMargin;
        int v4 = this.getScrollY();
        v0 = Math.max(0, v2_1 - v1);
        if(v4 < 0) {
            return v2_1 - v4;
        }

        if(v4 > v0) {
            v2_1 += v4 - v0;
        }

        return v2_1;
    }

    int consumeFlingInVerticalStretch(int arg6) {
        int v0 = this.getHeight();
        float v1 = 0.5f;
        float v3 = 4f;
        if(arg6 > 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0f) {
            v0 = Math.round((((float)(-v0))) / v3 * EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (((float)(-arg6))) * v3 / (((float)v0)), v1));
            if(v0 != arg6) {
                this.mEdgeGlowTop.finish();
            }

            return arg6 - v0;
        }

        if(arg6 < 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0f) {
            float v0_1 = ((float)v0);
            v0 = Math.round(v0_1 / v3 * EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (((float)arg6)) * v3 / v0_1, v1));
            if(v0 != arg6) {
                this.mEdgeGlowBottom.finish();
            }

            arg6 -= v0;
        }

        return arg6;
    }

    public boolean dispatchKeyEvent(KeyEvent arg2) {
        if(!super.dispatchKeyEvent(arg2)) {
            if(this.executeKeyEvent(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean dispatchNestedFling(float arg1, float arg2, boolean arg3) {
        return this.mChildHelper.dispatchNestedFling(arg1, arg2, arg3);
    }

    public boolean dispatchNestedPreFling(float arg1, float arg2) {
        return this.mChildHelper.dispatchNestedPreFling(arg1, arg2);
    }

    public boolean dispatchNestedPreScroll(int arg1, int arg2, int[] arg3, int[] arg4, int arg5) {
        return this.mChildHelper.dispatchNestedPreScroll(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean dispatchNestedPreScroll(int arg7, int arg8, int[] arg9, int[] arg10) {
        return this.dispatchNestedPreScroll(arg7, arg8, arg9, arg10, 0);
    }

    public void dispatchNestedScroll(int arg1, int arg2, int arg3, int arg4, int[] arg5, int arg6, int[] arg7) {
        this.mChildHelper.dispatchNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean dispatchNestedScroll(int arg1, int arg2, int arg3, int arg4, int[] arg5) {
        return this.mChildHelper.dispatchNestedScroll(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean dispatchNestedScroll(int arg1, int arg2, int arg3, int arg4, int[] arg5, int arg6) {
        return this.mChildHelper.dispatchNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private void doScrollY(int arg3) {
        if(arg3 != 0) {
            if(this.mSmoothScrollingEnabled) {
                this.smoothScrollBy(0, arg3);
                return;
            }
            else {
                this.scrollBy(0, arg3);
            }
        }
    }

    public void draw(Canvas arg10) {
        int v6;
        int v4;
        int v3;
        int v1;
        super.draw(arg10);
        int v0 = this.getScrollY();
        int v2 = 0;
        if(!this.mEdgeGlowTop.isFinished()) {
            v1 = arg10.save();
            v3 = this.getWidth();
            v4 = this.getHeight();
            int v5 = Math.min(0, v0);
            if(this.getClipToPadding()) {
                v3 -= this.getPaddingLeft() + this.getPaddingRight();
                v6 = this.getPaddingLeft();
                v4 -= this.getPaddingTop() + this.getPaddingBottom();
                v5 += this.getPaddingTop();
            }
            else {
                v6 = 0;
            }

            arg10.translate(((float)v6), ((float)v5));
            this.mEdgeGlowTop.setSize(v3, v4);
            if(this.mEdgeGlowTop.draw(arg10)) {
                this.postInvalidateOnAnimation();
            }

            arg10.restoreToCount(v1);
        }

        if(!this.mEdgeGlowBottom.isFinished()) {
            v1 = arg10.save();
            v3 = this.getWidth();
            v4 = this.getHeight();
            v0 = Math.max(this.getScrollRange(), v0) + v4;
            if(this.getClipToPadding()) {
                v3 -= this.getPaddingLeft() + this.getPaddingRight();
                v2 = this.getPaddingLeft();
            }

            if(this.getClipToPadding()) {
                v4 -= this.getPaddingTop() + this.getPaddingBottom();
                v0 -= this.getPaddingBottom();
            }

            arg10.translate(((float)(v2 - v3)), ((float)v0));
            arg10.rotate(180f, ((float)v3), 0f);
            this.mEdgeGlowBottom.setSize(v3, v4);
            if(this.mEdgeGlowBottom.draw(arg10)) {
                this.postInvalidateOnAnimation();
            }

            arg10.restoreToCount(v1);
        }
    }

    private boolean edgeEffectFling(int arg4) {
        if(Float.compare(EdgeEffectCompat.getDistance(this.mEdgeGlowTop), 0f) != 0) {
            if(this.shouldAbsorb(this.mEdgeGlowTop, arg4)) {
                this.mEdgeGlowTop.onAbsorb(arg4);
                return 1;
            }

            this.fling(-arg4);
            return 1;
        }

        if(EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0f) {
            arg4 = -arg4;
            if(this.shouldAbsorb(this.mEdgeGlowBottom, arg4)) {
                this.mEdgeGlowBottom.onAbsorb(arg4);
                return 1;
            }

            this.fling(arg4);
            return 1;
        }

        return 0;
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        this.recycleVelocityTracker();
        this.stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    public boolean executeKeyEvent(KeyEvent arg6) {
        this.mTempRect.setEmpty();
        int v2 = 130;
        if(!this.canScroll()) {
            if((this.isFocused()) && arg6.getKeyCode() != 4) {
                View v6 = this.findFocus();
                if((((NestedScrollView)v6)) == this) {
                    v6 = null;
                }

                v6 = FocusFinder.getInstance().findNextFocus(((ViewGroup)this), v6, v2);
                if(v6 == null) {
                    return 0;
                }

                if((((NestedScrollView)v6)) == this) {
                    return 0;
                }

                if(!v6.requestFocus(v2)) {
                    return 0;
                }

                return 1;
            }

            return 0;
        }

        if(arg6.getAction() == 0) {
            int v0 = arg6.getKeyCode();
            int v4 = 33;
            if(v0 == 19) {
                if(arg6.isAltPressed()) {
                    return this.fullScroll(v4);
                }

                return this.arrowScroll(v4);
            }
            else if(v0 == 20) {
                if(arg6.isAltPressed()) {
                    return this.fullScroll(v2);
                }

                return this.arrowScroll(v2);
            }
            else if(v0 == 62) {
                if(arg6.isShiftPressed()) {
                    v2 = v4;
                }

                this.pageScroll(v2);
                return 0;
            }
            else if(v0 == 92) {
                return this.fullScroll(v4);
            }
            else if(v0 == 93) {
                return this.fullScroll(v2);
            }
            else if(v0 == 0x7A) {
                this.pageScroll(v4);
                return 0;
            }
            else if(v0 != 0x7B) {
            }
            else {
                this.pageScroll(v2);
                return 0;
            }
        }

        return 0;
    }

    private View findFocusableViewInBounds(boolean arg12, int arg13, int arg14) {
        ArrayList v11 = this.getFocusables(2);
        int v0 = ((List)v11).size();
        Object v1 = null;
        int v3 = 0;
        int v4 = 0;
        while(v3 < v0) {
            Object v5 = ((List)v11).get(v3);
            int v6 = ((View)v5).getTop();
            int v7 = ((View)v5).getBottom();
            if(arg13 < v7 && v6 < arg14) {
                int v9 = arg13 >= v6 || v7 >= arg14 ? 0 : 1;
                if(v1 == null) {
                    v1 = v5;
                    v4 = v9;
                    goto label_42;
                }

                if(!arg12 || v6 >= ((View)v1).getTop()) {
                    if(!arg12 && v7 > ((View)v1).getBottom()) {
                    label_29:
                        v6 = 1;
                        goto label_32;
                    }

                    v6 = 0;
                }
                else {
                    goto label_29;
                }

            label_32:
                if(v4 == 0) {
                    if(v9 != 0) {
                        v1 = v5;
                        v4 = 1;
                    }
                    else if(v6 != 0) {
                        goto label_41;
                    }

                    goto label_42;
                }
                else if(v9 == 0) {
                    goto label_42;
                }
                else if(v6 != 0) {
                }
                else {
                    goto label_42;
                }

            label_41:
                v1 = v5;
            }

        label_42:
            ++v3;
        }

        return ((View)v1);
    }

    public void fling(int arg13) {
        if(this.getChildCount() > 0) {
            this.mScroller.fling(this.getScrollX(), this.getScrollY(), 0, arg13, 0, 0, 0x80000000, 0x7FFFFFFF, 0, 0);
            this.runAnimatedScroll(true);
            if(Build$VERSION.SDK_INT >= 35) {
                Api35Impl.setFrameContentVelocity(((View)this), Math.abs(this.mScroller.getCurrVelocity()));
            }
        }
    }

    public boolean fullScroll(int arg6) {
        int v0 = arg6 == 130 ? 1 : 0;
        int v3 = this.getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = v3;
        if(v0 != 0) {
            v0 = this.getChildCount();
            if(v0 > 0) {
                View v0_1 = this.getChildAt(v0 - 1);
                this.mTempRect.bottom = v0_1.getBottom() + v0_1.getLayoutParams().bottomMargin + this.getPaddingBottom();
                this.mTempRect.top = this.mTempRect.bottom - v3;
            }
        }

        return this.scrollAndFocus(arg6, this.mTempRect.top, this.mTempRect.bottom);
    }

    protected float getBottomFadingEdgeStrength() {
        if(this.getChildCount() == 0) {
            return 0;
        }

        View v0 = this.getChildAt(0);
        ViewGroup$LayoutParams v1 = v0.getLayoutParams();
        int v2 = this.getVerticalFadingEdgeLength();
        int v0_1 = v0.getBottom() + ((FrameLayout$LayoutParams)v1).bottomMargin - this.getScrollY() - (this.getHeight() - this.getPaddingBottom());
        if(v0_1 < v2) {
            return (((float)v0_1)) / (((float)v2));
        }

        return 1f;
    }

    public int getMaxScrollAmount() {
        return ((int)((((float)this.getHeight())) * 0.5f));
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    private ScrollFeedbackProviderCompat getScrollFeedbackProvider() {
        ScrollFeedbackProviderCompat v0 = this.mScrollFeedbackProvider;
        if(v0 == null) {
            v0 = ScrollFeedbackProviderCompat.createProvider(((View)this));
            this.mScrollFeedbackProvider = v0;
        }

        return v0;
    }

    int getScrollRange() {
        if(this.getChildCount() > 0) {
            View v0 = this.getChildAt(0);
            ViewGroup$LayoutParams v2 = v0.getLayoutParams();
            return Math.max(0, v0.getHeight() + ((FrameLayout$LayoutParams)v2).topMargin + ((FrameLayout$LayoutParams)v2).bottomMargin - (this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()));
        }

        return 0;
    }

    private float getSplineFlingDistance(int arg9) {
        return ((float)((((double)(this.mPhysicalCoeff * 0.015f))) * Math.exp((((double)NestedScrollView.DECELERATION_RATE)) / ((((double)NestedScrollView.DECELERATION_RATE)) - 1) * Math.log(((double)((((float)Math.abs(arg9))) * 0.35f / (this.mPhysicalCoeff * 0.015f)))))));
    }

    protected float getTopFadingEdgeStrength() {
        if(this.getChildCount() == 0) {
            return 0;
        }

        int v0 = this.getVerticalFadingEdgeLength();
        int v1 = this.getScrollY();
        if(v1 < v0) {
            return (((float)v1)) / (((float)v0));
        }

        return 1f;
    }

    float getVerticalScrollFactorCompat() {
        float v0 = this.mVerticalScrollFactor;
        if(v0 == 0f) {
            TypedValue v0_1 = new TypedValue();
            Context v1 = this.getContext();
            if(v1.getTheme().resolveAttribute(0x101004D, v0_1, true)) {
                v0 = v0_1.getDimension(v1.getResources().getDisplayMetrics());
                this.mVerticalScrollFactor = v0;
                return v0;
            }

            throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
        }

        return v0;
    }

    public boolean hasNestedScrollingParent() {
        return this.hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int arg1) {
        return this.mChildHelper.hasNestedScrollingParent(arg1);
    }

    private boolean inChild(int arg4, int arg5) {
        if(this.getChildCount() > 0) {
            int v0 = this.getScrollY();
            View v3 = this.getChildAt(0);
            if(arg5 >= v3.getTop() - v0 && arg5 < v3.getBottom() - v0 && arg4 >= v3.getLeft() && arg4 < v3.getRight()) {
                return 1;
            }
        }

        return 0;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker v0 = this.mVelocityTracker;
        if(v0 == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
            return;
        }

        v0.clear();
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(this.getContext());
        this.setFocusable(true);
        this.setDescendantFocusability(0x40000);
        this.setWillNotDraw(false);
        ViewConfiguration v0 = ViewConfiguration.get(this.getContext());
        this.mTouchSlop = v0.getScaledTouchSlop();
        this.mMinimumVelocity = v0.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = v0.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initializeTouchDrag(int arg1, int arg2) {
        this.mLastMotionY = arg1;
        this.mActivePointerId = arg2;
        this.startNestedScroll(2, 0);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    private boolean isOffScreen(View arg3) {
        return this.isWithinDeltaOfScreen(arg3, 0, this.getHeight()) ^ 1;
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    private static boolean isViewDescendantOf(View arg2, View arg3) {
        if(arg2 == arg3) {
            return 1;
        }

        ViewParent v2 = arg2.getParent();
        if(((v2 instanceof ViewGroup)) && (NestedScrollView.isViewDescendantOf(((View)v2), arg3))) {
            return 1;
        }

        return 0;
    }

    private boolean isWithinDeltaOfScreen(View arg2, int arg3, int arg4) {
        arg2.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(arg2, this.mTempRect);
        if(this.mTempRect.bottom + arg3 >= this.getScrollY() && this.mTempRect.top - arg3 <= this.getScrollY() + arg4) {
            return 1;
        }

        return 0;
    }

    protected void measureChild(View arg2, int arg3, int arg4) {
        arg2.measure(NestedScrollView.getChildMeasureSpec(arg3, this.getPaddingLeft() + this.getPaddingRight(), arg2.getLayoutParams().width), View$MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View arg1, int arg2, int arg3, int arg4, int arg5) {
        ViewGroup$LayoutParams v4 = arg1.getLayoutParams();
        arg1.measure(NestedScrollView.getChildMeasureSpec(arg2, this.getPaddingLeft() + this.getPaddingRight() + ((ViewGroup$MarginLayoutParams)v4).leftMargin + ((ViewGroup$MarginLayoutParams)v4).rightMargin + arg3, ((ViewGroup$MarginLayoutParams)v4).width), View$MeasureSpec.makeMeasureSpec(((ViewGroup$MarginLayoutParams)v4).topMargin + ((ViewGroup$MarginLayoutParams)v4).bottomMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    public boolean onGenericMotionEvent(MotionEvent arg13) {
        int v9;
        int v7;
        float v1;
        if(arg13.getAction() == 8 && !this.mIsBeingDragged) {
            if(MotionEventCompat.isFromSource(arg13, 2)) {
                v1 = arg13.getAxisValue(9);
                v7 = 9;
                v9 = ((int)arg13.getX());
            }
            else if(MotionEventCompat.isFromSource(arg13, 0x400000)) {
                float v4 = arg13.getAxisValue(26);
                v9 = this.getWidth() / 2;
                v7 = 26;
                v1 = v4;
            }
            else {
                v7 = 0;
                v9 = 0;
                v1 = 0f;
            }

            if(v1 == 0f) {
                return 0;
            }

            NestedScrollView v5 = this;
            MotionEvent v8 = arg13;
            v5.scrollBy(-(((int)(v1 * this.getVerticalScrollFactorCompat()))), v7, v8, v9, 1, MotionEventCompat.isFromSource(arg13, 0x2002));
            if(v7 != 0) {
                v5.mDifferentialMotionFlingController.onMotionEvent(v8, v7);
            }

            return 1;
        }

        return 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent arg12) {
        int v0 = arg12.getAction();
        boolean v1 = true;
        int v2 = 2;
        if(v0 == v2 && (this.mIsBeingDragged)) {
            return 1;
        }

        v0 &= 0xFF;
        if(v0 != 0) {
            int v4 = -1;
            if(v0 != 1) {
                if(v0 == v2) {
                    v0 = this.mActivePointerId;
                    if(v0 == v4) {
                    }
                    else {
                        int v5 = arg12.findPointerIndex(v0);
                        if(v5 == v4) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + v0 + " in onInterceptTouchEvent");
                        }
                        else {
                            v0 = ((int)arg12.getY(v5));
                            if(Math.abs(v0 - this.mLastMotionY) <= this.mTouchSlop) {
                            }
                            else if((v2 & this.getNestedScrollAxes()) == 0) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionY = v0;
                                this.initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(arg12);
                                this.mNestedYOffset = 0;
                                ViewParent v12 = this.getParent();
                                if(v12 != null) {
                                    v12.requestDisallowInterceptTouchEvent(true);
                                }
                                else {
                                }
                            }
                            else {
                            }
                        }
                    }

                    goto label_103;
                }
                else if(v0 != 3) {
                    if(v0 != 6) {
                    }
                    else {
                        this.onSecondaryPointerUp(arg12);
                    }

                    goto label_103;
                }
            }

            this.mIsBeingDragged = false;
            this.mActivePointerId = v4;
            this.recycleVelocityTracker();
            if(this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                this.postInvalidateOnAnimation();
            }

            this.stopNestedScroll(0);
        }
        else {
            v0 = ((int)arg12.getY());
            if(!this.inChild(((int)arg12.getX()), v0)) {
                if(!this.stopGlowAnimations(arg12)) {
                    if(!this.mScroller.isFinished()) {
                    }
                    else {
                        v1 = false;
                    }
                }

                this.mIsBeingDragged = v1;
                this.recycleVelocityTracker();
                goto label_103;
            }

            this.mLastMotionY = v0;
            this.mActivePointerId = arg12.getPointerId(0);
            this.initOrResetVelocityTracker();
            this.mVelocityTracker.addMovement(arg12);
            this.mScroller.computeScrollOffset();
            if(!this.stopGlowAnimations(arg12)) {
                if(!this.mScroller.isFinished()) {
                }
                else {
                    v1 = false;
                }
            }

            this.mIsBeingDragged = v1;
            this.startNestedScroll(v2, 0);
        }

    label_103:
        return this.mIsBeingDragged;
    }

    protected void onLayout(boolean arg2, int arg3, int arg4, int arg5, int arg6) {
        super.onLayout(arg2, arg3, arg4, arg5, arg6);
        int v2 = 0;
        this.mIsLayoutDirty = false;
        View v3 = this.mChildToScrollTo;
        if(v3 != null && (NestedScrollView.isViewDescendantOf(v3, ((View)this)))) {
            this.scrollToChild(this.mChildToScrollTo);
        }

        v3 = null;
        this.mChildToScrollTo = v3;
        if(!this.mIsLaidOut) {
            if(this.mSavedState != null) {
                this.scrollTo(this.getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = ((SavedState)v3);
            }

            if(this.getChildCount() > 0) {
                View v2_1 = this.getChildAt(0);
                ViewGroup$LayoutParams v3_1 = v2_1.getLayoutParams();
                v2 = v2_1.getMeasuredHeight() + ((FrameLayout$LayoutParams)v3_1).topMargin + ((FrameLayout$LayoutParams)v3_1).bottomMargin;
            }

            arg6 = arg6 - arg4 - this.getPaddingTop() - this.getPaddingBottom();
            arg3 = this.getScrollY();
            v2 = NestedScrollView.clamp(arg3, arg6, v2);
            if(v2 == arg3) {
                goto label_39;
            }

            this.scrollTo(this.getScrollX(), v2);
        }

    label_39:
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.mIsLaidOut = true;
    }

    protected void onMeasure(int arg5, int arg6) {
        super.onMeasure(arg5, arg6);
        if(!this.mFillViewport) {
        }
        else if(View$MeasureSpec.getMode(arg6) == 0) {
        }
        else if(this.getChildCount() > 0) {
            View v6 = this.getChildAt(0);
            ViewGroup$LayoutParams v0 = v6.getLayoutParams();
            int v1 = v6.getMeasuredHeight();
            int v2 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom() - ((FrameLayout$LayoutParams)v0).topMargin - ((FrameLayout$LayoutParams)v0).bottomMargin;
            if(v1 < v2) {
                v6.measure(NestedScrollView.getChildMeasureSpec(arg5, this.getPaddingLeft() + this.getPaddingRight() + ((FrameLayout$LayoutParams)v0).leftMargin + ((FrameLayout$LayoutParams)v0).rightMargin, ((FrameLayout$LayoutParams)v0).width), View$MeasureSpec.makeMeasureSpec(v2, 0x40000000));
            }
        }
    }

    public boolean onNestedFling(View arg1, float arg2, float arg3, boolean arg4) {
        if(!arg4) {
            this.dispatchNestedFling(0f, arg3, true);
            this.fling(((int)arg3));
            return 1;
        }

        return 0;
    }

    public boolean onNestedPreFling(View arg1, float arg2, float arg3) {
        return this.dispatchNestedPreFling(arg2, arg3);
    }

    public void onNestedPreScroll(View arg7, int arg8, int arg9, int[] arg10) {
        this.onNestedPreScroll(arg7, arg8, arg9, arg10, 0);
    }

    public void onNestedPreScroll(View arg1, int arg2, int arg3, int[] arg4, int arg5) {
        this.dispatchNestedPreScroll(arg2, arg3, arg4, null, arg5);
    }

    public void onNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5) {
        this.onNestedScrollInternal(arg5, 0, null);
    }

    public void onNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        this.onNestedScrollInternal(arg5, arg6, null);
    }

    public void onNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int[] arg7) {
        this.onNestedScrollInternal(arg5, arg6, arg7);
    }

    public void onNestedScrollAccepted(View arg2, View arg3, int arg4) {
        this.onNestedScrollAccepted(arg2, arg3, arg4, 0);
    }

    public void onNestedScrollAccepted(View arg2, View arg3, int arg4, int arg5) {
        this.mParentHelper.onNestedScrollAccepted(arg2, arg3, arg4, arg5);
        this.startNestedScroll(2, arg5);
    }

    private void onNestedScrollInternal(int arg11, int arg12, int[] arg13) {
        int v0 = this.getScrollY();
        this.scrollBy(0, arg11);
        int v4 = this.getScrollY() - v0;
        if(arg13 != null) {
            arg13[1] += v4;
        }

        this.mChildHelper.dispatchNestedScroll(0, v4, 0, arg11 - v4, null, arg12, arg13);
    }

    protected void onOverScrolled(int arg1, int arg2, boolean arg3, boolean arg4) {
        super.scrollTo(arg1, arg2);
    }

    protected boolean onRequestFocusInDescendants(int arg3, Rect arg4) {
        if(arg3 == 2) {
            arg3 = 130;
        }
        else if(arg3 == 1) {
            arg3 = 33;
        }

        View v0 = arg4 == null ? FocusFinder.getInstance().findNextFocus(((ViewGroup)this), null, arg3) : FocusFinder.getInstance().findNextFocusFromRect(((ViewGroup)this), arg4, arg3);
        if(v0 == null) {
            return 0;
        }

        if(this.isOffScreen(v0)) {
            return 0;
        }

        return v0.requestFocus(arg3, arg4);
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.mSavedState = ((SavedState)arg2);
        this.requestLayout();
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.scrollPosition = this.getScrollY();
        return ((Parcelable)v1);
    }

    protected void onScrollChanged(int arg7, int arg8, int arg9, int arg10) {
        super.onScrollChanged(arg7, arg8, arg9, arg10);
        OnScrollChangeListener v0 = this.mOnScrollChangeListener;
        if(v0 != null) {
            v0.onScrollChange(this, arg7, arg8, arg9, arg10);
        }
    }

    private void onSecondaryPointerUp(MotionEvent arg4) {
        int v0 = arg4.getActionIndex();
        if(arg4.getPointerId(v0) == this.mActivePointerId) {
            v0 = v0 == 0 ? 1 : 0;
            this.mLastMotionY = ((int)arg4.getY(v0));
            this.mActivePointerId = arg4.getPointerId(v0);
            VelocityTracker v3 = this.mVelocityTracker;
            if(v3 == null) {
                return;
            }

            v3.clear();
        }
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        View v1 = this.findFocus();
        if(v1 != null) {
            if(this == (((NestedScrollView)v1))) {
            }
            else if(this.isWithinDeltaOfScreen(v1, 0, arg4)) {
                v1.getDrawingRect(this.mTempRect);
                this.offsetDescendantRectToMyCoords(v1, this.mTempRect);
                this.doScrollY(this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            }
        }
    }

    public boolean onStartNestedScroll(View arg2, View arg3, int arg4) {
        return this.onStartNestedScroll(arg2, arg3, arg4, 0);
    }

    public boolean onStartNestedScroll(View arg1, View arg2, int arg3, int arg4) {
        if((arg3 & 2) != 0) {
            return 1;
        }

        return 0;
    }

    public void onStopNestedScroll(View arg2) {
        this.onStopNestedScroll(arg2, 0);
    }

    public void onStopNestedScroll(View arg2, int arg3) {
        this.mParentHelper.onStopNestedScroll(arg2, arg3);
        this.stopNestedScroll(arg3);
    }

    public boolean onTouchEvent(MotionEvent arg14) {
        VelocityTracker v13_1;
        int v13;
        NestedScrollView v5_2;
        this.initVelocityTrackerIfNotExists();
        int v0 = arg14.getActionMasked();
        if(v0 == 0) {
            this.mNestedYOffset = 0;
        }

        MotionEvent v2 = MotionEvent.obtain(arg14);
        v2.offsetLocation(0f, ((float)this.mNestedYOffset));
        if(v0 == 0) {
            v5_2 = this;
            MotionEvent v8 = arg14;
            if(v5_2.getChildCount() == 0) {
                return 0;
            }

            if(v5_2.mIsBeingDragged) {
                ViewParent v13_2 = v5_2.getParent();
                if(v13_2 != null) {
                    v13_2.requestDisallowInterceptTouchEvent(true);
                }
            }

            if(!v5_2.mScroller.isFinished()) {
                v5_2.abortAnimatedScroll();
            }

            v5_2.initializeTouchDrag(((int)v8.getY()), v8.getPointerId(0));
        }
        else if(v0 != 1) {
            if(v0 == 2) {
                v0 = arg14.findPointerIndex(this.mActivePointerId);
                if(v0 == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                    goto label_21;
                }

                int v1 = ((int)arg14.getY(v0));
                int v4 = this.mLastMotionY - v1;
                v4 -= this.releaseVerticalGlow(v4, arg14.getX(v0));
                if(!this.mIsBeingDragged && Math.abs(v4) > this.mTouchSlop) {
                    ViewParent v5 = this.getParent();
                    if(v5 != null) {
                        v5.requestDisallowInterceptTouchEvent(true);
                    }

                    this.mIsBeingDragged = true;
                    int v5_1 = this.mTouchSlop;
                    if(v4 > 0) {
                        v4 -= v5_1;
                        goto label_89;
                    }

                    v4 += v5_1;
                }

            label_89:
                int v6 = v4;
                if(!this.mIsBeingDragged) {
                    goto label_21;
                }

                v5_2 = this;
                v13 = v5_2.scrollBy(v6, 1, arg14, ((int)arg14.getX(v0)), 0, false);
                v5_2.mLastMotionY = v1 - v13;
                v5_2.mNestedYOffset += v13;
                goto label_157;
            }
            else if(v0 == 3) {
                if((this.mIsBeingDragged) && this.getChildCount() > 0 && (this.mScroller.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange()))) {
                    this.postInvalidateOnAnimation();
                }

                this.endTouchDrag();
            }
            else if(v0 == 5) {
                v0 = arg14.getActionIndex();
                this.mLastMotionY = ((int)arg14.getY(v0));
                this.mActivePointerId = arg14.getPointerId(v0);
            }
            else if(v0 == 6) {
                this.onSecondaryPointerUp(arg14);
                this.mLastMotionY = ((int)arg14.getY(arg14.findPointerIndex(this.mActivePointerId)));
            }

        label_21:
            v5_2 = this;
        }
        else {
            v5_2 = this;
            v13_1 = v5_2.mVelocityTracker;
            v13_1.computeCurrentVelocity(1000, ((float)v5_2.mMaximumVelocity));
            v13 = ((int)v13_1.getYVelocity(v5_2.mActivePointerId));
            if(Math.abs(v13) >= v5_2.mMinimumVelocity) {
                if(!v5_2.edgeEffectFling(v13)) {
                    v13 = -v13;
                    float v14 = ((float)v13);
                    if(!v5_2.dispatchNestedPreFling(0f, v14)) {
                        v5_2.dispatchNestedFling(0f, v14, true);
                        v5_2.fling(v13);
                    }
                }
            }
            else if(v5_2.mScroller.springBack(v5_2.getScrollX(), v5_2.getScrollY(), 0, 0, 0, v5_2.getScrollRange())) {
                v5_2.postInvalidateOnAnimation();
            }

            v5_2.endTouchDrag();
        }

    label_157:
        v13_1 = v5_2.mVelocityTracker;
        if(v13_1 != null) {
            v13_1.addMovement(v2);
        }

        v2.recycle();
        return 1;
    }

    boolean overScrollByCompat(int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19, boolean arg20) {
        boolean v0_1;
        boolean v1_1;
        int v0 = this.getOverScrollMode();
        int v1 = this.computeHorizontalScrollRange() > this.computeHorizontalScrollExtent() ? 1 : 0;
        int v2 = this.computeVerticalScrollRange() > this.computeVerticalScrollExtent() ? 1 : 0;
        if(v0 != 0) {
            if(v0 == 1 && v1 != 0) {
                goto label_21;
            }

            v1 = 0;
        }
        else {
        label_21:
            v1 = 1;
        }

        if(v0 != 0) {
            if(v0 == 1 && v2 != 0) {
                goto label_28;
            }

            v0 = 0;
        }
        else {
        label_28:
            v0 = 1;
        }

        v2 = arg14 + arg12;
        v1 = v1 == 0 ? 0 : arg18;
        int v5 = arg15 + arg13;
        v0 = v0 == 0 ? 0 : arg19;
        int v6 = -v1;
        v1 += arg16;
        int v7 = -v0;
        v0 += arg17;
        if(v2 > v1) {
            v2 = v1;
            v1_1 = true;
        }
        else if(v2 < v6) {
            v1_1 = true;
            v2 = v6;
        }
        else {
            v1_1 = false;
        }

        if(v5 > v0) {
            v5 = v0;
            v0_1 = true;
        }
        else if(v5 < v7) {
            v0_1 = true;
            v5 = v7;
        }
        else {
            v0_1 = false;
        }

        if(!v0_1 || (this.hasNestedScrollingParent(1))) {
            v6 = v2;
        }
        else {
            this.mScroller.springBack(v2, v5, 0, 0, 0, this.getScrollRange());
            v6 = v2;
        }

        this.onOverScrolled(v6, v5, v1_1, v0_1);
        if(!v1_1) {
            if(v0_1) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean pageScroll(int arg6) {
        int v0 = arg6 == 130 ? 1 : 0;
        int v3 = this.getHeight();
        Rect v4 = this.mTempRect;
        if(v0 != 0) {
            v4.top = this.getScrollY() + v3;
            v0 = this.getChildCount();
            if(v0 > 0) {
                View v0_1 = this.getChildAt(v0 - 1);
                v0 = v0_1.getBottom() + v0_1.getLayoutParams().bottomMargin + this.getPaddingBottom();
                if(this.mTempRect.top + v3 > v0) {
                    this.mTempRect.top = v0 - v3;
                }
            }
        }
        else {
            v4.top = this.getScrollY() - v3;
            if(this.mTempRect.top < 0) {
                this.mTempRect.top = 0;
            }
        }

        this.mTempRect.bottom = this.mTempRect.top + v3;
        return this.scrollAndFocus(arg6, this.mTempRect.top, this.mTempRect.bottom);
    }

    private void recycleVelocityTracker() {
        VelocityTracker v0 = this.mVelocityTracker;
        if(v0 != null) {
            v0.recycle();
            this.mVelocityTracker = null;
        }
    }

    private int releaseVerticalGlow(int arg4, float arg5) {
        arg5 /= ((float)this.getWidth());
        float v4 = (((float)arg4)) / (((float)this.getHeight()));
        float v1 = 0f;
        if(EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0f) {
            v4 = -EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, -v4, arg5);
            if(EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == 0f) {
                this.mEdgeGlowTop.onRelease();
            }
            else {
            }

            goto label_20;
        }
        else if(EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0f) {
            v4 = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, v4, 1f - arg5);
            if(EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0f) {
                this.mEdgeGlowBottom.onRelease();
                goto label_20;
            }
            else {
            label_20:
                v1 = v4;
            }
        }

        arg4 = Math.round(v1 * (((float)this.getHeight())));
        if(arg4 != 0) {
            this.invalidate();
        }

        return arg4;
    }

    public void requestChildFocus(View arg2, View arg3) {
        if(!this.mIsLayoutDirty) {
            this.scrollToChild(arg3);
        }
        else {
            this.mChildToScrollTo = arg3;
        }

        super.requestChildFocus(arg2, arg3);
    }

    public boolean requestChildRectangleOnScreen(View arg3, Rect arg4, boolean arg5) {
        arg4.offset(arg3.getLeft() - arg3.getScrollX(), arg3.getTop() - arg3.getScrollY());
        return this.scrollToChildRect(arg4, arg5);
    }

    public void requestDisallowInterceptTouchEvent(boolean arg1) {
        if(arg1) {
            this.recycleVelocityTracker();
        }

        super.requestDisallowInterceptTouchEvent(arg1);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    private void runAnimatedScroll(boolean arg2) {
        if(arg2) {
            this.startNestedScroll(2, 1);
        }
        else {
            this.stopNestedScroll(1);
        }

        this.mLastScrollerY = this.getScrollY();
        this.postInvalidateOnAnimation();
    }

    private boolean scrollAndFocus(int arg7, int arg8, int arg9) {
        NestedScrollView v5_1;
        int v0 = this.getHeight();
        int v1 = this.getScrollY();
        v0 += v1;
        boolean v3 = false;
        boolean v2 = arg7 == 33 ? true : false;
        View v5 = this.findFocusableViewInBounds(v2, arg8, arg9);
        if(v5 == null) {
            v5_1 = this;
        }

        if(arg8 < v1 || arg9 > v0) {
            if(v2) {
                arg8 -= v1;
            }
            else {
                arg8 = arg9 - v0;
            }

            this.scrollBy(arg8, 0, 1, true);
            v3 = true;
        }
        else {
        }

        if((((View)v5_1)) != this.findFocus()) {
            ((View)v5_1).requestFocus(arg7);
        }

        return v3;
    }

    private int scrollBy(int arg8, int arg9, int arg10, boolean arg11) {
        return this.scrollBy(arg8, -1, null, arg9, arg10, arg11);
    }

    int scrollBy(int arg20, int arg21, MotionEvent arg22, int arg23, int arg24, boolean arg25) {
        int v2;
        int v15;
        NestedScrollView v0 = this;
        int v10 = arg21;
        int v11 = arg23;
        int v5 = arg24;
        if(v5 == 1) {
            v0.startNestedScroll(2, v5);
        }

        int v13 = v5;
        int v14 = 0;
        if(v0.dispatchNestedPreScroll(0, arg20, v0.mScrollConsumed, v0.mScrollOffset, v5)) {
            int v1 = arg20 - v0.mScrollConsumed[1];
            v15 = v0.mScrollOffset[1];
            v2 = v1;
        }
        else {
            v2 = arg20;
            v15 = 0;
        }

        int v4 = v0.getScrollY();
        int v6 = v0.getScrollRange();
        int v16 = !v0.canOverScroll() || (arg25) ? 0 : 1;
        int v17 = v2;
        int v8 = v4;
        int v9 = v6;
        int v18 = !v0.overScrollByCompat(0, v2, 0, v4, 0, v6, 0, 0, true) || (v0.hasNestedScrollingParent(v13)) ? 0 : 1;
        v2 = v0.getScrollY() - v8;
        if(arg22 != null && v2 != 0) {
            v0.getScrollFeedbackProvider().onScrollProgress(arg22.getDeviceId(), arg22.getSource(), v10, v2);
        }

        int[] v7 = v0.mScrollConsumed;
        v7[1] = 0;
        v0.dispatchNestedScroll(0, v2, 0, v17 - v2, v0.mScrollOffset, v13, v7);
        v5 = v13;
        v15 += v0.mScrollOffset[1];
        v2 = v17 - v0.mScrollConsumed[1];
        v4 = v8 + v2;
        if(v4 >= 0) {
            if(v4 <= v9) {
                goto label_122;
            }

            if(v16 == 0) {
                goto label_122;
            }

            EdgeEffectCompat.onPullDistance(v0.mEdgeGlowBottom, (((float)v2)) / (((float)v0.getHeight())), 1f - (((float)v11)) / (((float)v0.getWidth())));
            if(arg22 != null) {
                v0.getScrollFeedbackProvider().onScrollLimit(arg22.getDeviceId(), arg22.getSource(), v10, false);
            }

            if(v0.mEdgeGlowTop.isFinished()) {
                goto label_122;
            }

            v0.mEdgeGlowTop.onRelease();
        }
        else if(v16 != 0) {
            EdgeEffectCompat.onPullDistance(v0.mEdgeGlowTop, (((float)(-v2))) / (((float)v0.getHeight())), (((float)v11)) / (((float)v0.getWidth())));
            if(arg22 != null) {
                v0.getScrollFeedbackProvider().onScrollLimit(arg22.getDeviceId(), arg22.getSource(), v10, true);
            }

            if(v0.mEdgeGlowBottom.isFinished()) {
                goto label_122;
            }

            v0.mEdgeGlowBottom.onRelease();
        }

    label_122:
        if(!v0.mEdgeGlowTop.isFinished() || !v0.mEdgeGlowBottom.isFinished()) {
            v0.postInvalidateOnAnimation();
        }
        else {
            v14 = v18;
        }

        if(v14 != 0 && v5 == 0) {
            VelocityTracker v1_1 = v0.mVelocityTracker;
            if(v1_1 != null) {
                v1_1.clear();
            }
        }

        if(v5 == 1) {
            v0.stopNestedScroll(v5);
            v0.mEdgeGlowTop.onRelease();
            v0.mEdgeGlowBottom.onRelease();
        }

        return v15;
    }

    public void scrollTo(int arg7, int arg8) {
        if(this.getChildCount() > 0) {
            View v0 = this.getChildAt(0);
            ViewGroup$LayoutParams v1 = v0.getLayoutParams();
            int v2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int v3 = v0.getWidth() + ((FrameLayout$LayoutParams)v1).leftMargin + ((FrameLayout$LayoutParams)v1).rightMargin;
            int v4 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            int v0_1 = v0.getHeight() + ((FrameLayout$LayoutParams)v1).topMargin + ((FrameLayout$LayoutParams)v1).bottomMargin;
            arg7 = NestedScrollView.clamp(arg7, v2, v3);
            arg8 = NestedScrollView.clamp(arg8, v4, v0_1);
            if(arg7 == this.getScrollX() && arg8 == this.getScrollY()) {
                return;
            }

            super.scrollTo(arg7, arg8);
        }
    }

    private void scrollToChild(View arg2) {
        arg2.getDrawingRect(this.mTempRect);
        this.offsetDescendantRectToMyCoords(arg2, this.mTempRect);
        int v2 = this.computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if(v2 != 0) {
            this.scrollBy(0, v2);
        }
    }

    private boolean scrollToChildRect(Rect arg3, boolean arg4) {
        int v3 = this.computeScrollDeltaToGetChildRectOnScreen(arg3);
        boolean v1 = v3 != 0 ? true : false;
        if(v1) {
            if(arg4) {
                this.scrollBy(0, v3);
                return v1;
            }
            else {
                this.smoothScrollBy(0, v3);
            }
        }

        return v1;
    }

    public void setFillViewport(boolean arg2) {
        if(arg2 != this.mFillViewport) {
            this.mFillViewport = arg2;
            this.requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean arg1) {
        this.mChildHelper.setNestedScrollingEnabled(arg1);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener arg1) {
        this.mOnScrollChangeListener = arg1;
    }

    public void setSmoothScrollingEnabled(boolean arg1) {
        this.mSmoothScrollingEnabled = arg1;
    }

    private boolean shouldAbsorb(EdgeEffect arg3, int arg4) {
        if(arg4 > 0) {
            return 1;
        }

        if(this.getSplineFlingDistance(-arg4) < EdgeEffectCompat.getDistance(arg3) * (((float)this.getHeight()))) {
            return 1;
        }

        return 0;
    }

    public boolean shouldDelayChildPressedState() {
        return 1;
    }

    public final void smoothScrollBy(int arg3, int arg4) {
        this.smoothScrollBy(arg3, arg4, 0xFA, false);
    }

    private void smoothScrollBy(int arg9, int arg10, int arg11, boolean arg12) {
        if(this.getChildCount() == 0) {
            return;
        }

        if(AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 0xFA) {
            View v0 = this.getChildAt(0);
            ViewGroup$LayoutParams v1 = v0.getLayoutParams();
            int v0_1 = v0.getHeight() + ((FrameLayout$LayoutParams)v1).topMargin + ((FrameLayout$LayoutParams)v1).bottomMargin;
            int v1_1 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            int v4 = this.getScrollY();
            this.mScroller.startScroll(this.getScrollX(), v4, 0, Math.max(0, Math.min(arg10 + v4, Math.max(0, v0_1 - v1_1))) - v4, arg11);
            this.runAnimatedScroll(arg12);
        }
        else {
            if(!this.mScroller.isFinished()) {
                this.abortAnimatedScroll();
            }

            this.scrollBy(arg9, arg10);
        }

        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void smoothScrollBy(int arg2, int arg3, int arg4) {
        this.smoothScrollBy(arg2, arg3, arg4, false);
    }

    public final void smoothScrollTo(int arg3, int arg4) {
        this.smoothScrollTo(arg3, arg4, 0xFA, false);
    }

    void smoothScrollTo(int arg2, int arg3, int arg4, boolean arg5) {
        this.smoothScrollBy(arg2 - this.getScrollX(), arg3 - this.getScrollY(), arg4, arg5);
    }

    public final void smoothScrollTo(int arg2, int arg3, int arg4) {
        this.smoothScrollTo(arg2, arg3, arg4, false);
    }

    void smoothScrollTo(int arg2, int arg3, boolean arg4) {
        this.smoothScrollTo(arg2, arg3, 0xFA, arg4);
    }

    public boolean startNestedScroll(int arg1, int arg2) {
        return this.mChildHelper.startNestedScroll(arg1, arg2);
    }

    public boolean startNestedScroll(int arg2) {
        return this.startNestedScroll(arg2, 0);
    }

    private boolean stopGlowAnimations(MotionEvent arg6) {
        boolean v0;
        if(Float.compare(EdgeEffectCompat.getDistance(this.mEdgeGlowTop), 0f) != 0) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, 0f, arg6.getX() / (((float)this.getWidth())));
            v0 = true;
        }
        else {
            v0 = false;
        }

        if(EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != 0f) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, 0f, 1f - arg6.getX() / (((float)this.getWidth())));
            return 1;
        }

        return v0;
    }

    public void stopNestedScroll(int arg1) {
        this.mChildHelper.stopNestedScroll(arg1);
    }

    public void stopNestedScroll() {
        this.stopNestedScroll(0);
    }
}

