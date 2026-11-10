package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToolbarUtils {
    class com.google.android.material.internal.ToolbarUtils$1 implements Comparator {
        com.google.android.material.internal.ToolbarUtils$1() {
            super();
        }

        public int compare(View arg1, View arg2) {
            return arg1.getTop() - arg2.getTop();
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((View)arg1), ((View)arg2));
        }
    }

    private static final Comparator VIEW_TOP_COMPARATOR;

    static {
        ToolbarUtils.VIEW_TOP_COMPARATOR = new com.google.android.material.internal.ToolbarUtils$1();
    }

    private ToolbarUtils() {
        super();
    }

    public static ActionMenuItemView getActionMenuItemView(Toolbar arg3, int arg4) {
        ActionMenuView v3 = ToolbarUtils.getActionMenuView(arg3);
        if(v3 != null) {
            int v0;
            for(v0 = 0; v0 < v3.getChildCount(); ++v0) {
                View v1 = v3.getChildAt(v0);
                if(((v1 instanceof ActionMenuItemView)) && ((ActionMenuItemView)v1).getItemData().getItemId() == arg4) {
                    return ((ActionMenuItemView)v1);
                }
            }
        }

        return null;
    }

    public static ActionMenuView getActionMenuView(Toolbar arg3) {
        int v0;
        for(v0 = 0; v0 < arg3.getChildCount(); ++v0) {
            View v1 = arg3.getChildAt(v0);
            if((v1 instanceof ActionMenuView)) {
                return ((ActionMenuView)v1);
            }
        }

        return null;
    }

    private static ImageView getImageView(Toolbar arg5, Drawable arg6) {
        ImageView v0 = null;
        if(arg6 == null) {
            return v0;
        }

        int v1;
        for(v1 = 0; v1 < arg5.getChildCount(); ++v1) {
            View v2 = arg5.getChildAt(v1);
            if((v2 instanceof ImageView)) {
                Drawable v3 = ((ImageView)v2).getDrawable();
                if(v3 != null && v3.getConstantState() != null && (v3.getConstantState().equals(arg6.getConstantState()))) {
                    return ((ImageView)v2);
                }
            }
        }

        return v0;
    }

    public static ImageView getLogoImageView(Toolbar arg1) {
        return ToolbarUtils.getImageView(arg1, arg1.getLogo());
    }

    public static ImageButton getNavigationIconButton(Toolbar arg5) {
        Drawable v0 = arg5.getNavigationIcon();
        ImageButton v1 = null;
        if(v0 == null) {
            return v1;
        }

        int v2;
        for(v2 = 0; v2 < arg5.getChildCount(); ++v2) {
            View v3 = arg5.getChildAt(v2);
            if(((v3 instanceof ImageButton)) && ((ImageButton)v3).getDrawable() == v0) {
                return ((ImageButton)v3);
            }
        }

        return v1;
    }

    public static View getSecondaryActionMenuItemView(Toolbar arg2) {
        ActionMenuView v2 = ToolbarUtils.getActionMenuView(arg2);
        if(v2 != null && v2.getChildCount() > 1) {
            return v2.getChildAt(0);
        }

        return null;
    }

    public static TextView getSubtitleTextView(Toolbar arg1) {
        List v1 = ToolbarUtils.getTextViewsWithText(arg1, arg1.getSubtitle());
        if(v1.isEmpty()) {
            return null;
        }

        return Collections.max(((Collection)v1), ToolbarUtils.VIEW_TOP_COMPARATOR);
    }

    private static List getTextViewsWithText(Toolbar arg4, CharSequence arg5) {
        ArrayList v0 = new ArrayList();
        int v1;
        for(v1 = 0; v1 < arg4.getChildCount(); ++v1) {
            View v2 = arg4.getChildAt(v1);
            if(((v2 instanceof TextView)) && (TextUtils.equals(((TextView)v2).getText(), arg5))) {
                ((List)v0).add(v2);
            }
        }

        return ((List)v0);
    }

    public static TextView getTitleTextView(Toolbar arg1) {
        List v1 = ToolbarUtils.getTextViewsWithText(arg1, arg1.getTitle());
        if(v1.isEmpty()) {
            return null;
        }

        return Collections.min(((Collection)v1), ToolbarUtils.VIEW_TOP_COMPARATOR);
    }
}

