package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem$OnActionExpandListener;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug$CapturedViewProperty;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider$VisibilityListener;
import androidx.core.view.ActionProvider;

public final class MenuItemImpl implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 0x20;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem$OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags;
    private final int mGroup;
    private boolean mHasIconTint;
    private boolean mHasIconTintMode;
    private Drawable mIconDrawable;
    private int mIconResId;
    private ColorStateList mIconTintList;
    private PorterDuff$Mode mIconTintMode;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenu$ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint;
    private MenuItem$OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    MenuItemImpl(MenuBuilder arg3, int arg4, int arg5, int arg6, int arg7, CharSequence arg8, int arg9) {
        super();
        this.mShortcutNumericModifiers = 0x1000;
        this.mShortcutAlphabeticModifiers = 0x1000;
        this.mIconResId = 0;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mNeedToApplyIconTint = false;
        this.mFlags = 16;
        this.mIsActionViewExpanded = false;
        this.mMenu = arg3;
        this.mId = arg5;
        this.mGroup = arg4;
        this.mCategoryOrder = arg6;
        this.mOrdering = arg7;
        this.mTitle = arg8;
        this.mShowAsAction = arg9;
    }

    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    private static void appendModifier(StringBuilder arg0, int arg1, int arg2, String arg3) {
        if((arg1 & arg2) == arg2) {
            arg0.append(arg3);
        }
    }

    private Drawable applyIconTintIfNecessary(Drawable arg2) {
        if(arg2 != null && (this.mNeedToApplyIconTint) && ((this.mHasIconTint) || (this.mHasIconTintMode))) {
            arg2 = DrawableCompat.wrap(arg2).mutate();
            if(this.mHasIconTint) {
                DrawableCompat.setTintList(arg2, this.mIconTintList);
            }

            if(this.mHasIconTintMode) {
                DrawableCompat.setTintMode(arg2, this.mIconTintMode);
            }

            this.mNeedToApplyIconTint = false;
        }

        return arg2;
    }

    public boolean collapseActionView() {
        if((this.mShowAsAction & 8) == 0) {
            return 0;
        }

        if(this.mActionView == null) {
            return 1;
        }

        MenuItem$OnActionExpandListener v0 = this.mOnActionExpandListener;
        if(v0 != null) {
            if(v0.onMenuItemActionCollapse(((MenuItem)this))) {
            }
            else {
                return 0;
            }
        }

        return this.mMenu.collapseItemActionView(this);
    }

    public boolean expandActionView() {
        if(!this.hasCollapsibleActionView()) {
            return 0;
        }

        MenuItem$OnActionExpandListener v0 = this.mOnActionExpandListener;
        if(v0 != null) {
            if(v0.onMenuItemActionExpand(((MenuItem)this))) {
            }
            else {
                return 0;
            }
        }

        return this.mMenu.expandItemActionView(this);
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View v0 = this.mActionView;
        if(v0 != null) {
            return v0;
        }

        ActionProvider v0_1 = this.mActionProvider;
        if(v0_1 != null) {
            v0 = v0_1.onCreateActionView(((MenuItem)this));
            this.mActionView = v0;
            return v0;
        }

        return null;
    }

    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    Runnable getCallback() {
        return this.mItemCallback;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public Drawable getIcon() {
        Drawable v0 = this.mIconDrawable;
        if(v0 != null) {
            return this.applyIconTintIfNecessary(v0);
        }

        if(this.mIconResId != 0) {
            v0 = AppCompatResources.getDrawable(this.mMenu.getContext(), this.mIconResId);
            this.mIconResId = 0;
            this.mIconDrawable = v0;
            return this.applyIconTintIfNecessary(v0);
        }

        return null;
    }

    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    public PorterDuff$Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    @ViewDebug$CapturedViewProperty public int getItemId() {
        return this.mId;
    }

    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    char getShortcut() {
        if(this.mMenu.isQwertyMode()) {
            return this.mShortcutAlphabeticChar;
        }

        return this.mShortcutNumericChar;
    }

    String getShortcutLabel() {
        char v0 = this.getShortcut();
        if(v0 == 0) {
            return "";
        }

        Resources v1 = this.mMenu.getContext().getResources();
        StringBuilder v2 = new StringBuilder();
        if(ViewConfiguration.get(this.mMenu.getContext()).hasPermanentMenuKey()) {
            v2.append(v1.getString(string.abc_prepend_shortcut_label));
        }

        int v5 = this.mMenu.isQwertyMode() ? this.mShortcutAlphabeticModifiers : this.mShortcutNumericModifiers;
        MenuItemImpl.appendModifier(v2, v5, 0x10000, v1.getString(string.abc_menu_meta_shortcut_label));
        MenuItemImpl.appendModifier(v2, v5, 0x1000, v1.getString(string.abc_menu_ctrl_shortcut_label));
        MenuItemImpl.appendModifier(v2, v5, 2, v1.getString(string.abc_menu_alt_shortcut_label));
        MenuItemImpl.appendModifier(v2, v5, 1, v1.getString(string.abc_menu_shift_shortcut_label));
        MenuItemImpl.appendModifier(v2, v5, 4, v1.getString(string.abc_menu_sym_shortcut_label));
        MenuItemImpl.appendModifier(v2, v5, 8, v1.getString(string.abc_menu_function_shortcut_label));
        if(v0 == 8) {
            v2.append(v1.getString(string.abc_menu_delete_shortcut_label));
        }
        else if(v0 == 10) {
            v2.append(v1.getString(string.abc_menu_enter_shortcut_label));
        }
        else if(v0 != 0x20) {
            v2.append(v0);
        }
        else {
            v2.append(v1.getString(string.abc_menu_space_shortcut_label));
        }

        return v2.toString();
    }

    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    public ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @ViewDebug$CapturedViewProperty public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTitleCondensed() {
        CharSequence v0 = this.mTitleCondensed;
        if(v0 != null) {
        }
        else {
            v0 = this.mTitle;
        }

        return v0;
    }

    CharSequence getTitleForItemView(ItemView arg1) {
        if(arg1 != null && (arg1.prefersCondensedTitle())) {
            return this.getTitleCondensed();
        }

        return this.getTitle();
    }

    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasCollapsibleActionView() {
        if((this.mShowAsAction & 8) != 0) {
            View v0 = this.mActionView;
            if(v0 == null) {
                ActionProvider v2 = this.mActionProvider;
                if(v2 != null) {
                    v0 = v2.onCreateActionView(((MenuItem)this));
                    this.mActionView = v0;
                }
            }

            if(v0 == null) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public boolean hasSubMenu() {
        if(this.mSubMenu != null) {
            return 1;
        }

        return 0;
    }

    public boolean invoke() {
        MenuItem$OnMenuItemClickListener v0 = this.mClickListener;
        if(v0 != null && (v0.onMenuItemClick(((MenuItem)this)))) {
            return 1;
        }

        if(this.mMenu.dispatchMenuItemSelected(this.mMenu, ((MenuItem)this))) {
            return 1;
        }

        Runnable v0_1 = this.mItemCallback;
        if(v0_1 != null) {
            v0_1.run();
            return 1;
        }

        if(this.mIntent != null) {
            try {
                this.mMenu.getContext().startActivity(this.mIntent);
                return 1;
            }
            catch(ActivityNotFoundException v0_2) {
                Log.e("MenuItemImpl", "Can\'t find activity to handle intent; ignoring", ((Throwable)v0_2));
            }
        }

        ActionProvider v4 = this.mActionProvider;
        if(v4 != null && (v4.onPerformDefaultAction())) {
            return 1;
        }

        return 0;
    }

    public boolean isActionButton() {
        if((this.mFlags & 0x20) == 0x20) {
            return 1;
        }

        return 0;
    }

    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    public boolean isCheckable() {
        if((this.mFlags & 1) == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isChecked() {
        if((this.mFlags & 2) == 2) {
            return 1;
        }

        return 0;
    }

    public boolean isEnabled() {
        if((this.mFlags & 16) != 0) {
            return 1;
        }

        return 0;
    }

    public boolean isExclusiveCheckable() {
        if((this.mFlags & 4) != 0) {
            return 1;
        }

        return 0;
    }

    public boolean isVisible() {
        ActionProvider v0 = this.mActionProvider;
        if(v0 != null && (v0.overridesItemVisibility())) {
            if((this.mFlags & 8) == 0 && (this.mActionProvider.isVisible())) {
                return 1;
            }

            return 0;
        }

        if((this.mFlags & 8) == 0) {
            return 1;
        }

        return 0;
    }

    public boolean requestsActionButton() {
        if((this.mShowAsAction & 1) == 1) {
            return 1;
        }

        return 0;
    }

    public boolean requiresActionButton() {
        if((this.mShowAsAction & 2) == 2) {
            return 1;
        }

        return 0;
    }

    public boolean requiresOverflow() {
        if(!this.requiresActionButton() && !this.requestsActionButton()) {
            return 1;
        }

        return 0;
    }

    public MenuItem setActionProvider(android.view.ActionProvider arg1) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setActionView(int arg1) {
        return this.setActionView(arg1);
    }

    public SupportMenuItem setActionView(int arg4) {
        Context v0 = this.mMenu.getContext();
        this.setActionView(LayoutInflater.from(v0).inflate(arg4, new LinearLayout(v0), false));
        return this;
    }

    public MenuItem setActionView(View arg1) {
        return this.setActionView(arg1);
    }

    public SupportMenuItem setActionView(View arg3) {
        this.mActionView = arg3;
        this.mActionProvider = null;
        if(arg3 != null && arg3.getId() == -1) {
            int v0 = this.mId;
            if(v0 > 0) {
                arg3.setId(v0);
            }
        }

        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }

    public void setActionViewExpanded(boolean arg1) {
        this.mIsActionViewExpanded = arg1;
        this.mMenu.onItemsChanged(false);
    }

    public MenuItem setAlphabeticShortcut(char arg2) {
        if(this.mShortcutAlphabeticChar == arg2) {
            return this;
        }

        this.mShortcutAlphabeticChar = Character.toLowerCase(arg2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char arg2, int arg3) {
        if(this.mShortcutAlphabeticChar == arg2 && this.mShortcutAlphabeticModifiers == arg3) {
            return this;
        }

        this.mShortcutAlphabeticChar = Character.toLowerCase(arg2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(arg3);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable arg1) {
        this.mItemCallback = arg1;
        return this;
    }

    public MenuItem setCheckable(boolean arg3) {
        int v0 = this.mFlags;
        int v3 = (((int)arg3)) | v0 & -2;
        this.mFlags = v3;
        if(v0 != v3) {
            this.mMenu.onItemsChanged(false);
        }

        return this;
    }

    public MenuItem setChecked(boolean arg2) {
        if((this.mFlags & 4) != 0) {
            this.mMenu.setExclusiveItemChecked(((MenuItem)this));
            return this;
        }

        this.setCheckedInt(arg2);
        return this;
    }

    void setCheckedInt(boolean arg4) {
        int v0 = this.mFlags;
        int v1 = v0 & -3;
        int v4 = arg4 ? 2 : 0;
        v4 |= v1;
        this.mFlags = v4;
        if(v0 != v4) {
            this.mMenu.onItemsChanged(false);
        }
    }

    public MenuItem setContentDescription(CharSequence arg1) {
        return this.setContentDescription(arg1);
    }

    public SupportMenuItem setContentDescription(CharSequence arg2) {
        this.mContentDescription = arg2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setEnabled(boolean arg2) {
        int v0 = this.mFlags;
        this.mFlags = arg2 ? v0 | 16 : v0 & -17;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean arg2) {
        int v0 = this.mFlags & -5;
        int v2 = arg2 ? 4 : 0;
        this.mFlags = v2 | v0;
    }

    public MenuItem setIcon(int arg2) {
        this.mIconDrawable = null;
        this.mIconResId = arg2;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(Drawable arg2) {
        this.mIconResId = 0;
        this.mIconDrawable = arg2;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList arg2) {
        this.mIconTintList = arg2;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff$Mode arg2) {
        this.mIconTintMode = arg2;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent arg1) {
        this.mIntent = arg1;
        return this;
    }

    public void setIsActionButton(boolean arg2) {
        int v0 = this.mFlags;
        if(arg2) {
            this.mFlags = v0 | 0x20;
            return;
        }

        this.mFlags = v0 & -33;
    }

    void setMenuInfo(ContextMenu$ContextMenuInfo arg1) {
        this.mMenuInfo = arg1;
    }

    public MenuItem setNumericShortcut(char arg2) {
        if(this.mShortcutNumericChar == arg2) {
            return this;
        }

        this.mShortcutNumericChar = arg2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setNumericShortcut(char arg2, int arg3) {
        if(this.mShortcutNumericChar == arg2 && this.mShortcutNumericModifiers == arg3) {
            return this;
        }

        this.mShortcutNumericChar = arg2;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(arg3);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem$OnActionExpandListener arg1) {
        this.mOnActionExpandListener = arg1;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem$OnMenuItemClickListener arg1) {
        this.mClickListener = arg1;
        return this;
    }

    public MenuItem setShortcut(char arg1, char arg2) {
        this.mShortcutNumericChar = arg1;
        this.mShortcutAlphabeticChar = Character.toLowerCase(arg2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setShortcut(char arg1, char arg2, int arg3, int arg4) {
        this.mShortcutNumericChar = arg1;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(arg3);
        this.mShortcutAlphabeticChar = Character.toLowerCase(arg2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(arg4);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int arg3) {
        int v0 = arg3 & 3;
        if(v0 != 0 && v0 != 1) {
            if(v0 == 2) {
            }
            else {
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            }
        }

        this.mShowAsAction = arg3;
        this.mMenu.onItemActionRequestChanged(this);
    }

    public MenuItem setShowAsActionFlags(int arg1) {
        return this.setShowAsActionFlags(arg1);
    }

    public SupportMenuItem setShowAsActionFlags(int arg1) {
        this.setShowAsAction(arg1);
        return this;
    }

    public void setSubMenu(SubMenuBuilder arg1) {
        this.mSubMenu = arg1;
        arg1.setHeaderTitle(this.getTitle());
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider arg2) {
        ActionProvider v0 = this.mActionProvider;
        if(v0 != null) {
            v0.reset();
        }

        this.mActionView = null;
        this.mActionProvider = arg2;
        this.mMenu.onItemsChanged(true);
        arg2 = this.mActionProvider;
        if(arg2 != null) {
            arg2.setVisibilityListener(new VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean arg1) {
                    MenuItemImpl.this.mMenu.onItemVisibleChanged(MenuItemImpl.this);
                }
            });
        }

        return this;
    }

    public MenuItem setTitle(int arg2) {
        return this.setTitle(this.mMenu.getContext().getString(arg2));
    }

    public MenuItem setTitle(CharSequence arg3) {
        this.mTitle = arg3;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder v0 = this.mSubMenu;
        if(v0 != null) {
            v0.setHeaderTitle(arg3);
        }

        return this;
    }

    public MenuItem setTitleCondensed(CharSequence arg2) {
        this.mTitleCondensed = arg2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setTooltipText(CharSequence arg1) {
        return this.setTooltipText(arg1);
    }

    public SupportMenuItem setTooltipText(CharSequence arg2) {
        this.mTooltipText = arg2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean arg1) {
        if(this.setVisibleInt(arg1)) {
            this.mMenu.onItemVisibleChanged(this);
        }

        return this;
    }

    boolean setVisibleInt(boolean arg4) {
        int v0 = this.mFlags;
        int v1 = v0 & -9;
        int v4 = arg4 ? 0 : 8;
        v4 |= v1;
        this.mFlags = v4;
        if(v0 != v4) {
            return 1;
        }

        return 0;
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    boolean shouldShowShortcut() {
        if((this.mMenu.isShortcutsVisible()) && this.getShortcut() != 0) {
            return 1;
        }

        return 0;
    }

    public boolean showsTextAsAction() {
        if((this.mShowAsAction & 4) == 4) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        CharSequence v0 = this.mTitle;
        if(v0 != null) {
            return v0.toString();
        }

        return null;
    }
}

