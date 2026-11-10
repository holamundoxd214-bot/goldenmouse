package androidx.compose.runtime.tooling;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0011\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000EJ0\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001A\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001A\u00020\u001AHÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000E¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "", "groupKey", "", "sourceInfo", "Landroidx/compose/runtime/tooling/SourceInformation;", "groupOffset", "<init>", "(ILandroidx/compose/runtime/tooling/SourceInformation;Ljava/lang/Integer;)V", "getGroupKey", "()I", "getSourceInfo", "()Landroidx/compose/runtime/tooling/SourceInformation;", "getGroupOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(ILandroidx/compose/runtime/tooling/SourceInformation;Ljava/lang/Integer;)Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComposeStackTraceFrame {
    public static final int $stable = 8;
    private final int groupKey;
    private final Integer groupOffset;
    private final SourceInformation sourceInfo;

    static {
    }

    public ComposeStackTraceFrame(int arg1, SourceInformation arg2, Integer arg3) {
        super();
        this.groupKey = arg1;
        this.sourceInfo = arg2;
        this.groupOffset = arg3;
    }

    public final int component1() {
        return this.groupKey;
    }

    public final SourceInformation component2() {
        return this.sourceInfo;
    }

    public final Integer component3() {
        return this.groupOffset;
    }

    public final ComposeStackTraceFrame copy(int arg1, SourceInformation arg2, Integer arg3) {
        return new ComposeStackTraceFrame(arg1, arg2, arg3);
    }

    public static ComposeStackTraceFrame copy$default(ComposeStackTraceFrame arg0, int arg1, SourceInformation arg2, Integer arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.groupKey;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.sourceInfo;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.groupOffset;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((ComposeStackTraceFrame)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ComposeStackTraceFrame)) {
            return 0;
        }

        if(this.groupKey != ((ComposeStackTraceFrame)arg5).groupKey) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sourceInfo, ((ComposeStackTraceFrame)arg5).sourceInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.groupOffset, ((ComposeStackTraceFrame)arg5).groupOffset)) {
            return 0;
        }

        return 1;
    }

    public final int getGroupKey() {
        return this.groupKey;
    }

    public final Integer getGroupOffset() {
        return this.groupOffset;
    }

    public final SourceInformation getSourceInfo() {
        return this.sourceInfo;
    }

    public int hashCode() {
        int v0 = Integer.hashCode(this.groupKey) * 0x1F;
        SourceInformation v1 = this.sourceInfo;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        Integer v3 = this.groupOffset;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "ComposeStackTraceFrame(groupKey=" + this.groupKey + ", sourceInfo=" + this.sourceInfo + ", groupOffset=" + this.groupOffset + ')';
    }
}

