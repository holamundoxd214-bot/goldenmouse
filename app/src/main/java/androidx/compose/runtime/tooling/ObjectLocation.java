package androidx.compose.runtime.tooling;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000FJ\u0014\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001A\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001A\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\n¨\u0006\u0016"}, d2={"Landroidx/compose/runtime/tooling/ObjectLocation;", "", "group", "", "dataOffset", "<init>", "(ILjava/lang/Integer;)V", "getGroup", "()I", "getDataOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Landroidx/compose/runtime/tooling/ObjectLocation;", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ObjectLocation {
    public static final int $stable;
    private final Integer dataOffset;
    private final int group;

    static {
    }

    public ObjectLocation(int arg1, Integer arg2) {
        super();
        this.group = arg1;
        this.dataOffset = arg2;
    }

    public final int component1() {
        return this.group;
    }

    public final Integer component2() {
        return this.dataOffset;
    }

    public final ObjectLocation copy(int arg1, Integer arg2) {
        return new ObjectLocation(arg1, arg2);
    }

    public static ObjectLocation copy$default(ObjectLocation arg0, int arg1, Integer arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.group;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.dataOffset;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((ObjectLocation)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ObjectLocation)) {
            return 0;
        }

        if(this.group != ((ObjectLocation)arg5).group) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.dataOffset, ((ObjectLocation)arg5).dataOffset)) {
            return 0;
        }

        return 1;
    }

    public final Integer getDataOffset() {
        return this.dataOffset;
    }

    public final int getGroup() {
        return this.group;
    }

    public int hashCode() {
        int v0 = Integer.hashCode(this.group) * 0x1F;
        Integer v1 = this.dataOffset;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return v0 + v1_1;
    }

    public String toString() {
        return "ObjectLocation(group=" + this.group + ", dataOffset=" + this.dataOffset + ')';
    }
}

