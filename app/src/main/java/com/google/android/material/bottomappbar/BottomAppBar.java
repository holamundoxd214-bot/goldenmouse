package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint$Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View$OnLayoutChangeListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior$OnScrollStateChangedListener;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar extends Toolbar implements AttachedBehavior {
    class com.google.android.material.bottomappbar.BottomAppBar$1 extends AnimatorListenerAdapter {
        com.google.android.material.bottomappbar.BottomAppBar$1(BottomAppBar arg1) {
            BottomAppBar.this = arg1;
            super();
        }

        public void onAnimationStart(Animator arg2) {
            if(!BottomAppBar.this.menuAnimatingWithFabAlignmentMode) {
                BottomAppBar.this.maybeAnimateMenuView(BottomAppBar.this.fabAlignmentMode, BottomAppBar.this.fabAttached);
            }
        }
    }

    class com.google.android.material.bottomappbar.BottomAppBar$2 implements TransformationCallback {
        com.google.android.material.bottomappbar.BottomAppBar$2(BottomAppBar arg1) {
            BottomAppBar.this = arg1;
            super();
        }

        public void onScaleChanged(View arg1) {
            this.onScaleChanged(((FloatingActionButton)arg1));
        }

        public void onScaleChanged(FloatingActionButton arg3) {
            MaterialShapeDrawable v0 = BottomAppBar.this.materialShapeDrawable;
            float v2 = arg3.getVisibility() != 0 || BottomAppBar.this.fabAnchorMode != 1 ? 0f : arg3.getScaleY();
            v0.setInterpolation(v2);
        }

        public void onTranslationChanged(View arg1) {
            this.onTranslationChanged(((FloatingActionButton)arg1));
        }

        public void onTranslationChanged(FloatingActionButton arg4) {
            if(BottomAppBar.this.fabAnchorMode != 1) {
                return;
            }

            float v0 = arg4.getTranslationX();
            if(BottomAppBar.this.getTopEdgeTreatment().getHorizontalOffset() != v0) {
                BottomAppBar.this.getTopEdgeTreatment().setHorizontalOffset(v0);
                BottomAppBar.this.materialShapeDrawable.invalidateSelf();
            }

            float v1 = 0f;
            v0 = Math.max(0f, -arg4.getTranslationY());
            if(BottomAppBar.this.getTopEdgeTreatment().getCradleVerticalOffset() != v0) {
                BottomAppBar.this.getTopEdgeTreatment().setCradleVerticalOffset(v0);
                BottomAppBar.this.materialShapeDrawable.invalidateSelf();
            }

            MaterialShapeDrawable v3 = BottomAppBar.this.materialShapeDrawable;
            if(arg4.getVisibility() == 0) {
                v1 = arg4.getScaleY();
            }

            v3.setInterpolation(v1);
        }
    }

    interface AnimationListener {
        void onAnimationEnd(BottomAppBar arg1);

        void onAnimationStart(BottomAppBar arg1);
    }

    public class Behavior extends HideBottomViewOnScrollBehavior {
        class com.google.android.material.bottomappbar.BottomAppBar$Behavior$1 implements View$OnLayoutChangeListener {
            com.google.android.material.bottomappbar.BottomAppBar$Behavior$1(Behavior arg1) {
                Behavior.this = arg1;
                super();
            }

            public void onLayoutChange(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
                Object v2 = Behavior.this.viewRef.get();
                if(v2 != null) {
                    boolean v3 = arg1 instanceof FloatingActionButton;
                    if(!v3 && !(arg1 instanceof ExtendedFloatingActionButton)) {
                        goto label_61;
                    }

                    arg4 = arg1.getHeight();
                    if(v3) {
                        arg1.getMeasuredContentRect(Behavior.this.fabContentRect);
                        arg4 = Behavior.this.fabContentRect.height();
                        ((BottomAppBar)v2).setFabDiameter(arg4);
                        ((BottomAppBar)v2).setFabCornerSize(arg1.getShapeAppearanceModel().getTopLeftCornerSize().getCornerSize(new RectF(Behavior.this.fabContentRect)));
                    }

                    ViewGroup$LayoutParams v3_1 = arg1.getLayoutParams();
                    if(Behavior.this.originalBottomMargin == 0) {
                        if(((BottomAppBar)v2).fabAnchorMode == 1) {
                            ((LayoutParams)v3_1).bottomMargin = ((BottomAppBar)v2).getBottomInset() + (((BottomAppBar)v2).getResources().getDimensionPixelOffset(dimen.mtrl_bottomappbar_fab_bottom_margin) - (arg1.getMeasuredHeight() - arg4) / 2);
                        }

                        ((LayoutParams)v3_1).leftMargin = ((BottomAppBar)v2).getLeftInset();
                        ((LayoutParams)v3_1).rightMargin = ((BottomAppBar)v2).getRightInset();
                        if(ViewUtils.isLayoutRtl(arg1)) {
                            ((LayoutParams)v3_1).leftMargin += ((BottomAppBar)v2).fabOffsetEndMode;
                            goto label_59;
                        }

                        ((LayoutParams)v3_1).rightMargin += ((BottomAppBar)v2).fabOffsetEndMode;
                    }

                label_59:
                    ((BottomAppBar)v2).setCutoutStateAndTranslateFab();
                    return;
                }

            label_61:
                arg1.removeOnLayoutChangeListener(((View$OnLayoutChangeListener)this));
            }
        }

        private final Rect fabContentRect;
        private final View$OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference viewRef;

        public Behavior() {
            super();
            this.fabLayoutListener = new com.google.android.material.bottomappbar.BottomAppBar$Behavior$1(this);
            this.fabContentRect = new Rect();
        }

        public Behavior(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
            this.fabLayoutListener = new com.google.android.material.bottomappbar.BottomAppBar$Behavior$1(this);
            this.fabContentRect = new Rect();
        }

        static WeakReference access$2500(Behavior arg0) {
            return arg0.viewRef;
        }

        static Rect access$2600(Behavior arg0) {
            return arg0.fabContentRect;
        }

        static int access$2700(Behavior arg0) {
            return arg0.originalBottomMargin;
        }

        public boolean onLayoutChild(CoordinatorLayout arg1, View arg2, int arg3) {
            return this.onLayoutChild(arg1, ((BottomAppBar)arg2), arg3);
        }

        public boolean onLayoutChild(CoordinatorLayout arg4, BottomAppBar arg5, int arg6) {
            this.viewRef = new WeakReference(arg5);
            View v0 = arg5.findDependentView();
            if(v0 != null && !ViewCompat.isLaidOut(v0)) {
                BottomAppBar.updateFabAnchorGravity(arg5, v0);
                this.originalBottomMargin = v0.getLayoutParams().bottomMargin;
                if((v0 instanceof FloatingActionButton)) {
                    View v1 = v0;
                    if(arg5.fabAnchorMode == 0 && (arg5.removeEmbeddedFabElevation)) {
                        ViewCompat.setElevation(v1, 0f);
                        ((FloatingActionButton)v1).setCompatElevation(0f);
                    }

                    if(((FloatingActionButton)v1).getShowMotionSpec() == null) {
                        ((FloatingActionButton)v1).setShowMotionSpecResource(animator.mtrl_fab_show_motion_spec);
                    }

                    if(((FloatingActionButton)v1).getHideMotionSpec() == null) {
                        ((FloatingActionButton)v1).setHideMotionSpecResource(animator.mtrl_fab_hide_motion_spec);
                    }

                    arg5.addFabAnimationListeners(((FloatingActionButton)v1));
                }

                v0.addOnLayoutChangeListener(this.fabLayoutListener);
                arg5.setCutoutStateAndTranslateFab();
            }

            arg4.onLayoutChild(((View)arg5), arg6);
            return super.onLayoutChild(arg4, ((View)arg5), arg6);
        }

        public boolean onStartNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, View arg4, int arg5, int arg6) {
            return this.onStartNestedScroll(arg1, ((BottomAppBar)arg2), arg3, arg4, arg5, arg6);
        }

        public boolean onStartNestedScroll(CoordinatorLayout arg2, BottomAppBar arg3, View arg4, View arg5, int arg6, int arg7) {
            if((arg3.getHideOnScroll()) && (super.onStartNestedScroll(arg2, ((View)arg3), arg4, arg5, arg6, arg7))) {
                return 1;
            }

            return 0;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface FabAlignmentMode {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface FabAnchorMode {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface FabAnimationMode {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface MenuAlignmentMode {
    }

    class SavedState extends AbsSavedState {
        class com.google.android.material.bottomappbar.BottomAppBar$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.bottomappbar.BottomAppBar$SavedState$1() {
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
        int fabAlignmentMode;
        boolean fabAttached;

        static {
            SavedState.CREATOR = new com.google.android.material.bottomappbar.BottomAppBar$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.fabAlignmentMode = arg1.readInt();
            boolean v1 = arg1.readInt() != 0 ? true : false;
            this.fabAttached = v1;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeInt(this.fabAlignmentMode);
            arg1.writeInt(this.fabAttached);
        }
    }

    private static final int DEF_STYLE_RES = 0;
    private static final int FAB_ALIGNMENT_ANIM_DURATION_ATTR = 0;
    private static final int FAB_ALIGNMENT_ANIM_DURATION_DEFAULT = 300;
    private static final int FAB_ALIGNMENT_ANIM_EASING_ATTR = 0;
    private static final float FAB_ALIGNMENT_ANIM_EASING_MIDPOINT = 0.2f;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANCHOR_MODE_CRADLE = 1;
    public static final int FAB_ANCHOR_MODE_EMBED = 0;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    public static final int MENU_ALIGNMENT_MODE_AUTO = 0;
    public static final int MENU_ALIGNMENT_MODE_START = 1;
    private static final int NO_FAB_END_MARGIN = -1;
    private static final int NO_MENU_RES_ID;
    private int animatingModeChangeCounter;
    private ArrayList animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;
    private int fabAlignmentModeEndMargin;
    private int fabAnchorMode;
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;
    TransformationCallback fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;
    private int menuAlignmentMode;
    private boolean menuAnimatingWithFabAlignmentMode;
    private Animator menuAnimator;
    private Animator modeAnimator;
    private Integer navigationIconTint;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;
    private int pendingMenuResId;
    private final boolean removeEmbeddedFabElevation;
    private int rightInset;

    static {
        BottomAppBar.DEF_STYLE_RES = style.Widget_MaterialComponents_BottomAppBar;
        BottomAppBar.FAB_ALIGNMENT_ANIM_DURATION_ATTR = attr.motionDurationLong2;
        BottomAppBar.FAB_ALIGNMENT_ANIM_EASING_ATTR = attr.motionEasingEmphasizedInterpolator;
    }

    public BottomAppBar(Context arg2) {
        this(arg2, null);
    }

    public BottomAppBar(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.bottomAppBarStyle);
    }

    public BottomAppBar(Context arg13, AttributeSet arg14, int arg15) {
        int v4 = BottomAppBar.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg13, arg14, arg15, v4), arg14, arg15);
        MaterialShapeDrawable v13 = new MaterialShapeDrawable();
        this.materialShapeDrawable = v13;
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new com.google.android.material.bottomappbar.BottomAppBar$1(this);
        this.fabTransformationCallback = new com.google.android.material.bottomappbar.BottomAppBar$2(this);
        Context v0 = this.getContext();
        AttributeSet v1 = arg14;
        int v3 = arg15;
        TypedArray v14 = ThemeEnforcement.obtainStyledAttributes(v0, v1, styleable.BottomAppBar, v3, v4, new int[0]);
        ColorStateList v15 = MaterialResources.getColorStateList(v0, v14, styleable.BottomAppBar_backgroundTint);
        int v5 = -1;
        if(v14.hasValue(styleable.BottomAppBar_navigationIconTint)) {
            this.setNavigationIconTint(v14.getColor(styleable.BottomAppBar_navigationIconTint, v5));
        }

        int v2 = v14.getDimensionPixelSize(styleable.BottomAppBar_elevation, 0);
        float v8 = ((float)v14.getDimensionPixelOffset(styleable.BottomAppBar_fabCradleMargin, 0));
        float v9 = ((float)v14.getDimensionPixelOffset(styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0));
        float v10 = ((float)v14.getDimensionPixelOffset(styleable.BottomAppBar_fabCradleVerticalOffset, 0));
        this.fabAlignmentMode = v14.getInt(styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = v14.getInt(styleable.BottomAppBar_fabAnimationMode, 0);
        this.fabAnchorMode = v14.getInt(styleable.BottomAppBar_fabAnchorMode, 1);
        this.removeEmbeddedFabElevation = v14.getBoolean(styleable.BottomAppBar_removeEmbeddedFabElevation, true);
        this.menuAlignmentMode = v14.getInt(styleable.BottomAppBar_menuAlignmentMode, 0);
        this.hideOnScroll = v14.getBoolean(styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = v14.getBoolean(styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = v14.getBoolean(styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = v14.getBoolean(styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        this.fabAlignmentModeEndMargin = v14.getDimensionPixelOffset(styleable.BottomAppBar_fabAlignmentModeEndMargin, v5);
        boolean v5_1 = v14.getBoolean(styleable.BottomAppBar_addElevationShadow, true);
        v14.recycle();
        this.fabOffsetEndMode = this.getResources().getDimensionPixelOffset(dimen.mtrl_bottomappbar_fabOffsetEndMode);
        v13.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(v8, v9, v10)).build());
        if(v5_1) {
            v13.setShadowCompatibilityMode(2);
        }
        else {
            v13.setShadowCompatibilityMode(1);
            if(Build$VERSION.SDK_INT >= 28) {
                this.setOutlineAmbientShadowColor(0);
                this.setOutlineSpotShadowColor(0);
            }
        }

        v13.setPaintStyle(Paint$Style.FILL);
        v13.initializeElevationOverlay(v0);
        this.setElevation(((float)v2));
        DrawableCompat.setTintList(((Drawable)v13), v15);
        ViewCompat.setBackground(((View)this), ((Drawable)v13));
        ViewUtils.doOnApplyWindowInsets(((View)this), v1, v3, v4, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View arg4, WindowInsetsCompat arg5, RelativePadding arg6) {
                int v4;
                if(BottomAppBar.access$700(BottomAppBar.this)) {
                    BottomAppBar.access$802(BottomAppBar.this, arg5.getSystemWindowInsetBottom());
                }

                int v6 = 1;
                int v0 = 0;
                if(BottomAppBar.access$900(BottomAppBar.this)) {
                    v4 = BottomAppBar.access$1000(BottomAppBar.this) != arg5.getSystemWindowInsetLeft() ? 1 : 0;
                    BottomAppBar.access$1002(BottomAppBar.this, arg5.getSystemWindowInsetLeft());
                }
                else {
                    v4 = 0;
                }

                if(BottomAppBar.access$1100(BottomAppBar.this)) {
                    if(BottomAppBar.access$1200(BottomAppBar.this) != arg5.getSystemWindowInsetRight()) {
                    }
                    else {
                        v6 = 0;
                    }

                    BottomAppBar.access$1202(BottomAppBar.this, arg5.getSystemWindowInsetRight());
                    v0 = v6;
                }

                if(v4 == 0) {
                    if(v0 != 0) {
                    }
                    else {
                        return arg5;
                    }
                }

                BottomAppBar.access$1300(BottomAppBar.this);
                BottomAppBar.access$1400(BottomAppBar.this);
                BottomAppBar.access$1500(BottomAppBar.this);
                return arg5;
            }
        });
    }

    static boolean access$000(BottomAppBar arg0) {
        return arg0.menuAnimatingWithFabAlignmentMode;
    }

    static boolean access$002(BottomAppBar arg0, boolean arg1) {
        arg0.menuAnimatingWithFabAlignmentMode = arg1;
        return arg1;
    }

    static int access$100(BottomAppBar arg0) {
        return arg0.fabAlignmentMode;
    }

    static int access$1000(BottomAppBar arg0) {
        return arg0.leftInset;
    }

    static int access$1002(BottomAppBar arg0, int arg1) {
        arg0.leftInset = arg1;
        return arg1;
    }

    static boolean access$1100(BottomAppBar arg0) {
        return arg0.paddingRightSystemWindowInsets;
    }

    static int access$1200(BottomAppBar arg0) {
        return arg0.rightInset;
    }

    static int access$1202(BottomAppBar arg0, int arg1) {
        arg0.rightInset = arg1;
        return arg1;
    }

    static void access$1300(BottomAppBar arg0) {
        arg0.cancelAnimations();
    }

    static void access$1400(BottomAppBar arg0) {
        arg0.setCutoutStateAndTranslateFab();
    }

    static void access$1500(BottomAppBar arg0) {
        arg0.setActionMenuViewPosition();
    }

    static void access$1600(BottomAppBar arg0) {
        arg0.dispatchAnimationStart();
    }

    static void access$1700(BottomAppBar arg0) {
        arg0.dispatchAnimationEnd();
    }

    static Animator access$1802(BottomAppBar arg0, Animator arg1) {
        arg0.modeAnimator = arg1;
        return arg1;
    }

    static float access$1900(BottomAppBar arg0, int arg1) {
        return arg0.getFabTranslationX(arg1);
    }

    static boolean access$200(BottomAppBar arg0) {
        return arg0.fabAttached;
    }

    static Animator access$2002(BottomAppBar arg0, Animator arg1) {
        arg0.menuAnimator = arg1;
        return arg1;
    }

    static int access$2100(BottomAppBar arg0) {
        return arg0.pendingMenuResId;
    }

    static void access$2200(BottomAppBar arg0, ActionMenuView arg1, int arg2, boolean arg3, boolean arg4) {
        arg0.translateActionMenuView(arg1, arg2, arg3, arg4);
    }

    static FloatingActionButton access$2300(BottomAppBar arg0) {
        return arg0.findDependentFab();
    }

    static float access$2400(BottomAppBar arg0) {
        return arg0.getFabTranslationX();
    }

    static int access$2800(BottomAppBar arg0) {
        return arg0.getBottomInset();
    }

    static int access$2900(BottomAppBar arg0) {
        return arg0.getLeftInset();
    }

    static void access$300(BottomAppBar arg0, int arg1, boolean arg2) {
        arg0.maybeAnimateMenuView(arg1, arg2);
    }

    static int access$3000(BottomAppBar arg0) {
        return arg0.getRightInset();
    }

    static int access$3100(BottomAppBar arg0) {
        return arg0.fabOffsetEndMode;
    }

    static View access$3200(BottomAppBar arg0) {
        return arg0.findDependentView();
    }

    static void access$3300(BottomAppBar arg0, View arg1) {
        BottomAppBar.updateFabAnchorGravity(arg0, arg1);
    }

    static boolean access$3400(BottomAppBar arg0) {
        return arg0.removeEmbeddedFabElevation;
    }

    static void access$3500(BottomAppBar arg0, FloatingActionButton arg1) {
        arg0.addFabAnimationListeners(arg1);
    }

    static int access$400(BottomAppBar arg0) {
        return arg0.fabAnchorMode;
    }

    static MaterialShapeDrawable access$500(BottomAppBar arg0) {
        return arg0.materialShapeDrawable;
    }

    static BottomAppBarTopEdgeTreatment access$600(BottomAppBar arg0) {
        return arg0.getTopEdgeTreatment();
    }

    static boolean access$700(BottomAppBar arg0) {
        return arg0.paddingBottomSystemWindowInsets;
    }

    static int access$802(BottomAppBar arg0, int arg1) {
        arg0.bottomInset = arg1;
        return arg1;
    }

    static boolean access$900(BottomAppBar arg0) {
        return arg0.paddingLeftSystemWindowInsets;
    }

    void addAnimationListener(AnimationListener arg2) {
        ArrayList v0 = this.animationListeners;
        if(v0 == null) {
            v0 = new ArrayList();
            this.animationListeners = v0;
        }

        v0.add(arg2);
    }

    private void addFabAnimationListeners(FloatingActionButton arg2) {
        arg2.addOnHideAnimationListener(this.fabAnimationListener);
        arg2.addOnShowAnimationListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator arg2) {
                BottomAppBar.this.fabAnimationListener.onAnimationStart(arg2);
                FloatingActionButton v2 = BottomAppBar.this.findDependentFab();
                if(v2 != null) {
                    v2.setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        arg2.addTransformationCallback(this.fabTransformationCallback);
    }

    public void addOnScrollStateChangedListener(OnScrollStateChangedListener arg1) {
        this.getBehavior().addOnScrollStateChangedListener(arg1);
    }

    private void cancelAnimations() {
        Animator v0 = this.menuAnimator;
        if(v0 != null) {
            v0.cancel();
        }

        Animator v1 = this.modeAnimator;
        if(v1 != null) {
            v1.cancel();
        }
    }

    public void clearOnScrollStateChangedListeners() {
        this.getBehavior().clearOnScrollStateChangedListeners();
    }

    protected void createFabDefaultXAnimation(int arg2, List arg3) {
        FloatingActionButton v3 = this.findDependentFab();
        if(v3 != null) {
            if(v3.isOrWillBeHidden()) {
            }
            else {
                this.dispatchAnimationStart();
                v3.hide(new OnVisibilityChangedListener(arg2) {
                    public void onHidden(FloatingActionButton arg3) {
                        arg3.setTranslationX(BottomAppBar.this.getFabTranslationX(this.val$targetMode));
                        arg3.show(new OnVisibilityChangedListener() {
                            public void onShown(FloatingActionButton arg1) {
                                this.this$1.this$0.dispatchAnimationEnd();
                            }
                        });
                    }
                });
            }
        }
    }

    private void createFabTranslationXAnimation(int arg4, List arg5) {
        ObjectAnimator v4 = ObjectAnimator.ofFloat(this.findDependentFab(), "translationX", new float[]{this.getFabTranslationX(arg4)});
        v4.setDuration(((long)this.getFabAlignmentAnimationDuration()));
        arg5.add(v4);
    }

    private void createMenuViewTranslationAnimation(int arg10, boolean arg11, List arg12) {
        ActionMenuView v0 = this.getActionMenuView();
        if(v0 == null) {
        }
        else {
            float v1 = ((float)this.getFabAlignmentAnimationDuration());
            float[] v3 = new float[1];
            float v5 = 1f;
            v3[0] = v5;
            String v6 = "alpha";
            ObjectAnimator v3_1 = ObjectAnimator.ofFloat(v0, v6, v3);
            ((Animator)v3_1).setDuration(((long)(0.8f * v1)));
            if(Math.abs(v0.getTranslationX() - (((float)this.getActionMenuViewTranslationX(v0, arg10, arg11)))) > v5) {
                ObjectAnimator v5_1 = ObjectAnimator.ofFloat(v0, v6, new float[]{0f});
                ((Animator)v5_1).setDuration(((long)(v1 * 0.2f)));
                ((Animator)v5_1).addListener(new AnimatorListenerAdapter(v0, arg10, arg11) {
                    public boolean cancelled;

                    public void onAnimationCancel(Animator arg1) {
                        this.cancelled = true;
                    }

                    public void onAnimationEnd(Animator arg4) {
                        if(!this.cancelled) {
                            boolean v4 = BottomAppBar.this.pendingMenuResId != 0 ? true : false;
                            BottomAppBar.this.replaceMenu(BottomAppBar.this.pendingMenuResId);
                            BottomAppBar.this.translateActionMenuView(this.val$actionMenuView, this.val$targetMode, this.val$targetAttached, v4);
                        }
                    }
                });
                AnimatorSet v9 = new AnimatorSet();
                v9.playSequentially(new Animator[]{v5_1, v3_1});
                arg12.add(v9);
                return;
            }
            else if(v0.getAlpha() < v5) {
                arg12.add(v3_1);
            }
        }
    }

    private void dispatchAnimationEnd() {
        int v0 = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = v0;
        if(v0 == 0) {
            ArrayList v0_1 = this.animationListeners;
            if(v0_1 != null) {
                Iterator v0_2 = v0_1.iterator();
                while(v0_2.hasNext()) {
                    v0_2.next().onAnimationEnd(this);
                }
            }
        }
    }

    private void dispatchAnimationStart() {
        int v0 = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = v0 + 1;
        if(v0 == 0) {
            ArrayList v0_1 = this.animationListeners;
            if(v0_1 != null) {
                Iterator v0_2 = v0_1.iterator();
                while(v0_2.hasNext()) {
                    v0_2.next().onAnimationStart(this);
                }
            }
        }
    }

    private FloatingActionButton findDependentFab() {
        View v1 = this.findDependentView();
        if((v1 instanceof FloatingActionButton)) {
            return ((FloatingActionButton)v1);
        }

        return null;
    }

    private View findDependentView() {
        Object v0;
        View v1 = null;
        if(!(this.getParent() instanceof CoordinatorLayout)) {
            return v1;
        }

        Iterator v3 = this.getParent().getDependents(((View)this)).iterator();
        do {
            if(!v3.hasNext()) {
                return v1;
            }

            v0 = v3.next();
            if((v0 instanceof FloatingActionButton)) {
                break;
            }
        }
        while(!(v0 instanceof ExtendedFloatingActionButton));

        return ((View)v0);
    }

    private ActionMenuView getActionMenuView() {
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            View v1 = this.getChildAt(v0);
            if((v1 instanceof ActionMenuView)) {
                return ((ActionMenuView)v1);
            }
        }

        return null;
    }

    protected int getActionMenuViewTranslationX(ActionMenuView arg6, int arg7, boolean arg8) {
        int v1 = 0;
        if(this.menuAlignmentMode != 1 && (arg7 != 1 || !arg8)) {
            return 0;
        }

        boolean v7 = ViewUtils.isLayoutRtl(((View)this));
        int v8 = v7 ? this.getMeasuredWidth() : 0;
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            View v2 = this.getChildAt(v0);
            if(((v2.getLayoutParams() instanceof androidx.appcompat.widget.Toolbar$LayoutParams)) && (v2.getLayoutParams().gravity & 0x800007) == 0x800003) {
                v8 = v7 ? Math.min(v8, v2.getLeft()) : Math.max(v8, v2.getRight());
            }
        }

        int v6 = v7 ? arg6.getRight() : arg6.getLeft();
        v0 = v7 ? this.rightInset : -this.leftInset;
        if(this.getNavigationIcon() == null) {
            int v5 = this.getResources().getDimensionPixelOffset(dimen.m3_bottomappbar_horizontal_padding);
            if(v7) {
            }
            else {
                v5 = -v5;
            }

            v1 = v5;
        }

        return v8 - (v6 + v0 + v1);
    }

    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    public Behavior getBehavior() {
        Behavior v0 = this.behavior;
        if(v0 == null) {
            v0 = new Behavior();
            this.behavior = v0;
        }

        return v0;
    }

    public androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior getBehavior() {
        return this.getBehavior();
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    public float getCradleVerticalOffset() {
        return this.getTopEdgeTreatment().getCradleVerticalOffset();
    }

    private int getFabAlignmentAnimationDuration() {
        return MotionUtils.resolveThemeDuration(this.getContext(), BottomAppBar.FAB_ALIGNMENT_ANIM_DURATION_ATTR, 300);
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.fabAlignmentModeEndMargin;
    }

    public int getFabAnchorMode() {
        return this.fabAnchorMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return this.getTopEdgeTreatment().getFabCradleMargin();
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    private float getFabTranslationX(int arg6) {
        boolean v0 = ViewUtils.isLayoutRtl(((View)this));
        int v1 = 1;
        if(arg6 == 1) {
            View v6 = this.findDependentView();
            int v2 = v0 ? this.leftInset : this.rightInset;
            int v4 = -1;
            arg6 = this.fabAlignmentModeEndMargin == v4 || v6 == null ? this.fabOffsetEndMode : v6.getMeasuredWidth() / 2 + this.fabAlignmentModeEndMargin;
            int v5 = this.getMeasuredWidth() / 2 - (v2 + arg6);
            if(v0) {
                v1 = v4;
            }

            return ((float)(v5 * v1));
        }

        return 0;
    }

    private float getFabTranslationX() {
        return this.getFabTranslationX(this.fabAlignmentMode);
    }

    private float getFabTranslationY() {
        if(this.fabAnchorMode == 1) {
            return -this.getTopEdgeTreatment().getCradleVerticalOffset();
        }

        View v0 = this.findDependentView();
        int v2 = v0 != null ? -(this.getMeasuredHeight() + this.getBottomInset() - v0.getMeasuredHeight()) / 2 : 0;
        return ((float)v2);
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    public int getMenuAlignmentMode() {
        return this.menuAlignmentMode;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton v0 = this.findDependentFab();
        if(v0 != null && (v0.isOrWillBeShown())) {
            return 1;
        }

        return 0;
    }

    public boolean isScrolledDown() {
        return this.getBehavior().isScrolledDown();
    }

    public boolean isScrolledUp() {
        return this.getBehavior().isScrolledUp();
    }

    static void lambda$onLayout$0(View arg0) {
        arg0.requestLayout();
    }

    private void maybeAnimateMenuView(int arg4, boolean arg5) {
        if(!ViewCompat.isLaidOut(((View)this))) {
            this.menuAnimatingWithFabAlignmentMode = false;
            this.replaceMenu(this.pendingMenuResId);
            return;
        }

        Animator v0 = this.menuAnimator;
        if(v0 != null) {
            v0.cancel();
        }

        ArrayList v0_1 = new ArrayList();
        this.createMenuViewTranslationAnimation(0, false, ((List)v0_1));
        AnimatorSet v4 = new AnimatorSet();
        v4.playTogether(((Collection)v0_1));
        this.menuAnimator = ((Animator)v4);
        ((Animator)v4).addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg2) {
                BottomAppBar.this.dispatchAnimationEnd();
                BottomAppBar.this.menuAnimatingWithFabAlignmentMode = false;
                BottomAppBar.this.menuAnimator = null;
            }

            public void onAnimationStart(Animator arg1) {
                BottomAppBar.this.dispatchAnimationStart();
            }
        });
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int arg4) {
        if(this.fabAlignmentMode != arg4) {
            if(!ViewCompat.isLaidOut(((View)this))) {
            }
            else {
                Animator v0 = this.modeAnimator;
                if(v0 != null) {
                    v0.cancel();
                }

                ArrayList v0_1 = new ArrayList();
                if(this.fabAnimationMode == 1) {
                    this.createFabTranslationXAnimation(arg4, ((List)v0_1));
                }
                else {
                    this.createFabDefaultXAnimation(arg4, ((List)v0_1));
                }

                AnimatorSet v4 = new AnimatorSet();
                v4.playTogether(((Collection)v0_1));
                v4.setInterpolator(MotionUtils.resolveThemeInterpolator(this.getContext(), BottomAppBar.FAB_ALIGNMENT_ANIM_EASING_ATTR, AnimationUtils.LINEAR_INTERPOLATOR));
                this.modeAnimator = ((Animator)v4);
                ((Animator)v4).addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator arg1) {
                        BottomAppBar.this.dispatchAnimationEnd();
                        BottomAppBar.this.modeAnimator = null;
                    }

                    public void onAnimationStart(Animator arg1) {
                        BottomAppBar.this.dispatchAnimationStart();
                    }
                });
                this.modeAnimator.start();
            }
        }
    }

    private Drawable maybeTintNavigationIcon(Drawable arg2) {
        if(arg2 != null && this.navigationIconTint != null) {
            arg2 = DrawableCompat.wrap(arg2.mutate());
            DrawableCompat.setTint(arg2, this.navigationIconTint.intValue());
        }

        return arg2;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this), this.materialShapeDrawable);
        if((this.getParent() instanceof ViewGroup)) {
            this.getParent().setClipChildren(false);
        }
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        if(arg1) {
            this.cancelAnimations();
            this.setCutoutStateAndTranslateFab();
            View v1 = this.findDependentView();
            if(v1 != null && (ViewCompat.isLaidOut(v1))) {
                v1.post(new BottomAppBar$$ExternalSyntheticLambda0(v1));
            }
        }

        this.setActionMenuViewPosition();
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.fabAlignmentMode = ((SavedState)arg2).fabAlignmentMode;
        this.fabAttached = ((SavedState)arg2).fabAttached;
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.fabAlignmentMode = this.fabAlignmentMode;
        v1.fabAttached = this.fabAttached;
        return ((Parcelable)v1);
    }

    public void performHide() {
        this.performHide(true);
    }

    public void performHide(boolean arg2) {
        this.getBehavior().slideDown(((View)this), arg2);
    }

    public void performShow() {
        this.performShow(true);
    }

    public void performShow(boolean arg2) {
        this.getBehavior().slideUp(((View)this), arg2);
    }

    void removeAnimationListener(AnimationListener arg1) {
        ArrayList v0 = this.animationListeners;
        if(v0 == null) {
            return;
        }

        v0.remove(arg1);
    }

    public void removeOnScrollStateChangedListener(OnScrollStateChangedListener arg1) {
        this.getBehavior().removeOnScrollStateChangedListener(arg1);
    }

    public void replaceMenu(int arg2) {
        if(arg2 != 0) {
            this.pendingMenuResId = 0;
            this.getMenu().clear();
            this.inflateMenu(arg2);
        }
    }

    private void setActionMenuViewPosition() {
        ActionMenuView v0 = this.getActionMenuView();
        if(v0 != null && this.menuAnimator == null) {
            v0.setAlpha(1f);
            if(!this.isFabVisibleOrWillBeShown()) {
                this.translateActionMenuView(v0, 0, false);
                return;
            }
            else {
                this.translateActionMenuView(v0, this.fabAlignmentMode, this.fabAttached);
            }
        }
    }

    public void setBackgroundTint(ColorStateList arg1) {
        DrawableCompat.setTintList(this.materialShapeDrawable, arg1);
    }

    public void setCradleVerticalOffset(float arg2) {
        if(arg2 != this.getCradleVerticalOffset()) {
            this.getTopEdgeTreatment().setCradleVerticalOffset(arg2);
            this.materialShapeDrawable.invalidateSelf();
            this.setCutoutStateAndTranslateFab();
        }
    }

    private void setCutoutStateAndTranslateFab() {
        this.getTopEdgeTreatment().setHorizontalOffset(this.getFabTranslationX());
        MaterialShapeDrawable v0 = this.materialShapeDrawable;
        float v1 = !this.fabAttached || !this.isFabVisibleOrWillBeShown() || this.fabAnchorMode != 1 ? 0f : 1f;
        v0.setInterpolation(v1);
        View v0_1 = this.findDependentView();
        if(v0_1 != null) {
            v0_1.setTranslationY(this.getFabTranslationY());
            v0_1.setTranslationX(this.getFabTranslationX());
        }
    }

    public void setElevation(float arg2) {
        this.materialShapeDrawable.setElevation(arg2);
        this.getBehavior().setAdditionalHiddenOffsetY(((View)this), this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY());
    }

    public void setFabAlignmentMode(int arg2) {
        this.setFabAlignmentModeAndReplaceMenu(arg2, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int arg1, int arg2) {
        this.pendingMenuResId = arg2;
        this.menuAnimatingWithFabAlignmentMode = true;
        this.maybeAnimateMenuView(arg1, this.fabAttached);
        this.maybeAnimateModeChange(arg1);
        this.fabAlignmentMode = arg1;
    }

    public void setFabAlignmentModeEndMargin(int arg2) {
        if(this.fabAlignmentModeEndMargin != arg2) {
            this.fabAlignmentModeEndMargin = arg2;
            this.setCutoutStateAndTranslateFab();
        }
    }

    public void setFabAnchorMode(int arg1) {
        this.fabAnchorMode = arg1;
        this.setCutoutStateAndTranslateFab();
        View v1 = this.findDependentView();
        if(v1 != null) {
            BottomAppBar.updateFabAnchorGravity(this, v1);
            v1.requestLayout();
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int arg1) {
        this.fabAnimationMode = arg1;
    }

    void setFabCornerSize(float arg2) {
        if(arg2 != this.getTopEdgeTreatment().getFabCornerRadius()) {
            this.getTopEdgeTreatment().setFabCornerSize(arg2);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float arg2) {
        if(arg2 != this.getFabCradleMargin()) {
            this.getTopEdgeTreatment().setFabCradleMargin(arg2);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float arg2) {
        if(arg2 != this.getFabCradleRoundedCornerRadius()) {
            this.getTopEdgeTreatment().setFabCradleRoundedCornerRadius(arg2);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    boolean setFabDiameter(int arg2) {
        float v2 = ((float)arg2);
        if(v2 != this.getTopEdgeTreatment().getFabDiameter()) {
            this.getTopEdgeTreatment().setFabDiameter(v2);
            this.materialShapeDrawable.invalidateSelf();
            return 1;
        }

        return 0;
    }

    public void setHideOnScroll(boolean arg1) {
        this.hideOnScroll = arg1;
    }

    public void setMenuAlignmentMode(int arg3) {
        if(this.menuAlignmentMode != arg3) {
            this.menuAlignmentMode = arg3;
            ActionMenuView v3 = this.getActionMenuView();
            if(v3 != null) {
                this.translateActionMenuView(v3, this.fabAlignmentMode, this.isFabVisibleOrWillBeShown());
            }
        }
    }

    public void setNavigationIcon(Drawable arg1) {
        super.setNavigationIcon(this.maybeTintNavigationIcon(arg1));
    }

    public void setNavigationIconTint(int arg1) {
        this.navigationIconTint = Integer.valueOf(arg1);
        Drawable v1 = this.getNavigationIcon();
        if(v1 != null) {
            this.setNavigationIcon(v1);
        }
    }

    public void setSubtitle(CharSequence arg1) {
    }

    public void setTitle(CharSequence arg1) {
    }

    private void translateActionMenuView(ActionMenuView arg2, int arg3, boolean arg4, boolean arg5) {
        com.google.android.material.bottomappbar.BottomAppBar$8 v0 = new Runnable(arg2, arg3, arg4) {
            public void run() {
                this.val$actionMenuView.setTranslationX(((float)BottomAppBar.this.getActionMenuViewTranslationX(this.val$actionMenuView, this.val$fabAlignmentMode, this.val$fabAttached)));
            }
        };
        if(arg5) {
            arg2.post(((Runnable)v0));
            return;
        }

        ((Runnable)v0).run();
    }

    private void translateActionMenuView(ActionMenuView arg2, int arg3, boolean arg4) {
        this.translateActionMenuView(arg2, arg3, arg4, false);
    }

    private static void updateFabAnchorGravity(BottomAppBar arg2, View arg3) {
        ViewGroup$LayoutParams v3 = arg3.getLayoutParams();
        ((LayoutParams)v3).anchorGravity = 17;
        if(arg2.fabAnchorMode == 1) {
            ((LayoutParams)v3).anchorGravity |= 0x30;
        }

        if(arg2.fabAnchorMode == 0) {
            ((LayoutParams)v3).anchorGravity |= 80;
        }
    }
}

