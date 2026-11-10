package _COROUTINE;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u001A\u0014\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0001H\u0002\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2={"ARTIFICIAL_FRAME_PACKAGE_NAME", "", "getARTIFICIAL_FRAME_PACKAGE_NAME", "()Ljava/lang/String;", "artificialFrame", "Ljava/lang/StackTraceElement;", "", "name", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CoroutineDebuggingKt {
    private static final String ARTIFICIAL_FRAME_PACKAGE_NAME = "_COROUTINE";

    static {
    }

    public static final StackTraceElement access$artificialFrame(Throwable arg0, String arg1) {
        return CoroutineDebuggingKt.artificialFrame(arg0, arg1);
    }

    private static final StackTraceElement artificialFrame(Throwable arg3, String arg4) {
        StackTraceElement v3 = arg3.getStackTrace()[0];
        return new StackTraceElement(CoroutineDebuggingKt.ARTIFICIAL_FRAME_PACKAGE_NAME + '.' + arg4, "_", v3.getFileName(), v3.getLineNumber());
    }

    public static final String getARTIFICIAL_FRAME_PACKAGE_NAME() {
        return CoroutineDebuggingKt.ARTIFICIAL_FRAME_PACKAGE_NAME;
    }
}

