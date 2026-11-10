package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0006H\u0087\u0088\u0004\u001A\u000E\u0010\u000E\u001A\u00020\u000F*\u00020\u0002H\u0087\u0080\u0004\u001A\u0016\u0010\u0010\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u0002H\u0087\u0080\u0004\"%\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00028FX\u0086\u0084\b¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\r\"%\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00020\u0013*\u00020\u00028FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0014\u0010\u000B\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"printStackTrace", "", "", "writer", "Ljava/io/PrintWriter;", "stream", "Ljava/io/PrintStream;", "stackTrace", "", "Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "stackTraceToString", "", "addSuppressed", "exception", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/ExceptionsKt") class ExceptionsKt__ExceptionsKt {
    public ExceptionsKt__ExceptionsKt() {
        super();
    }

    public static final void addSuppressed(Throwable arg1, Throwable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "exception");
        if(arg1 != arg2) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(arg1, arg2);
        }
    }

    public static final StackTraceElement[] getStackTrace(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        StackTraceElement[] v1 = arg1.getStackTrace();
        Intrinsics.checkNotNull(v1);
        return v1;
    }

    public static void getStackTrace$annotations(Throwable arg0) {
    }

    public static final List getSuppressedExceptions(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(arg1);
    }

    public static void getSuppressedExceptions$annotations(Throwable arg0) {
    }

    private static final void printStackTrace(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.printStackTrace();
    }

    private static final void printStackTrace(Throwable arg1, PrintStream arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "stream");
        arg1.printStackTrace(arg2);
    }

    private static final void printStackTrace(Throwable arg1, PrintWriter arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "writer");
        arg1.printStackTrace(arg2);
    }

    public static final String stackTraceToString(Throwable arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        StringWriter v0 = new StringWriter();
        PrintWriter v1 = new PrintWriter(v0);
        arg3.printStackTrace(v1);
        v1.flush();
        String v3 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v3, "toString(...)");
        return v3;
    }
}

