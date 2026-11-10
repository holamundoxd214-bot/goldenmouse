package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

abstract class BaseMenuWrapper {
    final Context mContext;
    private SimpleArrayMap mMenuItems;
    private SimpleArrayMap mSubMenus;

    BaseMenuWrapper(Context arg1) {
        super();
        this.mContext = arg1;
    }

    final MenuItem getMenuItemWrapper(MenuItem arg3) {
        MenuItemWrapperICS v0_2;
        if((arg3 instanceof SupportMenuItem)) {
            SimpleArrayMap v0 = this.mMenuItems;
            if(v0 == null) {
                v0 = new SimpleArrayMap();
                this.mMenuItems = v0;
            }

            Object v0_1 = v0.get(arg3);
            if(v0_1 == null) {
                v0_2 = new MenuItemWrapperICS(this.mContext, ((SupportMenuItem)arg3));
                this.mMenuItems.put(arg3, v0_2);
            }

            return ((MenuItem)v0_2);
        }

        return arg3;
    }

    final SubMenu getSubMenuWrapper(SubMenu arg3) {
        SubMenuWrapperICS v0_2;
        if((arg3 instanceof SupportSubMenu)) {
            SimpleArrayMap v0 = this.mSubMenus;
            if(v0 == null) {
                v0 = new SimpleArrayMap();
                this.mSubMenus = v0;
            }

            Object v0_1 = v0.get(arg3);
            if(v0_1 == null) {
                v0_2 = new SubMenuWrapperICS(this.mContext, ((SupportSubMenu)arg3));
                this.mSubMenus.put(arg3, v0_2);
            }

            return ((SubMenu)v0_2);
        }

        return arg3;
    }

    final void internalClear() {
        SimpleArrayMap v0 = this.mMenuItems;
        if(v0 != null) {
            v0.clear();
        }

        SimpleArrayMap v1 = this.mSubMenus;
        if(v1 != null) {
            v1.clear();
        }
    }

    final void internalRemoveGroup(int arg3) {
        if(this.mMenuItems == null) {
        }
        else {
            int v0;
            for(v0 = 0; v0 < this.mMenuItems.size(); ++v0) {
                if(this.mMenuItems.keyAt(v0).getGroupId() == arg3) {
                    this.mMenuItems.removeAt(v0);
                    --v0;
                }
            }
        }
    }

    final void internalRemoveItem(int arg3) {
        if(this.mMenuItems == null) {
        }
        else {
            int v0 = 0;
            while(v0 < this.mMenuItems.size()) {
                if(this.mMenuItems.keyAt(v0).getItemId() == arg3) {
                    this.mMenuItems.removeAt(v0);
                    return;
                }
                else {
                    ++v0;
                    continue;
                }

                return;
            }
        }
    }
}

