package androidx.core.widget;

import android.view.View$OnTouchListener;
import android.view.View;
import android.widget.ListPopupWindow;
import androidx.annotation.ReplaceWith;

public final class ListPopupWindowCompat {
    private ListPopupWindowCompat() {
        super();
    }

    @ReplaceWith(expression="listPopupWindow.createDragToOpenListener(src)") @Deprecated public static View$OnTouchListener createDragToOpenListener(ListPopupWindow arg0, View arg1) {
        return arg0.createDragToOpenListener(arg1);
    }

    @Deprecated public static View$OnTouchListener createDragToOpenListener(Object arg0, View arg1) {
        return ListPopupWindowCompat.createDragToOpenListener(((ListPopupWindow)arg0), arg1);
    }
}

