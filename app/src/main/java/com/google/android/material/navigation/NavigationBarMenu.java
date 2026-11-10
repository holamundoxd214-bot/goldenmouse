package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

public final class NavigationBarMenu extends MenuBuilder {
    private final int maxItemCount;
    private final Class viewClass;

    public NavigationBarMenu(Context arg1, Class arg2, int arg3) {
        super(arg1);
        this.viewClass = arg2;
        this.maxItemCount = arg3;
    }

    protected MenuItem addInternal(int arg4, int arg5, int arg6, CharSequence arg7) {
        if(this.size() + 1 <= this.maxItemCount) {
            this.stopDispatchingItemsChanged();
            MenuItem v4 = super.addInternal(arg4, arg5, arg6, arg7);
            if((v4 instanceof MenuItemImpl)) {
                v4.setExclusiveCheckable(true);
            }

            this.startDispatchingItemsChanged();
            return v4;
        }

        String v4_1 = this.viewClass.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + v4_1 + " is " + this.maxItemCount + ". Limit can be checked with " + v4_1 + "#getMaxItemCount()");
    }

    public SubMenu addSubMenu(int arg1, int arg2, int arg3, CharSequence arg4) {
        throw new UnsupportedOperationException(this.viewClass.getSimpleName() + " does not support submenus");
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}

