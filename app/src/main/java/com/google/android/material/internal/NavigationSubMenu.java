package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

public class NavigationSubMenu extends SubMenuBuilder {
    public NavigationSubMenu(Context arg1, NavigationMenu arg2, MenuItemImpl arg3) {
        super(arg1, ((MenuBuilder)arg2), arg3);
    }

    public void onItemsChanged(boolean arg1) {
        super.onItemsChanged(arg1);
        this.getParentMenu().onItemsChanged(arg1);
    }
}

