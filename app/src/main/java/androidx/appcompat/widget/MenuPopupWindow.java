package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    class Api23Impl {
        private Api23Impl() {
            super();
        }

        static void setEnterTransition(PopupWindow arg0, Transition arg1) {
            arg0.setEnterTransition(arg1);
        }

        static void setExitTransition(PopupWindow arg0, Transition arg1) {
            arg0.setExitTransition(arg1);
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void setTouchModal(PopupWindow arg0, boolean arg1) {
            arg0.setTouchModal(arg1);
        }
    }

    public class MenuDropDownListView extends DropDownListView {
        class Api17Impl {
            private Api17Impl() {
                super();
            }

            static int getLayoutDirection(Configuration arg0) {
                return arg0.getLayoutDirection();
            }
        }

        final int mAdvanceKey;
        private MenuItemHoverListener mHoverListener;
        private MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        public MenuDropDownListView(Context arg3, boolean arg4) {
            super(arg3, arg4);
            int v0 = 21;
            int v1 = 22;
            if(1 == Api17Impl.getLayoutDirection(arg3.getResources().getConfiguration())) {
                this.mAdvanceKey = v0;
                this.mRetreatKey = v1;
                return;
            }

            this.mAdvanceKey = v1;
            this.mRetreatKey = v0;
        }

        public void clearSelection() {
            this.setSelection(-1);
        }

        public boolean hasFocus() {
            return super.hasFocus();
        }

        public boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public boolean isFocused() {
            return super.isFocused();
        }

        public boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public int lookForSelectablePosition(int arg1, boolean arg2) {
            return super.lookForSelectablePosition(arg1, arg2);
        }

        public int measureHeightOfChildrenCompat(int arg1, int arg2, int arg3, int arg4, int arg5) {
            return super.measureHeightOfChildrenCompat(arg1, arg2, arg3, arg4, arg5);
        }

        public boolean onForwardedEvent(MotionEvent arg1, int arg2) {
            return super.onForwardedEvent(arg1, arg2);
        }

        public boolean onHoverEvent(MotionEvent arg5) {
            MenuItemImpl v1_1;
            int v1;
            if(this.mHoverListener != null) {
                ListAdapter v0 = this.getAdapter();
                if((v0 instanceof HeaderViewListAdapter)) {
                    v1 = ((HeaderViewListAdapter)v0).getHeadersCount();
                    v0 = ((HeaderViewListAdapter)v0).getWrappedAdapter();
                }
                else {
                    v1 = 0;
                }

                if(arg5.getAction() != 10) {
                    int v2 = this.pointToPosition(((int)arg5.getX()), ((int)arg5.getY()));
                    if(v2 != -1) {
                        v2 -= v1;
                        if(v2 < 0) {
                            goto label_25;
                        }
                        else if(v2 < ((MenuAdapter)v0).getCount()) {
                            v1_1 = ((MenuAdapter)v0).getItem(v2);
                        }
                        else {
                            goto label_25;
                        }
                    }
                    else {
                        goto label_25;
                    }
                }
                else {
                label_25:
                    v1_1 = null;
                }

                MenuItem v2_1 = this.mHoveredMenuItem;
                if((((MenuItemImpl)v2_1)) == v1_1) {
                    goto label_36;
                }

                MenuBuilder v0_1 = ((MenuAdapter)v0).getAdapterMenu();
                if(v2_1 != null) {
                    this.mHoverListener.onItemHoverExit(v0_1, v2_1);
                }

                this.mHoveredMenuItem = ((MenuItem)v1_1);
                if(v1_1 == null) {
                    goto label_36;
                }

                this.mHoverListener.onItemHoverEnter(v0_1, ((MenuItem)v1_1));
            }

        label_36:
            return super.onHoverEvent(arg5);
        }

        public boolean onKeyDown(int arg5, KeyEvent arg6) {
            View v0 = this.getSelectedView();
            if(v0 != null && arg5 == this.mAdvanceKey) {
                if((((ListMenuItemView)v0).isEnabled()) && (((ListMenuItemView)v0).getItemData().hasSubMenu())) {
                    this.performItemClick(v0, this.getSelectedItemPosition(), this.getSelectedItemId());
                }

                return 1;
            }

            if(v0 != null && arg5 == this.mRetreatKey) {
                this.setSelection(-1);
                ListAdapter v4 = this.getAdapter();
                if((v4 instanceof HeaderViewListAdapter)) {
                    v4 = ((HeaderViewListAdapter)v4).getWrappedAdapter();
                }

                ((MenuAdapter)v4).getAdapterMenu().close(false);
                return 1;
            }

            return super.onKeyDown(arg5, arg6);
        }

        public boolean onTouchEvent(MotionEvent arg1) {
            return super.onTouchEvent(arg1);
        }

        public void setHoverListener(MenuItemHoverListener arg1) {
            this.mHoverListener = arg1;
        }

        public void setSelector(Drawable arg1) {
            super.setSelector(arg1);
        }
    }

    private static final String TAG = "MenuPopupWindow";
    private MenuItemHoverListener mHoverListener;
    private static Method sSetTouchModalMethod;

    static {
        try {
            if(Build$VERSION.SDK_INT <= 28) {
                MenuPopupWindow.sSetTouchModalMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        }
        catch(NoSuchMethodException ) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
            return;
        }
    }

    public MenuPopupWindow(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    DropDownListView createDropDownListView(Context arg2, boolean arg3) {
        MenuDropDownListView v0 = new MenuDropDownListView(arg2, arg3);
        v0.setHoverListener(((MenuItemHoverListener)this));
        return ((DropDownListView)v0);
    }

    public void onItemHoverEnter(MenuBuilder arg1, MenuItem arg2) {
        MenuItemHoverListener v0 = this.mHoverListener;
        if(v0 != null) {
            v0.onItemHoverEnter(arg1, arg2);
        }
    }

    public void onItemHoverExit(MenuBuilder arg1, MenuItem arg2) {
        MenuItemHoverListener v0 = this.mHoverListener;
        if(v0 != null) {
            v0.onItemHoverExit(arg1, arg2);
        }
    }

    public void setEnterTransition(Object arg1) {
        Api23Impl.setEnterTransition(this.mPopup, ((Transition)arg1));
    }

    public void setExitTransition(Object arg1) {
        Api23Impl.setExitTransition(this.mPopup, ((Transition)arg1));
    }

    public void setHoverListener(MenuItemHoverListener arg1) {
        this.mHoverListener = arg1;
    }

    public void setTouchModal(boolean arg3) {
        if(Build$VERSION.SDK_INT <= 28) {
            Method v0 = MenuPopupWindow.sSetTouchModalMethod;
            if(v0 != null) {
                try {
                    v0.invoke(this.mPopup, Boolean.valueOf(arg3));
                    return;
                }
                catch(Exception ) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }

            return;
        }

        Api29Impl.setTouchModal(this.mPopup, arg3);
    }
}

