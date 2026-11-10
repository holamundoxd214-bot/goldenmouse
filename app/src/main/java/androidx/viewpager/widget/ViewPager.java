package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    final class androidx.viewpager.widget.ViewPager$1 implements Comparator {
        androidx.viewpager.widget.ViewPager$1() {
            super();
        }

        public int compare(ItemInfo arg1, ItemInfo arg2) {
            return arg1.position - arg2.position;
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((ItemInfo)arg1), ((ItemInfo)arg2));
        }
    }

    final class androidx.viewpager.widget.ViewPager$2 implements Interpolator {
        androidx.viewpager.widget.ViewPager$2() {
            super();
        }

        public float getInterpolation(float arg2) {
            --arg2;
            return arg2 * arg2 * arg2 * arg2 * arg2 + 1f;
        }
    }

    class androidx.viewpager.widget.ViewPager$3 implements Runnable {
        androidx.viewpager.widget.ViewPager$3(ViewPager arg1) {
            ViewPager.this = arg1;
            super();
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    }

    @Inherited @Retention(value=RetentionPolicy.RUNTIME) @Target(value={ElementType.TYPE}) @public interface DecorView {
    }

    class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
            super();
        }
    }

    public class LayoutParams extends ViewGroup$LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(-1, -1);
            this.widthFactor = 0f;
        }

        public LayoutParams(Context arg2, AttributeSet arg3) {
            super(arg2, arg3);
            this.widthFactor = 0f;
            TypedArray v2 = arg2.obtainStyledAttributes(arg3, ViewPager.LAYOUT_ATTRS);
            this.gravity = v2.getInteger(0, 0x30);
            v2.recycle();
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate(ViewPager arg1) {
            ViewPager.this = arg1;
            super();
        }

        private boolean canScroll() {
            if(ViewPager.this.mAdapter != null && ViewPager.this.mAdapter.getCount() > 1) {
                return 1;
            }

            return 0;
        }

        public void onInitializeAccessibilityEvent(View arg2, AccessibilityEvent arg3) {
            super.onInitializeAccessibilityEvent(arg2, arg3);
            arg3.setClassName(ViewPager.class.getName());
            arg3.setScrollable(this.canScroll());
            if(arg3.getEventType() == 0x1000 && ViewPager.this.mAdapter != null) {
                arg3.setItemCount(ViewPager.this.mAdapter.getCount());
                arg3.setFromIndex(ViewPager.this.mCurItem);
                arg3.setToIndex(ViewPager.this.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
            super.onInitializeAccessibilityNodeInfo(arg2, arg3);
            arg3.setClassName(ViewPager.class.getName());
            arg3.setScrollable(this.canScroll());
            if(ViewPager.this.canScrollHorizontally(1)) {
                arg3.addAction(0x1000);
            }

            if(ViewPager.this.canScrollHorizontally(-1)) {
                arg3.addAction(0x2000);
            }
        }

        public boolean performAccessibilityAction(View arg2, int arg3, Bundle arg4) {
            if(super.performAccessibilityAction(arg2, arg3, arg4)) {
                return 1;
            }

            if(arg3 != 0x1000) {
                if(arg3 != 0x2000) {
                    return 0;
                }

                if(ViewPager.this.canScrollHorizontally(-1)) {
                    ViewPager.this.setCurrentItem(ViewPager.this.mCurItem - 1);
                    return 1;
                }

                return 0;
            }

            if(ViewPager.this.canScrollHorizontally(1)) {
                ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
                return 1;
            }

            return 0;
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(ViewPager arg1, PagerAdapter arg2, PagerAdapter arg3);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int arg1);

        void onPageScrolled(int arg1, float arg2, int arg3);

        void onPageSelected(int arg1);
    }

    public interface PageTransformer {
        void transformPage(View arg1, float arg2);
    }

    class PagerObserver extends DataSetObserver {
        PagerObserver(ViewPager arg1) {
            ViewPager.this = arg1;
            super();
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public class SavedState extends AbsSavedState {
        final class androidx.viewpager.widget.ViewPager$SavedState$1 implements Parcelable$ClassLoaderCreator {
            androidx.viewpager.widget.ViewPager$SavedState$1() {
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
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        static {
            SavedState.CREATOR = new androidx.viewpager.widget.ViewPager$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg2, ClassLoader arg3) {
            super(arg2, arg3);
            if(arg3 == null) {
                arg3 = this.getClass().getClassLoader();
            }

            this.position = arg2.readInt();
            this.adapterState = arg2.readParcelable(arg3);
            this.loader = arg3;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeInt(this.position);
            arg2.writeParcelable(this.adapterState, arg3);
        }
    }

    public class SimpleOnPageChangeListener implements OnPageChangeListener {
        public SimpleOnPageChangeListener() {
            super();
        }

        public void onPageScrollStateChanged(int arg1) {
        }

        public void onPageScrolled(int arg1, float arg2, int arg3) {
        }

        public void onPageSelected(int arg1) {
        }
    }

    class ViewPositionComparator implements Comparator {
        ViewPositionComparator() {
            super();
        }

        public int compare(View arg2, View arg3) {
            ViewGroup$LayoutParams v1 = arg2.getLayoutParams();
            ViewGroup$LayoutParams v2 = arg3.getLayoutParams();
            if(((LayoutParams)v1).isDecor != ((LayoutParams)v2).isDecor) {
                if(((LayoutParams)v1).isDecor) {
                    return 1;
                }

                return -1;
            }

            return ((LayoutParams)v1).position - ((LayoutParams)v2).position;
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((View)arg1), ((View)arg2));
        }
    }

    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator COMPARATOR = null;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = null;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    PagerAdapter mAdapter;
    private List mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private OnPageChangeListener mOnPageChangeListener;
    private List mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final Interpolator sInterpolator;
    private static final ViewPositionComparator sPositionComparator;

    static {
        ViewPager.LAYOUT_ATTRS = new int[]{0x10100B3};
        ViewPager.COMPARATOR = new androidx.viewpager.widget.ViewPager$1();
        ViewPager.sInterpolator = new androidx.viewpager.widget.ViewPager$2();
        ViewPager.sPositionComparator = new ViewPositionComparator();
    }

    public ViewPager(Context arg2) {
        super(arg2);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.402823E+38f;
        this.mLastOffset = 3.402823E+38f;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new androidx.viewpager.widget.ViewPager$3(this);
        this.mScrollState = 0;
        this.initViewPager();
    }

    public ViewPager(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.402823E+38f;
        this.mLastOffset = 3.402823E+38f;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new androidx.viewpager.widget.ViewPager$3(this);
        this.mScrollState = 0;
        this.initViewPager();
    }

    public void addFocusables(ArrayList arg7, int arg8, int arg9) {
        int v0 = arg7.size();
        int v1 = this.getDescendantFocusability();
        if(v1 != 0x60000) {
            int v2;
            for(v2 = 0; v2 < this.getChildCount(); ++v2) {
                View v3 = this.getChildAt(v2);
                if(v3.getVisibility() == 0) {
                    ItemInfo v4 = this.infoForChild(v3);
                    if(v4 != null && v4.position == this.mCurItem) {
                        v3.addFocusables(arg7, arg8, arg9);
                    }
                }
            }
        }

        if(v1 != 0x40000 || v0 == arg7.size()) {
            if(!this.isFocusable()) {
            }
            else {
                if((arg9 & 1) == 1 && (this.isInTouchMode()) && !this.isFocusableInTouchMode()) {
                    return;
                }

                if(arg7 == null) {
                    return;
                }

                arg7.add(this);
            }
        }
    }

    ItemInfo addNewItem(int arg3, int arg4) {
        ItemInfo v0 = new ItemInfo();
        v0.position = arg3;
        v0.object = this.mAdapter.instantiateItem(((ViewGroup)this), arg3);
        v0.widthFactor = this.mAdapter.getPageWidth(arg3);
        if(arg4 >= 0) {
            if(arg4 >= this.mItems.size()) {
            }
            else {
                this.mItems.add(arg4, v0);
                return v0;
            }
        }

        this.mItems.add(v0);
        return v0;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener arg2) {
        if(this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }

        this.mAdapterChangeListeners.add(arg2);
    }

    public void addOnPageChangeListener(OnPageChangeListener arg2) {
        if(this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }

        this.mOnPageChangeListeners.add(arg2);
    }

    public void addTouchables(ArrayList arg5) {
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            View v1 = this.getChildAt(v0);
            if(v1.getVisibility() == 0) {
                ItemInfo v2 = this.infoForChild(v1);
                if(v2 != null && v2.position == this.mCurItem) {
                    v1.addTouchables(arg5);
                }
            }
        }
    }

    public void addView(View arg4, int arg5, ViewGroup$LayoutParams arg6) {
        if(!this.checkLayoutParams(arg6)) {
            arg6 = this.generateLayoutParams(arg6);
        }

        ViewGroup$LayoutParams v0 = arg6;
        ((LayoutParams)v0).isDecor |= ViewPager.isDecorView(arg4);
        if(this.mInLayout) {
            if(v0 != null) {
                if(!((LayoutParams)v0).isDecor) {
                }
                else {
                    throw new IllegalStateException("Cannot add pager decor view during layout");
                }
            }

            ((LayoutParams)v0).needsMeasure = true;
            this.addViewInLayout(arg4, arg5, arg6);
            return;
        }

        super.addView(arg4, arg5, arg6);
    }

    public boolean arrowScroll(int arg6) {
        boolean v0_2;
        View v0 = this.findFocus();
        View v1 = null;
        if((((ViewPager)v0)) == this) {
        label_3:
            v0 = v1;
        }
        else if(v0 != null) {
            ViewParent v2 = v0.getParent();
            while(true) {
                if(!(v2 instanceof ViewGroup)) {
                    break;
                }
                else if((((ViewPager)v2)) == this) {
                }
                else {
                    v2 = v2.getParent();
                    continue;
                }

                goto label_37;
            }

            StringBuilder v2_1 = new StringBuilder();
            v2_1.append(v0.getClass().getSimpleName());
            ViewParent v0_1;
            for(v0_1 = v0.getParent(); (v0_1 instanceof ViewGroup); v0_1 = v0_1.getParent()) {
                v2_1.append(" => ").append(v0_1.getClass().getSimpleName());
            }

            Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + v2_1.toString());
            goto label_3;
        }

    label_37:
        v1 = FocusFinder.getInstance().findNextFocus(((ViewGroup)this), v0, arg6);
        int v2_2 = 66;
        int v3 = 17;
        if(v1 == null || v1 == v0) {
            if(arg6 != v3) {
                if(arg6 == 1) {
                }
                else {
                    if(arg6 != v2_2) {
                        if(arg6 == 2) {
                        }
                        else {
                        label_77:
                            v0_2 = false;
                            goto label_82;
                        }
                    }

                    v0_2 = this.pageRight();
                    goto label_82;
                }
            }

            v0_2 = this.pageLeft();
        }
        else if(arg6 == v3) {
            v2_2 = this.getChildRectInPagerCoordinates(this.mTempRect, v1).left;
            v3 = this.getChildRectInPagerCoordinates(this.mTempRect, v0).left;
            if(v0 != null && v2_2 >= v3) {
                v0_2 = this.pageLeft();
                goto label_82;
            }

            v0_2 = v1.requestFocus();
        }
        else {
            if(arg6 != v2_2) {
                goto label_77;
            }

            v2_2 = this.getChildRectInPagerCoordinates(this.mTempRect, v1).left;
            v3 = this.getChildRectInPagerCoordinates(this.mTempRect, v0).left;
            if(v0 != null && v2_2 <= v3) {
                v0_2 = this.pageRight();
                goto label_82;
            }

            v0_2 = v1.requestFocus();
        }

    label_82:
        if(v0_2) {
            this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(arg6));
        }

        return v0_2;
    }

    public boolean beginFakeDrag() {
        if(this.mIsBeingDragged) {
            return 0;
        }

        this.mFakeDragging = true;
        this.setScrollState(1);
        this.mLastMotionX = 0f;
        this.mInitialMotionX = 0f;
        VelocityTracker v1 = this.mVelocityTracker;
        if(v1 == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        else {
            v1.clear();
        }

        long v2 = SystemClock.uptimeMillis();
        MotionEvent v1_1 = MotionEvent.obtain(v2, v2, 0, 0f, 0f, 0);
        this.mVelocityTracker.addMovement(v1_1);
        v1_1.recycle();
        this.mFakeDragBeginTime = v2;
        return 1;
    }

    private void calculatePageOffsets(ItemInfo arg11, int arg12, ItemInfo arg13) {
        int v4_1;
        int v13;
        int v0 = this.mAdapter.getCount();
        int v1 = this.getClientWidth();
        float v2 = v1 > 0 ? (((float)this.mPageMargin)) / (((float)v1)) : 0f;
        if(arg13 != null) {
            int v3 = arg13.position;
            if(v3 < arg11.position) {
                float v4 = arg13.offset + arg13.widthFactor + v2;
                ++v3;
                v13 = 0;
                while(v3 <= arg11.position) {
                    if(v13 >= this.mItems.size()) {
                        break;
                    }

                    Object v5;
                    for(v5 = this.mItems.get(v13); v3 > ((ItemInfo)v5).position; v5 = this.mItems.get(v13)) {
                        if(v13 >= this.mItems.size() - 1) {
                            break;
                        }

                        ++v13;
                    }

                    while(v3 < ((ItemInfo)v5).position) {
                        v4 += this.mAdapter.getPageWidth(v3) + v2;
                        ++v3;
                    }

                    ((ItemInfo)v5).offset = v4;
                    v4 += ((ItemInfo)v5).widthFactor + v2;
                    ++v3;
                }
            }
            else {
                if(v3 <= arg11.position) {
                    goto label_85;
                }

                v4_1 = this.mItems.size() - 1;
                float v13_1 = arg13.offset;
                --v3;
                while(v3 >= arg11.position) {
                    if(v4_1 < 0) {
                        break;
                    }

                    for(v5 = this.mItems.get(v4_1); v3 < ((ItemInfo)v5).position; v5 = this.mItems.get(v4_1)) {
                        if(v4_1 <= 0) {
                            break;
                        }

                        --v4_1;
                    }

                    while(v3 > ((ItemInfo)v5).position) {
                        v13_1 -= this.mAdapter.getPageWidth(v3) + v2;
                        --v3;
                    }

                    v13_1 -= ((ItemInfo)v5).widthFactor + v2;
                    ((ItemInfo)v5).offset = v13_1;
                    --v3;
                }
            }
        }

    label_85:
        v13 = this.mItems.size();
        float v3_1 = arg11.offset;
        v4_1 = arg11.position - 1;
        float v5_1 = arg11.position == 0 ? arg11.offset : -3.402823E+38f;
        this.mFirstOffset = v5_1;
        --v0;
        float v6 = 1f;
        v5_1 = arg11.position == v0 ? arg11.offset + arg11.widthFactor - v6 : 3.402823E+38f;
        this.mLastOffset = v5_1;
        int v5_2 = arg12 - 1;
        while(v5_2 >= 0) {
            Object v7 = this.mItems.get(v5_2);
            while(v4_1 > ((ItemInfo)v7).position) {
                v3_1 -= this.mAdapter.getPageWidth(v4_1) + v2;
                --v4_1;
            }

            v3_1 -= ((ItemInfo)v7).widthFactor + v2;
            ((ItemInfo)v7).offset = v3_1;
            if(((ItemInfo)v7).position == 0) {
                this.mFirstOffset = v3_1;
            }

            --v5_2;
            --v4_1;
        }

        v3_1 = arg11.offset + arg11.widthFactor + v2;
        int v11 = arg11.position + 1;
        ++arg12;
        while(arg12 < v13) {
            Object v4_2 = this.mItems.get(arg12);
            while(v11 < ((ItemInfo)v4_2).position) {
                v3_1 += this.mAdapter.getPageWidth(v11) + v2;
                ++v11;
            }

            if(((ItemInfo)v4_2).position == v0) {
                this.mLastOffset = ((ItemInfo)v4_2).widthFactor + v3_1 - v6;
            }

            ((ItemInfo)v4_2).offset = v3_1;
            v3_1 += ((ItemInfo)v4_2).widthFactor + v2;
            ++arg12;
            ++v11;
        }

        this.mNeedCalculatePageOffsets = false;
    }

    protected boolean canScroll(View arg12, boolean arg13, int arg14, int arg15, int arg16) {
        if((arg12 instanceof ViewGroup)) {
            View v0 = arg12;
            int v2 = arg12.getScrollX();
            int v3 = arg12.getScrollY();
            int v4;
            for(v4 = ((ViewGroup)v0).getChildCount() - 1; v4 >= 0; --v4) {
                View v6 = ((ViewGroup)v0).getChildAt(v4);
                int v5 = arg15 + v2;
                if(v5 >= v6.getLeft() && v5 < v6.getRight()) {
                    int v7 = arg16 + v3;
                    if(v7 >= v6.getTop() && v7 < v6.getBottom() && (this.canScroll(v6, true, arg14, v5 - v6.getLeft(), v7 - v6.getTop()))) {
                        return 1;
                    }
                }
            }
        }

        if((arg13) && (arg12.canScrollHorizontally(-arg14))) {
            return 1;
        }

        return 0;
    }

    public boolean canScrollHorizontally(int arg5) {
        if(this.mAdapter == null) {
            return 0;
        }

        int v0 = this.getClientWidth();
        int v2 = this.getScrollX();
        if(arg5 < 0) {
            if(v2 > (((int)((((float)v0)) * this.mFirstOffset)))) {
                return 1;
            }

            return 0;
        }

        if(arg5 > 0 && v2 < (((int)((((float)v0)) * this.mLastOffset)))) {
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

    public void clearOnPageChangeListeners() {
        List v0 = this.mOnPageChangeListeners;
        if(v0 != null) {
            v0.clear();
        }
    }

    private void completeScroll(boolean arg8) {
        int v1;
        int v0 = this.mScrollState == 2 ? 1 : 0;
        if(v0 != 0) {
            this.setScrollingCacheEnabled(false);
            if(!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                v1 = this.getScrollX();
                int v4 = this.getScrollY();
                int v5 = this.mScroller.getCurrX();
                int v6 = this.mScroller.getCurrY();
                if(v1 == v5 && v4 == v6) {
                    goto label_26;
                }

                this.scrollTo(v5, v6);
                if(v5 == v1) {
                    goto label_26;
                }

                this.pageScrolled(v5);
            }
        }

    label_26:
        this.mPopulatePending = false;
        for(v1 = 0; v1 < this.mItems.size(); ++v1) {
            Object v4_1 = this.mItems.get(v1);
            if(((ItemInfo)v4_1).scrolling) {
                ((ItemInfo)v4_1).scrolling = false;
                v0 = 1;
            }
        }

        if(v0 != 0) {
            Runnable v0_1 = this.mEndScrollRunnable;
            if(arg8) {
                ViewCompat.postOnAnimation(((View)this), v0_1);
                return;
            }
            else {
                v0_1.run();
            }
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if(!this.mScroller.isFinished() && (this.mScroller.computeScrollOffset())) {
            int v0 = this.getScrollX();
            int v1 = this.getScrollY();
            int v2 = this.mScroller.getCurrX();
            int v3 = this.mScroller.getCurrY();
            if(v0 != v2 || v1 != v3) {
                this.scrollTo(v2, v3);
                if(!this.pageScrolled(v2)) {
                    this.mScroller.abortAnimation();
                    this.scrollTo(0, v3);
                }
            }

            ViewCompat.postInvalidateOnAnimation(((View)this));
            return;
        }

        this.completeScroll(true);
    }

    void dataSetChanged() {
        int v0 = this.mAdapter.getCount();
        this.mExpectedAdapterCount = v0;
        int v1 = this.mItems.size() >= this.mOffscreenPageLimit * 2 + 1 || this.mItems.size() >= v0 ? 0 : 1;
        int v2 = this.mCurItem;
        int v5 = 0;
        int v6 = 0;
        while(v5 < this.mItems.size()) {
            Object v7 = this.mItems.get(v5);
            int v8 = this.mAdapter.getItemPosition(((ItemInfo)v7).object);
            if(v8 == -1) {
            }
            else {
                if(v8 == -2) {
                    this.mItems.remove(v5);
                    --v5;
                    if(v6 == 0) {
                        this.mAdapter.startUpdate(((ViewGroup)this));
                        v6 = 1;
                    }

                    this.mAdapter.destroyItem(((ViewGroup)this), ((ItemInfo)v7).position, ((ItemInfo)v7).object);
                    if(this.mCurItem != ((ItemInfo)v7).position) {
                        goto label_52;
                    }

                    v2 = Math.max(0, Math.min(this.mCurItem, v0 - 1));
                }
                else {
                    if(((ItemInfo)v7).position == v8) {
                        goto label_62;
                    }

                    if(((ItemInfo)v7).position == this.mCurItem) {
                        v2 = v8;
                    }

                    ((ItemInfo)v7).position = v8;
                }

            label_52:
                v1 = 1;
            }

        label_62:
            ++v5;
        }

        if(v6 != 0) {
            this.mAdapter.finishUpdate(((ViewGroup)this));
        }

        Collections.sort(this.mItems, ViewPager.COMPARATOR);
        if(v1 != 0) {
            v0 = this.getChildCount();
            for(v1 = 0; v1 < v0; ++v1) {
                ViewGroup$LayoutParams v5_1 = this.getChildAt(v1).getLayoutParams();
                if(!((LayoutParams)v5_1).isDecor) {
                    ((LayoutParams)v5_1).widthFactor = 0f;
                }
            }

            this.setCurrentItemInternal(v2, false, true);
            this.requestLayout();
        }
    }

    private int determineTargetPage(int arg2, float arg3, int arg4, int arg5) {
        if(Math.abs(arg5) <= this.mFlingDistance || Math.abs(arg4) <= this.mMinimumVelocity) {
            float v4 = arg2 >= this.mCurItem ? 0.4f : 0.6f;
            arg2 += ((int)(arg3 + v4));
        }
        else if(arg4 > 0) {
        }
        else {
            ++arg2;
        }

        if(this.mItems.size() > 0) {
            return Math.max(this.mItems.get(0).position, Math.min(arg2, this.mItems.get(this.mItems.size() - 1).position));
        }

        return arg2;
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

    private void dispatchOnPageScrolled(int arg4, float arg5, int arg6) {
        OnPageChangeListener v0 = this.mOnPageChangeListener;
        if(v0 != null) {
            v0.onPageScrolled(arg4, arg5, arg6);
        }

        List v0_1 = this.mOnPageChangeListeners;
        if(v0_1 != null) {
            int v0_2 = v0_1.size();
            int v1;
            for(v1 = 0; v1 < v0_2; ++v1) {
                Object v2 = this.mOnPageChangeListeners.get(v1);
                if(v2 != null) {
                    ((OnPageChangeListener)v2).onPageScrolled(arg4, arg5, arg6);
                }
            }
        }

        OnPageChangeListener v3 = this.mInternalPageChangeListener;
        if(v3 != null) {
            v3.onPageScrolled(arg4, arg5, arg6);
        }
    }

    private void dispatchOnPageSelected(int arg4) {
        OnPageChangeListener v0 = this.mOnPageChangeListener;
        if(v0 != null) {
            v0.onPageSelected(arg4);
        }

        List v0_1 = this.mOnPageChangeListeners;
        if(v0_1 != null) {
            int v0_2 = v0_1.size();
            int v1;
            for(v1 = 0; v1 < v0_2; ++v1) {
                Object v2 = this.mOnPageChangeListeners.get(v1);
                if(v2 != null) {
                    ((OnPageChangeListener)v2).onPageSelected(arg4);
                }
            }
        }

        OnPageChangeListener v3 = this.mInternalPageChangeListener;
        if(v3 != null) {
            v3.onPageSelected(arg4);
        }
    }

    private void dispatchOnScrollStateChanged(int arg4) {
        OnPageChangeListener v0 = this.mOnPageChangeListener;
        if(v0 != null) {
            v0.onPageScrollStateChanged(arg4);
        }

        List v0_1 = this.mOnPageChangeListeners;
        if(v0_1 != null) {
            int v0_2 = v0_1.size();
            int v1;
            for(v1 = 0; v1 < v0_2; ++v1) {
                Object v2 = this.mOnPageChangeListeners.get(v1);
                if(v2 != null) {
                    ((OnPageChangeListener)v2).onPageScrollStateChanged(arg4);
                }
            }
        }

        OnPageChangeListener v3 = this.mInternalPageChangeListener;
        if(v3 != null) {
            v3.onPageScrollStateChanged(arg4);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg7) {
        if(arg7.getEventType() == 0x1000) {
            return super.dispatchPopulateAccessibilityEvent(arg7);
        }

        int v0 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = this.getChildAt(v2);
            if(v3.getVisibility() == 0) {
                ItemInfo v4 = this.infoForChild(v3);
                if(v4 != null && v4.position == this.mCurItem && (v3.dispatchPopulateAccessibilityEvent(arg7))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    float distanceInfluenceForSnapDuration(float arg1) {
        return ((float)Math.sin(((double)((arg1 - 0.5f) * 0.471239f))));
    }

    public void draw(Canvas arg8) {
        int v2;
        super.draw(arg8);
        int v0 = this.getOverScrollMode();
        int v1 = 0;
        if(v0 != 0) {
            if(v0 == 1) {
                PagerAdapter v0_1 = this.mAdapter;
                if(v0_1 != null && v0_1.getCount() > 1) {
                    goto label_16;
                }
            }

            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        else {
        label_16:
            if(!this.mLeftEdge.isFinished()) {
                v0 = arg8.save();
                v1 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                v2 = this.getWidth();
                arg8.rotate(270f);
                arg8.translate(((float)(-v1 + this.getPaddingTop())), this.mFirstOffset * (((float)v2)));
                this.mLeftEdge.setSize(v1, v2);
                boolean v1_1 = this.mLeftEdge.draw(arg8);
                arg8.restoreToCount(v0);
            }

            if(this.mRightEdge.isFinished()) {
                goto label_69;
            }

            v0 = arg8.save();
            v2 = this.getWidth();
            int v3 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            arg8.rotate(90f);
            arg8.translate(((float)(-this.getPaddingTop())), -(this.mLastOffset + 1f) * (((float)v2)));
            this.mRightEdge.setSize(v3, v2);
            v1 |= this.mRightEdge.draw(arg8);
            arg8.restoreToCount(v0);
        }

    label_69:
        if((((boolean)v1))) {
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable v0 = this.mMarginDrawable;
        if(v0 != null && (v0.isStateful())) {
            v0.setState(this.getDrawableState());
        }
    }

    private void enableLayers(boolean arg7) {
        int v0 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            int v3 = arg7 ? this.mPageTransformerLayerType : 0;
            this.getChildAt(v2).setLayerType(v3, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker v0 = this.mVelocityTracker;
        if(v0 != null) {
            v0.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void endFakeDrag() {
        if(this.mFakeDragging) {
            if(this.mAdapter != null) {
                VelocityTracker v0 = this.mVelocityTracker;
                v0.computeCurrentVelocity(1000, ((float)this.mMaximumVelocity));
                int v0_1 = ((int)v0.getXVelocity(this.mActivePointerId));
                this.mPopulatePending = true;
                int v2 = this.getClientWidth();
                int v3 = this.getScrollX();
                ItemInfo v4 = this.infoForCurrentScrollPosition();
                this.setCurrentItemInternal(this.determineTargetPage(v4.position, ((((float)v3)) / (((float)v2)) - v4.offset) / v4.widthFactor, v0_1, ((int)(this.mLastMotionX - this.mInitialMotionX))), true, true, v0_1);
            }

            this.endDrag();
            this.mFakeDragging = false;
            return;
        }

        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent arg4) {
        if(arg4.getAction() == 0) {
            int v0 = arg4.getKeyCode();
            int v2 = 2;
            if(v0 != 21) {
                if(v0 != 22) {
                    if(v0 != 61) {
                    }
                    else if(arg4.hasNoModifiers()) {
                        return this.arrowScroll(v2);
                    }
                    else if(arg4.hasModifiers(1)) {
                        return this.arrowScroll(1);
                    }
                }
                else if(arg4.hasModifiers(v2)) {
                    return this.pageRight();
                }
                else {
                    return this.arrowScroll(66);
                }
            }
            else if(arg4.hasModifiers(v2)) {
                return this.pageLeft();
            }
            else {
                return this.arrowScroll(17);
            }
        }

        return 0;
    }

    public void fakeDragBy(float arg11) {
        if(this.mFakeDragging) {
            if(this.mAdapter == null) {
                return;
            }

            this.mLastMotionX += arg11;
            float v0 = (((float)this.getScrollX())) - arg11;
            arg11 = ((float)this.getClientWidth());
            float v1 = this.mFirstOffset * arg11;
            float v2 = this.mLastOffset * arg11;
            Object v3 = this.mItems.get(0);
            Object v4 = this.mItems.get(this.mItems.size() - 1);
            if(((ItemInfo)v3).position != 0) {
                v1 = ((ItemInfo)v3).offset * arg11;
            }

            if(((ItemInfo)v4).position != this.mAdapter.getCount() - 1) {
                v2 = ((ItemInfo)v4).offset * arg11;
            }

            if(v0 < v1) {
                v0 = v1;
            }
            else if(v0 > v2) {
                v0 = v2;
            }

            int v1_1 = ((int)v0);
            this.mLastMotionX += v0 - (((float)v1_1));
            this.scrollTo(v1_1, this.getScrollY());
            this.pageScrolled(v1_1);
            MotionEvent v11 = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0f, 0);
            this.mVelocityTracker.addMovement(v11);
            v11.recycle();
            return;
        }

        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return this.generateDefaultLayoutParams();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    protected int getChildDrawingOrder(int arg3, int arg4) {
        if(this.mDrawingOrder == 2) {
            arg4 = arg3 - 1 - arg4;
        }

        return this.mDrawingOrderedChildren.get(arg4).getLayoutParams().childIndex;
    }

    private Rect getChildRectInPagerCoordinates(Rect arg3, View arg4) {
        if(arg3 == null) {
            arg3 = new Rect();
        }

        if(arg4 == null) {
            arg3.set(0, 0, 0, 0);
            return arg3;
        }

        arg3.left = arg4.getLeft();
        arg3.right = arg4.getRight();
        arg3.top = arg4.getTop();
        arg3.bottom = arg4.getBottom();
        ViewParent v4;
        for(v4 = arg4.getParent(); (v4 instanceof ViewGroup); v4 = ((ViewGroup)v4).getParent()) {
            if((((ViewPager)v4)) == this) {
                return arg3;
            }

            arg3.left += ((ViewGroup)v4).getLeft();
            arg3.right += ((ViewGroup)v4).getRight();
            arg3.top += ((ViewGroup)v4).getTop();
            arg3.bottom += ((ViewGroup)v4).getBottom();
        }

        return arg3;
    }

    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    ItemInfo infoForAnyChild(View arg2) {
        ViewParent v2;
        while(true) {
            ViewParent v0 = arg2.getParent();
            if((((ViewPager)v0)) == this) {
                goto label_10;
            }

            if(v0 != null) {
                if(!(v0 instanceof View)) {
                }
                else {
                    v2 = v0;
                    continue;
                }
            }

            return null;
        }

        return null;
    label_10:
        return this.infoForChild(((View)v2));
    }

    ItemInfo infoForChild(View arg5) {
        int v0;
        for(v0 = 0; v0 < this.mItems.size(); ++v0) {
            Object v1 = this.mItems.get(v0);
            if(this.mAdapter.isViewFromObject(arg5, ((ItemInfo)v1).object)) {
                return ((ItemInfo)v1);
            }
        }

        return null;
    }

    private ItemInfo infoForCurrentScrollPosition() {
        Object v6_1;
        int v0 = this.getClientWidth();
        float v1 = 0f;
        float v2 = v0 > 0 ? (((float)this.getScrollX())) / (((float)v0)) : 0f;
        float v3 = v0 > 0 ? (((float)this.mPageMargin)) / (((float)v0)) : 0f;
        int v8 = 0;
        int v9 = 1;
        ItemInfo v7 = null;
        int v6 = -1;
        float v4 = 0f;
        while(true) {
            if(v8 < this.mItems.size()) {
                Object v10 = this.mItems.get(v8);
                if(v9 == 0) {
                    ++v6;
                    if(((ItemInfo)v10).position != v6) {
                        ItemInfo v10_1 = this.mTempItem;
                        v10_1.offset = v1 + v4 + v3;
                        v10_1.position = v6;
                        ((ItemInfo)v10).widthFactor = this.mAdapter.getPageWidth(((ItemInfo)v10).position);
                        --v8;
                    }
                }

                v6_1 = v10;
                v1 = ((ItemInfo)v6_1).offset;
                v4 = ((ItemInfo)v6_1).widthFactor + v1 + v3;
                if(v9 == 0 && v2 < v1) {
                    return v7;
                }

                if(v2 >= v4) {
                    if(v8 == this.mItems.size() - 1) {
                    }
                    else {
                        int v4_1 = ((ItemInfo)v6_1).position;
                        float v7_1 = ((ItemInfo)v6_1).widthFactor;
                        ++v8;
                        Object v9_1 = v6_1;
                        v6 = v4_1;
                        v4 = v7_1;
                        Object v7_2 = v9_1;
                        v9 = 0;
                        continue;
                    }
                }

                break;
            }

            return v7;
        }

        return ((ItemInfo)v6_1);
    }

    ItemInfo infoForPosition(int arg4) {
        int v0;
        for(v0 = 0; v0 < this.mItems.size(); ++v0) {
            Object v1 = this.mItems.get(v0);
            if(((ItemInfo)v1).position == arg4) {
                return ((ItemInfo)v1);
            }
        }

        return null;
    }

    void initViewPager() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(0x40000);
        this.setFocusable(true);
        Context v1 = this.getContext();
        this.mScroller = new Scroller(v1, ViewPager.sInterpolator);
        ViewConfiguration v2 = ViewConfiguration.get(v1);
        float v3 = v1.getResources().getDisplayMetrics().density;
        this.mTouchSlop = v2.getScaledPagingTouchSlop();
        this.mMinimumVelocity = ((int)(400f * v3));
        this.mMaximumVelocity = v2.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(v1);
        this.mRightEdge = new EdgeEffect(v1);
        this.mFlingDistance = ((int)(25f * v3));
        this.mCloseEnough = ((int)(2f * v3));
        this.mDefaultGutterSize = ((int)(v3 * 16f));
        ViewCompat.setAccessibilityDelegate(((View)this), new MyAccessibilityDelegate(this));
        if(ViewCompat.getImportantForAccessibility(((View)this)) == 0) {
            ViewCompat.setImportantForAccessibility(((View)this), 1);
        }

        ViewCompat.setOnApplyWindowInsetsListener(((View)this), new OnApplyWindowInsetsListener() {
            private final Rect mTempRect;

            public WindowInsetsCompat onApplyWindowInsets(View arg6, WindowInsetsCompat arg7) {
                WindowInsetsCompat v6 = ViewCompat.onApplyWindowInsets(arg6, arg7);
                if(v6.isConsumed()) {
                    return v6;
                }

                Rect v7 = this.mTempRect;
                v7.left = v6.getSystemWindowInsetLeft();
                v7.top = v6.getSystemWindowInsetTop();
                v7.right = v6.getSystemWindowInsetRight();
                v7.bottom = v6.getSystemWindowInsetBottom();
                int v0 = ViewPager.this.getChildCount();
                int v1;
                for(v1 = 0; v1 < v0; ++v1) {
                    WindowInsetsCompat v2 = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(v1), v6);
                    v7.left = Math.min(v2.getSystemWindowInsetLeft(), v7.left);
                    v7.top = Math.min(v2.getSystemWindowInsetTop(), v7.top);
                    v7.right = Math.min(v2.getSystemWindowInsetRight(), v7.right);
                    v7.bottom = Math.min(v2.getSystemWindowInsetBottom(), v7.bottom);
                }

                return v6.replaceSystemWindowInsets(v7.left, v7.top, v7.right, v7.bottom);
            }
        });
    }

    private static boolean isDecorView(View arg1) {
        if(arg1.getClass().getAnnotation(DecorView.class) != null) {
            return 1;
        }

        return 0;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private boolean isGutterDrag(float arg3, float arg4) {
        if(Float.compare(arg3, ((float)this.mGutterSize)) < 0 && arg4 > 0f || arg3 > (((float)(this.getWidth() - this.mGutterSize))) && arg4 < 0f) {
            return 1;
        }

        return 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        this.removeCallbacks(this.mEndScrollRunnable);
        Scroller v0 = this.mScroller;
        if(v0 != null && !v0.isFinished()) {
            this.mScroller.abortAnimation();
        }

        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas arg18) {
        int v16;
        float v11;
        ViewPager v0 = this;
        super.onDraw(arg18);
        if(v0.mPageMargin > 0 && v0.mMarginDrawable != null && v0.mItems.size() > 0 && v0.mAdapter != null) {
            int v1 = v0.getScrollX();
            int v2 = v0.getWidth();
            float v4 = ((float)v2);
            float v3 = (((float)v0.mPageMargin)) / v4;
            int v6 = 0;
            Object v5 = v0.mItems.get(0);
            float v7 = ((ItemInfo)v5).offset;
            int v8 = v0.mItems.size();
            int v9 = ((ItemInfo)v5).position;
            int v10 = v0.mItems.get(v8 - 1).position;
            while(v9 < v10) {
                while(v9 > ((ItemInfo)v5).position) {
                    if(v6 >= v8) {
                        break;
                    }

                    ++v6;
                    v5 = v0.mItems.get(v6);
                }

                if(v9 == ((ItemInfo)v5).position) {
                    v7 = (((ItemInfo)v5).offset + ((ItemInfo)v5).widthFactor) * v4;
                    v11 = ((ItemInfo)v5).offset + ((ItemInfo)v5).widthFactor + v3;
                }
                else {
                    v11 = v0.mAdapter.getPageWidth(v9);
                    float v12 = (v7 + v11) * v4;
                    v11 = v7 + (v11 + v3);
                    v7 = v12;
                }

                if((((float)v0.mPageMargin)) + v7 > (((float)v1))) {
                    v16 = v1;
                    v0.mMarginDrawable.setBounds(Math.round(v7), v0.mTopPageBounds, Math.round((((float)v0.mPageMargin)) + v7), v0.mBottomPageBounds);
                    v0.mMarginDrawable.draw(arg18);
                }
                else {
                    v16 = v1;
                }

                if(v7 > (((float)(v16 + v2)))) {
                    return;
                }

                ++v9;
                v7 = v11;
                v1 = v16;
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent arg14) {
        float v1_1;
        int v1 = arg14.getAction() & 0xFF;
        if(v1 != 3) {
            if(v1 == 1) {
            }
            else {
                if(v1 != 0) {
                    if(this.mIsBeingDragged) {
                        return 1;
                    }
                    else if(this.mIsUnableToDrag) {
                        return 0;
                    }
                }

                int v2 = 2;
                if(v1 == 0) {
                    v1_1 = arg14.getX();
                    this.mInitialMotionX = v1_1;
                    this.mLastMotionX = v1_1;
                    v1_1 = arg14.getY();
                    this.mInitialMotionY = v1_1;
                    this.mLastMotionY = v1_1;
                    this.mActivePointerId = arg14.getPointerId(0);
                    this.mIsUnableToDrag = false;
                    this.mIsScrollStarted = true;
                    this.mScroller.computeScrollOffset();
                    if(this.mScrollState == v2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        this.populate();
                        this.mIsBeingDragged = true;
                        this.requestParentDisallowInterceptTouchEvent(true);
                        this.setScrollState(1);
                        goto label_115;
                    }

                    this.completeScroll(false);
                    this.mIsBeingDragged = false;
                }
                else if(v1 == v2) {
                    v1 = this.mActivePointerId;
                    if(v1 == -1) {
                    }
                    else {
                        v1 = arg14.findPointerIndex(v1);
                        float v8 = arg14.getX(v1);
                        float v2_1 = v8 - this.mLastMotionX;
                        float v9 = Math.abs(v2_1);
                        float v10 = arg14.getY(v1);
                        float v11 = Math.abs(v10 - this.mInitialMotionY);
                        int v12 = Float.compare(v2_1, 0f);
                        if(v12 != 0 && !this.isGutterDrag(this.mLastMotionX, v2_1) && (this.canScroll(this, false, ((int)v2_1), ((int)v8), ((int)v10)))) {
                            this.mLastMotionX = v8;
                            this.mLastMotionY = v10;
                            this.mIsUnableToDrag = true;
                            return 0;
                        }

                        v1 = this.mTouchSlop;
                        if(v9 <= (((float)v1)) || v9 * 0.5f <= v11) {
                            if(v11 <= (((float)v1))) {
                                goto label_77;
                            }

                            this.mIsUnableToDrag = true;
                        }
                        else {
                            this.mIsBeingDragged = true;
                            this.requestParentDisallowInterceptTouchEvent(true);
                            this.setScrollState(1);
                            v1_1 = this.mInitialMotionX;
                            v2_1 = ((float)this.mTouchSlop);
                            if(v12 > 0) {
                                v1_1 += v2_1;
                            }
                            else {
                                v1_1 -= v2_1;
                            }

                            this.mLastMotionX = v1_1;
                            this.mLastMotionY = v10;
                            this.setScrollingCacheEnabled(true);
                        }

                    label_77:
                        if(!this.mIsBeingDragged) {
                            goto label_115;
                        }

                        if(!this.performDrag(v8)) {
                            goto label_115;
                        }

                        ViewCompat.postInvalidateOnAnimation(((View)this));
                    }
                }
                else if(v1 != 6) {
                }
                else {
                    this.onSecondaryPointerUp(arg14);
                }

            label_115:
                VelocityTracker v1_2 = this.mVelocityTracker;
                if(v1_2 == null) {
                    v1_2 = VelocityTracker.obtain();
                    this.mVelocityTracker = v1_2;
                }

                v1_2.addMovement(arg14);
                return this.mIsBeingDragged;
            }
        }

        this.resetTouch();
        return 0;
    }

    protected void onLayout(boolean arg19, int arg20, int arg21, int arg22, int arg23) {
        boolean v14_1;
        int v17;
        ViewPager v0 = this;
        int v1 = v0.getChildCount();
        int v2 = arg22 - arg20;
        int v3 = arg23 - arg21;
        int v4 = v0.getPaddingLeft();
        int v5 = v0.getPaddingTop();
        int v6 = v0.getPaddingRight();
        int v7 = v0.getPaddingBottom();
        int v8 = v0.getScrollX();
        int v10 = 0;
        int v11 = 0;
        while(true) {
            int v12 = 8;
            if(v10 >= v1) {
                break;
            }

            View v13 = v0.getChildAt(v10);
            if(v13.getVisibility() != v12) {
                ViewGroup$LayoutParams v12_1 = v13.getLayoutParams();
                if(((LayoutParams)v12_1).isDecor) {
                    int v14 = ((LayoutParams)v12_1).gravity & 7;
                    v12 = ((LayoutParams)v12_1).gravity & 0x70;
                    if(v14 == 1) {
                        v14 = Math.max((v2 - v13.getMeasuredWidth()) / 2, v4);
                    label_44:
                        v17 = v14;
                        v14 = v4;
                        v4 = v17;
                    }
                    else if(v14 == 3) {
                        v14 = v13.getMeasuredWidth() + v4;
                    }
                    else if(v14 != 5) {
                        v14 = v4;
                    }
                    else {
                        v14 = v2 - v6 - v13.getMeasuredWidth();
                        v6 += v13.getMeasuredWidth();
                        goto label_44;
                    }

                    if(v12 == 16) {
                        v12 = Math.max((v3 - v13.getMeasuredHeight()) / 2, v5);
                    label_68:
                        v17 = v12;
                        v12 = v5;
                        v5 = v17;
                    }
                    else if(v12 == 0x30) {
                        v12 = v13.getMeasuredHeight() + v5;
                    }
                    else if(v12 != 80) {
                        v12 = v5;
                    }
                    else {
                        v12 = v3 - v7 - v13.getMeasuredHeight();
                        v7 += v13.getMeasuredHeight();
                        goto label_68;
                    }

                    v4 += v8;
                    v13.layout(v4, v5, v13.getMeasuredWidth() + v4, v5 + v13.getMeasuredHeight());
                    ++v11;
                    v5 = v12;
                    v4 = v14;
                }
            }

            ++v10;
        }

        v2 = v2 - v4 - v6;
        for(v6 = 0; v6 < v1; ++v6) {
            View v8_1 = v0.getChildAt(v6);
            if(v8_1.getVisibility() != v12) {
                ViewGroup$LayoutParams v9 = v8_1.getLayoutParams();
                if(!((LayoutParams)v9).isDecor) {
                    ItemInfo v10_1 = v0.infoForChild(v8_1);
                    if(v10_1 != null) {
                        float v13_1 = ((float)v2);
                        v10 = (((int)(v10_1.offset * v13_1))) + v4;
                        if(((LayoutParams)v9).needsMeasure) {
                            ((LayoutParams)v9).needsMeasure = false;
                            v8_1.measure(View$MeasureSpec.makeMeasureSpec(((int)(v13_1 * ((LayoutParams)v9).widthFactor)), 0x40000000), View$MeasureSpec.makeMeasureSpec(v3 - v5 - v7, 0x40000000));
                        }

                        v8_1.layout(v10, v5, v8_1.getMeasuredWidth() + v10, v8_1.getMeasuredHeight() + v5);
                    }
                }
            }
        }

        v0.mTopPageBounds = v5;
        v0.mBottomPageBounds = v3 - v7;
        v0.mDecorChildCount = v11;
        if(v0.mFirstLayout) {
            v14_1 = false;
            v0.scrollToItem(v0.mCurItem, false, 0, false);
        }
        else {
            v14_1 = false;
        }

        v0.mFirstLayout = v14_1;
    }

    protected void onMeasure(int arg17, int arg18) {
        int v13;
        int v12;
        int v8;
        ViewPager v0 = this;
        int v1 = 0;
        v0.setMeasuredDimension(ViewPager.getDefaultSize(0, arg17), ViewPager.getDefaultSize(0, arg18));
        int v2 = v0.getMeasuredWidth();
        v0.mGutterSize = Math.min(v2 / 10, v0.mDefaultGutterSize);
        v2 = v2 - v0.getPaddingLeft() - v0.getPaddingRight();
        int v3 = v0.getMeasuredHeight() - v0.getPaddingTop() - v0.getPaddingBottom();
        int v4 = v0.getChildCount();
        int v5 = 0;
        while(true) {
            int v6 = 8;
            int v7 = 1;
            v8 = 0x40000000;
            if(v5 >= v4) {
                break;
            }

            View v9 = v0.getChildAt(v5);
            if(v9.getVisibility() != v6) {
                ViewGroup$LayoutParams v6_1 = v9.getLayoutParams();
                if(v6_1 != null && (((LayoutParams)v6_1).isDecor)) {
                    int v10 = ((LayoutParams)v6_1).gravity & 7;
                    int v11 = ((LayoutParams)v6_1).gravity & 0x70;
                    v11 = v11 == 0x30 || v11 == 80 ? 1 : v1;
                    if(v10 != 3) {
                        if(v10 == 5) {
                        }
                        else {
                            v7 = v1;
                        }
                    }

                    v10 = 0x80000000;
                    if(v11 != 0) {
                        v12 = v10;
                        v10 = v8;
                    }
                    else if(v7 != 0) {
                        v12 = v8;
                    }
                    else {
                        v12 = v10;
                    }

                    int v14 = -1;
                    int v15 = -2;
                    if(((LayoutParams)v6_1).width != v15) {
                        v10 = ((LayoutParams)v6_1).width != v14 ? ((LayoutParams)v6_1).width : v2;
                        v13 = v8;
                    }
                    else {
                        v13 = v10;
                        v10 = v2;
                    }

                    if(((LayoutParams)v6_1).height == v15) {
                        v1 = v3;
                        v8 = v12;
                    }
                    else if(((LayoutParams)v6_1).height != v14) {
                        v1 = ((LayoutParams)v6_1).height;
                    }
                    else {
                        v1 = v3;
                    }

                    v9.measure(View$MeasureSpec.makeMeasureSpec(v10, v13), View$MeasureSpec.makeMeasureSpec(v1, v8));
                    if(v11 != 0) {
                        v3 -= v9.getMeasuredHeight();
                        goto label_94;
                    }

                    if(v7 == 0) {
                        goto label_94;
                    }

                    v2 -= v9.getMeasuredWidth();
                }
            }

        label_94:
            ++v5;
            v1 = 0;
        }

        v0.mChildWidthMeasureSpec = View$MeasureSpec.makeMeasureSpec(v2, v8);
        v0.mChildHeightMeasureSpec = View$MeasureSpec.makeMeasureSpec(v3, v8);
        v0.mInLayout = true;
        v0.populate();
        v1 = 0;
        v0.mInLayout = false;
        v3 = v0.getChildCount();
        while(v1 < v3) {
            View v4_1 = v0.getChildAt(v1);
            if(v4_1.getVisibility() != v6) {
                ViewGroup$LayoutParams v5_1 = v4_1.getLayoutParams();
                if(v5_1 != null && (((LayoutParams)v5_1).isDecor)) {
                    goto label_121;
                }

                v4_1.measure(View$MeasureSpec.makeMeasureSpec(((int)((((float)v2)) * ((LayoutParams)v5_1).widthFactor)), v8), v0.mChildHeightMeasureSpec);
            }

        label_121:
            ++v1;
        }
    }

    protected void onPageScrolled(int arg13, float arg14, int arg15) {
        int v1 = 0;
        if(this.mDecorChildCount > 0) {
            int v0 = this.getScrollX();
            int v3 = this.getPaddingLeft();
            int v4 = this.getPaddingRight();
            int v5 = this.getWidth();
            int v6 = this.getChildCount();
            int v7;
            for(v7 = 0; v7 < v6; ++v7) {
                View v8 = this.getChildAt(v7);
                ViewGroup$LayoutParams v9 = v8.getLayoutParams();
                if(!((LayoutParams)v9).isDecor) {
                }
                else {
                    int v9_1 = ((LayoutParams)v9).gravity & 7;
                    if(v9_1 == 1) {
                        v9_1 = Math.max((v5 - v8.getMeasuredWidth()) / 2, v3);
                    label_38:
                        int v11 = v9_1;
                        v9_1 = v3;
                        v3 = v11;
                    }
                    else if(v9_1 == 3) {
                        v9_1 = v8.getWidth() + v3;
                    }
                    else if(v9_1 != 5) {
                        v9_1 = v3;
                    }
                    else {
                        v9_1 = v5 - v4 - v8.getMeasuredWidth();
                        v4 += v8.getMeasuredWidth();
                        goto label_38;
                    }

                    v3 = v3 + v0 - v8.getLeft();
                    if(v3 != 0) {
                        v8.offsetLeftAndRight(v3);
                    }

                    v3 = v9_1;
                }
            }
        }

        this.dispatchOnPageScrolled(arg13, arg14, arg15);
        if(this.mPageTransformer != null) {
            arg13 = this.getScrollX();
            int v14 = this.getChildCount();
            while(v1 < v14) {
                View v15 = this.getChildAt(v1);
                if(v15.getLayoutParams().isDecor) {
                }
                else {
                    this.mPageTransformer.transformPage(v15, (((float)(v15.getLeft() - arg13))) / (((float)this.getClientWidth())));
                }

                ++v1;
            }
        }

        this.mCalledSuper = true;
    }

    protected boolean onRequestFocusInDescendants(int arg9, Rect arg10) {
        int v4;
        int v1;
        int v0 = this.getChildCount();
        if((arg9 & 2) != 0) {
            v1 = v0;
            v0 = 0;
            v4 = 1;
        }
        else {
            --v0;
            v1 = -1;
            v4 = v1;
        }

        while(v0 != v1) {
            View v5 = this.getChildAt(v0);
            if(v5.getVisibility() == 0) {
                ItemInfo v6 = this.infoForChild(v5);
                if(v6 != null && v6.position == this.mCurItem && (v5.requestFocus(arg9, arg10))) {
                    return 1;
                }
            }

            v0 += v4;
        }

        return 0;
    }

    public void onRestoreInstanceState(Parcelable arg4) {
        if(!(arg4 instanceof SavedState)) {
            super.onRestoreInstanceState(arg4);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg4).getSuperState());
        PagerAdapter v0 = this.mAdapter;
        if(v0 != null) {
            v0.restoreState(((SavedState)arg4).adapterState, ((SavedState)arg4).loader);
            this.setCurrentItemInternal(((SavedState)arg4).position, false, true);
            return;
        }

        this.mRestoredCurItem = ((SavedState)arg4).position;
        this.mRestoredAdapterState = ((SavedState)arg4).adapterState;
        this.mRestoredClassLoader = ((SavedState)arg4).loader;
    }

    public Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.position = this.mCurItem;
        PagerAdapter v2 = this.mAdapter;
        if(v2 != null) {
            v1.adapterState = v2.saveState();
        }

        return ((Parcelable)v1);
    }

    private void onSecondaryPointerUp(MotionEvent arg4) {
        int v0 = arg4.getActionIndex();
        if(arg4.getPointerId(v0) == this.mActivePointerId) {
            v0 = v0 == 0 ? 1 : 0;
            this.mLastMotionX = arg4.getX(v0);
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
        if(arg1 != arg3) {
            this.recomputeScrollPosition(arg1, arg3, this.mPageMargin, this.mPageMargin);
        }
    }

    public boolean onTouchEvent(MotionEvent arg8) {
        int v3_1;
        float v0_3;
        if(this.mFakeDragging) {
            return 1;
        }

        boolean v2 = false;
        if(arg8.getAction() == 0 && arg8.getEdgeFlags() != 0) {
            return 0;
        }

        PagerAdapter v0 = this.mAdapter;
        if(v0 != null) {
            if(v0.getCount() == 0) {
            }
            else {
                VelocityTracker v0_1 = this.mVelocityTracker;
                if(v0_1 == null) {
                    v0_1 = VelocityTracker.obtain();
                    this.mVelocityTracker = v0_1;
                }

                v0_1.addMovement(arg8);
                int v0_2 = arg8.getAction() & 0xFF;
                if(v0_2 == 0) {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    this.populate();
                    v0_3 = arg8.getX();
                    this.mInitialMotionX = v0_3;
                    this.mLastMotionX = v0_3;
                    v0_3 = arg8.getY();
                    this.mInitialMotionY = v0_3;
                    this.mLastMotionY = v0_3;
                    this.mActivePointerId = arg8.getPointerId(0);
                }
                else if(v0_2 == 1) {
                    if(!this.mIsBeingDragged) {
                        goto label_146;
                    }

                    v0_1 = this.mVelocityTracker;
                    v0_1.computeCurrentVelocity(1000, ((float)this.mMaximumVelocity));
                    v0_2 = ((int)v0_1.getXVelocity(this.mActivePointerId));
                    this.mPopulatePending = true;
                    int v2_1 = this.getClientWidth();
                    v3_1 = this.getScrollX();
                    ItemInfo v4_1 = this.infoForCurrentScrollPosition();
                    float v2_2 = ((float)v2_1);
                    this.setCurrentItemInternal(this.determineTargetPage(v4_1.position, ((((float)v3_1)) / v2_2 - v4_1.offset) / (v4_1.widthFactor + (((float)this.mPageMargin)) / v2_2), v0_2, ((int)(arg8.getX(arg8.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX))), true, true, v0_2);
                    v2 = this.resetTouch();
                }
                else if(v0_2 == 2) {
                    if(!this.mIsBeingDragged) {
                        v0_2 = arg8.findPointerIndex(this.mActivePointerId);
                        if(v0_2 == -1) {
                            v2 = this.resetTouch();
                            goto label_146;
                        }
                        else {
                            float v3 = arg8.getX(v0_2);
                            float v4 = Math.abs(v3 - this.mLastMotionX);
                            v0_3 = arg8.getY(v0_2);
                            float v5 = Math.abs(v0_3 - this.mLastMotionY);
                            if(v4 > (((float)this.mTouchSlop)) && v4 > v5) {
                                this.mIsBeingDragged = true;
                                this.requestParentDisallowInterceptTouchEvent(true);
                                v4 = this.mInitialMotionX;
                                v3_1 = Float.compare(v3 - v4, 0f);
                                int v5_1 = this.mTouchSlop;
                                if(v3_1 > 0) {
                                    v4 += ((float)v5_1);
                                }
                                else {
                                    v4 -= ((float)v5_1);
                                }

                                this.mLastMotionX = v4;
                                this.mLastMotionY = v0_3;
                                this.setScrollState(1);
                                this.setScrollingCacheEnabled(true);
                                ViewParent v0_4 = this.getParent();
                                if(v0_4 == null) {
                                    goto label_91;
                                }

                                v0_4.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }

                label_91:
                    if(!this.mIsBeingDragged) {
                        goto label_146;
                    }

                    v2 = this.performDrag(arg8.getX(arg8.findPointerIndex(this.mActivePointerId)));
                }
                else if(v0_2 != 3) {
                    if(v0_2 == 5) {
                        v0_2 = arg8.getActionIndex();
                        this.mLastMotionX = arg8.getX(v0_2);
                        this.mActivePointerId = arg8.getPointerId(v0_2);
                    }
                    else if(v0_2 != 6) {
                    }
                    else {
                        this.onSecondaryPointerUp(arg8);
                        this.mLastMotionX = arg8.getX(arg8.findPointerIndex(this.mActivePointerId));
                    }
                }
                else if(this.mIsBeingDragged) {
                    this.scrollToItem(this.mCurItem, true, 0, false);
                    v2 = this.resetTouch();
                }

            label_146:
                if(v2) {
                    ViewCompat.postInvalidateOnAnimation(((View)this));
                }

                return 1;
            }
        }

        return 0;
    }

    boolean pageLeft() {
        int v0 = this.mCurItem;
        if(v0 > 0) {
            this.setCurrentItem(v0 - 1, true);
            return 1;
        }

        return 0;
    }

    boolean pageRight() {
        PagerAdapter v0 = this.mAdapter;
        if(v0 != null && this.mCurItem < v0.getCount() - 1) {
            this.setCurrentItem(this.mCurItem + 1, true);
            return 1;
        }

        return 0;
    }

    private boolean pageScrolled(int arg8) {
        String v1 = "onPageScrolled did not call superclass implementation";
        if(this.mItems.size() == 0) {
            if(this.mFirstLayout) {
                return 0;
            }

            this.mCalledSuper = false;
            this.onPageScrolled(0, 0f, 0);
            if(this.mCalledSuper) {
                return 0;
            }

            throw new IllegalStateException(v1);
        }

        ItemInfo v0 = this.infoForCurrentScrollPosition();
        int v3 = this.getClientWidth();
        int v5 = v3 + this.mPageMargin;
        float v3_1 = ((float)v3);
        float v4 = (((float)this.mPageMargin)) / v3_1;
        int v6 = v0.position;
        float v8 = ((((float)arg8)) / v3_1 - v0.offset) / (v0.widthFactor + v4);
        this.mCalledSuper = false;
        this.onPageScrolled(v6, v8, ((int)((((float)v5)) * v8)));
        if(this.mCalledSuper) {
            return 1;
        }

        throw new IllegalStateException(v1);
    }

    private boolean performDrag(float arg10) {
        int v5_1;
        int v3_1;
        float v0 = this.mLastMotionX - arg10;
        this.mLastMotionX = arg10;
        arg10 = (((float)this.getScrollX())) + v0;
        v0 = ((float)this.getClientWidth());
        float v1 = this.mFirstOffset * v0;
        float v2 = this.mLastOffset * v0;
        boolean v4 = false;
        Object v3 = this.mItems.get(0);
        Object v5 = this.mItems.get(this.mItems.size() - 1);
        if(((ItemInfo)v3).position != 0) {
            v1 = ((ItemInfo)v3).offset * v0;
            v3_1 = 0;
        }
        else {
            v3_1 = 1;
        }

        if(((ItemInfo)v5).position != this.mAdapter.getCount() - 1) {
            v2 = ((ItemInfo)v5).offset * v0;
            v5_1 = 0;
        }
        else {
            v5_1 = 1;
        }

        if(arg10 < v1) {
            if(v3_1 != 0) {
                this.mLeftEdge.onPull(Math.abs(v1 - arg10) / v0);
                v4 = true;
            }

            arg10 = v1;
        }
        else {
            if(arg10 <= v2) {
                goto label_56;
            }

            if(v5_1 != 0) {
                this.mRightEdge.onPull(Math.abs(arg10 - v2) / v0);
                v4 = true;
            }

            arg10 = v2;
        }

    label_56:
        int v1_1 = ((int)arg10);
        this.mLastMotionX += arg10 - (((float)v1_1));
        this.scrollTo(v1_1, this.getScrollY());
        this.pageScrolled(v1_1);
        return v4;
    }

    void populate() {
        this.populate(this.mCurItem);
    }

    void populate(int arg18) {
        String v1_2;
        ItemInfo v3_3;
        Object v5;
        Object v8;
        int v6;
        ItemInfo v2_1;
        ViewPager v0 = this;
        int v1 = arg18;
        int v2 = v0.mCurItem;
        if(v2 != v1) {
            v2_1 = v0.infoForPosition(v2);
            v0.mCurItem = v1;
        }
        else {
            v2_1 = null;
        }

        if(v0.mAdapter == null) {
            v0.sortChildDrawingOrder();
            return;
        }

        if(v0.mPopulatePending) {
            v0.sortChildDrawingOrder();
            return;
        }

        if(v0.getWindowToken() == null) {
        }
        else {
            v0.mAdapter.startUpdate(((ViewGroup)v0));
            v1 = v0.mOffscreenPageLimit;
            int v4 = Math.max(0, v0.mCurItem - v1);
            v6 = v0.mAdapter.getCount();
            v1 = Math.min(v6 - 1, v0.mCurItem + v1);
            if(v6 == v0.mExpectedAdapterCount) {
                int v7 = 0;
                while(true) {
                    if(v7 < v0.mItems.size()) {
                        v8 = v0.mItems.get(v7);
                        if(((ItemInfo)v8).position < v0.mCurItem) {
                            ++v7;
                            continue;
                        }
                        else if(((ItemInfo)v8).position == v0.mCurItem) {
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_50;
                }

                v8 = null;
            label_50:
                if(v8 == null && v6 > 0) {
                    ItemInfo v8_1 = v0.addNewItem(v0.mCurItem, v7);
                }

                if(v8 != null) {
                    int v10 = v7 - 1;
                    Object v11 = v10 >= 0 ? v0.mItems.get(v10) : null;
                    int v12 = v0.getClientWidth();
                    float v13 = 2f;
                    float v14 = v12 <= 0 ? 0f : v13 - ((ItemInfo)v8).widthFactor + (((float)v0.getPaddingLeft())) / (((float)v12));
                    int v3 = v0.mCurItem - 1;
                    float v15 = 0f;
                    while(v3 >= 0) {
                        if(v15 < v14 || v3 >= v4) {
                            if(v11 != null && v3 == ((ItemInfo)v11).position) {
                                v15 += ((ItemInfo)v11).widthFactor;
                                --v10;
                                if(v10 >= 0) {
                                    v5 = v0.mItems.get(v10);
                                    goto label_117;
                                }
                                else {
                                    goto label_116;
                                }
                            }

                            v15 += v0.addNewItem(v3, v10 + 1).widthFactor;
                            ++v7;
                            if(v10 >= 0) {
                                v5 = v0.mItems.get(v10);
                            }
                            else {
                            label_116:
                                v5 = null;
                            }

                        label_117:
                            v11 = v5;
                        }
                        else if(v11 == null) {
                            break;
                        }
                        else if(v3 == ((ItemInfo)v11).position && !((ItemInfo)v11).scrolling) {
                            v0.mItems.remove(v10);
                            v0.mAdapter.destroyItem(((ViewGroup)v0), v3, ((ItemInfo)v11).object);
                            --v10;
                            --v7;
                            if(v10 >= 0) {
                                v5 = v0.mItems.get(v10);
                                goto label_117;
                            }
                            else {
                                goto label_116;
                            }
                        }

                        --v3;
                    }

                    float v3_1 = ((ItemInfo)v8).widthFactor;
                    v4 = v7 + 1;
                    if(v3_1 < v13) {
                        v5 = v4 < v0.mItems.size() ? v0.mItems.get(v4) : null;
                        float v10_1 = v12 <= 0 ? 0f : (((float)v0.getPaddingRight())) / (((float)v12)) + v13;
                        int v11_1 = v0.mCurItem;
                        while(true) {
                            ++v11_1;
                            if(v11_1 >= v6) {
                                break;
                            }

                            if(v3_1 < v10_1 || v11_1 <= v1) {
                                if(v5 != null && v11_1 == ((ItemInfo)v5).position) {
                                    v3_1 += ((ItemInfo)v5).widthFactor;
                                    ++v4;
                                    if(v4 < v0.mItems.size()) {
                                        v5 = v0.mItems.get(v4);
                                        continue;
                                    }
                                    else {
                                        goto label_161;
                                    }
                                }

                                ItemInfo v5_1 = v0.addNewItem(v11_1, v4);
                                ++v4;
                                v3_1 += v5_1.widthFactor;
                                if(v4 >= v0.mItems.size()) {
                                    goto label_161;
                                }

                                v5 = v0.mItems.get(v4);
                                continue;
                            }
                            else if(v5 == null) {
                                break;
                            }
                            else {
                                if(v11_1 != ((ItemInfo)v5).position) {
                                    continue;
                                }

                                if(((ItemInfo)v5).scrolling) {
                                    continue;
                                }

                                v0.mItems.remove(v4);
                                v0.mAdapter.destroyItem(((ViewGroup)v0), v11_1, ((ItemInfo)v5).object);
                                if(v4 < v0.mItems.size()) {
                                    v5 = v0.mItems.get(v4);
                                    continue;
                                }
                            }

                        label_161:
                            v5 = null;
                        }
                    }

                    v0.calculatePageOffsets(((ItemInfo)v8), v7, v2_1);
                    v0.mAdapter.setPrimaryItem(((ViewGroup)v0), v0.mCurItem, ((ItemInfo)v8).object);
                }

                v0.mAdapter.finishUpdate(((ViewGroup)v0));
                v1 = v0.getChildCount();
                for(v2 = 0; v2 < v1; ++v2) {
                    View v3_2 = v0.getChildAt(v2);
                    ViewGroup$LayoutParams v4_1 = v3_2.getLayoutParams();
                    ((LayoutParams)v4_1).childIndex = v2;
                    if(!((LayoutParams)v4_1).isDecor && ((LayoutParams)v4_1).widthFactor == 0f) {
                        v3_3 = v0.infoForChild(v3_2);
                        if(v3_3 != null) {
                            ((LayoutParams)v4_1).widthFactor = v3_3.widthFactor;
                            ((LayoutParams)v4_1).position = v3_3.position;
                        }
                    }
                }

                v0.sortChildDrawingOrder();
                if(!v0.hasFocus()) {
                    return;
                }

                View v1_1 = v0.findFocus();
                v3_3 = v1_1 != null ? v0.infoForAnyChild(v1_1) : null;
                if(v3_3 != null && v3_3.position == v0.mCurItem) {
                    return;
                }

                int v5_2;
                for(v5_2 = 0; v5_2 < v0.getChildCount(); ++v5_2) {
                    v1_1 = v0.getChildAt(v5_2);
                    v2_1 = v0.infoForChild(v1_1);
                    if(v2_1 != null && v2_1.position == v0.mCurItem && (v1_1.requestFocus(2))) {
                        return;
                    }
                }
            }
            else {
                goto label_238;
            }
        }

        return;
        try {
        label_238:
            v1_2 = v0.getResources().getResourceName(v0.getId());
        }
        catch(Resources$NotFoundException ) {
            v1_2 = Integer.toHexString(v0.getId());
        }

        throw new IllegalStateException("The application\'s PagerAdapter changed the adapter\'s contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + v0.mExpectedAdapterCount + ", found: " + v6 + " Pager id: " + v1_2 + " Pager class: " + v0.getClass() + " Problematic adapter: " + v0.mAdapter.getClass());
    }

    private void recomputeScrollPosition(int arg2, int arg3, int arg4, int arg5) {
        if(arg3 > 0 && !this.mItems.isEmpty()) {
            if(!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(this.getCurrentItem() * this.getClientWidth());
                return;
            }
            else {
                this.scrollTo(((int)((((float)this.getScrollX())) / (((float)(arg3 - this.getPaddingLeft() - this.getPaddingRight() + arg5))) * (((float)(arg2 - this.getPaddingLeft() - this.getPaddingRight() + arg4))))), this.getScrollY());
                return;
            }
        }

        ItemInfo v3 = this.infoForPosition(this.mCurItem);
        float v3_1 = v3 != null ? Math.min(v3.offset, this.mLastOffset) : 0f;
        arg2 = ((int)(v3_1 * (((float)(arg2 - this.getPaddingLeft() - this.getPaddingRight())))));
        if(arg2 != this.getScrollX()) {
            this.completeScroll(false);
            this.scrollTo(arg2, this.getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            if(!this.getChildAt(v0).getLayoutParams().isDecor) {
                this.removeViewAt(v0);
                --v0;
            }
        }
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener arg1) {
        List v0 = this.mAdapterChangeListeners;
        if(v0 != null) {
            v0.remove(arg1);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener arg1) {
        List v0 = this.mOnPageChangeListeners;
        if(v0 != null) {
            v0.remove(arg1);
        }
    }

    public void removeView(View arg2) {
        if(this.mInLayout) {
            this.removeViewInLayout(arg2);
            return;
        }

        super.removeView(arg2);
    }

    private void requestParentDisallowInterceptTouchEvent(boolean arg1) {
        ViewParent v0 = this.getParent();
        if(v0 != null) {
            v0.requestDisallowInterceptTouchEvent(arg1);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        this.endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if(!this.mLeftEdge.isFinished()) {
            if(this.mRightEdge.isFinished()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private void scrollToItem(int arg6, boolean arg7, int arg8, boolean arg9) {
        ItemInfo v0 = this.infoForPosition(arg6);
        int v0_1 = v0 != null ? ((int)((((float)this.getClientWidth())) * Math.max(this.mFirstOffset, Math.min(v0.offset, this.mLastOffset)))) : 0;
        if(arg7) {
            this.smoothScrollTo(v0_1, 0, arg8);
            if(arg9) {
                this.dispatchOnPageSelected(arg6);
            }

            return;
        }

        if(arg9) {
            this.dispatchOnPageSelected(arg6);
        }

        this.completeScroll(false);
        this.scrollTo(v0_1, 0);
        this.pageScrolled(v0_1);
    }

    public void setAdapter(PagerAdapter arg8) {
        PagerAdapter v0 = this.mAdapter;
        DataSetObserver v1 = null;
        int v2 = 0;
        if(v0 != null) {
            v0.setViewPagerObserver(v1);
            this.mAdapter.startUpdate(((ViewGroup)this));
            int v0_1;
            for(v0_1 = 0; v0_1 < this.mItems.size(); ++v0_1) {
                Object v3 = this.mItems.get(v0_1);
                this.mAdapter.destroyItem(((ViewGroup)this), ((ItemInfo)v3).position, ((ItemInfo)v3).object);
            }

            this.mAdapter.finishUpdate(((ViewGroup)this));
            this.mItems.clear();
            this.removeNonDecorViews();
            this.mCurItem = 0;
            this.scrollTo(0, 0);
        }

        v0 = this.mAdapter;
        this.mAdapter = arg8;
        this.mExpectedAdapterCount = 0;
        if(arg8 != null) {
            PagerObserver v3_1 = this.mObserver;
            if(v3_1 == null) {
                v3_1 = new PagerObserver(this);
                this.mObserver = v3_1;
            }

            this.mAdapter.setViewPagerObserver(((DataSetObserver)v3_1));
            this.mPopulatePending = false;
            boolean v3_2 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if(this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                this.setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = ((Parcelable)v1);
                this.mRestoredClassLoader = ((ClassLoader)v1);
                goto label_61;
            }

            if(!v3_2) {
                this.populate();
                goto label_61;
            }

            this.requestLayout();
        }

    label_61:
        List v1_1 = this.mAdapterChangeListeners;
        if(v1_1 != null && !v1_1.isEmpty()) {
            int v1_2 = this.mAdapterChangeListeners.size();
            while(v2 < v1_2) {
                this.mAdapterChangeListeners.get(v2).onAdapterChanged(this, v0, arg8);
                ++v2;
            }
        }
    }

    public void setCurrentItem(int arg3) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(arg3, this.mFirstLayout ^ 1, false);
    }

    public void setCurrentItem(int arg2, boolean arg3) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(arg2, arg3, false);
    }

    void setCurrentItemInternal(int arg2, boolean arg3, boolean arg4) {
        this.setCurrentItemInternal(arg2, arg3, arg4, 0);
    }

    void setCurrentItemInternal(int arg5, boolean arg6, boolean arg7, int arg8) {
        PagerAdapter v0 = this.mAdapter;
        boolean v1 = false;
        if(v0 != null) {
            if(v0.getCount() <= 0) {
            }
            else {
                if(!arg7 && this.mCurItem == arg5 && this.mItems.size() != 0) {
                    this.setScrollingCacheEnabled(false);
                    return;
                }

                if(arg5 < 0) {
                    arg5 = 0;
                }
                else if(arg5 >= this.mAdapter.getCount()) {
                    arg5 = this.mAdapter.getCount() - 1;
                }

                int v0_1 = this.mOffscreenPageLimit;
                int v2 = this.mCurItem;
                if(arg5 > v2 + v0_1 || arg5 < v2 - v0_1) {
                    for(v0_1 = 0; v0_1 < this.mItems.size(); ++v0_1) {
                        this.mItems.get(v0_1).scrolling = true;
                    }
                }

                if(this.mCurItem != arg5) {
                    v1 = true;
                }

                if(this.mFirstLayout) {
                    this.mCurItem = arg5;
                    if(v1) {
                        this.dispatchOnPageSelected(arg5);
                    }

                    this.requestLayout();
                    return;
                }

                this.populate(arg5);
                this.scrollToItem(arg5, arg6, arg8, v1);
                return;
            }
        }

        this.setScrollingCacheEnabled(false);
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener arg2) {
        OnPageChangeListener v0 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = arg2;
        return v0;
    }

    public void setOffscreenPageLimit(int arg4) {
        if(arg4 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + arg4 + " too small; defaulting to 1");
        }

        if(1 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = 1;
            this.populate();
        }
    }

    @Deprecated public void setOnPageChangeListener(OnPageChangeListener arg1) {
        this.mOnPageChangeListener = arg1;
    }

    public void setPageMargin(int arg3) {
        int v0 = this.mPageMargin;
        this.mPageMargin = arg3;
        int v1 = this.getWidth();
        this.recomputeScrollPosition(v1, v1, arg3, v0);
        this.requestLayout();
    }

    public void setPageMarginDrawable(int arg2) {
        this.setPageMarginDrawable(ContextCompat.getDrawable(this.getContext(), arg2));
    }

    public void setPageMarginDrawable(Drawable arg1) {
        this.mMarginDrawable = arg1;
        if(arg1 != null) {
            this.refreshDrawableState();
        }

        boolean v1 = arg1 == null ? true : false;
        this.setWillNotDraw(v1);
        this.invalidate();
    }

    public void setPageTransformer(boolean arg2, PageTransformer arg3) {
        this.setPageTransformer(arg2, arg3, 2);
    }

    public void setPageTransformer(boolean arg5, PageTransformer arg6, int arg7) {
        int v0 = 1;
        boolean v2 = arg6 != null ? true : false;
        int v3 = this.mPageTransformer != null ? 1 : 0;
        v3 = v2 != (((boolean)v3)) ? 1 : 0;
        this.mPageTransformer = arg6;
        this.setChildrenDrawingOrderEnabled(v2);
        if(v2) {
            if(arg5) {
                v0 = 2;
            }

            this.mDrawingOrder = v0;
            this.mPageTransformerLayerType = arg7;
        }
        else {
            this.mDrawingOrder = 0;
        }

        if(v3 != 0) {
            this.populate();
        }
    }

    void setScrollState(int arg2) {
        if(this.mScrollState == arg2) {
            return;
        }

        this.mScrollState = arg2;
        if(this.mPageTransformer != null) {
            boolean v0 = arg2 != 0 ? true : false;
            this.enableLayers(v0);
        }

        this.dispatchOnScrollStateChanged(arg2);
    }

    private void setScrollingCacheEnabled(boolean arg2) {
        if(this.mScrollingCacheEnabled != arg2) {
            this.mScrollingCacheEnabled = arg2;
        }
    }

    void smoothScrollTo(int arg9, int arg10, int arg11) {
        int v0_2;
        if(this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }

        Scroller v0 = this.mScroller;
        if(v0 == null || (v0.isFinished())) {
            v0_2 = this.getScrollX();
        }
        else {
            boolean v0_1 = this.mIsScrollStarted;
            Scroller v2 = this.mScroller;
            v0_2 = v0_1 ? v2.getCurrX() : v2.getStartX();
            this.mScroller.abortAnimation();
            this.setScrollingCacheEnabled(false);
        }

        int v3 = v0_2;
        int v4 = this.getScrollY();
        int v5 = arg9 - v3;
        int v6 = arg10 - v4;
        if(v5 == 0 && v6 == 0) {
            this.completeScroll(false);
            this.populate();
            this.setScrollState(0);
            return;
        }

        this.setScrollingCacheEnabled(true);
        this.setScrollState(2);
        arg9 = this.getClientWidth();
        arg10 = arg9 / 2;
        float v2_1 = 1f;
        float v9 = ((float)arg9);
        float v10 = ((float)arg10);
        v10 += this.distanceInfluenceForSnapDuration(Math.min(v2_1, (((float)Math.abs(v5))) * v2_1 / v9)) * v10;
        arg11 = Math.abs(arg11);
        arg9 = arg11 > 0 ? Math.round(Math.abs(v10 / (((float)arg11))) * 1000f) * 4 : ((int)(((((float)Math.abs(v5))) / (v9 * this.mAdapter.getPageWidth(this.mCurItem) + (((float)this.mPageMargin))) + v2_1) * 100f));
        int v7 = Math.min(arg9, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(v3, v4, v5, v6, v7);
        ViewCompat.postInvalidateOnAnimation(((View)this));
    }

    void smoothScrollTo(int arg2, int arg3) {
        this.smoothScrollTo(arg2, arg3, 0);
    }

    private void sortChildDrawingOrder() {
        if(this.mDrawingOrder != 0) {
            ArrayList v0 = this.mDrawingOrderedChildren;
            if(v0 == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            }
            else {
                v0.clear();
            }

            int v0_1 = this.getChildCount();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                this.mDrawingOrderedChildren.add(this.getChildAt(v1));
            }

            Collections.sort(this.mDrawingOrderedChildren, ViewPager.sPositionComparator);
        }
    }

    protected boolean verifyDrawable(Drawable arg2) {
        if(!super.verifyDrawable(arg2)) {
            if(arg2 == this.mMarginDrawable) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

