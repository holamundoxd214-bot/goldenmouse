package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.ReplaceWith;

@Deprecated public final class ListViewCompat {
    private ListViewCompat() {
        super();
    }

    @ReplaceWith(expression="listView.canScrollList(direction)") @Deprecated public static boolean canScrollList(ListView arg0, int arg1) {
        return arg0.canScrollList(arg1);
    }

    @ReplaceWith(expression="listView.scrollListBy(y)") @Deprecated public static void scrollListBy(ListView arg0, int arg1) {
        arg0.scrollListBy(arg1);
    }
}

