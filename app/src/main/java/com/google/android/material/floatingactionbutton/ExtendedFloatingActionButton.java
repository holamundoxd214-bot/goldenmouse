package com.google.android.material.floatingactionbutton;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements AttachedBehavior {
    class com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$6 extends Property {
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$6(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(View arg1) {
            return Float.valueOf(((float)arg1.getLayoutParams().width));
        }

        public Object get(Object arg1) {
            return this.get(((View)arg1));
        }

        public void set(View arg1, Float arg2) {
            arg1.getLayoutParams().width = arg2.intValue();
            arg1.requestLayout();
        }

        public void set(Object arg1, Object arg2) {
            this.set(((View)arg1), ((Float)arg2));
        }
    }

    class com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$7 extends Property {
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$7(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(View arg1) {
            return Float.valueOf(((float)arg1.getLayoutParams().height));
        }

        public Object get(Object arg1) {
            return this.get(((View)arg1));
        }

        public void set(View arg1, Float arg2) {
            arg1.getLayoutParams().height = arg2.intValue();
            arg1.requestLayout();
        }

        public void set(Object arg1, Object arg2) {
            this.set(((View)arg1), ((Float)arg2));
        }
    }

    class com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$8 extends Property {
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$8(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(View arg1) {
            return Float.valueOf(((float)ViewCompat.getPaddingStart(arg1)));
        }

        public Object get(Object arg1) {
            return this.get(((View)arg1));
        }

        public void set(View arg3, Float arg4) {
            ViewCompat.setPaddingRelative(arg3, arg4.intValue(), arg3.getPaddingTop(), ViewCompat.getPaddingEnd(arg3), arg3.getPaddingBottom());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((View)arg1), ((Float)arg2));
        }
    }

    class com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$9 extends Property {
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$9(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(View arg1) {
            return Float.valueOf(((float)ViewCompat.getPaddingEnd(arg1)));
        }

        public Object get(Object arg1) {
            return this.get(((View)arg1));
        }

        public void set(View arg3, Float arg4) {
            ViewCompat.setPaddingRelative(arg3, ViewCompat.getPaddingStart(arg3), arg3.getPaddingTop(), arg4.intValue(), arg3.getPaddingBottom());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((View)arg1), ((Float)arg2));
        }
    }

    class ChangeSizeStrategy extends BaseMotionStrategy {
        private final boolean extending;
        private final Size size;

        ChangeSizeStrategy(ExtendedFloatingActionButton arg1, AnimatorTracker arg2, Size arg3, boolean arg4) {
            ExtendedFloatingActionButton.this = arg1;
            super(arg1, arg2);
            this.size = arg3;
            this.extending = arg4;
        }

        public AnimatorSet createAnimator() {
            float[] v9;
            float v8;
            float v7;
            PropertyValuesHolder v6;
            PropertyValuesHolder[] v2;
            MotionSpec v0 = this.getCurrentMotionSpec();
            String v1 = "width";
            int v4 = 2;
            if(v0.hasPropertyValues(v1)) {
                v2 = v0.getPropertyValues(v1);
                v6 = v2[0];
                v7 = ((float)ExtendedFloatingActionButton.this.getWidth());
                v8 = ((float)this.size.getWidth());
                v9 = new float[v4];
                v9[0] = v7;
                v9[1] = v8;
                v6.setFloatValues(v9);
                v0.setPropertyValues(v1, v2);
            }

            v1 = "height";
            if(v0.hasPropertyValues(v1)) {
                v2 = v0.getPropertyValues(v1);
                v6 = v2[0];
                v7 = ((float)ExtendedFloatingActionButton.this.getHeight());
                v8 = ((float)this.size.getHeight());
                v9 = new float[v4];
                v9[0] = v7;
                v9[1] = v8;
                v6.setFloatValues(v9);
                v0.setPropertyValues(v1, v2);
            }

            v1 = "paddingStart";
            if(v0.hasPropertyValues(v1)) {
                v2 = v0.getPropertyValues(v1);
                v6 = v2[0];
                v7 = ((float)ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this));
                v8 = ((float)this.size.getPaddingStart());
                v9 = new float[v4];
                v9[0] = v7;
                v9[1] = v8;
                v6.setFloatValues(v9);
                v0.setPropertyValues(v1, v2);
            }

            v1 = "paddingEnd";
            if(v0.hasPropertyValues(v1)) {
                v2 = v0.getPropertyValues(v1);
                v6 = v2[0];
                v7 = ((float)ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this));
                v8 = ((float)this.size.getPaddingEnd());
                v9 = new float[v4];
                v9[0] = v7;
                v9[1] = v8;
                v6.setFloatValues(v9);
                v0.setPropertyValues(v1, v2);
            }

            v1 = "labelOpacity";
            if(v0.hasPropertyValues(v1)) {
                v2 = v0.getPropertyValues(v1);
                boolean v6_1 = this.extending;
                v7 = 0f;
                v8 = 1f;
                float v9_1 = v6_1 ? 0f : v8;
                if(v6_1) {
                    v7 = v8;
                }

                v6 = v2[0];
                float[] v4_1 = new float[v4];
                v4_1[0] = v9_1;
                v4_1[1] = v7;
                v6.setFloatValues(v4_1);
                v0.setPropertyValues(v1, v2);
            }

            return super.createAnimator(v0);
        }

        public int getDefaultMotionSpecResource() {
            if(this.extending) {
                return animator.mtrl_extended_fab_change_size_expand_motion_spec;
            }

            return animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.isTransforming = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup$LayoutParams v0 = ExtendedFloatingActionButton.this.getLayoutParams();
            if(v0 == null) {
                return;
            }

            v0.width = this.size.getLayoutParams().width;
            v0.height = this.size.getLayoutParams().height;
        }

        public void onAnimationStart(Animator arg2) {
            super.onAnimationStart(arg2);
            ExtendedFloatingActionButton.this.isExtended = this.extending;
            ExtendedFloatingActionButton.this.isTransforming = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        public void onChange(OnChangedCallback arg2) {
            if(arg2 == null) {
                return;
            }

            boolean v0 = this.extending;
            ExtendedFloatingActionButton v1 = ExtendedFloatingActionButton.this;
            if(v0) {
                arg2.onExtended(v1);
                return;
            }

            arg2.onShrunken(v1);
        }

        public void performNow() {
            ExtendedFloatingActionButton.this.isExtended = this.extending;
            ViewGroup$LayoutParams v0 = ExtendedFloatingActionButton.this.getLayoutParams();
            if(v0 == null) {
                return;
            }

            if(!this.extending) {
                ExtendedFloatingActionButton.this.originalWidth = v0.width;
                ExtendedFloatingActionButton.this.originalHeight = v0.height;
            }

            v0.width = this.size.getLayoutParams().width;
            v0.height = this.size.getLayoutParams().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.size.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.size.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        public boolean shouldCancel() {
            if(this.extending != ExtendedFloatingActionButton.this.isExtended && ExtendedFloatingActionButton.this.getIcon() != null) {
                if(TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText())) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }
    }

    public class ExtendedFloatingActionButtonBehavior extends Behavior {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;
        private OnChangedCallback internalAutoHideCallback;
        private OnChangedCallback internalAutoShrinkCallback;
        private Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior(Context arg2, AttributeSet arg3) {
            super(arg2, arg3);
            TypedArray v2 = arg2.obtainStyledAttributes(arg3, styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = v2.getBoolean(styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = v2.getBoolean(styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            v2.recycle();
        }

        public ExtendedFloatingActionButtonBehavior() {
            super();
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        protected void extendOrShow(ExtendedFloatingActionButton arg2) {
            boolean v0 = this.autoShrinkEnabled;
            OnChangedCallback v1 = v0 ? this.internalAutoShrinkCallback : this.internalAutoHideCallback;
            int v0_1 = v0 ? 3 : 0;
            arg2.performMotion(v0_1, v1);
        }

        public boolean getInsetDodgeRect(CoordinatorLayout arg1, View arg2, Rect arg3) {
            return this.getInsetDodgeRect(arg1, ((ExtendedFloatingActionButton)arg2), arg3);
        }

        public boolean getInsetDodgeRect(CoordinatorLayout arg1, ExtendedFloatingActionButton arg2, Rect arg3) {
            return super.getInsetDodgeRect(arg1, ((View)arg2), arg3);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        private static boolean isBottomSheet(View arg1) {
            ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
            if((v1 instanceof LayoutParams)) {
                return ((LayoutParams)v1).getBehavior() instanceof BottomSheetBehavior;
            }

            return 0;
        }

        public void onAttachedToLayoutParams(LayoutParams arg1) {
            if(arg1.dodgeInsetEdges == 0) {
                arg1.dodgeInsetEdges = 80;
            }
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg1, View arg2, View arg3) {
            return this.onDependentViewChanged(arg1, ((ExtendedFloatingActionButton)arg2), arg3);
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg2, ExtendedFloatingActionButton arg3, View arg4) {
            if((arg4 instanceof AppBarLayout)) {
                this.updateFabVisibilityForAppBarLayout(arg2, ((AppBarLayout)arg4), arg3);
            }
            else if(ExtendedFloatingActionButtonBehavior.isBottomSheet(arg4)) {
                this.updateFabVisibilityForBottomSheet(arg4, arg3);
            }

            return 0;
        }

        public boolean onLayoutChild(CoordinatorLayout arg1, View arg2, int arg3) {
            return this.onLayoutChild(arg1, ((ExtendedFloatingActionButton)arg2), arg3);
        }

        public boolean onLayoutChild(CoordinatorLayout arg6, ExtendedFloatingActionButton arg7, int arg8) {
            List v0 = arg6.getDependencies(((View)arg7));
            int v1 = v0.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = v0.get(v2);
                if((v3 instanceof AppBarLayout)) {
                    if(this.updateFabVisibilityForAppBarLayout(arg6, ((AppBarLayout)v3), arg7)) {
                        break;
                    }
                }
                else if((ExtendedFloatingActionButtonBehavior.isBottomSheet(((View)v3))) && (this.updateFabVisibilityForBottomSheet(((View)v3), arg7))) {
                    break;
                }
            }

            arg6.onLayoutChild(((View)arg7), arg8);
            return 1;
        }

        public void setAutoHideEnabled(boolean arg1) {
            this.autoHideEnabled = arg1;
        }

        public void setAutoShrinkEnabled(boolean arg1) {
            this.autoShrinkEnabled = arg1;
        }

        void setInternalAutoHideCallback(OnChangedCallback arg1) {
            this.internalAutoHideCallback = arg1;
        }

        void setInternalAutoShrinkCallback(OnChangedCallback arg1) {
            this.internalAutoShrinkCallback = arg1;
        }

        private boolean shouldUpdateVisibility(View arg3, ExtendedFloatingActionButton arg4) {
            ViewGroup$LayoutParams v4 = arg4.getLayoutParams();
            if(!this.autoHideEnabled && !this.autoShrinkEnabled) {
                return 0;
            }

            if(((LayoutParams)v4).getAnchorId() != arg3.getId()) {
                return 0;
            }

            return 1;
        }

        protected void shrinkOrHide(ExtendedFloatingActionButton arg2) {
            boolean v0 = this.autoShrinkEnabled;
            OnChangedCallback v1 = v0 ? this.internalAutoShrinkCallback : this.internalAutoHideCallback;
            int v0_1 = v0 ? 2 : 1;
            arg2.performMotion(v0_1, v1);
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout arg2, AppBarLayout arg3, ExtendedFloatingActionButton arg4) {
            if(!this.shouldUpdateVisibility(((View)arg3), arg4)) {
                return 0;
            }

            Rect v0 = this.tmpRect;
            if(v0 == null) {
                v0 = new Rect();
                this.tmpRect = v0;
            }

            DescendantOffsetUtils.getDescendantRect(((ViewGroup)arg2), ((View)arg3), v0);
            if(v0.bottom <= arg3.getMinimumHeightForVisibleOverlappingContent()) {
                this.shrinkOrHide(arg4);
            }
            else {
                this.extendOrShow(arg4);
            }

            return 1;
        }

        private boolean updateFabVisibilityForBottomSheet(View arg3, ExtendedFloatingActionButton arg4) {
            if(!this.shouldUpdateVisibility(arg3, arg4)) {
                return 0;
            }

            if(arg3.getTop() < arg4.getHeight() / 2 + arg4.getLayoutParams().topMargin) {
                this.shrinkOrHide(arg4);
            }
            else {
                this.extendOrShow(arg4);
            }

            return 1;
        }
    }

    class HideStrategy extends BaseMotionStrategy {
        private boolean isCancelled;

        public HideStrategy(ExtendedFloatingActionButton arg1, AnimatorTracker arg2) {
            ExtendedFloatingActionButton.this = arg1;
            super(arg1, arg2);
        }

        public int getDefaultMotionSpecResource() {
            return animator.mtrl_extended_fab_hide_motion_spec;
        }

        public void onAnimationCancel() {
            super.onAnimationCancel();
            this.isCancelled = true;
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.animState = 0;
            if(!this.isCancelled) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }

        public void onAnimationStart(Animator arg2) {
            super.onAnimationStart(arg2);
            this.isCancelled = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.animState = 1;
        }

        public void onChange(OnChangedCallback arg1) {
            if(arg1 != null) {
                arg1.onHidden(ExtendedFloatingActionButton.this);
            }
        }

        public void performNow() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.this.isOrWillBeHidden();
        }
    }

    public abstract class OnChangedCallback {
        public OnChangedCallback() {
            super();
        }

        public void onExtended(ExtendedFloatingActionButton arg1) {
        }

        public void onHidden(ExtendedFloatingActionButton arg1) {
        }

        public void onShown(ExtendedFloatingActionButton arg1) {
        }

        public void onShrunken(ExtendedFloatingActionButton arg1) {
        }
    }

    class ShowStrategy extends BaseMotionStrategy {
        public ShowStrategy(ExtendedFloatingActionButton arg1, AnimatorTracker arg2) {
            ExtendedFloatingActionButton.this = arg1;
            super(arg1, arg2);
        }

        public int getDefaultMotionSpecResource() {
            return animator.mtrl_extended_fab_show_motion_spec;
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.animState = 0;
        }

        public void onAnimationStart(Animator arg2) {
            super.onAnimationStart(arg2);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.animState = 2;
        }

        public void onChange(OnChangedCallback arg1) {
            if(arg1 != null) {
                arg1.onShown(ExtendedFloatingActionButton.this);
            }
        }

        public void performNow() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1f);
            ExtendedFloatingActionButton.this.setScaleY(1f);
            ExtendedFloatingActionButton.this.setScaleX(1f);
        }

        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.this.isOrWillBeShown();
        }
    }

    interface Size {
        int getHeight();

        ViewGroup$LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private static final int DEF_STYLE_RES = 0;
    private static final int EXTEND = 3;
    private static final int EXTEND_STRATEGY_AUTO = 0;
    private static final int EXTEND_STRATEGY_MATCH_PARENT = 2;
    private static final int EXTEND_STRATEGY_WRAP_CONTENT = 1;
    static final Property HEIGHT = null;
    private static final int HIDE = 1;
    static final Property PADDING_END = null;
    static final Property PADDING_START = null;
    private static final int SHOW = 0;
    private static final int SHRINK = 2;
    static final Property WIDTH;
    private int animState;
    private boolean animateShowBeforeLayout;
    private final Behavior behavior;
    private final AnimatorTracker changeVisibilityTracker;
    private final int collapsedSize;
    private final MotionStrategy extendStrategy;
    private final int extendStrategyType;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final MotionStrategy hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;
    private int originalHeight;
    protected ColorStateList originalTextCsl;
    private int originalWidth;
    private final MotionStrategy showStrategy;
    private final MotionStrategy shrinkStrategy;

    static {
        ExtendedFloatingActionButton.DEF_STYLE_RES = style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
        Class v1 = Float.class;
        ExtendedFloatingActionButton.WIDTH = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$6(v1, "width");
        ExtendedFloatingActionButton.HEIGHT = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$7(v1, "height");
        ExtendedFloatingActionButton.PADDING_START = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$8(v1, "paddingStart");
        ExtendedFloatingActionButton.PADDING_END = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$9(v1, "paddingEnd");
    }

    public ExtendedFloatingActionButton(Context arg2) {
        this(arg2, null);
    }

    public ExtendedFloatingActionButton(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.extendedFloatingActionButtonStyle);
    }

    public ExtendedFloatingActionButton(Context arg18, AttributeSet arg19, int arg20) {
        int v5 = ExtendedFloatingActionButton.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg18, arg19, arg20, v5), arg19, arg20);
        this.animState = 0;
        AnimatorTracker v1 = new AnimatorTracker();
        this.changeVisibilityTracker = v1;
        ShowStrategy v8 = new ShowStrategy(this, v1);
        this.showStrategy = ((MotionStrategy)v8);
        HideStrategy v9 = new HideStrategy(this, v1);
        this.hideStrategy = ((MotionStrategy)v9);
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context v1_1 = this.getContext();
        this.behavior = new ExtendedFloatingActionButtonBehavior(v1_1, arg19);
        TypedArray v3 = ThemeEnforcement.obtainStyledAttributes(v1_1, arg19, styleable.ExtendedFloatingActionButton, arg20, v5, new int[0]);
        MotionSpec v6 = MotionSpec.createFromAttribute(v1_1, v3, styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec v11 = MotionSpec.createFromAttribute(v1_1, v3, styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec v12 = MotionSpec.createFromAttribute(v1_1, v3, styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec v13 = MotionSpec.createFromAttribute(v1_1, v3, styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = v3.getDimensionPixelSize(styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        int v14 = v3.getInt(styleable.ExtendedFloatingActionButton_extendStrategy, 1);
        this.extendStrategyType = v14;
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        AnimatorTracker v15 = new AnimatorTracker();
        ChangeSizeStrategy v7 = new ChangeSizeStrategy(this, v15, this.getSizeFromExtendStrategyType(v14), true);
        this.extendStrategy = ((MotionStrategy)v7);
        ChangeSizeStrategy v10 = new ChangeSizeStrategy(this, v15, new Size() {
            public int getHeight() {
                return ExtendedFloatingActionButton.this.getCollapsedSize();
            }

            public ViewGroup$LayoutParams getLayoutParams() {
                return new ViewGroup$LayoutParams(this.getWidth(), this.getHeight());
            }

            public int getPaddingEnd() {
                return ExtendedFloatingActionButton.this.getCollapsedPadding();
            }

            public int getPaddingStart() {
                return ExtendedFloatingActionButton.this.getCollapsedPadding();
            }

            public int getWidth() {
                return ExtendedFloatingActionButton.this.getCollapsedSize();
            }
        }, false);
        this.shrinkStrategy = ((MotionStrategy)v10);
        ((MotionStrategy)v8).setMotionSpec(v6);
        ((MotionStrategy)v9).setMotionSpec(v11);
        ((MotionStrategy)v7).setMotionSpec(v12);
        ((MotionStrategy)v10).setMotionSpec(v13);
        v3.recycle();
        this.setShapeAppearanceModel(ShapeAppearanceModel.builder(v1_1, arg19, arg20, v5, ShapeAppearanceModel.PILL).build());
        this.saveOriginalTextCsl();
    }

    static int access$000(ExtendedFloatingActionButton arg0) {
        return arg0.extendedPaddingStart;
    }

    static int access$100(ExtendedFloatingActionButton arg0) {
        return arg0.extendedPaddingEnd;
    }

    static int access$200(ExtendedFloatingActionButton arg0) {
        return arg0.originalHeight;
    }

    static int access$202(ExtendedFloatingActionButton arg0, int arg1) {
        arg0.originalHeight = arg1;
        return arg1;
    }

    static int access$300(ExtendedFloatingActionButton arg0) {
        return arg0.originalWidth;
    }

    static int access$302(ExtendedFloatingActionButton arg0, int arg1) {
        arg0.originalWidth = arg1;
        return arg1;
    }

    static void access$400(ExtendedFloatingActionButton arg0, int arg1, OnChangedCallback arg2) {
        arg0.performMotion(arg1, arg2);
    }

    static boolean access$500(ExtendedFloatingActionButton arg0) {
        return arg0.isExtended;
    }

    static boolean access$502(ExtendedFloatingActionButton arg0, boolean arg1) {
        arg0.isExtended = arg1;
        return arg1;
    }

    static boolean access$602(ExtendedFloatingActionButton arg0, boolean arg1) {
        arg0.isTransforming = arg1;
        return arg1;
    }

    static int access$702(ExtendedFloatingActionButton arg0, int arg1) {
        arg0.animState = arg1;
        return arg1;
    }

    static boolean access$800(ExtendedFloatingActionButton arg0) {
        return arg0.isOrWillBeShown();
    }

    static boolean access$900(ExtendedFloatingActionButton arg0) {
        return arg0.isOrWillBeHidden();
    }

    public void addOnExtendAnimationListener(Animator$AnimatorListener arg1) {
        this.extendStrategy.addAnimationListener(arg1);
    }

    public void addOnHideAnimationListener(Animator$AnimatorListener arg1) {
        this.hideStrategy.addAnimationListener(arg1);
    }

    public void addOnShowAnimationListener(Animator$AnimatorListener arg1) {
        this.showStrategy.addAnimationListener(arg1);
    }

    public void addOnShrinkAnimationListener(Animator$AnimatorListener arg1) {
        this.shrinkStrategy.addAnimationListener(arg1);
    }

    public void extend() {
        this.performMotion(3, null);
    }

    public void extend(OnChangedCallback arg2) {
        this.performMotion(3, arg2);
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    int getCollapsedPadding() {
        return (this.getCollapsedSize() - this.getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int v0 = this.collapsedSize;
        if(v0 < 0) {
            v0 = Math.min(ViewCompat.getPaddingStart(((View)this)), ViewCompat.getPaddingEnd(((View)this))) * 2 + this.getIconSize();
        }

        return v0;
    }

    public MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.getMotionSpec();
    }

    public MotionSpec getHideMotionSpec() {
        return this.hideStrategy.getMotionSpec();
    }

    public MotionSpec getShowMotionSpec() {
        return this.showStrategy.getMotionSpec();
    }

    public MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.getMotionSpec();
    }

    private Size getSizeFromExtendStrategyType(int arg4) {
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2 v0 = new Size() {
            public int getHeight() {
                return ExtendedFloatingActionButton.this.getMeasuredHeight();
            }

            public ViewGroup$LayoutParams getLayoutParams() {
                return new ViewGroup$LayoutParams(-2, -2);
            }

            public int getPaddingEnd() {
                return ExtendedFloatingActionButton.this.extendedPaddingEnd;
            }

            public int getPaddingStart() {
                return ExtendedFloatingActionButton.this.extendedPaddingStart;
            }

            public int getWidth() {
                return ExtendedFloatingActionButton.this.getMeasuredWidth() - ExtendedFloatingActionButton.this.getCollapsedPadding() * 2 + ExtendedFloatingActionButton.this.extendedPaddingStart + ExtendedFloatingActionButton.this.extendedPaddingEnd;
            }
        };
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$3 v1 = new Size(((Size)v0)) {
            public int getHeight() {
                int v0 = ExtendedFloatingActionButton.this.originalHeight;
                ExtendedFloatingActionButton v1 = ExtendedFloatingActionButton.this;
                int v2 = -2;
                if(v0 == -1) {
                    if(!(v1.getParent() instanceof View)) {
                        return this.val$wrapContentSize.getHeight();
                    }

                    ViewParent v0_1 = ExtendedFloatingActionButton.this.getParent();
                    ViewGroup$LayoutParams v1_1 = ((View)v0_1).getLayoutParams();
                    if(v1_1 != null && v1_1.height == v2) {
                        return this.val$wrapContentSize.getHeight();
                    }

                    int v1_2 = ((View)v0_1).getPaddingTop() + ((View)v0_1).getPaddingBottom();
                    if((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup$MarginLayoutParams)) {
                        ViewGroup$LayoutParams v4 = ExtendedFloatingActionButton.this.getLayoutParams();
                        if(v4 != null) {
                            v2 = ((ViewGroup$MarginLayoutParams)v4).topMargin + ((ViewGroup$MarginLayoutParams)v4).bottomMargin;
                        }
                        else {
                            goto label_35;
                        }
                    }
                    else {
                    label_35:
                        v2 = 0;
                    }

                    return ((View)v0_1).getHeight() - v2 - v1_2;
                }

                if(v1.originalHeight != 0) {
                    if(ExtendedFloatingActionButton.this.originalHeight == v2) {
                    }
                    else {
                        return ExtendedFloatingActionButton.this.originalHeight;
                    }
                }

                return this.val$wrapContentSize.getHeight();
            }

            public ViewGroup$LayoutParams getLayoutParams() {
                int v2 = ExtendedFloatingActionButton.this.originalHeight == 0 ? -2 : ExtendedFloatingActionButton.this.originalHeight;
                return new ViewGroup$LayoutParams(-1, v2);
            }

            public int getPaddingEnd() {
                return ExtendedFloatingActionButton.this.extendedPaddingEnd;
            }

            public int getPaddingStart() {
                return ExtendedFloatingActionButton.this.extendedPaddingStart;
            }

            public int getWidth() {
                int v2;
                if(!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                    return this.val$wrapContentSize.getWidth();
                }

                ViewParent v0 = ExtendedFloatingActionButton.this.getParent();
                ViewGroup$LayoutParams v1 = ((View)v0).getLayoutParams();
                if(v1 != null && v1.width == -2) {
                    return this.val$wrapContentSize.getWidth();
                }

                int v1_1 = ((View)v0).getPaddingLeft() + ((View)v0).getPaddingRight();
                if((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup$MarginLayoutParams)) {
                    ViewGroup$LayoutParams v3 = ExtendedFloatingActionButton.this.getLayoutParams();
                    if(v3 != null) {
                        v2 = ((ViewGroup$MarginLayoutParams)v3).leftMargin + ((ViewGroup$MarginLayoutParams)v3).rightMargin;
                    }
                    else {
                        goto label_31;
                    }
                }
                else {
                label_31:
                    v2 = 0;
                }

                return ((View)v0).getWidth() - v2 - v1_1;
            }
        };
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$4 v2 = new Size(((Size)v1), ((Size)v0)) {
            public int getHeight() {
                if(ExtendedFloatingActionButton.this.originalHeight == -1) {
                    return this.val$matchParentSize.getHeight();
                }

                if(ExtendedFloatingActionButton.this.originalHeight != 0) {
                    if(ExtendedFloatingActionButton.this.originalHeight == -2) {
                    }
                    else {
                        return ExtendedFloatingActionButton.this.originalHeight;
                    }
                }

                return this.val$wrapContentSize.getHeight();
            }

            public ViewGroup$LayoutParams getLayoutParams() {
                int v2 = -2;
                int v1 = ExtendedFloatingActionButton.this.originalWidth == 0 ? v2 : ExtendedFloatingActionButton.this.originalWidth;
                if(ExtendedFloatingActionButton.this.originalHeight == 0) {
                }
                else {
                    v2 = ExtendedFloatingActionButton.this.originalHeight;
                }

                return new ViewGroup$LayoutParams(v1, v2);
            }

            public int getPaddingEnd() {
                return ExtendedFloatingActionButton.this.extendedPaddingEnd;
            }

            public int getPaddingStart() {
                return ExtendedFloatingActionButton.this.extendedPaddingStart;
            }

            public int getWidth() {
                if(ExtendedFloatingActionButton.this.originalWidth == -1) {
                    return this.val$matchParentSize.getWidth();
                }

                if(ExtendedFloatingActionButton.this.originalWidth != 0) {
                    if(ExtendedFloatingActionButton.this.originalWidth == -2) {
                    }
                    else {
                        return ExtendedFloatingActionButton.this.originalWidth;
                    }
                }

                return this.val$wrapContentSize.getWidth();
            }
        };
        if(arg4 != 1) {
            if(arg4 != 2) {
                return ((Size)v2);
            }

            return ((Size)v1);
        }

        return ((Size)v0);
    }

    public void hide() {
        this.performMotion(1, null);
    }

    public void hide(OnChangedCallback arg2) {
        this.performMotion(1, arg2);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    private boolean isOrWillBeHidden() {
        int v0 = this.getVisibility();
        int v3 = this.animState;
        if(v0 == 0) {
            if(v3 == 1) {
                return 1;
            }

            return 0;
        }

        if(v3 != 2) {
            return 1;
        }

        return 0;
    }

    private boolean isOrWillBeShown() {
        int v0 = this.getVisibility();
        int v3 = this.animState;
        if(v0 != 0) {
            if(v3 == 2) {
                return 1;
            }

            return 0;
        }

        if(v3 != 1) {
            return 1;
        }

        return 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if((this.isExtended) && (TextUtils.isEmpty(this.getText())) && this.getIcon() != null) {
            this.isExtended = false;
            this.shrinkStrategy.performNow();
        }
    }

    private void performMotion(int arg4, OnChangedCallback arg5) {
        MotionStrategy v1;
        int v0 = 2;
        if(arg4 == 0) {
            v1 = this.showStrategy;
        }
        else if(arg4 == 1) {
            v1 = this.hideStrategy;
        }
        else if(arg4 == v0) {
            v1 = this.shrinkStrategy;
        }
        else if(arg4 == 3) {
            v1 = this.extendStrategy;
        }
        else {
            throw new IllegalStateException("Unknown strategy type: " + arg4);
        }

        if(v1.shouldCancel()) {
            return;
        }

        if(!this.shouldAnimateVisibilityChange()) {
            v1.performNow();
            v1.onChange(arg5);
            return;
        }

        if(arg4 == v0) {
            ViewGroup$LayoutParams v4 = this.getLayoutParams();
            if(v4 != null) {
                this.originalWidth = v4.width;
                this.originalHeight = v4.height;
            }
            else {
                this.originalWidth = this.getWidth();
                this.originalHeight = this.getHeight();
            }
        }

        this.measure(0, 0);
        AnimatorSet v4_1 = v1.createAnimator();
        ((Animator)v4_1).addListener(new AnimatorListenerAdapter(v1, arg5) {
            private boolean cancelled;

            public void onAnimationCancel(Animator arg1) {
                this.cancelled = true;
                this.val$strategy.onAnimationCancel();
            }

            public void onAnimationEnd(Animator arg1) {
                this.val$strategy.onAnimationEnd();
                if(!this.cancelled) {
                    this.val$strategy.onChange(this.val$callback);
                }
            }

            public void onAnimationStart(Animator arg2) {
                this.val$strategy.onAnimationStart(arg2);
                this.cancelled = false;
            }
        });
        Iterator v3 = v1.getListeners().iterator();
        while(v3.hasNext()) {
            ((Animator)v4_1).addListener(v3.next());
        }

        ((Animator)v4_1).start();
    }

    public void removeOnExtendAnimationListener(Animator$AnimatorListener arg1) {
        this.extendStrategy.removeAnimationListener(arg1);
    }

    public void removeOnHideAnimationListener(Animator$AnimatorListener arg1) {
        this.hideStrategy.removeAnimationListener(arg1);
    }

    public void removeOnShowAnimationListener(Animator$AnimatorListener arg1) {
        this.showStrategy.removeAnimationListener(arg1);
    }

    public void removeOnShrinkAnimationListener(Animator$AnimatorListener arg1) {
        this.shrinkStrategy.removeAnimationListener(arg1);
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = this.getTextColors();
    }

    public void setAnimateShowBeforeLayout(boolean arg1) {
        this.animateShowBeforeLayout = arg1;
    }

    public void setExtendMotionSpec(MotionSpec arg1) {
        this.extendStrategy.setMotionSpec(arg1);
    }

    public void setExtendMotionSpecResource(int arg2) {
        this.setExtendMotionSpec(MotionSpec.createFromResource(this.getContext(), arg2));
    }

    public void setExtended(boolean arg2) {
        MotionStrategy v1;
        if(this.isExtended == arg2) {
        }
        else {
            v1 = arg2 ? this.extendStrategy : this.shrinkStrategy;
            if(!v1.shouldCancel()) {
                goto label_10;
            }
        }

        return;
    label_10:
        v1.performNow();
    }

    public void setHideMotionSpec(MotionSpec arg1) {
        this.hideStrategy.setMotionSpec(arg1);
    }

    public void setHideMotionSpecResource(int arg2) {
        this.setHideMotionSpec(MotionSpec.createFromResource(this.getContext(), arg2));
    }

    public void setPadding(int arg1, int arg2, int arg3, int arg4) {
        super.setPadding(arg1, arg2, arg3, arg4);
        if((this.isExtended) && !this.isTransforming) {
            this.extendedPaddingStart = ViewCompat.getPaddingStart(((View)this));
            this.extendedPaddingEnd = ViewCompat.getPaddingEnd(((View)this));
        }
    }

    public void setPaddingRelative(int arg1, int arg2, int arg3, int arg4) {
        super.setPaddingRelative(arg1, arg2, arg3, arg4);
        if((this.isExtended) && !this.isTransforming) {
            this.extendedPaddingStart = arg1;
            this.extendedPaddingEnd = arg3;
        }
    }

    public void setShowMotionSpec(MotionSpec arg1) {
        this.showStrategy.setMotionSpec(arg1);
    }

    public void setShowMotionSpecResource(int arg2) {
        this.setShowMotionSpec(MotionSpec.createFromResource(this.getContext(), arg2));
    }

    public void setShrinkMotionSpec(MotionSpec arg1) {
        this.shrinkStrategy.setMotionSpec(arg1);
    }

    public void setShrinkMotionSpecResource(int arg2) {
        this.setShrinkMotionSpec(MotionSpec.createFromResource(this.getContext(), arg2));
    }

    public void setTextColor(int arg1) {
        super.setTextColor(arg1);
        this.saveOriginalTextCsl();
    }

    public void setTextColor(ColorStateList arg1) {
        super.setTextColor(arg1);
        this.saveOriginalTextCsl();
    }

    private boolean shouldAnimateVisibilityChange() {
        if(((ViewCompat.isLaidOut(((View)this))) || !this.isOrWillBeShown() && (this.animateShowBeforeLayout)) && !this.isInEditMode()) {
            return 1;
        }

        return 0;
    }

    public void show() {
        this.performMotion(0, null);
    }

    public void show(OnChangedCallback arg2) {
        this.performMotion(0, arg2);
    }

    public void shrink() {
        this.performMotion(2, null);
    }

    public void shrink(OnChangedCallback arg2) {
        this.performMotion(2, arg2);
    }

    protected void silentlyUpdateTextColor(ColorStateList arg1) {
        super.setTextColor(arg1);
    }
}

