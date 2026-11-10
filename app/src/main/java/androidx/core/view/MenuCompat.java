package androidx.core.view;

import android.os.Build$VERSION;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.ReplaceWith;
import androidx.core.internal.view.SupportMenu;

public final class MenuCompat {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static void setGroupDividerEnabled(Menu arg0, boolean arg1) {
            arg0.setGroupDividerEnabled(arg1);
        }
    }

    private MenuCompat() {
        super();
    }

    public static void setGroupDividerEnabled(Menu arg2, boolean arg3) {
        if((arg2 instanceof SupportMenu)) {
            ((SupportMenu)arg2).setGroupDividerEnabled(arg3);
            return;
        }

        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.setGroupDividerEnabled(arg2, arg3);
        }
    }

    @ReplaceWith(expression="item.setShowAsAction(actionEnum)") @Deprecated public static void setShowAsAction(MenuItem arg0, int arg1) {
        arg0.setShowAsAction(arg1);
    }
}

