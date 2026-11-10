package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001A\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001D\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001A\u00020\u0010H\u0016J\u000E\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0010\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\u0015\u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0017J\u0018\u0010\u001B\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001A\u00020\u0012H\u0096\u0002¢\u0006\u0002\u0010\u001CJ\u001D\u0010\u001B\u001A\u00028\u00002\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u001D\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\u0015\u0010 \u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001A\u00020\u0007H\u0016J\u0010\u0010#\u001A\u00020\u00122\u0006\u0010$\u001A\u00020\u0004H\u0016J\u001D\u0010%\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0018\u0010&\u001A\u00020\u00102\u000E\u0010\'\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0016J\u001F\u0010(\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001EJ\u0010\u0010)\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\u001D\u0010)\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010*J\u0010\u0010+\u001A\u00020\u00102\u0006\u0010$\u001A\u00020\u0004H\u0016J\u001F\u0010,\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001EJ%\u0010,\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010-\u001A\u00028\u00002\u0006\u0010.\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010/J\u001D\u00100\u001A\u00020\u00102\u0006\u0010$\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0002\u00101J\b\u0010\n\u001A\u00020\u0004H\u0016J\b\u00102\u001A\u000203H\u0016J\u0015\u00104\u001A\u00028\u00002\u0006\u0010$\u001A\u00020\u0004H\u0016¢\u0006\u0002\u00105R\u0012\u0010\u0006\u001A\u00020\u00078\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u00020\t8\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001A\u00020\u00048\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0000@\u0000X\u0081\u000E¢\u0006\u0004\n\u0002\u0010\u000E¨\u00066"}, d2={"Landroidx/collection/LongSparseArray;", "E", "", "initialCapacity", "", "(I)V", "garbage", "", "keys", "", "size", "values", "", "", "[Ljava/lang/Object;", "append", "", "key", "", "value", "(JLjava/lang/Object;)V", "clear", "clone", "containsKey", "containsValue", "(Ljava/lang/Object;)Z", "delete", "get", "(J)Ljava/lang/Object;", "defaultValue", "(JLjava/lang/Object;)Ljava/lang/Object;", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "isEmpty", "keyAt", "index", "put", "putAll", "other", "putIfAbsent", "remove", "(JLjava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(JLjava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)V", "toString", "", "valueAt", "(I)Ljava/lang/Object;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public class LongSparseArray implements Cloneable {
    public LongSparseArray() {
        this(0, 1, null);
    }

    public LongSparseArray(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 10;
        }

        this(arg1);
    }

    public LongSparseArray(int arg2) {
        super();
        if(arg2 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
            return;
        }

        arg2 = ContainerHelpersKt.idealLongArraySize(arg2);
        this.keys = new long[arg2];
        this.values = new Object[arg2];
    }

    public void append(long arg10, Object arg12) {
        int v0 = this.size;
        if(v0 != 0 && arg10 <= this.keys[v0 - 1]) {
            this.put(arg10, arg12);
            return;
        }

        if(this.garbage) {
            long[] v1 = this.keys;
            if(v0 >= v1.length) {
                Object[] v2 = this.values;
                int v4 = 0;
                int v5 = 0;
                while(v4 < v0) {
                    Object v6 = v2[v4];
                    if(v6 != LongSparseArrayKt.access$getDELETED$p()) {
                        if(v4 != v5) {
                            v1[v5] = v1[v4];
                            v2[v5] = v6;
                            v2[v4] = null;
                        }

                        ++v5;
                    }

                    ++v4;
                }

                this.garbage = false;
                this.size = v5;
                v0 = v5;
            }
        }

        if(v0 >= this.keys.length) {
            int v1_1 = ContainerHelpersKt.idealLongArraySize(v0 + 1);
            long[] v2_1 = Arrays.copyOf(this.keys, v1_1);
            Intrinsics.checkNotNullExpressionValue(v2_1, "copyOf(...)");
            this.keys = v2_1;
            Object[] v1_2 = Arrays.copyOf(this.values, v1_1);
            Intrinsics.checkNotNullExpressionValue(v1_2, "copyOf(...)");
            this.values = v1_2;
        }

        this.keys[v0] = arg10;
        this.values[v0] = arg12;
        this.size = v0 + 1;
    }

    public void clear() {
        int v0 = this.size;
        Object[] v1 = this.values;
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1[v3] = null;
        }

        this.size = 0;
        this.garbage = false;
    }

    public LongSparseArray clone() {
        Object v0 = super.clone();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        ((LongSparseArray)v0).keys = this.keys.clone();
        ((LongSparseArray)v0).values = this.values.clone();
        return ((LongSparseArray)v0);
    }

    public Object clone() {
        return this.clone();
    }

    public boolean containsKey(long arg1) {
        if(this.indexOfKey(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    public boolean containsValue(Object arg1) {
        if(this.indexOfValue(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="Alias for `remove(key)`.", replaceWith="<_subannotation>") public void delete(long arg3) {
        int v3 = ContainerHelpersKt.binarySearch(this.keys, this.size, arg3);
        if(v3 >= 0 && this.values[v3] != LongSparseArrayKt.access$getDELETED$p()) {
            this.values[v3] = LongSparseArrayKt.access$getDELETED$p();
            this.garbage = true;
        }
    }

    public Object get(long arg3, Object arg5) {
        int v3 = ContainerHelpersKt.binarySearch(this.keys, this.size, arg3);
        if(v3 >= 0) {
            if(this.values[v3] == LongSparseArrayKt.access$getDELETED$p()) {
            }
            else {
                return this.values[v3];
            }
        }

        return arg5;
    }

    public Object get(long arg3) {
        int v3 = ContainerHelpersKt.binarySearch(this.keys, this.size, arg3);
        if(v3 >= 0) {
            if(this.values[v3] == LongSparseArrayKt.access$getDELETED$p()) {
            }
            else {
                return this.values[v3];
            }
        }

        return null;
    }

    public int indexOfKey(long arg10) {
        if(this.garbage) {
            int v0 = this.size;
            long[] v1 = this.keys;
            Object[] v2 = this.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v0) {
                Object v6 = v2[v4];
                if(v6 != LongSparseArrayKt.access$getDELETED$p()) {
                    if(v4 != v5) {
                        v1[v5] = v1[v4];
                        v2[v5] = v6;
                        v2[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            this.garbage = false;
            this.size = v5;
        }

        return ContainerHelpersKt.binarySearch(this.keys, this.size, arg10);
    }

    public int indexOfValue(Object arg10) {
        int v0;
        int v1 = 0;
        if(this.garbage) {
            v0 = this.size;
            long[] v2 = this.keys;
            Object[] v3 = this.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v0) {
                Object v6 = v3[v4];
                if(v6 != LongSparseArrayKt.access$getDELETED$p()) {
                    if(v4 != v5) {
                        v2[v5] = v2[v4];
                        v3[v5] = v6;
                        v3[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            this.garbage = false;
            this.size = v5;
        }

        v0 = this.size;
        while(v1 < v0) {
            if(this.values[v1] == arg10) {
                return v1;
            }

            ++v1;
        }

        return -1;
    }

    public boolean isEmpty() {
        if(this.size() == 0) {
            return 1;
        }

        return 0;
    }

    public long keyAt(int arg10) {
        int v1 = arg10 < 0 || arg10 >= this.size ? 0 : 1;
        if(v1 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg10);
        }

        if(this.garbage) {
            v1 = this.size;
            long[] v2 = this.keys;
            Object[] v3 = this.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v1) {
                Object v6 = v3[v4];
                if(v6 != LongSparseArrayKt.access$getDELETED$p()) {
                    if(v4 != v5) {
                        v2[v5] = v2[v4];
                        v3[v5] = v6;
                        v3[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            this.garbage = false;
            this.size = v5;
        }

        return this.keys[arg10];
    }

    public void put(long arg10, Object arg12) {
        long[] v2;
        int v1;
        int v0 = ContainerHelpersKt.binarySearch(this.keys, this.size, arg10);
        if(v0 >= 0) {
            this.values[v0] = arg12;
            return;
        }

        v0 = ~v0;
        if(v0 < this.size && this.values[v0] == LongSparseArrayKt.access$getDELETED$p()) {
            this.keys[v0] = arg10;
            this.values[v0] = arg12;
            return;
        }

        if(this.garbage) {
            v1 = this.size;
            v2 = this.keys;
            if(v1 >= v2.length) {
                Object[] v0_1 = this.values;
                int v4 = 0;
                int v5 = 0;
                while(v4 < v1) {
                    Object v6 = v0_1[v4];
                    if(v6 != LongSparseArrayKt.access$getDELETED$p()) {
                        if(v4 != v5) {
                            v2[v5] = v2[v4];
                            v0_1[v5] = v6;
                            v0_1[v4] = null;
                        }

                        ++v5;
                    }

                    ++v4;
                }

                this.garbage = false;
                this.size = v5;
                v0 = ~ContainerHelpersKt.binarySearch(this.keys, v5, arg10);
            }
        }

        v1 = this.size;
        if(v1 >= this.keys.length) {
            v1 = ContainerHelpersKt.idealLongArraySize(v1 + 1);
            v2 = Arrays.copyOf(this.keys, v1);
            Intrinsics.checkNotNullExpressionValue(v2, "copyOf(...)");
            this.keys = v2;
            Object[] v1_1 = Arrays.copyOf(this.values, v1);
            Intrinsics.checkNotNullExpressionValue(v1_1, "copyOf(...)");
            this.values = v1_1;
        }

        v1 = this.size;
        if(v1 - v0 != 0) {
            int v3 = v0 + 1;
            ArraysKt.copyInto(this.keys, this.keys, v3, v0, v1);
            ArraysKt.copyInto(this.values, this.values, v3, v0, this.size);
        }

        this.keys[v0] = arg10;
        this.values[v0] = arg12;
        ++this.size;
    }

    public void putAll(LongSparseArray arg6) {
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.put(arg6.keyAt(v1), arg6.valueAt(v1));
        }
    }

    public Object putIfAbsent(long arg2, Object arg4) {
        Object v0 = this.get(arg2);
        if(v0 == null) {
            this.put(arg2, arg4);
        }

        return v0;
    }

    public void remove(long arg3) {
        int v3 = ContainerHelpersKt.binarySearch(this.keys, this.size, arg3);
        if(v3 >= 0 && this.values[v3] != LongSparseArrayKt.access$getDELETED$p()) {
            this.values[v3] = LongSparseArrayKt.access$getDELETED$p();
            this.garbage = true;
        }
    }

    public boolean remove(long arg1, Object arg3) {
        int v1 = this.indexOfKey(arg1);
        if(v1 >= 0 && (Intrinsics.areEqual(arg3, this.valueAt(v1)))) {
            this.removeAt(v1);
            return 1;
        }

        return 0;
    }

    public void removeAt(int arg3) {
        if(this.values[arg3] != LongSparseArrayKt.access$getDELETED$p()) {
            this.values[arg3] = LongSparseArrayKt.access$getDELETED$p();
            this.garbage = true;
        }
    }

    public Object replace(long arg1, Object arg3) {
        int v1 = this.indexOfKey(arg1);
        if(v1 >= 0) {
            Object[] v0 = this.values;
            Object v2 = v0[v1];
            v0[v1] = arg3;
            return v2;
        }

        return null;
    }

    public boolean replace(long arg1, Object arg3, Object arg4) {
        int v1 = this.indexOfKey(arg1);
        if(v1 >= 0 && (Intrinsics.areEqual(this.values[v1], arg3))) {
            this.values[v1] = arg4;
            return 1;
        }

        return 0;
    }

    public void setValueAt(int arg10, Object arg11) {
        int v1 = arg10 < 0 || arg10 >= this.size ? 0 : 1;
        if(v1 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg10);
        }

        if(this.garbage) {
            v1 = this.size;
            long[] v2 = this.keys;
            Object[] v3 = this.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v1) {
                Object v6 = v3[v4];
                if(v6 != LongSparseArrayKt.access$getDELETED$p()) {
                    if(v4 != v5) {
                        v2[v5] = v2[v4];
                        v3[v5] = v6;
                        v3[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            this.garbage = false;
            this.size = v5;
        }

        this.values[arg10] = arg11;
    }

    public int size() {
        if(this.garbage) {
            int v0 = this.size;
            long[] v1 = this.keys;
            Object[] v2 = this.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v0) {
                Object v6 = v2[v4];
                if(v6 != LongSparseArrayKt.access$getDELETED$p()) {
                    if(v4 != v5) {
                        v1[v5] = v1[v4];
                        v2[v5] = v6;
                        v2[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            this.garbage = false;
            this.size = v5;
        }

        return this.size;
    }

    public String toString() {
        if(this.size() <= 0) {
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

            v1.append(this.keyAt(v2));
            v1.append('=');
            Object v3 = this.valueAt(v2);
            if((((StringBuilder)v3)) != v1) {
                v1.append(v3);
            }
            else {
                v1.append("(this Map)");
            }
        }

        v1.append('}');
        String v5 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
        return v5;
    }

    public Object valueAt(int arg10) {
        int v1 = arg10 < 0 || arg10 >= this.size ? 0 : 1;
        if(v1 == 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + arg10);
        }

        if(this.garbage) {
            v1 = this.size;
            long[] v2 = this.keys;
            Object[] v3 = this.values;
            int v4 = 0;
            int v5 = 0;
            while(v4 < v1) {
                Object v6 = v3[v4];
                if(v6 != LongSparseArrayKt.access$getDELETED$p()) {
                    if(v4 != v5) {
                        v2[v5] = v2[v4];
                        v3[v5] = v6;
                        v3[v4] = null;
                    }

                    ++v5;
                }

                ++v4;
            }

            this.garbage = false;
            this.size = v5;
        }

        return this.values[arg10];
    }
}

