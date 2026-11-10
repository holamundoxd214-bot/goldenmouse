package androidx.core.os;

import android.os.Build$VERSION;

public final class BuildCompat$$ExternalSyntheticBackportWithForwarding0 {
    public static int m() {
        if(Build$VERSION.SDK_INT < 36) {
            return Build$VERSION.SDK_INT * 100000;
        }

        return Build$VERSION.SDK_INT_FULL;
    }
}

