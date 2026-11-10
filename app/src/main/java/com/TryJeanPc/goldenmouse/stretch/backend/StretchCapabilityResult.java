package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchCapabilityResult;", "", "capability", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchCapability;", "evidence", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchEvidence;", "reason", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchCapability;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchEvidence;Ljava/lang/String;)V", "getCapability", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchCapability;", "getEvidence", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchEvidence;", "getReason", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCapabilityResult {
    public static final int $stable;
    private final StretchCapability capability;
    private final StretchEvidence evidence;
    private final String reason;

    static {
    }

    public StretchCapabilityResult(StretchCapability arg2, StretchEvidence arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg2, "capability");
        Intrinsics.checkNotNullParameter(arg3, "evidence");
        Intrinsics.checkNotNullParameter(arg4, "reason");
        super();
        this.capability = arg2;
        this.evidence = arg3;
        this.reason = arg4;
    }

    public final StretchCapability component1() {
        return this.capability;
    }

    public final StretchEvidence component2() {
        return this.evidence;
    }

    public final String component3() {
        return this.reason;
    }

    public final StretchCapabilityResult copy(StretchCapability arg1, StretchEvidence arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg1, "capability");
        Intrinsics.checkNotNullParameter(arg2, "evidence");
        Intrinsics.checkNotNullParameter(arg3, "reason");
        return new StretchCapabilityResult(arg1, arg2, arg3);
    }

    public static StretchCapabilityResult copy$default(StretchCapabilityResult arg0, StretchCapability arg1, StretchEvidence arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.capability;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.evidence;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.reason;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchCapabilityResult)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchCapabilityResult)) {
            return 0;
        }

        if(this.capability != ((StretchCapabilityResult)arg5).capability) {
            return 0;
        }

        if(this.evidence != ((StretchCapabilityResult)arg5).evidence) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.reason, ((StretchCapabilityResult)arg5).reason)) {
            return 0;
        }

        return 1;
    }

    public final StretchCapability getCapability() {
        return this.capability;
    }

    public final StretchEvidence getEvidence() {
        return this.evidence;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        return (this.capability.hashCode() * 0x1F + this.evidence.hashCode()) * 0x1F + this.reason.hashCode();
    }

    public String toString() {
        return "StretchCapabilityResult(capability=" + this.capability + ", evidence=" + this.evidence + ", reason=" + this.reason + ")";
    }
}

