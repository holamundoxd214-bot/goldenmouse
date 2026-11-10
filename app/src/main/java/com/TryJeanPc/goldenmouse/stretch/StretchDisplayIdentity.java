package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayIdentity;", "", "logicalId", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getLogicalId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchDisplayIdentity {
    public static final int $stable;
    private final int logicalId;
    private final String name;

    static {
    }

    public StretchDisplayIdentity(int arg1, String arg2) {
        super();
        this.logicalId = arg1;
        this.name = arg2;
    }

    public StretchDisplayIdentity(int arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public final int component1() {
        return this.logicalId;
    }

    public final String component2() {
        return this.name;
    }

    public final StretchDisplayIdentity copy(int arg1, String arg2) {
        return new StretchDisplayIdentity(arg1, arg2);
    }

    public static StretchDisplayIdentity copy$default(StretchDisplayIdentity arg0, int arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.logicalId;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.name;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchDisplayIdentity)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchDisplayIdentity)) {
            return 0;
        }

        if(this.logicalId != ((StretchDisplayIdentity)arg5).logicalId) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.name, ((StretchDisplayIdentity)arg5).name)) {
            return 0;
        }

        return 1;
    }

    public final int getLogicalId() {
        return this.logicalId;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int v0 = Integer.hashCode(this.logicalId) * 0x1F;
        String v1 = this.name;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return v0 + v1_1;
    }

    public String toString() {
        return "StretchDisplayIdentity(logicalId=" + this.logicalId + ", name=" + this.name + ")";
    }
}

