package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View$MeasureSpec;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.navigation.NavigationBarItemView;

final class NavigationRailItemView extends NavigationBarItemView {
    public NavigationRailItemView(Context arg1) {
        super(arg1);
    }

    protected int getItemDefaultMarginResId() {
        return dimen.mtrl_navigation_rail_icon_margin;
    }

    protected int getItemLayoutResId() {
        return layout.mtrl_navigation_rail_item;
    }

    protected void onMeasure(int arg1, int arg2) {
        super.onMeasure(arg1, arg2);
        if(View$MeasureSpec.getMode(arg2) == 0) {
            this.setMeasuredDimension(this.getMeasuredWidthAndState(), Math.max(this.getMeasuredHeight(), View$MeasureSpec.getSize(arg2)));
        }
    }
}

