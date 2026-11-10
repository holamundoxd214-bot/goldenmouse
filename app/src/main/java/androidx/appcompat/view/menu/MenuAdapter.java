package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {
    MenuBuilder mAdapterMenu;
    private int mExpandedIndex;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder arg2, LayoutInflater arg3, boolean arg4, int arg5) {
        super();
        this.mExpandedIndex = -1;
        this.mOverflowOnly = arg4;
        this.mInflater = arg3;
        this.mAdapterMenu = arg2;
        this.mItemLayoutRes = arg5;
        this.findExpandedIndex();
    }

    void findExpandedIndex() {
        MenuItemImpl v0 = this.mAdapterMenu.getExpandedItem();
        if(v0 != null) {
            ArrayList v1 = this.mAdapterMenu.getNonActionItems();
            int v2 = v1.size();
            int v3 = 0;
            while(v3 < v2) {
                if(v1.get(v3) == v0) {
                    this.mExpandedIndex = v3;
                    return;
                }
                else {
                    ++v3;
                    continue;
                }

                break;
            }
        }

        this.mExpandedIndex = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    public int getCount() {
        boolean v0 = this.mOverflowOnly;
        MenuBuilder v1 = this.mAdapterMenu;
        ArrayList v0_1 = v0 ? v1.getNonActionItems() : v1.getVisibleItems();
        if(this.mExpandedIndex < 0) {
            return v0_1.size();
        }

        return v0_1.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    public MenuItemImpl getItem(int arg3) {
        boolean v0 = this.mOverflowOnly;
        MenuBuilder v1 = this.mAdapterMenu;
        ArrayList v0_1 = v0 ? v1.getNonActionItems() : v1.getVisibleItems();
        int v2 = this.mExpandedIndex;
        if(v2 >= 0 && arg3 >= v2) {
            ++arg3;
        }

        return v0_1.get(arg3);
    }

    public Object getItem(int arg1) {
        return this.getItem(arg1);
    }

    public long getItemId(int arg1) {
        return ((long)arg1);
    }

    public View getView(int arg6, View arg7, ViewGroup arg8) {
        if(arg7 == null) {
            arg7 = this.mInflater.inflate(this.mItemLayoutRes, arg8, false);
        }

        int v8 = this.getItem(arg6).getGroupId();
        int v1 = arg6 - 1;
        v1 = v1 >= 0 ? this.getItem(v1).getGroupId() : v8;
        View v2 = arg7;
        boolean v8_1 = !this.mAdapterMenu.isGroupDividerEnabled() || v8 == v1 ? false : true;
        ((ListMenuItemView)v2).setGroupDividerEnabled(v8_1);
        View v8_2 = arg7;
        if(this.mForceShowIcon) {
            ((ListMenuItemView)v2).setForceShowIcon(true);
        }

        ((ItemView)v8_2).initialize(this.getItem(arg6), 0);
        return arg7;
    }

    public void notifyDataSetChanged() {
        this.findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean arg1) {
        this.mForceShowIcon = arg1;
    }
}

