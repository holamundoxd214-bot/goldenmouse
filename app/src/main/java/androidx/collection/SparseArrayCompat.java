package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001A\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001F\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001D\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0013H\u0016J\u000E\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u0010\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0004H\u0016J\u0015\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0004H\u0017J\u0018\u0010\u001D\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001A\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u001EJ\u001D\u0010\u001D\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u001F\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0004H\u0016J\u0015\u0010\"\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\b\u0010\b\u001A\u00020\u0007H\u0016J\u0010\u0010$\u001A\u00020\u00042\u0006\u0010%\u001A\u00020\u0004H\u0016J\u001D\u0010&\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0018\u0010\'\u001A\u00020\u00132\u000E\u0010(\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0016J\u001F\u0010)\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u0010\u0010*\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0004H\u0016J\u001A\u0010*\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00042\b\u0010\u0015\u001A\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010+\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u0004H\u0016J\u0018\u0010,\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u0004H\u0016J\u001F\u0010-\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010 J%\u0010-\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010.\u001A\u00028\u00002\u0006\u0010/\u001A\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u001D\u00101\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\r\u001A\u00020\u0004H\u0016J\b\u00102\u001A\u000203H\u0016J\u0015\u00104\u001A\u00028\u00002\u0006\u0010%\u001A\u00020\u0004H\u0016¢\u0006\u0002\u0010\u001ER\u0012\u0010\u0006\u001A\u00020\u00078\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\u00078G¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0012\u0010\u000B\u001A\u00020\f8\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001A\u00020\u00048\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000F8\u0000@\u0000X\u0081\u000E¢\u0006\u0004\n\u0002\u0010\u0011¨\u00065"}, d2={"Landroidx/collection/SparseArrayCompat;", "E", "", "initialCapacity", "", "(I)V", "garbage", "", "isEmpty", "getIsEmpty", "()Z", "keys", "", "size", "values", "", "", "[Ljava/lang/Object;", "append", "", "key", "value", "(ILjava/lang/Object;)V", "clear", "clone", "containsKey", "containsValue", "(Ljava/lang/Object;)Z", "delete", "get", "(I)Ljava/lang/Object;", "defaultValue", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "keyAt", "index", "put", "putAll", "other", "putIfAbsent", "remove", "removeAt", "removeAtRange", "replace", "oldValue", "newValue", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "toString", "", "valueAt", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public class SparseArrayCompat implements Cloneable {
    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public SparseArrayCompat(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 10;
        }

        this(arg1);
    }

    public SparseArrayCompat(int arg2) {
        super();
        if(arg2 == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
            return;
        }

        arg2 = ContainerHelpersKt.idealIntArraySize(arg2);
        this.keys = new int[arg2];
        this.values = new Object[arg2];
    }

    public void append(int arg5, Object arg6) {
        int v0 = this.size;
        if(v0 != 0 && arg5 <= this.keys[v0 - 1]) {
            this.put(arg5, arg6);
            return;
        }

        if((this.garbage) && v0 >= this.keys.length) {
            SparseArrayCompatKt.access$gc(this);
        }

        v0 = this.size;
        if(v0 >= this.keys.length) {
            int v1 = ContainerHelpersKt.idealIntArraySize(v0 + 1);
            int[] v2 = Arrays.copyOf(this.keys, v1);
            Intrinsics.checkNotNullExpressionValue(v2, "copyOf(...)");
            this.keys = v2;
            Object[] v1_1 = Arrays.copyOf(this.values, v1);
            Intrinsics.checkNotNullExpressionValue(v1_1, "copyOf(...)");
            this.values = v1_1;
        }

        this.keys[v0] = arg5;
        this.values[v0] = arg6;
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

    public SparseArrayCompat clone() {
        Object v0 = super.clone();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        ((SparseArrayCompat)v0).keys = this.keys.clone();
        ((SparseArrayCompat)v0).values = this.values.clone();
        return ((SparseArrayCompat)v0);
    }

    public Object clone() {
        return this.clone();
    }

    public boolean containsKey(int arg1) {
        if(this.indexOfKey(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    public boolean containsValue(Object arg5) {
        if(this.garbage) {
            SparseArrayCompatKt.access$gc(this);
        }

        int v0 = this.size;
        int v2 = 0;
        while(true) {
            if(v2 >= v0) {
                break;
            }
            else if(this.values[v2] == arg5) {
            }
            else {
                ++v2;
                continue;
            }

            goto label_14;
        }

        v2 = -1;
    label_14:
        if(v2 >= 0) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="Alias for remove(int).", replaceWith="<_subannotation>") public void delete(int arg1) {
        this.remove(arg1);
    }

    public Object get(int arg1, Object arg2) {
        return SparseArrayCompatKt.commonGet(this, arg1, arg2);
    }

    public Object get(int arg1) {
        return SparseArrayCompatKt.commonGet(this, arg1);
    }

    public final boolean getIsEmpty() {
        return this.isEmpty();
    }

    public int indexOfKey(int arg2) {
        if(this.garbage) {
            SparseArrayCompatKt.access$gc(this);
        }

        return ContainerHelpersKt.binarySearch(this.keys, this.size, arg2);
    }

    public int indexOfValue(Object arg4) {
        if(this.garbage) {
            SparseArrayCompatKt.access$gc(this);
        }

        int v0 = this.size;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(this.values[v1] == arg4) {
                return v1;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        if(this.size() == 0) {
            return 1;
        }

        return 0;
    }

    public int keyAt(int arg2) {
        if(this.garbage) {
            SparseArrayCompatKt.access$gc(this);
        }

        return this.keys[arg2];
    }

    public void put(int arg5, Object arg6) {
        int v0 = ContainerHelpersKt.binarySearch(this.keys, this.size, arg5);
        if(v0 >= 0) {
            this.values[v0] = arg6;
            return;
        }

        v0 = ~v0;
        if(v0 < this.size && this.values[v0] == SparseArrayCompatKt.access$getDELETED$p()) {
            this.keys[v0] = arg5;
            this.values[v0] = arg6;
            return;
        }

        if((this.garbage) && this.size >= this.keys.length) {
            SparseArrayCompatKt.access$gc(this);
            v0 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, arg5);
        }

        int v1 = this.size;
        if(v1 >= this.keys.length) {
            v1 = ContainerHelpersKt.idealIntArraySize(v1 + 1);
            int[] v2 = Arrays.copyOf(this.keys, v1);
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

        this.keys[v0] = arg5;
        this.values[v0] = arg6;
        ++this.size;
    }

    public void putAll(SparseArrayCompat arg9) {
        Intrinsics.checkNotNullParameter(arg9, "other");
        int v0 = arg9.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            int v2 = arg9.keyAt(v1);
            Object v3 = arg9.valueAt(v1);
            int v4 = ContainerHelpersKt.binarySearch(this.keys, this.size, v2);
            if(v4 >= 0) {
                this.values[v4] = v3;
            }
            else {
                v4 = ~v4;
                if(v4 < this.size && this.values[v4] == SparseArrayCompatKt.access$getDELETED$p()) {
                    this.keys[v4] = v2;
                    this.values[v4] = v3;
                    goto label_68;
                }

                if((this.garbage) && this.size >= this.keys.length) {
                    SparseArrayCompatKt.access$gc(this);
                    v4 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, v2);
                }

                int v5 = this.size;
                if(v5 >= this.keys.length) {
                    v5 = ContainerHelpersKt.idealIntArraySize(v5 + 1);
                    int[] v6 = Arrays.copyOf(this.keys, v5);
                    Intrinsics.checkNotNullExpressionValue(v6, "copyOf(...)");
                    this.keys = v6;
                    Object[] v5_1 = Arrays.copyOf(this.values, v5);
                    Intrinsics.checkNotNullExpressionValue(v5_1, "copyOf(...)");
                    this.values = v5_1;
                }

                v5 = this.size;
                if(v5 - v4 != 0) {
                    int v7 = v4 + 1;
                    ArraysKt.copyInto(this.keys, this.keys, v7, v4, v5);
                    ArraysKt.copyInto(this.values, this.values, v7, v4, this.size);
                }

                this.keys[v4] = v2;
                this.values[v4] = v3;
                ++this.size;
            }

        label_68:
        }
    }

    public Object putIfAbsent(int arg6, Object arg7) {
        Object v0 = SparseArrayCompatKt.commonGet(this, arg6);
        if(v0 == null) {
            int v1 = ContainerHelpersKt.binarySearch(this.keys, this.size, arg6);
            if(v1 >= 0) {
                this.values[v1] = arg7;
                return v0;
            }
            else {
                v1 = ~v1;
                if(v1 < this.size && this.values[v1] == SparseArrayCompatKt.access$getDELETED$p()) {
                    this.keys[v1] = arg6;
                    this.values[v1] = arg7;
                    return v0;
                }

                if((this.garbage) && this.size >= this.keys.length) {
                    SparseArrayCompatKt.access$gc(this);
                    v1 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, arg6);
                }

                int v2 = this.size;
                if(v2 >= this.keys.length) {
                    v2 = ContainerHelpersKt.idealIntArraySize(v2 + 1);
                    int[] v3 = Arrays.copyOf(this.keys, v2);
                    Intrinsics.checkNotNullExpressionValue(v3, "copyOf(...)");
                    this.keys = v3;
                    Object[] v2_1 = Arrays.copyOf(this.values, v2);
                    Intrinsics.checkNotNullExpressionValue(v2_1, "copyOf(...)");
                    this.values = v2_1;
                }

                v2 = this.size;
                if(v2 - v1 != 0) {
                    int v4 = v1 + 1;
                    ArraysKt.copyInto(this.keys, this.keys, v4, v1, v2);
                    ArraysKt.copyInto(this.values, this.values, v4, v1, this.size);
                }

                this.keys[v1] = arg6;
                this.values[v1] = arg7;
                ++this.size;
            }
        }

        return v0;
    }

    public void remove(int arg1) {
        SparseArrayCompatKt.commonRemove(this, arg1);
    }

    public boolean remove(int arg2, Object arg3) {
        arg2 = this.indexOfKey(arg2);
        if(arg2 >= 0 && (Intrinsics.areEqual(arg3, this.valueAt(arg2)))) {
            this.removeAt(arg2);
            return 1;
        }

        return 0;
    }

    public void removeAt(int arg3) {
        if(this.values[arg3] != SparseArrayCompatKt.access$getDELETED$p()) {
            this.values[arg3] = SparseArrayCompatKt.access$getDELETED$p();
            this.garbage = true;
        }
    }

    public void removeAtRange(int arg2, int arg3) {
        arg3 = Math.min(arg3, arg2 + arg3);
        while(arg2 < arg3) {
            this.removeAt(arg2);
            ++arg2;
        }
    }

    public Object replace(int arg2, Object arg3) {
        arg2 = this.indexOfKey(arg2);
        if(arg2 >= 0) {
            Object[] v1 = this.values;
            Object v0 = v1[arg2];
            v1[arg2] = arg3;
            return v0;
        }

        return null;
    }

    public boolean replace(int arg2, Object arg3, Object arg4) {
        arg2 = this.indexOfKey(arg2);
        if(arg2 >= 0 && (Intrinsics.areEqual(this.values[arg2], arg3))) {
            this.values[arg2] = arg4;
            return 1;
        }

        return 0;
    }

    public void setValueAt(int arg2, Object arg3) {
        if(this.garbage) {
            SparseArrayCompatKt.access$gc(this);
        }

        this.values[arg2] = arg3;
    }

    public int size() {
        if(this.garbage) {
            SparseArrayCompatKt.access$gc(this);
        }

        return this.size;
    }

    public String toString() {
        if(this.size() <= 0) {
            return "{}";
        }

        StringBuilder v0 = new StringBuilder(this.size * 28);
        v0.append('{');
        int v1 = this.size;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            if(v2 > 0) {
                v0.append(", ");
            }

            v0.append(this.keyAt(v2));
            v0.append('=');
            Object v3 = this.valueAt(v2);
            if((((SparseArrayCompat)v3)) != this) {
                v0.append(v3);
            }
            else {
                v0.append("(this Map)");
            }
        }

        v0.append('}');
        String v4 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v4, "toString(...)");
        return v4;
    }

    public Object valueAt(int arg2) {
        if(this.garbage) {
            SparseArrayCompatKt.access$gc(this);
        }

        Object[] v1 = this.values;
        if(arg2 < v1.length) {
            return v1[arg2];
        }

        throw new ArrayIndexOutOfBoundsException();
    }
}

