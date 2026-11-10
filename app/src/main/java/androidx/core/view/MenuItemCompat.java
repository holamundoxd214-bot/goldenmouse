package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.util.Log;
import android.view.MenuItem$OnActionExpandListener;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.ReplaceWith;
import androidx.core.internal.view.SupportMenuItem;

public final class MenuItemCompat {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static int getAlphabeticModifiers(MenuItem arg0) {
            return arg0.getAlphabeticModifiers();
        }

        static CharSequence getContentDescription(MenuItem arg0) {
            return arg0.getContentDescription();
        }

        static ColorStateList getIconTintList(MenuItem arg0) {
            return arg0.getIconTintList();
        }

        static PorterDuff$Mode getIconTintMode(MenuItem arg0) {
            return arg0.getIconTintMode();
        }

        static int getNumericModifiers(MenuItem arg0) {
            return arg0.getNumericModifiers();
        }

        static CharSequence getTooltipText(MenuItem arg0) {
            return arg0.getTooltipText();
        }

        static MenuItem setAlphabeticShortcut(MenuItem arg0, char arg1, int arg2) {
            return arg0.setAlphabeticShortcut(arg1, arg2);
        }

        static MenuItem setContentDescription(MenuItem arg0, CharSequence arg1) {
            return arg0.setContentDescription(arg1);
        }

        static MenuItem setIconTintList(MenuItem arg0, ColorStateList arg1) {
            return arg0.setIconTintList(arg1);
        }

        static MenuItem setIconTintMode(MenuItem arg0, PorterDuff$Mode arg1) {
            return arg0.setIconTintMode(arg1);
        }

        static MenuItem setNumericShortcut(MenuItem arg0, char arg1, int arg2) {
            return arg0.setNumericShortcut(arg1, arg2);
        }

        static MenuItem setShortcut(MenuItem arg0, char arg1, char arg2, int arg3, int arg4) {
            return arg0.setShortcut(arg1, arg2, arg3, arg4);
        }

        static MenuItem setTooltipText(MenuItem arg0, CharSequence arg1) {
            return arg0.setTooltipText(arg1);
        }
    }

    @Deprecated public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem arg1);

        boolean onMenuItemActionExpand(MenuItem arg1);
    }

    @Deprecated public static final int SHOW_AS_ACTION_ALWAYS = 2;
    @Deprecated public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    @Deprecated public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    @Deprecated public static final int SHOW_AS_ACTION_NEVER = 0;
    @Deprecated public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    private MenuItemCompat() {
        super();
    }

    @ReplaceWith(expression="item.collapseActionView()") @Deprecated public static boolean collapseActionView(MenuItem arg0) {
        return arg0.collapseActionView();
    }

    @ReplaceWith(expression="item.expandActionView()") @Deprecated public static boolean expandActionView(MenuItem arg0) {
        return arg0.expandActionView();
    }

    public static ActionProvider getActionProvider(MenuItem arg1) {
        if((arg1 instanceof SupportMenuItem)) {
            return ((SupportMenuItem)arg1).getSupportActionProvider();
        }

        Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @ReplaceWith(expression="item.getActionView()") @Deprecated public static View getActionView(MenuItem arg0) {
        return arg0.getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem arg1) {
        if((arg1 instanceof SupportMenuItem)) {
            return ((SupportMenuItem)arg1).getAlphabeticModifiers();
        }

        return Api26Impl.getAlphabeticModifiers(arg1);
    }

    public static CharSequence getContentDescription(MenuItem arg1) {
        if((arg1 instanceof SupportMenuItem)) {
            return ((SupportMenuItem)arg1).getContentDescription();
        }

        return Api26Impl.getContentDescription(arg1);
    }

    public static ColorStateList getIconTintList(MenuItem arg1) {
        if((arg1 instanceof SupportMenuItem)) {
            return ((SupportMenuItem)arg1).getIconTintList();
        }

        return Api26Impl.getIconTintList(arg1);
    }

    public static PorterDuff$Mode getIconTintMode(MenuItem arg1) {
        if((arg1 instanceof SupportMenuItem)) {
            return ((SupportMenuItem)arg1).getIconTintMode();
        }

        return Api26Impl.getIconTintMode(arg1);
    }

    public static int getNumericModifiers(MenuItem arg1) {
        if((arg1 instanceof SupportMenuItem)) {
            return ((SupportMenuItem)arg1).getNumericModifiers();
        }

        return Api26Impl.getNumericModifiers(arg1);
    }

    public static CharSequence getTooltipText(MenuItem arg1) {
        if((arg1 instanceof SupportMenuItem)) {
            return ((SupportMenuItem)arg1).getTooltipText();
        }

        return Api26Impl.getTooltipText(arg1);
    }

    @ReplaceWith(expression="item.isActionViewExpanded()") @Deprecated public static boolean isActionViewExpanded(MenuItem arg0) {
        return arg0.isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem arg1, ActionProvider arg2) {
        if((arg1 instanceof SupportMenuItem)) {
            return ((SupportMenuItem)arg1).setSupportActionProvider(arg2);
        }

        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return arg1;
    }

    @ReplaceWith(expression="item.setActionView(resId)") @Deprecated public static MenuItem setActionView(MenuItem arg0, int arg1) {
        return arg0.setActionView(arg1);
    }

    @ReplaceWith(expression="item.setActionView(view)") @Deprecated public static MenuItem setActionView(MenuItem arg0, View arg1) {
        return arg0.setActionView(arg1);
    }

    public static void setAlphabeticShortcut(MenuItem arg1, char arg2, int arg3) {
        if((arg1 instanceof SupportMenuItem)) {
            ((SupportMenuItem)arg1).setAlphabeticShortcut(arg2, arg3);
            return;
        }

        Api26Impl.setAlphabeticShortcut(arg1, arg2, arg3);
    }

    public static void setContentDescription(MenuItem arg1, CharSequence arg2) {
        if((arg1 instanceof SupportMenuItem)) {
            ((SupportMenuItem)arg1).setContentDescription(arg2);
            return;
        }

        Api26Impl.setContentDescription(arg1, arg2);
    }

    public static void setIconTintList(MenuItem arg1, ColorStateList arg2) {
        if((arg1 instanceof SupportMenuItem)) {
            ((SupportMenuItem)arg1).setIconTintList(arg2);
            return;
        }

        Api26Impl.setIconTintList(arg1, arg2);
    }

    public static void setIconTintMode(MenuItem arg1, PorterDuff$Mode arg2) {
        if((arg1 instanceof SupportMenuItem)) {
            ((SupportMenuItem)arg1).setIconTintMode(arg2);
            return;
        }

        Api26Impl.setIconTintMode(arg1, arg2);
    }

    public static void setNumericShortcut(MenuItem arg1, char arg2, int arg3) {
        if((arg1 instanceof SupportMenuItem)) {
            ((SupportMenuItem)arg1).setNumericShortcut(arg2, arg3);
            return;
        }

        Api26Impl.setNumericShortcut(arg1, arg2, arg3);
    }

    @Deprecated public static MenuItem setOnActionExpandListener(MenuItem arg1, OnActionExpandListener arg2) {
        return arg1.setOnActionExpandListener(new MenuItem$OnActionExpandListener(arg2) {
            public boolean onMenuItemActionCollapse(MenuItem arg1) {
                return this.val$listener.onMenuItemActionCollapse(arg1);
            }

            public boolean onMenuItemActionExpand(MenuItem arg1) {
                return this.val$listener.onMenuItemActionExpand(arg1);
            }
        });
    }

    public static void setShortcut(MenuItem arg1, char arg2, char arg3, int arg4, int arg5) {
        if((arg1 instanceof SupportMenuItem)) {
            ((SupportMenuItem)arg1).setShortcut(arg2, arg3, arg4, arg5);
            return;
        }

        Api26Impl.setShortcut(arg1, arg2, arg3, arg4, arg5);
    }

    @ReplaceWith(expression="item.setShowAsAction(actionEnum)") @Deprecated public static void setShowAsAction(MenuItem arg0, int arg1) {
        arg0.setShowAsAction(arg1);
    }

    public static void setTooltipText(MenuItem arg1, CharSequence arg2) {
        if((arg1 instanceof SupportMenuItem)) {
            ((SupportMenuItem)arg1).setTooltipText(arg2);
            return;
        }

        Api26Impl.setTooltipText(arg1, arg2);
    }
}

