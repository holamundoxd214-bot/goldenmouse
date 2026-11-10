package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÆ\u0003J\u000F\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreRequest;", "", "ticket", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "steps", "", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;Ljava/util/List;)V", "getTicket", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "getSnapshot", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "getSteps", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRestoreRequest {
    public static final int $stable = 8;
    private final StretchRecoverySnapshot snapshot;
    private final List steps;
    private final RecoveryTicket ticket;

    static {
    }

    public StretchRestoreRequest(RecoveryTicket arg2, StretchRecoverySnapshot arg3, List arg4) {
        Intrinsics.checkNotNullParameter(arg2, "ticket");
        Intrinsics.checkNotNullParameter(arg3, "snapshot");
        Intrinsics.checkNotNullParameter(arg4, "steps");
        super();
        this.ticket = arg2;
        this.snapshot = arg3;
        this.steps = arg4;
    }

    public final RecoveryTicket component1() {
        return this.ticket;
    }

    public final StretchRecoverySnapshot component2() {
        return this.snapshot;
    }

    public final List component3() {
        return this.steps;
    }

    public final StretchRestoreRequest copy(RecoveryTicket arg1, StretchRecoverySnapshot arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg1, "ticket");
        Intrinsics.checkNotNullParameter(arg2, "snapshot");
        Intrinsics.checkNotNullParameter(arg3, "steps");
        return new StretchRestoreRequest(arg1, arg2, arg3);
    }

    public static StretchRestoreRequest copy$default(StretchRestoreRequest arg0, RecoveryTicket arg1, StretchRecoverySnapshot arg2, List arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.ticket;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.snapshot;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.steps;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchRestoreRequest)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchRestoreRequest)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.ticket, ((StretchRestoreRequest)arg5).ticket)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshot, ((StretchRestoreRequest)arg5).snapshot)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.steps, ((StretchRestoreRequest)arg5).steps)) {
            return 0;
        }

        return 1;
    }

    public final StretchRecoverySnapshot getSnapshot() {
        return this.snapshot;
    }

    public final List getSteps() {
        return this.steps;
    }

    public final RecoveryTicket getTicket() {
        return this.ticket;
    }

    public int hashCode() {
        return (this.ticket.hashCode() * 0x1F + this.snapshot.hashCode()) * 0x1F + this.steps.hashCode();
    }

    public String toString() {
        return "StretchRestoreRequest(ticket=" + this.ticket + ", snapshot=" + this.snapshot + ", steps=" + this.steps + ")";
    }
}

