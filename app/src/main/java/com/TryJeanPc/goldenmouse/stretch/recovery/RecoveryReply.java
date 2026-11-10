package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÆ\u0003J\u000B\u0010\u0016\u001A\u0004\u0018\u00010\u0007HÆ\u0003J\u000B\u0010\u0017\u001A\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u00032\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReply;", "", "accepted", "", "view", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryView;", "error", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "ticket", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "<init>", "(ZLcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryView;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;)V", "getAccepted", "()Z", "getView", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryView;", "getError", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "getTicket", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryReply {
    public static final int $stable = 8;
    private final boolean accepted;
    private final RecoveryError error;
    private final RecoveryTicket ticket;
    private final RecoveryView view;

    static {
    }

    public RecoveryReply(boolean arg2, RecoveryView arg3, RecoveryError arg4, RecoveryTicket arg5) {
        Intrinsics.checkNotNullParameter(arg3, "view");
        super();
        this.accepted = arg2;
        this.view = arg3;
        this.error = arg4;
        this.ticket = arg5;
    }

    public RecoveryReply(boolean arg2, RecoveryView arg3, RecoveryError arg4, RecoveryTicket arg5, int arg6, DefaultConstructorMarker arg7) {
        RecoveryError v0 = null;
        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        if((arg6 & 8) != 0) {
            arg5 = ((RecoveryTicket)v0);
        }

        this(arg2, arg3, arg4, arg5);
    }

    public final boolean component1() {
        return this.accepted;
    }

    public final RecoveryView component2() {
        return this.view;
    }

    public final RecoveryError component3() {
        return this.error;
    }

    public final RecoveryTicket component4() {
        return this.ticket;
    }

    public final RecoveryReply copy(boolean arg1, RecoveryView arg2, RecoveryError arg3, RecoveryTicket arg4) {
        Intrinsics.checkNotNullParameter(arg2, "view");
        return new RecoveryReply(arg1, arg2, arg3, arg4);
    }

    public static RecoveryReply copy$default(RecoveryReply arg0, boolean arg1, RecoveryView arg2, RecoveryError arg3, RecoveryTicket arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.accepted;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.view;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.error;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.ticket;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryReply)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryReply)) {
            return 0;
        }

        if(this.accepted != ((RecoveryReply)arg5).accepted) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.view, ((RecoveryReply)arg5).view)) {
            return 0;
        }

        if(this.error != ((RecoveryReply)arg5).error) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.ticket, ((RecoveryReply)arg5).ticket)) {
            return 0;
        }

        return 1;
    }

    public final boolean getAccepted() {
        return this.accepted;
    }

    public final RecoveryError getError() {
        return this.error;
    }

    public final RecoveryTicket getTicket() {
        return this.ticket;
    }

    public final RecoveryView getView() {
        return this.view;
    }

    public int hashCode() {
        int v0 = (Boolean.hashCode(this.accepted) * 0x1F + this.view.hashCode()) * 0x1F;
        RecoveryError v1 = this.error;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        RecoveryTicket v3 = this.ticket;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "RecoveryReply(accepted=" + this.accepted + ", view=" + this.view + ", error=" + this.error + ", ticket=" + this.ticket + ")";
    }
}

