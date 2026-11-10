package androidx.compose.ui.node;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0083@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ \u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0019"}, d2={"Landroidx/compose/ui/node/CenteredArray;", "", "data", "", "constructor-impl", "([I)[I", "mid", "", "getMid-impl", "([I)I", "get", "index", "get-impl", "([II)I", "set", "", "value", "set-impl", "([III)V", "equals", "", "other", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline final class CenteredArray {
    private final int[] data;

    private CenteredArray(int[] arg1) {
        super();
        this.data = arg1;
    }

    public static final CenteredArray box-impl(int[] arg1) {
        return new CenteredArray(arg1);
    }

    public static int[] constructor-impl(int[] arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return CenteredArray.equals-impl(this.data, arg1);
    }

    public static boolean equals-impl(int[] arg2, Object arg3) {
        if(!(arg3 instanceof CenteredArray)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((CenteredArray)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int[] arg0, int[] arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final int get-impl(int[] arg1, int arg2) {
        return arg1[arg2 + CenteredArray.getMid-impl(arg1)];
    }

    private static final int getMid-impl(int[] arg0) {
        return arg0.length / 2;
    }

    public int hashCode() {
        return CenteredArray.hashCode-impl(this.data);
    }

    public static int hashCode-impl(int[] arg0) {
        return Arrays.hashCode(arg0);
    }

    public static final void set-impl(int[] arg1, int arg2, int arg3) {
        arg1[arg2 + CenteredArray.getMid-impl(arg1)] = arg3;
    }

    public String toString() {
        return CenteredArray.toString-impl(this.data);
    }

    public static String toString-impl(int[] arg2) {
        return "CenteredArray(data=" + Arrays.toString(arg2) + ')';
    }

    public final int[] unbox-impl() {
        return this.data;
    }
}

