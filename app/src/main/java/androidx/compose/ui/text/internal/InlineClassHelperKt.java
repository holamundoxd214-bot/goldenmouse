package androidx.compose.ui.text.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u0010\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u0010\u0010\u0007\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A4\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\fH\u0080\b\u0082\u0002\u0012\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001AG\u0010\r\u001A\u0002H\u000E\"\b\b\u0000\u0010\u000E*\u00020\u000F2\b\u0010\t\u001A\u0004\u0018\u0001H\u000E2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\fH\u0080\b\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000\n\b\b\u0000\u001A\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\u0010\u001A4\u0010\u0011\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\fH\u0080\b\u0082\u0002\u0012\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001AG\u0010\u0012\u001A\u0002H\u000E\"\b\b\u0000\u0010\u000E*\u00020\u000F2\b\u0010\t\u001A\u0004\u0018\u0001H\u000E2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\fH\u0080\b\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000\n\b\b\u0000\u001A\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\u0010¨\u0006\u0013"}, d2={"throwIllegalStateException", "", "message", "", "throwIllegalStateExceptionForNullCheck", "", "throwIllegalArgumentException", "throwIllegalArgumentExceptionForNullCheck", "checkPrecondition", "value", "", "lazyMessage", "Lkotlin/Function0;", "checkPreconditionNotNull", "T", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requirePrecondition", "requirePreconditionNotNull", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InlineClassHelperKt {
    public static final void checkPrecondition(boolean arg0, Function0 arg1) {
        if(!arg0) {
            InlineClassHelperKt.throwIllegalStateException(arg1.invoke());
        }
    }

    public static final Object checkPreconditionNotNull(Object arg0, Function0 arg1) {
        if(arg0 != null) {
            return arg0;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(arg1.invoke());
        throw new KotlinNothingValueException();
    }

    public static final void requirePrecondition(boolean arg0, Function0 arg1) {
        if(!arg0) {
            InlineClassHelperKt.throwIllegalArgumentException(arg1.invoke());
        }
    }

    public static final Object requirePreconditionNotNull(Object arg0, Function0 arg1) {
        if(arg0 != null) {
            return arg0;
        }

        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck(arg1.invoke());
        throw new KotlinNothingValueException();
    }

    public static final void throwIllegalArgumentException(String arg1) {
        throw new IllegalArgumentException(arg1);
    }

    public static final Void throwIllegalArgumentExceptionForNullCheck(String arg1) {
        throw new IllegalArgumentException(arg1);
    }

    public static final void throwIllegalStateException(String arg1) {
        throw new IllegalStateException(arg1);
    }

    public static final Void throwIllegalStateExceptionForNullCheck(String arg1) {
        throw new IllegalStateException(arg1);
    }
}

