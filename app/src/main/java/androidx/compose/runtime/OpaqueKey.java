package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001A\u00020\u000EHÖ\u0081\u0004J\n\u0010\u000F\u001A\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/OpaqueKey;", "", "key", "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class OpaqueKey {
    public static final int $stable;
    private final String key;

    static {
    }

    public OpaqueKey(String arg1) {
        super();
        this.key = arg1;
    }

    public final String component1() {
        return this.key;
    }

    public final OpaqueKey copy(String arg1) {
        return new OpaqueKey(arg1);
    }

    public static OpaqueKey copy$default(OpaqueKey arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.key;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((OpaqueKey)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof OpaqueKey)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.key, ((OpaqueKey)arg4).key)) {
            return 0;
        }

        return 1;
    }

    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "OpaqueKey(key=" + this.key + ')';
    }
}

