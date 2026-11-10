package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper$Callback;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements Openable {
    class androidx.drawerlayout.widget.DrawerLayout$1 implements AccessibilityViewCommand {
        androidx.drawerlayout.widget.DrawerLayout$1(DrawerLayout arg1) {
            DrawerLayout.this = arg1;
            super();
        }

        public boolean perform(View arg2, CommandArguments arg3) {
            if((DrawerLayout.this.isDrawerOpen(arg2)) && DrawerLayout.this.getDrawerLockMode(arg2) != 2) {
                DrawerLayout.this.closeDrawer(arg2);
                return 1;
            }

            return 0;
        }
    }

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect;

        AccessibilityDelegate(DrawerLayout arg1) {
            DrawerLayout.this = arg1;
            super();
            this.mTmpRect = new Rect();
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat arg4, ViewGroup arg5) {
            int v3 = arg5.getChildCount();
            int v0;
            for(v0 = 0; v0 < v3; ++v0) {
                View v1 = arg5.getChildAt(v0);
                if(DrawerLayout.includeChildForAccessibility(v1)) {
                    arg4.addChild(v1);
                }
            }
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat arg1, AccessibilityNodeInfoCompat arg2) {
            Rect v0 = this.mTmpRect;
            arg2.getBoundsInScreen(v0);
            arg1.setBoundsInScreen(v0);
            arg1.setVisibleToUser(arg2.isVisibleToUser());
            arg1.setPackageName(arg2.getPackageName());
            arg1.setClassName(arg2.getClassName());
            arg1.setContentDescription(arg2.getContentDescription());
            arg1.setEnabled(arg2.isEnabled());
            arg1.setFocused(arg2.isFocused());
            arg1.setAccessibilityFocused(arg2.isAccessibilityFocused());
            arg1.setSelected(arg2.isSelected());
            arg1.addAction(arg2.getActions());
        }

        public boolean dispatchPopulateAccessibilityEvent(View arg3, AccessibilityEvent arg4) {
            if(arg4.getEventType() == 0x20) {
                List v3 = arg4.getText();
                View v4 = DrawerLayout.this.findVisibleDrawer();
                if(v4 != null) {
                    CharSequence v2 = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.getDrawerViewAbsoluteGravity(v4));
                    if(v2 != null) {
                        v3.add(v2);
                    }
                }

                return 1;
            }

            return super.dispatchPopulateAccessibilityEvent(arg3, arg4);
        }

        public void onInitializeAccessibilityEvent(View arg1, AccessibilityEvent arg2) {
            super.onInitializeAccessibilityEvent(arg1, arg2);
            arg2.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        public void onInitializeAccessibilityNodeInfo(View arg4, AccessibilityNodeInfoCompat arg5) {
            if(DrawerLayout.CAN_HIDE_DESCENDANTS) {
                super.onInitializeAccessibilityNodeInfo(arg4, arg5);
            }
            else {
                AccessibilityNodeInfoCompat v0 = AccessibilityNodeInfoCompat.obtain(arg5);
                super.onInitializeAccessibilityNodeInfo(arg4, v0);
                arg5.setSource(arg4);
                ViewParent v1 = ViewCompat.getParentForAccessibility(arg4);
                if((v1 instanceof View)) {
                    arg5.setParent(((View)v1));
                }

                this.copyNodeInfoNoChildren(arg5, v0);
                v0.recycle();
                this.addChildrenForAccessibility(arg5, ((ViewGroup)arg4));
            }

            arg5.setClassName("androidx.drawerlayout.widget.DrawerLayout");
            arg5.setFocusable(false);
            arg5.setFocused(false);
            arg5.removeAction(AccessibilityActionCompat.ACTION_FOCUS);
            arg5.removeAction(AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup arg2, View arg3, AccessibilityEvent arg4) {
            if(!DrawerLayout.CAN_HIDE_DESCENDANTS) {
                if(DrawerLayout.includeChildForAccessibility(arg3)) {
                }
                else {
                    return 0;
                }
            }

            return super.onRequestSendAccessibilityEvent(arg2, arg3, arg4);
        }
    }

    final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
            super();
        }

        public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
            super.onInitializeAccessibilityNodeInfo(arg1, arg2);
            if(!DrawerLayout.includeChildForAccessibility(arg1)) {
                arg2.setParent(null);
            }
        }
    }

    public interface DrawerListener {
        void onDrawerClosed(View arg1);

        void onDrawerOpened(View arg1);

        void onDrawerSlide(View arg1, float arg2);

        void onDrawerStateChanged(int arg1);
    }

    public class LayoutParams extends ViewGroup$MarginLayoutParams {
        private static final int FLAG_IS_CLOSING = 4;
        private static final int FLAG_IS_OPENED = 1;
        private static final int FLAG_IS_OPENING = 2;
        public int gravity;
        boolean isPeeking;
        float onScreen;
        int openState;

        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
            this.gravity = 0;
        }

        public LayoutParams(Context arg3, AttributeSet arg4) {
            super(arg3, arg4);
            this.gravity = 0;
            TypedArray v3 = arg3.obtainStyledAttributes(arg4, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = v3.getInt(0, 0);
            v3.recycle();
        }

        public LayoutParams(LayoutParams arg2) {
            super(((ViewGroup$MarginLayoutParams)arg2));
            this.gravity = 0;
            this.gravity = arg2.gravity;
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg1) {
            super(arg1);
            this.gravity = 0;
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
            this.gravity = 0;
        }

        public LayoutParams(int arg1, int arg2, int arg3) {
            this(arg1, arg2);
            this.gravity = arg3;
        }
    }

    public class SavedState extends AbsSavedState {
        class androidx.drawerlayout.widget.DrawerLayout$SavedState$1 implements Parcelable$ClassLoaderCreator {
            androidx.drawerlayout.widget.DrawerLayout$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return new SavedState(arg2, null);
            }

            public SavedState createFromParcel(Parcel arg1, ClassLoader arg2) {
                return new SavedState(arg1, arg2);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public Object createFromParcel(Parcel arg1, ClassLoader arg2) {
                return this.createFromParcel(arg1, arg2);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        int lockModeEnd;
        int lockModeLeft;
        int lockModeRight;
        int lockModeStart;
        int openDrawerGravity;

        static {
            SavedState.CREATOR = new androidx.drawerlayout.widget.DrawerLayout$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
            this.openDrawerGravity = 0;
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = arg1.readInt();
            this.lockModeLeft = arg1.readInt();
            this.lockModeRight = arg1.readInt();
            this.lockModeStart = arg1.readInt();
            this.lockModeEnd = arg1.readInt();
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeInt(this.openDrawerGravity);
            arg1.writeInt(this.lockModeLeft);
            arg1.writeInt(this.lockModeRight);
            arg1.writeInt(this.lockModeStart);
            arg1.writeInt(this.lockModeEnd);
        }
    }

    public abstract class SimpleDrawerListener implements DrawerListener {
        public SimpleDrawerListener() {
            super();
        }

        public void onDrawerClosed(View arg1) {
        }

        public void onDrawerOpened(View arg1) {
        }

        public void onDrawerSlide(View arg1, float arg2) {
        }

        public void onDrawerStateChanged(int arg1) {
        }
    }

    class ViewDragCallback extends Callback {
        class androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback$1 implements Runnable {
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback$1(ViewDragCallback arg1) {
                this.this$1 = arg1;
                super();
            }

            public void run() {
                this.this$1.peekDrawer();
            }
        }

        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable;

        ViewDragCallback(DrawerLayout arg1, int arg2) {
            DrawerLayout.this = arg1;
            super();
            this.mPeekRunnable = new androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback$1(this);
            this.mAbsGravity = arg2;
        }

        public int clampViewPositionHorizontal(View arg2, int arg3, int arg4) {
            if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(arg2, 3)) {
                return Math.max(-arg2.getWidth(), Math.min(arg3, 0));
            }

            int v1 = DrawerLayout.this.getWidth();
            return Math.max(v1 - arg2.getWidth(), Math.min(arg3, v1));
        }

        public int clampViewPositionVertical(View arg1, int arg2, int arg3) {
            return arg1.getTop();
        }

        private void closeOtherDrawer() {
            int v1 = 3;
            if(this.mAbsGravity == v1) {
                v1 = 5;
            }

            View v0 = DrawerLayout.this.findDrawerWithGravity(v1);
            if(v0 != null) {
                DrawerLayout.this.closeDrawer(v0);
            }
        }

        public int getViewHorizontalDragRange(View arg1) {
            if(DrawerLayout.this.isDrawerView(arg1)) {
                return arg1.getWidth();
            }

            return 0;
        }

        public void onEdgeDragStarted(int arg3, int arg4) {
            DrawerLayout v1 = DrawerLayout.this;
            View v3 = (arg3 & 1) == 1 ? v1.findDrawerWithGravity(3) : v1.findDrawerWithGravity(5);
            if(v3 != null && DrawerLayout.this.getDrawerLockMode(v3) == 0) {
                this.mDragger.captureChildView(v3, arg4);
            }
        }

        public boolean onEdgeLock(int arg1) {
            return 0;
        }

        public void onEdgeTouched(int arg3, int arg4) {
            DrawerLayout.this.postDelayed(this.mPeekRunnable, 0xA0);
        }

        public void onViewCaptured(View arg1, int arg2) {
            arg1.getLayoutParams().isPeeking = false;
            this.closeOtherDrawer();
        }

        public void onViewDragStateChanged(int arg2) {
            DrawerLayout.this.updateDrawerState(arg2, this.mDragger.getCapturedView());
        }

        public void onViewPositionChanged(View arg1, int arg2, int arg3, int arg4, int arg5) {
            arg3 = arg1.getWidth();
            float v2 = DrawerLayout.this.checkDrawerViewAbsoluteGravity(arg1, 3) ? ((float)(arg2 + arg3)) : ((float)(DrawerLayout.this.getWidth() - arg2));
            v2 /= ((float)arg3);
            DrawerLayout.this.setDrawerViewOffset(arg1, v2);
            arg2 = v2 == 0f ? 4 : 0;
            arg1.setVisibility(arg2);
            DrawerLayout.this.invalidate();
        }

        public void onViewReleased(View arg6, float arg7, float arg8) {
            int v7;
            arg8 = DrawerLayout.this.getDrawerViewOffset(arg6);
            int v0 = arg6.getWidth();
            float v2 = 0.5f;
            if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(arg6, 3)) {
                v7 = Float.compare(arg7, 0f);
                if(v7 <= 0 && (v7 != 0 || arg8 <= v2)) {
                    v7 = -v0;
                    goto label_25;
                }

                v7 = 0;
            }
            else {
                int v1 = DrawerLayout.this.getWidth();
                if(arg7 < 0f || arg7 == 0f && arg8 > v2) {
                    v1 -= v0;
                }

                v7 = v1;
            }

        label_25:
            this.mDragger.settleCapturedViewAt(v7, arg6.getTop());
            DrawerLayout.this.invalidate();
        }

        void peekDrawer() {
            View v4_1;
            int v0 = this.mDragger.getEdgeSize();
            int v3 = 0;
            int v4 = 3;
            int v1 = this.mAbsGravity == v4 ? 1 : 0;
            DrawerLayout v5 = DrawerLayout.this;
            if(v1 != 0) {
                v4_1 = v5.findDrawerWithGravity(v4);
                if(v4_1 != null) {
                    v3 = -v4_1.getWidth();
                }

                v3 += v0;
            }
            else {
                v4_1 = v5.findDrawerWithGravity(5);
                v3 = DrawerLayout.this.getWidth() - v0;
            }

            if(v4_1 != null) {
                if(v1 == 0 || v4_1.getLeft() >= v3) {
                    if(v1 != 0) {
                    }
                    else if(v4_1.getLeft() > v3) {
                        goto label_30;
                    }

                    return;
                }

            label_30:
                if(DrawerLayout.this.getDrawerLockMode(v4_1) != 0) {
                    return;
                }

                ViewGroup$LayoutParams v0_1 = v4_1.getLayoutParams();
                this.mDragger.smoothSlideViewTo(v4_1, v3, v4_1.getTop());
                ((LayoutParams)v0_1).isPeeking = true;
                DrawerLayout.this.invalidate();
                this.closeOtherDrawer();
                DrawerLayout.this.cancelChildViewTouch();
            }
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper arg1) {
            this.mDragger = arg1;
        }

        public boolean tryCaptureView(View arg2, int arg3) {
            if((DrawerLayout.this.isDrawerView(arg2)) && (DrawerLayout.this.checkDrawerViewAbsoluteGravity(arg2, this.mAbsGravity)) && DrawerLayout.this.getDrawerLockMode(arg2) == 0) {
                return 1;
            }

            return 0;
        }
    }

    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = 0x99000000;
    static final int[] LAYOUT_ATTRS = null;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 0x40;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 0xA0;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final int[] THEME_ATTRS = null;
    private static final float TOUCH_SLOP_SENSITIVITY = 1f;
    private final AccessibilityViewCommand mActionDismiss;
    private final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    private DrawerListener mListener;
    private List mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList mNonDrawerViews;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;
    private static boolean sEdgeSizeUsingSystemGestureInsets;

    static {
        DrawerLayout.THEME_ATTRS = new int[]{0x1010434};
        DrawerLayout.LAYOUT_ATTRS = new int[]{0x10100B3};
        boolean v0 = true;
        DrawerLayout.CAN_HIDE_DESCENDANTS = true;
        DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION = true;
        if(Build$VERSION.SDK_INT >= 29) {
        }
        else {
            v0 = false;
        }

        DrawerLayout.sEdgeSizeUsingSystemGestureInsets = v0;
    }

    public DrawerLayout(Context arg2) {
        this(arg2, null);
    }

    public DrawerLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.drawerLayoutStyle);
    }

    public DrawerLayout(Context arg7, AttributeSet arg8, int arg9) {
        super(arg7, arg8, arg9);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = 0x99000000;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.mActionDismiss = new androidx.drawerlayout.widget.DrawerLayout$1(this);
        this.setDescendantFocusability(0x40000);
        float v2 = this.getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = ((int)(64f * v2 + 0.5f));
        v2 *= 400f;
        ViewDragCallback v3 = new ViewDragCallback(this, 3);
        this.mLeftCallback = v3;
        ViewDragCallback v1 = new ViewDragCallback(this, 5);
        this.mRightCallback = v1;
        ViewDragHelper v5 = ViewDragHelper.create(((ViewGroup)this), 1f, ((Callback)v3));
        this.mLeftDragger = v5;
        v5.setEdgeTrackingEnabled(1);
        v5.setMinVelocity(v2);
        v3.setDragger(v5);
        ViewDragHelper v3_1 = ViewDragHelper.create(((ViewGroup)this), 1f, ((Callback)v1));
        this.mRightDragger = v3_1;
        v3_1.setEdgeTrackingEnabled(2);
        v3_1.setMinVelocity(v2);
        v1.setDragger(v3_1);
        this.setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(((View)this), 1);
        ViewCompat.setAccessibilityDelegate(((View)this), new AccessibilityDelegate(this));
        this.setMotionEventSplittingEnabled(false);
        if(ViewCompat.getFitsSystemWindows(((View)this))) {
            this.setOnApplyWindowInsetsListener(new View$OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View arg1, WindowInsets arg2) {
                    boolean v0 = arg2.getSystemWindowInsetTop() > 0 ? true : false;
                    ((DrawerLayout)arg1).setChildInsets(arg2, v0);
                    return arg2.consumeSystemWindowInsets();
                }
            });
            this.setSystemUiVisibility(0x500);
            TypedArray v1_1 = arg7.obtainStyledAttributes(DrawerLayout.THEME_ATTRS);
            try {
                this.mStatusBarBackground = v1_1.getDrawable(0);
            }
            catch(Throwable v6) {
                v1_1.recycle();
                throw v6;
            }

            v1_1.recycle();
        }

        TypedArray v7 = arg7.obtainStyledAttributes(arg8, styleable.DrawerLayout, arg9, 0);
        try {
            this.mDrawerElevation = v7.hasValue(styleable.DrawerLayout_elevation) ? v7.getDimension(styleable.DrawerLayout_elevation, 0f) : this.getResources().getDimension(dimen.def_drawer_elevation);
        }
        catch(Throwable v6) {
            v7.recycle();
            throw v6;
        }

        v7.recycle();
        this.mNonDrawerViews = new ArrayList();
    }

    public void addDrawerListener(DrawerListener arg2) {
        if(arg2 == null) {
            return;
        }

        if(this.mListeners == null) {
            this.mListeners = new ArrayList();
        }

        this.mListeners.add(arg2);
    }

    public void addFocusables(ArrayList arg7, int arg8, int arg9) {
        if(this.getDescendantFocusability() == 0x60000) {
            return;
        }

        int v0 = this.getChildCount();
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            View v4 = this.getChildAt(v2);
            if(!this.isDrawerView(v4)) {
                this.mNonDrawerViews.add(v4);
            }
            else if(this.isDrawerOpen(v4)) {
                v4.addFocusables(arg7, arg8, arg9);
                v3 = 1;
            }

            ++v2;
        }

        if(v3 == 0) {
            v0 = this.mNonDrawerViews.size();
            while(v1 < v0) {
                Object v2_1 = this.mNonDrawerViews.get(v1);
                if(((View)v2_1).getVisibility() == 0) {
                    ((View)v2_1).addFocusables(arg7, arg8, arg9);
                }

                ++v1;
            }
        }

        this.mNonDrawerViews.clear();
    }

    public void addView(View arg1, int arg2, ViewGroup$LayoutParams arg3) {
        super.addView(arg1, arg2, arg3);
        if(this.findOpenDrawer() != null || (this.isDrawerView(arg1))) {
            ViewCompat.setImportantForAccessibility(arg1, 4);
        }
        else {
            ViewCompat.setImportantForAccessibility(arg1, 1);
        }

        if(!DrawerLayout.CAN_HIDE_DESCENDANTS) {
            ViewCompat.setAccessibilityDelegate(arg1, this.mChildAccessibilityDelegate);
        }
    }

    void cancelChildViewTouch() {
        if(!this.mChildrenCanceledTouch) {
            long v1 = SystemClock.uptimeMillis();
            MotionEvent v0 = MotionEvent.obtain(v1, v1, 3, 0f, 0f, 0);
            int v1_1 = this.getChildCount();
            int v2;
            for(v2 = 0; v2 < v1_1; ++v2) {
                this.getChildAt(v2).dispatchTouchEvent(v0);
            }

            v0.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }

    boolean checkDrawerViewAbsoluteGravity(View arg1, int arg2) {
        if((this.getDrawerViewAbsoluteGravity(arg1) & arg2) == arg2) {
            return 1;
        }

        return 0;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        if(((arg2 instanceof LayoutParams)) && (super.checkLayoutParams(arg2))) {
            return 1;
        }

        return 0;
    }

    public void close() {
        this.closeDrawer(0x800003);
    }

    public void closeDrawer(int arg2) {
        this.closeDrawer(arg2, true);
    }

    public void closeDrawer(int arg2, boolean arg3) {
        View v0 = this.findDrawerWithGravity(arg2);
        if(v0 != null) {
            this.closeDrawer(v0, arg3);
            return;
        }

        throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.gravityToString(arg2));
    }

    public void closeDrawer(View arg5, boolean arg6) {
        if(this.isDrawerView(arg5)) {
            ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
            if(this.mFirstLayout) {
                ((LayoutParams)v0).onScreen = 0f;
                ((LayoutParams)v0).openState = 0;
            }
            else {
                int v1 = 4;
                if(arg6) {
                    ((LayoutParams)v0).openState |= v1;
                    if(this.checkDrawerViewAbsoluteGravity(arg5, 3)) {
                        this.mLeftDragger.smoothSlideViewTo(arg5, -arg5.getWidth(), arg5.getTop());
                    }
                    else {
                        this.mRightDragger.smoothSlideViewTo(arg5, this.getWidth(), arg5.getTop());
                    }
                }
                else {
                    this.moveDrawerToOffset(arg5, 0f);
                    this.updateDrawerState(0, arg5);
                    arg5.setVisibility(v1);
                }
            }

            this.invalidate();
            return;
        }

        throw new IllegalArgumentException("View " + arg5 + " is not a sliding drawer");
    }

    public void closeDrawer(View arg2) {
        this.closeDrawer(arg2, true);
    }

    public void closeDrawers() {
        this.closeDrawers(false);
    }

    void closeDrawers(boolean arg10) {
        int v0 = this.getChildCount();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            View v4 = this.getChildAt(v2);
            ViewGroup$LayoutParams v5 = v4.getLayoutParams();
            if((this.isDrawerView(v4)) && (!arg10 || (((LayoutParams)v5).isPeeking))) {
                int v6 = v4.getWidth();
                boolean v4_1 = this.checkDrawerViewAbsoluteGravity(v4, 3) ? this.mLeftDragger.smoothSlideViewTo(v4, -v6, v4.getTop()) : this.mRightDragger.smoothSlideViewTo(v4, this.getWidth(), v4.getTop());
                v3 |= ((int)v4_1);
                ((LayoutParams)v5).isPeeking = false;
            }

            ++v2;
        }

        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if(v3 != 0) {
            this.invalidate();
        }
    }

    public void computeScroll() {
        int v0 = this.getChildCount();
        float v1 = 0f;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1 = Math.max(v1, this.getChildAt(v2).getLayoutParams().onScreen);
        }

        this.mScrimOpacity = v1;
        boolean v0_1 = this.mLeftDragger.continueSettling(true);
        boolean v1_1 = this.mRightDragger.continueSettling(true);
        if(!v0_1) {
            if(v1_1) {
            }
            else {
                return;
            }
        }

        ViewCompat.postInvalidateOnAnimation(((View)this));
    }

    public boolean dispatchGenericMotionEvent(MotionEvent arg7) {
        if((arg7.getSource() & 2) != 0 && arg7.getAction() != 10) {
            if(this.mScrimOpacity <= 0f) {
            }
            else {
                int v0 = this.getChildCount();
                if(v0 != 0) {
                    float v1 = arg7.getX();
                    float v2 = arg7.getY();
                    --v0;
                    while(v0 >= 0) {
                        View v4 = this.getChildAt(v0);
                        if(this.isInBoundsOfChild(v1, v2, v4)) {
                            if(this.isContentView(v4)) {
                            }
                            else if(this.dispatchTransformedGenericPointerEvent(arg7, v4)) {
                                return 1;
                            }
                        }

                        --v0;
                    }
                }

                return 0;
            }
        }

        return super.dispatchGenericMotionEvent(arg7);
    }

    void dispatchOnDrawerClosed(View arg4) {
        ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
        if((((LayoutParams)v0).openState & 1) == 1) {
            ((LayoutParams)v0).openState = 0;
            List v0_1 = this.mListeners;
            if(v0_1 != null) {
                int v0_2;
                for(v0_2 = v0_1.size() - 1; v0_2 >= 0; --v0_2) {
                    this.mListeners.get(v0_2).onDrawerClosed(arg4);
                }
            }

            this.updateChildrenImportantForAccessibility(arg4, false);
            this.updateChildAccessibilityAction(arg4);
            if(!this.hasWindowFocus()) {
                return;
            }

            View v3 = this.getRootView();
            if(v3 == null) {
                return;
            }

            v3.sendAccessibilityEvent(0x20);
        }
    }

    void dispatchOnDrawerOpened(View arg4) {
        ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
        if((((LayoutParams)v0).openState & 1) == 0) {
            ((LayoutParams)v0).openState = 1;
            List v0_1 = this.mListeners;
            if(v0_1 != null) {
                int v0_2;
                for(v0_2 = v0_1.size() - 1; v0_2 >= 0; --v0_2) {
                    this.mListeners.get(v0_2).onDrawerOpened(arg4);
                }
            }

            this.updateChildrenImportantForAccessibility(arg4, true);
            this.updateChildAccessibilityAction(arg4);
            if(!this.hasWindowFocus()) {
                return;
            }

            this.sendAccessibilityEvent(0x20);
        }
    }

    void dispatchOnDrawerSlide(View arg3, float arg4) {
        List v0 = this.mListeners;
        if(v0 != null) {
            int v0_1;
            for(v0_1 = v0.size() - 1; v0_1 >= 0; --v0_1) {
                this.mListeners.get(v0_1).onDrawerSlide(arg3, arg4);
            }
        }
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent arg3, View arg4) {
        if(!arg4.getMatrix().isIdentity()) {
            MotionEvent v2 = this.getTransformedMotionEvent(arg3, arg4);
            boolean v3 = arg4.dispatchGenericMotionEvent(v2);
            v2.recycle();
            return v3;
        }

        float v0 = ((float)(this.getScrollX() - arg4.getLeft()));
        float v2_1 = ((float)(this.getScrollY() - arg4.getTop()));
        arg3.offsetLocation(v0, v2_1);
        boolean v4 = arg4.dispatchGenericMotionEvent(arg3);
        arg3.offsetLocation(-v0, -v2_1);
        return v4;
    }

    protected boolean drawChild(Canvas arg14, View arg15, long arg16) {
        int v10_1;
        int v1 = this.getHeight();
        boolean v2 = this.isContentView(arg15);
        int v3 = this.getWidth();
        int v4 = arg14.save();
        int v5 = 3;
        int v6 = 0;
        if(v2) {
            int v7 = this.getChildCount();
            int v8 = 0;
            int v9 = 0;
            while(v8 < v7) {
                View v10 = this.getChildAt(v8);
                if(v10 != arg15 && v10.getVisibility() == 0 && (DrawerLayout.hasOpaqueBackground(v10)) && (this.isDrawerView(v10))) {
                    if(v10.getHeight() < v1) {
                    }
                    else if(this.checkDrawerViewAbsoluteGravity(v10, v5)) {
                        v10_1 = v10.getRight();
                        if(v10_1 > v9) {
                            v9 = v10_1;
                        }
                    }
                    else {
                        v10_1 = v10.getLeft();
                        if(v10_1 < v3) {
                            v3 = v10_1;
                        }
                    }
                }

                ++v8;
            }

            arg14.clipRect(v9, 0, v3, this.getHeight());
            v6 = v9;
        }

        boolean v1_1 = super.drawChild(arg14, arg15, arg16);
        arg14.restoreToCount(v4);
        float v4_1 = this.mScrimOpacity;
        if(v4_1 > 0f && (v2)) {
            this.mScrimPaint.setColor(this.mScrimColor & 0xFFFFFF | (((int)((((float)((0xFF000000 & this.mScrimColor) >>> 24))) * v4_1))) << 24);
            arg14.drawRect(((float)v6), 0f, ((float)v3), ((float)this.getHeight()), this.mScrimPaint);
            return v1_1;
        }

        v4_1 = 255f;
        float v6_1 = 1f;
        if(this.mShadowLeftResolved != null && (this.checkDrawerViewAbsoluteGravity(arg15, v5))) {
            v3 = this.mShadowLeftResolved.getIntrinsicWidth();
            v5 = arg15.getRight();
            v6_1 = Math.max(0f, Math.min((((float)v5)) / (((float)this.mLeftDragger.getEdgeSize())), v6_1));
            this.mShadowLeftResolved.setBounds(v5, arg15.getTop(), v3 + v5, arg15.getBottom());
            this.mShadowLeftResolved.setAlpha(((int)(v6_1 * v4_1)));
            this.mShadowLeftResolved.draw(arg14);
            return v1_1;
        }

        if(this.mShadowRightResolved != null && (this.checkDrawerViewAbsoluteGravity(arg15, 5))) {
            v3 = this.mShadowRightResolved.getIntrinsicWidth();
            v5 = arg15.getLeft();
            v6_1 = Math.max(0f, Math.min((((float)(this.getWidth() - v5))) / (((float)this.mRightDragger.getEdgeSize())), v6_1));
            this.mShadowRightResolved.setBounds(v5 - v3, arg15.getTop(), v5, arg15.getBottom());
            this.mShadowRightResolved.setAlpha(((int)(v6_1 * v4_1)));
            this.mShadowRightResolved.draw(arg14);
        }

        return v1_1;
    }

    View findDrawerWithGravity(int arg5) {
        arg5 = GravityCompat.getAbsoluteGravity(arg5, ViewCompat.getLayoutDirection(((View)this))) & 7;
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getChildAt(v1);
            if((this.getDrawerViewAbsoluteGravity(v2) & 7) == arg5) {
                return v2;
            }
        }

        return null;
    }

    View findOpenDrawer() {
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getChildAt(v1);
            if((v2.getLayoutParams().openState & 1) == 1) {
                return v2;
            }
        }

        return null;
    }

    View findVisibleDrawer() {
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getChildAt(v1);
            if((this.isDrawerView(v2)) && (this.isDrawerVisible(v2))) {
                return v2;
            }
        }

        return null;
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        if((arg1 instanceof LayoutParams)) {
            return new LayoutParams(((LayoutParams)arg1));
        }

        if((arg1 instanceof ViewGroup$MarginLayoutParams)) {
            return new LayoutParams(((ViewGroup$MarginLayoutParams)arg1));
        }

        return new LayoutParams(arg1);
    }

    public float getDrawerElevation() {
        if(DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return this.mDrawerElevation;
        }

        return 0;
    }

    public int getDrawerLockMode(int arg4) {
        int v3;
        int v0 = ViewCompat.getLayoutDirection(((View)this));
        int v1 = 3;
        if(arg4 == v1) {
            arg4 = this.mLockModeLeft;
            if(arg4 != v1) {
                return arg4;
            }

            v3 = v0 == 0 ? this.mLockModeStart : this.mLockModeEnd;
            if(v3 == v1) {
                return 0;
            }

            return v3;
        }
        else if(arg4 == 5) {
            arg4 = this.mLockModeRight;
            if(arg4 != v1) {
                return arg4;
            }

            v3 = v0 == 0 ? this.mLockModeEnd : this.mLockModeStart;
            if(v3 == v1) {
                return 0;
            }

            return v3;
        }
        else if(arg4 == 0x800003) {
            arg4 = this.mLockModeStart;
            if(arg4 != v1) {
                return arg4;
            }

            v3 = v0 == 0 ? this.mLockModeLeft : this.mLockModeRight;
            if(v3 == v1) {
                return 0;
            }

            return v3;
        }
        else if(arg4 != 0x800005) {
        }
        else {
            arg4 = this.mLockModeEnd;
            if(arg4 != v1) {
                return arg4;
            }
            else {
                v3 = v0 == 0 ? this.mLockModeRight : this.mLockModeLeft;
                if(v3 == v1) {
                    return 0;
                }

                return v3;
            }
        }

        return 0;
    }

    public int getDrawerLockMode(View arg3) {
        if(this.isDrawerView(arg3)) {
            return this.getDrawerLockMode(arg3.getLayoutParams().gravity);
        }

        throw new IllegalArgumentException("View " + arg3 + " is not a drawer");
    }

    public CharSequence getDrawerTitle(int arg2) {
        arg2 = GravityCompat.getAbsoluteGravity(arg2, ViewCompat.getLayoutDirection(((View)this)));
        if(arg2 == 3) {
            return this.mTitleLeft;
        }

        if(arg2 == 5) {
            return this.mTitleRight;
        }

        return null;
    }

    int getDrawerViewAbsoluteGravity(View arg1) {
        return GravityCompat.getAbsoluteGravity(arg1.getLayoutParams().gravity, ViewCompat.getLayoutDirection(((View)this)));
    }

    float getDrawerViewOffset(View arg1) {
        return arg1.getLayoutParams().onScreen;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent arg4, View arg5) {
        float v0 = ((float)(this.getScrollX() - arg5.getLeft()));
        float v1 = ((float)(this.getScrollY() - arg5.getTop()));
        arg4 = MotionEvent.obtain(arg4);
        arg4.offsetLocation(v0, v1);
        Matrix v5 = arg5.getMatrix();
        if(!v5.isIdentity()) {
            Matrix v0_1 = this.mChildInvertedMatrix;
            if(v0_1 == null) {
                v0_1 = new Matrix();
                this.mChildInvertedMatrix = v0_1;
            }

            v5.invert(v0_1);
            arg4.transform(this.mChildInvertedMatrix);
        }

        return arg4;
    }

    static String gravityToString(int arg2) {
        if((arg2 & 3) == 3) {
            return "LEFT";
        }

        if((arg2 & 5) == 5) {
            return "RIGHT";
        }

        return Integer.toHexString(arg2);
    }

    private static boolean hasOpaqueBackground(View arg2) {
        Drawable v2 = arg2.getBackground();
        if(v2 != null && v2.getOpacity() == -1) {
            return 1;
        }

        return 0;
    }

    private boolean hasPeekingDrawer() {
        int v0 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(this.getChildAt(v2).getLayoutParams().isPeeking) {
                return 1;
            }
        }

        return 0;
    }

    private boolean hasVisibleDrawer() {
        if(this.findVisibleDrawer() != null) {
            return 1;
        }

        return 0;
    }

    static boolean includeChildForAccessibility(View arg2) {
        if(ViewCompat.getImportantForAccessibility(arg2) != 4 && ViewCompat.getImportantForAccessibility(arg2) != 2) {
            return 1;
        }

        return 0;
    }

    boolean isContentView(View arg1) {
        if(arg1.getLayoutParams().gravity == 0) {
            return 1;
        }

        return 0;
    }

    public boolean isDrawerOpen(int arg1) {
        View v1 = this.findDrawerWithGravity(arg1);
        if(v1 != null) {
            return this.isDrawerOpen(v1);
        }

        return 0;
    }

    public boolean isDrawerOpen(View arg3) {
        if(this.isDrawerView(arg3)) {
            if((arg3.getLayoutParams().openState & 1) == 1) {
                return 1;
            }

            return 0;
        }

        throw new IllegalArgumentException("View " + arg3 + " is not a drawer");
    }

    boolean isDrawerView(View arg2) {
        int v1 = GravityCompat.getAbsoluteGravity(arg2.getLayoutParams().gravity, ViewCompat.getLayoutDirection(arg2));
        if((v1 & 3) != 0) {
            return 1;
        }

        if((v1 & 5) != 0) {
            return 1;
        }

        return 0;
    }

    public boolean isDrawerVisible(int arg1) {
        View v1 = this.findDrawerWithGravity(arg1);
        if(v1 != null) {
            return this.isDrawerVisible(v1);
        }

        return 0;
    }

    public boolean isDrawerVisible(View arg3) {
        if(this.isDrawerView(arg3)) {
            if(arg3.getLayoutParams().onScreen > 0f) {
                return 1;
            }

            return 0;
        }

        throw new IllegalArgumentException("View " + arg3 + " is not a drawer");
    }

    private boolean isInBoundsOfChild(float arg2, float arg3, View arg4) {
        Rect v0 = this.mChildHitRect;
        if(v0 == null) {
            v0 = new Rect();
            this.mChildHitRect = v0;
        }

        arg4.getHitRect(v0);
        return this.mChildHitRect.contains(((int)arg2), ((int)arg3));
    }

    public boolean isOpen() {
        return this.isDrawerOpen(0x800003);
    }

    private void mirror(Drawable arg1, int arg2) {
        if(arg1 != null && (DrawableCompat.isAutoMirrored(arg1))) {
            DrawableCompat.setLayoutDirection(arg1, arg2);
        }
    }

    void moveDrawerToOffset(View arg3, float arg4) {
        float v0 = this.getDrawerViewOffset(arg3);
        float v1 = ((float)arg3.getWidth());
        int v1_1 = (((int)(v1 * arg4))) - (((int)(v0 * v1)));
        if(this.checkDrawerViewAbsoluteGravity(arg3, 3)) {
        }
        else {
            v1_1 = -v1_1;
        }

        arg3.offsetLeftAndRight(v1_1);
        this.setDrawerViewOffset(arg3, arg4);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    public void onDraw(Canvas arg5) {
        super.onDraw(arg5);
        if((this.mDrawStatusBarBackground) && this.mStatusBarBackground != null) {
            Object v0 = this.mLastInsets;
            int v0_1 = v0 != null ? ((WindowInsets)v0).getSystemWindowInsetTop() : 0;
            if(v0_1 <= 0) {
                return;
            }

            this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), v0_1);
            this.mStatusBarBackground.draw(arg5);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent arg7) {
        int v7;
        int v0 = arg7.getActionMasked();
        int v1 = this.mLeftDragger.shouldInterceptTouchEvent(arg7) | this.mRightDragger.shouldInterceptTouchEvent(arg7);
        if(v0 != 0) {
            if(v0 != 1) {
                int v4 = 3;
                if(v0 != 2) {
                    if(v0 != v4) {
                    }
                    else {
                        goto label_23;
                    }
                }
                else if(this.mLeftDragger.checkTouchSlop(v4)) {
                    this.mLeftCallback.removeCallbacks();
                    this.mRightCallback.removeCallbacks();
                }
            }
            else {
            label_23:
                this.closeDrawers(true);
                this.mChildrenCanceledTouch = false;
            }

            v7 = 0;
        }
        else {
            float v0_1 = arg7.getX();
            float v7_1 = arg7.getY();
            this.mInitialMotionX = v0_1;
            this.mInitialMotionY = v7_1;
            if(this.mScrimOpacity > 0f) {
                View v7_2 = this.mLeftDragger.findTopChildUnder(((int)v0_1), ((int)v7_1));
                if(v7_2 == null) {
                    goto label_43;
                }
                else if(this.isContentView(v7_2)) {
                    v7 = 1;
                }
                else {
                    goto label_43;
                }
            }
            else {
            label_43:
                v7 = 0;
            }

            this.mChildrenCanceledTouch = false;
        }

        if(v1 == 0 && v7 == 0 && !this.hasPeekingDrawer()) {
            if(this.mChildrenCanceledTouch) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean onKeyDown(int arg2, KeyEvent arg3) {
        if(arg2 == 4 && (this.hasVisibleDrawer())) {
            arg3.startTracking();
            return 1;
        }

        return super.onKeyDown(arg2, arg3);
    }

    public boolean onKeyUp(int arg2, KeyEvent arg3) {
        if(arg2 == 4) {
            View v2 = this.findVisibleDrawer();
            if(v2 != null && this.getDrawerLockMode(v2) == 0) {
                this.closeDrawers();
            }

            if(v2 != null) {
                return 1;
            }

            return 0;
        }

        return super.onKeyUp(arg2, arg3);
    }

    protected void onLayout(boolean arg17, int arg18, int arg19, int arg20, int arg21) {
        int v11_1;
        float v12;
        int v10;
        DrawerLayout v0 = this;
        int v1 = 1;
        v0.mInLayout = true;
        int v2 = arg20 - arg18;
        int v3 = v0.getChildCount();
        int v5 = 0;
        while(v5 < v3) {
            View v6 = v0.getChildAt(v5);
            if(v6.getVisibility() == 8) {
            }
            else {
                ViewGroup$LayoutParams v7 = v6.getLayoutParams();
                if(v0.isContentView(v6)) {
                    v6.layout(((LayoutParams)v7).leftMargin, ((LayoutParams)v7).topMargin, ((LayoutParams)v7).leftMargin + v6.getMeasuredWidth(), ((LayoutParams)v7).topMargin + v6.getMeasuredHeight());
                }
                else {
                    int v8 = v6.getMeasuredWidth();
                    int v9 = v6.getMeasuredHeight();
                    if(v0.checkDrawerViewAbsoluteGravity(v6, 3)) {
                        float v11 = ((float)v8);
                        v10 = -v8 + (((int)(((LayoutParams)v7).onScreen * v11)));
                        v12 = (((float)(v8 + v10))) / v11;
                    }
                    else {
                        float v10_1 = ((float)v8);
                        v11_1 = v2 - (((int)(((LayoutParams)v7).onScreen * v10_1)));
                        v12 = (((float)(v2 - v11_1))) / v10_1;
                        v10 = v11_1;
                    }

                    v11_1 = v12 != ((LayoutParams)v7).onScreen ? v1 : 0;
                    int v13 = ((LayoutParams)v7).gravity & 0x70;
                    if(v13 == 16) {
                        v13 = arg21 - arg19;
                        int v14 = (v13 - v9) / 2;
                        if(v14 < ((LayoutParams)v7).topMargin) {
                            v14 = ((LayoutParams)v7).topMargin;
                        }
                        else if(v14 + v9 > v13 - ((LayoutParams)v7).bottomMargin) {
                            v14 = v13 - ((LayoutParams)v7).bottomMargin - v9;
                        }

                        v6.layout(v10, v14, v8 + v10, v9 + v14);
                    }
                    else if(v13 != 80) {
                        v6.layout(v10, ((LayoutParams)v7).topMargin, v8 + v10, ((LayoutParams)v7).topMargin + v9);
                    }
                    else {
                        v9 = arg21 - arg19;
                        v6.layout(v10, v9 - ((LayoutParams)v7).bottomMargin - v6.getMeasuredHeight(), v8 + v10, v9 - ((LayoutParams)v7).bottomMargin);
                    }

                    if(v11_1 != 0) {
                        v0.setDrawerViewOffset(v6, v12);
                    }

                    v1 = ((LayoutParams)v7).onScreen > 0f ? 0 : 4;
                    if(v6.getVisibility() == v1) {
                        goto label_105;
                    }

                    v6.setVisibility(v1);
                }
            }

        label_105:
            ++v5;
            v1 = 1;
        }

        if(DrawerLayout.sEdgeSizeUsingSystemGestureInsets) {
            WindowInsets v1_1 = v0.getRootWindowInsets();
            if(v1_1 != null) {
                Insets v1_2 = WindowInsetsCompat.toWindowInsetsCompat(v1_1).getSystemGestureInsets();
                v0.mLeftDragger.setEdgeSize(Math.max(v0.mLeftDragger.getDefaultEdgeSize(), v1_2.left));
                v0.mRightDragger.setEdgeSize(Math.max(v0.mRightDragger.getDefaultEdgeSize(), v1_2.right));
            }
        }

        v0.mInLayout = false;
        v0.mFirstLayout = false;
    }

    protected void onMeasure(int arg18, int arg19) {
        WindowInsets v2_2;
        View v12;
        DrawerLayout v0 = this;
        int v1 = View$MeasureSpec.getMode(arg18);
        int v2 = View$MeasureSpec.getMode(arg19);
        int v3 = View$MeasureSpec.getSize(arg18);
        int v4 = View$MeasureSpec.getSize(arg19);
        int v5 = 0x40000000;
        if(v1 != v5 || v2 != v5) {
            if(v0.isInEditMode()) {
                int v6 = 300;
                if(v1 == 0) {
                    v3 = v6;
                }

                if(v2 != 0) {
                    goto label_15;
                }

                v4 = v6;
            }
            else {
                goto label_162;
            }
        }

    label_15:
        v0.setMeasuredDimension(v3, v4);
        v1 = v0.mLastInsets == null || !ViewCompat.getFitsSystemWindows(((View)v0)) ? 0 : 1;
        int v7 = ViewCompat.getLayoutDirection(((View)v0));
        int v8 = v0.getChildCount();
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        while(true) {
            if(v9 >= v8) {
                return;
            }

            v12 = v0.getChildAt(v9);
            if(v12.getVisibility() == 8) {
            }
            else {
                ViewGroup$LayoutParams v13 = v12.getLayoutParams();
                int v14 = 3;
                if(v1 != 0) {
                    int v15 = GravityCompat.getAbsoluteGravity(((LayoutParams)v13).gravity, v7);
                    boolean v16 = ViewCompat.getFitsSystemWindows(v12);
                    Object v2_1 = v0.mLastInsets;
                    v5 = 5;
                    if(v16) {
                        if(v15 == v14) {
                            v2_2 = ((WindowInsets)v2_1).replaceSystemWindowInsets(((WindowInsets)v2_1).getSystemWindowInsetLeft(), ((WindowInsets)v2_1).getSystemWindowInsetTop(), 0, ((WindowInsets)v2_1).getSystemWindowInsetBottom());
                        }
                        else if(v15 == v5) {
                            v2_2 = ((WindowInsets)v2_1).replaceSystemWindowInsets(0, ((WindowInsets)v2_1).getSystemWindowInsetTop(), ((WindowInsets)v2_1).getSystemWindowInsetRight(), ((WindowInsets)v2_1).getSystemWindowInsetBottom());
                        }

                        v12.dispatchApplyWindowInsets(((WindowInsets)v2_1));
                    }
                    else {
                        if(v15 == 3) {
                            v2_2 = ((WindowInsets)v2_1).replaceSystemWindowInsets(((WindowInsets)v2_1).getSystemWindowInsetLeft(), ((WindowInsets)v2_1).getSystemWindowInsetTop(), 0, ((WindowInsets)v2_1).getSystemWindowInsetBottom());
                        }
                        else if(v15 == v5) {
                            v2_2 = ((WindowInsets)v2_1).replaceSystemWindowInsets(0, ((WindowInsets)v2_1).getSystemWindowInsetTop(), ((WindowInsets)v2_1).getSystemWindowInsetRight(), ((WindowInsets)v2_1).getSystemWindowInsetBottom());
                        }

                        ((LayoutParams)v13).leftMargin = ((WindowInsets)v2_1).getSystemWindowInsetLeft();
                        ((LayoutParams)v13).topMargin = ((WindowInsets)v2_1).getSystemWindowInsetTop();
                        ((LayoutParams)v13).rightMargin = ((WindowInsets)v2_1).getSystemWindowInsetRight();
                        ((LayoutParams)v13).bottomMargin = ((WindowInsets)v2_1).getSystemWindowInsetBottom();
                    }
                }

                if(v0.isContentView(v12)) {
                    v12.measure(View$MeasureSpec.makeMeasureSpec(v3 - ((LayoutParams)v13).leftMargin - ((LayoutParams)v13).rightMargin, 0x40000000), View$MeasureSpec.makeMeasureSpec(v4 - ((LayoutParams)v13).topMargin - ((LayoutParams)v13).bottomMargin, 0x40000000));
                    goto label_145;
                }

                if(!v0.isDrawerView(v12)) {
                    break;
                }

                if(DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
                    float v2_3 = ViewCompat.getElevation(v12);
                    float v14_1 = v0.mDrawerElevation;
                    if(v2_3 != v14_1) {
                        ViewCompat.setElevation(v12, v14_1);
                    }
                }

                v2 = v0.getDrawerViewAbsoluteGravity(v12) & 7;
                v14 = v2 == 3 ? 1 : 0;
                if(v14 != 0 && v10 != 0) {
                label_115:
                    throw new IllegalStateException("Child drawer has absolute gravity " + DrawerLayout.gravityToString(v2) + " but this DrawerLayout already has a drawer view along that edge");
                }
                else if(v14 == 0) {
                    if(v11 == 0) {
                    }
                    else {
                        goto label_115;
                    }
                }

                if(v14 != 0) {
                    v10 = 1;
                }
                else {
                    v11 = 1;
                }

                v12.measure(DrawerLayout.getChildMeasureSpec(arg18, v0.mMinDrawerMargin + ((LayoutParams)v13).leftMargin + ((LayoutParams)v13).rightMargin, ((LayoutParams)v13).width), DrawerLayout.getChildMeasureSpec(arg19, ((LayoutParams)v13).topMargin + ((LayoutParams)v13).bottomMargin, ((LayoutParams)v13).height));
            }

        label_145:
            ++v9;
        }

        throw new IllegalStateException("Child " + v12 + " at index " + v9 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
        return;
    label_162:
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }

    protected void onRestoreInstanceState(Parcelable arg4) {
        if(!(arg4 instanceof SavedState)) {
            super.onRestoreInstanceState(arg4);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg4).getSuperState());
        if(((SavedState)arg4).openDrawerGravity != 0) {
            View v0 = this.findDrawerWithGravity(((SavedState)arg4).openDrawerGravity);
            if(v0 != null) {
                this.openDrawer(v0);
            }
        }

        int v1 = 3;
        if(((SavedState)arg4).lockModeLeft != v1) {
            this.setDrawerLockMode(((SavedState)arg4).lockModeLeft, v1);
        }

        if(((SavedState)arg4).lockModeRight != v1) {
            this.setDrawerLockMode(((SavedState)arg4).lockModeRight, 5);
        }

        if(((SavedState)arg4).lockModeStart != v1) {
            this.setDrawerLockMode(((SavedState)arg4).lockModeStart, 0x800003);
        }

        if(((SavedState)arg4).lockModeEnd != v1) {
            this.setDrawerLockMode(((SavedState)arg4).lockModeEnd, 0x800005);
        }
    }

    public void onRtlPropertiesChanged(int arg1) {
        this.resolveShadowDrawables();
    }

    protected Parcelable onSaveInstanceState() {
        ViewGroup$LayoutParams v4;
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        int v0 = this.getChildCount();
        int v3 = 0;
        while(true) {
            if(v3 < v0) {
                v4 = this.getChildAt(v3).getLayoutParams();
                int v6 = 1;
                int v5 = ((LayoutParams)v4).openState == 1 ? 1 : 0;
                if(((LayoutParams)v4).openState == 2) {
                }
                else {
                    v6 = 0;
                }

                if(v5 == 0) {
                    if(v6 != 0) {
                    }
                    else {
                        ++v3;
                        continue;
                    }
                }

                break;
            }

            goto label_27;
        }

        v1.openDrawerGravity = ((LayoutParams)v4).gravity;
    label_27:
        v1.lockModeLeft = this.mLockModeLeft;
        v1.lockModeRight = this.mLockModeRight;
        v1.lockModeStart = this.mLockModeStart;
        v1.lockModeEnd = this.mLockModeEnd;
        return ((Parcelable)v1);
    }

    public boolean onTouchEvent(MotionEvent arg7) {
        float v7;
        float v0_1;
        this.mLeftDragger.processTouchEvent(arg7);
        this.mRightDragger.processTouchEvent(arg7);
        int v0 = arg7.getAction() & 0xFF;
        boolean v1 = false;
        if(v0 == 0) {
            v0_1 = arg7.getX();
            v7 = arg7.getY();
            this.mInitialMotionX = v0_1;
            this.mInitialMotionY = v7;
            this.mChildrenCanceledTouch = false;
        }
        else if(v0 == 1) {
            v0_1 = arg7.getX();
            v7 = arg7.getY();
            View v3 = this.mLeftDragger.findTopChildUnder(((int)v0_1), ((int)v7));
            if(v3 == null || !this.isContentView(v3)) {
            label_42:
                v1 = true;
            }
            else {
                v0_1 -= this.mInitialMotionX;
                v7 -= this.mInitialMotionY;
                int v3_1 = this.mLeftDragger.getTouchSlop();
                if(v0_1 * v0_1 + v7 * v7 < (((float)(v3_1 * v3_1)))) {
                    View v7_1 = this.findOpenDrawer();
                    if(v7_1 == null) {
                        goto label_42;
                    }
                    else if(this.getDrawerLockMode(v7_1) == 2) {
                        goto label_42;
                    }
                }
                else {
                    goto label_42;
                }
            }

            this.closeDrawers(v1);
        }
        else if(v0 != 3) {
        }
        else {
            this.closeDrawers(true);
            this.mChildrenCanceledTouch = false;
        }

        return 1;
    }

    public void open() {
        this.openDrawer(0x800003);
    }

    public void openDrawer(int arg2) {
        this.openDrawer(arg2, true);
    }

    public void openDrawer(View arg2) {
        this.openDrawer(arg2, true);
    }

    public void openDrawer(int arg2, boolean arg3) {
        View v0 = this.findDrawerWithGravity(arg2);
        if(v0 != null) {
            this.openDrawer(v0, arg3);
            return;
        }

        throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.gravityToString(arg2));
    }

    public void openDrawer(View arg4, boolean arg5) {
        if(this.isDrawerView(arg4)) {
            ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
            float v2 = 1f;
            if(this.mFirstLayout) {
                ((LayoutParams)v0).onScreen = v2;
                ((LayoutParams)v0).openState = 1;
                this.updateChildrenImportantForAccessibility(arg4, true);
                this.updateChildAccessibilityAction(arg4);
            }
            else if(arg5) {
                ((LayoutParams)v0).openState |= 2;
                if(this.checkDrawerViewAbsoluteGravity(arg4, 3)) {
                    this.mLeftDragger.smoothSlideViewTo(arg4, 0, arg4.getTop());
                }
                else {
                    this.mRightDragger.smoothSlideViewTo(arg4, this.getWidth() - arg4.getWidth(), arg4.getTop());
                }
            }
            else {
                this.moveDrawerToOffset(arg4, v2);
                this.updateDrawerState(0, arg4);
                arg4.setVisibility(0);
            }

            this.invalidate();
            return;
        }

        throw new IllegalArgumentException("View " + arg4 + " is not a sliding drawer");
    }

    public void removeDrawerListener(DrawerListener arg1) {
        List v0;
        if(arg1 == null) {
        }
        else {
            v0 = this.mListeners;
            if(v0 == null) {
                return;
            }

            goto label_5;
        }

        return;
    label_5:
        v0.remove(arg1);
    }

    public void requestDisallowInterceptTouchEvent(boolean arg1) {
        super.requestDisallowInterceptTouchEvent(arg1);
        if(arg1) {
            this.closeDrawers(true);
        }
    }

    public void requestLayout() {
        if(!this.mInLayout) {
            super.requestLayout();
        }
    }

    private Drawable resolveLeftShadow() {
        Drawable v1;
        int v0 = ViewCompat.getLayoutDirection(((View)this));
        if(v0 == 0) {
            v1 = this.mShadowStart;
            if(v1 != null) {
                this.mirror(v1, v0);
                return this.mShadowStart;
            }
        }
        else {
            v1 = this.mShadowEnd;
            if(v1 != null) {
                this.mirror(v1, v0);
                return this.mShadowEnd;
            }
        }

        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        Drawable v1;
        int v0 = ViewCompat.getLayoutDirection(((View)this));
        if(v0 == 0) {
            v1 = this.mShadowEnd;
            if(v1 != null) {
                this.mirror(v1, v0);
                return this.mShadowEnd;
            }
        }
        else {
            v1 = this.mShadowStart;
            if(v1 != null) {
                this.mirror(v1, v0);
                return this.mShadowStart;
            }
        }

        return this.mShadowRight;
    }

    private void resolveShadowDrawables() {
        if(DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }

        this.mShadowLeftResolved = this.resolveLeftShadow();
        this.mShadowRightResolved = this.resolveRightShadow();
    }

    public void setChildInsets(Object arg1, boolean arg2) {
        this.mLastInsets = arg1;
        this.mDrawStatusBarBackground = arg2;
        boolean v1 = (arg2) || this.getBackground() != null ? false : true;
        this.setWillNotDraw(v1);
        this.requestLayout();
    }

    public void setDrawerElevation(float arg3) {
        this.mDrawerElevation = arg3;
        int v3;
        for(v3 = 0; v3 < this.getChildCount(); ++v3) {
            View v0 = this.getChildAt(v3);
            if(this.isDrawerView(v0)) {
                ViewCompat.setElevation(v0, this.mDrawerElevation);
            }
        }
    }

    @Deprecated public void setDrawerListener(DrawerListener arg2) {
        DrawerListener v0 = this.mListener;
        if(v0 != null) {
            this.removeDrawerListener(v0);
        }

        if(arg2 != null) {
            this.addDrawerListener(arg2);
        }

        this.mListener = arg2;
    }

    public void setDrawerLockMode(int arg4, int arg5) {
        View v4;
        int v0 = GravityCompat.getAbsoluteGravity(arg5, ViewCompat.getLayoutDirection(((View)this)));
        int v1 = 3;
        if(arg5 == v1) {
            this.mLockModeLeft = arg4;
        }
        else if(arg5 == 5) {
            this.mLockModeRight = arg4;
        }
        else if(arg5 == 0x800003) {
            this.mLockModeStart = arg4;
        }
        else if(arg5 != 0x800005) {
        }
        else {
            this.mLockModeEnd = arg4;
        }

        if(arg4 != 0) {
            ViewDragHelper v5 = v0 == v1 ? this.mLeftDragger : this.mRightDragger;
            v5.cancel();
        }

        if(arg4 == 1) {
            v4 = this.findDrawerWithGravity(v0);
            if(v4 != null) {
                this.closeDrawer(v4);
            }
        }
        else if(arg4 != 2) {
        }
        else {
            v4 = this.findDrawerWithGravity(v0);
            if(v4 != null) {
                this.openDrawer(v4);
                return;
            }
        }
    }

    public void setDrawerLockMode(int arg2) {
        this.setDrawerLockMode(arg2, 3);
        this.setDrawerLockMode(arg2, 5);
    }

    public void setDrawerLockMode(int arg2, View arg3) {
        if(this.isDrawerView(arg3)) {
            this.setDrawerLockMode(arg2, arg3.getLayoutParams().gravity);
            return;
        }

        throw new IllegalArgumentException("View " + arg3 + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(int arg2, int arg3) {
        this.setDrawerShadow(ContextCompat.getDrawable(this.getContext(), arg2), arg3);
    }

    public void setDrawerShadow(Drawable arg3, int arg4) {
        if(DrawerLayout.SET_DRAWER_SHADOW_FROM_ELEVATION) {
        }
        else {
            if((arg4 & 0x800003) == 0x800003) {
                this.mShadowStart = arg3;
            }
            else if((arg4 & 0x800005) == 0x800005) {
                this.mShadowEnd = arg3;
            }
            else if((arg4 & 3) == 3) {
                this.mShadowLeft = arg3;
            }
            else if((arg4 & 5) == 5) {
                this.mShadowRight = arg3;
            }
            else {
                return;
            }

            this.resolveShadowDrawables();
            this.invalidate();
        }
    }

    public void setDrawerTitle(int arg2, CharSequence arg3) {
        arg2 = GravityCompat.getAbsoluteGravity(arg2, ViewCompat.getLayoutDirection(((View)this)));
        if(arg2 == 3) {
            this.mTitleLeft = arg3;
            return;
        }

        if(arg2 == 5) {
            this.mTitleRight = arg3;
        }
    }

    void setDrawerViewOffset(View arg3, float arg4) {
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        if(arg4 == ((LayoutParams)v0).onScreen) {
            return;
        }

        ((LayoutParams)v0).onScreen = arg4;
        this.dispatchOnDrawerSlide(arg3, arg4);
    }

    public void setScrimColor(int arg1) {
        this.mScrimColor = arg1;
        this.invalidate();
    }

    public void setStatusBarBackground(int arg2) {
        Drawable v2 = arg2 != 0 ? ContextCompat.getDrawable(this.getContext(), arg2) : null;
        this.mStatusBarBackground = v2;
        this.invalidate();
    }

    public void setStatusBarBackground(Drawable arg1) {
        this.mStatusBarBackground = arg1;
        this.invalidate();
    }

    public void setStatusBarBackgroundColor(int arg2) {
        this.mStatusBarBackground = new ColorDrawable(arg2);
        this.invalidate();
    }

    private void updateChildAccessibilityAction(View arg3) {
        ViewCompat.removeAccessibilityAction(arg3, AccessibilityActionCompat.ACTION_DISMISS.getId());
        if((this.isDrawerOpen(arg3)) && this.getDrawerLockMode(arg3) != 2) {
            ViewCompat.replaceAccessibilityAction(arg3, AccessibilityActionCompat.ACTION_DISMISS, null, this.mActionDismiss);
        }
    }

    private void updateChildrenImportantForAccessibility(View arg5, boolean arg6) {
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getChildAt(v1);
            if((arg6) || (this.isDrawerView(v2))) {
                if((arg6) && v2 == arg5) {
                label_9:
                    ViewCompat.setImportantForAccessibility(v2, 1);
                    goto label_14;
                }

                ViewCompat.setImportantForAccessibility(v2, 4);
            }
            else {
                goto label_9;
            }

        label_14:
        }
    }

    void updateDrawerState(int arg5, View arg6) {
        int v3;
        int v0 = this.mLeftDragger.getViewDragState();
        int v1 = this.mRightDragger.getViewDragState();
        if(v0 == 1 || v1 == 1) {
            v3 = 1;
        }
        else {
            v3 = 2;
            if(v0 != v3) {
                if(v1 == v3) {
                }
                else {
                    v3 = 0;
                }
            }
        }

        if(arg6 != null && arg5 == 0) {
            ViewGroup$LayoutParams v5 = arg6.getLayoutParams();
            if(((LayoutParams)v5).onScreen == 0f) {
                this.dispatchOnDrawerClosed(arg6);
            }
            else if(((LayoutParams)v5).onScreen == 1f) {
                this.dispatchOnDrawerOpened(arg6);
            }
        }

        if(v3 != this.mDrawerState) {
            this.mDrawerState = v3;
            List v5_1 = this.mListeners;
            if(v5_1 != null) {
                for(arg5 = v5_1.size() - 1; arg5 >= 0; --arg5) {
                    this.mListeners.get(arg5).onDrawerStateChanged(v3);
                }
            }
        }
    }
}

