package androidx.core.os;

import android.os.Build$VERSION;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

@Deprecated public final class TraceCompat {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void beginAsyncSection(String arg0, int arg1) {
            Trace.beginAsyncSection(arg0, arg1);
        }

        static void endAsyncSection(String arg0, int arg1) {
            Trace.endAsyncSection(arg0, arg1);
        }

        static boolean isEnabled() {
            return Trace.isEnabled();
        }

        static void setCounter(String arg0, long arg1) {
            Trace.setCounter(arg0, arg1);
        }
    }

    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        if(Build$VERSION.SDK_INT < 29) {
            try {
                Class v0_1 = Trace.class;
                TraceCompat.sTraceTagApp = v0_1.getField("TRACE_TAG_APP").getLong(null);
                TraceCompat.sIsTagEnabledMethod = v0_1.getMethod("isTagEnabled", Long.TYPE);
                Class[] v4 = new Class[3];
                v4[0] = Long.TYPE;
                Class v6 = String.class;
                v4[1] = v6;
                v4[2] = Integer.TYPE;
                TraceCompat.sAsyncTraceBeginMethod = v0_1.getMethod("asyncTraceBegin", v4);
                TraceCompat.sAsyncTraceEndMethod = v0_1.getMethod("asyncTraceEnd", Long.TYPE, v6, Integer.TYPE);
                TraceCompat.sTraceCounterMethod = v0_1.getMethod("traceCounter", Long.TYPE, v6, Integer.TYPE);
                return;
            }
            catch(Exception v0) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", ((Throwable)v0));
            }
        }
    }

    private TraceCompat() {
        super();
    }

    public static void beginAsyncSection(String arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.beginAsyncSection(arg3, arg4);
            return;
        }

        try {
            TraceCompat.sAsyncTraceBeginMethod.invoke(null, Long.valueOf(TraceCompat.sTraceTagApp), arg3, Integer.valueOf(arg4));
            return;
        }
        catch(Exception ) {
            Log.v("TraceCompat", "Unable to invoke asyncTraceBegin() via reflection.");
            return;
        }
    }

    public static void beginSection(String arg0) {
        Trace.beginSection(arg0);
    }

    public static void endAsyncSection(String arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.endAsyncSection(arg3, arg4);
            return;
        }

        try {
            TraceCompat.sAsyncTraceEndMethod.invoke(null, Long.valueOf(TraceCompat.sTraceTagApp), arg3, Integer.valueOf(arg4));
            return;
        }
        catch(Exception ) {
            Log.v("TraceCompat", "Unable to invoke endAsyncSection() via reflection.");
            return;
        }
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static boolean isEnabled() {
        if(Build$VERSION.SDK_INT >= 29) {
            return Api29Impl.isEnabled();
        }

        try {
            return TraceCompat.sIsTagEnabledMethod.invoke(null, Long.valueOf(TraceCompat.sTraceTagApp)).booleanValue();
        }
        catch(Exception ) {
            Log.v("TraceCompat", "Unable to invoke isTagEnabled() via reflection.");
            return 0;
        }
    }

    public static void setCounter(String arg3, int arg4) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.setCounter(arg3, ((long)arg4));
            return;
        }

        try {
            TraceCompat.sTraceCounterMethod.invoke(null, Long.valueOf(TraceCompat.sTraceTagApp), arg3, Integer.valueOf(arg4));
            return;
        }
        catch(Exception ) {
            Log.v("TraceCompat", "Unable to invoke traceCounter() via reflection.");
            return;
        }
    }
}

