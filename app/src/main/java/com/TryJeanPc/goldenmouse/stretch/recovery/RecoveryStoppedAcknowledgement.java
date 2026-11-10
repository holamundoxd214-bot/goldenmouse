package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStoppedAcknowledgement;", "", "ticket", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "scope", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;)V", "getTicket", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "getScope", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryStoppedAcknowledgement {
    public static final int $stable;
    private final RecoveryScope scope;
    private final RecoveryTicket ticket;

    static {
    }

    public RecoveryStoppedAcknowledgement(RecoveryTicket arg2, RecoveryScope arg3) {
        Intrinsics.checkNotNullParameter(arg2, "ticket");
        Intrinsics.checkNotNullParameter(arg3, "scope");
        super();
        this.ticket = arg2;
        this.scope = arg3;
    }

    public RecoveryStoppedAcknowledgement(RecoveryTicket arg1, RecoveryScope arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = RecoveryScope.SIMULATION_ONLY;
        }

        this(arg1, arg2);
    }

    public final RecoveryTicket component1() {
        return this.ticket;
    }

    public final RecoveryScope component2() {
        return this.scope;
    }

    public final RecoveryStoppedAcknowledgement copy(RecoveryTicket arg1, RecoveryScope arg2) {
        Intrinsics.checkNotNullParameter(arg1, "ticket");
        Intrinsics.checkNotNullParameter(arg2, "scope");
        return new RecoveryStoppedAcknowledgement(arg1, arg2);
    }

    public static RecoveryStoppedAcknowledgement copy$default(RecoveryStoppedAcknowledgement arg0, RecoveryTicket arg1, RecoveryScope arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.ticket;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.scope;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryStoppedAcknowledgement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryStoppedAcknowledgement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.ticket, ((RecoveryStoppedAcknowledgement)arg5).ticket)) {
            return 0;
        }

        if(this.scope != ((RecoveryStoppedAcknowledgement)arg5).scope) {
            return 0;
        }

        return 1;
    }

    public final RecoveryScope getScope() {
        return this.scope;
    }

    public final RecoveryTicket getTicket() {
        return this.ticket;
    }

    public int hashCode() {
        return this.ticket.hashCode() * 0x1F + this.scope.hashCode();
    }

    public String toString() {
        return "RecoveryStoppedAcknowledgement(ticket=" + this.ticket + ", scope=" + this.scope + ")";
    }
}

