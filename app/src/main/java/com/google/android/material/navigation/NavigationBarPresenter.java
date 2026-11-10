package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

public class NavigationBarPresenter implements MenuPresenter {
    class SavedState implements Parcelable {
        class com.google.android.material.navigation.NavigationBarPresenter$SavedState$1 implements Parcelable$Creator {
            com.google.android.material.navigation.NavigationBarPresenter$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg1) {
                return new SavedState(arg1);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        static {
            SavedState.CREATOR = new com.google.android.material.navigation.NavigationBarPresenter$SavedState$1();
        }

        SavedState() {
            super();
        }

        SavedState(Parcel arg2) {
            super();
            this.selectedItemId = arg2.readInt();
            this.badgeSavedStates = arg2.readParcelable(this.getClass().getClassLoader());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            arg1.writeInt(this.selectedItemId);
            arg1.writeParcelable(this.badgeSavedStates, 0);
        }
    }

    private int id;
    private MenuBuilder menu;
    private NavigationBarMenuView menuView;
    private boolean updateSuspended;

    public NavigationBarPresenter() {
        super();
        this.updateSuspended = false;
    }

    public boolean collapseItemActionView(MenuBuilder arg1, MenuItemImpl arg2) {
        return 0;
    }

    public boolean expandItemActionView(MenuBuilder arg1, MenuItemImpl arg2) {
        return 0;
    }

    public boolean flagActionItems() {
        return 0;
    }

    public int getId() {
        return this.id;
    }

    public MenuView getMenuView(ViewGroup arg1) {
        return this.menuView;
    }

    public void initForMenu(Context arg1, MenuBuilder arg2) {
        this.menu = arg2;
        this.menuView.initialize(arg2);
    }

    public void onCloseMenu(MenuBuilder arg1, boolean arg2) {
    }

    public void onRestoreInstanceState(Parcelable arg3) {
        if((arg3 instanceof SavedState)) {
            this.menuView.tryRestoreSelectedItemId(((SavedState)arg3).selectedItemId);
            this.menuView.restoreBadgeDrawables(BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), ((SavedState)arg3).badgeSavedStates));
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState v0 = new SavedState();
        v0.selectedItemId = this.menuView.getSelectedItemId();
        v0.badgeSavedStates = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return ((Parcelable)v0);
    }

    public boolean onSubMenuSelected(SubMenuBuilder arg1) {
        return 0;
    }

    public void setCallback(Callback arg1) {
    }

    public void setId(int arg1) {
        this.id = arg1;
    }

    public void setMenuView(NavigationBarMenuView arg1) {
        this.menuView = arg1;
    }

    public void setUpdateSuspended(boolean arg1) {
        this.updateSuspended = arg1;
    }

    public void updateMenuView(boolean arg2) {
        if(this.updateSuspended) {
            return;
        }

        NavigationBarMenuView v1 = this.menuView;
        if(arg2) {
            v1.buildMenuView();
            return;
        }

        v1.updateMenuView();
    }
}

