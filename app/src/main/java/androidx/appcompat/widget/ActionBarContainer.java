package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode$Callback;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

public class ActionBarContainer extends FrameLayout {
    class Api21Impl {
        private Api21Impl() {
            super();
        }

        public static void invalidateOutline(ActionBarContainer arg0) {
            arg0.invalidateOutline();
        }
    }

    private View mActionBarView;
    Drawable mBackground;
    private View mContextView;
    private int mHeight;
    boolean mIsSplit;
    boolean mIsStacked;
    private boolean mIsTransitioning;
    Drawable mSplitBackground;
    Drawable mStackedBackground;
    private View mTabContainer;

    public ActionBarContainer(Context arg2) {
        this(arg2, null);
    }

    public ActionBarContainer(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        ViewCompat.setBackground(((View)this), new ActionBarBackgroundDrawable(this));
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, styleable.ActionBar);
        this.mBackground = v3.getDrawable(styleable.ActionBar_background);
        this.mStackedBackground = v3.getDrawable(styleable.ActionBar_backgroundStacked);
        this.mHeight = v3.getDimensionPixelSize(styleable.ActionBar_height, -1);
        boolean v1 = true;
        if(this.getId() == id.split_action_bar) {
            this.mIsSplit = true;
            this.mSplitBackground = v3.getDrawable(styleable.ActionBar_backgroundSplit);
        }

        v3.recycle();
        if(this.mIsSplit) {
            if(this.mSplitBackground == null) {
            }
            else {
                goto label_36;
            }
        }
        else if(this.mBackground != null) {
        label_36:
            v1 = false;
        }
        else if(this.mStackedBackground == null) {
        }
        else {
            goto label_36;
        }

        this.setWillNotDraw(v1);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable v0 = this.mBackground;
        if(v0 != null && (v0.isStateful())) {
            this.mBackground.setState(this.getDrawableState());
        }

        v0 = this.mStackedBackground;
        if(v0 != null && (v0.isStateful())) {
            this.mStackedBackground.setState(this.getDrawableState());
        }

        v0 = this.mSplitBackground;
        if(v0 != null && (v0.isStateful())) {
            this.mSplitBackground.setState(this.getDrawableState());
        }
    }

    private int getMeasuredHeightWithMargins(View arg2) {
        ViewGroup$LayoutParams v1 = arg2.getLayoutParams();
        return arg2.getMeasuredHeight() + ((FrameLayout$LayoutParams)v1).topMargin + ((FrameLayout$LayoutParams)v1).bottomMargin;
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    private boolean isCollapsed(View arg2) {
        if(arg2 != null && arg2.getVisibility() != 8) {
            if(arg2.getMeasuredHeight() == 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable v0 = this.mBackground;
        if(v0 != null) {
            v0.jumpToCurrentState();
        }

        v0 = this.mStackedBackground;
        if(v0 != null) {
            v0.jumpToCurrentState();
        }

        Drawable v1 = this.mSplitBackground;
        if(v1 != null) {
            v1.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = this.findViewById(id.action_bar);
        this.mContextView = this.findViewById(id.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent arg1) {
        super.onHoverEvent(arg1);
        return 1;
    }

    public boolean onInterceptTouchEvent(MotionEvent arg2) {
        if(!this.mIsTransitioning) {
            if(super.onInterceptTouchEvent(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void onLayout(boolean arg6, int arg7, int arg8, int arg9, int arg10) {
        super.onLayout(arg6, arg7, arg8, arg9, arg10);
        View v6 = this.mTabContainer;
        arg8 = 8;
        arg10 = 1;
        int v0 = 0;
        boolean v1 = v6 == null || v6.getVisibility() == arg8 ? false : true;
        if(v6 != null && v6.getVisibility() != arg8) {
            arg8 = this.getMeasuredHeight();
            ViewGroup$LayoutParams v2 = v6.getLayoutParams();
            v6.layout(arg7, arg8 - v6.getMeasuredHeight() - ((FrameLayout$LayoutParams)v2).bottomMargin, arg9, arg8 - ((FrameLayout$LayoutParams)v2).bottomMargin);
        }

        if(this.mIsSplit) {
            Drawable v6_1 = this.mSplitBackground;
            if(v6_1 != null) {
                v6_1.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
            }
            else {
                goto label_31;
            }
        }
        else {
            if(this.mBackground != null) {
                if(this.mActionBarView.getVisibility() == 0) {
                    this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
                }
                else {
                    View v7 = this.mContextView;
                    if(v7 != null && v7.getVisibility() == 0) {
                        this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
                        goto label_66;
                    }

                    this.mBackground.setBounds(0, 0, 0, 0);
                }

            label_66:
                v0 = 1;
            }

            this.mIsStacked = v1;
            if(v1) {
                Drawable v7_1 = this.mStackedBackground;
                if(v7_1 == null) {
                    goto label_31;
                }

                v7_1.setBounds(v6.getLeft(), v6.getTop(), v6.getRight(), v6.getBottom());
                goto label_76;
            }

        label_31:
            arg10 = v0;
        }

    label_76:
        if(arg10 != 0) {
            this.invalidate();
        }
    }

    public void onMeasure(int arg4, int arg5) {
        int v0;
        int v1 = 0x80000000;
        if(this.mActionBarView == null && View$MeasureSpec.getMode(arg5) == v1) {
            v0 = this.mHeight;
            if(v0 >= 0) {
                arg5 = View$MeasureSpec.makeMeasureSpec(Math.min(v0, View$MeasureSpec.getSize(arg5)), v1);
            }
        }

        super.onMeasure(arg4, arg5);
        if(this.mActionBarView == null) {
        }
        else {
            arg4 = View$MeasureSpec.getMode(arg5);
            View v0_1 = this.mTabContainer;
            if(v0_1 != null && v0_1.getVisibility() != 8 && arg4 != 0x40000000) {
                if(!this.isCollapsed(this.mActionBarView)) {
                    v0 = this.getMeasuredHeightWithMargins(this.mActionBarView);
                }
                else if(!this.isCollapsed(this.mContextView)) {
                    v0 = this.getMeasuredHeightWithMargins(this.mContextView);
                }
                else {
                    v0 = 0;
                }

                arg4 = arg4 == v1 ? View$MeasureSpec.getSize(arg5) : 0x7FFFFFFF;
                this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(v0 + this.getMeasuredHeightWithMargins(this.mTabContainer), arg4));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent arg1) {
        super.onTouchEvent(arg1);
        return 1;
    }

    public void setPrimaryBackground(Drawable arg5) {
        Drawable v0 = this.mBackground;
        if(v0 != null) {
            v0.setCallback(null);
            this.unscheduleDrawable(this.mBackground);
        }

        this.mBackground = arg5;
        if(arg5 != null) {
            arg5.setCallback(((Drawable$Callback)this));
            View v5 = this.mActionBarView;
            if(v5 != null) {
                this.mBackground.setBounds(v5.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
            }
        }

        boolean v0_1 = true;
        if(this.mIsSplit) {
            if(this.mSplitBackground == null) {
            }
            else {
                goto label_32;
            }
        }
        else if(this.mBackground != null) {
        label_32:
            v0_1 = false;
        }
        else if(this.mStackedBackground == null) {
        }
        else {
            goto label_32;
        }

        this.setWillNotDraw(v0_1);
        this.invalidate();
        Api21Impl.invalidateOutline(this);
    }

    public void setSplitBackground(Drawable arg4) {
        Drawable v0 = this.mSplitBackground;
        if(v0 != null) {
            v0.setCallback(null);
            this.unscheduleDrawable(this.mSplitBackground);
        }

        this.mSplitBackground = arg4;
        boolean v0_1 = false;
        if(arg4 != null) {
            arg4.setCallback(((Drawable$Callback)this));
            if(this.mIsSplit) {
                arg4 = this.mSplitBackground;
                if(arg4 != null) {
                    arg4.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
                }
            }
        }

        if(this.mIsSplit) {
            if(this.mSplitBackground != null) {
                goto label_29;
            }

            goto label_22;
        }
        else if(this.mBackground == null && this.mStackedBackground == null) {
        label_22:
            v0_1 = true;
        }

    label_29:
        this.setWillNotDraw(v0_1);
        this.invalidate();
        Api21Impl.invalidateOutline(this);
    }

    public void setStackedBackground(Drawable arg5) {
        Drawable v0 = this.mStackedBackground;
        if(v0 != null) {
            v0.setCallback(null);
            this.unscheduleDrawable(this.mStackedBackground);
        }

        this.mStackedBackground = arg5;
        if(arg5 != null) {
            arg5.setCallback(((Drawable$Callback)this));
            if(this.mIsStacked) {
                arg5 = this.mStackedBackground;
                if(arg5 != null) {
                    arg5.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
                }
            }
        }

        boolean v0_1 = true;
        if(this.mIsSplit) {
            if(this.mSplitBackground == null) {
            }
            else {
                goto label_34;
            }
        }
        else if(this.mBackground != null) {
        label_34:
            v0_1 = false;
        }
        else if(this.mStackedBackground == null) {
        }
        else {
            goto label_34;
        }

        this.setWillNotDraw(v0_1);
        this.invalidate();
        Api21Impl.invalidateOutline(this);
    }

    public void setTabContainer(ScrollingTabContainerView arg2) {
        View v0 = this.mTabContainer;
        if(v0 != null) {
            this.removeView(v0);
        }

        this.mTabContainer = ((View)arg2);
        if(arg2 != null) {
            this.addView(((View)arg2));
            ViewGroup$LayoutParams v1 = arg2.getLayoutParams();
            v1.width = -1;
            v1.height = -2;
            arg2.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean arg1) {
        this.mIsTransitioning = arg1;
        int v1 = arg1 ? 0x60000 : 0x40000;
        this.setDescendantFocusability(v1);
    }

    public void setVisibility(int arg3) {
        super.setVisibility(arg3);
        boolean v3 = arg3 == 0 ? true : false;
        Drawable v1 = this.mBackground;
        if(v1 != null) {
            v1.setVisible(v3, false);
        }

        v1 = this.mStackedBackground;
        if(v1 != null) {
            v1.setVisible(v3, false);
        }

        Drawable v2 = this.mSplitBackground;
        if(v2 != null) {
            v2.setVisible(v3, false);
        }
    }

    public ActionMode startActionModeForChild(View arg1, ActionMode$Callback arg2) {
        return null;
    }

    public ActionMode startActionModeForChild(View arg1, ActionMode$Callback arg2, int arg3) {
        if(arg3 != 0) {
            return super.startActionModeForChild(arg1, arg2, arg3);
        }

        return null;
    }

    protected boolean verifyDrawable(Drawable arg2) {
        if(arg2 == this.mBackground && !this.mIsSplit || arg2 == this.mStackedBackground && (this.mIsStacked) || arg2 == this.mSplitBackground && (this.mIsSplit) || (super.verifyDrawable(arg2))) {
            return 1;
        }

        return 0;
    }
}

