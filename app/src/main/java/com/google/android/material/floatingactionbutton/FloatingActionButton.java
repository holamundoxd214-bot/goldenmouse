package com.google.android.material.floatingactionbutton;

import android.animation.Animator$AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class FloatingActionButton extends VisibilityAwareImageButton implements AttachedBehavior, TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable {
    public class BaseBehavior extends Behavior {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean autoHideEnabled;
        private OnVisibilityChangedListener internalAutoHideListener;
        private Rect tmpRect;

        public BaseBehavior() {
            super();
            this.autoHideEnabled = true;
        }

        public BaseBehavior(Context arg2, AttributeSet arg3) {
            super(arg2, arg3);
            TypedArray v2 = arg2.obtainStyledAttributes(arg3, styleable.FloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = v2.getBoolean(styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            v2.recycle();
        }

        public boolean getInsetDodgeRect(CoordinatorLayout arg1, View arg2, Rect arg3) {
            return this.getInsetDodgeRect(arg1, ((FloatingActionButton)arg2), arg3);
        }

        public boolean getInsetDodgeRect(CoordinatorLayout arg4, FloatingActionButton arg5, Rect arg6) {
            arg6.set(arg5.getLeft() + arg5.shadowPadding.left, arg5.getTop() + arg5.shadowPadding.top, arg5.getRight() - arg5.shadowPadding.right, arg5.getBottom() - arg5.shadowPadding.bottom);
            return 1;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        private static boolean isBottomSheet(View arg1) {
            ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
            if((v1 instanceof LayoutParams)) {
                return ((LayoutParams)v1).getBehavior() instanceof BottomSheetBehavior;
            }

            return 0;
        }

        private void offsetIfNeeded(CoordinatorLayout arg6, FloatingActionButton arg7) {
            int v1;
            Rect v5 = arg7.shadowPadding;
            if(v5 != null && v5.centerX() > 0 && v5.centerY() > 0) {
                ViewGroup$LayoutParams v0 = arg7.getLayoutParams();
                int v3 = 0;
                if(arg7.getRight() >= arg6.getWidth() - ((LayoutParams)v0).rightMargin) {
                    v1 = v5.right;
                }
                else if(arg7.getLeft() <= ((LayoutParams)v0).leftMargin) {
                    v1 = -v5.left;
                }
                else {
                    v1 = 0;
                }

                if(arg7.getBottom() >= arg6.getHeight() - ((LayoutParams)v0).bottomMargin) {
                    v3 = v5.bottom;
                }
                else if(arg7.getTop() <= ((LayoutParams)v0).topMargin) {
                    v3 = -v5.top;
                }

                if(v3 != 0) {
                    ViewCompat.offsetTopAndBottom(((View)arg7), v3);
                }

                if(v1 == 0) {
                    return;
                }

                ViewCompat.offsetLeftAndRight(((View)arg7), v1);
            }
        }

        public void onAttachedToLayoutParams(LayoutParams arg1) {
            if(arg1.dodgeInsetEdges == 0) {
                arg1.dodgeInsetEdges = 80;
            }
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg1, View arg2, View arg3) {
            return this.onDependentViewChanged(arg1, ((FloatingActionButton)arg2), arg3);
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg2, FloatingActionButton arg3, View arg4) {
            if((arg4 instanceof AppBarLayout)) {
                this.updateFabVisibilityForAppBarLayout(arg2, ((AppBarLayout)arg4), arg3);
            }
            else if(BaseBehavior.isBottomSheet(arg4)) {
                this.updateFabVisibilityForBottomSheet(arg4, arg3);
            }

            return 0;
        }

        public boolean onLayoutChild(CoordinatorLayout arg1, View arg2, int arg3) {
            return this.onLayoutChild(arg1, ((FloatingActionButton)arg2), arg3);
        }

        public boolean onLayoutChild(CoordinatorLayout arg6, FloatingActionButton arg7, int arg8) {
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
                else if((BaseBehavior.isBottomSheet(((View)v3))) && (this.updateFabVisibilityForBottomSheet(((View)v3), arg7))) {
                    break;
                }
            }

            arg6.onLayoutChild(((View)arg7), arg8);
            this.offsetIfNeeded(arg6, arg7);
            return 1;
        }

        public void setAutoHideEnabled(boolean arg1) {
            this.autoHideEnabled = arg1;
        }

        public void setInternalAutoHideListener(OnVisibilityChangedListener arg1) {
            this.internalAutoHideListener = arg1;
        }

        private boolean shouldUpdateVisibility(View arg3, FloatingActionButton arg4) {
            ViewGroup$LayoutParams v0 = arg4.getLayoutParams();
            if(!this.autoHideEnabled) {
                return 0;
            }

            if(((LayoutParams)v0).getAnchorId() != arg3.getId()) {
                return 0;
            }

            if(arg4.getUserSetVisibility() != 0) {
                return 0;
            }

            return 1;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout arg3, AppBarLayout arg4, FloatingActionButton arg5) {
            if(!this.shouldUpdateVisibility(((View)arg4), arg5)) {
                return 0;
            }

            Rect v0 = this.tmpRect;
            if(v0 == null) {
                v0 = new Rect();
                this.tmpRect = v0;
            }

            DescendantOffsetUtils.getDescendantRect(((ViewGroup)arg3), ((View)arg4), v0);
            int v3 = v0.bottom;
            int v4 = arg4.getMinimumHeightForVisibleOverlappingContent();
            OnVisibilityChangedListener v2 = this.internalAutoHideListener;
            if(v3 <= v4) {
                arg5.hide(v2, false);
            }
            else {
                arg5.show(v2, false);
            }

            return 1;
        }

        private boolean updateFabVisibilityForBottomSheet(View arg4, FloatingActionButton arg5) {
            if(!this.shouldUpdateVisibility(arg4, arg5)) {
                return 0;
            }

            ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
            int v4 = arg4.getTop();
            int v2 = arg5.getHeight() / 2 + ((LayoutParams)v0).topMargin;
            OnVisibilityChangedListener v3 = this.internalAutoHideListener;
            if(v4 < v2) {
                arg5.hide(v3, false);
            }
            else {
                arg5.show(v3, false);
            }

            return 1;
        }
    }

    public class com.google.android.material.floatingactionbutton.FloatingActionButton$Behavior extends BaseBehavior {
        public com.google.android.material.floatingactionbutton.FloatingActionButton$Behavior() {
            super();
        }

        public com.google.android.material.floatingactionbutton.FloatingActionButton$Behavior(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        public boolean getInsetDodgeRect(CoordinatorLayout arg1, FloatingActionButton arg2, Rect arg3) {
            return super.getInsetDodgeRect(arg1, arg2, arg3);
        }

        public boolean isAutoHideEnabled() {
            return super.isAutoHideEnabled();
        }

        public void onAttachedToLayoutParams(LayoutParams arg1) {
            super.onAttachedToLayoutParams(arg1);
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg1, FloatingActionButton arg2, View arg3) {
            return super.onDependentViewChanged(arg1, arg2, arg3);
        }

        public boolean onLayoutChild(CoordinatorLayout arg1, FloatingActionButton arg2, int arg3) {
            return super.onLayoutChild(arg1, arg2, arg3);
        }

        public void setAutoHideEnabled(boolean arg1) {
            super.setAutoHideEnabled(arg1);
        }

        public void setInternalAutoHideListener(OnVisibilityChangedListener arg1) {
            super.setInternalAutoHideListener(arg1);
        }
    }

    public abstract class OnVisibilityChangedListener {
        public OnVisibilityChangedListener() {
            super();
        }

        public void onHidden(FloatingActionButton arg1) {
        }

        public void onShown(FloatingActionButton arg1) {
        }
    }

    class ShadowDelegateImpl implements ShadowViewDelegate {
        ShadowDelegateImpl(FloatingActionButton arg1) {
            FloatingActionButton.this = arg1;
            super();
        }

        public float getRadius() {
            return (((float)FloatingActionButton.this.getSizeDimension())) / 2f;
        }

        public boolean isCompatPaddingEnabled() {
            return FloatingActionButton.this.compatPadding;
        }

        public void setBackgroundDrawable(Drawable arg1) {
            if(arg1 != null) {
                FloatingActionButton.access$101(FloatingActionButton.this, arg1);
            }
        }

        public void setShadowPadding(int arg3, int arg4, int arg5, int arg6) {
            FloatingActionButton.this.shadowPadding.set(arg3, arg4, arg5, arg6);
            FloatingActionButton.this.setPadding(arg3 + FloatingActionButton.this.imagePadding, arg4 + FloatingActionButton.this.imagePadding, arg5 + FloatingActionButton.this.imagePadding, arg6 + FloatingActionButton.this.imagePadding);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Size {
    }

    class TransformationCallbackWrapper implements InternalTransformationCallback {
        private final TransformationCallback listener;

        TransformationCallbackWrapper(FloatingActionButton arg1, TransformationCallback arg2) {
            FloatingActionButton.this = arg1;
            super();
            this.listener = arg2;
        }

        public boolean equals(Object arg2) {
            if(((arg2 instanceof TransformationCallbackWrapper)) && (((TransformationCallbackWrapper)arg2).listener.equals(this.listener))) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return this.listener.hashCode();
        }

        public void onScaleChanged() {
            this.listener.onScaleChanged(FloatingActionButton.this);
        }

        public void onTranslationChanged() {
            this.listener.onTranslationChanged(FloatingActionButton.this);
        }
    }

    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final int DEF_STYLE_RES = 0;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL;
    private ColorStateList backgroundTint;
    private PorterDuff$Mode backgroundTintMode;
    private int borderWidth;
    boolean compatPadding;
    private int customSize;
    private final ExpandableWidgetHelper expandableWidgetHelper;
    private final AppCompatImageHelper imageHelper;
    private PorterDuff$Mode imageMode;
    private int imagePadding;
    private ColorStateList imageTint;
    private FloatingActionButtonImpl impl;
    private int maxImageSize;
    private ColorStateList rippleColor;
    final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    static {
        FloatingActionButton.DEF_STYLE_RES = style.Widget_Design_FloatingActionButton;
    }

    public FloatingActionButton(Context arg2) {
        this(arg2, null);
    }

    public FloatingActionButton(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.floatingActionButtonStyle);
    }

    public FloatingActionButton(Context arg11, AttributeSet arg12, int arg13) {
        int v4 = FloatingActionButton.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg11, arg12, arg13, v4), arg12, arg13);
        this.shadowPadding = new Rect();
        this.touchArea = new Rect();
        Context v0 = this.getContext();
        AttributeSet v1 = arg12;
        int v3 = arg13;
        TypedArray v12 = ThemeEnforcement.obtainStyledAttributes(v0, v1, styleable.FloatingActionButton, v3, v4, new int[0]);
        this.backgroundTint = MaterialResources.getColorStateList(v0, v12, styleable.FloatingActionButton_backgroundTint);
        this.backgroundTintMode = ViewUtils.parseTintMode(v12.getInt(styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.rippleColor = MaterialResources.getColorStateList(v0, v12, styleable.FloatingActionButton_rippleColor);
        this.size = v12.getInt(styleable.FloatingActionButton_fabSize, -1);
        this.customSize = v12.getDimensionPixelSize(styleable.FloatingActionButton_fabCustomSize, 0);
        this.borderWidth = v12.getDimensionPixelSize(styleable.FloatingActionButton_borderWidth, 0);
        float v13 = v12.getDimension(styleable.FloatingActionButton_elevation, 0f);
        float v5 = v12.getDimension(styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0f);
        float v2 = v12.getDimension(styleable.FloatingActionButton_pressedTranslationZ, 0f);
        this.compatPadding = v12.getBoolean(styleable.FloatingActionButton_useCompatPadding, false);
        int v6 = this.getResources().getDimensionPixelSize(dimen.mtrl_fab_min_touch_target);
        this.setMaxImageSize(v12.getDimensionPixelSize(styleable.FloatingActionButton_maxImageSize, 0));
        MotionSpec v7 = MotionSpec.createFromAttribute(v0, v12, styleable.FloatingActionButton_showMotionSpec);
        MotionSpec v8 = MotionSpec.createFromAttribute(v0, v12, styleable.FloatingActionButton_hideMotionSpec);
        ShapeAppearanceModel v0_1 = ShapeAppearanceModel.builder(v0, v1, v3, v4, ShapeAppearanceModel.PILL).build();
        boolean v11 = v12.getBoolean(styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        this.setEnabled(v12.getBoolean(styleable.FloatingActionButton_android_enabled, true));
        v12.recycle();
        AppCompatImageHelper v12_1 = new AppCompatImageHelper(((ImageView)this));
        this.imageHelper = v12_1;
        v12_1.loadFromAttributes(v1, v3);
        this.expandableWidgetHelper = new ExpandableWidgetHelper(((ExpandableWidget)this));
        this.getImpl().setShapeAppearance(v0_1);
        this.getImpl().initializeBackgroundDrawable(this.backgroundTint, this.backgroundTintMode, this.rippleColor, this.borderWidth);
        this.getImpl().setMinTouchTargetSize(v6);
        this.getImpl().setElevation(v13);
        this.getImpl().setHoveredFocusedTranslationZ(v5);
        this.getImpl().setPressedTranslationZ(v2);
        this.getImpl().setShowMotionSpec(v7);
        this.getImpl().setHideMotionSpec(v8);
        this.getImpl().setEnsureMinTouchTargetSize(v11);
        this.setScaleType(ImageView$ScaleType.MATRIX);
    }

    static int access$000(FloatingActionButton arg0) {
        return arg0.imagePadding;
    }

    static void access$101(FloatingActionButton arg0, Drawable arg1) {
        super.setBackgroundDrawable(arg1);
    }

    public void addOnHideAnimationListener(Animator$AnimatorListener arg1) {
        this.getImpl().addOnHideAnimationListener(arg1);
    }

    public void addOnShowAnimationListener(Animator$AnimatorListener arg1) {
        this.getImpl().addOnShowAnimationListener(arg1);
    }

    public void addTransformationCallback(TransformationCallback arg3) {
        this.getImpl().addTransformationCallback(new TransformationCallbackWrapper(this, arg3));
    }

    public void clearCustomSize() {
        this.setCustomSize(0);
    }

    private FloatingActionButtonImpl createImpl() {
        return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl(this));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.getImpl().onDrawableStateChanged(this.getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff$Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public Behavior getBehavior() {
        return new com.google.android.material.floatingactionbutton.FloatingActionButton$Behavior();
    }

    public float getCompatElevation() {
        return this.getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return this.getImpl().getHoveredFocusedTranslationZ();
    }

    public float getCompatPressedTranslationZ() {
        return this.getImpl().getPressedTranslationZ();
    }

    public Drawable getContentBackground() {
        return this.getImpl().getContentBackground();
    }

    @Deprecated public boolean getContentRect(Rect arg4) {
        if(ViewCompat.isLaidOut(((View)this))) {
            arg4.set(0, 0, this.getWidth(), this.getHeight());
            this.offsetRectWithShadow(arg4);
            return 1;
        }

        return 0;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.getExpandedComponentIdHint();
    }

    public MotionSpec getHideMotionSpec() {
        return this.getImpl().getHideMotionSpec();
    }

    private FloatingActionButtonImpl getImpl() {
        FloatingActionButtonImpl v0 = this.impl;
        if(v0 == null) {
            v0 = this.createImpl();
            this.impl = v0;
        }

        return v0;
    }

    public void getMeasuredContentRect(Rect arg4) {
        arg4.set(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
        this.offsetRectWithShadow(arg4);
    }

    @Deprecated public int getRippleColor() {
        ColorStateList v0 = this.rippleColor;
        if(v0 != null) {
            return v0.getDefaultColor();
        }

        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return Preconditions.checkNotNull(this.getImpl().getShapeAppearance());
    }

    public MotionSpec getShowMotionSpec() {
        return this.getImpl().getShowMotionSpec();
    }

    public int getSize() {
        return this.size;
    }

    private int getSizeDimension(int arg4) {
        int v0 = this.customSize;
        if(v0 != 0) {
            return v0;
        }

        Resources v0_1 = this.getResources();
        if(arg4 != -1) {
            if(arg4 != 1) {
                return v0_1.getDimensionPixelSize(dimen.design_fab_size_normal);
            }

            return v0_1.getDimensionPixelSize(dimen.design_fab_size_mini);
        }

        if(Math.max(v0_1.getConfiguration().screenWidthDp, v0_1.getConfiguration().screenHeightDp) < 470) {
            return this.getSizeDimension(1);
        }

        return this.getSizeDimension(0);
    }

    int getSizeDimension() {
        return this.getSizeDimension(this.size);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.getBackgroundTintList();
    }

    public PorterDuff$Mode getSupportBackgroundTintMode() {
        return this.getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    public PorterDuff$Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    private void getTouchTargetRect(Rect arg1) {
        this.getMeasuredContentRect(arg1);
        int v0 = -this.impl.getTouchTargetPadding();
        arg1.inset(v0, v0);
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide(OnVisibilityChangedListener arg2) {
        this.hide(arg2, true);
    }

    public void hide() {
        this.hide(null);
    }

    void hide(OnVisibilityChangedListener arg2, boolean arg3) {
        this.getImpl().hide(this.wrapOnVisibilityChangedListener(arg2), arg3);
    }

    public boolean isExpanded() {
        return this.expandableWidgetHelper.isExpanded();
    }

    public boolean isOrWillBeHidden() {
        return this.getImpl().isOrWillBeHidden();
    }

    public boolean isOrWillBeShown() {
        return this.getImpl().isOrWillBeShown();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.getImpl().jumpDrawableToCurrentState();
    }

    private void offsetRectWithShadow(Rect arg3) {
        arg3.left += this.shadowPadding.left;
        arg3.top += this.shadowPadding.top;
        arg3.right -= this.shadowPadding.right;
        arg3.bottom -= this.shadowPadding.bottom;
    }

    private void onApplySupportImageTint() {
        Drawable v0 = this.getDrawable();
        if(v0 == null) {
            return;
        }

        ColorStateList v1 = this.imageTint;
        if(v1 == null) {
            DrawableCompat.clearColorFilter(v0);
            return;
        }

        int v1_1 = v1.getColorForState(this.getDrawableState(), 0);
        PorterDuff$Mode v4 = this.imageMode;
        if(v4 == null) {
            v4 = PorterDuff$Mode.SRC_IN;
        }

        v0.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(v1_1, v4));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getImpl().onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getImpl().onDetachedFromWindow();
    }

    protected void onMeasure(int arg3, int arg4) {
        int v0 = this.getSizeDimension();
        this.imagePadding = (v0 - this.maxImageSize) / 2;
        this.getImpl().updatePadding();
        arg3 = Math.min(View.resolveSize(v0, arg3), View.resolveSize(v0, arg4));
        this.setMeasuredDimension(this.shadowPadding.left + arg3 + this.shadowPadding.right, arg3 + this.shadowPadding.top + this.shadowPadding.bottom);
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((ExtendableSavedState)arg2).getSuperState());
        this.expandableWidgetHelper.onRestoreInstanceState(Preconditions.checkNotNull(((ExtendableSavedState)arg2).extendableStates.get("expandableWidgetHelper")));
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable v0 = super.onSaveInstanceState();
        if(v0 == null) {
            Bundle v0_1 = new Bundle();
        }

        ExtendableSavedState v1 = new ExtendableSavedState(v0);
        v1.extendableStates.put("expandableWidgetHelper", this.expandableWidgetHelper.onSaveInstanceState());
        return ((Parcelable)v1);
    }

    public boolean onTouchEvent(MotionEvent arg4) {
        if(arg4.getAction() == 0) {
            this.getTouchTargetRect(this.touchArea);
            if(!this.touchArea.contains(((int)arg4.getX()), ((int)arg4.getY()))) {
                return 0;
            }
        }

        return super.onTouchEvent(arg4);
    }

    public void removeOnHideAnimationListener(Animator$AnimatorListener arg1) {
        this.getImpl().removeOnHideAnimationListener(arg1);
    }

    public void removeOnShowAnimationListener(Animator$AnimatorListener arg1) {
        this.getImpl().removeOnShowAnimationListener(arg1);
    }

    public void removeTransformationCallback(TransformationCallback arg3) {
        this.getImpl().removeTransformationCallback(new TransformationCallbackWrapper(this, arg3));
    }

    public void setBackgroundColor(int arg1) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable arg1) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int arg1) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList arg2) {
        if(this.backgroundTint != arg2) {
            this.backgroundTint = arg2;
            this.getImpl().setBackgroundTintList(arg2);
        }
    }

    public void setBackgroundTintMode(PorterDuff$Mode arg2) {
        if(this.backgroundTintMode != arg2) {
            this.backgroundTintMode = arg2;
            this.getImpl().setBackgroundTintMode(arg2);
        }
    }

    public void setCompatElevation(float arg1) {
        this.getImpl().setElevation(arg1);
    }

    public void setCompatElevationResource(int arg2) {
        this.setCompatElevation(this.getResources().getDimension(arg2));
    }

    public void setCompatHoveredFocusedTranslationZ(float arg1) {
        this.getImpl().setHoveredFocusedTranslationZ(arg1);
    }

    public void setCompatHoveredFocusedTranslationZResource(int arg2) {
        this.setCompatHoveredFocusedTranslationZ(this.getResources().getDimension(arg2));
    }

    public void setCompatPressedTranslationZ(float arg1) {
        this.getImpl().setPressedTranslationZ(arg1);
    }

    public void setCompatPressedTranslationZResource(int arg2) {
        this.setCompatPressedTranslationZ(this.getResources().getDimension(arg2));
    }

    public void setCustomSize(int arg2) {
        if(arg2 >= 0) {
            if(arg2 != this.customSize) {
                this.customSize = arg2;
                this.requestLayout();
            }

            return;
        }

        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        this.getImpl().updateShapeElevation(arg1);
    }

    public void setEnsureMinTouchTargetSize(boolean arg2) {
        if(arg2 != this.getImpl().getEnsureMinTouchTargetSize()) {
            this.getImpl().setEnsureMinTouchTargetSize(arg2);
            this.requestLayout();
        }
    }

    public boolean setExpanded(boolean arg1) {
        return this.expandableWidgetHelper.setExpanded(arg1);
    }

    public void setExpandedComponentIdHint(int arg1) {
        this.expandableWidgetHelper.setExpandedComponentIdHint(arg1);
    }

    public void setHideMotionSpec(MotionSpec arg1) {
        this.getImpl().setHideMotionSpec(arg1);
    }

    public void setHideMotionSpecResource(int arg2) {
        this.setHideMotionSpec(MotionSpec.createFromResource(this.getContext(), arg2));
    }

    public void setImageDrawable(Drawable arg2) {
        if(this.getDrawable() != arg2) {
            super.setImageDrawable(arg2);
            this.getImpl().updateImageMatrixScale();
            if(this.imageTint != null) {
                this.onApplySupportImageTint();
            }
        }
    }

    public void setImageResource(int arg2) {
        this.imageHelper.setImageResource(arg2);
        this.onApplySupportImageTint();
    }

    public void setMaxImageSize(int arg1) {
        this.maxImageSize = arg1;
        this.getImpl().setMaxImageSize(arg1);
    }

    public void setRippleColor(int arg1) {
        this.setRippleColor(ColorStateList.valueOf(arg1));
    }

    public void setRippleColor(ColorStateList arg2) {
        if(this.rippleColor != arg2) {
            this.rippleColor = arg2;
            this.getImpl().setRippleColor(this.rippleColor);
        }
    }

    public void setScaleX(float arg1) {
        super.setScaleX(arg1);
        this.getImpl().onScaleChanged();
    }

    public void setScaleY(float arg1) {
        super.setScaleY(arg1);
        this.getImpl().onScaleChanged();
    }

    public void setShadowPaddingEnabled(boolean arg1) {
        this.getImpl().setShadowPaddingEnabled(arg1);
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg1) {
        this.getImpl().setShapeAppearance(arg1);
    }

    public void setShowMotionSpec(MotionSpec arg1) {
        this.getImpl().setShowMotionSpec(arg1);
    }

    public void setShowMotionSpecResource(int arg2) {
        this.setShowMotionSpec(MotionSpec.createFromResource(this.getContext(), arg2));
    }

    public void setSize(int arg2) {
        this.customSize = 0;
        if(arg2 != this.size) {
            this.size = arg2;
            this.requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList arg1) {
        this.setBackgroundTintList(arg1);
    }

    public void setSupportBackgroundTintMode(PorterDuff$Mode arg1) {
        this.setBackgroundTintMode(arg1);
    }

    public void setSupportImageTintList(ColorStateList arg2) {
        if(this.imageTint != arg2) {
            this.imageTint = arg2;
            this.onApplySupportImageTint();
        }
    }

    public void setSupportImageTintMode(PorterDuff$Mode arg2) {
        if(this.imageMode != arg2) {
            this.imageMode = arg2;
            this.onApplySupportImageTint();
        }
    }

    public void setTranslationX(float arg1) {
        super.setTranslationX(arg1);
        this.getImpl().onTranslationChanged();
    }

    public void setTranslationY(float arg1) {
        super.setTranslationY(arg1);
        this.getImpl().onTranslationChanged();
    }

    public void setTranslationZ(float arg1) {
        super.setTranslationZ(arg1);
        this.getImpl().onTranslationChanged();
    }

    public void setUseCompatPadding(boolean arg2) {
        if(this.compatPadding != arg2) {
            this.compatPadding = arg2;
            this.getImpl().onCompatShadowChanged();
        }
    }

    public void setVisibility(int arg1) {
        super.setVisibility(arg1);
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.getImpl().getEnsureMinTouchTargetSize();
    }

    public void show(OnVisibilityChangedListener arg2) {
        this.show(arg2, true);
    }

    public void show() {
        this.show(null);
    }

    void show(OnVisibilityChangedListener arg2, boolean arg3) {
        this.getImpl().show(this.wrapOnVisibilityChangedListener(arg2), arg3);
    }

    private InternalVisibilityChangedListener wrapOnVisibilityChangedListener(OnVisibilityChangedListener arg2) {
        if(arg2 == null) {
            return null;
        }

        return new InternalVisibilityChangedListener(arg2) {
            public void onHidden() {
                this.val$listener.onHidden(FloatingActionButton.this);
            }

            public void onShown() {
                this.val$listener.onShown(FloatingActionButton.this);
            }
        };
    }
}

