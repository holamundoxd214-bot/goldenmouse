package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0019\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\r\u001A\u00020\u0004HÆ\u0083\u0004J\u000F\u0010\u000E\u001A\u00028\u0000HÆ\u0083\u0004¢\u0006\u0002\u0010\u000BJ)\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00028\u0000HÆ\u0081\u0004¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0014\u001A\u00020\u0004HÖ\u0081\u0004J\n\u0010\u0015\u001A\u00020\u0016HÖ\u0081\u0004R\u0015\u0010\u0003\u001A\u00020\u0004X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001A\u00028\u0000X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Lkotlin/collections/IndexedValue;", "T", "", "index", "", "value", "<init>", "(ILjava/lang/Object;)V", "getIndex", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "equals", "", "other", "hashCode", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class IndexedValue {
    private final int index;
    private final Object value;

    public IndexedValue(int arg1, Object arg2) {
        super();
        this.index = arg1;
        this.value = arg2;
    }

    public final int component1() {
        return this.index;
    }

    public final Object component2() {
        return this.value;
    }

    public final IndexedValue copy(int arg1, Object arg2) {
        return new IndexedValue(arg1, arg2);
    }

    public static IndexedValue copy$default(IndexedValue arg0, int arg1, Object arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.index;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.value;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((IndexedValue)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof IndexedValue)) {
            return 0;
        }

        if(this.index != ((IndexedValue)arg5).index) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.value, ((IndexedValue)arg5).value)) {
            return 0;
        }

        return 1;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int v0 = Integer.hashCode(this.index) * 0x1F;
        Object v1 = this.value;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return v0 + v1_1;
    }

    public String toString() {
        return "IndexedValue(index=" + this.index + ", value=" + this.value + ')';
    }
}

