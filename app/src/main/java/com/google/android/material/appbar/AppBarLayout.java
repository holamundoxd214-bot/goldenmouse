package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBarLayout extends LinearLayout implements AttachedBehavior {
    public class BaseBehavior extends HeaderBehavior {
        public abstract class BaseDragCallback {
            public BaseDragCallback() {
                super();
            }

            public abstract boolean canDrag(AppBarLayout arg1);
        }

        public class SavedState extends AbsSavedState {
            class com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState$1 implements Parcelable$ClassLoaderCreator {
                com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState$1() {
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
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            static {
                SavedState.CREATOR = new com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState$1();
            }

            public SavedState(Parcelable arg1) {
                super(arg1);
            }

            public SavedState(Parcel arg3, ClassLoader arg4) {
                super(arg3, arg4);
                boolean v0 = true;
                boolean v4 = arg3.readByte() != 0 ? true : false;
                this.fullyScrolled = v4;
                v4 = arg3.readByte() != 0 ? true : false;
                this.fullyExpanded = v4;
                this.firstVisibleChildIndex = arg3.readInt();
                this.firstVisibleChildPercentageShown = arg3.readFloat();
                if(arg3.readByte() != 0) {
                }
                else {
                    v0 = false;
                }

                this.firstVisibleChildAtMinimumHeight = v0;
            }

            public void writeToParcel(Parcel arg1, int arg2) {
                super.writeToParcel(arg1, arg2);
                arg1.writeByte(((byte)this.fullyScrolled));
                arg1.writeByte(((byte)this.fullyExpanded));
                arg1.writeInt(this.firstVisibleChildIndex);
                arg1.writeFloat(this.firstVisibleChildPercentageShown);
                arg1.writeByte(((byte)this.firstVisibleChildAtMinimumHeight));
            }
        }

        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private boolean coordinatorLayoutA11yScrollable;
        private WeakReference lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private BaseDragCallback onDragCallback;
        private SavedState savedState;

        public BaseBehavior() {
            super();
        }

        public BaseBehavior(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        static boolean access$000(BaseBehavior arg0) {
            return arg0.coordinatorLayoutA11yScrollable;
        }

        static int access$100(BaseBehavior arg0) {
            return arg0.offsetDelta;
        }

        private boolean addAccessibilityScrollActions(CoordinatorLayout arg11, AppBarLayout arg12, View arg13) {
            boolean v3 = false;
            if(this.getTopBottomOffsetForScrollingSibling() != -arg12.getTotalScrollRange()) {
                this.addActionToExpand(arg11, arg12, AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
                v3 = true;
            }

            if(this.getTopBottomOffsetForScrollingSibling() != 0) {
                if(arg13.canScrollVertically(-1)) {
                    int v9 = -arg12.getDownNestedPreScrollRange();
                    if(v9 != 0) {
                        ViewCompat.replaceAccessibilityAction(arg11, AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AccessibilityViewCommand(arg11, arg12, arg13, v9) {
                            public boolean perform(View arg9, CommandArguments arg10) {
                                BaseBehavior.this.onNestedPreScroll(this.val$coordinatorLayout, this.val$appBarLayout, this.val$scrollingView, 0, this.val$dy, new int[]{0, 0}, 1);
                                return 1;
                            }
                        });
                        return 1;
                    }
                }
                else {
                    this.addActionToExpand(arg11, arg12, AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
                    return 1;
                }
            }

            return v3;
        }

        private void addActionToExpand(CoordinatorLayout arg2, AppBarLayout arg3, AccessibilityActionCompat arg4, boolean arg5) {
            ViewCompat.replaceAccessibilityAction(((View)arg2), arg4, null, new AccessibilityViewCommand(arg3, arg5) {
                public boolean perform(View arg1, CommandArguments arg2) {
                    this.val$appBarLayout.setExpanded(this.val$expand);
                    return 1;
                }
            });
        }

        private void animateOffsetTo(CoordinatorLayout arg3, AppBarLayout arg4, int arg5, float arg6) {
            int v0 = Math.abs(this.getTopBottomOffsetForScrollingSibling() - arg5);
            arg6 = Math.abs(arg6);
            int v6 = arg6 > 0f ? Math.round((((float)v0)) / arg6 * 1000f) * 3 : ((int)(((((float)v0)) / (((float)arg4.getHeight())) + 1f) * 150f));
            this.animateOffsetWithDuration(arg3, arg4, arg5, v6);
        }

        private void animateOffsetWithDuration(CoordinatorLayout arg4, AppBarLayout arg5, int arg6, int arg7) {
            int v0 = this.getTopBottomOffsetForScrollingSibling();
            ValueAnimator v1 = this.offsetAnimator;
            if(v0 == arg6) {
                if(v1 != null && (v1.isRunning())) {
                    this.offsetAnimator.cancel();
                }

                return;
            }

            if(v1 == null) {
                v1 = new ValueAnimator();
                this.offsetAnimator = v1;
                v1.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.offsetAnimator.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(arg4, arg5) {
                    public void onAnimationUpdate(ValueAnimator arg3) {
                        BaseBehavior.this.setHeaderTopBottomOffset(this.val$coordinatorLayout, this.val$child, arg3.getAnimatedValue().intValue());
                    }
                });
            }
            else {
                v1.cancel();
            }

            this.offsetAnimator.setDuration(((long)Math.min(arg7, 600)));
            this.offsetAnimator.setIntValues(new int[]{v0, arg6});
            this.offsetAnimator.start();
        }

        private int calculateSnapOffset(int arg1, int arg2, int arg3) {
            if(arg1 < (arg2 + arg3) / 2) {
                return arg2;
            }

            return arg3;
        }

        boolean canDragView(View arg1) {
            return this.canDragView(((AppBarLayout)arg1));
        }

        boolean canDragView(AppBarLayout arg2) {
            BaseDragCallback v0 = this.onDragCallback;
            if(v0 != null) {
                return v0.canDrag(arg2);
            }

            WeakReference v1 = this.lastNestedScrollingChildRef;
            if(v1 != null) {
                Object v1_1 = v1.get();
                if(v1_1 != null && (((View)v1_1).isShown()) && !((View)v1_1).canScrollVertically(-1)) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        private boolean canScrollChildren(CoordinatorLayout arg1, AppBarLayout arg2, View arg3) {
            if((arg2.hasScrollableChildren()) && arg1.getHeight() - arg3.getHeight() <= arg2.getHeight()) {
                return 1;
            }

            return 0;
        }

        private static boolean checkFlag(int arg0, int arg1) {
            if((arg0 & arg1) == arg1) {
                return 1;
            }

            return 0;
        }

        private boolean childrenHaveScrollFlags(AppBarLayout arg4) {
            int v3 = arg4.getChildCount();
            int v1;
            for(v1 = 0; v1 < v3; ++v1) {
                if(arg4.getChildAt(v1).getLayoutParams().scrollFlags != 0) {
                    return 1;
                }
            }

            return 0;
        }

        private View findFirstScrollingChild(CoordinatorLayout arg4) {
            View v1;
            int v3 = arg4.getChildCount();
            int v0 = 0;
            while(true) {
                if(v0 >= v3) {
                    return null;
                }

                v1 = arg4.getChildAt(v0);
                if(!(v1 instanceof NestedScrollingChild) && !(v1 instanceof AbsListView)) {
                    if((v1 instanceof ScrollView)) {
                    }
                    else {
                        ++v0;
                        continue;
                    }
                }

                return v1;
            }

            return v1;
        }

        private static View getAppBarChildOnOffset(AppBarLayout arg4, int arg5) {
            arg5 = Math.abs(arg5);
            int v0 = arg4.getChildCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                View v2 = arg4.getChildAt(v1);
                if(arg5 >= v2.getTop() && arg5 <= v2.getBottom()) {
                    return v2;
                }
            }

            return null;
        }

        private int getChildIndexOnOffset(AppBarLayout arg7, int arg8) {
            int v6 = arg7.getChildCount();
            int v0;
            for(v0 = 0; v0 < v6; ++v0) {
                View v1 = arg7.getChildAt(v0);
                int v2 = v1.getTop();
                int v3 = v1.getBottom();
                ViewGroup$LayoutParams v1_1 = v1.getLayoutParams();
                if(BaseBehavior.checkFlag(((LayoutParams)v1_1).getScrollFlags(), 0x20)) {
                    v2 -= ((LayoutParams)v1_1).topMargin;
                    v3 += ((LayoutParams)v1_1).bottomMargin;
                }

                int v1_2 = -arg8;
                if(v2 <= v1_2 && v3 >= v1_2) {
                    return v0;
                }
            }

            return -1;
        }

        private View getChildWithScrollingBehavior(CoordinatorLayout arg4) {
            int v3 = arg4.getChildCount();
            int v0;
            for(v0 = 0; v0 < v3; ++v0) {
                View v1 = arg4.getChildAt(v0);
                if((v1.getLayoutParams().getBehavior() instanceof ScrollingViewBehavior)) {
                    return v1;
                }
            }

            return null;
        }

        int getMaxDragOffset(View arg1) {
            return this.getMaxDragOffset(((AppBarLayout)arg1));
        }

        int getMaxDragOffset(AppBarLayout arg1) {
            return -arg1.getDownNestedScrollRange() + arg1.getTopInset();
        }

        int getScrollRangeForDragFling(View arg1) {
            return this.getScrollRangeForDragFling(((AppBarLayout)arg1));
        }

        int getScrollRangeForDragFling(AppBarLayout arg1) {
            return arg1.getTotalScrollRange();
        }

        int getTopBottomOffsetForScrollingSibling() {
            return this.getTopAndBottomOffset() + this.offsetDelta;
        }

        private int interpolateOffset(AppBarLayout arg8, int arg9) {
            int v7 = Math.abs(arg9);
            int v0 = arg8.getChildCount();
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                View v3 = arg8.getChildAt(v2);
                ViewGroup$LayoutParams v4 = v3.getLayoutParams();
                Interpolator v5 = ((LayoutParams)v4).getScrollInterpolator();
                if(v7 >= v3.getTop() && v7 <= v3.getBottom()) {
                    if(v5 != null) {
                        v0 = ((LayoutParams)v4).getScrollFlags();
                        if((v0 & 1) != 0) {
                            v1 = v3.getHeight() + ((LayoutParams)v4).topMargin + ((LayoutParams)v4).bottomMargin;
                            if((v0 & 2) != 0) {
                                v1 -= ViewCompat.getMinimumHeight(v3);
                            }
                        }

                        if(ViewCompat.getFitsSystemWindows(v3)) {
                            v1 -= arg8.getTopInset();
                        }

                        if(v1 <= 0) {
                            return arg9;
                        }

                        float v8 = ((float)v1);
                        return Integer.signum(arg9) * (v3.getTop() + Math.round(v8 * v5.getInterpolation((((float)(v7 - v3.getTop()))) / v8)));
                    }
                    else {
                        return arg9;
                    }
                }
            }

            return arg9;
        }

        boolean isOffsetAnimatorRunning() {
            ValueAnimator v0 = this.offsetAnimator;
            if(v0 != null && (v0.isRunning())) {
                return 1;
            }

            return 0;
        }

        void onFlingFinished(CoordinatorLayout arg1, View arg2) {
            this.onFlingFinished(arg1, ((AppBarLayout)arg2));
        }

        void onFlingFinished(CoordinatorLayout arg2, AppBarLayout arg3) {
            this.snapToChildIfNeeded(arg2, arg3);
            if(arg3.isLiftOnScroll()) {
                arg3.setLiftedState(arg3.shouldLift(this.findFirstScrollingChild(arg2)));
            }
        }

        public boolean onLayoutChild(CoordinatorLayout arg1, View arg2, int arg3) {
            return this.onLayoutChild(arg1, ((AppBarLayout)arg2), arg3);
        }

        public boolean onLayoutChild(CoordinatorLayout arg8, AppBarLayout arg9, int arg10) {
            int v1_1;
            boolean v10 = super.onLayoutChild(arg8, ((View)arg9), arg10);
            int v0 = arg9.getPendingAction();
            SavedState v1 = this.savedState;
            if(v1 == null || (v0 & 8) != 0) {
                if(v0 == 0) {
                    goto label_62;
                }

                v1_1 = (v0 & 4) != 0 ? 1 : 0;
                if((v0 & 2) != 0) {
                    v0 = -arg9.getUpNestedPreScrollRange();
                    if(v1_1 != 0) {
                        this.animateOffsetTo(arg8, arg9, v0, 0f);
                        goto label_62;
                    }

                    this.setHeaderTopBottomOffset(arg8, ((View)arg9), v0);
                    goto label_62;
                }

                if((v0 & 1) == 0) {
                    goto label_62;
                }

                if(v1_1 != 0) {
                    this.animateOffsetTo(arg8, arg9, 0, 0f);
                    goto label_62;
                }

                this.setHeaderTopBottomOffset(arg8, ((View)arg9), 0);
            }
            else if(v1.fullyScrolled) {
                this.setHeaderTopBottomOffset(arg8, ((View)arg9), -arg9.getTotalScrollRange());
            }
            else if(this.savedState.fullyExpanded) {
                this.setHeaderTopBottomOffset(arg8, ((View)arg9), 0);
            }
            else {
                View v0_1 = arg9.getChildAt(this.savedState.firstVisibleChildIndex);
                v1_1 = -v0_1.getBottom();
                v0 = this.savedState.firstVisibleChildAtMinimumHeight ? ViewCompat.getMinimumHeight(v0_1) + arg9.getTopInset() : Math.round((((float)v0_1.getHeight())) * this.savedState.firstVisibleChildPercentageShown);
                this.setHeaderTopBottomOffset(arg8, ((View)arg9), v1_1 + v0);
            }

        label_62:
            arg9.resetPendingAction();
            this.savedState = null;
            this.setTopAndBottomOffset(MathUtils.clamp(this.getTopAndBottomOffset(), -arg9.getTotalScrollRange(), 0));
            this.updateAppBarLayoutDrawableState(arg8, arg9, this.getTopAndBottomOffset(), 0, true);
            arg9.onOffsetChanged(this.getTopAndBottomOffset());
            this.updateAccessibilityActions(arg8, arg9);
            return v10;
        }

        public boolean onMeasureChild(CoordinatorLayout arg1, View arg2, int arg3, int arg4, int arg5, int arg6) {
            return this.onMeasureChild(arg1, ((AppBarLayout)arg2), arg3, arg4, arg5, arg6);
        }

        public boolean onMeasureChild(CoordinatorLayout arg8, AppBarLayout arg9, int arg10, int arg11, int arg12, int arg13) {
            if(arg9.getLayoutParams().height == -2) {
                arg8.onMeasureChild(((View)arg9), arg10, arg11, View$MeasureSpec.makeMeasureSpec(0, 0), arg13);
                return 1;
            }

            return super.onMeasureChild(arg8, arg9, arg10, arg11, arg12, arg13);
        }

        public void onNestedPreScroll(CoordinatorLayout arg7, AppBarLayout arg8, View arg9, int arg10, int arg11, int[] arg12, int arg13) {
            AppBarLayout v2;
            if(arg11 != 0) {
                if(arg11 < 0) {
                    arg10 = -arg8.getTotalScrollRange();
                    arg13 = arg8.getDownNestedPreScrollRange() + arg10;
                }
                else {
                    arg10 = -arg8.getUpNestedPreScrollRange();
                    arg13 = 0;
                }

                int v4 = arg10;
                int v5 = arg13;
                if(v4 == v5) {
                    goto label_21;
                }

                v2 = arg8;
                arg12[1] = this.scroll(arg7, ((View)v2), arg11, v4, v5);
            }
            else {
            label_21:
                v2 = arg8;
            }

            if(v2.isLiftOnScroll()) {
                v2.setLiftedState(v2.shouldLift(arg9));
            }
        }

        public void onNestedPreScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4, int arg5, int[] arg6, int arg7) {
            this.onNestedPreScroll(arg1, ((AppBarLayout)arg2), arg3, arg4, arg5, arg6, arg7);
        }

        public void onNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int[] arg9) {
            this.onNestedScroll(arg1, ((AppBarLayout)arg2), arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        }

        public void onNestedScroll(CoordinatorLayout arg7, AppBarLayout arg8, View arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int[] arg15) {
            int v3;
            AppBarLayout v2;
            CoordinatorLayout v1;
            BaseBehavior v0;
            if(arg13 < 0) {
                v0 = this;
                v1 = arg7;
                v2 = arg8;
                v3 = arg13;
                arg15[1] = v0.scroll(v1, ((View)v2), v3, -arg8.getDownNestedScrollRange(), 0);
            }
            else {
                v0 = this;
                v1 = arg7;
                v2 = arg8;
                v3 = arg13;
            }

            if(v3 == 0) {
                v0.updateAccessibilityActions(v1, v2);
            }
        }

        public void onRestoreInstanceState(CoordinatorLayout arg1, View arg2, Parcelable arg3) {
            this.onRestoreInstanceState(arg1, ((AppBarLayout)arg2), arg3);
        }

        public void onRestoreInstanceState(CoordinatorLayout arg2, AppBarLayout arg3, Parcelable arg4) {
            if((arg4 instanceof SavedState)) {
                this.restoreScrollState(((SavedState)arg4), true);
                super.onRestoreInstanceState(arg2, ((View)arg3), this.savedState.getSuperState());
                return;
            }

            super.onRestoreInstanceState(arg2, ((View)arg3), arg4);
            this.savedState = null;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout arg1, View arg2) {
            return this.onSaveInstanceState(arg1, ((AppBarLayout)arg2));
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout arg1, AppBarLayout arg2) {
            Parcelable v1 = super.onSaveInstanceState(arg1, ((View)arg2));
            SavedState v0 = this.saveScrollState(v1, arg2);
            if(v0 == null) {
                return v1;
            }

            return ((Parcelable)v0);
        }

        public boolean onStartNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, View arg4, int arg5, int arg6) {
            return this.onStartNestedScroll(arg1, ((AppBarLayout)arg2), arg3, arg4, arg5, arg6);
        }

        public boolean onStartNestedScroll(CoordinatorLayout arg1, AppBarLayout arg2, View arg3, View arg4, int arg5, int arg6) {
            boolean v1;
            if((arg5 & 2) != 0) {
                if(!arg2.isLiftOnScroll() && !this.canScrollChildren(arg1, arg2, arg3)) {
                    goto label_8;
                }

                v1 = true;
            }
            else {
            label_8:
                v1 = false;
            }

            if(v1) {
                ValueAnimator v2 = this.offsetAnimator;
                if(v2 != null) {
                    v2.cancel();
                }
            }

            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = arg6;
            return v1;
        }

        public void onStopNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4) {
            this.onStopNestedScroll(arg1, ((AppBarLayout)arg2), arg3, arg4);
        }

        public void onStopNestedScroll(CoordinatorLayout arg2, AppBarLayout arg3, View arg4, int arg5) {
            if(this.lastStartedType == 0 || arg5 == 1) {
                this.snapToChildIfNeeded(arg2, arg3);
                if(arg3.isLiftOnScroll()) {
                    arg3.setLiftedState(arg3.shouldLift(arg4));
                }
            }

            this.lastNestedScrollingChildRef = new WeakReference(arg4);
        }

        void restoreScrollState(SavedState arg2, boolean arg3) {
            if(this.savedState != null) {
                if(arg3) {
                }
                else {
                    return;
                }
            }

            this.savedState = arg2;
        }

        SavedState saveScrollState(Parcelable arg7, AppBarLayout arg8) {
            AbsSavedState v7;
            int v6 = this.getTopAndBottomOffset();
            int v0 = arg8.getChildCount();
            boolean v1 = false;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                View v3 = arg8.getChildAt(v2);
                int v4 = v3.getBottom() + v6;
                if(v3.getTop() + v6 <= 0 && v4 >= 0) {
                    if(arg7 == null) {
                        v7 = AbsSavedState.EMPTY_STATE;
                    }

                    SavedState v0_1 = new SavedState(((Parcelable)v7));
                    boolean v5 = v6 == 0 ? true : false;
                    v0_1.fullyExpanded = v5;
                    boolean v6_1 = (v0_1.fullyExpanded) || -v6 < arg8.getTotalScrollRange() ? false : true;
                    v0_1.fullyScrolled = v6_1;
                    v0_1.firstVisibleChildIndex = v2;
                    if(v4 == ViewCompat.getMinimumHeight(v3) + arg8.getTopInset()) {
                        v1 = true;
                    }

                    v0_1.firstVisibleChildAtMinimumHeight = v1;
                    v0_1.firstVisibleChildPercentageShown = (((float)v4)) / (((float)v3.getHeight()));
                    return v0_1;
                }
            }

            return null;
        }

        public void setDragCallback(BaseDragCallback arg1) {
            this.onDragCallback = arg1;
        }

        int setHeaderTopBottomOffset(CoordinatorLayout arg1, View arg2, int arg3, int arg4, int arg5) {
            return this.setHeaderTopBottomOffset(arg1, ((AppBarLayout)arg2), arg3, arg4, arg5);
        }

        int setHeaderTopBottomOffset(CoordinatorLayout arg7, AppBarLayout arg8, int arg9, int arg10, int arg11) {
            int v0 = this.getTopBottomOffsetForScrollingSibling();
            int v1 = 0;
            if(arg10 == 0 || v0 < arg10 || v0 > arg11) {
                this.offsetDelta = 0;
            }
            else {
                arg9 = MathUtils.clamp(arg9, arg10, arg11);
                if(v0 != arg9) {
                    arg10 = arg8.hasChildWithInterpolator() ? this.interpolateOffset(arg8, arg9) : arg9;
                    boolean v11 = this.setTopAndBottomOffset(arg10);
                    int v2 = v0 - arg9;
                    this.offsetDelta = arg9 - arg10;
                    arg10 = 1;
                    if(v11) {
                        while(v1 < arg8.getChildCount()) {
                            ViewGroup$LayoutParams v3 = arg8.getChildAt(v1).getLayoutParams();
                            ChildScrollEffect v4 = ((LayoutParams)v3).getScrollEffect();
                            if(v4 != null && (((LayoutParams)v3).getScrollFlags() & 1) != 0) {
                                v4.onOffsetChanged(arg8, arg8.getChildAt(v1), ((float)this.getTopAndBottomOffset()));
                            }

                            ++v1;
                        }
                    }

                    if(!v11 && (arg8.hasChildWithInterpolator())) {
                        arg7.dispatchDependentViewsChanged(((View)arg8));
                    }

                    arg8.onOffsetChanged(this.getTopAndBottomOffset());
                    if(arg9 < v0) {
                        arg10 = -1;
                    }

                    this.updateAppBarLayoutDrawableState(arg7, arg8, arg9, arg10, false);
                    v1 = v2;
                }
            }

            this.updateAccessibilityActions(arg7, arg8);
            return v1;
        }

        private boolean shouldJumpElevationState(CoordinatorLayout arg4, AppBarLayout arg5) {
            List v3 = arg4.getDependents(((View)arg5));
            int v4 = v3.size();
            int v0;
            for(v0 = 0; v0 < v4; ++v0) {
                Behavior v1 = v3.get(v0).getLayoutParams().getBehavior();
                if((v1 instanceof ScrollingViewBehavior)) {
                    if(((ScrollingViewBehavior)v1).getOverlayTop() != 0) {
                        return 1;
                    }

                    return 0;
                }
            }

            return 0;
        }

        private void snapToChildIfNeeded(CoordinatorLayout arg9, AppBarLayout arg10) {
            int v0 = arg10.getTopInset() + arg10.getPaddingTop();
            int v1 = this.getTopBottomOffsetForScrollingSibling() - v0;
            int v2 = this.getChildIndexOnOffset(arg10, v1);
            if(v2 >= 0) {
                View v3 = arg10.getChildAt(v2);
                ViewGroup$LayoutParams v4 = v3.getLayoutParams();
                int v5 = ((LayoutParams)v4).getScrollFlags();
                if((v5 & 17) == 17) {
                    int v6 = -v3.getTop();
                    int v7 = -v3.getBottom();
                    if(v2 == 0 && (ViewCompat.getFitsSystemWindows(((View)arg10))) && (ViewCompat.getFitsSystemWindows(v3))) {
                        v6 -= arg10.getTopInset();
                    }

                    if(BaseBehavior.checkFlag(v5, 2)) {
                        v7 += ViewCompat.getMinimumHeight(v3);
                    }
                    else if(BaseBehavior.checkFlag(v5, 5)) {
                        v2 = ViewCompat.getMinimumHeight(v3) + v7;
                        if(v1 < v2) {
                            v6 = v2;
                        }
                        else {
                            v7 = v2;
                        }
                    }

                    if(BaseBehavior.checkFlag(v5, 0x20)) {
                        v6 += ((LayoutParams)v4).topMargin;
                        v7 -= ((LayoutParams)v4).bottomMargin;
                    }

                    this.animateOffsetTo(arg9, arg10, MathUtils.clamp(this.calculateSnapOffset(v1, v7, v6) + v0, -arg10.getTotalScrollRange(), 0), 0f);
                }
            }
        }

        private void updateAccessibilityActions(CoordinatorLayout arg3, AppBarLayout arg4) {
            View v0;
            ViewCompat.removeAccessibilityAction(((View)arg3), AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(((View)arg3), AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            if(arg4.getTotalScrollRange() == 0) {
            }
            else {
                v0 = this.getChildWithScrollingBehavior(arg3);
                if(v0 == null) {
                }
                else {
                    if(!this.childrenHaveScrollFlags(arg4)) {
                        return;
                    }

                    goto label_15;
                }
            }

            return;
        label_15:
            if(!ViewCompat.hasAccessibilityDelegate(((View)arg3))) {
                ViewCompat.setAccessibilityDelegate(((View)arg3), new AccessibilityDelegateCompat() {
                    public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                        super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                        arg2.setScrollable(BaseBehavior.this.coordinatorLayoutA11yScrollable);
                        arg2.setClassName(ScrollView.class.getName());
                    }
                });
            }

            this.coordinatorLayoutA11yScrollable = this.addAccessibilityScrollActions(arg3, arg4, v0);
        }

        private void updateAppBarLayoutDrawableState(CoordinatorLayout arg6, AppBarLayout arg7, int arg8, int arg9, boolean arg10) {
            View v0 = BaseBehavior.getAppBarChildOnOffset(arg7, arg8);
            boolean v1 = false;
            if(v0 != null) {
                int v2 = v0.getLayoutParams().getScrollFlags();
                if((v2 & 1) != 0) {
                    int v3 = ViewCompat.getMinimumHeight(v0);
                    if(arg9 <= 0 || (v2 & 12) == 0) {
                        if((v2 & 2) == 0) {
                            goto label_29;
                        }
                        else if(-arg8 >= v0.getBottom() - v3 - arg7.getTopInset()) {
                        }
                        else {
                            goto label_29;
                        }
                    }
                    else if(-arg8 < v0.getBottom() - v3 - arg7.getTopInset()) {
                        goto label_29;
                    }

                    v1 = true;
                }
            }

        label_29:
            if(arg7.isLiftOnScroll()) {
                v1 = arg7.shouldLift(this.findFirstScrollingChild(arg6));
            }

            boolean v8 = arg7.setLiftedState(v1);
            if((arg10) || (v8) && (this.shouldJumpElevationState(arg6, arg7))) {
                if(arg7.getBackground() != null) {
                    arg7.getBackground().jumpToCurrentState();
                }

                if(arg7.getForeground() != null) {
                    arg7.getForeground().jumpToCurrentState();
                }

                if(arg7.getStateListAnimator() == null) {
                    return;
                }

                arg7.getStateListAnimator().jumpToCurrentState();
            }
        }
    }

    public interface BaseOnOffsetChangedListener {
        void onOffsetChanged(AppBarLayout arg1, int arg2);
    }

    public class com.google.android.material.appbar.AppBarLayout$Behavior extends BaseBehavior {
        public abstract class DragCallback extends BaseDragCallback {
            public DragCallback() {
                super();
            }
        }

        public com.google.android.material.appbar.AppBarLayout$Behavior() {
            super();
        }

        public com.google.android.material.appbar.AppBarLayout$Behavior(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        public int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout arg1, View arg2, MotionEvent arg3) {
            return super.onInterceptTouchEvent(arg1, arg2, arg3);
        }

        public boolean onLayoutChild(CoordinatorLayout arg1, AppBarLayout arg2, int arg3) {
            return super.onLayoutChild(arg1, arg2, arg3);
        }

        public boolean onMeasureChild(CoordinatorLayout arg1, AppBarLayout arg2, int arg3, int arg4, int arg5, int arg6) {
            return super.onMeasureChild(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public void onNestedPreScroll(CoordinatorLayout arg1, AppBarLayout arg2, View arg3, int arg4, int arg5, int[] arg6, int arg7) {
            super.onNestedPreScroll(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public void onNestedScroll(CoordinatorLayout arg1, AppBarLayout arg2, View arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int[] arg9) {
            super.onNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        }

        public void onRestoreInstanceState(CoordinatorLayout arg1, AppBarLayout arg2, Parcelable arg3) {
            super.onRestoreInstanceState(arg1, arg2, arg3);
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout arg1, AppBarLayout arg2) {
            return super.onSaveInstanceState(arg1, arg2);
        }

        public boolean onStartNestedScroll(CoordinatorLayout arg1, AppBarLayout arg2, View arg3, View arg4, int arg5, int arg6) {
            return super.onStartNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public void onStopNestedScroll(CoordinatorLayout arg1, AppBarLayout arg2, View arg3, int arg4) {
            super.onStopNestedScroll(arg1, arg2, arg3, arg4);
        }

        public boolean onTouchEvent(CoordinatorLayout arg1, View arg2, MotionEvent arg3) {
            return super.onTouchEvent(arg1, arg2, arg3);
        }

        public void setDragCallback(BaseDragCallback arg1) {
            super.setDragCallback(arg1);
        }

        public void setHorizontalOffsetEnabled(boolean arg1) {
            super.setHorizontalOffsetEnabled(arg1);
        }

        public boolean setLeftAndRightOffset(int arg1) {
            return super.setLeftAndRightOffset(arg1);
        }

        public boolean setTopAndBottomOffset(int arg1) {
            return super.setTopAndBottomOffset(arg1);
        }

        public void setVerticalOffsetEnabled(boolean arg1) {
            super.setVerticalOffsetEnabled(arg1);
        }
    }

    public abstract class ChildScrollEffect {
        public ChildScrollEffect() {
            super();
        }

        public abstract void onOffsetChanged(AppBarLayout arg1, View arg2, float arg3);
    }

    public class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect ghostRect;
        private final Rect relativeRect;

        public CompressChildScrollEffect() {
            super();
            this.relativeRect = new Rect();
            this.ghostRect = new Rect();
        }

        public void onOffsetChanged(AppBarLayout arg3, View arg4, float arg5) {
            CompressChildScrollEffect.updateRelativeRect(this.relativeRect, arg3, arg4);
            float v3 = (((float)this.relativeRect.top)) - Math.abs(arg5);
            if(v3 <= 0f) {
                arg5 = 1f - MathUtils.clamp(Math.abs(v3 / (((float)this.relativeRect.height()))), 0f, 1f);
                v3 = -v3 - (((float)this.relativeRect.height())) * 0.3f * (1f - arg5 * arg5);
                arg4.setTranslationY(v3);
                arg4.getDrawingRect(this.ghostRect);
                this.ghostRect.offset(0, ((int)(-v3)));
                ViewCompat.setClipBounds(arg4, this.ghostRect);
                return;
            }

            ViewCompat.setClipBounds(arg4, null);
            arg4.setTranslationY(0f);
        }

        private static void updateRelativeRect(Rect arg0, AppBarLayout arg1, View arg2) {
            arg2.getDrawingRect(arg0);
            arg1.offsetDescendantRectToMyCoords(arg2, arg0);
            arg0.offset(0, -arg1.getTopInset());
        }
    }

    public class LayoutParams extends LinearLayout$LayoutParams {
        @Retention(value=RetentionPolicy.SOURCE) @public interface ScrollEffect {
        }

        @Retention(value=RetentionPolicy.SOURCE) @public interface ScrollFlags {
        }

        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_EFFECT_COMPRESS = 1;
        public static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 0x20;
        private ChildScrollEffect scrollEffect;
        int scrollFlags;
        Interpolator scrollInterpolator;

        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
            this.scrollFlags = 1;
        }

        public LayoutParams(Context arg3, AttributeSet arg4) {
            super(arg3, arg4);
            this.scrollFlags = 1;
            TypedArray v4 = arg3.obtainStyledAttributes(arg4, styleable.AppBarLayout_Layout);
            this.scrollFlags = v4.getInt(styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            this.setScrollEffect(v4.getInt(styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            if(v4.hasValue(styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(arg3, v4.getResourceId(styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }

            v4.recycle();
        }

        public LayoutParams(LinearLayout$LayoutParams arg1) {
            super(arg1);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg1) {
            super(arg1);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
            this.scrollFlags = 1;
        }

        public LayoutParams(int arg1, int arg2, float arg3) {
            super(arg1, arg2, arg3);
            this.scrollFlags = 1;
        }

        public LayoutParams(LayoutParams arg2) {
            super(((LinearLayout$LayoutParams)arg2));
            this.scrollFlags = 1;
            this.scrollFlags = arg2.scrollFlags;
            this.scrollEffect = arg2.scrollEffect;
            this.scrollInterpolator = arg2.scrollInterpolator;
        }

        private ChildScrollEffect createScrollEffectFromInt(int arg1) {
            if(arg1 != 1) {
                return null;
            }

            return new CompressChildScrollEffect();
        }

        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        boolean isCollapsible() {
            int v2 = this.scrollFlags;
            if((v2 & 1) == 1 && (v2 & 10) != 0) {
                return 1;
            }

            return 0;
        }

        public void setScrollEffect(int arg1) {
            this.scrollEffect = this.createScrollEffectFromInt(arg1);
        }

        public void setScrollEffect(ChildScrollEffect arg1) {
            this.scrollEffect = arg1;
        }

        public void setScrollFlags(int arg1) {
            this.scrollFlags = arg1;
        }

        public void setScrollInterpolator(Interpolator arg1) {
            this.scrollInterpolator = arg1;
        }
    }

    public interface LiftOnScrollListener {
        void onUpdate(float arg1, int arg2);
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener {
        void onOffsetChanged(AppBarLayout arg1, int arg2);
    }

    public class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
            super();
        }

        public ScrollingViewBehavior(Context arg2, AttributeSet arg3) {
            super(arg2, arg3);
            TypedArray v2 = arg2.obtainStyledAttributes(arg3, styleable.ScrollingViewBehavior_Layout);
            this.setOverlayTop(v2.getDimensionPixelSize(styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            v2.recycle();
        }

        View findFirstDependency(List arg1) {
            return this.findFirstDependency(arg1);
        }

        AppBarLayout findFirstDependency(List arg4) {
            int v3 = arg4.size();
            int v0;
            for(v0 = 0; v0 < v3; ++v0) {
                Object v1 = arg4.get(v0);
                if((v1 instanceof AppBarLayout)) {
                    return ((AppBarLayout)v1);
                }
            }

            return null;
        }

        private static int getAppBarLayoutOffset(AppBarLayout arg1) {
            Behavior v1 = arg1.getLayoutParams().getBehavior();
            if((v1 instanceof BaseBehavior)) {
                return ((BaseBehavior)v1).getTopBottomOffsetForScrollingSibling();
            }

            return 0;
        }

        public int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        float getOverlapRatioForOffset(View arg4) {
            if((arg4 instanceof AppBarLayout)) {
                int v3 = ((AppBarLayout)arg4).getTotalScrollRange();
                int v1 = ((AppBarLayout)arg4).getDownNestedPreScrollRange();
                int v4 = ScrollingViewBehavior.getAppBarLayoutOffset(((AppBarLayout)arg4));
                if(v1 != 0 && v3 + v4 <= v1) {
                    return 0;
                }

                v3 -= v1;
                if(v3 == 0) {
                    return 0;
                }

                return (((float)v4)) / (((float)v3)) + 1f;
            }

            return 0;
        }

        int getScrollRange(View arg2) {
            if((arg2 instanceof AppBarLayout)) {
                return ((AppBarLayout)arg2).getTotalScrollRange();
            }

            return super.getScrollRange(arg2);
        }

        public int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public boolean layoutDependsOn(CoordinatorLayout arg1, View arg2, View arg3) {
            return arg3 instanceof AppBarLayout;
        }

        private void offsetChildAsNeeded(View arg4, View arg5) {
            Behavior v0 = arg5.getLayoutParams().getBehavior();
            if((v0 instanceof BaseBehavior)) {
                ViewCompat.offsetTopAndBottom(arg4, arg5.getBottom() - arg4.getTop() + ((BaseBehavior)v0).offsetDelta + this.getVerticalLayoutGap() - this.getOverlapPixelsForOffset(arg5));
            }
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg1, View arg2, View arg3) {
            this.offsetChildAsNeeded(arg2, arg3);
            this.updateLiftedStateIfNeeded(arg2, arg3);
            return 0;
        }

        public void onDependentViewRemoved(CoordinatorLayout arg1, View arg2, View arg3) {
            if((arg3 instanceof AppBarLayout)) {
                ViewCompat.removeAccessibilityAction(((View)arg1), AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(((View)arg1), AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
                ViewCompat.setAccessibilityDelegate(((View)arg1), null);
            }
        }

        public boolean onLayoutChild(CoordinatorLayout arg1, View arg2, int arg3) {
            return super.onLayoutChild(arg1, arg2, arg3);
        }

        public boolean onMeasureChild(CoordinatorLayout arg1, View arg2, int arg3, int arg4, int arg5, int arg6) {
            return super.onMeasureChild(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout arg4, View arg5, Rect arg6, boolean arg7) {
            AppBarLayout v0 = this.findFirstDependency(arg4.getDependencies(arg5));
            if(v0 != null) {
                Rect v2 = new Rect(arg6);
                v2.offset(arg5.getLeft(), arg5.getTop());
                Rect v3 = this.tempRect1;
                v3.set(0, 0, arg4.getWidth(), arg4.getHeight());
                if(!v3.contains(v2)) {
                    v0.setExpanded(false, (((int)arg7)) ^ 1);
                    return 1;
                }
            }

            return 0;
        }

        public void setHorizontalOffsetEnabled(boolean arg1) {
            super.setHorizontalOffsetEnabled(arg1);
        }

        public boolean setLeftAndRightOffset(int arg1) {
            return super.setLeftAndRightOffset(arg1);
        }

        public boolean setTopAndBottomOffset(int arg1) {
            return super.setTopAndBottomOffset(arg1);
        }

        public void setVerticalOffsetEnabled(boolean arg1) {
            super.setVerticalOffsetEnabled(arg1);
        }

        private void updateLiftedStateIfNeeded(View arg1, View arg2) {
            if(((arg2 instanceof AppBarLayout)) && (((AppBarLayout)arg2).isLiftOnScroll())) {
                ((AppBarLayout)arg2).setLiftedState(((AppBarLayout)arg2).shouldLift(arg1));
            }
        }
    }

    private static final int DEF_STYLE_RES = 0;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE;
    private final float appBarElevation;
    private com.google.android.material.appbar.AppBarLayout$Behavior behavior;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private final boolean hasLiftOnScrollColor;
    private boolean haveChildWithInterpolator;
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    private ValueAnimator liftOnScrollColorAnimator;
    private final long liftOnScrollColorDuration;
    private final TimeInterpolator liftOnScrollColorInterpolator;
    private ValueAnimator$AnimatorUpdateListener liftOnScrollColorUpdateListener;
    private final List liftOnScrollListeners;
    private WeakReference liftOnScrollTargetView;
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List listeners;
    private int pendingAction;
    private Drawable statusBarForeground;
    private Integer statusBarForegroundOriginalColor;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    static {
        AppBarLayout.DEF_STYLE_RES = style.Widget_Design_AppBarLayout;
    }

    public AppBarLayout(Context arg2) {
        this(arg2, null);
    }

    public AppBarLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.appBarLayoutStyle);
    }

    public AppBarLayout(Context arg9, AttributeSet arg10, int arg11) {
        int v4 = AppBarLayout.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg9, arg10, arg11, v4), arg10, arg11);
        int v9 = -1;
        this.totalScrollRange = v9;
        this.downPreScrollRange = v9;
        this.downScrollRange = v9;
        this.pendingAction = 0;
        this.liftOnScrollListeners = new ArrayList();
        Context v0 = this.getContext();
        boolean v7 = true;
        this.setOrientation(1);
        if(this.getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            ViewUtilsLollipop.setBoundsViewOutlineProvider(((View)this));
        }

        ViewUtilsLollipop.setStateListAnimatorFromAttrs(((View)this), arg10, arg11, v4);
        TypedArray v10 = ThemeEnforcement.obtainStyledAttributes(v0, arg10, styleable.AppBarLayout, arg11, v4, new int[0]);
        ViewCompat.setBackground(((View)this), v10.getDrawable(styleable.AppBarLayout_android_background));
        ColorStateList v11 = MaterialResources.getColorStateList(v0, v10, styleable.AppBarLayout_liftOnScrollColor);
        if(v11 != null) {
        }
        else {
            v7 = false;
        }

        this.hasLiftOnScrollColor = v7;
        ColorStateList v1 = DrawableUtils.getColorStateListOrNull(this.getBackground());
        if(v1 != null) {
            MaterialShapeDrawable v2 = new MaterialShapeDrawable();
            v2.setFillColor(v1);
            if(v11 != null) {
                this.initializeLiftOnScrollWithColor(v2, v1, v11);
            }
            else {
                this.initializeLiftOnScrollWithElevation(v0, v2);
            }
        }

        this.liftOnScrollColorDuration = ((long)MotionUtils.resolveThemeDuration(v0, attr.motionDurationMedium2, this.getResources().getInteger(integer.app_bar_elevation_anim_duration)));
        this.liftOnScrollColorInterpolator = MotionUtils.resolveThemeInterpolator(v0, attr.motionEasingStandardInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        if(v10.hasValue(styleable.AppBarLayout_expanded)) {
            this.setExpanded(v10.getBoolean(styleable.AppBarLayout_expanded, false), false, false);
        }

        if(v10.hasValue(styleable.AppBarLayout_elevation)) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(((View)this), ((float)v10.getDimensionPixelSize(styleable.AppBarLayout_elevation, 0)));
        }

        if(v10.hasValue(styleable.AppBarLayout_android_keyboardNavigationCluster)) {
            this.setKeyboardNavigationCluster(v10.getBoolean(styleable.AppBarLayout_android_keyboardNavigationCluster, false));
        }

        if(v10.hasValue(styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
            this.setTouchscreenBlocksFocus(v10.getBoolean(styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
        }

        this.appBarElevation = this.getResources().getDimension(dimen.design_appbar_elevation);
        this.liftOnScroll = v10.getBoolean(styleable.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = v10.getResourceId(styleable.AppBarLayout_liftOnScrollTargetViewId, v9);
        this.setStatusBarForeground(v10.getDrawable(styleable.AppBarLayout_statusBarForeground));
        v10.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(((View)this), new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View arg1, WindowInsetsCompat arg2) {
                return AppBarLayout.this.onWindowInsetChanged(arg2);
            }
        });
    }

    public void addLiftOnScrollListener(LiftOnScrollListener arg1) {
        this.liftOnScrollListeners.add(arg1);
    }

    public void addOnOffsetChangedListener(BaseOnOffsetChangedListener arg2) {
        if(this.listeners == null) {
            this.listeners = new ArrayList();
        }

        if(arg2 != null && !this.listeners.contains(arg2)) {
            this.listeners.add(arg2);
        }
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener arg1) {
        this.addOnOffsetChangedListener(((BaseOnOffsetChangedListener)arg1));
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg1) {
        return arg1 instanceof LayoutParams;
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference v0 = this.liftOnScrollTargetView;
        if(v0 != null) {
            v0.clear();
        }

        this.liftOnScrollTargetView = null;
    }

    public void draw(Canvas arg4) {
        super.draw(arg4);
        if(this.shouldDrawStatusBarForeground()) {
            int v0 = arg4.save();
            arg4.translate(0f, ((float)(-this.currentOffset)));
            this.statusBarForeground.draw(arg4);
            arg4.restoreToCount(v0);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] v0 = this.getDrawableState();
        Drawable v1 = this.statusBarForeground;
        if(v1 != null && (v1.isStateful()) && (v1.setState(v0))) {
            this.invalidateDrawable(v1);
        }
    }

    private Integer extractStatusBarForegroundColor() {
        Drawable v1 = this.statusBarForeground;
        if((v1 instanceof MaterialShapeDrawable)) {
            return Integer.valueOf(((MaterialShapeDrawable)v1).getResolvedTintColor());
        }

        ColorStateList v1_1 = DrawableUtils.getColorStateListOrNull(v1);
        if(v1_1 != null) {
            return Integer.valueOf(v1_1.getDefaultColor());
        }

        return null;
    }

    private View findLiftOnScrollTargetView(View arg4) {
        View v1 = null;
        if(this.liftOnScrollTargetView == null) {
            int v0 = this.liftOnScrollTargetViewId;
            if(v0 != -1) {
                arg4 = arg4 != null ? arg4.findViewById(v0) : v1;
                if(arg4 == null && ((this.getParent() instanceof ViewGroup))) {
                    arg4 = this.getParent().findViewById(this.liftOnScrollTargetViewId);
                }

                if(arg4 == null) {
                    goto label_21;
                }

                this.liftOnScrollTargetView = new WeakReference(arg4);
            }
        }

    label_21:
        WeakReference v3 = this.liftOnScrollTargetView;
        if(v3 != null) {
            return v3.get();
        }

        return v1;
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    protected LinearLayout$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    public LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return this.generateLayoutParams(arg1);
    }

    protected LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        if((arg1 instanceof LinearLayout$LayoutParams)) {
            return new LayoutParams(((LinearLayout$LayoutParams)arg1));
        }

        if((arg1 instanceof ViewGroup$MarginLayoutParams)) {
            return new LayoutParams(((ViewGroup$MarginLayoutParams)arg1));
        }

        return new LayoutParams(arg1);
    }

    public LinearLayout$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    protected LinearLayout$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return this.generateLayoutParams(arg1);
    }

    public Behavior getBehavior() {
        com.google.android.material.appbar.AppBarLayout$Behavior v0 = new com.google.android.material.appbar.AppBarLayout$Behavior();
        this.behavior = v0;
        return ((Behavior)v0);
    }

    int getDownNestedPreScrollRange() {
        int v4_1;
        int v0 = this.downPreScrollRange;
        if(v0 != -1) {
            return v0;
        }

        v0 = this.getChildCount() - 1;
        int v2 = 0;
        while(v0 >= 0) {
            View v3 = this.getChildAt(v0);
            if(v3.getVisibility() == 8) {
            }
            else {
                ViewGroup$LayoutParams v4 = v3.getLayoutParams();
                int v5 = v3.getMeasuredHeight();
                int v6 = ((LayoutParams)v4).scrollFlags;
                if((v6 & 5) == 5) {
                    int v7 = ((LayoutParams)v4).topMargin + ((LayoutParams)v4).bottomMargin;
                    if((v6 & 8) != 0) {
                        v4_1 = ViewCompat.getMinimumHeight(v3);
                        goto label_26;
                    }
                    else if((v6 & 2) != 0) {
                        v4_1 = v5 - ViewCompat.getMinimumHeight(v3);
                    label_26:
                        v7 += v4_1;
                    }
                    else {
                        v7 += v5;
                    }

                    if(v0 == 0 && (ViewCompat.getFitsSystemWindows(v3))) {
                        v7 = Math.min(v7, v5 - this.getTopInset());
                    }

                    v2 += v7;
                }
                else {
                    if(v2 <= 0) {
                        goto label_44;
                    }

                    break;
                }
            }

        label_44:
            --v0;
        }

        v0 = Math.max(0, v2);
        this.downPreScrollRange = v0;
        return v0;
    }

    int getDownNestedScrollRange() {
        int v0 = this.downScrollRange;
        if(v0 != -1) {
            return v0;
        }

        v0 = this.getChildCount();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            View v4 = this.getChildAt(v2);
            if(v4.getVisibility() == 8) {
            }
            else {
                ViewGroup$LayoutParams v5 = v4.getLayoutParams();
                int v6 = v4.getMeasuredHeight() + (((LayoutParams)v5).topMargin + ((LayoutParams)v5).bottomMargin);
                int v5_1 = ((LayoutParams)v5).scrollFlags;
                if((v5_1 & 1) != 0) {
                    v3 += v6;
                    if((v5_1 & 2) != 0) {
                        v3 -= ViewCompat.getMinimumHeight(v4);
                        break;
                    }
                }
                else {
                    break;
                }
            }

            ++v2;
        }

        v0 = Math.max(0, v3);
        this.downScrollRange = v0;
        return v0;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    public MaterialShapeDrawable getMaterialShapeBackground() {
        Drawable v1 = this.getBackground();
        if((v1 instanceof MaterialShapeDrawable)) {
            return ((MaterialShapeDrawable)v1);
        }

        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int v0 = this.getTopInset();
        int v1 = ViewCompat.getMinimumHeight(((View)this));
        if(v1 == 0) {
            v1 = this.getChildCount();
            v1 = v1 >= 1 ? ViewCompat.getMinimumHeight(this.getChildAt(v1 - 1)) : 0;
            if(v1 == 0) {
                goto label_16;
            }
        }

        return v1 * 2 + v0;
    label_16:
        return this.getHeight() / 3;
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated public float getTargetElevation() {
        return 0;
    }

    final int getTopInset() {
        WindowInsetsCompat v0 = this.lastInsets;
        if(v0 != null) {
            return v0.getSystemWindowInsetTop();
        }

        return 0;
    }

    public final int getTotalScrollRange() {
        int v0 = this.totalScrollRange;
        if(v0 != -1) {
            return v0;
        }

        v0 = this.getChildCount();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            View v4 = this.getChildAt(v2);
            if(v4.getVisibility() == 8) {
            }
            else {
                ViewGroup$LayoutParams v5 = v4.getLayoutParams();
                int v6 = v4.getMeasuredHeight();
                int v7 = ((LayoutParams)v5).scrollFlags;
                if((v7 & 1) != 0) {
                    v3 += v6 + ((LayoutParams)v5).topMargin + ((LayoutParams)v5).bottomMargin;
                    if(v2 == 0 && (ViewCompat.getFitsSystemWindows(v4))) {
                        v3 -= this.getTopInset();
                    }

                    if((v7 & 2) == 0) {
                        goto label_34;
                    }

                    v3 -= ViewCompat.getMinimumHeight(v4);
                }
                else {
                }

                break;
            }

        label_34:
            ++v2;
        }

        v0 = Math.max(0, v3);
        this.totalScrollRange = v0;
        return v0;
    }

    int getUpNestedPreScrollRange() {
        return this.getTotalScrollRange();
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    private boolean hasCollapsibleChild() {
        int v0 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(this.getChildAt(v2).getLayoutParams().isCollapsible()) {
                return 1;
            }
        }

        return 0;
    }

    boolean hasScrollableChildren() {
        if(this.getTotalScrollRange() != 0) {
            return 1;
        }

        return 0;
    }

    private void initializeLiftOnScrollWithColor(MaterialShapeDrawable arg9, ColorStateList arg10, ColorStateList arg11) {
        this.liftOnScrollColorUpdateListener = new AppBarLayout$$ExternalSyntheticLambda0(this, arg10, arg11, arg9, MaterialColors.getColorOrNull(this.getContext(), attr.colorSurface));
        ViewCompat.setBackground(this, arg9);
    }

    private void initializeLiftOnScrollWithElevation(Context arg1, MaterialShapeDrawable arg2) {
        arg2.initializeElevationOverlay(arg1);
        this.liftOnScrollColorUpdateListener = new AppBarLayout$$ExternalSyntheticLambda1(this, arg2);
        ViewCompat.setBackground(((View)this), ((Drawable)arg2));
    }

    private void invalidateScrollRanges() {
        com.google.android.material.appbar.AppBarLayout$Behavior v0 = this.behavior;
        int v1 = -1;
        SavedState v0_1 = v0 == null || this.totalScrollRange == v1 || this.pendingAction != 0 ? null : v0.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        this.totalScrollRange = v1;
        this.downPreScrollRange = v1;
        this.downScrollRange = v1;
        if(v0_1 != null) {
            this.behavior.restoreScrollState(v0_1, false);
        }
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    private boolean isLiftOnScrollCompatibleBackground() {
        return this.getBackground() instanceof MaterialShapeDrawable;
    }

    public boolean isLifted() {
        return this.lifted;
    }

    void lambda$initializeLiftOnScrollWithColor$0$com-google-android-material-appbar-AppBarLayout(ColorStateList arg1, ColorStateList arg2, MaterialShapeDrawable arg3, Integer arg4, ValueAnimator arg5) {
        int v1 = MaterialColors.layer(arg1.getDefaultColor(), arg2.getDefaultColor(), arg5.getAnimatedValue().floatValue());
        arg3.setFillColor(ColorStateList.valueOf(v1));
        if(this.statusBarForeground != null) {
            Integer v2 = this.statusBarForegroundOriginalColor;
            if(v2 != null && (v2.equals(arg4))) {
                DrawableCompat.setTint(this.statusBarForeground, v1);
            }
        }

        if(!this.liftOnScrollListeners.isEmpty()) {
            Iterator v0 = this.liftOnScrollListeners.iterator();
            while(v0.hasNext()) {
                Object v2_1 = v0.next();
                if(arg3.getFillColor() == null) {
                    continue;
                }

                ((LiftOnScrollListener)v2_1).onUpdate(0f, v1);
            }
        }
    }

    void lambda$initializeLiftOnScrollWithElevation$1$com-google-android-material-appbar-AppBarLayout(MaterialShapeDrawable arg3, ValueAnimator arg4) {
        float v4 = arg4.getAnimatedValue().floatValue();
        arg3.setElevation(v4);
        Drawable v0 = this.statusBarForeground;
        if((v0 instanceof MaterialShapeDrawable)) {
            ((MaterialShapeDrawable)v0).setElevation(v4);
        }

        Iterator v2 = this.liftOnScrollListeners.iterator();
        while(v2.hasNext()) {
            v2.next().onUpdate(v4, arg3.getResolvedTintColor());
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this));
    }

    protected int[] onCreateDrawableState(int arg4) {
        int[] v0 = this.tmpStatesArray;
        if(v0 == null) {
            v0 = new int[4];
            this.tmpStatesArray = v0;
        }

        int[] v4 = super.onCreateDrawableState(arg4 + v0.length);
        int v1 = this.liftable ? attr.state_liftable : -attr.state_liftable;
        v0[0] = v1;
        v1 = !this.liftable || !this.lifted ? -attr.state_lifted : attr.state_lifted;
        v0[1] = v1;
        v1 = this.liftable ? attr.state_collapsible : -attr.state_collapsible;
        v0[2] = v1;
        int v3 = !this.liftable || !this.lifted ? -attr.state_collapsed : attr.state_collapsed;
        v0[3] = v3;
        return AppBarLayout.mergeDrawableStates(v4, v0);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.clearLiftOnScrollTargetView();
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        boolean v2 = true;
        if((ViewCompat.getFitsSystemWindows(((View)this))) && (this.shouldOffsetFirstChild())) {
            int v1 = this.getTopInset();
            for(arg3 = this.getChildCount() - 1; arg3 >= 0; --arg3) {
                ViewCompat.offsetTopAndBottom(this.getChildAt(arg3), v1);
            }
        }

        this.invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        arg3 = this.getChildCount();
        arg4 = 0;
        while(arg4 < arg3) {
            if(this.getChildAt(arg4).getLayoutParams().getScrollInterpolator() != null) {
                this.haveChildWithInterpolator = true;
            }
            else {
                ++arg4;
                continue;
            }

            break;
        }

        Drawable v3 = this.statusBarForeground;
        if(v3 != null) {
            v3.setBounds(0, 0, this.getWidth(), this.getTopInset());
        }

        if(!this.liftableOverride) {
            if(!this.liftOnScroll) {
                if(this.hasCollapsibleChild()) {
                }
                else {
                    v2 = false;
                }
            }

            this.setLiftableState(v2);
        }
    }

    protected void onMeasure(int arg3, int arg4) {
        super.onMeasure(arg3, arg4);
        arg3 = View$MeasureSpec.getMode(arg4);
        if(arg3 != 0x40000000 && (ViewCompat.getFitsSystemWindows(((View)this))) && (this.shouldOffsetFirstChild())) {
            int v0 = this.getMeasuredHeight();
            if(arg3 == 0x80000000) {
                v0 = MathUtils.clamp(this.getMeasuredHeight() + this.getTopInset(), 0, View$MeasureSpec.getSize(arg4));
            }
            else if(arg3 != 0) {
            }
            else {
                v0 += this.getTopInset();
            }

            this.setMeasuredDimension(this.getMeasuredWidth(), v0);
        }

        this.invalidateScrollRanges();
    }

    void onOffsetChanged(int arg4) {
        this.currentOffset = arg4;
        if(!this.willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }

        List v0 = this.listeners;
        if(v0 != null) {
            int v0_1 = v0.size();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                Object v2 = this.listeners.get(v1);
                if(v2 != null) {
                    ((BaseOnOffsetChangedListener)v2).onOffsetChanged(this, arg4);
                }
            }
        }
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat arg3) {
        WindowInsetsCompat v0;
        if(ViewCompat.getFitsSystemWindows(((View)this))) {
            v0 = arg3;
        }
        else {
            Object v0_1 = null;
        }

        if(!ObjectsCompat.equals(this.lastInsets, v0)) {
            this.lastInsets = v0;
            this.updateWillNotDraw();
            this.requestLayout();
        }

        return arg3;
    }

    public boolean removeLiftOnScrollListener(LiftOnScrollListener arg1) {
        return this.liftOnScrollListeners.remove(arg1);
    }

    public void removeOnOffsetChangedListener(BaseOnOffsetChangedListener arg1) {
        List v0 = this.listeners;
        if(v0 != null && arg1 != null) {
            v0.remove(arg1);
        }
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener arg1) {
        this.removeOnOffsetChangedListener(((BaseOnOffsetChangedListener)arg1));
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        MaterialShapeUtils.setElevation(((View)this), arg1);
    }

    private void setExpanded(boolean arg2, boolean arg3, boolean arg4) {
        int v2 = arg2 ? 1 : 2;
        int v0 = 0;
        int v3 = arg3 ? 4 : 0;
        v2 |= v3;
        if(arg4) {
            v0 = 8;
        }

        this.pendingAction = v2 | v0;
        this.requestLayout();
    }

    public void setExpanded(boolean arg2) {
        this.setExpanded(arg2, ViewCompat.isLaidOut(((View)this)));
    }

    public void setExpanded(boolean arg2, boolean arg3) {
        this.setExpanded(arg2, arg3, true);
    }

    public void setLiftOnScroll(boolean arg1) {
        this.liftOnScroll = arg1;
    }

    public void setLiftOnScrollTargetView(View arg2) {
        this.liftOnScrollTargetViewId = -1;
        if(arg2 == null) {
            this.clearLiftOnScrollTargetView();
            return;
        }

        this.liftOnScrollTargetView = new WeakReference(arg2);
    }

    public void setLiftOnScrollTargetViewId(int arg1) {
        this.liftOnScrollTargetViewId = arg1;
        this.clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean arg2) {
        this.liftableOverride = true;
        return this.setLiftableState(arg2);
    }

    public void setLiftableOverrideEnabled(boolean arg1) {
        this.liftableOverride = arg1;
    }

    private boolean setLiftableState(boolean arg2) {
        if(this.liftable != arg2) {
            this.liftable = arg2;
            this.refreshDrawableState();
            return 1;
        }

        return 0;
    }

    public boolean setLifted(boolean arg2) {
        return this.setLiftedState(arg2, true);
    }

    boolean setLiftedState(boolean arg3, boolean arg4) {
        float v4;
        if((arg4) && this.lifted != arg3) {
            this.lifted = arg3;
            this.refreshDrawableState();
            if(this.isLiftOnScrollCompatibleBackground()) {
                float v0 = 0f;
                if(this.hasLiftOnScrollColor) {
                    v4 = 1f;
                    float v1 = arg3 ? 0f : v4;
                    if(arg3) {
                        v0 = v4;
                    }

                    this.startLiftOnScrollColorAnimation(v1, v0);
                }
                else {
                    if(!this.liftOnScroll) {
                        return 1;
                    }

                    v4 = arg3 ? 0f : this.appBarElevation;
                    if(arg3) {
                        v0 = this.appBarElevation;
                    }

                    this.startLiftOnScrollColorAnimation(v4, v0);
                }
            }

            return 1;
        }

        return 0;
    }

    boolean setLiftedState(boolean arg2) {
        return this.setLiftedState(arg2, this.liftableOverride ^ 1);
    }

    public void setOrientation(int arg2) {
        if(arg2 == 1) {
            super.setOrientation(arg2);
            return;
        }

        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable arg3) {
        Drawable v0 = this.statusBarForeground;
        if(v0 != arg3) {
            Drawable$Callback v1 = null;
            if(v0 != null) {
                v0.setCallback(v1);
            }

            if(arg3 != null) {
                Drawable v1_1 = arg3.mutate();
            }

            this.statusBarForeground = ((Drawable)v1);
            this.statusBarForegroundOriginalColor = this.extractStatusBarForegroundColor();
            arg3 = this.statusBarForeground;
            if(arg3 != null) {
                if(arg3.isStateful()) {
                    this.statusBarForeground.setState(this.getDrawableState());
                }

                DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(((View)this)));
                arg3 = this.statusBarForeground;
                boolean v0_1 = this.getVisibility() == 0 ? true : false;
                arg3.setVisible(v0_1, false);
                this.statusBarForeground.setCallback(((Drawable$Callback)this));
            }

            this.updateWillNotDraw();
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    public void setStatusBarForegroundColor(int arg2) {
        this.setStatusBarForeground(new ColorDrawable(arg2));
    }

    public void setStatusBarForegroundResource(int arg2) {
        this.setStatusBarForeground(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    @Deprecated public void setTargetElevation(float arg1) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(((View)this), arg1);
    }

    public void setVisibility(int arg2) {
        super.setVisibility(arg2);
        boolean v2 = arg2 == 0 ? true : false;
        Drawable v1 = this.statusBarForeground;
        if(v1 != null) {
            v1.setVisible(v2, false);
        }
    }

    private boolean shouldDrawStatusBarForeground() {
        if(this.statusBarForeground != null && this.getTopInset() > 0) {
            return 1;
        }

        return 0;
    }

    boolean shouldLift(View arg1) {
        View v0 = this.findLiftOnScrollTargetView(arg1);
        if(v0 == null) {
        }
        else {
            arg1 = v0;
        }

        if(arg1 != null && ((arg1.canScrollVertically(-1)) || arg1.getScrollY() > 0)) {
            return 1;
        }

        return 0;
    }

    private boolean shouldOffsetFirstChild() {
        if(this.getChildCount() > 0) {
            View v3 = this.getChildAt(0);
            if(v3.getVisibility() != 8 && !ViewCompat.getFitsSystemWindows(v3)) {
                return 1;
            }
        }

        return 0;
    }

    private void startLiftOnScrollColorAnimation(float arg3, float arg4) {
        ValueAnimator v0 = this.liftOnScrollColorAnimator;
        if(v0 != null) {
            v0.cancel();
        }

        ValueAnimator v3 = ValueAnimator.ofFloat(new float[]{arg3, arg4});
        this.liftOnScrollColorAnimator = v3;
        v3.setDuration(this.liftOnScrollColorDuration);
        this.liftOnScrollColorAnimator.setInterpolator(this.liftOnScrollColorInterpolator);
        ValueAnimator$AnimatorUpdateListener v3_1 = this.liftOnScrollColorUpdateListener;
        if(v3_1 != null) {
            this.liftOnScrollColorAnimator.addUpdateListener(v3_1);
        }

        this.liftOnScrollColorAnimator.start();
    }

    private void updateWillNotDraw() {
        this.setWillNotDraw(this.shouldDrawStatusBarForeground() ^ 1);
    }

    protected boolean verifyDrawable(Drawable arg2) {
        if(!super.verifyDrawable(arg2)) {
            if(arg2 == this.statusBarForeground) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

