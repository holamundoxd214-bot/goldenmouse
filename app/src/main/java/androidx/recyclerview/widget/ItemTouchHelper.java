package androidx.recyclerview.widget;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R$dimen;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends ItemDecoration implements OnChildAttachStateChangeListener {
    class androidx.recyclerview.widget.ItemTouchHelper$1 implements Runnable {
        androidx.recyclerview.widget.ItemTouchHelper$1(ItemTouchHelper arg1) {
            ItemTouchHelper.this = arg1;
            super();
        }

        public void run() {
            if(ItemTouchHelper.this.mSelected != null && (ItemTouchHelper.this.scrollIfNecessary())) {
                if(ItemTouchHelper.this.mSelected != null) {
                    ItemTouchHelper.this.moveIfNecessary(ItemTouchHelper.this.mSelected);
                }

                ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, ((Runnable)this));
            }
        }
    }

    class androidx.recyclerview.widget.ItemTouchHelper$2 implements OnItemTouchListener {
        androidx.recyclerview.widget.ItemTouchHelper$2(ItemTouchHelper arg1) {
            ItemTouchHelper.this = arg1;
            super();
        }

        public boolean onInterceptTouchEvent(RecyclerView arg6, MotionEvent arg7) {
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(arg7);
            int v6 = arg7.getActionMasked();
            if(v6 == 0) {
                ItemTouchHelper.this.mActivePointerId = arg7.getPointerId(0);
                ItemTouchHelper.this.mInitialTouchX = arg7.getX();
                ItemTouchHelper.this.mInitialTouchY = arg7.getY();
                ItemTouchHelper.this.obtainVelocityTracker();
                if(ItemTouchHelper.this.mSelected == null) {
                    RecoverAnimation v6_1 = ItemTouchHelper.this.findAnimation(arg7);
                    if(v6_1 != null) {
                        ItemTouchHelper.this.mInitialTouchX -= v6_1.mX;
                        ItemTouchHelper.this.mInitialTouchY -= v6_1.mY;
                        ItemTouchHelper.this.endRecoverAnimation(v6_1.mViewHolder, true);
                        if(ItemTouchHelper.this.mPendingCleanup.remove(v6_1.mViewHolder.itemView)) {
                            ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, v6_1.mViewHolder);
                        }

                        ItemTouchHelper.this.select(v6_1.mViewHolder, v6_1.mActionState);
                        ItemTouchHelper.this.updateDxDy(arg7, ItemTouchHelper.this.mSelectedFlags, 0);
                    }
                }
            }
            else {
                int v3 = -1;
                if(v6 != 3) {
                    if(v6 == 1) {
                    }
                    else {
                        if(ItemTouchHelper.this.mActivePointerId != v3) {
                            int v2 = arg7.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                            if(v2 >= 0) {
                                ItemTouchHelper.this.checkSelectForSwipe(v6, arg7, v2);
                            }
                            else {
                            }
                        }
                        else {
                        }

                        goto label_77;
                    }
                }

                ItemTouchHelper.this.mActivePointerId = v3;
                ItemTouchHelper.this.select(null, 0);
            }

        label_77:
            if(ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(arg7);
            }

            if(ItemTouchHelper.this.mSelected != null) {
                return 1;
            }

            return 0;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean arg2) {
            if(!arg2) {
                return;
            }

            ItemTouchHelper.this.select(null, 0);
        }

        public void onTouchEvent(RecyclerView arg7, MotionEvent arg8) {
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(arg8);
            if(ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(arg8);
            }

            int v0 = -1;
            if(ItemTouchHelper.this.mActivePointerId == v0) {
            }
            else {
                int v7 = arg8.getActionMasked();
                int v1 = arg8.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                if(v1 >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(v7, arg8, v1);
                }

                ViewHolder v2 = ItemTouchHelper.this.mSelected;
                if(v2 == null) {
                    return;
                }

                int v3 = 0;
                if(v7 != 1) {
                    if(v7 == 2) {
                        if(v1 < 0) {
                            return;
                        }

                        ItemTouchHelper.this.updateDxDy(arg8, ItemTouchHelper.this.mSelectedFlags, v1);
                        ItemTouchHelper.this.moveIfNecessary(v2);
                        ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                        ItemTouchHelper.this.mScrollRunnable.run();
                        ItemTouchHelper.this.mRecyclerView.invalidate();
                        return;
                    }
                    else if(v7 == 3) {
                        if(ItemTouchHelper.this.mVelocityTracker == null) {
                            goto label_74;
                        }

                        ItemTouchHelper.this.mVelocityTracker.clear();
                    }
                    else if(v7 != 6) {
                        return;
                    }
                    else {
                        v7 = arg8.getActionIndex();
                        if(arg8.getPointerId(v7) == ItemTouchHelper.this.mActivePointerId) {
                            if(v7 == 0) {
                                v3 = 1;
                            }

                            ItemTouchHelper.this.mActivePointerId = arg8.getPointerId(v3);
                            ItemTouchHelper.this.updateDxDy(arg8, ItemTouchHelper.this.mSelectedFlags, v7);
                            return;
                        }
                        else {
                            return;
                        }
                    }
                }

                goto label_74;
            }

            return;
        label_74:
            ItemTouchHelper.this.select(null, 0);
            ItemTouchHelper.this.mActivePointerId = v0;
        }
    }

    public abstract class Callback {
        final class androidx.recyclerview.widget.ItemTouchHelper$Callback$1 implements Interpolator {
            androidx.recyclerview.widget.ItemTouchHelper$Callback$1() {
                super();
            }

            public float getInterpolation(float arg1) {
                return arg1 * arg1 * arg1 * arg1 * arg1;
            }
        }

        final class androidx.recyclerview.widget.ItemTouchHelper$Callback$2 implements Interpolator {
            androidx.recyclerview.widget.ItemTouchHelper$Callback$2() {
                super();
            }

            public float getInterpolation(float arg2) {
                --arg2;
                return arg2 * arg2 * arg2 * arg2 * arg2 + 1f;
            }
        }

        private static final int ABS_HORIZONTAL_DIR_FLAGS = 0xC0C0C;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 0xFA;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 0x303030;
        private int mCachedMaxScrollSpeed;
        private static final Interpolator sDragScrollInterpolator;
        private static final Interpolator sDragViewScrollCapInterpolator;

        static {
            Callback.sDragScrollInterpolator = new androidx.recyclerview.widget.ItemTouchHelper$Callback$1();
            Callback.sDragViewScrollCapInterpolator = new androidx.recyclerview.widget.ItemTouchHelper$Callback$2();
        }

        public Callback() {
            super();
            this.mCachedMaxScrollSpeed = -1;
        }

        public boolean canDropOver(RecyclerView arg1, ViewHolder arg2, ViewHolder arg3) {
            return 1;
        }

        public ViewHolder chooseDropTarget(ViewHolder arg12, List arg13, int arg14, int arg15) {
            Object v4_1;
            int v8;
            int v11 = arg12.itemView.getWidth() + arg14;
            int v0 = arg12.itemView.getHeight() + arg15;
            int v1 = arg14 - arg12.itemView.getLeft();
            int v2 = arg15 - arg12.itemView.getTop();
            int v3 = arg13.size();
            ViewHolder v4 = null;
            int v5 = -1;
            int v6;
            for(v6 = 0; v6 < v3; ++v6) {
                Object v7 = arg13.get(v6);
                if(v1 > 0) {
                    v8 = ((ViewHolder)v7).itemView.getRight() - v11;
                    if(v8 < 0 && ((ViewHolder)v7).itemView.getRight() > arg12.itemView.getRight()) {
                        v8 = Math.abs(v8);
                        if(v8 > v5) {
                            v4_1 = v7;
                            v5 = v8;
                        }
                    }
                }

                if(v1 < 0) {
                    v8 = ((ViewHolder)v7).itemView.getLeft() - arg14;
                    if(v8 > 0 && ((ViewHolder)v7).itemView.getLeft() < arg12.itemView.getLeft()) {
                        v8 = Math.abs(v8);
                        if(v8 > v5) {
                            v4_1 = v7;
                            v5 = v8;
                        }
                    }
                }

                if(v2 < 0) {
                    v8 = ((ViewHolder)v7).itemView.getTop() - arg15;
                    if(v8 > 0 && ((ViewHolder)v7).itemView.getTop() < arg12.itemView.getTop()) {
                        v8 = Math.abs(v8);
                        if(v8 > v5) {
                            v4_1 = v7;
                            v5 = v8;
                        }
                    }
                }

                if(v2 > 0) {
                    v8 = ((ViewHolder)v7).itemView.getBottom() - v0;
                    if(v8 < 0 && ((ViewHolder)v7).itemView.getBottom() > arg12.itemView.getBottom()) {
                        v8 = Math.abs(v8);
                        if(v8 > v5) {
                            v4_1 = v7;
                            v5 = v8;
                        }
                    }
                }
            }

            return v4;
        }

        public void clearView(RecyclerView arg1, ViewHolder arg2) {
            ItemTouchUIUtilImpl.INSTANCE.clearView(arg2.itemView);
        }

        public int convertToAbsoluteDirection(int arg3, int arg4) {
            int v2 = 0x303030;
            int v0 = arg3 & v2;
            if(v0 == 0) {
                return arg3;
            }

            arg3 &= ~v0;
            if(arg4 == 0) {
                v2 = v0 >> 2;
            }
            else {
                arg4 = v0 >> 1;
                arg3 |= 0xFFCFCFCF & arg4;
                v2 = (v2 & arg4) >> 2;
            }

            return v2 | arg3;
        }

        public static int convertToRelativeDirection(int arg3, int arg4) {
            int v0 = 0xC0C0C;
            int v1 = arg3 & v0;
            if(v1 == 0) {
                return arg3;
            }

            arg3 &= ~v1;
            if(arg4 == 0) {
                arg4 = v1 << 2;
            }
            else {
                arg4 = v1 << 1;
                arg3 |= 0xFFF3F3F3 & arg4;
                arg4 = (arg4 & v0) << 2;
            }

            return arg3 | arg4;
        }

        final int getAbsoluteMovementFlags(RecyclerView arg1, ViewHolder arg2) {
            return this.convertToAbsoluteDirection(this.getMovementFlags(arg1, arg2), ViewCompat.getLayoutDirection(((View)arg1)));
        }

        public long getAnimationDuration(RecyclerView arg1, int arg2, float arg3, float arg4) {
            ItemAnimator v0 = arg1.getItemAnimator();
            int v1 = 8;
            if(v0 == null) {
                if(arg2 == v1) {
                    return 200;
                }

                return 0xFA;
            }

            if(arg2 == v1) {
                return v0.getMoveDuration();
            }

            return v0.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        private int getMaxDragScroll(RecyclerView arg3) {
            int v0 = this.mCachedMaxScrollSpeed;
            if(v0 == -1) {
                int v3 = arg3.getResources().getDimensionPixelSize(dimen.item_touch_helper_max_drag_scroll_per_frame);
                this.mCachedMaxScrollSpeed = v3;
                return v3;
            }

            return v0;
        }

        public float getMoveThreshold(ViewHolder arg1) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView arg1, ViewHolder arg2);

        public float getSwipeEscapeVelocity(float arg1) {
            return arg1;
        }

        public float getSwipeThreshold(ViewHolder arg1) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float arg1) {
            return arg1;
        }

        boolean hasDragFlag(RecyclerView arg1, ViewHolder arg2) {
            if((this.getAbsoluteMovementFlags(arg1, arg2) & 0xFF0000) != 0) {
                return 1;
            }

            return 0;
        }

        boolean hasSwipeFlag(RecyclerView arg1, ViewHolder arg2) {
            if((this.getAbsoluteMovementFlags(arg1, arg2) & 0xFF00) != 0) {
                return 1;
            }

            return 0;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView arg2, int arg3, int arg4, int arg5, long arg6) {
            float v0 = 1f;
            int v1 = ((int)((((float)((((int)Math.signum(((float)arg4)))) * this.getMaxDragScroll(arg2)))) * Callback.sDragViewScrollCapInterpolator.getInterpolation(Math.min(v0, (((float)Math.abs(arg4))) * v0 / (((float)arg3))))));
            if(arg6 > 2000) {
            }
            else {
                v0 = (((float)arg6)) / 2000f;
            }

            v1 = ((int)((((float)v1)) * Callback.sDragScrollInterpolator.getInterpolation(v0)));
            if(v1 == 0) {
                if(arg4 > 0) {
                    return 1;
                }
                else {
                    v1 = -1;
                }
            }

            return v1;
        }

        public boolean isItemViewSwipeEnabled() {
            return 1;
        }

        public boolean isLongPressDragEnabled() {
            return 1;
        }

        public static int makeFlag(int arg0, int arg1) {
            return arg1 << arg0 * 8;
        }

        public static int makeMovementFlags(int arg2, int arg3) {
            return Callback.makeFlag(2, arg2) | (Callback.makeFlag(1, arg3) | Callback.makeFlag(0, arg3 | arg2));
        }

        public void onChildDraw(Canvas arg1, RecyclerView arg2, ViewHolder arg3, float arg4, float arg5, int arg6, boolean arg7) {
            ItemTouchUIUtilImpl.INSTANCE.onDraw(arg1, arg2, arg3.itemView, arg4, arg5, arg6, arg7);
        }

        public void onChildDrawOver(Canvas arg1, RecyclerView arg2, ViewHolder arg3, float arg4, float arg5, int arg6, boolean arg7) {
            ItemTouchUIUtilImpl.INSTANCE.onDrawOver(arg1, arg2, arg3.itemView, arg4, arg5, arg6, arg7);
        }

        void onDraw(Canvas arg13, RecyclerView arg14, ViewHolder arg15, List arg16, int arg17, float arg18, float arg19) {
            int v8 = arg16.size();
            int v9;
            for(v9 = 0; v9 < v8; ++v9) {
                Object v0 = arg16.get(v9);
                ((RecoverAnimation)v0).update();
                int v11 = arg13.save();
                this.onChildDraw(arg13, arg14, ((RecoverAnimation)v0).mViewHolder, ((RecoverAnimation)v0).mX, ((RecoverAnimation)v0).mY, ((RecoverAnimation)v0).mActionState, false);
                arg13.restoreToCount(v11);
            }

            if(arg15 != null) {
                v8 = arg13.save();
                this.onChildDraw(arg13, arg14, arg15, arg18, arg19, arg17, true);
                arg13.restoreToCount(v8);
            }
        }

        void onDrawOver(Canvas arg14, RecyclerView arg15, ViewHolder arg16, List arg17, int arg18, float arg19, float arg20) {
            List v8 = arg17;
            int v9 = v8.size();
            int v10 = 0;
            int v11;
            for(v11 = 0; v11 < v9; ++v11) {
                Object v0 = v8.get(v11);
                int v12 = arg14.save();
                this.onChildDrawOver(arg14, arg15, ((RecoverAnimation)v0).mViewHolder, ((RecoverAnimation)v0).mX, ((RecoverAnimation)v0).mY, ((RecoverAnimation)v0).mActionState, false);
                arg14.restoreToCount(v12);
            }

            if(arg16 != null) {
                v11 = arg14.save();
                this.onChildDrawOver(arg14, arg15, arg16, arg19, arg20, arg18, true);
                arg14.restoreToCount(v11);
            }

            --v9;
            while(v9 >= 0) {
                Object v1 = v8.get(v9);
                if((((RecoverAnimation)v1).mEnded) && !((RecoverAnimation)v1).mIsPendingCleanup) {
                    v8.remove(v9);
                }
                else if(!((RecoverAnimation)v1).mEnded) {
                    v10 = 1;
                }

                --v9;
            }

            if(v10 != 0) {
                arg15.invalidate();
            }
        }

        public abstract boolean onMove(RecyclerView arg1, ViewHolder arg2, ViewHolder arg3);

        public void onMoved(RecyclerView arg1, ViewHolder arg2, int arg3, ViewHolder arg4, int arg5, int arg6, int arg7) {
            LayoutManager v0 = arg1.getLayoutManager();
            if((v0 instanceof ViewDropHandler)) {
                ((ViewDropHandler)v0).prepareForDrop(arg2.itemView, arg4.itemView, arg6, arg7);
                return;
            }

            if(v0.canScrollHorizontally()) {
                if(v0.getDecoratedLeft(arg4.itemView) <= arg1.getPaddingLeft()) {
                    arg1.scrollToPosition(arg5);
                }

                if(v0.getDecoratedRight(arg4.itemView) < arg1.getWidth() - arg1.getPaddingRight()) {
                    goto label_21;
                }

                arg1.scrollToPosition(arg5);
            }

        label_21:
            if(v0.canScrollVertically()) {
                if(v0.getDecoratedTop(arg4.itemView) <= arg1.getPaddingTop()) {
                    arg1.scrollToPosition(arg5);
                }

                if(v0.getDecoratedBottom(arg4.itemView) < arg1.getHeight() - arg1.getPaddingBottom()) {
                    return;
                }

                arg1.scrollToPosition(arg5);
            }
        }

        public void onSelectedChanged(ViewHolder arg1, int arg2) {
            if(arg1 != null) {
                ItemTouchUIUtilImpl.INSTANCE.onSelected(arg1.itemView);
            }
        }

        public abstract void onSwiped(ViewHolder arg1, int arg2);
    }

    class ItemTouchHelperGestureListener extends GestureDetector$SimpleOnGestureListener {
        private boolean mShouldReactToLongPress;

        ItemTouchHelperGestureListener(ItemTouchHelper arg1) {
            ItemTouchHelper.this = arg1;
            super();
            this.mShouldReactToLongPress = true;
        }

        void doNotReactToLongPress() {
            this.mShouldReactToLongPress = false;
        }

        public boolean onDown(MotionEvent arg1) {
            return 1;
        }

        public void onLongPress(MotionEvent arg4) {
            if(!this.mShouldReactToLongPress) {
            }
            else {
                View v0 = ItemTouchHelper.this.findChildView(arg4);
                if(v0 != null) {
                    ViewHolder v0_1 = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(v0);
                    if(v0_1 != null) {
                        if(!ItemTouchHelper.this.mCallback.hasDragFlag(ItemTouchHelper.this.mRecyclerView, v0_1)) {
                        }
                        else if(arg4.getPointerId(0) == ItemTouchHelper.this.mActivePointerId) {
                            int v1 = arg4.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                            float v2 = arg4.getX(v1);
                            float v4 = arg4.getY(v1);
                            ItemTouchHelper.this.mInitialTouchX = v2;
                            ItemTouchHelper.this.mInitialTouchY = v4;
                            ItemTouchHelper v4_1 = ItemTouchHelper.this;
                            v4_1.mDy = 0f;
                            v4_1.mDx = 0f;
                            if(ItemTouchHelper.this.mCallback.isLongPressDragEnabled()) {
                                ItemTouchHelper.this.select(v0_1, 2);
                            }
                        }
                    }
                }
            }
        }
    }

    class RecoverAnimation implements Animator$AnimatorListener {
        final int mActionState;
        final int mAnimationType;
        boolean mEnded;
        private float mFraction;
        boolean mIsPendingCleanup;
        boolean mOverridden;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final ValueAnimator mValueAnimator;
        final ViewHolder mViewHolder;
        float mX;
        float mY;

        RecoverAnimation(ViewHolder arg2, int arg3, int arg4, float arg5, float arg6, float arg7, float arg8) {
            super();
            this.mOverridden = false;
            this.mEnded = false;
            this.mActionState = arg4;
            this.mAnimationType = arg3;
            this.mViewHolder = arg2;
            this.mStartDx = arg5;
            this.mStartDy = arg6;
            this.mTargetX = arg7;
            this.mTargetY = arg8;
            ValueAnimator v3 = ValueAnimator.ofFloat(new float[]{0f, 1f});
            this.mValueAnimator = v3;
            v3.addUpdateListener(new ValueAnimator$AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator arg1) {
                    RecoverAnimation.this.setFraction(arg1.getAnimatedFraction());
                }
            });
            v3.setTarget(arg2.itemView);
            v3.addListener(((Animator$AnimatorListener)this));
            this.setFraction(0f);
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        public void onAnimationCancel(Animator arg1) {
            this.setFraction(1f);
        }

        public void onAnimationEnd(Animator arg2) {
            if(!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }

            this.mEnded = true;
        }

        public void onAnimationRepeat(Animator arg1) {
        }

        public void onAnimationStart(Animator arg1) {
        }

        public void setDuration(long arg1) {
            this.mValueAnimator.setDuration(arg1);
        }

        public void setFraction(float arg1) {
            this.mFraction = arg1;
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void update() {
            float v0 = this.mStartDx;
            float v1 = this.mTargetX;
            this.mX = v0 == v1 ? this.mViewHolder.itemView.getTranslationX() : v0 + this.mFraction * (v1 - v0);
            v0 = this.mStartDy;
            v1 = this.mTargetY;
            if(v0 == v1) {
                this.mY = this.mViewHolder.itemView.getTranslationY();
                return;
            }

            this.mY = v0 + this.mFraction * (v1 - v0);
        }
    }

    public abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int arg1, int arg2) {
            super();
            this.mDefaultSwipeDirs = arg2;
            this.mDefaultDragDirs = arg1;
        }

        public int getDragDirs(RecyclerView arg1, ViewHolder arg2) {
            return this.mDefaultDragDirs;
        }

        public int getMovementFlags(RecyclerView arg2, ViewHolder arg3) {
            return SimpleCallback.makeMovementFlags(this.getDragDirs(arg2, arg3), this.getSwipeDirs(arg2, arg3));
        }

        public int getSwipeDirs(RecyclerView arg1, ViewHolder arg2) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int arg1) {
            this.mDefaultDragDirs = arg1;
        }

        public void setDefaultSwipeDirs(int arg1) {
            this.mDefaultSwipeDirs = arg1;
        }
    }

    public interface ViewDropHandler {
        void prepareForDrop(View arg1, View arg2, int arg3, int arg4);
    }

    static final int ACTION_MODE_DRAG_MASK = 0xFF0000;
    private static final int ACTION_MODE_IDLE_MASK = 0xFF;
    static final int ACTION_MODE_SWIPE_MASK = 0xFF00;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 0x20;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    private int mActionState;
    int mActivePointerId;
    Callback mCallback;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    private List mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    private float mMaxSwipeVelocity;
    private final OnItemTouchListener mOnItemTouchListener;
    View mOverdrawChild;
    int mOverdrawChildPosition;
    final List mPendingCleanup;
    List mRecoverAnimations;
    RecyclerView mRecyclerView;
    final Runnable mScrollRunnable;
    ViewHolder mSelected;
    int mSelectedFlags;
    private float mSelectedStartX;
    private float mSelectedStartY;
    private int mSlop;
    private List mSwapTargets;
    private float mSwipeEscapeVelocity;
    private final float[] mTmpPosition;
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;

    public ItemTouchHelper(Callback arg4) {
        super();
        this.mPendingCleanup = new ArrayList();
        this.mTmpPosition = new float[2];
        this.mSelected = null;
        this.mActivePointerId = -1;
        this.mActionState = 0;
        this.mRecoverAnimations = new ArrayList();
        this.mScrollRunnable = new androidx.recyclerview.widget.ItemTouchHelper$1(this);
        this.mChildDrawingOrderCallback = null;
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        this.mOnItemTouchListener = new androidx.recyclerview.widget.ItemTouchHelper$2(this);
        this.mCallback = arg4;
    }

    private void addChildDrawingOrderCallback() {
    }

    public void attachToRecyclerView(RecyclerView arg2) {
        RecyclerView v0 = this.mRecyclerView;
        if(v0 == arg2) {
        }
        else {
            if(v0 != null) {
                this.destroyCallbacks();
            }

            this.mRecyclerView = arg2;
            if(arg2 == null) {
                return;
            }

            Resources v2 = arg2.getResources();
            this.mSwipeEscapeVelocity = v2.getDimension(dimen.item_touch_helper_swipe_escape_velocity);
            this.mMaxSwipeVelocity = v2.getDimension(dimen.item_touch_helper_swipe_escape_max_velocity);
            this.setupCallbacks();
        }
    }

    private int checkHorizontalSwipe(ViewHolder arg8, int arg9) {
        float v1;
        if((arg9 & 12) != 0) {
            int v2 = 8;
            int v3 = 4;
            int v0 = Float.compare(this.mDx, 0f) > 0 ? v2 : v3;
            VelocityTracker v4 = this.mVelocityTracker;
            if(v4 != null && this.mActivePointerId > -1) {
                v4.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float v4_1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                float v5 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                if(v4_1 > 0f) {
                }
                else {
                    v2 = v3;
                }

                v1 = Math.abs(v4_1);
                if((v2 & arg9) == 0) {
                    goto label_41;
                }

                if(v0 != v2) {
                    goto label_41;
                }

                if(v1 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) {
                    goto label_41;
                }

                if(v1 <= Math.abs(v5)) {
                    goto label_41;
                }

                return v2;
            }

        label_41:
            v1 = (((float)this.mRecyclerView.getWidth())) * this.mCallback.getSwipeThreshold(arg8);
            if((arg9 & v0) == 0) {
                return 0;
            }

            if(Math.abs(this.mDx) <= v1) {
                return 0;
            }

            return v0;
        }

        return 0;
    }

    void checkSelectForSwipe(int arg9, MotionEvent arg10, int arg11) {
        if(this.mSelected == null) {
            int v0 = 2;
            if(arg9 == v0 && this.mActionState != v0) {
                if(!this.mCallback.isItemViewSwipeEnabled()) {
                }
                else if(this.mRecyclerView.getScrollState() == 1) {
                }
                else {
                    ViewHolder v9 = this.findSwipedView(arg10);
                    if(v9 == null) {
                    }
                    else {
                        int v2 = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, v9) & 0xFF00) >> 8;
                        if(v2 == 0) {
                        }
                        else {
                            float v3 = arg10.getX(arg11);
                            float v11 = arg10.getY(arg11);
                            v3 -= this.mInitialTouchX;
                            v11 -= this.mInitialTouchY;
                            float v4 = Math.abs(v3);
                            float v5 = Math.abs(v11);
                            int v6 = this.mSlop;
                            if(v4 < (((float)v6)) && v5 < (((float)v6))) {
                                return;
                            }

                            if(Float.compare(v4, v5) > 0) {
                                if(v3 < 0f && (v2 & 4) == 0) {
                                    return;
                                }

                                if(v3 <= 0f) {
                                    goto label_59;
                                }

                                if((v2 & 8) != 0) {
                                    goto label_59;
                                }
                            }
                            else {
                                if(v11 < 0f && (v2 & 1) == 0) {
                                    return;
                                }

                                if(v11 <= 0f) {
                                    goto label_59;
                                }

                                if((v2 & 2) != 0) {
                                    goto label_59;
                                }
                            }

                            return;
                        label_59:
                            this.mDy = 0f;
                            this.mDx = 0f;
                            this.mActivePointerId = arg10.getPointerId(0);
                            this.select(v9, 1);
                        }
                    }
                }
            }
        }
    }

    private int checkVerticalSwipe(ViewHolder arg8, int arg9) {
        float v1;
        if((arg9 & 3) != 0) {
            int v2 = 2;
            int v0 = Float.compare(this.mDy, 0f) > 0 ? v2 : 1;
            VelocityTracker v4 = this.mVelocityTracker;
            if(v4 != null && this.mActivePointerId > -1) {
                v4.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float v4_1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                float v5 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                if(v5 > 0f) {
                }
                else {
                    v2 = 1;
                }

                v1 = Math.abs(v5);
                if((v2 & arg9) == 0) {
                    goto label_41;
                }

                if(v2 != v0) {
                    goto label_41;
                }

                if(v1 < this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) {
                    goto label_41;
                }

                if(v1 <= Math.abs(v4_1)) {
                    goto label_41;
                }

                return v2;
            }

        label_41:
            v1 = (((float)this.mRecyclerView.getHeight())) * this.mCallback.getSwipeThreshold(arg8);
            if((arg9 & v0) == 0) {
                return 0;
            }

            if(Math.abs(this.mDy) <= v1) {
                return 0;
            }

            return v0;
        }

        return 0;
    }

    private void destroyCallbacks() {
        List v1;
        this.mRecyclerView.removeItemDecoration(((ItemDecoration)this));
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(((OnChildAttachStateChangeListener)this));
        int v0;
        for(v0 = this.mRecoverAnimations.size() - 1; true; --v0) {
            v1 = this.mRecoverAnimations;
            if(v0 < 0) {
                break;
            }

            this.mCallback.clearView(this.mRecyclerView, v1.get(0).mViewHolder);
        }

        v1.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        this.releaseVelocityTracker();
        this.stopGestureDetection();
    }

    void endRecoverAnimation(ViewHolder arg4, boolean arg5) {
        int v0;
        for(v0 = this.mRecoverAnimations.size() - 1; v0 >= 0; --v0) {
            Object v1 = this.mRecoverAnimations.get(v0);
            if(((RecoverAnimation)v1).mViewHolder == arg4) {
                ((RecoverAnimation)v1).mOverridden |= ((int)arg5);
                if(!((RecoverAnimation)v1).mEnded) {
                    ((RecoverAnimation)v1).cancel();
                }

                this.mRecoverAnimations.remove(v0);
                return;
            }
        }
    }

    RecoverAnimation findAnimation(MotionEvent arg5) {
        RecoverAnimation v1 = null;
        if(this.mRecoverAnimations.isEmpty()) {
            return v1;
        }

        View v5 = this.findChildView(arg5);
        int v0;
        for(v0 = this.mRecoverAnimations.size() - 1; v0 >= 0; --v0) {
            Object v2 = this.mRecoverAnimations.get(v0);
            if(((RecoverAnimation)v2).mViewHolder.itemView == v5) {
                return ((RecoverAnimation)v2);
            }
        }

        return v1;
    }

    View findChildView(MotionEvent arg6) {
        float v0 = arg6.getX();
        float v6 = arg6.getY();
        ViewHolder v1 = this.mSelected;
        if(v1 != null) {
            View v1_1 = v1.itemView;
            if(ItemTouchHelper.hitTest(v1_1, v0, v6, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return v1_1;
            }
        }

        int v1_2;
        for(v1_2 = this.mRecoverAnimations.size() - 1; v1_2 >= 0; --v1_2) {
            Object v2 = this.mRecoverAnimations.get(v1_2);
            View v3 = ((RecoverAnimation)v2).mViewHolder.itemView;
            if(ItemTouchHelper.hitTest(v3, v0, v6, ((RecoverAnimation)v2).mX, ((RecoverAnimation)v2).mY)) {
                return v3;
            }
        }

        return this.mRecyclerView.findChildViewUnder(v0, v6);
    }

    private List findSwapTargets(ViewHolder arg17) {
        ItemTouchHelper v0 = this;
        ViewHolder v1 = arg17;
        List v2 = v0.mSwapTargets;
        if(v2 == null) {
            v0.mSwapTargets = new ArrayList();
            v0.mDistances = new ArrayList();
        }
        else {
            v2.clear();
            v0.mDistances.clear();
        }

        int v2_1 = v0.mCallback.getBoundingBoxMargin();
        int v3 = Math.round(v0.mSelectedStartX + v0.mDx) - v2_1;
        int v4 = Math.round(v0.mSelectedStartY + v0.mDy) - v2_1;
        v2_1 *= 2;
        int v5 = v1.itemView.getWidth() + v3 + v2_1;
        int v6 = v1.itemView.getHeight() + v4 + v2_1;
        v2_1 = (v3 + v5) / 2;
        int v7 = (v4 + v6) / 2;
        LayoutManager v8 = v0.mRecyclerView.getLayoutManager();
        int v9 = v8.getChildCount();
        int v11 = 0;
        while(v11 < v9) {
            View v12 = v8.getChildAt(v11);
            if(v12 == v1.itemView) {
            }
            else if(v12.getBottom() >= v4 && v12.getTop() <= v6 && v12.getRight() >= v3) {
                if(v12.getLeft() > v5) {
                }
                else {
                    ViewHolder v13 = v0.mRecyclerView.getChildViewHolder(v12);
                    if(v0.mCallback.canDropOver(v0.mRecyclerView, v0.mSelected, v13)) {
                        int v10 = Math.abs(v2_1 - (v12.getLeft() + v12.getRight()) / 2);
                        int v12_1 = Math.abs(v7 - (v12.getTop() + v12.getBottom()) / 2);
                        v10 = v10 * v10 + v12_1 * v12_1;
                        v12_1 = v0.mSwapTargets.size();
                        int v14 = 0;
                        int v15 = 0;
                        while(v14 < v12_1) {
                            if(v10 <= v0.mDistances.get(v14).intValue()) {
                                break;
                            }

                            ++v15;
                            ++v14;
                        }

                        v0.mSwapTargets.add(v15, v13);
                        v0.mDistances.add(v15, Integer.valueOf(v10));
                    }
                }
            }

            ++v11;
            v1 = arg17;
        }

        return v0.mSwapTargets;
    }

    private ViewHolder findSwipedView(MotionEvent arg7) {
        LayoutManager v0 = this.mRecyclerView.getLayoutManager();
        int v1 = this.mActivePointerId;
        ViewHolder v3 = null;
        if(v1 == -1) {
            return v3;
        }

        v1 = arg7.findPointerIndex(v1);
        float v2 = arg7.getX(v1) - this.mInitialTouchX;
        float v1_1 = arg7.getY(v1) - this.mInitialTouchY;
        v2 = Math.abs(v2);
        v1_1 = Math.abs(v1_1);
        int v4 = this.mSlop;
        if(v2 < (((float)v4)) && v1_1 < (((float)v4))) {
            return v3;
        }

        if(v2 > v1_1 && (v0.canScrollHorizontally())) {
            return v3;
        }

        if(v1_1 > v2 && (v0.canScrollVertically())) {
            return v3;
        }

        View v7 = this.findChildView(arg7);
        if(v7 == null) {
            return v3;
        }

        return this.mRecyclerView.getChildViewHolder(v7);
    }

    public void getItemOffsets(Rect arg1, View arg2, RecyclerView arg3, State arg4) {
        arg1.setEmpty();
    }

    private void getSelectedDxDy(float[] arg4) {
        arg4[0] = (this.mSelectedFlags & 12) != 0 ? this.mSelectedStartX + this.mDx - (((float)this.mSelected.itemView.getLeft())) : this.mSelected.itemView.getTranslationX();
        if((this.mSelectedFlags & 3) != 0) {
            arg4[1] = this.mSelectedStartY + this.mDy - (((float)this.mSelected.itemView.getTop()));
            return;
        }

        arg4[1] = this.mSelected.itemView.getTranslationY();
    }

    boolean hasRunningRecoverAnim() {
        int v0 = this.mRecoverAnimations.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!this.mRecoverAnimations.get(v2).mEnded) {
                return 1;
            }
        }

        return 0;
    }

    private static boolean hitTest(View arg1, float arg2, float arg3, float arg4, float arg5) {
        if(arg2 >= arg4 && arg2 <= arg4 + (((float)arg1.getWidth())) && arg3 >= arg5 && arg3 <= arg5 + (((float)arg1.getHeight()))) {
            return 1;
        }

        return 0;
    }

    void moveIfNecessary(ViewHolder arg11) {
        if(this.mRecyclerView.isLayoutRequested()) {
        }
        else if(this.mActionState != 2) {
        }
        else {
            float v0 = this.mCallback.getMoveThreshold(arg11);
            int v8 = ((int)(this.mSelectedStartX + this.mDx));
            int v9 = ((int)(this.mSelectedStartY + this.mDy));
            if((((float)Math.abs(v9 - arg11.itemView.getTop()))) < (((float)arg11.itemView.getHeight())) * v0 && (((float)Math.abs(v8 - arg11.itemView.getLeft()))) < (((float)arg11.itemView.getWidth())) * v0) {
                return;
            }

            List v0_1 = this.findSwapTargets(arg11);
            if(v0_1.size() == 0) {
                return;
            }

            ViewHolder v6 = this.mCallback.chooseDropTarget(arg11, v0_1, v8, v9);
            if(v6 == null) {
                this.mSwapTargets.clear();
                this.mDistances.clear();
                return;
            }

            int v7 = v6.getAdapterPosition();
            int v5 = arg11.getAdapterPosition();
            if(!this.mCallback.onMove(this.mRecyclerView, arg11, v6)) {
                return;
            }

            this.mCallback.onMoved(this.mRecyclerView, arg11, v5, v6, v7, v8, v9);
        }
    }

    void obtainVelocityTracker() {
        VelocityTracker v0 = this.mVelocityTracker;
        if(v0 != null) {
            v0.recycle();
        }

        this.mVelocityTracker = VelocityTracker.obtain();
    }

    public void onChildViewAttachedToWindow(View arg1) {
    }

    public void onChildViewDetachedFromWindow(View arg3) {
        this.removeChildDrawingOrderCallbackIfNecessary(arg3);
        ViewHolder v3 = this.mRecyclerView.getChildViewHolder(arg3);
        if(v3 == null) {
        }
        else {
            ViewHolder v0 = this.mSelected;
            if(v0 != null && v3 == v0) {
                this.select(null, 0);
                return;
            }

            this.endRecoverAnimation(v3, false);
            if(!this.mPendingCleanup.remove(v3.itemView)) {
                return;
            }

            this.mCallback.clearView(this.mRecyclerView, v3);
        }
    }

    public void onDraw(Canvas arg10, RecyclerView arg11, State arg12) {
        float v7;
        float v8;
        this.mOverdrawChildPosition = -1;
        if(this.mSelected != null) {
            this.getSelectedDxDy(this.mTmpPosition);
            float[] v12 = this.mTmpPosition;
            float v0 = v12[0];
            v8 = v12[1];
            v7 = v0;
        }
        else {
            v7 = 0f;
            v8 = 0f;
        }

        this.mCallback.onDraw(arg10, arg11, this.mSelected, this.mRecoverAnimations, this.mActionState, v7, v8);
    }

    public void onDrawOver(Canvas arg10, RecyclerView arg11, State arg12) {
        float v7;
        float v8;
        if(this.mSelected != null) {
            this.getSelectedDxDy(this.mTmpPosition);
            float[] v12 = this.mTmpPosition;
            float v0 = v12[0];
            v8 = v12[1];
            v7 = v0;
        }
        else {
            v7 = 0f;
            v8 = 0f;
        }

        this.mCallback.onDrawOver(arg10, arg11, this.mSelected, this.mRecoverAnimations, this.mActionState, v7, v8);
    }

    void postDispatchSwipe(RecoverAnimation arg3, int arg4) {
        this.mRecyclerView.post(new Runnable(arg3, arg4) {
            public void run() {
                if(ItemTouchHelper.this.mRecyclerView != null && (ItemTouchHelper.this.mRecyclerView.isAttachedToWindow()) && !this.val$anim.mOverridden && this.val$anim.mViewHolder.getAdapterPosition() != -1) {
                    ItemAnimator v0 = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                    if((v0 == null || !v0.isRunning(null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                        ItemTouchHelper.this.mCallback.onSwiped(this.val$anim.mViewHolder, this.val$swipeDir);
                        return;
                    }

                    ItemTouchHelper.this.mRecyclerView.post(((Runnable)this));
                }
            }
        });
    }

    private void releaseVelocityTracker() {
        VelocityTracker v0 = this.mVelocityTracker;
        if(v0 != null) {
            v0.recycle();
            this.mVelocityTracker = null;
        }
    }

    void removeChildDrawingOrderCallbackIfNecessary(View arg2) {
        if(arg2 == this.mOverdrawChild) {
            arg2 = null;
            this.mOverdrawChild = arg2;
            if(this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback(((ChildDrawingOrderCallback)arg2));
            }
        }
    }

    boolean scrollIfNecessary() {
        int v0_1;
        int v11;
        int v6_1;
        long v2 = -9223372036854775808L;
        if(this.mSelected == null) {
            this.mDragScrollStartTimeInMs = v2;
            return 0;
        }

        long v4 = System.currentTimeMillis();
        long v6 = this.mDragScrollStartTimeInMs;
        v6 = v6 == v2 ? 0 : v4 - v6;
        long v13 = v6;
        LayoutManager v0 = this.mRecyclerView.getLayoutManager();
        if(this.mTmpRect == null) {
            this.mTmpRect = new Rect();
        }

        v0.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
        if(v0.canScrollHorizontally()) {
            v6_1 = ((int)(this.mSelectedStartX + this.mDx));
            int v8 = v6_1 - this.mTmpRect.left - this.mRecyclerView.getPaddingLeft();
            float v9 = this.mDx;
            if(v9 >= 0f || v8 >= 0) {
                if(v9 > 0f) {
                    v8 = v6_1 + this.mSelected.itemView.getWidth() + this.mTmpRect.right - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
                    if(v8 > 0) {
                    }
                    else {
                        goto label_58;
                    }
                }
                else {
                    goto label_58;
                }
            }

            v11 = v8;
        }
        else {
        label_58:
            v11 = 0;
        }

        if(v0.canScrollVertically()) {
            v0_1 = ((int)(this.mSelectedStartY + this.mDy));
            v6_1 = v0_1 - this.mTmpRect.top - this.mRecyclerView.getPaddingTop();
            float v8_1 = this.mDy;
            if(v8_1 < 0f && v6_1 < 0) {
                goto label_92;
            }

            if(v8_1 <= 0f) {
                goto label_91;
            }

            v6_1 = v0_1 + this.mSelected.itemView.getHeight() + this.mTmpRect.bottom - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
            if(v6_1 <= 0) {
                goto label_91;
            }
        }
        else {
        label_91:
            v6_1 = 0;
        }

    label_92:
        if(v11 != 0) {
            v11 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), v11, this.mRecyclerView.getWidth(), v13);
        }

        v0_1 = v11;
        if(v6_1 != 0) {
            v6_1 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), v6_1, this.mRecyclerView.getHeight(), v13);
        }

        if(v0_1 == 0) {
            if(v6_1 != 0) {
            }
            else {
                this.mDragScrollStartTimeInMs = v2;
                return 0;
            }
        }

        if(this.mDragScrollStartTimeInMs == v2) {
            this.mDragScrollStartTimeInMs = v4;
        }

        this.mRecyclerView.scrollBy(v0_1, v6_1);
        return 1;
    }

    void select(ViewHolder arg19, int arg20) {
        boolean v13_1;
        int v13;
        float v8;
        float v7;
        ItemTouchHelper v1 = this;
        ViewHolder v11 = arg19;
        int v12 = arg20;
        if(v11 == v1.mSelected && v12 == v1.mActionState) {
            return;
        }

        v1.mDragScrollStartTimeInMs = -9223372036854775808L;
        int v4 = v1.mActionState;
        v1.endRecoverAnimation(v11, true);
        v1.mActionState = v12;
        int v14 = 2;
        if(v12 == v14) {
            if(v11 != null) {
                v1.mOverdrawChild = v11.itemView;
                v1.addChildDrawingOrderCallback();
            }
            else {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
        }

        int v15 = 8;
        int v16 = (1 << v12 * 8 + v15) - 1;
        ViewHolder v2 = v1.mSelected;
        int v0 = 0;
        if(v2 != null) {
            if(v2.itemView.getParent() != null) {
                int v9 = v4 == v14 ? 0 : v1.swipeIfNecessary(v2);
                v1.releaseVelocityTracker();
                int v3 = 4;
                if(v9 == 1 || v9 == v14) {
                    v7 = 0f;
                    v8 = Math.signum(v1.mDy) * (((float)v1.mRecyclerView.getHeight()));
                }
                else {
                    if(v9 != v3 && v9 != v15 && v9 != 16 && v9 != 0x20) {
                        v7 = 0f;
                        v8 = 0f;
                        goto label_72;
                    }

                    v8 = 0f;
                    v7 = Math.signum(v1.mDx) * (((float)v1.mRecyclerView.getWidth()));
                }

            label_72:
                if(v4 == v14) {
                    v3 = v15;
                }
                else if(v9 > 0) {
                    v3 = v14;
                }

                v1.getSelectedDxDy(v1.mTmpPosition);
                float[] v6 = v1.mTmpPosition;
                float v5 = v6[0];
                float v6_1 = v6[1];
                v13 = 0;
                androidx.recyclerview.widget.ItemTouchHelper$3 v0_1 = new RecoverAnimation(v2, v3, v4, v5, v6_1, v7, v8, v9, v2) {
                    public void onAnimationEnd(Animator arg3) {
                        super.onAnimationEnd(arg3);
                        if(this.mOverridden) {
                        }
                        else {
                            int v3 = this.val$swipeDir;
                            ItemTouchHelper v0 = ItemTouchHelper.this;
                            if(v3 <= 0) {
                                v0.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, this.val$prevSelected);
                            }
                            else {
                                v0.mPendingCleanup.add(this.val$prevSelected.itemView);
                                this.mIsPendingCleanup = true;
                                v3 = this.val$swipeDir;
                                if(v3 > 0) {
                                    ItemTouchHelper.this.postDispatchSwipe(((RecoverAnimation)this), v3);
                                }
                            }

                            if(ItemTouchHelper.this.mOverdrawChild != this.val$prevSelected.itemView) {
                                return;
                            }

                            ItemTouchHelper.this.removeChildDrawingOrderCallbackIfNecessary(this.val$prevSelected.itemView);
                        }
                    }
                };
                ((RecoverAnimation)v0_1).setDuration(v1.mCallback.getAnimationDuration(v1.mRecyclerView, v3, v7 - v5, v8 - v6_1));
                v1.mRecoverAnimations.add(v0_1);
                ((RecoverAnimation)v0_1).start();
                v0 = 1;
            }
            else {
                v13 = 0;
                v1.removeChildDrawingOrderCallbackIfNecessary(v2.itemView);
                v1.mCallback.clearView(v1.mRecyclerView, v2);
                v0 = 0;
            }

            v1.mSelected = null;
        }
        else {
            v13 = 0;
        }

        if(v11 != null) {
            v1.mSelectedFlags = (v1.mCallback.getAbsoluteMovementFlags(v1.mRecyclerView, v11) & v16) >> v1.mActionState * v15;
            v1.mSelectedStartX = ((float)v11.itemView.getLeft());
            v1.mSelectedStartY = ((float)v11.itemView.getTop());
            v1.mSelected = v11;
            if(v12 == v14) {
                v11.itemView.performHapticFeedback(v13);
            }
        }

        ViewParent v2_1 = v1.mRecyclerView.getParent();
        if(v2_1 != null) {
            if(v1.mSelected != null) {
                v13_1 = true;
            }

            v2_1.requestDisallowInterceptTouchEvent(v13_1);
        }

        if(v0 == 0) {
            v1.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }

        v1.mCallback.onSelectedChanged(v1.mSelected, v1.mActionState);
        v1.mRecyclerView.invalidate();
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(((ItemDecoration)this));
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(((OnChildAttachStateChangeListener)this));
        this.startGestureDetection();
    }

    public void startDrag(ViewHolder arg4) {
        String v1 = "ItemTouchHelper";
        if(!this.mCallback.hasDragFlag(this.mRecyclerView, arg4)) {
            Log.e(v1, "Start drag has been called but dragging is not enabled");
            return;
        }

        if(arg4.itemView.getParent() != this.mRecyclerView) {
            Log.e(v1, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }

        this.obtainVelocityTracker();
        this.mDy = 0f;
        this.mDx = 0f;
        this.select(arg4, 2);
    }

    private void startGestureDetection() {
        this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener(this);
        this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
    }

    public void startSwipe(ViewHolder arg4) {
        String v1 = "ItemTouchHelper";
        if(!this.mCallback.hasSwipeFlag(this.mRecyclerView, arg4)) {
            Log.e(v1, "Start swipe has been called but swiping is not enabled");
            return;
        }

        if(arg4.itemView.getParent() != this.mRecyclerView) {
            Log.e(v1, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            return;
        }

        this.obtainVelocityTracker();
        this.mDy = 0f;
        this.mDx = 0f;
        this.select(arg4, 1);
    }

    private void stopGestureDetection() {
        ItemTouchHelperGestureListener v0 = this.mItemTouchHelperGestureListener;
        ItemTouchHelperGestureListener v1 = null;
        if(v0 != null) {
            v0.doNotReactToLongPress();
            this.mItemTouchHelperGestureListener = v1;
        }

        if(this.mGestureDetector != null) {
            this.mGestureDetector = ((GestureDetectorCompat)v1);
        }
    }

    private int swipeIfNecessary(ViewHolder arg6) {
        if(this.mActionState == 2) {
            return 0;
        }

        int v0 = this.mCallback.getMovementFlags(this.mRecyclerView, arg6);
        int v3 = 0xFF00;
        int v1 = (this.mCallback.convertToAbsoluteDirection(v0, ViewCompat.getLayoutDirection(this.mRecyclerView)) & v3) >> 8;
        if(v1 == 0) {
            return 0;
        }

        v0 = (v0 & v3) >> 8;
        if(Math.abs(this.mDx) > Math.abs(this.mDy)) {
            v3 = this.checkHorizontalSwipe(arg6, v1);
            if(v3 <= 0) {
                int v5 = this.checkVerticalSwipe(arg6, v1);
                if(v5 > 0) {
                    return v5;
                }
            }
            else if((v0 & v3) == 0) {
                return Callback.convertToRelativeDirection(v3, ViewCompat.getLayoutDirection(this.mRecyclerView));
            }
            else {
                return v3;
            }
        }
        else {
            v3 = this.checkVerticalSwipe(arg6, v1);
            if(v3 > 0) {
                return v3;
            }
            else {
                int v6 = this.checkHorizontalSwipe(arg6, v1);
                if(v6 > 0) {
                    if((v0 & v6) == 0) {
                        return Callback.convertToRelativeDirection(v6, ViewCompat.getLayoutDirection(this.mRecyclerView));
                    }
                    else {
                        return v6;
                    }
                }
            }
        }

        return 0;
    }

    void updateDxDy(MotionEvent arg2, int arg3, int arg4) {
        float v0 = arg2.getX(arg4);
        float v2 = arg2.getY(arg4);
        v0 -= this.mInitialTouchX;
        this.mDx = v0;
        this.mDy = v2 - this.mInitialTouchY;
        if((arg3 & 4) == 0) {
            v0 = Math.max(0f, v0);
            this.mDx = v0;
        }

        if((arg3 & 8) == 0) {
            this.mDx = Math.min(0f, v0);
        }

        if((arg3 & 1) == 0) {
            this.mDy = Math.max(0f, this.mDy);
        }

        if((arg3 & 2) == 0) {
            this.mDy = Math.min(0f, this.mDy);
        }
    }
}

