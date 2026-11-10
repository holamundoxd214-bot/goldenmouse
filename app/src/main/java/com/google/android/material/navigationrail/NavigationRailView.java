package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout$LayoutParams;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.resources.MaterialResources;

public class NavigationRailView extends NavigationBarView {
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    static final int MAX_ITEM_COUNT = 7;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;
    private View headerView;
    private Boolean paddingBottomSystemWindowInsets;
    private Boolean paddingStartSystemWindowInsets;
    private Boolean paddingTopSystemWindowInsets;
    private final int topMargin;

    public NavigationRailView(Context arg2) {
        this(arg2, null);
    }

    public NavigationRailView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.navigationRailStyle);
    }

    public NavigationRailView(Context arg2, AttributeSet arg3, int arg4) {
        this(arg2, arg3, arg4, style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(Context arg7, AttributeSet arg8, int arg9, int arg10) {
        super(arg7, arg8, arg9, arg10);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.paddingStartSystemWindowInsets = null;
        this.topMargin = this.getResources().getDimensionPixelSize(dimen.mtrl_navigation_rail_margin);
        Context v0 = this.getContext();
        TintTypedArray v8 = ThemeEnforcement.obtainTintedStyledAttributes(v0, arg8, styleable.NavigationRailView, arg9, arg10, new int[0]);
        arg9 = v8.getResourceId(styleable.NavigationRailView_headerLayout, 0);
        if(arg9 != 0) {
            this.addHeaderView(arg9);
        }

        this.setMenuGravity(v8.getInt(styleable.NavigationRailView_menuGravity, 49));
        if(v8.hasValue(styleable.NavigationRailView_itemMinHeight)) {
            this.setItemMinimumHeight(v8.getDimensionPixelSize(styleable.NavigationRailView_itemMinHeight, -1));
        }

        if(v8.hasValue(styleable.NavigationRailView_paddingTopSystemWindowInsets)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(v8.getBoolean(styleable.NavigationRailView_paddingTopSystemWindowInsets, false));
        }

        if(v8.hasValue(styleable.NavigationRailView_paddingBottomSystemWindowInsets)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(v8.getBoolean(styleable.NavigationRailView_paddingBottomSystemWindowInsets, false));
        }

        if(v8.hasValue(styleable.NavigationRailView_paddingStartSystemWindowInsets)) {
            this.paddingStartSystemWindowInsets = Boolean.valueOf(v8.getBoolean(styleable.NavigationRailView_paddingStartSystemWindowInsets, false));
        }

        int v7 = this.getResources().getDimensionPixelOffset(dimen.m3_navigation_rail_item_padding_top_with_large_font);
        arg9 = this.getResources().getDimensionPixelOffset(dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float v10 = AnimationUtils.lerp(0f, 1f, 0.3f, 1f, MaterialResources.getFontScale(v0) - 1f);
        float v7_1 = ((float)AnimationUtils.lerp(this.getItemPaddingTop(), v7, v10));
        float v9 = ((float)AnimationUtils.lerp(this.getItemPaddingBottom(), arg9, v10));
        this.setItemPaddingTop(Math.round(v7_1));
        this.setItemPaddingBottom(Math.round(v9));
        v8.recycle();
        this.applyWindowInsets();
    }

    static Boolean access$000(NavigationRailView arg0) {
        return arg0.paddingTopSystemWindowInsets;
    }

    static boolean access$100(NavigationRailView arg0, Boolean arg1) {
        return arg0.shouldApplyWindowInsetPadding(arg1);
    }

    static Boolean access$200(NavigationRailView arg0) {
        return arg0.paddingBottomSystemWindowInsets;
    }

    static Boolean access$300(NavigationRailView arg0) {
        return arg0.paddingStartSystemWindowInsets;
    }

    public void addHeaderView(int arg3) {
        this.addHeaderView(LayoutInflater.from(this.getContext()).inflate(arg3, ((ViewGroup)this), false));
    }

    public void addHeaderView(View arg3) {
        this.removeHeaderView();
        this.headerView = arg3;
        FrameLayout$LayoutParams v0 = new FrameLayout$LayoutParams(-2, -2);
        v0.gravity = 49;
        v0.topMargin = this.topMargin;
        this.addView(arg3, 0, ((ViewGroup$LayoutParams)v0));
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(((View)this), new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View arg4, WindowInsetsCompat arg5, RelativePadding arg6) {
                Insets v0 = arg5.getInsets(Type.systemBars());
                if(NavigationRailView.this.shouldApplyWindowInsetPadding(NavigationRailView.this.paddingTopSystemWindowInsets)) {
                    arg6.top += v0.top;
                }

                if(NavigationRailView.this.shouldApplyWindowInsetPadding(NavigationRailView.this.paddingBottomSystemWindowInsets)) {
                    arg6.bottom += v0.bottom;
                }

                if(NavigationRailView.this.shouldApplyWindowInsetPadding(NavigationRailView.this.paddingStartSystemWindowInsets)) {
                    int v3 = arg6.start;
                    int v0_1 = ViewUtils.isLayoutRtl(arg4) ? v0.right : v0.left;
                    arg6.start = v3 + v0_1;
                }

                arg6.applyToView(arg4);
                return arg5;
            }
        });
    }

    protected NavigationBarMenuView createNavigationBarMenuView(Context arg1) {
        return this.createNavigationBarMenuView(arg1);
    }

    protected NavigationRailMenuView createNavigationBarMenuView(Context arg1) {
        return new NavigationRailMenuView(arg1);
    }

    public View getHeaderView() {
        return this.headerView;
    }

    public int getItemMinimumHeight() {
        return this.getMenuView().getItemMinimumHeight();
    }

    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return this.getNavigationRailMenuView().getMenuGravity();
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return this.getMenuView();
    }

    private boolean isHeaderViewVisible() {
        View v1 = this.headerView;
        if(v1 != null && v1.getVisibility() != 8) {
            return 1;
        }

        return 0;
    }

    private int makeMinWidthSpec(int arg4) {
        int v0 = this.getSuggestedMinimumWidth();
        int v2 = 0x40000000;
        if(View$MeasureSpec.getMode(arg4) != v2 && v0 > 0) {
            return View$MeasureSpec.makeMeasureSpec(Math.min(View$MeasureSpec.getSize(arg4), v0 + (this.getPaddingLeft() + this.getPaddingRight())), v2);
        }

        return arg4;
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        NavigationRailMenuView v1 = this.getNavigationRailMenuView();
        arg3 = 0;
        if(this.isHeaderViewVisible()) {
            arg2 = this.headerView.getBottom() + this.topMargin;
            int v0 = v1.getTop();
            if(v0 < arg2) {
                arg3 = arg2 - v0;
            }
        }
        else if(v1.isTopGravity()) {
            arg3 = this.topMargin;
        }

        if(arg3 > 0) {
            v1.layout(v1.getLeft(), v1.getTop() + arg3, v1.getRight(), v1.getBottom() + arg3);
        }
    }

    protected void onMeasure(int arg2, int arg3) {
        arg2 = this.makeMinWidthSpec(arg2);
        super.onMeasure(arg2, arg3);
        if(this.isHeaderViewVisible()) {
            this.measureChild(this.getNavigationRailMenuView(), arg2, View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.headerView.getMeasuredHeight() - this.topMargin, 0x80000000));
        }
    }

    public void removeHeaderView() {
        View v0 = this.headerView;
        if(v0 != null) {
            this.removeView(v0);
            this.headerView = null;
        }
    }

    public void setItemMinimumHeight(int arg1) {
        this.getMenuView().setItemMinimumHeight(arg1);
    }

    public void setMenuGravity(int arg1) {
        this.getNavigationRailMenuView().setMenuGravity(arg1);
    }

    private boolean shouldApplyWindowInsetPadding(Boolean arg1) {
        if(arg1 != null) {
            return arg1.booleanValue();
        }

        return ViewCompat.getFitsSystemWindows(((View)this));
    }
}

