package com.google.android.material.navigation;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View$OnLayoutChangeListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

public abstract class NavigationBarItemView extends FrameLayout implements ItemView {
    class ActiveIndicatorTransform {
        private static final float ALPHA_FRACTION = 0.2f;
        private static final float SCALE_X_HIDDEN = 0.4f;
        private static final float SCALE_X_SHOWN = 1f;

        ActiveIndicatorTransform(com.google.android.material.navigation.NavigationBarItemView$1 arg1) {
            this();
        }

        private ActiveIndicatorTransform() {
            super();
        }

        protected float calculateAlpha(float arg3, float arg4) {
            int v4 = Float.compare(arg4, 0f);
            float v0 = v4 == 0 ? 0.8f : 0f;
            float v1 = 1f;
            arg4 = v4 == 0 ? v1 : 0.2f;
            return AnimationUtils.lerp(0f, v1, v0, arg4, arg3);
        }

        protected float calculateScaleX(float arg1, float arg2) {
            return AnimationUtils.lerp(0.4f, 1f, arg1);
        }

        protected float calculateScaleY(float arg1, float arg2) {
            return 1f;
        }

        public void updateForProgress(float arg2, float arg3, View arg4) {
            arg4.setScaleX(this.calculateScaleX(arg2, arg3));
            arg4.setScaleY(this.calculateScaleY(arg2, arg3));
            arg4.setAlpha(this.calculateAlpha(arg2, arg3));
        }
    }

    class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        ActiveIndicatorUnlabeledTransform(com.google.android.material.navigation.NavigationBarItemView$1 arg1) {
            this();
        }

        private ActiveIndicatorUnlabeledTransform() {
            super(null);
        }

        protected float calculateScaleY(float arg1, float arg2) {
            return this.calculateScaleX(arg1, arg2);
        }
    }

    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_LABELED_TRANSFORM = null;
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_UNLABELED_TRANSFORM = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight;
    private int activeIndicatorDesiredWidth;
    private boolean activeIndicatorEnabled;
    private int activeIndicatorLabelPadding;
    private int activeIndicatorMarginHorizontal;
    private float activeIndicatorProgress;
    private boolean activeIndicatorResizeable;
    private ActiveIndicatorTransform activeIndicatorTransform;
    private final View activeIndicatorView;
    private int activeTextAppearance;
    private BadgeDrawable badgeDrawable;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private ColorStateList iconTint;
    private boolean initialized;
    private boolean isShifting;
    Drawable itemBackground;
    private MenuItemImpl itemData;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition;
    private ColorStateList itemRippleColor;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    private Drawable wrappedIconDrawable;

    static {
        NavigationBarItemView.CHECKED_STATE_SET = new int[]{0x10100A0};
        NavigationBarItemView.ACTIVE_INDICATOR_LABELED_TRANSFORM = new ActiveIndicatorTransform(null);
        NavigationBarItemView.ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new ActiveIndicatorUnlabeledTransform(null);
    }

    public NavigationBarItemView(Context arg7) {
        super(arg7);
        this.initialized = false;
        this.itemPosition = -1;
        this.activeTextAppearance = 0;
        this.activeIndicatorTransform = NavigationBarItemView.ACTIVE_INDICATOR_LABELED_TRANSFORM;
        this.activeIndicatorProgress = 0f;
        this.activeIndicatorEnabled = false;
        this.activeIndicatorDesiredWidth = 0;
        this.activeIndicatorDesiredHeight = 0;
        this.activeIndicatorResizeable = false;
        this.activeIndicatorMarginHorizontal = 0;
        LayoutInflater.from(arg7).inflate(this.getItemLayoutResId(), ((ViewGroup)this), true);
        this.iconContainer = this.findViewById(id.navigation_bar_item_icon_container);
        this.activeIndicatorView = this.findViewById(id.navigation_bar_item_active_indicator_view);
        View v7 = this.findViewById(id.navigation_bar_item_icon_view);
        this.icon = ((ImageView)v7);
        View v0 = this.findViewById(id.navigation_bar_item_labels_group);
        this.labelGroup = ((ViewGroup)v0);
        View v2 = this.findViewById(id.navigation_bar_item_small_label_view);
        this.smallLabel = ((TextView)v2);
        View v3 = this.findViewById(id.navigation_bar_item_large_label_view);
        this.largeLabel = ((TextView)v3);
        this.setBackgroundResource(this.getItemBackgroundResId());
        this.itemPaddingTop = this.getResources().getDimensionPixelSize(this.getItemDefaultMarginResId());
        this.itemPaddingBottom = ((ViewGroup)v0).getPaddingBottom();
        this.activeIndicatorLabelPadding = this.getResources().getDimensionPixelSize(dimen.m3_navigation_item_active_indicator_label_padding);
        ViewCompat.setImportantForAccessibility(v2, 2);
        ViewCompat.setImportantForAccessibility(v3, 2);
        this.setFocusable(true);
        this.calculateTextScaleFactors(((TextView)v2).getTextSize(), ((TextView)v3).getTextSize());
        if(v7 != null) {
            ((ImageView)v7).addOnLayoutChangeListener(new View$OnLayoutChangeListener() {
                public void onLayoutChange(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
                    if(NavigationBarItemView.access$200(NavigationBarItemView.this).getVisibility() == 0) {
                        NavigationBarItemView.access$300(NavigationBarItemView.this, NavigationBarItemView.access$200(NavigationBarItemView.this));
                    }
                }
            });
        }
    }

    static ImageView access$200(NavigationBarItemView arg0) {
        return arg0.icon;
    }

    static void access$300(NavigationBarItemView arg0, View arg1) {
        arg0.tryUpdateBadgeBounds(arg1);
    }

    static void access$400(NavigationBarItemView arg0, int arg1) {
        arg0.updateActiveIndicatorLayoutParams(arg1);
    }

    static void access$500(NavigationBarItemView arg0, float arg1, float arg2) {
        arg0.setActiveIndicatorProgress(arg1, arg2);
    }

    private void calculateTextScaleFactors(float arg3, float arg4) {
        this.shiftAmount = arg3 - arg4;
        this.scaleUpFactor = arg4 * 1f / arg3;
        this.scaleDownFactor = arg3 * 1f / arg4;
    }

    void clear() {
        this.removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0f;
        this.initialized = false;
    }

    private static Drawable createItemBackgroundCompat(ColorStateList arg2) {
        return new RippleDrawable(RippleUtils.convertToRippleDrawableColor(arg2), null, null);
    }

    public boolean dispatchTouchEvent(MotionEvent arg3) {
        FrameLayout v0 = this.iconContainer;
        if(v0 != null && (this.activeIndicatorEnabled)) {
            v0.dispatchTouchEvent(arg3);
        }

        return super.dispatchTouchEvent(arg3);
    }

    public Drawable getActiveIndicatorDrawable() {
        View v0 = this.activeIndicatorView;
        if(v0 == null) {
            return null;
        }

        return v0.getBackground();
    }

    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    private FrameLayout getCustomParentForBadge(View arg3) {
        FrameLayout v1 = null;
        if(arg3 == this.icon && (BadgeUtils.USE_COMPAT_PARENT)) {
            return this.icon.getParent();
        }

        return v1;
    }

    private View getIconOrContainer() {
        FrameLayout v0 = this.iconContainer;
        if(v0 != null) {
            return ((View)v0);
        }

        return this.icon;
    }

    protected int getItemBackgroundResId() {
        return drawable.mtrl_navigation_bar_item_background;
    }

    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    protected int getItemDefaultMarginResId() {
        return dimen.mtrl_navigation_bar_item_default_margin;
    }

    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    private int getItemVisiblePosition() {
        ViewParent v0 = this.getParent();
        int v5 = ((ViewGroup)v0).indexOfChild(((View)this));
        int v1 = 0;
        int v2 = 0;
        while(v1 < v5) {
            View v3 = ((ViewGroup)v0).getChildAt(v1);
            if(((v3 instanceof NavigationBarItemView)) && v3.getVisibility() == 0) {
                ++v2;
            }

            ++v1;
        }

        return v2;
    }

    private int getSuggestedIconHeight() {
        return this.getIconOrContainer().getLayoutParams().topMargin + this.getIconOrContainer().getMeasuredHeight();
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable v0 = this.badgeDrawable;
        int v0_1 = v0 == null ? 0 : v0.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        ViewGroup$LayoutParams v1 = this.getIconOrContainer().getLayoutParams();
        return Math.max(v0_1, ((FrameLayout$LayoutParams)v1).leftMargin) + this.icon.getMeasuredWidth() + Math.max(v0_1, ((FrameLayout$LayoutParams)v1).rightMargin);
    }

    protected int getSuggestedMinimumHeight() {
        ViewGroup$LayoutParams v0 = this.labelGroup.getLayoutParams();
        int v1 = this.getSuggestedIconHeight();
        int v2 = this.labelGroup.getVisibility() == 0 ? this.activeIndicatorLabelPadding : 0;
        return v1 + v2 + ((FrameLayout$LayoutParams)v0).topMargin + this.labelGroup.getMeasuredHeight() + ((FrameLayout$LayoutParams)v0).bottomMargin;
    }

    protected int getSuggestedMinimumWidth() {
        ViewGroup$LayoutParams v0 = this.labelGroup.getLayoutParams();
        return Math.max(this.getSuggestedIconWidth(), ((FrameLayout$LayoutParams)v0).leftMargin + this.labelGroup.getMeasuredWidth() + ((FrameLayout$LayoutParams)v0).rightMargin);
    }

    private boolean hasBadge() {
        if(this.badgeDrawable != null) {
            return 1;
        }

        return 0;
    }

    public void initialize(MenuItemImpl arg1, int arg2) {
        this.itemData = arg1;
        this.setCheckable(arg1.isCheckable());
        this.setChecked(arg1.isChecked());
        this.setEnabled(arg1.isEnabled());
        this.setIcon(arg1.getIcon());
        this.setTitle(arg1.getTitle());
        this.setId(arg1.getItemId());
        if(!TextUtils.isEmpty(arg1.getContentDescription())) {
            this.setContentDescription(arg1.getContentDescription());
        }

        CharSequence v2 = !TextUtils.isEmpty(arg1.getTooltipText()) ? arg1.getTooltipText() : arg1.getTitle();
        TooltipCompat.setTooltipText(((View)this), v2);
        int v1 = arg1.isVisible() ? 0 : 8;
        this.setVisibility(v1);
        this.initialized = true;
    }

    private boolean isActiveIndicatorResizeableAndUnlabeled() {
        if((this.activeIndicatorResizeable) && this.labelVisibilityMode == 2) {
            return 1;
        }

        return 0;
    }

    private void maybeAnimateActiveIndicatorToProgress(float arg5) {
        if((this.activeIndicatorEnabled) && (this.initialized)) {
            if(!ViewCompat.isAttachedToWindow(((View)this))) {
            }
            else {
                ValueAnimator v0 = this.activeIndicatorAnimator;
                if(v0 != null) {
                    v0.cancel();
                    this.activeIndicatorAnimator = null;
                }

                v0 = ValueAnimator.ofFloat(new float[]{this.activeIndicatorProgress, arg5});
                this.activeIndicatorAnimator = v0;
                v0.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(arg5) {
                    public void onAnimationUpdate(ValueAnimator arg2) {
                        NavigationBarItemView.this.setActiveIndicatorProgress(arg2.getAnimatedValue().floatValue(), this.val$newProgress);
                    }
                });
                this.activeIndicatorAnimator.setInterpolator(MotionUtils.resolveThemeInterpolator(this.getContext(), attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
                this.activeIndicatorAnimator.setDuration(((long)MotionUtils.resolveThemeDuration(this.getContext(), attr.motionDurationLong2, this.getResources().getInteger(integer.material_motion_duration_long_1))));
                this.activeIndicatorAnimator.start();
                return;
            }
        }

        this.setActiveIndicatorProgress(arg5, arg5);
    }

    public int[] onCreateDrawableState(int arg2) {
        int[] v2 = super.onCreateDrawableState(arg2 + 1);
        MenuItemImpl v0 = this.itemData;
        if(v0 != null && (v0.isCheckable()) && (this.itemData.isChecked())) {
            NavigationBarItemView.mergeDrawableStates(v2, NavigationBarItemView.CHECKED_STATE_SET);
        }

        return v2;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg7) {
        super.onInitializeAccessibilityNodeInfo(arg7);
        BadgeDrawable v0 = this.badgeDrawable;
        if(v0 != null && (v0.isVisible())) {
            CharSequence v0_1 = this.itemData.getTitle();
            if(!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                v0_1 = this.itemData.getContentDescription();
            }

            arg7.setContentDescription(v0_1 + ", " + this.badgeDrawable.getContentDescription());
        }

        AccessibilityNodeInfoCompat v7 = AccessibilityNodeInfoCompat.wrap(arg7);
        v7.setCollectionItemInfo(CollectionItemInfoCompat.obtain(0, 1, this.getItemVisiblePosition(), 1, false, this.isSelected()));
        if(this.isSelected()) {
            v7.setClickable(false);
            v7.removeAction(AccessibilityActionCompat.ACTION_CLICK);
        }

        v7.setRoleDescription(this.getResources().getString(string.item_view_role_description));
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        this.post(new Runnable(arg1) {
            public void run() {
                NavigationBarItemView.this.updateActiveIndicatorLayoutParams(this.val$width);
            }
        });
    }

    public boolean prefersCondensedTitle() {
        return 0;
    }

    private void refreshChecked() {
        MenuItemImpl v0 = this.itemData;
        if(v0 != null) {
            this.setChecked(v0.isChecked());
        }
    }

    private void refreshItemBackground() {
        RippleDrawable v3_1;
        Drawable v0 = this.itemBackground;
        Drawable v3 = null;
        boolean v4 = true;
        if(this.itemRippleColor != null) {
            Drawable v1 = this.getActiveIndicatorDrawable();
            if((this.activeIndicatorEnabled) && this.getActiveIndicatorDrawable() != null && this.iconContainer != null && v1 != null) {
                v3_1 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.itemRippleColor), v3, v1);
                v4 = false;
                goto label_24;
            }

            if(v0 != null) {
                goto label_24;
            }

            v0 = NavigationBarItemView.createItemBackgroundCompat(this.itemRippleColor);
        }

    label_24:
        FrameLayout v1_1 = this.iconContainer;
        if(v1_1 != null) {
            v1_1.setPadding(0, 0, 0, 0);
            this.iconContainer.setForeground(((Drawable)v3_1));
        }

        ViewCompat.setBackground(((View)this), v0);
        this.setDefaultFocusHighlightEnabled(v4);
    }

    void removeBadge() {
        this.tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setActiveIndicatorDrawable(Drawable arg2) {
        View v0 = this.activeIndicatorView;
        if(v0 == null) {
            return;
        }

        v0.setBackgroundDrawable(arg2);
        this.refreshItemBackground();
    }

    public void setActiveIndicatorEnabled(boolean arg2) {
        this.activeIndicatorEnabled = arg2;
        this.refreshItemBackground();
        View v0 = this.activeIndicatorView;
        if(v0 != null) {
            int v2 = arg2 ? 0 : 8;
            v0.setVisibility(v2);
            this.requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int arg1) {
        this.activeIndicatorDesiredHeight = arg1;
        this.updateActiveIndicatorLayoutParams(this.getWidth());
    }

    public void setActiveIndicatorLabelPadding(int arg2) {
        if(this.activeIndicatorLabelPadding != arg2) {
            this.activeIndicatorLabelPadding = arg2;
            this.refreshChecked();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int arg1) {
        this.activeIndicatorMarginHorizontal = arg1;
        this.updateActiveIndicatorLayoutParams(this.getWidth());
    }

    private void setActiveIndicatorProgress(float arg3, float arg4) {
        View v0 = this.activeIndicatorView;
        if(v0 != null) {
            this.activeIndicatorTransform.updateForProgress(arg3, arg4, v0);
        }

        this.activeIndicatorProgress = arg3;
    }

    public void setActiveIndicatorResizeable(boolean arg1) {
        this.activeIndicatorResizeable = arg1;
    }

    public void setActiveIndicatorWidth(int arg1) {
        this.activeIndicatorDesiredWidth = arg1;
        this.updateActiveIndicatorLayoutParams(this.getWidth());
    }

    void setBadge(BadgeDrawable arg3) {
        if(this.badgeDrawable == arg3) {
        }
        else {
            if((this.hasBadge()) && this.icon != null) {
                Log.w("NavigationBar", "Multiple badges shouldn\'t be attached to one item.");
                this.tryRemoveBadgeFromAnchor(this.icon);
            }

            this.badgeDrawable = arg3;
            ImageView v3 = this.icon;
            if(v3 == null) {
                return;
            }

            this.tryAttachBadgeToAnchor(((View)v3));
        }
    }

    public void setCheckable(boolean arg1) {
        this.refreshDrawableState();
    }

    public void setChecked(boolean arg9) {
        int v2 = 2;
        this.largeLabel.setPivotX(((float)(this.largeLabel.getWidth() / v2)));
        this.largeLabel.setPivotY(((float)this.largeLabel.getBaseline()));
        this.smallLabel.setPivotX(((float)(this.smallLabel.getWidth() / v2)));
        this.smallLabel.setPivotY(((float)this.smallLabel.getBaseline()));
        float v0 = 1f;
        float v1 = arg9 ? v0 : 0f;
        this.maybeAnimateActiveIndicatorToProgress(v1);
        int v1_1 = this.labelVisibilityMode;
        int v4 = 17;
        int v5 = 49;
        int v6 = 4;
        if(v1_1 == -1) {
            if(this.isShifting) {
                if(arg9) {
                    NavigationBarItemView.setViewTopMarginAndGravity(this.getIconOrContainer(), this.itemPaddingTop, v5);
                    NavigationBarItemView.updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
                    this.largeLabel.setVisibility(0);
                }
                else {
                    NavigationBarItemView.setViewTopMarginAndGravity(this.getIconOrContainer(), this.itemPaddingTop, v4);
                    NavigationBarItemView.updateViewPaddingBottom(this.labelGroup, 0);
                    this.largeLabel.setVisibility(v6);
                }

                this.smallLabel.setVisibility(v6);
                goto label_139;
            }

            NavigationBarItemView.updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
            if(arg9) {
                NavigationBarItemView.setViewTopMarginAndGravity(this.getIconOrContainer(), ((int)((((float)this.itemPaddingTop)) + this.shiftAmount)), v5);
                NavigationBarItemView.setViewScaleValues(this.largeLabel, v0, v0, 0);
                NavigationBarItemView.setViewScaleValues(this.smallLabel, this.scaleUpFactor, this.scaleUpFactor, v6);
                goto label_139;
            }

            NavigationBarItemView.setViewTopMarginAndGravity(this.getIconOrContainer(), this.itemPaddingTop, v5);
            NavigationBarItemView.setViewScaleValues(this.largeLabel, this.scaleDownFactor, this.scaleDownFactor, v6);
            NavigationBarItemView.setViewScaleValues(this.smallLabel, v0, v0, 0);
        }
        else if(v1_1 == 0) {
            if(arg9) {
                NavigationBarItemView.setViewTopMarginAndGravity(this.getIconOrContainer(), this.itemPaddingTop, v5);
                NavigationBarItemView.updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
                this.largeLabel.setVisibility(0);
            }
            else {
                NavigationBarItemView.setViewTopMarginAndGravity(this.getIconOrContainer(), this.itemPaddingTop, v4);
                NavigationBarItemView.updateViewPaddingBottom(this.labelGroup, 0);
                this.largeLabel.setVisibility(v6);
            }

            this.smallLabel.setVisibility(v6);
        }
        else if(v1_1 == 1) {
            NavigationBarItemView.updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
            if(arg9) {
                NavigationBarItemView.setViewTopMarginAndGravity(this.getIconOrContainer(), ((int)((((float)this.itemPaddingTop)) + this.shiftAmount)), v5);
                NavigationBarItemView.setViewScaleValues(this.largeLabel, v0, v0, 0);
                NavigationBarItemView.setViewScaleValues(this.smallLabel, this.scaleUpFactor, this.scaleUpFactor, v6);
            }
            else {
                NavigationBarItemView.setViewTopMarginAndGravity(this.getIconOrContainer(), this.itemPaddingTop, v5);
                NavigationBarItemView.setViewScaleValues(this.largeLabel, this.scaleDownFactor, this.scaleDownFactor, v6);
                NavigationBarItemView.setViewScaleValues(this.smallLabel, v0, v0, 0);
            }
        }
        else if(v1_1 != v2) {
        }
        else {
            NavigationBarItemView.setViewTopMarginAndGravity(this.getIconOrContainer(), this.itemPaddingTop, v4);
            this.largeLabel.setVisibility(8);
            this.smallLabel.setVisibility(8);
        }

    label_139:
        this.refreshDrawableState();
        this.setSelected(arg9);
    }

    public void setEnabled(boolean arg2) {
        super.setEnabled(arg2);
        this.smallLabel.setEnabled(arg2);
        this.largeLabel.setEnabled(arg2);
        this.icon.setEnabled(arg2);
        if(arg2) {
            ViewCompat.setPointerIcon(((View)this), PointerIconCompat.getSystemIcon(this.getContext(), 1002));
            return;
        }

        ViewCompat.setPointerIcon(((View)this), null);
    }

    public void setIcon(Drawable arg2) {
        if(arg2 == this.originalIconDrawable) {
            return;
        }

        this.originalIconDrawable = arg2;
        if(arg2 != null) {
            Drawable$ConstantState v0 = arg2.getConstantState();
            if(v0 == null) {
            }
            else {
                arg2 = v0.newDrawable();
            }

            arg2 = DrawableCompat.wrap(arg2).mutate();
            this.wrappedIconDrawable = arg2;
            ColorStateList v0_1 = this.iconTint;
            if(v0_1 == null) {
                goto label_15;
            }

            DrawableCompat.setTintList(arg2, v0_1);
        }

    label_15:
        this.icon.setImageDrawable(arg2);
    }

    public void setIconSize(int arg2) {
        ViewGroup$LayoutParams v0 = this.icon.getLayoutParams();
        ((FrameLayout$LayoutParams)v0).width = arg2;
        ((FrameLayout$LayoutParams)v0).height = arg2;
        this.icon.setLayoutParams(v0);
    }

    public void setIconTintList(ColorStateList arg2) {
        this.iconTint = arg2;
        if(this.itemData != null) {
            Drawable v0 = this.wrappedIconDrawable;
            if(v0 != null) {
                DrawableCompat.setTintList(v0, arg2);
                this.wrappedIconDrawable.invalidateSelf();
            }
        }
    }

    public void setItemBackground(int arg2) {
        Drawable v2 = arg2 == 0 ? null : ContextCompat.getDrawable(this.getContext(), arg2);
        this.setItemBackground(v2);
    }

    public void setItemBackground(Drawable arg2) {
        if(arg2 != null && arg2.getConstantState() != null) {
            arg2 = arg2.getConstantState().newDrawable().mutate();
        }

        this.itemBackground = arg2;
        this.refreshItemBackground();
    }

    public void setItemPaddingBottom(int arg2) {
        if(this.itemPaddingBottom != arg2) {
            this.itemPaddingBottom = arg2;
            this.refreshChecked();
        }
    }

    public void setItemPaddingTop(int arg2) {
        if(this.itemPaddingTop != arg2) {
            this.itemPaddingTop = arg2;
            this.refreshChecked();
        }
    }

    public void setItemPosition(int arg1) {
        this.itemPosition = arg1;
    }

    public void setItemRippleColor(ColorStateList arg1) {
        this.itemRippleColor = arg1;
        this.refreshItemBackground();
    }

    public void setLabelVisibilityMode(int arg2) {
        if(this.labelVisibilityMode != arg2) {
            this.labelVisibilityMode = arg2;
            this.updateActiveIndicatorTransform();
            this.updateActiveIndicatorLayoutParams(this.getWidth());
            this.refreshChecked();
        }
    }

    public void setShifting(boolean arg2) {
        if(this.isShifting != arg2) {
            this.isShifting = arg2;
            this.refreshChecked();
        }
    }

    public void setShortcut(boolean arg1, char arg2) {
    }

    public void setTextAppearanceActive(int arg2) {
        this.activeTextAppearance = arg2;
        NavigationBarItemView.setTextAppearanceWithoutFontScaling(this.largeLabel, arg2);
        this.calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean arg2) {
        this.setTextAppearanceActive(this.activeTextAppearance);
        this.largeLabel.setTypeface(this.largeLabel.getTypeface(), ((int)arg2));
    }

    public void setTextAppearanceInactive(int arg2) {
        NavigationBarItemView.setTextAppearanceWithoutFontScaling(this.smallLabel, arg2);
        this.calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    private static void setTextAppearanceWithoutFontScaling(TextView arg2, int arg3) {
        TextViewCompat.setTextAppearance(arg2, arg3);
        arg3 = MaterialResources.getUnscaledTextSize(arg2.getContext(), arg3, 0);
        if(arg3 != 0) {
            arg2.setTextSize(0, ((float)arg3));
        }
    }

    public void setTextColor(ColorStateList arg2) {
        if(arg2 != null) {
            this.smallLabel.setTextColor(arg2);
            this.largeLabel.setTextColor(arg2);
        }
    }

    public void setTitle(CharSequence arg2) {
        this.smallLabel.setText(arg2);
        this.largeLabel.setText(arg2);
        MenuItemImpl v0 = this.itemData;
        if(v0 == null || (TextUtils.isEmpty(v0.getContentDescription()))) {
            this.setContentDescription(arg2);
        }

        v0 = this.itemData;
        if(v0 != null) {
            if(TextUtils.isEmpty(v0.getTooltipText())) {
            }
            else {
                arg2 = this.itemData.getTooltipText();
            }
        }

        TooltipCompat.setTooltipText(((View)this), arg2);
    }

    private static void setViewScaleValues(View arg0, float arg1, float arg2, int arg3) {
        arg0.setScaleX(arg1);
        arg0.setScaleY(arg2);
        arg0.setVisibility(arg3);
    }

    private static void setViewTopMarginAndGravity(View arg1, int arg2, int arg3) {
        ViewGroup$LayoutParams v0 = arg1.getLayoutParams();
        ((FrameLayout$LayoutParams)v0).topMargin = arg2;
        ((FrameLayout$LayoutParams)v0).bottomMargin = arg2;
        ((FrameLayout$LayoutParams)v0).gravity = arg3;
        arg1.setLayoutParams(v0);
    }

    public boolean showsIcon() {
        return 1;
    }

    private void tryAttachBadgeToAnchor(View arg2) {
        if(!this.hasBadge()) {
        }
        else if(arg2 != null) {
            this.setClipChildren(false);
            this.setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, arg2, this.getCustomParentForBadge(arg2));
        }
    }

    private void tryRemoveBadgeFromAnchor(View arg2) {
        if(!this.hasBadge()) {
            return;
        }

        if(arg2 != null) {
            this.setClipChildren(true);
            this.setClipToPadding(true);
            BadgeUtils.detachBadgeDrawable(this.badgeDrawable, arg2);
        }

        this.badgeDrawable = null;
    }

    private void tryUpdateBadgeBounds(View arg2) {
        if(!this.hasBadge()) {
            return;
        }

        BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, arg2, this.getCustomParentForBadge(arg2));
    }

    private void updateActiveIndicatorLayoutParams(int arg3) {
        if(this.activeIndicatorView != null) {
            if(arg3 <= 0) {
            }
            else {
                arg3 = Math.min(this.activeIndicatorDesiredWidth, arg3 - this.activeIndicatorMarginHorizontal * 2);
                ViewGroup$LayoutParams v0 = this.activeIndicatorView.getLayoutParams();
                int v1 = this.isActiveIndicatorResizeableAndUnlabeled() ? arg3 : this.activeIndicatorDesiredHeight;
                ((FrameLayout$LayoutParams)v0).height = v1;
                ((FrameLayout$LayoutParams)v0).width = arg3;
                this.activeIndicatorView.setLayoutParams(v0);
            }
        }
    }

    private void updateActiveIndicatorTransform() {
        if(this.isActiveIndicatorResizeableAndUnlabeled()) {
            this.activeIndicatorTransform = NavigationBarItemView.ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
            return;
        }

        this.activeIndicatorTransform = NavigationBarItemView.ACTIVE_INDICATOR_LABELED_TRANSFORM;
    }

    private static void updateViewPaddingBottom(View arg3, int arg4) {
        arg3.setPadding(arg3.getPaddingLeft(), arg3.getPaddingTop(), arg3.getPaddingRight(), arg4);
    }
}

