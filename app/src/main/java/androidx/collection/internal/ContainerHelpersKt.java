package androidx.collection.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\u001A \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\tH\u0000\u001A \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\rH\u0000\u001A\u001C\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0006H\u0000\u001A\u0010\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\tH\u0000\u001A\u0010\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\tH\u0000\u001A\u0010\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\tH\u0000\"\u0010\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001A\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001A\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058\u0000X\u0081\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0016"}, d2={"EMPTY_INTS", "", "EMPTY_LONGS", "", "EMPTY_OBJECTS", "", "", "[Ljava/lang/Object;", "binarySearch", "", "array", "size", "value", "", "equal", "", "a", "b", "idealByteArraySize", "need", "idealIntArraySize", "idealLongArraySize", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class ContainerHelpersKt {
    public static final int[] EMPTY_INTS;
    public static final long[] EMPTY_LONGS;
    public static final Object[] EMPTY_OBJECTS;

    static {
        ContainerHelpersKt.EMPTY_INTS = new int[0];
        ContainerHelpersKt.EMPTY_LONGS = new long[0];
        ContainerHelpersKt.EMPTY_OBJECTS = new Object[0];
    }

    public static final int binarySearch(int[] arg3, int arg4, int arg5) {
        int v1;
        Intrinsics.checkNotNullParameter(arg3, "array");
        --arg4;
        int v0 = 0;
        while(true) {
            if(v0 > arg4) {
                goto label_15;
            }

            v1 = v0 + arg4 >>> 1;
            int v2 = arg3[v1];
            if(v2 < arg5) {
                v0 = v1 + 1;
                continue;
            }

            if(v2 <= arg5) {
                return v1;
            }

            arg4 = v1 - 1;
        }

        return v1;
    label_15:
        return ~v0;
    }

    public static final int binarySearch(long[] arg4, int arg5, long arg6) {
        int v1;
        Intrinsics.checkNotNullParameter(arg4, "array");
        --arg5;
        int v0 = 0;
        while(true) {
            if(v0 > arg5) {
                goto label_16;
            }

            v1 = v0 + arg5 >>> 1;
            int v2 = Long.compare(arg4[v1], arg6);
            if(v2 < 0) {
                v0 = v1 + 1;
                continue;
            }

            if(v2 <= 0) {
                return v1;
            }

            arg5 = v1 - 1;
        }

        return v1;
    label_16:
        return ~v0;
    }

    public static final boolean equal(Object arg0, Object arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final int idealByteArraySize(int arg2) {
        int v0;
        for(v0 = 4; v0 < 0x20; ++v0) {
            int v1 = (1 << v0) - 12;
            if(arg2 <= v1) {
                return v1;
            }
        }

        return arg2;
    }

    public static final int idealIntArraySize(int arg0) {
        return ContainerHelpersKt.idealByteArraySize(arg0 * 4) / 4;
    }

    public static final int idealLongArraySize(int arg0) {
        return ContainerHelpersKt.idealByteArraySize(arg0 * 8) / 8;
    }
}

