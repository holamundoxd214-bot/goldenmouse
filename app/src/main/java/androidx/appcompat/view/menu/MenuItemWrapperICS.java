package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider$VisibilityListener;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.MenuItem$OnActionExpandListener;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider$VisibilityListener;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    class ActionProviderWrapper extends ActionProvider {
        final android.view.ActionProvider mInner;

        ActionProviderWrapper(MenuItemWrapperICS arg1, Context arg2, android.view.ActionProvider arg3) {
            MenuItemWrapperICS.this = arg1;
            super(arg2);
            this.mInner = arg3;
        }

        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        public View onCreateActionView() {
            return this.mInner.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu arg2) {
            this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(arg2));
        }
    }

    class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider$VisibilityListener {
        private VisibilityListener mListener;

        ActionProviderWrapperJB(MenuItemWrapperICS arg1, Context arg2, android.view.ActionProvider arg3) {
            MenuItemWrapperICS.this = arg1;
            super(arg1, arg2, arg3);
        }

        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean arg1) {
            VisibilityListener v0 = this.mListener;
            if(v0 != null) {
                v0.onActionProviderVisibilityChanged(arg1);
            }
        }

        public View onCreateActionView(MenuItem arg1) {
            return this.mInner.onCreateActionView(arg1);
        }

        public boolean overridesItemVisibility() {
            return this.mInner.overridesItemVisibility();
        }

        public void refreshVisibility() {
            this.mInner.refreshVisibility();
        }

        public void setVisibilityListener(VisibilityListener arg2) {
            ActionProvider$VisibilityListener v1;
            this.mListener = arg2;
            android.view.ActionProvider v0 = this.mInner;
            if(arg2 != null) {
            }
            else {
                v1 = null;
            }

            v0.setVisibilityListener(v1);
        }
    }

    class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        final android.view.CollapsibleActionView mWrappedView;

        CollapsibleActionViewWrapper(View arg2) {
            super(arg2.getContext());
            this.mWrappedView = arg2;
            this.addView(arg2);
        }

        View getWrappedView() {
            return this.mWrappedView;
        }

        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }
    }

    class OnActionExpandListenerWrapper implements MenuItem$OnActionExpandListener {
        private final MenuItem$OnActionExpandListener mObject;

        OnActionExpandListenerWrapper(MenuItemWrapperICS arg1, MenuItem$OnActionExpandListener arg2) {
            MenuItemWrapperICS.this = arg1;
            super();
            this.mObject = arg2;
        }

        public boolean onMenuItemActionCollapse(MenuItem arg2) {
            return this.mObject.onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(arg2));
        }

        public boolean onMenuItemActionExpand(MenuItem arg2) {
            return this.mObject.onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(arg2));
        }
    }

    class OnMenuItemClickListenerWrapper implements MenuItem$OnMenuItemClickListener {
        private final MenuItem$OnMenuItemClickListener mObject;

        OnMenuItemClickListenerWrapper(MenuItemWrapperICS arg1, MenuItem$OnMenuItemClickListener arg2) {
            MenuItemWrapperICS.this = arg1;
            super();
            this.mObject = arg2;
        }

        public boolean onMenuItemClick(MenuItem arg2) {
            return this.mObject.onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(arg2));
        }
    }

    static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;
    private final SupportMenuItem mWrappedObject;

    public MenuItemWrapperICS(Context arg1, SupportMenuItem arg2) {
        super(arg1);
        if(arg2 != null) {
            this.mWrappedObject = arg2;
            return;
        }

        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.mWrappedObject.collapseActionView();
    }

    public boolean expandActionView() {
        return this.mWrappedObject.expandActionView();
    }

    public android.view.ActionProvider getActionProvider() {
        ActionProvider v1 = this.mWrappedObject.getSupportActionProvider();
        if((v1 instanceof ActionProviderWrapper)) {
            return ((ActionProviderWrapper)v1).mInner;
        }

        return null;
    }

    public View getActionView() {
        View v1 = this.mWrappedObject.getActionView();
        if((v1 instanceof CollapsibleActionViewWrapper)) {
            v1 = ((CollapsibleActionViewWrapper)v1).getWrappedView();
        }

        return v1;
    }

    public int getAlphabeticModifiers() {
        return this.mWrappedObject.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.mWrappedObject.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.mWrappedObject.getContentDescription();
    }

    public int getGroupId() {
        return this.mWrappedObject.getGroupId();
    }

    public Drawable getIcon() {
        return this.mWrappedObject.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.mWrappedObject.getIconTintList();
    }

    public PorterDuff$Mode getIconTintMode() {
        return this.mWrappedObject.getIconTintMode();
    }

    public Intent getIntent() {
        return this.mWrappedObject.getIntent();
    }

    public int getItemId() {
        return this.mWrappedObject.getItemId();
    }

    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return this.mWrappedObject.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.mWrappedObject.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.mWrappedObject.getNumericShortcut();
    }

    public int getOrder() {
        return this.mWrappedObject.getOrder();
    }

    public SubMenu getSubMenu() {
        return this.getSubMenuWrapper(this.mWrappedObject.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.mWrappedObject.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.mWrappedObject.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.mWrappedObject.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.mWrappedObject.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.mWrappedObject.isCheckable();
    }

    public boolean isChecked() {
        return this.mWrappedObject.isChecked();
    }

    public boolean isEnabled() {
        return this.mWrappedObject.isEnabled();
    }

    public boolean isVisible() {
        return this.mWrappedObject.isVisible();
    }

    public MenuItem setActionProvider(android.view.ActionProvider arg3) {
        ActionProvider v0_1;
        ActionProviderWrapperJB v0 = new ActionProviderWrapperJB(this, this.mContext, arg3);
        SupportMenuItem v1 = this.mWrappedObject;
        if(arg3 != null) {
        }
        else {
            v0_1 = null;
        }

        v1.setSupportActionProvider(v0_1);
        return this;
    }

    public MenuItem setActionView(int arg3) {
        this.mWrappedObject.setActionView(arg3);
        View v3 = this.mWrappedObject.getActionView();
        if((v3 instanceof android.view.CollapsibleActionView)) {
            this.mWrappedObject.setActionView(new CollapsibleActionViewWrapper(v3));
        }

        return this;
    }

    public MenuItem setActionView(View arg2) {
        CollapsibleActionViewWrapper v2;
        if((arg2 instanceof android.view.CollapsibleActionView)) {
            v2 = new CollapsibleActionViewWrapper(arg2);
        }

        this.mWrappedObject.setActionView(((View)v2));
        return this;
    }

    public MenuItem setAlphabeticShortcut(char arg2) {
        this.mWrappedObject.setAlphabeticShortcut(arg2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char arg2, int arg3) {
        this.mWrappedObject.setAlphabeticShortcut(arg2, arg3);
        return this;
    }

    public MenuItem setCheckable(boolean arg2) {
        this.mWrappedObject.setCheckable(arg2);
        return this;
    }

    public MenuItem setChecked(boolean arg2) {
        this.mWrappedObject.setChecked(arg2);
        return this;
    }

    public MenuItem setContentDescription(CharSequence arg2) {
        this.mWrappedObject.setContentDescription(arg2);
        return this;
    }

    public MenuItem setEnabled(boolean arg2) {
        this.mWrappedObject.setEnabled(arg2);
        return this;
    }

    public void setExclusiveCheckable(boolean arg6) {
        try {
            Method v0 = this.mSetExclusiveCheckableMethod;
            if(v0 == null) {
                v0 = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                this.mSetExclusiveCheckableMethod = v0;
            }

            v0.invoke(this.mWrappedObject, Boolean.valueOf(arg6));
            return;
        }
        catch(Exception v5) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", ((Throwable)v5));
            return;
        }
    }

    public MenuItem setIcon(int arg2) {
        this.mWrappedObject.setIcon(arg2);
        return this;
    }

    public MenuItem setIcon(Drawable arg2) {
        this.mWrappedObject.setIcon(arg2);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList arg2) {
        this.mWrappedObject.setIconTintList(arg2);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff$Mode arg2) {
        this.mWrappedObject.setIconTintMode(arg2);
        return this;
    }

    public MenuItem setIntent(Intent arg2) {
        this.mWrappedObject.setIntent(arg2);
        return this;
    }

    public MenuItem setNumericShortcut(char arg2) {
        this.mWrappedObject.setNumericShortcut(arg2);
        return this;
    }

    public MenuItem setNumericShortcut(char arg2, int arg3) {
        this.mWrappedObject.setNumericShortcut(arg2, arg3);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem$OnActionExpandListener arg3) {
        MenuItem$OnActionExpandListener v1_1;
        SupportMenuItem v0 = this.mWrappedObject;
        if(arg3 != null) {
            OnActionExpandListenerWrapper v1 = new OnActionExpandListenerWrapper(this, arg3);
        }
        else {
            v1_1 = null;
        }

        v0.setOnActionExpandListener(v1_1);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem$OnMenuItemClickListener arg3) {
        MenuItem$OnMenuItemClickListener v1_1;
        SupportMenuItem v0 = this.mWrappedObject;
        if(arg3 != null) {
            OnMenuItemClickListenerWrapper v1 = new OnMenuItemClickListenerWrapper(this, arg3);
        }
        else {
            v1_1 = null;
        }

        v0.setOnMenuItemClickListener(v1_1);
        return this;
    }

    public MenuItem setShortcut(char arg2, char arg3) {
        this.mWrappedObject.setShortcut(arg2, arg3);
        return this;
    }

    public MenuItem setShortcut(char arg2, char arg3, int arg4, int arg5) {
        this.mWrappedObject.setShortcut(arg2, arg3, arg4, arg5);
        return this;
    }

    public void setShowAsAction(int arg1) {
        this.mWrappedObject.setShowAsAction(arg1);
    }

    public MenuItem setShowAsActionFlags(int arg2) {
        this.mWrappedObject.setShowAsActionFlags(arg2);
        return this;
    }

    public MenuItem setTitle(int arg2) {
        this.mWrappedObject.setTitle(arg2);
        return this;
    }

    public MenuItem setTitle(CharSequence arg2) {
        this.mWrappedObject.setTitle(arg2);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence arg2) {
        this.mWrappedObject.setTitleCondensed(arg2);
        return this;
    }

    public MenuItem setTooltipText(CharSequence arg2) {
        this.mWrappedObject.setTooltipText(arg2);
        return this;
    }

    public MenuItem setVisible(boolean arg1) {
        return this.mWrappedObject.setVisible(arg1);
    }
}

