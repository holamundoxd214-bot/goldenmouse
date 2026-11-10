package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000F\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJ\u0018\u0010\b\u001A\u00020\f2\b\b\u0001\u0010\r\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000BJ\u0011\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0001H\u0086\bJ\u0011\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0010H\u0086\bJ\u0018\u0010\u000E\u001A\u00020\t2\b\b\u0001\u0010\r\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0001J\u0018\u0010\u000E\u001A\u00020\t2\b\b\u0001\u0010\r\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0010J\u0006\u0010\u0011\u001A\u00020\fJ\u000E\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u0003J\u0011\u0010\u0013\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0001H\u0086\u0002J\u0011\u0010\u0013\u001A\u00020\f2\u0006\u0010\n\u001A\u00020\u000BH\u0086\nJ\u0011\u0010\u0013\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0010H\u0086\u0002J\u0011\u0010\u0014\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0001H\u0086\nJ\u0011\u0010\u0014\u001A\u00020\f2\u0006\u0010\n\u001A\u00020\u000BH\u0086\nJ\u0011\u0010\u0014\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0010H\u0086\nJ\u000E\u0010\u0015\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\u0016\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0001J\u000E\u0010\u0016\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0010J\u0010\u0010\u0017\u001A\u00020\u000B2\b\b\u0001\u0010\r\u001A\u00020\u0003J\u001A\u0010\u0018\u001A\u00020\f2\b\b\u0001\u0010\u0019\u001A\u00020\u00032\b\b\u0001\u0010\u001A\u001A\u00020\u0003J\u000E\u0010\u001B\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0001J\u000E\u0010\u001B\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0010J\u001B\u0010\u001C\u001A\u00020\u000B2\b\b\u0001\u0010\r\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000BH\u0086\u0002J\u0006\u0010\u001D\u001A\u00020\fJ\u0006\u0010\u001E\u001A\u00020\fJ\u0010\u0010\u001F\u001A\u00020\f2\b\b\u0002\u0010 \u001A\u00020\u0003R\u0012\u0010\u0005\u001A\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2={"Landroidx/collection/MutableDoubleList;", "Landroidx/collection/DoubleList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", "add", "", "element", "", "", "index", "addAll", "elements", "", "clear", "ensureCapacity", "minusAssign", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "set", "sort", "sortDescending", "trim", "minCapacity", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class MutableDoubleList extends DoubleList {
    public MutableDoubleList(int arg2) {
        super(arg2, null);
    }

    public MutableDoubleList(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 16;
        }

        this(arg1);
    }

    public MutableDoubleList() {
        this(0, 1, null);
    }

    public final boolean add(double arg4) {
        this.ensureCapacity(this._size + 1);
        this.content[this._size] = arg4;
        ++this._size;
        return 1;
    }

    public final void add(int arg4, double arg5) {
        if(arg4 < 0 || arg4 > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        else {
        }

        this.ensureCapacity(this._size + 1);
        double[] v0 = this.content;
        if(arg4 != this._size) {
            ArraysKt.copyInto(v0, v0, arg4 + 1, arg4, this._size);
        }

        v0[arg4] = arg5;
        ++this._size;
    }

    public final boolean addAll(int arg9, double[] arg10) {
        Intrinsics.checkNotNullParameter(arg10, "elements");
        if(arg9 < 0 || arg9 > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }
        else {
        }

        if(arg10.length == 0) {
            return 0;
        }

        this.ensureCapacity(this._size + arg10.length);
        double[] v2 = this.content;
        if(arg9 != this._size) {
            ArraysKt.copyInto(v2, v2, arg10.length + arg9, arg9, this._size);
        }

        ArraysKt.copyInto$default(arg10, v2, arg9, 0, 0, 12, null);
        this._size += arg10.length;
        return 1;
    }

    public final boolean addAll(int arg5, DoubleList arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        if(arg5 < 0 || arg5 > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
        }
        else {
        }

        if(arg6._size == 0) {
            return 0;
        }

        this.ensureCapacity(this._size + arg6._size);
        double[] v0 = this.content;
        if(arg5 != this._size) {
            ArraysKt.copyInto(v0, v0, arg6._size + arg5, arg5, this._size);
        }

        ArraysKt.copyInto(arg6.content, v0, arg5, 0, arg6._size);
        this._size += arg6._size;
        return 1;
    }

    public final boolean addAll(DoubleList arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return this.addAll(this._size, arg2);
    }

    public final boolean addAll(double[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return this.addAll(this._size, arg2);
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int arg3) {
        double[] v0 = this.content;
        if(v0.length < arg3) {
            double[] v3 = Arrays.copyOf(v0, Math.max(arg3, v0.length * 3 / 2));
            Intrinsics.checkNotNullExpressionValue(v3, "copyOf(...)");
            this.content = v3;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(double arg1) {
        this.remove(arg1);
    }

    public final void minusAssign(DoubleList arg5) {
        Intrinsics.checkNotNullParameter(arg5, "elements");
        double[] v0 = arg5.content;
        int v5 = arg5._size;
        int v1;
        for(v1 = 0; v1 < v5; ++v1) {
            this.remove(v0[v1]);
        }
    }

    public final void minusAssign(double[] arg5) {
        Intrinsics.checkNotNullParameter(arg5, "elements");
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            this.remove(arg5[v1]);
        }
    }

    public final void plusAssign(double arg1) {
        this.add(arg1);
    }

    public final void plusAssign(DoubleList arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        this.addAll(this._size, arg2);
    }

    public final void plusAssign(double[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        this.addAll(this._size, arg2);
    }

    public final boolean remove(double arg1) {
        int v1 = this.indexOf(arg1);
        if(v1 >= 0) {
            this.removeAt(v1);
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(DoubleList arg8) {
        Intrinsics.checkNotNullParameter(arg8, "elements");
        int v0 = this._size;
        int v1 = arg8._size - 1;
        if(v1 >= 0) {
            int v4 = 0;
            while(true) {
                this.remove(arg8.get(v4));
                if(v4 != v1) {
                    ++v4;
                    continue;
                }

                break;
            }
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(double[] arg7) {
        Intrinsics.checkNotNullParameter(arg7, "elements");
        int v0 = this._size;
        int v1 = arg7.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            this.remove(arg7[v3]);
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final double removeAt(int arg6) {
        if(arg6 < 0 || arg6 >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        else {
        }

        double[] v0 = this.content;
        double v1 = v0[arg6];
        if(arg6 != this._size - 1) {
            ArraysKt.copyInto(v0, v0, arg6, arg6 + 1, this._size);
        }

        --this._size;
        return v1;
    }

    public final void removeRange(int arg4, int arg5) {
        if(arg4 < 0 || arg4 > this._size || arg5 < 0 || arg5 > this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        else {
        }

        if(arg5 < arg4) {
            RuntimeHelpersKt.throwIllegalArgumentException("The end index must be < start index");
        }

        if(arg5 != arg4) {
            if(arg5 < this._size) {
                ArraysKt.copyInto(this.content, this.content, arg4, arg5, this._size);
            }

            this._size -= arg5 - arg4;
        }
    }

    public final boolean retainAll(DoubleList arg7) {
        Intrinsics.checkNotNullParameter(arg7, "elements");
        int v0 = this._size;
        double[] v1 = this.content;
        int v2;
        for(v2 = this._size - 1; -1 < v2; --v2) {
            if(!arg7.contains(v1[v2])) {
                this.removeAt(v2);
            }
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final boolean retainAll(double[] arg12) {
        Intrinsics.checkNotNullParameter(arg12, "elements");
        int v0 = this._size;
        double[] v1 = this.content;
        int v2;
        for(v2 = this._size - 1; true; --v2) {
            int v4 = 0;
            int v5 = -1;
            if(v5 >= v2) {
                break;
            }

            double v6 = v1[v2];
            int v8 = arg12.length;
            while(v4 < v8) {
                if(arg12[v4] == v6) {
                    v5 = v4;
                }
                else {
                    ++v4;
                    continue;
                }

                break;
            }

            if(v5 < 0) {
                this.removeAt(v2);
            }
        }

        if(v0 != this._size) {
            return 1;
        }

        return 0;
    }

    public final double set(int arg3, double arg4) {
        if(arg3 < 0 || arg3 >= this._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
        }
        else {
        }

        double[] v2 = this.content;
        double v0 = v2[arg3];
        v2[arg3] = arg4;
        return v0;
    }

    public final void sort() {
        if(this._size == 0) {
            return;
        }

        ArraysKt.sort(this.content, 0, this._size);
    }

    public final void sortDescending() {
        if(this._size == 0) {
            return;
        }

        ArraysKt.sortDescending(this.content, 0, this._size);
    }

    public final void trim(int arg2) {
        arg2 = Math.max(arg2, this._size);
        if(this.content.length > arg2) {
            double[] v2 = Arrays.copyOf(this.content, arg2);
            Intrinsics.checkNotNullExpressionValue(v2, "copyOf(...)");
            this.content = v2;
        }
    }

    public static void trim$default(MutableDoubleList arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0._size;
        }

        arg0.trim(arg1);
    }
}

