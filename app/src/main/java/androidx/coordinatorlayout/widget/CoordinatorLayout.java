package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region$Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View$BaseSavedState;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$OnHierarchyChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver$OnPreDrawListener;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public interface AttachedBehavior {
        Behavior getBehavior();
    }

    public abstract class Behavior {
        public Behavior() {
            super();
        }

        public Behavior(Context arg1, AttributeSet arg2) {
            super();
        }

        public boolean blocksInteractionBelow(CoordinatorLayout arg1, View arg2) {
            if(this.getScrimOpacity(arg1, arg2) > 0f) {
                return 1;
            }

            return 0;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout arg1, View arg2, Rect arg3) {
            return 0;
        }

        public int getScrimColor(CoordinatorLayout arg1, View arg2) {
            return 0xFF000000;
        }

        public float getScrimOpacity(CoordinatorLayout arg1, View arg2) {
            return 0;
        }

        public static Object getTag(View arg0) {
            return arg0.getLayoutParams().mBehaviorTag;
        }

        public boolean layoutDependsOn(CoordinatorLayout arg1, View arg2, View arg3) {
            return 0;
        }

        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout arg1, View arg2, WindowInsetsCompat arg3) {
            return arg3;
        }

        public void onAttachedToLayoutParams(LayoutParams arg1) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg1, View arg2, View arg3) {
            return 0;
        }

        public void onDependentViewRemoved(CoordinatorLayout arg1, View arg2, View arg3) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout arg1, View arg2, MotionEvent arg3) {
            return 0;
        }

        public boolean onLayoutChild(CoordinatorLayout arg1, View arg2, int arg3) {
            return 0;
        }

        public boolean onMeasureChild(CoordinatorLayout arg1, View arg2, int arg3, int arg4, int arg5, int arg6) {
            return 0;
        }

        public boolean onNestedFling(CoordinatorLayout arg1, View arg2, View arg3, float arg4, float arg5, boolean arg6) {
            return 0;
        }

        public boolean onNestedPreFling(CoordinatorLayout arg1, View arg2, View arg3, float arg4, float arg5) {
            return 0;
        }

        public void onNestedPreScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4, int arg5, int[] arg6, int arg7) {
            if(arg7 == 0) {
                this.onNestedPreScroll(arg1, arg2, arg3, arg4, arg5, arg6);
            }
        }

        @Deprecated public void onNestedPreScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4, int arg5, int[] arg6) {
        }

        public void onNestedScroll(CoordinatorLayout arg3, View arg4, View arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int[] arg11) {
            arg11[0] += arg8;
            arg11[1] += arg9;
            this.onNestedScroll(arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
        }

        @Deprecated public void onNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4, int arg5, int arg6, int arg7) {
        }

        @Deprecated public void onNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
            if(arg8 == 0) {
                this.onNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
            }
        }

        public void onNestedScrollAccepted(CoordinatorLayout arg1, View arg2, View arg3, View arg4, int arg5, int arg6) {
            if(arg6 == 0) {
                this.onNestedScrollAccepted(arg1, arg2, arg3, arg4, arg5);
            }
        }

        @Deprecated public void onNestedScrollAccepted(CoordinatorLayout arg1, View arg2, View arg3, View arg4, int arg5) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout arg1, View arg2, Rect arg3, boolean arg4) {
            return 0;
        }

        public void onRestoreInstanceState(CoordinatorLayout arg1, View arg2, Parcelable arg3) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout arg1, View arg2) {
            return View$BaseSavedState.EMPTY_STATE;
        }

        public boolean onStartNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, View arg4, int arg5, int arg6) {
            if(arg6 == 0) {
                return this.onStartNestedScroll(arg1, arg2, arg3, arg4, arg5);
            }

            return 0;
        }

        @Deprecated public boolean onStartNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, View arg4, int arg5) {
            return 0;
        }

        public void onStopNestedScroll(CoordinatorLayout arg1, View arg2, View arg3, int arg4) {
            if(arg4 == 0) {
                this.onStopNestedScroll(arg1, arg2, arg3);
            }
        }

        @Deprecated public void onStopNestedScroll(CoordinatorLayout arg1, View arg2, View arg3) {
        }

        public boolean onTouchEvent(CoordinatorLayout arg1, View arg2, MotionEvent arg3) {
            return 0;
        }

        public static void setTag(View arg0, Object arg1) {
            arg0.getLayoutParams().mBehaviorTag = arg1;
        }
    }

    @Deprecated @Retention(value=RetentionPolicy.RUNTIME) @public interface DefaultBehavior {
        Class value();
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface DispatchChangeEvent {
    }

    class HierarchyChangeListener implements ViewGroup$OnHierarchyChangeListener {
        HierarchyChangeListener(CoordinatorLayout arg1) {
            CoordinatorLayout.this = arg1;
            super();
        }

        public void onChildViewAdded(View arg2, View arg3) {
            if(CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(arg2, arg3);
            }
        }

        public void onChildViewRemoved(View arg3, View arg4) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            if(CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(arg3, arg4);
            }
        }
    }

    public class LayoutParams extends ViewGroup$MarginLayoutParams {
        public int anchorGravity;
        public int dodgeInsetEdges;
        public int gravity;
        public int insetEdge;
        public int keyline;
        View mAnchorDirectChild;
        int mAnchorId;
        View mAnchorView;
        Behavior mBehavior;
        boolean mBehaviorResolved;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScrollNonTouch;
        private boolean mDidAcceptNestedScrollTouch;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect;

        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        LayoutParams(Context arg5, AttributeSet arg6) {
            super(arg5, arg6);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray v2 = arg5.obtainStyledAttributes(arg6, styleable.CoordinatorLayout_Layout);
            this.gravity = v2.getInteger(styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = v2.getResourceId(styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = v2.getInteger(styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = v2.getInteger(styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = v2.getInt(styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = v2.getInt(styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean v0 = v2.hasValue(styleable.CoordinatorLayout_Layout_layout_behavior);
            this.mBehaviorResolved = v0;
            if(v0) {
                this.mBehavior = CoordinatorLayout.parseBehavior(arg5, arg6, v2.getString(styleable.CoordinatorLayout_Layout_layout_behavior));
            }

            v2.recycle();
            Behavior v5 = this.mBehavior;
            if(v5 != null) {
                v5.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams arg2) {
            super(((ViewGroup$MarginLayoutParams)arg2));
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg2) {
            super(arg2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup$LayoutParams arg2) {
            super(arg2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        boolean checkAnchorChanged() {
            if(this.mAnchorView == null && this.mAnchorId != -1) {
                return 1;
            }

            return 0;
        }

        boolean dependsOn(CoordinatorLayout arg2, View arg3, View arg4) {
            if(arg4 != this.mAnchorDirectChild && !this.shouldDodge(arg4, ViewCompat.getLayoutDirection(((View)arg2)))) {
                Behavior v1 = this.mBehavior;
                if(v1 != null && (v1.layoutDependsOn(arg2, arg3, arg4))) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        boolean didBlockInteraction() {
            if(this.mBehavior == null) {
                this.mDidBlockInteraction = false;
            }

            return this.mDidBlockInteraction;
        }

        View findAnchorView(CoordinatorLayout arg3, View arg4) {
            if(this.mAnchorId == -1) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return null;
            }

            if(this.mAnchorView == null || !this.verifyAnchorView(arg4, arg3)) {
                this.resolveAnchorView(arg4, arg3);
            }

            return this.mAnchorView;
        }

        public int getAnchorId() {
            return this.mAnchorId;
        }

        public Behavior getBehavior() {
            return this.mBehavior;
        }

        boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        boolean isBlockingInteractionBelow(CoordinatorLayout arg3, View arg4) {
            int v3_1;
            boolean v0 = this.mDidBlockInteraction;
            if(v0) {
                return 1;
            }

            Behavior v1 = this.mBehavior;
            if(v1 != null) {
                boolean v3 = v1.blocksInteractionBelow(arg3, arg4);
            }
            else {
                v3_1 = 0;
            }

            v3_1 |= ((int)v0);
            this.mDidBlockInteraction = ((boolean)v3_1);
            return ((boolean)v3_1);
        }

        boolean isNestedScrollAccepted(int arg2) {
            if(arg2 != 0) {
                if(arg2 != 1) {
                    return 0;
                }

                return this.mDidAcceptNestedScrollNonTouch;
            }

            return this.mDidAcceptNestedScrollTouch;
        }

        void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        void resetNestedScroll(int arg2) {
            this.setNestedScrollAccepted(arg2, false);
        }

        void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        private void resolveAnchorView(View arg5, CoordinatorLayout arg6) {
            ViewParent v0_1;
            View v0 = arg6.findViewById(this.mAnchorId);
            this.mAnchorView = v0;
            View v1 = null;
            if(v0 != null) {
                if((((CoordinatorLayout)v0)) == arg6) {
                    if(arg6.isInEditMode()) {
                        this.mAnchorDirectChild = v1;
                        this.mAnchorView = v1;
                        return;
                    }

                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }

                ViewParent v2 = v0.getParent();
                while((((CoordinatorLayout)v2)) != arg6) {
                    if(v2 == null) {
                        break;
                    }

                    if((((View)v2)) != arg5) {
                        if((v2 instanceof View)) {
                            v0_1 = v2;
                        }

                        v2 = v2.getParent();
                        continue;
                    }
                    else if(arg6.isInEditMode()) {
                        this.mAnchorDirectChild = v1;
                        this.mAnchorView = v1;
                        return;
                    }
                    else {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }

                    break;
                }

                this.mAnchorDirectChild = ((View)v0_1);
                return;
            }

            if(arg6.isInEditMode()) {
                this.mAnchorDirectChild = v1;
                this.mAnchorView = v1;
                return;
            }

            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + arg6.getResources().getResourceName(this.mAnchorId) + " to anchor view " + arg5);
        }

        public void setAnchorId(int arg1) {
            this.invalidateAnchor();
            this.mAnchorId = arg1;
        }

        public void setBehavior(Behavior arg2) {
            Behavior v0 = this.mBehavior;
            if(v0 != arg2) {
                if(v0 != null) {
                    v0.onDetachedFromLayoutParams();
                }

                this.mBehavior = arg2;
                this.mBehaviorTag = null;
                this.mBehaviorResolved = true;
                if(arg2 == null) {
                    return;
                }

                arg2.onAttachedToLayoutParams(this);
            }
        }

        void setChangedAfterNestedScroll(boolean arg1) {
            this.mDidChangeAfterNestedScroll = arg1;
        }

        void setLastChildRect(Rect arg1) {
            this.mLastChildRect.set(arg1);
        }

        void setNestedScrollAccepted(int arg2, boolean arg3) {
            if(arg2 != 0) {
                if(arg2 != 1) {
                    return;
                }

                this.mDidAcceptNestedScrollNonTouch = arg3;
                return;
            }

            this.mDidAcceptNestedScrollTouch = arg3;
        }

        private boolean shouldDodge(View arg1, int arg2) {
            int v1 = GravityCompat.getAbsoluteGravity(arg1.getLayoutParams().insetEdge, arg2);
            if(v1 != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, arg2) & v1) == v1) {
                return 1;
            }

            return 0;
        }

        private boolean verifyAnchorView(View arg5, CoordinatorLayout arg6) {
            ViewParent v0_1;
            if(this.mAnchorView.getId() != this.mAnchorId) {
                return 0;
            }

            View v0 = this.mAnchorView;
            ViewParent v1 = v0.getParent();
            while(true) {
                if((((CoordinatorLayout)v1)) == arg6) {
                    goto label_21;
                }

                if(v1 != null) {
                    if((((View)v1)) == arg5) {
                    }
                    else {
                        if((v1 instanceof View)) {
                            v0_1 = v1;
                        }

                        v1 = v1.getParent();
                        continue;
                    }
                }

                break;
            }

            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return 0;
        label_21:
            this.mAnchorDirectChild = ((View)v0_1);
            return 1;
        }
    }

    class OnPreDrawListener implements ViewTreeObserver$OnPreDrawListener {
        OnPreDrawListener(CoordinatorLayout arg1) {
            CoordinatorLayout.this = arg1;
            super();
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return 1;
        }
    }

    public class SavedState extends AbsSavedState {
        final class androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState$1 implements Parcelable$ClassLoaderCreator {
            androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState$1() {
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
        SparseArray behaviorStates;

        static {
            SavedState.CREATOR = new androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg6, ClassLoader arg7) {
            super(arg6, arg7);
            int v0 = arg6.readInt();
            int[] v1 = new int[v0];
            arg6.readIntArray(v1);
            Parcelable[] v6 = arg6.readParcelableArray(arg7);
            this.behaviorStates = new SparseArray(v0);
            int v7;
            for(v7 = 0; v7 < v0; ++v7) {
                this.behaviorStates.append(v1[v7], v6[v7]);
            }
        }

        public void writeToParcel(Parcel arg6, int arg7) {
            super.writeToParcel(arg6, arg7);
            SparseArray v0 = this.behaviorStates;
            int v1 = 0;
            int v0_1 = v0 != null ? v0.size() : 0;
            arg6.writeInt(v0_1);
            int[] v2 = new int[v0_1];
            Parcelable[] v3 = new Parcelable[v0_1];
            while(v1 < v0_1) {
                v2[v1] = this.behaviorStates.keyAt(v1);
                v3[v1] = this.behaviorStates.valueAt(v1);
                ++v1;
            }

            arg6.writeIntArray(v2);
            arg6.writeParcelableArray(v3, arg7);
        }
    }

    class ViewElevationComparator implements Comparator {
        ViewElevationComparator() {
            super();
        }

        public int compare(View arg1, View arg2) {
            float v0 = ViewCompat.getZ(arg1);
            float v1 = ViewCompat.getZ(arg2);
            if(v0 > v1) {
                return -1;
            }

            if(v0 < v1) {
                return 1;
            }

            return 0;
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((View)arg1), ((View)arg2));
        }
    }

    static final Class[] CONSTRUCTOR_PARAMS = null;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator TOP_SORTED_CHILDREN_COMPARATOR = null;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph mChildDag;
    private final List mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup$OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List mTempDependenciesList;
    private final List mTempList1;
    static final ThreadLocal sConstructors;
    private static final Pool sRectPool;

    static {
        Package v0 = CoordinatorLayout.class.getPackage();
        String v0_1 = v0 != null ? v0.getName() : null;
        CoordinatorLayout.WIDGET_PACKAGE_NAME = v0_1;
        CoordinatorLayout.TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        CoordinatorLayout.CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        CoordinatorLayout.sConstructors = new ThreadLocal();
        CoordinatorLayout.sRectPool = new SynchronizedPool(12);
    }

    public CoordinatorLayout(Context arg2) {
        this(arg2, null);
    }

    public CoordinatorLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context arg10, AttributeSet arg11, int arg12) {
        Context v3;
        CoordinatorLayout v2;
        super(arg10, arg11, arg12);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(((ViewGroup)this));
        int v0 = 0;
        TypedArray v1 = arg12 == 0 ? arg10.obtainStyledAttributes(arg11, styleable.CoordinatorLayout, 0, style.Widget_Support_CoordinatorLayout) : arg10.obtainStyledAttributes(arg11, styleable.CoordinatorLayout, arg12, 0);
        TypedArray v6 = v1;
        if(Build$VERSION.SDK_INT < 29) {
            v2 = this;
            v3 = arg10;
        }
        else if(arg12 == 0) {
            v2 = this;
            v3 = arg10;
            v2.saveAttributeDataForStyleable(v3, styleable.CoordinatorLayout, arg11, v6, 0, style.Widget_Support_CoordinatorLayout);
        }
        else {
            v2 = this;
            v3 = arg10;
            v2.saveAttributeDataForStyleable(v3, styleable.CoordinatorLayout, arg11, v6, arg12, 0);
        }

        int v9 = v6.getResourceId(styleable.CoordinatorLayout_keylines, 0);
        if(v9 != 0) {
            Resources v10 = v3.getResources();
            v2.mKeylines = v10.getIntArray(v9);
            float v9_1 = v10.getDisplayMetrics().density;
            int v10_1 = v2.mKeylines.length;
            while(v0 < v10_1) {
                v2.mKeylines[v0] = ((int)((((float)v2.mKeylines[v0])) * v9_1));
                ++v0;
            }
        }

        v2.mStatusBarBackground = v6.getDrawable(styleable.CoordinatorLayout_statusBarBackground);
        v6.recycle();
        v2.setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener(v2));
        if(ViewCompat.getImportantForAccessibility(((View)v2)) == 0) {
            ViewCompat.setImportantForAccessibility(((View)v2), 1);
        }
    }

    private static Rect acquireTempRect() {
        Object v0 = CoordinatorLayout.sRectPool.acquire();
        if(v0 == null) {
            Rect v0_1 = new Rect();
        }

        return ((Rect)v0);
    }

    void addPreDrawListener() {
        if(this.mIsAttachedToWindow) {
            if(this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener(this);
            }

            this.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }

        this.mNeedsPreDrawListener = true;
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg2) {
        if(((arg2 instanceof LayoutParams)) && (super.checkLayoutParams(arg2))) {
            return 1;
        }

        return 0;
    }

    private static int clamp(int arg0, int arg1, int arg2) {
        if(arg0 < arg1) {
            return arg1;
        }

        if(arg0 > arg2) {
            return arg2;
        }

        return arg0;
    }

    private void constrainChildRect(LayoutParams arg6, Rect arg7, int arg8, int arg9) {
        int v0 = this.getWidth();
        int v1 = this.getHeight();
        v0 = Math.max(this.getPaddingLeft() + arg6.leftMargin, Math.min(arg7.left, v0 - this.getPaddingRight() - arg8 - arg6.rightMargin));
        int v5 = Math.max(this.getPaddingTop() + arg6.topMargin, Math.min(arg7.top, v1 - this.getPaddingBottom() - arg9 - arg6.bottomMargin));
        arg7.set(v0, v5, arg8 + v0, arg9 + v5);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat arg5) {
        if(arg5.isConsumed()) {
            return arg5;
        }

        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getChildAt(v1);
            if(ViewCompat.getFitsSystemWindows(v2)) {
                Behavior v3 = v2.getLayoutParams().getBehavior();
                if(v3 != null) {
                    arg5 = v3.onApplyWindowInsets(this, v2, arg5);
                    if(arg5.isConsumed()) {
                        return arg5;
                    }
                }
            }
        }

        return arg5;
    }

    public void dispatchDependentViewsChanged(View arg5) {
        List v0 = this.mChildDag.getIncomingEdges(arg5);
        if(v0 != null && !v0.isEmpty()) {
            int v1;
            for(v1 = 0; v1 < v0.size(); ++v1) {
                Object v2 = v0.get(v1);
                Behavior v3 = ((View)v2).getLayoutParams().getBehavior();
                if(v3 != null) {
                    v3.onDependentViewChanged(this, ((View)v2), arg5);
                }
            }
        }
    }

    public boolean doViewsOverlap(View arg5, View arg6) {
        boolean v1 = false;
        if(arg5.getVisibility() == 0 && arg6.getVisibility() == 0) {
            Rect v0 = CoordinatorLayout.acquireTempRect();
            boolean v2 = arg5.getParent() != this ? true : false;
            this.getChildRect(arg5, v2, v0);
            Rect v5 = CoordinatorLayout.acquireTempRect();
            v2 = arg6.getParent() != this ? true : false;
            this.getChildRect(arg6, v2, v5);
            try {
                if(v0.left <= v5.right && v0.top <= v5.bottom && v0.right >= v5.left) {
                    if(v0.bottom < v5.top) {
                        goto label_33;
                    }

                    goto label_32;
                }

                goto label_33;
            }
            catch(Throwable v4) {
                CoordinatorLayout.releaseTempRect(v0);
                CoordinatorLayout.releaseTempRect(v5);
                throw v4;
            }

        label_32:
            v1 = true;
        label_33:
            CoordinatorLayout.releaseTempRect(v0);
            CoordinatorLayout.releaseTempRect(v5);
            return v1;
        }

        return 0;
    }

    protected boolean drawChild(Canvas arg17, View arg18, long arg19) {
        CoordinatorLayout v0 = this;
        View v1 = arg18;
        ViewGroup$LayoutParams v2 = v1.getLayoutParams();
        if(((LayoutParams)v2).mBehavior != null) {
            float v3 = ((LayoutParams)v2).mBehavior.getScrimOpacity(v0, v1);
            if(v3 > 0f) {
                Paint v4 = v0.mScrimPaint;
                if(v4 == null) {
                    v4 = new Paint();
                    v0.mScrimPaint = v4;
                }

                v4.setColor(((LayoutParams)v2).mBehavior.getScrimColor(v0, v1));
                v0.mScrimPaint.setAlpha(CoordinatorLayout.clamp(Math.round(v3 * 255f), 0, 0xFF));
                int v2_1 = arg17.save();
                if(v1.isOpaque()) {
                    arg17.clipRect(((float)v1.getLeft()), ((float)v1.getTop()), ((float)v1.getRight()), ((float)v1.getBottom()), Region$Op.DIFFERENCE);
                }

                arg17.drawRect(((float)v0.getPaddingLeft()), ((float)v0.getPaddingTop()), ((float)(v0.getWidth() - v0.getPaddingRight())), ((float)(v0.getHeight() - v0.getPaddingBottom())), v0.mScrimPaint);
                arg17.restoreToCount(v2_1);
            }
        }

        return super.drawChild(arg17, arg18, arg19);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] v0 = this.getDrawableState();
        Drawable v1 = this.mStatusBarBackground;
        boolean v0_1 = v1 == null || !v1.isStateful() ? false : v1.setState(v0);
        if(v0_1) {
            this.invalidate();
        }
    }

    void ensurePreDrawListener() {
        int v0 = this.getChildCount();
        boolean v1 = false;
        int v2 = 0;
        while(v2 < v0) {
            if(this.hasDependencies(this.getChildAt(v2))) {
                v1 = true;
            }
            else {
                ++v2;
                continue;
            }

            break;
        }

        if(v1 != this.mNeedsPreDrawListener) {
            if(v1) {
                this.addPreDrawListener();
                return;
            }
            else {
                this.removePreDrawListener();
            }
        }
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
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
        if((arg1 instanceof LayoutParams)) {
            return new LayoutParams(((LayoutParams)arg1));
        }

        if((arg1 instanceof ViewGroup$MarginLayoutParams)) {
            return new LayoutParams(((ViewGroup$MarginLayoutParams)arg1));
        }

        return new LayoutParams(arg1);
    }

    void getChildRect(View arg3, boolean arg4, Rect arg5) {
        if(!arg3.isLayoutRequested()) {
            if(arg3.getVisibility() == 8) {
            }
            else if(arg4) {
                this.getDescendantRect(arg3, arg5);
                return;
            }
            else {
                arg5.set(arg3.getLeft(), arg3.getTop(), arg3.getRight(), arg3.getBottom());
                return;
            }
        }

        arg5.setEmpty();
    }

    public List getDependencies(View arg2) {
        List v2 = this.mChildDag.getOutgoingEdges(arg2);
        this.mTempDependenciesList.clear();
        if(v2 != null) {
            this.mTempDependenciesList.addAll(((Collection)v2));
        }

        return this.mTempDependenciesList;
    }

    final List getDependencySortedChildren() {
        this.prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public List getDependents(View arg2) {
        List v2 = this.mChildDag.getIncomingEdges(arg2);
        this.mTempDependenciesList.clear();
        if(v2 != null) {
            this.mTempDependenciesList.addAll(((Collection)v2));
        }

        return this.mTempDependenciesList;
    }

    void getDescendantRect(View arg1, Rect arg2) {
        ViewGroupUtils.getDescendantRect(((ViewGroup)this), arg1, arg2);
    }

    void getDesiredAnchoredChildRect(View arg10, int arg11, Rect arg12, Rect arg13) {
        ViewGroup$LayoutParams v6 = arg10.getLayoutParams();
        int v7 = arg10.getMeasuredWidth();
        int v8 = arg10.getMeasuredHeight();
        this.getDesiredAnchoredChildRectWithoutConstraints(arg10, arg11, arg12, arg13, ((LayoutParams)v6), v7, v8);
        this.constrainChildRect(((LayoutParams)v6), arg13, v7, v8);
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View arg5, int arg6, Rect arg7, Rect arg8, LayoutParams arg9, int arg10, int arg11) {
        int v4 = GravityCompat.getAbsoluteGravity(CoordinatorLayout.resolveAnchoredChildGravity(arg9.gravity), arg6);
        int v5 = GravityCompat.getAbsoluteGravity(CoordinatorLayout.resolveGravity(arg9.anchorGravity), arg6);
        arg6 = v4 & 7;
        v4 &= 0x70;
        int v9 = v5 & 7;
        v5 &= 0x70;
        int v0 = 5;
        if(v9 == 1) {
            v9 = arg7.left + arg7.width() / 2;
        }
        else if(v9 != v0) {
            v9 = arg7.left;
        }
        else {
            v9 = arg7.right;
        }

        int v2 = 80;
        int v3 = 16;
        if(v5 == v3) {
            v5 = arg7.top + arg7.height() / 2;
        }
        else if(v5 != v2) {
            v5 = arg7.top;
        }
        else {
            v5 = arg7.bottom;
        }

        if(arg6 == 1) {
            v9 -= arg10 / 2;
        }
        else if(arg6 != v0) {
            v9 -= arg10;
        }

        if(v4 == v3) {
            v5 -= arg11 / 2;
        }
        else if(v4 != v2) {
            v5 -= arg11;
        }

        arg8.set(v9, v5, arg10 + v9, arg11 + v5);
    }

    private int getKeyline(int arg5) {
        int[] v0 = this.mKeylines;
        String v2 = "CoordinatorLayout";
        if(v0 == null) {
            Log.e(v2, "No keylines defined for " + this + " - attempted index lookup " + arg5);
            return 0;
        }

        if(arg5 >= 0) {
            if(arg5 >= v0.length) {
            }
            else {
                return v0[arg5];
            }
        }

        Log.e(v2, "Keyline index " + arg5 + " out of range for " + this);
        return 0;
    }

    void getLastChildRect(View arg1, Rect arg2) {
        arg2.set(arg1.getLayoutParams().getLastChildRect());
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    LayoutParams getResolvedLayoutParams(View arg6) {
        ViewGroup$LayoutParams v5 = arg6.getLayoutParams();
        if(!((LayoutParams)v5).mBehaviorResolved) {
            String v1 = "CoordinatorLayout";
            if((arg6 instanceof AttachedBehavior)) {
                Behavior v6 = ((AttachedBehavior)arg6).getBehavior();
                if(v6 == null) {
                    Log.e(v1, "Attached behavior class is null");
                }

                ((LayoutParams)v5).setBehavior(v6);
                ((LayoutParams)v5).mBehaviorResolved = true;
                return ((LayoutParams)v5);
            }

            Class v6_1 = arg6.getClass();
            Annotation v0 = null;
            while(v6_1 != null) {
                v0 = v6_1.getAnnotation(DefaultBehavior.class);
                if(v0 != null) {
                    break;
                }

                v6_1 = v6_1.getSuperclass();
            }

            if(v0 != null) {
                try {
                    ((LayoutParams)v5).setBehavior(((DefaultBehavior)v0).value().getDeclaredConstructor().newInstance());
                }
                catch(Exception v6_2) {
                    Log.e(v1, "Default behavior class " + ((DefaultBehavior)v0).value().getName() + " could not be instantiated. Did you forget a default constructor?", ((Throwable)v6_2));
                }
            }

            ((LayoutParams)v5).mBehaviorResolved = true;
        }

        return ((LayoutParams)v5);
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), this.getPaddingTop() + this.getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), this.getPaddingLeft() + this.getPaddingRight());
    }

    private void getTopSortedChildren(List arg5) {
        arg5.clear();
        boolean v0 = this.isChildrenDrawingOrderEnabled();
        int v1 = this.getChildCount();
        int v2;
        for(v2 = v1 - 1; v2 >= 0; --v2) {
            int v3 = v0 ? this.getChildDrawingOrder(v1, v2) : v2;
            arg5.add(this.getChildAt(v3));
        }

        Comparator v4 = CoordinatorLayout.TOP_SORTED_CHILDREN_COMPARATOR;
        if(v4 != null) {
            Collections.sort(arg5, v4);
        }
    }

    private boolean hasDependencies(View arg1) {
        return this.mChildDag.hasOutgoingEdges(arg1);
    }

    public boolean isPointInChildBounds(View arg2, int arg3, int arg4) {
        boolean v1_1;
        Rect v0 = CoordinatorLayout.acquireTempRect();
        this.getDescendantRect(arg2, v0);
        try {
            v1_1 = v0.contains(arg3, arg4);
        }
        catch(Throwable v1) {
            CoordinatorLayout.releaseTempRect(v0);
            throw v1;
        }

        CoordinatorLayout.releaseTempRect(v0);
        return v1_1;
    }

    private void layoutChild(View arg8, int arg9) {
        ViewGroup$LayoutParams v0 = arg8.getLayoutParams();
        Rect v4 = CoordinatorLayout.acquireTempRect();
        v4.set(this.getPaddingLeft() + ((LayoutParams)v0).leftMargin, this.getPaddingTop() + ((LayoutParams)v0).topMargin, this.getWidth() - this.getPaddingRight() - ((LayoutParams)v0).rightMargin, this.getHeight() - this.getPaddingBottom() - ((LayoutParams)v0).bottomMargin);
        if(this.mLastInsets != null && (ViewCompat.getFitsSystemWindows(((View)this))) && !ViewCompat.getFitsSystemWindows(arg8)) {
            v4.left += this.mLastInsets.getSystemWindowInsetLeft();
            v4.top += this.mLastInsets.getSystemWindowInsetTop();
            v4.right -= this.mLastInsets.getSystemWindowInsetRight();
            v4.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        }

        Rect v5 = CoordinatorLayout.acquireTempRect();
        GravityCompat.apply(CoordinatorLayout.resolveGravity(((LayoutParams)v0).gravity), arg8.getMeasuredWidth(), arg8.getMeasuredHeight(), v4, v5, arg9);
        arg8.layout(v5.left, v5.top, v5.right, v5.bottom);
        CoordinatorLayout.releaseTempRect(v4);
        CoordinatorLayout.releaseTempRect(v5);
    }

    private void layoutChildWithAnchor(View arg4, View arg5, int arg6) {
        Rect v0 = CoordinatorLayout.acquireTempRect();
        Rect v1 = CoordinatorLayout.acquireTempRect();
        try {
            this.getDescendantRect(arg5, v0);
            this.getDesiredAnchoredChildRect(arg4, arg6, v0, v1);
            arg4.layout(v1.left, v1.top, v1.right, v1.bottom);
        }
        catch(Throwable v3) {
            CoordinatorLayout.releaseTempRect(v0);
            CoordinatorLayout.releaseTempRect(v1);
            throw v3;
        }

        CoordinatorLayout.releaseTempRect(v0);
        CoordinatorLayout.releaseTempRect(v1);
    }

    private void layoutChildWithKeyline(View arg9, int arg10, int arg11) {
        ViewGroup$LayoutParams v0 = arg9.getLayoutParams();
        int v1 = GravityCompat.getAbsoluteGravity(CoordinatorLayout.resolveKeylineGravity(((LayoutParams)v0).gravity), arg11);
        int v2 = v1 & 7;
        v1 &= 0x70;
        int v3 = this.getWidth();
        int v4 = this.getHeight();
        int v5 = arg9.getMeasuredWidth();
        int v6 = arg9.getMeasuredHeight();
        if(arg11 == 1) {
            arg10 = v3 - arg10;
        }

        arg10 = this.getKeyline(arg10) - v5;
        if(v2 == 1) {
            arg10 += v5 / 2;
        }
        else if(v2 != 5) {
        }
        else {
            arg10 += v5;
        }

        if(v1 == 16) {
            arg11 = v6 / 2;
        }
        else if(v1 != 80) {
            arg11 = 0;
        }
        else {
            arg11 = v6;
        }

        arg10 = Math.max(this.getPaddingLeft() + ((LayoutParams)v0).leftMargin, Math.min(arg10, v3 - this.getPaddingRight() - v5 - ((LayoutParams)v0).rightMargin));
        int v8 = Math.max(this.getPaddingTop() + ((LayoutParams)v0).topMargin, Math.min(arg11, v4 - this.getPaddingBottom() - v6 - ((LayoutParams)v0).bottomMargin));
        arg9.layout(arg10, v8, v5 + arg10, v6 + v8);
    }

    private void offsetChildByInset(View arg9, Rect arg10, int arg11) {
        int v1_1;
        if(!ViewCompat.isLaidOut(arg9)) {
        }
        else if(arg9.getWidth() > 0) {
            if(arg9.getHeight() <= 0) {
            }
            else {
                ViewGroup$LayoutParams v0 = arg9.getLayoutParams();
                Behavior v1 = ((LayoutParams)v0).getBehavior();
                Rect v2 = CoordinatorLayout.acquireTempRect();
                Rect v3 = CoordinatorLayout.acquireTempRect();
                v3.set(arg9.getLeft(), arg9.getTop(), arg9.getRight(), arg9.getBottom());
                if(v1 == null || !v1.getInsetDodgeRect(this, arg9, v2)) {
                    v2.set(v3);
                }
                else if(v3.contains(v2)) {
                }
                else {
                    throw new IllegalArgumentException("Rect should be within the child\'s bounds. Rect:" + v2.toShortString() + " | Bounds:" + v3.toShortString());
                }

                CoordinatorLayout.releaseTempRect(v3);
                if(v2.isEmpty()) {
                    CoordinatorLayout.releaseTempRect(v2);
                    return;
                }

                arg11 = GravityCompat.getAbsoluteGravity(((LayoutParams)v0).dodgeInsetEdges, arg11);
                int v4 = 1;
                if((arg11 & 0x30) == 0x30) {
                    v1_1 = v2.top - ((LayoutParams)v0).topMargin - ((LayoutParams)v0).mInsetOffsetY;
                    if(v1_1 < arg10.top) {
                        this.setInsetOffsetY(arg9, arg10.top - v1_1);
                        v1_1 = 1;
                    }
                    else {
                        goto label_61;
                    }
                }
                else {
                label_61:
                    v1_1 = 0;
                }

                if((arg11 & 80) == 80) {
                    int v3_1 = this.getHeight() - v2.bottom - ((LayoutParams)v0).bottomMargin + ((LayoutParams)v0).mInsetOffsetY;
                    if(v3_1 < arg10.bottom) {
                        this.setInsetOffsetY(arg9, v3_1 - arg10.bottom);
                        v1_1 = 1;
                    }
                }

                if(v1_1 == 0) {
                    this.setInsetOffsetY(arg9, 0);
                }

                if((arg11 & 3) == 3) {
                    v1_1 = v2.left - ((LayoutParams)v0).leftMargin - ((LayoutParams)v0).mInsetOffsetX;
                    if(v1_1 < arg10.left) {
                        this.setInsetOffsetX(arg9, arg10.left - v1_1);
                        v1_1 = 1;
                    }
                    else {
                        goto label_95;
                    }
                }
                else {
                label_95:
                    v1_1 = 0;
                }

                if((arg11 & 5) == 5) {
                    arg11 = this.getWidth() - v2.right - ((LayoutParams)v0).rightMargin + ((LayoutParams)v0).mInsetOffsetX;
                    if(arg11 < arg10.right) {
                        this.setInsetOffsetX(arg9, arg11 - arg10.right);
                    }
                    else {
                        goto label_112;
                    }
                }
                else {
                label_112:
                    v4 = v1_1;
                }

                if(v4 == 0) {
                    this.setInsetOffsetX(arg9, 0);
                }

                CoordinatorLayout.releaseTempRect(v2);
            }
        }
    }

    void offsetChildToAnchor(View arg11, int arg12) {
        ViewGroup$LayoutParams v6 = arg11.getLayoutParams();
        if(((LayoutParams)v6).mAnchorView != null) {
            Rect v4 = CoordinatorLayout.acquireTempRect();
            Rect v0 = CoordinatorLayout.acquireTempRect();
            Rect v5 = CoordinatorLayout.acquireTempRect();
            this.getDescendantRect(((LayoutParams)v6).mAnchorView, v4);
            int v9 = 0;
            this.getChildRect(arg11, false, v0);
            int v7 = arg11.getMeasuredWidth();
            int v8 = arg11.getMeasuredHeight();
            CoordinatorLayout v1 = this;
            View v2 = arg11;
            v1.getDesiredAnchoredChildRectWithoutConstraints(v2, arg12, v4, v5, ((LayoutParams)v6), v7, v8);
            if(v5.left != v0.left || v5.top != v0.top) {
                v9 = 1;
            }

            v1.constrainChildRect(((LayoutParams)v6), v5, v7, v8);
            int v10 = v5.left - v0.left;
            int v11 = v5.top - v0.top;
            if(v10 != 0) {
                ViewCompat.offsetLeftAndRight(v2, v10);
            }

            if(v11 != 0) {
                ViewCompat.offsetTopAndBottom(v2, v11);
            }

            if(v9 != 0) {
                Behavior v10_1 = ((LayoutParams)v6).getBehavior();
                if(v10_1 != null) {
                    v10_1.onDependentViewChanged(v1, v2, ((LayoutParams)v6).mAnchorView);
                }
            }

            CoordinatorLayout.releaseTempRect(v4);
            CoordinatorLayout.releaseTempRect(v0);
            CoordinatorLayout.releaseTempRect(v5);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.resetTouchBehaviors(false);
        if(this.mNeedsPreDrawListener) {
            if(this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener(this);
            }

            this.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }

        if(this.mLastInsets == null && (ViewCompat.getFitsSystemWindows(((View)this)))) {
            ViewCompat.requestApplyInsets(((View)this));
        }

        this.mIsAttachedToWindow = true;
    }

    final void onChildViewsChanged(int arg18) {
        boolean v13_2;
        int v12;
        CoordinatorLayout v0 = this;
        int v1 = arg18;
        int v2 = ViewCompat.getLayoutDirection(((View)v0));
        int v3 = v0.mDependencySortedChildren.size();
        Rect v4 = CoordinatorLayout.acquireTempRect();
        Rect v5 = CoordinatorLayout.acquireTempRect();
        Rect v6 = CoordinatorLayout.acquireTempRect();
        int v8;
        for(v8 = 0; v8 < v3; ++v8) {
            Object v9 = v0.mDependencySortedChildren.get(v8);
            ViewGroup$LayoutParams v10 = ((View)v9).getLayoutParams();
            if(v1 != 0 || ((View)v9).getVisibility() != 8) {
                int v11;
                for(v11 = 0; v11 < v8; ++v11) {
                    if(((LayoutParams)v10).mAnchorDirectChild == v0.mDependencySortedChildren.get(v11)) {
                        v0.offsetChildToAnchor(((View)v9), v2);
                    }
                }

                v0.getChildRect(((View)v9), true, v5);
                if(((LayoutParams)v10).insetEdge != 0 && !v5.isEmpty()) {
                    v12 = GravityCompat.getAbsoluteGravity(((LayoutParams)v10).insetEdge, v2);
                    int v13 = v12 & 0x70;
                    if(v13 == 0x30) {
                        v4.top = Math.max(v4.top, v5.bottom);
                    }
                    else if(v13 != 80) {
                    }
                    else {
                        v4.bottom = Math.max(v4.bottom, v0.getHeight() - v5.top);
                    }

                    v12 &= 7;
                    if(v12 != 3) {
                        if(v12 != 5) {
                            goto label_70;
                        }

                        v4.right = Math.max(v4.right, v0.getWidth() - v5.left);
                        goto label_70;
                    }

                    v4.left = Math.max(v4.left, v5.right);
                }

            label_70:
                if(((LayoutParams)v10).dodgeInsetEdges != 0 && ((View)v9).getVisibility() == 0) {
                    v0.offsetChildByInset(((View)v9), v4, v2);
                }

                int v10_1 = 2;
                if(v1 != v10_1) {
                    v0.getLastChildRect(((View)v9), v6);
                    if(v6.equals(v5)) {
                        goto label_105;
                    }
                    else {
                        v0.recordLastChildRect(((View)v9), v5);
                    }
                }

                for(v12 = v8 + 1; v12 < v3; ++v12) {
                    Object v13_1 = v0.mDependencySortedChildren.get(v12);
                    ViewGroup$LayoutParams v14 = ((View)v13_1).getLayoutParams();
                    Behavior v15 = ((LayoutParams)v14).getBehavior();
                    if(v15 != null && (v15.layoutDependsOn(v0, ((View)v13_1), ((View)v9)))) {
                        if(v1 == 0 && (((LayoutParams)v14).getChangedAfterNestedScroll())) {
                            ((LayoutParams)v14).resetChangedAfterNestedScroll();
                            goto label_103;
                        }

                        if(v1 != v10_1) {
                            v13_2 = v15.onDependentViewChanged(v0, ((View)v13_1), ((View)v9));
                        }
                        else {
                            v15.onDependentViewRemoved(v0, ((View)v13_1), ((View)v9));
                            v13_2 = true;
                        }

                        if(v1 != 1) {
                            goto label_103;
                        }

                        ((LayoutParams)v14).setChangedAfterNestedScroll(v13_2);
                    }

                label_103:
                }
            }
            else {
            }

        label_105:
        }

        CoordinatorLayout.releaseTempRect(v4);
        CoordinatorLayout.releaseTempRect(v5);
        CoordinatorLayout.releaseTempRect(v6);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.resetTouchBehaviors(false);
        if((this.mNeedsPreDrawListener) && this.mOnPreDrawListener != null) {
            this.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }

        View v1 = this.mNestedScrollingTarget;
        if(v1 != null) {
            this.onStopNestedScroll(v1);
        }

        this.mIsAttachedToWindow = false;
    }

    public void onDraw(Canvas arg5) {
        super.onDraw(arg5);
        if((this.mDrawStatusBarBackground) && this.mStatusBarBackground != null) {
            WindowInsetsCompat v0 = this.mLastInsets;
            int v0_1 = v0 != null ? v0.getSystemWindowInsetTop() : 0;
            if(v0_1 <= 0) {
                return;
            }

            this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), v0_1);
            this.mStatusBarBackground.draw(arg5);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent arg4) {
        int v0 = arg4.getActionMasked();
        if(v0 == 0) {
            this.resetTouchBehaviors(true);
        }

        boolean v4 = this.performIntercept(arg4, 0);
        if(v0 != 1) {
            if(v0 == 3) {
            }
            else {
                return v4;
            }
        }

        this.resetTouchBehaviors(true);
        return v4;
    }

    protected void onLayout(boolean arg2, int arg3, int arg4, int arg5, int arg6) {
        int v2 = ViewCompat.getLayoutDirection(((View)this));
        arg3 = this.mDependencySortedChildren.size();
        for(arg4 = 0; arg4 < arg3; ++arg4) {
            Object v5 = this.mDependencySortedChildren.get(arg4);
            if(((View)v5).getVisibility() == 8) {
            }
            else {
                Behavior v6 = ((View)v5).getLayoutParams().getBehavior();
                if(v6 != null && (v6.onLayoutChild(this, ((View)v5), v2))) {
                    goto label_17;
                }

                this.onLayoutChild(((View)v5), v2);
            }

        label_17:
        }
    }

    public void onLayoutChild(View arg3, int arg4) {
        ViewGroup$LayoutParams v0 = arg3.getLayoutParams();
        if(!((LayoutParams)v0).checkAnchorChanged()) {
            if(((LayoutParams)v0).mAnchorView != null) {
                this.layoutChildWithAnchor(arg3, ((LayoutParams)v0).mAnchorView, arg4);
                return;
            }

            if(((LayoutParams)v0).keyline >= 0) {
                this.layoutChildWithKeyline(arg3, ((LayoutParams)v0).keyline, arg4);
                return;
            }

            this.layoutChild(arg3, arg4);
            return;
        }

        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    protected void onMeasure(int arg27, int arg28) {
        Object v2_1;
        int v22;
        int v19;
        int v21;
        int v23;
        CoordinatorLayout v0 = this;
        v0.prepareChildren();
        v0.ensurePreDrawListener();
        int v7 = v0.getPaddingLeft();
        int v1 = v0.getPaddingTop();
        int v8 = v0.getPaddingRight();
        int v2 = v0.getPaddingBottom();
        int v9 = ViewCompat.getLayoutDirection(((View)v0));
        int v11 = v9 == 1 ? 1 : 0;
        int v12 = View$MeasureSpec.getMode(arg27);
        int v13 = View$MeasureSpec.getSize(arg27);
        int v14 = View$MeasureSpec.getMode(arg28);
        int v15 = View$MeasureSpec.getSize(arg28);
        int v16 = v7 + v8;
        int v17 = v1 + v2;
        v1 = v0.getSuggestedMinimumWidth();
        v2 = v0.getSuggestedMinimumHeight();
        int v18 = v0.mLastInsets == null || !ViewCompat.getFitsSystemWindows(((View)v0)) ? 0 : 1;
        int v3 = v0.mDependencySortedChildren.size();
        int v4 = 0;
        int v5 = 0;
        while(v4 < v3) {
            Object v6 = v0.mDependencySortedChildren.get(v4);
            int v20 = v1;
            if(((View)v6).getVisibility() == 8) {
                v23 = v3;
                v21 = v4;
                v19 = v7;
                v22 = v9;
                v1 = v20;
                v20 = v8;
            }
            else {
                ViewGroup$LayoutParams v10 = ((View)v6).getLayoutParams();
                if(((LayoutParams)v10).keyline < 0 || v12 == 0) {
                    v22 = v2;
                label_84:
                    v1 = v4;
                    v4 = 0;
                }
                else {
                    v21 = v0.getKeyline(((LayoutParams)v10).keyline);
                    v1 = GravityCompat.getAbsoluteGravity(CoordinatorLayout.resolveKeylineGravity(((LayoutParams)v10).gravity), v9) & 7;
                    v22 = v2;
                    if(v1 != 3 || v11 != 0) {
                        v2 = 5;
                        if(v1 == v2 && v11 != 0) {
                        label_66:
                            v1 = Math.max(0, v13 - v8 - v21);
                            goto label_70;
                        }

                        if(v1 != v2 || v11 != 0) {
                            if(v1 != 3) {
                            }
                            else if(v11 != 0) {
                                goto label_79;
                            }

                            goto label_84;
                        }

                    label_79:
                        v1 = Math.max(0, v21 - v7);
                    }
                    else {
                        goto label_66;
                    }

                label_70:
                    int v25 = v4;
                    v4 = v1;
                    v1 = v25;
                }

                if(v18 == 0 || (ViewCompat.getFitsSystemWindows(((View)v6)))) {
                    v21 = v1;
                    v2 = arg27;
                    v1 = arg28;
                }
                else {
                    v21 = v1;
                    v2 = v0.mLastInsets.getSystemWindowInsetLeft() + v0.mLastInsets.getSystemWindowInsetRight();
                    v1 = v0.mLastInsets.getSystemWindowInsetTop() + v0.mLastInsets.getSystemWindowInsetBottom();
                    v2 = View$MeasureSpec.makeMeasureSpec(v13 - v2, v12);
                    v1 = View$MeasureSpec.makeMeasureSpec(v15 - v1, v14);
                }

                Behavior v0_1 = ((LayoutParams)v10).getBehavior();
                if(v0_1 != null) {
                    v23 = v3;
                    v3 = v2;
                    v2_1 = v6;
                    v19 = v22;
                    v22 = v9;
                    v9 = v19;
                    v19 = v7;
                    v7 = v20;
                    v20 = v8;
                    v8 = v5;
                    v5 = v1;
                    boolean v0_2 = v0_1.onMeasureChild(this, ((View)v2_1), v3, v4, v5, 0);
                    v1 = v4;
                    v4 = v5;
                    if(!v0_2) {
                        goto label_147;
                    }
                    else {
                        v0 = this;
                    }
                }
                else {
                    v19 = v4;
                    v4 = v1;
                    v1 = v19;
                    v19 = v22;
                    v22 = v9;
                    v9 = v19;
                    v23 = v3;
                    v19 = v7;
                    v7 = v20;
                    v3 = v2;
                    v2_1 = v6;
                    v20 = v8;
                    v8 = v5;
                label_147:
                    int v0_3 = v3;
                    v3 = v1;
                    Object v1_1 = v2_1;
                    v2 = v0_3;
                    v0 = this;
                    v0.onMeasureChild(((View)v1_1), v2, v3, v4, 0);
                    v2_1 = v1_1;
                }

                v1 = Math.max(v7, v16 + ((View)v2_1).getMeasuredWidth() + ((LayoutParams)v10).leftMargin + ((LayoutParams)v10).rightMargin);
                v3 = Math.max(v9, v17 + ((View)v2_1).getMeasuredHeight() + ((LayoutParams)v10).topMargin + ((LayoutParams)v10).bottomMargin);
                v5 = View.combineMeasuredStates(v8, ((View)v2_1).getMeasuredState());
                v2 = v3;
            }

            v4 = v21 + 1;
            v7 = v19;
            v8 = v20;
            v9 = v22;
            v3 = v23;
        }

        v0.setMeasuredDimension(View.resolveSizeAndState(v1, arg27, 0xFF000000 & v5), View.resolveSizeAndState(v2, arg28, v5 << 16));
    }

    public void onMeasureChild(View arg1, int arg2, int arg3, int arg4, int arg5) {
        this.measureChildWithMargins(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean onNestedFling(View arg12, float arg13, float arg14, boolean arg15) {
        boolean v10;
        float v9;
        float v8;
        View v7;
        CoordinatorLayout v5;
        int v0 = this.getChildCount();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            View v6 = this.getChildAt(v2);
            if(v6.getVisibility() != 8) {
                ViewGroup$LayoutParams v4 = v6.getLayoutParams();
                if(!((LayoutParams)v4).isNestedScrollAccepted(0)) {
                    goto label_9;
                }
                else {
                    Behavior v4_1 = ((LayoutParams)v4).getBehavior();
                    if(v4_1 != null) {
                        v5 = this;
                        v7 = arg12;
                        v8 = arg13;
                        v9 = arg14;
                        v10 = arg15;
                        v3 |= v4_1.onNestedFling(v5, v6, v7, v8, v9, v10);
                    }
                    else {
                        goto label_9;
                    }
                }
            }
            else {
            label_9:
                v5 = this;
                v7 = arg12;
                v8 = arg13;
                v9 = arg14;
                v10 = arg15;
            }

            ++v2;
            this = v5;
            arg12 = v7;
            arg13 = v8;
            arg14 = v9;
            arg15 = v10;
        }

        v5 = this;
        if(v3 != 0) {
            v5.onChildViewsChanged(1);
        }

        return ((boolean)v3);
    }

    public boolean onNestedPreFling(View arg11, float arg12, float arg13) {
        float v9;
        float v8;
        View v7;
        CoordinatorLayout v5;
        int v0 = this.getChildCount();
        int v2 = 0;
        int v3 = 0;
        while(v2 < v0) {
            View v6 = this.getChildAt(v2);
            if(v6.getVisibility() != 8) {
                ViewGroup$LayoutParams v4 = v6.getLayoutParams();
                if(!((LayoutParams)v4).isNestedScrollAccepted(0)) {
                    goto label_9;
                }
                else {
                    Behavior v4_1 = ((LayoutParams)v4).getBehavior();
                    if(v4_1 != null) {
                        v5 = this;
                        v7 = arg11;
                        v8 = arg12;
                        v9 = arg13;
                        v3 |= v4_1.onNestedPreFling(v5, v6, v7, v8, v9);
                    }
                    else {
                        goto label_9;
                    }
                }
            }
            else {
            label_9:
                v5 = this;
                v7 = arg11;
                v8 = arg12;
                v9 = arg13;
            }

            ++v2;
            this = v5;
            arg11 = v7;
            arg12 = v8;
            arg13 = v9;
        }

        return ((boolean)v3);
    }

    public void onNestedPreScroll(View arg7, int arg8, int arg9, int[] arg10) {
        this.onNestedPreScroll(arg7, arg8, arg9, arg10, 0);
    }

    public void onNestedPreScroll(View arg15, int arg16, int arg17, int[] arg18, int arg19) {
        int v8 = this.getChildCount();
        int v0 = 0;
        int v10 = 0;
        int v11 = 0;
        int v12 = 0;
        while(v10 < v8) {
            View v2 = this.getChildAt(v10);
            if(v2.getVisibility() == 8) {
            }
            else {
                ViewGroup$LayoutParams v3 = v2.getLayoutParams();
                int v7 = arg19;
                if(!((LayoutParams)v3).isNestedScrollAccepted(v7)) {
                }
                else {
                    Behavior v3_1 = ((LayoutParams)v3).getBehavior();
                    if(v3_1 != null) {
                        int[] v6 = this.mBehaviorConsumed;
                        v6[0] = 0;
                        v6[1] = 0;
                        v3_1.onNestedPreScroll(this, v2, arg15, arg16, arg17, v6, v7);
                        int[] v0_1 = this.mBehaviorConsumed;
                        v0 = arg16 > 0 ? Math.max(v11, v0_1[0]) : Math.min(v11, v0_1[0]);
                        v11 = v0;
                        v0_1 = this.mBehaviorConsumed;
                        v0 = arg17 > 0 ? Math.max(v12, v0_1[1]) : Math.min(v12, v0_1[1]);
                        v12 = v0;
                        v0 = 1;
                    }
                }
            }

            ++v10;
        }

        arg18[0] = v11;
        arg18[1] = v12;
        if(v0 != 0) {
            this.onChildViewsChanged(1);
        }
    }

    public void onNestedScroll(View arg8, int arg9, int arg10, int arg11, int arg12) {
        this.onNestedScroll(arg8, arg9, arg10, arg11, arg12, 0);
    }

    public void onNestedScroll(View arg9, int arg10, int arg11, int arg12, int arg13, int arg14) {
        this.onNestedScroll(arg9, arg10, arg11, arg12, arg13, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    public void onNestedScroll(View arg17, int arg18, int arg19, int arg20, int arg21, int arg22, int[] arg23) {
        CoordinatorLayout v1 = this;
        int v10 = v1.getChildCount();
        int v0 = 0;
        int v12 = 0;
        int v13 = 0;
        int v14 = 0;
        while(v12 < v10) {
            View v2 = v1.getChildAt(v12);
            if(v2.getVisibility() == 8) {
            }
            else {
                ViewGroup$LayoutParams v3 = v2.getLayoutParams();
                int v8 = arg22;
                if(!((LayoutParams)v3).isNestedScrollAccepted(v8)) {
                }
                else {
                    Behavior v3_1 = ((LayoutParams)v3).getBehavior();
                    if(v3_1 != null) {
                        int[] v9 = v1.mBehaviorConsumed;
                        v9[0] = 0;
                        v9[1] = 0;
                        v3_1.onNestedScroll(v1, v2, arg17, arg18, arg19, arg20, arg21, v8, v9);
                        int[] v0_1 = v1.mBehaviorConsumed;
                        v0 = arg20 > 0 ? Math.max(v13, v0_1[0]) : Math.min(v13, v0_1[0]);
                        v13 = v0;
                        v0_1 = v1.mBehaviorConsumed;
                        v0 = arg21 > 0 ? Math.max(v14, v0_1[1]) : Math.min(v14, v0_1[1]);
                        v14 = v0;
                        v0 = 1;
                    }
                }
            }

            ++v12;
        }

        arg23[0] += v13;
        arg23[1] += v14;
        if(v0 != 0) {
            v1.onChildViewsChanged(1);
        }
    }

    public void onNestedScrollAccepted(View arg2, View arg3, int arg4) {
        this.onNestedScrollAccepted(arg2, arg3, arg4, 0);
    }

    public void onNestedScrollAccepted(View arg10, View arg11, int arg12, int arg13) {
        int v8;
        int v7;
        View v6;
        View v5;
        CoordinatorLayout v3;
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(arg10, arg11, arg12, arg13);
        this.mNestedScrollingTarget = arg11;
        int v0 = this.getChildCount();
        int v1 = 0;
        while(v1 < v0) {
            View v4 = this.getChildAt(v1);
            ViewGroup$LayoutParams v2 = v4.getLayoutParams();
            if(!((LayoutParams)v2).isNestedScrollAccepted(arg13)) {
                goto label_20;
            }
            else {
                Behavior v2_1 = ((LayoutParams)v2).getBehavior();
                if(v2_1 != null) {
                    v3 = this;
                    v5 = arg10;
                    v6 = arg11;
                    v7 = arg12;
                    v8 = arg13;
                    v2_1.onNestedScrollAccepted(v3, v4, v5, v6, v7, v8);
                }
                else {
                label_20:
                    v3 = this;
                    v5 = arg10;
                    v6 = arg11;
                    v7 = arg12;
                    v8 = arg13;
                }
            }

            ++v1;
            this = v3;
            arg10 = v5;
            arg11 = v6;
            arg12 = v7;
            arg13 = v8;
        }
    }

    protected void onRestoreInstanceState(Parcelable arg7) {
        if(!(arg7 instanceof SavedState)) {
            super.onRestoreInstanceState(arg7);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg7).getSuperState());
        SparseArray v7 = ((SavedState)arg7).behaviorStates;
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getChildAt(v1);
            int v3 = v2.getId();
            Behavior v4 = this.getResolvedLayoutParams(v2).getBehavior();
            if(v3 != -1 && v4 != null) {
                Object v3_1 = v7.get(v3);
                if(v3_1 != null) {
                    v4.onRestoreInstanceState(this, v2, ((Parcelable)v3_1));
                }
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v0 = new SavedState(super.onSaveInstanceState());
        SparseArray v1 = new SparseArray();
        int v2 = this.getChildCount();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            View v4 = this.getChildAt(v3);
            int v5 = v4.getId();
            Behavior v6 = v4.getLayoutParams().getBehavior();
            if(v5 != -1 && v6 != null) {
                Parcelable v4_1 = v6.onSaveInstanceState(this, v4);
                if(v4_1 != null) {
                    v1.append(v5, v4_1);
                }
            }
        }

        v0.behaviorStates = v1;
        return ((Parcelable)v0);
    }

    public boolean onStartNestedScroll(View arg2, View arg3, int arg4) {
        return this.onStartNestedScroll(arg2, arg3, arg4, 0);
    }

    public boolean onStartNestedScroll(View arg13, View arg14, int arg15, int arg16) {
        int v7 = this.getChildCount();
        int v9 = 0;
        int v10 = 0;
        while(v9 < v7) {
            View v2 = this.getChildAt(v9);
            if(v2.getVisibility() == 8) {
            }
            else {
                ViewGroup$LayoutParams v11 = v2.getLayoutParams();
                Behavior v0 = ((LayoutParams)v11).getBehavior();
                if(v0 != null) {
                    boolean v0_1 = v0.onStartNestedScroll(this, v2, arg13, arg14, arg15, arg16);
                    v10 |= ((int)v0_1);
                    ((LayoutParams)v11).setNestedScrollAccepted(arg16, v0_1);
                }
                else {
                    ((LayoutParams)v11).setNestedScrollAccepted(arg16, false);
                }
            }

            ++v9;
        }

        return ((boolean)v10);
    }

    public void onStopNestedScroll(View arg2) {
        this.onStopNestedScroll(arg2, 0);
    }

    public void onStopNestedScroll(View arg6, int arg7) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(arg6, arg7);
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getChildAt(v1);
            ViewGroup$LayoutParams v3 = v2.getLayoutParams();
            if(!((LayoutParams)v3).isNestedScrollAccepted(arg7)) {
            }
            else {
                Behavior v4 = ((LayoutParams)v3).getBehavior();
                if(v4 != null) {
                    v4.onStopNestedScroll(this, v2, arg6, arg7);
                }

                ((LayoutParams)v3).resetNestedScroll(arg7);
                ((LayoutParams)v3).resetChangedAfterNestedScroll();
            }
        }

        this.mNestedScrollingTarget = null;
    }

    public boolean onTouchEvent(MotionEvent arg18) {
        int v6_2;
        boolean v3;
        CoordinatorLayout v0 = this;
        MotionEvent v1 = arg18;
        int v2 = v1.getActionMasked();
        if(v0.mBehaviorTouchView == null) {
            v3 = v0.performIntercept(v1, 1);
            if(v3) {
                goto label_11;
            }
            else {
                goto label_18;
            }
        }
        else {
            v3 = false;
        label_11:
            Behavior v6 = v0.mBehaviorTouchView.getLayoutParams().getBehavior();
            if(v6 != null) {
                boolean v6_1 = v6.onTouchEvent(v0, v0.mBehaviorTouchView, v1);
            }
            else {
            label_18:
                v6_2 = 0;
            }
        }

        MotionEvent v8 = null;
        if(v0.mBehaviorTouchView == null) {
            v6_2 |= super.onTouchEvent(arg18);
        }
        else if(v3) {
            long v9 = SystemClock.uptimeMillis();
            v8 = MotionEvent.obtain(v9, v9, 3, 0f, 0f, 0);
            super.onTouchEvent(v8);
        }

        if(v8 != null) {
            v8.recycle();
        }

        if(v2 != 1) {
            if(v2 == 3) {
            }
            else {
                return ((boolean)v6_2);
            }
        }

        v0.resetTouchBehaviors(false);
        return ((boolean)v6_2);
    }

    static Behavior parseBehavior(Context arg3, AttributeSet arg4, String arg5) {
        if(TextUtils.isEmpty(((CharSequence)arg5))) {
            return null;
        }

        if(arg5.startsWith(".")) {
            arg5 = arg3.getPackageName() + arg5;
        }
        else {
            char v0 = '.';
            if(arg5.indexOf(v0) >= 0) {
            }
            else {
                String v1 = CoordinatorLayout.WIDGET_PACKAGE_NAME;
                if(!TextUtils.isEmpty(((CharSequence)v1))) {
                    arg5 = v1 + v0 + arg5;
                }
            }
        }

        try {
            ThreadLocal v0_1 = CoordinatorLayout.sConstructors;
            Object v1_1 = v0_1.get();
            if(v1_1 == null) {
                HashMap v1_2 = new HashMap();
                v0_1.set(v1_2);
            }

            Object v0_2 = ((Map)v1_1).get(arg5);
            if(v0_2 == null) {
                Constructor v0_3 = Class.forName(arg5, false, arg3.getClassLoader()).getConstructor(CoordinatorLayout.CONSTRUCTOR_PARAMS);
                v0_3.setAccessible(true);
                ((Map)v1_1).put(arg5, v0_3);
            }

            return ((Constructor)v0_2).newInstance(arg3, arg4);
        }
        catch(Exception v3) {
            throw new RuntimeException("Could not inflate Behavior subclass " + arg5, ((Throwable)v3));
        }
    }

    private boolean performIntercept(MotionEvent arg24, int arg25) {
        CoordinatorLayout v0 = this;
        MotionEvent v1 = arg24;
        int v2 = arg25;
        int v3 = v1.getActionMasked();
        List v4 = v0.mTempList1;
        v0.getTopSortedChildren(v4);
        int v5 = v4.size();
        MotionEvent v7 = null;
        int v8 = 0;
        boolean v9 = false;
        int v10 = 0;
        while(v8 < v5) {
            Object v11 = v4.get(v8);
            ViewGroup$LayoutParams v12 = ((View)v11).getLayoutParams();
            Behavior v13 = ((LayoutParams)v12).getBehavior();
            if(!v9 && v10 == 0 || v3 == 0) {
                if(!v9 && v13 != null) {
                    if(v2 == 0) {
                        v9 = v13.onInterceptTouchEvent(v0, ((View)v11), v1);
                    }
                    else if(v2 != 1) {
                    }
                    else {
                        v9 = v13.onTouchEvent(v0, ((View)v11), v1);
                    }

                    if(!v9) {
                        goto label_46;
                    }

                    v0.mBehaviorTouchView = ((View)v11);
                }

            label_46:
                boolean v10_1 = ((LayoutParams)v12).didBlockInteraction();
                boolean v11_1 = ((LayoutParams)v12).isBlockingInteractionBelow(v0, ((View)v11));
                v10 = !v11_1 || (v10_1) ? 0 : 1;
                if(!v11_1) {
                    goto label_56;
                }

                if(v10 != 0) {
                    goto label_56;
                }

                break;
            }
            else if(v13 != null) {
                if(v7 == null) {
                    long v15 = SystemClock.uptimeMillis();
                    v7 = MotionEvent.obtain(v15, v15, 3, 0f, 0f, 0);
                }

                if(v2 != 0) {
                    if(v2 != 1) {
                        goto label_56;
                    }

                    v13.onTouchEvent(v0, ((View)v11), v7);
                    goto label_56;
                }

                v13.onInterceptTouchEvent(v0, ((View)v11), v7);
            }

        label_56:
            ++v8;
        }

        v4.clear();
        return v9;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int v0 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = this.getChildAt(v2);
            LayoutParams v4 = this.getResolvedLayoutParams(v3);
            v4.findAnchorView(this, v3);
            this.mChildDag.addNode(v3);
            int v5;
            for(v5 = 0; v5 < v0; ++v5) {
                if(v5 == v2) {
                }
                else {
                    View v6 = this.getChildAt(v5);
                    if(v4.dependsOn(this, v3, v6)) {
                        if(!this.mChildDag.contains(v6)) {
                            this.mChildDag.addNode(v6);
                        }

                        this.mChildDag.addEdge(v6, v3);
                    }
                }
            }
        }

        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    void recordLastChildRect(View arg1, Rect arg2) {
        arg1.getLayoutParams().setLastChildRect(arg2);
    }

    private static void releaseTempRect(Rect arg1) {
        arg1.setEmpty();
        CoordinatorLayout.sRectPool.release(arg1);
    }

    void removePreDrawListener() {
        if((this.mIsAttachedToWindow) && this.mOnPreDrawListener != null) {
            this.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }

        this.mNeedsPreDrawListener = false;
    }

    public boolean requestChildRectangleOnScreen(View arg2, Rect arg3, boolean arg4) {
        Behavior v0 = arg2.getLayoutParams().getBehavior();
        if(v0 != null && (v0.onRequestChildRectangleOnScreen(this, arg2, arg3, arg4))) {
            return 1;
        }

        return super.requestChildRectangleOnScreen(arg2, arg3, arg4);
    }

    public void requestDisallowInterceptTouchEvent(boolean arg1) {
        super.requestDisallowInterceptTouchEvent(arg1);
        if((arg1) && !this.mDisallowInterceptReset) {
            this.resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    private void resetTouchBehaviors(boolean arg14) {
        int v0 = this.getChildCount();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            View v3 = this.getChildAt(v2);
            Behavior v4 = v3.getLayoutParams().getBehavior();
            if(v4 != null) {
                long v5 = SystemClock.uptimeMillis();
                MotionEvent v5_1 = MotionEvent.obtain(v5, v5, 3, 0f, 0f, 0);
                if(arg14) {
                    v4.onInterceptTouchEvent(this, v3, v5_1);
                }
                else {
                    v4.onTouchEvent(this, v3, v5_1);
                }

                v5_1.recycle();
            }
        }

        int v14;
        for(v14 = 0; v14 < v0; ++v14) {
            this.getChildAt(v14).getLayoutParams().resetTouchBehaviorTracking();
        }

        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int arg0) {
        if(arg0 == 0) {
            arg0 = 17;
        }

        return arg0;
    }

    private static int resolveGravity(int arg1) {
        if((arg1 & 7) == 0) {
            arg1 |= 0x800003;
        }

        if((arg1 & 0x70) == 0) {
            arg1 |= 0x30;
        }

        return arg1;
    }

    private static int resolveKeylineGravity(int arg0) {
        if(arg0 == 0) {
            arg0 = 0x800035;
        }

        return arg0;
    }

    public void setFitsSystemWindows(boolean arg1) {
        super.setFitsSystemWindows(arg1);
        this.setupForInsets();
    }

    private void setInsetOffsetX(View arg2, int arg3) {
        ViewGroup$LayoutParams v1 = arg2.getLayoutParams();
        if(((LayoutParams)v1).mInsetOffsetX != arg3) {
            ViewCompat.offsetLeftAndRight(arg2, arg3 - ((LayoutParams)v1).mInsetOffsetX);
            ((LayoutParams)v1).mInsetOffsetX = arg3;
        }
    }

    private void setInsetOffsetY(View arg2, int arg3) {
        ViewGroup$LayoutParams v1 = arg2.getLayoutParams();
        if(((LayoutParams)v1).mInsetOffsetY != arg3) {
            ViewCompat.offsetTopAndBottom(arg2, arg3 - ((LayoutParams)v1).mInsetOffsetY);
            ((LayoutParams)v1).mInsetOffsetY = arg3;
        }
    }

    public void setOnHierarchyChangeListener(ViewGroup$OnHierarchyChangeListener arg1) {
        this.mOnHierarchyChangeListener = arg1;
    }

    public void setStatusBarBackground(Drawable arg3) {
        Drawable v1_1;
        Drawable v0 = this.mStatusBarBackground;
        if(v0 != arg3) {
            Drawable$Callback v1 = null;
            if(v0 != null) {
                v0.setCallback(v1);
            }

            if(arg3 != null) {
                v1_1 = arg3.mutate();
            }

            this.mStatusBarBackground = v1_1;
            if(v1_1 != null) {
                if(v1_1.isStateful()) {
                    this.mStatusBarBackground.setState(this.getDrawableState());
                }

                DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(((View)this)));
                arg3 = this.mStatusBarBackground;
                boolean v0_1 = this.getVisibility() == 0 ? true : false;
                arg3.setVisible(v0_1, false);
                this.mStatusBarBackground.setCallback(((Drawable$Callback)this));
            }

            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    public void setStatusBarBackgroundColor(int arg2) {
        this.setStatusBarBackground(new ColorDrawable(arg2));
    }

    public void setStatusBarBackgroundResource(int arg2) {
        Drawable v2 = arg2 != 0 ? ContextCompat.getDrawable(this.getContext(), arg2) : null;
        this.setStatusBarBackground(v2);
    }

    public void setVisibility(int arg3) {
        super.setVisibility(arg3);
        boolean v3 = arg3 == 0 ? true : false;
        Drawable v1 = this.mStatusBarBackground;
        if(v1 != null && v1.isVisible() != v3) {
            this.mStatusBarBackground.setVisible(v3, false);
        }
    }

    final WindowInsetsCompat setWindowInsets(WindowInsetsCompat arg4) {
        if(!ObjectsCompat.equals(this.mLastInsets, arg4)) {
            this.mLastInsets = arg4;
            boolean v0 = true;
            boolean v2 = arg4 == null || arg4.getSystemWindowInsetTop() <= 0 ? false : true;
            this.mDrawStatusBarBackground = v2;
            if((v2) || this.getBackground() != null) {
                v0 = false;
            }
            else {
            }

            this.setWillNotDraw(v0);
            arg4 = this.dispatchApplyWindowInsetsToBehaviors(arg4);
            this.requestLayout();
        }

        return arg4;
    }

    private void setupForInsets() {
        if(ViewCompat.getFitsSystemWindows(((View)this))) {
            if(this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat onApplyWindowInsets(View arg1, WindowInsetsCompat arg2) {
                        return CoordinatorLayout.this.setWindowInsets(arg2);
                    }
                };
            }

            ViewCompat.setOnApplyWindowInsetsListener(((View)this), this.mApplyWindowInsetsListener);
            this.setSystemUiVisibility(0x500);
            return;
        }

        ViewCompat.setOnApplyWindowInsetsListener(((View)this), null);
    }

    protected boolean verifyDrawable(Drawable arg2) {
        if(!super.verifyDrawable(arg2)) {
            if(arg2 == this.mStatusBarBackground) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

