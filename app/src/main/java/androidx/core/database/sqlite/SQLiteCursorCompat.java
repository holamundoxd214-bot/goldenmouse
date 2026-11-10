package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build$VERSION;

public final class SQLiteCursorCompat {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static void setFillWindowForwardOnly(SQLiteCursor arg0, boolean arg1) {
            arg0.setFillWindowForwardOnly(arg1);
        }
    }

    private SQLiteCursorCompat() {
        super();
    }

    public static void setFillWindowForwardOnly(SQLiteCursor arg2, boolean arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.setFillWindowForwardOnly(arg2, arg3);
        }
    }
}

