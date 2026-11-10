package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

final class StandardMenuPopup extends MenuPopup implements View$OnKeyListener, AdapterView$OnItemClickListener, PopupWindow$OnDismissListener, MenuPresenter {
    class androidx.appcompat.view.menu.StandardMenuPopup$1 implements ViewTreeObserver$OnGlobalLayoutListener {
        androidx.appcompat.view.menu.StandardMenuPopup$1(StandardMenuPopup arg1) {
            StandardMenuPopup.this = arg1;
            super();
        }

        public void onGlobalLayout() {
            if((StandardMenuPopup.this.isShowing()) && !StandardMenuPopup.this.mPopup.isModal()) {
                View v0 = StandardMenuPopup.this.mShownAnchorView;
                if(v0 != null) {
                    if(!v0.isShown()) {
                    }
                    else {
                        StandardMenuPopup.this.mPopup.show();
                        return;
                    }
                }

                StandardMenuPopup.this.dismiss();
            }
        }
    }

    class androidx.appcompat.view.menu.StandardMenuPopup$2 implements View$OnAttachStateChangeListener {
        androidx.appcompat.view.menu.StandardMenuPopup$2(StandardMenuPopup arg1) {
            StandardMenuPopup.this = arg1;
            super();
        }

        public void onViewAttachedToWindow(View arg1) {
        }

        public void onViewDetachedFromWindow(View arg3) {
            if(StandardMenuPopup.this.mTreeObserver != null) {
                if(!StandardMenuPopup.this.mTreeObserver.isAlive()) {
                    StandardMenuPopup.this.mTreeObserver = arg3.getViewTreeObserver();
                }

                StandardMenuPopup.this.mTreeObserver.removeGlobalOnLayoutListener(StandardMenuPopup.this.mGlobalLayoutListener);
            }

            arg3.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
        }
    }

    private static final int ITEM_LAYOUT;
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private final View$OnAttachStateChangeListener mAttachStateChangeListener;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity;
    final ViewTreeObserver$OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasContentWidth;
    private final MenuBuilder mMenu;
    private PopupWindow$OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    final MenuPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private Callback mPresenterCallback;
    private boolean mShowTitle;
    View mShownAnchorView;
    ViewTreeObserver mTreeObserver;
    private boolean mWasDismissed;

    static {
        StandardMenuPopup.ITEM_LAYOUT = layout.abc_popup_menu_item_layout;
    }

    public StandardMenuPopup(Context arg4, MenuBuilder arg5, View arg6, int arg7, int arg8, boolean arg9) {
        super();
        this.mGlobalLayoutListener = new androidx.appcompat.view.menu.StandardMenuPopup$1(this);
        this.mAttachStateChangeListener = new androidx.appcompat.view.menu.StandardMenuPopup$2(this);
        this.mDropDownGravity = 0;
        this.mContext = arg4;
        this.mMenu = arg5;
        this.mOverflowOnly = arg9;
        this.mAdapter = new MenuAdapter(arg5, LayoutInflater.from(arg4), arg9, StandardMenuPopup.ITEM_LAYOUT);
        this.mPopupStyleAttr = arg7;
        this.mPopupStyleRes = arg8;
        Resources v9 = arg4.getResources();
        this.mPopupMaxWidth = Math.max(v9.getDisplayMetrics().widthPixels / 2, v9.getDimensionPixelSize(dimen.abc_config_prefDialogWidth));
        this.mAnchorView = arg6;
        this.mPopup = new MenuPopupWindow(arg4, null, arg7, arg8);
        arg5.addMenuPresenter(((MenuPresenter)this), arg4);
    }

    public void addMenu(MenuBuilder arg1) {
    }

    public void dismiss() {
        if(this.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public boolean flagActionItems() {
        return 0;
    }

    public ListView getListView() {
        return this.mPopup.getListView();
    }

    public boolean isShowing() {
        if(!this.mWasDismissed && (this.mPopup.isShowing())) {
            return 1;
        }

        return 0;
    }

    public void onCloseMenu(MenuBuilder arg2, boolean arg3) {
        if(arg2 != this.mMenu) {
        }
        else {
            this.dismiss();
            Callback v1 = this.mPresenterCallback;
            if(v1 != null) {
                v1.onCloseMenu(arg2, arg3);
            }
        }
    }

    public void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close();
        ViewTreeObserver v0 = this.mTreeObserver;
        if(v0 != null) {
            if(!v0.isAlive()) {
                this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
            }

            this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mTreeObserver = null;
        }

        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        PopupWindow$OnDismissListener v2 = this.mOnDismissListener;
        if(v2 != null) {
            v2.onDismiss();
        }
    }

    public boolean onKey(View arg1, int arg2, KeyEvent arg3) {
        if(arg3.getAction() == 1 && arg2 == 82) {
            this.dismiss();
            return 1;
        }

        return 0;
    }

    public void onRestoreInstanceState(Parcelable arg1) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder arg10) {
        if(arg10.hasVisibleItems()) {
            SubMenuBuilder v4 = arg10;
            MenuPopupHelper v2 = new MenuPopupHelper(this.mContext, ((MenuBuilder)v4), this.mShownAnchorView, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
            v2.setPresenterCallback(this.mPresenterCallback);
            v2.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(((MenuBuilder)v4)));
            v2.setOnDismissListener(this.mOnDismissListener);
            this.mOnDismissListener = null;
            this.mMenu.close(false);
            int v10 = this.mPopup.getHorizontalOffset();
            int v0 = this.mPopup.getVerticalOffset();
            if((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                v10 += this.mAnchorView.getWidth();
            }

            if(!v2.tryShow(v10, v0)) {
                return 0;
            }

            Callback v9 = this.mPresenterCallback;
            if(v9 != null) {
                v9.onOpenSubMenu(((MenuBuilder)v4));
            }

            return 1;
        }

        return 0;
    }

    public void setAnchorView(View arg1) {
        this.mAnchorView = arg1;
    }

    public void setCallback(Callback arg1) {
        this.mPresenterCallback = arg1;
    }

    public void setForceShowIcon(boolean arg1) {
        this.mAdapter.setForceShowIcon(arg1);
    }

    public void setGravity(int arg1) {
        this.mDropDownGravity = arg1;
    }

    public void setHorizontalOffset(int arg1) {
        this.mPopup.setHorizontalOffset(arg1);
    }

    public void setOnDismissListener(PopupWindow$OnDismissListener arg1) {
        this.mOnDismissListener = arg1;
    }

    public void setShowTitle(boolean arg1) {
        this.mShowTitle = arg1;
    }

    public void setVerticalOffset(int arg1) {
        this.mPopup.setVerticalOffset(arg1);
    }

    public void show() {
        if(this.tryShow()) {
            return;
        }

        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    private boolean tryShow() {
        if(this.isShowing()) {
            return 1;
        }

        if(!this.mWasDismissed) {
            View v0 = this.mAnchorView;
            if(v0 == null) {
            }
            else {
                this.mShownAnchorView = v0;
                this.mPopup.setOnDismissListener(((PopupWindow$OnDismissListener)this));
                this.mPopup.setOnItemClickListener(((AdapterView$OnItemClickListener)this));
                this.mPopup.setModal(true);
                v0 = this.mShownAnchorView;
                int v3 = this.mTreeObserver == null ? 1 : 0;
                ViewTreeObserver v4 = v0.getViewTreeObserver();
                this.mTreeObserver = v4;
                if(v3 != 0) {
                    v4.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
                }

                v0.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
                this.mPopup.setAnchorView(v0);
                this.mPopup.setDropDownGravity(this.mDropDownGravity);
                ViewGroup v3_1 = null;
                if(!this.mHasContentWidth) {
                    this.mContentWidth = StandardMenuPopup.measureIndividualMenuWidth(this.mAdapter, v3_1, this.mContext, this.mPopupMaxWidth);
                    this.mHasContentWidth = true;
                }

                this.mPopup.setContentWidth(this.mContentWidth);
                this.mPopup.setInputMethodMode(2);
                this.mPopup.setEpicenterBounds(this.getEpicenterBounds());
                this.mPopup.show();
                ListView v0_1 = this.mPopup.getListView();
                v0_1.setOnKeyListener(((View$OnKeyListener)this));
                if((this.mShowTitle) && this.mMenu.getHeaderTitle() != null) {
                    View v4_1 = LayoutInflater.from(this.mContext).inflate(layout.abc_popup_menu_header_item_layout, ((ViewGroup)v0_1), false);
                    View v5 = ((FrameLayout)v4_1).findViewById(0x1020016);
                    if(v5 != null) {
                        ((TextView)v5).setText(this.mMenu.getHeaderTitle());
                    }

                    ((FrameLayout)v4_1).setEnabled(false);
                    v0_1.addHeaderView(v4_1, v3_1, false);
                }

                this.mPopup.setAdapter(this.mAdapter);
                this.mPopup.show();
                return 1;
            }
        }

        return 0;
    }

    public void updateMenuView(boolean arg1) {
        this.mHasContentWidth = false;
        MenuAdapter v0 = this.mAdapter;
        if(v0 != null) {
            v0.notifyDataSetChanged();
        }
    }
}

