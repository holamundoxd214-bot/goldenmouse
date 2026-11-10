package com.google.android.material.bottomnavigation;

import android.content.Context;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.navigation.NavigationBarItemView;

public class BottomNavigationItemView extends NavigationBarItemView {
    public BottomNavigationItemView(Context arg1) {
        super(arg1);
    }

    protected int getItemDefaultMarginResId() {
        return dimen.design_bottom_navigation_margin;
    }

    protected int getItemLayoutResId() {
        return layout.design_bottom_navigation_item;
    }
}

