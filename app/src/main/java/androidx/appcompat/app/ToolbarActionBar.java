package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.Window$Callback;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar$OnMenuItemClickListener;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {
    class androidx.appcompat.app.ToolbarActionBar$1 implements Runnable {
        androidx.appcompat.app.ToolbarActionBar$1(ToolbarActionBar arg1) {
            ToolbarActionBar.this = arg1;
            super();
        }

        public void run() {
            ToolbarActionBar.this.populateOptionsMenu();
        }
    }

    class androidx.appcompat.app.ToolbarActionBar$2 implements OnMenuItemClickListener {
        androidx.appcompat.app.ToolbarActionBar$2(ToolbarActionBar arg1) {
            ToolbarActionBar.this = arg1;
            super();
        }

        public boolean onMenuItemClick(MenuItem arg2) {
            return ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, arg2);
        }
    }

    final class ActionMenuPresenterCallback implements Callback {
        private boolean mClosingActionMenu;

        ActionMenuPresenterCallback(ToolbarActionBar arg1) {
            ToolbarActionBar.this = arg1;
            super();
        }

        public void onCloseMenu(MenuBuilder arg2, boolean arg3) {
            if(this.mClosingActionMenu) {
                return;
            }

            this.mClosingActionMenu = true;
            ToolbarActionBar.this.mDecorToolbar.dismissPopupMenus();
            ToolbarActionBar.this.mWindowCallback.onPanelClosed(108, ((Menu)arg2));
            this.mClosingActionMenu = false;
        }

        public boolean onOpenSubMenu(MenuBuilder arg2) {
            ToolbarActionBar.this.mWindowCallback.onMenuOpened(108, ((Menu)arg2));
            return 1;
        }
    }

    final class MenuBuilderCallback implements androidx.appcompat.view.menu.MenuBuilder$Callback {
        MenuBuilderCallback(ToolbarActionBar arg1) {
            ToolbarActionBar.this = arg1;
            super();
        }

        public boolean onMenuItemSelected(MenuBuilder arg1, MenuItem arg2) {
            return 0;
        }

        public void onMenuModeChange(MenuBuilder arg5) {
            boolean v0 = ToolbarActionBar.this.mDecorToolbar.isOverflowMenuShowing();
            ToolbarActionBar v1 = ToolbarActionBar.this;
            int v2 = 108;
            if(v0) {
                v1.mWindowCallback.onPanelClosed(v2, ((Menu)arg5));
                return;
            }

            if(v1.mWindowCallback.onPreparePanel(0, null, ((Menu)arg5))) {
                ToolbarActionBar.this.mWindowCallback.onMenuOpened(v2, ((Menu)arg5));
            }
        }
    }

    class ToolbarMenuCallback implements ActionBarMenuCallback {
        ToolbarMenuCallback(ToolbarActionBar arg1) {
            ToolbarActionBar.this = arg1;
            super();
        }

        public View onCreatePanelView(int arg1) {
            if(arg1 == 0) {
                return new View(ToolbarActionBar.this.mDecorToolbar.getContext());
            }

            return null;
        }

        public boolean onPreparePanel(int arg1) {
            if(arg1 == 0 && !ToolbarActionBar.this.mToolbarMenuPrepared) {
                ToolbarActionBar.this.mDecorToolbar.setMenuPrepared();
                ToolbarActionBar.this.mToolbarMenuPrepared = true;
            }

            return 0;
        }
    }

    final DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    final ActionBarMenuCallback mMenuCallback;
    private boolean mMenuCallbackSet;
    private final OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator;
    private ArrayList mMenuVisibilityListeners;
    boolean mToolbarMenuPrepared;
    final Window$Callback mWindowCallback;

    ToolbarActionBar(Toolbar arg4, CharSequence arg5, Window$Callback arg6) {
        super();
        this.mMenuVisibilityListeners = new ArrayList();
        this.mMenuInvalidator = new androidx.appcompat.app.ToolbarActionBar$1(this);
        androidx.appcompat.app.ToolbarActionBar$2 v0 = new androidx.appcompat.app.ToolbarActionBar$2(this);
        this.mMenuClicker = ((OnMenuItemClickListener)v0);
        Preconditions.checkNotNull(arg4);
        ToolbarWidgetWrapper v1 = new ToolbarWidgetWrapper(arg4, false);
        this.mDecorToolbar = ((DecorToolbar)v1);
        this.mWindowCallback = Preconditions.checkNotNull(arg6);
        ((DecorToolbar)v1).setWindowCallback(arg6);
        arg4.setOnMenuItemClickListener(((OnMenuItemClickListener)v0));
        ((DecorToolbar)v1).setWindowTitle(arg5);
        this.mMenuCallback = new ToolbarMenuCallback(this);
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener arg1) {
        this.mMenuVisibilityListeners.add(arg1);
    }

    public void addTab(Tab arg1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab arg1, int arg2) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab arg1, int arg2, boolean arg3) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(Tab arg1, boolean arg2) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public boolean collapseActionView() {
        if(this.mDecorToolbar.hasExpandedActionView()) {
            this.mDecorToolbar.collapseActionView();
            return 1;
        }

        return 0;
    }

    public void dispatchMenuVisibilityChanged(boolean arg4) {
        if(arg4 == this.mLastMenuVisibility) {
        }
        else {
            this.mLastMenuVisibility = arg4;
            int v0 = this.mMenuVisibilityListeners.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.mMenuVisibilityListeners.get(v1).onMenuVisibilityChanged(arg4);
            }
        }
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation(this.mDecorToolbar.getViewGroup());
    }

    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    private Menu getMenu() {
        if(!this.mMenuCallbackSet) {
            this.mDecorToolbar.setMenuCallbacks(new ActionMenuPresenterCallback(this), new MenuBuilderCallback(this));
            this.mMenuCallbackSet = true;
        }

        return this.mDecorToolbar.getMenu();
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public int getNavigationMode() {
        return 0;
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public Tab getTabAt(int arg1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
        ViewCompat.postOnAnimation(this.mDecorToolbar.getViewGroup(), this.mMenuInvalidator);
        return 1;
    }

    public boolean isShowing() {
        if(this.mDecorToolbar.getVisibility() == 0) {
            return 1;
        }

        return 0;
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void onConfigurationChanged(Configuration arg1) {
        super.onConfigurationChanged(arg1);
    }

    void onDestroy() {
        this.mDecorToolbar.getViewGroup().removeCallbacks(this.mMenuInvalidator);
    }

    public boolean onKeyShortcut(int arg4, KeyEvent arg5) {
        Menu v3 = this.getMenu();
        if(v3 != null) {
            int v1 = arg5 != null ? arg5.getDeviceId() : -1;
            boolean v2 = true;
            if(KeyCharacterMap.load(v1).getKeyboardType() != 1) {
            }
            else {
                v2 = false;
            }

            v3.setQwertyMode(v2);
            return v3.performShortcut(arg4, arg5, 0);
        }

        return 0;
    }

    public boolean onMenuKeyEvent(KeyEvent arg2) {
        if(arg2.getAction() == 1) {
            this.openOptionsMenu();
        }

        return 1;
    }

    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    void populateOptionsMenu() {
        Menu v0 = this.getMenu();
        View v2 = null;
        Menu v1 = (v0 instanceof MenuBuilder) ? v0 : ((Menu)v2);
        if(v1 != null) {
            ((MenuBuilder)v1).stopDispatchingItemsChanged();
        }

        try {
            v0.clear();
            if(!this.mWindowCallback.onCreatePanelMenu(0, v0) || !this.mWindowCallback.onPreparePanel(0, v2, v0)) {
                v0.clear();
            }
        }
        catch(Throwable v5) {
            if(v1 != null) {
                ((MenuBuilder)v1).startDispatchingItemsChanged();
            }

            throw v5;
        }

        if(v1 != null) {
            ((MenuBuilder)v1).startDispatchingItemsChanged();
        }
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener arg1) {
        this.mMenuVisibilityListeners.remove(arg1);
    }

    public void removeTab(Tab arg1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int arg1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean requestFocus() {
        ViewGroup v1 = this.mDecorToolbar.getViewGroup();
        if(v1 != null && !v1.hasFocus()) {
            v1.requestFocus();
            return 1;
        }

        return 0;
    }

    public void selectTab(Tab arg1) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setBackgroundDrawable(Drawable arg1) {
        this.mDecorToolbar.setBackgroundDrawable(arg1);
    }

    public void setCustomView(int arg4) {
        this.setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(arg4, this.mDecorToolbar.getViewGroup(), false));
    }

    public void setCustomView(View arg3) {
        this.setCustomView(arg3, new LayoutParams(-2, -2));
    }

    public void setCustomView(View arg1, LayoutParams arg2) {
        if(arg1 != null) {
            arg1.setLayoutParams(((ViewGroup$LayoutParams)arg2));
        }

        this.mDecorToolbar.setCustomView(arg1);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean arg1) {
    }

    public void setDisplayHomeAsUpEnabled(boolean arg2) {
        int v0 = 4;
        int v2 = arg2 ? v0 : 0;
        this.setDisplayOptions(v2, v0);
    }

    public void setDisplayOptions(int arg2, int arg3) {
        this.mDecorToolbar.setDisplayOptions(arg2 & arg3 | ~arg3 & this.mDecorToolbar.getDisplayOptions());
    }

    public void setDisplayOptions(int arg2) {
        this.setDisplayOptions(arg2, -1);
    }

    public void setDisplayShowCustomEnabled(boolean arg2) {
        int v0 = 16;
        int v2 = arg2 ? v0 : 0;
        this.setDisplayOptions(v2, v0);
    }

    public void setDisplayShowHomeEnabled(boolean arg2) {
        int v0 = 2;
        int v2 = arg2 ? v0 : 0;
        this.setDisplayOptions(v2, v0);
    }

    public void setDisplayShowTitleEnabled(boolean arg2) {
        int v0 = 8;
        int v2 = arg2 ? v0 : 0;
        this.setDisplayOptions(v2, v0);
    }

    public void setDisplayUseLogoEnabled(boolean arg2) {
        this.setDisplayOptions(((int)arg2), 1);
    }

    public void setElevation(float arg1) {
        ViewCompat.setElevation(this.mDecorToolbar.getViewGroup(), arg1);
    }

    public void setHomeActionContentDescription(int arg1) {
        this.mDecorToolbar.setNavigationContentDescription(arg1);
    }

    public void setHomeActionContentDescription(CharSequence arg1) {
        this.mDecorToolbar.setNavigationContentDescription(arg1);
    }

    public void setHomeAsUpIndicator(int arg1) {
        this.mDecorToolbar.setNavigationIcon(arg1);
    }

    public void setHomeAsUpIndicator(Drawable arg1) {
        this.mDecorToolbar.setNavigationIcon(arg1);
    }

    public void setHomeButtonEnabled(boolean arg1) {
    }

    public void setIcon(int arg1) {
        this.mDecorToolbar.setIcon(arg1);
    }

    public void setIcon(Drawable arg1) {
        this.mDecorToolbar.setIcon(arg1);
    }

    public void setListNavigationCallbacks(SpinnerAdapter arg2, OnNavigationListener arg3) {
        this.mDecorToolbar.setDropdownParams(arg2, new NavItemSelectedListener(arg3));
    }

    public void setLogo(int arg1) {
        this.mDecorToolbar.setLogo(arg1);
    }

    public void setLogo(Drawable arg1) {
        this.mDecorToolbar.setLogo(arg1);
    }

    public void setNavigationMode(int arg2) {
        if(arg2 != 2) {
            this.mDecorToolbar.setNavigationMode(arg2);
            return;
        }

        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    public void setSelectedNavigationItem(int arg3) {
        if(this.mDecorToolbar.getNavigationMode() == 1) {
            this.mDecorToolbar.setDropdownSelectedPosition(arg3);
            return;
        }

        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    public void setShowHideAnimationEnabled(boolean arg1) {
    }

    public void setSplitBackgroundDrawable(Drawable arg1) {
    }

    public void setStackedBackgroundDrawable(Drawable arg1) {
    }

    public void setSubtitle(int arg2) {
        DecorToolbar v1 = this.mDecorToolbar;
        CharSequence v2 = arg2 != 0 ? v1.getContext().getText(arg2) : null;
        v1.setSubtitle(v2);
    }

    public void setSubtitle(CharSequence arg1) {
        this.mDecorToolbar.setSubtitle(arg1);
    }

    public void setTitle(int arg2) {
        DecorToolbar v1 = this.mDecorToolbar;
        CharSequence v2 = arg2 != 0 ? v1.getContext().getText(arg2) : null;
        v1.setTitle(v2);
    }

    public void setTitle(CharSequence arg1) {
        this.mDecorToolbar.setTitle(arg1);
    }

    public void setWindowTitle(CharSequence arg1) {
        this.mDecorToolbar.setWindowTitle(arg1);
    }

    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }
}

