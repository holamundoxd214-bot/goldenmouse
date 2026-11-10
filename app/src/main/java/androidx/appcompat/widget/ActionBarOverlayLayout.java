package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window$Callback;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import androidx.core.view.WindowInsetsCompat;

public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent2, NestedScrollingParent3, NestedScrollingParent {
    class androidx.appcompat.widget.ActionBarOverlayLayout$1 extends AnimatorListenerAdapter {
        androidx.appcompat.widget.ActionBarOverlayLayout$1(ActionBarOverlayLayout arg1) {
            ActionBarOverlayLayout.this = arg1;
            super();
        }

        public void onAnimationCancel(Animator arg2) {
            ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
            ActionBarOverlayLayout.this.mAnimatingForFling = false;
        }

        public void onAnimationEnd(Animator arg2) {
            ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
            ActionBarOverlayLayout.this.mAnimatingForFling = false;
        }
    }

    class androidx.appcompat.widget.ActionBarOverlayLayout$2 implements Runnable {
        androidx.appcompat.widget.ActionBarOverlayLayout$2(ActionBarOverlayLayout arg1) {
            ActionBarOverlayLayout.this = arg1;
            super();
        }

        public void run() {
            ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
            ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ActionBarOverlayLayout.this.mActionBarTop.animate().translationY(0f).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
        }
    }

    class androidx.appcompat.widget.ActionBarOverlayLayout$3 implements Runnable {
        androidx.appcompat.widget.ActionBarOverlayLayout$3(ActionBarOverlayLayout arg1) {
            ActionBarOverlayLayout.this = arg1;
            super();
        }

        public void run() {
            ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
            ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ActionBarOverlayLayout.this.mActionBarTop.animate().translationY(((float)(-ActionBarOverlayLayout.this.mActionBarTop.getHeight()))).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
        }
    }

    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean arg1);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int arg1);

        void showForSystem();
    }

    public class LayoutParams extends ViewGroup$MarginLayoutParams {
        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
        }

        public LayoutParams(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg1) {
            super(arg1);
        }
    }

    private static final int ACTION_BAR_ANIMATE_DELAY = 600;
    static final int[] ATTRS = null;
    private static final String TAG = "ActionBarOverlayLayout";
    private int mActionBarHeight;
    ActionBarContainer mActionBarTop;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    boolean mAnimatingForFling;
    private final Rect mBaseContentInsets;
    private WindowInsetsCompat mBaseInnerInsets;
    private final Rect mBaseInnerInsetsRect;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    ViewPropertyAnimator mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private OverScroller mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    private WindowInsetsCompat mInnerInsets;
    private final Rect mInnerInsetsRect;
    private final Rect mLastBaseContentInsets;
    private WindowInsetsCompat mLastBaseInnerInsets;
    private final Rect mLastBaseInnerInsetsRect;
    private WindowInsetsCompat mLastInnerInsets;
    private final Rect mLastInnerInsetsRect;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    final AnimatorListenerAdapter mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;

    static {
        ActionBarOverlayLayout.ATTRS = new int[]{attr.actionBarSize, 0x1010059};
    }

    public ActionBarOverlayLayout(Context arg2) {
        this(arg2, null);
    }

    public ActionBarOverlayLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsetsRect = new Rect();
        this.mLastBaseInnerInsetsRect = new Rect();
        this.mInnerInsetsRect = new Rect();
        this.mLastInnerInsetsRect = new Rect();
        this.mBaseInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mLastBaseInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mLastInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mTopAnimatorListener = new androidx.appcompat.widget.ActionBarOverlayLayout$1(this);
        this.mRemoveActionBarHideOffset = new androidx.appcompat.widget.ActionBarOverlayLayout$2(this);
        this.mAddActionBarHideOffset = new androidx.appcompat.widget.ActionBarOverlayLayout$3(this);
        this.init(arg1);
        this.mParentHelper = new NestedScrollingParentHelper(((ViewGroup)this));
    }

    private void addActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private boolean applyInsets(View arg2, Rect arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7) {
        ViewGroup$LayoutParams v1 = arg2.getLayoutParams();
        if(!arg4 || ((LayoutParams)v1).leftMargin == arg3.left) {
            arg4 = false;
        }
        else {
            ((LayoutParams)v1).leftMargin = arg3.left;
            arg4 = true;
        }

        if((arg5) && ((LayoutParams)v1).topMargin != arg3.top) {
            ((LayoutParams)v1).topMargin = arg3.top;
            arg4 = true;
        }

        if((arg7) && ((LayoutParams)v1).rightMargin != arg3.right) {
            ((LayoutParams)v1).rightMargin = arg3.right;
            arg4 = true;
        }

        if((arg6) && ((LayoutParams)v1).bottomMargin != arg3.bottom) {
            ((LayoutParams)v1).bottomMargin = arg3.bottom;
            return 1;
        }

        return arg4;
    }

    public boolean canShowOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg1) {
        return arg1 instanceof LayoutParams;
    }

    public void dismissPopups() {
        this.pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    public void draw(Canvas arg6) {
        super.draw(arg6);
        if(this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
            int v0 = this.mActionBarTop.getVisibility() == 0 ? ((int)((((float)this.mActionBarTop.getBottom())) + this.mActionBarTop.getTranslationY() + 0.5f)) : 0;
            this.mWindowContentOverlay.setBounds(0, v0, this.getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + v0);
            this.mWindowContentOverlay.draw(arg6);
        }
    }

    protected boolean fitSystemWindows(Rect arg1) {
        return super.fitSystemWindows(arg1);
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    public LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return new LayoutParams(arg1);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer v0 = this.mActionBarTop;
        if(v0 != null) {
            return -(((int)v0.getTranslationY()));
        }

        return 0;
    }

    private DecorToolbar getDecorToolbar(View arg3) {
        if((arg3 instanceof DecorToolbar)) {
            return arg3;
        }

        if((arg3 instanceof Toolbar)) {
            return ((Toolbar)arg3).getWrapper();
        }

        throw new IllegalStateException("Can\'t make a decor toolbar out of " + arg3.getClass().getSimpleName());
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        this.pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    void haltActionBarHideOffsetAnimations() {
        this.removeCallbacks(this.mRemoveActionBarHideOffset);
        this.removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator v1 = this.mCurrentActionBarTopAnimator;
        if(v1 != null) {
            v1.cancel();
        }
    }

    public boolean hasIcon() {
        this.pullChildren();
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        this.pullChildren();
        return this.mDecorToolbar.hasLogo();
    }

    public boolean hideOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    private void init(Context arg5) {
        TypedArray v0 = this.getContext().getTheme().obtainStyledAttributes(ActionBarOverlayLayout.ATTRS);
        boolean v1 = false;
        this.mActionBarHeight = v0.getDimensionPixelSize(0, 0);
        Drawable v3 = v0.getDrawable(1);
        this.mWindowContentOverlay = v3;
        boolean v3_1 = v3 == null ? true : false;
        this.setWillNotDraw(v3_1);
        v0.recycle();
        if(arg5.getApplicationInfo().targetSdkVersion < 19) {
            v1 = true;
        }

        this.mIgnoreWindowContentOverlay = v1;
        this.mFlingEstimator = new OverScroller(arg5);
    }

    public void initFeature(int arg2) {
        this.pullChildren();
        if(arg2 != 2) {
            if(arg2 != 5) {
                if(arg2 != 109) {
                    return;
                }

                this.setOverlayMode(true);
                return;
            }

            this.mDecorToolbar.initIndeterminateProgress();
            return;
        }

        this.mDecorToolbar.initProgress();
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }

    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }

    public boolean isOverflowMenuShowPending() {
        this.pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        this.pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    public WindowInsets onApplyWindowInsets(WindowInsets arg8) {
        this.pullChildren();
        WindowInsetsCompat v8 = WindowInsetsCompat.toWindowInsetsCompat(arg8, ((View)this));
        ActionBarOverlayLayout v0 = this;
        boolean v7 = v0.applyInsets(this.mActionBarTop, new Rect(v8.getSystemWindowInsetLeft(), v8.getSystemWindowInsetTop(), v8.getSystemWindowInsetRight(), v8.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(((View)v0), v8, v0.mBaseContentInsets);
        WindowInsetsCompat v1 = v8.inset(v0.mBaseContentInsets.left, v0.mBaseContentInsets.top, v0.mBaseContentInsets.right, v0.mBaseContentInsets.bottom);
        v0.mBaseInnerInsets = v1;
        boolean v2 = true;
        if(!v0.mLastBaseInnerInsets.equals(v1)) {
            v0.mLastBaseInnerInsets = v0.mBaseInnerInsets;
            v7 = true;
        }

        if(!v0.mLastBaseContentInsets.equals(v0.mBaseContentInsets)) {
            v0.mLastBaseContentInsets.set(v0.mBaseContentInsets);
        }
        else {
            v2 = v7;
        }

        if(v2) {
            v0.requestLayout();
        }

        return v8.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    protected void onConfigurationChanged(Configuration arg1) {
        super.onConfigurationChanged(arg1);
        this.init(this.getContext());
        ViewCompat.requestApplyInsets(((View)this));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.haltActionBarHideOffsetAnimations();
    }

    protected void onLayout(boolean arg5, int arg6, int arg7, int arg8, int arg9) {
        int v5 = this.getChildCount();
        arg6 = this.getPaddingLeft();
        arg7 = this.getPaddingTop();
        for(arg8 = 0; arg8 < v5; ++arg8) {
            View v9 = this.getChildAt(arg8);
            if(v9.getVisibility() != 8) {
                ViewGroup$LayoutParams v0 = v9.getLayoutParams();
                int v1 = v9.getMeasuredWidth();
                int v2 = v9.getMeasuredHeight();
                int v3 = ((LayoutParams)v0).leftMargin + arg6;
                int v0_1 = ((LayoutParams)v0).topMargin + arg7;
                v9.layout(v3, v0_1, v1 + v3, v2 + v0_1);
            }
        }
    }

    protected void onMeasure(int arg14, int arg15) {
        int v3;
        this.pullChildren();
        int v2 = arg14;
        int v4 = arg15;
        this.measureChildWithMargins(this.mActionBarTop, v2, 0, v4, 0);
        ActionBarOverlayLayout v6 = this;
        ViewGroup$LayoutParams v13 = v6.mActionBarTop.getLayoutParams();
        arg14 = Math.max(0, v6.mActionBarTop.getMeasuredWidth() + ((LayoutParams)v13).leftMargin + ((LayoutParams)v13).rightMargin);
        int v13_1 = Math.max(0, v6.mActionBarTop.getMeasuredHeight() + ((LayoutParams)v13).topMargin + ((LayoutParams)v13).bottomMargin);
        int v0 = View.combineMeasuredStates(0, v6.mActionBarTop.getMeasuredState());
        int v1 = (ViewCompat.getWindowSystemUiVisibility(((View)v6)) & 0x100) != 0 ? 1 : 0;
        if(v1 != 0) {
            v3 = v6.mActionBarHeight;
            if((v6.mHasNonEmbeddedTabs) && v6.mActionBarTop.getTabContainer() != null) {
                v3 += v6.mActionBarHeight;
            }
        }
        else if(v6.mActionBarTop.getVisibility() != 8) {
            v3 = v6.mActionBarTop.getMeasuredHeight();
        }
        else {
            v3 = 0;
        }

        v6.mContentInsets.set(v6.mBaseContentInsets);
        v6.mInnerInsets = v6.mBaseInnerInsets;
        if((v6.mOverlayMode) || v1 != 0) {
            v6.mInnerInsets = new Builder(v6.mInnerInsets).setSystemWindowInsets(Insets.of(v6.mInnerInsets.getSystemWindowInsetLeft(), v6.mInnerInsets.getSystemWindowInsetTop() + v3, v6.mInnerInsets.getSystemWindowInsetRight(), v6.mInnerInsets.getSystemWindowInsetBottom())).build();
        }
        else {
            v6.mContentInsets.top += v3;
            v6.mContentInsets.bottom = v6.mContentInsets.bottom;
            v6.mInnerInsets = v6.mInnerInsets.inset(0, v3, 0, 0);
        }

        v6.applyInsets(v6.mContent, v6.mContentInsets, true, true, true, true);
        if(!v6.mLastInnerInsets.equals(v6.mInnerInsets)) {
            WindowInsetsCompat v15 = v6.mInnerInsets;
            v6.mLastInnerInsets = v15;
            ViewCompat.dispatchApplyWindowInsets(v6.mContent, v15);
        }

        v6.measureChildWithMargins(v6.mContent, v2, 0, v4, 0);
        ViewGroup$LayoutParams v15_1 = v6.mContent.getLayoutParams();
        arg14 = Math.max(arg14, v6.mContent.getMeasuredWidth() + ((LayoutParams)v15_1).leftMargin + ((LayoutParams)v15_1).rightMargin);
        v13_1 = Math.max(v13_1, v6.mContent.getMeasuredHeight() + ((LayoutParams)v15_1).topMargin + ((LayoutParams)v15_1).bottomMargin);
        arg15 = View.combineMeasuredStates(v0, v6.mContent.getMeasuredState());
        v6.setMeasuredDimension(View.resolveSizeAndState(Math.max(arg14 + (v6.getPaddingLeft() + v6.getPaddingRight()), v6.getSuggestedMinimumWidth()), v2, arg15), View.resolveSizeAndState(Math.max(v13_1 + (v6.getPaddingTop() + v6.getPaddingBottom()), v6.getSuggestedMinimumHeight()), v4, arg15 << 16));
    }

    public boolean onNestedFling(View arg1, float arg2, float arg3, boolean arg4) {
        if(this.mHideOnContentScroll) {
            if(!arg4) {
            }
            else {
                if(this.shouldHideActionBarOnFling(arg3)) {
                    this.addActionBarHideOffset();
                }
                else {
                    this.removeActionBarHideOffset();
                }

                this.mAnimatingForFling = true;
                return 1;
            }
        }

        return 0;
    }

    public boolean onNestedPreFling(View arg1, float arg2, float arg3) {
        return 0;
    }

    public void onNestedPreScroll(View arg1, int arg2, int arg3, int[] arg4) {
    }

    public void onNestedPreScroll(View arg1, int arg2, int arg3, int[] arg4, int arg5) {
        if(arg5 == 0) {
            this.onNestedPreScroll(arg1, arg2, arg3, arg4);
        }
    }

    public void onNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5) {
        int v1 = this.mHideOnContentScrollReference + arg3;
        this.mHideOnContentScrollReference = v1;
        this.setActionBarHideOffset(v1);
    }

    public void onNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        if(arg6 == 0) {
            this.onNestedScroll(arg1, arg2, arg3, arg4, arg5);
        }
    }

    public void onNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int[] arg7) {
        this.onNestedScroll(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void onNestedScrollAccepted(View arg2, View arg3, int arg4) {
        this.mParentHelper.onNestedScrollAccepted(arg2, arg3, arg4);
        this.mHideOnContentScrollReference = this.getActionBarHideOffset();
        this.haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback v1 = this.mActionBarVisibilityCallback;
        if(v1 != null) {
            v1.onContentScrollStarted();
        }
    }

    public void onNestedScrollAccepted(View arg1, View arg2, int arg3, int arg4) {
        if(arg4 == 0) {
            this.onNestedScrollAccepted(arg1, arg2, arg3);
        }
    }

    public boolean onStartNestedScroll(View arg1, View arg2, int arg3) {
        if((arg3 & 2) != 0) {
            if(this.mActionBarTop.getVisibility() != 0) {
            }
            else {
                return this.mHideOnContentScroll;
            }
        }

        return 0;
    }

    public boolean onStartNestedScroll(View arg1, View arg2, int arg3, int arg4) {
        if(arg4 == 0 && (this.onStartNestedScroll(arg1, arg2, arg3))) {
            return 1;
        }

        return 0;
    }

    public void onStopNestedScroll(View arg2) {
        if((this.mHideOnContentScroll) && !this.mAnimatingForFling) {
            if(this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
                this.postRemoveActionBarHideOffset();
            }
            else {
                this.postAddActionBarHideOffset();
            }
        }

        ActionBarVisibilityCallback v1 = this.mActionBarVisibilityCallback;
        if(v1 != null) {
            v1.onContentScrollStopped();
        }
    }

    public void onStopNestedScroll(View arg1, int arg2) {
        if(arg2 == 0) {
            this.onStopNestedScroll(arg1);
        }
    }

    @Deprecated public void onWindowSystemUiVisibilityChanged(int arg5) {
        super.onWindowSystemUiVisibilityChanged(arg5);
        this.pullChildren();
        int v0 = this.mLastSystemUiVisibility ^ arg5;
        this.mLastSystemUiVisibility = arg5;
        int v2 = 0;
        int v1 = (arg5 & 4) == 0 ? 1 : 0;
        if((arg5 & 0x100) != 0) {
            v2 = 1;
        }

        ActionBarVisibilityCallback v5 = this.mActionBarVisibilityCallback;
        if(v5 != null) {
            v5.enableContentAnimations(v2 ^ 1);
            if(v1 == 0) {
                if(v2 == 0) {
                }
                else {
                    this.mActionBarVisibilityCallback.hideForSystem();
                    goto label_27;
                }
            }

            this.mActionBarVisibilityCallback.showForSystem();
        }

    label_27:
        if((v0 & 0x100) != 0 && this.mActionBarVisibilityCallback != null) {
            ViewCompat.requestApplyInsets(((View)this));
        }
    }

    protected void onWindowVisibilityChanged(int arg1) {
        super.onWindowVisibilityChanged(arg1);
        this.mWindowVisibility = arg1;
        ActionBarVisibilityCallback v0 = this.mActionBarVisibilityCallback;
        if(v0 != null) {
            v0.onWindowVisibilityChanged(arg1);
        }
    }

    private void postAddActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.postDelayed(this.mAddActionBarHideOffset, 600);
    }

    private void postRemoveActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.postDelayed(this.mRemoveActionBarHideOffset, 600);
    }

    void pullChildren() {
        if(this.mContent == null) {
            this.mContent = this.findViewById(id.action_bar_activity_content);
            this.mActionBarTop = this.findViewById(id.action_bar_container);
            this.mDecorToolbar = this.getDecorToolbar(this.findViewById(id.action_bar));
        }
    }

    private void removeActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
    }

    public void restoreToolbarHierarchyState(SparseArray arg1) {
        this.pullChildren();
        this.mDecorToolbar.restoreHierarchyState(arg1);
    }

    public void saveToolbarHierarchyState(SparseArray arg1) {
        this.pullChildren();
        this.mDecorToolbar.saveHierarchyState(arg1);
    }

    public void setActionBarHideOffset(int arg3) {
        this.haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY(((float)(-Math.max(0, Math.min(arg3, this.mActionBarTop.getHeight())))));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback arg2) {
        this.mActionBarVisibilityCallback = arg2;
        if(this.getWindowToken() != null) {
            this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
            int v2 = this.mLastSystemUiVisibility;
            if(v2 != 0) {
                this.onWindowSystemUiVisibilityChanged(v2);
                ViewCompat.requestApplyInsets(((View)this));
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean arg1) {
        this.mHasNonEmbeddedTabs = arg1;
    }

    public void setHideOnContentScrollEnabled(boolean arg2) {
        if(arg2 != this.mHideOnContentScroll) {
            this.mHideOnContentScroll = arg2;
            if(!arg2) {
                this.haltActionBarHideOffsetAnimations();
                this.setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int arg1) {
        this.pullChildren();
        this.mDecorToolbar.setIcon(arg1);
    }

    public void setIcon(Drawable arg1) {
        this.pullChildren();
        this.mDecorToolbar.setIcon(arg1);
    }

    public void setLogo(int arg1) {
        this.pullChildren();
        this.mDecorToolbar.setLogo(arg1);
    }

    public void setMenu(Menu arg1, Callback arg2) {
        this.pullChildren();
        this.mDecorToolbar.setMenu(arg1, arg2);
    }

    public void setMenuPrepared() {
        this.pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean arg2) {
        this.mOverlayMode = arg2;
        arg2 = !arg2 || this.getContext().getApplicationInfo().targetSdkVersion >= 19 ? false : true;
        this.mIgnoreWindowContentOverlay = arg2;
    }

    public void setShowingForActionMode(boolean arg1) {
    }

    public void setUiOptions(int arg1) {
    }

    public void setWindowCallback(Window$Callback arg1) {
        this.pullChildren();
        this.mDecorToolbar.setWindowCallback(arg1);
    }

    public void setWindowTitle(CharSequence arg1) {
        this.pullChildren();
        this.mDecorToolbar.setWindowTitle(arg1);
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }

    private boolean shouldHideActionBarOnFling(float arg10) {
        this.mFlingEstimator.fling(0, 0, 0, ((int)arg10), 0, 0, 0x80000000, 0x7FFFFFFF);
        if(this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight()) {
            return 1;
        }

        return 0;
    }

    public boolean showOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }
}

