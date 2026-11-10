package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;", "", "agentGeneration", "", "ownerGeneration", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAgentGeneration", "()Ljava/lang/String;", "getOwnerGeneration", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRestorationIdentity {
    public static final int $stable;
    private final String agentGeneration;
    private final String ownerGeneration;

    static {
    }

    public StretchRestorationIdentity(String arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg3, "ownerGeneration");
        super();
        this.agentGeneration = arg2;
        this.ownerGeneration = arg3;
        if((StretchAgentProtocolKt.validAgentText(arg2)) && (StretchAgentProtocolKt.validAgentText(arg3))) {
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final String component1() {
        return this.agentGeneration;
    }

    public final String component2() {
        return this.ownerGeneration;
    }

    public final StretchRestorationIdentity copy(String arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg2, "ownerGeneration");
        return new StretchRestorationIdentity(arg1, arg2);
    }

    public static StretchRestorationIdentity copy$default(StretchRestorationIdentity arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.agentGeneration;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.ownerGeneration;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchRestorationIdentity)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchRestorationIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.agentGeneration, ((StretchRestorationIdentity)arg5).agentGeneration)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.ownerGeneration, ((StretchRestorationIdentity)arg5).ownerGeneration)) {
            return 0;
        }

        return 1;
    }

    public final String getAgentGeneration() {
        return this.agentGeneration;
    }

    public final String getOwnerGeneration() {
        return this.ownerGeneration;
    }

    public int hashCode() {
        return this.agentGeneration.hashCode() * 0x1F + this.ownerGeneration.hashCode();
    }

    public String toString() {
        return "StretchRestorationIdentity(agentGeneration=" + this.agentGeneration + ", ownerGeneration=" + this.ownerGeneration + ")";
    }
}

