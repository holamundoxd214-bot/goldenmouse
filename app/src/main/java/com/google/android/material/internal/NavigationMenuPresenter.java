package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;

public class NavigationMenuPresenter implements MenuPresenter {
    class com.google.android.material.internal.NavigationMenuPresenter$1 implements View$OnClickListener {
        com.google.android.material.internal.NavigationMenuPresenter$1(NavigationMenuPresenter arg1) {
            NavigationMenuPresenter.this = arg1;
            super();
        }

        public void onClick(View arg5) {
            int v1 = 1;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl v5 = ((NavigationMenuItemView)arg5).getItemData();
            boolean v0 = NavigationMenuPresenter.this.menu.performItemAction(((MenuItem)v5), NavigationMenuPresenter.this, 0);
            if(v5 == null || !v5.isCheckable() || !v0) {
                v1 = 0;
            }
            else {
                NavigationMenuPresenter.this.adapter.setCheckedItem(v5);
            }

            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if(v1 != 0) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    }

    class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View arg1) {
            super(arg1);
        }
    }

    class NavigationMenuAdapter extends Adapter {
        private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
        private static final String STATE_CHECKED_ITEM = "android:menu:checked";
        private static final int VIEW_TYPE_HEADER = 3;
        private static final int VIEW_TYPE_NORMAL = 0;
        private static final int VIEW_TYPE_SEPARATOR = 2;
        private static final int VIEW_TYPE_SUBHEADER = 1;
        private MenuItemImpl checkedItem;
        private final ArrayList items;
        private boolean updateSuspended;

        NavigationMenuAdapter(NavigationMenuPresenter arg1) {
            NavigationMenuPresenter.this = arg1;
            super();
            this.items = new ArrayList();
            this.prepareMenuItems();
        }

        static int access$100(NavigationMenuAdapter arg0, int arg1) {
            return arg0.adjustItemPositionForA11yDelegate(arg1);
        }

        private int adjustItemPositionForA11yDelegate(int arg5) {
            int v0 = 0;
            int v1 = arg5;
            while(v0 < arg5) {
                if(NavigationMenuPresenter.this.adapter.getItemViewType(v0) == 2 || NavigationMenuPresenter.this.adapter.getItemViewType(v0) == 3) {
                    --v1;
                }

                ++v0;
            }

            return v1;
        }

        private void appendTransparentIconIfMissing(int arg3, int arg4) {
            while(arg3 < arg4) {
                this.items.get(arg3).needsEmptyIcon = true;
                ++arg3;
            }
        }

        public Bundle createInstanceState() {
            Bundle v0 = new Bundle();
            MenuItemImpl v1 = this.checkedItem;
            if(v1 != null) {
                v0.putInt("android:menu:checked", v1.getItemId());
            }

            SparseArray v1_1 = new SparseArray();
            int v2 = this.items.size();
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                Object v4 = this.items.get(v3);
                if((v4 instanceof NavigationMenuTextItem)) {
                    MenuItemImpl v4_1 = ((NavigationMenuTextItem)v4).getMenuItem();
                    View v5 = v4_1 != null ? v4_1.getActionView() : null;
                    if(v5 == null) {
                        goto label_28;
                    }

                    ParcelableSparseArray v6 = new ParcelableSparseArray();
                    v5.saveHierarchyState(((SparseArray)v6));
                    v1_1.put(v4_1.getItemId(), v6);
                }

            label_28:
            }

            v0.putSparseParcelableArray("android:menu:action_views", v1_1);
            return v0;
        }

        public MenuItemImpl getCheckedItem() {
            return this.checkedItem;
        }

        public int getItemCount() {
            return this.items.size();
        }

        public long getItemId(int arg1) {
            return ((long)arg1);
        }

        public int getItemViewType(int arg1) {
            Object v0 = this.items.get(arg1);
            if((v0 instanceof NavigationMenuSeparatorItem)) {
                return 2;
            }

            if((v0 instanceof NavigationMenuHeaderItem)) {
                return 3;
            }

            if((v0 instanceof NavigationMenuTextItem)) {
                if(((NavigationMenuTextItem)v0).getMenuItem().hasSubMenu()) {
                    return 1;
                }

                return 0;
            }

            throw new RuntimeException("Unknown item type.");
        }

        int getRowCount() {
            int v0 = 0;
            int v1 = 0;
            while(v0 < NavigationMenuPresenter.this.adapter.getItemCount()) {
                int v2 = NavigationMenuPresenter.this.adapter.getItemViewType(v0);
                if(v2 == 0 || v2 == 1) {
                    ++v1;
                }

                ++v0;
            }

            return v1;
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder arg1, int arg2) {
            this.onBindViewHolder(((ViewHolder)arg1), arg2);
        }

        public void onBindViewHolder(ViewHolder arg6, int arg7) {
            View v6;
            int v0 = this.getItemViewType(arg7);
            if(v0 != 0) {
                if(v0 != 1) {
                    if(v0 != 2) {
                        return;
                    }

                    Object v7 = this.items.get(arg7);
                    arg6.itemView.setPadding(NavigationMenuPresenter.this.dividerInsetStart, ((NavigationMenuSeparatorItem)v7).getPaddingTop(), NavigationMenuPresenter.this.dividerInsetEnd, ((NavigationMenuSeparatorItem)v7).getPaddingBottom());
                    return;
                }

                v6 = arg6.itemView;
                ((TextView)v6).setText(this.items.get(arg7).getMenuItem().getTitle());
                TextViewCompat.setTextAppearance(((TextView)v6), NavigationMenuPresenter.this.subheaderTextAppearance);
                ((TextView)v6).setPadding(NavigationMenuPresenter.this.subheaderInsetStart, ((TextView)v6).getPaddingTop(), NavigationMenuPresenter.this.subheaderInsetEnd, ((TextView)v6).getPaddingBottom());
                if(NavigationMenuPresenter.this.subheaderColor != null) {
                    ((TextView)v6).setTextColor(NavigationMenuPresenter.this.subheaderColor);
                }

                this.setAccessibilityDelegate(v6, arg7, true);
                return;
            }

            v6 = arg6.itemView;
            ((NavigationMenuItemView)v6).setIconTintList(NavigationMenuPresenter.this.iconTintList);
            ((NavigationMenuItemView)v6).setTextAppearance(NavigationMenuPresenter.this.textAppearance);
            if(NavigationMenuPresenter.this.textColor != null) {
                ((NavigationMenuItemView)v6).setTextColor(NavigationMenuPresenter.this.textColor);
            }

            Drawable v0_1 = NavigationMenuPresenter.this.itemBackground != null ? NavigationMenuPresenter.this.itemBackground.getConstantState().newDrawable() : null;
            ViewCompat.setBackground(v6, v0_1);
            if(NavigationMenuPresenter.this.itemForeground != null) {
                ((NavigationMenuItemView)v6).setForeground(NavigationMenuPresenter.this.itemForeground.getConstantState().newDrawable());
            }

            Object v0_2 = this.items.get(arg7);
            ((NavigationMenuItemView)v6).setNeedsEmptyIcon(((NavigationMenuTextItem)v0_2).needsEmptyIcon);
            ((NavigationMenuItemView)v6).setPadding(NavigationMenuPresenter.this.itemHorizontalPadding, NavigationMenuPresenter.this.itemVerticalPadding, NavigationMenuPresenter.this.itemHorizontalPadding, NavigationMenuPresenter.this.itemVerticalPadding);
            ((NavigationMenuItemView)v6).setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
            if(NavigationMenuPresenter.this.hasCustomItemIconSize) {
                ((NavigationMenuItemView)v6).setIconSize(NavigationMenuPresenter.this.itemIconSize);
            }

            ((NavigationMenuItemView)v6).setMaxLines(NavigationMenuPresenter.this.itemMaxLines);
            ((NavigationMenuItemView)v6).initialize(((NavigationMenuTextItem)v0_2).getMenuItem(), NavigationMenuPresenter.this.textAppearanceActiveBoldEnabled);
            this.setAccessibilityDelegate(v6, arg7, false);
        }

        public androidx.recyclerview.widget.RecyclerView$ViewHolder onCreateViewHolder(ViewGroup arg1, int arg2) {
            return this.onCreateViewHolder(arg1, arg2);
        }

        public ViewHolder onCreateViewHolder(ViewGroup arg2, int arg3) {
            if(arg3 != 0) {
                if(arg3 != 1) {
                    if(arg3 != 2) {
                        if(arg3 != 3) {
                            return null;
                        }

                        return new HeaderViewHolder(NavigationMenuPresenter.this.headerLayout);
                    }

                    return new SeparatorViewHolder(NavigationMenuPresenter.this.layoutInflater, arg2);
                }

                return new SubheaderViewHolder(NavigationMenuPresenter.this.layoutInflater, arg2);
            }

            return new NormalViewHolder(NavigationMenuPresenter.this.layoutInflater, arg2, NavigationMenuPresenter.this.onClickListener);
        }

        public void onViewRecycled(androidx.recyclerview.widget.RecyclerView$ViewHolder arg1) {
            this.onViewRecycled(((ViewHolder)arg1));
        }

        public void onViewRecycled(ViewHolder arg1) {
            if((arg1 instanceof NormalViewHolder)) {
                arg1.itemView.recycle();
            }
        }

        private void prepareMenuItems() {
            NavigationMenuAdapter v0 = this;
            if(v0.updateSuspended) {
                return;
            }

            int v1 = 1;
            v0.updateSuspended = true;
            v0.items.clear();
            v0.items.add(new NavigationMenuHeaderItem());
            int v2 = v0.this$0.menu.getVisibleItems().size();
            int v4 = -1;
            int v5 = 0;
            boolean v6 = false;
            int v7 = 0;
            while(v5 < v2) {
                Object v8 = v0.this$0.menu.getVisibleItems().get(v5);
                if(((MenuItemImpl)v8).isChecked()) {
                    v0.setCheckedItem(((MenuItemImpl)v8));
                }

                if(((MenuItemImpl)v8).isCheckable()) {
                    ((MenuItemImpl)v8).setExclusiveCheckable(false);
                }

                if(((MenuItemImpl)v8).hasSubMenu()) {
                    SubMenu v9 = ((MenuItemImpl)v8).getSubMenu();
                    if(v9.hasVisibleItems()) {
                        if(v5 != 0) {
                            v0.items.add(new NavigationMenuSeparatorItem(v0.this$0.paddingSeparator, 0));
                        }

                        v0.items.add(new NavigationMenuTextItem(((MenuItemImpl)v8)));
                        int v10 = v0.items.size();
                        int v11 = v9.size();
                        int v12 = 0;
                        int v13 = 0;
                        while(v12 < v11) {
                            MenuItem v14 = v9.getItem(v12);
                            if(((MenuItemImpl)v14).isVisible()) {
                                if(v13 == 0 && ((MenuItemImpl)v14).getIcon() != null) {
                                    v13 = v1;
                                }

                                if(((MenuItemImpl)v14).isCheckable()) {
                                    ((MenuItemImpl)v14).setExclusiveCheckable(false);
                                }

                                if(((MenuItemImpl)v8).isChecked()) {
                                    v0.setCheckedItem(((MenuItemImpl)v8));
                                }

                                v0.items.add(new NavigationMenuTextItem(((MenuItemImpl)v14)));
                            }

                            ++v12;
                            v1 = 1;
                        }

                        if(v13 == 0) {
                            goto label_112;
                        }

                        v0.appendTransparentIconIfMissing(v10, v0.items.size());
                    }
                }
                else {
                    v1 = ((MenuItemImpl)v8).getGroupId();
                    if(v1 != v4) {
                        v7 = v0.items.size();
                        v6 = ((MenuItemImpl)v8).getIcon() != null ? true : false;
                        if(v5 == 0) {
                            goto label_106;
                        }

                        ++v7;
                        v0.items.add(new NavigationMenuSeparatorItem(v0.this$0.paddingSeparator, v0.this$0.paddingSeparator));
                    }
                    else {
                        if(v6) {
                            goto label_106;
                        }

                        if(((MenuItemImpl)v8).getIcon() == null) {
                            goto label_106;
                        }

                        v0.appendTransparentIconIfMissing(v7, v0.items.size());
                        v6 = true;
                    }

                label_106:
                    NavigationMenuTextItem v4_1 = new NavigationMenuTextItem(((MenuItemImpl)v8));
                    v4_1.needsEmptyIcon = v6;
                    v0.items.add(v4_1);
                    v4 = v1;
                }

            label_112:
                ++v5;
                v1 = 1;
            }

            v0.updateSuspended = false;
        }

        public void restoreInstanceState(Bundle arg7) {
            int v1 = 0;
            int v0 = arg7.getInt("android:menu:checked", 0);
            if(v0 != 0) {
                this.updateSuspended = true;
                int v2 = this.items.size();
                int v3;
                for(v3 = 0; v3 < v2; ++v3) {
                    Object v4 = this.items.get(v3);
                    if((v4 instanceof NavigationMenuTextItem)) {
                        MenuItemImpl v4_1 = ((NavigationMenuTextItem)v4).getMenuItem();
                        if(v4_1 != null && v4_1.getItemId() == v0) {
                            this.setCheckedItem(v4_1);
                            break;
                        }
                    }
                }

                this.updateSuspended = false;
                this.prepareMenuItems();
            }

            SparseArray v7 = arg7.getSparseParcelableArray("android:menu:action_views");
            if(v7 != null) {
                v0 = this.items.size();
                while(v1 < v0) {
                    Object v2_1 = this.items.get(v1);
                    if(!(v2_1 instanceof NavigationMenuTextItem)) {
                    }
                    else {
                        MenuItemImpl v2_2 = ((NavigationMenuTextItem)v2_1).getMenuItem();
                        if(v2_2 == null) {
                        }
                        else {
                            View v3_1 = v2_2.getActionView();
                            if(v3_1 == null) {
                            }
                            else {
                                v2_1 = v7.get(v2_2.getItemId());
                                if(v2_1 == null) {
                                }
                                else {
                                    v3_1.restoreHierarchyState(((SparseArray)v2_1));
                                }
                            }
                        }
                    }

                    ++v1;
                }
            }
        }

        private void setAccessibilityDelegate(View arg2, int arg3, boolean arg4) {
            ViewCompat.setAccessibilityDelegate(arg2, new AccessibilityDelegateCompat(arg3, arg4) {
                public void onInitializeAccessibilityNodeInfo(View arg9, AccessibilityNodeInfoCompat arg10) {
                    super.onInitializeAccessibilityNodeInfo(arg9, arg10);
                    arg10.setCollectionItemInfo(CollectionItemInfoCompat.obtain(this.this$1.adjustItemPositionForA11yDelegate(this.val$position), 1, 1, 1, this.val$isHeader, arg9.isSelected()));
                }
            });
        }

        public void setCheckedItem(MenuItemImpl arg3) {
            if(this.checkedItem != arg3) {
                if(!arg3.isCheckable()) {
                }
                else {
                    MenuItemImpl v0 = this.checkedItem;
                    if(v0 != null) {
                        v0.setChecked(false);
                    }

                    this.checkedItem = arg3;
                    arg3.setChecked(true);
                }
            }
        }

        public void setUpdateSuspended(boolean arg1) {
            this.updateSuspended = arg1;
        }

        public void update() {
            this.prepareMenuItems();
            this.notifyDataSetChanged();
        }
    }

    class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
            super();
        }
    }

    interface NavigationMenuItem {
    }

    class NavigationMenuSeparatorItem implements NavigationMenuItem {
        private final int paddingBottom;
        private final int paddingTop;

        public NavigationMenuSeparatorItem(int arg1, int arg2) {
            super();
            this.paddingTop = arg1;
            this.paddingBottom = arg2;
        }

        public int getPaddingBottom() {
            return this.paddingBottom;
        }

        public int getPaddingTop() {
            return this.paddingTop;
        }
    }

    class NavigationMenuTextItem implements NavigationMenuItem {
        private final MenuItemImpl menuItem;
        boolean needsEmptyIcon;

        NavigationMenuTextItem(MenuItemImpl arg1) {
            super();
            this.menuItem = arg1;
        }

        public MenuItemImpl getMenuItem() {
            return this.menuItem;
        }
    }

    class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        NavigationMenuViewAccessibilityDelegate(NavigationMenuPresenter arg1, RecyclerView arg2) {
            NavigationMenuPresenter.this = arg1;
            super(arg2);
        }

        public void onInitializeAccessibilityNodeInfo(View arg2, AccessibilityNodeInfoCompat arg3) {
            super.onInitializeAccessibilityNodeInfo(arg2, arg3);
            arg3.setCollectionInfo(CollectionInfoCompat.obtain(NavigationMenuPresenter.this.adapter.getRowCount(), 1, false));
        }
    }

    class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(LayoutInflater arg3, ViewGroup arg4, View$OnClickListener arg5) {
            super(arg3.inflate(layout.design_navigation_item, arg4, false));
            this.itemView.setOnClickListener(arg5);
        }
    }

    class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(LayoutInflater arg3, ViewGroup arg4) {
            super(arg3.inflate(layout.design_navigation_item_separator, arg4, false));
        }
    }

    class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(LayoutInflater arg3, ViewGroup arg4) {
            super(arg3.inflate(layout.design_navigation_item_subheader, arg4, false));
        }
    }

    abstract class ViewHolder extends androidx.recyclerview.widget.RecyclerView$ViewHolder {
        public ViewHolder(View arg1) {
            super(arg1);
        }
    }

    public static final int NO_TEXT_APPEARANCE_SET = 0;
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    NavigationMenuAdapter adapter;
    private Callback callback;
    int dividerInsetEnd;
    int dividerInsetStart;
    boolean hasCustomItemIconSize;
    LinearLayout headerLayout;
    ColorStateList iconTintList;
    private int id;
    boolean isBehindStatusBar;
    Drawable itemBackground;
    RippleDrawable itemForeground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    private int itemMaxLines;
    int itemVerticalPadding;
    LayoutInflater layoutInflater;
    MenuBuilder menu;
    private NavigationMenuView menuView;
    final View$OnClickListener onClickListener;
    private int overScrollMode;
    int paddingSeparator;
    private int paddingTopDefault;
    ColorStateList subheaderColor;
    int subheaderInsetEnd;
    int subheaderInsetStart;
    int subheaderTextAppearance;
    int textAppearance;
    boolean textAppearanceActiveBoldEnabled;
    ColorStateList textColor;

    public NavigationMenuPresenter() {
        super();
        this.subheaderTextAppearance = 0;
        this.textAppearance = 0;
        this.textAppearanceActiveBoldEnabled = true;
        this.isBehindStatusBar = true;
        this.overScrollMode = -1;
        this.onClickListener = new com.google.android.material.internal.NavigationMenuPresenter$1(this);
    }

    static int access$000(NavigationMenuPresenter arg0) {
        return arg0.itemMaxLines;
    }

    public void addHeaderView(View arg2) {
        this.headerLayout.addView(arg2);
        this.menuView.setPadding(0, 0, 0, this.menuView.getPaddingBottom());
    }

    public boolean collapseItemActionView(MenuBuilder arg1, MenuItemImpl arg2) {
        return 0;
    }

    public void dispatchApplyWindowInsets(WindowInsetsCompat arg5) {
        int v0 = arg5.getSystemWindowInsetTop();
        if(this.paddingTopDefault != v0) {
            this.paddingTopDefault = v0;
            this.updateTopPadding();
        }

        this.menuView.setPadding(0, this.menuView.getPaddingTop(), 0, arg5.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.headerLayout, arg5);
    }

    public boolean expandItemActionView(MenuBuilder arg1, MenuItemImpl arg2) {
        return 0;
    }

    public boolean flagActionItems() {
        return 0;
    }

    public MenuItemImpl getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    public int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    public int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int arg1) {
        return this.headerLayout.getChildAt(arg1);
    }

    public int getId() {
        return this.id;
    }

    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    public int getItemVerticalPadding() {
        return this.itemVerticalPadding;
    }

    public MenuView getMenuView(ViewGroup arg4) {
        if(this.menuView == null) {
            View v4 = this.layoutInflater.inflate(layout.design_navigation_menu, arg4, false);
            this.menuView = ((NavigationMenuView)v4);
            ((NavigationMenuView)v4).setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this, this.menuView));
            if(this.adapter == null) {
                this.adapter = new NavigationMenuAdapter(this);
            }

            int v4_1 = this.overScrollMode;
            if(v4_1 != -1) {
                this.menuView.setOverScrollMode(v4_1);
            }

            v4 = this.layoutInflater.inflate(layout.design_navigation_item_header, this.menuView, false);
            this.headerLayout = ((LinearLayout)v4);
            ViewCompat.setImportantForAccessibility(v4, 2);
            this.menuView.setAdapter(this.adapter);
        }

        return this.menuView;
    }

    public int getSubheaderInsetEnd() {
        return this.subheaderInsetEnd;
    }

    public int getSubheaderInsetStart() {
        return this.subheaderInsetStart;
    }

    private boolean hasHeader() {
        if(this.getHeaderCount() > 0) {
            return 1;
        }

        return 0;
    }

    public View inflateHeaderView(int arg4) {
        View v4 = this.layoutInflater.inflate(arg4, this.headerLayout, false);
        this.addHeaderView(v4);
        return v4;
    }

    public void initForMenu(Context arg2, MenuBuilder arg3) {
        this.layoutInflater = LayoutInflater.from(arg2);
        this.menu = arg3;
        this.paddingSeparator = arg2.getResources().getDimensionPixelOffset(dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    public void onCloseMenu(MenuBuilder arg1, boolean arg2) {
        Callback v0 = this.callback;
        if(v0 != null) {
            v0.onCloseMenu(arg1, arg2);
        }
    }

    public void onRestoreInstanceState(Parcelable arg3) {
        if((arg3 instanceof Bundle)) {
            SparseArray v0 = ((Bundle)arg3).getSparseParcelableArray("android:menu:list");
            if(v0 != null) {
                this.menuView.restoreHierarchyState(v0);
            }

            Bundle v0_1 = ((Bundle)arg3).getBundle("android:menu:adapter");
            if(v0_1 != null) {
                this.adapter.restoreInstanceState(v0_1);
            }

            SparseArray v3 = ((Bundle)arg3).getSparseParcelableArray("android:menu:header");
            if(v3 == null) {
                return;
            }

            this.headerLayout.restoreHierarchyState(v3);
        }
    }

    public Parcelable onSaveInstanceState() {
        SparseArray v1;
        Bundle v0 = new Bundle();
        if(this.menuView != null) {
            v1 = new SparseArray();
            this.menuView.saveHierarchyState(v1);
            v0.putSparseParcelableArray("android:menu:list", v1);
        }

        NavigationMenuAdapter v1_1 = this.adapter;
        if(v1_1 != null) {
            v0.putBundle("android:menu:adapter", v1_1.createInstanceState());
        }

        if(this.headerLayout != null) {
            v1 = new SparseArray();
            this.headerLayout.saveHierarchyState(v1);
            v0.putSparseParcelableArray("android:menu:header", v1);
        }

        return ((Parcelable)v0);
    }

    public boolean onSubMenuSelected(SubMenuBuilder arg1) {
        return 0;
    }

    public void removeHeaderView(View arg3) {
        this.headerLayout.removeView(arg3);
        if(!this.hasHeader()) {
            this.menuView.setPadding(0, this.paddingTopDefault, 0, this.menuView.getPaddingBottom());
        }
    }

    public void setBehindStatusBar(boolean arg2) {
        if(this.isBehindStatusBar != arg2) {
            this.isBehindStatusBar = arg2;
            this.updateTopPadding();
        }
    }

    public void setCallback(Callback arg1) {
        this.callback = arg1;
    }

    public void setCheckedItem(MenuItemImpl arg1) {
        this.adapter.setCheckedItem(arg1);
    }

    public void setDividerInsetEnd(int arg1) {
        this.dividerInsetEnd = arg1;
        this.updateMenuView(false);
    }

    public void setDividerInsetStart(int arg1) {
        this.dividerInsetStart = arg1;
        this.updateMenuView(false);
    }

    public void setId(int arg1) {
        this.id = arg1;
    }

    public void setItemBackground(Drawable arg1) {
        this.itemBackground = arg1;
        this.updateMenuView(false);
    }

    public void setItemForeground(RippleDrawable arg1) {
        this.itemForeground = arg1;
        this.updateMenuView(false);
    }

    public void setItemHorizontalPadding(int arg1) {
        this.itemHorizontalPadding = arg1;
        this.updateMenuView(false);
    }

    public void setItemIconPadding(int arg1) {
        this.itemIconPadding = arg1;
        this.updateMenuView(false);
    }

    public void setItemIconSize(int arg2) {
        if(this.itemIconSize != arg2) {
            this.itemIconSize = arg2;
            this.hasCustomItemIconSize = true;
            this.updateMenuView(false);
        }
    }

    public void setItemIconTintList(ColorStateList arg1) {
        this.iconTintList = arg1;
        this.updateMenuView(false);
    }

    public void setItemMaxLines(int arg1) {
        this.itemMaxLines = arg1;
        this.updateMenuView(false);
    }

    public void setItemTextAppearance(int arg1) {
        this.textAppearance = arg1;
        this.updateMenuView(false);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean arg1) {
        this.textAppearanceActiveBoldEnabled = arg1;
        this.updateMenuView(false);
    }

    public void setItemTextColor(ColorStateList arg1) {
        this.textColor = arg1;
        this.updateMenuView(false);
    }

    public void setItemVerticalPadding(int arg1) {
        this.itemVerticalPadding = arg1;
        this.updateMenuView(false);
    }

    public void setOverScrollMode(int arg1) {
        this.overScrollMode = arg1;
        NavigationMenuView v0 = this.menuView;
        if(v0 != null) {
            v0.setOverScrollMode(arg1);
        }
    }

    public void setSubheaderColor(ColorStateList arg1) {
        this.subheaderColor = arg1;
        this.updateMenuView(false);
    }

    public void setSubheaderInsetEnd(int arg1) {
        this.subheaderInsetEnd = arg1;
        this.updateMenuView(false);
    }

    public void setSubheaderInsetStart(int arg1) {
        this.subheaderInsetStart = arg1;
        this.updateMenuView(false);
    }

    public void setSubheaderTextAppearance(int arg1) {
        this.subheaderTextAppearance = arg1;
        this.updateMenuView(false);
    }

    public void setUpdateSuspended(boolean arg1) {
        NavigationMenuAdapter v0 = this.adapter;
        if(v0 != null) {
            v0.setUpdateSuspended(arg1);
        }
    }

    public void updateMenuView(boolean arg1) {
        NavigationMenuAdapter v0 = this.adapter;
        if(v0 != null) {
            v0.update();
        }
    }

    private void updateTopPadding() {
        int v0 = (this.hasHeader()) || !this.isBehindStatusBar ? 0 : this.paddingTopDefault;
        this.menuView.setPadding(0, v0, 0, this.menuView.getPaddingBottom());
    }
}

