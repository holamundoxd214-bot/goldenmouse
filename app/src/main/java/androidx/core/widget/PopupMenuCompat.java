package androidx.core.widget;

import android.view.View$OnTouchListener;
import android.widget.PopupMenu;

public final class PopupMenuCompat {
    private PopupMenuCompat() {
        super();
    }

    public static View$OnTouchListener getDragToOpenListener(Object arg0) {
        return ((PopupMenu)arg0).getDragToOpenListener();
    }
}

