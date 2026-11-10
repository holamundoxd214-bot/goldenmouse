package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u000E2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalAssessment;", "", "compatibility", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompatibility;", "reasons", "", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompatibility;Ljava/util/Set;)V", "getCompatibility", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompatibility;", "getReasons", "()Ljava/util/Set;", "physicalMutationAllowed", "", "getPhysicalMutationAllowed", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPhysicalAssessment {
    public static final int $stable = 8;
    private final StretchCompatibility compatibility;
    private final Set reasons;

    static {
    }

    public StretchPhysicalAssessment(StretchCompatibility arg2, Set arg3) {
        Intrinsics.checkNotNullParameter(arg2, "compatibility");
        Intrinsics.checkNotNullParameter(arg3, "reasons");
        super();
        this.compatibility = arg2;
        this.reasons = arg3;
    }

    public final StretchCompatibility component1() {
        return this.compatibility;
    }

    public final Set component2() {
        return this.reasons;
    }

    public final StretchPhysicalAssessment copy(StretchCompatibility arg1, Set arg2) {
        Intrinsics.checkNotNullParameter(arg1, "compatibility");
        Intrinsics.checkNotNullParameter(arg2, "reasons");
        return new StretchPhysicalAssessment(arg1, arg2);
    }

    public static StretchPhysicalAssessment copy$default(StretchPhysicalAssessment arg0, StretchCompatibility arg1, Set arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.compatibility;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.reasons;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchPhysicalAssessment)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchPhysicalAssessment)) {
            return 0;
        }

        if(this.compatibility != ((StretchPhysicalAssessment)arg5).compatibility) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.reasons, ((StretchPhysicalAssessment)arg5).reasons)) {
            return 0;
        }

        return 1;
    }

    public final StretchCompatibility getCompatibility() {
        return this.compatibility;
    }

    public final boolean getPhysicalMutationAllowed() {
        return 0;
    }

    public final Set getReasons() {
        return this.reasons;
    }

    public int hashCode() {
        return this.compatibility.hashCode() * 0x1F + this.reasons.hashCode();
    }

    public String toString() {
        return "StretchPhysicalAssessment(compatibility=" + this.compatibility + ", reasons=" + this.reasons + ")";
    }
}

