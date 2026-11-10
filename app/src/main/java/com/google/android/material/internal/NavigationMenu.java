package com.google.android.material.internal;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context arg1) {
        super(arg1);
    }

    public SubMenu addSubMenu(int arg1, int arg2, int arg3, CharSequence arg4) {
        MenuItem v1 = this.addInternal(arg1, arg2, arg3, arg4);
        NavigationSubMenu v2 = new NavigationSubMenu(this.getContext(), this, ((MenuItemImpl)v1));
        ((MenuItemImpl)v1).setSubMenu(((SubMenuBuilder)v2));
        return ((SubMenu)v2);
    }
}

