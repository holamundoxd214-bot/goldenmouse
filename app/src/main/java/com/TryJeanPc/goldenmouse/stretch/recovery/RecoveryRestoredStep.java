package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryRestoredStep;", "", "step", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "outcome", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepOutcome;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepOutcome;)V", "getStep", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "getOutcome", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepOutcome;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryRestoredStep {
    public static final int $stable;
    private final RecoveryStepOutcome outcome;
    private final RecoveryStep step;

    static {
    }

    public RecoveryRestoredStep(RecoveryStep arg2, RecoveryStepOutcome arg3) {
        Intrinsics.checkNotNullParameter(arg2, "step");
        Intrinsics.checkNotNullParameter(arg3, "outcome");
        super();
        this.step = arg2;
        this.outcome = arg3;
    }

    public final RecoveryStep component1() {
        return this.step;
    }

    public final RecoveryStepOutcome component2() {
        return this.outcome;
    }

    public final RecoveryRestoredStep copy(RecoveryStep arg1, RecoveryStepOutcome arg2) {
        Intrinsics.checkNotNullParameter(arg1, "step");
        Intrinsics.checkNotNullParameter(arg2, "outcome");
        return new RecoveryRestoredStep(arg1, arg2);
    }

    public static RecoveryRestoredStep copy$default(RecoveryRestoredStep arg0, RecoveryStep arg1, RecoveryStepOutcome arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.step;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.outcome;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryRestoredStep)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryRestoredStep)) {
            return 0;
        }

        if(this.step != ((RecoveryRestoredStep)arg5).step) {
            return 0;
        }

        if(this.outcome != ((RecoveryRestoredStep)arg5).outcome) {
            return 0;
        }

        return 1;
    }

    public final RecoveryStepOutcome getOutcome() {
        return this.outcome;
    }

    public final RecoveryStep getStep() {
        return this.step;
    }

    public int hashCode() {
        return this.step.hashCode() * 0x1F + this.outcome.hashCode();
    }

    public String toString() {
        return "RecoveryRestoredStep(step=" + this.step + ", outcome=" + this.outcome + ")";
    }
}

