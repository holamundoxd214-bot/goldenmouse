package kotlin;

import java.io.Serializable;
import kotlin.js.JsImplicitExport;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00060\u0003j\u0002`\u0004B\u0019\bF\u0012\u0006\u0010\u0005\u001A\u00028\u0000\u0012\u0006\u0010\u0006\u001A\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\r\u001A\u00020\u000EH\u0096\u0080\u0004J\u000F\u0010\u000F\u001A\u00028\u0000HÆ\u0083\u0004¢\u0006\u0002\u0010\nJ\u000F\u0010\u0010\u001A\u00028\u0001HÆ\u0083\u0004¢\u0006\u0002\u0010\nJ/\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001A\u00028\u00002\b\b\u0002\u0010\u0006\u001A\u00028\u0001HÆ\u0081\u0004¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001A\u00020\u0018HÖ\u0081\u0004R\u0017\u0010\u0005\u001A\u00028\u0000X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001A\u00028\u0001X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\f\u0010\n¨\u0006\u0019"}, d2={"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "toString", "", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JsImplicitExport(couldBeConvertedToExplicitExport=true) public final class Pair implements Serializable {
    private final Object first;
    private final Object second;

    public Pair(Object arg1, Object arg2) {
        super();
        this.first = arg1;
        this.second = arg2;
    }

    public final Object component1() {
        return this.first;
    }

    public final Object component2() {
        return this.second;
    }

    public final Pair copy(Object arg1, Object arg2) {
        return new Pair(arg1, arg2);
    }

    public static Pair copy$default(Pair arg0, Object arg1, Object arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.first;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.second;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((Pair)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Pair)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.first, ((Pair)arg5).first)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.second, ((Pair)arg5).second)) {
            return 0;
        }

        return 1;
    }

    public final Object getFirst() {
        return this.first;
    }

    public final Object getSecond() {
        return this.second;
    }

    public int hashCode() {
        Object v0 = this.first;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        Object v2 = this.second;
        if(v2 == null) {
        }
        else {
            v1 = v2.hashCode();
        }

        return v0_1 + v1;
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}

