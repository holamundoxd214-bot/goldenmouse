package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NavigationMenuView extends RecyclerView implements MenuView {
    public NavigationMenuView(Context arg2) {
        this(arg2, null);
    }

    public NavigationMenuView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public NavigationMenuView(Context arg2, AttributeSet arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.setLayoutManager(new LinearLayoutManager(arg2, 1, false));
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(MenuBuilder arg1) {
    }
}

