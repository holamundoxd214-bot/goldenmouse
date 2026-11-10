package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View$OnTouchListener;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow$OnDismissListener;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

public class PopupMenu {
    public interface OnDismissListener {
        void onDismiss(PopupMenu arg1);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem arg1);
    }

    private final View mAnchor;
    private final Context mContext;
    private View$OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    public PopupMenu(Context arg2, View arg3) {
        this(arg2, arg3, 0);
    }

    public PopupMenu(Context arg7, View arg8, int arg9) {
        this(arg7, arg8, arg9, attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context arg8, View arg9, int arg10, int arg11, int arg12) {
        super();
        this.mContext = arg8;
        this.mAnchor = arg9;
        MenuBuilder v2 = new MenuBuilder(arg8);
        this.mMenu = v2;
        v2.setCallback(new Callback() {
            public boolean onMenuItemSelected(MenuBuilder arg1, MenuItem arg2) {
                if(PopupMenu.this.mMenuItemClickListener != null) {
                    return PopupMenu.this.mMenuItemClickListener.onMenuItemClick(arg2);
                }

                return 0;
            }

            public void onMenuModeChange(MenuBuilder arg1) {
            }
        });
        MenuPopupHelper v0 = new MenuPopupHelper(arg8, v2, arg9, false, arg11, arg12);
        this.mPopup = v0;
        v0.setGravity(arg10);
        v0.setOnDismissListener(new PopupWindow$OnDismissListener() {
            public void onDismiss() {
                if(PopupMenu.this.mOnDismissListener != null) {
                    PopupMenu.this.mOnDismissListener.onDismiss(PopupMenu.this);
                }
            }
        });
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public View$OnTouchListener getDragToOpenListener() {
        if(this.mDragListener == null) {
            this.mDragListener = new ForwardingListener(this.mAnchor) {
                public ShowableListMenu getPopup() {
                    return PopupMenu.this.mPopup.getPopup();
                }

                protected boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return 1;
                }

                protected boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return 1;
                }
            };
        }

        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    ListView getMenuListView() {
        if(!this.mPopup.isShowing()) {
            return null;
        }

        return this.mPopup.getListView();
    }

    public void inflate(int arg2) {
        this.getMenuInflater().inflate(arg2, this.mMenu);
    }

    public void setForceShowIcon(boolean arg1) {
        this.mPopup.setForceShowIcon(arg1);
    }

    public void setGravity(int arg1) {
        this.mPopup.setGravity(arg1);
    }

    public void setOnDismissListener(OnDismissListener arg1) {
        this.mOnDismissListener = arg1;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener arg1) {
        this.mMenuItemClickListener = arg1;
    }

    public void show() {
        this.mPopup.show();
    }
}

