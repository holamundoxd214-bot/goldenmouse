package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView$OnItemReselectedListener;
import com.google.android.material.navigation.NavigationBarView$OnItemSelectedListener;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationView extends NavigationBarView {
    @Deprecated public interface OnNavigationItemReselectedListener extends OnItemReselectedListener {
    }

    @Deprecated public interface OnNavigationItemSelectedListener extends OnItemSelectedListener {
    }

    private static final int MAX_ITEM_COUNT = 5;

    public BottomNavigationView(Context arg2) {
        this(arg2, null);
    }

    public BottomNavigationView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context arg2, AttributeSet arg3, int arg4) {
        this(arg2, arg3, arg4, style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(Context arg7, AttributeSet arg8, int arg9, int arg10) {
        super(arg7, arg8, arg9, arg10);
        Context v0 = this.getContext();
        TintTypedArray v8 = ThemeEnforcement.obtainTintedStyledAttributes(v0, arg8, styleable.BottomNavigationView, arg9, arg10, new int[0]);
        this.setItemHorizontalTranslationEnabled(v8.getBoolean(styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        if(v8.hasValue(styleable.BottomNavigationView_android_minHeight)) {
            this.setMinimumHeight(v8.getDimensionPixelSize(styleable.BottomNavigationView_android_minHeight, 0));
        }

        if((v8.getBoolean(styleable.BottomNavigationView_compatShadowEnabled, true)) && (this.shouldDrawCompatibilityTopDivider())) {
            this.addCompatibilityTopDivider(v0);
        }

        v8.recycle();
        this.applyWindowInsets();
    }

    private void addCompatibilityTopDivider(Context arg4) {
        View v0 = new View(arg4);
        v0.setBackgroundColor(ContextCompat.getColor(arg4, color.design_bottom_navigation_shadow_color));
        v0.setLayoutParams(new FrameLayout$LayoutParams(-1, this.getResources().getDimensionPixelSize(dimen.design_bottom_navigation_shadow_height)));
        this.addView(v0);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(((View)this), new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View arg5, WindowInsetsCompat arg6, RelativePadding arg7) {
                arg7.bottom += arg6.getSystemWindowInsetBottom();
                int v0 = 1;
                if(ViewCompat.getLayoutDirection(arg5) == 1) {
                }
                else {
                    v0 = 0;
                }

                int v4 = arg6.getSystemWindowInsetLeft();
                int v1 = arg6.getSystemWindowInsetRight();
                int v2 = arg7.start;
                int v3 = v0 != 0 ? v1 : v4;
                arg7.start = v2 + v3;
                v2 = arg7.end;
                if(v0 != 0) {
                }
                else {
                    v4 = v1;
                }

                arg7.end = v2 + v4;
                arg7.applyToView(arg5);
                return arg6;
            }
        });
    }

    protected NavigationBarMenuView createNavigationBarMenuView(Context arg1) {
        return new BottomNavigationMenuView(arg1);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.getMenuView().isItemHorizontalTranslationEnabled();
    }

    private int makeMinHeightSpec(int arg4) {
        int v0 = this.getSuggestedMinimumHeight();
        int v2 = 0x40000000;
        if(View$MeasureSpec.getMode(arg4) != v2 && v0 > 0) {
            return View$MeasureSpec.makeMeasureSpec(Math.min(View$MeasureSpec.getSize(arg4), v0 + (this.getPaddingTop() + this.getPaddingBottom())), v2);
        }

        return arg4;
    }

    protected void onMeasure(int arg1, int arg2) {
        super.onMeasure(arg1, this.makeMinHeightSpec(arg2));
    }

    public void setItemHorizontalTranslationEnabled(boolean arg3) {
        MenuView v0 = this.getMenuView();
        if(((BottomNavigationMenuView)v0).isItemHorizontalTranslationEnabled() != arg3) {
            ((BottomNavigationMenuView)v0).setItemHorizontalTranslationEnabled(arg3);
            this.getPresenter().updateMenuView(false);
        }
    }

    @Deprecated public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener arg1) {
        this.setOnItemReselectedListener(((OnItemReselectedListener)arg1));
    }

    @Deprecated public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener arg1) {
        this.setOnItemSelectedListener(((OnItemSelectedListener)arg1));
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        return 0;
    }
}

