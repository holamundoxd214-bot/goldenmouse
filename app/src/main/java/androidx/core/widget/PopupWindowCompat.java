package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.ReplaceWith;

public final class PopupWindowCompat {
    private PopupWindowCompat() {
        super();
    }

    public static boolean getOverlapAnchor(PopupWindow arg0) {
        return arg0.getOverlapAnchor();
    }

    public static int getWindowLayoutType(PopupWindow arg0) {
        return arg0.getWindowLayoutType();
    }

    public static void setOverlapAnchor(PopupWindow arg0, boolean arg1) {
        arg0.setOverlapAnchor(arg1);
    }

    public static void setWindowLayoutType(PopupWindow arg0, int arg1) {
        arg0.setWindowLayoutType(arg1);
    }

    @ReplaceWith(expression="popup.showAsDropDown(anchor, xoff, yoff, gravity)") @Deprecated public static void showAsDropDown(PopupWindow arg0, View arg1, int arg2, int arg3, int arg4) {
        arg0.showAsDropDown(arg1, arg2, arg3, arg4);
    }
}

