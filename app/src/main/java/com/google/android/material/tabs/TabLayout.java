package com.google.android.material.tabs;

import android.animation.Animator$AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnLayoutChangeListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager$DecorView;
import androidx.viewpager.widget.ViewPager$OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@DecorView public class TabLayout extends HorizontalScrollView {
    class AdapterChangeListener implements OnAdapterChangeListener {
        private boolean autoRefresh;

        AdapterChangeListener(TabLayout arg1) {
            TabLayout.this = arg1;
            super();
        }

        public void onAdapterChanged(ViewPager arg1, PagerAdapter arg2, PagerAdapter arg3) {
            if(TabLayout.this.viewPager == arg1) {
                TabLayout.this.setPagerAdapter(arg3, this.autoRefresh);
            }
        }

        void setAutoRefresh(boolean arg1) {
            this.autoRefresh = arg1;
        }
    }

    @Deprecated public interface BaseOnTabSelectedListener {
        void onTabReselected(Tab arg1);

        void onTabSelected(Tab arg1);

        void onTabUnselected(Tab arg1);
    }

    @public interface LabelVisibility {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener {
    }

    class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver(TabLayout arg1) {
            TabLayout.this = arg1;
            super();
        }

        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    class SlidingTabIndicator extends LinearLayout {
        ValueAnimator indicatorAnimator;
        private int layoutDirection;

        SlidingTabIndicator(TabLayout arg1, Context arg2) {
            TabLayout.this = arg1;
            super(arg2);
            this.layoutDirection = -1;
            this.setWillNotDraw(false);
        }

        static void access$100(SlidingTabIndicator arg0) {
            arg0.jumpIndicatorToSelectedPosition();
        }

        static void access$1800(SlidingTabIndicator arg0, View arg1, View arg2, float arg3) {
            arg0.tweenIndicatorPosition(arg1, arg2, arg3);
        }

        void animateIndicatorToPosition(int arg2, int arg3) {
            ValueAnimator v0 = this.indicatorAnimator;
            if(v0 != null && (v0.isRunning()) && TabLayout.this.indicatorPosition != arg2) {
                this.indicatorAnimator.cancel();
            }

            this.updateOrRecreateIndicatorAnimation(true, arg2, arg3);
        }

        boolean childrenNeedLayout() {
            int v0 = this.getChildCount();
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                if(this.getChildAt(v2).getWidth() <= 0) {
                    return 1;
                }
            }

            return 0;
        }

        public void draw(Canvas arg6) {
            int v2;
            int v0 = TabLayout.this.tabSelectedIndicator.getBounds().height();
            if(v0 < 0) {
                v0 = TabLayout.this.tabSelectedIndicator.getIntrinsicHeight();
            }

            int v1 = TabLayout.this.tabIndicatorGravity;
            if(v1 != 0) {
                int v3 = 2;
                if(v1 != 1) {
                    v2 = 0;
                    if(v1 != v3) {
                        v0 = v1 != 3 ? 0 : this.getHeight();
                    }
                }
                else {
                    v2 = (this.getHeight() - v0) / 2;
                    v0 = (this.getHeight() + v0) / 2;
                }
            }
            else {
                v2 = this.getHeight() - v0;
                v0 = this.getHeight();
            }

            if(TabLayout.this.tabSelectedIndicator.getBounds().width() > 0) {
                Rect v1_1 = TabLayout.this.tabSelectedIndicator.getBounds();
                TabLayout.this.tabSelectedIndicator.setBounds(v1_1.left, v2, v1_1.right, v0);
                TabLayout.this.tabSelectedIndicator.draw(arg6);
            }

            super.draw(arg6);
        }

        private void jumpIndicatorToIndicatorPosition() {
            if(TabLayout.this.indicatorPosition == -1) {
                TabLayout.this.indicatorPosition = TabLayout.this.getSelectedTabPosition();
            }

            this.jumpIndicatorToPosition(TabLayout.this.indicatorPosition);
        }

        private void jumpIndicatorToPosition(int arg5) {
            if(TabLayout.this.viewPagerScrollState != 0) {
                int v1 = -1;
                if(TabLayout.this.getTabSelectedIndicator().getBounds().left == v1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == v1) {
                    goto label_15;
                }

                return;
            }

        label_15:
            TabLayout.this.tabIndicatorInterpolator.setIndicatorBoundsForTab(TabLayout.this, this.getChildAt(arg5), TabLayout.this.tabSelectedIndicator);
            TabLayout.this.indicatorPosition = arg5;
        }

        private void jumpIndicatorToSelectedPosition() {
            this.jumpIndicatorToPosition(TabLayout.this.getSelectedTabPosition());
        }

        protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
            super.onLayout(arg1, arg2, arg3, arg4, arg5);
            ValueAnimator v1 = this.indicatorAnimator;
            if(v1 != null && (v1.isRunning())) {
                this.updateOrRecreateIndicatorAnimation(false, TabLayout.this.getSelectedTabPosition(), -1);
                return;
            }

            this.jumpIndicatorToIndicatorPosition();
        }

        protected void onMeasure(int arg9, int arg10) {
            super.onMeasure(arg9, arg10);
            if(View$MeasureSpec.getMode(arg9) != 0x40000000) {
            }
            else {
                int v1 = 2;
                int v2 = 1;
                if(TabLayout.this.tabGravity != 1 && TabLayout.this.mode != v1) {
                    return;
                }

                int v0 = this.getChildCount();
                int v3 = 0;
                int v4 = 0;
                int v5 = 0;
                while(v4 < v0) {
                    View v6 = this.getChildAt(v4);
                    if(v6.getVisibility() == 0) {
                        v5 = Math.max(v5, v6.getMeasuredWidth());
                    }

                    ++v4;
                }

                if(v5 <= 0) {
                    return;
                }

                if(v5 * v0 <= this.getMeasuredWidth() - (((int)ViewUtils.dpToPx(this.getContext(), 16))) * v1) {
                    v1 = 0;
                    goto label_37;
                }
                else {
                    TabLayout.this.tabGravity = 0;
                    TabLayout.this.updateTabViews(false);
                    goto label_56;
                label_37:
                    while(v3 < v0) {
                        ViewGroup$LayoutParams v4_1 = this.getChildAt(v3).getLayoutParams();
                        if(((LinearLayout$LayoutParams)v4_1).width != v5 || ((LinearLayout$LayoutParams)v4_1).weight != 0f) {
                            ((LinearLayout$LayoutParams)v4_1).width = v5;
                            ((LinearLayout$LayoutParams)v4_1).weight = 0f;
                            v1 = 1;
                        }

                        ++v3;
                    }

                    v2 = v1;
                }

            label_56:
                if(v2 == 0) {
                    return;
                }

                super.onMeasure(arg9, arg10);
            }
        }

        public void onRtlPropertiesChanged(int arg1) {
            super.onRtlPropertiesChanged(arg1);
        }

        void setIndicatorPositionFromTabPosition(int arg3, float arg4) {
            TabLayout.this.indicatorPosition = Math.round((((float)arg3)) + arg4);
            ValueAnimator v0 = this.indicatorAnimator;
            if(v0 != null && (v0.isRunning())) {
                this.indicatorAnimator.cancel();
            }

            this.tweenIndicatorPosition(this.getChildAt(arg3), this.getChildAt(arg3 + 1), arg4);
        }

        void setSelectedIndicatorHeight(int arg5) {
            Rect v0 = TabLayout.this.tabSelectedIndicator.getBounds();
            TabLayout.this.tabSelectedIndicator.setBounds(v0.left, 0, v0.right, arg5);
            this.requestLayout();
        }

        private void tweenIndicatorPosition(View arg8, View arg9, float arg10) {
            if(arg8 == null || arg8.getWidth() <= 0) {
                TabLayout.this.tabSelectedIndicator.setBounds(-1, TabLayout.this.tabSelectedIndicator.getBounds().top, -1, TabLayout.this.tabSelectedIndicator.getBounds().bottom);
            }
            else {
                TabLayout.this.tabIndicatorInterpolator.updateIndicatorForOffset(TabLayout.this, arg8, arg9, arg10, TabLayout.this.tabSelectedIndicator);
            }

            ViewCompat.postInvalidateOnAnimation(((View)this));
        }

        private void updateOrRecreateIndicatorAnimation(boolean arg4, int arg5, int arg6) {
            if(TabLayout.this.indicatorPosition == arg5) {
                return;
            }

            View v0 = this.getChildAt(TabLayout.this.getSelectedTabPosition());
            View v1 = this.getChildAt(arg5);
            if(v1 == null) {
                this.jumpIndicatorToSelectedPosition();
                return;
            }

            TabLayout.this.indicatorPosition = arg5;
            com.google.android.material.tabs.TabLayout$SlidingTabIndicator$1 v5 = new ValueAnimator$AnimatorUpdateListener(v0, v1) {
                public void onAnimationUpdate(ValueAnimator arg3) {
                    this.this$1.tweenIndicatorPosition(this.val$currentView, this.val$targetView, arg3.getAnimatedFraction());
                }
            };
            if(arg4) {
                ValueAnimator v4 = new ValueAnimator();
                this.indicatorAnimator = v4;
                v4.setInterpolator(TabLayout.this.tabIndicatorTimeInterpolator);
                v4.setDuration(((long)arg6));
                v4.setFloatValues(new float[]{0f, 1f});
                v4.addUpdateListener(((ValueAnimator$AnimatorUpdateListener)v5));
                v4.start();
                return;
            }

            this.indicatorAnimator.removeAllUpdateListeners();
            this.indicatorAnimator.addUpdateListener(((ValueAnimator$AnimatorUpdateListener)v5));
        }
    }

    public class Tab {
        public static final int INVALID_POSITION = -1;
        private CharSequence contentDesc;
        private View customView;
        private Drawable icon;
        private int id;
        private int labelVisibilityMode;
        public TabLayout parent;
        private int position;
        private Object tag;
        private CharSequence text;
        public TabView view;

        public Tab() {
            super();
            this.position = -1;
            this.labelVisibilityMode = 1;
            this.id = -1;
        }

        static int access$000(Tab arg0) {
            return arg0.id;
        }

        static int access$1500(Tab arg0) {
            return arg0.labelVisibilityMode;
        }

        static CharSequence access$300(Tab arg0) {
            return arg0.contentDesc;
        }

        static CharSequence access$400(Tab arg0) {
            return arg0.text;
        }

        public BadgeDrawable getBadge() {
            return TabView.access$1000(this.view);
        }

        public CharSequence getContentDescription() {
            TabView v0 = this.view;
            if(v0 == null) {
                return null;
            }

            return v0.getContentDescription();
        }

        public View getCustomView() {
            return this.customView;
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.id;
        }

        public BadgeDrawable getOrCreateBadge() {
            return TabView.access$800(this.view);
        }

        public int getPosition() {
            return this.position;
        }

        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        public Object getTag() {
            return this.tag;
        }

        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout v0 = this.parent;
            if(v0 != null) {
                int v0_1 = v0.getSelectedTabPosition();
                if(v0_1 != -1 && v0_1 == this.position) {
                    return 1;
                }

                return 0;
            }

            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            TabView.access$900(this.view);
        }

        void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            TabLayout v0 = this.parent;
            if(v0 != null) {
                v0.selectTab(this);
                return;
            }

            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setContentDescription(CharSequence arg1) {
            this.contentDesc = arg1;
            this.updateView();
            return this;
        }

        public Tab setContentDescription(int arg2) {
            TabLayout v0 = this.parent;
            if(v0 != null) {
                return this.setContentDescription(v0.getResources().getText(arg2));
            }

            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setCustomView(int arg4) {
            return this.setCustomView(LayoutInflater.from(this.view.getContext()).inflate(arg4, this.view, false));
        }

        public Tab setCustomView(View arg1) {
            this.customView = arg1;
            this.updateView();
            return this;
        }

        public Tab setIcon(Drawable arg3) {
            this.icon = arg3;
            if(this.parent.tabGravity == 1 || this.parent.mode == 2) {
                this.parent.updateTabViews(true);
            }

            this.updateView();
            if((BadgeUtils.USE_COMPAT_PARENT) && (TabView.access$600(this.view)) && (TabView.access$700(this.view).isVisible())) {
                this.view.invalidate();
            }

            return this;
        }

        public Tab setIcon(int arg2) {
            TabLayout v0 = this.parent;
            if(v0 != null) {
                return this.setIcon(AppCompatResources.getDrawable(v0.getContext(), arg2));
            }

            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setId(int arg2) {
            this.id = arg2;
            TabView v0 = this.view;
            if(v0 != null) {
                v0.setId(arg2);
            }

            return this;
        }

        void setPosition(int arg1) {
            this.position = arg1;
        }

        public Tab setTabLabelVisibility(int arg3) {
            this.labelVisibilityMode = arg3;
            if(this.parent.tabGravity == 1 || this.parent.mode == 2) {
                this.parent.updateTabViews(true);
            }

            this.updateView();
            if((BadgeUtils.USE_COMPAT_PARENT) && (TabView.access$600(this.view)) && (TabView.access$700(this.view).isVisible())) {
                this.view.invalidate();
            }

            return this;
        }

        public Tab setTag(Object arg1) {
            this.tag = arg1;
            return this;
        }

        public Tab setText(CharSequence arg2) {
            if((TextUtils.isEmpty(this.contentDesc)) && !TextUtils.isEmpty(arg2)) {
                this.view.setContentDescription(arg2);
            }

            this.text = arg2;
            this.updateView();
            return this;
        }

        public Tab setText(int arg2) {
            TabLayout v0 = this.parent;
            if(v0 != null) {
                return this.setText(v0.getResources().getText(arg2));
            }

            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void updateView() {
            TabView v0 = this.view;
            if(v0 != null) {
                v0.update();
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface TabGravity {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface TabIndicatorAnimationMode {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface TabIndicatorGravity {
    }

    public class TabLayoutOnPageChangeListener implements OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;
        private final WeakReference tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout arg2) {
            super();
            this.tabLayoutRef = new WeakReference(arg2);
        }

        public void onPageScrollStateChanged(int arg2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = arg2;
            Object v2 = this.tabLayoutRef.get();
            if(v2 != null) {
                ((TabLayout)v2).updateViewPagerScrollState(this.scrollState);
            }
        }

        public void onPageScrolled(int arg7, float arg8, int arg9) {
            boolean v4;
            Object v0 = this.tabLayoutRef.get();
            if(v0 != null) {
                arg9 = this.scrollState;
                int v2 = 2;
                boolean v3 = true;
                if(arg9 != v2 || this.previousScrollState == 1) {
                    v4 = true;
                }
                else {
                    v4 = true;
                    v3 = false;
                }

                if(arg9 == v2) {
                    if(this.previousScrollState != 0) {
                    }
                    else {
                        v4 = false;
                    }
                }

                ((TabLayout)v0).setScrollPosition(arg7, arg8, v3, v4, false);
            }
        }

        public void onPageSelected(int arg4) {
            boolean v3;
            Object v0 = this.tabLayoutRef.get();
            if(v0 != null && ((TabLayout)v0).getSelectedTabPosition() != arg4 && arg4 < ((TabLayout)v0).getTabCount()) {
                int v1 = this.scrollState;
                if(v1 != 0) {
                    if(v1 == 2 && this.previousScrollState == 0) {
                        goto label_16;
                    }

                    v3 = false;
                }
                else {
                label_16:
                    v3 = true;
                }

                ((TabLayout)v0).selectTab(((TabLayout)v0).getTabAt(arg4), v3);
            }
        }

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public final class TabView extends LinearLayout {
        private View badgeAnchorView;
        private BadgeDrawable badgeDrawable;
        private Drawable baseBackgroundDrawable;
        private ImageView customIconView;
        private TextView customTextView;
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;

        public TabView(TabLayout arg4, Context arg5) {
            TabLayout.this = arg4;
            super(arg5);
            this.defaultMaxLines = 2;
            this.updateBackgroundDrawable(arg5);
            ViewCompat.setPaddingRelative(((View)this), arg4.tabPaddingStart, arg4.tabPaddingTop, arg4.tabPaddingEnd, arg4.tabPaddingBottom);
            this.setGravity(17);
            this.setOrientation(arg4.inlineLabel ^ 1);
            this.setClickable(true);
            ViewCompat.setPointerIcon(((View)this), PointerIconCompat.getSystemIcon(this.getContext(), 1002));
        }

        static BadgeDrawable access$1000(TabView arg0) {
            return arg0.getBadge();
        }

        static void access$1400(TabView arg0, View arg1) {
            arg0.tryUpdateBadgeDrawableBounds(arg1);
        }

        static void access$200(TabView arg0, Context arg1) {
            arg0.updateBackgroundDrawable(arg1);
        }

        static void access$500(TabView arg0, Canvas arg1) {
            arg0.drawBackground(arg1);
        }

        static boolean access$600(TabView arg0) {
            return arg0.hasBadgeDrawable();
        }

        static BadgeDrawable access$700(TabView arg0) {
            return arg0.badgeDrawable;
        }

        static BadgeDrawable access$800(TabView arg0) {
            return arg0.getOrCreateBadge();
        }

        static void access$900(TabView arg0) {
            arg0.removeBadge();
        }

        private void addOnLayoutChangeListener(View arg2) {
            if(arg2 == null) {
                return;
            }

            arg2.addOnLayoutChangeListener(new View$OnLayoutChangeListener(arg2) {
                public void onLayoutChange(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
                    if(this.val$view.getVisibility() == 0) {
                        this.this$1.tryUpdateBadgeDrawableBounds(this.val$view);
                    }
                }
            });
        }

        private float approximateLineWidth(Layout arg1, int arg2, float arg3) {
            return arg1.getLineWidth(arg2) * (arg3 / arg1.getPaint().getTextSize());
        }

        private void clipViewToPaddingForBadge(boolean arg1) {
            this.setClipChildren(arg1);
            this.setClipToPadding(arg1);
            ViewParent v0 = this.getParent();
            if(v0 != null) {
                ((ViewGroup)v0).setClipChildren(arg1);
                ((ViewGroup)v0).setClipToPadding(arg1);
            }
        }

        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout v0 = new FrameLayout(this.getContext());
            v0.setLayoutParams(new FrameLayout$LayoutParams(-2, -2));
            return v0;
        }

        private void drawBackground(Canvas arg6) {
            Drawable v0 = this.baseBackgroundDrawable;
            if(v0 != null) {
                v0.setBounds(this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
                this.baseBackgroundDrawable.draw(arg6);
            }
        }

        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] v0 = this.getDrawableState();
            Drawable v1 = this.baseBackgroundDrawable;
            boolean v0_1 = v1 == null || !v1.isStateful() ? false : this.baseBackgroundDrawable.setState(v0);
            if(v0_1) {
                this.invalidate();
                TabLayout.this.invalidate();
            }
        }

        private BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        int getContentHeight() {
            int v0 = 3;
            View[] v1 = new View[v0];
            int v3 = 0;
            v1[0] = this.textView;
            v1[1] = this.iconView;
            v1[2] = this.customView;
            int v8 = 0;
            int v2 = 0;
            int v5 = 0;
            while(v3 < v0) {
                View v6 = v1[v3];
                if(v6 != null && v6.getVisibility() == 0) {
                    v2 = v5 != 0 ? Math.min(v2, v6.getTop()) : v6.getTop();
                    v8 = v5 != 0 ? Math.max(v8, v6.getBottom()) : v6.getBottom();
                    v5 = 1;
                }

                ++v3;
            }

            return v8 - v2;
        }

        int getContentWidth() {
            int v0 = 3;
            View[] v1 = new View[v0];
            int v3 = 0;
            v1[0] = this.textView;
            v1[1] = this.iconView;
            v1[2] = this.customView;
            int v8 = 0;
            int v2 = 0;
            int v5 = 0;
            while(v3 < v0) {
                View v6 = v1[v3];
                if(v6 != null && v6.getVisibility() == 0) {
                    v2 = v5 != 0 ? Math.min(v2, v6.getLeft()) : v6.getLeft();
                    v8 = v5 != 0 ? Math.max(v8, v6.getRight()) : v6.getRight();
                    v5 = 1;
                }

                ++v3;
            }

            return v8 - v2;
        }

        private FrameLayout getCustomParentForBadge(View arg3) {
            FrameLayout v1 = null;
            if(arg3 != this.iconView && arg3 != this.textView) {
                return v1;
            }

            if(BadgeUtils.USE_COMPAT_PARENT) {
                return arg3.getParent();
            }

            return v1;
        }

        private BadgeDrawable getOrCreateBadge() {
            if(this.badgeDrawable == null) {
                this.badgeDrawable = BadgeDrawable.create(this.getContext());
            }

            this.tryUpdateBadgeAnchor();
            BadgeDrawable v1 = this.badgeDrawable;
            if(v1 != null) {
                return v1;
            }

            throw new IllegalStateException("Unable to create badge");
        }

        public Tab getTab() {
            return this.tab;
        }

        private boolean hasBadgeDrawable() {
            if(this.badgeDrawable != null) {
                return 1;
            }

            return 0;
        }

        private void inflateAndAddDefaultIconView() {
            FrameLayout v0;
            if(BadgeUtils.USE_COMPAT_PARENT) {
                v0 = this.createPreApi18BadgeAnchorRoot();
                this.addView(((View)v0), 0);
            }
            else {
                TabView v0_1 = this;
            }

            View v2 = LayoutInflater.from(this.getContext()).inflate(layout.design_layout_tab_icon, ((ViewGroup)v0), false);
            this.iconView = ((ImageView)v2);
            ((ViewGroup)v0).addView(v2, 0);
        }

        private void inflateAndAddDefaultTextView() {
            FrameLayout v0;
            if(BadgeUtils.USE_COMPAT_PARENT) {
                v0 = this.createPreApi18BadgeAnchorRoot();
                this.addView(((View)v0));
            }
            else {
                TabView v0_1 = this;
            }

            View v1 = LayoutInflater.from(this.getContext()).inflate(layout.design_layout_tab_text, ((ViewGroup)v0), false);
            this.textView = ((TextView)v1);
            ((ViewGroup)v0).addView(v1);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg8) {
            super.onInitializeAccessibilityNodeInfo(arg8);
            BadgeDrawable v0 = this.badgeDrawable;
            if(v0 != null && (v0.isVisible())) {
                arg8.setContentDescription(this.getContentDescription() + ", " + this.badgeDrawable.getContentDescription());
            }

            AccessibilityNodeInfoCompat v8 = AccessibilityNodeInfoCompat.wrap(arg8);
            v8.setCollectionItemInfo(CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, this.isSelected()));
            if(this.isSelected()) {
                v8.setClickable(false);
                v8.removeAction(AccessibilityActionCompat.ACTION_CLICK);
            }

            v8.setRoleDescription(this.getResources().getString(string.item_view_role_description));
        }

        public void onMeasure(int arg8, int arg9) {
            int v0 = View$MeasureSpec.getSize(arg8);
            int v1 = View$MeasureSpec.getMode(arg8);
            int v2 = TabLayout.this.getTabMaxWidth();
            if(v2 > 0 && (v1 == 0 || v0 > v2)) {
                arg8 = View$MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, 0x80000000);
            }

            super.onMeasure(arg8, arg9);
            if(this.textView != null) {
                float v0_1 = TabLayout.this.tabTextSize;
                v1 = this.defaultMaxLines;
                ImageView v2_1 = this.iconView;
                if(v2_1 == null || v2_1.getVisibility() != 0) {
                    TextView v2_2 = this.textView;
                    if(v2_2 != null && v2_2.getLineCount() > 1) {
                        v0_1 = TabLayout.this.tabTextMultiLineSize;
                    }
                }
                else {
                    v1 = 1;
                }

                float v2_3 = this.textView.getTextSize();
                int v4 = this.textView.getLineCount();
                int v5 = TextViewCompat.getMaxLines(this.textView);
                v2 = Float.compare(v0_1, v2_3);
                if(v2 == 0) {
                    if(v5 < 0) {
                    }
                    else if(v1 != v5) {
                        goto label_40;
                    }

                    return;
                }

            label_40:
                if(TabLayout.this.mode == 1 && v2 > 0 && v4 == 1) {
                    Layout v2_4 = this.textView.getLayout();
                    if(v2_4 != null && this.approximateLineWidth(v2_4, 0, v0_1) <= (((float)(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight())))) {
                        goto label_58;
                    }

                    return;
                }

            label_58:
                this.textView.setTextSize(0, v0_1);
                this.textView.setMaxLines(v1);
                super.onMeasure(arg8, arg9);
            }
        }

        public boolean performClick() {
            boolean v0 = super.performClick();
            if(this.tab != null) {
                if(!v0) {
                    this.playSoundEffect(0);
                }

                this.tab.select();
                return 1;
            }

            return v0;
        }

        private void removeBadge() {
            if(this.badgeAnchorView != null) {
                this.tryRemoveBadgeFromAnchor();
            }

            this.badgeDrawable = null;
        }

        void reset() {
            this.setTab(null);
            this.setSelected(false);
        }

        public void setSelected(boolean arg2) {
            this.isSelected();
            super.setSelected(arg2);
            TextView v0 = this.textView;
            if(v0 != null) {
                v0.setSelected(arg2);
            }

            ImageView v0_1 = this.iconView;
            if(v0_1 != null) {
                v0_1.setSelected(arg2);
            }

            View v1 = this.customView;
            if(v1 != null) {
                v1.setSelected(arg2);
            }
        }

        void setTab(Tab arg2) {
            if(arg2 != this.tab) {
                this.tab = arg2;
                this.update();
            }
        }

        private void tryAttachBadgeToAnchor(View arg3) {
            if(!this.hasBadgeDrawable()) {
            }
            else if(arg3 != null) {
                this.clipViewToPaddingForBadge(false);
                BadgeUtils.attachBadgeDrawable(this.badgeDrawable, arg3, this.getCustomParentForBadge(arg3));
                this.badgeAnchorView = arg3;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            if(!this.hasBadgeDrawable()) {
            }
            else {
                this.clipViewToPaddingForBadge(true);
                View v0 = this.badgeAnchorView;
                if(v0 != null) {
                    BadgeUtils.detachBadgeDrawable(this.badgeDrawable, v0);
                    this.badgeAnchorView = null;
                }
            }
        }

        private void tryUpdateBadgeAnchor() {
            View v0_1;
            Tab v0;
            if(!this.hasBadgeDrawable()) {
                return;
            }

            if(this.customView != null) {
                this.tryRemoveBadgeFromAnchor();
                return;
            }

            if(this.iconView != null) {
                v0 = this.tab;
                if(v0 != null && v0.getIcon() != null) {
                    v0_1 = this.badgeAnchorView;
                    ImageView v1 = this.iconView;
                    if(v0_1 != (((View)v1))) {
                        this.tryRemoveBadgeFromAnchor();
                        this.tryAttachBadgeToAnchor(this.iconView);
                        return;
                    }
                    else {
                        this.tryUpdateBadgeDrawableBounds(((View)v1));
                        return;
                    }
                }
            }

            if(this.textView != null) {
                v0 = this.tab;
                if(v0 != null && v0.getTabLabelVisibility() == 1) {
                    v0_1 = this.badgeAnchorView;
                    TextView v1_1 = this.textView;
                    if(v0_1 != (((View)v1_1))) {
                        this.tryRemoveBadgeFromAnchor();
                        this.tryAttachBadgeToAnchor(this.textView);
                        return;
                    }
                    else {
                        this.tryUpdateBadgeDrawableBounds(((View)v1_1));
                        return;
                    }
                }
            }

            this.tryRemoveBadgeFromAnchor();
        }

        private void tryUpdateBadgeDrawableBounds(View arg2) {
            if((this.hasBadgeDrawable()) && arg2 == this.badgeAnchorView) {
                BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, arg2, this.getCustomParentForBadge(arg2));
            }
        }

        final void update() {
            this.updateTab();
            Tab v0 = this.tab;
            boolean v0_1 = v0 == null || !v0.isSelected() ? false : true;
            this.setSelected(v0_1);
        }

        private void updateBackgroundDrawable(Context arg6) {
            RippleDrawable v6_2;
            Drawable v6;
            Drawable v1 = null;
            if(TabLayout.this.tabBackgroundResId != 0) {
                v6 = AppCompatResources.getDrawable(arg6, TabLayout.this.tabBackgroundResId);
                this.baseBackgroundDrawable = v6;
                if(v6 != null && (v6.isStateful())) {
                    this.baseBackgroundDrawable.setState(this.getDrawableState());
                }
            }
            else {
                this.baseBackgroundDrawable = v1;
            }

            GradientDrawable v6_1 = new GradientDrawable();
            v6_1.setColor(0);
            if(TabLayout.this.tabRippleColorStateList != null) {
                GradientDrawable v0 = new GradientDrawable();
                v0.setCornerRadius(0.00001f);
                v0.setColor(-1);
                ColorStateList v2 = RippleUtils.convertToRippleDrawableColor(TabLayout.this.tabRippleColorStateList);
                if(TabLayout.this.unboundedRipple) {
                    v6 = v1;
                }

                if(TabLayout.this.unboundedRipple) {
                }
                else {
                    GradientDrawable v1_1 = v0;
                }

                v6_2 = new RippleDrawable(v2, v6, v1);
            }

            ViewCompat.setBackground(((View)this), ((Drawable)v6_2));
            TabLayout.this.invalidate();
        }

        final void updateOrientation() {
            this.setOrientation(TabLayout.this.inlineLabel ^ 1);
            TextView v0 = this.customTextView;
            if(v0 == null) {
                if(this.customIconView != null) {
                }
                else {
                    this.updateTextAndIcon(this.textView, this.iconView, true);
                    return;
                }
            }

            this.updateTextAndIcon(v0, this.customIconView, false);
        }

        final void updateTab() {
            Tab v0 = this.tab;
            Drawable v1 = null;
            View v2 = v0 != null ? v0.getCustomView() : ((View)v1);
            if(v2 != null) {
                ViewParent v3 = v2.getParent();
                if((((TabView)v3)) != this) {
                    if(v3 != null) {
                        ((ViewGroup)v3).removeView(v2);
                    }

                    View v3_1 = this.customView;
                    if(v3_1 != null) {
                        v3 = v3_1.getParent();
                        if(v3 != null) {
                            ((ViewGroup)v3).removeView(this.customView);
                        }
                    }

                    this.addView(v2);
                }

                this.customView = v2;
                TextView v3_2 = this.textView;
                int v4 = 8;
                if(v3_2 != null) {
                    v3_2.setVisibility(v4);
                }

                ImageView v3_3 = this.iconView;
                if(v3_3 != null) {
                    v3_3.setVisibility(v4);
                    this.iconView.setImageDrawable(v1);
                }

                View v1_1 = v2.findViewById(0x1020014);
                this.customTextView = ((TextView)v1_1);
                if(v1_1 != null) {
                    this.defaultMaxLines = TextViewCompat.getMaxLines(((TextView)v1_1));
                }

                this.customIconView = v2.findViewById(0x1020006);
            }
            else {
                v2 = this.customView;
                if(v2 != null) {
                    this.removeView(v2);
                    this.customView = ((View)v1);
                }

                this.customTextView = ((TextView)v1);
                this.customIconView = ((ImageView)v1);
            }

            if(this.customView == null) {
                if(this.iconView == null) {
                    this.inflateAndAddDefaultIconView();
                }

                if(this.textView == null) {
                    this.inflateAndAddDefaultTextView();
                    this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
                }

                TextViewCompat.setTextAppearance(this.textView, TabLayout.this.defaultTabTextAppearance);
                if(!this.isSelected() || TabLayout.this.selectedTabTextAppearance == -1) {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.tabTextAppearance);
                }
                else {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.selectedTabTextAppearance);
                }

                if(TabLayout.this.tabTextColors != null) {
                    this.textView.setTextColor(TabLayout.this.tabTextColors);
                }

                this.updateTextAndIcon(this.textView, this.iconView, true);
                this.tryUpdateBadgeAnchor();
                this.addOnLayoutChangeListener(this.iconView);
                this.addOnLayoutChangeListener(this.textView);
            }
            else {
                TextView v1_2 = this.customTextView;
                if(v1_2 == null && this.customIconView == null) {
                    goto label_98;
                }

                this.updateTextAndIcon(v1_2, this.customIconView, false);
            }

        label_98:
            if(v0 != null && !TextUtils.isEmpty(v0.contentDesc)) {
                this.setContentDescription(v0.contentDesc);
            }
        }

        private void updateTextAndIcon(TextView arg8, ImageView arg9, boolean arg10) {
            int v6;
            Tab v0 = this.tab;
            Drawable v1 = null;
            Drawable v0_1 = v0 == null || v0.getIcon() == null ? v1 : DrawableCompat.wrap(this.tab.getIcon()).mutate();
            if(v0_1 != null) {
                DrawableCompat.setTintList(v0_1, TabLayout.this.tabIconTint);
                if(TabLayout.this.tabIconTintMode != null) {
                    DrawableCompat.setTintMode(v0_1, TabLayout.this.tabIconTintMode);
                }
            }

            Tab v2 = this.tab;
            CharSequence v2_1 = v2 != null ? v2.getText() : ((CharSequence)v1);
            int v3 = 8;
            if(arg9 != null) {
                if(v0_1 != null) {
                    arg9.setImageDrawable(v0_1);
                    arg9.setVisibility(0);
                    this.setVisibility(0);
                }
                else {
                    arg9.setVisibility(v3);
                    arg9.setImageDrawable(v1);
                }
            }

            boolean v0_2 = TextUtils.isEmpty(v2_1);
            if(arg8 != null) {
                if(!v0_2) {
                    v6 = 1;
                    if(this.tab.labelVisibilityMode == 1) {
                    }
                    else {
                        goto label_44;
                    }
                }
                else {
                label_44:
                    v6 = 0;
                }

                CharSequence v5 = !v0_2 ? v2_1 : ((CharSequence)v1);
                arg8.setText(v5);
                int v5_1 = v6 != 0 ? 0 : v3;
                arg8.setVisibility(v5_1);
                if(v0_2) {
                    goto label_59;
                }

                this.setVisibility(0);
            }
            else {
                v6 = 0;
            }

        label_59:
            if((arg10) && arg9 != null) {
                ViewGroup$LayoutParams v8 = arg9.getLayoutParams();
                int v10 = v6 == 0 || arg9.getVisibility() != 0 ? 0 : ((int)ViewUtils.dpToPx(this.getContext(), v3));
                if(TabLayout.this.inlineLabel) {
                    if(v10 == MarginLayoutParamsCompat.getMarginEnd(((ViewGroup$MarginLayoutParams)v8))) {
                        goto label_86;
                    }

                    MarginLayoutParamsCompat.setMarginEnd(((ViewGroup$MarginLayoutParams)v8), v10);
                    ((ViewGroup$MarginLayoutParams)v8).bottomMargin = 0;
                    arg9.setLayoutParams(v8);
                    arg9.requestLayout();
                    goto label_86;
                }

                if(v10 == ((ViewGroup$MarginLayoutParams)v8).bottomMargin) {
                    goto label_86;
                }

                ((ViewGroup$MarginLayoutParams)v8).bottomMargin = v10;
                MarginLayoutParamsCompat.setMarginEnd(((ViewGroup$MarginLayoutParams)v8), 0);
                arg9.setLayoutParams(v8);
                arg9.requestLayout();
            }

        label_86:
            Tab v8_1 = this.tab;
            if(v8_1 != null) {
                CharSequence v1_1 = v8_1.contentDesc;
            }

            if(!v0_2) {
            }
            else {
                v2_1 = ((CharSequence)v1);
            }

            TooltipCompat.setTooltipText(((View)this), v2_1);
        }
    }

    public class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager arg1) {
            super();
            this.viewPager = arg1;
        }

        public void onTabReselected(Tab arg1) {
        }

        public void onTabSelected(Tab arg1) {
            this.viewPager.setCurrentItem(arg1.getPosition());
        }

        public void onTabUnselected(Tab arg1) {
        }
    }

    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 0x30;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int DEF_STYLE_RES = 0;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_FADE = 2;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int SELECTED_INDICATOR_HEIGHT_DEFAULT = -1;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    private BaseOnTabSelectedListener currentVpSelectedListener;
    private final int defaultTabTextAppearance;
    int indicatorPosition;
    boolean inlineLabel;
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList selectedListeners;
    private Tab selectedTab;
    private int selectedTabTextAppearance;
    float selectedTabTextSize;
    private boolean setupViewPagerImplicitly;
    final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff$Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabIndicatorHeight;
    private TabIndicatorInterpolator tabIndicatorInterpolator;
    private final TimeInterpolator tabIndicatorTimeInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    private static final Pool tabPool;
    ColorStateList tabRippleColorStateList;
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    private final int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pool tabViewPool;
    private final ArrayList tabs;
    boolean unboundedRipple;
    ViewPager viewPager;
    private int viewPagerScrollState;

    static {
        TabLayout.DEF_STYLE_RES = style.Widget_Design_TabLayout;
        TabLayout.tabPool = new SynchronizedPool(16);
    }

    public TabLayout(Context arg2) {
        this(arg2, null);
    }

    public TabLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.tabStyle);
    }

    public TabLayout(Context arg9, AttributeSet arg10, int arg11) {
        int v4 = TabLayout.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg9, arg10, arg11, v4), arg10, arg11);
        int v9 = -1;
        this.indicatorPosition = v9;
        this.tabs = new ArrayList();
        this.selectedTabTextAppearance = v9;
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = 0x7FFFFFFF;
        this.tabIndicatorHeight = v9;
        this.selectedListeners = new ArrayList();
        this.tabViewPool = new SimplePool(12);
        Context v0 = this.getContext();
        this.setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator v7 = new SlidingTabIndicator(this, v0);
        this.slidingTabIndicator = v7;
        super.addView(((View)v7), 0, new FrameLayout$LayoutParams(-2, v9));
        TypedArray v10 = ThemeEnforcement.obtainStyledAttributes(v0, arg10, styleable.TabLayout, arg11, v4, new int[]{styleable.TabLayout_tabTextAppearance});
        ColorStateList v11 = DrawableUtils.getColorStateListOrNull(this.getBackground());
        if(v11 != null) {
            MaterialShapeDrawable v1 = new MaterialShapeDrawable();
            v1.setFillColor(v11);
            v1.initializeElevationOverlay(v0);
            v1.setElevation(ViewCompat.getElevation(((View)this)));
            ViewCompat.setBackground(((View)this), ((Drawable)v1));
        }

        this.setSelectedTabIndicator(MaterialResources.getDrawable(v0, v10, styleable.TabLayout_tabIndicator));
        this.setSelectedTabIndicatorColor(v10.getColor(styleable.TabLayout_tabIndicatorColor, 0));
        v7.setSelectedIndicatorHeight(v10.getDimensionPixelSize(styleable.TabLayout_tabIndicatorHeight, v9));
        this.setSelectedTabIndicatorGravity(v10.getInt(styleable.TabLayout_tabIndicatorGravity, 0));
        this.setTabIndicatorAnimationMode(v10.getInt(styleable.TabLayout_tabIndicatorAnimationMode, 0));
        this.setTabIndicatorFullWidth(v10.getBoolean(styleable.TabLayout_tabIndicatorFullWidth, true));
        arg11 = v10.getDimensionPixelSize(styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = arg11;
        this.tabPaddingEnd = arg11;
        this.tabPaddingTop = arg11;
        this.tabPaddingStart = arg11;
        this.tabPaddingStart = v10.getDimensionPixelSize(styleable.TabLayout_tabPaddingStart, this.tabPaddingStart);
        this.tabPaddingTop = v10.getDimensionPixelSize(styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = v10.getDimensionPixelSize(styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = v10.getDimensionPixelSize(styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        this.defaultTabTextAppearance = ThemeEnforcement.isMaterial3Theme(v0) ? attr.textAppearanceTitleSmall : attr.textAppearanceButton;
        arg11 = v10.getResourceId(styleable.TabLayout_tabTextAppearance, style.TextAppearance_Design_Tab);
        this.tabTextAppearance = arg11;
        TypedArray v2 = v0.obtainStyledAttributes(arg11, androidx.appcompat.R$styleable.TextAppearance);
        try {
            this.tabTextSize = ((float)v2.getDimensionPixelSize(androidx.appcompat.R$styleable.TextAppearance_android_textSize, 0));
            this.tabTextColors = MaterialResources.getColorStateList(v0, v2, androidx.appcompat.R$styleable.TextAppearance_android_textColor);
        }
        catch(Throwable v0_1) {
            v2.recycle();
            throw v0_1;
        }

        v2.recycle();
        if(v10.hasValue(styleable.TabLayout_tabSelectedTextAppearance)) {
            this.selectedTabTextAppearance = v10.getResourceId(styleable.TabLayout_tabSelectedTextAppearance, arg11);
        }

        arg11 = this.selectedTabTextAppearance;
        if(arg11 != v9) {
            TypedArray v11_1 = v0.obtainStyledAttributes(arg11, androidx.appcompat.R$styleable.TextAppearance);
            try {
                this.selectedTabTextSize = ((float)v11_1.getDimensionPixelSize(androidx.appcompat.R$styleable.TextAppearance_android_textSize, ((int)this.tabTextSize)));
                ColorStateList v2_1 = MaterialResources.getColorStateList(v0, v11_1, androidx.appcompat.R$styleable.TextAppearance_android_textColor);
                if(v2_1 != null) {
                    this.tabTextColors = TabLayout.createColorStateList(this.tabTextColors.getDefaultColor(), v2_1.getColorForState(new int[]{0x10100A1}, v2_1.getDefaultColor()));
                }
            }
            catch(Throwable v0_1) {
                v11_1.recycle();
                throw v0_1;
            }

            v11_1.recycle();
        }

        if(v10.hasValue(styleable.TabLayout_tabTextColor)) {
            this.tabTextColors = MaterialResources.getColorStateList(v0, v10, styleable.TabLayout_tabTextColor);
        }

        if(v10.hasValue(styleable.TabLayout_tabSelectedTextColor)) {
            this.tabTextColors = TabLayout.createColorStateList(this.tabTextColors.getDefaultColor(), v10.getColor(styleable.TabLayout_tabSelectedTextColor, 0));
        }

        this.tabIconTint = MaterialResources.getColorStateList(v0, v10, styleable.TabLayout_tabIconTint);
        this.tabIconTintMode = ViewUtils.parseTintMode(v10.getInt(styleable.TabLayout_tabIconTintMode, v9), null);
        this.tabRippleColorStateList = MaterialResources.getColorStateList(v0, v10, styleable.TabLayout_tabRippleColor);
        this.tabIndicatorAnimationDuration = v10.getInt(styleable.TabLayout_tabIndicatorAnimationDuration, 300);
        this.tabIndicatorTimeInterpolator = MotionUtils.resolveThemeInterpolator(v0, attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.requestedTabMinWidth = v10.getDimensionPixelSize(styleable.TabLayout_tabMinWidth, v9);
        this.requestedTabMaxWidth = v10.getDimensionPixelSize(styleable.TabLayout_tabMaxWidth, v9);
        this.tabBackgroundResId = v10.getResourceId(styleable.TabLayout_tabBackground, 0);
        this.contentInsetStart = v10.getDimensionPixelSize(styleable.TabLayout_tabContentStart, 0);
        this.mode = v10.getInt(styleable.TabLayout_tabMode, 1);
        this.tabGravity = v10.getInt(styleable.TabLayout_tabGravity, 0);
        this.inlineLabel = v10.getBoolean(styleable.TabLayout_tabInlineLabel, false);
        this.unboundedRipple = v10.getBoolean(styleable.TabLayout_tabUnboundedRipple, false);
        v10.recycle();
        Resources v9_1 = this.getResources();
        this.tabTextMultiLineSize = ((float)v9_1.getDimensionPixelSize(dimen.design_tab_text_size_2line));
        this.scrollableTabMinWidth = v9_1.getDimensionPixelSize(dimen.design_tab_scrollable_min_width);
        this.applyModeAndGravity();
    }

    static int access$1100(TabLayout arg0) {
        return arg0.defaultTabTextAppearance;
    }

    static int access$1200(TabLayout arg0) {
        return arg0.selectedTabTextAppearance;
    }

    static int access$1300(TabLayout arg0) {
        return arg0.tabTextAppearance;
    }

    static int access$1600(TabLayout arg0) {
        return arg0.viewPagerScrollState;
    }

    static TabIndicatorInterpolator access$1700(TabLayout arg0) {
        return arg0.tabIndicatorInterpolator;
    }

    static TimeInterpolator access$1900(TabLayout arg0) {
        return arg0.tabIndicatorTimeInterpolator;
    }

    @Deprecated public void addOnTabSelectedListener(BaseOnTabSelectedListener arg2) {
        if(!this.selectedListeners.contains(arg2)) {
            this.selectedListeners.add(arg2);
        }
    }

    public void addOnTabSelectedListener(OnTabSelectedListener arg1) {
        this.addOnTabSelectedListener(((BaseOnTabSelectedListener)arg1));
    }

    public void addTab(Tab arg2) {
        this.addTab(arg2, this.tabs.isEmpty());
    }

    public void addTab(Tab arg2, boolean arg3) {
        this.addTab(arg2, this.tabs.size(), arg3);
    }

    public void addTab(Tab arg2, int arg3) {
        this.addTab(arg2, arg3, this.tabs.isEmpty());
    }

    public void addTab(Tab arg2, int arg3, boolean arg4) {
        if(arg2.parent == this) {
            this.configureTab(arg2, arg3);
            this.addTabView(arg2);
            if(arg4) {
                arg2.select();
            }

            return;
        }

        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void addTabFromItemView(TabItem arg3) {
        Tab v0 = this.newTab();
        if(arg3.text != null) {
            v0.setText(arg3.text);
        }

        if(arg3.icon != null) {
            v0.setIcon(arg3.icon);
        }

        if(arg3.customLayout != 0) {
            v0.setCustomView(arg3.customLayout);
        }

        if(!TextUtils.isEmpty(arg3.getContentDescription())) {
            v0.setContentDescription(arg3.getContentDescription());
        }

        this.addTab(v0);
    }

    private void addTabView(Tab arg3) {
        TabView v0 = arg3.view;
        v0.setSelected(false);
        v0.setActivated(false);
        this.slidingTabIndicator.addView(((View)v0), arg3.getPosition(), this.createLayoutParamsForTabs());
    }

    public void addView(View arg1) {
        this.addViewInternal(arg1);
    }

    public void addView(View arg1, int arg2) {
        this.addViewInternal(arg1);
    }

    public void addView(View arg1, int arg2, ViewGroup$LayoutParams arg3) {
        this.addViewInternal(arg1);
    }

    public void addView(View arg1, ViewGroup$LayoutParams arg2) {
        this.addViewInternal(arg1);
    }

    private void addViewInternal(View arg2) {
        if((arg2 instanceof TabItem)) {
            this.addTabFromItemView(((TabItem)arg2));
            return;
        }

        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int arg4) {
        if(arg4 == -1) {
            return;
        }

        if(this.getWindowToken() != null && (ViewCompat.isLaidOut(((View)this)))) {
            if(this.slidingTabIndicator.childrenNeedLayout()) {
            }
            else {
                int v0 = this.getScrollX();
                int v1 = this.calculateScrollXForTab(arg4, 0f);
                if(v0 != v1) {
                    this.ensureScrollAnimator();
                    this.scrollAnimator.setIntValues(new int[]{v0, v1});
                    this.scrollAnimator.start();
                }

                this.slidingTabIndicator.animateIndicatorToPosition(arg4, this.tabIndicatorAnimationDuration);
                return;
            }
        }

        this.setScrollPosition(arg4, 0f, true);
    }

    private void applyGravityForModeScrollable(int arg2) {
        if(arg2 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        else if(arg2 == 1) {
            this.slidingTabIndicator.setGravity(1);
            return;
        }
        else if(arg2 != 2) {
            return;
        }

        this.slidingTabIndicator.setGravity(0x800003);
    }

    private void applyModeAndGravity() {
        int v0 = this.mode;
        int v1 = 2;
        v0 = v0 == 0 || v0 == v1 ? Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0;
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, v0, 0, 0, 0);
        v0 = this.mode;
        if(v0 != 0) {
            if(v0 != 1 && v0 != v1) {
                goto label_30;
            }

            if(this.tabGravity == v1) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }

            this.slidingTabIndicator.setGravity(1);
        }
        else {
            this.applyGravityForModeScrollable(this.tabGravity);
        }

    label_30:
        this.updateTabViews(true);
    }

    private int calculateScrollXForTab(int arg5, float arg6) {
        int v0 = this.mode;
        int v1 = 0;
        int v2 = 2;
        if(v0 != 0) {
            if(v0 == v2) {
            }
            else {
                return 0;
            }
        }

        View v0_1 = this.slidingTabIndicator.getChildAt(arg5);
        if(v0_1 == null) {
            return 0;
        }

        ++arg5;
        View v5 = arg5 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(arg5) : null;
        int v3 = v0_1.getWidth();
        if(v5 != null) {
            v1 = v5.getWidth();
        }

        arg5 = v0_1.getLeft() + v3 / 2 - this.getWidth() / v2;
        int v6 = ((int)((((float)(v3 + v1))) * 0.5f * arg6));
        if(ViewCompat.getLayoutDirection(((View)this)) == 0) {
            return arg5 + v6;
        }

        return arg5 - v6;
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    private void configureTab(Tab arg4, int arg5) {
        arg4.setPosition(arg5);
        this.tabs.add(arg5, arg4);
        int v4 = this.tabs.size();
        ++arg5;
        int v0 = -1;
        while(arg5 < v4) {
            if(this.tabs.get(arg5).getPosition() == this.indicatorPosition) {
                v0 = arg5;
            }

            this.tabs.get(arg5).setPosition(arg5);
            ++arg5;
        }

        this.indicatorPosition = v0;
    }

    private static ColorStateList createColorStateList(int arg4, int arg5) {
        int[][] v1 = new int[2][];
        int[] v0 = new int[2];
        v1[0] = TabLayout.SELECTED_STATE_SET;
        v0[0] = arg5;
        v1[1] = TabLayout.EMPTY_STATE_SET;
        v0[1] = arg4;
        return new ColorStateList(v1, v0);
    }

    private LinearLayout$LayoutParams createLayoutParamsForTabs() {
        LinearLayout$LayoutParams v0 = new LinearLayout$LayoutParams(-2, -1);
        this.updateTabViewLayoutParams(v0);
        return v0;
    }

    protected Tab createTabFromPool() {
        Object v0 = TabLayout.tabPool.acquire();
        if(v0 == null) {
            Tab v0_1 = new Tab();
        }

        return ((Tab)v0);
    }

    private TabView createTabView(Tab arg3) {
        Pool v0 = this.tabViewPool;
        Object v0_1 = v0 != null ? v0.acquire() : null;
        if(v0_1 == null) {
            TabView v0_2 = new TabView(this, this.getContext());
        }

        ((TabView)v0_1).setTab(arg3);
        ((TabView)v0_1).setFocusable(true);
        ((TabView)v0_1).setMinimumWidth(this.getTabMinWidth());
        if(TextUtils.isEmpty(Tab.access$300(arg3))) {
            ((TabView)v0_1).setContentDescription(Tab.access$400(arg3));
            return ((TabView)v0_1);
        }

        ((TabView)v0_1).setContentDescription(Tab.access$300(arg3));
        return ((TabView)v0_1);
    }

    private void dispatchTabReselected(Tab arg3) {
        int v0;
        for(v0 = this.selectedListeners.size() - 1; v0 >= 0; --v0) {
            this.selectedListeners.get(v0).onTabReselected(arg3);
        }
    }

    private void dispatchTabSelected(Tab arg3) {
        int v0;
        for(v0 = this.selectedListeners.size() - 1; v0 >= 0; --v0) {
            this.selectedListeners.get(v0).onTabSelected(arg3);
        }
    }

    private void dispatchTabUnselected(Tab arg3) {
        int v0;
        for(v0 = this.selectedListeners.size() - 1; v0 >= 0; --v0) {
            this.selectedListeners.get(v0).onTabUnselected(arg3);
        }
    }

    private void ensureScrollAnimator() {
        if(this.scrollAnimator == null) {
            ValueAnimator v0 = new ValueAnimator();
            this.scrollAnimator = v0;
            v0.setInterpolator(this.tabIndicatorTimeInterpolator);
            this.scrollAnimator.setDuration(((long)this.tabIndicatorAnimationDuration));
            this.scrollAnimator.addUpdateListener(new ValueAnimator$AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator arg2) {
                    TabLayout.this.scrollTo(arg2.getAnimatedValue().intValue(), 0);
                }
            });
        }
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    public FrameLayout$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateDefaultLayoutParams();
    }

    private int getDefaultHeight() {
        int v0 = this.tabs.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = this.tabs.get(v1);
            if(v2 != null && ((Tab)v2).getIcon() != null && !TextUtils.isEmpty(((Tab)v2).getText())) {
                if(!this.inlineLabel) {
                    return 72;
                }
                else {
                    return 0x30;
                }
            }
        }

        return 0x30;
    }

    public int getSelectedTabPosition() {
        Tab v0 = this.selectedTab;
        if(v0 != null) {
            return v0.getPosition();
        }

        return -1;
    }

    public Tab getTabAt(int arg2) {
        if(arg2 >= 0) {
            if(arg2 >= this.getTabCount()) {
            }
            else {
                return this.tabs.get(arg2);
            }
        }

        return null;
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    private int getTabMinWidth() {
        int v0 = this.requestedTabMinWidth;
        if(v0 != -1) {
            return v0;
        }

        v0 = this.mode;
        if(v0 != 0) {
            if(v0 == 2) {
            }
            else {
                return 0;
            }
        }

        return this.scrollableTabMinWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    private int getTabScrollRange() {
        return Math.max(0, this.slidingTabIndicator.getWidth() - this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    private boolean isScrollingEnabled() {
        if(this.getTabMode() != 0) {
            if(this.getTabMode() == 2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public Tab newTab() {
        Tab v0 = this.createTabFromPool();
        v0.parent = this;
        v0.view = this.createTabView(v0);
        if(Tab.access$000(v0) != -1) {
            v0.view.setId(Tab.access$000(v0));
        }

        return v0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this));
        if(this.viewPager == null) {
            ViewParent v0 = this.getParent();
            if((v0 instanceof ViewPager)) {
                this.setupWithViewPager(((ViewPager)v0), true, true);
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(this.setupViewPagerImplicitly) {
            this.setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    protected void onDraw(Canvas arg4) {
        int v0;
        for(v0 = 0; v0 < this.slidingTabIndicator.getChildCount(); ++v0) {
            View v1 = this.slidingTabIndicator.getChildAt(v0);
            if((v1 instanceof TabView)) {
                TabView.access$500(((TabView)v1), arg4);
            }
        }

        super.onDraw(arg4);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg3) {
        super.onInitializeAccessibilityNodeInfo(arg3);
        AccessibilityNodeInfoCompat.wrap(arg3).setCollectionInfo(CollectionInfoCompat.obtain(1, this.getTabCount(), false, 1));
    }

    public boolean onInterceptTouchEvent(MotionEvent arg2) {
        if((this.isScrollingEnabled()) && (super.onInterceptTouchEvent(arg2))) {
            return 1;
        }

        return 0;
    }

    protected void onMeasure(int arg7, int arg8) {
        int v0 = Math.round(ViewUtils.dpToPx(this.getContext(), this.getDefaultHeight()));
        int v1 = View$MeasureSpec.getMode(arg8);
        int v4 = 0x40000000;
        if(v1 != 0x80000000) {
            if(v1 != 0) {
            }
            else {
                arg8 = View$MeasureSpec.makeMeasureSpec(v0 + this.getPaddingTop() + this.getPaddingBottom(), v4);
            }
        }
        else if(this.getChildCount() == 1 && View$MeasureSpec.getSize(arg8) >= v0) {
            this.getChildAt(0).setMinimumHeight(v0);
        }

        v0 = View$MeasureSpec.getSize(arg7);
        if(View$MeasureSpec.getMode(arg7) != 0) {
            v1 = this.requestedTabMaxWidth;
            if(v1 > 0) {
            }
            else {
                v1 = ((int)((((float)v0)) - ViewUtils.dpToPx(this.getContext(), 56)));
            }

            this.tabMaxWidth = v1;
        }

        super.onMeasure(arg7, arg8);
        if(this.getChildCount() == 1) {
            View v7 = this.getChildAt(0);
            v0 = this.mode;
            if(v0 == 0) {
            label_52:
                if(v7.getMeasuredWidth() < this.getMeasuredWidth()) {
                    goto label_55;
                }

                return;
            }
            else if(v0 != 1) {
                if(v0 != 2) {
                    return;
                }
                else {
                    goto label_52;
                }
            }
            else if(v7.getMeasuredWidth() != this.getMeasuredWidth()) {
            }
            else {
                return;
            }

        label_55:
            v7.measure(View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), v4), TabLayout.getChildMeasureSpec(arg8, this.getPaddingTop() + this.getPaddingBottom(), v7.getLayoutParams().height));
        }
    }

    public boolean onTouchEvent(MotionEvent arg3) {
        if(arg3.getActionMasked() == 8 && !this.isScrollingEnabled()) {
            return 0;
        }

        return super.onTouchEvent(arg3);
    }

    void populateFromPagerAdapter() {
        this.removeAllTabs();
        PagerAdapter v0 = this.pagerAdapter;
        if(v0 != null) {
            int v0_1 = v0.getCount();
            int v2;
            for(v2 = 0; v2 < v0_1; ++v2) {
                this.addTab(this.newTab().setText(this.pagerAdapter.getPageTitle(v2)), false);
            }

            ViewPager v1 = this.viewPager;
            if(v1 != null && v0_1 > 0) {
                v0_1 = v1.getCurrentItem();
                if(v0_1 != this.getSelectedTabPosition() && v0_1 < this.getTabCount()) {
                    this.selectTab(this.getTabAt(v0_1));
                }
            }
        }
    }

    protected boolean releaseFromTabPool(Tab arg1) {
        return TabLayout.tabPool.release(arg1);
    }

    public void removeAllTabs() {
        int v0;
        for(v0 = this.slidingTabIndicator.getChildCount() - 1; v0 >= 0; --v0) {
            this.removeTabViewAt(v0);
        }

        Iterator v0_1 = this.tabs.iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            v0_1.remove();
            ((Tab)v1).reset();
            this.releaseFromTabPool(((Tab)v1));
        }

        this.selectedTab = null;
    }

    @Deprecated public void removeOnTabSelectedListener(BaseOnTabSelectedListener arg1) {
        this.selectedListeners.remove(arg1);
    }

    public void removeOnTabSelectedListener(OnTabSelectedListener arg1) {
        this.removeOnTabSelectedListener(((BaseOnTabSelectedListener)arg1));
    }

    public void removeTab(Tab arg2) {
        if(arg2.parent == this) {
            this.removeTabAt(arg2.getPosition());
            return;
        }

        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int arg8) {
        Tab v8;
        Tab v0 = this.selectedTab;
        int v0_1 = v0 != null ? v0.getPosition() : 0;
        this.removeTabViewAt(arg8);
        Object v2 = this.tabs.remove(arg8);
        if(v2 != null) {
            ((Tab)v2).reset();
            this.releaseFromTabPool(((Tab)v2));
        }

        int v2_1 = this.tabs.size();
        int v3 = -1;
        int v4;
        for(v4 = arg8; v4 < v2_1; ++v4) {
            if(this.tabs.get(v4).getPosition() == this.indicatorPosition) {
                v3 = v4;
            }

            this.tabs.get(v4).setPosition(v4);
        }

        this.indicatorPosition = v3;
        if(v0_1 == arg8) {
            if(this.tabs.isEmpty()) {
                v8 = null;
            }
            else {
                Object v8_1 = this.tabs.get(Math.max(0, arg8 - 1));
            }

            this.selectTab(v8);
        }
    }

    private void removeTabViewAt(int arg3) {
        View v0 = this.slidingTabIndicator.getChildAt(arg3);
        this.slidingTabIndicator.removeViewAt(arg3);
        if(v0 != null) {
            ((TabView)v0).reset();
            this.tabViewPool.release(v0);
        }

        this.requestLayout();
    }

    public void selectTab(Tab arg2) {
        this.selectTab(arg2, true);
    }

    public void selectTab(Tab arg5, boolean arg6) {
        Tab v0 = this.selectedTab;
        if(v0 != arg5) {
            int v1 = -1;
            int v2 = arg5 != null ? arg5.getPosition() : v1;
            if(arg6) {
                if(v0 != null && v0.getPosition() != v1) {
                    goto label_21;
                }
                else if(v2 != v1) {
                    this.setScrollPosition(v2, 0f, true);
                }
                else {
                label_21:
                    this.animateToTab(v2);
                }

                if(v2 == v1) {
                    goto label_24;
                }

                this.setSelectedTabView(v2);
            }

        label_24:
            this.selectedTab = arg5;
            if(v0 != null && v0.parent != null) {
                this.dispatchTabUnselected(v0);
            }

            if(arg5 == null) {
                return;
            }

            this.dispatchTabSelected(arg5);
        }
        else if(v0 != null) {
            this.dispatchTabReselected(arg5);
            this.animateToTab(arg5.getPosition());
            return;
        }
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        MaterialShapeUtils.setElevation(((View)this), arg1);
    }

    public void setInlineLabel(boolean arg3) {
        if(this.inlineLabel != arg3) {
            this.inlineLabel = arg3;
            int v3;
            for(v3 = 0; v3 < this.slidingTabIndicator.getChildCount(); ++v3) {
                View v0 = this.slidingTabIndicator.getChildAt(v3);
                if((v0 instanceof TabView)) {
                    ((TabView)v0).updateOrientation();
                }
            }

            this.applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(int arg2) {
        this.setInlineLabel(this.getResources().getBoolean(arg2));
    }

    @Deprecated public void setOnTabSelectedListener(BaseOnTabSelectedListener arg2) {
        BaseOnTabSelectedListener v0 = this.selectedListener;
        if(v0 != null) {
            this.removeOnTabSelectedListener(v0);
        }

        this.selectedListener = arg2;
        if(arg2 != null) {
            this.addOnTabSelectedListener(arg2);
        }
    }

    @Deprecated public void setOnTabSelectedListener(OnTabSelectedListener arg1) {
        this.setOnTabSelectedListener(((BaseOnTabSelectedListener)arg1));
    }

    void setPagerAdapter(PagerAdapter arg3, boolean arg4) {
        PagerAdapter v0 = this.pagerAdapter;
        if(v0 != null) {
            DataSetObserver v1 = this.pagerAdapterObserver;
            if(v1 != null) {
                v0.unregisterDataSetObserver(v1);
            }
        }

        this.pagerAdapter = arg3;
        if((arg4) && arg3 != null) {
            if(this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new PagerAdapterObserver(this);
            }

            arg3.registerDataSetObserver(this.pagerAdapterObserver);
        }

        this.populateFromPagerAdapter();
    }

    void setScrollAnimatorListener(Animator$AnimatorListener arg1) {
        this.ensureScrollAnimator();
        this.scrollAnimator.addListener(arg1);
    }

    public void setScrollPosition(int arg2, float arg3, boolean arg4) {
        this.setScrollPosition(arg2, arg3, arg4, true);
    }

    public void setScrollPosition(int arg7, float arg8, boolean arg9, boolean arg10) {
        this.setScrollPosition(arg7, arg8, arg9, arg10, true);
    }

    void setScrollPosition(int arg6, float arg7, boolean arg8, boolean arg9, boolean arg10) {
        int v1;
        int v0 = Math.round((((float)arg6)) + arg7);
        if(v0 >= 0) {
            if(v0 >= this.slidingTabIndicator.getChildCount()) {
            }
            else {
                if(arg9) {
                    this.slidingTabIndicator.setIndicatorPositionFromTabPosition(arg6, arg7);
                }

                ValueAnimator v9 = this.scrollAnimator;
                if(v9 != null && (v9.isRunning())) {
                    this.scrollAnimator.cancel();
                }

                int v7 = this.calculateScrollXForTab(arg6, arg7);
                int v9_1 = this.getScrollX();
                if(arg6 >= this.getSelectedTabPosition() || v7 < v9_1) {
                    if(arg6 > this.getSelectedTabPosition() && v7 <= v9_1) {
                        goto label_29;
                    }

                    if(arg6 == this.getSelectedTabPosition()) {
                    label_29:
                        v1 = 1;
                        goto label_32;
                    }

                    v1 = 0;
                }
                else {
                    goto label_29;
                }

            label_32:
                if(ViewCompat.getLayoutDirection(((View)this)) == 1) {
                    if(arg6 < this.getSelectedTabPosition() && v7 <= v9_1 || arg6 > this.getSelectedTabPosition() && v7 >= v9_1 || arg6 == this.getSelectedTabPosition()) {
                        v1 = 1;
                        goto label_45;
                    }

                    v1 = 0;
                }

            label_45:
                if(v1 != 0 || this.viewPagerScrollState == 1 || (arg10)) {
                    if(arg6 < 0) {
                        v7 = 0;
                    }

                    this.scrollTo(v7, 0);
                }

                if(!arg8) {
                    return;
                }

                this.setSelectedTabView(v0);
            }
        }
    }

    public void setSelectedTabIndicator(Drawable arg2) {
        GradientDrawable v2;
        if(arg2 == null) {
            v2 = new GradientDrawable();
        }

        arg2 = DrawableCompat.wrap(((Drawable)v2)).mutate();
        this.tabSelectedIndicator = arg2;
        DrawableUtils.setTint(arg2, this.tabSelectedIndicatorColor);
        int v2_1 = this.tabIndicatorHeight;
        if(v2_1 == -1) {
            v2_1 = this.tabSelectedIndicator.getIntrinsicHeight();
        }

        this.slidingTabIndicator.setSelectedIndicatorHeight(v2_1);
    }

    public void setSelectedTabIndicator(int arg2) {
        if(arg2 != 0) {
            this.setSelectedTabIndicator(AppCompatResources.getDrawable(this.getContext(), arg2));
            return;
        }

        this.setSelectedTabIndicator(null);
    }

    public void setSelectedTabIndicatorColor(int arg2) {
        this.tabSelectedIndicatorColor = arg2;
        DrawableUtils.setTint(this.tabSelectedIndicator, arg2);
        this.updateTabViews(false);
    }

    public void setSelectedTabIndicatorGravity(int arg2) {
        if(this.tabIndicatorGravity != arg2) {
            this.tabIndicatorGravity = arg2;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @Deprecated public void setSelectedTabIndicatorHeight(int arg1) {
        this.tabIndicatorHeight = arg1;
        this.slidingTabIndicator.setSelectedIndicatorHeight(arg1);
    }

    private void setSelectedTabView(int arg7) {
        boolean v5;
        int v0 = this.slidingTabIndicator.getChildCount();
        if(arg7 < v0) {
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                View v3 = this.slidingTabIndicator.getChildAt(v2);
                boolean v4 = true;
                if(v2 != arg7 || (v3.isSelected())) {
                    if(v2 != arg7 && (v3.isSelected())) {
                    label_15:
                        v5 = v2 == arg7 ? true : false;
                        v3.setSelected(v5);
                        if(v2 == arg7) {
                        }
                        else {
                            v4 = false;
                        }

                        v3.setActivated(v4);
                        if(!(v3 instanceof TabView)) {
                            goto label_37;
                        }

                        ((TabView)v3).updateTab();
                        goto label_37;
                    }

                    v5 = v2 == arg7 ? true : false;
                    v3.setSelected(v5);
                    if(v2 == arg7) {
                    }
                    else {
                        v4 = false;
                    }

                    v3.setActivated(v4);
                }
                else {
                    goto label_15;
                }

            label_37:
            }
        }
    }

    public void setTabGravity(int arg2) {
        if(this.tabGravity != arg2) {
            this.tabGravity = arg2;
            this.applyModeAndGravity();
        }
    }

    public void setTabIconTint(ColorStateList arg2) {
        if(this.tabIconTint != arg2) {
            this.tabIconTint = arg2;
            this.updateAllTabs();
        }
    }

    public void setTabIconTintResource(int arg2) {
        this.setTabIconTint(AppCompatResources.getColorStateList(this.getContext(), arg2));
    }

    public void setTabIndicatorAnimationMode(int arg2) {
        this.tabIndicatorAnimationMode = arg2;
        if(arg2 != 0) {
            if(arg2 != 1) {
                if(arg2 == 2) {
                    this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator();
                    return;
                }

                throw new IllegalArgumentException(arg2 + " is not a valid TabIndicatorAnimationMode");
            }

            this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
            return;
        }

        this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
    }

    public void setTabIndicatorFullWidth(boolean arg1) {
        this.tabIndicatorFullWidth = arg1;
        SlidingTabIndicator.access$100(this.slidingTabIndicator);
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int arg2) {
        if(arg2 != this.mode) {
            this.mode = arg2;
            this.applyModeAndGravity();
        }
    }

    public void setTabRippleColor(ColorStateList arg3) {
        if(this.tabRippleColorStateList != arg3) {
            this.tabRippleColorStateList = arg3;
            int v3;
            for(v3 = 0; v3 < this.slidingTabIndicator.getChildCount(); ++v3) {
                View v0 = this.slidingTabIndicator.getChildAt(v3);
                if((v0 instanceof TabView)) {
                    TabView.access$200(((TabView)v0), this.getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int arg2) {
        this.setTabRippleColor(AppCompatResources.getColorStateList(this.getContext(), arg2));
    }

    public void setTabTextColors(int arg1, int arg2) {
        this.setTabTextColors(TabLayout.createColorStateList(arg1, arg2));
    }

    public void setTabTextColors(ColorStateList arg2) {
        if(this.tabTextColors != arg2) {
            this.tabTextColors = arg2;
            this.updateAllTabs();
        }
    }

    @Deprecated public void setTabsFromPagerAdapter(PagerAdapter arg2) {
        this.setPagerAdapter(arg2, false);
    }

    public void setUnboundedRipple(boolean arg3) {
        if(this.unboundedRipple != arg3) {
            this.unboundedRipple = arg3;
            int v3;
            for(v3 = 0; v3 < this.slidingTabIndicator.getChildCount(); ++v3) {
                View v0 = this.slidingTabIndicator.getChildAt(v3);
                if((v0 instanceof TabView)) {
                    TabView.access$200(((TabView)v0), this.getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int arg2) {
        this.setUnboundedRipple(this.getResources().getBoolean(arg2));
    }

    private void setupWithViewPager(ViewPager arg3, boolean arg4, boolean arg5) {
        AdapterChangeListener v0_1;
        ViewPager v0 = this.viewPager;
        if(v0 != null) {
            TabLayoutOnPageChangeListener v1 = this.pageChangeListener;
            if(v1 != null) {
                v0.removeOnPageChangeListener(((OnPageChangeListener)v1));
            }

            v0_1 = this.adapterChangeListener;
            if(v0_1 == null) {
                goto label_9;
            }

            this.viewPager.removeOnAdapterChangeListener(((OnAdapterChangeListener)v0_1));
        }

    label_9:
        BaseOnTabSelectedListener v0_2 = this.currentVpSelectedListener;
        BaseOnTabSelectedListener v1_1 = null;
        if(v0_2 != null) {
            this.removeOnTabSelectedListener(v0_2);
            this.currentVpSelectedListener = v1_1;
        }

        if(arg3 != null) {
            this.viewPager = arg3;
            TabLayoutOnPageChangeListener v0_3 = this.pageChangeListener;
            if(v0_3 == null) {
                v0_3 = new TabLayoutOnPageChangeListener(this);
                this.pageChangeListener = v0_3;
            }

            v0_3.reset();
            arg3.addOnPageChangeListener(this.pageChangeListener);
            ViewPagerOnTabSelectedListener v0_4 = new ViewPagerOnTabSelectedListener(arg3);
            this.currentVpSelectedListener = ((BaseOnTabSelectedListener)v0_4);
            this.addOnTabSelectedListener(((BaseOnTabSelectedListener)v0_4));
            PagerAdapter v0_5 = arg3.getAdapter();
            if(v0_5 != null) {
                this.setPagerAdapter(v0_5, arg4);
            }

            v0_1 = this.adapterChangeListener;
            if(v0_1 == null) {
                v0_1 = new AdapterChangeListener(this);
                this.adapterChangeListener = v0_1;
            }

            v0_1.setAutoRefresh(arg4);
            arg3.addOnAdapterChangeListener(this.adapterChangeListener);
            this.setScrollPosition(arg3.getCurrentItem(), 0f, true);
        }
        else {
            this.viewPager = ((ViewPager)v1_1);
            this.setPagerAdapter(((PagerAdapter)v1_1), false);
        }

        this.setupViewPagerImplicitly = arg5;
    }

    public void setupWithViewPager(ViewPager arg2) {
        this.setupWithViewPager(arg2, true);
    }

    public void setupWithViewPager(ViewPager arg2, boolean arg3) {
        this.setupWithViewPager(arg2, arg3, false);
    }

    public boolean shouldDelayChildPressedState() {
        if(this.getTabScrollRange() > 0) {
            return 1;
        }

        return 0;
    }

    private void updateAllTabs() {
        int v0 = this.tabs.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.tabs.get(v1).updateView();
        }
    }

    private void updateTabViewLayoutParams(LinearLayout$LayoutParams arg3) {
        if(this.mode == 1 && this.tabGravity == 0) {
            arg3.width = 0;
            arg3.weight = 1f;
            return;
        }

        arg3.width = -2;
        arg3.weight = 0f;
    }

    void updateTabViews(boolean arg4) {
        int v0;
        for(v0 = 0; v0 < this.slidingTabIndicator.getChildCount(); ++v0) {
            View v1 = this.slidingTabIndicator.getChildAt(v0);
            v1.setMinimumWidth(this.getTabMinWidth());
            this.updateTabViewLayoutParams(v1.getLayoutParams());
            if(arg4) {
                v1.requestLayout();
            }
        }
    }

    void updateViewPagerScrollState(int arg1) {
        this.viewPagerScrollState = arg1;
    }
}

