package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class StandaloneActionMode extends ActionMode implements Callback {
    private androidx.appcompat.view.ActionMode$Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;

    public StandaloneActionMode(Context arg1, ActionBarContextView arg2, androidx.appcompat.view.ActionMode$Callback arg3, boolean arg4) {
        super();
        this.mContext = arg1;
        this.mContextView = arg2;
        this.mCallback = arg3;
        MenuBuilder v1 = new MenuBuilder(arg2.getContext()).setDefaultShowAsAction(1);
        this.mMenu = v1;
        v1.setCallback(((Callback)this));
        this.mFocusable = arg4;
    }

    public void finish() {
        if(this.mFinished) {
            return;
        }

        this.mFinished = true;
        this.mCallback.onDestroyActionMode(((ActionMode)this));
    }

    public View getCustomView() {
        WeakReference v0 = this.mCustomView;
        if(v0 != null) {
            return v0.get();
        }

        return null;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContextView.getContext());
    }

    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }

    public void invalidate() {
        this.mCallback.onPrepareActionMode(((ActionMode)this), this.mMenu);
    }

    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    public boolean isUiFocusable() {
        return this.mFocusable;
    }

    public void onCloseMenu(MenuBuilder arg1, boolean arg2) {
    }

    public void onCloseSubMenu(SubMenuBuilder arg1) {
    }

    public boolean onMenuItemSelected(MenuBuilder arg1, MenuItem arg2) {
        return this.mCallback.onActionItemClicked(((ActionMode)this), arg2);
    }

    public void onMenuModeChange(MenuBuilder arg1) {
        this.invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder arg3) {
        if(!arg3.hasVisibleItems()) {
            return 1;
        }

        new MenuPopupHelper(this.mContextView.getContext(), ((MenuBuilder)arg3)).show();
        return 1;
    }

    public void setCustomView(View arg2) {
        this.mContextView.setCustomView(arg2);
        WeakReference v0 = arg2 != null ? new WeakReference(arg2) : null;
        this.mCustomView = v0;
    }

    public void setSubtitle(int arg2) {
        this.setSubtitle(this.mContext.getString(arg2));
    }

    public void setSubtitle(CharSequence arg1) {
        this.mContextView.setSubtitle(arg1);
    }

    public void setTitle(int arg2) {
        this.setTitle(this.mContext.getString(arg2));
    }

    public void setTitle(CharSequence arg1) {
        this.mContextView.setTitle(arg1);
    }

    public void setTitleOptionalHint(boolean arg1) {
        super.setTitleOptionalHint(arg1);
        this.mContextView.setTitleOptional(arg1);
    }
}

