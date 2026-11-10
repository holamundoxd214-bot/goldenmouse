package androidx.compose.animation.core;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A*\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\bH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A\u0010\u0010\t\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A*\u0010\f\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\bH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A=\u0010\r\u001A\u0002H\u000E\"\b\b\u0000\u0010\u000E*\u00020\u000F2\b\u0010\u0005\u001A\u0004\u0018\u0001H\u000E2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\bH\u0080\b\u0082\u0002\n\n\b\b\u0000\u001A\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2={"throwIllegalArgumentException", "", "message", "", "requirePrecondition", "value", "", "lazyMessage", "Lkotlin/Function0;", "throwIllegalStateException", "throwIllegalStateExceptionForNullCheck", "", "checkPrecondition", "checkPreconditionNotNull", "T", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PreconditionsKt {
    public static final void checkPrecondition(boolean arg0, Function0 arg1) {
        if(!arg0) {
            PreconditionsKt.throwIllegalStateException(arg1.invoke());
        }
    }

    public static final Object checkPreconditionNotNull(Object arg0, Function0 arg1) {
        if(arg0 != null) {
            return arg0;
        }

        PreconditionsKt.throwIllegalStateExceptionForNullCheck(arg1.invoke());
        throw new KotlinNothingValueException();
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

    public static final Void throwIllegalStateExceptionForNullCheck(String arg1) {
        throw new IllegalStateException(arg1);
    }
}

