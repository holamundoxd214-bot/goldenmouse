package androidx.startup;

import android.util.Log;

public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
        super();
    }

    public static void e(String arg1, Throwable arg2) {
        Log.e("StartupLogger", arg1, arg2);
    }

    public static void i(String arg1) {
        Log.i("StartupLogger", arg1);
    }

    public static void w(String arg1) {
        Log.w("StartupLogger", arg1);
    }
}

