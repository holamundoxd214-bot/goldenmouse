package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A*\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A\u0010\u0010\u000B\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A*\u0010\f\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"DualFloatSignBit", "", "throwIllegalArgumentException", "", "message", "", "requirePrecondition", "value", "", "lazyMessage", "Lkotlin/Function0;", "throwIllegalStateException", "checkPrecondition", "ui-unit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InlineClassHelperKt {
    public static final long DualFloatSignBit = -9223372034707292160L;

    public static final void checkPrecondition(boolean arg0, Function0 arg1) {
        if(!arg0) {
            InlineClassHelperKt.throwIllegalStateException(arg1.invoke());
        }
    }

    public static final void requirePrecondition(boolean arg0, Function0 arg1) {
        if(!arg0) {
            InlineClassHelperKt.throwIllegalArgumentException(arg1.invoke());
        }
    }

    public static final void throwIllegalArgumentException(String arg1) {
        throw new IllegalArgumentException(arg1);
    }

    public static final void throwIllegalStateException(String arg1) {
        throw new IllegalStateException(arg1);
    }
}

