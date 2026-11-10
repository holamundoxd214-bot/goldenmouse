package kotlin;

import java.io.Serializable;
import kotlin.js.JsImplicitExport;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\u00060\u0004j\u0002`\u0005B!\bF\u0012\u0006\u0010\u0006\u001A\u00028\u0000\u0012\u0006\u0010\u0007\u001A\u00028\u0001\u0012\u0006\u0010\b\u001A\u00028\u0002¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004J\u000F\u0010\u0012\u001A\u00028\u0000HÆ\u0083\u0004¢\u0006\u0002\u0010\fJ\u000F\u0010\u0013\u001A\u00028\u0001HÆ\u0083\u0004¢\u0006\u0002\u0010\fJ\u000F\u0010\u0014\u001A\u00028\u0002HÆ\u0083\u0004¢\u0006\u0002\u0010\fJ?\u0010\u0015\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001A\u00028\u00002\b\b\u0002\u0010\u0007\u001A\u00028\u00012\b\b\u0002\u0010\b\u001A\u00028\u0002HÆ\u0081\u0004¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AHÖ\u0083\u0004J\n\u0010\u001B\u001A\u00020\u001CHÖ\u0081\u0004R\u0017\u0010\u0006\u001A\u00028\u0000X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0017\u0010\u0007\u001A\u00028\u0001X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000E\u0010\fR\u0017\u0010\b\u001A\u00028\u0002X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000F\u0010\f¨\u0006\u001D"}, d2={"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "toString", "", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JsImplicitExport(couldBeConvertedToExplicitExport=true) public final class Triple implements Serializable {
    private final Object first;
    private final Object second;
    private final Object third;

    public Triple(Object arg1, Object arg2, Object arg3) {
        super();
        this.first = arg1;
        this.second = arg2;
        this.third = arg3;
    }

    public final Object component1() {
        return this.first;
    }

    public final Object component2() {
        return this.second;
    }

    public final Object component3() {
        return this.third;
    }

    public final Triple copy(Object arg1, Object arg2, Object arg3) {
        return new Triple(arg1, arg2, arg3);
    }

    public static Triple copy$default(Triple arg0, Object arg1, Object arg2, Object arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.first;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.second;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.third;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((Triple)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Triple)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.first, ((Triple)arg5).first)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.second, ((Triple)arg5).second)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.third, ((Triple)arg5).third)) {
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

    public final Object getThird() {
        return this.third;
    }

    public int hashCode() {
        Object v0 = this.first;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        Object v2 = this.second;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Object v3 = this.third;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ", " + this.third + ')';
    }
}

