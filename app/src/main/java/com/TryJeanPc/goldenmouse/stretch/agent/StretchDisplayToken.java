package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchDisplayToken;", "", "binder", "Landroid/os/IBinder;", "contract", "", "<init>", "(Landroid/os/IBinder;Ljava/lang/String;)V", "getBinder", "()Landroid/os/IBinder;", "getContract", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchDisplayToken {
    public static final int $stable = 8;
    private final IBinder binder;
    private final String contract;

    static {
    }

    public StretchDisplayToken(IBinder arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "binder");
        Intrinsics.checkNotNullParameter(arg3, "contract");
        super();
        this.binder = arg2;
        this.contract = arg3;
    }

    public final IBinder component1() {
        return this.binder;
    }

    public final String component2() {
        return this.contract;
    }

    public final StretchDisplayToken copy(IBinder arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "binder");
        Intrinsics.checkNotNullParameter(arg2, "contract");
        return new StretchDisplayToken(arg1, arg2);
    }

    public static StretchDisplayToken copy$default(StretchDisplayToken arg0, IBinder arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.binder;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.contract;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchDisplayToken)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchDisplayToken)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.binder, ((StretchDisplayToken)arg5).binder)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.contract, ((StretchDisplayToken)arg5).contract)) {
            return 0;
        }

        return 1;
    }

    public final IBinder getBinder() {
        return this.binder;
    }

    public final String getContract() {
        return this.contract;
    }

    public int hashCode() {
        return this.binder.hashCode() * 0x1F + this.contract.hashCode();
    }

    public String toString() {
        return "StretchDisplayToken(binder=" + this.binder + ", contract=" + this.contract + ")";
    }
}

