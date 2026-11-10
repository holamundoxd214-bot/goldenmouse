package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.ReplaceWith;

@Deprecated public final class BundleCompat {
    private BundleCompat() {
        super();
    }

    @ReplaceWith(expression="bundle.getBinder(key)") @Deprecated public static IBinder getBinder(Bundle arg0, String arg1) {
        return arg0.getBinder(arg1);
    }

    @ReplaceWith(expression="bundle.putBinder(key, binder)") @Deprecated public static void putBinder(Bundle arg0, String arg1, IBinder arg2) {
        arg0.putBinder(arg1, arg2);
    }
}

