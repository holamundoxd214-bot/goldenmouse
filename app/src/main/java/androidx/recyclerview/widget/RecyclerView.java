package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements NestedScrollingChild2, NestedScrollingChild3, ScrollingView {
    class androidx.recyclerview.widget.RecyclerView$1 implements Runnable {
        androidx.recyclerview.widget.RecyclerView$1(RecyclerView arg1) {
            RecyclerView.this = arg1;
            super();
        }

        public void run() {
            if(RecyclerView.this.mFirstLayoutComplete) {
                if(RecyclerView.this.isLayoutRequested()) {
                }
                else {
                    boolean v0 = RecyclerView.this.mIsAttached;
                    RecyclerView v1 = RecyclerView.this;
                    if(!v0) {
                        v1.requestLayout();
                        return;
                    }
                    else {
                        v0 = v1.mLayoutSuppressed;
                        RecyclerView v2 = RecyclerView.this;
                        if(v0) {
                            v2.mLayoutWasDefered = true;
                            return;
                        }
                        else {
                            v2.consumePendingUpdateOperations();
                        }
                    }
                }
            }
        }
    }

    class androidx.recyclerview.widget.RecyclerView$2 implements Runnable {
        androidx.recyclerview.widget.RecyclerView$2(RecyclerView arg1) {
            RecyclerView.this = arg1;
            super();
        }

        public void run() {
            if(RecyclerView.this.mItemAnimator != null) {
                RecyclerView.this.mItemAnimator.runPendingAnimations();
            }

            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    final class androidx.recyclerview.widget.RecyclerView$3 implements Interpolator {
        androidx.recyclerview.widget.RecyclerView$3() {
            super();
        }

        public float getInterpolation(float arg2) {
            --arg2;
            return arg2 * arg2 * arg2 * arg2 * arg2 + 1f;
        }
    }

    class androidx.recyclerview.widget.RecyclerView$4 implements ProcessCallback {
        androidx.recyclerview.widget.RecyclerView$4(RecyclerView arg1) {
            RecyclerView.this = arg1;
            super();
        }

        public void processAppeared(ViewHolder arg1, ItemHolderInfo arg2, ItemHolderInfo arg3) {
            RecyclerView.this.animateAppearance(arg1, arg2, arg3);
        }

        public void processDisappeared(ViewHolder arg2, ItemHolderInfo arg3, ItemHolderInfo arg4) {
            RecyclerView.this.mRecycler.unscrapView(arg2);
            RecyclerView.this.animateDisappearance(arg2, arg3, arg4);
        }

        public void processPersistent(ViewHolder arg3, ItemHolderInfo arg4, ItemHolderInfo arg5) {
            arg3.setIsRecyclable(false);
            boolean v0 = RecyclerView.this.mDataSetHasChangedAfterLayout;
            RecyclerView v1 = RecyclerView.this;
            if(v0) {
                if(v1.mItemAnimator.animateChange(arg3, arg3, arg4, arg5)) {
                    RecyclerView.this.postAnimationRunner();
                    return;
                }
            }
            else if(v1.mItemAnimator.animatePersistence(arg3, arg4, arg5)) {
                RecyclerView.this.postAnimationRunner();
            }
        }

        public void unused(ViewHolder arg2) {
            RecyclerView.this.mLayout.removeAndRecycleView(arg2.itemView, RecyclerView.this.mRecycler);
        }
    }

    public abstract class Adapter {
        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable;

        public Adapter() {
            super();
            this.mObservable = new AdapterDataObservable();
            this.mHasStableIds = false;
        }

        public final void bindViewHolder(ViewHolder arg3, int arg4) {
            arg3.mPosition = arg4;
            if(this.hasStableIds()) {
                arg3.mItemId = this.getItemId(arg4);
            }

            arg3.setFlags(1, 0x207);
            TraceCompat.beginSection("RV OnBindView");
            this.onBindViewHolder(arg3, arg4, arg3.getUnmodifiedPayloads());
            arg3.clearPayload();
            ViewGroup$LayoutParams v2 = arg3.itemView.getLayoutParams();
            if((v2 instanceof LayoutParams)) {
                ((LayoutParams)v2).mInsetsDirty = true;
            }

            TraceCompat.endSection();
        }

        public final ViewHolder createViewHolder(ViewGroup arg2, int arg3) {
            ViewHolder v1_1;
            try {
                TraceCompat.beginSection("RV CreateView");
                v1_1 = this.onCreateViewHolder(arg2, arg3);
                if(v1_1.itemView.getParent() != null) {
                    goto label_9;
                }

                v1_1.mItemViewType = arg3;
            }
            catch(Throwable v1) {
                goto label_14;
            }

            TraceCompat.endSection();
            return v1_1;
            try {
            label_9:
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing \'true\' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            catch(Throwable v1) {
            label_14:
                TraceCompat.endSection();
                throw v1;
            }
        }

        public abstract int getItemCount();

        public long getItemId(int arg1) {
            return -1;
        }

        public int getItemViewType(int arg1) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int arg2) {
            this.mObservable.notifyItemRangeChanged(arg2, 1);
        }

        public final void notifyItemChanged(int arg2, Object arg3) {
            this.mObservable.notifyItemRangeChanged(arg2, 1, arg3);
        }

        public final void notifyItemInserted(int arg2) {
            this.mObservable.notifyItemRangeInserted(arg2, 1);
        }

        public final void notifyItemMoved(int arg1, int arg2) {
            this.mObservable.notifyItemMoved(arg1, arg2);
        }

        public final void notifyItemRangeChanged(int arg1, int arg2, Object arg3) {
            this.mObservable.notifyItemRangeChanged(arg1, arg2, arg3);
        }

        public final void notifyItemRangeChanged(int arg1, int arg2) {
            this.mObservable.notifyItemRangeChanged(arg1, arg2);
        }

        public final void notifyItemRangeInserted(int arg1, int arg2) {
            this.mObservable.notifyItemRangeInserted(arg1, arg2);
        }

        public final void notifyItemRangeRemoved(int arg1, int arg2) {
            this.mObservable.notifyItemRangeRemoved(arg1, arg2);
        }

        public final void notifyItemRemoved(int arg2) {
            this.mObservable.notifyItemRangeRemoved(arg2, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView arg1) {
        }

        public void onBindViewHolder(ViewHolder arg1, int arg2, List arg3) {
            this.onBindViewHolder(arg1, arg2);
        }

        public abstract void onBindViewHolder(ViewHolder arg1, int arg2);

        public abstract ViewHolder onCreateViewHolder(ViewGroup arg1, int arg2);

        public void onDetachedFromRecyclerView(RecyclerView arg1) {
        }

        public boolean onFailedToRecycleView(ViewHolder arg1) {
            return 0;
        }

        public void onViewAttachedToWindow(ViewHolder arg1) {
        }

        public void onViewDetachedFromWindow(ViewHolder arg1) {
        }

        public void onViewRecycled(ViewHolder arg1) {
        }

        public void registerAdapterDataObserver(AdapterDataObserver arg1) {
            this.mObservable.registerObserver(arg1);
        }

        public void setHasStableIds(boolean arg2) {
            if(!this.hasObservers()) {
                this.mHasStableIds = arg2;
                return;
            }

            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver arg1) {
            this.mObservable.unregisterObserver(arg1);
        }
    }

    class AdapterDataObservable extends Observable {
        AdapterDataObservable() {
            super();
        }

        public boolean hasObservers() {
            return this.mObservers.isEmpty() ^ 1;
        }

        public void notifyChanged() {
            int v0;
            for(v0 = this.mObservers.size() - 1; v0 >= 0; --v0) {
                this.mObservers.get(v0).onChanged();
            }
        }

        public void notifyItemMoved(int arg4, int arg5) {
            int v0;
            for(v0 = this.mObservers.size() - 1; v0 >= 0; --v0) {
                this.mObservers.get(v0).onItemRangeMoved(arg4, arg5, 1);
            }
        }

        public void notifyItemRangeChanged(int arg2, int arg3) {
            this.notifyItemRangeChanged(arg2, arg3, null);
        }

        public void notifyItemRangeChanged(int arg3, int arg4, Object arg5) {
            int v0;
            for(v0 = this.mObservers.size() - 1; v0 >= 0; --v0) {
                this.mObservers.get(v0).onItemRangeChanged(arg3, arg4, arg5);
            }
        }

        public void notifyItemRangeInserted(int arg3, int arg4) {
            int v0;
            for(v0 = this.mObservers.size() - 1; v0 >= 0; --v0) {
                this.mObservers.get(v0).onItemRangeInserted(arg3, arg4);
            }
        }

        public void notifyItemRangeRemoved(int arg3, int arg4) {
            int v0;
            for(v0 = this.mObservers.size() - 1; v0 >= 0; --v0) {
                this.mObservers.get(v0).onItemRangeRemoved(arg3, arg4);
            }
        }
    }

    public abstract class AdapterDataObserver {
        public AdapterDataObserver() {
            super();
        }

        public void onChanged() {
        }

        public void onItemRangeChanged(int arg1, int arg2, Object arg3) {
            this.onItemRangeChanged(arg1, arg2);
        }

        public void onItemRangeChanged(int arg1, int arg2) {
        }

        public void onItemRangeInserted(int arg1, int arg2) {
        }

        public void onItemRangeMoved(int arg1, int arg2, int arg3) {
        }

        public void onItemRangeRemoved(int arg1, int arg2) {
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int arg1, int arg2);
    }

    public class EdgeEffectFactory {
        @Retention(value=RetentionPolicy.SOURCE) @public interface EdgeDirection {
        }

        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        public EdgeEffectFactory() {
            super();
        }

        protected EdgeEffect createEdgeEffect(RecyclerView arg1, int arg2) {
            return new EdgeEffect(arg1.getContext());
        }
    }

    public abstract class ItemAnimator {
        @Retention(value=RetentionPolicy.SOURCE) @public interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        interface ItemAnimatorListener {
            void onAnimationFinished(ViewHolder arg1);
        }

        public class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo() {
                super();
            }

            public ItemHolderInfo setFrom(ViewHolder arg2) {
                return this.setFrom(arg2, 0);
            }

            public ItemHolderInfo setFrom(ViewHolder arg1, int arg2) {
                View v1 = arg1.itemView;
                this.left = v1.getLeft();
                this.top = v1.getTop();
                this.right = v1.getRight();
                this.bottom = v1.getBottom();
                return this;
            }
        }

        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 0x1000;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 0x800;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration;
        private long mChangeDuration;
        private ArrayList mFinishedListeners;
        private ItemAnimatorListener mListener;
        private long mMoveDuration;
        private long mRemoveDuration;

        public ItemAnimator() {
            super();
            this.mListener = null;
            this.mFinishedListeners = new ArrayList();
            this.mAddDuration = 120;
            this.mRemoveDuration = 120;
            this.mMoveDuration = 0xFA;
            this.mChangeDuration = 0xFA;
        }

        public abstract boolean animateAppearance(ViewHolder arg1, ItemHolderInfo arg2, ItemHolderInfo arg3);

        public abstract boolean animateChange(ViewHolder arg1, ViewHolder arg2, ItemHolderInfo arg3, ItemHolderInfo arg4);

        public abstract boolean animateDisappearance(ViewHolder arg1, ItemHolderInfo arg2, ItemHolderInfo arg3);

        public abstract boolean animatePersistence(ViewHolder arg1, ItemHolderInfo arg2, ItemHolderInfo arg3);

        static int buildAdapterChangeFlagsForAnimations(ViewHolder arg4) {
            int v0 = arg4.mFlags;
            int v1 = v0 & 14;
            int v3 = 4;
            if(arg4.isInvalid()) {
                return v3;
            }

            if((v0 & v3) == 0) {
                v0 = arg4.getOldPosition();
                int v4 = arg4.getAdapterPosition();
                int v2 = -1;
                if(v0 != v2 && v4 != v2 && v0 != v4) {
                    return v1 | 0x800;
                }
            }

            return v1;
        }

        public boolean canReuseUpdatedViewHolder(ViewHolder arg1, List arg2) {
            return this.canReuseUpdatedViewHolder(arg1);
        }

        public boolean canReuseUpdatedViewHolder(ViewHolder arg1) {
            return 1;
        }

        public final void dispatchAnimationFinished(ViewHolder arg1) {
            this.onAnimationFinished(arg1);
            ItemAnimatorListener v0 = this.mListener;
            if(v0 != null) {
                v0.onAnimationFinished(arg1);
            }
        }

        public final void dispatchAnimationStarted(ViewHolder arg1) {
            this.onAnimationStarted(arg1);
        }

        public final void dispatchAnimationsFinished() {
            ArrayList v2;
            int v0 = this.mFinishedListeners.size();
            int v1;
            for(v1 = 0; true; ++v1) {
                v2 = this.mFinishedListeners;
                if(v1 >= v0) {
                    break;
                }

                v2.get(v1).onAnimationsFinished();
            }

            v2.clear();
        }

        public abstract void endAnimation(ViewHolder arg1);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public final boolean isRunning(ItemAnimatorFinishedListener arg2) {
            boolean v0 = this.isRunning();
            if(arg2 != null) {
                if(!v0) {
                    arg2.onAnimationsFinished();
                    return v0;
                }
                else {
                    this.mFinishedListeners.add(arg2);
                }
            }

            return v0;
        }

        public abstract boolean isRunning();

        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(ViewHolder arg1) {
        }

        public void onAnimationStarted(ViewHolder arg1) {
        }

        public ItemHolderInfo recordPostLayoutInformation(State arg1, ViewHolder arg2) {
            return this.obtainHolderInfo().setFrom(arg2);
        }

        public ItemHolderInfo recordPreLayoutInformation(State arg1, ViewHolder arg2, int arg3, List arg4) {
            return this.obtainHolderInfo().setFrom(arg2);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long arg1) {
            this.mAddDuration = arg1;
        }

        public void setChangeDuration(long arg1) {
            this.mChangeDuration = arg1;
        }

        void setListener(ItemAnimatorListener arg1) {
            this.mListener = arg1;
        }

        public void setMoveDuration(long arg1) {
            this.mMoveDuration = arg1;
        }

        public void setRemoveDuration(long arg1) {
            this.mRemoveDuration = arg1;
        }
    }

    class ItemAnimatorRestoreListener implements ItemAnimatorListener {
        ItemAnimatorRestoreListener(RecyclerView arg1) {
            RecyclerView.this = arg1;
            super();
        }

        public void onAnimationFinished(ViewHolder arg3) {
            arg3.setIsRecyclable(true);
            ViewHolder v1 = null;
            if(arg3.mShadowedHolder != null && arg3.mShadowingHolder == null) {
                arg3.mShadowedHolder = v1;
            }

            arg3.mShadowingHolder = v1;
            if(!arg3.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(arg3.itemView) && (arg3.isTmpDetached())) {
                RecyclerView.this.removeDetachedView(arg3.itemView, false);
            }
        }
    }

    public abstract class ItemDecoration {
        public ItemDecoration() {
            super();
        }

        public void getItemOffsets(Rect arg1, View arg2, RecyclerView arg3, State arg4) {
            this.getItemOffsets(arg1, arg2.getLayoutParams().getViewLayoutPosition(), arg3);
        }

        @Deprecated public void getItemOffsets(Rect arg1, int arg2, RecyclerView arg3) {
            arg1.set(0, 0, 0, 0);
        }

        public void onDraw(Canvas arg1, RecyclerView arg2, State arg3) {
            this.onDraw(arg1, arg2);
        }

        @Deprecated public void onDraw(Canvas arg1, RecyclerView arg2) {
        }

        public void onDrawOver(Canvas arg1, RecyclerView arg2, State arg3) {
            this.onDrawOver(arg1, arg2);
        }

        @Deprecated public void onDrawOver(Canvas arg1, RecyclerView arg2) {
        }
    }

    public abstract class LayoutManager {
        class androidx.recyclerview.widget.RecyclerView$LayoutManager$1 implements Callback {
            androidx.recyclerview.widget.RecyclerView$LayoutManager$1(LayoutManager arg1) {
                LayoutManager.this = arg1;
                super();
            }

            public View getChildAt(int arg1) {
                return LayoutManager.this.getChildAt(arg1);
            }

            public int getChildEnd(View arg2) {
                return LayoutManager.this.getDecoratedRight(arg2) + arg2.getLayoutParams().rightMargin;
            }

            public int getChildStart(View arg2) {
                return LayoutManager.this.getDecoratedLeft(arg2) - arg2.getLayoutParams().leftMargin;
            }

            public int getParentEnd() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            public int getParentStart() {
                return LayoutManager.this.getPaddingLeft();
            }
        }

        class androidx.recyclerview.widget.RecyclerView$LayoutManager$2 implements Callback {
            androidx.recyclerview.widget.RecyclerView$LayoutManager$2(LayoutManager arg1) {
                LayoutManager.this = arg1;
                super();
            }

            public View getChildAt(int arg1) {
                return LayoutManager.this.getChildAt(arg1);
            }

            public int getChildEnd(View arg2) {
                return LayoutManager.this.getDecoratedBottom(arg2) + arg2.getLayoutParams().bottomMargin;
            }

            public int getChildStart(View arg2) {
                return LayoutManager.this.getDecoratedTop(arg2) - arg2.getLayoutParams().topMargin;
            }

            public int getParentEnd() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            public int getParentStart() {
                return LayoutManager.this.getPaddingTop();
            }
        }

        public interface LayoutPrefetchRegistry {
            void addPosition(int arg1, int arg2);
        }

        public class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;

            public Properties() {
                super();
            }
        }

        boolean mAutoMeasure;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public LayoutManager() {
            super();
            androidx.recyclerview.widget.RecyclerView$LayoutManager$1 v0 = new androidx.recyclerview.widget.RecyclerView$LayoutManager$1(this);
            this.mHorizontalBoundCheckCallback = ((Callback)v0);
            androidx.recyclerview.widget.RecyclerView$LayoutManager$2 v1 = new androidx.recyclerview.widget.RecyclerView$LayoutManager$2(this);
            this.mVerticalBoundCheckCallback = ((Callback)v1);
            this.mHorizontalBoundCheck = new ViewBoundsCheck(((Callback)v0));
            this.mVerticalBoundCheck = new ViewBoundsCheck(((Callback)v1));
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        public void addDisappearingView(View arg2) {
            this.addDisappearingView(arg2, -1);
        }

        public void addDisappearingView(View arg2, int arg3) {
            this.addViewInt(arg2, arg3, true);
        }

        public void addView(View arg2) {
            this.addView(arg2, -1);
        }

        public void addView(View arg2, int arg3) {
            this.addViewInt(arg2, arg3, false);
        }

        private void addViewInt(View arg6, int arg7, boolean arg8) {
            ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg6);
            if((arg8) || (v0.isRemoved())) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(v0);
            }
            else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(v0);
            }

            ViewGroup$LayoutParams v8 = arg6.getLayoutParams();
            if((v0.wasReturnedFromScrap()) || (v0.isScrap())) {
                if(v0.isScrap()) {
                    v0.unScrap();
                }
                else {
                    v0.clearReturnedFromScrapFlag();
                }

                this.mChildHelper.attachViewToParent(arg6, arg7, arg6.getLayoutParams(), false);
            }
            else {
                ViewParent v1 = arg6.getParent();
                RecyclerView v3 = this.mRecyclerView;
                ChildHelper v4 = this.mChildHelper;
                if(v1 == (((ViewParent)v3))) {
                    int v1_1 = v4.indexOfChild(arg6);
                    int v3_1 = -1;
                    if(arg7 == v3_1) {
                        arg7 = this.mChildHelper.getChildCount();
                    }

                    if(v1_1 != v3_1) {
                        if(v1_1 == arg7) {
                            goto label_65;
                        }

                        this.mRecyclerView.mLayout.moveView(v1_1, arg7);
                        goto label_65;
                    }

                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(arg6) + this.mRecyclerView.exceptionLabel());
                }
                else {
                    v4.addView(arg6, arg7, false);
                    ((LayoutParams)v8).mInsetsDirty = true;
                    SmoothScroller v7 = this.mSmoothScroller;
                    if(v7 == null) {
                        goto label_65;
                    }

                    if(!v7.isRunning()) {
                        goto label_65;
                    }

                    this.mSmoothScroller.onChildAttachedToWindow(arg6);
                }
            }

        label_65:
            if(((LayoutParams)v8).mPendingInvalidate) {
                v0.itemView.invalidate();
                ((LayoutParams)v8).mPendingInvalidate = false;
            }
        }

        public void assertInLayoutOrScroll(String arg1) {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                v0.assertInLayoutOrScroll(arg1);
            }
        }

        public void assertNotInLayoutOrScroll(String arg1) {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                v0.assertNotInLayoutOrScroll(arg1);
            }
        }

        public void attachView(View arg2) {
            this.attachView(arg2, -1);
        }

        public void attachView(View arg2, int arg3) {
            this.attachView(arg2, arg3, arg2.getLayoutParams());
        }

        public void attachView(View arg4, int arg5, LayoutParams arg6) {
            ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg4);
            boolean v1 = v0.isRemoved();
            RecyclerView v2 = this.mRecyclerView;
            if(v1) {
                v2.mViewInfoStore.addToDisappearedInLayout(v0);
            }
            else {
                v2.mViewInfoStore.removeFromDisappearedInLayout(v0);
            }

            this.mChildHelper.attachViewToParent(arg4, arg5, ((ViewGroup$LayoutParams)arg6), v0.isRemoved());
        }

        public void calculateItemDecorationsForChild(View arg1, Rect arg2) {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 == null) {
                arg2.set(0, 0, 0, 0);
                return;
            }

            arg2.set(v0.getItemDecorInsetsForChild(arg1));
        }

        public boolean canScrollHorizontally() {
            return 0;
        }

        public boolean canScrollVertically() {
            return 0;
        }

        public boolean checkLayoutParams(LayoutParams arg1) {
            if(arg1 != null) {
                return 1;
            }

            return 0;
        }

        public static int chooseSize(int arg2, int arg3, int arg4) {
            int v0 = View$MeasureSpec.getMode(arg2);
            arg2 = View$MeasureSpec.getSize(arg2);
            if(v0 != 0x80000000) {
                if(v0 != 0x40000000) {
                    arg2 = Math.max(arg3, arg4);
                }

                return arg2;
            }

            return Math.min(arg2, Math.max(arg3, arg4));
        }

        public void collectAdjacentPrefetchPositions(int arg1, int arg2, State arg3, LayoutPrefetchRegistry arg4) {
        }

        public void collectInitialPrefetchPositions(int arg1, LayoutPrefetchRegistry arg2) {
        }

        public int computeHorizontalScrollExtent(State arg1) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State arg1) {
            return 0;
        }

        public int computeHorizontalScrollRange(State arg1) {
            return 0;
        }

        public int computeVerticalScrollExtent(State arg1) {
            return 0;
        }

        public int computeVerticalScrollOffset(State arg1) {
            return 0;
        }

        public int computeVerticalScrollRange(State arg1) {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler arg3) {
            int v0;
            for(v0 = this.getChildCount() - 1; v0 >= 0; --v0) {
                this.scrapOrRecycleView(arg3, v0, this.getChildAt(v0));
            }
        }

        public void detachAndScrapView(View arg2, Recycler arg3) {
            this.scrapOrRecycleView(arg3, this.mChildHelper.indexOfChild(arg2), arg2);
        }

        public void detachAndScrapViewAt(int arg2, Recycler arg3) {
            this.scrapOrRecycleView(arg3, arg2, this.getChildAt(arg2));
        }

        public void detachView(View arg2) {
            int v0 = this.mChildHelper.indexOfChild(arg2);
            if(v0 >= 0) {
                this.detachViewInternal(v0, arg2);
            }
        }

        public void detachViewAt(int arg2) {
            this.detachViewInternal(arg2, this.getChildAt(arg2));
        }

        private void detachViewInternal(int arg1, View arg2) {
            this.mChildHelper.detachViewFromParent(arg1);
        }

        void dispatchAttachedToWindow(RecyclerView arg2) {
            this.mIsAttachedToWindow = true;
            this.onAttachedToWindow(arg2);
        }

        void dispatchDetachedFromWindow(RecyclerView arg2, Recycler arg3) {
            this.mIsAttachedToWindow = false;
            this.onDetachedFromWindow(arg2, arg3);
        }

        public void endAnimation(View arg2) {
            if(this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(arg2));
            }
        }

        public View findContainingItemView(View arg3) {
            RecyclerView v0 = this.mRecyclerView;
            View v1 = null;
            if(v0 == null) {
                return v1;
            }

            arg3 = v0.findContainingItemView(arg3);
            if(arg3 == null) {
                return v1;
            }

            if(this.mChildHelper.isHidden(arg3)) {
                return v1;
            }

            return arg3;
        }

        public View findViewByPosition(int arg6) {
            int v0 = this.getChildCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                View v2 = this.getChildAt(v1);
                ViewHolder v3 = RecyclerView.getChildViewHolderInt(v2);
                if(v3 == null) {
                }
                else if(v3.getLayoutPosition() == arg6 && !v3.shouldIgnore()) {
                    if(!this.mRecyclerView.mState.isPreLayout() && (v3.isRemoved())) {
                        goto label_18;
                    }

                    return v2;
                }

            label_18:
            }

            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(Context arg1, AttributeSet arg2) {
            return new LayoutParams(arg1, arg2);
        }

        public LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
            if((arg1 instanceof LayoutParams)) {
                return new LayoutParams(((LayoutParams)arg1));
            }

            if((arg1 instanceof ViewGroup$MarginLayoutParams)) {
                return new LayoutParams(((ViewGroup$MarginLayoutParams)arg1));
            }

            return new LayoutParams(arg1);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View arg1) {
            return arg1.getLayoutParams().mDecorInsets.bottom;
        }

        public View getChildAt(int arg1) {
            ChildHelper v0 = this.mChildHelper;
            if(v0 != null) {
                return v0.getChildAt(arg1);
            }

            return null;
        }

        public int getChildCount() {
            ChildHelper v0 = this.mChildHelper;
            if(v0 != null) {
                return v0.getChildCount();
            }

            return 0;
        }

        public static int getChildMeasureSpec(int arg4, int arg5, int arg6, int arg7, boolean arg8) {
            arg4 = Math.max(0, arg4 - arg6);
            int v0 = -2;
            int v1 = -1;
            int v2 = 0x80000000;
            int v3 = 0x40000000;
            if(arg8) {
                if(arg7 >= 0) {
                    goto label_16;
                }
                else if(arg7 != v1) {
                    goto label_31;
                }
                else if(arg5 == v2) {
                    goto label_19;
                }
                else if(arg5 == 0) {
                    goto label_31;
                }
                else if(arg5 != v3) {
                    goto label_31;
                }
                else {
                    goto label_19;
                }
            }
            else if(arg7 >= 0) {
            label_16:
                arg5 = v3;
            }
            else if(arg7 == v1) {
            label_19:
                arg7 = arg4;
            }
            else if(arg7 == v0) {
                if(arg5 != v2) {
                    if(arg5 == v3) {
                    }
                    else {
                        arg7 = arg4;
                        arg5 = 0;
                        goto label_33;
                    }
                }

                arg7 = arg4;
                arg5 = v2;
            }
            else {
            label_31:
                arg5 = 0;
                arg7 = 0;
            }

        label_33:
            return View$MeasureSpec.makeMeasureSpec(arg7, arg5);
        }

        @Deprecated public static int getChildMeasureSpec(int arg1, int arg2, int arg3, boolean arg4) {
            arg1 -= arg2;
            arg2 = 0;
            arg1 = Math.max(0, arg1);
            int v0 = 0x40000000;
            if(arg4) {
                if(arg3 >= 0) {
                    goto label_10;
                }
                else {
                    goto label_7;
                }
            }
            else if(arg3 >= 0) {
            label_10:
                arg2 = v0;
                goto label_20;
            label_16:
                if(arg3 == -2) {
                    arg2 = 0x80000000;
                    arg3 = arg1;
                }
                else {
                label_7:
                    arg3 = 0;
                }
            }
            else if(arg3 == -1) {
                arg3 = arg1;
                goto label_10;
            }
            else {
                goto label_16;
            }

        label_20:
            return View$MeasureSpec.makeMeasureSpec(arg3, arg2);
        }

        private int[] getChildRectangleOnScreenScrollAmount(View arg8, Rect arg9) {
            int v0 = this.getPaddingLeft();
            int v1 = this.getPaddingTop();
            int v2 = this.getWidth() - this.getPaddingRight();
            int v3 = this.getHeight() - this.getPaddingBottom();
            int v4 = arg8.getLeft() + arg9.left - arg8.getScrollX();
            int v5 = arg8.getTop() + arg9.top - arg8.getScrollY();
            int v8 = arg9.width() + v4;
            int v9 = arg9.height() + v5;
            v4 -= v0;
            int v6 = Math.min(0, v4);
            v5 -= v1;
            v1 = Math.min(0, v5);
            v8 -= v2;
            v2 = Math.max(0, v8);
            v9 = Math.max(0, v9 - v3);
            if(this.getLayoutDirection() != 1) {
                if(v6 != 0) {
                }
                else {
                    v6 = Math.min(v4, v2);
                }

                v2 = v6;
            }
            else if(v2 != 0) {
            }
            else {
                v2 = Math.max(v6, v8);
            }

            if(v1 != 0) {
            }
            else {
                v1 = Math.min(v5, v9);
            }

            return new int[]{v2, v1};
        }

        public boolean getClipToPadding() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null && (v0.mClipToPadding)) {
                return 1;
            }

            return 0;
        }

        public int getColumnCountForAccessibility(Recycler arg1, State arg2) {
            RecyclerView v1 = this.mRecyclerView;
            if(v1 != null) {
                if(v1.mAdapter == null) {
                }
                else if(this.canScrollHorizontally()) {
                    return this.mRecyclerView.mAdapter.getItemCount();
                }
            }

            return 1;
        }

        public int getDecoratedBottom(View arg2) {
            return arg2.getBottom() + this.getBottomDecorationHeight(arg2);
        }

        public void getDecoratedBoundsWithMargins(View arg1, Rect arg2) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(arg1, arg2);
        }

        public int getDecoratedLeft(View arg2) {
            return arg2.getLeft() - this.getLeftDecorationWidth(arg2);
        }

        public int getDecoratedMeasuredHeight(View arg2) {
            Rect v1 = arg2.getLayoutParams().mDecorInsets;
            return arg2.getMeasuredHeight() + v1.top + v1.bottom;
        }

        public int getDecoratedMeasuredWidth(View arg2) {
            Rect v1 = arg2.getLayoutParams().mDecorInsets;
            return arg2.getMeasuredWidth() + v1.left + v1.right;
        }

        public int getDecoratedRight(View arg2) {
            return arg2.getRight() + this.getRightDecorationWidth(arg2);
        }

        public int getDecoratedTop(View arg2) {
            return arg2.getTop() - this.getTopDecorationHeight(arg2);
        }

        public View getFocusedChild() {
            RecyclerView v0 = this.mRecyclerView;
            View v1 = null;
            if(v0 == null) {
                return v1;
            }

            View v0_1 = v0.getFocusedChild();
            if(v0_1 != null) {
                if(this.mChildHelper.isHidden(v0_1)) {
                }
                else {
                    return v0_1;
                }
            }

            return v1;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView v0 = this.mRecyclerView;
            Adapter v0_1 = v0 != null ? v0.getAdapter() : null;
            if(v0_1 != null) {
                return v0_1.getItemCount();
            }

            return 0;
        }

        public int getItemViewType(View arg1) {
            return RecyclerView.getChildViewHolderInt(arg1).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View arg1) {
            return arg1.getLayoutParams().mDecorInsets.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                return v0.getPaddingBottom();
            }

            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                return ViewCompat.getPaddingEnd(((View)v0));
            }

            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                return v0.getPaddingLeft();
            }

            return 0;
        }

        public int getPaddingRight() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                return v0.getPaddingRight();
            }

            return 0;
        }

        public int getPaddingStart() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                return ViewCompat.getPaddingStart(((View)v0));
            }

            return 0;
        }

        public int getPaddingTop() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                return v0.getPaddingTop();
            }

            return 0;
        }

        public int getPosition(View arg1) {
            return arg1.getLayoutParams().getViewLayoutPosition();
        }

        public static Properties getProperties(Context arg2, AttributeSet arg3, int arg4, int arg5) {
            Properties v0 = new Properties();
            TypedArray v2 = arg2.obtainStyledAttributes(arg3, styleable.RecyclerView, arg4, arg5);
            v0.orientation = v2.getInt(styleable.RecyclerView_android_orientation, 1);
            v0.spanCount = v2.getInt(styleable.RecyclerView_spanCount, 1);
            v0.reverseLayout = v2.getBoolean(styleable.RecyclerView_reverseLayout, false);
            v0.stackFromEnd = v2.getBoolean(styleable.RecyclerView_stackFromEnd, false);
            v2.recycle();
            return v0;
        }

        public int getRightDecorationWidth(View arg1) {
            return arg1.getLayoutParams().mDecorInsets.right;
        }

        public int getRowCountForAccessibility(Recycler arg1, State arg2) {
            RecyclerView v1 = this.mRecyclerView;
            if(v1 != null) {
                if(v1.mAdapter == null) {
                }
                else if(this.canScrollVertically()) {
                    return this.mRecyclerView.mAdapter.getItemCount();
                }
            }

            return 1;
        }

        public int getSelectionModeForAccessibility(Recycler arg1, State arg2) {
            return 0;
        }

        public int getTopDecorationHeight(View arg1) {
            return arg1.getLayoutParams().mDecorInsets.top;
        }

        public void getTransformedBoundingBox(View arg5, boolean arg6, Rect arg7) {
            if(arg6) {
                Rect v6 = arg5.getLayoutParams().mDecorInsets;
                arg7.set(-v6.left, -v6.top, arg5.getWidth() + v6.right, arg5.getHeight() + v6.bottom);
            }
            else {
                arg7.set(0, 0, arg5.getWidth(), arg5.getHeight());
            }

            if(this.mRecyclerView != null) {
                Matrix v6_1 = arg5.getMatrix();
                if(v6_1 != null && !v6_1.isIdentity()) {
                    RectF v4 = this.mRecyclerView.mTempRectF;
                    v4.set(arg7);
                    v6_1.mapRect(v4);
                    arg7.set(((int)Math.floor(((double)v4.left))), ((int)Math.floor(((double)v4.top))), ((int)Math.ceil(((double)v4.right))), ((int)Math.ceil(((double)v4.bottom))));
                }
            }

            arg7.offset(arg5.getLeft(), arg5.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        boolean hasFlexibleChildInBothOrientations() {
            int v0 = this.getChildCount();
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                ViewGroup$LayoutParams v3 = this.getChildAt(v2).getLayoutParams();
                if(v3.width < 0 && v3.height < 0) {
                    return 1;
                }
            }

            return 0;
        }

        public boolean hasFocus() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null && (v0.hasFocus())) {
                return 1;
            }

            return 0;
        }

        public void ignoreView(View arg3) {
            ViewParent v0 = arg3.getParent();
            RecyclerView v1 = this.mRecyclerView;
            if(v0 == (((ViewParent)v1)) && v1.indexOfChild(arg3) != -1) {
                ViewHolder v3 = RecyclerView.getChildViewHolderInt(arg3);
                v3.addFlags(0x80);
                this.mRecyclerView.mViewInfoStore.removeViewHolder(v3);
                return;
            }

            throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null && (v0.isFocused())) {
                return 1;
            }

            return 0;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView arg7, int arg8, int arg9) {
            View v7 = arg7.getFocusedChild();
            if(v7 == null) {
                return 0;
            }

            int v1 = this.getPaddingLeft();
            int v2 = this.getPaddingTop();
            int v3 = this.getWidth() - this.getPaddingRight();
            int v4 = this.getHeight() - this.getPaddingBottom();
            Rect v5 = this.mRecyclerView.mTempRect;
            this.getDecoratedBoundsWithMargins(v7, v5);
            if(v5.left - arg8 < v3 && v5.right - arg8 > v1 && v5.top - arg9 < v4) {
                if(v5.bottom - arg9 <= v2) {
                }
                else {
                    return 1;
                }
            }

            return 0;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(Recycler arg1, State arg2) {
            return 0;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        private static boolean isMeasurementUpToDate(int arg3, int arg4, int arg5) {
            int v0 = View$MeasureSpec.getMode(arg4);
            arg4 = View$MeasureSpec.getSize(arg4);
            if(arg5 > 0 && arg3 != arg5) {
                return 0;
            }

            if(v0 != 0x80000000) {
                if(v0 != 0) {
                    if(v0 != 0x40000000) {
                        return 0;
                    }

                    if(arg4 == arg3) {
                        return 1;
                    }

                    return 0;
                }

                return 1;
            }

            if(arg4 >= arg3) {
                return 1;
            }

            return 0;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller v0 = this.mSmoothScroller;
            if(v0 != null && (v0.isRunning())) {
                return 1;
            }

            return 0;
        }

        public boolean isViewPartiallyVisible(View arg3, boolean arg4, boolean arg5) {
            int v0 = 0x6003;
            boolean v2 = !this.mHorizontalBoundCheck.isViewWithinBoundFlags(arg3, v0) || !this.mVerticalBoundCheck.isViewWithinBoundFlags(arg3, v0) ? false : true;
            if(arg4) {
                return v2;
            }

            return (((int)v2)) ^ 1;
        }

        public void layoutDecorated(View arg2, int arg3, int arg4, int arg5, int arg6) {
            Rect v1 = arg2.getLayoutParams().mDecorInsets;
            arg2.layout(arg3 + v1.left, arg4 + v1.top, arg5 - v1.right, arg6 - v1.bottom);
        }

        public void layoutDecoratedWithMargins(View arg3, int arg4, int arg5, int arg6, int arg7) {
            ViewGroup$LayoutParams v2 = arg3.getLayoutParams();
            arg3.layout(arg4 + ((LayoutParams)v2).mDecorInsets.left + ((LayoutParams)v2).leftMargin, arg5 + ((LayoutParams)v2).mDecorInsets.top + ((LayoutParams)v2).topMargin, arg6 - ((LayoutParams)v2).mDecorInsets.right - ((LayoutParams)v2).rightMargin, arg7 - ((LayoutParams)v2).mDecorInsets.bottom - ((LayoutParams)v2).bottomMargin);
        }

        public void measureChild(View arg6, int arg7, int arg8) {
            ViewGroup$LayoutParams v0 = arg6.getLayoutParams();
            Rect v1 = this.mRecyclerView.getItemDecorInsetsForChild(arg6);
            arg7 += v1.left + v1.right;
            arg8 += v1.top + v1.bottom;
            arg7 = LayoutManager.getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight() + arg7, ((LayoutParams)v0).width, this.canScrollHorizontally());
            arg8 = LayoutManager.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingTop() + this.getPaddingBottom() + arg8, ((LayoutParams)v0).height, this.canScrollVertically());
            if(this.shouldMeasureChild(arg6, arg7, arg8, ((LayoutParams)v0))) {
                arg6.measure(arg7, arg8);
            }
        }

        public void measureChildWithMargins(View arg6, int arg7, int arg8) {
            ViewGroup$LayoutParams v0 = arg6.getLayoutParams();
            Rect v1 = this.mRecyclerView.getItemDecorInsetsForChild(arg6);
            arg7 += v1.left + v1.right;
            arg8 += v1.top + v1.bottom;
            arg7 = LayoutManager.getChildMeasureSpec(this.getWidth(), this.getWidthMode(), this.getPaddingLeft() + this.getPaddingRight() + ((LayoutParams)v0).leftMargin + ((LayoutParams)v0).rightMargin + arg7, ((LayoutParams)v0).width, this.canScrollHorizontally());
            arg8 = LayoutManager.getChildMeasureSpec(this.getHeight(), this.getHeightMode(), this.getPaddingTop() + this.getPaddingBottom() + ((LayoutParams)v0).topMargin + ((LayoutParams)v0).bottomMargin + arg8, ((LayoutParams)v0).height, this.canScrollVertically());
            if(this.shouldMeasureChild(arg6, arg7, arg8, ((LayoutParams)v0))) {
                arg6.measure(arg7, arg8);
            }
        }

        public void moveView(int arg3, int arg4) {
            View v0 = this.getChildAt(arg3);
            if(v0 != null) {
                this.detachViewAt(arg3);
                this.attachView(v0, arg4);
                return;
            }

            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + arg3 + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(int arg1) {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                v0.offsetChildrenHorizontal(arg1);
            }
        }

        public void offsetChildrenVertical(int arg1) {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                v0.offsetChildrenVertical(arg1);
            }
        }

        public void onAdapterChanged(Adapter arg1, Adapter arg2) {
        }

        public boolean onAddFocusables(RecyclerView arg1, ArrayList arg2, int arg3, int arg4) {
            return 0;
        }

        public void onAttachedToWindow(RecyclerView arg1) {
        }

        public void onDetachedFromWindow(RecyclerView arg1, Recycler arg2) {
            this.onDetachedFromWindow(arg1);
        }

        @Deprecated public void onDetachedFromWindow(RecyclerView arg1) {
        }

        public View onFocusSearchFailed(View arg1, int arg2, Recycler arg3, State arg4) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent arg3) {
            this.onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, arg3);
        }

        public void onInitializeAccessibilityEvent(Recycler arg2, State arg3, AccessibilityEvent arg4) {
            RecyclerView v2 = this.mRecyclerView;
            if(v2 != null) {
                if(arg4 == null) {
                }
                else {
                    boolean v3 = true;
                    if(!v2.canScrollVertically(1)) {
                        int v0 = -1;
                        if(!this.mRecyclerView.canScrollVertically(v0) && !this.mRecyclerView.canScrollHorizontally(v0)) {
                            if(this.mRecyclerView.canScrollHorizontally(1)) {
                            }
                            else {
                                v3 = false;
                            }
                        }
                    }

                    arg4.setScrollable(v3);
                    if(this.mRecyclerView.mAdapter == null) {
                        return;
                    }

                    arg4.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
                }
            }
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat arg3) {
            this.onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, arg3);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler arg4, State arg5, AccessibilityNodeInfoCompat arg6) {
            int v1 = -1;
            if((this.mRecyclerView.canScrollVertically(v1)) || (this.mRecyclerView.canScrollHorizontally(v1))) {
                arg6.addAction(0x2000);
                arg6.setScrollable(true);
            }

            if((this.mRecyclerView.canScrollVertically(1)) || (this.mRecyclerView.canScrollHorizontally(1))) {
                arg6.addAction(0x1000);
                arg6.setScrollable(true);
            }

            arg6.setCollectionInfo(CollectionInfoCompat.obtain(this.getRowCountForAccessibility(arg4, arg5), this.getColumnCountForAccessibility(arg4, arg5), this.isLayoutHierarchical(arg4, arg5), this.getSelectionModeForAccessibility(arg4, arg5)));
        }

        void onInitializeAccessibilityNodeInfoForItem(View arg3, AccessibilityNodeInfoCompat arg4) {
            ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg3);
            if(v0 != null && !v0.isRemoved() && !this.mChildHelper.isHidden(v0.itemView)) {
                this.onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, arg3, arg4);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler arg7, State arg8, View arg9, AccessibilityNodeInfoCompat arg10) {
            int v8 = 0;
            int v0 = this.canScrollVertically() ? this.getPosition(arg9) : 0;
            if(this.canScrollHorizontally()) {
                v8 = this.getPosition(arg9);
            }

            arg10.setCollectionItemInfo(CollectionItemInfoCompat.obtain(v0, 1, v8, 1, false, false));
        }

        public View onInterceptFocusSearch(View arg1, int arg2) {
            return null;
        }

        public void onItemsAdded(RecyclerView arg1, int arg2, int arg3) {
        }

        public void onItemsChanged(RecyclerView arg1) {
        }

        public void onItemsMoved(RecyclerView arg1, int arg2, int arg3, int arg4) {
        }

        public void onItemsRemoved(RecyclerView arg1, int arg2, int arg3) {
        }

        public void onItemsUpdated(RecyclerView arg1, int arg2, int arg3, Object arg4) {
            this.onItemsUpdated(arg1, arg2, arg3);
        }

        public void onItemsUpdated(RecyclerView arg1, int arg2, int arg3) {
        }

        public void onLayoutChildren(Recycler arg1, State arg2) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(State arg1) {
        }

        public void onMeasure(Recycler arg1, State arg2, int arg3, int arg4) {
            this.mRecyclerView.defaultOnMeasure(arg3, arg4);
        }

        public boolean onRequestChildFocus(RecyclerView arg1, State arg2, View arg3, View arg4) {
            return this.onRequestChildFocus(arg1, arg3, arg4);
        }

        @Deprecated public boolean onRequestChildFocus(RecyclerView arg1, View arg2, View arg3) {
            if(!this.isSmoothScrolling()) {
                if(arg1.isComputingLayout()) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public void onRestoreInstanceState(Parcelable arg1) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int arg1) {
        }

        void onSmoothScrollerStopped(SmoothScroller arg2) {
            if(this.mSmoothScroller == arg2) {
                this.mSmoothScroller = null;
            }
        }

        boolean performAccessibilityAction(int arg3, Bundle arg4) {
            return this.performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, arg3, arg4);
        }

        public boolean performAccessibilityAction(Recycler arg8, State arg9, int arg10, Bundle arg11) {
            int v8_1;
            int v3;
            int v2;
            RecyclerView v8 = this.mRecyclerView;
            if(v8 == null) {
                return 0;
            }

            if(arg10 == 0x1000) {
                v8_1 = v8.canScrollVertically(1) ? this.getHeight() - this.getPaddingTop() - this.getPaddingBottom() : 0;
                if(this.mRecyclerView.canScrollHorizontally(1)) {
                    arg10 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
                label_50:
                    v3 = v8_1;
                    v2 = arg10;
                    goto label_55;
                }

            label_53:
                v3 = v8_1;
                v2 = 0;
            }
            else if(arg10 != 0x2000) {
                v2 = 0;
                v3 = 0;
            }
            else {
                arg10 = -1;
                v8_1 = v8.canScrollVertically(arg10) ? -(this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()) : 0;
                if(!this.mRecyclerView.canScrollHorizontally(arg10)) {
                    goto label_53;
                }

                arg10 = -(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
                goto label_50;
            }

        label_55:
            if(v3 == 0 && v2 == 0) {
                return 0;
            }

            this.mRecyclerView.smoothScrollBy(v2, v3, null, 0x80000000, true);
            return 1;
        }

        boolean performAccessibilityActionForItem(View arg8, int arg9, Bundle arg10) {
            return this.performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, arg8, arg9, arg10);
        }

        public boolean performAccessibilityActionForItem(Recycler arg1, State arg2, View arg3, int arg4, Bundle arg5) {
            return 0;
        }

        public void postOnAnimation(Runnable arg1) {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                ViewCompat.postOnAnimation(((View)v0), arg1);
            }
        }

        public void removeAllViews() {
            int v0;
            for(v0 = this.getChildCount() - 1; v0 >= 0; --v0) {
                this.mChildHelper.removeViewAt(v0);
            }
        }

        public void removeAndRecycleAllViews(Recycler arg3) {
            int v0;
            for(v0 = this.getChildCount() - 1; v0 >= 0; --v0) {
                if(!RecyclerView.getChildViewHolderInt(this.getChildAt(v0)).shouldIgnore()) {
                    this.removeAndRecycleViewAt(v0, arg3);
                }
            }
        }

        void removeAndRecycleScrapInt(Recycler arg7) {
            int v0 = arg7.getScrapCount();
            int v1;
            for(v1 = v0 - 1; v1 >= 0; --v1) {
                View v2 = arg7.getScrapViewAt(v1);
                ViewHolder v3 = RecyclerView.getChildViewHolderInt(v2);
                if(v3.shouldIgnore()) {
                }
                else {
                    v3.setIsRecyclable(false);
                    if(v3.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(v2, false);
                    }

                    if(this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.endAnimation(v3);
                    }

                    v3.setIsRecyclable(true);
                    arg7.quickRecycleScrapView(v2);
                }
            }

            arg7.clearScrap();
            if(v0 > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View arg1, Recycler arg2) {
            this.removeView(arg1);
            arg2.recycleView(arg1);
        }

        public void removeAndRecycleViewAt(int arg2, Recycler arg3) {
            View v0 = this.getChildAt(arg2);
            this.removeViewAt(arg2);
            arg3.recycleView(v0);
        }

        public boolean removeCallbacks(Runnable arg1) {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                return v0.removeCallbacks(arg1);
            }

            return 0;
        }

        public void removeDetachedView(View arg2) {
            this.mRecyclerView.removeDetachedView(arg2, false);
        }

        public void removeView(View arg1) {
            this.mChildHelper.removeView(arg1);
        }

        public void removeViewAt(int arg2) {
            if(this.getChildAt(arg2) != null) {
                this.mChildHelper.removeViewAt(arg2);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView arg3, View arg4, Rect arg5, boolean arg6, boolean arg7) {
            int[] v4 = this.getChildRectangleOnScreenScrollAmount(arg4, arg5);
            int v0 = v4[0];
            int v4_1 = v4[1];
            if((arg7) && !this.isFocusedChildVisibleAfterScrolling(arg3, v0, v4_1)) {
                return 0;
            }
            else if(v0 == 0) {
                if(v4_1 != 0) {
                }
                else {
                    return 0;
                }
            }

            if(arg6) {
                arg3.scrollBy(v0, v4_1);
            }
            else {
                arg3.smoothScrollBy(v0, v4_1);
            }

            return 1;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView arg7, View arg8, Rect arg9, boolean arg10) {
            return this.requestChildRectangleOnScreen(arg7, arg8, arg9, arg10, false);
        }

        public void requestLayout() {
            RecyclerView v0 = this.mRecyclerView;
            if(v0 != null) {
                v0.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        private void scrapOrRecycleView(Recycler arg3, int arg4, View arg5) {
            ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg5);
            if(v0.shouldIgnore()) {
                return;
            }

            if((v0.isInvalid()) && !v0.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                this.removeViewAt(arg4);
                arg3.recycleViewHolderInternal(v0);
                return;
            }

            this.detachViewAt(arg4);
            arg3.scrapView(arg5);
            this.mRecyclerView.mViewInfoStore.onViewDetached(v0);
        }

        public int scrollHorizontallyBy(int arg1, Recycler arg2, State arg3) {
            return 0;
        }

        public void scrollToPosition(int arg1) {
        }

        public int scrollVerticallyBy(int arg1, Recycler arg2, State arg3) {
            return 0;
        }

        @Deprecated public void setAutoMeasureEnabled(boolean arg1) {
            this.mAutoMeasure = arg1;
        }

        void setExactMeasureSpecsFrom(RecyclerView arg3) {
            this.setMeasureSpecs(View$MeasureSpec.makeMeasureSpec(arg3.getWidth(), 0x40000000), View$MeasureSpec.makeMeasureSpec(arg3.getHeight(), 0x40000000));
        }

        public final void setItemPrefetchEnabled(boolean arg2) {
            if(arg2 != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = arg2;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView v1 = this.mRecyclerView;
                if(v1 != null) {
                    v1.mRecycler.updateViewCacheSize();
                }
            }
        }

        void setMeasureSpecs(int arg2, int arg3) {
            this.mWidth = View$MeasureSpec.getSize(arg2);
            arg2 = View$MeasureSpec.getMode(arg2);
            this.mWidthMode = arg2;
            if(arg2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }

            this.mHeight = View$MeasureSpec.getSize(arg3);
            arg2 = View$MeasureSpec.getMode(arg3);
            this.mHeightMode = arg2;
            if(arg2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(int arg1, int arg2) {
            this.mRecyclerView.setMeasuredDimension(arg1, arg2);
        }

        public void setMeasuredDimension(Rect arg3, int arg4, int arg5) {
            this.setMeasuredDimension(LayoutManager.chooseSize(arg4, arg3.width() + this.getPaddingLeft() + this.getPaddingRight(), this.getMinimumWidth()), LayoutManager.chooseSize(arg5, arg3.height() + this.getPaddingTop() + this.getPaddingBottom(), this.getMinimumHeight()));
        }

        void setMeasuredDimensionFromChildren(int arg9, int arg10) {
            int v0 = this.getChildCount();
            if(v0 == 0) {
                this.mRecyclerView.defaultOnMeasure(arg9, arg10);
                return;
            }

            int v1 = 0x80000000;
            int v4 = 0x7FFFFFFF;
            int v5 = 0;
            int v2 = v1;
            int v3 = v4;
            while(v5 < v0) {
                View v6 = this.getChildAt(v5);
                Rect v7 = this.mRecyclerView.mTempRect;
                this.getDecoratedBoundsWithMargins(v6, v7);
                if(v7.left < v3) {
                    v3 = v7.left;
                }

                if(v7.right > v1) {
                    v1 = v7.right;
                }

                if(v7.top < v4) {
                    v4 = v7.top;
                }

                if(v7.bottom > v2) {
                    v2 = v7.bottom;
                }

                ++v5;
            }

            this.mRecyclerView.mTempRect.set(v3, v4, v1, v2);
            this.setMeasuredDimension(this.mRecyclerView.mTempRect, arg9, arg10);
        }

        public void setMeasurementCacheEnabled(boolean arg1) {
            this.mMeasurementCacheEnabled = arg1;
        }

        void setRecyclerView(RecyclerView arg2) {
            if(arg2 == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            }
            else {
                this.mRecyclerView = arg2;
                this.mChildHelper = arg2.mChildHelper;
                this.mWidth = arg2.getWidth();
                this.mHeight = arg2.getHeight();
            }

            this.mWidthMode = 0x40000000;
            this.mHeightMode = 0x40000000;
        }

        boolean shouldMeasureChild(View arg2, int arg3, int arg4, LayoutParams arg5) {
            if(!arg2.isLayoutRequested() && (this.mMeasurementCacheEnabled) && (LayoutManager.isMeasurementUpToDate(arg2.getWidth(), arg3, arg5.width))) {
                if(!LayoutManager.isMeasurementUpToDate(arg2.getHeight(), arg4, arg5.height)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        boolean shouldMeasureTwice() {
            return 0;
        }

        boolean shouldReMeasureChild(View arg2, int arg3, int arg4, LayoutParams arg5) {
            if((this.mMeasurementCacheEnabled) && (LayoutManager.isMeasurementUpToDate(arg2.getMeasuredWidth(), arg3, arg5.width))) {
                if(!LayoutManager.isMeasurementUpToDate(arg2.getMeasuredHeight(), arg4, arg5.height)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public void smoothScrollToPosition(RecyclerView arg1, State arg2, int arg3) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller arg2) {
            SmoothScroller v0 = this.mSmoothScroller;
            if(v0 != null && arg2 != v0 && (v0.isRunning())) {
                this.mSmoothScroller.stop();
            }

            this.mSmoothScroller = arg2;
            arg2.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View arg1) {
            ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg1);
            v0.stopIgnoring();
            v0.resetInternal();
            v0.addFlags(4);
        }

        void stopSmoothScroller() {
            SmoothScroller v0 = this.mSmoothScroller;
            if(v0 != null) {
                v0.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return 0;
        }
    }

    public class LayoutParams extends ViewGroup$MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg1) {
            super(arg1);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams arg1) {
            super(((ViewGroup$LayoutParams)arg1));
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getViewAdapterPosition() {
            return this.mViewHolder.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View arg1);

        void onChildViewDetachedFromWindow(View arg1);
    }

    public abstract class OnFlingListener {
        public OnFlingListener() {
            super();
        }

        public abstract boolean onFling(int arg1, int arg2);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView arg1, MotionEvent arg2);

        void onRequestDisallowInterceptTouchEvent(boolean arg1);

        void onTouchEvent(RecyclerView arg1, MotionEvent arg2);
    }

    public abstract class OnScrollListener {
        public OnScrollListener() {
            super();
        }

        public void onScrollStateChanged(RecyclerView arg1, int arg2) {
        }

        public void onScrolled(RecyclerView arg1, int arg2, int arg3) {
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Orientation {
    }

    public class RecycledViewPool {
        class ScrapData {
            long mBindRunningAverageNs;
            long mCreateRunningAverageNs;
            int mMaxScrap;
            final ArrayList mScrapHeap;

            ScrapData() {
                super();
                this.mScrapHeap = new ArrayList();
                this.mMaxScrap = 5;
                this.mCreateRunningAverageNs = 0;
                this.mBindRunningAverageNs = 0;
            }
        }

        private static final int DEFAULT_MAX_SCRAP = 5;
        private int mAttachCount;
        SparseArray mScrap;

        public RecycledViewPool() {
            super();
            this.mScrap = new SparseArray();
            this.mAttachCount = 0;
        }

        void attach() {
            ++this.mAttachCount;
        }

        public void clear() {
            int v0;
            for(v0 = 0; v0 < this.mScrap.size(); ++v0) {
                this.mScrap.valueAt(v0).mScrapHeap.clear();
            }
        }

        void detach() {
            --this.mAttachCount;
        }

        void factorInBindTime(int arg3, long arg4) {
            ScrapData v3 = this.getScrapDataForType(arg3);
            v3.mBindRunningAverageNs = this.runningAverage(v3.mBindRunningAverageNs, arg4);
        }

        void factorInCreateTime(int arg3, long arg4) {
            ScrapData v3 = this.getScrapDataForType(arg3);
            v3.mCreateRunningAverageNs = this.runningAverage(v3.mCreateRunningAverageNs, arg4);
        }

        public ViewHolder getRecycledView(int arg2) {
            Object v1 = this.mScrap.get(arg2);
            if(v1 != null && !((ScrapData)v1).mScrapHeap.isEmpty()) {
                ArrayList v1_1 = ((ScrapData)v1).mScrapHeap;
                arg2 = v1_1.size() - 1;
                while(arg2 >= 0) {
                    if(!v1_1.get(arg2).isAttachedToTransitionOverlay()) {
                        return v1_1.remove(arg2);
                    }
                    else {
                        --arg2;
                        continue;
                    }

                    return null;
                }
            }

            return null;
        }

        public int getRecycledViewCount(int arg1) {
            return this.getScrapDataForType(arg1).mScrapHeap.size();
        }

        private ScrapData getScrapDataForType(int arg2) {
            ScrapData v0_1;
            Object v0 = this.mScrap.get(arg2);
            if(v0 == null) {
                v0_1 = new ScrapData();
                this.mScrap.put(arg2, v0_1);
            }

            return v0_1;
        }

        void onAdapterChanged(Adapter arg1, Adapter arg2, boolean arg3) {
            if(arg1 != null) {
                this.detach();
            }

            if(!arg3 && this.mAttachCount == 0) {
                this.clear();
            }

            if(arg2 != null) {
                this.attach();
            }
        }

        public void putRecycledView(ViewHolder arg3) {
            int v0 = arg3.getItemViewType();
            ArrayList v1 = this.getScrapDataForType(v0).mScrapHeap;
            if(this.mScrap.get(v0).mMaxScrap <= v1.size()) {
                return;
            }

            arg3.resetInternal();
            v1.add(arg3);
        }

        long runningAverage(long arg5, long arg7) {
            if(arg5 == 0) {
                return arg7;
            }

            return arg5 / 4 * 3 + arg7 / 4;
        }

        public void setMaxRecycledViews(int arg1, int arg2) {
            ScrapData v0 = this.getScrapDataForType(arg1);
            v0.mMaxScrap = arg2;
            ArrayList v0_1 = v0.mScrapHeap;
            while(v0_1.size() > arg2) {
                v0_1.remove(v0_1.size() - 1);
            }
        }

        int size() {
            int v0 = 0;
            int v1 = 0;
            while(v0 < this.mScrap.size()) {
                ArrayList v2 = this.mScrap.valueAt(v0).mScrapHeap;
                if(v2 != null) {
                    v1 += v2.size();
                }

                ++v0;
            }

            return v1;
        }

        boolean willBindInTime(int arg3, long arg4, long arg6) {
            long v2 = this.getScrapDataForType(arg3).mBindRunningAverageNs;
            if(v2 != 0) {
                if(arg4 + v2 < arg6) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        boolean willCreateInTime(int arg3, long arg4, long arg6) {
            long v2 = this.getScrapDataForType(arg3).mCreateRunningAverageNs;
            if(v2 != 0) {
                if(arg4 + v2 < arg6) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }
    }

    public final class Recycler {
        static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList mAttachedScrap;
        final ArrayList mCachedViews;
        ArrayList mChangedScrap;
        RecycledViewPool mRecyclerPool;
        private int mRequestedCacheMax;
        private final List mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        int mViewCacheMax;

        public Recycler(RecyclerView arg2) {
            RecyclerView.this = arg2;
            super();
            ArrayList v2 = new ArrayList();
            this.mAttachedScrap = v2;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(((List)v2));
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        void addViewHolderToRecycledViewPool(ViewHolder arg5, boolean arg6) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(arg5);
            View v0 = arg5.itemView;
            RecyclerView v2 = null;
            if(RecyclerView.this.mAccessibilityDelegate != null) {
                AccessibilityDelegateCompat v1 = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                v1 = (v1 instanceof ItemDelegate) ? ((ItemDelegate)v1).getAndRemoveOriginalDelegateForItem(v0) : ((AccessibilityDelegateCompat)v2);
                ViewCompat.setAccessibilityDelegate(v0, v1);
            }

            if(arg6) {
                this.dispatchViewRecycled(arg5);
            }

            arg5.mOwnerRecyclerView = v2;
            this.getRecycledViewPool().putRecycledView(arg5);
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder arg2) {
            if(RecyclerView.this.isAccessibilityEnabled()) {
                View v2 = arg2.itemView;
                if(ViewCompat.getImportantForAccessibility(v2) == 0) {
                    ViewCompat.setImportantForAccessibility(v2, 1);
                }

                if(RecyclerView.this.mAccessibilityDelegate == null) {
                    return;
                }

                AccessibilityDelegateCompat v1 = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                if((v1 instanceof ItemDelegate)) {
                    v1.saveOriginalDelegate(v2);
                }

                ViewCompat.setAccessibilityDelegate(v2, v1);
            }
        }

        public void bindViewToPosition(View arg7, int arg8) {
            ViewHolder v1 = RecyclerView.getChildViewHolderInt(arg7);
            RecyclerView v7 = RecyclerView.this;
            if(v1 != null) {
                int v2 = v7.mAdapterHelper.findPositionOffset(arg8);
                if(v2 >= 0 && v2 < RecyclerView.this.mAdapter.getItemCount()) {
                    Recycler v0 = this;
                    v0.tryBindViewHolderByDeadline(v1, v2, arg8, 0x7FFFFFFFFFFFFFFFL);
                    ViewGroup$LayoutParams v6 = v1.itemView.getLayoutParams();
                    v7 = v0.this$0;
                    if(v6 == null) {
                        v6 = v7.generateDefaultLayoutParams();
                        v1.itemView.setLayoutParams(v6);
                    }
                    else if(!v7.checkLayoutParams(v6)) {
                        v6 = v0.this$0.generateLayoutParams(v6);
                        v1.itemView.setLayoutParams(v6);
                    }

                    boolean v7_1 = true;
                    ((LayoutParams)v6).mInsetsDirty = true;
                    ((LayoutParams)v6).mViewHolder = v1;
                    if(v1.itemView.getParent() == null) {
                    }
                    else {
                        v7_1 = false;
                    }

                    ((LayoutParams)v6).mPendingInvalidate = v7_1;
                    return;
                }

                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + arg8 + "(offset:" + v2 + ").state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
            }

            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + v7.exceptionLabel());
        }

        public void clear() {
            this.mAttachedScrap.clear();
            this.recycleAndClearCachedViews();
        }

        void clearOldPositions() {
            int v0 = this.mCachedViews.size();
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                this.mCachedViews.get(v2).clearOldPosition();
            }

            v0 = this.mAttachedScrap.size();
            for(v2 = 0; v2 < v0; ++v2) {
                this.mAttachedScrap.get(v2).clearOldPosition();
            }

            ArrayList v0_1 = this.mChangedScrap;
            if(v0_1 != null) {
                v0 = v0_1.size();
                while(v1 < v0) {
                    this.mChangedScrap.get(v1).clearOldPosition();
                    ++v1;
                }
            }
        }

        void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList v1 = this.mChangedScrap;
            if(v1 != null) {
                v1.clear();
            }
        }

        public int convertPreLayoutPositionToPostLayout(int arg4) {
            if(arg4 >= 0 && arg4 < RecyclerView.this.mState.getItemCount()) {
                if(!RecyclerView.this.mState.isPreLayout()) {
                    return arg4;
                }
                else {
                    return RecyclerView.this.mAdapterHelper.findPositionOffset(arg4);
                }
            }

            throw new IndexOutOfBoundsException("invalid position " + arg4 + ". State item count is " + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
        }

        void dispatchViewRecycled(ViewHolder arg2) {
            if(RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.onViewRecycled(arg2);
            }

            if(RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(arg2);
            }

            if(RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.removeViewHolder(arg2);
            }
        }

        ViewHolder getChangedScrapViewForPosition(int arg10) {
            int v4;
            ArrayList v0 = this.mChangedScrap;
            ViewHolder v1 = null;
            if(v0 != null) {
                int v0_1 = v0.size();
                if(v0_1 == 0) {
                }
                else {
                    int v2 = 0;
                    int v3;
                    for(v3 = 0; true; ++v3) {
                        v4 = 0x20;
                        if(v3 >= v0_1) {
                            break;
                        }

                        Object v5 = this.mChangedScrap.get(v3);
                        if(!((ViewHolder)v5).wasReturnedFromScrap() && ((ViewHolder)v5).getLayoutPosition() == arg10) {
                            ((ViewHolder)v5).addFlags(v4);
                            return ((ViewHolder)v5);
                        }
                    }

                    if(!RecyclerView.this.mAdapter.hasStableIds()) {
                        return v1;
                    }

                    arg10 = RecyclerView.this.mAdapterHelper.findPositionOffset(arg10);
                    if(arg10 <= 0) {
                        return v1;
                    }

                    if(arg10 >= RecyclerView.this.mAdapter.getItemCount()) {
                        return v1;
                    }

                    long v5_1 = RecyclerView.this.mAdapter.getItemId(arg10);
                    while(v2 < v0_1) {
                        Object v10 = this.mChangedScrap.get(v2);
                        if(!((ViewHolder)v10).wasReturnedFromScrap() && ((ViewHolder)v10).getItemId() == v5_1) {
                            ((ViewHolder)v10).addFlags(v4);
                            return ((ViewHolder)v10);
                        }

                        ++v2;
                    }
                }
            }

            return v1;
        }

        RecycledViewPool getRecycledViewPool() {
            RecycledViewPool v0 = this.mRecyclerPool;
            if(v0 == null) {
                v0 = new RecycledViewPool();
                this.mRecyclerPool = v0;
            }

            return v0;
        }

        int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        public List getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        ViewHolder getScrapOrCachedViewForId(long arg6, int arg8, boolean arg9) {
            ViewHolder v1_1;
            int v0;
            for(v0 = this.mAttachedScrap.size() - 1; v0 >= 0; --v0) {
                Object v1 = this.mAttachedScrap.get(v0);
                if(((ViewHolder)v1).getItemId() == arg6 && !((ViewHolder)v1).wasReturnedFromScrap()) {
                    if(arg8 == ((ViewHolder)v1).getItemViewType()) {
                        ((ViewHolder)v1).addFlags(0x20);
                        if((((ViewHolder)v1).isRemoved()) && !RecyclerView.this.mState.isPreLayout()) {
                            ((ViewHolder)v1).setFlags(2, 14);
                        }

                        return ((ViewHolder)v1);
                    }
                    else {
                        if(arg9) {
                            goto label_33;
                        }

                        this.mAttachedScrap.remove(v0);
                        RecyclerView.this.removeDetachedView(((ViewHolder)v1).itemView, false);
                        this.quickRecycleScrapView(((ViewHolder)v1).itemView);
                    }
                }

            label_33:
            }

            for(v0 = this.mCachedViews.size() - 1; true; --v0) {
                v1_1 = null;
                if(v0 < 0) {
                    return v1_1;
                }

                Object v2 = this.mCachedViews.get(v0);
                if(((ViewHolder)v2).getItemId() == arg6 && !((ViewHolder)v2).isAttachedToTransitionOverlay()) {
                    if(arg8 == ((ViewHolder)v2).getItemViewType()) {
                        if(!arg9) {
                            this.mCachedViews.remove(v0);
                        }

                        return ((ViewHolder)v2);
                    }
                    else {
                        if(arg9) {
                            goto label_55;
                        }

                        this.recycleCachedViewAt(v0);
                        return v1_1;
                    }
                }

            label_55:
            }

            return v1_1;
        }

        ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int arg6, boolean arg7) {
            int v0 = this.mAttachedScrap.size();
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                Object v3 = this.mAttachedScrap.get(v2);
                if(!((ViewHolder)v3).wasReturnedFromScrap() && ((ViewHolder)v3).getLayoutPosition() == arg6 && !((ViewHolder)v3).isInvalid() && ((RecyclerView.this.mState.mInPreLayout) || !((ViewHolder)v3).isRemoved())) {
                    ((ViewHolder)v3).addFlags(0x20);
                    return ((ViewHolder)v3);
                }
            }

            if(!arg7) {
                View v0_1 = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(arg6);
                if(v0_1 != null) {
                    ViewHolder v6 = RecyclerView.getChildViewHolderInt(v0_1);
                    RecyclerView.this.mChildHelper.unhide(v0_1);
                    int v7 = RecyclerView.this.mChildHelper.indexOfChild(v0_1);
                    if(v7 != -1) {
                        RecyclerView.this.mChildHelper.detachViewFromParent(v7);
                        this.scrapView(v0_1);
                        v6.addFlags(0x2020);
                        return v6;
                    }
                    else {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + v6 + RecyclerView.this.exceptionLabel());
                    }
                }
            }

            v0 = this.mCachedViews.size();
            while(v1 < v0) {
                Object v2_1 = this.mCachedViews.get(v1);
                if(!((ViewHolder)v2_1).isInvalid() && ((ViewHolder)v2_1).getLayoutPosition() == arg6 && !((ViewHolder)v2_1).isAttachedToTransitionOverlay()) {
                    if(!arg7) {
                        this.mCachedViews.remove(v1);
                    }

                    return ((ViewHolder)v2_1);
                }

                ++v1;
            }

            return null;
        }

        View getScrapViewAt(int arg1) {
            return this.mAttachedScrap.get(arg1).itemView;
        }

        public View getViewForPosition(int arg2) {
            return this.getViewForPosition(arg2, false);
        }

        View getViewForPosition(int arg3, boolean arg4) {
            return this.tryGetViewHolderForPositionByDeadline(arg3, arg4, 0x7FFFFFFFFFFFFFFFL).itemView;
        }

        private void invalidateDisplayListInt(ViewGroup arg5, boolean arg6) {
            int v0;
            for(v0 = arg5.getChildCount() - 1; v0 >= 0; --v0) {
                View v2 = arg5.getChildAt(v0);
                if((v2 instanceof ViewGroup)) {
                    this.invalidateDisplayListInt(((ViewGroup)v2), true);
                }
            }

            if(!arg6) {
                return;
            }

            int v6 = 4;
            if(arg5.getVisibility() == v6) {
                arg5.setVisibility(0);
                arg5.setVisibility(v6);
                return;
            }

            int v4 = arg5.getVisibility();
            arg5.setVisibility(v6);
            arg5.setVisibility(v4);
        }

        private void invalidateDisplayListInt(ViewHolder arg2) {
            if((arg2.itemView instanceof ViewGroup)) {
                this.invalidateDisplayListInt(arg2.itemView, false);
            }
        }

        void markItemDecorInsetsDirty() {
            int v0 = this.mCachedViews.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                ViewGroup$LayoutParams v2 = this.mCachedViews.get(v1).itemView.getLayoutParams();
                if(v2 != null) {
                    ((LayoutParams)v2).mInsetsDirty = true;
                }
            }
        }

        void markKnownViewsInvalid() {
            int v0 = this.mCachedViews.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                Object v2 = this.mCachedViews.get(v1);
                if(v2 != null) {
                    ((ViewHolder)v2).addFlags(6);
                    ((ViewHolder)v2).addChangePayload(null);
                }
            }

            if(RecyclerView.this.mAdapter != null) {
                if(!RecyclerView.this.mAdapter.hasStableIds()) {
                }
                else {
                    return;
                }
            }

            this.recycleAndClearCachedViews();
        }

        void offsetPositionRecordsForInsert(int arg5, int arg6) {
            int v0 = this.mCachedViews.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                Object v2 = this.mCachedViews.get(v1);
                if(v2 != null && ((ViewHolder)v2).mPosition >= arg5) {
                    ((ViewHolder)v2).offsetPosition(arg6, true);
                }
            }
        }

        void offsetPositionRecordsForMove(int arg9, int arg10) {
            int v2;
            int v1;
            int v0;
            if(arg9 < arg10) {
                v0 = -1;
                v1 = arg9;
                v2 = arg10;
            }
            else {
                v0 = 1;
                v2 = arg9;
                v1 = arg10;
            }

            int v3 = this.mCachedViews.size();
            int v5;
            for(v5 = 0; v5 < v3; ++v5) {
                Object v6 = this.mCachedViews.get(v5);
                if(v6 != null && ((ViewHolder)v6).mPosition >= v1) {
                    if(((ViewHolder)v6).mPosition > v2) {
                    }
                    else if(((ViewHolder)v6).mPosition == arg9) {
                        ((ViewHolder)v6).offsetPosition(arg10 - arg9, false);
                    }
                    else {
                        ((ViewHolder)v6).offsetPosition(v0, false);
                    }
                }
            }
        }

        void offsetPositionRecordsForRemove(int arg5, int arg6, boolean arg7) {
            int v0 = arg5 + arg6;
            int v1;
            for(v1 = this.mCachedViews.size() - 1; v1 >= 0; --v1) {
                Object v2 = this.mCachedViews.get(v1);
                if(v2 != null) {
                    if(((ViewHolder)v2).mPosition >= v0) {
                        ((ViewHolder)v2).offsetPosition(-arg6, arg7);
                    }
                    else if(((ViewHolder)v2).mPosition >= arg5) {
                        ((ViewHolder)v2).addFlags(8);
                        this.recycleCachedViewAt(v1);
                    }
                }
            }
        }

        void onAdapterChanged(Adapter arg1, Adapter arg2, boolean arg3) {
            this.clear();
            this.getRecycledViewPool().onAdapterChanged(arg1, arg2, arg3);
        }

        void quickRecycleScrapView(View arg2) {
            ViewHolder v2 = RecyclerView.getChildViewHolderInt(arg2);
            v2.mScrapContainer = null;
            v2.mInChangeScrap = false;
            v2.clearReturnedFromScrapFlag();
            this.recycleViewHolderInternal(v2);
        }

        void recycleAndClearCachedViews() {
            int v0;
            for(v0 = this.mCachedViews.size() - 1; v0 >= 0; --v0) {
                this.recycleCachedViewAt(v0);
            }

            this.mCachedViews.clear();
            if(RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
            }
        }

        void recycleCachedViewAt(int arg3) {
            this.addViewHolderToRecycledViewPool(this.mCachedViews.get(arg3), true);
            this.mCachedViews.remove(arg3);
        }

        public void recycleView(View arg4) {
            ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg4);
            if(v0.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(arg4, false);
            }

            if(v0.isScrap()) {
                v0.unScrap();
            }
            else if(v0.wasReturnedFromScrap()) {
                v0.clearReturnedFromScrapFlag();
            }

            this.recycleViewHolderInternal(v0);
            if(RecyclerView.this.mItemAnimator != null && !v0.isRecyclable()) {
                RecyclerView.this.mItemAnimator.endAnimation(v0);
            }
        }

        void recycleViewHolderInternal(ViewHolder arg7) {
            boolean v1 = false;
            int v2 = 1;
            if(!arg7.isScrap()) {
                if(arg7.itemView.getParent() != null) {
                }
                else if(arg7.isTmpDetached()) {
                    throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + arg7 + RecyclerView.this.exceptionLabel());
                }
                else if(!arg7.shouldIgnore()) {
                    boolean v0 = arg7.doesTransientStatePreventRecycling();
                    int v3 = RecyclerView.this.mAdapter == null || !v0 || !RecyclerView.this.mAdapter.onFailedToRecycleView(arg7) ? 0 : 1;
                    if(v3 != 0 || (arg7.isRecyclable())) {
                        if(this.mViewCacheMax <= 0 || (arg7.hasAnyOfTheFlags(0x20E))) {
                            v3 = 0;
                        }
                        else {
                            v3 = this.mCachedViews.size();
                            if(v3 >= this.mViewCacheMax && v3 > 0) {
                                this.recycleCachedViewAt(0);
                                --v3;
                            }

                            if((RecyclerView.ALLOW_THREAD_GAP_WORK) && v3 > 0 && !RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(arg7.mPosition)) {
                                --v3;
                                while(v3 >= 0) {
                                    if(!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(v3).mPosition)) {
                                    }
                                    else {
                                        --v3;
                                        continue;
                                    }

                                    break;
                                }

                                ++v3;
                            }

                            this.mCachedViews.add(v3, arg7);
                            v3 = 1;
                        }

                        if(v3 == 0) {
                            this.addViewHolderToRecycledViewPool(arg7, true);
                        }
                        else {
                            v2 = 0;
                        }

                        int v1_1 = v3;
                    }
                    else {
                        v2 = 0;
                    }

                    RecyclerView.this.mViewInfoStore.removeViewHolder(arg7);
                    if(!(((boolean)v1_1)) && v2 == 0 && (v0)) {
                        arg7.mOwnerRecyclerView = null;
                    }

                    return;
                }
                else {
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
                }
            }

            StringBuilder v3_1 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(arg7.isScrap()).append(" isAttached:");
            if(arg7.itemView.getParent() != null) {
                v1 = true;
            }

            throw new IllegalArgumentException(v3_1.append(v1).append(RecyclerView.this.exceptionLabel()).toString());
        }

        void scrapView(View arg3) {
            ViewHolder v3 = RecyclerView.getChildViewHolderInt(arg3);
            if(!v3.hasAnyOfTheFlags(12) && (v3.isUpdated())) {
                if(RecyclerView.this.canReuseUpdatedViewHolder(v3)) {
                }
                else {
                    if(this.mChangedScrap == null) {
                        this.mChangedScrap = new ArrayList();
                    }

                    v3.setScrapContainer(this, true);
                    this.mChangedScrap.add(v3);
                    return;
                }
            }

            if((v3.isInvalid()) && !v3.isRemoved()) {
                if(RecyclerView.this.mAdapter.hasStableIds()) {
                }
                else {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
                }
            }

            v3.setScrapContainer(this, false);
            this.mAttachedScrap.add(v3);
        }

        void setRecycledViewPool(RecycledViewPool arg2) {
            RecycledViewPool v0 = this.mRecyclerPool;
            if(v0 != null) {
                v0.detach();
            }

            this.mRecyclerPool = arg2;
            if(arg2 != null && RecyclerView.this.getAdapter() != null) {
                this.mRecyclerPool.attach();
            }
        }

        void setViewCacheExtension(ViewCacheExtension arg1) {
            this.mViewCacheExtension = arg1;
        }

        public void setViewCacheSize(int arg1) {
            this.mRequestedCacheMax = arg1;
            this.updateViewCacheSize();
        }

        private boolean tryBindViewHolderByDeadline(ViewHolder arg8, int arg9, int arg10, long arg11) {
            arg8.mOwnerRecyclerView = RecyclerView.this;
            int v2 = arg8.getItemViewType();
            long v3 = RecyclerView.this.getNanoTime();
            if(arg11 != 0x7FFFFFFFFFFFFFFFL && !this.mRecyclerPool.willBindInTime(v2, v3, arg11)) {
                return 0;
            }

            RecyclerView.this.mAdapter.bindViewHolder(arg8, arg9);
            this.mRecyclerPool.factorInBindTime(arg8.getItemViewType(), RecyclerView.this.getNanoTime() - v3);
            this.attachAccessibilityDelegateOnBind(arg8);
            if(RecyclerView.this.mState.isPreLayout()) {
                arg8.mPreLayoutPosition = arg10;
            }

            return 1;
        }

        ViewHolder tryGetViewHolderForPositionByDeadline(int arg17, boolean arg18, long arg19) {
            ViewGroup$LayoutParams v0_1;
            boolean v2_2;
            ViewHolder v1_3;
            int v8;
            int v5;
            ViewHolder v2;
            Recycler v0 = this;
            int v3 = arg17;
            boolean v1 = arg18;
            if(v3 >= 0 && v3 < v0.this$0.mState.getItemCount()) {
                ViewHolder v4 = null;
                boolean v6 = true;
                if(v0.this$0.mState.isPreLayout()) {
                    v2 = this.getChangedScrapViewForPosition(arg17);
                    if(v2 != null) {
                        v5 = 1;
                    }
                    else {
                        goto label_20;
                    }
                }
                else {
                    v2 = v4;
                label_20:
                    v5 = 0;
                }

                if(v2 == null) {
                    v2 = this.getScrapOrHiddenOrCachedHolderForPosition(arg17, arg18);
                    if(v2 != null) {
                        if(!v0.validateViewHolderForOffsetPosition(v2)) {
                            if(!v1) {
                                v2.addFlags(4);
                                if(v2.isScrap()) {
                                    v0.this$0.removeDetachedView(v2.itemView, false);
                                    v2.unScrap();
                                }
                                else if(v2.wasReturnedFromScrap()) {
                                    v2.clearReturnedFromScrapFlag();
                                }

                                v0.recycleViewHolderInternal(v2);
                            }

                            v2 = v4;
                        }
                        else {
                            v5 = 1;
                        }
                    }
                }

                if(v2 == null) {
                    v8 = v0.this$0.mAdapterHelper.findPositionOffset(v3);
                    if(v8 >= 0 && v8 < v0.this$0.mAdapter.getItemCount()) {
                        int v11 = v0.this$0.mAdapter.getItemViewType(v8);
                        if(v0.this$0.mAdapter.hasStableIds()) {
                            v2 = v0.getScrapOrCachedViewForId(v0.this$0.mAdapter.getItemId(v8), v11, v1);
                            if(v2 != null) {
                                v2.mPosition = v8;
                                v5 = 1;
                            }
                        }

                        if(v2 == null) {
                            ViewCacheExtension v1_1 = v0.mViewCacheExtension;
                            if(v1_1 != null) {
                                View v1_2 = v1_1.getViewForPositionAndType(v0, v3, v11);
                                if(v1_2 != null) {
                                    v2 = v0.this$0.getChildViewHolder(v1_2);
                                    if(v2 == null) {
                                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + v0.this$0.exceptionLabel());
                                    }
                                    else if(!v2.shouldIgnore()) {
                                    }
                                    else {
                                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + v0.this$0.exceptionLabel());
                                    }
                                }
                            }
                        }

                        if(v2 == null) {
                            v1_3 = v0.getRecycledViewPool().getRecycledView(v11);
                            if(v1_3 != null) {
                                v1_3.resetInternal();
                                if(RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                    v0.invalidateDisplayListInt(v1_3);
                                }
                            }

                            v2 = v1_3;
                        }

                        if(v2 != null) {
                            goto label_154;
                        }

                        long v12 = v0.this$0.getNanoTime();
                        if(arg19 != 0x7FFFFFFFFFFFFFFFL && !v0.mRecyclerPool.willCreateInTime(v11, v12, arg19)) {
                            return v4;
                        }

                        v2 = v0.this$0.mAdapter.createViewHolder(v0.this$0, v11);
                        if(RecyclerView.ALLOW_THREAD_GAP_WORK) {
                            RecyclerView v1_4 = RecyclerView.findNestedRecyclerView(v2.itemView);
                            if(v1_4 != null) {
                                v2.mNestedRecyclerView = new WeakReference(v1_4);
                            }
                        }

                        v0.mRecyclerPool.factorInCreateTime(v11, v0.this$0.getNanoTime() - v12);
                        goto label_154;
                    }

                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + v3 + "(offset:" + v8 + ").state:" + v0.this$0.mState.getItemCount() + v0.this$0.exceptionLabel());
                }

            label_154:
                v1_3 = v2;
                v8 = v5;
                if(v8 != 0 && !v0.this$0.mState.isPreLayout()) {
                    int v2_1 = 0x2000;
                    if(v1_3.hasAnyOfTheFlags(v2_1)) {
                        v1_3.setFlags(0, v2_1);
                        if(v0.this$0.mState.mRunSimpleAnimations) {
                            v0.this$0.recordAnimationInfoIfBouncedHiddenView(v1_3, v0.this$0.mItemAnimator.recordPreLayoutInformation(v0.this$0.mState, v1_3, ItemAnimator.buildAdapterChangeFlagsForAnimations(v1_3) | 0x1000, v1_3.getUnmodifiedPayloads()));
                        }
                    }
                }

                if(!v0.this$0.mState.isPreLayout() || !v1_3.isBound()) {
                    if((v1_3.isBound()) && !v1_3.needsUpdate()) {
                        if(v1_3.isInvalid()) {
                        }
                        else {
                        label_194:
                            v2_2 = false;
                            goto label_201;
                        }
                    }

                    v2_2 = v0.tryBindViewHolderByDeadline(v1_3, v0.this$0.mAdapterHelper.findPositionOffset(v3), v3, arg19);
                }
                else {
                    v1_3.mPreLayoutPosition = v3;
                    goto label_194;
                }

            label_201:
                ViewGroup$LayoutParams v3_1 = v1_3.itemView.getLayoutParams();
                RecyclerView v4_1 = v0.this$0;
                if(v3_1 == null) {
                    v0_1 = v4_1.generateDefaultLayoutParams();
                    v1_3.itemView.setLayoutParams(v0_1);
                }
                else if(!v4_1.checkLayoutParams(v3_1)) {
                    v0_1 = v0.this$0.generateLayoutParams(v3_1);
                    v1_3.itemView.setLayoutParams(v0_1);
                }
                else {
                    v0_1 = v3_1;
                }

                ((LayoutParams)v0_1).mViewHolder = v1_3;
                if(v8 == 0 || !v2_2) {
                    v6 = false;
                }
                else {
                }

                ((LayoutParams)v0_1).mPendingInvalidate = v6;
                return v1_3;
            }

            throw new IndexOutOfBoundsException("Invalid item position " + v3 + "(" + v3 + "). Item count:" + v0.this$0.mState.getItemCount() + v0.this$0.exceptionLabel());
        }

        void unscrapView(ViewHolder arg2) {
            if(arg2.mInChangeScrap) {
                this.mChangedScrap.remove(arg2);
            }
            else {
                this.mAttachedScrap.remove(arg2);
            }

            arg2.mScrapContainer = null;
            arg2.mInChangeScrap = false;
            arg2.clearReturnedFromScrapFlag();
        }

        void updateViewCacheSize() {
            int v0 = RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.mPrefetchMaxCountObserved : 0;
            this.mViewCacheMax = this.mRequestedCacheMax + v0;
            for(v0 = this.mCachedViews.size() - 1; v0 >= 0; --v0) {
                if(this.mCachedViews.size() <= this.mViewCacheMax) {
                    return;
                }

                this.recycleCachedViewAt(v0);
            }
        }

        boolean validateViewHolderForOffsetPosition(ViewHolder arg6) {
            if(arg6.isRemoved()) {
                return RecyclerView.this.mState.isPreLayout();
            }

            if(arg6.mPosition >= 0 && arg6.mPosition < RecyclerView.this.mAdapter.getItemCount()) {
                if(!RecyclerView.this.mState.isPreLayout() && RecyclerView.this.mAdapter.getItemViewType(arg6.mPosition) != arg6.getItemViewType()) {
                    return 0;
                }

                if(RecyclerView.this.mAdapter.hasStableIds()) {
                    if(arg6.getItemId() == RecyclerView.this.mAdapter.getItemId(arg6.mPosition)) {
                        return 1;
                    }

                    return 0;
                }

                return 1;
            }

            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + arg6 + RecyclerView.this.exceptionLabel());
        }

        void viewRangeUpdate(int arg4, int arg5) {
            arg5 += arg4;
            int v0;
            for(v0 = this.mCachedViews.size() - 1; v0 >= 0; --v0) {
                Object v1 = this.mCachedViews.get(v0);
                if(v1 == null) {
                }
                else {
                    int v2 = ((ViewHolder)v1).mPosition;
                    if(v2 >= arg4 && v2 < arg5) {
                        ((ViewHolder)v1).addFlags(2);
                        this.recycleCachedViewAt(v0);
                    }
                }
            }
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(ViewHolder arg1);
    }

    class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver(RecyclerView arg1) {
            RecyclerView.this = arg1;
            super();
        }

        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView.this.mState.mStructureChanged = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if(!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int arg3, int arg4, Object arg5) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if(RecyclerView.this.mAdapterHelper.onItemRangeChanged(arg3, arg4, arg5)) {
                this.triggerUpdateProcessor();
            }
        }

        public void onItemRangeInserted(int arg3, int arg4) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if(RecyclerView.this.mAdapterHelper.onItemRangeInserted(arg3, arg4)) {
                this.triggerUpdateProcessor();
            }
        }

        public void onItemRangeMoved(int arg3, int arg4, int arg5) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if(RecyclerView.this.mAdapterHelper.onItemRangeMoved(arg3, arg4, arg5)) {
                this.triggerUpdateProcessor();
            }
        }

        public void onItemRangeRemoved(int arg3, int arg4) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if(RecyclerView.this.mAdapterHelper.onItemRangeRemoved(arg3, arg4)) {
                this.triggerUpdateProcessor();
            }
        }

        void triggerUpdateProcessor() {
            if((RecyclerView.POST_UPDATES_ON_ANIMATION) && (RecyclerView.this.mHasFixedSize) && (RecyclerView.this.mIsAttached)) {
                ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.mUpdateChildViewsRunnable);
                return;
            }

            RecyclerView.this.mAdapterUpdateDuringMeasure = true;
            RecyclerView.this.requestLayout();
        }
    }

    public class SavedState extends AbsSavedState {
        final class androidx.recyclerview.widget.RecyclerView$SavedState$1 implements Parcelable$ClassLoaderCreator {
            androidx.recyclerview.widget.RecyclerView$SavedState$1() {
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
        Parcelable mLayoutState;

        static {
            SavedState.CREATOR = new androidx.recyclerview.widget.RecyclerView$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            if(arg2 != null) {
            }
            else {
                arg2 = LayoutManager.class.getClassLoader();
            }

            this.mLayoutState = arg1.readParcelable(arg2);
        }

        void copyFrom(SavedState arg1) {
            this.mLayoutState = arg1.mLayoutState;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeParcelable(this.mLayoutState, 0);
        }
    }

    public class SimpleOnItemTouchListener implements OnItemTouchListener {
        public SimpleOnItemTouchListener() {
            super();
        }

        public boolean onInterceptTouchEvent(RecyclerView arg1, MotionEvent arg2) {
            return 0;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean arg1) {
        }

        public void onTouchEvent(RecyclerView arg1, MotionEvent arg2) {
        }
    }

    public abstract class SmoothScroller {
        public class Action {
            public static final int UNDEFINED_DURATION = 0x80000000;
            private boolean mChanged;
            private int mConsecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            public Action(int arg3, int arg4) {
                this(arg3, arg4, 0x80000000, null);
            }

            public Action(int arg2, int arg3, int arg4, Interpolator arg5) {
                super();
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = arg2;
                this.mDy = arg3;
                this.mDuration = arg4;
                this.mInterpolator = arg5;
            }

            public Action(int arg2, int arg3, int arg4) {
                this(arg2, arg3, arg4, null);
            }

            public int getDuration() {
                return this.mDuration;
            }

            public int getDx() {
                return this.mDx;
            }

            public int getDy() {
                return this.mDy;
            }

            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            boolean hasJumpTarget() {
                if(this.mJumpToPosition >= 0) {
                    return 1;
                }

                return 0;
            }

            public void jumpTo(int arg1) {
                this.mJumpToPosition = arg1;
            }

            void runIfNecessary(RecyclerView arg6) {
                int v0 = this.mJumpToPosition;
                if(v0 >= 0) {
                    this.mJumpToPosition = -1;
                    arg6.jumpToPositionForSmoothScroller(v0);
                    this.mChanged = false;
                    return;
                }

                if(this.mChanged) {
                    this.validate();
                    arg6.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                    int v6 = this.mConsecutiveUpdates + 1;
                    this.mConsecutiveUpdates = v6;
                    if(v6 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }

                    this.mChanged = false;
                    return;
                }

                this.mConsecutiveUpdates = 0;
            }

            public void setDuration(int arg2) {
                this.mChanged = true;
                this.mDuration = arg2;
            }

            public void setDx(int arg2) {
                this.mChanged = true;
                this.mDx = arg2;
            }

            public void setDy(int arg2) {
                this.mChanged = true;
                this.mDy = arg2;
            }

            public void setInterpolator(Interpolator arg2) {
                this.mChanged = true;
                this.mInterpolator = arg2;
            }

            public void update(int arg1, int arg2, int arg3, Interpolator arg4) {
                this.mDx = arg1;
                this.mDy = arg2;
                this.mDuration = arg3;
                this.mInterpolator = arg4;
                this.mChanged = true;
            }

            private void validate() {
                if(this.mInterpolator != null) {
                    if(this.mDuration >= 1) {
                    }
                    else {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                }

                if(this.mDuration >= 1) {
                    return;
                }

                throw new IllegalStateException("Scroll duration must be a positive number");
            }
        }

        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int arg1);
        }

        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction;
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition;
        private View mTargetView;

        public SmoothScroller() {
            super();
            this.mTargetPosition = -1;
            this.mRecyclingAction = new Action(0, 0);
        }

        public PointF computeScrollVectorForPosition(int arg2) {
            LayoutManager v1 = this.getLayoutManager();
            if((v1 instanceof ScrollVectorProvider)) {
                return ((ScrollVectorProvider)v1).computeScrollVectorForPosition(arg2);
            }

            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int arg1) {
            return this.mRecyclerView.mLayout.findViewByPosition(arg1);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View arg1) {
            return this.mRecyclerView.getChildLayoutPosition(arg1);
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated public void instantScrollToPosition(int arg1) {
            this.mRecyclerView.scrollToPosition(arg1);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        protected void normalize(PointF arg3) {
            float v2 = ((float)Math.sqrt(((double)(arg3.x * arg3.x + arg3.y * arg3.y))));
            arg3.x /= v2;
            arg3.y /= v2;
        }

        void onAnimation(int arg6, int arg7) {
            RecyclerView v0 = this.mRecyclerView;
            if(this.mTargetPosition == -1 || v0 == null) {
                this.stop();
            }

            int[] v2 = null;
            if((this.mPendingInitialRun) && this.mTargetView == null && this.mLayoutManager != null) {
                PointF v1 = this.computeScrollVectorForPosition(this.mTargetPosition);
                if(v1 != null) {
                    if(v1.x == 0f && v1.y == 0f) {
                        goto label_28;
                    }

                    v0.scrollStep(((int)Math.signum(v1.x)), ((int)Math.signum(v1.y)), v2);
                }
            }

        label_28:
            this.mPendingInitialRun = false;
            View v1_1 = this.mTargetView;
            if(v1_1 != null) {
                if(this.getChildPosition(v1_1) == this.mTargetPosition) {
                    this.onTargetFound(this.mTargetView, v0.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(v0);
                    this.stop();
                }
                else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.mTargetView = ((View)v2);
                }
            }

            if(this.mRunning) {
                this.onSeekTargetStep(arg6, arg7, v0.mState, this.mRecyclingAction);
                boolean v6 = this.mRecyclingAction.hasJumpTarget();
                this.mRecyclingAction.runIfNecessary(v0);
                if((v6) && (this.mRunning)) {
                    this.mPendingInitialRun = true;
                    v0.mViewFlinger.postOnAnimation();
                }
            }
        }

        protected void onChildAttachedToWindow(View arg3) {
            if(this.getChildPosition(arg3) == this.getTargetPosition()) {
                this.mTargetView = arg3;
            }
        }

        protected abstract void onSeekTargetStep(int arg1, int arg2, State arg3, Action arg4);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View arg1, State arg2, Action arg3);

        public void setTargetPosition(int arg1) {
            this.mTargetPosition = arg1;
        }

        void start(RecyclerView arg3, LayoutManager arg4) {
            arg3.mViewFlinger.stop();
            if(this.mStarted) {
                Log.w("RecyclerView", "An instance of " + this.getClass().getSimpleName() + " was started more than once. Each instance of" + this.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }

            this.mRecyclerView = arg3;
            this.mLayoutManager = arg4;
            if(this.mTargetPosition != -1) {
                arg3.mState.mTargetPosition = this.mTargetPosition;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = this.findViewByPosition(this.getTargetPosition());
                this.onStart();
                this.mRecyclerView.mViewFlinger.postOnAnimation();
                this.mStarted = true;
                return;
            }

            throw new IllegalArgumentException("Invalid target position");
        }

        protected final void stop() {
            if(!this.mRunning) {
                return;
            }

            this.mRunning = false;
            this.onStop();
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }

    public class State {
        static final int STEP_ANIMATIONS = 4;
        static final int STEP_LAYOUT = 2;
        static final int STEP_START = 1;
        private SparseArray mData;
        int mDeletedInvisibleItemCountSincePreviousLayout;
        long mFocusedItemId;
        int mFocusedItemPosition;
        int mFocusedSubChildId;
        boolean mInPreLayout;
        boolean mIsMeasuring;
        int mItemCount;
        int mLayoutStep;
        int mPreviousLayoutItemCount;
        int mRemainingScrollHorizontal;
        int mRemainingScrollVertical;
        boolean mRunPredictiveAnimations;
        boolean mRunSimpleAnimations;
        boolean mStructureChanged;
        int mTargetPosition;
        boolean mTrackOldChangeHolders;

        public State() {
            super();
            this.mTargetPosition = -1;
            this.mPreviousLayoutItemCount = 0;
            this.mDeletedInvisibleItemCountSincePreviousLayout = 0;
            this.mLayoutStep = 1;
            this.mItemCount = 0;
            this.mStructureChanged = false;
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
            this.mRunSimpleAnimations = false;
            this.mRunPredictiveAnimations = false;
        }

        void assertLayoutStep(int arg4) {
            if((this.mLayoutStep & arg4) != 0) {
                return;
            }

            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(arg4) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public Object get(int arg1) {
            SparseArray v0 = this.mData;
            if(v0 == null) {
                return null;
            }

            return v0.get(arg1);
        }

        public int getItemCount() {
            if(this.mInPreLayout) {
                return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
            }

            return this.mItemCount;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            if(this.mTargetPosition != -1) {
                return 1;
            }

            return 0;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        void prepareForNestedPrefetch(Adapter arg2) {
            this.mLayoutStep = 1;
            this.mItemCount = arg2.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public void put(int arg2, Object arg3) {
            SparseArray v0 = this.mData;
            if(v0 == null) {
                v0 = new SparseArray();
                this.mData = v0;
            }

            v0.put(arg2, arg3);
        }

        public void remove(int arg1) {
            SparseArray v0 = this.mData;
            if(v0 == null) {
                return;
            }

            v0.remove(arg1);
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }
    }

    public abstract class ViewCacheExtension {
        public ViewCacheExtension() {
            super();
        }

        public abstract View getViewForPositionAndType(Recycler arg1, int arg2, int arg3);
    }

    class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback;

        ViewFlinger(RecyclerView arg3) {
            RecyclerView.this = arg3;
            super();
            this.mInterpolator = RecyclerView.sQuinticInterpolator;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(arg3.getContext(), RecyclerView.sQuinticInterpolator);
        }

        private int computeScrollDuration(int arg5, int arg6, int arg7, int arg8) {
            int v4;
            int v0 = Math.abs(arg5);
            int v1 = Math.abs(arg6);
            int v2 = v0 > v1 ? 1 : 0;
            arg7 = ((int)Math.sqrt(((double)(arg7 * arg7 + arg8 * arg8))));
            arg5 = ((int)Math.sqrt(((double)(arg5 * arg5 + arg6 * arg6))));
            RecyclerView v6 = RecyclerView.this;
            arg6 = v2 != 0 ? v6.getWidth() : v6.getHeight();
            arg8 = arg6 / 2;
            float v3 = 1f;
            float v6_1 = ((float)arg6);
            float v8 = ((float)arg8);
            v8 += this.distanceInfluenceForSnapDuration(Math.min(v3, (((float)arg5)) * v3 / v6_1)) * v8;
            if(arg7 > 0) {
                v4 = Math.round(Math.abs(v8 / (((float)arg7))) * 1000f) * 4;
            }
            else {
                if(v2 != 0) {
                }
                else {
                    v0 = v1;
                }

                v4 = ((int)(((((float)v0)) / v6_1 + v3) * 300f));
            }

            return Math.min(v4, 2000);
        }

        private float distanceInfluenceForSnapDuration(float arg1) {
            return ((float)Math.sin(((double)((arg1 - 0.5f) * 0.471239f))));
        }

        public void fling(int arg13, int arg14) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            if(this.mInterpolator != RecyclerView.sQuinticInterpolator) {
                this.mInterpolator = RecyclerView.sQuinticInterpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
            }

            this.mOverScroller.fling(0, 0, arg13, arg14, 0x80000000, 0x7FFFFFFF, 0x80000000, 0x7FFFFFFF);
            this.postOnAnimation();
        }

        private void internalPostOnAnimation() {
            RecyclerView.this.removeCallbacks(((Runnable)this));
            ViewCompat.postOnAnimation(RecyclerView.this, ((Runnable)this));
        }

        void postOnAnimation() {
            if(this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
                return;
            }

            this.internalPostOnAnimation();
        }

        public void run() {
            int v13;
            int v12;
            int v6;
            ViewFlinger v0 = this;
            if(v0.this$0.mLayout == null) {
                v0.stop();
                return;
            }

            v0.mReSchedulePostAnimationCallback = false;
            v0.mEatRunOnAnimationRequest = true;
            v0.this$0.consumePendingUpdateOperations();
            OverScroller v3 = v0.mOverScroller;
            if(v3.computeScrollOffset()) {
                int v4 = v3.getCurrX();
                int v5 = v3.getCurrY();
                int v8 = v4 - v0.mLastFlingX;
                int v9 = v5 - v0.mLastFlingY;
                v0.mLastFlingX = v4;
                v0.mLastFlingY = v5;
                v0.this$0.mReusableIntPair[0] = 0;
                v0.this$0.mReusableIntPair[1] = 0;
                if(v0.this$0.dispatchNestedPreScroll(v8, v9, v0.this$0.mReusableIntPair, null, 1)) {
                    v8 -= v0.this$0.mReusableIntPair[0];
                    v9 -= v0.this$0.mReusableIntPair[1];
                }

                v5 = 2;
                if(v0.this$0.getOverScrollMode() != v5) {
                    v0.this$0.considerReleasingGlowsOnScroll(v8, v9);
                }

                if(v0.this$0.mAdapter != null) {
                    v0.this$0.mReusableIntPair[0] = 0;
                    v0.this$0.mReusableIntPair[1] = 0;
                    v0.this$0.scrollStep(v8, v9, v0.this$0.mReusableIntPair);
                    v4 = v0.this$0.mReusableIntPair[0];
                    v6 = v0.this$0.mReusableIntPair[1];
                    v8 -= v4;
                    v9 -= v6;
                    SmoothScroller v7 = v0.this$0.mLayout.mSmoothScroller;
                    if(v7 != null && !v7.isPendingInitialRun() && (v7.isRunning())) {
                        int v10 = v0.this$0.mState.getItemCount();
                        if(v10 == 0) {
                            v7.stop();
                        }
                        else if(v7.getTargetPosition() >= v10) {
                            v7.setTargetPosition(v10 - 1);
                            v7.onAnimation(v4, v6);
                        }
                        else {
                            v7.onAnimation(v4, v6);
                        }
                    }

                    v12 = v4;
                    v13 = v6;
                }
                else {
                    v12 = 0;
                    v13 = 0;
                }

                int v14 = v8;
                int v15 = v9;
                if(!v0.this$0.mItemDecorations.isEmpty()) {
                    v0.this$0.invalidate();
                }

                v0.this$0.mReusableIntPair[0] = 0;
                v0.this$0.mReusableIntPair[1] = 0;
                v0.this$0.dispatchNestedScroll(v12, v13, v14, v15, null, 1, v0.this$0.mReusableIntPair);
                v14 -= v0.this$0.mReusableIntPair[0];
                v15 -= v0.this$0.mReusableIntPair[1];
                if(v12 != 0 || v13 != 0) {
                    v0.this$0.dispatchOnScrolled(v12, v13);
                }

                if(!v0.this$0.awakenScrollBars()) {
                    v0.this$0.invalidate();
                }

                v4 = v3.getCurrX() == v3.getFinalX() ? 1 : 0;
                v6 = v3.getCurrY() == v3.getFinalY() ? 1 : 0;
                if(!v3.isFinished()) {
                    if(v4 != 0 || v14 != 0) {
                        if(v6 != 0) {
                            goto label_153;
                        }
                        else if(v15 != 0) {
                            goto label_153;
                        }
                    }

                    v4 = 0;
                }
                else {
                label_153:
                    v4 = 1;
                }

                SmoothScroller v6_1 = v0.this$0.mLayout.mSmoothScroller;
                if(v6_1 != null && (v6_1.isPendingInitialRun())) {
                }
                else if(v4 != 0) {
                    if(v0.this$0.getOverScrollMode() != v5) {
                        int v3_1 = ((int)v3.getCurrVelocity());
                        if(v14 < 0) {
                            v4 = -v3_1;
                        }
                        else if(v14 > 0) {
                            v4 = v3_1;
                        }
                        else {
                            v4 = 0;
                        }

                        if(v15 < 0) {
                            v3_1 = -v3_1;
                        }
                        else if(v15 > 0) {
                        }
                        else {
                            v3_1 = 0;
                        }

                        v0.this$0.absorbGlows(v4, v3_1);
                    }

                    if(!RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        goto label_196;
                    }

                    v0.this$0.mPrefetchRegistry.clearPrefetchPositions();
                    goto label_196;
                }

                v0.postOnAnimation();
                if(v0.this$0.mGapWorker == null) {
                    goto label_196;
                }

                v0.this$0.mGapWorker.postFromTraversal(v0.this$0, v12, v13);
            }

        label_196:
            SmoothScroller v3_2 = v0.this$0.mLayout.mSmoothScroller;
            if(v3_2 != null && (v3_2.isPendingInitialRun())) {
                v3_2.onAnimation(0, 0);
            }

            v0.mEatRunOnAnimationRequest = false;
            if(v0.mReSchedulePostAnimationCallback) {
                v0.internalPostOnAnimation();
                return;
            }

            v0.this$0.setScrollState(0);
            v0.this$0.stopNestedScroll(1);
        }

        public void smoothScrollBy(int arg9, int arg10, int arg11, Interpolator arg12) {
            if(arg11 == 0x80000000) {
                arg11 = this.computeScrollDuration(arg9, arg10, 0, 0);
            }

            int v7 = arg11;
            if(arg12 == null) {
                arg12 = RecyclerView.sQuinticInterpolator;
            }

            if(this.mInterpolator != arg12) {
                this.mInterpolator = arg12;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), arg12);
            }

            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, arg9, arg10, v7);
            this.postOnAnimation();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(((Runnable)this));
            this.mOverScroller.abortAnimation();
        }
    }

    public abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 0x400;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 0x200;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 0x1000;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 0x2000;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 0x80;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 0x800;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 0x20;
        static final int FLAG_TMP_DETACHED = 0x100;
        static final int FLAG_UPDATE = 2;
        private static final List FULLUPDATE_PAYLOADS = null;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        WeakReference mNestedRecyclerView;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List mPayloads;
        int mPendingAccessibilityState;
        int mPosition;
        int mPreLayoutPosition;
        Recycler mScrapContainer;
        ViewHolder mShadowedHolder;
        ViewHolder mShadowingHolder;
        List mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;

        static {
            ViewHolder.FULLUPDATE_PAYLOADS = Collections.emptyList();
        }

        public ViewHolder(View arg4) {
            super();
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mItemViewType = -1;
            this.mPreLayoutPosition = -1;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.mPayloads = null;
            this.mUnmodifiedPayloads = null;
            this.mIsRecyclableCount = 0;
            this.mScrapContainer = null;
            this.mInChangeScrap = false;
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            if(arg4 != null) {
                this.itemView = arg4;
                return;
            }

            throw new IllegalArgumentException("itemView may not be null");
        }

        void addChangePayload(Object arg3) {
            int v0 = 0x400;
            if(arg3 == null) {
                this.addFlags(v0);
                return;
            }

            if((v0 & this.mFlags) == 0) {
                this.createPayloadsIfNeeded();
                this.mPayloads.add(arg3);
            }
        }

        void addFlags(int arg2) {
            this.mFlags |= arg2;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List v0 = this.mPayloads;
            if(v0 != null) {
                v0.clear();
            }

            this.mFlags &= 0xFFFFFBFF;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= 0xFFFFFEFF;
        }

        private void createPayloadsIfNeeded() {
            if(this.mPayloads == null) {
                ArrayList v0 = new ArrayList();
                this.mPayloads = ((List)v0);
                this.mUnmodifiedPayloads = Collections.unmodifiableList(((List)v0));
            }
        }

        boolean doesTransientStatePreventRecycling() {
            if((this.mFlags & 16) == 0 && (ViewCompat.hasTransientState(this.itemView))) {
                return 1;
            }

            return 0;
        }

        void flagRemovedAndOffsetPosition(int arg2, int arg3, boolean arg4) {
            this.addFlags(8);
            this.offsetPosition(arg3, arg4);
            this.mPosition = arg2;
        }

        public final int getAdapterPosition() {
            RecyclerView v0 = this.mOwnerRecyclerView;
            if(v0 == null) {
                return -1;
            }

            return v0.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int v0 = this.mPreLayoutPosition;
            if(v0 == -1) {
                return this.mPosition;
            }

            return v0;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated public final int getPosition() {
            int v0 = this.mPreLayoutPosition;
            if(v0 == -1) {
                return this.mPosition;
            }

            return v0;
        }

        List getUnmodifiedPayloads() {
            if((this.mFlags & 0x400) == 0) {
                List v0 = this.mPayloads;
                if(v0 != null) {
                    if(v0.size() == 0) {
                    }
                    else {
                        return this.mUnmodifiedPayloads;
                    }
                }

                return ViewHolder.FULLUPDATE_PAYLOADS;
            }

            return ViewHolder.FULLUPDATE_PAYLOADS;
        }

        boolean hasAnyOfTheFlags(int arg1) {
            if((this.mFlags & arg1) != 0) {
                return 1;
            }

            return 0;
        }

        boolean isAdapterPositionUnknown() {
            if((this.mFlags & 0x200) == 0) {
                if(this.isInvalid()) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        boolean isAttachedToTransitionOverlay() {
            if(this.itemView.getParent() != null && this.itemView.getParent() != this.mOwnerRecyclerView) {
                return 1;
            }

            return 0;
        }

        boolean isBound() {
            if((this.mFlags & 1) != 0) {
                return 1;
            }

            return 0;
        }

        boolean isInvalid() {
            if((this.mFlags & 4) != 0) {
                return 1;
            }

            return 0;
        }

        public final boolean isRecyclable() {
            if((this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView)) {
                return 1;
            }

            return 0;
        }

        boolean isRemoved() {
            if((this.mFlags & 8) != 0) {
                return 1;
            }

            return 0;
        }

        boolean isScrap() {
            if(this.mScrapContainer != null) {
                return 1;
            }

            return 0;
        }

        boolean isTmpDetached() {
            if((this.mFlags & 0x100) != 0) {
                return 1;
            }

            return 0;
        }

        boolean isUpdated() {
            if((this.mFlags & 2) != 0) {
                return 1;
            }

            return 0;
        }

        boolean needsUpdate() {
            if((this.mFlags & 2) != 0) {
                return 1;
            }

            return 0;
        }

        void offsetPosition(int arg3, boolean arg4) {
            int v1 = -1;
            if(this.mOldPosition == v1) {
                this.mOldPosition = this.mPosition;
            }

            int v0 = this.mPreLayoutPosition;
            if(v0 == v1) {
                v0 = this.mPosition;
                this.mPreLayoutPosition = v0;
            }

            if(arg4) {
                this.mPreLayoutPosition = v0 + arg3;
            }

            this.mPosition += arg3;
            if(this.itemView.getLayoutParams() != null) {
                this.itemView.getLayoutParams().mInsetsDirty = true;
            }
        }

        void onEnteredHiddenState(RecyclerView arg3) {
            int v0 = this.mPendingAccessibilityState;
            this.mWasImportantForAccessibilityBeforeHidden = v0 != -1 ? v0 : ViewCompat.getImportantForAccessibility(this.itemView);
            arg3.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView arg2) {
            arg2.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void saveOldPosition() {
            if(this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int arg3, int arg4) {
            this.mFlags = arg3 & arg4 | this.mFlags & ~arg4;
        }

        public final void setIsRecyclable(boolean arg3) {
            int v0 = this.mIsRecyclableCount;
            if(arg3) {
                --v0;
            }
            else {
                ++v0;
            }

            this.mIsRecyclableCount = v0;
            if(v0 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }

            if(!arg3 && v0 == 1) {
                this.mFlags |= 16;
                return;
            }

            if((arg3) && v0 == 0) {
                this.mFlags &= -17;
            }
        }

        void setScrapContainer(Recycler arg1, boolean arg2) {
            this.mScrapContainer = arg1;
            this.mInChangeScrap = arg2;
        }

        boolean shouldBeKeptAsChild() {
            if((this.mFlags & 16) != 0) {
                return 1;
            }

            return 0;
        }

        boolean shouldIgnore() {
            if((this.mFlags & 0x80) != 0) {
                return 1;
            }

            return 0;
        }

        void stopIgnoring() {
            this.mFlags &= 0xFFFFFF7F;
        }

        public String toString() {
            String v0 = this.getClass().isAnonymousClass() ? "ViewHolder" : this.getClass().getSimpleName();
            StringBuilder v1 = new StringBuilder(v0 + "{" + Integer.toHexString(this.hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if(this.isScrap()) {
                StringBuilder v0_1 = v1.append(" scrap ");
                String v2 = this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]";
                v0_1.append(v2);
            }

            if(this.isInvalid()) {
                v1.append(" invalid");
            }

            if(!this.isBound()) {
                v1.append(" unbound");
            }

            if(this.needsUpdate()) {
                v1.append(" update");
            }

            if(this.isRemoved()) {
                v1.append(" removed");
            }

            if(this.shouldIgnore()) {
                v1.append(" ignored");
            }

            if(this.isTmpDetached()) {
                v1.append(" tmpDetached");
            }

            if(!this.isRecyclable()) {
                v1.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }

            if(this.isAdapterPositionUnknown()) {
                v1.append(" undefined adapter position");
            }

            if(this.itemView.getParent() == null) {
                v1.append(" no parent");
            }

            v1.append("}");
            return v1.toString();
        }

        void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        boolean wasReturnedFromScrap() {
            if((this.mFlags & 0x20) != 0) {
                return 1;
            }

            return 0;
        }
    }

    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
    static final boolean ALLOW_THREAD_GAP_WORK = false;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = 0x7FFFFFFFFFFFFFFFL;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = null;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = null;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = false;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = 0x80000000;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList mOnItemTouchListeners;
    final List mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;
    static final Interpolator sQuinticInterpolator;

    static {
        RecyclerView.NESTED_SCROLLING_ATTRS = new int[]{0x1010436};
        RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST = false;
        RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
        RecyclerView.POST_UPDATES_ON_ANIMATION = true;
        RecyclerView.ALLOW_THREAD_GAP_WORK = true;
        RecyclerView.FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        RecyclerView.IGNORE_DETACHED_FOCUSED_CHILD = false;
        RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        RecyclerView.sQuinticInterpolator = new androidx.recyclerview.widget.RecyclerView$3();
    }

    public RecyclerView(Context arg2) {
        this(arg2, null);
    }

    public RecyclerView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.recyclerViewStyle);
    }

    public RecyclerView(Context arg12, AttributeSet arg13, int arg14) {
        super(arg12, arg13, arg14);
        this.mObserver = new RecyclerViewDataObserver(this);
        this.mRecycler = new Recycler(this);
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new androidx.recyclerview.widget.RecyclerView$1(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        int v8 = -1;
        this.mScrollPointerId = v8;
        this.mScaledHorizontalScrollFactor = 1.401298E-45f;
        this.mScaledVerticalScrollFactor = 1.401298E-45f;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        LayoutPrefetchRegistryImpl v2 = RecyclerView.ALLOW_THREAD_GAP_WORK ? new LayoutPrefetchRegistryImpl() : null;
        this.mPrefetchRegistry = v2;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new androidx.recyclerview.widget.RecyclerView$2(this);
        this.mViewInfoProcessCallback = new androidx.recyclerview.widget.RecyclerView$4(this);
        this.setScrollContainer(true);
        this.setFocusableInTouchMode(true);
        ViewConfiguration v4 = ViewConfiguration.get(arg12);
        this.mTouchSlop = v4.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(v4, arg12);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(v4, arg12);
        this.mMinFlingVelocity = v4.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = v4.getScaledMaximumFlingVelocity();
        boolean v2_1 = this.getOverScrollMode() == 2 ? true : false;
        this.setWillNotDraw(v2_1);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        this.initAdapterManager();
        this.initChildrenHelper();
        this.initAutofill();
        if(ViewCompat.getImportantForAccessibility(((View)this)) == 0) {
            ViewCompat.setImportantForAccessibility(((View)this), 1);
        }

        this.mAccessibilityManager = this.getContext().getSystemService("accessibility");
        this.setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray v4_1 = arg12.obtainStyledAttributes(arg13, styleable.RecyclerView, arg14, 0);
        int v10 = 29;
        if(Build$VERSION.SDK_INT >= v10) {
            this.saveAttributeDataForStyleable(arg12, styleable.RecyclerView, arg13, v4_1, arg14, 0);
        }

        String v2_2 = v4_1.getString(styleable.RecyclerView_layoutManager);
        if(v4_1.getInt(styleable.RecyclerView_android_descendantFocusability, v8) == v8) {
            this.setDescendantFocusability(0x40000);
        }

        this.mClipToPadding = v4_1.getBoolean(styleable.RecyclerView_android_clipToPadding, true);
        boolean v1 = v4_1.getBoolean(styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = v1;
        if(v1) {
            this.initFastScroller(v4_1.getDrawable(styleable.RecyclerView_fastScrollVerticalThumbDrawable), v4_1.getDrawable(styleable.RecyclerView_fastScrollVerticalTrackDrawable), v4_1.getDrawable(styleable.RecyclerView_fastScrollHorizontalThumbDrawable), v4_1.getDrawable(styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }

        v4_1.recycle();
        this.createLayoutManager(arg12, v2_2, arg13, arg14, 0);
        int[] v2_3 = RecyclerView.NESTED_SCROLLING_ATTRS;
        v4_1 = arg12.obtainStyledAttributes(arg13, v2_3, arg14, 0);
        if(Build$VERSION.SDK_INT >= v10) {
            this.saveAttributeDataForStyleable(arg12, v2_3, arg13, v4_1, arg14, 0);
        }

        v1 = v4_1.getBoolean(0, true);
        v4_1.recycle();
        this.setNestedScrollingEnabled(v1);
    }

    void absorbGlows(int arg3, int arg4) {
        if(arg3 < 0) {
            this.ensureLeftGlow();
            if(this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-arg3);
            }
        }
        else if(arg3 > 0) {
            this.ensureRightGlow();
            if(this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(arg3);
            }
        }

        if(arg4 < 0) {
            this.ensureTopGlow();
            if(this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-arg4);
            }
        }
        else if(arg4 > 0) {
            this.ensureBottomGlow();
            if(this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(arg4);
            }
        }

        if(arg3 == 0) {
            if(arg4 != 0) {
            }
            else {
                return;
            }
        }

        ViewCompat.postInvalidateOnAnimation(((View)this));
    }

    static void access$000(RecyclerView arg0, View arg1, int arg2, ViewGroup$LayoutParams arg3) {
        arg0.attachViewToParent(arg1, arg2, arg3);
    }

    static void access$100(RecyclerView arg0, int arg1) {
        arg0.detachViewFromParent(arg1);
    }

    static boolean access$200(RecyclerView arg0) {
        return arg0.awakenScrollBars();
    }

    static void access$300(RecyclerView arg0, int arg1, int arg2) {
        arg0.setMeasuredDimension(arg1, arg2);
    }

    private void addAnimatingView(ViewHolder arg6) {
        View v0 = arg6.itemView;
        int v1 = v0.getParent() == this ? 1 : 0;
        this.mRecycler.unscrapView(this.getChildViewHolder(v0));
        if(arg6.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(v0, -1, v0.getLayoutParams(), true);
            return;
        }

        ChildHelper v5 = this.mChildHelper;
        if(v1 == 0) {
            v5.addView(v0, true);
            return;
        }

        v5.hide(v0);
    }

    public void addFocusables(ArrayList arg2, int arg3, int arg4) {
        LayoutManager v0 = this.mLayout;
        if(v0 != null) {
            if(!v0.onAddFocusables(this, arg2, arg3, arg4)) {
            }
            else {
                return;
            }
        }

        super.addFocusables(arg2, arg3, arg4);
    }

    public void addItemDecoration(ItemDecoration arg2) {
        this.addItemDecoration(arg2, -1);
    }

    public void addItemDecoration(ItemDecoration arg3, int arg4) {
        LayoutManager v0 = this.mLayout;
        if(v0 != null) {
            v0.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }

        if(this.mItemDecorations.isEmpty()) {
            this.setWillNotDraw(false);
        }

        ArrayList v0_1 = this.mItemDecorations;
        if(arg4 < 0) {
            v0_1.add(arg3);
        }
        else {
            v0_1.add(arg4, arg3);
        }

        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener arg2) {
        if(this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }

        this.mOnChildAttachStateListeners.add(arg2);
    }

    public void addOnItemTouchListener(OnItemTouchListener arg1) {
        this.mOnItemTouchListeners.add(arg1);
    }

    public void addOnScrollListener(OnScrollListener arg2) {
        if(this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }

        this.mScrollListeners.add(arg2);
    }

    void animateAppearance(ViewHolder arg2, ItemHolderInfo arg3, ItemHolderInfo arg4) {
        arg2.setIsRecyclable(false);
        if(this.mItemAnimator.animateAppearance(arg2, arg3, arg4)) {
            this.postAnimationRunner();
        }
    }

    private void animateChange(ViewHolder arg2, ViewHolder arg3, ItemHolderInfo arg4, ItemHolderInfo arg5, boolean arg6, boolean arg7) {
        arg2.setIsRecyclable(false);
        if(arg6) {
            this.addAnimatingView(arg2);
        }

        if(arg2 != arg3) {
            if(arg7) {
                this.addAnimatingView(arg3);
            }

            arg2.mShadowedHolder = arg3;
            this.addAnimatingView(arg2);
            this.mRecycler.unscrapView(arg2);
            arg3.setIsRecyclable(false);
            arg3.mShadowingHolder = arg2;
        }

        if(this.mItemAnimator.animateChange(arg2, arg3, arg4, arg5)) {
            this.postAnimationRunner();
        }
    }

    void animateDisappearance(ViewHolder arg2, ItemHolderInfo arg3, ItemHolderInfo arg4) {
        this.addAnimatingView(arg2);
        arg2.setIsRecyclable(false);
        if(this.mItemAnimator.animateDisappearance(arg2, arg3, arg4)) {
            this.postAnimationRunner();
        }
    }

    void assertInLayoutOrScroll(String arg3) {
        if(!this.isComputingLayout()) {
            if(arg3 == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + this.exceptionLabel());
            }

            throw new IllegalStateException(arg3 + this.exceptionLabel());
        }
    }

    void assertNotInLayoutOrScroll(String arg3) {
        if(this.isComputingLayout()) {
            if(arg3 == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + this.exceptionLabel());
            }

            throw new IllegalStateException(arg3);
        }

        if(this.mDispatchScrollCounter > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + this.exceptionLabel()));
        }
    }

    boolean canReuseUpdatedViewHolder(ViewHolder arg2) {
        ItemAnimator v1 = this.mItemAnimator;
        if(v1 != null) {
            if(v1.canReuseUpdatedViewHolder(arg2, arg2.getUnmodifiedPayloads())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private void cancelScroll() {
        this.resetScroll();
        this.setScrollState(0);
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        if(((arg2 instanceof LayoutParams)) && (this.mLayout.checkLayoutParams(((LayoutParams)arg2)))) {
            return 1;
        }

        return 0;
    }

    static void clearNestedRecyclerViewIfNotNested(ViewHolder arg3) {
        Object v1;
        if(arg3.mNestedRecyclerView != null) {
            Object v0 = arg3.mNestedRecyclerView.get();
            while(true) {
                v1 = null;
                if(v0 == null) {
                    break;
                }
                else if(v0 == arg3.itemView) {
                }
                else {
                    ViewParent v0_1 = ((View)v0).getParent();
                    if((v0_1 instanceof View)) {
                    }
                    else {
                        v0 = v1;
                    }

                    continue;
                }

                return;
            }

            arg3.mNestedRecyclerView = ((WeakReference)v1);
        }
    }

    void clearOldPositions() {
        int v0 = this.mChildHelper.getUnfilteredChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            ViewHolder v2 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(v1));
            if(!v2.shouldIgnore()) {
                v2.clearOldPosition();
            }
        }

        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List v0 = this.mOnChildAttachStateListeners;
        if(v0 != null) {
            v0.clear();
        }
    }

    public void clearOnScrollListeners() {
        List v0 = this.mScrollListeners;
        if(v0 != null) {
            v0.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            return 0;
        }

        if(v0.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }

        return 0;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            return 0;
        }

        if(v0.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }

        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            return 0;
        }

        if(v0.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }

        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            return 0;
        }

        if(v0.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }

        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            return 0;
        }

        if(v0.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }

        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            return 0;
        }

        if(v0.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }

        return 0;
    }

    void considerReleasingGlowsOnScroll(int arg3, int arg4) {
        int v0_2;
        EdgeEffect v0 = this.mLeftGlow;
        if(v0 == null || (v0.isFinished()) || arg3 <= 0) {
            v0_2 = 0;
        }
        else {
            this.mLeftGlow.onRelease();
            boolean v0_1 = this.mLeftGlow.isFinished();
        }

        EdgeEffect v1 = this.mRightGlow;
        if(v1 != null && !v1.isFinished() && arg3 < 0) {
            this.mRightGlow.onRelease();
            v0_2 |= this.mRightGlow.isFinished();
        }

        EdgeEffect v3 = this.mTopGlow;
        if(v3 != null && !v3.isFinished() && arg4 > 0) {
            this.mTopGlow.onRelease();
            v0_2 |= this.mTopGlow.isFinished();
        }

        v3 = this.mBottomGlow;
        if(v3 != null && !v3.isFinished() && arg4 < 0) {
            this.mBottomGlow.onRelease();
            v0_2 |= this.mBottomGlow.isFinished();
        }

        if((((boolean)v0_2))) {
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    void consumePendingUpdateOperations() {
        String v1 = "RV FullInvalidate";
        if(this.mFirstLayoutComplete) {
            if(this.mDataSetHasChangedAfterLayout) {
            }
            else {
                if(!this.mAdapterHelper.hasPendingUpdates()) {
                }
                else {
                    if((this.mAdapterHelper.hasAnyUpdateTypes(4)) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
                        TraceCompat.beginSection("RV PartialInvalidate");
                        this.startInterceptRequestLayout();
                        this.onEnterLayoutOrScroll();
                        this.mAdapterHelper.preProcess();
                        if(!this.mLayoutWasDefered) {
                            if(this.hasUpdatedView()) {
                                this.dispatchLayout();
                            }
                            else {
                                this.mAdapterHelper.consumePostponedUpdates();
                            }
                        }

                        this.stopInterceptRequestLayout(true);
                        this.onExitLayoutOrScroll();
                        TraceCompat.endSection();
                        return;
                    }

                    if(!this.mAdapterHelper.hasPendingUpdates()) {
                        return;
                    }

                    TraceCompat.beginSection(v1);
                    this.dispatchLayout();
                    TraceCompat.endSection();
                }

                return;
            }
        }

        TraceCompat.beginSection(v1);
        this.dispatchLayout();
        TraceCompat.endSection();
    }

    private void createLayoutManager(Context arg7, String arg8, AttributeSet arg9, int arg10, int arg11) {
        Object[] v5;
        Constructor v4;
        Class v1_1;
        String v0 = ": Could not instantiate the LayoutManager: ";
        if(arg8 != null) {
            arg8 = arg8.trim();
            if(arg8.isEmpty()) {
                return;
            }

            arg8 = this.getFullClassName(arg7, arg8);
            try {
                ClassLoader v1 = this.isInEditMode() ? this.getClass().getClassLoader() : arg7.getClassLoader();
                v1_1 = Class.forName(arg8, false, v1).asSubclass(LayoutManager.class);
            }
            catch(ClassNotFoundException v6) {
                goto label_108;
            }
            catch(InvocationTargetException v6_1) {
                goto label_96;
            }
            catch(InstantiationException v6_2) {
                goto label_85;
            }
            catch(IllegalAccessException v6_3) {
                goto label_74;
            }
            catch(ClassCastException v6_4) {
                goto label_62;
            }

            try {
                v4 = v1_1.getConstructor(RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                v5 = new Object[]{arg7, arg9, Integer.valueOf(arg10), Integer.valueOf(arg11)};
                goto label_34;
            }
            catch(ClassCastException v6_4) {
            }
            catch(IllegalAccessException v6_3) {
            }
            catch(InstantiationException v6_2) {
            }
            catch(InvocationTargetException v6_1) {
            }
            catch(ClassNotFoundException v6) {
            }
            catch(NoSuchMethodException v7) {
                try {
                    v4 = v1_1.getConstructor();
                    v5 = null;
                    goto label_34;
                }
                catch(ClassCastException v6_4) {
                }
                catch(IllegalAccessException v6_3) {
                }
                catch(InstantiationException v6_2) {
                }
                catch(InvocationTargetException v6_1) {
                }
                catch(ClassNotFoundException v6) {
                }
                catch(NoSuchMethodException v6_5) {
                    try {
                        v6_5.initCause(((Throwable)v7));
                        throw new IllegalStateException(arg9.getPositionDescription() + ": Error creating LayoutManager " + arg8, ((Throwable)v6_5));
                    label_34:
                        v4.setAccessible(true);
                        this.setLayoutManager(v4.newInstance(v5));
                    }
                    catch(ClassCastException v6_4) {
                    label_62:
                        throw new IllegalStateException(arg9.getPositionDescription() + ": Class is not a LayoutManager " + arg8, ((Throwable)v6_4));
                    }
                    catch(IllegalAccessException v6_3) {
                    label_74:
                        throw new IllegalStateException(arg9.getPositionDescription() + ": Cannot access non-public constructor " + arg8, ((Throwable)v6_3));
                    }
                    catch(InstantiationException v6_2) {
                    label_85:
                        throw new IllegalStateException(arg9.getPositionDescription() + v0 + arg8, ((Throwable)v6_2));
                    }
                    catch(InvocationTargetException v6_1) {
                    label_96:
                        throw new IllegalStateException(arg9.getPositionDescription() + v0 + arg8, ((Throwable)v6_1));
                    }
                    catch(ClassNotFoundException v6) {
                    label_108:
                        throw new IllegalStateException(arg9.getPositionDescription() + ": Unable to find LayoutManager " + arg8, ((Throwable)v6));
                    }
                }
            }
        }
    }

    void defaultOnMeasure(int arg3, int arg4) {
        this.setMeasuredDimension(LayoutManager.chooseSize(arg3, this.getPaddingLeft() + this.getPaddingRight(), ViewCompat.getMinimumWidth(((View)this))), LayoutManager.chooseSize(arg4, this.getPaddingTop() + this.getPaddingBottom(), ViewCompat.getMinimumHeight(((View)this))));
    }

    private boolean didChildRangeChange(int arg4, int arg5) {
        this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] v3 = this.mMinMaxLayoutPositions;
        if(v3[0] == arg4) {
            if(v3[1] != arg5) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    void dispatchChildAttached(View arg3) {
        ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg3);
        this.onChildAttachedToWindow(arg3);
        Adapter v1 = this.mAdapter;
        if(v1 != null && v0 != null) {
            v1.onViewAttachedToWindow(v0);
        }

        List v0_1 = this.mOnChildAttachStateListeners;
        if(v0_1 != null) {
            int v0_2;
            for(v0_2 = v0_1.size() - 1; v0_2 >= 0; --v0_2) {
                this.mOnChildAttachStateListeners.get(v0_2).onChildViewAttachedToWindow(arg3);
            }
        }
    }

    void dispatchChildDetached(View arg3) {
        ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg3);
        this.onChildDetachedFromWindow(arg3);
        Adapter v1 = this.mAdapter;
        if(v1 != null && v0 != null) {
            v1.onViewDetachedFromWindow(v0);
        }

        List v0_1 = this.mOnChildAttachStateListeners;
        if(v0_1 != null) {
            int v0_2;
            for(v0_2 = v0_1.size() - 1; v0_2 >= 0; --v0_2) {
                this.mOnChildAttachStateListeners.get(v0_2).onChildViewDetachedFromWindow(arg3);
            }
        }
    }

    private void dispatchContentChangedIfNecessary() {
        int v0 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if(v0 != 0 && (this.isAccessibilityEnabled())) {
            AccessibilityEvent v1 = AccessibilityEvent.obtain();
            v1.setEventType(0x800);
            AccessibilityEventCompat.setContentChangeTypes(v1, v0);
            this.sendAccessibilityEventUnchecked(v1);
        }
    }

    void dispatchLayout() {
        String v1 = "RecyclerView";
        if(this.mAdapter == null) {
            Log.e(v1, "No adapter attached; skipping layout");
            return;
        }

        if(this.mLayout == null) {
            Log.e(v1, "No layout manager attached; skipping layout");
            return;
        }

        this.mState.mIsMeasuring = false;
        if(this.mState.mLayoutStep == 1) {
            this.dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
        }
        else {
            if(!this.mAdapterHelper.hasUpdates() && this.mLayout.getWidth() == this.getWidth()) {
                if(this.mLayout.getHeight() != this.getHeight()) {
                }
                else {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                    goto label_41;
                }
            }

            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
        }

    label_41:
        this.dispatchLayoutStep3();
    }

    private void dispatchLayoutStep1() {
        int v0_1;
        boolean v1 = true;
        this.mState.assertLayoutStep(1);
        this.fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        this.startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        this.onEnterLayoutOrScroll();
        this.processAdapterUpdatesAndSetAnimationFlags();
        this.saveFocusInfo();
        State v0 = this.mState;
        if(!v0.mRunSimpleAnimations || !this.mItemsChanged) {
            v1 = false;
        }
        else {
        }

        v0.mTrackOldChangeHolders = v1;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        this.mState.mInPreLayout = this.mState.mRunPredictiveAnimations;
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if(this.mState.mRunSimpleAnimations) {
            v0_1 = this.mChildHelper.getChildCount();
            int v1_1;
            for(v1_1 = 0; v1_1 < v0_1; ++v1_1) {
                ViewHolder v3 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(v1_1));
                if(!v3.shouldIgnore() && (!v3.isInvalid() || (this.mAdapter.hasStableIds()))) {
                    this.mViewInfoStore.addToPreLayout(v3, this.mItemAnimator.recordPreLayoutInformation(this.mState, v3, ItemAnimator.buildAdapterChangeFlagsForAnimations(v3), v3.getUnmodifiedPayloads()));
                    if(!this.mState.mTrackOldChangeHolders) {
                        goto label_72;
                    }

                    if(!v3.isUpdated()) {
                        goto label_72;
                    }

                    if(v3.isRemoved()) {
                        goto label_72;
                    }

                    if(v3.shouldIgnore()) {
                        goto label_72;
                    }

                    if(v3.isInvalid()) {
                        goto label_72;
                    }

                    this.mViewInfoStore.addToOldChangeHolders(this.getChangedHolderKey(v3), v3);
                }

            label_72:
            }
        }

        if(this.mState.mRunPredictiveAnimations) {
            this.saveOldPositions();
            boolean v0_2 = this.mState.mStructureChanged;
            this.mState.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.mStructureChanged = v0_2;
            for(v0_1 = 0; v0_1 < this.mChildHelper.getChildCount(); ++v0_1) {
                ViewHolder v1_2 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(v0_1));
                if(v1_2.shouldIgnore()) {
                }
                else if(!this.mViewInfoStore.isInPreLayout(v1_2)) {
                    int v3_1 = ItemAnimator.buildAdapterChangeFlagsForAnimations(v1_2);
                    boolean v4 = v1_2.hasAnyOfTheFlags(0x2000);
                    if(!v4) {
                        v3_1 |= 0x1000;
                    }

                    ItemHolderInfo v3_2 = this.mItemAnimator.recordPreLayoutInformation(this.mState, v1_2, v3_1, v1_2.getUnmodifiedPayloads());
                    if(v4) {
                        this.recordAnimationInfoIfBouncedHiddenView(v1_2, v3_2);
                        goto label_115;
                    }

                    this.mViewInfoStore.addToAppearedInPreLayoutHolders(v1_2, v3_2);
                }

            label_115:
            }

            this.clearOldPositions();
        }
        else {
            this.clearOldPositions();
        }

        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        this.mState.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.mStructureChanged = false;
        this.mPendingSavedState = null;
        State v0 = this.mState;
        boolean v2 = !v0.mRunSimpleAnimations || this.mItemAnimator == null ? false : true;
        v0.mRunSimpleAnimations = v2;
        this.mState.mLayoutStep = 4;
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        RecyclerView v3;
        ItemHolderInfo v7;
        boolean v9;
        boolean v8;
        ViewHolder v6;
        ItemHolderInfo v4;
        this.mState.assertLayoutStep(4);
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        this.mState.mLayoutStep = 1;
        if(this.mState.mRunSimpleAnimations) {
            int v0 = this.mChildHelper.getChildCount() - 1;
            while(v0 >= 0) {
                ViewHolder v5 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(v0));
                if(!v5.shouldIgnore()) {
                    long v2 = this.getChangedHolderKey(v5);
                    v4 = this.mItemAnimator.recordPostLayoutInformation(this.mState, v5);
                    v6 = this.mViewInfoStore.getFromOldChangeHolders(v2);
                    if(v6 != null && !v6.shouldIgnore()) {
                        v8 = this.mViewInfoStore.isDisappearing(v6);
                        v9 = this.mViewInfoStore.isDisappearing(v5);
                        if((v8) && v6 == v5) {
                            this.mViewInfoStore.addToPostLayout(v5, v4);
                            goto label_20;
                        }

                        v7 = this.mViewInfoStore.popFromPreLayout(v6);
                        this.mViewInfoStore.addToPostLayout(v5, v4);
                        v4 = this.mViewInfoStore.popFromPostLayout(v5);
                        if(v7 != null) {
                            goto label_49;
                        }

                        this.handleMissingPreInfoForChangeError(v2, v5, v6);
                        goto label_20;
                    }

                    goto label_56;
                }
                else {
                label_20:
                    v3 = this;
                    goto label_59;
                label_49:
                    ItemHolderInfo v3_1 = v7;
                    v7 = v4;
                    ViewHolder v4_1 = v6;
                    ItemHolderInfo v6_1 = v3_1;
                    v3 = this;
                    v3.animateChange(v4_1, v5, v6_1, v7, v8, v9);
                    goto label_59;
                label_56:
                    v3 = this;
                    v3.mViewInfoStore.addToPostLayout(v5, v4);
                }

            label_59:
                --v0;
                this = v3;
            }

            v3 = this;
            v3.mViewInfoStore.process(v3.mViewInfoProcessCallback);
        }
        else {
            v3 = this;
        }

        v3.mLayout.removeAndRecycleScrapInt(v3.mRecycler);
        v3.mState.mPreviousLayoutItemCount = v3.mState.mItemCount;
        v3.mDataSetHasChangedAfterLayout = false;
        v3.mDispatchItemsChangedEvent = false;
        v3.mState.mRunSimpleAnimations = false;
        v3.mState.mRunPredictiveAnimations = false;
        v3.mLayout.mRequestedSimpleAnimations = false;
        if(v3.mRecycler.mChangedScrap != null) {
            v3.mRecycler.mChangedScrap.clear();
        }

        if(v3.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            v3.mLayout.mPrefetchMaxCountObserved = 0;
            v3.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
            v3.mRecycler.updateViewCacheSize();
        }

        v3.mLayout.onLayoutCompleted(v3.mState);
        v3.onExitLayoutOrScroll();
        v3.stopInterceptRequestLayout(false);
        v3.mViewInfoStore.clear();
        if(v3.didChildRangeChange(v3.mMinMaxLayoutPositions[0], v3.mMinMaxLayoutPositions[1])) {
            v3.dispatchOnScrolled(0, 0);
        }

        v3.recoverFocusFromState();
        v3.resetFocusInfo();
    }

    public boolean dispatchNestedFling(float arg1, float arg2, boolean arg3) {
        return this.getScrollingChildHelper().dispatchNestedFling(arg1, arg2, arg3);
    }

    public boolean dispatchNestedPreFling(float arg1, float arg2) {
        return this.getScrollingChildHelper().dispatchNestedPreFling(arg1, arg2);
    }

    public boolean dispatchNestedPreScroll(int arg1, int arg2, int[] arg3, int[] arg4) {
        return this.getScrollingChildHelper().dispatchNestedPreScroll(arg1, arg2, arg3, arg4);
    }

    public boolean dispatchNestedPreScroll(int arg1, int arg2, int[] arg3, int[] arg4, int arg5) {
        return this.getScrollingChildHelper().dispatchNestedPreScroll(arg1, arg2, arg3, arg4, arg5);
    }

    public final void dispatchNestedScroll(int arg1, int arg2, int arg3, int arg4, int[] arg5, int arg6, int[] arg7) {
        this.getScrollingChildHelper().dispatchNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean dispatchNestedScroll(int arg1, int arg2, int arg3, int arg4, int[] arg5) {
        return this.getScrollingChildHelper().dispatchNestedScroll(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean dispatchNestedScroll(int arg1, int arg2, int arg3, int arg4, int[] arg5, int arg6) {
        return this.getScrollingChildHelper().dispatchNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    void dispatchOnScrollStateChanged(int arg3) {
        LayoutManager v0 = this.mLayout;
        if(v0 != null) {
            v0.onScrollStateChanged(arg3);
        }

        this.onScrollStateChanged(arg3);
        OnScrollListener v0_1 = this.mScrollListener;
        if(v0_1 != null) {
            v0_1.onScrollStateChanged(this, arg3);
        }

        List v0_2 = this.mScrollListeners;
        if(v0_2 != null) {
            int v0_3;
            for(v0_3 = v0_2.size() - 1; v0_3 >= 0; --v0_3) {
                this.mScrollListeners.get(v0_3).onScrollStateChanged(this, arg3);
            }
        }
    }

    void dispatchOnScrolled(int arg5, int arg6) {
        ++this.mDispatchScrollCounter;
        int v0 = this.getScrollX();
        int v1 = this.getScrollY();
        this.onScrollChanged(v0, v1, v0 - arg5, v1 - arg6);
        this.onScrolled(arg5, arg6);
        OnScrollListener v0_1 = this.mScrollListener;
        if(v0_1 != null) {
            v0_1.onScrolled(this, arg5, arg6);
        }

        List v0_2 = this.mScrollListeners;
        if(v0_2 != null) {
            for(v0 = v0_2.size() - 1; v0 >= 0; --v0) {
                this.mScrollListeners.get(v0).onScrolled(this, arg5, arg6);
            }
        }

        --this.mDispatchScrollCounter;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        List v1;
        int v0;
        for(v0 = this.mPendingAccessibilityImportanceChange.size() - 1; true; --v0) {
            v1 = this.mPendingAccessibilityImportanceChange;
            if(v0 < 0) {
                break;
            }

            Object v1_1 = v1.get(v0);
            if(((ViewHolder)v1_1).itemView.getParent() == this) {
                if(((ViewHolder)v1_1).shouldIgnore()) {
                }
                else {
                    int v2 = ((ViewHolder)v1_1).mPendingAccessibilityState;
                    int v3 = -1;
                    if(v2 != v3) {
                        ViewCompat.setImportantForAccessibility(((ViewHolder)v1_1).itemView, v2);
                        ((ViewHolder)v1_1).mPendingAccessibilityState = v3;
                    }
                }
            }
        }

        v1.clear();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg1) {
        this.onPopulateAccessibilityEvent(arg1);
        return 1;
    }

    protected void dispatchRestoreInstanceState(SparseArray arg1) {
        this.dispatchThawSelfOnly(arg1);
    }

    protected void dispatchSaveInstanceState(SparseArray arg1) {
        this.dispatchFreezeSelfOnly(arg1);
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent arg3) {
        OnItemTouchListener v0 = this.mInterceptingOnItemTouchListener;
        if(v0 == null) {
            if(arg3.getAction() == 0) {
                return 0;
            }

            return this.findInterceptingOnItemTouchListener(arg3);
        }

        v0.onTouchEvent(this, arg3);
        int v3 = arg3.getAction();
        if(v3 == 3 || v3 == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }

        return 1;
    }

    public void draw(Canvas arg8) {
        int v4_1;
        EdgeEffect v4;
        int v3;
        super.draw(arg8);
        int v0 = this.mItemDecorations.size();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            this.mItemDecorations.get(v2).onDrawOver(arg8, this, this.mState);
        }

        EdgeEffect v0_1 = this.mLeftGlow;
        v2 = 1;
        if(v0_1 == null || (v0_1.isFinished())) {
            v3 = 0;
        }
        else {
            v0 = arg8.save();
            v3 = this.mClipToPadding ? this.getPaddingBottom() : 0;
            arg8.rotate(270f);
            arg8.translate(((float)(-this.getHeight() + v3)), 0f);
            EdgeEffect v3_1 = this.mLeftGlow;
            v3 = v3_1 == null || !v3_1.draw(arg8) ? 0 : 1;
            arg8.restoreToCount(v0);
        }

        v0_1 = this.mTopGlow;
        if(v0_1 != null && !v0_1.isFinished()) {
            v0 = arg8.save();
            if(this.mClipToPadding) {
                arg8.translate(((float)this.getPaddingLeft()), ((float)this.getPaddingTop()));
            }

            v4 = this.mTopGlow;
            v4_1 = v4 == null || !v4.draw(arg8) ? 0 : 1;
            v3 |= v4_1;
            arg8.restoreToCount(v0);
        }

        v0_1 = this.mRightGlow;
        if(v0_1 != null && !v0_1.isFinished()) {
            v0 = arg8.save();
            v4_1 = this.getWidth();
            int v5 = this.mClipToPadding ? this.getPaddingTop() : 0;
            arg8.rotate(90f);
            arg8.translate(((float)(-v5)), ((float)(-v4_1)));
            v4 = this.mRightGlow;
            v4_1 = v4 == null || !v4.draw(arg8) ? 0 : 1;
            v3 |= v4_1;
            arg8.restoreToCount(v0);
        }

        v0_1 = this.mBottomGlow;
        if(v0_1 != null && !v0_1.isFinished()) {
            v0 = arg8.save();
            arg8.rotate(180f);
            if(this.mClipToPadding) {
                arg8.translate(((float)(-this.getWidth() + this.getPaddingRight())), ((float)(-this.getHeight() + this.getPaddingBottom())));
            }
            else {
                arg8.translate(((float)(-this.getWidth())), ((float)(-this.getHeight())));
            }

            v4 = this.mBottomGlow;
            if(v4 != null && (v4.draw(arg8))) {
                v1 = 1;
            }

            v3 |= v1;
            arg8.restoreToCount(v0);
        }

        if(v3 != 0 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            v2 = v3;
        }
        else {
        }

        if(v2 != 0) {
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    public boolean drawChild(Canvas arg1, View arg2, long arg3) {
        return super.drawChild(arg1, arg2, arg3);
    }

    void ensureBottomGlow() {
        if(this.mBottomGlow != null) {
            return;
        }

        EdgeEffect v0 = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
        this.mBottomGlow = v0;
        if(this.mClipToPadding) {
            v0.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
            return;
        }

        v0.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    void ensureLeftGlow() {
        if(this.mLeftGlow != null) {
            return;
        }

        EdgeEffect v0 = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
        this.mLeftGlow = v0;
        if(this.mClipToPadding) {
            v0.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
            return;
        }

        v0.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
    }

    void ensureRightGlow() {
        if(this.mRightGlow != null) {
            return;
        }

        EdgeEffect v0 = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
        this.mRightGlow = v0;
        if(this.mClipToPadding) {
            v0.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
            return;
        }

        v0.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
    }

    void ensureTopGlow() {
        if(this.mTopGlow != null) {
            return;
        }

        EdgeEffect v0 = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
        this.mTopGlow = v0;
        if(this.mClipToPadding) {
            v0.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
            return;
        }

        v0.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + this.getContext();
    }

    final void fillRemainingScrollValues(State arg3) {
        if(this.getScrollState() == 2) {
            OverScroller v2 = this.mViewFlinger.mOverScroller;
            arg3.mRemainingScrollHorizontal = v2.getFinalX() - v2.getCurrX();
            arg3.mRemainingScrollVertical = v2.getFinalY() - v2.getCurrY();
            return;
        }

        arg3.mRemainingScrollHorizontal = 0;
        arg3.mRemainingScrollVertical = 0;
    }

    public View findChildViewUnder(float arg6, float arg7) {
        int v0;
        for(v0 = this.mChildHelper.getChildCount() - 1; v0 >= 0; --v0) {
            View v1 = this.mChildHelper.getChildAt(v0);
            float v2 = v1.getTranslationX();
            float v3 = v1.getTranslationY();
            if(arg6 >= (((float)v1.getLeft())) + v2 && arg6 <= (((float)v1.getRight())) + v2 && arg7 >= (((float)v1.getTop())) + v3 && arg7 <= (((float)v1.getBottom())) + v3) {
                return v1;
            }
        }

        return null;
    }

    public View findContainingItemView(View arg3) {
        ViewParent v3;
        ViewParent v0;
        for(v0 = arg3.getParent(); v0 != null; v0 = ((View)v3).getParent()) {
            if((((RecyclerView)v0)) == this) {
                break;
            }

            if(!(v0 instanceof View)) {
                break;
            }

            v3 = v0;
        }

        if((((RecyclerView)v0)) == this) {
            return ((View)v3);
        }

        return null;
    }

    public ViewHolder findContainingViewHolder(View arg1) {
        arg1 = this.findContainingItemView(arg1);
        if(arg1 == null) {
            return null;
        }

        return this.getChildViewHolder(arg1);
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent arg7) {
        int v0 = arg7.getAction();
        int v1 = this.mOnItemTouchListeners.size();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            Object v4 = this.mOnItemTouchListeners.get(v3);
            if((((OnItemTouchListener)v4).onInterceptTouchEvent(this, arg7)) && v0 != 3) {
                this.mInterceptingOnItemTouchListener = ((OnItemTouchListener)v4);
                return 1;
            }
        }

        return 0;
    }

    private void findMinMaxChildLayoutPositions(int[] arg9) {
        int v0 = this.mChildHelper.getChildCount();
        if(v0 == 0) {
            arg9[0] = -1;
            arg9[1] = -1;
            return;
        }

        int v3 = 0x7FFFFFFF;
        int v4 = 0x80000000;
        int v5;
        for(v5 = 0; v5 < v0; ++v5) {
            ViewHolder v6 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(v5));
            if(v6.shouldIgnore()) {
            }
            else {
                int v6_1 = v6.getLayoutPosition();
                if(v6_1 < v3) {
                    v3 = v6_1;
                }

                if(v6_1 <= v4) {
                    goto label_24;
                }

                v4 = v6_1;
            }

        label_24:
        }

        arg9[0] = v3;
        arg9[1] = v4;
    }

    static RecyclerView findNestedRecyclerView(View arg4) {
        RecyclerView v1 = null;
        if(!(arg4 instanceof ViewGroup)) {
            return v1;
        }

        if((arg4 instanceof RecyclerView)) {
            return arg4;
        }

        int v0 = ((ViewGroup)arg4).getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            RecyclerView v3 = RecyclerView.findNestedRecyclerView(((ViewGroup)arg4).getChildAt(v2));
            if(v3 != null) {
                return v3;
            }
        }

        return v1;
    }

    private View findNextViewToFocus() {
        View v1_1;
        int v0 = this.mState.mFocusedItemPosition != -1 ? this.mState.mFocusedItemPosition : 0;
        int v1 = this.mState.getItemCount();
        int v2 = v0;
        while(v2 < v1) {
            ViewHolder v3 = this.findViewHolderForAdapterPosition(v2);
            if(v3 == null) {
            }
            else if(v3.itemView.hasFocusable()) {
                return v3.itemView;
            }
            else {
                ++v2;
                continue;
            }

            break;
        }

        for(v0 = Math.min(v1, v0) - 1; true; --v0) {
            v1_1 = null;
            if(v0 < 0) {
                return v1_1;
            }

            ViewHolder v2_1 = this.findViewHolderForAdapterPosition(v0);
            if(v2_1 == null) {
                return v1_1;
            }

            if(v2_1.itemView.hasFocusable()) {
                return v2_1.itemView;
            }
        }

        return v1_1;
    }

    public ViewHolder findViewHolderForAdapterPosition(int arg6) {
        ViewHolder v1 = null;
        if(this.mDataSetHasChangedAfterLayout) {
            return v1;
        }

        int v0 = this.mChildHelper.getUnfilteredChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            ViewHolder v3 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(v2));
            if(v3 != null && !v3.isRemoved() && this.getAdapterPositionFor(v3) == arg6) {
                if(this.mChildHelper.isHidden(v3.itemView)) {
                    v1 = v3;
                }
                else {
                    return v3;
                }
            }
        }

        return v1;
    }

    public ViewHolder findViewHolderForItemId(long arg7) {
        Adapter v0 = this.mAdapter;
        ViewHolder v1 = null;
        if(v0 != null) {
            if(!v0.hasStableIds()) {
            }
            else {
                int v0_1 = this.mChildHelper.getUnfilteredChildCount();
                int v2;
                for(v2 = 0; v2 < v0_1; ++v2) {
                    ViewHolder v3 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(v2));
                    if(v3 != null && !v3.isRemoved() && v3.getItemId() == arg7) {
                        if(this.mChildHelper.isHidden(v3.itemView)) {
                            v1 = v3;
                        }
                        else {
                            return v3;
                        }
                    }
                }
            }
        }

        return v1;
    }

    public ViewHolder findViewHolderForLayoutPosition(int arg2) {
        return this.findViewHolderForPosition(arg2, false);
    }

    ViewHolder findViewHolderForPosition(int arg6, boolean arg7) {
        int v0 = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder v1 = null;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            ViewHolder v3 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(v2));
            if(v3 != null && !v3.isRemoved()) {
                if(arg7) {
                    if(v3.mPosition != arg6) {
                        goto label_25;
                    }
                }
                else if(v3.getLayoutPosition() != arg6) {
                    goto label_25;
                }

                if(this.mChildHelper.isHidden(v3.itemView)) {
                    v1 = v3;
                    goto label_25;
                }

                return v3;
            }

        label_25:
        }

        return v1;
    }

    @Deprecated public ViewHolder findViewHolderForPosition(int arg2) {
        return this.findViewHolderForPosition(arg2, false);
    }

    public boolean fling(int arg8, int arg9) {
        int v0_2;
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return 0;
        }

        if(this.mLayoutSuppressed) {
            return 0;
        }

        boolean v0_1 = v0.canScrollHorizontally();
        boolean v2 = this.mLayout.canScrollVertically();
        if(0 == 0 && 0 == 0) {
            return 0;
        }

        float v3 = ((float)0);
        float v4 = ((float)0);
        if(!this.dispatchNestedPreFling(v3, v4)) {
            boolean v6 = (v0_1) || (v2) ? true : false;
            this.dispatchNestedFling(v3, v4, v6);
            OnFlingListener v3_1 = this.mOnFlingListener;
            if(v3_1 != null && (v3_1.onFling(0, 0))) {
                return 1;
            }

            if(!v6) {
                return 0;
            }

            if(v2) {
                v0_2 = (((int)v0_1)) | 2;
            }

            this.startNestedScroll(v0_2, 1);
            this.mViewFlinger.fling(Math.max(-this.mMaxFlingVelocity, Math.min(0, this.mMaxFlingVelocity)), Math.max(-this.mMaxFlingVelocity, Math.min(0, this.mMaxFlingVelocity)));
            return 1;
        }

        return 0;
    }

    public View focusSearch(View arg9, int arg10) {
        int v6;
        View v0 = this.mLayout.onInterceptFocusSearch(arg9, arg10);
        if(v0 != null) {
            return v0;
        }

        int v1 = 1;
        int v0_1 = this.mAdapter == null || this.mLayout == null || (this.isComputingLayout()) || (this.mLayoutSuppressed) ? 0 : 1;
        FocusFinder v3 = FocusFinder.getInstance();
        View v4 = null;
        if(v0_1 != 0) {
            int v5 = 2;
            if(arg10 != v5 && arg10 != 1) {
                goto label_80;
            }

            if(this.mLayout.canScrollVertically()) {
                v0_1 = arg10 == v5 ? 130 : 33;
                v6 = v3.findNextFocus(((ViewGroup)this), arg9, v0_1) == null ? 1 : 0;
                if(!RecyclerView.FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    goto label_40;
                }

                arg10 = v0_1;
            }
            else {
                v6 = 0;
            }

        label_40:
            if(v6 == 0 && (this.mLayout.canScrollHorizontally())) {
                v0_1 = this.mLayout.getLayoutDirection() == 1 ? 1 : 0;
                v5 = arg10 == v5 ? 1 : 0;
                v0_1 = (v0_1 ^ v5) != 0 ? 66 : 17;
                if(v3.findNextFocus(((ViewGroup)this), arg9, v0_1) == null) {
                }
                else {
                    v1 = 0;
                }

                if(RecyclerView.FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    arg10 = v0_1;
                }

                v6 = v1;
            }

            if(v6 != 0) {
                this.consumePendingUpdateOperations();
                if(this.findContainingItemView(arg9) == null) {
                    return v4;
                }
                else {
                    this.startInterceptRequestLayout();
                    this.mLayout.onFocusSearchFailed(arg9, arg10, this.mRecycler, this.mState);
                    this.stopInterceptRequestLayout(false);
                }
            }

            v0 = v3.findNextFocus(((ViewGroup)this), arg9, arg10);
        }
        else {
        label_80:
            View v1_1 = v3.findNextFocus(((ViewGroup)this), arg9, arg10);
            if(v1_1 == null && v0_1 != 0) {
                this.consumePendingUpdateOperations();
                if(this.findContainingItemView(arg9) == null) {
                    return v4;
                }
                else {
                    this.startInterceptRequestLayout();
                    v0 = this.mLayout.onFocusSearchFailed(arg9, arg10, this.mRecycler, this.mState);
                    this.stopInterceptRequestLayout(false);
                    goto label_95;
                }
            }

            v0 = v1_1;
        }

    label_95:
        if(v0 != null && !v0.hasFocusable()) {
            if(this.getFocusedChild() == null) {
                return super.focusSearch(arg9, arg10);
            }
            else {
                this.requestChildOnScreen(v0, v4);
                return arg9;
            }
        }

        if(this.isPreferredNextFocus(arg9, v0, arg10)) {
            return v0;
        }

        return super.focusSearch(arg9, arg10);
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        LayoutManager v0 = this.mLayout;
        if(v0 != null) {
            return v0.generateDefaultLayoutParams();
        }

        throw new IllegalStateException("RecyclerView has no LayoutManager" + this.exceptionLabel());
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg3) {
        LayoutManager v0 = this.mLayout;
        if(v0 != null) {
            return v0.generateLayoutParams(this.getContext(), arg3);
        }

        throw new IllegalStateException("RecyclerView has no LayoutManager" + this.exceptionLabel());
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg3) {
        LayoutManager v0 = this.mLayout;
        if(v0 != null) {
            return v0.generateLayoutParams(arg3);
        }

        throw new IllegalStateException("RecyclerView has no LayoutManager" + this.exceptionLabel());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionFor(ViewHolder arg2) {
        if(!arg2.hasAnyOfTheFlags(0x20C)) {
            if(!arg2.isBound()) {
            }
            else {
                return this.mAdapterHelper.applyPendingUpdatesToPosition(arg2.mPosition);
            }
        }

        return -1;
    }

    public int getBaseline() {
        LayoutManager v0 = this.mLayout;
        if(v0 != null) {
            return v0.getBaseline();
        }

        return super.getBaseline();
    }

    long getChangedHolderKey(ViewHolder arg1) {
        if(this.mAdapter.hasStableIds()) {
            return arg1.getItemId();
        }

        return ((long)arg1.mPosition);
    }

    public int getChildAdapterPosition(View arg1) {
        ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg1);
        if(v0 != null) {
            return v0.getAdapterPosition();
        }

        return -1;
    }

    protected int getChildDrawingOrder(int arg2, int arg3) {
        ChildDrawingOrderCallback v0 = this.mChildDrawingOrderCallback;
        if(v0 == null) {
            return super.getChildDrawingOrder(arg2, arg3);
        }

        return v0.onGetChildDrawingOrder(arg2, arg3);
    }

    public long getChildItemId(View arg3) {
        Adapter v2 = this.mAdapter;
        long v0 = -1;
        if(v2 != null) {
            if(!v2.hasStableIds()) {
            }
            else {
                ViewHolder v2_1 = RecyclerView.getChildViewHolderInt(arg3);
                if(v2_1 != null) {
                    return v2_1.getItemId();
                }
            }
        }

        return v0;
    }

    public int getChildLayoutPosition(View arg1) {
        ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg1);
        if(v0 != null) {
            return v0.getLayoutPosition();
        }

        return -1;
    }

    @Deprecated public int getChildPosition(View arg1) {
        return this.getChildAdapterPosition(arg1);
    }

    public ViewHolder getChildViewHolder(View arg4) {
        ViewParent v0 = arg4.getParent();
        if(v0 != null) {
            if((((RecyclerView)v0)) == this) {
            }
            else {
                throw new IllegalArgumentException("View " + arg4 + " is not a direct child of " + this);
            }
        }

        return RecyclerView.getChildViewHolderInt(arg4);
    }

    static ViewHolder getChildViewHolderInt(View arg0) {
        if(arg0 == null) {
            return null;
        }

        return arg0.getLayoutParams().mViewHolder;
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View arg1, Rect arg2) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(arg1, arg2);
    }

    static void getDecoratedBoundsWithMarginsInt(View arg6, Rect arg7) {
        ViewGroup$LayoutParams v0 = arg6.getLayoutParams();
        arg7.set(arg6.getLeft() - ((LayoutParams)v0).mDecorInsets.left - ((LayoutParams)v0).leftMargin, arg6.getTop() - ((LayoutParams)v0).mDecorInsets.top - ((LayoutParams)v0).topMargin, arg6.getRight() + ((LayoutParams)v0).mDecorInsets.right + ((LayoutParams)v0).rightMargin, arg6.getBottom() + ((LayoutParams)v0).mDecorInsets.bottom + ((LayoutParams)v0).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View arg3) {
        int v2;
        for(v2 = arg3.getId(); !arg3.isFocused(); v2 = arg3.getId()) {
            if(!(arg3 instanceof ViewGroup)) {
                return v2;
            }

            if(!arg3.hasFocus()) {
                return v2;
            }

            arg3 = ((ViewGroup)arg3).getFocusedChild();
            if(arg3.getId() == -1) {
                continue;
            }
        }

        return v2;
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    private String getFullClassName(Context arg2, String arg3) {
        char v0 = '.';
        if(arg3.charAt(0) == v0) {
            return arg2.getPackageName() + arg3;
        }

        if(arg3.contains(".")) {
            return arg3;
        }

        return RecyclerView.class.getPackage().getName() + v0 + arg3;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View arg9) {
        ViewGroup$LayoutParams v0 = arg9.getLayoutParams();
        if(!((LayoutParams)v0).mInsetsDirty) {
            return ((LayoutParams)v0).mDecorInsets;
        }

        if((this.mState.isPreLayout()) && ((((LayoutParams)v0).isItemChanged()) || (((LayoutParams)v0).isViewInvalid()))) {
            return ((LayoutParams)v0).mDecorInsets;
        }

        Rect v1 = ((LayoutParams)v0).mDecorInsets;
        v1.set(0, 0, 0, 0);
        int v3 = this.mItemDecorations.size();
        int v4;
        for(v4 = 0; v4 < v3; ++v4) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(v4).getItemOffsets(this.mTempRect, arg9, this, this.mState);
            v1.left += this.mTempRect.left;
            v1.top += this.mTempRect.top;
            v1.right += this.mTempRect.right;
            v1.bottom += this.mTempRect.bottom;
        }

        ((LayoutParams)v0).mInsetsDirty = false;
        return v1;
    }

    public ItemDecoration getItemDecorationAt(int arg3) {
        int v0 = this.getItemDecorationCount();
        if(arg3 >= 0 && arg3 < v0) {
            return this.mItemDecorations.get(arg3);
        }

        throw new IndexOutOfBoundsException(arg3 + " is an invalid index for size " + v0);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    long getNanoTime() {
        if(RecyclerView.ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }

        return 0;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        NestedScrollingChildHelper v0 = this.mScrollingChildHelper;
        if(v0 == null) {
            v0 = new NestedScrollingChildHelper(((View)this));
            this.mScrollingChildHelper = v0;
        }

        return v0;
    }

    private void handleMissingPreInfoForChangeError(long arg6, ViewHolder arg8, ViewHolder arg9) {
        int v0 = this.mChildHelper.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            ViewHolder v2 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(v1));
            if(v2 == arg8) {
            }
            else if(this.getChangedHolderKey(v2) == arg6) {
                Adapter v6 = this.mAdapter;
                String v7 = " \n View Holder 2:";
                if(v6 != null && (v6.hasStableIds())) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + v2 + v7 + arg8 + this.exceptionLabel());
                }

                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + v2 + v7 + arg8 + this.exceptionLabel());
            }
        }

        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + arg9 + " cannot be found but it is necessary for " + arg8 + this.exceptionLabel());
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return this.getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasNestedScrollingParent(int arg1) {
        return this.getScrollingChildHelper().hasNestedScrollingParent(arg1);
    }

    public boolean hasPendingAdapterUpdates() {
        if((this.mFirstLayoutComplete) && !this.mDataSetHasChangedAfterLayout) {
            if(this.mAdapterHelper.hasPendingUpdates()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean hasUpdatedView() {
        int v0 = this.mChildHelper.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            ViewHolder v3 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(v2));
            if(v3 != null) {
                if(v3.shouldIgnore()) {
                }
                else if(v3.isUpdated()) {
                    return 1;
                }
            }
        }

        return 0;
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new androidx.recyclerview.widget.AdapterHelper$Callback() {
            void dispatchUpdate(UpdateOp arg4) {
                int v0 = arg4.cmd;
                if(v0 != 1) {
                    if(v0 != 2) {
                        if(v0 != 4) {
                            if(v0 != 8) {
                                return;
                            }

                            RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, arg4.positionStart, arg4.itemCount, 1);
                            return;
                        }

                        RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, arg4.positionStart, arg4.itemCount, arg4.payload);
                        return;
                    }

                    RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, arg4.positionStart, arg4.itemCount);
                    return;
                }

                RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, arg4.positionStart, arg4.itemCount);
            }

            public ViewHolder findViewHolder(int arg3) {
                ViewHolder v3 = RecyclerView.this.findViewHolderForPosition(arg3, true);
                ViewHolder v0 = null;
                if(v3 == null) {
                    return v0;
                }

                if(RecyclerView.this.mChildHelper.isHidden(v3.itemView)) {
                    return v0;
                }

                return v3;
            }

            public void markViewHoldersUpdated(int arg2, int arg3, Object arg4) {
                RecyclerView.this.viewRangeUpdate(arg2, arg3, arg4);
                RecyclerView.this.mItemsChanged = true;
            }

            public void offsetPositionsForAdd(int arg2, int arg3) {
                RecyclerView.this.offsetPositionRecordsForInsert(arg2, arg3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForMove(int arg2, int arg3) {
                RecyclerView.this.offsetPositionRecordsForMove(arg2, arg3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForRemovingInvisible(int arg3, int arg4) {
                RecyclerView.this.offsetPositionRecordsForRemove(arg3, arg4, true);
                RecyclerView.this.mItemsAddedOrRemoved = true;
                RecyclerView.this.mState.mDeletedInvisibleItemCountSincePreviousLayout += arg4;
            }

            public void offsetPositionsForRemovingLaidOutOrNewView(int arg3, int arg4) {
                RecyclerView.this.offsetPositionRecordsForRemove(arg3, arg4, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void onDispatchFirstPass(UpdateOp arg1) {
                this.dispatchUpdate(arg1);
            }

            public void onDispatchSecondPass(UpdateOp arg1) {
                this.dispatchUpdate(arg1);
            }
        });
    }

    private void initAutofill() {
        if(ViewCompat.getImportantForAutofill(((View)this)) == 0) {
            ViewCompat.setImportantForAutofill(((View)this), 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new androidx.recyclerview.widget.ChildHelper$Callback() {
            public void addView(View arg2, int arg3) {
                RecyclerView.this.addView(arg2, arg3);
                RecyclerView.this.dispatchChildAttached(arg2);
            }

            public void attachViewToParent(View arg3, int arg4, ViewGroup$LayoutParams arg5) {
                ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg3);
                if(v0 != null) {
                    if(!v0.isTmpDetached()) {
                        if(v0.shouldIgnore()) {
                        }
                        else {
                            throw new IllegalArgumentException("Called attach on a child which is not detached: " + v0 + RecyclerView.this.exceptionLabel());
                        }
                    }

                    v0.clearTmpDetachFlag();
                }

                RecyclerView.this.attachViewToParent(arg3, arg4, arg5);
            }

            public void detachViewFromParent(int arg4) {
                View v0 = this.getChildAt(arg4);
                if(v0 != null) {
                    ViewHolder v0_1 = RecyclerView.getChildViewHolderInt(v0);
                    if(v0_1 != null) {
                        if(v0_1.isTmpDetached()) {
                            if(v0_1.shouldIgnore()) {
                            }
                            else {
                                throw new IllegalArgumentException("called detach on an already detached child " + v0_1 + RecyclerView.this.exceptionLabel());
                            }
                        }

                        v0_1.addFlags(0x100);
                    }
                }

                RecyclerView.this.detachViewFromParent(arg4);
            }

            public View getChildAt(int arg1) {
                return RecyclerView.this.getChildAt(arg1);
            }

            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public ViewHolder getChildViewHolder(View arg1) {
                return RecyclerView.getChildViewHolderInt(arg1);
            }

            public int indexOfChild(View arg1) {
                return RecyclerView.this.indexOfChild(arg1);
            }

            public void onEnteredHiddenState(View arg1) {
                ViewHolder v1 = RecyclerView.getChildViewHolderInt(arg1);
                if(v1 != null) {
                    v1.onEnteredHiddenState(RecyclerView.this);
                }
            }

            public void onLeftHiddenState(View arg1) {
                ViewHolder v1 = RecyclerView.getChildViewHolderInt(arg1);
                if(v1 != null) {
                    v1.onLeftHiddenState(RecyclerView.this);
                }
            }

            public void removeAllViews() {
                int v0 = this.getChildCount();
                int v1;
                for(v1 = 0; v1 < v0; ++v1) {
                    View v2 = this.getChildAt(v1);
                    RecyclerView.this.dispatchChildDetached(v2);
                    v2.clearAnimation();
                }

                RecyclerView.this.removeAllViews();
            }

            public void removeViewAt(int arg3) {
                View v0 = RecyclerView.this.getChildAt(arg3);
                if(v0 != null) {
                    RecyclerView.this.dispatchChildDetached(v0);
                    v0.clearAnimation();
                }

                RecyclerView.this.removeViewAt(arg3);
            }
        });
    }

    void initFastScroller(StateListDrawable arg11, Drawable arg12, StateListDrawable arg13, Drawable arg14) {
        if(arg11 != null && arg12 != null && arg13 != null && arg14 != null) {
            Resources v0 = this.getContext().getResources();
            new FastScroller(this, arg11, arg12, arg13, arg14, v0.getDimensionPixelSize(dimen.fastscroll_default_thickness), v0.getDimensionPixelSize(dimen.fastscroll_minimum_range), v0.getDimensionPixelOffset(dimen.fastscroll_margin));
            return;
        }

        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + this.exceptionLabel());
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if(this.mItemDecorations.size() == 0) {
            return;
        }

        LayoutManager v0 = this.mLayout;
        if(v0 != null) {
            v0.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }

        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager v0 = this.mAccessibilityManager;
        if(v0 != null && (v0.isEnabled())) {
            return 1;
        }

        return 0;
    }

    public boolean isAnimating() {
        ItemAnimator v0 = this.mItemAnimator;
        if(v0 != null && (v0.isRunning())) {
            return 1;
        }

        return 0;
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if(this.mLayoutOrScrollCounter > 0) {
            return 1;
        }

        return 0;
    }

    @Deprecated public boolean isLayoutFrozen() {
        return this.isLayoutSuppressed();
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public boolean isNestedScrollingEnabled() {
        return this.getScrollingChildHelper().isNestedScrollingEnabled();
    }

    private boolean isPreferredNextFocus(View arg6, View arg7, int arg8) {
        int v2;
        if(arg7 != null) {
            if((((RecyclerView)arg7)) == this) {
            }
            else if(this.findContainingItemView(arg7) == null) {
                return 0;
            }
            else if(arg6 == null) {
                return 1;
            }
            else if(this.findContainingItemView(arg6) == null) {
                return 1;
            }
            else {
                this.mTempRect.set(0, 0, arg6.getWidth(), arg6.getHeight());
                this.mTempRect2.set(0, 0, arg7.getWidth(), arg7.getHeight());
                this.offsetDescendantRectToMyCoords(arg6, this.mTempRect);
                this.offsetDescendantRectToMyCoords(arg7, this.mTempRect2);
                int v7 = -1;
                int v6 = this.mLayout.getLayoutDirection() == 1 ? v7 : 1;
                if(this.mTempRect.left >= this.mTempRect2.left && this.mTempRect.right > this.mTempRect2.left) {
                    goto label_49;
                }
                else if(this.mTempRect.right < this.mTempRect2.right) {
                    v2 = 1;
                }
                else {
                label_49:
                    if((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) {
                        v2 = v7;
                        goto label_67;
                    }

                    v2 = 0;
                }

            label_67:
                if(this.mTempRect.top >= this.mTempRect2.top && this.mTempRect.bottom > this.mTempRect2.top) {
                    goto label_84;
                }
                else if(this.mTempRect.bottom < this.mTempRect2.bottom) {
                    v7 = 1;
                }
                else {
                label_84:
                    if((this.mTempRect.bottom > this.mTempRect2.bottom || this.mTempRect.top >= this.mTempRect2.bottom) && this.mTempRect.top > this.mTempRect2.top) {
                        goto label_101;
                    }

                    v7 = 0;
                }

            label_101:
                if(arg8 != 1) {
                    if(arg8 != 2) {
                        if(arg8 != 17) {
                            if(arg8 != 33) {
                                if(arg8 != 66) {
                                    if(arg8 == 130) {
                                        if(v7 > 0) {
                                            return 1;
                                        }

                                        return 0;
                                    }

                                    throw new IllegalArgumentException("Invalid direction: " + arg8 + this.exceptionLabel());
                                }

                                if(v2 > 0) {
                                    return 1;
                                }

                                return 0;
                            }

                            if(v7 < 0) {
                                return 1;
                            }

                            return 0;
                        }

                        if(v2 < 0) {
                            return 1;
                        }

                        return 0;
                    }

                    if(v7 <= 0 && (v7 != 0 || v2 * v6 < 0)) {
                        return 0;
                    }

                    return 1;
                }

                if(v7 >= 0 && (v7 != 0 || v2 * v6 > 0)) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    void jumpToPositionForSmoothScroller(int arg2) {
        if(this.mLayout == null) {
            return;
        }

        this.setScrollState(2);
        this.mLayout.scrollToPosition(arg2);
        this.awakenScrollBars();
    }

    void markItemDecorInsetsDirty() {
        int v0 = this.mChildHelper.getUnfilteredChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mChildHelper.getUnfilteredChildAt(v1).getLayoutParams().mInsetsDirty = true;
        }

        this.mRecycler.markItemDecorInsetsDirty();
    }

    void markKnownViewsInvalid() {
        int v0 = this.mChildHelper.getUnfilteredChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            ViewHolder v2 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(v1));
            if(v2 != null && !v2.shouldIgnore()) {
                v2.addFlags(6);
            }
        }

        this.markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void offsetChildrenHorizontal(int arg4) {
        int v0 = this.mChildHelper.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mChildHelper.getChildAt(v1).offsetLeftAndRight(arg4);
        }
    }

    public void offsetChildrenVertical(int arg4) {
        int v0 = this.mChildHelper.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mChildHelper.getChildAt(v1).offsetTopAndBottom(arg4);
        }
    }

    void offsetPositionRecordsForInsert(int arg6, int arg7) {
        int v0 = this.mChildHelper.getUnfilteredChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            ViewHolder v3 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(v2));
            if(v3 != null && !v3.shouldIgnore() && v3.mPosition >= arg6) {
                v3.offsetPosition(arg7, false);
                this.mState.mStructureChanged = true;
            }
        }

        this.mRecycler.offsetPositionRecordsForInsert(arg6, arg7);
        this.requestLayout();
    }

    void offsetPositionRecordsForMove(int arg10, int arg11) {
        int v4;
        int v3;
        int v2;
        int v0 = this.mChildHelper.getUnfilteredChildCount();
        if(arg10 < arg11) {
            v2 = -1;
            v3 = arg10;
            v4 = arg11;
        }
        else {
            v4 = arg10;
            v3 = arg11;
            v2 = 1;
        }

        int v6;
        for(v6 = 0; v6 < v0; ++v6) {
            ViewHolder v7 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(v6));
            if(v7 != null && v7.mPosition >= v3) {
                if(v7.mPosition > v4) {
                }
                else {
                    if(v7.mPosition == arg10) {
                        v7.offsetPosition(arg11 - arg10, false);
                    }
                    else {
                        v7.offsetPosition(v2, false);
                    }

                    this.mState.mStructureChanged = true;
                }
            }
        }

        this.mRecycler.offsetPositionRecordsForMove(arg10, arg11);
        this.requestLayout();
    }

    void offsetPositionRecordsForRemove(int arg8, int arg9, boolean arg10) {
        int v0 = arg8 + arg9;
        int v1 = this.mChildHelper.getUnfilteredChildCount();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            ViewHolder v3 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(v2));
            if(v3 != null && !v3.shouldIgnore()) {
                if(v3.mPosition >= v0) {
                    v3.offsetPosition(-arg9, arg10);
                    this.mState.mStructureChanged = true;
                }
                else if(v3.mPosition >= arg8) {
                    v3.flagRemovedAndOffsetPosition(arg8 - 1, -arg9, arg10);
                    this.mState.mStructureChanged = true;
                }
            }
        }

        this.mRecycler.offsetPositionRecordsForRemove(arg8, arg9, arg10);
        this.requestLayout();
    }

    protected void onAttachedToWindow() {
        float v0_2;
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean v1 = true;
        this.mIsAttached = true;
        if(!this.mFirstLayoutComplete || (this.isLayoutRequested())) {
            v1 = false;
        }
        else {
        }

        this.mFirstLayoutComplete = v1;
        LayoutManager v1_1 = this.mLayout;
        if(v1_1 != null) {
            v1_1.dispatchAttachedToWindow(this);
        }

        this.mPostedAnimatorRunner = false;
        if(RecyclerView.ALLOW_THREAD_GAP_WORK) {
            Object v0 = GapWorker.sGapWorker.get();
            this.mGapWorker = ((GapWorker)v0);
            if(v0 == null) {
                this.mGapWorker = new GapWorker();
                Display v0_1 = ViewCompat.getDisplay(((View)this));
                if((this.isInEditMode()) || v0_1 == null) {
                label_33:
                    v0_2 = 60f;
                }
                else {
                    v0_2 = v0_1.getRefreshRate();
                    if(v0_2 >= 30f) {
                    }
                    else {
                        goto label_33;
                    }
                }

                this.mGapWorker.mFrameIntervalNs = ((long)(1000000000f / v0_2));
                GapWorker.sGapWorker.set(this.mGapWorker);
            }

            this.mGapWorker.add(this);
        }
    }

    public void onChildAttachedToWindow(View arg1) {
    }

    public void onChildDetachedFromWindow(View arg1) {
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator v0 = this.mItemAnimator;
        if(v0 != null) {
            v0.endAnimations();
        }

        this.stopScroll();
        this.mIsAttached = false;
        LayoutManager v0_1 = this.mLayout;
        if(v0_1 != null) {
            v0_1.dispatchDetachedFromWindow(this, this.mRecycler);
        }

        this.mPendingAccessibilityImportanceChange.clear();
        this.removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        if(RecyclerView.ALLOW_THREAD_GAP_WORK) {
            GapWorker v0_2 = this.mGapWorker;
            if(v0_2 != null) {
                v0_2.remove(this);
                this.mGapWorker = null;
            }
        }
    }

    public void onDraw(Canvas arg5) {
        super.onDraw(arg5);
        int v0 = this.mItemDecorations.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mItemDecorations.get(v1).onDraw(arg5, this, this.mState);
        }
    }

    void onEnterLayoutOrScroll() {
        ++this.mLayoutOrScrollCounter;
    }

    void onExitLayoutOrScroll(boolean arg3) {
        int v0 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = v0;
        if(v0 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if(arg3) {
                this.dispatchContentChangedIfNecessary();
                this.dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    void onExitLayoutOrScroll() {
        this.onExitLayoutOrScroll(true);
    }

    public boolean onGenericMotionEvent(MotionEvent arg6) {
        float v3;
        float v0;
        if(this.mLayout == null) {
            return 0;
        }

        if(this.mLayoutSuppressed) {
            return 0;
        }

        if(arg6.getAction() == 8) {
            if((arg6.getSource() & 2) != 0) {
                v0 = this.mLayout.canScrollVertically() ? -arg6.getAxisValue(9) : 0f;
                if(!this.mLayout.canScrollHorizontally()) {
                    goto label_28;
                }

                v3 = arg6.getAxisValue(10);
            }
            else {
                if((arg6.getSource() & 0x400000) != 0) {
                    v0 = arg6.getAxisValue(26);
                    if(this.mLayout.canScrollVertically()) {
                        v0 = -v0;
                    label_28:
                        v3 = 0f;
                        goto label_49;
                    }
                    else if(this.mLayout.canScrollHorizontally()) {
                        v3 = v0;
                        v0 = 0f;
                        goto label_49;
                    }
                }

                v0 = 0f;
                v3 = 0f;
            }

        label_49:
            if(v0 == 0f && v3 == 0f) {
                return 0;
            }

            this.scrollByInternal(((int)(v3 * this.mScaledHorizontalScrollFactor)), ((int)(v0 * this.mScaledVerticalScrollFactor)), arg6);
        }

        return 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent arg9) {
        int v9;
        int v0_2;
        if(this.mLayoutSuppressed) {
            return 0;
        }

        this.mInterceptingOnItemTouchListener = null;
        if(this.findInterceptingOnItemTouchListener(arg9)) {
            this.cancelScroll();
            return 1;
        }

        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            return 0;
        }

        boolean v0_1 = v0.canScrollHorizontally();
        boolean v3 = this.mLayout.canScrollVertically();
        VelocityTracker v4 = this.mVelocityTracker;
        if(v4 == null) {
            v4 = VelocityTracker.obtain();
            this.mVelocityTracker = v4;
        }

        v4.addMovement(arg9);
        int v4_1 = arg9.getActionMasked();
        int v5 = arg9.getActionIndex();
        int v6 = 2;
        float v7 = 0.5f;
        if(v4_1 == 0) {
            if(this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }

            this.mScrollPointerId = arg9.getPointerId(0);
            v4_1 = ((int)(arg9.getX() + v7));
            this.mLastTouchX = v4_1;
            this.mInitialTouchX = v4_1;
            v9 = ((int)(arg9.getY() + v7));
            this.mLastTouchY = v9;
            this.mInitialTouchY = v9;
            if(this.mScrollState == v6) {
                this.getParent().requestDisallowInterceptTouchEvent(true);
                this.setScrollState(1);
                this.stopNestedScroll(1);
            }

            int[] v9_1 = this.mNestedOffsets;
            v9_1[1] = 0;
            v9_1[0] = 0;
            if(v3) {
                v0_2 = (((int)v0_1)) | 2;
            }

            this.startNestedScroll(v0_2, 0);
        }
        else if(v4_1 == 1) {
            this.mVelocityTracker.clear();
            this.stopNestedScroll(0);
        }
        else if(v4_1 == v6) {
            v4_1 = arg9.findPointerIndex(this.mScrollPointerId);
            if(v4_1 < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return 0;
            }
            else {
                v5 = ((int)(arg9.getX(v4_1) + v7));
                v9 = ((int)(arg9.getY(v4_1) + v7));
                if(this.mScrollState != 1) {
                    v4_1 = v5 - this.mInitialTouchX;
                    v6 = v9 - this.mInitialTouchY;
                    if(!v0_1 || Math.abs(v4_1) <= this.mTouchSlop) {
                        v0_2 = 0;
                    }
                    else {
                        this.mLastTouchX = v5;
                        v0_2 = 1;
                    }

                    if((v3) && Math.abs(v6) > this.mTouchSlop) {
                        this.mLastTouchY = v9;
                        v0_2 = 1;
                    }

                    if(v0_2 == 0) {
                        goto label_127;
                    }

                    this.setScrollState(1);
                }
            }
        }
        else if(v4_1 == 3) {
            this.cancelScroll();
        }
        else if(v4_1 == 5) {
            this.mScrollPointerId = arg9.getPointerId(v5);
            v0_2 = ((int)(arg9.getX(v5) + v7));
            this.mLastTouchX = v0_2;
            this.mInitialTouchX = v0_2;
            v9 = ((int)(arg9.getY(v5) + v7));
            this.mLastTouchY = v9;
            this.mInitialTouchY = v9;
        }
        else if(v4_1 != 6) {
        }
        else {
            this.onPointerUp(arg9);
        }

    label_127:
        if(this.mScrollState == 1) {
            return 1;
        }

        return 0;
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        TraceCompat.beginSection("RV OnLayout");
        this.dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    protected void onMeasure(int arg7, int arg8) {
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            this.defaultOnMeasure(arg7, arg8);
            return;
        }

        if(v0.isAutoMeasureEnabled()) {
            int v0_1 = View$MeasureSpec.getMode(arg7);
            int v2 = View$MeasureSpec.getMode(arg8);
            this.mLayout.onMeasure(this.mRecycler, this.mState, arg7, arg8);
            int v3 = 0x40000000;
            if(v0_1 == v3 && v2 == v3) {
                return;
            }

            if(this.mAdapter == null) {
            }
            else {
                if(this.mState.mLayoutStep == 1) {
                    this.dispatchLayoutStep1();
                }

                this.mLayout.setMeasureSpecs(arg7, arg8);
                this.mState.mIsMeasuring = true;
                this.dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(arg7, arg8);
                if(!this.mLayout.shouldMeasureTwice()) {
                    return;
                }

                this.mLayout.setMeasureSpecs(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), v3), View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), v3));
                this.mState.mIsMeasuring = true;
                this.dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(arg7, arg8);
            }

            return;
        }

        if(this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, arg7, arg8);
            return;
        }

        if(this.mAdapterUpdateDuringMeasure) {
            this.startInterceptRequestLayout();
            this.onEnterLayoutOrScroll();
            this.processAdapterUpdatesAndSetAnimationFlags();
            this.onExitLayoutOrScroll();
            if(this.mState.mRunPredictiveAnimations) {
                this.mState.mInPreLayout = true;
            }
            else {
                this.mAdapterHelper.consumeUpdatesInOnePass();
                this.mState.mInPreLayout = false;
            }

            this.mAdapterUpdateDuringMeasure = false;
            this.stopInterceptRequestLayout(false);
        }
        else {
            if(!this.mState.mRunPredictiveAnimations) {
                goto label_80;
            }

            this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredHeight());
            return;
        }

    label_80:
        Adapter v0_2 = this.mAdapter;
        State v1 = this.mState;
        v1.mItemCount = v0_2 != null ? v0_2.getItemCount() : 0;
        this.startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, arg7, arg8);
        this.stopInterceptRequestLayout(false);
        this.mState.mInPreLayout = false;
    }

    private void onPointerUp(MotionEvent arg4) {
        int v0 = arg4.getActionIndex();
        if(arg4.getPointerId(v0) == this.mScrollPointerId) {
            v0 = v0 == 0 ? 1 : 0;
            this.mScrollPointerId = arg4.getPointerId(v0);
            int v1 = ((int)(arg4.getX(v0) + 0.5f));
            this.mLastTouchX = v1;
            this.mInitialTouchX = v1;
            int v4 = ((int)(arg4.getY(v0) + 0.5f));
            this.mLastTouchY = v4;
            this.mInitialTouchY = v4;
        }
    }

    protected boolean onRequestFocusInDescendants(int arg2, Rect arg3) {
        if(this.isComputingLayout()) {
            return 0;
        }

        return super.onRequestFocusInDescendants(arg2, arg3);
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        this.mPendingSavedState = ((SavedState)arg2);
        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        if(this.mLayout != null && this.mPendingSavedState.mLayoutState != null) {
            this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v0 = new SavedState(super.onSaveInstanceState());
        SavedState v1 = this.mPendingSavedState;
        if(v1 != null) {
            v0.copyFrom(v1);
            return ((Parcelable)v0);
        }

        LayoutManager v2 = this.mLayout;
        if(v2 != null) {
            v0.mLayoutState = v2.onSaveInstanceState();
            return ((Parcelable)v0);
        }

        v0.mLayoutState = null;
        return ((Parcelable)v0);
    }

    public void onScrollStateChanged(int arg1) {
    }

    public void onScrolled(int arg1, int arg2) {
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        if(arg1 == arg3) {
            if(arg2 != arg4) {
            }
            else {
                return;
            }
        }

        this.invalidateGlows();
    }

    public boolean onTouchEvent(MotionEvent arg17) {
        int[] v1_2;
        int v3_2;
        int v9_1;
        int[] v3;
        RecyclerView v0 = this;
        MotionEvent v6 = arg17;
        int v7 = 0;
        if(!v0.mLayoutSuppressed) {
            if(v0.mIgnoreMotionEventTillDown) {
            }
            else if(this.dispatchToOnItemTouchListeners(arg17)) {
                v0.cancelScroll();
                return 1;
            }
            else {
                LayoutManager v1 = v0.mLayout;
                if(v1 == null) {
                    return 0;
                }
                else {
                    boolean v9 = v1.canScrollHorizontally();
                    boolean v10 = v0.mLayout.canScrollVertically();
                    if(v0.mVelocityTracker == null) {
                        v0.mVelocityTracker = VelocityTracker.obtain();
                    }

                    int v1_1 = v6.getActionMasked();
                    int v2 = v6.getActionIndex();
                    if(v1_1 == 0) {
                        v3 = v0.mNestedOffsets;
                        v3[1] = 0;
                        v3[0] = 0;
                    }

                    MotionEvent v11 = MotionEvent.obtain(v6);
                    v11.offsetLocation(((float)v0.mNestedOffsets[0]), ((float)v0.mNestedOffsets[1]));
                    float v3_1 = 0.5f;
                    if(v1_1 == 0) {
                        v0.mScrollPointerId = v6.getPointerId(0);
                        v1_1 = ((int)(v6.getX() + v3_1));
                        v0.mLastTouchX = v1_1;
                        v0.mInitialTouchX = v1_1;
                        v1_1 = ((int)(v6.getY() + v3_1));
                        v0.mLastTouchY = v1_1;
                        v0.mInitialTouchY = v1_1;
                        if(v10) {
                            v9_1 = (((int)v9)) | 2;
                        }

                        v0.startNestedScroll(v9_1, 0);
                    label_220:
                        v0.mVelocityTracker.addMovement(v11);
                    }
                    else if(v1_1 == 1) {
                        v0.mVelocityTracker.addMovement(v11);
                        v0.mVelocityTracker.computeCurrentVelocity(1000, ((float)v0.mMaxFlingVelocity));
                        float v2_1 = v9 ? -v0.mVelocityTracker.getXVelocity(v0.mScrollPointerId) : 0f;
                        v3_1 = v10 ? -v0.mVelocityTracker.getYVelocity(v0.mScrollPointerId) : 0f;
                        if(v2_1 == 0f && v3_1 == 0f || !v0.fling(((int)v2_1), ((int)v3_1))) {
                            v0.setScrollState(0);
                        }

                        v0.resetScroll();
                    }
                    else if(v1_1 == 2) {
                        v1_1 = v6.findPointerIndex(v0.mScrollPointerId);
                        if(v1_1 < 0) {
                            Log.e("RecyclerView", "Error processing scroll; pointer index for id " + v0.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                            return 0;
                        }
                        else {
                            int v12 = ((int)(v6.getX(v1_1) + v3_1));
                            int v13 = ((int)(v6.getY(v1_1) + v3_1));
                            v1_1 = v0.mLastTouchX - v12;
                            v2 = v0.mLastTouchY - v13;
                            if(v0.mScrollState != 1) {
                                if(v9) {
                                    v3_2 = v0.mTouchSlop;
                                    v1_1 = v1_1 > 0 ? Math.max(0, v1_1 - v3_2) : Math.min(0, v1_1 + v3_2);
                                    if(v1_1 == 0) {
                                        goto label_102;
                                    }

                                    v3_2 = 1;
                                }
                                else {
                                label_102:
                                    v3_2 = 0;
                                }

                                if(v10) {
                                    int v4 = v0.mTouchSlop;
                                    v2 = v2 > 0 ? Math.max(0, v2 - v4) : Math.min(0, v2 + v4);
                                    if(v2 == 0) {
                                        goto label_113;
                                    }

                                    v3_2 = 1;
                                }

                            label_113:
                                if(v3_2 == 0) {
                                    goto label_115;
                                }

                                v0.setScrollState(1);
                            }

                        label_115:
                            int v14 = v1_1;
                            int v15 = v2;
                            if(v0.mScrollState != 1) {
                                goto label_220;
                            }

                            v3 = v0.mReusableIntPair;
                            v3[0] = 0;
                            v3[1] = 0;
                            v1_1 = v9 ? v14 : 0;
                            v2 = v10 ? v15 : 0;
                            if(v0.dispatchNestedPreScroll(v1_1, v2, v3, v0.mScrollOffset, 0)) {
                                v1_2 = v0.mReusableIntPair;
                                v14 -= v1_2[0];
                                v15 -= v1_2[1];
                                v1_2 = v0.mNestedOffsets;
                                v2 = v1_2[0];
                                v3 = v0.mScrollOffset;
                                v1_2[0] = v2 + v3[0];
                                v1_2[1] += v3[1];
                                v0.getParent().requestDisallowInterceptTouchEvent(true);
                            }

                            v1_2 = v0.mScrollOffset;
                            v0.mLastTouchX = v12 - v1_2[0];
                            v0.mLastTouchY = v13 - v1_2[1];
                            v1_1 = v9 ? v14 : 0;
                            if(v10) {
                                v7 = v15;
                            }

                            if(v0.scrollByInternal(v1_1, v7, v6)) {
                                v0.getParent().requestDisallowInterceptTouchEvent(true);
                            }

                            GapWorker v1_3 = v0.mGapWorker;
                            if(v1_3 == null) {
                                goto label_220;
                            }

                            if(v14 == 0 && v15 == 0) {
                                goto label_220;
                            }

                            v1_3.postFromTraversal(v0, v14, v15);
                            goto label_220;
                        }
                    }
                    else if(v1_1 != 3) {
                        if(v1_1 == 5) {
                            v0.mScrollPointerId = v6.getPointerId(v2);
                            v1_1 = ((int)(v6.getX(v2) + v3_1));
                            v0.mLastTouchX = v1_1;
                            v0.mInitialTouchX = v1_1;
                            v1_1 = ((int)(v6.getY(v2) + v3_1));
                            v0.mLastTouchY = v1_1;
                            v0.mInitialTouchY = v1_1;
                        }
                        else if(v1_1 != 6) {
                        }
                        else {
                            this.onPointerUp(arg17);
                        }

                        goto label_220;
                    }
                    else {
                        v0.cancelScroll();
                        goto label_220;
                    }

                    v11.recycle();
                    return 1;
                }
            }
        }

        return 0;
    }

    void postAnimationRunner() {
        if(!this.mPostedAnimatorRunner && (this.mIsAttached)) {
            ViewCompat.postOnAnimation(((View)this), this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        if(this.mItemAnimator != null && (this.mLayout.supportsPredictiveItemAnimations())) {
            return 1;
        }

        return 0;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean v4;
        if(this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            if(this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }

        boolean v0 = this.predictiveItemAnimationsEnabled();
        AdapterHelper v1 = this.mAdapterHelper;
        if(v0) {
            v1.preProcess();
        }
        else {
            v1.consumeUpdatesInOnePass();
        }

        boolean v1_1 = false;
        int v0_1 = (this.mItemsAddedOrRemoved) || (this.mItemsChanged) ? 1 : 0;
        State v3 = this.mState;
        if(!this.mFirstLayoutComplete || this.mItemAnimator == null) {
        label_42:
            v4 = false;
        }
        else {
            if(!this.mDataSetHasChangedAfterLayout && v0_1 == 0 && !this.mLayout.mRequestedSimpleAnimations) {
                goto label_42;
            }

            if((this.mDataSetHasChangedAfterLayout) && !this.mAdapter.hasStableIds()) {
                goto label_42;
            }

            v4 = true;
        }

        v3.mRunSimpleAnimations = v4;
        v3 = this.mState;
        if((v3.mRunSimpleAnimations) && v0_1 != 0 && !this.mDataSetHasChangedAfterLayout && (this.predictiveItemAnimationsEnabled())) {
            v1_1 = true;
        }

        v3.mRunPredictiveAnimations = v1_1;
    }

    void processDataSetCompletelyChanged(boolean arg2) {
        this.mDispatchItemsChangedEvent |= ((int)arg2);
        this.mDataSetHasChangedAfterLayout = true;
        this.markKnownViewsInvalid();
    }

    private void pullGlows(float arg7, float arg8, float arg9, float arg10) {
        int v9;
        float v2 = 1f;
        int v3 = 1;
        if(Float.compare(arg8, 0f) < 0) {
            this.ensureLeftGlow();
            EdgeEffectCompat.onPull(this.mLeftGlow, -arg8 / (((float)this.getWidth())), v2 - arg9 / (((float)this.getHeight())));
            goto label_16;
        }
        else if(arg8 > 0f) {
            this.ensureRightGlow();
            EdgeEffectCompat.onPull(this.mRightGlow, arg8 / (((float)this.getWidth())), arg9 / (((float)this.getHeight())));
        label_16:
            v9 = 1;
        }
        else {
            v9 = 0;
        }

        if(arg10 < 0f) {
            this.ensureTopGlow();
            EdgeEffectCompat.onPull(this.mTopGlow, -arg10 / (((float)this.getHeight())), arg7 / (((float)this.getWidth())));
        }
        else if(arg10 > 0f) {
            this.ensureBottomGlow();
            EdgeEffectCompat.onPull(this.mBottomGlow, arg10 / (((float)this.getHeight())), v2 - arg7 / (((float)this.getWidth())));
        }
        else {
            v3 = v9;
        }

        if(v3 == 0 && arg8 == 0f) {
            if(arg10 != 0f) {
            }
            else {
                return;
            }
        }

        ViewCompat.postInvalidateOnAnimation(((View)this));
    }

    void recordAnimationInfoIfBouncedHiddenView(ViewHolder arg4, ItemHolderInfo arg5) {
        arg4.setFlags(0, 0x2000);
        if((this.mState.mTrackOldChangeHolders) && (arg4.isUpdated()) && !arg4.isRemoved() && !arg4.shouldIgnore()) {
            this.mViewInfoStore.addToOldChangeHolders(this.getChangedHolderKey(arg4), arg4);
        }

        this.mViewInfoStore.addToPreLayout(arg4, arg5);
    }

    private void recoverFocusFromState() {
        if((this.mPreserveFocusAfterLayout) && this.mAdapter != null && (this.hasFocus()) && this.getDescendantFocusability() != 0x60000 && (this.getDescendantFocusability() != 0x20000 || !this.isFocused())) {
            if(!this.isFocused()) {
                View v0 = this.getFocusedChild();
                if((RecyclerView.IGNORE_DETACHED_FOCUSED_CHILD) && (v0.getParent() == null || !v0.hasFocus())) {
                    if(this.mChildHelper.getChildCount() != 0) {
                        goto label_33;
                    }

                    this.requestFocus();
                    return;
                }

                if(this.mChildHelper.isHidden(v0)) {
                    goto label_33;
                }

                return;
            }

        label_33:
            long v2 = -1;
            View v1 = null;
            ViewHolder v0_1 = Long.compare(this.mState.mFocusedItemId, v2) == 0 || !this.mAdapter.hasStableIds() ? ((ViewHolder)v1) : this.findViewHolderForItemId(this.mState.mFocusedItemId);
            if(v0_1 != null && !this.mChildHelper.isHidden(v0_1.itemView) && (v0_1.itemView.hasFocusable())) {
                v1 = v0_1.itemView;
            }
            else if(this.mChildHelper.getChildCount() > 0) {
                v1 = this.findNextViewToFocus();
            }

            if(v1 == null) {
                return;
            }

            if((((long)this.mState.mFocusedSubChildId)) != v2) {
                View v6 = v1.findViewById(this.mState.mFocusedSubChildId);
                if(v6 != null && (v6.isFocusable())) {
                    v1 = v6;
                }
            }

            v1.requestFocus();
        }
    }

    private void releaseGlows() {
        int v0_2;
        boolean v0_1;
        EdgeEffect v0 = this.mLeftGlow;
        if(v0 != null) {
            v0.onRelease();
            v0_1 = this.mLeftGlow.isFinished();
        }
        else {
            v0_2 = 0;
        }

        EdgeEffect v1 = this.mTopGlow;
        if(v1 != null) {
            v1.onRelease();
            v0_2 = (((int)v0_1)) | this.mTopGlow.isFinished();
        }

        v1 = this.mRightGlow;
        if(v1 != null) {
            v1.onRelease();
            v0_2 = (((int)v0_1)) | this.mRightGlow.isFinished();
        }

        v1 = this.mBottomGlow;
        if(v1 != null) {
            v1.onRelease();
            v0_2 = (((int)v0_1)) | this.mBottomGlow.isFinished();
        }

        if(v0_1) {
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    void removeAndRecycleViews() {
        ItemAnimator v0 = this.mItemAnimator;
        if(v0 != null) {
            v0.endAnimations();
        }

        LayoutManager v0_1 = this.mLayout;
        if(v0_1 != null) {
            v0_1.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }

        this.mRecycler.clear();
    }

    boolean removeAnimatingView(View arg3) {
        this.startInterceptRequestLayout();
        boolean v0 = this.mChildHelper.removeViewIfHidden(arg3);
        if(v0) {
            ViewHolder v3 = RecyclerView.getChildViewHolderInt(arg3);
            this.mRecycler.unscrapView(v3);
            this.mRecycler.recycleViewHolderInternal(v3);
        }

        this.stopInterceptRequestLayout((((int)v0)) ^ 1);
        return v0;
    }

    protected void removeDetachedView(View arg3, boolean arg4) {
        ViewHolder v0 = RecyclerView.getChildViewHolderInt(arg3);
        if(v0 != null) {
            if(v0.isTmpDetached()) {
                v0.clearTmpDetachFlag();
            }
            else if(v0.shouldIgnore()) {
            }
            else {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + v0 + this.exceptionLabel());
            }
        }

        arg3.clearAnimation();
        this.dispatchChildDetached(arg3);
        super.removeDetachedView(arg3, arg4);
    }

    public void removeItemDecoration(ItemDecoration arg3) {
        LayoutManager v0 = this.mLayout;
        if(v0 != null) {
            v0.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }

        this.mItemDecorations.remove(arg3);
        if(this.mItemDecorations.isEmpty()) {
            boolean v3 = this.getOverScrollMode() == 2 ? true : false;
            this.setWillNotDraw(v3);
        }

        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }

    public void removeItemDecorationAt(int arg3) {
        int v0 = this.getItemDecorationCount();
        if(arg3 >= 0 && arg3 < v0) {
            this.removeItemDecoration(this.getItemDecorationAt(arg3));
            return;
        }

        throw new IndexOutOfBoundsException(arg3 + " is an invalid index for size " + v0);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener arg1) {
        List v0 = this.mOnChildAttachStateListeners;
        if(v0 == null) {
            return;
        }

        v0.remove(arg1);
    }

    public void removeOnItemTouchListener(OnItemTouchListener arg2) {
        this.mOnItemTouchListeners.remove(arg2);
        if(this.mInterceptingOnItemTouchListener == arg2) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(OnScrollListener arg1) {
        List v0 = this.mScrollListeners;
        if(v0 != null) {
            v0.remove(arg1);
        }
    }

    void repositionShadowingViews() {
        int v0 = this.mChildHelper.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.mChildHelper.getChildAt(v1);
            ViewHolder v3 = this.getChildViewHolder(v2);
            if(v3 != null && v3.mShadowingHolder != null) {
                View v3_1 = v3.mShadowingHolder.itemView;
                int v4 = v2.getLeft();
                int v2_1 = v2.getTop();
                if(v4 == v3_1.getLeft() && v2_1 == v3_1.getTop()) {
                    goto label_23;
                }

                v3_1.layout(v4, v2_1, v3_1.getWidth() + v4, v3_1.getHeight() + v2_1);
            }

        label_23:
        }
    }

    public void requestChildFocus(View arg3, View arg4) {
        if(!this.mLayout.onRequestChildFocus(this, this.mState, arg3, arg4) && arg4 != null) {
            this.requestChildOnScreen(arg3, arg4);
        }

        super.requestChildFocus(arg3, arg4);
    }

    private void requestChildOnScreen(View arg12, View arg13) {
        View v0 = arg13 != null ? arg13 : arg12;
        this.mTempRect.set(0, 0, v0.getWidth(), v0.getHeight());
        ViewGroup$LayoutParams v0_1 = v0.getLayoutParams();
        if(((v0_1 instanceof LayoutParams)) && !((LayoutParams)v0_1).mInsetsDirty) {
            Rect v0_2 = ((LayoutParams)v0_1).mDecorInsets;
            this.mTempRect.left -= v0_2.left;
            this.mTempRect.right += v0_2.right;
            this.mTempRect.top -= v0_2.top;
            this.mTempRect.bottom += v0_2.bottom;
        }

        if(arg13 != null) {
            this.offsetDescendantRectToMyCoords(arg13, this.mTempRect);
            this.offsetRectIntoDescendantCoords(arg12, this.mTempRect);
        }

        LayoutManager v5 = this.mLayout;
        Rect v8 = this.mTempRect;
        int v9 = this.mFirstLayoutComplete ^ 1;
        boolean v10 = arg13 == null ? true : false;
        v5.requestChildRectangleOnScreen(this, arg12, v8, ((boolean)v9), v10);
    }

    public boolean requestChildRectangleOnScreen(View arg2, Rect arg3, boolean arg4) {
        return this.mLayout.requestChildRectangleOnScreen(this, arg2, arg3, arg4);
    }

    public void requestDisallowInterceptTouchEvent(boolean arg4) {
        int v0 = this.mOnItemTouchListeners.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.mOnItemTouchListeners.get(v1).onRequestDisallowInterceptTouchEvent(arg4);
        }

        super.requestDisallowInterceptTouchEvent(arg4);
    }

    public void requestLayout() {
        if(this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
            return;
        }

        this.mLayoutWasDefered = true;
    }

    private void resetFocusInfo() {
        this.mState.mFocusedItemId = -1;
        this.mState.mFocusedItemPosition = -1;
        this.mState.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker v0 = this.mVelocityTracker;
        if(v0 != null) {
            v0.clear();
        }

        this.stopNestedScroll(0);
        this.releaseGlows();
    }

    private void saveFocusInfo() {
        int v2_1;
        ViewHolder v1 = null;
        View v0 = !this.mPreserveFocusAfterLayout || !this.hasFocus() || this.mAdapter == null ? ((View)v1) : this.getFocusedChild();
        if(v0 == null) {
        }
        else {
            v1 = this.findContainingViewHolder(v0);
        }

        if(v1 == null) {
            this.resetFocusInfo();
            return;
        }

        State v0_1 = this.mState;
        long v2 = this.mAdapter.hasStableIds() ? v1.getItemId() : -1;
        v0_1.mFocusedItemId = v2;
        v0_1 = this.mState;
        if(this.mDataSetHasChangedAfterLayout) {
            v2_1 = -1;
        }
        else if(v1.isRemoved()) {
            v2_1 = v1.mOldPosition;
        }
        else {
            v2_1 = v1.getAdapterPosition();
        }

        v0_1.mFocusedItemPosition = v2_1;
        this.mState.mFocusedSubChildId = this.getDeepestFocusedViewWithId(v1.itemView);
    }

    void saveOldPositions() {
        int v0 = this.mChildHelper.getUnfilteredChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            ViewHolder v2 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(v1));
            if(!v2.shouldIgnore()) {
                v2.saveOldPosition();
            }
        }
    }

    public void scrollBy(int arg4, int arg5) {
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }

        if(this.mLayoutSuppressed) {
        }
        else {
            boolean v0_1 = v0.canScrollHorizontally();
            boolean v1 = this.mLayout.canScrollVertically();
            if(!v0_1) {
                if(v1) {
                }
                else {
                    return;
                }
            }

            goto label_23;
        }

        return;
    label_23:
        this.scrollByInternal(0, 0, null);
    }

    boolean scrollByInternal(int arg17, int arg18, MotionEvent arg19) {
        int v1_1;
        int v4;
        int v3;
        int v2;
        RecyclerView v0 = this;
        int v8 = arg17;
        int v9 = arg18;
        MotionEvent v10 = arg19;
        v0.consumePendingUpdateOperations();
        if(v0.mAdapter != null) {
            int[] v1 = v0.mReusableIntPair;
            v1[0] = 0;
            v1[1] = 0;
            v0.scrollStep(v8, v9, v1);
            v1 = v0.mReusableIntPair;
            v2 = v1[0];
            v3 = v8 - v2;
            v4 = v9 - v1[1];
            int v15 = v2;
            v2 = v1[1];
            v1_1 = v15;
        }
        else {
            v1_1 = 0;
            v2 = 0;
            v3 = 0;
            v4 = 0;
        }

        if(!v0.mItemDecorations.isEmpty()) {
            v0.invalidate();
        }

        int[] v7 = v0.mReusableIntPair;
        v7[0] = 0;
        v7[1] = 0;
        v0.dispatchNestedScroll(v1_1, v2, v3, v4, v0.mScrollOffset, 0, v7);
        int[] v5 = v0.mReusableIntPair;
        int v6 = v5[0];
        v3 -= v6;
        int v5_1 = v5[1];
        v4 -= v5_1;
        v5_1 = v6 != 0 || v5_1 != 0 ? 1 : 0;
        v6 = v0.mLastTouchX;
        v7 = v0.mScrollOffset;
        int v13 = v7[0];
        v0.mLastTouchX = v6 - v13;
        v6 = v0.mLastTouchY;
        int v7_1 = v7[1];
        v0.mLastTouchY = v6 - v7_1;
        int[] v6_1 = v0.mNestedOffsets;
        v6_1[0] += v13;
        v6_1[1] += v7_1;
        if(v0.getOverScrollMode() != 2) {
            if(v10 != null && !MotionEventCompat.isFromSource(v10, 0x2002)) {
                v0.pullGlows(v10.getX(), ((float)v3), v10.getY(), ((float)v4));
            }

            this.considerReleasingGlowsOnScroll(arg17, arg18);
        }

        if(v1_1 != 0 || v2 != 0) {
            v0.dispatchOnScrolled(v1_1, v2);
        }

        if(!v0.awakenScrollBars()) {
            v0.invalidate();
        }

        if(v5_1 == 0 && v1_1 == 0) {
            if(v2 != 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    void scrollStep(int arg5, int arg6, int[] arg7) {
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        TraceCompat.beginSection("RV Scroll");
        this.fillRemainingScrollValues(this.mState);
        arg5 = arg5 != 0 ? this.mLayout.scrollHorizontallyBy(arg5, this.mRecycler, this.mState) : 0;
        arg6 = arg6 != 0 ? this.mLayout.scrollVerticallyBy(arg6, this.mRecycler, this.mState) : 0;
        TraceCompat.endSection();
        this.repositionShadowingViews();
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        if(arg7 != null) {
            arg7[0] = arg5;
            arg7[1] = arg6;
        }
    }

    public void scrollTo(int arg1, int arg2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int arg2) {
        if(this.mLayoutSuppressed) {
            return;
        }

        this.stopScroll();
        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }

        v0.scrollToPosition(arg2);
        this.awakenScrollBars();
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent arg2) {
        if(this.shouldDeferAccessibilityEvent(arg2)) {
            return;
        }

        super.sendAccessibilityEventUnchecked(arg2);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate arg1) {
        this.mAccessibilityDelegate = arg1;
        ViewCompat.setAccessibilityDelegate(((View)this), ((AccessibilityDelegateCompat)arg1));
    }

    public void setAdapter(Adapter arg3) {
        this.setLayoutFrozen(false);
        this.setAdapterInternal(arg3, false, true);
        this.processDataSetCompletelyChanged(false);
        this.requestLayout();
    }

    private void setAdapterInternal(Adapter arg3, boolean arg4, boolean arg5) {
        Adapter v0 = this.mAdapter;
        if(v0 != null) {
            v0.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }

        if(!arg4 || (arg5)) {
            this.removeAndRecycleViews();
        }

        this.mAdapterHelper.reset();
        Adapter v5 = this.mAdapter;
        this.mAdapter = arg3;
        if(arg3 != null) {
            arg3.registerAdapterDataObserver(this.mObserver);
            arg3.onAttachedToRecyclerView(this);
        }

        LayoutManager v3 = this.mLayout;
        if(v3 != null) {
            v3.onAdapterChanged(v5, this.mAdapter);
        }

        this.mRecycler.onAdapterChanged(v5, this.mAdapter, arg4);
        this.mState.mStructureChanged = true;
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback arg2) {
        if(arg2 == this.mChildDrawingOrderCallback) {
            return;
        }

        this.mChildDrawingOrderCallback = arg2;
        boolean v2 = arg2 != null ? true : false;
        this.setChildrenDrawingOrderEnabled(v2);
    }

    boolean setChildImportantForAccessibilityInternal(ViewHolder arg2, int arg3) {
        if(this.isComputingLayout()) {
            arg2.mPendingAccessibilityState = arg3;
            this.mPendingAccessibilityImportanceChange.add(arg2);
            return 0;
        }

        ViewCompat.setImportantForAccessibility(arg2.itemView, arg3);
        return 1;
    }

    public void setClipToPadding(boolean arg2) {
        if(arg2 != this.mClipToPadding) {
            this.invalidateGlows();
        }

        this.mClipToPadding = arg2;
        super.setClipToPadding(arg2);
        if(this.mFirstLayoutComplete) {
            this.requestLayout();
        }
    }

    public void setEdgeEffectFactory(EdgeEffectFactory arg1) {
        Preconditions.checkNotNull(arg1);
        this.mEdgeEffectFactory = arg1;
        this.invalidateGlows();
    }

    public void setHasFixedSize(boolean arg1) {
        this.mHasFixedSize = arg1;
    }

    public void setItemAnimator(ItemAnimator arg3) {
        ItemAnimator v0 = this.mItemAnimator;
        if(v0 != null) {
            v0.endAnimations();
            this.mItemAnimator.setListener(null);
        }

        this.mItemAnimator = arg3;
        if(arg3 != null) {
            arg3.setListener(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int arg1) {
        this.mRecycler.setViewCacheSize(arg1);
    }

    @Deprecated public void setLayoutFrozen(boolean arg1) {
        this.suppressLayout(arg1);
    }

    public void setLayoutManager(LayoutManager arg3) {
        if(arg3 == this.mLayout) {
            return;
        }

        this.stopScroll();
        if(this.mLayout != null) {
            ItemAnimator v0 = this.mItemAnimator;
            if(v0 != null) {
                v0.endAnimations();
            }

            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.clear();
            if(this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }

            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        }
        else {
            this.mRecycler.clear();
        }

        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = arg3;
        if(arg3 != null) {
            if(arg3.mRecyclerView == null) {
                this.mLayout.setRecyclerView(this);
                if(this.mIsAttached) {
                    this.mLayout.dispatchAttachedToWindow(this);
                }
            }
            else {
                throw new IllegalArgumentException("LayoutManager " + arg3 + " is already attached to a RecyclerView:" + arg3.mRecyclerView.exceptionLabel());
            }
        }

        this.mRecycler.updateViewCacheSize();
        this.requestLayout();
    }

    @Deprecated public void setLayoutTransition(LayoutTransition arg1) {
        if(arg1 == null) {
            super.setLayoutTransition(null);
            return;
        }

        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean arg1) {
        this.getScrollingChildHelper().setNestedScrollingEnabled(arg1);
    }

    public void setOnFlingListener(OnFlingListener arg1) {
        this.mOnFlingListener = arg1;
    }

    @Deprecated public void setOnScrollListener(OnScrollListener arg1) {
        this.mScrollListener = arg1;
    }

    public void setPreserveFocusAfterLayout(boolean arg1) {
        this.mPreserveFocusAfterLayout = arg1;
    }

    public void setRecycledViewPool(RecycledViewPool arg1) {
        this.mRecycler.setRecycledViewPool(arg1);
    }

    public void setRecyclerListener(RecyclerListener arg1) {
        this.mRecyclerListener = arg1;
    }

    void setScrollState(int arg2) {
        if(arg2 == this.mScrollState) {
            return;
        }

        this.mScrollState = arg2;
        if(arg2 != 2) {
            this.stopScrollersInternal();
        }

        this.dispatchOnScrollStateChanged(arg2);
    }

    public void setScrollingTouchSlop(int arg4) {
        ViewConfiguration v0 = ViewConfiguration.get(this.getContext());
        if(arg4 != 0) {
            if(arg4 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + arg4 + "; using default value");
            }
            else {
                this.mTouchSlop = v0.getScaledPagingTouchSlop();
                return;
            }
        }

        this.mTouchSlop = v0.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension arg1) {
        this.mRecycler.setViewCacheExtension(arg1);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent arg3) {
        int v1 = 0;
        if(this.isComputingLayout()) {
            int v3 = arg3 != null ? AccessibilityEventCompat.getContentChangeTypes(arg3) : 0;
            if(v3 == 0) {
            }
            else {
                v1 = v3;
            }

            this.mEatenAccessibilityChangeFlags |= v1;
            return 1;
        }

        return 0;
    }

    public void smoothScrollBy(int arg2, int arg3) {
        this.smoothScrollBy(arg2, arg3, null);
    }

    public void smoothScrollBy(int arg2, int arg3, Interpolator arg4) {
        this.smoothScrollBy(arg2, arg3, arg4, 0x80000000);
    }

    public void smoothScrollBy(int arg7, int arg8, Interpolator arg9, int arg10) {
        this.smoothScrollBy(arg7, arg8, arg9, arg10, false);
    }

    void smoothScrollBy(int arg3, int arg4, Interpolator arg5, int arg6, boolean arg7) {
        int v1;
        if(this.mLayout == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }

        if(this.mLayoutSuppressed) {
        }
        else {
            v1 = 0;
            if(0 == 0) {
                if(0 != 0) {
                }
                else {
                    return;
                }
            }

            goto label_21;
        }

        return;
    label_21:
        if(arg6 != 0x80000000) {
            if(arg6 > 0) {
            }
            else {
                this.scrollBy(0, 0);
                return;
            }
        }

        if(arg7) {
            if(0 != 0) {
                v1 = 1;
            }

            if(0 != 0) {
                v1 |= 2;
            }

            this.startNestedScroll(v1, 1);
        }

        this.mViewFlinger.smoothScrollBy(0, 0, arg6, arg5);
    }

    public void smoothScrollToPosition(int arg3) {
        if(this.mLayoutSuppressed) {
            return;
        }

        LayoutManager v0 = this.mLayout;
        if(v0 == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }

        v0.smoothScrollToPosition(this, this.mState, arg3);
    }

    void startInterceptRequestLayout() {
        int v0 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = v0;
        if(v0 == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    public boolean startNestedScroll(int arg1, int arg2) {
        return this.getScrollingChildHelper().startNestedScroll(arg1, arg2);
    }

    public boolean startNestedScroll(int arg1) {
        return this.getScrollingChildHelper().startNestedScroll(arg1);
    }

    void stopInterceptRequestLayout(boolean arg5) {
        int v0 = this.mInterceptRequestLayoutDepth;
        if(v0 < 1) {
            this.mInterceptRequestLayoutDepth = 1;
            v0 = 1;
        }

        if(!arg5 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }

        if(v0 == 1) {
            if((arg5) && (this.mLayoutWasDefered) && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                this.dispatchLayout();
            }

            if(this.mLayoutSuppressed) {
                goto label_24;
            }

            this.mLayoutWasDefered = false;
        }

    label_24:
        --this.mInterceptRequestLayoutDepth;
    }

    public void stopNestedScroll(int arg1) {
        this.getScrollingChildHelper().stopNestedScroll(arg1);
    }

    public void stopNestedScroll() {
        this.getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        this.setScrollState(0);
        this.stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager v1 = this.mLayout;
        if(v1 != null) {
            v1.stopSmoothScroller();
        }
    }

    public final void suppressLayout(boolean arg10) {
        if(arg10 != this.mLayoutSuppressed) {
            this.assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if(!arg10) {
                this.mLayoutSuppressed = false;
                if((this.mLayoutWasDefered) && this.mLayout != null && this.mAdapter != null) {
                    this.requestLayout();
                }

                this.mLayoutWasDefered = false;
                return;
            }
            else {
                long v1 = SystemClock.uptimeMillis();
                this.onTouchEvent(MotionEvent.obtain(v1, v1, 3, 0f, 0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                this.stopScroll();
            }
        }
    }

    public void swapAdapter(Adapter arg2, boolean arg3) {
        this.setLayoutFrozen(false);
        this.setAdapterInternal(arg2, true, arg3);
        this.processDataSetCompletelyChanged(true);
        this.requestLayout();
    }

    void viewRangeUpdate(int arg7, int arg8, Object arg9) {
        int v0 = this.mChildHelper.getUnfilteredChildCount();
        int v1 = arg7 + arg8;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = this.mChildHelper.getUnfilteredChildAt(v2);
            ViewHolder v4 = RecyclerView.getChildViewHolderInt(v3);
            if(v4 != null) {
                if(v4.shouldIgnore()) {
                }
                else if(v4.mPosition >= arg7 && v4.mPosition < v1) {
                    v4.addFlags(2);
                    v4.addChangePayload(arg9);
                    v3.getLayoutParams().mInsetsDirty = true;
                }
            }
        }

        this.mRecycler.viewRangeUpdate(arg7, arg8);
    }
}

