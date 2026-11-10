package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A*\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\bH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A\u0010\u0010\t\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A*\u0010\n\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\bH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A\u001C\u0010\n\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001¨\u0006\u000B"}, d2={"throwIllegalArgumentException", "", "message", "", "requirePrecondition", "value", "", "lazyMessage", "Lkotlin/Function0;", "throwIllegalStateException", "checkPrecondition", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PreconditionsKt {
    public static final void checkPrecondition(boolean arg0) {
        if(!arg0) {
            PreconditionsKt.throwIllegalStateException("Check failed.");
        }
    }

    public static final void checkPrecondition(boolean arg0, Function0 arg1) {
        if(!arg0) {
            PreconditionsKt.throwIllegalStateException(arg1.invoke());
        }
    }

    public static final void requirePrecondition(boolean arg0, Function0 arg1) {
        if(!arg0) {
            PreconditionsKt.throwIllegalArgumentException(arg1.invoke());
        }
    }

    public static final void throwIllegalArgumentException(String arg1) {
        throw new IllegalArgumentException(arg1);
    }

    public static final void throwIllegalStateException(String arg1) {
        throw new IllegalStateException(arg1);
    }
}

