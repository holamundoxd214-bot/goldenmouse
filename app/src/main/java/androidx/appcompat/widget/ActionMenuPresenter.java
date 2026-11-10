package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider$SubUiVisibilityListener;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements SubUiVisibilityListener {
    class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(ActionMenuPresenter arg7, Context arg8, SubMenuBuilder arg9, View arg10) {
            OverflowMenuButton v6_1;
            ActionMenuPresenter.this = arg7;
            ActionButtonSubmenu v0 = this;
            super(arg8, arg9, arg10, false, attr.actionOverflowMenuStyle);
            if(!arg9.getItem().isActionButton()) {
                if(arg7.mOverflowButton == null) {
                    MenuView v6 = arg7.mMenuView;
                }
                else {
                    v6_1 = arg7.mOverflowButton;
                }

                v0.setAnchorView(((View)v6_1));
            }

            v0.setPresenterCallback(arg7.mPopupPresenterCallback);
        }

        protected void onDismiss() {
            ActionMenuPresenter.this.mActionButtonPopup = null;
            ActionMenuPresenter.this.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    class ActionMenuPopupCallback extends PopupCallback {
        ActionMenuPopupCallback(ActionMenuPresenter arg1) {
            ActionMenuPresenter.this = arg1;
            super();
        }

        public ShowableListMenu getPopup() {
            if(ActionMenuPresenter.this.mActionButtonPopup != null) {
                return ActionMenuPresenter.this.mActionButtonPopup.getPopup();
            }

            return null;
        }
    }

    class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(ActionMenuPresenter arg1, OverflowPopup arg2) {
            ActionMenuPresenter.this = arg1;
            super();
            this.mPopup = arg2;
        }

        public void run() {
            if(ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.changeMenuMode();
            }

            MenuView v0 = ActionMenuPresenter.this.mMenuView;
            if(v0 != null && ((View)v0).getWindowToken() != null && (this.mPopup.tryShow())) {
                ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }

            ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    class OverflowMenuButton extends AppCompatImageView implements ActionMenuChildView {
        public OverflowMenuButton(ActionMenuPresenter arg3, Context arg4) {
            ActionMenuPresenter.this = arg3;
            super(arg4, null, attr.actionOverflowButtonStyle);
            this.setClickable(true);
            this.setFocusable(true);
            this.setVisibility(0);
            this.setEnabled(true);
            TooltipCompat.setTooltipText(((View)this), this.getContentDescription());
            this.setOnTouchListener(new ForwardingListener(((View)this), arg3) {
                public ShowableListMenu getPopup() {
                    if(this.this$1.this$0.mOverflowPopup == null) {
                        return null;
                    }

                    return this.this$1.this$0.mOverflowPopup.getPopup();
                }

                public boolean onForwardingStarted() {
                    this.this$1.this$0.showOverflowMenu();
                    return 1;
                }

                public boolean onForwardingStopped() {
                    if(this.this$1.this$0.mPostedOpenRunnable != null) {
                        return 0;
                    }

                    this.this$1.this$0.hideOverflowMenu();
                    return 1;
                }
            });
        }

        public boolean needsDividerAfter() {
            return 0;
        }

        public boolean needsDividerBefore() {
            return 0;
        }

        public boolean performClick() {
            if(super.performClick()) {
                return 1;
            }

            this.playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return 1;
        }

        protected boolean setFrame(int arg4, int arg5, int arg6, int arg7) {
            boolean v4 = super.setFrame(arg4, arg5, arg6, arg7);
            Drawable v5 = this.getDrawable();
            Drawable v6 = this.getBackground();
            if(v5 != null && v6 != null) {
                arg5 = this.getWidth();
                arg7 = this.getHeight();
                int v0 = Math.max(arg5, arg7) / 2;
                arg5 = (arg5 + (this.getPaddingLeft() - this.getPaddingRight())) / 2;
                arg7 = (arg7 + (this.getPaddingTop() - this.getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(v6, arg5 - v0, arg7 - v0, arg5 + v0, arg7 + v0);
            }

            return v4;
        }
    }

    class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(ActionMenuPresenter arg7, Context arg8, MenuBuilder arg9, View arg10, boolean arg11) {
            ActionMenuPresenter.this = arg7;
            super(arg8, arg9, arg10, arg11, attr.actionOverflowMenuStyle);
            this.setGravity(0x800005);
            this.setPresenterCallback(arg7.mPopupPresenterCallback);
        }

        protected void onDismiss() {
            if(ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.close();
            }

            ActionMenuPresenter.this.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    class PopupPresenterCallback implements Callback {
        PopupPresenterCallback(ActionMenuPresenter arg1) {
            ActionMenuPresenter.this = arg1;
            super();
        }

        public void onCloseMenu(MenuBuilder arg3, boolean arg4) {
            if((arg3 instanceof SubMenuBuilder)) {
                arg3.getRootMenu().close(false);
            }

            Callback v2 = ActionMenuPresenter.this.getCallback();
            if(v2 != null) {
                v2.onCloseMenu(arg3, arg4);
            }
        }

        public boolean onOpenSubMenu(MenuBuilder arg4) {
            if(arg4 == ActionMenuPresenter.this.mMenu) {
                return 0;
            }

            ActionMenuPresenter.this.mOpenSubMenuId = arg4.getItem().getItemId();
            Callback v3 = ActionMenuPresenter.this.getCallback();
            if(v3 != null) {
                return v3.onOpenSubMenu(arg4);
            }

            return 0;
        }
    }

    class SavedState implements Parcelable {
        class androidx.appcompat.widget.ActionMenuPresenter$SavedState$1 implements Parcelable$Creator {
            androidx.appcompat.widget.ActionMenuPresenter$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg1) {
                return new SavedState(arg1);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        public int openSubMenuId;

        static {
            SavedState.CREATOR = new androidx.appcompat.widget.ActionMenuPresenter$SavedState$1();
        }

        SavedState() {
            super();
        }

        SavedState(Parcel arg1) {
            super();
            this.openSubMenuId = arg1.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            arg1.writeInt(this.openSubMenuId);
        }
    }

    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    OverflowMenuButton mOverflowButton;
    OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback;
    OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public ActionMenuPresenter(Context arg3) {
        super(arg3, layout.abc_action_menu_layout, layout.abc_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback(this);
    }

    static MenuBuilder access$000(ActionMenuPresenter arg0) {
        return arg0.mMenu;
    }

    static MenuBuilder access$100(ActionMenuPresenter arg0) {
        return arg0.mMenu;
    }

    static MenuView access$200(ActionMenuPresenter arg0) {
        return arg0.mMenuView;
    }

    static MenuBuilder access$300(ActionMenuPresenter arg0) {
        return arg0.mMenu;
    }

    static MenuBuilder access$400(ActionMenuPresenter arg0) {
        return arg0.mMenu;
    }

    static MenuBuilder access$500(ActionMenuPresenter arg0) {
        return arg0.mMenu;
    }

    static MenuView access$600(ActionMenuPresenter arg0) {
        return arg0.mMenuView;
    }

    public void bindItemView(MenuItemImpl arg2, ItemView arg3) {
        arg3.initialize(arg2, 0);
        ((ActionMenuItemView)arg3).setItemInvoker(this.mMenuView);
        ActionMenuPopupCallback v2 = this.mPopupCallback;
        if(v2 == null) {
            v2 = new ActionMenuPopupCallback(this);
            this.mPopupCallback = v2;
        }

        ((ActionMenuItemView)arg3).setPopupCallback(((PopupCallback)v2));
    }

    public boolean dismissPopupMenus() {
        return this.hideSubMenus() | this.hideOverflowMenu();
    }

    public boolean filterLeftoverView(ViewGroup arg3, int arg4) {
        if(arg3.getChildAt(arg4) == this.mOverflowButton) {
            return 0;
        }

        return super.filterLeftoverView(arg3, arg4);
    }

    private View findViewForItem(MenuItem arg6) {
        MenuView v5 = this.mMenuView;
        View v0 = null;
        if(v5 == null) {
            return v0;
        }

        int v1 = ((ViewGroup)v5).getChildCount();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            View v3 = ((ViewGroup)v5).getChildAt(v2);
            if(((v3 instanceof ItemView)) && v3.getItemData() == arg6) {
                return v3;
            }
        }

        return v0;
    }

    public boolean flagActionItems() {
        boolean v0_2;
        int v17;
        int v0_1;
        int v2_1;
        int v4;
        ArrayList v1;
        ActionMenuPresenter v0 = this;
        View v2 = null;
        int v3 = 0;
        if(v0.mMenu != null) {
            v1 = v0.mMenu.getVisibleItems();
            v4 = v1.size();
        }
        else {
            v1 = ((ArrayList)v2);
            v4 = 0;
        }

        int v5 = v0.mMaxItems;
        int v6 = v0.mActionItemWidthLimit;
        int v7 = View$MeasureSpec.makeMeasureSpec(0, 0);
        MenuView v8 = v0.mMenuView;
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        int v12 = 0;
        while(v9 < v4) {
            Object v14 = v1.get(v9);
            if(((MenuItemImpl)v14).requiresActionButton()) {
                ++v11;
            }
            else if(((MenuItemImpl)v14).requestsActionButton()) {
                ++v12;
            }
            else {
                v10 = 1;
            }

            if((v0.mExpandedActionViewsExclusive) && (((MenuItemImpl)v14).isActionViewExpanded())) {
                v5 = 0;
            }

            ++v9;
        }

        if((v0.mReserveOverflow) && (v10 != 0 || v12 + v11 > v5)) {
            --v5;
        }

        v5 -= v11;
        SparseBooleanArray v9_1 = v0.mActionButtonGroups;
        v9_1.clear();
        if(v0.mStrictWidthLimit) {
            v11 = v6 / v0.mMinCellSize;
            v10 = v0.mMinCellSize + v6 % v0.mMinCellSize / v11;
        }
        else {
            v10 = 0;
            v11 = 0;
        }

        v12 = 0;
        int v14_1 = 0;
        while(v12 < v4) {
            Object v15 = v1.get(v12);
            if(((MenuItemImpl)v15).requiresActionButton()) {
                View v13 = v0.getItemView(((MenuItemImpl)v15), v2, ((ViewGroup)v8));
                if(v0.mStrictWidthLimit) {
                    v11 -= ActionMenuView.measureChildForCells(v13, v10, v11, v7, v3);
                }
                else {
                    v13.measure(v7, v7);
                }

                v2_1 = v13.getMeasuredWidth();
                v6 -= v2_1;
                if(v14_1 == 0) {
                    v14_1 = v2_1;
                }

                v2_1 = ((MenuItemImpl)v15).getGroupId();
                if(v2_1 != 0) {
                    v9_1.put(v2_1, true);
                }

                ((MenuItemImpl)v15).setIsActionButton(true);
                v0_1 = v3;
                v17 = v4;
            }
            else {
                if(((MenuItemImpl)v15).requestsActionButton()) {
                    v2_1 = ((MenuItemImpl)v15).getGroupId();
                    boolean v13_1 = v9_1.get(v2_1);
                    if(v5 <= 0 && !v13_1) {
                        goto label_93;
                    }
                    else if(v6 > 0) {
                        if((v0.mStrictWidthLimit) && v11 <= 0) {
                            goto label_93;
                        }

                        v3 = 1;
                    }
                    else {
                    label_93:
                        v3 = 0;
                    }

                    int v18 = v3;
                    v17 = v4;
                    if(v3 != 0) {
                        View v4_1 = v0.getItemView(((MenuItemImpl)v15), null, ((ViewGroup)v8));
                        if(v0.mStrictWidthLimit) {
                            int v19 = ActionMenuView.measureChildForCells(v4_1, v10, v11, v7, 0);
                            v11 -= v19;
                            if(v19 == 0) {
                                v18 = 0;
                            }
                        }
                        else {
                            v4_1.measure(v7, v7);
                        }

                        v3 = v18;
                        v4 = v4_1.getMeasuredWidth();
                        v6 -= v4;
                        if(v14_1 == 0) {
                            v14_1 = v4;
                        }

                        if(v0.mStrictWidthLimit) {
                            if(v6 >= 0) {
                                goto label_119;
                            }
                            else {
                                goto label_121;
                            }
                        }
                        else if(v6 + v14_1 > 0) {
                        label_119:
                            v4 = 1;
                        }
                        else {
                        label_121:
                            v4 = 0;
                        }

                        v3 &= v4;
                    }

                    if(v3 != 0 && v2_1 != 0) {
                        v9_1.put(v2_1, true);
                    }
                    else if(v13_1) {
                        v9_1.put(v2_1, false);
                        for(v4 = 0; v4 < v12; ++v4) {
                            Object v13_2 = v1.get(v4);
                            if(((MenuItemImpl)v13_2).getGroupId() == v2_1) {
                                if(((MenuItemImpl)v13_2).isActionButton()) {
                                    ++v5;
                                }

                                ((MenuItemImpl)v13_2).setIsActionButton(false);
                            }
                        }
                    }

                    if(v3 != 0) {
                        --v5;
                    }

                    ((MenuItemImpl)v15).setIsActionButton(((boolean)v3));
                    v0_1 = 0;
                    goto label_152;
                }

                v0_2 = ((boolean)v3);
                v17 = v4;
                ((MenuItemImpl)v15).setIsActionButton(v0_2);
            }

        label_152:
            ++v12;
            v3 = ((int)v0_2);
            v4 = v17;
            v2 = null;
            v0 = this;
        }

        return 1;
    }

    public View getItemView(MenuItemImpl arg3, View arg4, ViewGroup arg5) {
        View v0 = arg3.getActionView();
        if(v0 == null || (arg3.hasCollapsibleActionView())) {
            v0 = super.getItemView(arg3, arg4, arg5);
        }

        int v2 = arg3.isActionViewExpanded() ? 8 : 0;
        v0.setVisibility(v2);
        ViewGroup$LayoutParams v2_1 = v0.getLayoutParams();
        if(!((ActionMenuView)arg5).checkLayoutParams(v2_1)) {
            v0.setLayoutParams(((ActionMenuView)arg5).generateLayoutParams(v2_1));
        }

        return v0;
    }

    public MenuView getMenuView(ViewGroup arg2) {
        MenuView v0 = this.mMenuView;
        MenuView v2 = super.getMenuView(arg2);
        if(v0 != v2) {
            v2.setPresenter(this);
        }

        return v2;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton v0 = this.mOverflowButton;
        if(v0 != null) {
            return v0.getDrawable();
        }

        if(this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }

        return null;
    }

    public boolean hideOverflowMenu() {
        if(this.mPostedOpenRunnable != null && this.mMenuView != null) {
            this.mMenuView.removeCallbacks(this.mPostedOpenRunnable);
            this.mPostedOpenRunnable = null;
            return 1;
        }

        OverflowPopup v3 = this.mOverflowPopup;
        if(v3 != null) {
            ((MenuPopupHelper)v3).dismiss();
            return 1;
        }

        return 0;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu v0 = this.mActionButtonPopup;
        if(v0 != null) {
            v0.dismiss();
            return 1;
        }

        return 0;
    }

    public void initForMenu(Context arg5, MenuBuilder arg6) {
        super.initForMenu(arg5, arg6);
        Resources v6 = arg5.getResources();
        ActionBarPolicy v5 = ActionBarPolicy.get(arg5);
        if(!this.mReserveOverflowSet) {
            this.mReserveOverflow = v5.showsOverflowMenuButton();
        }

        if(!this.mWidthLimitSet) {
            this.mWidthLimit = v5.getEmbeddedMenuWidthLimit();
        }

        if(!this.mMaxItemsSet) {
            this.mMaxItems = v5.getMaxActionButtons();
        }

        int v5_1 = this.mWidthLimit;
        Drawable v1 = null;
        if(this.mReserveOverflow) {
            if(this.mOverflowButton == null) {
                OverflowMenuButton v0 = new OverflowMenuButton(this, this.mSystemContext);
                this.mOverflowButton = v0;
                if(this.mPendingOverflowIconSet) {
                    v0.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = v1;
                    this.mPendingOverflowIconSet = false;
                }

                int v0_1 = View$MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(v0_1, v0_1);
            }

            v5_1 -= this.mOverflowButton.getMeasuredWidth();
        }
        else {
            this.mOverflowButton = ((OverflowMenuButton)v1);
        }

        this.mActionItemWidthLimit = v5_1;
        this.mMinCellSize = ((int)(v6.getDisplayMetrics().density * 56f));
    }

    public boolean isOverflowMenuShowPending() {
        if(this.mPostedOpenRunnable == null) {
            if(this.isOverflowMenuShowing()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup v0 = this.mOverflowPopup;
        if(v0 != null && (v0.isShowing())) {
            return 1;
        }

        return 0;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onCloseMenu(MenuBuilder arg1, boolean arg2) {
        this.dismissPopupMenus();
        super.onCloseMenu(arg1, arg2);
    }

    public void onConfigurationChanged(Configuration arg1) {
        if(!this.mMaxItemsSet) {
            this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        }

        if(this.mMenu != null) {
            this.mMenu.onItemsChanged(true);
        }
    }

    public void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
        }
        else if(((SavedState)arg2).openSubMenuId > 0) {
            MenuItem v2 = this.mMenu.findItem(((SavedState)arg2).openSubMenuId);
            if(v2 != null) {
                this.onSubMenuSelected(v2.getSubMenu());
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState v0 = new SavedState();
        v0.openSubMenuId = this.mOpenSubMenuId;
        return ((Parcelable)v0);
    }

    public boolean onSubMenuSelected(SubMenuBuilder arg8) {
        boolean v1 = false;
        if(!arg8.hasVisibleItems()) {
            return 0;
        }

        SubMenuBuilder v0 = arg8;
        while(v0.getParentMenu() != this.mMenu) {
            Menu v0_1 = v0.getParentMenu();
        }

        View v0_2 = this.findViewForItem(v0.getItem());
        if(v0_2 == null) {
            return 0;
        }

        this.mOpenSubMenuId = arg8.getItem().getItemId();
        int v2 = arg8.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            MenuItem v5 = arg8.getItem(v3);
            if((v5.isVisible()) && v5.getIcon() != null) {
                v1 = true;
                break;
            }
        }

        ActionButtonSubmenu v2_1 = new ActionButtonSubmenu(this, this.mContext, arg8, v0_2);
        this.mActionButtonPopup = v2_1;
        v2_1.setForceShowIcon(v1);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(arg8);
        return 1;
    }

    public void onSubUiVisibilityChanged(boolean arg1) {
        if(arg1) {
            super.onSubMenuSelected(null);
            return;
        }

        if(this.mMenu != null) {
            this.mMenu.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean arg1) {
        this.mExpandedActionViewsExclusive = arg1;
    }

    public void setItemLimit(int arg1) {
        this.mMaxItems = arg1;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView arg1) {
        this.mMenuView = ((MenuView)arg1);
        arg1.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable arg2) {
        OverflowMenuButton v0 = this.mOverflowButton;
        if(v0 != null) {
            v0.setImageDrawable(arg2);
            return;
        }

        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = arg2;
    }

    public void setReserveOverflow(boolean arg1) {
        this.mReserveOverflow = arg1;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int arg1, boolean arg2) {
        this.mWidthLimit = arg1;
        this.mStrictWidthLimit = arg2;
        this.mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int arg1, MenuItemImpl arg2) {
        return arg2.isActionButton();
    }

    public boolean showOverflowMenu() {
        if((this.mReserveOverflow) && !this.isOverflowMenuShowing() && this.mMenu != null && this.mMenuView != null && this.mPostedOpenRunnable == null && !this.mMenu.getNonActionItems().isEmpty()) {
            this.mPostedOpenRunnable = new OpenOverflowRunnable(this, new OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
            this.mMenuView.post(this.mPostedOpenRunnable);
            return 1;
        }

        return 0;
    }

    public void updateMenuView(boolean arg5) {
        int v1;
        ArrayList v5;
        super.updateMenuView(arg5);
        this.mMenuView.requestLayout();
        int v0 = 0;
        if(this.mMenu != null) {
            v5 = this.mMenu.getActionItems();
            v1 = v5.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                ActionProvider v3 = v5.get(v2).getSupportActionProvider();
                if(v3 != null) {
                    v3.setSubUiVisibilityListener(((SubUiVisibilityListener)this));
                }
            }
        }

        v5 = this.mMenu != null ? this.mMenu.getNonActionItems() : null;
        if((this.mReserveOverflow) && v5 != null) {
            v1 = v5.size();
            if(v1 == 1) {
                v0 = v5.get(0).isActionViewExpanded() ^ 1;
            }
            else if(v1 > 0) {
                v0 = 1;
            }
        }

        OverflowMenuButton v5_1 = this.mOverflowButton;
        if(v0 != 0) {
            if(v5_1 == null) {
                v5_1 = new OverflowMenuButton(this, this.mSystemContext);
                this.mOverflowButton = v5_1;
            }

            ViewParent v5_2 = v5_1.getParent();
            if(v5_2 == this.mMenuView) {
                goto label_60;
            }

            if(v5_2 != null) {
                ((ViewGroup)v5_2).removeView(this.mOverflowButton);
            }

            this.mMenuView.addView(this.mOverflowButton, this.mMenuView.generateOverflowButtonLayoutParams());
        }
        else {
            if(v5_1 == null) {
                goto label_60;
            }

            if(v5_1.getParent() != this.mMenuView) {
                goto label_60;
            }

            this.mMenuView.removeView(this.mOverflowButton);
        }

    label_60:
        this.mMenuView.setOverflowReserved(this.mReserveOverflow);
    }
}

