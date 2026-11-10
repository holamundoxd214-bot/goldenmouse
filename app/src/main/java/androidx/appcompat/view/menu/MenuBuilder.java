package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.KeyCharacterMap$KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder implements SupportMenu {
    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder arg1, MenuItem arg2);

        void onMenuModeChange(MenuBuilder arg1);
    }

    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl arg1);
    }

    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private ArrayList mActionItems;
    private Callback mCallback;
    private final Context mContext;
    private ContextMenu$ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction;
    private MenuItemImpl mExpandedItem;
    private boolean mGroupDividerEnabled;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing;
    private boolean mIsVisibleItemsStale;
    private ArrayList mItems;
    private boolean mItemsChangedWhileDispatchPrevented;
    private ArrayList mNonActionItems;
    private boolean mOptionalIconsVisible;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList mPresenters;
    private boolean mPreventDispatchingItemsChanged;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented;
    private ArrayList mTempShortcutItemList;
    private ArrayList mVisibleItems;
    private static final int[] sCategoryToOrder;

    static {
        MenuBuilder.sCategoryToOrder = new int[]{1, 4, 5, 3, 2, 0};
    }

    public MenuBuilder(Context arg3) {
        super();
        this.mDefaultShowAsAction = 0;
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        this.mOptionalIconsVisible = false;
        this.mIsClosing = false;
        this.mTempShortcutItemList = new ArrayList();
        this.mPresenters = new CopyOnWriteArrayList();
        this.mGroupDividerEnabled = false;
        this.mContext = arg3;
        this.mResources = arg3.getResources();
        this.mItems = new ArrayList();
        this.mVisibleItems = new ArrayList();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList();
        this.mNonActionItems = new ArrayList();
        this.mIsActionItemsStale = true;
        this.setShortcutsVisibleInner(true);
    }

    public MenuItem add(int arg2) {
        return this.addInternal(0, 0, 0, this.mResources.getString(arg2));
    }

    public MenuItem add(int arg2, int arg3, int arg4, int arg5) {
        return this.addInternal(arg2, arg3, arg4, this.mResources.getString(arg5));
    }

    public MenuItem add(int arg1, int arg2, int arg3, CharSequence arg4) {
        return this.addInternal(arg1, arg2, arg3, arg4);
    }

    public MenuItem add(CharSequence arg2) {
        return this.addInternal(0, 0, 0, arg2);
    }

    public int addIntentOptions(int arg8, int arg9, int arg10, ComponentName arg11, Intent[] arg12, Intent arg13, int arg14, MenuItem[] arg15) {
        PackageManager v0 = this.mContext.getPackageManager();
        int v1 = 0;
        List v11 = v0.queryIntentActivityOptions(arg11, arg12, arg13, 0);
        int v2 = v11 != null ? v11.size() : 0;
        if((arg14 & 1) == 0) {
            this.removeGroup(arg8);
        }

        while(v1 < v2) {
            Object v14 = v11.get(v1);
            Intent v4 = ((ResolveInfo)v14).specificIndex < 0 ? arg13 : arg12[((ResolveInfo)v14).specificIndex];
            Intent v3 = new Intent(v4);
            v3.setComponent(new ComponentName(((ResolveInfo)v14).activityInfo.applicationInfo.packageName, ((ResolveInfo)v14).activityInfo.name));
            MenuItem v3_1 = this.add(arg8, arg9, arg10, ((ResolveInfo)v14).loadLabel(v0)).setIcon(((ResolveInfo)v14).loadIcon(v0)).setIntent(v3);
            if(arg15 != null && ((ResolveInfo)v14).specificIndex >= 0) {
                arg15[((ResolveInfo)v14).specificIndex] = v3_1;
            }

            ++v1;
        }

        return v2;
    }

    protected MenuItem addInternal(int arg8, int arg9, int arg10, CharSequence arg11) {
        int v4 = MenuBuilder.getOrdering(arg10);
        MenuBuilder v0 = this;
        MenuItemImpl v7 = v0.createNewMenuItem(arg8, arg9, arg10, v4, arg11, this.mDefaultShowAsAction);
        ContextMenu$ContextMenuInfo v8 = v0.mCurrentMenuInfo;
        if(v8 != null) {
            v7.setMenuInfo(v8);
        }

        v0.mItems.add(MenuBuilder.findInsertIndex(v0.mItems, v4), v7);
        v0.onItemsChanged(true);
        return ((MenuItem)v7);
    }

    public void addMenuPresenter(MenuPresenter arg2) {
        this.addMenuPresenter(arg2, this.mContext);
    }

    public void addMenuPresenter(MenuPresenter arg3, Context arg4) {
        this.mPresenters.add(new WeakReference(arg3));
        arg3.initForMenu(arg4, this);
        this.mIsActionItemsStale = true;
    }

    public SubMenu addSubMenu(int arg2) {
        return this.addSubMenu(0, 0, 0, this.mResources.getString(arg2));
    }

    public SubMenu addSubMenu(int arg1, int arg2, int arg3, CharSequence arg4) {
        MenuItem v1 = this.addInternal(arg1, arg2, arg3, arg4);
        SubMenuBuilder v2 = new SubMenuBuilder(this.mContext, this, ((MenuItemImpl)v1));
        ((MenuItemImpl)v1).setSubMenu(v2);
        return ((SubMenu)v2);
    }

    public SubMenu addSubMenu(int arg2, int arg3, int arg4, int arg5) {
        return this.addSubMenu(arg2, arg3, arg4, this.mResources.getString(arg5));
    }

    public SubMenu addSubMenu(CharSequence arg2) {
        return this.addSubMenu(0, 0, 0, arg2);
    }

    public void changeMenuMode() {
        Callback v0 = this.mCallback;
        if(v0 != null) {
            v0.onMenuModeChange(this);
        }
    }

    public void clear() {
        MenuItemImpl v0 = this.mExpandedItem;
        if(v0 != null) {
            this.collapseItemActionView(v0);
        }

        this.mItems.clear();
        this.onItemsChanged(true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        this.clear();
        this.clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        this.onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        this.onItemsChanged(false);
    }

    public void close() {
        this.close(true);
    }

    public final void close(boolean arg4) {
        if(this.mIsClosing) {
            return;
        }

        this.mIsClosing = true;
        Iterator v0 = this.mPresenters.iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = ((WeakReference)v1).get();
            if(v2 == null) {
                this.mPresenters.remove(v1);
                continue;
            }

            ((MenuPresenter)v2).onCloseMenu(this, arg4);
        }

        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl arg5) {
        boolean v1 = false;
        if(!this.mPresenters.isEmpty()) {
            if(this.mExpandedItem != arg5) {
            }
            else {
                this.stopDispatchingItemsChanged();
                Iterator v0 = this.mPresenters.iterator();
                do {
                    if(!v0.hasNext()) {
                        break;
                    }

                    Object v2 = v0.next();
                    Object v3 = ((WeakReference)v2).get();
                    if(v3 == null) {
                        this.mPresenters.remove(v2);
                        continue;
                    }
                    else {
                        v1 = ((MenuPresenter)v3).collapseItemActionView(this, arg5);
                        if(!v1) {
                            continue;
                        }
                    }

                    break;
                }
                while(true);

                this.startDispatchingItemsChanged();
                if(!v1) {
                    return v1;
                }

                this.mExpandedItem = null;
            }
        }

        return v1;
    }

    private MenuItemImpl createNewMenuItem(int arg9, int arg10, int arg11, int arg12, CharSequence arg13, int arg14) {
        return new MenuItemImpl(this, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    boolean dispatchMenuItemSelected(MenuBuilder arg1, MenuItem arg2) {
        Callback v0 = this.mCallback;
        if(v0 != null && (v0.onMenuItemSelected(arg1, arg2))) {
            return 1;
        }

        return 0;
    }

    private void dispatchPresenterUpdate(boolean arg4) {
        if(this.mPresenters.isEmpty()) {
            return;
        }

        this.stopDispatchingItemsChanged();
        Iterator v0 = this.mPresenters.iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = ((WeakReference)v1).get();
            if(v2 == null) {
                this.mPresenters.remove(v1);
                continue;
            }

            ((MenuPresenter)v2).updateMenuView(arg4);
        }

        this.startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle arg4) {
        SparseArray v4 = arg4.getSparseParcelableArray("android:menu:presenters");
        if(v4 != null) {
            if(this.mPresenters.isEmpty()) {
            }
            else {
                Iterator v0 = this.mPresenters.iterator();
                while(v0.hasNext()) {
                    Object v1 = v0.next();
                    Object v2 = ((WeakReference)v1).get();
                    if(v2 == null) {
                        this.mPresenters.remove(v1);
                    }
                    else {
                        int v1_1 = ((MenuPresenter)v2).getId();
                        if(v1_1 <= 0) {
                            continue;
                        }

                        v1 = v4.get(v1_1);
                        if(v1 == null) {
                            continue;
                        }

                        ((MenuPresenter)v2).onRestoreInstanceState(((Parcelable)v1));
                    }
                }
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle arg5) {
        if(this.mPresenters.isEmpty()) {
            return;
        }

        SparseArray v0 = new SparseArray();
        Iterator v1 = this.mPresenters.iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            Object v3 = ((WeakReference)v2).get();
            if(v3 == null) {
                this.mPresenters.remove(v2);
                continue;
            }

            int v2_1 = ((MenuPresenter)v3).getId();
            if(v2_1 <= 0) {
                continue;
            }

            Parcelable v3_1 = ((MenuPresenter)v3).onSaveInstanceState();
            if(v3_1 == null) {
                continue;
            }

            v0.put(v2_1, v3_1);
        }

        arg5.putSparseParcelableArray("android:menu:presenters", v0);
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder arg4, MenuPresenter arg5) {
        boolean v1 = false;
        if(this.mPresenters.isEmpty()) {
            return 0;
        }

        if(arg5 != null) {
            v1 = arg5.onSubMenuSelected(arg4);
        }

        Iterator v5 = this.mPresenters.iterator();
        while(v5.hasNext()) {
            Object v0 = v5.next();
            Object v2 = ((WeakReference)v0).get();
            if(v2 == null) {
                this.mPresenters.remove(v0);
                continue;
            }

            if(v1) {
                continue;
            }

            v1 = ((MenuPresenter)v2).onSubMenuSelected(arg4);
        }

        return v1;
    }

    public boolean expandItemActionView(MenuItemImpl arg5) {
        boolean v1 = false;
        if(this.mPresenters.isEmpty()) {
            return 0;
        }

        this.stopDispatchingItemsChanged();
        Iterator v0 = this.mPresenters.iterator();
        do {
            if(!v0.hasNext()) {
                break;
            }

            Object v2 = v0.next();
            Object v3 = ((WeakReference)v2).get();
            if(v3 == null) {
                this.mPresenters.remove(v2);
                continue;
            }
            else {
                v1 = ((MenuPresenter)v3).expandItemActionView(this, arg5);
                if(!v1) {
                    continue;
                }
            }

            break;
        }
        while(true);

        this.startDispatchingItemsChanged();
        if(v1) {
            this.mExpandedItem = arg5;
        }

        return v1;
    }

    public int findGroupIndex(int arg2) {
        return this.findGroupIndex(arg2, 0);
    }

    public int findGroupIndex(int arg3, int arg4) {
        int v0 = this.size();
        if(arg4 < 0) {
            arg4 = 0;
        }

        while(arg4 < v0) {
            if(this.mItems.get(arg4).getGroupId() == arg3) {
                return arg4;
            }

            ++arg4;
        }

        return -1;
    }

    private static int findInsertIndex(ArrayList arg2, int arg3) {
        int v0;
        for(v0 = arg2.size() - 1; v0 >= 0; --v0) {
            if(arg2.get(v0).getOrdering() <= arg3) {
                return v0 + 1;
            }
        }

        return 0;
    }

    public MenuItem findItem(int arg5) {
        int v0 = this.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = this.mItems.get(v1);
            if(((MenuItemImpl)v2).getItemId() == arg5) {
                return ((MenuItem)v2);
            }

            if(((MenuItemImpl)v2).hasSubMenu()) {
                MenuItem v2_1 = ((MenuItemImpl)v2).getSubMenu().findItem(arg5);
                if(v2_1 != null) {
                    return v2_1;
                }
            }
        }

        return null;
    }

    public int findItemIndex(int arg4) {
        int v0 = this.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(this.mItems.get(v1).getItemId() == arg4) {
                return v1;
            }
        }

        return -1;
    }

    MenuItemImpl findItemWithShortcutForKey(int arg11, KeyEvent arg12) {
        ArrayList v0 = this.mTempShortcutItemList;
        v0.clear();
        this.findItemsWithShortcutForKey(((List)v0), arg11, arg12);
        MenuItemImpl v2 = null;
        if(v0.isEmpty()) {
            return v2;
        }

        int v1 = arg12.getMetaState();
        KeyCharacterMap$KeyData v3 = new KeyCharacterMap$KeyData();
        arg12.getKeyData(v3);
        int v12 = v0.size();
        if(v12 == 1) {
            return v0.get(0);
        }

        boolean v10 = this.isQwertyMode();
        int v4;
        for(v4 = 0; v4 < v12; ++v4) {
            Object v6 = v0.get(v4);
            int v7 = v10 ? ((MenuItemImpl)v6).getAlphabeticShortcut() : ((MenuItemImpl)v6).getNumericShortcut();
            if(v7 != v3.meta[0] || (v1 & 2) != 0) {
                if(v7 == v3.meta[2] && (v1 & 2) != 0) {
                    goto label_41;
                }

                if((v10) && v7 == 8 && arg11 == 67) {
                    goto label_41;
                }
            }
            else {
            label_41:
                return ((MenuItemImpl)v6);
            }
        }

        return v2;
    }

    void findItemsWithShortcutForKey(List arg13, int arg14, KeyEvent arg15) {
        boolean v0 = this.isQwertyMode();
        int v1 = arg15.getModifiers();
        KeyCharacterMap$KeyData v2 = new KeyCharacterMap$KeyData();
        int v4 = 67;
        if((arg15.getKeyData(v2)) || arg14 == v4) {
            int v3 = this.mItems.size();
            int v6;
            for(v6 = 0; v6 < v3; ++v6) {
                Object v7 = this.mItems.get(v6);
                if(((MenuItemImpl)v7).hasSubMenu()) {
                    ((MenuItemImpl)v7).getSubMenu().findItemsWithShortcutForKey(arg13, arg14, arg15);
                }

                int v8 = v0 ? ((MenuItemImpl)v7).getAlphabeticShortcut() : ((MenuItemImpl)v7).getNumericShortcut();
                int v9 = v0 ? ((MenuItemImpl)v7).getAlphabeticModifiers() : ((MenuItemImpl)v7).getNumericModifiers();
                if((v1 & 0x1100F) == (v9 & 0x1100F) && v8 != 0) {
                    if(v8 != v2.meta[0] && v8 != v2.meta[2]) {
                        if(!v0) {
                        }
                        else if(v8 != 8) {
                        }
                        else if(arg14 == v4) {
                            goto label_44;
                        }

                        goto label_47;
                    }

                label_44:
                    if(!((MenuItemImpl)v7).isEnabled()) {
                        goto label_47;
                    }

                    arg13.add(v7);
                }

            label_47:
            }
        }
        else {
        }
    }

    public void flagActionItems() {
        Object v4;
        ArrayList v0 = this.getVisibleItems();
        if(!this.mIsActionItemsStale) {
            return;
        }

        Iterator v1 = this.mPresenters.iterator();
        int v3;
        for(v3 = 0; v1.hasNext(); v3 |= ((MenuPresenter)v5).flagActionItems()) {
            v4 = v1.next();
            Object v5 = ((WeakReference)v4).get();
            if(v5 == null) {
                this.mPresenters.remove(v4);
                continue;
            }
        }

        ArrayList v1_1 = this.mActionItems;
        if(v3 != 0) {
            v1_1.clear();
            this.mNonActionItems.clear();
            int v1_2 = v0.size();
            v3 = 0;
            goto label_26;
        }
        else {
            v1_1.clear();
            this.mNonActionItems.clear();
            this.mNonActionItems.addAll(this.getVisibleItems());
            goto label_43;
        label_26:
            while(v3 < v1_2) {
                v4 = v0.get(v3);
                if(((MenuItemImpl)v4).isActionButton()) {
                    this.mActionItems.add(v4);
                }
                else {
                    this.mNonActionItems.add(v4);
                }

                ++v3;
            }
        }

    label_43:
        this.mIsActionItemsStale = false;
    }

    public ArrayList getActionItems() {
        this.flagActionItems();
        return this.mActionItems;
    }

    protected String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public Context getContext() {
        return this.mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public MenuItem getItem(int arg1) {
        return this.mItems.get(arg1);
    }

    public ArrayList getNonActionItems() {
        this.flagActionItems();
        return this.mNonActionItems;
    }

    boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    private static int getOrdering(int arg3) {
        int v0 = (0xFFFF0000 & arg3) >> 16;
        if(v0 >= 0) {
            int[] v1 = MenuBuilder.sCategoryToOrder;
            if(v0 < v1.length) {
                return arg3 & 0xFFFF | v1[v0] << 16;
            }
        }

        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    Resources getResources() {
        return this.mResources;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public ArrayList getVisibleItems() {
        boolean v0 = this.mIsVisibleItemsStale;
        ArrayList v1 = this.mVisibleItems;
        if(!v0) {
            return v1;
        }

        v1.clear();
        int v0_1 = this.mItems.size();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            Object v3 = this.mItems.get(v2);
            if(((MenuItemImpl)v3).isVisible()) {
                this.mVisibleItems.add(v3);
            }
        }

        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    public boolean hasVisibleItems() {
        if(this.mOverrideVisibleItems) {
            return 1;
        }

        int v0 = this.size();
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            if(this.mItems.get(v3).isVisible()) {
                return 1;
            }
        }

        return 0;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public boolean isShortcutKey(int arg1, KeyEvent arg2) {
        if(this.findItemWithShortcutForKey(arg1, arg2) != null) {
            return 1;
        }

        return 0;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    void onItemActionRequestChanged(MenuItemImpl arg1) {
        this.mIsActionItemsStale = true;
        this.onItemsChanged(true);
    }

    void onItemVisibleChanged(MenuItemImpl arg1) {
        this.mIsVisibleItemsStale = true;
        this.onItemsChanged(true);
    }

    public void onItemsChanged(boolean arg3) {
        if(!this.mPreventDispatchingItemsChanged) {
            if(arg3) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }

            this.dispatchPresenterUpdate(arg3);
            return;
        }

        this.mItemsChangedWhileDispatchPrevented = true;
        if(arg3) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    public boolean performIdentifierAction(int arg1, int arg2) {
        return this.performItemAction(this.findItem(arg1), arg2);
    }

    public boolean performItemAction(MenuItem arg7, MenuPresenter arg8, int arg9) {
        int v7;
        if(arg7 != null) {
            if(!((MenuItemImpl)arg7).isEnabled()) {
            }
            else {
                boolean v1 = ((MenuItemImpl)arg7).invoke();
                ActionProvider v2 = ((MenuItemImpl)arg7).getSupportActionProvider();
                int v4 = v2 == null || !v2.hasSubMenu() ? 0 : 1;
                if(((MenuItemImpl)arg7).hasCollapsibleActionView()) {
                    v7 = ((MenuItemImpl)arg7).expandActionView() | (((int)v1));
                    if(v7 != 0) {
                        this.close(true);
                    }

                    return ((boolean)v7);
                }

                if(!((MenuItemImpl)arg7).hasSubMenu()) {
                    if(v4 != 0) {
                    }
                    else {
                        if((arg9 & 1) == 0) {
                            this.close(true);
                        }

                        return v1;
                    }
                }

                if((arg9 & 4) == 0) {
                    this.close(false);
                }

                if(!((MenuItemImpl)arg7).hasSubMenu()) {
                    ((MenuItemImpl)arg7).setSubMenu(new SubMenuBuilder(this.getContext(), this, ((MenuItemImpl)arg7)));
                }

                SubMenu v7_1 = ((MenuItemImpl)arg7).getSubMenu();
                if(v4 != 0) {
                    v2.onPrepareSubMenu(v7_1);
                }

                v7 = this.dispatchSubMenuSelected(((SubMenuBuilder)v7_1), arg8) | (((int)v1));
                if(v7 == 0) {
                    this.close(true);
                }

                return ((boolean)v7);
            }
        }

        return 0;
    }

    public boolean performItemAction(MenuItem arg2, int arg3) {
        return this.performItemAction(arg2, null, arg3);
    }

    public boolean performShortcut(int arg1, KeyEvent arg2, int arg3) {
        MenuItemImpl v1 = this.findItemWithShortcutForKey(arg1, arg2);
        boolean v1_1 = v1 != null ? this.performItemAction(((MenuItem)v1), arg3) : false;
        if((arg3 & 2) != 0) {
            this.close(true);
        }

        return v1_1;
    }

    public void removeGroup(int arg6) {
        int v0 = this.findGroupIndex(arg6);
        if(v0 >= 0) {
            int v1 = this.mItems.size() - v0;
            int v3 = 0;
            while(true) {
                int v4 = v3 + 1;
                if(v3 < v1 && this.mItems.get(v0).getGroupId() == arg6) {
                    this.removeItemAtInt(v0, false);
                    v3 = v4;
                    continue;
                }

                break;
            }

            this.onItemsChanged(true);
        }
    }

    public void removeItem(int arg2) {
        this.removeItemAtInt(this.findItemIndex(arg2), true);
    }

    public void removeItemAt(int arg2) {
        this.removeItemAtInt(arg2, true);
    }

    private void removeItemAtInt(int arg2, boolean arg3) {
        if(arg2 >= 0) {
            if(arg2 >= this.mItems.size()) {
            }
            else {
                this.mItems.remove(arg2);
                if(arg3) {
                    this.onItemsChanged(true);
                }
            }
        }
    }

    public void removeMenuPresenter(MenuPresenter arg4) {
        Iterator v0 = this.mPresenters.iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = ((WeakReference)v1).get();
            if(v2 != null && (((MenuPresenter)v2)) != arg4) {
                continue;
            }

            this.mPresenters.remove(v1);
        }
    }

    public void restoreActionViewStates(Bundle arg8) {
        if(arg8 == null) {
        }
        else {
            SparseArray v0 = arg8.getSparseParcelableArray(this.getActionViewStatesKey());
            int v1 = this.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                MenuItem v3 = this.getItem(v2);
                View v4 = v3.getActionView();
                if(v4 != null && v4.getId() != -1) {
                    v4.restoreHierarchyState(v0);
                }

                if(v3.hasSubMenu()) {
                    v3.getSubMenu().restoreActionViewStates(arg8);
                }
            }

            int v8 = arg8.getInt("android:menu:expandedactionview");
            if(v8 <= 0) {
                return;
            }

            MenuItem v7 = this.findItem(v8);
            if(v7 == null) {
                return;
            }

            v7.expandActionView();
        }
    }

    public void restorePresenterStates(Bundle arg1) {
        this.dispatchRestoreInstanceState(arg1);
    }

    public void saveActionViewStates(Bundle arg8) {
        int v0 = this.size();
        SparseArray v1 = null;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            MenuItem v3 = this.getItem(v2);
            View v4 = v3.getActionView();
            if(v4 != null && v4.getId() != -1) {
                if(v1 == null) {
                    v1 = new SparseArray();
                }

                v4.saveHierarchyState(v1);
                if(!v3.isActionViewExpanded()) {
                    goto label_19;
                }

                arg8.putInt("android:menu:expandedactionview", v3.getItemId());
            }

        label_19:
            if(v3.hasSubMenu()) {
                v3.getSubMenu().saveActionViewStates(arg8);
            }
        }

        if(v1 != null) {
            arg8.putSparseParcelableArray(this.getActionViewStatesKey(), v1);
        }
    }

    public void savePresenterStates(Bundle arg1) {
        this.dispatchSaveInstanceState(arg1);
    }

    public void setCallback(Callback arg1) {
        this.mCallback = arg1;
    }

    public void setCurrentMenuInfo(ContextMenu$ContextMenuInfo arg1) {
        this.mCurrentMenuInfo = arg1;
    }

    public MenuBuilder setDefaultShowAsAction(int arg1) {
        this.mDefaultShowAsAction = arg1;
        return this;
    }

    void setExclusiveItemChecked(MenuItem arg7) {
        int v0 = arg7.getGroupId();
        int v1 = this.mItems.size();
        this.stopDispatchingItemsChanged();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            Object v4 = this.mItems.get(v3);
            if(((MenuItemImpl)v4).getGroupId() == v0) {
                if(!((MenuItemImpl)v4).isExclusiveCheckable()) {
                }
                else if(!((MenuItemImpl)v4).isCheckable()) {
                }
                else {
                    boolean v5 = (((MenuItem)v4)) == arg7 ? true : false;
                    ((MenuItemImpl)v4).setCheckedInt(v5);
                }
            }
        }

        this.startDispatchingItemsChanged();
    }

    public void setGroupCheckable(int arg5, boolean arg6, boolean arg7) {
        int v0 = this.mItems.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = this.mItems.get(v1);
            if(((MenuItemImpl)v2).getGroupId() == arg5) {
                ((MenuItemImpl)v2).setExclusiveCheckable(arg7);
                ((MenuItemImpl)v2).setCheckable(arg6);
            }
        }
    }

    public void setGroupDividerEnabled(boolean arg1) {
        this.mGroupDividerEnabled = arg1;
    }

    public void setGroupEnabled(int arg5, boolean arg6) {
        int v0 = this.mItems.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = this.mItems.get(v1);
            if(((MenuItemImpl)v2).getGroupId() == arg5) {
                ((MenuItemImpl)v2).setEnabled(arg6);
            }
        }
    }

    public void setGroupVisible(int arg7, boolean arg8) {
        int v0 = this.mItems.size();
        int v1 = 0;
        int v2 = 0;
        while(v1 < v0) {
            Object v4 = this.mItems.get(v1);
            if(((MenuItemImpl)v4).getGroupId() == arg7 && (((MenuItemImpl)v4).setVisibleInt(arg8))) {
                v2 = 1;
            }

            ++v1;
        }

        if(v2 != 0) {
            this.onItemsChanged(true);
        }
    }

    protected MenuBuilder setHeaderIconInt(int arg7) {
        this.setHeaderInternal(0, null, arg7, null, null);
        return this;
    }

    protected MenuBuilder setHeaderIconInt(Drawable arg7) {
        this.setHeaderInternal(0, null, 0, arg7, null);
        return this;
    }

    private void setHeaderInternal(int arg3, CharSequence arg4, int arg5, Drawable arg6, View arg7) {
        Resources v0 = this.getResources();
        CharSequence v1 = null;
        if(arg7 != null) {
            this.mHeaderView = arg7;
            this.mHeaderTitle = v1;
            this.mHeaderIcon = ((Drawable)v1);
        }
        else {
            if(arg3 > 0) {
                this.mHeaderTitle = v0.getText(arg3);
            }
            else if(arg4 != null) {
                this.mHeaderTitle = arg4;
            }

            if(arg5 > 0) {
                this.mHeaderIcon = ContextCompat.getDrawable(this.getContext(), arg5);
            }
            else if(arg6 != null) {
                this.mHeaderIcon = arg6;
            }

            this.mHeaderView = ((View)v1);
        }

        this.onItemsChanged(false);
    }

    protected MenuBuilder setHeaderTitleInt(int arg7) {
        this.setHeaderInternal(arg7, null, 0, null, null);
        return this;
    }

    protected MenuBuilder setHeaderTitleInt(CharSequence arg7) {
        this.setHeaderInternal(0, arg7, 0, null, null);
        return this;
    }

    protected MenuBuilder setHeaderViewInt(View arg7) {
        this.setHeaderInternal(0, null, 0, null, arg7);
        return this;
    }

    public void setOptionalIconsVisible(boolean arg1) {
        this.mOptionalIconsVisible = arg1;
    }

    public void setOverrideVisibleItems(boolean arg1) {
        this.mOverrideVisibleItems = arg1;
    }

    public void setQwertyMode(boolean arg1) {
        this.mQwertyMode = arg1;
        this.onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean arg2) {
        if(this.mShortcutsVisible == arg2) {
            return;
        }

        this.setShortcutsVisibleInner(arg2);
        this.onItemsChanged(false);
    }

    private void setShortcutsVisibleInner(boolean arg3) {
        boolean v0;
        if(arg3) {
            v0 = true;
            if(this.mResources.getConfiguration().keyboard == 1) {
                goto label_12;
            }
            else if(ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration.get(this.mContext), this.mContext)) {
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v0 = false;
        }

        this.mShortcutsVisible = v0;
    }

    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if(this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            this.onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public void stopDispatchingItemsChanged() {
        if(!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }
}

