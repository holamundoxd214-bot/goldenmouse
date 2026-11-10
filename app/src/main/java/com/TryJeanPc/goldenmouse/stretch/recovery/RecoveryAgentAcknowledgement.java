package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentAcknowledgement;", "", "registration", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentRegistration;", "disposition", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentDisposition;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentRegistration;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentDisposition;)V", "getRegistration", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentRegistration;", "getDisposition", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentDisposition;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryAgentAcknowledgement {
    public static final int $stable = 8;
    private final RecoveryAgentDisposition disposition;
    private final RecoveryAgentRegistration registration;

    static {
    }

    public RecoveryAgentAcknowledgement(RecoveryAgentRegistration arg2, RecoveryAgentDisposition arg3) {
        Intrinsics.checkNotNullParameter(arg2, "registration");
        Intrinsics.checkNotNullParameter(arg3, "disposition");
        super();
        this.registration = arg2;
        this.disposition = arg3;
    }

    public final RecoveryAgentRegistration component1() {
        return this.registration;
    }

    public final RecoveryAgentDisposition component2() {
        return this.disposition;
    }

    public final RecoveryAgentAcknowledgement copy(RecoveryAgentRegistration arg1, RecoveryAgentDisposition arg2) {
        Intrinsics.checkNotNullParameter(arg1, "registration");
        Intrinsics.checkNotNullParameter(arg2, "disposition");
        return new RecoveryAgentAcknowledgement(arg1, arg2);
    }

    public static RecoveryAgentAcknowledgement copy$default(RecoveryAgentAcknowledgement arg0, RecoveryAgentRegistration arg1, RecoveryAgentDisposition arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.registration;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.disposition;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryAgentAcknowledgement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryAgentAcknowledgement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.registration, ((RecoveryAgentAcknowledgement)arg5).registration)) {
            return 0;
        }

        if(this.disposition != ((RecoveryAgentAcknowledgement)arg5).disposition) {
            return 0;
        }

        return 1;
    }

    public final RecoveryAgentDisposition getDisposition() {
        return this.disposition;
    }

    public final RecoveryAgentRegistration getRegistration() {
        return this.registration;
    }

    public int hashCode() {
        return this.registration.hashCode() * 0x1F + this.disposition.hashCode();
    }

    public String toString() {
        return "RecoveryAgentAcknowledgement(registration=" + this.registration + ", disposition=" + this.disposition + ")";
    }
}

