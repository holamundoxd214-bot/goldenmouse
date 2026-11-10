package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u001D\u0010\b\u001A\u00020\u0006*\u00060\u0001j\u0002`\u00032\n\u0010\t\u001A\u00060\u0001j\u0002`\u0003H\u0080\n\u001A\u0019\u0010\b\u001A\u00020\u0006*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001A\u00020\u0006H\u0080\n\u001A\u001D\u0010\n\u001A\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001A\u00020\u0006H\u0080\n\u001A!\u0010\u000B\u001A\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\n\u0010\t\u001A\u00060\u0001j\u0002`\u0003H\u0080\n\u001A\u001D\u0010\u000B\u001A\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001A\u00020\u0006H\u0080\n\u001A\u001D\u0010\f\u001A\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001A\u00020\u0006H\u0080\n\u001A\u001D\u0010\r\u001A\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u00032\u0006\u0010\t\u001A\u00020\u0006H\u0080\n\u001A\u0011\u0010\u000E\u001A\u00020\u0006*\u00060\u0001j\u0002`\u0003H\u0086\b\u001A\u0011\u0010\u000F\u001A\u00020\u0001*\u00060\u0001j\u0002`\u0003H\u0086\b\u001A\u0014\u0010\u0012\u001A\u00060\u0011j\u0002`\u00132\u0006\u0010\u0014\u001A\u00020\u0006H\u0000\u001A\u001D\u0010\u0015\u001A\u00060\u0001j\u0002`\u0003*\u00060\u0011j\u0002`\u00132\u0006\u0010\u0016\u001A\u00020\u0006H\u0080\n\u001A%\u0010\u0017\u001A\u00020\u0018*\u00060\u0011j\u0002`\u00132\u0006\u0010\u0016\u001A\u00020\u00062\n\u0010\u0019\u001A\u00060\u0001j\u0002`\u0003H\u0080\n\u001A\u001D\u0010\u001D\u001A\u00020\u0018*\u00060\u0011j\u0002`\u00132\n\u0010\t\u001A\u00060\u0011j\u0002`\u0013H\u0080\b\u001A\u0015\u0010\u001E\u001A\u00060\u0001j\u0002`\u0003*\u00060\u0011j\u0002`\u0013H\u0080\b\u001A\u001C\u0010\u001F\u001A\u00020\u0006*\u00060\u0011j\u0002`\u00132\n\u0010 \u001A\u00060\u0001j\u0002`\u0003H\u0000\u001A)\u0010!\u001A\u00020\u0018*\u00060\u0011j\u0002`\u00132\u0016\u0010\"\u001A\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\u0004\u0012\u00020\u00180#H\u0080\b\u001A(\u0010$\u001A\u00060\u0011j\u0002`\u0013*\u00060\u0011j\u0002`\u00132\u0006\u0010\u0016\u001A\u00020\u00062\n\u0010 \u001A\u00060\u0001j\u0002`\u0003H\u0000\u001A \u0010%\u001A\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0013*\u00060\u0011j\u0002`\u00132\u0006\u0010\u0016\u001A\u00020\u0006H\u0000\u001A\u0019\u0010&\u001A\u00060\u0011j\u0002`\u00132\n\u0010 \u001A\u00060\u0001j\u0002`\u0003H\u0080\b\u001A\u0010\u0010\'\u001A\u00060\u0001j\u0002`\u0003*\u00020\u0006H\u0000\u001A\u0010\u0010\'\u001A\u00060\u0001j\u0002`\u0003*\u00020\u0001H\u0000\"\u0012\u0010\u0002\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0007\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u001D\u0010\u001A\u001A\u00020\u0006*\u00060\u0011j\u0002`\u00138À\u0002X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\n\u0010\u0010\"\u00020\u00112\u00020\u0011¨\u0006("}, d2={"SnapshotId", "", "SnapshotIdZero", "Landroidx/compose/runtime/snapshots/SnapshotId;", "SnapshotIdMax", "SnapshotIdSize", "", "SnapshotIdInvalidValue", "compareTo", "other", "plus", "minus", "div", "times", "toInt", "toLong", "SnapshotIdArray", "", "snapshotIdArrayWithCapacity", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "capacity", "get", "index", "set", "", "value", "size", "getSize", "([J)I", "copyInto", "first", "binarySearch", "id", "forEach", "block", "Lkotlin/Function1;", "withIdInsertedAt", "withIdRemovedAt", "snapshotIdArrayOf", "toSnapshotId", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SnapshotId_jvmKt {
    public static final long SnapshotIdInvalidValue = -1;
    public static final long SnapshotIdMax = 0x7FFFFFFFFFFFFFFFL;
    public static final int SnapshotIdSize = 0x40;
    public static final long SnapshotIdZero;

    public static final int binarySearch(long[] arg5, long arg6) {
        int v2;
        int v0 = arg5.length - 1;
        int v1 = 0;
        while(true) {
            if(v1 > v0) {
                goto label_15;
            }

            v2 = v1 + v0 >>> 1;
            int v3 = Long.compare(arg6, arg5[v2]);
            if(v3 > 0) {
                v1 = v2 + 1;
                continue;
            }

            if(v3 >= 0) {
                return v2;
            }

            v0 = v2 - 1;
        }

        return v2;
    label_15:
        return -(v1 + 1);
    }

    public static final int compareTo(long arg2, int arg4) {
        return Intrinsics.compare(arg2, ((long)arg4));
    }

    public static final int compareTo(long arg0, long arg2) {
        return Intrinsics.compare(arg0, arg2);
    }

    public static final void copyInto(long[] arg7, long[] arg8) {
        ArraysKt.copyInto$default(arg7, arg8, 0, 0, 0, 12, null);
    }

    public static final long div(long arg2, int arg4) {
        return arg2 / (((long)arg4));
    }

    public static final long first(long[] arg2) {
        return arg2[0];
    }

    public static final void forEach(long[] arg4, Function1 arg5) {
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.invoke(Long.valueOf(arg4[v1]));
        }
    }

    public static final long get(long[] arg2, int arg3) {
        return arg2[arg3];
    }

    public static final int getSize(long[] arg0) {
        return arg0.length;
    }

    public static final long minus(long arg2, int arg4) {
        return arg2 - (((long)arg4));
    }

    public static final long minus(long arg0, long arg2) {
        return arg0 - arg2;
    }

    public static final long plus(long arg2, int arg4) {
        return arg2 + (((long)arg4));
    }

    public static final void set(long[] arg0, int arg1, long arg2) {
        arg0[arg1] = arg2;
    }

    public static final long[] snapshotIdArrayOf(long arg2) {
        return new long[]{arg2};
    }

    public static final long[] snapshotIdArrayWithCapacity(int arg0) {
        return new long[arg0];
    }

    public static final long times(long arg2, int arg4) {
        return arg2 * (((long)arg4));
    }

    public static final int toInt(long arg0) {
        return ((int)arg0);
    }

    public static final long toLong(long arg0) {
        return arg0;
    }

    public static final long toSnapshotId(int arg2) {
        return ((long)arg2);
    }

    public static final long toSnapshotId(long arg0) {
        return arg0;
    }

    public static final long[] withIdInsertedAt(long[] arg3, int arg4, long arg5) {
        int v0 = arg3.length;
        long[] v1 = new long[v0 + 1];
        ArraysKt.copyInto(arg3, v1, 0, 0, arg4);
        ArraysKt.copyInto(arg3, v1, arg4 + 1, arg4, v0);
        v1[arg4] = arg5;
        return v1;
    }

    public static final long[] withIdRemovedAt(long[] arg4, int arg5) {
        int v0 = arg4.length;
        int v1 = v0 - 1;
        if(v1 == 0) {
            return null;
        }

        long[] v2 = new long[v1];
        if(arg5 > 0) {
            ArraysKt.copyInto(arg4, v2, 0, 0, arg5);
        }

        if(arg5 < v1) {
            ArraysKt.copyInto(arg4, v2, arg5, arg5 + 1, v0);
        }

        return v2;
    }
}

