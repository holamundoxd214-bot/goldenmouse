package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u001E\n\u0002\b\u000E\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u0015\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H\u0086\b\u001A+\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u0006\"\u0002H\u0004¢\u0006\u0002\u0010\u0007\u001A)\u0010\b\u001A\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u000E\u0010\u000B\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0003H\u0080\b\u001A\'\u0010\b\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\n0\u000EH\u0080\b\u001A&\u0010\u000F\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001A\u0002H\nH\u0080\b¢\u0006\u0002\u0010\u0011\u001A \u0010\u0012\u001A\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0013\u001A\u00020\u0001H\u0000\u001A \u0010\u0014\u001A\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0015\u001A\u00020\u0001H\u0000\u001A\u0019\u0010\u0016\u001A\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\b\u001A\'\u0010\u0017\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\n0\u000EH\u0080\b\u001A&\u0010\u0018\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001A\u0002H\nH\u0080\b¢\u0006\u0002\u0010\u0011\u001A!\u0010\u0019\u001A\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u001A\u001A\u00020\u0001H\u0080\b\u001A#\u0010\u001B\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0080\b\u001A\u0019\u0010\u001E\u001A\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\b\u001A*\u0010\u001F\u001A\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\b\u0010 \u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u0015\u001A\u00020\u0001H\u0000\u001A#\u0010!\u001A\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\b\u0010 \u001A\u0004\u0018\u00010\u001DH\u0080\b\u001A\u0018\u0010\"\u001A\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0000\u001A\u0019\u0010#\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\b\u001A)\u0010$\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u000E\u0010\u000B\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0003H\u0080\b\u001A\'\u0010$\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\n0\u000EH\u0080\b\u001A&\u0010%\u001A\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010&\u001A\u00020\u0001H\u0080\b¢\u0006\u0002\u0010\'\u001A&\u0010(\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001A\u0002H\nH\u0080\b¢\u0006\u0002\u0010\u0011\u001A\'\u0010)\u001A\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\n0\u000EH\u0080\b\u001A\u0019\u0010*\u001A\u00020+\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0080\b\u001A&\u0010,\u001A\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010&\u001A\u00020\u0001H\u0080\b¢\u0006\u0002\u0010\'\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006-"}, d2={"ARRAY_SET_BASE_SIZE", "", "arraySetOf", "Landroidx/collection/ArraySet;", "T", "values", "", "([Ljava/lang/Object;)Landroidx/collection/ArraySet;", "addAllInternal", "", "E", "array", "", "elements", "", "addInternal", "element", "(Landroidx/collection/ArraySet;Ljava/lang/Object;)Z", "allocArrays", "size", "binarySearchInternal", "hash", "clearInternal", "containsAllInternal", "containsInternal", "ensureCapacityInternal", "minimumCapacity", "equalsInternal", "other", "", "hashCodeInternal", "indexOf", "key", "indexOfInternal", "indexOfNull", "isEmptyInternal", "removeAllInternal", "removeAtInternal", "index", "(Landroidx/collection/ArraySet;I)Ljava/lang/Object;", "removeInternal", "retainAllInternal", "toStringInternal", "", "valueAtInternal", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final void addAllInternal(ArraySet arg8, ArraySet arg9) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "array");
        int v5 = arg9.get_size$collection();
        arg8.ensureCapacity(arg8.get_size$collection() + v5);
        if(arg8.get_size$collection() != 0) {
            int v0;
            for(v0 = 0; v0 < v5; ++v0) {
                arg8.add(arg9.valueAt(v0));
            }
        }
        else if(v5 > 0) {
            ArraysKt.copyInto$default(arg9.getHashes$collection(), arg8.getHashes$collection(), 0, 0, v5, 6, null);
            ArraysKt.copyInto$default(arg9.getArray$collection(), arg8.getArray$collection(), 0, 0, v5, 6, null);
            if(arg8.get_size$collection() == 0) {
                arg8.set_size$collection(v5);
                return;
            }
            else {
                throw new ConcurrentModificationException();
            }
        }
    }

    public static final boolean addAllInternal(ArraySet arg2, Collection arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "elements");
        arg2.ensureCapacity(arg2.get_size$collection() + arg3.size());
        Iterator v3 = arg3.iterator();
        int v0;
        for(v0 = 0; v3.hasNext(); v0 |= arg2.add(v3.next())) {
        }

        return ((boolean)v0);
    }

    public static final boolean addInternal(ArraySet arg17, Object arg18) {
        int v8;
        int v5;
        int v4;
        ArraySet v0 = arg17;
        Object v1 = arg18;
        Intrinsics.checkNotNullParameter(v0, "<this>");
        int v2 = v0.get_size$collection();
        int v3 = 0;
        if(v1 == null) {
            v4 = ArraySetKt.indexOfNull(v0);
            v5 = 0;
        }
        else {
            v4 = v1.hashCode();
            v5 = v4;
            v4 = ArraySetKt.indexOf(v0, v1, v4);
        }

        if(v4 >= 0) {
            return 0;
        }

        v4 = ~v4;
        if(v2 >= v0.getHashes$collection().length) {
            int v6 = 8;
            if(v2 >= v6) {
                v6 = (v2 >> 1) + v2;
            }
            else {
                v8 = 4;
                if(v2 >= v8) {
                }
                else {
                    v6 = v8;
                }
            }

            int[] v8_1 = v0.getHashes$collection();
            Object[] v15 = v0.getArray$collection();
            ArraySetKt.allocArrays(v0, v6);
            if(v2 == v0.get_size$collection()) {
                if(v0.getHashes$collection().length == 0) {
                    v3 = 1;
                }

                if(v3 != 0) {
                    goto label_59;
                }

                ArraysKt.copyInto$default(v8_1, v0.getHashes$collection(), 0, 0, v8_1.length, 6, null);
                ArraysKt.copyInto$default(v15, v0.getArray$collection(), 0, 0, v15.length, 6, null);
                goto label_59;
            }

            throw new ConcurrentModificationException();
        }

    label_59:
        if(v4 < v2) {
            v8 = v4 + 1;
            ArraysKt.copyInto(v0.getHashes$collection(), v0.getHashes$collection(), v8, v4, v2);
            ArraysKt.copyInto(v0.getArray$collection(), v0.getArray$collection(), v8, v4, v2);
        }

        if(v2 == v0.get_size$collection() && v4 < v0.getHashes$collection().length) {
            v0.getHashes$collection()[v4] = v5;
            v0.getArray$collection()[v4] = v1;
            v0.set_size$collection(v0.get_size$collection() + 1);
            return 1;
        }

        throw new ConcurrentModificationException();
    }

    public static final void allocArrays(ArraySet arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setHashes$collection(new int[arg2]);
        arg1.setArray$collection(new Object[arg2]);
    }

    public static final ArraySet arraySetOf() {
        return new ArraySet(0, 1, null);
    }

    public static final ArraySet arraySetOf(Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "values");
        ArraySet v0 = new ArraySet(arg4.length);
        int v1 = arg4.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(arg4[v2]);
        }

        return v0;
    }

    public static final int binarySearchInternal(ArraySet arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        try {
            return ContainerHelpersKt.binarySearch(arg1.getHashes$collection(), arg1.get_size$collection(), arg2);
        }
        catch(IndexOutOfBoundsException ) {
            throw new ConcurrentModificationException();
        }
    }

    public static final void clearInternal(ArraySet arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.get_size$collection() != 0) {
            arg1.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arg1.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arg1.set_size$collection(0);
        }

        if(arg1.get_size$collection() == 0) {
            return;
        }

        throw new ConcurrentModificationException();
    }

    public static final boolean containsAllInternal(ArraySet arg1, Collection arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        do {
            if(!v2.hasNext()) {
                return 1;
            }
        }
        while(arg1.contains(v2.next()));

        return 0;
    }

    public static final boolean containsInternal(ArraySet arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.indexOf(arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final void ensureCapacityInternal(ArraySet arg10, int arg11) {
        Intrinsics.checkNotNullParameter(arg10, "<this>");
        int v0 = arg10.get_size$collection();
        if(arg10.getHashes$collection().length < arg11) {
            int[] v2 = arg10.getHashes$collection();
            Object[] v1 = arg10.getArray$collection();
            ArraySetKt.allocArrays(arg10, arg11);
            if(arg10.get_size$collection() > 0) {
                ArraysKt.copyInto$default(v2, arg10.getHashes$collection(), 0, 0, arg10.get_size$collection(), 6, null);
                ArraysKt.copyInto$default(v1, arg10.getArray$collection(), 0, 0, arg10.get_size$collection(), 6, null);
            }
        }

        if(arg10.get_size$collection() == v0) {
            return;
        }

        throw new ConcurrentModificationException();
    }

    public static final boolean equalsInternal(ArraySet arg6, Object arg7) {
        int v3;
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        if(arg6 == (((ArraySet)arg7))) {
            return 1;
        }

        if(!(arg7 instanceof Set)) {
            return 0;
        }

        if(arg6.size() != arg7.size()) {
            return 0;
        }

        try {
            int v1 = arg6.get_size$collection();
            v3 = 0;
            while(true) {
            label_15:
                if(v3 >= v1) {
                    return 1;
                }

                if(arg7.contains(arg6.valueAt(v3))) {
                    goto label_21;
                }

                return 0;
            }
        }
        catch(ClassCastException ) {
            return 0;
        }

        return 0;
    label_21:
        ++v3;
        goto label_15;
        return 1;
    }

    public static final int hashCodeInternal(ArraySet arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        int[] v0 = arg4.getHashes$collection();
        int v4 = arg4.get_size$collection();
        int v1 = 0;
        int v2 = 0;
        while(v1 < v4) {
            v2 += v0[v1];
            ++v1;
        }

        return v2;
    }

    public static final int indexOf(ArraySet arg4, Object arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        int v0 = arg4.get_size$collection();
        if(v0 == 0) {
            return -1;
        }

        int v1 = ArraySetKt.binarySearchInternal(arg4, arg6);
        if(v1 < 0) {
        }
        else {
            if(Intrinsics.areEqual(arg5, arg4.getArray$collection()[v1])) {
                return v1;
            }

            goto label_14;
        }

        return v1;
    label_14:
        int v2 = v1 + 1;
        while(v2 < v0) {
            if(arg4.getHashes$collection()[v2] != arg6) {
                break;
            }

            if(Intrinsics.areEqual(arg5, arg4.getArray$collection()[v2])) {
                return v2;
            }
            else {
                ++v2;
                continue;
            }

            break;
        }

        --v1;
        while(v1 >= 0) {
            if(arg4.getHashes$collection()[v1] != arg6) {
                break;
            }

            if(Intrinsics.areEqual(arg5, arg4.getArray$collection()[v1])) {
                return v1;
            }
            else {
                --v1;
                continue;
            }

            break;
        }

        return ~v2;
    }

    public static final int indexOfInternal(ArraySet arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 == null) {
            return ArraySetKt.indexOfNull(arg1);
        }

        return ArraySetKt.indexOf(arg1, arg2, arg2.hashCode());
    }

    public static final int indexOfNull(ArraySet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return ArraySetKt.indexOf(arg2, null, 0);
    }

    public static final boolean isEmptyInternal(ArraySet arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.get_size$collection() <= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean removeAllInternal(ArraySet arg5, ArraySet arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "array");
        int v0 = arg6.get_size$collection();
        int v1 = arg5.get_size$collection();
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            arg5.remove(arg6.valueAt(v3));
        }

        if(v1 != arg5.get_size$collection()) {
            return 1;
        }

        return 0;
    }

    public static final boolean removeAllInternal(ArraySet arg2, Collection arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "elements");
        Iterator v3 = arg3.iterator();
        int v0;
        for(v0 = 0; v3.hasNext(); v0 |= arg2.remove(v3.next())) {
        }

        return ((boolean)v0);
    }

    public static final Object removeAtInternal(ArraySet arg14, int arg15) {
        int v10;
        Object[] v7;
        Intrinsics.checkNotNullParameter(arg14, "<this>");
        int v0 = arg14.get_size$collection();
        Object v1 = arg14.getArray$collection()[arg15];
        if(v0 <= 1) {
            arg14.clear();
            return v1;
        }

        int v3 = v0 - 1;
        int v5 = 8;
        if(arg14.getHashes$collection().length <= v5 || arg14.get_size$collection() >= arg14.getHashes$collection().length / 3) {
            v10 = arg15;
            if(v10 < v3) {
                int v4 = v10 + 1;
                ArraysKt.copyInto(arg14.getHashes$collection(), arg14.getHashes$collection(), v10, v4, v0);
                ArraysKt.copyInto(arg14.getArray$collection(), arg14.getArray$collection(), v10, v4, v0);
            }

            arg14.getArray$collection()[v3] = null;
        }
        else {
            if(arg14.get_size$collection() > v5) {
                v5 = arg14.get_size$collection() + (arg14.get_size$collection() >> 1);
            }

            int[] v6 = arg14.getHashes$collection();
            Object[] v2 = arg14.getArray$collection();
            ArraySetKt.allocArrays(arg14, v5);
            if(arg15 > 0) {
                ArraysKt.copyInto$default(v6, arg14.getHashes$collection(), 0, 0, arg15, 6, null);
                v7 = v2;
                ArraysKt.copyInto$default(v7, arg14.getArray$collection(), 0, 0, arg15, 6, null);
                v10 = arg15;
            }
            else {
                v10 = arg15;
                v7 = v2;
            }

            if(v10 >= v3) {
                goto label_66;
            }

            int v2_1 = v10 + 1;
            ArraysKt.copyInto(v6, arg14.getHashes$collection(), v10, v2_1, v0);
            ArraysKt.copyInto(v7, arg14.getArray$collection(), v10, v2_1, v0);
        }

    label_66:
        if(v0 == arg14.get_size$collection()) {
            arg14.set_size$collection(v3);
            return v1;
        }

        throw new ConcurrentModificationException();
    }

    public static final boolean removeInternal(ArraySet arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int v2 = arg1.indexOf(arg2);
        if(v2 >= 0) {
            arg1.removeAt(v2);
            return 1;
        }

        return 0;
    }

    public static final boolean retainAllInternal(ArraySet arg5, Collection arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "elements");
        int v0 = arg5.get_size$collection() - 1;
        boolean v2 = false;
        while(-1 < v0) {
            if(!CollectionsKt.contains(arg6, arg5.getArray$collection()[v0])) {
                arg5.removeAt(v0);
                v2 = true;
            }

            --v0;
        }

        return v2;
    }

    public static final String toStringInternal(ArraySet arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg4.isEmpty()) {
            return "{}";
        }

        StringBuilder v1 = new StringBuilder(arg4.get_size$collection() * 14);
        v1.append('{');
        int v0 = arg4.get_size$collection();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(v2 > 0) {
                v1.append(", ");
            }

            Object v3 = arg4.valueAt(v2);
            if((((ArraySet)v3)) != arg4) {
                v1.append(v3);
            }
            else {
                v1.append("(this Set)");
            }
        }

        v1.append('}');
        String v4 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v4, "toString(...)");
        return v4;
    }

    public static final Object valueAtInternal(ArraySet arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getArray$collection()[arg2];
    }
}

