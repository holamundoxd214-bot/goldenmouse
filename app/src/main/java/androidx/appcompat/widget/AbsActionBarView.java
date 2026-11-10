package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

abstract class AbsActionBarView extends ViewGroup {
    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean mCanceled;
        int mFinalVisibility;

        protected VisibilityAnimListener(AbsActionBarView arg1) {
            AbsActionBarView.this = arg1;
            super();
            this.mCanceled = false;
        }

        public void onAnimationCancel(View arg1) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(View arg2) {
            if(this.mCanceled) {
                return;
            }

            AbsActionBarView.this.mVisibilityAnim = null;
            AbsActionBarView.access$101(AbsActionBarView.this, this.mFinalVisibility);
        }

        public void onAnimationStart(View arg2) {
            AbsActionBarView.access$001(AbsActionBarView.this, 0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat arg2, int arg3) {
            AbsActionBarView.this.mVisibilityAnim = arg2;
            this.mFinalVisibility = arg3;
            return this;
        }
    }

    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    AbsActionBarView(Context arg2) {
        this(arg2, null);
    }

    AbsActionBarView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    AbsActionBarView(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        TypedValue v4 = new TypedValue();
        if((arg3.getTheme().resolveAttribute(attr.actionBarPopupTheme, v4, true)) && v4.resourceId != 0) {
            this.mPopupContext = new ContextThemeWrapper(arg3, v4.resourceId);
            return;
        }

        this.mPopupContext = arg3;
    }

    static void access$001(AbsActionBarView arg0, int arg1) {
        super.setVisibility(arg1);
    }

    static void access$101(AbsActionBarView arg0, int arg1) {
        super.setVisibility(arg1);
    }

    public void animateToVisibility(int arg3) {
        this.setupAnimatorToVisibility(arg3, 200).start();
    }

    public boolean canShowOverflowMenu() {
        if((this.isOverflowReserved()) && this.getVisibility() == 0) {
            return 1;
        }

        return 0;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter v0 = this.mActionMenuPresenter;
        if(v0 != null) {
            v0.dismissPopupMenus();
        }
    }

    public int getAnimatedVisibility() {
        if(this.mVisibilityAnim != null) {
            return this.mVisAnimListener.mFinalVisibility;
        }

        return this.getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter v0 = this.mActionMenuPresenter;
        if(v0 != null) {
            return v0.hideOverflowMenu();
        }

        return 0;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter v0 = this.mActionMenuPresenter;
        if(v0 != null) {
            return v0.isOverflowMenuShowPending();
        }

        return 0;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter v0 = this.mActionMenuPresenter;
        if(v0 != null) {
            return v0.isOverflowMenuShowing();
        }

        return 0;
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter v0 = this.mActionMenuPresenter;
        if(v0 != null && (v0.isOverflowReserved())) {
            return 1;
        }

        return 0;
    }

    protected int measureChildView(View arg1, int arg2, int arg3, int arg4) {
        arg1.measure(View$MeasureSpec.makeMeasureSpec(arg2, 0x80000000), arg3);
        return Math.max(0, arg2 - arg1.getMeasuredWidth() - arg4);
    }

    protected static int next(int arg0, int arg1, boolean arg2) {
        if(arg2) {
            return arg0 - arg1;
        }

        return arg0 + arg1;
    }

    protected void onConfigurationChanged(Configuration arg6) {
        super.onConfigurationChanged(arg6);
        TypedArray v0 = this.getContext().obtainStyledAttributes(null, styleable.ActionBar, attr.actionBarStyle, 0);
        this.setContentHeight(v0.getLayoutDimension(styleable.ActionBar_height, 0));
        v0.recycle();
        ActionMenuPresenter v5 = this.mActionMenuPresenter;
        if(v5 != null) {
            v5.onConfigurationChanged(arg6);
        }
    }

    public boolean onHoverEvent(MotionEvent arg6) {
        int v0 = arg6.getActionMasked();
        int v2 = 9;
        if(v0 == v2) {
            this.mEatingHover = false;
        }

        if(!this.mEatingHover) {
            boolean v6 = super.onHoverEvent(arg6);
            if(v0 == v2 && !v6) {
                this.mEatingHover = true;
            }
        }

        if(v0 == 10 || v0 == 3) {
            this.mEatingHover = false;
        }

        return 1;
    }

    public boolean onTouchEvent(MotionEvent arg5) {
        int v0 = arg5.getActionMasked();
        if(v0 == 0) {
            this.mEatingTouch = false;
        }

        if(!this.mEatingTouch) {
            boolean v5 = super.onTouchEvent(arg5);
            if(v0 == 0 && !v5) {
                this.mEatingTouch = true;
            }
        }

        if(v0 == 1 || v0 == 3) {
            this.mEatingTouch = false;
        }

        return 1;
    }

    protected int positionChild(View arg2, int arg3, int arg4, int arg5, boolean arg6) {
        int v1 = arg2.getMeasuredWidth();
        int v0 = arg2.getMeasuredHeight();
        arg4 += (arg5 - v0) / 2;
        if(arg6) {
            arg2.layout(arg3 - v1, arg4, arg3, v0 + arg4);
        }
        else {
            arg2.layout(arg3, arg4, arg3 + v1, v0 + arg4);
        }

        if(arg6) {
            v1 = -v1;
        }

        return v1;
    }

    public void postShowOverflowMenu() {
        this.post(new Runnable() {
            public void run() {
                AbsActionBarView.this.showOverflowMenu();
            }
        });
    }

    public void setContentHeight(int arg1) {
        this.mContentHeight = arg1;
        this.requestLayout();
    }

    public void setVisibility(int arg2) {
        if(arg2 != this.getVisibility()) {
            ViewPropertyAnimatorCompat v0 = this.mVisibilityAnim;
            if(v0 != null) {
                v0.cancel();
            }

            super.setVisibility(arg2);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int arg3, long arg4) {
        ViewPropertyAnimatorCompat v0 = this.mVisibilityAnim;
        if(v0 != null) {
            v0.cancel();
        }

        if(arg3 == 0) {
            if(this.getVisibility() != 0) {
                this.setAlpha(0f);
            }

            v0 = ViewCompat.animate(((View)this)).alpha(1f);
            v0.setDuration(arg4);
            v0.setListener(this.mVisAnimListener.withFinalVisibility(v0, arg3));
            return v0;
        }

        v0 = ViewCompat.animate(((View)this)).alpha(0f);
        v0.setDuration(arg4);
        v0.setListener(this.mVisAnimListener.withFinalVisibility(v0, arg3));
        return v0;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter v0 = this.mActionMenuPresenter;
        if(v0 != null) {
            return v0.showOverflowMenu();
        }

        return 0;
    }
}

