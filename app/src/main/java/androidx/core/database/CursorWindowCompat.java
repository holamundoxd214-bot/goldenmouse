package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build$VERSION;

public final class CursorWindowCompat {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static CursorWindow createCursorWindow(String arg1, long arg2) {
            return new CursorWindow(arg1, arg2);
        }
    }

    private CursorWindowCompat() {
        super();
    }

    public static CursorWindow create(String arg2, long arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.createCursorWindow(arg2, arg3);
        }

        return new CursorWindow(arg2);
    }
}

