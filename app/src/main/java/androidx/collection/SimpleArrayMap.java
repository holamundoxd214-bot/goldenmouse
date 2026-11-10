package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b)\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B!\b\u0016\u0012\u0018\u0010\u0004\u001A\u0014\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000F\u001A\u00020\u0010H\u0016J\u0015\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u0007H\u0016J\u0013\u0010\u0019\u001A\u00020\u00122\b\u0010\u001A\u001A\u0004\u0018\u00010\u0003H\u0096\u0002J\u0018\u0010\u001B\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001CJ\u001F\u0010\u001D\u001A\u00028\u00012\b\u0010\u0013\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u001E\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001FJ,\u0010 \u001A\u0002H!\"\n\b\u0002\u0010!*\u0004\u0018\u00018\u00012\b\u0010\u0013\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u001E\u001A\u0002H!H\u0082\b¢\u0006\u0002\u0010\u001FJ\b\u0010\"\u001A\u00020\u0007H\u0016J\u001D\u0010#\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010$\u001A\u00020\u0007H\u0002¢\u0006\u0002\u0010%J\u0015\u0010&\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\'J\b\u0010(\u001A\u00020\u0007H\u0002J\u0017\u0010)\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00028\u0001H\u0001¢\u0006\u0004\b*\u0010\'J\b\u0010+\u001A\u00020\u0012H\u0016J\u0015\u0010,\u001A\u00028\u00002\u0006\u0010-\u001A\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001F\u0010/\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001FJ \u00100\u001A\u00020\u00102\u0016\u0010\u0004\u001A\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0000H\u0016J\u001F\u00101\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001FJ\u0017\u00102\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001CJ\u001D\u00102\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u0001H\u0016¢\u0006\u0002\u00103J\u0015\u00104\u001A\u00028\u00012\u0006\u0010-\u001A\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001F\u00105\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001FJ%\u00105\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u00002\u0006\u00106\u001A\u00028\u00012\u0006\u00107\u001A\u00028\u0001H\u0016¢\u0006\u0002\u00108J\u001D\u00109\u001A\u00028\u00012\u0006\u0010-\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010:J\b\u0010\u000E\u001A\u00020\u0007H\u0016J\b\u0010;\u001A\u00020<H\u0016J\u0015\u0010=\u001A\u00028\u00012\u0006\u0010-\u001A\u00020\u0007H\u0016¢\u0006\u0002\u0010.R\u0018\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000BR\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006>"}, d2={"Landroidx/collection/SimpleArrayMap;", "K", "V", "", "map", "(Landroidx/collection/SimpleArrayMap;)V", "capacity", "", "(I)V", "array", "", "[Ljava/lang/Object;", "hashes", "", "size", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "ensureCapacity", "minimumCapacity", "equals", "other", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefaultInternal", "T", "hashCode", "indexOf", "hash", "(Ljava/lang/Object;I)I", "indexOfKey", "(Ljava/lang/Object;)I", "indexOfNull", "indexOfValue", "__restricted$indexOfValue", "isEmpty", "keyAt", "index", "(I)Ljava/lang/Object;", "put", "putAll", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "toString", "", "valueAt", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public class SimpleArrayMap {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap(int arg1, int arg2, DefaultConstructorMarker arg3) {
        this(0);
    }

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    public SimpleArrayMap(int arg2) {
        super();
        int[] v0 = arg2 == 0 ? ContainerHelpersKt.EMPTY_INTS : new int[arg2];
        this.hashes = v0;
        Object[] v2 = arg2 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[arg2 << 1];
        this.array = v2;
    }

    public SimpleArrayMap(SimpleArrayMap arg4) {
        this(0, 1, null);
        if(arg4 != null) {
            this.putAll(arg4);
        }
    }

    public final int __restricted$indexOfValue(Object arg5) {
        int v0 = this.size * 2;
        Object[] v4 = this.array;
        if(arg5 == null) {
            int v5 = 1;
            while(v5 < v0) {
                if(v4[v5] == null) {
                    return v5 >> 1;
                }
                else {
                    v5 += 2;
                    continue;
                }

                return -1;
            }
        }
        else {
            int v2 = 1;
            while(v2 < v0) {
                if(Intrinsics.areEqual(arg5, v4[v2])) {
                    return v2 >> 1;
                }
                else {
                    v2 += 2;
                    continue;
                }

                return -1;
            }
        }

        return -1;
    }

    public void clear() {
        int v0 = this.size;
        if(v0 > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            v0 = 0;
            this.size = 0;
        }

        if(v0 <= 0) {
            return;
        }

        throw new ConcurrentModificationException();
    }

    public boolean containsKey(Object arg1) {
        if(this.indexOfKey(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    public boolean containsValue(Object arg1) {
        if(this.__restricted$indexOfValue(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    public void ensureCapacity(int arg4) {
        int v0 = this.size;
        int[] v1 = this.hashes;
        if(v1.length < arg4) {
            v1 = Arrays.copyOf(v1, arg4);
            Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
            this.hashes = v1;
            Object[] v4 = Arrays.copyOf(this.array, arg4 * 2);
            Intrinsics.checkNotNullExpressionValue(v4, "copyOf(...)");
            this.array = v4;
        }

        if(this.size == v0) {
            return;
        }

        throw new ConcurrentModificationException();
    }

    public boolean equals(Object arg8) {
        Object v6;
        Object v5;
        Object v4;
        int v2;
        if(this == (((SimpleArrayMap)arg8))) {
            return 1;
        }

        try {
            if((arg8 instanceof SimpleArrayMap)) {
                if(this.size() != arg8.size()) {
                    return 0;
                }

                v2 = this.size;
                int v3;
                for(v3 = 0; v3 < v2; ++v3) {
                    v4 = this.keyAt(v3);
                    v5 = this.valueAt(v3);
                    v6 = ((SimpleArrayMap)arg8).get(v4);
                    if(v5 == null) {
                        if(v6 == null && (((SimpleArrayMap)arg8).containsKey(v4))) {
                            goto label_25;
                        }

                        return 0;
                    }
                    else {
                        if(Intrinsics.areEqual(v5, v6)) {
                            goto label_25;
                        }

                        return 0;
                    }

                label_25:
                }

                return 1;
            }

            if(!(arg8 instanceof Map)) {
                return 0;
            }

            if(this.size() != arg8.size()) {
                return 0;
            }

            v2 = this.size;
            v3 = 0;
            while(true) {
            label_37:
                if(v3 >= v2) {
                    return 1;
                }

                v4 = this.keyAt(v3);
                v5 = this.valueAt(v3);
                v6 = arg8.get(v4);
                if(v5 == null) {
                    if(v6 == null && (arg8.containsKey(v4))) {
                        goto label_51;
                    }

                    return 0;
                }
                else {
                    if(Intrinsics.areEqual(v5, v6)) {
                        goto label_51;
                    }

                    return 0;
                }

                goto label_51;
            }
        }
        catch(ClassCastException ) {
            return 0;
        }

        return 0;
    label_51:
        ++v3;
        goto label_37;
        return 1;
    }

    public Object get(Object arg1) {
        int v1 = this.indexOfKey(arg1);
        if(v1 >= 0) {
            return this.array[(v1 << 1) + 1];
        }

        return null;
    }

    public Object getOrDefault(Object arg1, Object arg2) {
        int v1 = this.indexOfKey(arg1);
        if(v1 >= 0) {
            return this.array[(v1 << 1) + 1];
        }

        return arg2;
    }

    private final Object getOrDefaultInternal(Object arg1, Object arg2) {
        int v1 = this.indexOfKey(arg1);
        if(v1 >= 0) {
            return this.array[(v1 << 1) + 1];
        }

        return arg2;
    }

    public int hashCode() {
        int[] v0 = this.hashes;
        Object[] v1 = this.array;
        int v8 = this.size;
        int v3 = 1;
        int v4 = 0;
        int v5 = 0;
        while(v4 < v8) {
            Object v6 = v1[v3];
            int v7 = v0[v4];
            int v6_1 = v6 != null ? v6.hashCode() : 0;
            v5 += v6_1 ^ v7;
            ++v4;
            v3 += 2;
        }

        return v5;
    }

    private final int indexOf(Object arg6, int arg7) {
        int v0 = this.size;
        if(v0 == 0) {
            return -1;
        }

        int v1 = ContainerHelpersKt.binarySearch(this.hashes, v0, arg7);
        if(v1 < 0) {
        }
        else {
            if(Intrinsics.areEqual(arg6, this.array[v1 << 1])) {
                return v1;
            }

            goto label_14;
        }

        return v1;
    label_14:
        int v2 = v1 + 1;
        while(v2 < v0) {
            if(this.hashes[v2] != arg7) {
                break;
            }

            if(Intrinsics.areEqual(arg6, this.array[v2 << 1])) {
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
            if(this.hashes[v1] != arg7) {
                break;
            }

            if(Intrinsics.areEqual(arg6, this.array[v1 << 1])) {
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

    public int indexOfKey(Object arg2) {
        if(arg2 == null) {
            return this.indexOfNull();
        }

        return this.indexOf(arg2, arg2.hashCode());
    }

    private final int indexOfNull() {
        int v0 = this.size;
        if(v0 == 0) {
            return -1;
        }

        int v1 = ContainerHelpersKt.binarySearch(this.hashes, v0, 0);
        if(v1 < 0) {
        }
        else {
            if(this.array[v1 << 1] == null) {
                return v1;
            }

            goto label_14;
        }

        return v1;
    label_14:
        int v2 = v1 + 1;
        while(v2 < v0) {
            if(this.hashes[v2] != 0) {
                break;
            }

            if(this.array[v2 << 1] == null) {
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
            if(this.hashes[v1] != 0) {
                break;
            }

            if(this.array[v1 << 1] == null) {
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

    public boolean isEmpty() {
        if(this.size <= 0) {
            return 1;
        }

        return 0;
    }

    public Object keyAt(int arg4) {
        int v1 = 0;
        if(arg4 >= 0 && arg4 < this.size) {
            v1 = 1;
        }

        if(v1 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg4);
        }

        return this.array[arg4 << 1];
    }

    public Object put(Object arg8, Object arg9) {
        int v4;
        int v0 = this.size;
        int v1 = arg8 != null ? arg8.hashCode() : 0;
        int v2 = arg8 != null ? this.indexOf(arg8, v1) : this.indexOfNull();
        if(v2 >= 0) {
            int v8 = (v2 << 1) + 1;
            Object[] v7 = this.array;
            Object v0_1 = v7[v8];
            v7[v8] = arg9;
            return v0_1;
        }

        v2 = ~v2;
        int[] v3 = this.hashes;
        if(v0 >= v3.length) {
            v4 = 8;
            if(v0 >= v4) {
                v4 = (v0 >> 1) + v0;
            }
            else {
                int v5 = 4;
                if(v0 >= v5) {
                }
                else {
                    v4 = v5;
                }
            }

            v3 = Arrays.copyOf(v3, v4);
            Intrinsics.checkNotNullExpressionValue(v3, "copyOf(...)");
            this.hashes = v3;
            Object[] v3_1 = Arrays.copyOf(this.array, v4 << 1);
            Intrinsics.checkNotNullExpressionValue(v3_1, "copyOf(...)");
            this.array = v3_1;
            if(v0 == this.size) {
                goto label_44;
            }

            throw new ConcurrentModificationException();
        }

    label_44:
        if(v2 < v0) {
            v4 = v2 + 1;
            ArraysKt.copyInto(this.hashes, this.hashes, v4, v2, v0);
            ArraysKt.copyInto(this.array, this.array, v4 << 1, v2 << 1, this.size << 1);
        }

        int v3_2 = this.size;
        if(v0 == v3_2) {
            int[] v0_2 = this.hashes;
            if(v2 < v0_2.length) {
                v0_2[v2] = v1;
                Object[] v0_3 = this.array;
                v1 = v2 << 1;
                v0_3[v1] = arg8;
                v0_3[v1 + 1] = arg9;
                this.size = v3_2 + 1;
                return null;
            }
        }

        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap arg5) {
        Intrinsics.checkNotNullParameter(arg5, "map");
        int v0 = arg5.size;
        this.ensureCapacity(this.size + v0);
        int v2 = 0;
        if(this.size != 0) {
            while(v2 < v0) {
                this.put(arg5.keyAt(v2), arg5.valueAt(v2));
                ++v2;
            }
        }
        else if(v0 > 0) {
            ArraysKt.copyInto(arg5.hashes, this.hashes, 0, 0, v0);
            ArraysKt.copyInto(arg5.array, this.array, 0, 0, v0 << 1);
            this.size = v0;
            return;
        }
    }

    public Object putIfAbsent(Object arg2, Object arg3) {
        Object v0 = this.get(arg2);
        if(v0 == null) {
            return this.put(arg2, arg3);
        }

        return v0;
    }

    public Object remove(Object arg1) {
        int v1 = this.indexOfKey(arg1);
        if(v1 >= 0) {
            return this.removeAt(v1);
        }

        return null;
    }

    public boolean remove(Object arg2, Object arg3) {
        int v2 = this.indexOfKey(arg2);
        if(v2 >= 0 && (Intrinsics.areEqual(arg3, this.valueAt(v2)))) {
            this.removeAt(v2);
            return 1;
        }

        return 0;
    }

    public Object removeAt(int arg12) {
        int v0;
        int v2 = arg12 < 0 || arg12 >= this.size ? 0 : 1;
        if(v2 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg12);
        }

        Object[] v2_1 = this.array;
        int v3 = arg12 << 1;
        Object v4 = v2_1[v3 + 1];
        int v5 = this.size;
        if(v5 <= 1) {
            this.clear();
            return v4;
        }

        int v6 = v5 - 1;
        int[] v7 = this.hashes;
        int v9 = 8;
        if(v7.length <= v9 || v5 >= v7.length / 3) {
            if(arg12 < v6) {
                v0 = arg12 + 1;
                ArraysKt.copyInto(v7, v7, arg12, v0, v5);
                ArraysKt.copyInto(this.array, this.array, v3, v0 << 1, v5 << 1);
            }

            Object[] v12 = this.array;
            v0 = v6 << 1;
            v12[v0] = null;
            v12[v0 + 1] = null;
        }
        else {
            if(v5 > v9) {
                v9 = v5 + (v5 >> 1);
            }

            int[] v8 = Arrays.copyOf(v7, v9);
            Intrinsics.checkNotNullExpressionValue(v8, "copyOf(...)");
            this.hashes = v8;
            Object[] v8_1 = Arrays.copyOf(this.array, v9 << 1);
            Intrinsics.checkNotNullExpressionValue(v8_1, "copyOf(...)");
            this.array = v8_1;
            if(v5 == this.size) {
                if(arg12 > 0) {
                    ArraysKt.copyInto(v7, this.hashes, 0, 0, arg12);
                    ArraysKt.copyInto(v2_1, this.array, 0, 0, v3);
                }

                if(arg12 >= v6) {
                    goto label_75;
                }

                int v8_2 = arg12 + 1;
                ArraysKt.copyInto(v7, this.hashes, arg12, v8_2, v5);
                ArraysKt.copyInto(v2_1, this.array, v3, v8_2 << 1, v5 << 1);
                goto label_75;
            }

            throw new ConcurrentModificationException();
        }

    label_75:
        if(v5 == this.size) {
            this.size = v6;
            return v4;
        }

        throw new ConcurrentModificationException();
    }

    public Object replace(Object arg1, Object arg2) {
        int v1 = this.indexOfKey(arg1);
        if(v1 >= 0) {
            return this.setValueAt(v1, arg2);
        }

        return null;
    }

    public boolean replace(Object arg2, Object arg3, Object arg4) {
        int v2 = this.indexOfKey(arg2);
        if(v2 >= 0 && (Intrinsics.areEqual(arg3, this.valueAt(v2)))) {
            this.setValueAt(v2, arg4);
            return 1;
        }

        return 0;
    }

    public Object setValueAt(int arg4, Object arg5) {
        int v0 = 0;
        if(arg4 >= 0 && arg4 < this.size) {
            v0 = 1;
        }

        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg4);
        }

        arg4 = (arg4 << 1) + 1;
        Object[] v3 = this.array;
        Object v0_1 = v3[arg4];
        v3[arg4] = arg5;
        return v0_1;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if(this.isEmpty()) {
            return "{}";
        }

        StringBuilder v1 = new StringBuilder(this.size * 28);
        v1.append('{');
        int v0 = this.size;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(v2 > 0) {
                v1.append(", ");
            }

            Object v3 = this.keyAt(v2);
            String v4 = "(this Map)";
            if((((StringBuilder)v3)) != v1) {
                v1.append(v3);
            }
            else {
                v1.append(v4);
            }

            v1.append('=');
            v3 = this.valueAt(v2);
            if((((StringBuilder)v3)) != v1) {
                v1.append(v3);
            }
            else {
                v1.append(v4);
            }
        }

        v1.append('}');
        String v5 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
        return v5;
    }

    public Object valueAt(int arg4) {
        int v0 = 0;
        if(arg4 >= 0 && arg4 < this.size) {
            v0 = 1;
        }

        if(v0 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg4);
        }

        return this.array[(arg4 << 1) + 1];
    }
}

