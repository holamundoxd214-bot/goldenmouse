package com.google.android.material.bottomsheet;

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
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper$Callback;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior extends Behavior implements MaterialBackHandler {
    class com.google.android.material.bottomsheet.BottomSheetBehavior$5 extends Callback {
        private long viewCapturedMillis;

        com.google.android.material.bottomsheet.BottomSheetBehavior$5(BottomSheetBehavior arg1) {
            BottomSheetBehavior.this = arg1;
            super();
        }

        public int clampViewPositionHorizontal(View arg1, int arg2, int arg3) {
            return arg1.getLeft();
        }

        public int clampViewPositionVertical(View arg1, int arg2, int arg3) {
            return MathUtils.clamp(arg2, BottomSheetBehavior.this.getExpandedOffset(), this.getViewVerticalDragRange(arg1));
        }

        public int getViewVerticalDragRange(View arg1) {
            boolean v1 = BottomSheetBehavior.this.canBeHiddenByDragging();
            BottomSheetBehavior v0 = BottomSheetBehavior.this;
            if(v1) {
                return v0.parentHeight;
            }

            return v0.collapsedOffset;
        }

        public void onViewDragStateChanged(int arg2) {
            if(arg2 == 1 && (BottomSheetBehavior.this.draggable)) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(View arg1, int arg2, int arg3, int arg4, int arg5) {
            BottomSheetBehavior.this.dispatchOnSlide(arg3);
        }

        public void onViewReleased(View arg9, float arg10, float arg11) {
            boolean v11;
            int v10;
            int v1 = Float.compare(arg11, 0f);
            BottomSheetBehavior v2 = BottomSheetBehavior.this;
            int v3 = 6;
            int v4 = 3;
            int v5 = 4;
            if(v1 >= 0) {
                if((v2.hideable) && (BottomSheetBehavior.this.shouldHide(arg9, arg11))) {
                    if(Math.abs(arg10) < Math.abs(arg11) && arg11 > (((float)BottomSheetBehavior.this.significantVelocityThreshold)) || (this.releasedLow(arg9))) {
                        v3 = 5;
                        goto label_126;
                    }

                    if(BottomSheetBehavior.this.fitToContents) {
                        goto label_9;
                    }

                    if(Math.abs(arg9.getTop() - BottomSheetBehavior.this.getExpandedOffset()) >= Math.abs(arg9.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                        goto label_126;
                    }

                    goto label_9;
                }

                if(arg11 != 0f) {
                    if(Math.abs(arg10) > Math.abs(arg11)) {
                    }
                    else if(!BottomSheetBehavior.this.fitToContents) {
                        v10 = arg9.getTop();
                        if(Math.abs(v10 - BottomSheetBehavior.this.halfExpandedOffset) >= Math.abs(v10 - BottomSheetBehavior.this.collapsedOffset)) {
                            goto label_72;
                        }
                        else if(BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                            goto label_72;
                        }
                        else {
                            goto label_126;
                        }
                    }
                    else {
                        goto label_72;
                    }
                }

                v10 = arg9.getTop();
                v11 = BottomSheetBehavior.this.fitToContents;
                BottomSheetBehavior v0_1 = BottomSheetBehavior.this;
                if(v11) {
                    if(Math.abs(v10 - v0_1.fitToContentsOffset) >= Math.abs(v10 - BottomSheetBehavior.this.collapsedOffset)) {
                        goto label_72;
                    }

                    goto label_9;
                }

                int v11_1 = v0_1.halfExpandedOffset;
                v0_1 = BottomSheetBehavior.this;
                if(v10 < v11_1) {
                    if(v10 < Math.abs(v10 - v0_1.collapsedOffset)) {
                    label_9:
                        v3 = v4;
                        goto label_126;
                    }

                    if(!BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                        goto label_126;
                    }

                    goto label_72;
                }

                if(Math.abs(v10 - v0_1.halfExpandedOffset) < Math.abs(v10 - BottomSheetBehavior.this.collapsedOffset) && !BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                    goto label_126;
                }

            label_72:
                v3 = v5;
            }
            else if(!v2.fitToContents) {
                v10 = arg9.getTop();
                long v0 = System.currentTimeMillis() - this.viewCapturedMillis;
                v11 = BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging();
                v2 = BottomSheetBehavior.this;
                if(v11) {
                    if(BottomSheetBehavior.this.shouldExpandOnUpwardDrag(v0, (((float)v10)) * 100f / (((float)v2.parentHeight)))) {
                        goto label_9;
                    }
                    else {
                        goto label_72;
                    }
                }
                else if(v10 > v2.halfExpandedOffset) {
                }
                else {
                    goto label_9;
                }
            }
            else {
                goto label_9;
            }

        label_126:
            BottomSheetBehavior.this.startSettling(arg9, v3, BottomSheetBehavior.this.shouldSkipSmoothAnimation());
        }

        private boolean releasedLow(View arg2) {
            if(arg2.getTop() > (BottomSheetBehavior.this.parentHeight + BottomSheetBehavior.this.getExpandedOffset()) / 2) {
                return 1;
            }

            return 0;
        }

        public boolean tryCaptureView(View arg6, int arg7) {
            if(BottomSheetBehavior.this.state == 1) {
                return 0;
            }

            if(BottomSheetBehavior.this.touchingScrollingChild) {
                return 0;
            }

            if(BottomSheetBehavior.this.state == 3 && BottomSheetBehavior.this.activePointerId == arg7) {
                Object v7 = BottomSheetBehavior.this.nestedScrollingChildRef != null ? BottomSheetBehavior.this.nestedScrollingChildRef.get() : null;
                if(v7 == null) {
                    goto label_30;
                }

                if(!((View)v7).canScrollVertically(-1)) {
                    goto label_30;
                }

                return 0;
            }

        label_30:
            this.viewCapturedMillis = System.currentTimeMillis();
            if(BottomSheetBehavior.this.viewRef != null && BottomSheetBehavior.this.viewRef.get() == arg6) {
                return 1;
            }

            return 0;
        }
    }

    public abstract class BottomSheetCallback {
        public BottomSheetCallback() {
            super();
        }

        void onLayout(View arg1) {
        }

        public abstract void onSlide(View arg1, float arg2);

        public abstract void onStateChanged(View arg1, int arg2);
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface SaveFlags {
    }

    public class SavedState extends AbsSavedState {
        class com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$1() {
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
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        static {
            SavedState.CREATOR = new com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$1();
        }

        public SavedState(Parcelable arg1, BottomSheetBehavior arg2) {
            super(arg1);
            this.state = arg2.state;
            this.peekHeight = arg2.peekHeight;
            this.fitToContents = arg2.fitToContents;
            this.hideable = arg2.hideable;
            this.skipCollapsed = arg2.skipCollapsed;
        }

        public SavedState(Parcel arg2) {
            this(arg2, null);
        }

        public SavedState(Parcel arg3, ClassLoader arg4) {
            super(arg3, arg4);
            this.state = arg3.readInt();
            this.peekHeight = arg3.readInt();
            boolean v0 = false;
            boolean v4 = arg3.readInt() == 1 ? true : false;
            this.fitToContents = v4;
            v4 = arg3.readInt() == 1 ? true : false;
            this.hideable = v4;
            if(arg3.readInt() == 1) {
                v0 = true;
            }

            this.skipCollapsed = v0;
        }

        @Deprecated public SavedState(Parcelable arg1, int arg2) {
            super(arg1);
            this.state = arg2;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeInt(this.state);
            arg1.writeInt(this.peekHeight);
            arg1.writeInt(this.fitToContents);
            arg1.writeInt(this.hideable);
            arg1.writeInt(this.skipCollapsed);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface StableState {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface State {
    }

    class StateSettlingTracker {
        class com.google.android.material.bottomsheet.BottomSheetBehavior$StateSettlingTracker$1 implements Runnable {
            com.google.android.material.bottomsheet.BottomSheetBehavior$StateSettlingTracker$1(StateSettlingTracker arg1) {
                this.this$1 = arg1;
                super();
            }

            public void run() {
                this.this$1.isContinueSettlingRunnablePosted = false;
                if(this.this$1.this$0.viewDragHelper != null && (this.this$1.this$0.viewDragHelper.continueSettling(true))) {
                    this.this$1.continueSettlingToState(this.this$1.targetState);
                    return;
                }

                if(this.this$1.this$0.state == 2) {
                    this.this$1.this$0.setStateInternal(this.this$1.targetState);
                }
            }
        }

        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;

        StateSettlingTracker(BottomSheetBehavior arg1, com.google.android.material.bottomsheet.BottomSheetBehavior$1 arg2) {
            this(arg1);
        }

        private StateSettlingTracker(BottomSheetBehavior arg1) {
            BottomSheetBehavior.this = arg1;
            super();
            this.continueSettlingRunnable = new com.google.android.material.bottomsheet.BottomSheetBehavior$StateSettlingTracker$1(this);
        }

        static boolean access$1702(StateSettlingTracker arg0, boolean arg1) {
            arg0.isContinueSettlingRunnablePosted = arg1;
            return arg1;
        }

        static int access$1800(StateSettlingTracker arg0) {
            return arg0.targetState;
        }

        void continueSettlingToState(int arg2) {
            if(BottomSheetBehavior.this.viewRef != null) {
                if(BottomSheetBehavior.this.viewRef.get() == null) {
                }
                else {
                    this.targetState = arg2;
                    if(!this.isContinueSettlingRunnablePosted) {
                        ViewCompat.postOnAnimation(BottomSheetBehavior.this.viewRef.get(), this.continueSettlingRunnable);
                        this.isContinueSettlingRunnablePosted = true;
                    }
                }
            }
        }
    }

    private static final int CORNER_ANIMATION_DURATION = 500;
    static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int INVALID_POSITION = -1;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    static final int VIEW_INDEX_ACCESSIBILITY_DELEGATE_VIEW = 1;
    private static final int VIEW_INDEX_BOTTOM_SHEET;
    WeakReference accessibilityDelegateViewRef;
    int activePointerId;
    private ColorStateList backgroundTint;
    MaterialBottomContainerBackHelper bottomContainerBackHelper;
    private final ArrayList callbacks;
    private int childHeight;
    int collapsedOffset;
    private final Callback dragCallback;
    private boolean draggable;
    float elevation;
    final SparseIntArray expandHalfwayActionIds;
    private boolean expandedCornersRemoved;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    private float hideFriction;
    boolean hideable;
    private boolean ignoreEvents;
    private Map importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;
    private ValueAnimator interpolatorAnimator;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shouldRemoveExpandedCorners;
    private int significantVelocityThreshold;
    private boolean skipCollapsed;
    int state;
    private final StateSettlingTracker stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference viewRef;

    static {
        BottomSheetBehavior.DEF_STYLE_RES = style.Widget_Design_BottomSheet_Modal;
    }

    public BottomSheetBehavior() {
        super();
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.callbacks = new ArrayList();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new com.google.android.material.bottomsheet.BottomSheetBehavior$5(this);
    }

    public BottomSheetBehavior(Context arg9, AttributeSet arg10) {
        super(arg9, arg10);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        int v2 = -1;
        this.maxWidth = v2;
        this.maxHeight = v2;
        this.stateSettlingTracker = new StateSettlingTracker(this, null);
        float v3 = 0.5f;
        this.halfExpandedRatio = v3;
        float v4 = -1f;
        this.elevation = v4;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.callbacks = new ArrayList();
        this.initialY = v2;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new com.google.android.material.bottomsheet.BottomSheetBehavior$5(this);
        this.peekHeightGestureInsetBuffer = arg9.getResources().getDimensionPixelSize(dimen.mtrl_min_touch_target_size);
        TypedArray v5 = arg9.obtainStyledAttributes(arg10, styleable.BottomSheetBehavior_Layout);
        if(v5.hasValue(styleable.BottomSheetBehavior_Layout_backgroundTint)) {
            this.backgroundTint = MaterialResources.getColorStateList(arg9, v5, styleable.BottomSheetBehavior_Layout_backgroundTint);
        }

        if(v5.hasValue(styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(arg9, arg10, attr.bottomSheetStyle, BottomSheetBehavior.DEF_STYLE_RES).build();
        }

        this.createMaterialShapeDrawableIfNeeded(arg9);
        this.createShapeValueAnimator();
        this.elevation = v5.getDimension(styleable.BottomSheetBehavior_Layout_android_elevation, v4);
        if(v5.hasValue(styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            this.setMaxWidth(v5.getDimensionPixelSize(styleable.BottomSheetBehavior_Layout_android_maxWidth, v2));
        }

        if(v5.hasValue(styleable.BottomSheetBehavior_Layout_android_maxHeight)) {
            this.setMaxHeight(v5.getDimensionPixelSize(styleable.BottomSheetBehavior_Layout_android_maxHeight, v2));
        }

        TypedValue v10 = v5.peekValue(styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if(v10 == null || v10.data != v2) {
            this.setPeekHeight(v5.getDimensionPixelSize(styleable.BottomSheetBehavior_Layout_behavior_peekHeight, v2));
        }
        else {
            this.setPeekHeight(v10.data);
        }

        this.setHideable(v5.getBoolean(styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.setGestureInsetBottomIgnored(v5.getBoolean(styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        this.setFitToContents(v5.getBoolean(styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        this.setSkipCollapsed(v5.getBoolean(styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        this.setDraggable(v5.getBoolean(styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        this.setSaveFlags(v5.getInt(styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        this.setHalfExpandedRatio(v5.getFloat(styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, v3));
        v10 = v5.peekValue(styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if(v10 == null || v10.type != 16) {
            this.setExpandedOffset(v5.getDimensionPixelOffset(styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        else {
            this.setExpandedOffset(v10.data);
        }

        this.setSignificantVelocityThreshold(v5.getInt(styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.paddingBottomSystemWindowInsets = v5.getBoolean(styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = v5.getBoolean(styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = v5.getBoolean(styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = v5.getBoolean(styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = v5.getBoolean(styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = v5.getBoolean(styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = v5.getBoolean(styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.shouldRemoveExpandedCorners = v5.getBoolean(styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        v5.recycle();
        this.maximumVelocity = ((float)ViewConfiguration.get(arg9).getScaledMaximumFlingVelocity());
    }

    static void access$100(BottomSheetBehavior arg0, View arg1, int arg2, boolean arg3) {
        arg0.startSettling(arg1, arg2, arg3);
    }

    static boolean access$1000(BottomSheetBehavior arg0) {
        return arg0.marginTopSystemWindowInsets;
    }

    static int access$1102(BottomSheetBehavior arg0, int arg1) {
        arg0.gestureInsetBottom = arg1;
        return arg1;
    }

    static void access$1200(BottomSheetBehavior arg0, boolean arg1) {
        arg0.updatePeekHeight(arg1);
    }

    static boolean access$1300(BottomSheetBehavior arg0) {
        return arg0.draggable;
    }

    static boolean access$1400(BottomSheetBehavior arg0) {
        return arg0.fitToContents;
    }

    static int access$1500(BottomSheetBehavior arg0) {
        return arg0.significantVelocityThreshold;
    }

    static boolean access$1600(BottomSheetBehavior arg0) {
        return arg0.canBeHiddenByDragging();
    }

    static int access$1900(BottomSheetBehavior arg0) {
        return arg0.peekHeight;
    }

    static MaterialShapeDrawable access$200(BottomSheetBehavior arg0) {
        return arg0.materialShapeDrawable;
    }

    static boolean access$2000(BottomSheetBehavior arg0) {
        return arg0.skipCollapsed;
    }

    static int access$302(BottomSheetBehavior arg0, int arg1) {
        arg0.insetTop = arg1;
        return arg1;
    }

    static boolean access$400(BottomSheetBehavior arg0) {
        return arg0.paddingBottomSystemWindowInsets;
    }

    static int access$500(BottomSheetBehavior arg0) {
        return arg0.insetBottom;
    }

    static int access$502(BottomSheetBehavior arg0, int arg1) {
        arg0.insetBottom = arg1;
        return arg1;
    }

    static boolean access$600(BottomSheetBehavior arg0) {
        return arg0.paddingLeftSystemWindowInsets;
    }

    static boolean access$700(BottomSheetBehavior arg0) {
        return arg0.paddingRightSystemWindowInsets;
    }

    static boolean access$800(BottomSheetBehavior arg0) {
        return arg0.marginLeftSystemWindowInsets;
    }

    static boolean access$900(BottomSheetBehavior arg0) {
        return arg0.marginRightSystemWindowInsets;
    }

    private int addAccessibilityActionForState(View arg2, int arg3, int arg4) {
        return ViewCompat.addAccessibilityAction(arg2, arg2.getResources().getString(arg3), this.createAccessibilityViewCommandForState(arg4));
    }

    public void addBottomSheetCallback(BottomSheetCallback arg2) {
        if(!this.callbacks.contains(arg2)) {
            this.callbacks.add(arg2);
        }
    }

    private void calculateCollapsedOffset() {
        int v0 = this.calculatePeekHeight();
        boolean v1 = this.fitToContents;
        int v2 = this.parentHeight;
        if(v1) {
            this.collapsedOffset = Math.max(v2 - v0, this.fitToContentsOffset);
            return;
        }

        this.collapsedOffset = v2 - v0;
    }

    private float calculateCornerInterpolation(float arg2, RoundedCorner arg3) {
        if(arg3 != null) {
            float v3 = ((float)arg3.getRadius());
            if(v3 > 0f && arg2 > 0f) {
                return v3 / arg2;
            }
        }

        return 0;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = ((int)((((float)this.parentHeight)) * (1f - this.halfExpandedRatio)));
    }

    private float calculateInterpolationWithCornersRemoved() {
        if(this.materialShapeDrawable != null) {
            WeakReference v0 = this.viewRef;
            if(v0 != null && v0.get() != null && Build$VERSION.SDK_INT >= 0x1F) {
                Object v0_1 = this.viewRef.get();
                if(this.isAtTopOfScreen()) {
                    WindowInsets v0_2 = ((View)v0_1).getRootWindowInsets();
                    if(v0_2 != null) {
                        return Math.max(this.calculateCornerInterpolation(this.materialShapeDrawable.getTopLeftCornerResolvedSize(), v0_2.getRoundedCorner(0)), this.calculateCornerInterpolation(this.materialShapeDrawable.getTopRightCornerResolvedSize(), v0_2.getRoundedCorner(1)));
                    }
                }
            }
        }

        return 0;
    }

    private int calculatePeekHeight() {
        int v3;
        int v0;
        if(this.peekHeightAuto) {
            v0 = Math.min(Math.max(this.peekHeightMin, this.parentHeight - this.parentWidth * 9 / 16), this.childHeight);
            v3 = this.insetBottom;
        }
        else {
            if(!this.gestureInsetBottomIgnored && !this.paddingBottomSystemWindowInsets) {
                v0 = this.gestureInsetBottom;
                if(v0 > 0) {
                    return Math.max(this.peekHeight, v0 + this.peekHeightGestureInsetBuffer);
                }
            }

            v0 = this.peekHeight;
            v3 = this.insetBottom;
        }

        return v0 + v3;
    }

    public float calculateSlideOffset() {
        WeakReference v0 = this.viewRef;
        if(v0 != null) {
            if(v0.get() == null) {
            }
            else {
                return this.calculateSlideOffsetWithTop(this.viewRef.get().getTop());
            }
        }

        return -1f;
    }

    private float calculateSlideOffsetWithTop(int arg3) {
        float v2;
        float v3;
        int v0 = this.collapsedOffset;
        if(arg3 > v0 || v0 == this.getExpandedOffset()) {
            v3 = ((float)(this.collapsedOffset - arg3));
            v2 = ((float)(this.parentHeight - this.collapsedOffset));
        }
        else {
            v3 = ((float)(this.collapsedOffset - arg3));
            v2 = ((float)(this.collapsedOffset - this.getExpandedOffset()));
        }

        return v3 / v2;
    }

    private boolean canBeHiddenByDragging() {
        if((this.isHideable()) && (this.isHideableWhenDragging())) {
            return 1;
        }

        return 0;
    }

    public void cancelBackProgress() {
        MaterialBottomContainerBackHelper v0 = this.bottomContainerBackHelper;
        if(v0 == null) {
            return;
        }

        v0.cancelBackProgress();
    }

    private void clearAccessibilityAction(View arg3, int arg4) {
        if(arg3 == null) {
        }
        else {
            ViewCompat.removeAccessibilityAction(arg3, 0x80000);
            ViewCompat.removeAccessibilityAction(arg3, 0x40000);
            ViewCompat.removeAccessibilityAction(arg3, 0x100000);
            int v0 = this.expandHalfwayActionIds.get(arg4, -1);
            if(v0 != -1) {
                ViewCompat.removeAccessibilityAction(arg3, v0);
                this.expandHalfwayActionIds.delete(arg4);
            }
        }
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(int arg2) {
        return new AccessibilityViewCommand(arg2) {
            public boolean perform(View arg1, CommandArguments arg2) {
                BottomSheetBehavior.this.setState(this.val$state);
                return 1;
            }
        };
    }

    private void createMaterialShapeDrawableIfNeeded(Context arg4) {
        if(this.shapeAppearanceModelDefault == null) {
            return;
        }

        MaterialShapeDrawable v0 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
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

    private void createShapeValueAnimator() {
        ValueAnimator v0 = ValueAnimator.ofFloat(new float[]{this.calculateInterpolationWithCornersRemoved(), 1f});
        this.interpolatorAnimator = v0;
        v0.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator$AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator arg2) {
                float v2 = arg2.getAnimatedValue().floatValue();
                if(BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(v2);
                }
            }
        });
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    void dispatchOnSlide(int arg4) {
        Object v0 = this.viewRef.get();
        if(v0 != null && !this.callbacks.isEmpty()) {
            float v4 = this.calculateSlideOffsetWithTop(arg4);
            int v1;
            for(v1 = 0; v1 < this.callbacks.size(); ++v1) {
                this.callbacks.get(v1).onSlide(((View)v0), v4);
            }
        }
    }

    View findScrollingChild(View arg5) {
        View v1 = null;
        if(arg5.getVisibility() != 0) {
            return v1;
        }

        if(ViewCompat.isNestedScrollingEnabled(arg5)) {
            return arg5;
        }

        if((arg5 instanceof ViewGroup)) {
            int v0 = ((ViewGroup)arg5).getChildCount();
            int v2 = 0;
            while(v2 < v0) {
                View v3 = this.findScrollingChild(((ViewGroup)arg5).getChildAt(v2));
                if(v3 != null) {
                    return v3;
                }
                else {
                    ++v2;
                    continue;
                }

                return v1;
            }
        }

        return v1;
    }

    public static BottomSheetBehavior from(View arg1) {
        ViewGroup$LayoutParams v1 = arg1.getLayoutParams();
        if((v1 instanceof LayoutParams)) {
            Behavior v1_1 = ((LayoutParams)v1).getBehavior();
            if((v1_1 instanceof BottomSheetBehavior)) {
                return ((BottomSheetBehavior)v1_1);
            }

            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }

        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    MaterialBottomContainerBackHelper getBackHelper() {
        return this.bottomContainerBackHelper;
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

    public int getExpandedOffset() {
        if(this.fitToContents) {
            return this.fitToContentsOffset;
        }

        int v0 = this.expandedOffset;
        int v2 = this.paddingTopSystemWindowInsets ? 0 : this.insetTop;
        return Math.max(v0, v2);
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if(this.peekHeightAuto) {
            return -1;
        }

        return this.peekHeight;
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public int getSignificantVelocityThreshold() {
        return this.significantVelocityThreshold;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    private int getTopOffsetForState(int arg3) {
        if(arg3 != 3) {
            if(arg3 != 4) {
                if(arg3 != 5) {
                    if(arg3 == 6) {
                        return this.halfExpandedOffset;
                    }

                    throw new IllegalArgumentException("Invalid state to get top offset: " + arg3);
                }

                return this.parentHeight;
            }

            return this.collapsedOffset;
        }

        return this.getExpandedOffset();
    }

    private float getYVelocity() {
        VelocityTracker v0 = this.velocityTracker;
        if(v0 == null) {
            return 0;
        }

        v0.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    public void handleBackInvoked() {
        MaterialBottomContainerBackHelper v0 = this.bottomContainerBackHelper;
        if(v0 == null) {
            return;
        }

        BackEventCompat v0_1 = v0.onHandleBackInvoked();
        int v1 = 4;
        if(v0_1 != null) {
            if(Build$VERSION.SDK_INT < 34) {
            }
            else {
                boolean v2 = this.hideable;
                MaterialBottomContainerBackHelper v3 = this.bottomContainerBackHelper;
                if(v2) {
                    v3.finishBackProgressNotPersistent(v0_1, new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator arg2) {
                            BottomSheetBehavior.this.setStateInternal(5);
                            if(BottomSheetBehavior.this.viewRef != null && BottomSheetBehavior.this.viewRef.get() != null) {
                                BottomSheetBehavior.this.viewRef.get().requestLayout();
                            }
                        }
                    });
                    return;
                }
                else {
                    v3.finishBackProgressPersistent(v0_1, null);
                    this.setState(v1);
                    return;
                }
            }
        }

        if(this.hideable) {
            v1 = 5;
        }

        this.setState(v1);
    }

    private boolean isAtTopOfScreen() {
        WeakReference v0 = this.viewRef;
        if(v0 != null) {
            if(v0.get() == null) {
            }
            else {
                int[] v0_1 = new int[2];
                this.viewRef.get().getLocationOnScreen(v0_1);
                if(v0_1[1] == 0) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    private boolean isExpandedAndShouldRemoveCorners() {
        if(this.state == 3 && ((this.shouldRemoveExpandedCorners) || (this.isAtTopOfScreen()))) {
            return 1;
        }

        return 0;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public boolean isHideableWhenDragging() {
        return 1;
    }

    private boolean isLayouting(View arg1) {
        ViewParent v0 = arg1.getParent();
        if(v0 != null && (v0.isLayoutRequested()) && (ViewCompat.isAttachedToWindow(arg1))) {
            return 1;
        }

        return 0;
    }

    public boolean isNestedScrollingCheckEnabled() {
        return 1;
    }

    public boolean isShouldRemoveExpandedCorners() {
        return this.shouldRemoveExpandedCorners;
    }

    public void onAttachedToLayoutParams(LayoutParams arg1) {
        super.onAttachedToLayoutParams(arg1);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout arg10, View arg11, MotionEvent arg12) {
        if(arg11.isShown()) {
            if(!this.draggable) {
            }
            else {
                int v0 = arg12.getActionMasked();
                if(v0 == 0) {
                    this.reset();
                }

                VelocityTracker v3 = this.velocityTracker;
                if(v3 == null) {
                    v3 = VelocityTracker.obtain();
                    this.velocityTracker = v3;
                }

                v3.addMovement(arg12);
                Object v3_1 = null;
                int v4 = 2;
                int v5 = -1;
                if(v0 != 0) {
                    if(v0 != 1 && v0 != 3) {
                        goto label_58;
                    }

                    this.touchingScrollingChild = false;
                    this.activePointerId = v5;
                    if(!this.ignoreEvents) {
                        goto label_58;
                    }

                    this.ignoreEvents = false;
                    return 0;
                }
                else {
                    int v6 = ((int)arg12.getX());
                    this.initialY = ((int)arg12.getY());
                    if(this.state != v4) {
                        WeakReference v7 = this.nestedScrollingChildRef;
                        Object v7_1 = v7 != null ? v7.get() : v3_1;
                        if(v7_1 == null) {
                            goto label_49;
                        }

                        if(!arg10.isPointInChildBounds(((View)v7_1), v6, this.initialY)) {
                            goto label_49;
                        }

                        this.activePointerId = arg12.getPointerId(arg12.getActionIndex());
                        this.touchingScrollingChild = true;
                    }

                label_49:
                    boolean v11 = this.activePointerId != v5 || (arg10.isPointInChildBounds(arg11, v6, this.initialY)) ? false : true;
                    this.ignoreEvents = v11;
                }

            label_58:
                if(!this.ignoreEvents) {
                    ViewDragHelper v11_1 = this.viewDragHelper;
                    if(v11_1 != null && (v11_1.shouldInterceptTouchEvent(arg12))) {
                        return 1;
                    }
                }

                WeakReference v11_2 = this.nestedScrollingChildRef;
                if(v11_2 != null) {
                    v3_1 = v11_2.get();
                }

                if(v0 == v4 && v3_1 != null && !this.ignoreEvents && this.state != 1 && !arg10.isPointInChildBounds(((View)v3_1), ((int)arg12.getX()), ((int)arg12.getY())) && this.viewDragHelper != null) {
                    int v10 = this.initialY;
                    if(v10 != v5 && Math.abs((((float)v10)) - arg12.getY()) > (((float)this.viewDragHelper.getTouchSlop()))) {
                        return 1;
                    }
                }

                return 0;
            }
        }

        this.ignoreEvents = true;
        return 0;
    }

    public boolean onLayoutChild(CoordinatorLayout arg6, View arg7, int arg8) {
        if((ViewCompat.getFitsSystemWindows(((View)arg6))) && !ViewCompat.getFitsSystemWindows(arg7)) {
            arg7.setFitsSystemWindows(true);
        }

        if(this.viewRef == null) {
            this.peekHeightMin = arg6.getResources().getDimensionPixelSize(dimen.design_bottom_sheet_peek_height_min);
            this.setWindowInsetsListener(arg7);
            ViewCompat.setWindowInsetsAnimationCallback(arg7, new InsetsAnimationCallback(arg7));
            this.viewRef = new WeakReference(arg7);
            this.bottomContainerBackHelper = new MaterialBottomContainerBackHelper(arg7);
            MaterialShapeDrawable v0 = this.materialShapeDrawable;
            if(v0 != null) {
                ViewCompat.setBackground(arg7, ((Drawable)v0));
                v0 = this.materialShapeDrawable;
                float v2 = this.elevation;
                if(v2 == -1f) {
                    v2 = ViewCompat.getElevation(arg7);
                }

                v0.setElevation(v2);
            }
            else {
                ColorStateList v0_1 = this.backgroundTint;
                if(v0_1 == null) {
                    goto label_35;
                }

                ViewCompat.setBackgroundTintList(arg7, v0_1);
            }

        label_35:
            this.updateAccessibilityActions();
            if(ViewCompat.getImportantForAccessibility(arg7) != 0) {
                goto label_39;
            }

            ViewCompat.setImportantForAccessibility(arg7, 1);
        }

    label_39:
        if(this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(((ViewGroup)arg6), this.dragCallback);
        }

        int v0_2 = arg7.getTop();
        arg6.onLayoutChild(arg7, arg8);
        this.parentWidth = arg6.getWidth();
        this.parentHeight = arg6.getHeight();
        int v6 = arg7.getHeight();
        this.childHeight = v6;
        arg8 = this.parentHeight;
        int v3 = this.insetTop;
        if(arg8 - v6 < v3) {
            boolean v6_1 = this.paddingTopSystemWindowInsets;
            int v2_1 = this.maxHeight;
            int v4 = -1;
            if(v6_1) {
                v6 = v2_1 == v4 ? arg8 : Math.min(arg8, v2_1);
                this.childHeight = v6;
            }
            else {
                arg8 -= v3;
                v6 = v2_1 == v4 ? arg8 : Math.min(arg8, v2_1);
                this.childHeight = v6;
            }
        }

        arg8 = this.parentHeight - v6;
        v6 = 0;
        this.fitToContentsOffset = Math.max(0, arg8);
        this.calculateHalfExpandedOffset();
        this.calculateCollapsedOffset();
        arg8 = this.state;
        if(arg8 == 3) {
            ViewCompat.offsetTopAndBottom(arg7, this.getExpandedOffset());
        }
        else if(arg8 == 6) {
            ViewCompat.offsetTopAndBottom(arg7, this.halfExpandedOffset);
        }
        else {
            if((this.hideable) && arg8 == 5) {
                ViewCompat.offsetTopAndBottom(arg7, this.parentHeight);
                goto label_108;
            }

            if(arg8 == 4) {
                ViewCompat.offsetTopAndBottom(arg7, this.collapsedOffset);
                goto label_108;
            }

            if(arg8 != 1 && arg8 != 2) {
                goto label_108;
            }

            ViewCompat.offsetTopAndBottom(arg7, v0_2 - arg7.getTop());
        }

    label_108:
        this.updateDrawableForTargetState(this.state, false);
        this.nestedScrollingChildRef = new WeakReference(this.findScrollingChild(arg7));
        while(v6 < this.callbacks.size()) {
            this.callbacks.get(v6).onLayout(arg7);
            ++v6;
        }

        return 1;
    }

    public boolean onMeasureChild(CoordinatorLayout arg4, View arg5, int arg6, int arg7, int arg8, int arg9) {
        ViewGroup$LayoutParams v0 = arg5.getLayoutParams();
        arg5.measure(this.getChildMeasureSpec(arg6, arg4.getPaddingLeft() + arg4.getPaddingRight() + ((ViewGroup$MarginLayoutParams)v0).leftMargin + ((ViewGroup$MarginLayoutParams)v0).rightMargin + arg7, this.maxWidth, ((ViewGroup$MarginLayoutParams)v0).width), this.getChildMeasureSpec(arg8, arg4.getPaddingTop() + arg4.getPaddingBottom() + ((ViewGroup$MarginLayoutParams)v0).topMargin + ((ViewGroup$MarginLayoutParams)v0).bottomMargin + arg9, this.maxHeight, ((ViewGroup$MarginLayoutParams)v0).height));
        return 1;
    }

    public boolean onNestedPreFling(CoordinatorLayout arg4, View arg5, View arg6, float arg7, float arg8) {
        if(this.isNestedScrollingCheckEnabled()) {
            WeakReference v0 = this.nestedScrollingChildRef;
            if(v0 != null && arg6 == v0.get()) {
                if(this.state == 3 && !super.onNestedPreFling(arg4, arg5, arg6, arg7, arg8)) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public void onNestedPreScroll(CoordinatorLayout arg2, View arg3, View arg4, int arg5, int arg6, int[] arg7, int arg8) {
        if(arg8 == 1) {
        }
        else {
            WeakReference v5 = this.nestedScrollingChildRef;
            if(v5 != null) {
                Object v5_1 = v5.get();
            }
            else {
                View v5_2 = null;
            }

            if((this.isNestedScrollingCheckEnabled()) && arg4 != (((View)v5_1))) {
                return;
            }

            arg5 = arg3.getTop();
            arg8 = arg5 - arg6;
            if(arg6 > 0) {
                if(arg8 < this.getExpandedOffset()) {
                    arg5 -= this.getExpandedOffset();
                    arg7[1] = arg5;
                    ViewCompat.offsetTopAndBottom(arg3, -arg5);
                    this.setStateInternal(3);
                }
                else if(!this.draggable) {
                    return;
                }
                else {
                    arg7[1] = arg6;
                    ViewCompat.offsetTopAndBottom(arg3, -arg6);
                    this.setStateInternal(1);
                }
            }
            else if(arg6 < 0 && !arg4.canScrollVertically(-1)) {
                if(arg8 > this.collapsedOffset) {
                    if(this.canBeHiddenByDragging()) {
                    }
                    else {
                        arg5 -= this.collapsedOffset;
                        arg7[1] = arg5;
                        ViewCompat.offsetTopAndBottom(arg3, -arg5);
                        this.setStateInternal(4);
                        goto label_57;
                    }
                }

                if(this.draggable) {
                    goto label_53;
                }

                return;
            }

            goto label_57;
        }

        return;
    label_53:
        arg7[1] = arg6;
        ViewCompat.offsetTopAndBottom(arg3, -arg6);
        this.setStateInternal(1);
    label_57:
        this.dispatchOnSlide(arg3.getTop());
        this.lastNestedScrollDy = arg6;
        this.nestedScrolled = true;
    }

    public void onNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int[] arg9) {
    }

    public void onRestoreInstanceState(CoordinatorLayout arg2, View arg3, Parcelable arg4) {
        super.onRestoreInstanceState(arg2, arg3, ((SavedState)arg4).getSuperState());
        this.restoreOptionalState(((SavedState)arg4));
        if(((SavedState)arg4).state != 1) {
            if(((SavedState)arg4).state == 2) {
            }
            else {
                int v2 = ((SavedState)arg4).state;
                this.state = v2;
                this.lastStableState = v2;
                return;
            }
        }

        this.state = 4;
        this.lastStableState = 4;
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout arg2, View arg3) {
        return new SavedState(super.onSaveInstanceState(arg2, arg3), this);
    }

    public boolean onStartNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, View arg4, int arg5, int arg6) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if((arg5 & 2) != 0) {
            return 1;
        }

        return 0;
    }

    public void onStopNestedScroll(CoordinatorLayout arg3, View arg4, View arg5, int arg6) {
        int v3_1;
        int v0 = 3;
        if(arg4.getTop() == this.getExpandedOffset()) {
            this.setStateInternal(v0);
            return;
        }

        if(this.isNestedScrollingCheckEnabled()) {
            WeakReference v3 = this.nestedScrollingChildRef;
            if(v3 != null && arg5 == v3.get() && (this.nestedScrolled)) {
                goto label_15;
            }

            return;
        }

    label_15:
        int v5 = 6;
        if(this.lastNestedScrollDy <= 0) {
            if((this.hideable) && (this.shouldHide(arg4, this.getYVelocity()))) {
                v0 = 5;
                goto label_76;
            }

            arg6 = 4;
            if(this.lastNestedScrollDy == 0) {
                v3_1 = arg4.getTop();
                if(!this.fitToContents) {
                    int v1 = this.halfExpandedOffset;
                    if(v3_1 < v1) {
                        if(v3_1 < Math.abs(v3_1 - this.collapsedOffset)) {
                            goto label_76;
                        }
                        else if(this.shouldSkipHalfExpandedStateWhenDragging()) {
                        }
                        else {
                            goto label_75;
                        }
                    }
                    else if(Math.abs(v3_1 - v1) < Math.abs(v3_1 - this.collapsedOffset)) {
                        goto label_75;
                    }
                }
                else if(Math.abs(v3_1 - this.fitToContentsOffset) < Math.abs(v3_1 - this.collapsedOffset)) {
                    goto label_76;
                }
            }
            else if(!this.fitToContents) {
                v3_1 = arg4.getTop();
                if(Math.abs(v3_1 - this.halfExpandedOffset) < Math.abs(v3_1 - this.collapsedOffset)) {
                label_75:
                    v0 = v5;
                    goto label_76;
                }
            }

            v0 = arg6;
        }
        else if(this.fitToContents) {
        }
        else if(arg4.getTop() > this.halfExpandedOffset) {
            goto label_75;
        }

    label_76:
        this.startSettling(arg4, v0, false);
        this.nestedScrolled = false;
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
            this.reset();
        }

        VelocityTracker v0 = this.velocityTracker;
        if(v0 == null) {
            v0 = VelocityTracker.obtain();
            this.velocityTracker = v0;
        }

        v0.addMovement(arg5);
        if((this.shouldHandleDraggingWithHelper()) && v3 == 2 && !this.ignoreEvents && Math.abs((((float)this.initialY)) - arg5.getY()) > (((float)this.viewDragHelper.getTouchSlop()))) {
            this.viewDragHelper.captureChildView(arg4, arg5.getPointerId(arg5.getActionIndex()));
        }

        return this.ignoreEvents ^ 1;
    }

    public void removeBottomSheetCallback(BottomSheetCallback arg1) {
        this.callbacks.remove(arg1);
    }

    private void replaceAccessibilityActionForState(View arg2, AccessibilityActionCompat arg3, int arg4) {
        ViewCompat.replaceAccessibilityAction(arg2, arg3, null, this.createAccessibilityViewCommandForState(arg4));
    }

    private void reset() {
        this.activePointerId = -1;
        this.initialY = -1;
        VelocityTracker v0 = this.velocityTracker;
        if(v0 != null) {
            v0.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState arg4) {
        int v0 = this.saveFlags;
        if(v0 == 0) {
        }
        else {
            int v1 = -1;
            if(v0 == v1 || (v0 & 1) == 1) {
                this.peekHeight = arg4.peekHeight;
            }

            v0 = this.saveFlags;
            if(v0 == v1 || (v0 & 2) == 2) {
                this.fitToContents = arg4.fitToContents;
            }

            v0 = this.saveFlags;
            if(v0 == v1 || (v0 & 4) == 4) {
                this.hideable = arg4.hideable;
            }

            v0 = this.saveFlags;
            if(v0 != v1) {
                if((v0 & 8) == 8) {
                }
                else {
                    return;
                }
            }

            goto label_31;
        }

        return;
    label_31:
        this.skipCollapsed = arg4.skipCollapsed;
    }

    private void runAfterLayout(View arg1, Runnable arg2) {
        if(this.isLayouting(arg1)) {
            arg1.post(arg2);
            return;
        }

        arg2.run();
    }

    void setAccessibilityDelegateView(View arg3) {
        if(arg3 == null) {
            WeakReference v1 = this.accessibilityDelegateViewRef;
            if(v1 != null) {
                this.clearAccessibilityAction(v1.get(), 1);
                this.accessibilityDelegateViewRef = null;
                return;
            }
        }

        this.accessibilityDelegateViewRef = new WeakReference(arg3);
        this.updateAccessibilityActions(arg3, 1);
    }

    @Deprecated public void setBottomSheetCallback(BottomSheetCallback arg3) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if(arg3 != null) {
            this.callbacks.add(arg3);
        }
    }

    public void setDraggable(boolean arg1) {
        this.draggable = arg1;
    }

    public void setExpandedOffset(int arg2) {
        if(arg2 >= 0) {
            this.expandedOffset = arg2;
            this.updateDrawableForTargetState(this.state, true);
            return;
        }

        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean arg2) {
        if(this.fitToContents == arg2) {
            return;
        }

        this.fitToContents = arg2;
        if(this.viewRef != null) {
            this.calculateCollapsedOffset();
        }

        int v2 = !this.fitToContents || this.state != 6 ? this.state : 3;
        this.setStateInternal(v2);
        this.updateDrawableForTargetState(this.state, true);
        this.updateAccessibilityActions();
    }

    public void setGestureInsetBottomIgnored(boolean arg1) {
        this.gestureInsetBottomIgnored = arg1;
    }

    public void setHalfExpandedRatio(float arg2) {
        if(arg2 > 0f && arg2 < 1f) {
            this.halfExpandedRatio = arg2;
            if(this.viewRef != null) {
                this.calculateHalfExpandedOffset();
            }

            return;
        }

        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideFriction(float arg1) {
        this.hideFriction = arg1;
    }

    public void setHideable(boolean arg2) {
        if(this.hideable != arg2) {
            this.hideable = arg2;
            if(!arg2 && this.state == 5) {
                this.setState(4);
            }

            this.updateAccessibilityActions();
        }
    }

    public void setHideableInternal(boolean arg1) {
        this.hideable = arg1;
    }

    public void setMaxHeight(int arg1) {
        this.maxHeight = arg1;
    }

    public void setMaxWidth(int arg1) {
        this.maxWidth = arg1;
    }

    public void setPeekHeight(int arg2) {
        this.setPeekHeight(arg2, false);
    }

    public final void setPeekHeight(int arg3, boolean arg4) {
        boolean v0 = this.peekHeightAuto;
        if(arg3 != -1) {
            if(!v0) {
                if(this.peekHeight != arg3) {
                }
                else {
                    return;
                }
            }

            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, arg3);
        }
        else if(!v0) {
            this.peekHeightAuto = true;
        }
        else {
            return;
        }

        this.updatePeekHeight(arg4);
    }

    public void setSaveFlags(int arg1) {
        this.saveFlags = arg1;
    }

    public void setShouldRemoveExpandedCorners(boolean arg2) {
        if(this.shouldRemoveExpandedCorners != arg2) {
            this.shouldRemoveExpandedCorners = arg2;
            this.updateDrawableForTargetState(this.getState(), true);
        }
    }

    public void setSignificantVelocityThreshold(int arg1) {
        this.significantVelocityThreshold = arg1;
    }

    public void setSkipCollapsed(boolean arg1) {
        this.skipCollapsed = arg1;
    }

    public void setState(int arg4) {
        if(arg4 != 1) {
            if(arg4 == 2) {
            }
            else {
                if(!this.hideable && arg4 == 5) {
                    Log.w("BottomSheetBehavior", "Cannot set state: " + arg4);
                    return;
                }

                int v0 = arg4 != 6 || !this.fitToContents || this.getTopOffsetForState(arg4) > this.fitToContentsOffset ? arg4 : 3;
                WeakReference v1 = this.viewRef;
                if(v1 != null) {
                    if(v1.get() == null) {
                    }
                    else {
                        Object v4 = this.viewRef.get();
                        this.runAfterLayout(((View)v4), new Runnable(((View)v4), v0) {
                            public void run() {
                                BottomSheetBehavior.this.startSettling(this.val$child, this.val$finalState, false);
                            }
                        });
                        return;
                    }
                }

                this.setStateInternal(arg4);
                return;
            }
        }

        StringBuilder v1_1 = new StringBuilder("STATE_");
        String v4_1 = arg4 == 1 ? "DRAGGING" : "SETTLING";
        throw new IllegalArgumentException(v1_1.append(v4_1).append(" should not be set externally.").toString());
    }

    void setStateInternal(int arg8) {
        Object v4_1;
        if(this.state == arg8) {
        }
        else {
            this.state = arg8;
            int v0 = 5;
            int v1 = 6;
            int v2 = 3;
            int v3 = 4;
            if(arg8 == v3 || arg8 == v2 || arg8 == v1 || (this.hideable) && arg8 == v0) {
                this.lastStableState = arg8;
            }

            WeakReference v4 = this.viewRef;
            if(v4 == null) {
                return;
            }

            v4_1 = v4.get();
            if(v4_1 != null) {
                goto label_21;
            }
        }

        return;
    label_21:
        int v5 = 0;
        if(arg8 == v2) {
            this.updateImportantForAccessibility(true);
        }
        else {
            if(arg8 != v1 && arg8 != v0 && arg8 != v3) {
                goto label_30;
            }

            this.updateImportantForAccessibility(false);
        }

    label_30:
        this.updateDrawableForTargetState(arg8, true);
        while(v5 < this.callbacks.size()) {
            this.callbacks.get(v5).onStateChanged(((View)v4_1), arg8);
            ++v5;
        }

        this.updateAccessibilityActions();
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean arg1) {
        this.updateImportantForAccessibilityOnSiblings = arg1;
    }

    private void setWindowInsetsListener(View arg3) {
        boolean v0 = Build$VERSION.SDK_INT < 29 || (this.isGestureInsetBottomIgnored()) || (this.peekHeightAuto) ? false : true;
        if(!this.paddingBottomSystemWindowInsets && !this.paddingLeftSystemWindowInsets && !this.paddingRightSystemWindowInsets && !this.marginLeftSystemWindowInsets && !this.marginRightSystemWindowInsets && !this.marginTopSystemWindowInsets && !v0) {
            return;
        }

        ViewUtils.doOnApplyWindowInsets(arg3, new OnApplyWindowInsetsListener(v0) {
            public WindowInsetsCompat onApplyWindowInsets(View arg11, WindowInsetsCompat arg12, RelativePadding arg13) {
                int v2_1;
                Insets v0 = arg12.getInsets(Type.systemBars());
                Insets v1 = arg12.getInsets(Type.mandatorySystemGestures());
                BottomSheetBehavior.this.insetTop = v0.top;
                boolean v2 = ViewUtils.isLayoutRtl(arg11);
                int v3 = arg11.getPaddingBottom();
                int v4 = arg11.getPaddingLeft();
                int v5 = arg11.getPaddingRight();
                if(BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                    BottomSheetBehavior.this.insetBottom = arg12.getSystemWindowInsetBottom();
                    v3 = arg13.bottom + BottomSheetBehavior.this.insetBottom;
                }

                if(BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                    v4 = v2 ? arg13.end : arg13.start;
                    v4 += v0.left;
                }

                if(BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                    int v13 = v2 ? arg13.start : arg13.end;
                    v5 = v13 + v0.right;
                }

                ViewGroup$LayoutParams v13_1 = arg11.getLayoutParams();
                int v7 = 1;
                if(!BottomSheetBehavior.this.marginLeftSystemWindowInsets || ((ViewGroup$MarginLayoutParams)v13_1).leftMargin == v0.left) {
                    v2_1 = 0;
                }
                else {
                    ((ViewGroup$MarginLayoutParams)v13_1).leftMargin = v0.left;
                    v2_1 = 1;
                }

                if((BottomSheetBehavior.this.marginRightSystemWindowInsets) && ((ViewGroup$MarginLayoutParams)v13_1).rightMargin != v0.right) {
                    ((ViewGroup$MarginLayoutParams)v13_1).rightMargin = v0.right;
                    v2_1 = 1;
                }

                if(!BottomSheetBehavior.this.marginTopSystemWindowInsets || ((ViewGroup$MarginLayoutParams)v13_1).topMargin == v0.top) {
                    v7 = v2_1;
                }
                else {
                    ((ViewGroup$MarginLayoutParams)v13_1).topMargin = v0.top;
                }

                if(v7 != 0) {
                    arg11.setLayoutParams(v13_1);
                }

                arg11.setPadding(v4, arg11.getPaddingTop(), v5, v3);
                if(this.val$shouldHandleGestureInsets) {
                    BottomSheetBehavior.this.gestureInsetBottom = v1.bottom;
                }

                if(!BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                    if(this.val$shouldHandleGestureInsets) {
                    }
                    else {
                        return arg12;
                    }
                }

                BottomSheetBehavior.this.updatePeekHeight(false);
                return arg12;
            }
        });
    }

    public boolean shouldExpandOnUpwardDrag(long arg1, float arg3) {
        return 0;
    }

    private boolean shouldHandleDraggingWithHelper() {
        if(this.viewDragHelper != null && ((this.draggable) || this.state == 1)) {
            return 1;
        }

        return 0;
    }

    boolean shouldHide(View arg5, float arg6) {
        if(this.skipCollapsed) {
            return 1;
        }

        if(!this.isHideableWhenDragging()) {
            return 0;
        }

        if(arg5.getTop() < this.collapsedOffset) {
            return 0;
        }

        if(Math.abs((((float)arg5.getTop())) + arg6 * this.hideFriction - (((float)this.collapsedOffset))) / (((float)this.calculatePeekHeight())) > 0.5f) {
            return 1;
        }

        return 0;
    }

    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return 0;
    }

    public boolean shouldSkipSmoothAnimation() {
        return 1;
    }

    public void startBackProgress(BackEventCompat arg1) {
        MaterialBottomContainerBackHelper v0 = this.bottomContainerBackHelper;
        if(v0 == null) {
            return;
        }

        v0.startBackProgress(arg1);
    }

    private void startSettling(View arg3, int arg4, boolean arg5) {
        int v0 = this.getTopOffsetForState(arg4);
        ViewDragHelper v1 = this.viewDragHelper;
        if(v1 != null) {
            if(!arg5) {
                if(v1.smoothSlideViewTo(arg3, arg3.getLeft(), v0)) {
                    goto label_11;
                }

                goto label_18;
            }
            else if(v1.settleCapturedViewAt(arg3.getLeft(), v0)) {
            }
            else {
                goto label_18;
            }

        label_11:
            this.setStateInternal(2);
            this.updateDrawableForTargetState(arg4, true);
            this.stateSettlingTracker.continueSettlingToState(arg4);
            return;
        }

    label_18:
        this.setStateInternal(arg4);
    }

    private void updateAccessibilityActions() {
        WeakReference v0 = this.viewRef;
        if(v0 != null) {
            this.updateAccessibilityActions(v0.get(), 0);
        }

        v0 = this.accessibilityDelegateViewRef;
        if(v0 != null) {
            this.updateAccessibilityActions(v0.get(), 1);
        }
    }

    private void updateAccessibilityActions(View arg4, int arg5) {
        int v2;
        int v0;
        int v1;
        if(arg4 == null) {
        }
        else {
            this.clearAccessibilityAction(arg4, arg5);
            v1 = 6;
            if(!this.fitToContents && this.state != v1) {
                this.expandHalfwayActionIds.put(arg5, this.addAccessibilityActionForState(arg4, string.bottomsheet_action_expand_halfway, v1));
            }

            if((this.hideable) && (this.isHideableWhenDragging())) {
                v0 = 5;
                if(this.state != v0) {
                    this.replaceAccessibilityActionForState(arg4, AccessibilityActionCompat.ACTION_DISMISS, v0);
                }
            }

            arg5 = this.state;
            v0 = 4;
            v2 = 3;
            if(arg5 == v2) {
                goto label_39;
            }

            if(arg5 == v0) {
                goto label_33;
            }

            if(arg5 == v1) {
                goto label_28;
            }
        }

        return;
    label_28:
        this.replaceAccessibilityActionForState(arg4, AccessibilityActionCompat.ACTION_COLLAPSE, v0);
        this.replaceAccessibilityActionForState(arg4, AccessibilityActionCompat.ACTION_EXPAND, v2);
        return;
    label_33:
        if(this.fitToContents) {
            v1 = v2;
        }

        this.replaceAccessibilityActionForState(arg4, AccessibilityActionCompat.ACTION_EXPAND, v1);
        return;
    label_39:
        if(this.fitToContents) {
            v1 = v0;
        }

        this.replaceAccessibilityActionForState(arg4, AccessibilityActionCompat.ACTION_COLLAPSE, v1);
    }

    public void updateBackProgress(BackEventCompat arg1) {
        MaterialBottomContainerBackHelper v0 = this.bottomContainerBackHelper;
        if(v0 == null) {
            return;
        }

        v0.updateBackProgress(arg1);
    }

    private void updateDrawableForTargetState(int arg4, boolean arg5) {
        ValueAnimator v4_1;
        int v0 = 2;
        if(arg4 == v0) {
        }
        else {
            boolean v4 = this.isExpandedAndShouldRemoveCorners();
            if(this.expandedCornersRemoved != v4) {
                if(this.materialShapeDrawable == null) {
                }
                else {
                    this.expandedCornersRemoved = v4;
                    float v1 = 1f;
                    if(arg5) {
                        ValueAnimator v5 = this.interpolatorAnimator;
                        if(v5 != null) {
                            if(v5.isRunning()) {
                                this.interpolatorAnimator.reverse();
                                return;
                            }
                            else {
                                float v5_1 = this.materialShapeDrawable.getInterpolation();
                                if(v4) {
                                    v1 = this.calculateInterpolationWithCornersRemoved();
                                }

                                v4_1 = this.interpolatorAnimator;
                                float[] v0_1 = new float[v0];
                                v0_1[0] = v5_1;
                                v0_1[1] = v1;
                                v4_1.setFloatValues(v0_1);
                                this.interpolatorAnimator.start();
                                return;
                            }
                        }
                    }

                    v4_1 = this.interpolatorAnimator;
                    if(v4_1 != null && (v4_1.isRunning())) {
                        this.interpolatorAnimator.cancel();
                    }

                    MaterialShapeDrawable v4_2 = this.materialShapeDrawable;
                    if(this.expandedCornersRemoved) {
                        v1 = this.calculateInterpolationWithCornersRemoved();
                    }

                    v4_2.setInterpolation(v1);
                }
            }
        }
    }

    private void updateImportantForAccessibility(boolean arg7) {
        WeakReference v0 = this.viewRef;
        if(v0 == null) {
        }
        else {
            ViewParent v0_1 = v0.get().getParent();
            if(!(v0_1 instanceof CoordinatorLayout)) {
            }
            else {
                int v1 = ((CoordinatorLayout)v0_1).getChildCount();
                if(arg7) {
                    if(this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(v1);
                    }
                    else {
                        return;
                    }
                }

                int v2;
                for(v2 = 0; v2 < v1; ++v2) {
                    View v3 = ((CoordinatorLayout)v0_1).getChildAt(v2);
                    if(v3 == this.viewRef.get()) {
                    }
                    else if(arg7) {
                        this.importantForAccessibilityMap.put(v3, Integer.valueOf(v3.getImportantForAccessibility()));
                        if(this.updateImportantForAccessibilityOnSiblings) {
                            ViewCompat.setImportantForAccessibility(v3, 4);
                        }
                    }
                    else if(this.updateImportantForAccessibilityOnSiblings) {
                        Map v4 = this.importantForAccessibilityMap;
                        if(v4 != null && (v4.containsKey(v3))) {
                            ViewCompat.setImportantForAccessibility(v3, this.importantForAccessibilityMap.get(v3).intValue());
                        }
                    }
                }

                if(!arg7) {
                    this.importantForAccessibilityMap = null;
                    return;
                }

                if(!this.updateImportantForAccessibilityOnSiblings) {
                    return;
                }

                this.viewRef.get().sendAccessibilityEvent(8);
            }
        }
    }

    private void updatePeekHeight(boolean arg3) {
        if(this.viewRef != null) {
            this.calculateCollapsedOffset();
            int v1 = 4;
            if(this.state == v1) {
                Object v0 = this.viewRef.get();
                if(v0 != null) {
                    if(arg3) {
                        this.setState(v1);
                        return;
                    }
                    else {
                        ((View)v0).requestLayout();
                    }
                }
            }
        }
    }
}

