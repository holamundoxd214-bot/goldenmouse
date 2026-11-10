package com.TryJeanPc.goldenmouse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/RequirementStatus;", "", "state", "Lcom/TryJeanPc/goldenmouse/RequirementState;", "message", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/RequirementState;Ljava/lang/String;)V", "getState", "()Lcom/TryJeanPc/goldenmouse/RequirementState;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RequirementStatus {
    public static final int $stable;
    private final String message;
    private final RequirementState state;

    static {
    }

    public RequirementStatus(RequirementState arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "state");
        Intrinsics.checkNotNullParameter(arg3, "message");
        super();
        this.state = arg2;
        this.message = arg3;
    }

    public final RequirementState component1() {
        return this.state;
    }

    public final String component2() {
        return this.message;
    }

    public final RequirementStatus copy(RequirementState arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "state");
        Intrinsics.checkNotNullParameter(arg2, "message");
        return new RequirementStatus(arg1, arg2);
    }

    public static RequirementStatus copy$default(RequirementStatus arg0, RequirementState arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.state;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.message;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((RequirementStatus)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RequirementStatus)) {
            return 0;
        }

        if(this.state != ((RequirementStatus)arg5).state) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.message, ((RequirementStatus)arg5).message)) {
            return 0;
        }

        return 1;
    }

    public final String getMessage() {
        return this.message;
    }

    public final RequirementState getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode() * 0x1F + this.message.hashCode();
    }

    public String toString() {
        return "RequirementStatus(state=" + this.state + ", message=" + this.message + ")";
    }
}

