package androidx.compose.runtime.collection;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001AL\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0005H\u0080\b¢\u0006\u0002\u0010\b¨\u0006\t"}, d2={"fastCopyInto", "", "T", "destination", "destinationOffset", "", "startIndex", "endIndex", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ArrayUtils_androidKt {
    public static final Object[] fastCopyInto(Object[] arg0, Object[] arg1, int arg2, int arg3, int arg4) {
        System.arraycopy(arg0, arg3, arg1, arg2, arg4 - arg3);
        return arg1;
    }
}

