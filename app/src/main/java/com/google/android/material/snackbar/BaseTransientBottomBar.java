package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler$Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnClickListener;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransientBottomBar {
    class com.google.android.material.snackbar.BaseTransientBottomBar$1 implements Handler$Callback {
        com.google.android.material.snackbar.BaseTransientBottomBar$1() {
            super();
        }

        public boolean handleMessage(Message arg2) {
            int v1 = arg2.what;
            if(v1 != 0) {
                if(v1 != 1) {
                    return 0;
                }

                arg2.obj.hideView(arg2.arg1);
                return 1;
            }

            arg2.obj.showView();
            return 1;
        }
    }

    class com.google.android.material.snackbar.BaseTransientBottomBar$2 implements Runnable {
        com.google.android.material.snackbar.BaseTransientBottomBar$2(BaseTransientBottomBar arg1) {
            BaseTransientBottomBar.this = arg1;
            super();
        }

        public void run() {
            if(BaseTransientBottomBar.this.view != null) {
                if(BaseTransientBottomBar.this.context == null) {
                }
                else {
                    int v0 = WindowUtils.getCurrentWindowBounds(BaseTransientBottomBar.this.context).height() - BaseTransientBottomBar.this.getViewAbsoluteBottom() + (((int)BaseTransientBottomBar.this.view.getTranslationY()));
                    int v1 = BaseTransientBottomBar.this.extraBottomMarginGestureInset;
                    BaseTransientBottomBar v2 = BaseTransientBottomBar.this;
                    if(v0 >= v1) {
                        v2.appliedBottomMarginGestureInset = v2.extraBottomMarginGestureInset;
                        return;
                    }
                    else {
                        ViewGroup$LayoutParams v1_1 = v2.view.getLayoutParams();
                        if(!(v1_1 instanceof ViewGroup$MarginLayoutParams)) {
                            Log.w(BaseTransientBottomBar.TAG, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                            return;
                        }
                        else {
                            BaseTransientBottomBar.this.appliedBottomMarginGestureInset = BaseTransientBottomBar.this.extraBottomMarginGestureInset;
                            ((ViewGroup$MarginLayoutParams)v1_1).bottomMargin += BaseTransientBottomBar.this.extraBottomMarginGestureInset - v0;
                            BaseTransientBottomBar.this.view.requestLayout();
                        }
                    }
                }
            }
        }
    }

    class com.google.android.material.snackbar.BaseTransientBottomBar$5 implements Callback {
        com.google.android.material.snackbar.BaseTransientBottomBar$5(BaseTransientBottomBar arg1) {
            BaseTransientBottomBar.this = arg1;
            super();
        }

        public void dismiss(int arg5) {
            BaseTransientBottomBar.handler.sendMessage(BaseTransientBottomBar.handler.obtainMessage(1, arg5, 0, BaseTransientBottomBar.this));
        }

        public void show() {
            BaseTransientBottomBar.handler.sendMessage(BaseTransientBottomBar.handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    class Anchor implements View$OnAttachStateChangeListener, ViewTreeObserver$OnGlobalLayoutListener {
        private final WeakReference anchorView;
        private final WeakReference transientBottomBar;

        private Anchor(BaseTransientBottomBar arg2, View arg3) {
            super();
            this.transientBottomBar = new WeakReference(arg2);
            this.anchorView = new WeakReference(arg3);
        }

        static Anchor anchor(BaseTransientBottomBar arg1, View arg2) {
            Anchor v0 = new Anchor(arg1, arg2);
            if(ViewCompat.isAttachedToWindow(arg2)) {
                ViewUtils.addOnGlobalLayoutListener(arg2, ((ViewTreeObserver$OnGlobalLayoutListener)v0));
            }

            arg2.addOnAttachStateChangeListener(((View$OnAttachStateChangeListener)v0));
            return v0;
        }

        View getAnchorView() {
            return this.anchorView.get();
        }

        public void onGlobalLayout() {
            if(!this.unanchorIfNoTransientBottomBar()) {
                if(!this.transientBottomBar.get().anchorViewLayoutListenerEnabled) {
                }
                else {
                    this.transientBottomBar.get().recalculateAndUpdateMargins();
                }
            }
        }

        public void onViewAttachedToWindow(View arg2) {
            if(this.unanchorIfNoTransientBottomBar()) {
                return;
            }

            ViewUtils.addOnGlobalLayoutListener(arg2, ((ViewTreeObserver$OnGlobalLayoutListener)this));
        }

        public void onViewDetachedFromWindow(View arg2) {
            if(this.unanchorIfNoTransientBottomBar()) {
                return;
            }

            ViewUtils.removeOnGlobalLayoutListener(arg2, ((ViewTreeObserver$OnGlobalLayoutListener)this));
        }

        void unanchor() {
            if(this.anchorView.get() != null) {
                this.anchorView.get().removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
                ViewUtils.removeOnGlobalLayoutListener(this.anchorView.get(), ((ViewTreeObserver$OnGlobalLayoutListener)this));
            }

            this.anchorView.clear();
            this.transientBottomBar.clear();
        }

        private boolean unanchorIfNoTransientBottomBar() {
            if(this.transientBottomBar.get() == null) {
                this.unanchor();
                return 1;
            }

            return 0;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface AnimationMode {
    }

    public abstract class BaseCallback {
        @Retention(value=RetentionPolicy.SOURCE) @public interface DismissEvent {
        }

        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public BaseCallback() {
            super();
        }

        public void onDismissed(Object arg1, int arg2) {
        }

        public void onShown(Object arg1) {
        }
    }

    public class Behavior extends SwipeDismissBehavior {
        private final BehaviorDelegate delegate;

        public Behavior() {
            super();
            this.delegate = new BehaviorDelegate(((SwipeDismissBehavior)this));
        }

        static void access$1100(Behavior arg0, BaseTransientBottomBar arg1) {
            arg0.setBaseTransientBottomBar(arg1);
        }

        public boolean canSwipeDismissView(View arg1) {
            return this.delegate.canSwipeDismissView(arg1);
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout arg2, View arg3, MotionEvent arg4) {
            this.delegate.onInterceptTouchEvent(arg2, arg3, arg4);
            return super.onInterceptTouchEvent(arg2, arg3, arg4);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar arg1) {
            this.delegate.setBaseTransientBottomBar(arg1);
        }
    }

    public class BehaviorDelegate {
        private Callback managerCallback;

        public BehaviorDelegate(SwipeDismissBehavior arg1) {
            super();
            arg1.setStartAlphaSwipeDistance(0.1f);
            arg1.setEndAlphaSwipeDistance(0.6f);
            arg1.setSwipeDirection(0);
        }

        public boolean canSwipeDismissView(View arg1) {
            return arg1 instanceof SnackbarBaseLayout;
        }

        public void onInterceptTouchEvent(CoordinatorLayout arg2, View arg3, MotionEvent arg4) {
            int v0 = arg4.getActionMasked();
            if(v0 != 0) {
                if(v0 != 1 && v0 != 3) {
                    return;
                }

                SnackbarManager.getInstance().restoreTimeoutIfPaused(this.managerCallback);
                return;
            }
            else {
                if(!arg2.isPointInChildBounds(arg3, ((int)arg4.getX()), ((int)arg4.getY()))) {
                    return;
                }

                SnackbarManager.getInstance().pauseTimeout(this.managerCallback);
            }
        }

        public void setBaseTransientBottomBar(BaseTransientBottomBar arg1) {
            this.managerCallback = arg1.managerCallback;
        }
    }

    @Deprecated public interface ContentViewCallback extends com.google.android.material.snackbar.ContentViewCallback {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Duration {
    }

    public class SnackbarBaseLayout extends FrameLayout {
        class com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout$1 implements View$OnTouchListener {
            com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout$1() {
                super();
            }

            public boolean onTouch(View arg1, MotionEvent arg2) {
                return 1;
            }
        }

        private final float actionTextColorAlpha;
        private boolean addingToTargetParent;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private ColorStateList backgroundTint;
        private PorterDuff$Mode backgroundTintMode;
        private BaseTransientBottomBar baseTransientBottomBar;
        private static final View$OnTouchListener consumeAllTouchListener;
        private final int maxInlineActionWidth;
        private final int maxWidth;
        private Rect originalMargins;
        ShapeAppearanceModel shapeAppearanceModel;

        static {
            SnackbarBaseLayout.consumeAllTouchListener = new com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout$1();
        }

        protected SnackbarBaseLayout(Context arg2) {
            this(arg2, null);
        }

        protected SnackbarBaseLayout(Context arg4, AttributeSet arg5) {
            super(MaterialThemeOverlay.wrap(arg4, arg5, 0, 0), arg5);
            arg4 = this.getContext();
            TypedArray v1 = arg4.obtainStyledAttributes(arg5, styleable.SnackbarLayout);
            if(v1.hasValue(styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(((View)this), ((float)v1.getDimensionPixelSize(styleable.SnackbarLayout_elevation, 0)));
            }

            this.animationMode = v1.getInt(styleable.SnackbarLayout_animationMode, 0);
            if((v1.hasValue(styleable.SnackbarLayout_shapeAppearance)) || (v1.hasValue(styleable.SnackbarLayout_shapeAppearanceOverlay))) {
                this.shapeAppearanceModel = ShapeAppearanceModel.builder(arg4, arg5, 0, 0).build();
            }

            this.backgroundOverlayColorAlpha = v1.getFloat(styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1f);
            this.setBackgroundTintList(MaterialResources.getColorStateList(arg4, v1, styleable.SnackbarLayout_backgroundTint));
            this.setBackgroundTintMode(ViewUtils.parseTintMode(v1.getInt(styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff$Mode.SRC_IN));
            this.actionTextColorAlpha = v1.getFloat(styleable.SnackbarLayout_actionTextColorAlpha, 1f);
            this.maxWidth = v1.getDimensionPixelSize(styleable.SnackbarLayout_android_maxWidth, -1);
            this.maxInlineActionWidth = v1.getDimensionPixelSize(styleable.SnackbarLayout_maxActionInlineWidth, -1);
            v1.recycle();
            this.setOnTouchListener(SnackbarBaseLayout.consumeAllTouchListener);
            this.setFocusable(true);
            if(this.getBackground() == null) {
                ViewCompat.setBackground(((View)this), this.createThemedBackground());
            }
        }

        static Rect access$1000(SnackbarBaseLayout arg0) {
            return arg0.originalMargins;
        }

        static void access$500(SnackbarBaseLayout arg0, BaseTransientBottomBar arg1) {
            arg0.setBaseTransientBottomBar(arg1);
        }

        void addToTargetParent(ViewGroup arg2) {
            this.addingToTargetParent = true;
            arg2.addView(((View)this));
            this.addingToTargetParent = false;
        }

        private Drawable createThemedBackground() {
            MaterialShapeDrawable v0_1;
            int v0 = MaterialColors.layer(((View)this), attr.colorSurface, attr.colorOnSurface, this.getBackgroundOverlayColorAlpha());
            ShapeAppearanceModel v1 = this.shapeAppearanceModel;
            if(v1 != null) {
                v0_1 = BaseTransientBottomBar.createMaterialShapeDrawableBackground(v0, v1);
            }
            else {
                GradientDrawable v0_2 = BaseTransientBottomBar.createGradientDrawableBackground(v0, this.getResources());
            }

            if(this.backgroundTint != null) {
                Drawable v0_3 = DrawableCompat.wrap(((Drawable)v0_1));
                DrawableCompat.setTintList(v0_3, this.backgroundTint);
                return v0_3;
            }

            return DrawableCompat.wrap(((Drawable)v0_1));
        }

        float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        int getAnimationMode() {
            return this.animationMode;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        int getMaxInlineActionWidth() {
            return this.maxInlineActionWidth;
        }

        int getMaxWidth() {
            return this.maxWidth;
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar v0 = this.baseTransientBottomBar;
            if(v0 != null) {
                v0.onAttachedToWindow();
            }

            ViewCompat.requestApplyInsets(((View)this));
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar v0 = this.baseTransientBottomBar;
            if(v0 != null) {
                v0.onDetachedFromWindow();
            }
        }

        protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
            super.onLayout(arg1, arg2, arg3, arg4, arg5);
            BaseTransientBottomBar v0 = this.baseTransientBottomBar;
            if(v0 != null) {
                v0.onLayoutChange();
            }
        }

        protected void onMeasure(int arg2, int arg3) {
            super.onMeasure(arg2, arg3);
            if(this.maxWidth > 0) {
                arg2 = this.getMeasuredWidth();
                int v0 = this.maxWidth;
                if(arg2 > v0) {
                    super.onMeasure(View$MeasureSpec.makeMeasureSpec(v0, 0x40000000), arg3);
                }
            }
        }

        void setAnimationMode(int arg1) {
            this.animationMode = arg1;
        }

        public void setBackground(Drawable arg1) {
            this.setBackgroundDrawable(arg1);
        }

        public void setBackgroundDrawable(Drawable arg2) {
            if(arg2 != null && this.backgroundTint != null) {
                arg2 = DrawableCompat.wrap(arg2.mutate());
                DrawableCompat.setTintList(arg2, this.backgroundTint);
                DrawableCompat.setTintMode(arg2, this.backgroundTintMode);
            }

            super.setBackgroundDrawable(arg2);
        }

        public void setBackgroundTintList(ColorStateList arg2) {
            this.backgroundTint = arg2;
            if(this.getBackground() != null) {
                Drawable v0 = DrawableCompat.wrap(this.getBackground().mutate());
                DrawableCompat.setTintList(v0, arg2);
                DrawableCompat.setTintMode(v0, this.backgroundTintMode);
                if(v0 != this.getBackground()) {
                    super.setBackgroundDrawable(v0);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff$Mode arg2) {
            this.backgroundTintMode = arg2;
            if(this.getBackground() != null) {
                Drawable v0 = DrawableCompat.wrap(this.getBackground().mutate());
                DrawableCompat.setTintMode(v0, arg2);
                if(v0 != this.getBackground()) {
                    super.setBackgroundDrawable(v0);
                }
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar arg1) {
            this.baseTransientBottomBar = arg1;
        }

        public void setLayoutParams(ViewGroup$LayoutParams arg2) {
            super.setLayoutParams(arg2);
            if(!this.addingToTargetParent && ((arg2 instanceof ViewGroup$MarginLayoutParams))) {
                this.updateOriginalMargins(((ViewGroup$MarginLayoutParams)arg2));
                BaseTransientBottomBar v1 = this.baseTransientBottomBar;
                if(v1 != null) {
                    v1.updateMargins();
                }
            }
        }

        public void setOnClickListener(View$OnClickListener arg2) {
            View$OnTouchListener v0 = arg2 != null ? null : SnackbarBaseLayout.consumeAllTouchListener;
            this.setOnTouchListener(v0);
            super.setOnClickListener(arg2);
        }

        private void updateOriginalMargins(ViewGroup$MarginLayoutParams arg5) {
            this.originalMargins = new Rect(arg5.leftMargin, arg5.topMargin, arg5.rightMargin, arg5.bottomMargin);
        }
    }

    public static final int ANIMATION_MODE_FADE = 1;
    public static final int ANIMATION_MODE_SLIDE = 0;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    static final int DEFAULT_ANIMATION_FADE_DURATION = 180;
    private static final TimeInterpolator DEFAULT_ANIMATION_FADE_INTERPOLATOR = null;
    private static final int DEFAULT_ANIMATION_FADE_IN_DURATION = 150;
    private static final int DEFAULT_ANIMATION_FADE_OUT_DURATION = 75;
    private static final TimeInterpolator DEFAULT_ANIMATION_SCALE_INTERPOLATOR = null;
    private static final TimeInterpolator DEFAULT_ANIMATION_SLIDE_INTERPOLATOR = null;
    static final int DEFAULT_SLIDE_ANIMATION_DURATION = 0xFA;
    public static final int LENGTH_INDEFINITE = -2;
    public static final int LENGTH_LONG = 0;
    public static final int LENGTH_SHORT = -1;
    static final int MSG_DISMISS = 1;
    static final int MSG_SHOW;
    private static final int[] SNACKBAR_STYLE_ATTR;
    private static final String TAG;
    private static final boolean USE_OFFSET_API;
    private final AccessibilityManager accessibilityManager;
    private Anchor anchor;
    private boolean anchorViewLayoutListenerEnabled;
    private final int animationFadeInDuration;
    private final TimeInterpolator animationFadeInterpolator;
    private final int animationFadeOutDuration;
    private final TimeInterpolator animationScaleInterpolator;
    private final int animationSlideDuration;
    private final TimeInterpolator animationSlideInterpolator;
    private int appliedBottomMarginGestureInset;
    private Behavior behavior;
    private final Runnable bottomMarginGestureInsetRunnable;
    private List callbacks;
    private final com.google.android.material.snackbar.ContentViewCallback contentViewCallback;
    private final Context context;
    private int duration;
    private int extraBottomMarginAnchorView;
    private int extraBottomMarginGestureInset;
    private int extraBottomMarginWindowInset;
    private int extraLeftMarginWindowInset;
    private int extraRightMarginWindowInset;
    private boolean gestureInsetBottomIgnored;
    static final Handler handler;
    Callback managerCallback;
    private boolean pendingShowingView;
    private final ViewGroup targetParent;
    protected final SnackbarBaseLayout view;

    static {
        BaseTransientBottomBar.DEFAULT_ANIMATION_SLIDE_INTERPOLATOR = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        BaseTransientBottomBar.DEFAULT_ANIMATION_FADE_INTERPOLATOR = AnimationUtils.LINEAR_INTERPOLATOR;
        BaseTransientBottomBar.DEFAULT_ANIMATION_SCALE_INTERPOLATOR = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
        BaseTransientBottomBar.USE_OFFSET_API = false;
        BaseTransientBottomBar.SNACKBAR_STYLE_ATTR = new int[]{attr.snackbarStyle};
        BaseTransientBottomBar.TAG = "BaseTransientBottomBar";
        BaseTransientBottomBar.handler = new Handler(Looper.getMainLooper(), new com.google.android.material.snackbar.BaseTransientBottomBar$1());
    }

    protected BaseTransientBottomBar(Context arg3, ViewGroup arg4, View arg5, com.google.android.material.snackbar.ContentViewCallback arg6) {
        super();
        this.anchorViewLayoutListenerEnabled = false;
        this.bottomMarginGestureInsetRunnable = new com.google.android.material.snackbar.BaseTransientBottomBar$2(this);
        this.managerCallback = new com.google.android.material.snackbar.BaseTransientBottomBar$5(this);
        if(arg4 != null) {
            if(arg5 != null) {
                if(arg6 != null) {
                    this.targetParent = arg4;
                    this.contentViewCallback = arg6;
                    this.context = arg3;
                    ThemeEnforcement.checkAppCompatTheme(arg3);
                    View v4 = LayoutInflater.from(arg3).inflate(this.getSnackbarBaseLayoutResId(), arg4, false);
                    this.view = ((SnackbarBaseLayout)v4);
                    SnackbarBaseLayout.access$500(((SnackbarBaseLayout)v4), this);
                    if((arg5 instanceof SnackbarContentLayout)) {
                        arg5.updateActionTextColorAlphaIfNeeded(((SnackbarBaseLayout)v4).getActionTextColorAlpha());
                        arg5.setMaxInlineActionWidth(((SnackbarBaseLayout)v4).getMaxInlineActionWidth());
                    }

                    ((SnackbarBaseLayout)v4).addView(arg5);
                    ViewCompat.setAccessibilityLiveRegion(v4, 1);
                    ViewCompat.setImportantForAccessibility(v4, 1);
                    ViewCompat.setFitsSystemWindows(v4, true);
                    ViewCompat.setOnApplyWindowInsetsListener(v4, new OnApplyWindowInsetsListener() {
                        public WindowInsetsCompat onApplyWindowInsets(View arg2, WindowInsetsCompat arg3) {
                            BaseTransientBottomBar.access$602(BaseTransientBottomBar.this, arg3.getSystemWindowInsetBottom());
                            BaseTransientBottomBar.access$702(BaseTransientBottomBar.this, arg3.getSystemWindowInsetLeft());
                            BaseTransientBottomBar.access$802(BaseTransientBottomBar.this, arg3.getSystemWindowInsetRight());
                            BaseTransientBottomBar.access$900(BaseTransientBottomBar.this);
                            return arg3;
                        }
                    });
                    ViewCompat.setAccessibilityDelegate(v4, new AccessibilityDelegateCompat() {
                        public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
                            super.onInitializeAccessibilityNodeInfo(arg1, arg2);
                            arg2.addAction(0x100000);
                            arg2.setDismissable(true);
                        }

                        public boolean performAccessibilityAction(View arg2, int arg3, Bundle arg4) {
                            if(arg3 == 0x100000) {
                                BaseTransientBottomBar.this.dismiss();
                                return 1;
                            }

                            return super.performAccessibilityAction(arg2, arg3, arg4);
                        }
                    });
                    this.accessibilityManager = arg3.getSystemService("accessibility");
                    this.animationSlideDuration = MotionUtils.resolveThemeDuration(arg3, attr.motionDurationLong2, 0xFA);
                    this.animationFadeInDuration = MotionUtils.resolveThemeDuration(arg3, attr.motionDurationLong2, 150);
                    this.animationFadeOutDuration = MotionUtils.resolveThemeDuration(arg3, attr.motionDurationMedium1, 75);
                    this.animationFadeInterpolator = MotionUtils.resolveThemeInterpolator(arg3, attr.motionEasingEmphasizedInterpolator, BaseTransientBottomBar.DEFAULT_ANIMATION_FADE_INTERPOLATOR);
                    this.animationScaleInterpolator = MotionUtils.resolveThemeInterpolator(arg3, attr.motionEasingEmphasizedInterpolator, BaseTransientBottomBar.DEFAULT_ANIMATION_SCALE_INTERPOLATOR);
                    this.animationSlideInterpolator = MotionUtils.resolveThemeInterpolator(arg3, attr.motionEasingEmphasizedInterpolator, BaseTransientBottomBar.DEFAULT_ANIMATION_SLIDE_INTERPOLATOR);
                    return;
                }

                throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
            }

            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }

        throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
    }

    protected BaseTransientBottomBar(ViewGroup arg2, View arg3, com.google.android.material.snackbar.ContentViewCallback arg4) {
        this(arg2.getContext(), arg2, arg3, arg4);
    }

    static Context access$000(BaseTransientBottomBar arg0) {
        return arg0.context;
    }

    static int access$100(BaseTransientBottomBar arg0) {
        return arg0.getViewAbsoluteBottom();
    }

    static void access$1200(BaseTransientBottomBar arg0) {
        arg0.startFadeInAnimation();
    }

    static void access$1300(BaseTransientBottomBar arg0) {
        arg0.startSlideInAnimation();
    }

    static int access$1400(BaseTransientBottomBar arg0) {
        return arg0.animationSlideDuration;
    }

    static int access$1500(BaseTransientBottomBar arg0) {
        return arg0.animationFadeInDuration;
    }

    static com.google.android.material.snackbar.ContentViewCallback access$1600(BaseTransientBottomBar arg0) {
        return arg0.contentViewCallback;
    }

    static boolean access$1700() {
        return BaseTransientBottomBar.USE_OFFSET_API;
    }

    static int access$1800(BaseTransientBottomBar arg0) {
        return arg0.animationFadeOutDuration;
    }

    static MaterialShapeDrawable access$1900(int arg0, ShapeAppearanceModel arg1) {
        return BaseTransientBottomBar.createMaterialShapeDrawableBackground(arg0, arg1);
    }

    static int access$200(BaseTransientBottomBar arg0) {
        return arg0.extraBottomMarginGestureInset;
    }

    static GradientDrawable access$2000(int arg0, Resources arg1) {
        return BaseTransientBottomBar.createGradientDrawableBackground(arg0, arg1);
    }

    static boolean access$2100(BaseTransientBottomBar arg0) {
        return arg0.anchorViewLayoutListenerEnabled;
    }

    static void access$2200(BaseTransientBottomBar arg0) {
        arg0.recalculateAndUpdateMargins();
    }

    static int access$302(BaseTransientBottomBar arg0, int arg1) {
        arg0.appliedBottomMarginGestureInset = arg1;
        return arg1;
    }

    static String access$400() {
        return BaseTransientBottomBar.TAG;
    }

    static int access$602(BaseTransientBottomBar arg0, int arg1) {
        arg0.extraBottomMarginWindowInset = arg1;
        return arg1;
    }

    static int access$702(BaseTransientBottomBar arg0, int arg1) {
        arg0.extraLeftMarginWindowInset = arg1;
        return arg1;
    }

    static int access$802(BaseTransientBottomBar arg0, int arg1) {
        arg0.extraRightMarginWindowInset = arg1;
        return arg1;
    }

    static void access$900(BaseTransientBottomBar arg0) {
        arg0.updateMargins();
    }

    public BaseTransientBottomBar addCallback(BaseCallback arg2) {
        if(arg2 == null) {
            return this;
        }

        if(this.callbacks == null) {
            this.callbacks = new ArrayList();
        }

        this.callbacks.add(arg2);
        return this;
    }

    void animateViewIn() {
        this.view.post(new Runnable() {
            public void run() {
                if(BaseTransientBottomBar.this.view == null) {
                    return;
                }

                if(BaseTransientBottomBar.this.view.getParent() != null) {
                    BaseTransientBottomBar.this.view.setVisibility(0);
                }

                int v0 = BaseTransientBottomBar.this.view.getAnimationMode();
                BaseTransientBottomBar v2 = BaseTransientBottomBar.this;
                if(v0 == 1) {
                    v2.startFadeInAnimation();
                    return;
                }

                v2.startSlideInAnimation();
            }
        });
    }

    private void animateViewOut(int arg3) {
        if(this.view.getAnimationMode() == 1) {
            this.startFadeOutAnimation(arg3);
            return;
        }

        this.startSlideOutAnimation(arg3);
    }

    private int calculateBottomMarginForAnchorView() {
        if(this.getAnchorView() == null) {
            return 0;
        }

        int[] v1 = new int[2];
        this.getAnchorView().getLocationOnScreen(v1);
        int v1_1 = v1[1];
        int[] v0 = new int[2];
        this.targetParent.getLocationOnScreen(v0);
        return v0[1] + this.targetParent.getHeight() - v1_1;
    }

    private static GradientDrawable createGradientDrawableBackground(int arg2, Resources arg3) {
        float v3 = arg3.getDimension(dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable v0 = new GradientDrawable();
        v0.setShape(0);
        v0.setCornerRadius(v3);
        v0.setColor(arg2);
        return v0;
    }

    private static MaterialShapeDrawable createMaterialShapeDrawableBackground(int arg1, ShapeAppearanceModel arg2) {
        MaterialShapeDrawable v0 = new MaterialShapeDrawable(arg2);
        v0.setFillColor(ColorStateList.valueOf(arg1));
        return v0;
    }

    public void dismiss() {
        this.dispatchDismiss(3);
    }

    protected void dispatchDismiss(int arg2) {
        SnackbarManager.getInstance().dismiss(this.managerCallback, arg2);
    }

    private ValueAnimator getAlphaAnimator(float[] arg2) {
        ValueAnimator v2 = ValueAnimator.ofFloat(arg2);
        v2.setInterpolator(this.animationFadeInterpolator);
        v2.addUpdateListener(new ValueAnimator$AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator arg1) {
                BaseTransientBottomBar.this.view.setAlpha(arg1.getAnimatedValue().floatValue());
            }
        });
        return v2;
    }

    public View getAnchorView() {
        Anchor v0 = this.anchor;
        if(v0 == null) {
            return null;
        }

        return v0.getAnchorView();
    }

    public int getAnimationMode() {
        return this.view.getAnimationMode();
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    public Context getContext() {
        return this.context;
    }

    public int getDuration() {
        return this.duration;
    }

    protected SwipeDismissBehavior getNewBehavior() {
        return new Behavior();
    }

    private ValueAnimator getScaleAnimator(float[] arg2) {
        ValueAnimator v2 = ValueAnimator.ofFloat(arg2);
        v2.setInterpolator(this.animationScaleInterpolator);
        v2.addUpdateListener(new ValueAnimator$AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator arg2) {
                float v2 = arg2.getAnimatedValue().floatValue();
                BaseTransientBottomBar.this.view.setScaleX(v2);
                BaseTransientBottomBar.this.view.setScaleY(v2);
            }
        });
        return v2;
    }

    protected int getSnackbarBaseLayoutResId() {
        if(this.hasSnackbarStyleAttr()) {
            return layout.mtrl_layout_snackbar;
        }

        return layout.design_layout_snackbar;
    }

    private int getTranslationYBottom() {
        int v0 = this.view.getHeight();
        ViewGroup$LayoutParams v2 = this.view.getLayoutParams();
        if((v2 instanceof ViewGroup$MarginLayoutParams)) {
            v0 += ((ViewGroup$MarginLayoutParams)v2).bottomMargin;
        }

        return v0;
    }

    public View getView() {
        return this.view;
    }

    private int getViewAbsoluteBottom() {
        int[] v0 = new int[2];
        this.view.getLocationInWindow(v0);
        return v0[1] + this.view.getHeight();
    }

    protected boolean hasSnackbarStyleAttr() {
        TypedArray v3 = this.context.obtainStyledAttributes(BaseTransientBottomBar.SNACKBAR_STYLE_ATTR);
        int v2 = v3.getResourceId(0, -1);
        v3.recycle();
        if(v2 != -1) {
            return 1;
        }

        return 0;
    }

    final void hideView(int arg2) {
        if((this.shouldAnimate()) && this.view.getVisibility() == 0) {
            this.animateViewOut(arg2);
            return;
        }

        this.onViewHidden(arg2);
    }

    public boolean isAnchorViewLayoutListenerEnabled() {
        return this.anchorViewLayoutListenerEnabled;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isShown() {
        return SnackbarManager.getInstance().isCurrent(this.managerCallback);
    }

    public boolean isShownOrQueued() {
        return SnackbarManager.getInstance().isCurrentOrNext(this.managerCallback);
    }

    private boolean isSwipeDismissable() {
        ViewGroup$LayoutParams v1 = this.view.getLayoutParams();
        if(((v1 instanceof LayoutParams)) && ((((LayoutParams)v1).getBehavior() instanceof SwipeDismissBehavior))) {
            return 1;
        }

        return 0;
    }

    void onAttachedToWindow() {
        if(Build$VERSION.SDK_INT >= 29) {
            WindowInsets v0 = this.view.getRootWindowInsets();
            if(v0 != null) {
                this.extraBottomMarginGestureInset = v0.getMandatorySystemGestureInsets().bottom;
                this.updateMargins();
            }
        }
    }

    void onDetachedFromWindow() {
        if(this.isShownOrQueued()) {
            BaseTransientBottomBar.handler.post(new Runnable() {
                public void run() {
                    BaseTransientBottomBar.this.onViewHidden(3);
                }
            });
        }
    }

    void onLayoutChange() {
        if(this.pendingShowingView) {
            this.showViewImpl();
            this.pendingShowingView = false;
        }
    }

    void onViewHidden(int arg3) {
        SnackbarManager.getInstance().onDismissed(this.managerCallback);
        List v0 = this.callbacks;
        if(v0 != null) {
            int v0_1;
            for(v0_1 = v0.size() - 1; v0_1 >= 0; --v0_1) {
                this.callbacks.get(v0_1).onDismissed(this, arg3);
            }
        }

        ViewParent v3 = this.view.getParent();
        if((v3 instanceof ViewGroup)) {
            ((ViewGroup)v3).removeView(this.view);
        }
    }

    void onViewShown() {
        SnackbarManager.getInstance().onShown(this.managerCallback);
        List v0 = this.callbacks;
        if(v0 != null) {
            int v0_1;
            for(v0_1 = v0.size() - 1; v0_1 >= 0; --v0_1) {
                this.callbacks.get(v0_1).onShown(this);
            }
        }
    }

    private void recalculateAndUpdateMargins() {
        this.extraBottomMarginAnchorView = this.calculateBottomMarginForAnchorView();
        this.updateMargins();
    }

    public BaseTransientBottomBar removeCallback(BaseCallback arg2) {
        List v0;
        if(arg2 == null) {
        }
        else {
            v0 = this.callbacks;
            if(v0 == null) {
                return this;
            }

            goto label_5;
        }

        return this;
    label_5:
        v0.remove(arg2);
        return this;
    }

    public BaseTransientBottomBar setAnchorView(int arg3) {
        View v0 = this.targetParent.findViewById(arg3);
        if(v0 != null) {
            return this.setAnchorView(v0);
        }

        throw new IllegalArgumentException("Unable to find anchor view with id: " + arg3);
    }

    public BaseTransientBottomBar setAnchorView(View arg2) {
        Anchor v0 = this.anchor;
        if(v0 != null) {
            v0.unanchor();
        }

        Anchor v2 = arg2 == null ? null : Anchor.anchor(this, arg2);
        this.anchor = v2;
        return this;
    }

    public void setAnchorViewLayoutListenerEnabled(boolean arg1) {
        this.anchorViewLayoutListenerEnabled = arg1;
    }

    public BaseTransientBottomBar setAnimationMode(int arg2) {
        this.view.setAnimationMode(arg2);
        return this;
    }

    public BaseTransientBottomBar setBehavior(Behavior arg1) {
        this.behavior = arg1;
        return this;
    }

    public BaseTransientBottomBar setDuration(int arg1) {
        this.duration = arg1;
        return this;
    }

    public BaseTransientBottomBar setGestureInsetBottomIgnored(boolean arg1) {
        this.gestureInsetBottomIgnored = arg1;
        return this;
    }

    private void setUpBehavior(LayoutParams arg3) {
        SwipeDismissBehavior v0_1;
        Behavior v0 = this.behavior;
        if(v0 == null) {
            v0_1 = this.getNewBehavior();
        }

        if(((((Behavior)v0_1)) instanceof Behavior)) {
            Behavior.access$1100(((Behavior)v0_1), this);
        }

        v0_1.setListener(new OnDismissListener() {
            public void onDismiss(View arg2) {
                if(arg2.getParent() != null) {
                    arg2.setVisibility(8);
                }

                BaseTransientBottomBar.this.dispatchDismiss(0);
            }

            public void onDragStateChanged(int arg2) {
                if(arg2 != 0) {
                    if(arg2 != 1 && arg2 != 2) {
                        return;
                    }

                    SnackbarManager.getInstance().pauseTimeout(BaseTransientBottomBar.this.managerCallback);
                    return;
                }

                SnackbarManager.getInstance().restoreTimeoutIfPaused(BaseTransientBottomBar.this.managerCallback);
            }
        });
        arg3.setBehavior(((androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior)v0_1));
        if(this.getAnchorView() == null) {
            arg3.insetEdge = 80;
        }
    }

    boolean shouldAnimate() {
        AccessibilityManager v1 = this.accessibilityManager;
        if(v1 == null) {
            return 1;
        }

        List v1_1 = v1.getEnabledAccessibilityServiceList(1);
        if(v1_1 != null && (v1_1.isEmpty())) {
            return 1;
        }

        return 0;
    }

    private boolean shouldUpdateGestureInset() {
        if(this.extraBottomMarginGestureInset > 0 && !this.gestureInsetBottomIgnored && (this.isSwipeDismissable())) {
            return 1;
        }

        return 0;
    }

    public void show() {
        SnackbarManager.getInstance().show(this.getDuration(), this.managerCallback);
    }

    final void showView() {
        if(this.view.getParent() == null) {
            ViewGroup$LayoutParams v0 = this.view.getLayoutParams();
            if((v0 instanceof LayoutParams)) {
                this.setUpBehavior(((LayoutParams)v0));
            }

            this.view.addToTargetParent(this.targetParent);
            this.recalculateAndUpdateMargins();
            this.view.setVisibility(4);
        }

        if(ViewCompat.isLaidOut(this.view)) {
            this.showViewImpl();
            return;
        }

        this.pendingShowingView = true;
    }

    private void showViewImpl() {
        if(this.shouldAnimate()) {
            this.animateViewIn();
            return;
        }

        if(this.view.getParent() != null) {
            this.view.setVisibility(0);
        }

        this.onViewShown();
    }

    private void startFadeInAnimation() {
        ValueAnimator v1 = this.getAlphaAnimator(new float[]{0f, 1f});
        ValueAnimator v2 = this.getScaleAnimator(new float[]{0.8f, 1f});
        AnimatorSet v3 = new AnimatorSet();
        v3.playTogether(new Animator[]{v1, v2});
        v3.setDuration(((long)this.animationFadeInDuration));
        v3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                BaseTransientBottomBar.this.onViewShown();
            }
        });
        v3.start();
    }

    private void startFadeOutAnimation(int arg4) {
        ValueAnimator v0 = this.getAlphaAnimator(new float[]{1f, 0f});
        v0.setDuration(((long)this.animationFadeOutDuration));
        v0.addListener(new AnimatorListenerAdapter(arg4) {
            public void onAnimationEnd(Animator arg1) {
                BaseTransientBottomBar.this.onViewHidden(this.val$event);
            }
        });
        v0.start();
    }

    private void startSlideInAnimation() {
        int v0 = this.getTranslationYBottom();
        boolean v1 = BaseTransientBottomBar.USE_OFFSET_API;
        SnackbarBaseLayout v2 = this.view;
        if(v1) {
            ViewCompat.offsetTopAndBottom(((View)v2), v0);
        }
        else {
            v2.setTranslationY(((float)v0));
        }

        ValueAnimator v1_1 = new ValueAnimator();
        v1_1.setIntValues(new int[]{v0, 0});
        v1_1.setInterpolator(this.animationSlideInterpolator);
        v1_1.setDuration(((long)this.animationSlideDuration));
        v1_1.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                BaseTransientBottomBar.this.onViewShown();
            }

            public void onAnimationStart(Animator arg3) {
                BaseTransientBottomBar.this.contentViewCallback.animateContentIn(BaseTransientBottomBar.this.animationSlideDuration - BaseTransientBottomBar.this.animationFadeInDuration, BaseTransientBottomBar.this.animationFadeInDuration);
            }
        });
        v1_1.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(v0) {
            private int previousAnimatedIntValue;

            public void onAnimationUpdate(ValueAnimator arg3) {
                int v3 = arg3.getAnimatedValue().intValue();
                boolean v0 = BaseTransientBottomBar.USE_OFFSET_API;
                BaseTransientBottomBar v1 = BaseTransientBottomBar.this;
                if(v0) {
                    ViewCompat.offsetTopAndBottom(v1.view, v3 - this.previousAnimatedIntValue);
                }
                else {
                    v1.view.setTranslationY(((float)v3));
                }

                this.previousAnimatedIntValue = v3;
            }
        });
        v1_1.start();
    }

    private void startSlideOutAnimation(int arg4) {
        ValueAnimator v0 = new ValueAnimator();
        v0.setIntValues(new int[]{0, this.getTranslationYBottom()});
        v0.setInterpolator(this.animationSlideInterpolator);
        v0.setDuration(((long)this.animationSlideDuration));
        v0.addListener(new AnimatorListenerAdapter(arg4) {
            public void onAnimationEnd(Animator arg1) {
                BaseTransientBottomBar.this.onViewHidden(this.val$event);
            }

            public void onAnimationStart(Animator arg2) {
                BaseTransientBottomBar.this.contentViewCallback.animateContentOut(0, BaseTransientBottomBar.this.animationFadeOutDuration);
            }
        });
        v0.addUpdateListener(new ValueAnimator$AnimatorUpdateListener() {
            private int previousAnimatedIntValue;

            public void onAnimationUpdate(ValueAnimator arg3) {
                int v3 = arg3.getAnimatedValue().intValue();
                boolean v0 = BaseTransientBottomBar.USE_OFFSET_API;
                BaseTransientBottomBar v1 = BaseTransientBottomBar.this;
                if(v0) {
                    ViewCompat.offsetTopAndBottom(v1.view, v3 - this.previousAnimatedIntValue);
                }
                else {
                    v1.view.setTranslationY(((float)v3));
                }

                this.previousAnimatedIntValue = v3;
            }
        });
        v0.start();
    }

    private void updateMargins() {
        ViewGroup$LayoutParams v0 = this.view.getLayoutParams();
        if(!(v0 instanceof ViewGroup$MarginLayoutParams)) {
            Log.w(BaseTransientBottomBar.TAG, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }

        if(SnackbarBaseLayout.access$1000(this.view) == null) {
            Log.w(BaseTransientBottomBar.TAG, "Unable to update margins because original view margins are not set");
            return;
        }

        if(this.view.getParent() == null) {
        }
        else {
            int v1 = this.getAnchorView() != null ? this.extraBottomMarginAnchorView : this.extraBottomMarginWindowInset;
            int v2 = SnackbarBaseLayout.access$1000(this.view).bottom + v1;
            v1 = SnackbarBaseLayout.access$1000(this.view).left + this.extraLeftMarginWindowInset;
            int v3 = SnackbarBaseLayout.access$1000(this.view).right + this.extraRightMarginWindowInset;
            int v4 = SnackbarBaseLayout.access$1000(this.view).top;
            int v5 = ((ViewGroup$MarginLayoutParams)v0).bottomMargin != v2 || ((ViewGroup$MarginLayoutParams)v0).leftMargin != v1 || ((ViewGroup$MarginLayoutParams)v0).rightMargin != v3 || ((ViewGroup$MarginLayoutParams)v0).topMargin != v4 ? 1 : 0;
            if(v5 != 0) {
                ((ViewGroup$MarginLayoutParams)v0).bottomMargin = v2;
                ((ViewGroup$MarginLayoutParams)v0).leftMargin = v1;
                ((ViewGroup$MarginLayoutParams)v0).rightMargin = v3;
                ((ViewGroup$MarginLayoutParams)v0).topMargin = v4;
                this.view.requestLayout();
            }

            if(v5 == 0 && this.appliedBottomMarginGestureInset == this.extraBottomMarginGestureInset) {
                return;
            }

            if(Build$VERSION.SDK_INT < 29) {
                return;
            }

            if(!this.shouldUpdateGestureInset()) {
                return;
            }

            this.view.removeCallbacks(this.bottomMarginGestureInsetRunnable);
            this.view.post(this.bottomMarginGestureInsetRunnable);
        }
    }
}

