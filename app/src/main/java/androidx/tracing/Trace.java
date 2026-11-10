package androidx.tracing;

import android.os.Build$VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {
    static final int MAX_TRACE_LABEL_LENGTH = 0x7F;
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static boolean sHasAppTracingEnabled;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private Trace() {
        super();
    }

    public static void beginAsyncSection(String arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            TraceApi29Impl.beginAsyncSection(Trace.truncatedTraceSectionLabel(arg2), arg3);
            return;
        }

        Trace.beginAsyncSectionFallback(Trace.truncatedTraceSectionLabel(arg2), arg3);
    }

    private static void beginAsyncSectionFallback(String arg5, int arg6) {
        String v0 = "asyncTraceBegin";
        try {
            Method v1 = Trace.sAsyncTraceBeginMethod;
            if(v1 == null) {
                v1 = android.os.Trace.class.getMethod(v0, Long.TYPE, String.class, Integer.TYPE);
                Trace.sAsyncTraceBeginMethod = v1;
            }

            v1.invoke(null, Long.valueOf(Trace.sTraceTagApp), arg5, Integer.valueOf(arg6));
            return;
        }
        catch(Exception v5) {
            Trace.handleException(v0, v5);
            return;
        }
    }

    public static void beginSection(String arg0) {
        TraceApi18Impl.beginSection(Trace.truncatedTraceSectionLabel(arg0));
    }

    public static void endAsyncSection(String arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            TraceApi29Impl.endAsyncSection(Trace.truncatedTraceSectionLabel(arg2), arg3);
            return;
        }

        Trace.endAsyncSectionFallback(Trace.truncatedTraceSectionLabel(arg2), arg3);
    }

    private static void endAsyncSectionFallback(String arg5, int arg6) {
        String v0 = "asyncTraceEnd";
        try {
            Method v1 = Trace.sAsyncTraceEndMethod;
            if(v1 == null) {
                v1 = android.os.Trace.class.getMethod(v0, Long.TYPE, String.class, Integer.TYPE);
                Trace.sAsyncTraceEndMethod = v1;
            }

            v1.invoke(null, Long.valueOf(Trace.sTraceTagApp), arg5, Integer.valueOf(arg6));
            return;
        }
        catch(Exception v5) {
            Trace.handleException(v0, v5);
            return;
        }
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    public static void forceEnableAppTracing() {
        String v0 = "setAppTracingAllowed";
        if(Build$VERSION.SDK_INT < 0x1F) {
            try {
                if(Trace.sHasAppTracingEnabled) {
                    return;
                }

                Trace.sHasAppTracingEnabled = true;
                android.os.Trace.class.getMethod(v0, Boolean.TYPE).invoke(null, Boolean.valueOf(true));
                return;
            }
            catch(Exception v1) {
                Trace.handleException(v0, v1);
            }
        }
    }

    private static void handleException(String arg2, Exception arg3) {
        if((arg3 instanceof InvocationTargetException)) {
            Throwable v2 = arg3.getCause();
            if((v2 instanceof RuntimeException)) {
                throw v2;
            }

            throw new RuntimeException(v2);
        }

        Log.v("Trace", "Unable to call " + arg2 + " via reflection", ((Throwable)arg3));
    }

    public static boolean isEnabled() {
        if(Build$VERSION.SDK_INT >= 29) {
            return TraceApi29Impl.isEnabled();
        }

        return Trace.isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        boolean v0_1;
        String v0 = "isTagEnabled";
        try {
            Method v2_1 = Trace.sIsTagEnabledMethod;
            Object v3 = null;
            if(v2_1 == null) {
                Class v2_2 = android.os.Trace.class;
                Trace.sTraceTagApp = v2_2.getField("TRACE_TAG_APP").getLong(v3);
                v2_1 = v2_2.getMethod(v0, Long.TYPE);
                Trace.sIsTagEnabledMethod = v2_1;
            }

            v0_1 = v2_1.invoke(v3, Long.valueOf(Trace.sTraceTagApp)).booleanValue();
            return v0_1;
        }
        catch(Exception v2) {
            Trace.handleException(((String)v0_1), v2);
            return 0;
        }
    }

    public static void setCounter(String arg2, int arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            TraceApi29Impl.setCounter(Trace.truncatedTraceSectionLabel(arg2), arg3);
            return;
        }

        Trace.setCounterFallback(Trace.truncatedTraceSectionLabel(arg2), arg3);
    }

    private static void setCounterFallback(String arg5, int arg6) {
        String v0 = "traceCounter";
        try {
            Method v1 = Trace.sTraceCounterMethod;
            if(v1 == null) {
                v1 = android.os.Trace.class.getMethod(v0, Long.TYPE, String.class, Integer.TYPE);
                Trace.sTraceCounterMethod = v1;
            }

            v1.invoke(null, Long.valueOf(Trace.sTraceTagApp), arg5, Integer.valueOf(arg6));
            return;
        }
        catch(Exception v5) {
            Trace.handleException(v0, v5);
            return;
        }
    }

    private static String truncatedTraceSectionLabel(String arg2) {
        int v1 = 0x7F;
        if(arg2.length() <= v1) {
            return arg2;
        }

        return arg2.substring(0, v1);
    }
}

