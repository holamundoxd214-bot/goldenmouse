package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001A-\u0010\u0000\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0003\u001A\u0016\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0087\u0088\u0004\u001A\'\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0086\u0088\u0004¢\u0006\u0002\u0010\u000B\u001A1\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u000FH\u0080\u0080\u0004¢\u0006\u0002\u0010\u0010\u001A\u001A\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u000FH\u0081\u0080\u0004\u001A%\u0010\u0014\u001A\u00020\u000F\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"orEmpty", "", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "", "charset", "Ljava/nio/charset/Charset;", "toTypedArray", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "arrayOfNulls", "reference", "size", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRangeToIndexCheck", "", "toIndex", "contentDeepHashCodeImpl", "contentDeepHashCode", "([Ljava/lang/Object;)I", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/ArraysKt") class ArraysKt__ArraysJVMKt {
    public ArraysKt__ArraysJVMKt() {
        super();
    }

    public static final Object[] arrayOfNulls(Object[] arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "reference");
        Object v1 = Array.newInstance(arg1.getClass().getComponentType(), arg2);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return ((Object[])v1);
    }

    public static final int contentDeepHashCode(Object[] arg0) {
        return Arrays.deepHashCode(arg0);
    }

    public static final void copyOfRangeToIndexCheck(int arg3, int arg4) {
        if(arg3 <= arg4) {
            return;
        }

        throw new IndexOutOfBoundsException("toIndex (" + arg3 + ") is greater than size (" + arg4 + ").");
    }

    public static final Object[] orEmpty(Object[] arg1) {
        if(arg1 == null) {
            Intrinsics.reifiedOperationMarker(0, "T");
            arg1 = new Object[0];
        }

        return arg1;
    }

    private static final String toString(byte[] arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        return new String(arg1, arg2);
    }

    public static final Object[] toTypedArray(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.reifiedOperationMarker(0, "T?");
        return arg2.toArray(new Object[0]);
    }
}

