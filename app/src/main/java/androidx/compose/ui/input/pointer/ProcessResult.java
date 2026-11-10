package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0010\u001A\u00020\t2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0012\u0010\u000E\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000B\u0088\u0001\u0002¨\u0006\u0015"}, d2={"Landroidx/compose/ui/input/pointer/ProcessResult;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "dispatchedToAPointerInputModifier", "", "getDispatchedToAPointerInputModifier-impl", "(I)Z", "anyMovementConsumed", "getAnyMovementConsumed-impl", "anyChangeConsumed", "getAnyChangeConsumed-impl", "equals", "other", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ProcessResult {
    private final int value;

    private ProcessResult(int arg1) {
        super();
        this.value = arg1;
    }

    public static final ProcessResult box-impl(int arg1) {
        return new ProcessResult(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ProcessResult.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof ProcessResult)) {
            return 0;
        }

        if(arg2 != ((ProcessResult)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int arg0, int arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    public static final boolean getAnyChangeConsumed-impl(int arg0) {
        if((arg0 & 4) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean getAnyMovementConsumed-impl(int arg0) {
        if((arg0 & 2) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean getDispatchedToAPointerInputModifier-impl(int arg1) {
        if((arg1 & 1) != 0) {
            return 1;
        }

        return 0;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return ProcessResult.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return ProcessResult.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "ProcessResult(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

