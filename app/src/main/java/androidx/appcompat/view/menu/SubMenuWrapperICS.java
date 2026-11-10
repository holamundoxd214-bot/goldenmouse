package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportSubMenu;

class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    private final SupportSubMenu mSubMenu;

    SubMenuWrapperICS(Context arg1, SupportSubMenu arg2) {
        super(arg1, ((SupportMenu)arg2));
        this.mSubMenu = arg2;
    }

    public void clearHeader() {
        this.mSubMenu.clearHeader();
    }

    public MenuItem getItem() {
        return this.getMenuItemWrapper(this.mSubMenu.getItem());
    }

    public SubMenu setHeaderIcon(int arg2) {
        this.mSubMenu.setHeaderIcon(arg2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable arg2) {
        this.mSubMenu.setHeaderIcon(arg2);
        return this;
    }

    public SubMenu setHeaderTitle(int arg2) {
        this.mSubMenu.setHeaderTitle(arg2);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence arg2) {
        this.mSubMenu.setHeaderTitle(arg2);
        return this;
    }

    public SubMenu setHeaderView(View arg2) {
        this.mSubMenu.setHeaderView(arg2);
        return this;
    }

    public SubMenu setIcon(int arg2) {
        this.mSubMenu.setIcon(arg2);
        return this;
    }

    public SubMenu setIcon(Drawable arg2) {
        this.mSubMenu.setIcon(arg2);
        return this;
    }
}

