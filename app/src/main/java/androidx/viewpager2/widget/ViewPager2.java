package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View$BaseSavedState;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import androidx.viewpager2.adapter.StatefulAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ViewPager2 extends ViewGroup {
    class androidx.viewpager2.widget.ViewPager2$1 extends DataSetChangeObserver {
        androidx.viewpager2.widget.ViewPager2$1(ViewPager2 arg1) {
            ViewPager2.this = arg1;
            super(null);
        }

        public void onChanged() {
            ViewPager2.this.mCurrentItemDirty = true;
            ViewPager2.this.mScrollEventAdapter.notifyDataSetChangeHappened();
        }
    }

    abstract class AccessibilityProvider {
        private AccessibilityProvider(ViewPager2 arg1) {
            ViewPager2.this = arg1;
            super();
        }

        AccessibilityProvider(ViewPager2 arg1, androidx.viewpager2.widget.ViewPager2$1 arg2) {
            this(arg1);
        }

        boolean handlesGetAccessibilityClassName() {
            return 0;
        }

        boolean handlesLmPerformAccessibilityAction(int arg1) {
            return 0;
        }

        boolean handlesPerformAccessibilityAction(int arg1, Bundle arg2) {
            return 0;
        }

        boolean handlesRvGetAccessibilityClassName() {
            return 0;
        }

        void onAttachAdapter(Adapter arg1) {
        }

        void onDetachAdapter(Adapter arg1) {
        }

        String onGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        void onInitialize(CompositeOnPageChangeCallback arg1, RecyclerView arg2) {
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg1) {
        }

        void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat arg1) {
        }

        boolean onLmPerformAccessibilityAction(int arg1) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean onPerformAccessibilityAction(int arg1, Bundle arg2) {
            throw new IllegalStateException("Not implemented.");
        }

        void onRestorePendingState() {
        }

        CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        void onRvInitializeAccessibilityEvent(AccessibilityEvent arg1) {
        }

        void onSetLayoutDirection() {
        }

        void onSetNewCurrentItem() {
        }

        void onSetOrientation() {
        }

        void onSetUserInputEnabled() {
        }
    }

    class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider(ViewPager2 arg2) {
            ViewPager2.this = arg2;
            super(arg2, null);
        }

        public boolean handlesLmPerformAccessibilityAction(int arg2) {
            if((arg2 == 0x2000 || arg2 == 0x1000) && !ViewPager2.this.isUserInputEnabled()) {
                return 1;
            }

            return 0;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return 1;
        }

        public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat arg1) {
            if(!ViewPager2.this.isUserInputEnabled()) {
                arg1.removeAction(AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                arg1.removeAction(AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                arg1.setScrollable(false);
            }
        }

        public boolean onLmPerformAccessibilityAction(int arg1) {
            if(this.handlesLmPerformAccessibilityAction(arg1)) {
                return 0;
            }

            throw new IllegalStateException();
        }

        public CharSequence onRvGetAccessibilityClassName() {
            if(this.handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }

            throw new IllegalStateException();
        }
    }

    abstract class DataSetChangeObserver extends AdapterDataObserver {
        private DataSetChangeObserver() {
            super();
        }

        DataSetChangeObserver(androidx.viewpager2.widget.ViewPager2$1 arg1) {
            this();
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int arg1, int arg2) {
            this.onChanged();
        }

        public final void onItemRangeChanged(int arg1, int arg2, Object arg3) {
            this.onChanged();
        }

        public final void onItemRangeInserted(int arg1, int arg2) {
            this.onChanged();
        }

        public final void onItemRangeMoved(int arg1, int arg2, int arg3) {
            this.onChanged();
        }

        public final void onItemRangeRemoved(int arg1, int arg2) {
            this.onChanged();
        }
    }

    class LinearLayoutManagerImpl extends LinearLayoutManager {
        LinearLayoutManagerImpl(ViewPager2 arg1, Context arg2) {
            ViewPager2.this = arg1;
            super(arg2);
        }

        protected void calculateExtraLayoutSpace(State arg3, int[] arg4) {
            int v0 = ViewPager2.this.getOffscreenPageLimit();
            if(v0 == -1) {
                super.calculateExtraLayoutSpace(arg3, arg4);
                return;
            }

            int v2 = ViewPager2.this.getPageSize() * v0;
            arg4[0] = v2;
            arg4[1] = v2;
        }

        public void onInitializeAccessibilityNodeInfo(Recycler arg1, State arg2, AccessibilityNodeInfoCompat arg3) {
            super.onInitializeAccessibilityNodeInfo(arg1, arg2, arg3);
            ViewPager2.this.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(arg3);
        }

        public boolean performAccessibilityAction(Recycler arg2, State arg3, int arg4, Bundle arg5) {
            if(ViewPager2.this.mAccessibilityProvider.handlesLmPerformAccessibilityAction(arg4)) {
                return ViewPager2.this.mAccessibilityProvider.onLmPerformAccessibilityAction(arg4);
            }

            return super.performAccessibilityAction(arg2, arg3, arg4, arg5);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView arg1, View arg2, Rect arg3, boolean arg4, boolean arg5) {
            return 0;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface OffscreenPageLimit {
    }

    public abstract class OnPageChangeCallback {
        public OnPageChangeCallback() {
            super();
        }

        public void onPageScrollStateChanged(int arg1) {
        }

        public void onPageScrolled(int arg1, float arg2, int arg3) {
        }

        public void onPageSelected(int arg1) {
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Orientation {
    }

    class PageAwareAccessibilityProvider extends AccessibilityProvider {
        class androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$1 implements AccessibilityViewCommand {
            androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$1(PageAwareAccessibilityProvider arg1) {
                this.this$1 = arg1;
                super();
            }

            public boolean perform(View arg1, CommandArguments arg2) {
                this.this$1.setCurrentItemFromAccessibilityCommand(((ViewPager2)arg1).getCurrentItem() + 1);
                return 1;
            }
        }

        class androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$2 implements AccessibilityViewCommand {
            androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$2(PageAwareAccessibilityProvider arg1) {
                this.this$1 = arg1;
                super();
            }

            public boolean perform(View arg1, CommandArguments arg2) {
                this.this$1.setCurrentItemFromAccessibilityCommand(((ViewPager2)arg1).getCurrentItem() - 1);
                return 1;
            }
        }

        private final AccessibilityViewCommand mActionPageBackward;
        private final AccessibilityViewCommand mActionPageForward;
        private AdapterDataObserver mAdapterDataObserver;

        PageAwareAccessibilityProvider(ViewPager2 arg2) {
            ViewPager2.this = arg2;
            super(arg2, null);
            this.mActionPageForward = new androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$1(this);
            this.mActionPageBackward = new androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$2(this);
        }

        private void addCollectionInfo(AccessibilityNodeInfo arg4) {
            int v3_1;
            int v0;
            if(ViewPager2.this.getAdapter() != null) {
                v0 = ViewPager2.this.getOrientation();
                ViewPager2 v3 = ViewPager2.this;
                if(v0 == 1) {
                    v3_1 = v3.getAdapter().getItemCount();
                    v0 = 0;
                }
                else {
                    v0 = v3.getAdapter().getItemCount();
                    v3_1 = 0;
                }
            }
            else {
                v3_1 = 0;
                v0 = 0;
            }

            AccessibilityNodeInfoCompat.wrap(arg4).setCollectionInfo(CollectionInfoCompat.obtain(v3_1, v0, false, 0));
        }

        private void addScrollActions(AccessibilityNodeInfo arg3) {
            Adapter v0 = ViewPager2.this.getAdapter();
            if(v0 == null) {
            }
            else {
                int v0_1 = v0.getItemCount();
                if(v0_1 != 0) {
                    if(!ViewPager2.this.isUserInputEnabled()) {
                    }
                    else {
                        if(ViewPager2.this.mCurrentItem > 0) {
                            arg3.addAction(0x2000);
                        }

                        if(ViewPager2.this.mCurrentItem < v0_1 - 1) {
                            arg3.addAction(0x1000);
                        }

                        arg3.setScrollable(true);
                    }
                }
            }
        }

        public boolean handlesGetAccessibilityClassName() {
            return 1;
        }

        public boolean handlesPerformAccessibilityAction(int arg1, Bundle arg2) {
            if(arg1 != 0x2000) {
                if(arg1 == 0x1000) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public void onAttachAdapter(Adapter arg1) {
            this.updatePageAccessibilityActions();
            if(arg1 != null) {
                arg1.registerAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        public void onDetachAdapter(Adapter arg1) {
            if(arg1 != null) {
                arg1.unregisterAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        public String onGetAccessibilityClassName() {
            if(this.handlesGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }

            throw new IllegalStateException();
        }

        public void onInitialize(CompositeOnPageChangeCallback arg1, RecyclerView arg2) {
            ViewCompat.setImportantForAccessibility(((View)arg2), 2);
            this.mAdapterDataObserver = new DataSetChangeObserver() {
                public void onChanged() {
                    this.this$1.updatePageAccessibilityActions();
                }
            };
            if(ViewCompat.getImportantForAccessibility(ViewPager2.this) == 0) {
                ViewCompat.setImportantForAccessibility(ViewPager2.this, 1);
            }
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg1) {
            this.addCollectionInfo(arg1);
            this.addScrollActions(arg1);
        }

        public boolean onPerformAccessibilityAction(int arg3, Bundle arg4) {
            if(this.handlesPerformAccessibilityAction(arg3, arg4)) {
                ViewPager2 v4 = ViewPager2.this;
                arg3 = arg3 == 0x2000 ? v4.getCurrentItem() - 1 : v4.getCurrentItem() + 1;
                this.setCurrentItemFromAccessibilityCommand(arg3);
                return 1;
            }

            throw new IllegalStateException();
        }

        public void onRestorePendingState() {
            this.updatePageAccessibilityActions();
        }

        public void onRvInitializeAccessibilityEvent(AccessibilityEvent arg2) {
            arg2.setSource(ViewPager2.this);
            arg2.setClassName(this.onGetAccessibilityClassName());
        }

        public void onSetLayoutDirection() {
            this.updatePageAccessibilityActions();
        }

        public void onSetNewCurrentItem() {
            this.updatePageAccessibilityActions();
        }

        public void onSetOrientation() {
            this.updatePageAccessibilityActions();
        }

        public void onSetUserInputEnabled() {
            this.updatePageAccessibilityActions();
        }

        void setCurrentItemFromAccessibilityCommand(int arg2) {
            if(ViewPager2.this.isUserInputEnabled()) {
                ViewPager2.this.setCurrentItemInternal(arg2, true);
            }
        }

        void updatePageAccessibilityActions() {
            ViewPager2 v0 = ViewPager2.this;
            int v1 = 0x1020048;
            ViewCompat.removeAccessibilityAction(((View)v0), v1);
            int v2 = 0x1020049;
            ViewCompat.removeAccessibilityAction(((View)v0), v2);
            int v3 = 0x1020046;
            ViewCompat.removeAccessibilityAction(((View)v0), v3);
            int v4 = 0x1020047;
            ViewCompat.removeAccessibilityAction(((View)v0), v4);
            if(ViewPager2.this.getAdapter() == null) {
            }
            else {
                int v5 = ViewPager2.this.getAdapter().getItemCount();
                if(v5 == 0) {
                }
                else if(!ViewPager2.this.isUserInputEnabled()) {
                }
                else {
                    int v6 = ViewPager2.this.getOrientation();
                    ViewPager2 v7 = ViewPager2.this;
                    CharSequence v8 = null;
                    if(v6 == 0) {
                        boolean v3_1 = v7.isRtl();
                        v4 = v3_1 ? v1 : v2;
                        if(v3_1) {
                            v1 = v2;
                        }

                        if(ViewPager2.this.mCurrentItem < v5 - 1) {
                            ViewCompat.replaceAccessibilityAction(((View)v0), new AccessibilityActionCompat(v4, v8), v8, this.mActionPageForward);
                        }

                        if(ViewPager2.this.mCurrentItem <= 0) {
                            return;
                        }

                        ViewCompat.replaceAccessibilityAction(((View)v0), new AccessibilityActionCompat(v1, v8), v8, this.mActionPageBackward);
                        return;
                    }
                    else {
                        if(v7.mCurrentItem < v5 - 1) {
                            ViewCompat.replaceAccessibilityAction(((View)v0), new AccessibilityActionCompat(v4, v8), v8, this.mActionPageForward);
                        }

                        if(ViewPager2.this.mCurrentItem <= 0) {
                            return;
                        }

                        ViewCompat.replaceAccessibilityAction(((View)v0), new AccessibilityActionCompat(v3, v8), v8, this.mActionPageBackward);
                    }
                }
            }
        }
    }

    public interface PageTransformer {
        void transformPage(View arg1, float arg2);
    }

    class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl(ViewPager2 arg1) {
            ViewPager2.this = arg1;
            super();
        }

        public View findSnapView(LayoutManager arg2) {
            if(ViewPager2.this.isFakeDragging()) {
                return null;
            }

            return super.findSnapView(arg2);
        }
    }

    class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(ViewPager2 arg1, Context arg2) {
            ViewPager2.this = arg1;
            super(arg2);
        }

        public CharSequence getAccessibilityClassName() {
            if(ViewPager2.this.mAccessibilityProvider.handlesRvGetAccessibilityClassName()) {
                return ViewPager2.this.mAccessibilityProvider.onRvGetAccessibilityClassName();
            }

            return super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent arg2) {
            super.onInitializeAccessibilityEvent(arg2);
            arg2.setFromIndex(ViewPager2.this.mCurrentItem);
            arg2.setToIndex(ViewPager2.this.mCurrentItem);
            ViewPager2.this.mAccessibilityProvider.onRvInitializeAccessibilityEvent(arg2);
        }

        public boolean onInterceptTouchEvent(MotionEvent arg2) {
            if((ViewPager2.this.isUserInputEnabled()) && (super.onInterceptTouchEvent(arg2))) {
                return 1;
            }

            return 0;
        }

        public boolean onTouchEvent(MotionEvent arg2) {
            if((ViewPager2.this.isUserInputEnabled()) && (super.onTouchEvent(arg2))) {
                return 1;
            }

            return 0;
        }
    }

    class SavedState extends View$BaseSavedState {
        final class androidx.viewpager2.widget.ViewPager2$SavedState$1 implements Parcelable$ClassLoaderCreator {
            androidx.viewpager2.widget.ViewPager2$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return this.createFromParcel(arg2, null);
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
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        static {
            SavedState.CREATOR = new androidx.viewpager2.widget.ViewPager2$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg2) {
            super(arg2);
            this.readValues(arg2, null);
        }

        SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.readValues(arg1, arg2);
        }

        private void readValues(Parcel arg2, ClassLoader arg3) {
            this.mRecyclerViewId = arg2.readInt();
            this.mCurrentItem = arg2.readInt();
            this.mAdapterState = arg2.readParcelable(arg3);
        }

        public void writeToParcel(Parcel arg2, int arg3) {
            super.writeToParcel(arg2, arg3);
            arg2.writeInt(this.mRecyclerViewId);
            arg2.writeInt(this.mCurrentItem);
            arg2.writeParcelable(this.mAdapterState, arg3);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ScrollState {
    }

    class SmoothScrollToPosition implements Runnable {
        private final int mPosition;
        private final RecyclerView mRecyclerView;

        SmoothScrollToPosition(int arg1, RecyclerView arg2) {
            super();
            this.mPosition = arg1;
            this.mRecyclerView = arg2;
        }

        public void run() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }
    }

    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    AccessibilityProvider mAccessibilityProvider;
    int mCurrentItem;
    private AdapterDataObserver mCurrentItemDataSetChangeObserver;
    boolean mCurrentItemDirty;
    private CompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    private FakeDrag mFakeDragger;
    private LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private PageTransformerAdapter mPageTransformerAdapter;
    private PagerSnapHelper mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    RecyclerView mRecyclerView;
    private ItemAnimator mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    ScrollEventAdapter mScrollEventAdapter;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;
    private boolean mUserInputEnabled;
    static boolean sFeatureEnhancedA11yEnabled = true;

    static {
    }

    public ViewPager2(Context arg4) {
        super(arg4);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.ViewPager2$1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        this.initialize(arg4, null);
    }

    public ViewPager2(Context arg4, AttributeSet arg5) {
        super(arg4, arg5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.ViewPager2$1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        this.initialize(arg4, arg5);
    }

    public ViewPager2(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.ViewPager2$1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        this.initialize(arg3, arg4);
    }

    public ViewPager2(Context arg2, AttributeSet arg3, int arg4, int arg5) {
        super(arg2, arg3, arg4, arg5);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.ViewPager2$1(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        this.initialize(arg2, arg3);
    }

    public void addItemDecoration(ItemDecoration arg1) {
        this.mRecyclerView.addItemDecoration(arg1);
    }

    public void addItemDecoration(ItemDecoration arg1, int arg2) {
        this.mRecyclerView.addItemDecoration(arg1, arg2);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    public boolean canScrollHorizontally(int arg1) {
        return this.mRecyclerView.canScrollHorizontally(arg1);
    }

    public boolean canScrollVertically(int arg1) {
        return this.mRecyclerView.canScrollVertically(arg1);
    }

    protected void dispatchRestoreInstanceState(SparseArray arg4) {
        Object v0 = arg4.get(this.getId());
        if((v0 instanceof SavedState)) {
            int v0_1 = ((SavedState)v0).mRecyclerViewId;
            arg4.put(this.mRecyclerView.getId(), arg4.get(v0_1));
            arg4.remove(v0_1);
        }

        super.dispatchRestoreInstanceState(arg4);
        this.restorePendingState();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    private OnChildAttachStateChangeListener enforceChildFillListener() {
        return new OnChildAttachStateChangeListener() {
            public void onChildViewAttachedToWindow(View arg2) {
                ViewGroup$LayoutParams v1 = arg2.getLayoutParams();
                int v0 = -1;
                if(((LayoutParams)v1).width == v0 && ((LayoutParams)v1).height == v0) {
                    return;
                }

                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }

            public void onChildViewDetachedFromWindow(View arg1) {
            }
        };
    }

    public boolean fakeDragBy(float arg1) {
        return this.mFakeDragger.fakeDragBy(arg1);
    }

    public CharSequence getAccessibilityClassName() {
        if(this.mAccessibilityProvider.handlesGetAccessibilityClassName()) {
            return this.mAccessibilityProvider.onGetAccessibilityClassName();
        }

        return super.getAccessibilityClassName();
    }

    public Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public ItemDecoration getItemDecorationAt(int arg1) {
        return this.mRecyclerView.getItemDecorationAt(arg1);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation();
    }

    int getPageSize() {
        int v0_1;
        int v2;
        RecyclerView v0 = this.mRecyclerView;
        if(this.getOrientation() == 0) {
            v2 = v0.getWidth() - v0.getPaddingLeft();
            v0_1 = v0.getPaddingRight();
        }
        else {
            v2 = v0.getHeight() - v0.getPaddingTop();
            v0_1 = v0.getPaddingBottom();
        }

        return v2 - v0_1;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.getScrollState();
    }

    private void initialize(Context arg3, AttributeSet arg4) {
        BasicAccessibilityProvider v0_1;
        if(ViewPager2.sFeatureEnhancedA11yEnabled) {
            PageAwareAccessibilityProvider v0 = new PageAwareAccessibilityProvider(this);
        }
        else {
            v0_1 = new BasicAccessibilityProvider(this);
        }

        this.mAccessibilityProvider = ((AccessibilityProvider)v0_1);
        RecyclerViewImpl v0_2 = new RecyclerViewImpl(this, arg3);
        this.mRecyclerView = ((RecyclerView)v0_2);
        ((RecyclerView)v0_2).setId(ViewCompat.generateViewId());
        this.mRecyclerView.setDescendantFocusability(0x20000);
        LinearLayoutManagerImpl v0_3 = new LinearLayoutManagerImpl(this, arg3);
        this.mLayoutManager = ((LinearLayoutManager)v0_3);
        this.mRecyclerView.setLayoutManager(((LayoutManager)v0_3));
        this.mRecyclerView.setScrollingTouchSlop(1);
        this.setOrientation(arg3, arg4);
        this.mRecyclerView.setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(this.enforceChildFillListener());
        this.mScrollEventAdapter = new ScrollEventAdapter(this);
        this.mFakeDragger = new FakeDrag(this, this.mScrollEventAdapter, this.mRecyclerView);
        PagerSnapHelperImpl v3 = new PagerSnapHelperImpl(this);
        this.mPagerSnapHelper = ((PagerSnapHelper)v3);
        ((PagerSnapHelper)v3).attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        CompositeOnPageChangeCallback v3_1 = new CompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = v3_1;
        this.mScrollEventAdapter.setOnPageChangeCallback(((OnPageChangeCallback)v3_1));
        androidx.viewpager2.widget.ViewPager2$2 v3_2 = new OnPageChangeCallback() {
            public void onPageScrollStateChanged(int arg1) {
                if(arg1 == 0) {
                    ViewPager2.this.updateCurrentItem();
                }
            }

            public void onPageSelected(int arg2) {
                if(ViewPager2.this.mCurrentItem != arg2) {
                    ViewPager2.this.mCurrentItem = arg2;
                    ViewPager2.this.mAccessibilityProvider.onSetNewCurrentItem();
                }
            }
        };
        androidx.viewpager2.widget.ViewPager2$3 v4 = new OnPageChangeCallback() {
            public void onPageSelected(int arg1) {
                ViewPager2.this.clearFocus();
                if(ViewPager2.this.hasFocus()) {
                    ViewPager2.this.mRecyclerView.requestFocus(2);
                }
            }
        };
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(((OnPageChangeCallback)v3_2));
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(((OnPageChangeCallback)v4));
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        PageTransformerAdapter v3_3 = new PageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = v3_3;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(((OnPageChangeCallback)v3_3));
        this.attachViewToParent(this.mRecyclerView, 0, this.mRecyclerView.getLayoutParams());
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.isFakeDragging();
    }

    boolean isRtl() {
        if(this.mLayoutManager.getLayoutDirection() == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg1) {
        super.onInitializeAccessibilityNodeInfo(arg1);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(arg1);
    }

    protected void onLayout(boolean arg4, int arg5, int arg6, int arg7, int arg8) {
        int v4 = this.mRecyclerView.getMeasuredWidth();
        int v0 = this.mRecyclerView.getMeasuredHeight();
        this.mTmpContainerRect.left = this.getPaddingLeft();
        this.mTmpContainerRect.right = arg7 - arg5 - this.getPaddingRight();
        this.mTmpContainerRect.top = this.getPaddingTop();
        this.mTmpContainerRect.bottom = arg8 - arg6 - this.getPaddingBottom();
        Gravity.apply(0x800033, v4, v0, this.mTmpContainerRect, this.mTmpChildRect);
        this.mRecyclerView.layout(this.mTmpChildRect.left, this.mTmpChildRect.top, this.mTmpChildRect.right, this.mTmpChildRect.bottom);
        if(this.mCurrentItemDirty) {
            this.updateCurrentItem();
        }
    }

    protected void onMeasure(int arg6, int arg7) {
        this.measureChild(this.mRecyclerView, arg6, arg7);
        int v0 = this.mRecyclerView.getMeasuredWidth();
        int v1 = this.mRecyclerView.getMeasuredHeight();
        int v2 = this.mRecyclerView.getMeasuredState();
        this.setMeasuredDimension(ViewPager2.resolveSizeAndState(Math.max(v0 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), arg6, v2), ViewPager2.resolveSizeAndState(Math.max(v1 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), arg7, v2 << 16));
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.mPendingCurrentItem = ((SavedState)arg2).mCurrentItem;
        this.mPendingAdapterState = ((SavedState)arg2).mAdapterState;
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.mRecyclerViewId = this.mRecyclerView.getId();
        int v0 = this.mPendingCurrentItem;
        if(v0 == -1) {
            v0 = this.mCurrentItem;
        }

        v1.mCurrentItem = v0;
        Parcelable v0_1 = this.mPendingAdapterState;
        if(v0_1 != null) {
            v1.mAdapterState = v0_1;
            return ((Parcelable)v1);
        }

        Adapter v3 = this.mRecyclerView.getAdapter();
        if((v3 instanceof StatefulAdapter)) {
            v1.mAdapterState = ((StatefulAdapter)v3).saveState();
        }

        return ((Parcelable)v1);
    }

    public void onViewAdded(View arg2) {
        throw new IllegalStateException(this.getClass().getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int arg2, Bundle arg3) {
        if(this.mAccessibilityProvider.handlesPerformAccessibilityAction(arg2, arg3)) {
            return this.mAccessibilityProvider.onPerformAccessibilityAction(arg2, arg3);
        }

        return super.performAccessibilityAction(arg2, arg3);
    }

    private void registerCurrentItemDataSetTracker(Adapter arg1) {
        if(arg1 != null) {
            arg1.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    public void registerOnPageChangeCallback(OnPageChangeCallback arg1) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(arg1);
    }

    public void removeItemDecoration(ItemDecoration arg1) {
        this.mRecyclerView.removeItemDecoration(arg1);
    }

    public void removeItemDecorationAt(int arg1) {
        this.mRecyclerView.removeItemDecorationAt(arg1);
    }

    public void requestTransform() {
        if(this.mPageTransformerAdapter.getPageTransformer() == null) {
            return;
        }

        double v0 = this.mScrollEventAdapter.getRelativeScrollPosition();
        int v2 = ((int)v0);
        float v0_1 = ((float)(v0 - (((double)v2))));
        this.mPageTransformerAdapter.onPageScrolled(v2, v0_1, Math.round((((float)this.getPageSize())) * v0_1));
    }

    private void restorePendingState() {
        Adapter v0;
        int v1 = -1;
        if(this.mPendingCurrentItem == v1) {
        }
        else {
            v0 = this.getAdapter();
            if(v0 == null) {
                return;
            }

            goto label_7;
        }

        return;
    label_7:
        Parcelable v2 = this.mPendingAdapterState;
        if(v2 != null) {
            if((v0 instanceof StatefulAdapter)) {
                v0.restoreState(v2);
            }

            this.mPendingAdapterState = null;
        }

        int v0_1 = Math.max(0, Math.min(this.mPendingCurrentItem, v0.getItemCount() - 1));
        this.mCurrentItem = v0_1;
        this.mPendingCurrentItem = v1;
        this.mRecyclerView.scrollToPosition(v0_1);
        this.mAccessibilityProvider.onRestorePendingState();
    }

    public void setAdapter(Adapter arg3) {
        Adapter v0 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(v0);
        this.unregisterCurrentItemDataSetTracker(v0);
        this.mRecyclerView.setAdapter(arg3);
        this.mCurrentItem = 0;
        this.restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(arg3);
        this.registerCurrentItemDataSetTracker(arg3);
    }

    public void setCurrentItem(int arg2) {
        this.setCurrentItem(arg2, true);
    }

    public void setCurrentItem(int arg2, boolean arg3) {
        if(!this.isFakeDragging()) {
            this.setCurrentItemInternal(arg2, arg3);
            return;
        }

        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    void setCurrentItemInternal(int arg9, boolean arg10) {
        int v0_1;
        Adapter v0 = this.getAdapter();
        if(v0 == null) {
            if(this.mPendingCurrentItem != -1) {
                this.mPendingCurrentItem = Math.max(arg9, 0);
                return;
            }
        }
        else if(v0.getItemCount() <= 0) {
        }
        else {
            arg9 = Math.min(Math.max(arg9, 0), v0.getItemCount() - 1);
            if(arg9 == this.mCurrentItem && (this.mScrollEventAdapter.isIdle())) {
                return;
            }

            v0_1 = this.mCurrentItem;
            if(arg9 == v0_1 && (arg10)) {
                return;
            }

            goto label_26;
        }

        return;
    label_26:
        double v0_2 = ((double)v0_1);
        this.mCurrentItem = arg9;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        if(!this.mScrollEventAdapter.isIdle()) {
            v0_2 = this.mScrollEventAdapter.getRelativeScrollPosition();
        }

        this.mScrollEventAdapter.notifyProgrammaticScroll(arg9, arg10);
        if(!arg10) {
            this.mRecyclerView.scrollToPosition(arg9);
            return;
        }

        double v2 = ((double)arg9);
        int v10 = Double.compare(Math.abs(v2 - v0_2), 3);
        RecyclerView v4 = this.mRecyclerView;
        if(v10 > 0) {
            v10 = v2 > v0_2 ? arg9 - 3 : arg9 + 3;
            v4.scrollToPosition(v10);
            this.mRecyclerView.post(new SmoothScrollToPosition(arg9, this.mRecyclerView));
            return;
        }

        v4.smoothScrollToPosition(arg9);
    }

    public void setLayoutDirection(int arg1) {
        super.setLayoutDirection(arg1);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int arg2) {
        if(arg2 < 1) {
            if(arg2 == -1) {
            }
            else {
                throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
            }
        }

        this.mOffscreenPageLimit = arg2;
        this.mRecyclerView.requestLayout();
    }

    private void setOrientation(Context arg9, AttributeSet arg10) {
        ViewPager2 v1;
        TypedArray v5 = arg9.obtainStyledAttributes(arg10, styleable.ViewPager2);
        if(Build$VERSION.SDK_INT >= 29) {
            v1 = this;
            v1.saveAttributeDataForStyleable(arg9, styleable.ViewPager2, arg10, v5, 0, 0);
        }
        else {
            v1 = this;
        }

        try {
            v1.setOrientation(v5.getInt(styleable.ViewPager2_android_orientation, 0));
        }
        catch(Throwable v0) {
            v5.recycle();
            throw v0;
        }

        v5.recycle();
    }

    public void setOrientation(int arg2) {
        this.mLayoutManager.setOrientation(arg2);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public void setPageTransformer(PageTransformer arg4) {
        boolean v0 = this.mSavedItemAnimatorPresent;
        ItemAnimator v1 = null;
        if(arg4 != null) {
            if(!v0) {
                this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = true;
            }

            this.mRecyclerView.setItemAnimator(v1);
        }
        else {
            if(!v0) {
                goto label_19;
            }

            this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
            this.mSavedItemAnimator = v1;
            this.mSavedItemAnimatorPresent = false;
        }

    label_19:
        if(arg4 == this.mPageTransformerAdapter.getPageTransformer()) {
            return;
        }

        this.mPageTransformerAdapter.setPageTransformer(arg4);
        this.requestTransform();
    }

    public void setUserInputEnabled(boolean arg1) {
        this.mUserInputEnabled = arg1;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    void snapToPage() {
        int v1;
        int[] v0_1;
        View v0 = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if(v0 == null) {
        }
        else {
            v0_1 = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, v0);
            v1 = v0_1[0];
            if(v1 == 0) {
                if(v0_1[1] != 0) {
                }
                else {
                    return;
                }
            }

            goto label_16;
        }

        return;
    label_16:
        this.mRecyclerView.smoothScrollBy(v1, v0_1[1]);
    }

    private void unregisterCurrentItemDataSetTracker(Adapter arg1) {
        if(arg1 != null) {
            arg1.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    public void unregisterOnPageChangeCallback(OnPageChangeCallback arg1) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(arg1);
    }

    void updateCurrentItem() {
        PagerSnapHelper v0 = this.mPagerSnapHelper;
        if(v0 != null) {
            View v0_1 = v0.findSnapView(this.mLayoutManager);
            if(v0_1 == null) {
                return;
            }

            int v0_2 = this.mLayoutManager.getPosition(v0_1);
            if(v0_2 != this.mCurrentItem && this.getScrollState() == 0) {
                this.mPageChangeEventDispatcher.onPageSelected(v0_2);
            }

            this.mCurrentItemDirty = false;
            return;
        }

        throw new IllegalStateException("Design assumption violated.");
    }
}

