package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0080\f\u001A\u0015\u0010\u0000\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001A\u00020\u0001H\u0080\f\u001A\u0015\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0080\f\u001A\u0015\u0010\u0004\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001A\u00020\u0001H\u0080\f¨\u0006\u0005"}, d2={"ror", "", "other", "", "rol", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class BitwiseOperatorsKt {
    public static final int rol(int arg0, int arg1) {
        return Integer.rotateLeft(arg0, arg1);
    }

    public static final long rol(long arg0, int arg2) {
        return Long.rotateLeft(arg0, arg2);
    }

    public static final int ror(int arg0, int arg1) {
        return Integer.rotateRight(arg0, arg1);
    }

    public static final long ror(long arg0, int arg2) {
        return Long.rotateRight(arg0, arg2);
    }
}

