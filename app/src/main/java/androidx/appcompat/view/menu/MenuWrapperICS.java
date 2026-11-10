package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.internal.view.SupportMenu;

public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context arg1, SupportMenu arg2) {
        super(arg1);
        if(arg2 != null) {
            this.mWrappedObject = arg2;
            return;
        }

        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(int arg2) {
        return this.getMenuItemWrapper(this.mWrappedObject.add(arg2));
    }

    public MenuItem add(int arg2, int arg3, int arg4, int arg5) {
        return this.getMenuItemWrapper(this.mWrappedObject.add(arg2, arg3, arg4, arg5));
    }

    public MenuItem add(int arg2, int arg3, int arg4, CharSequence arg5) {
        return this.getMenuItemWrapper(this.mWrappedObject.add(arg2, arg3, arg4, arg5));
    }

    public MenuItem add(CharSequence arg2) {
        return this.getMenuItemWrapper(this.mWrappedObject.add(arg2));
    }

    public int addIntentOptions(int arg12, int arg13, int arg14, ComponentName arg15, Intent[] arg16, Intent arg17, int arg18, MenuItem[] arg19) {
        MenuItem[] v0 = arg19;
        MenuItem[] v1 = v0 != null ? new MenuItem[v0.length] : null;
        MenuItem[] v10 = v1;
        arg12 = this.mWrappedObject.addIntentOptions(arg12, arg13, arg14, arg15, arg16, arg17, arg18, v10);
        if(v10 != null) {
            arg13 = v10.length;
            for(arg14 = 0; arg14 < arg13; ++arg14) {
                v0[arg14] = this.getMenuItemWrapper(v10[arg14]);
            }
        }

        return arg12;
    }

    public SubMenu addSubMenu(int arg2) {
        return this.getSubMenuWrapper(this.mWrappedObject.addSubMenu(arg2));
    }

    public SubMenu addSubMenu(int arg2, int arg3, int arg4, int arg5) {
        return this.getSubMenuWrapper(this.mWrappedObject.addSubMenu(arg2, arg3, arg4, arg5));
    }

    public SubMenu addSubMenu(int arg2, int arg3, int arg4, CharSequence arg5) {
        return this.getSubMenuWrapper(this.mWrappedObject.addSubMenu(arg2, arg3, arg4, arg5));
    }

    public SubMenu addSubMenu(CharSequence arg2) {
        return this.getSubMenuWrapper(this.mWrappedObject.addSubMenu(arg2));
    }

    public void clear() {
        this.internalClear();
        this.mWrappedObject.clear();
    }

    public void close() {
        this.mWrappedObject.close();
    }

    public MenuItem findItem(int arg2) {
        return this.getMenuItemWrapper(this.mWrappedObject.findItem(arg2));
    }

    public MenuItem getItem(int arg2) {
        return this.getMenuItemWrapper(this.mWrappedObject.getItem(arg2));
    }

    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    public boolean isShortcutKey(int arg1, KeyEvent arg2) {
        return this.mWrappedObject.isShortcutKey(arg1, arg2);
    }

    public boolean performIdentifierAction(int arg1, int arg2) {
        return this.mWrappedObject.performIdentifierAction(arg1, arg2);
    }

    public boolean performShortcut(int arg1, KeyEvent arg2, int arg3) {
        return this.mWrappedObject.performShortcut(arg1, arg2, arg3);
    }

    public void removeGroup(int arg1) {
        this.internalRemoveGroup(arg1);
        this.mWrappedObject.removeGroup(arg1);
    }

    public void removeItem(int arg1) {
        this.internalRemoveItem(arg1);
        this.mWrappedObject.removeItem(arg1);
    }

    public void setGroupCheckable(int arg1, boolean arg2, boolean arg3) {
        this.mWrappedObject.setGroupCheckable(arg1, arg2, arg3);
    }

    public void setGroupEnabled(int arg1, boolean arg2) {
        this.mWrappedObject.setGroupEnabled(arg1, arg2);
    }

    public void setGroupVisible(int arg1, boolean arg2) {
        this.mWrappedObject.setGroupVisible(arg1, arg2);
    }

    public void setQwertyMode(boolean arg1) {
        this.mWrappedObject.setQwertyMode(arg1);
    }

    public int size() {
        return this.mWrappedObject.size();
    }
}

