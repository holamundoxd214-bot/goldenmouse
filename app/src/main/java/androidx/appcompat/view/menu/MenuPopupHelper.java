package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow$OnDismissListener;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class MenuPopupHelper implements MenuHelper {
    class androidx.appcompat.view.menu.MenuPopupHelper$1 implements PopupWindow$OnDismissListener {
        androidx.appcompat.view.menu.MenuPopupHelper$1(MenuPopupHelper arg1) {
            MenuPopupHelper.this = arg1;
            super();
        }

        public void onDismiss() {
            MenuPopupHelper.this.onDismiss();
        }
    }

    class Api17Impl {
        private Api17Impl() {
            super();
        }

        static void getRealSize(Display arg0, Point arg1) {
            arg0.getRealSize(arg1);
        }
    }

    private static final int TOUCH_EPICENTER_SIZE_DP = 0x30;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow$OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow$OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private Callback mPresenterCallback;

    public MenuPopupHelper(Context arg8, MenuBuilder arg9) {
        this(arg8, arg9, null, false, attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(Context arg2, MenuBuilder arg3, View arg4, boolean arg5, int arg6, int arg7) {
        super();
        this.mDropDownGravity = 0x800003;
        this.mInternalOnDismissListener = new androidx.appcompat.view.menu.MenuPopupHelper$1(this);
        this.mContext = arg2;
        this.mMenu = arg3;
        this.mAnchorView = arg4;
        this.mOverflowOnly = arg5;
        this.mPopupStyleAttr = arg6;
        this.mPopupStyleRes = arg7;
    }

    public MenuPopupHelper(Context arg8, MenuBuilder arg9, View arg10) {
        this(arg8, arg9, arg10, false, attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(Context arg8, MenuBuilder arg9, View arg10, boolean arg11, int arg12) {
        this(arg8, arg9, arg10, arg11, arg12, 0);
    }

    private MenuPopup createPopup() {
        StandardMenuPopup v2_1;
        Display v0 = this.mContext.getSystemService("window").getDefaultDisplay();
        Point v1 = new Point();
        Api17Impl.getRealSize(v0, v1);
        if(Math.min(v1.x, v1.y) >= this.mContext.getResources().getDimensionPixelSize(dimen.abc_cascading_menus_min_smallest_width)) {
            CascadingMenuPopup v2 = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        }
        else {
            v2_1 = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        }

        ((MenuPopup)v2_1).addMenu(this.mMenu);
        ((MenuPopup)v2_1).setOnDismissListener(this.mInternalOnDismissListener);
        ((MenuPopup)v2_1).setAnchorView(this.mAnchorView);
        ((MenuPopup)v2_1).setCallback(this.mPresenterCallback);
        ((MenuPopup)v2_1).setForceShowIcon(this.mForceShowIcon);
        ((MenuPopup)v2_1).setGravity(this.mDropDownGravity);
        return ((MenuPopup)v2_1);
    }

    public void dismiss() {
        if(this.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public ListView getListView() {
        return this.getPopup().getListView();
    }

    public MenuPopup getPopup() {
        MenuPopup v0 = this.mPopup;
        if(v0 == null) {
            v0 = this.createPopup();
            this.mPopup = v0;
        }

        return v0;
    }

    public boolean isShowing() {
        MenuPopup v0 = this.mPopup;
        if(v0 != null && (v0.isShowing())) {
            return 1;
        }

        return 0;
    }

    protected void onDismiss() {
        this.mPopup = null;
        PopupWindow$OnDismissListener v1 = this.mOnDismissListener;
        if(v1 != null) {
            v1.onDismiss();
        }
    }

    public void setAnchorView(View arg1) {
        this.mAnchorView = arg1;
    }

    public void setForceShowIcon(boolean arg1) {
        this.mForceShowIcon = arg1;
        MenuPopup v0 = this.mPopup;
        if(v0 != null) {
            v0.setForceShowIcon(arg1);
        }
    }

    public void setGravity(int arg1) {
        this.mDropDownGravity = arg1;
    }

    public void setOnDismissListener(PopupWindow$OnDismissListener arg1) {
        this.mOnDismissListener = arg1;
    }

    public void setPresenterCallback(Callback arg1) {
        this.mPresenterCallback = arg1;
        MenuPopup v0 = this.mPopup;
        if(v0 != null) {
            v0.setCallback(arg1);
        }
    }

    public void show() {
        if(this.tryShow()) {
            return;
        }

        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public void show(int arg1, int arg2) {
        if(this.tryShow(arg1, arg2)) {
            return;
        }

        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    private void showPopup(int arg3, int arg4, boolean arg5, boolean arg6) {
        MenuPopup v0 = this.getPopup();
        v0.setShowTitle(arg6);
        if(arg5) {
            if((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                arg3 -= this.mAnchorView.getWidth();
            }

            v0.setHorizontalOffset(arg3);
            v0.setVerticalOffset(arg4);
            int v2 = ((int)(this.mContext.getResources().getDisplayMetrics().density * 48f / 2f));
            v0.setEpicenterBounds(new Rect(arg3 - v2, arg4 - v2, arg3 + v2, arg4 + v2));
        }

        v0.show();
    }

    public boolean tryShow() {
        if(this.isShowing()) {
            return 1;
        }

        if(this.mAnchorView == null) {
            return 0;
        }

        this.showPopup(0, 0, false, false);
        return 1;
    }

    public boolean tryShow(int arg3, int arg4) {
        if(this.isShowing()) {
            return 1;
        }

        if(this.mAnchorView == null) {
            return 0;
        }

        this.showPopup(arg3, arg4, true, true);
        return 1;
    }
}

