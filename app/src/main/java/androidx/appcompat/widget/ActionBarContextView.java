package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

public class ActionBarContextView extends AbsActionBarView {
    private View mClose;
    private View mCloseButton;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public ActionBarContextView(Context arg2) {
        this(arg2, null);
    }

    public ActionBarContextView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.actionModeStyle);
    }

    public ActionBarContextView(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        TintTypedArray v3 = TintTypedArray.obtainStyledAttributes(arg3, arg4, styleable.ActionMode, arg5, 0);
        ViewCompat.setBackground(((View)this), v3.getDrawable(styleable.ActionMode_background));
        this.mTitleStyleRes = v3.getResourceId(styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = v3.getResourceId(styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = v3.getLayoutDimension(styleable.ActionMode_height, 0);
        this.mCloseItemLayout = v3.getResourceId(styleable.ActionMode_closeItemLayout, layout.abc_action_mode_close_item_material);
        v3.recycle();
    }

    public void animateToVisibility(int arg1) {
        super.animateToVisibility(arg1);
    }

    public boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if(this.mClose == null) {
            this.killMode();
        }
    }

    public void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup$MarginLayoutParams(-1, -2);
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new ViewGroup$MarginLayoutParams(this.getContext(), arg2);
    }

    public int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean hideOverflowMenu() {
        if(this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.hideOverflowMenu();
        }

        return 0;
    }

    public void initForMode(ActionMode arg4) {
        View v0 = this.mClose;
        if(v0 == null) {
            v0 = LayoutInflater.from(this.getContext()).inflate(this.mCloseItemLayout, ((ViewGroup)this), false);
            this.mClose = v0;
            this.addView(v0);
        }
        else if(v0.getParent() == null) {
            this.addView(this.mClose);
        }

        v0 = this.mClose.findViewById(id.action_mode_close_button);
        this.mCloseButton = v0;
        v0.setOnClickListener(new View$OnClickListener(arg4) {
            public void onClick(View arg1) {
                this.val$mode.finish();
            }
        });
        Menu v4 = arg4.getMenu();
        if(this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }

        this.mActionMenuPresenter = new ActionMenuPresenter(this.getContext());
        this.mActionMenuPresenter.setReserveOverflow(true);
        ViewGroup$LayoutParams v0_1 = new ViewGroup$LayoutParams(-2, -1);
        ((MenuBuilder)v4).addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        this.mMenuView = this.mActionMenuPresenter.getMenuView(((ViewGroup)this));
        ViewCompat.setBackground(this.mMenuView, null);
        this.addView(this.mMenuView, v0_1);
    }

    private void initTitle() {
        if(this.mTitleLayout == null) {
            LayoutInflater.from(this.getContext()).inflate(layout.abc_action_bar_title_item, ((ViewGroup)this));
            View v0 = this.getChildAt(this.getChildCount() - 1);
            this.mTitleLayout = ((LinearLayout)v0);
            this.mTitleView = ((LinearLayout)v0).findViewById(id.action_bar_title);
            this.mSubtitleView = this.mTitleLayout.findViewById(id.action_bar_subtitle);
            if(this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(this.getContext(), this.mTitleStyleRes);
            }

            if(this.mSubtitleStyleRes == 0) {
                goto label_29;
            }

            this.mSubtitleView.setTextAppearance(this.getContext(), this.mSubtitleStyleRes);
        }

    label_29:
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean v0_1 = TextUtils.isEmpty(this.mTitle);
        boolean v1 = TextUtils.isEmpty(this.mSubtitle);
        TextView v2 = this.mSubtitleView;
        int v3 = 0;
        int v4 = 8;
        int v5 = !v1 ? 0 : v4;
        v2.setVisibility(v5);
        LinearLayout v2_1 = this.mTitleLayout;
        if(v0_1) {
            if(!v1) {
            }
            else {
                v3 = v4;
            }
        }

        v2_1.setVisibility(v3);
        if(this.mTitleLayout.getParent() == null) {
            this.addView(this.mTitleLayout);
        }
    }

    public boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        if(this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.isOverflowMenuShowing();
        }

        return 0;
    }

    public boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        this.removeAllViews();
        View v0 = null;
        this.mCustomView = v0;
        this.mMenuView = ((ActionMenuView)v0);
        this.mActionMenuPresenter = ((ActionMenuPresenter)v0);
        View v1 = this.mCloseButton;
        if(v1 != null) {
            v1.setOnClickListener(((View$OnClickListener)v0));
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    public boolean onHoverEvent(MotionEvent arg1) {
        return super.onHoverEvent(arg1);
    }

    protected void onLayout(boolean arg10, int arg11, int arg12, int arg13, int arg14) {
        int v2_2;
        boolean v5 = ViewUtils.isLayoutRtl(((View)this));
        int v1 = v5 ? arg13 - arg11 - this.getPaddingRight() : this.getPaddingLeft();
        int v3 = this.getPaddingTop();
        int v4 = arg14 - arg12 - this.getPaddingTop() - this.getPaddingBottom();
        View v2 = this.mClose;
        int v6 = 8;
        if(v2 != null && v2.getVisibility() != v6) {
            ViewGroup$LayoutParams v2_1 = this.mClose.getLayoutParams();
            int v7 = v5 ? ((ViewGroup$MarginLayoutParams)v2_1).rightMargin : ((ViewGroup$MarginLayoutParams)v2_1).leftMargin;
            v2_2 = v5 ? ((ViewGroup$MarginLayoutParams)v2_1).leftMargin : ((ViewGroup$MarginLayoutParams)v2_1).rightMargin;
            int v8 = v2_2;
            v2_2 = ActionBarContextView.next(v1, v7, v5);
            v1 = ActionBarContextView.next(v2_2 + this.positionChild(this.mClose, v2_2, v3, v4, v5), v8, v5);
        }

        v2_2 = v1;
        LinearLayout v1_1 = this.mTitleLayout;
        if(v1_1 != null && this.mCustomView == null && v1_1.getVisibility() != v6) {
            v2_2 += this.positionChild(this.mTitleLayout, v2_2, v3, v4, v5);
        }

        View v1_2 = this.mCustomView;
        if(v1_2 != null) {
            this.positionChild(v1_2, v2_2, v3, v4, v5);
        }

        v1 = v5 ? this.getPaddingLeft() : arg13 - arg11 - this.getPaddingRight();
        v2_2 = v1;
        if(this.mMenuView != null) {
            this.positionChild(this.mMenuView, v2_2, v3, v4, (((int)v5)) ^ 1);
        }
    }

    protected void onMeasure(int arg11, int arg12) {
        int v6_3;
        int v1 = 0x40000000;
        if(View$MeasureSpec.getMode(arg11) == v1) {
            if(View$MeasureSpec.getMode(arg12) != 0) {
                arg11 = View$MeasureSpec.getSize(arg11);
                arg12 = this.mContentHeight > 0 ? this.mContentHeight : View$MeasureSpec.getSize(arg12);
                int v0 = this.getPaddingTop() + this.getPaddingBottom();
                int v2 = arg11 - this.getPaddingLeft() - this.getPaddingRight();
                int v3 = arg12 - v0;
                int v4 = 0x80000000;
                int v5 = View$MeasureSpec.makeMeasureSpec(v3, v4);
                View v6 = this.mClose;
                int v7 = 0;
                if(v6 != null) {
                    v2 = this.measureChildView(v6, v2, v5, 0);
                    ViewGroup$LayoutParams v6_1 = this.mClose.getLayoutParams();
                    v2 -= ((ViewGroup$MarginLayoutParams)v6_1).leftMargin + ((ViewGroup$MarginLayoutParams)v6_1).rightMargin;
                }

                if(this.mMenuView != null && this.mMenuView.getParent() == this) {
                    v2 = this.measureChildView(this.mMenuView, v2, v5, 0);
                }

                LinearLayout v6_2 = this.mTitleLayout;
                if(v6_2 != null && this.mCustomView == null) {
                    if(this.mTitleOptional) {
                        this.mTitleLayout.measure(View$MeasureSpec.makeMeasureSpec(0, 0), v5);
                        v5 = this.mTitleLayout.getMeasuredWidth();
                        v6_3 = v5 <= v2 ? 1 : 0;
                        if(v6_3 != 0) {
                            v2 -= v5;
                        }

                        LinearLayout v5_1 = this.mTitleLayout;
                        v6_3 = v6_3 != 0 ? 0 : 8;
                        v5_1.setVisibility(v6_3);
                    }
                    else {
                        v2 = this.measureChildView(((View)v6_2), v2, v5, 0);
                    }
                }

                View v5_2 = this.mCustomView;
                if(v5_2 != null) {
                    ViewGroup$LayoutParams v5_3 = v5_2.getLayoutParams();
                    int v8 = -2;
                    v6_3 = v5_3.width != v8 ? v1 : v4;
                    if(v5_3.width >= 0) {
                        v2 = Math.min(v5_3.width, v2);
                    }

                    if(v5_3.height != v8) {
                    }
                    else {
                        v1 = v4;
                    }

                    if(v5_3.height >= 0) {
                        v3 = Math.min(v5_3.height, v3);
                    }

                    this.mCustomView.measure(View$MeasureSpec.makeMeasureSpec(v2, v6_3), View$MeasureSpec.makeMeasureSpec(v3, v1));
                }

                if(this.mContentHeight <= 0) {
                    arg12 = this.getChildCount();
                    v1 = 0;
                    while(v7 < arg12) {
                        v2 = this.getChildAt(v7).getMeasuredHeight() + v0;
                        if(v2 > v1) {
                            v1 = v2;
                        }

                        ++v7;
                    }

                    this.setMeasuredDimension(arg11, v1);
                    return;
                }

                this.setMeasuredDimension(arg11, arg12);
                return;
            }

            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }

        throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    public boolean onTouchEvent(MotionEvent arg1) {
        return super.onTouchEvent(arg1);
    }

    public void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    public void setContentHeight(int arg1) {
        this.mContentHeight = arg1;
    }

    public void setCustomView(View arg2) {
        View v0 = this.mCustomView;
        if(v0 != null) {
            this.removeView(v0);
        }

        this.mCustomView = arg2;
        if(arg2 != null) {
            LinearLayout v0_1 = this.mTitleLayout;
            if(v0_1 != null) {
                this.removeView(((View)v0_1));
                this.mTitleLayout = null;
            }
        }

        if(arg2 != null) {
            this.addView(arg2);
        }

        this.requestLayout();
    }

    public void setSubtitle(CharSequence arg1) {
        this.mSubtitle = arg1;
        this.initTitle();
    }

    public void setTitle(CharSequence arg1) {
        this.mTitle = arg1;
        this.initTitle();
        ViewCompat.setAccessibilityPaneTitle(((View)this), arg1);
    }

    public void setTitleOptional(boolean arg2) {
        if(arg2 != this.mTitleOptional) {
            this.requestLayout();
        }

        this.mTitleOptional = arg2;
    }

    public void setVisibility(int arg1) {
        super.setVisibility(arg1);
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int arg1, long arg2) {
        return super.setupAnimatorToVisibility(arg1, arg2);
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }

    public boolean showOverflowMenu() {
        if(this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.showOverflowMenu();
        }

        return 0;
    }
}

