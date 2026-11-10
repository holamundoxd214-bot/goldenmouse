package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class Intrinsics {
    public class Kotlin {
        private Kotlin() {
            super();
        }
    }

    private Intrinsics() {
        super();
    }

    public static boolean areEqual(Object arg0, Object arg1) {
        if(arg0 == null) {
            if(arg1 == null) {
                return 1;
            }

            return 0;
        }

        return arg0.equals(arg1);
    }

    public static boolean areEqual(float arg0, Float arg1) {
        if(arg1 != null && arg0 == arg1.floatValue()) {
            return 1;
        }

        return 0;
    }

    public static boolean areEqual(Float arg0, float arg1) {
        if(arg0 != null && arg0.floatValue() == arg1) {
            return 1;
        }

        return 0;
    }

    public static boolean areEqual(double arg2, Double arg4) {
        if(arg4 != null && arg2 == arg4.doubleValue()) {
            return 1;
        }

        return 0;
    }

    public static boolean areEqual(Double arg2, double arg3) {
        if(arg2 != null && arg2.doubleValue() == arg3) {
            return 1;
        }

        return 0;
    }

    public static boolean areEqual(Double arg4, Double arg5) {
        if(arg4 == null) {
            if(arg5 == null) {
                return 1;
            }

            return 0;
        }

        if(arg5 != null && arg4.doubleValue() == arg5.doubleValue()) {
            return 1;
        }

        return 0;
    }

    public static boolean areEqual(Float arg2, Float arg3) {
        if(arg2 == null) {
            if(arg3 == null) {
                return 1;
            }

            return 0;
        }

        if(arg3 != null && arg2.floatValue() == arg3.floatValue()) {
            return 1;
        }

        return 0;
    }

    public static void checkExpressionValueIsNotNull(Object arg1, String arg2) {
        if(arg1 != null) {
            return;
        }

        throw Intrinsics.sanitizeStackTrace(new IllegalStateException(arg2 + " must not be null"));
    }

    public static void checkFieldIsNotNull(Object arg0, String arg1) {
        if(arg0 != null) {
            return;
        }

        throw Intrinsics.sanitizeStackTrace(new IllegalStateException(arg1));
    }

    public static void checkFieldIsNotNull(Object arg2, String arg3, String arg4) {
        if(arg2 != null) {
            return;
        }

        throw Intrinsics.sanitizeStackTrace(new IllegalStateException("Field specified as non-null is null: " + arg3 + "." + arg4));
    }

    public static void checkHasClass(String arg4) throws ClassNotFoundException {
        arg4 = arg4.replace('/', '.');
        try {
            Class.forName(arg4);
            return;
        }
        catch(ClassNotFoundException v0) {
            throw Intrinsics.sanitizeStackTrace(new ClassNotFoundException("Class " + arg4 + " is not found. Please update the Kotlin runtime to the latest version", ((Throwable)v0)));
        }
    }

    public static void checkHasClass(String arg4, String arg5) throws ClassNotFoundException {
        arg4 = arg4.replace('/', '.');
        try {
            Class.forName(arg4);
            return;
        }
        catch(ClassNotFoundException v0) {
            throw Intrinsics.sanitizeStackTrace(new ClassNotFoundException("Class " + arg4 + " is not found: this code requires the Kotlin runtime of version at least " + arg5, ((Throwable)v0)));
        }
    }

    public static void checkNotNull(Object arg0, String arg1) {
        if(arg0 == null) {
            Intrinsics.throwJavaNpe(arg1);
        }
    }

    public static void checkNotNull(Object arg0) {
        if(arg0 == null) {
            Intrinsics.throwJavaNpe();
        }
    }

    public static void checkNotNullExpressionValue(Object arg1, String arg2) {
        if(arg1 != null) {
            return;
        }

        throw Intrinsics.sanitizeStackTrace(new NullPointerException(arg2 + " must not be null"));
    }

    public static void checkNotNullParameter(Object arg0, String arg1) {
        if(arg0 == null) {
            Intrinsics.throwParameterIsNullNPE(arg1);
        }
    }

    public static void checkParameterIsNotNull(Object arg0, String arg1) {
        if(arg0 == null) {
            Intrinsics.throwParameterIsNullIAE(arg1);
        }
    }

    public static void checkReturnedValueIsNotNull(Object arg0, String arg1) {
        if(arg0 != null) {
            return;
        }

        throw Intrinsics.sanitizeStackTrace(new IllegalStateException(arg1));
    }

    public static void checkReturnedValueIsNotNull(Object arg2, String arg3, String arg4) {
        if(arg2 != null) {
            return;
        }

        throw Intrinsics.sanitizeStackTrace(new IllegalStateException("Method specified as non-null returned null: " + arg3 + "." + arg4));
    }

    public static int compare(int arg0, int arg1) {
        if(arg0 < arg1) {
            return -1;
        }

        if(arg0 == arg1) {
            return 0;
        }

        return 1;
    }

    public static int compare(long arg0, long arg2) {
        int v0 = Long.compare(arg0, arg2);
        if(v0 < 0) {
            return -1;
        }

        if(v0 == 0) {
            return 0;
        }

        return 1;
    }

    private static String createParameterIsNullExceptionMessage(String arg4) {
        StackTraceElement[] v0 = Thread.currentThread().getStackTrace();
        String v1 = Intrinsics.class.getName();
        int v2;
        for(v2 = 0; !v0[v2].getClassName().equals(v1); ++v2) {
        }

        while(v0[v2].getClassName().equals(v1)) {
            ++v2;
        }

        return "Parameter specified as non-null is null: method " + v0[v2].getClassName() + "." + v0[v2].getMethodName() + ", parameter " + arg4;
    }

    public static void needClassReification() {
        Intrinsics.throwUndefinedForReified();
    }

    public static void needClassReification(String arg0) {
        Intrinsics.throwUndefinedForReified(arg0);
    }

    public static void reifiedOperationMarker(int arg0, String arg1) {
        Intrinsics.throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int arg0, String arg1, String arg2) {
        Intrinsics.throwUndefinedForReified(arg2);
    }

    private static Throwable sanitizeStackTrace(Throwable arg1) {
        return Intrinsics.sanitizeStackTrace(arg1, Intrinsics.class.getName());
    }

    static Throwable sanitizeStackTrace(Throwable arg5, String arg6) {
        StackTraceElement[] v0 = arg5.getStackTrace();
        int v1 = v0.length;
        int v2 = -1;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            if(arg6.equals(v0[v3].getClassName())) {
                v2 = v3;
            }
        }

        arg5.setStackTrace(Arrays.copyOfRange(((Object[])v0), v2 + 1, v1));
        return arg5;
    }

    public static String stringPlus(String arg1, Object arg2) {
        return arg1 + arg2;
    }

    public static void throwAssert() {
        throw Intrinsics.sanitizeStackTrace(new AssertionError());
    }

    public static void throwAssert(String arg1) {
        throw Intrinsics.sanitizeStackTrace(new AssertionError(arg1));
    }

    public static void throwIllegalArgument() {
        throw Intrinsics.sanitizeStackTrace(new IllegalArgumentException());
    }

    public static void throwIllegalArgument(String arg1) {
        throw Intrinsics.sanitizeStackTrace(new IllegalArgumentException(arg1));
    }

    public static void throwIllegalState() {
        throw Intrinsics.sanitizeStackTrace(new IllegalStateException());
    }

    public static void throwIllegalState(String arg1) {
        throw Intrinsics.sanitizeStackTrace(new IllegalStateException(arg1));
    }

    public static void throwJavaNpe() {
        throw Intrinsics.sanitizeStackTrace(new NullPointerException());
    }

    public static void throwJavaNpe(String arg1) {
        throw Intrinsics.sanitizeStackTrace(new NullPointerException(arg1));
    }

    public static void throwNpe() {
        throw Intrinsics.sanitizeStackTrace(new KotlinNullPointerException());
    }

    public static void throwNpe(String arg1) {
        throw Intrinsics.sanitizeStackTrace(new KotlinNullPointerException(arg1));
    }

    private static void throwParameterIsNullIAE(String arg1) {
        throw Intrinsics.sanitizeStackTrace(new IllegalArgumentException(Intrinsics.createParameterIsNullExceptionMessage(arg1)));
    }

    private static void throwParameterIsNullNPE(String arg1) {
        throw Intrinsics.sanitizeStackTrace(new NullPointerException(Intrinsics.createParameterIsNullExceptionMessage(arg1)));
    }

    public static void throwUndefinedForReified() {
        Intrinsics.throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUndefinedForReified(String arg1) {
        throw new UnsupportedOperationException(arg1);
    }

    public static void throwUninitializedProperty(String arg1) {
        throw Intrinsics.sanitizeStackTrace(new UninitializedPropertyAccessException(arg1));
    }

    public static void throwUninitializedPropertyAccessException(String arg2) {
        Intrinsics.throwUninitializedProperty("lateinit property " + arg2 + " has not been initialized");
    }
}

