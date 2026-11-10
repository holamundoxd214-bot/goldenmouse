package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    public SubMenuBuilder(Context arg1, MenuBuilder arg2, MenuItemImpl arg3) {
        super(arg1);
        this.mParentMenu = arg2;
        this.mItem = arg3;
    }

    public boolean collapseItemActionView(MenuItemImpl arg1) {
        return this.mParentMenu.collapseItemActionView(arg1);
    }

    boolean dispatchMenuItemSelected(MenuBuilder arg2, MenuItem arg3) {
        if(!super.dispatchMenuItemSelected(arg2, arg3)) {
            if(this.mParentMenu.dispatchMenuItemSelected(arg2, arg3)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean expandItemActionView(MenuItemImpl arg1) {
        return this.mParentMenu.expandItemActionView(arg1);
    }

    public String getActionViewStatesKey() {
        MenuItemImpl v0 = this.mItem;
        int v0_1 = v0 != null ? v0.getItemId() : 0;
        if(v0_1 == 0) {
            return null;
        }

        return super.getActionViewStatesKey() + ":" + v0_1;
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public void setCallback(Callback arg1) {
        this.mParentMenu.setCallback(arg1);
    }

    public void setGroupDividerEnabled(boolean arg1) {
        this.mParentMenu.setGroupDividerEnabled(arg1);
    }

    public SubMenu setHeaderIcon(int arg1) {
        return super.setHeaderIconInt(arg1);
    }

    public SubMenu setHeaderIcon(Drawable arg1) {
        return super.setHeaderIconInt(arg1);
    }

    public SubMenu setHeaderTitle(CharSequence arg1) {
        return super.setHeaderTitleInt(arg1);
    }

    public SubMenu setHeaderTitle(int arg1) {
        return super.setHeaderTitleInt(arg1);
    }

    public SubMenu setHeaderView(View arg1) {
        return super.setHeaderViewInt(arg1);
    }

    public SubMenu setIcon(int arg2) {
        this.mItem.setIcon(arg2);
        return this;
    }

    public SubMenu setIcon(Drawable arg2) {
        this.mItem.setIcon(arg2);
        return this;
    }

    public void setQwertyMode(boolean arg1) {
        this.mParentMenu.setQwertyMode(arg1);
    }

    public void setShortcutsVisible(boolean arg1) {
        this.mParentMenu.setShortcutsVisible(arg1);
    }
}

