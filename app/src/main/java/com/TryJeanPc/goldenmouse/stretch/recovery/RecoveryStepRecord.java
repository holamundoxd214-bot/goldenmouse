package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepRecord;", "", "step", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "ticket", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "outcome", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepOutcome;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepOutcome;)V", "getStep", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "getTicket", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "getOutcome", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepOutcome;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryStepRecord {
    public static final int $stable;
    private final RecoveryStepOutcome outcome;
    private final RecoveryStep step;
    private final RecoveryTicket ticket;

    static {
    }

    public RecoveryStepRecord(RecoveryStep arg2, RecoveryTicket arg3, RecoveryStepOutcome arg4) {
        Intrinsics.checkNotNullParameter(arg2, "step");
        Intrinsics.checkNotNullParameter(arg3, "ticket");
        Intrinsics.checkNotNullParameter(arg4, "outcome");
        super();
        this.step = arg2;
        this.ticket = arg3;
        this.outcome = arg4;
    }

    public final RecoveryStep component1() {
        return this.step;
    }

    public final RecoveryTicket component2() {
        return this.ticket;
    }

    public final RecoveryStepOutcome component3() {
        return this.outcome;
    }

    public final RecoveryStepRecord copy(RecoveryStep arg1, RecoveryTicket arg2, RecoveryStepOutcome arg3) {
        Intrinsics.checkNotNullParameter(arg1, "step");
        Intrinsics.checkNotNullParameter(arg2, "ticket");
        Intrinsics.checkNotNullParameter(arg3, "outcome");
        return new RecoveryStepRecord(arg1, arg2, arg3);
    }

    public static RecoveryStepRecord copy$default(RecoveryStepRecord arg0, RecoveryStep arg1, RecoveryTicket arg2, RecoveryStepOutcome arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.step;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.ticket;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.outcome;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryStepRecord)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryStepRecord)) {
            return 0;
        }

        if(this.step != ((RecoveryStepRecord)arg5).step) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.ticket, ((RecoveryStepRecord)arg5).ticket)) {
            return 0;
        }

        if(this.outcome != ((RecoveryStepRecord)arg5).outcome) {
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

    public final RecoveryTicket getTicket() {
        return this.ticket;
    }

    public int hashCode() {
        return (this.step.hashCode() * 0x1F + this.ticket.hashCode()) * 0x1F + this.outcome.hashCode();
    }

    public String toString() {
        return "RecoveryStepRecord(step=" + this.step + ", ticket=" + this.ticket + ", outcome=" + this.outcome + ")";
    }
}

