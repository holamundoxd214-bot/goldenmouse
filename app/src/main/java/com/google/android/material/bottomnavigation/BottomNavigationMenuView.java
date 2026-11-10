package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private final List tempChildWidths;

    public BottomNavigationMenuView(Context arg2) {
        super(arg2);
        this.tempChildWidths = new ArrayList();
        FrameLayout$LayoutParams v2 = new FrameLayout$LayoutParams(-2, -2);
        v2.gravity = 17;
        this.setLayoutParams(((ViewGroup$LayoutParams)v2));
        Resources v2_1 = this.getResources();
        this.inactiveItemMaxWidth = v2_1.getDimensionPixelSize(dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = v2_1.getDimensionPixelSize(dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = v2_1.getDimensionPixelSize(dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = v2_1.getDimensionPixelSize(dimen.design_bottom_navigation_active_item_min_width);
    }

    protected NavigationBarItemView createNavigationBarItemView(Context arg1) {
        return new BottomNavigationItemView(arg1);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    protected void onLayout(boolean arg5, int arg6, int arg7, int arg8, int arg9) {
        int v5 = this.getChildCount();
        arg8 -= arg6;
        arg9 -= arg7;
        arg7 = 0;
        int v0 = 0;
        while(arg7 < v5) {
            View v1 = this.getChildAt(arg7);
            if(v1.getVisibility() == 8) {
            }
            else {
                if(ViewCompat.getLayoutDirection(((View)this)) == 1) {
                    int v2 = arg8 - v0;
                    v1.layout(v2 - v1.getMeasuredWidth(), 0, v2, arg9);
                }
                else {
                    v1.layout(v0, 0, v1.getMeasuredWidth() + v0, arg9);
                }

                v0 += v1.getMeasuredWidth();
            }

            ++arg7;
        }
    }

    protected void onMeasure(int arg12, int arg13) {
        int v4_1;
        MenuBuilder v0 = this.getMenu();
        arg12 = View$MeasureSpec.getSize(arg12);
        int v0_1 = v0.getVisibleItems().size();
        int v1 = this.getChildCount();
        this.tempChildWidths.clear();
        arg13 = View$MeasureSpec.getSize(arg13);
        int v2 = 0x40000000;
        int v3 = View$MeasureSpec.makeMeasureSpec(arg13, v2);
        int v5 = 8;
        int v6 = 0;
        int v7 = 1;
        if(!this.isShifting(this.getLabelVisibilityMode(), v0_1) || !this.isItemHorizontalTranslationEnabled()) {
            if(v0_1 == 0) {
            }
            else {
                v7 = v0_1;
            }

            v4_1 = Math.min(arg12 / v7, this.activeItemMaxWidth);
            arg12 -= v0_1 * v4_1;
            for(v0_1 = 0; v0_1 < v1; ++v0_1) {
                if(this.getChildAt(v0_1).getVisibility() == v5) {
                    v7 = 0;
                }
                else if(arg12 > 0) {
                    v7 = v4_1 + 1;
                    --arg12;
                }
                else {
                    v7 = v4_1;
                }

                this.tempChildWidths.add(Integer.valueOf(v7));
            }
        }
        else {
            View v4 = this.getChildAt(this.getSelectedItemPosition());
            int v8 = this.activeItemMinWidth;
            if(v4.getVisibility() != v5) {
                v4.measure(View$MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, 0x80000000), v3);
                v8 = Math.max(v8, v4.getMeasuredWidth());
            }

            v4_1 = v4.getVisibility() != v5 ? 1 : 0;
            v0_1 -= v4_1;
            v4_1 = Math.min(arg12 - this.inactiveItemMinWidth * v0_1, Math.min(v8, this.activeItemMaxWidth));
            arg12 -= v4_1;
            if(v0_1 == 0) {
            }
            else {
                v7 = v0_1;
            }

            v7 = Math.min(arg12 / v7, this.inactiveItemMaxWidth);
            arg12 -= v0_1 * v7;
            for(v0_1 = 0; v0_1 < v1; ++v0_1) {
                if(this.getChildAt(v0_1).getVisibility() != v5) {
                    v8 = v0_1 == this.getSelectedItemPosition() ? v4_1 : v7;
                    if(arg12 <= 0) {
                        goto label_65;
                    }

                    ++v8;
                    --arg12;
                }
                else {
                    v8 = 0;
                }

            label_65:
                this.tempChildWidths.add(Integer.valueOf(v8));
            }
        }

        arg12 = 0;
        while(v6 < v1) {
            View v0_2 = this.getChildAt(v6);
            if(v0_2.getVisibility() == v5) {
            }
            else {
                v0_2.measure(View$MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(v6).intValue(), v2), v3);
                v0_2.getLayoutParams().width = v0_2.getMeasuredWidth();
                arg12 += v0_2.getMeasuredWidth();
            }

            ++v6;
        }

        this.setMeasuredDimension(arg12, arg13);
    }

    public void setItemHorizontalTranslationEnabled(boolean arg1) {
        this.itemHorizontalTranslationEnabled = arg1;
    }
}

