package androidx.compose.runtime.tooling;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\bH\u0016J@\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0004\b\u0000\u0010\u0010\"\u0006\b\u0001\u0010\u000F\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000F0\u0013H\u0082\b¢\u0006\u0002\u0010\u0014R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001A\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u0015"}, d2={"Landroidx/compose/runtime/tooling/DiagnosticComposeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "trace", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "<init>", "(Landroidx/compose/runtime/tooling/ComposeStackTrace;)V", "fillInStackTrace", "", "message", "", "getMessage", "()Ljava/lang/String;", "mapToArray", "", "R", "T", "", "map", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DiagnosticComposeException extends RuntimeException {
    public static final int $stable = 8;
    private final ComposeStackTrace trace;

    static {
    }

    public DiagnosticComposeException(ComposeStackTrace arg9) {
        super();
        this.trace = arg9;
        if(!arg9.getHasSourceInformation()) {
            List v9 = ComposeStackTraceKt.filterInternalFramesByGroupKey(arg9);
            int v0 = v9.size();
            StackTraceElement[] v1 = new StackTraceElement[v0];
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                v1[v2] = new StackTraceElement("$$compose", "m$" + v9.get(v2).getGroupKey(), "SourceFile", 1);
            }

            this.setStackTrace(v1);
        }
    }

    public Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public String getMessage() {
        if(this.trace.getHasSourceInformation()) {
            StringBuilder v0 = new StringBuilder();
            v0.append("Composition stack when thrown:\n");
            ComposeStackTraceKt.appendSourceInformationStackTrace(v0, this.trace);
            return v0.toString();
        }

        return "Composition stack when thrown:";
    }

    private final Object[] mapToArray(List arg4, Function1 arg5) {
        int v3 = arg4.size();
        int v1 = 0;
        Intrinsics.reifiedOperationMarker(0, "R");
        Object[] v0 = new Object[v3];
        while(v1 < v3) {
            v0[v1] = arg5.invoke(arg4.get(v1));
            ++v1;
        }

        return v0;
    }
}

