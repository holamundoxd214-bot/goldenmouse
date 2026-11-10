package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class CascadingMenuPopup extends MenuPopup implements View$OnKeyListener, PopupWindow$OnDismissListener, MenuPresenter {
    class androidx.appcompat.view.menu.CascadingMenuPopup$1 implements ViewTreeObserver$OnGlobalLayoutListener {
        androidx.appcompat.view.menu.CascadingMenuPopup$1(CascadingMenuPopup arg1) {
            CascadingMenuPopup.this = arg1;
            super();
        }

        public void onGlobalLayout() {
            if((CascadingMenuPopup.this.isShowing()) && CascadingMenuPopup.this.mShowingMenus.size() > 0 && !CascadingMenuPopup.this.mShowingMenus.get(0).window.isModal()) {
                View v0 = CascadingMenuPopup.this.mShownAnchorView;
                if(v0 != null) {
                    if(!v0.isShown()) {
                    }
                    else {
                        Iterator v2 = CascadingMenuPopup.this.mShowingMenus.iterator();
                        while(true) {
                            if(v2.hasNext()) {
                                v2.next().window.show();
                                continue;
                            }
                            else {
                                return;
                            }
                        }
                    }
                }

                CascadingMenuPopup.this.dismiss();
            }
        }
    }

    class androidx.appcompat.view.menu.CascadingMenuPopup$2 implements View$OnAttachStateChangeListener {
        androidx.appcompat.view.menu.CascadingMenuPopup$2(CascadingMenuPopup arg1) {
            CascadingMenuPopup.this = arg1;
            super();
        }

        public void onViewAttachedToWindow(View arg1) {
        }

        public void onViewDetachedFromWindow(View arg3) {
            if(CascadingMenuPopup.this.mTreeObserver != null) {
                if(!CascadingMenuPopup.this.mTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.mTreeObserver = arg3.getViewTreeObserver();
                }

                CascadingMenuPopup.this.mTreeObserver.removeGlobalOnLayoutListener(CascadingMenuPopup.this.mGlobalLayoutListener);
            }

            arg3.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
        }
    }

    class androidx.appcompat.view.menu.CascadingMenuPopup$3 implements MenuItemHoverListener {
        androidx.appcompat.view.menu.CascadingMenuPopup$3(CascadingMenuPopup arg1) {
            CascadingMenuPopup.this = arg1;
            super();
        }

        public void onItemHoverEnter(MenuBuilder arg6, MenuItem arg7) {
            int v3;
            Object v1 = null;
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(v1);
            int v0 = CascadingMenuPopup.this.mShowingMenus.size();
            int v2 = 0;
            while(true) {
                v3 = -1;
                if(v2 >= v0) {
                    break;
                }
                else if(arg6 == CascadingMenuPopup.this.mShowingMenus.get(v2).menu) {
                }
                else {
                    ++v2;
                    continue;
                }

                goto label_19;
            }

            v2 = v3;
        label_19:
            if(v2 == v3) {
                return;
            }

            ++v2;
            if(v2 < CascadingMenuPopup.this.mShowingMenus.size()) {
                v1 = CascadingMenuPopup.this.mShowingMenus.get(v2);
            }

            CascadingMenuPopup.this.mSubMenuHoverHandler.postAtTime(new Runnable(((CascadingMenuInfo)v1), arg7, arg6) {
                public void run() {
                    if(this.val$nextInfo != null) {
                        this.this$1.this$0.mShouldCloseImmediately = true;
                        this.val$nextInfo.menu.close(false);
                        this.this$1.this$0.mShouldCloseImmediately = false;
                    }

                    if((this.val$item.isEnabled()) && (this.val$item.hasSubMenu())) {
                        this.val$menu.performItemAction(this.val$item, 4);
                    }
                }
            }, arg6, SystemClock.uptimeMillis() + 200);
        }

        public void onItemHoverExit(MenuBuilder arg1, MenuItem arg2) {
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(arg1);
        }
    }

    class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow arg1, MenuBuilder arg2, int arg3) {
            super();
            this.window = arg1;
            this.menu = arg2;
            this.position = arg3;
        }

        public ListView getListView() {
            return this.window.getListView();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface HorizPosition {
    }

    static final int HORIZ_POSITION_LEFT = 0;
    static final int HORIZ_POSITION_RIGHT = 1;
    private static final int ITEM_LAYOUT = 0;
    static final int SUBMENU_TIMEOUT_MS = 200;
    private View mAnchorView;
    private final View$OnAttachStateChangeListener mAttachStateChangeListener;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    final ViewTreeObserver$OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private int mLastPosition;
    private final MenuItemHoverListener mMenuItemHoverListener;
    private final int mMenuMaxWidth;
    private PopupWindow$OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final List mPendingMenus;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private Callback mPresenterCallback;
    private int mRawDropDownGravity;
    boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    final List mShowingMenus;
    View mShownAnchorView;
    final Handler mSubMenuHoverHandler;
    ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;

    static {
        CascadingMenuPopup.ITEM_LAYOUT = layout.abc_cascading_menu_item_layout;
    }

    public CascadingMenuPopup(Context arg2, View arg3, int arg4, int arg5, boolean arg6) {
        super();
        this.mPendingMenus = new ArrayList();
        this.mShowingMenus = new ArrayList();
        this.mGlobalLayoutListener = new androidx.appcompat.view.menu.CascadingMenuPopup$1(this);
        this.mAttachStateChangeListener = new androidx.appcompat.view.menu.CascadingMenuPopup$2(this);
        this.mMenuItemHoverListener = new androidx.appcompat.view.menu.CascadingMenuPopup$3(this);
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = arg2;
        this.mAnchorView = arg3;
        this.mPopupStyleAttr = arg4;
        this.mPopupStyleRes = arg5;
        this.mOverflowOnly = arg6;
        this.mForceShowIcon = false;
        this.mLastPosition = this.getInitialMenuPosition();
        Resources v2 = arg2.getResources();
        this.mMenuMaxWidth = Math.max(v2.getDisplayMetrics().widthPixels / 2, v2.getDimensionPixelSize(dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    public void addMenu(MenuBuilder arg2) {
        arg2.addMenuPresenter(((MenuPresenter)this), this.mContext);
        if(this.isShowing()) {
            this.showMenu(arg2);
            return;
        }

        this.mPendingMenus.add(arg2);
    }

    protected boolean closeMenuOnSubMenuOpened() {
        return 0;
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow v0 = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        v0.setHoverListener(this.mMenuItemHoverListener);
        v0.setOnItemClickListener(((AdapterView$OnItemClickListener)this));
        v0.setOnDismissListener(((PopupWindow$OnDismissListener)this));
        v0.setAnchorView(this.mAnchorView);
        v0.setDropDownGravity(this.mDropDownGravity);
        v0.setModal(true);
        v0.setInputMethodMode(2);
        return v0;
    }

    public void dismiss() {
        int v0 = this.mShowingMenus.size();
        if(v0 > 0) {
            Object[] v3 = this.mShowingMenus.toArray(new CascadingMenuInfo[v0]);
            --v0;
            while(v0 >= 0) {
                Object v1 = v3[v0];
                if(((CascadingMenuInfo)v1).window.isShowing()) {
                    ((CascadingMenuInfo)v1).window.dismiss();
                }

                --v0;
            }
        }
    }

    private int findIndexOfAddedMenu(MenuBuilder arg4) {
        int v0 = this.mShowingMenus.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(arg4 == this.mShowingMenus.get(v1).menu) {
                return v1;
            }
        }

        return -1;
    }

    private MenuItem findMenuItemForSubmenu(MenuBuilder arg4, MenuBuilder arg5) {
        int v3 = arg4.size();
        int v0;
        for(v0 = 0; v0 < v3; ++v0) {
            MenuItem v1 = arg4.getItem(v0);
            if((v1.hasSubMenu()) && arg5 == v1.getSubMenu()) {
                return v1;
            }
        }

        return null;
    }

    private View findParentViewForSubmenu(CascadingMenuInfo arg7, MenuBuilder arg8) {
        int v4;
        int v1;
        MenuItem v6 = this.findMenuItemForSubmenu(arg7.menu, arg8);
        View v8 = null;
        if(v6 == null) {
            return v8;
        }

        ListView v7 = arg7.getListView();
        ListAdapter v0 = v7.getAdapter();
        int v2 = 0;
        if((v0 instanceof HeaderViewListAdapter)) {
            v1 = ((HeaderViewListAdapter)v0).getHeadersCount();
            v0 = ((HeaderViewListAdapter)v0).getWrappedAdapter();
        }
        else {
            v1 = 0;
        }

        int v3 = ((MenuAdapter)v0).getCount();
        while(true) {
            v4 = -1;
            if(v2 >= v3) {
                break;
            }
            else if(v6 == ((MenuAdapter)v0).getItem(v2)) {
            }
            else {
                ++v2;
                continue;
            }

            goto label_23;
        }

        v2 = v4;
    label_23:
        if(v2 == v4) {
            return v8;
        }

        v2 = v2 + v1 - v7.getFirstVisiblePosition();
        if(v2 >= 0) {
            if(v2 >= v7.getChildCount()) {
            }
            else {
                return v7.getChildAt(v2);
            }
        }

        return v8;
    }

    public boolean flagActionItems() {
        return 0;
    }

    private int getInitialMenuPosition() {
        if(ViewCompat.getLayoutDirection(this.mAnchorView) == 1) {
            return 0;
        }

        return 1;
    }

    public ListView getListView() {
        if(this.mShowingMenus.isEmpty()) {
            return null;
        }

        return this.mShowingMenus.get(this.mShowingMenus.size() - 1).getListView();
    }

    private int getNextMenuPosition(int arg6) {
        ListView v0 = this.mShowingMenus.get(this.mShowingMenus.size() - 1).getListView();
        int[] v1 = new int[2];
        v0.getLocationOnScreen(v1);
        Rect v3 = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(v3);
        if(this.mLastPosition == 1) {
            if(v1[0] + v0.getWidth() + arg6 > v3.right) {
                return 0;
            }

            return 1;
        }

        if(v1[0] - arg6 < 0) {
            return 1;
        }

        return 0;
    }

    public boolean isShowing() {
        if(this.mShowingMenus.size() > 0 && (this.mShowingMenus.get(0).window.isShowing())) {
            return 1;
        }

        return 0;
    }

    public void onCloseMenu(MenuBuilder arg6, boolean arg7) {
        int v0 = this.findIndexOfAddedMenu(arg6);
        if(v0 < 0) {
        }
        else {
            int v1 = v0 + 1;
            if(v1 < this.mShowingMenus.size()) {
                this.mShowingMenus.get(v1).menu.close(false);
            }

            Object v0_1 = this.mShowingMenus.remove(v0);
            ((CascadingMenuInfo)v0_1).menu.removeMenuPresenter(((MenuPresenter)this));
            Object v2 = null;
            if(this.mShouldCloseImmediately) {
                ((CascadingMenuInfo)v0_1).window.setExitTransition(v2);
                ((CascadingMenuInfo)v0_1).window.setAnimationStyle(0);
            }

            ((CascadingMenuInfo)v0_1).window.dismiss();
            v0 = this.mShowingMenus.size();
            this.mLastPosition = v0 > 0 ? this.mShowingMenus.get(v0 - 1).position : this.getInitialMenuPosition();
            if(v0 == 0) {
                this.dismiss();
                Callback v7 = this.mPresenterCallback;
                if(v7 != null) {
                    v7.onCloseMenu(arg6, true);
                }

                ViewTreeObserver v6 = this.mTreeObserver;
                if(v6 != null) {
                    if(v6.isAlive()) {
                        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                    }

                    this.mTreeObserver = ((ViewTreeObserver)v2);
                }

                this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
                this.mOnDismissListener.onDismiss();
                return;
            }

            if(!arg7) {
                return;
            }

            this.mShowingMenus.get(0).menu.close(false);
        }
    }

    public void onDismiss() {
        Object v3;
        int v0 = this.mShowingMenus.size();
        int v2 = 0;
        while(true) {
            if(v2 < v0) {
                v3 = this.mShowingMenus.get(v2);
                if(!((CascadingMenuInfo)v3).window.isShowing()) {
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_14;
        }

        v3 = null;
    label_14:
        if(v3 != null) {
            ((CascadingMenuInfo)v3).menu.close(false);
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

    public boolean onSubMenuSelected(SubMenuBuilder arg5) {
        Object v1;
        Iterator v0 = this.mShowingMenus.iterator();
        do {
            if(!v0.hasNext()) {
                goto label_11;
            }

            v1 = v0.next();
        }
        while(arg5 != ((CascadingMenuInfo)v1).menu);

        ((CascadingMenuInfo)v1).getListView().requestFocus();
        return 1;
    label_11:
        if(arg5.hasVisibleItems()) {
            this.addMenu(((MenuBuilder)arg5));
            Callback v4 = this.mPresenterCallback;
            if(v4 != null) {
                v4.onOpenSubMenu(((MenuBuilder)arg5));
            }

            return 1;
        }

        return 0;
    }

    public void setAnchorView(View arg2) {
        if(this.mAnchorView != arg2) {
            this.mAnchorView = arg2;
            this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(arg2));
        }
    }

    public void setCallback(Callback arg1) {
        this.mPresenterCallback = arg1;
    }

    public void setForceShowIcon(boolean arg1) {
        this.mForceShowIcon = arg1;
    }

    public void setGravity(int arg2) {
        if(this.mRawDropDownGravity != arg2) {
            this.mRawDropDownGravity = arg2;
            this.mDropDownGravity = GravityCompat.getAbsoluteGravity(arg2, ViewCompat.getLayoutDirection(this.mAnchorView));
        }
    }

    public void setHorizontalOffset(int arg2) {
        this.mHasXOffset = true;
        this.mXOffset = arg2;
    }

    public void setOnDismissListener(PopupWindow$OnDismissListener arg1) {
        this.mOnDismissListener = arg1;
    }

    public void setShowTitle(boolean arg1) {
        this.mShowTitle = arg1;
    }

    public void setVerticalOffset(int arg2) {
        this.mHasYOffset = true;
        this.mYOffset = arg2;
    }

    public void show() {
        if(this.isShowing()) {
        }
        else {
            Iterator v0 = this.mPendingMenus.iterator();
            while(v0.hasNext()) {
                this.showMenu(v0.next());
            }

            this.mPendingMenus.clear();
            View v0_1 = this.mAnchorView;
            this.mShownAnchorView = v0_1;
            if(v0_1 != null) {
                int v1 = this.mTreeObserver == null ? 1 : 0;
                ViewTreeObserver v0_2 = v0_1.getViewTreeObserver();
                this.mTreeObserver = v0_2;
                if(v1 != 0) {
                    v0_2.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
                }

                this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
            }
        }
    }

    private void showMenu(MenuBuilder arg12) {
        View v6;
        Object v1_1;
        LayoutInflater v0 = LayoutInflater.from(this.mContext);
        MenuAdapter v1 = new MenuAdapter(arg12, v0, this.mOverflowOnly, CascadingMenuPopup.ITEM_LAYOUT);
        if(!this.isShowing() && (this.mForceShowIcon)) {
            v1.setForceShowIcon(true);
        }
        else if(this.isShowing()) {
            v1.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(arg12));
        }

        ViewGroup v5 = null;
        int v2 = CascadingMenuPopup.measureIndividualMenuWidth(((ListAdapter)v1), v5, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow v4 = this.createPopupWindow();
        v4.setAdapter(((ListAdapter)v1));
        v4.setContentWidth(v2);
        v4.setDropDownGravity(this.mDropDownGravity);
        if(this.mShowingMenus.size() > 0) {
            v1_1 = this.mShowingMenus.get(this.mShowingMenus.size() - 1);
            v6 = this.findParentViewForSubmenu(((CascadingMenuInfo)v1_1), arg12);
        }
        else {
            v1_1 = v5;
            v6 = ((View)v1_1);
        }

        if(v6 != null) {
            v4.setTouchModal(false);
            v4.setEnterTransition(v5);
            int v8 = this.getNextMenuPosition(v2);
            int v9 = v8 == 1 ? 1 : 0;
            this.mLastPosition = v8;
            v4.setAnchorView(v6);
            if((this.mDropDownGravity & 5) == 5) {
                if(v9 != 0) {
                }
                else {
                    v2 = -v6.getWidth();
                }
            }
            else if(v9 != 0) {
                v2 = v6.getWidth();
            }
            else {
                v2 = -v2;
            }

            v4.setHorizontalOffset(v2);
            v4.setOverlapAnchor(true);
            v4.setVerticalOffset(0);
        }
        else {
            if(this.mHasXOffset) {
                v4.setHorizontalOffset(this.mXOffset);
            }

            if(this.mHasYOffset) {
                v4.setVerticalOffset(this.mYOffset);
            }

            v4.setEpicenterBounds(this.getEpicenterBounds());
        }

        this.mShowingMenus.add(new CascadingMenuInfo(v4, arg12, this.mLastPosition));
        v4.show();
        ListView v2_1 = v4.getListView();
        v2_1.setOnKeyListener(((View$OnKeyListener)this));
        if(v1_1 == null && (this.mShowTitle) && arg12.getHeaderTitle() != null) {
            View v11 = v0.inflate(layout.abc_popup_menu_header_item_layout, ((ViewGroup)v2_1), false);
            View v0_1 = ((FrameLayout)v11).findViewById(0x1020016);
            ((FrameLayout)v11).setEnabled(false);
            ((TextView)v0_1).setText(arg12.getHeaderTitle());
            v2_1.addHeaderView(v11, v5, false);
            v4.show();
        }
    }

    public void updateMenuView(boolean arg1) {
        Iterator v0 = this.mShowingMenus.iterator();
        while(v0.hasNext()) {
            CascadingMenuPopup.toMenuAdapter(v0.next().getListView().getAdapter()).notifyDataSetChanged();
        }
    }
}

