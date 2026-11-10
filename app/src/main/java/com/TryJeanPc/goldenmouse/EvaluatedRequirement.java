package com.TryJeanPc.goldenmouse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00072\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000F¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/EvaluatedRequirement;", "", "definition", "Lcom/TryJeanPc/goldenmouse/RequirementDefinition;", "status", "Lcom/TryJeanPc/goldenmouse/RequirementStatus;", "applicable", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/RequirementDefinition;Lcom/TryJeanPc/goldenmouse/RequirementStatus;Z)V", "getDefinition", "()Lcom/TryJeanPc/goldenmouse/RequirementDefinition;", "getStatus", "()Lcom/TryJeanPc/goldenmouse/RequirementStatus;", "getApplicable", "()Z", "blocksStart", "getBlocksStart", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EvaluatedRequirement {
    public static final int $stable;
    private final boolean applicable;
    private final RequirementDefinition definition;
    private final RequirementStatus status;

    static {
    }

    public EvaluatedRequirement(RequirementDefinition arg2, RequirementStatus arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg2, "definition");
        Intrinsics.checkNotNullParameter(arg3, "status");
        super();
        this.definition = arg2;
        this.status = arg3;
        this.applicable = arg4;
    }

    public final RequirementDefinition component1() {
        return this.definition;
    }

    public final RequirementStatus component2() {
        return this.status;
    }

    public final boolean component3() {
        return this.applicable;
    }

    public final EvaluatedRequirement copy(RequirementDefinition arg1, RequirementStatus arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "definition");
        Intrinsics.checkNotNullParameter(arg2, "status");
        return new EvaluatedRequirement(arg1, arg2, arg3);
    }

    public static EvaluatedRequirement copy$default(EvaluatedRequirement arg0, RequirementDefinition arg1, RequirementStatus arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.definition;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.status;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.applicable;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((EvaluatedRequirement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof EvaluatedRequirement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.definition, ((EvaluatedRequirement)arg5).definition)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.status, ((EvaluatedRequirement)arg5).status)) {
            return 0;
        }

        if(this.applicable != ((EvaluatedRequirement)arg5).applicable) {
            return 0;
        }

        return 1;
    }

    public final boolean getApplicable() {
        return this.applicable;
    }

    public final boolean getBlocksStart() {
        if((this.applicable) && this.definition.getType() == RequirementType.MANDATORY && this.status.getState() != RequirementState.SATISFIED) {
            return 1;
        }

        return 0;
    }

    public final RequirementDefinition getDefinition() {
        return this.definition;
    }

    public final RequirementStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (this.definition.hashCode() * 0x1F + this.status.hashCode()) * 0x1F + Boolean.hashCode(this.applicable);
    }

    public String toString() {
        return "EvaluatedRequirement(definition=" + this.definition + ", status=" + this.status + ", applicable=" + this.applicable + ")";
    }
}

