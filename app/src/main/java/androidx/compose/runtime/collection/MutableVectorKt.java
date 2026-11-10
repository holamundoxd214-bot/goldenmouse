package androidx.compose.runtime.collection;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u0018\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002\u001A \u0010\u0007\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u0004H\u0000\u001A\u0018\u0010\n\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002\u001A\u0010\u0010\u000B\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u0004H\u0002\u001A\u0018\u0010\f\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u0004H\u0002\u001A!\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0006\b\u0000\u0010\u000F\u0018\u00012\b\b\u0002\u0010\u0010\u001A\u00020\u0004H\u0086\b\u001A@\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0006\b\u0000\u0010\u000F\u0018\u00012\u0006\u0010\u0006\u001A\u00020\u00042\u0014\b\b\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u000F0\u0012H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001A\u0017\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0006\b\u0000\u0010\u000F\u0018\u0001H\u0086\b\u001A0\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u000E\"\u0006\b\u0000\u0010\u000F\u0018\u00012\u0012\u0010\u0014\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u000F0\u0015\"\u0002H\u000FH\u0086\b¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2={"checkIndex", "", "", "index", "", "throwListIndexOutOfBoundsException", "size", "checkSubIndex", "fromIndex", "toIndex", "throwOutOfRangeException", "throwNegativeIndexException", "throwReversedIndicesException", "MutableVector", "Landroidx/compose/runtime/collection/MutableVector;", "T", "capacity", "init", "Lkotlin/Function1;", "mutableVectorOf", "elements", "", "([Ljava/lang/Object;)Landroidx/compose/runtime/collection/MutableVector;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class MutableVectorKt {
    public static final MutableVector MutableVector(int arg3) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[arg3], 0);
    }

    public static final MutableVector MutableVector(int arg3, Function1 arg4) {
        int v1 = 0;
        Intrinsics.reifiedOperationMarker(0, "T");
        Object[] v0 = new Object[arg3];
        while(v1 < arg3) {
            v0[v1] = arg4.invoke(Integer.valueOf(v1));
            ++v1;
        }

        return new MutableVector(v0, arg3);
    }

    public static MutableVector MutableVector$default(int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 16;
        }

        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[arg1], 0);
    }

    public static final void checkIndex(List arg0, int arg1) {
        int v0 = arg0.size();
        if(arg1 >= 0) {
            if(arg1 >= v0) {
            }
            else {
                return;
            }
        }

        MutableVectorKt.throwListIndexOutOfBoundsException(arg1, v0);
    }

    public static final void checkSubIndex(List arg0, int arg1, int arg2) {
        if(arg1 > arg2) {
            MutableVectorKt.throwReversedIndicesException(arg1, arg2);
        }

        if(arg1 < 0) {
            MutableVectorKt.throwNegativeIndexException(arg1);
        }

        if(arg2 > arg0.size()) {
            MutableVectorKt.throwOutOfRangeException(arg2, arg0.size());
        }
    }

    public static final MutableVector mutableVectorOf() {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new MutableVector(new Object[16], 0);
    }

    public static final MutableVector mutableVectorOf(Object[] arg2) {
        return new MutableVector(arg2, arg2.length);
    }

    private static final void throwListIndexOutOfBoundsException(int arg3, int arg4) {
        throw new IndexOutOfBoundsException("Index " + arg3 + " is out of bounds. The list has " + arg4 + " elements.");
    }

    private static final void throwNegativeIndexException(int arg3) {
        throw new IndexOutOfBoundsException("fromIndex (" + arg3 + ") is less than 0.");
    }

    private static final void throwOutOfRangeException(int arg3, int arg4) {
        throw new IndexOutOfBoundsException("toIndex (" + arg3 + ") is more than than the list size (" + arg4 + ')');
    }

    private static final void throwReversedIndicesException(int arg3, int arg4) {
        throw new IllegalArgumentException("Indices are out of order. fromIndex (" + arg3 + ") is greater than toIndex (" + arg4 + ").");
    }
}

