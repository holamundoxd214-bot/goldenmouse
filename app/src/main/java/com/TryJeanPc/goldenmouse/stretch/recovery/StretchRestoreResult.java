package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0005HÆ\u0003J\u000F\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001D\u001A\u00020\fHÆ\u0003JC\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000B\u001A\u00020\fHÆ\u0001J\u0013\u0010\u001F\u001A\u00020\f2\b\u0010 \u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001A\u00020\"HÖ\u0001J\t\u0010#\u001A\u00020$HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreResult;", "", "ticket", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "status", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreStatus;", "steps", "", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryRestoredStep;", "observedOriginal", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;", "executionStopped", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreStatus;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;Z)V", "getTicket", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "getStatus", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreStatus;", "getSteps", "()Ljava/util/List;", "getObservedOriginal", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;", "getExecutionStopped", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRestoreResult {
    public static final int $stable = 8;
    private final boolean executionStopped;
    private final StretchOriginalDisplayState observedOriginal;
    private final StretchRestoreStatus status;
    private final List steps;
    private final RecoveryTicket ticket;

    static {
    }

    public StretchRestoreResult(RecoveryTicket arg2, StretchRestoreStatus arg3, List arg4, StretchOriginalDisplayState arg5, boolean arg6) {
        Intrinsics.checkNotNullParameter(arg2, "ticket");
        Intrinsics.checkNotNullParameter(arg3, "status");
        Intrinsics.checkNotNullParameter(arg4, "steps");
        super();
        this.ticket = arg2;
        this.status = arg3;
        this.steps = arg4;
        this.observedOriginal = arg5;
        this.executionStopped = arg6;
    }

    public final RecoveryTicket component1() {
        return this.ticket;
    }

    public final StretchRestoreStatus component2() {
        return this.status;
    }

    public final List component3() {
        return this.steps;
    }

    public final StretchOriginalDisplayState component4() {
        return this.observedOriginal;
    }

    public final boolean component5() {
        return this.executionStopped;
    }

    public final StretchRestoreResult copy(RecoveryTicket arg7, StretchRestoreStatus arg8, List arg9, StretchOriginalDisplayState arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg7, "ticket");
        Intrinsics.checkNotNullParameter(arg8, "status");
        Intrinsics.checkNotNullParameter(arg9, "steps");
        return new StretchRestoreResult(arg7, arg8, arg9, arg10, arg11);
    }

    public static StretchRestoreResult copy$default(StretchRestoreResult arg0, RecoveryTicket arg1, StretchRestoreStatus arg2, List arg3, StretchOriginalDisplayState arg4, boolean arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.ticket;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.status;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.steps;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.observedOriginal;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.executionStopped;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchRestoreResult)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchRestoreResult)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.ticket, ((StretchRestoreResult)arg5).ticket)) {
            return 0;
        }

        if(this.status != ((StretchRestoreResult)arg5).status) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.steps, ((StretchRestoreResult)arg5).steps)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.observedOriginal, ((StretchRestoreResult)arg5).observedOriginal)) {
            return 0;
        }

        if(this.executionStopped != ((StretchRestoreResult)arg5).executionStopped) {
            return 0;
        }

        return 1;
    }

    public final boolean getExecutionStopped() {
        return this.executionStopped;
    }

    public final StretchOriginalDisplayState getObservedOriginal() {
        return this.observedOriginal;
    }

    public final StretchRestoreStatus getStatus() {
        return this.status;
    }

    public final List getSteps() {
        return this.steps;
    }

    public final RecoveryTicket getTicket() {
        return this.ticket;
    }

    public int hashCode() {
        int v0 = ((this.ticket.hashCode() * 0x1F + this.status.hashCode()) * 0x1F + this.steps.hashCode()) * 0x1F;
        StretchOriginalDisplayState v1 = this.observedOriginal;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return (v0 + v1_1) * 0x1F + Boolean.hashCode(this.executionStopped);
    }

    public String toString() {
        return "StretchRestoreResult(ticket=" + this.ticket + ", status=" + this.status + ", steps=" + this.steps + ", observedOriginal=" + this.observedOriginal + ", executionStopped=" + this.executionStopped + ")";
    }
}

