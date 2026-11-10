package com.google.android.material.sidesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper$Callback;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel$Builder;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SideSheetBehavior extends Behavior implements Sheet {
    class com.google.android.material.sidesheet.SideSheetBehavior$1 extends Callback {
        com.google.android.material.sidesheet.SideSheetBehavior$1(SideSheetBehavior arg1) {
            SideSheetBehavior.this = arg1;
            super();
        }

        public int clampViewPositionHorizontal(View arg1, int arg2, int arg3) {
            return MathUtils.clamp(arg2, SideSheetBehavior.this.sheetDelegate.getMinViewPositionHorizontal(), SideSheetBehavior.this.sheetDelegate.getMaxViewPositionHorizontal());
        }

        public int clampViewPositionVertical(View arg1, int arg2, int arg3) {
            return arg1.getTop();
        }

        public int getViewHorizontalDragRange(View arg1) {
            return SideSheetBehavior.this.childWidth + SideSheetBehavior.this.getInnerMargin();
        }

        public void onViewDragStateChanged(int arg2) {
            if(arg2 == 1 && (SideSheetBehavior.this.draggable)) {
                SideSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(View arg3, int arg4, int arg5, int arg6, int arg7) {
            View v5 = SideSheetBehavior.this.getCoplanarSiblingView();
            if(v5 != null) {
                ViewGroup$LayoutParams v6 = v5.getLayoutParams();
                if(v6 != null) {
                    SideSheetBehavior.this.sheetDelegate.updateCoplanarSiblingLayoutParams(((ViewGroup$MarginLayoutParams)v6), arg3.getLeft(), arg3.getRight());
                    v5.setLayoutParams(v6);
                }
            }

            SideSheetBehavior.this.dispatchOnSlide(arg3, arg4);
        }

        public void onViewReleased(View arg2, float arg3, float arg4) {
            SideSheetBehavior.this.startSettling(arg2, SideSheetBehavior.this.calculateTargetStateOnViewReleased(arg2, arg3, arg4), SideSheetBehavior.this.shouldSkipSmoothAnimation());
        }

        public boolean tryCaptureView(View arg3, int arg4) {
            if(SideSheetBehavior.this.state == 1) {
                return 0;
            }

            if(SideSheetBehavior.this.viewRef != null && SideSheetBehavior.this.viewRef.get() == arg3) {
                return 1;
            }

            return 0;
        }
    }

    public class SavedState extends AbsSavedState {
        class com.google.android.material.sidesheet.SideSheetBehavior$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.sidesheet.SideSheetBehavior$SavedState$1() {
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
        final int state;

        static {
            SavedState.CREATOR = new com.google.android.material.sidesheet.SideSheetBehavior$SavedState$1();
        }

        public SavedState(Parcelable arg1, SideSheetBehavior arg2) {
            super(arg1);
            this.state = arg2.state;
        }

        public SavedState(Parcel arg2) {
            this(arg2, null);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.state = arg1.readInt();
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeInt(this.state);
        }
    }

    class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;

        StateSettlingTracker(SideSheetBehavior arg1) {
            SideSheetBehavior.this = arg1;
            super();
            this.continueSettlingRunnable = new SideSheetBehavior$StateSettlingTracker$$ExternalSyntheticLambda0(this);
        }

        void continueSettlingToState(int arg2) {
            if(SideSheetBehavior.this.viewRef != null) {
                if(SideSheetBehavior.this.viewRef.get() == null) {
                }
                else {
                    this.targetState = arg2;
                    if(!this.isContinueSettlingRunnablePosted) {
                        ViewCompat.postOnAnimation(SideSheetBehavior.this.viewRef.get(), this.continueSettlingRunnable);
                        this.isContinueSettlingRunnablePosted = true;
                    }
                }
            }
        }

        void lambda$new$0$com-google-android-material-sidesheet-SideSheetBehavior$StateSettlingTracker() {
            this.isContinueSettlingRunnablePosted = false;
            if(SideSheetBehavior.this.viewDragHelper != null && (SideSheetBehavior.this.viewDragHelper.continueSettling(true))) {
                this.continueSettlingToState(this.targetState);
                return;
            }

            if(SideSheetBehavior.this.state == 2) {
                SideSheetBehavior.this.setStateInternal(this.targetState);
            }
        }
    }

    private static final int DEFAULT_ACCESSIBILITY_PANE_TITLE = 0;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    private ColorStateList backgroundTint;
    private final Set callbacks;
    private int childWidth;
    private int coplanarSiblingViewId;
    private WeakReference coplanarSiblingViewRef;
    private final Callback dragCallback;
    private boolean draggable;
    private float elevation;
    private float hideFriction;
    private boolean ignoreEvents;
    private int initialX;
    private int innerMargin;
    private int lastStableState;
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private int parentInnerEdge;
    private int parentWidth;
    private ShapeAppearanceModel shapeAppearanceModel;
    private SheetDelegate sheetDelegate;
    private MaterialSideContainerBackHelper sideContainerBackHelper;
    private int state;
    private final StateSettlingTracker stateSettlingTracker;
    private VelocityTracker velocityTracker;
    private ViewDragHelper viewDragHelper;
    private WeakReference viewRef;

    static {
        SideSheetBehavior.DEFAULT_ACCESSIBILITY_PANE_TITLE = string.side_sheet_accessibility_pane_title;
        SideSheetBehavior.DEF_STYLE_RES = style.Widget_Material3_SideSheet;
    }

    public SideSheetBehavior() {
        super();
        this.stateSettlingTracker = new StateSettlingTracker(this);
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new com.google.android.material.sidesheet.SideSheetBehavior$1(this);
    }

    public SideSheetBehavior(Context arg6, AttributeSet arg7) {
        super(arg6, arg7);
        this.stateSettlingTracker = new StateSettlingTracker(this);
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        int v1 = -1;
        this.coplanarSiblingViewId = v1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new com.google.android.material.sidesheet.SideSheetBehavior$1(this);
        TypedArray v2 = arg6.obtainStyledAttributes(arg7, styleable.SideSheetBehavior_Layout);
        if(v2.hasValue(styleable.SideSheetBehavior_Layout_backgroundTint)) {
            this.backgroundTint = MaterialResources.getColorStateList(arg6, v2, styleable.SideSheetBehavior_Layout_backgroundTint);
        }

        if(v2.hasValue(styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModel = ShapeAppearanceModel.builder(arg6, arg7, 0, SideSheetBehavior.DEF_STYLE_RES).build();
        }

        if(v2.hasValue(styleable.SideSheetBehavior_Layout_coplanarSiblingViewId)) {
            this.setCoplanarSiblingViewId(v2.getResourceId(styleable.SideSheetBehavior_Layout_coplanarSiblingViewId, v1));
        }

        this.createMaterialShapeDrawableIfNeeded(arg6);
        this.elevation = v2.getDimension(styleable.SideSheetBehavior_Layout_android_elevation, -1f);
        this.setDraggable(v2.getBoolean(styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        v2.recycle();
        this.maximumVelocity = ((float)ViewConfiguration.get(arg6).getScaledMaximumFlingVelocity());
    }

    static int access$000(SideSheetBehavior arg0) {
        return arg0.state;
    }

    static WeakReference access$100(SideSheetBehavior arg0) {
        return arg0.viewRef;
    }

    static SheetDelegate access$200(SideSheetBehavior arg0) {
        return arg0.sheetDelegate;
    }

    static void access$300(SideSheetBehavior arg0, View arg1, int arg2) {
        arg0.dispatchOnSlide(arg1, arg2);
    }

    static boolean access$400(SideSheetBehavior arg0) {
        return arg0.draggable;
    }

    static int access$500(SideSheetBehavior arg0, View arg1, float arg2, float arg3) {
        return arg0.calculateTargetStateOnViewReleased(arg1, arg2, arg3);
    }

    static void access$600(SideSheetBehavior arg0, View arg1, int arg2, boolean arg3) {
        arg0.startSettling(arg1, arg2, arg3);
    }

    static int access$700(SideSheetBehavior arg0) {
        return arg0.childWidth;
    }

    static ViewDragHelper access$800(SideSheetBehavior arg0) {
        return arg0.viewDragHelper;
    }

    public void addCallback(SheetCallback arg1) {
        this.addCallback(((SideSheetCallback)arg1));
    }

    public void addCallback(SideSheetCallback arg1) {
        this.callbacks.add(arg1);
    }

    private int calculateCurrentOffset(int arg3, View arg4) {
        int v0 = this.state;
        if(v0 != 1 && v0 != 2) {
            if(v0 == 3) {
                return 0;
            }
            else if(v0 == 5) {
                return this.sheetDelegate.getHiddenOffset();
            }
            else {
                throw new IllegalStateException("Unexpected value: " + this.state);
            }
        }

        return arg3 - this.sheetDelegate.getOuterEdge(arg4);
    }

    private float calculateDragDistance(float arg1, float arg2) {
        return Math.abs(arg1 - arg2);
    }

    private int calculateTargetStateOnViewReleased(View arg4, float arg5, float arg6) {
        int v1 = 3;
        if(this.isExpandingOutwards(arg5)) {
            return v1;
        }

        int v2 = 5;
        if(this.shouldHide(arg4, arg5)) {
            if(!this.sheetDelegate.isSwipeSignificant(arg5, arg6)) {
                if(this.sheetDelegate.isReleasedCloseToInnerEdge(arg4)) {
                }
                else {
                    return v1;
                }
            }

            return v2;
        }

        if(arg5 != 0f) {
            if(!SheetUtils.isSwipeMostlyHorizontal(arg5, arg6)) {
            }
            else {
                return v2;
            }
        }

        int v4 = arg4.getLeft();
        if(Math.abs(v4 - this.getExpandedOffset()) < Math.abs(v4 - this.sheetDelegate.getHiddenOffset())) {
            return v1;
        }

        return v2;
    }

    public void cancelBackProgress() {
        MaterialSideContainerBackHelper v0 = this.sideContainerBackHelper;
        if(v0 == null) {
            return;
        }

        v0.cancelBackProgress();
    }

    private void clearCoplanarSiblingView() {
        WeakReference v0 = this.coplanarSiblingViewRef;
        if(v0 != null) {
            v0.clear();
        }

        this.coplanarSiblingViewRef = null;
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(int arg2) {
        return new SideSheetBehavior$$ExternalSyntheticLambda1(this, arg2);
    }

    private void createMaterialShapeDrawableIfNeeded(Context arg4) {
        if(this.shapeAppearanceModel == null) {
            return;
        }

        MaterialShapeDrawable v0 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.materialShapeDrawable = v0;
        v0.initializeElevationOverlay(arg4);
        ColorStateList v0_1 = this.backgroundTint;
        if(v0_1 != null) {
            this.materialShapeDrawable.setFillColor(v0_1);
            return;
        }

        TypedValue v0_2 = new TypedValue();
        arg4.getTheme().resolveAttribute(0x1010031, v0_2, true);
        this.materialShapeDrawable.setTint(v0_2.data);
    }

    private void dispatchOnSlide(View arg2, int arg3) {
        if(!this.callbacks.isEmpty()) {
            float v3 = this.sheetDelegate.calculateSlideOffset(arg3);
            Iterator v1 = this.callbacks.iterator();
            while(v1.hasNext()) {
                v1.next().onSlide(arg2, v3);
            }
        }
    }

    private void ensureAccessibilityPaneTitleIsSet(View arg2) {
        if(ViewCompat.getAccessibilityPaneTitle(arg2) == null) {
            ViewCompat.setAccessibilityPaneTitle(arg2, arg2.getResources().getString(SideSheetBehavior.DEFAULT_ACCESSIBILITY_PANE_TITLE));
        }
    }

    public void expand() {
        this.setState(3);
    }

    public static SideSheetBehavior from(View arg1) {
        ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
        if((v1 instanceof LayoutParams)) {
            Behavior v1_1 = ((LayoutParams)v1).getBehavior();
            if((v1_1 instanceof SideSheetBehavior)) {
                return ((SideSheetBehavior)v1_1);
            }

            throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
        }

        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    MaterialSideContainerBackHelper getBackHelper() {
        return this.sideContainerBackHelper;
    }

    private int getChildMeasureSpec(int arg1, int arg2, int arg3, int arg4) {
        int v0 = ViewGroup.getChildMeasureSpec(arg1, arg2, arg4);
        if(arg3 == -1) {
            return v0;
        }

        arg1 = View$MeasureSpec.getMode(v0);
        v0 = View$MeasureSpec.getSize(v0);
        arg2 = 0x40000000;
        if(arg1 != arg2) {
            if(v0 == 0) {
            }
            else {
                arg3 = Math.min(v0, arg3);
            }

            return View$MeasureSpec.makeMeasureSpec(arg3, 0x80000000);
        }

        return View$MeasureSpec.makeMeasureSpec(Math.min(v0, arg3), arg2);
    }

    int getChildWidth() {
        return this.childWidth;
    }

    private ValueAnimator$AnimatorUpdateListener getCoplanarFinishAnimatorUpdateListener() {
        View v0 = this.getCoplanarSiblingView();
        ValueAnimator$AnimatorUpdateListener v1 = null;
        if(v0 == null) {
            return v1;
        }

        ViewGroup$LayoutParams v2 = v0.getLayoutParams();
        if(v2 == null) {
            return v1;
        }

        return new SideSheetBehavior$$ExternalSyntheticLambda2(this, ((ViewGroup$MarginLayoutParams)v2), this.sheetDelegate.getCoplanarSiblingAdjacentMargin(((ViewGroup$MarginLayoutParams)v2)), v0);
    }

    public View getCoplanarSiblingView() {
        WeakReference v0 = this.coplanarSiblingViewRef;
        if(v0 != null) {
            return v0.get();
        }

        return null;
    }

    public int getExpandedOffset() {
        return this.sheetDelegate.getExpandedOffset();
    }

    private int getGravityFromSheetEdge() {
        SheetDelegate v1 = this.sheetDelegate;
        int v0 = 5;
        if(v1 != null) {
            if(v1.getSheetEdge() == 0) {
                return v0;
            }

            return 3;
        }

        return v0;
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    float getHideThreshold() {
        return 0.5f;
    }

    int getInnerMargin() {
        return this.innerMargin;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    int getOuterEdgeOffsetForState(int arg3) {
        if(arg3 != 3) {
            if(arg3 == 5) {
                return this.sheetDelegate.getHiddenOffset();
            }

            throw new IllegalArgumentException("Invalid state to get outer edge offset: " + arg3);
        }

        return this.getExpandedOffset();
    }

    int getParentInnerEdge() {
        return this.parentInnerEdge;
    }

    int getParentWidth() {
        return this.parentWidth;
    }

    int getSignificantVelocityThreshold() {
        return 500;
    }

    public int getState() {
        return this.state;
    }

    ViewDragHelper getViewDragHelper() {
        return this.viewDragHelper;
    }

    private LayoutParams getViewLayoutParams() {
        WeakReference v1 = this.viewRef;
        if(v1 != null) {
            Object v1_1 = v1.get();
            if(v1_1 != null && ((((View)v1_1).getLayoutParams() instanceof LayoutParams))) {
                return ((View)v1_1).getLayoutParams();
            }
        }

        return null;
    }

    float getXVelocity() {
        VelocityTracker v0 = this.velocityTracker;
        if(v0 == null) {
            return 0;
        }

        v0.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getXVelocity();
    }

    public void handleBackInvoked() {
        MaterialSideContainerBackHelper v0 = this.sideContainerBackHelper;
        if(v0 == null) {
            return;
        }

        BackEventCompat v0_1 = v0.onHandleBackInvoked();
        if(v0_1 != null) {
            if(Build$VERSION.SDK_INT < 34) {
            }
            else {
                this.sideContainerBackHelper.finishBackProgress(v0_1, this.getGravityFromSheetEdge(), new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator arg2) {
                        SideSheetBehavior.this.setStateInternal(5);
                        if(SideSheetBehavior.this.viewRef != null && SideSheetBehavior.this.viewRef.get() != null) {
                            SideSheetBehavior.this.viewRef.get().requestLayout();
                        }
                    }
                }, this.getCoplanarFinishAnimatorUpdateListener());
                return;
            }
        }

        this.setState(5);
    }

    private boolean hasLeftMargin() {
        LayoutParams v0 = this.getViewLayoutParams();
        if(v0 != null && v0.leftMargin > 0) {
            return 1;
        }

        return 0;
    }

    private boolean hasRightMargin() {
        LayoutParams v0 = this.getViewLayoutParams();
        if(v0 != null && v0.rightMargin > 0) {
            return 1;
        }

        return 0;
    }

    public void hide() {
        this.setState(5);
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    private boolean isDraggedFarEnough(MotionEvent arg3) {
        if(!this.shouldHandleDraggingWithHelper()) {
            return 0;
        }

        if(this.calculateDragDistance(((float)this.initialX), arg3.getX()) > (((float)this.viewDragHelper.getTouchSlop()))) {
            return 1;
        }

        return 0;
    }

    private boolean isExpandingOutwards(float arg1) {
        return this.sheetDelegate.isExpandingOutwards(arg1);
    }

    private boolean isLayingOut(View arg1) {
        ViewParent v0 = arg1.getParent();
        if(v0 != null && (v0.isLayoutRequested()) && (ViewCompat.isAttachedToWindow(arg1))) {
            return 1;
        }

        return 0;
    }

    private boolean isSettling(View arg1, int arg2, boolean arg3) {
        arg2 = this.getOuterEdgeOffsetForState(arg2);
        ViewDragHelper v0 = this.getViewDragHelper();
        if(v0 != null) {
            if(!arg3) {
                if(v0.smoothSlideViewTo(arg1, arg2, arg1.getTop())) {
                    return 1;
                }

                return 0;
            }
            else if(v0.settleCapturedViewAt(arg2, arg1.getTop())) {
            }
            else {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    boolean lambda$createAccessibilityViewCommandForState$2$com-google-android-material-sidesheet-SideSheetBehavior(int arg1, View arg2, CommandArguments arg3) {
        this.setState(arg1);
        return 1;
    }

    void lambda$getCoplanarFinishAnimatorUpdateListener$1$com-google-android-material-sidesheet-SideSheetBehavior(ViewGroup$MarginLayoutParams arg2, int arg3, View arg4, ValueAnimator arg5) {
        this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(arg2, AnimationUtils.lerp(arg3, 0, arg5.getAnimatedFraction()));
        arg4.requestLayout();
    }

    void lambda$setState$0$com-google-android-material-sidesheet-SideSheetBehavior(int arg3) {
        Object v0 = this.viewRef.get();
        if(v0 != null) {
            this.startSettling(((View)v0), arg3, false);
        }
    }

    private void maybeAssignCoplanarSiblingViewBasedId(CoordinatorLayout arg3) {
        if(this.coplanarSiblingViewRef == null) {
            int v0 = this.coplanarSiblingViewId;
            if(v0 != -1) {
                View v3 = arg3.findViewById(v0);
                if(v3 != null) {
                    this.coplanarSiblingViewRef = new WeakReference(v3);
                }
            }
        }
    }

    public void onAttachedToLayoutParams(LayoutParams arg1) {
        super.onAttachedToLayoutParams(arg1);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout arg3, View arg4, MotionEvent arg5) {
        if(!this.shouldInterceptTouchEvent(arg4)) {
            this.ignoreEvents = true;
            return 0;
        }

        int v3 = arg5.getActionMasked();
        if(v3 == 0) {
            this.resetVelocity();
        }

        VelocityTracker v1 = this.velocityTracker;
        if(v1 == null) {
            v1 = VelocityTracker.obtain();
            this.velocityTracker = v1;
        }

        v1.addMovement(arg5);
        if(v3 != 0) {
            if(v3 != 1 && v3 != 3) {
                goto label_26;
            }

            if(!this.ignoreEvents) {
                goto label_26;
            }

            this.ignoreEvents = false;
            return 0;
        }
        else {
            this.initialX = ((int)arg5.getX());
        }

    label_26:
        if(!this.ignoreEvents) {
            ViewDragHelper v2 = this.viewDragHelper;
            if(v2 != null && (v2.shouldInterceptTouchEvent(arg5))) {
                return 1;
            }
        }

        return 0;
    }

    public boolean onLayoutChild(CoordinatorLayout arg5, View arg6, int arg7) {
        if((ViewCompat.getFitsSystemWindows(((View)arg5))) && !ViewCompat.getFitsSystemWindows(arg6)) {
            arg6.setFitsSystemWindows(true);
        }

        if(this.viewRef == null) {
            this.viewRef = new WeakReference(arg6);
            this.sideContainerBackHelper = new MaterialSideContainerBackHelper(arg6);
            MaterialShapeDrawable v0 = this.materialShapeDrawable;
            if(v0 != null) {
                ViewCompat.setBackground(arg6, ((Drawable)v0));
                v0 = this.materialShapeDrawable;
                float v2 = this.elevation;
                if(v2 == -1f) {
                    v2 = ViewCompat.getElevation(arg6);
                }

                v0.setElevation(v2);
            }
            else {
                ColorStateList v0_1 = this.backgroundTint;
                if(v0_1 == null) {
                    goto label_27;
                }

                ViewCompat.setBackgroundTintList(arg6, v0_1);
            }

        label_27:
            this.updateSheetVisibility(arg6);
            this.updateAccessibilityActions();
            if(ViewCompat.getImportantForAccessibility(arg6) == 0) {
                ViewCompat.setImportantForAccessibility(arg6, 1);
            }

            this.ensureAccessibilityPaneTitleIsSet(arg6);
        }

        this.setSheetEdge(arg6, arg7);
        if(this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(((ViewGroup)arg5), this.dragCallback);
        }

        int v0_2 = this.sheetDelegate.getOuterEdge(arg6);
        arg5.onLayoutChild(arg6, arg7);
        this.parentWidth = arg5.getWidth();
        this.parentInnerEdge = this.sheetDelegate.getParentInnerEdge(arg5);
        this.childWidth = arg6.getWidth();
        ViewGroup$LayoutParams v7 = arg6.getLayoutParams();
        arg7 = v7 != null ? this.sheetDelegate.calculateInnerMargin(((ViewGroup$MarginLayoutParams)v7)) : 0;
        this.innerMargin = arg7;
        ViewCompat.offsetLeftAndRight(arg6, this.calculateCurrentOffset(v0_2, arg6));
        this.maybeAssignCoplanarSiblingViewBasedId(arg5);
        Iterator v4 = this.callbacks.iterator();
        while(v4.hasNext()) {
            Object v5 = v4.next();
            if(!(v5 instanceof SideSheetCallback)) {
                continue;
            }

            ((SideSheetCallback)v5).onLayout(arg6);
        }

        return 1;
    }

    public boolean onMeasureChild(CoordinatorLayout arg4, View arg5, int arg6, int arg7, int arg8, int arg9) {
        ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
        arg5.measure(this.getChildMeasureSpec(arg6, arg4.getPaddingLeft() + arg4.getPaddingRight() + ((ViewGroup$MarginLayoutParams)v0).leftMargin + ((ViewGroup$MarginLayoutParams)v0).rightMargin + arg7, -1, ((ViewGroup$MarginLayoutParams)v0).width), this.getChildMeasureSpec(arg8, arg4.getPaddingTop() + arg4.getPaddingBottom() + ((ViewGroup$MarginLayoutParams)v0).topMargin + ((ViewGroup$MarginLayoutParams)v0).bottomMargin + arg9, -1, ((ViewGroup$MarginLayoutParams)v0).height));
        return 1;
    }

    public void onRestoreInstanceState(CoordinatorLayout arg2, View arg3, Parcelable arg4) {
        if(((SavedState)arg4).getSuperState() != null) {
            super.onRestoreInstanceState(arg2, arg3, ((SavedState)arg4).getSuperState());
        }

        int v2 = ((SavedState)arg4).state == 1 || ((SavedState)arg4).state == 2 ? 5 : ((SavedState)arg4).state;
        this.state = v2;
        this.lastStableState = v2;
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout arg2, View arg3) {
        return new SavedState(super.onSaveInstanceState(arg2, arg3), this);
    }

    public boolean onTouchEvent(CoordinatorLayout arg3, View arg4, MotionEvent arg5) {
        if(!arg4.isShown()) {
            return 0;
        }

        int v3 = arg5.getActionMasked();
        if(this.state == 1 && v3 == 0) {
            return 1;
        }

        if(this.shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.processTouchEvent(arg5);
        }

        if(v3 == 0) {
            this.resetVelocity();
        }

        VelocityTracker v0 = this.velocityTracker;
        if(v0 == null) {
            v0 = VelocityTracker.obtain();
            this.velocityTracker = v0;
        }

        v0.addMovement(arg5);
        if((this.shouldHandleDraggingWithHelper()) && v3 == 2 && !this.ignoreEvents && (this.isDraggedFarEnough(arg5))) {
            this.viewDragHelper.captureChildView(arg4, arg5.getPointerId(arg5.getActionIndex()));
        }

        return this.ignoreEvents ^ 1;
    }

    public void removeCallback(SheetCallback arg1) {
        this.removeCallback(((SideSheetCallback)arg1));
    }

    public void removeCallback(SideSheetCallback arg1) {
        this.callbacks.remove(arg1);
    }

    private void replaceAccessibilityActionForState(View arg2, AccessibilityActionCompat arg3, int arg4) {
        ViewCompat.replaceAccessibilityAction(arg2, arg3, null, this.createAccessibilityViewCommandForState(arg4));
    }

    private void resetVelocity() {
        VelocityTracker v0 = this.velocityTracker;
        if(v0 != null) {
            v0.recycle();
            this.velocityTracker = null;
        }
    }

    private void runAfterLayout(View arg1, Runnable arg2) {
        if(this.isLayingOut(arg1)) {
            arg1.post(arg2);
            return;
        }

        arg2.run();
    }

    public void setCoplanarSiblingView(View arg2) {
        this.coplanarSiblingViewId = -1;
        if(arg2 == null) {
            this.clearCoplanarSiblingView();
            return;
        }

        this.coplanarSiblingViewRef = new WeakReference(arg2);
        WeakReference v1 = this.viewRef;
        if(v1 != null) {
            Object v1_1 = v1.get();
            if(ViewCompat.isLaidOut(((View)v1_1))) {
                ((View)v1_1).requestLayout();
            }
        }
    }

    public void setCoplanarSiblingViewId(int arg2) {
        this.coplanarSiblingViewId = arg2;
        this.clearCoplanarSiblingView();
        WeakReference v1 = this.viewRef;
        if(v1 != null) {
            Object v1_1 = v1.get();
            if(arg2 != -1 && (ViewCompat.isLaidOut(((View)v1_1)))) {
                ((View)v1_1).requestLayout();
            }
        }
    }

    public void setDraggable(boolean arg1) {
        this.draggable = arg1;
    }

    public void setHideFriction(float arg1) {
        this.hideFriction = arg1;
    }

    private void setSheetEdge(int arg3) {
        Builder v3;
        SheetDelegate v0 = this.sheetDelegate;
        if(v0 == null || v0.getSheetEdge() != arg3) {
            if(arg3 == 0) {
                this.sheetDelegate = new RightSheetDelegate(this);
                if(this.shapeAppearanceModel != null && !this.hasRightMargin()) {
                    v3 = this.shapeAppearanceModel.toBuilder();
                    v3.setTopRightCornerSize(0f).setBottomRightCornerSize(0f);
                    this.updateMaterialShapeDrawable(v3.build());
                    return;
                }
            }
            else if(arg3 == 1) {
                this.sheetDelegate = new LeftSheetDelegate(this);
                if(this.shapeAppearanceModel != null && !this.hasLeftMargin()) {
                    v3 = this.shapeAppearanceModel.toBuilder();
                    v3.setTopLeftCornerSize(0f).setBottomLeftCornerSize(0f);
                    this.updateMaterialShapeDrawable(v3.build());
                }
            }
            else {
                goto label_36;
            }
        }

        return;
    label_36:
        throw new IllegalArgumentException("Invalid sheet edge position value: " + arg3 + ". Must be 0 or 1.");
    }

    private void setSheetEdge(View arg1, int arg2) {
        int v1 = GravityCompat.getAbsoluteGravity(arg1.getLayoutParams().gravity, arg2) == 3 ? 1 : 0;
        this.setSheetEdge(v1);
    }

    public void setState(int arg4) {
        if(arg4 != 1) {
            if(arg4 == 2) {
            }
            else {
                WeakReference v0 = this.viewRef;
                if(v0 != null) {
                    if(v0.get() == null) {
                    }
                    else {
                        this.runAfterLayout(this.viewRef.get(), new SideSheetBehavior$$ExternalSyntheticLambda0(this, arg4));
                        return;
                    }
                }

                this.setStateInternal(arg4);
                return;
            }
        }

        StringBuilder v1 = new StringBuilder("STATE_");
        String v4 = arg4 == 1 ? "DRAGGING" : "SETTLING";
        throw new IllegalArgumentException(v1.append(v4).append(" should not be set externally.").toString());
    }

    void setStateInternal(int arg4) {
        Object v0_1;
        if(this.state == arg4) {
        }
        else {
            this.state = arg4;
            if(arg4 == 3 || arg4 == 5) {
                this.lastStableState = arg4;
            }

            WeakReference v0 = this.viewRef;
            if(v0 == null) {
                return;
            }

            v0_1 = v0.get();
            if(v0_1 != null) {
                goto label_15;
            }
        }

        return;
    label_15:
        this.updateSheetVisibility(((View)v0_1));
        Iterator v1 = this.callbacks.iterator();
        while(v1.hasNext()) {
            v1.next().onStateChanged(((View)v0_1), arg4);
        }

        this.updateAccessibilityActions();
    }

    private boolean shouldHandleDraggingWithHelper() {
        if(this.viewDragHelper != null && ((this.draggable) || this.state == 1)) {
            return 1;
        }

        return 0;
    }

    boolean shouldHide(View arg1, float arg2) {
        return this.sheetDelegate.shouldHide(arg1, arg2);
    }

    private boolean shouldInterceptTouchEvent(View arg2) {
        if(((arg2.isShown()) || ViewCompat.getAccessibilityPaneTitle(arg2) != null) && (this.draggable)) {
            return 1;
        }

        return 0;
    }

    public boolean shouldSkipSmoothAnimation() {
        return 1;
    }

    public void startBackProgress(BackEventCompat arg1) {
        MaterialSideContainerBackHelper v0 = this.sideContainerBackHelper;
        if(v0 == null) {
            return;
        }

        v0.startBackProgress(arg1);
    }

    private void startSettling(View arg1, int arg2, boolean arg3) {
        if(this.isSettling(arg1, arg2, arg3)) {
            this.setStateInternal(2);
            this.stateSettlingTracker.continueSettlingToState(arg2);
            return;
        }

        this.setStateInternal(arg2);
    }

    private void updateAccessibilityActions() {
        WeakReference v0 = this.viewRef;
        if(v0 == null) {
        }
        else {
            Object v0_1 = v0.get();
            if(v0_1 == null) {
            }
            else {
                ViewCompat.removeAccessibilityAction(((View)v0_1), 0x40000);
                ViewCompat.removeAccessibilityAction(((View)v0_1), 0x100000);
                int v2 = 5;
                if(this.state != v2) {
                    this.replaceAccessibilityActionForState(((View)v0_1), AccessibilityActionCompat.ACTION_DISMISS, v2);
                }

                v2 = 3;
                if(this.state == v2) {
                    return;
                }

                this.replaceAccessibilityActionForState(((View)v0_1), AccessibilityActionCompat.ACTION_EXPAND, v2);
            }
        }
    }

    public void updateBackProgress(BackEventCompat arg3) {
        MaterialSideContainerBackHelper v0 = this.sideContainerBackHelper;
        if(v0 == null) {
            return;
        }

        v0.updateBackProgress(arg3, this.getGravityFromSheetEdge());
        this.updateCoplanarSiblingBackProgress();
    }

    private void updateCoplanarSiblingBackProgress() {
        WeakReference v0 = this.viewRef;
        if(v0 != null) {
            if(v0.get() == null) {
            }
            else {
                Object v0_1 = this.viewRef.get();
                View v1 = this.getCoplanarSiblingView();
                if(v1 == null) {
                }
                else {
                    ViewGroup$LayoutParams v2 = v1.getLayoutParams();
                    if(v2 == null) {
                    }
                    else {
                        this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(((ViewGroup$MarginLayoutParams)v2), ((int)((((float)this.childWidth)) * ((View)v0_1).getScaleX() + (((float)this.innerMargin)))));
                        v1.requestLayout();
                    }
                }
            }
        }
    }

    private void updateMaterialShapeDrawable(ShapeAppearanceModel arg1) {
        MaterialShapeDrawable v0 = this.materialShapeDrawable;
        if(v0 != null) {
            v0.setShapeAppearanceModel(arg1);
        }
    }

    private void updateSheetVisibility(View arg2) {
        int v1 = this.state == 5 ? 4 : 0;
        if(arg2.getVisibility() != v1) {
            arg2.setVisibility(v1);
        }
    }
}

