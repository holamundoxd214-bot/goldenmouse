package androidx.core.app;

import android.app.Dialog;
import android.os.Build$VERSION;
import android.view.View;

public class DialogCompat {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Object requireViewById(Dialog arg0, int arg1) {
            return arg0.requireViewById(arg1);
        }
    }

    private DialogCompat() {
        super();
    }

    public static View requireViewById(Dialog arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.requireViewById(arg2, arg3);
        }

        View v2 = arg2.findViewById(arg3);
        if(v2 != null) {
            return v2;
        }

        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    }
}

