package com.TryJeanPc.goldenmouse.recoil;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015J6\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\u0007J\u001E\u0010\u001B\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0007J0\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u001E\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u0007J.\u0010\u001F\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0018\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u0007J\u000E\u0010 \u001A\u00020\u00132\u0006\u0010!\u001A\u00020\u000EJ\u0006\u0010\"\u001A\u00020\u0013R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000F\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilCoordinator;", "", "<init>", "()V", "controller", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilController;", "value", "", "epoch", "getEpoch", "()J", "session", "revision", "contactSeen", "", "running", "getRunning", "()Z", "configure", "", "settings", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "observeButton", "pressed", "authorized", "contactPresent", "nowNanos", "nextWakeNanos", "step", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilCoordinator$Step;", "expectedEpoch", "current", "observeContact", "present", "cancel", "Step", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoilCoordinator {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0007HÆ\u0003J1\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilCoordinator$Step;", "", "epoch", "", "session", "revision", "delta", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilDelta;", "<init>", "(JJJLcom/TryJeanPc/goldenmouse/recoil/RecoilDelta;)V", "getEpoch", "()J", "getSession", "getRevision", "getDelta", "()Lcom/TryJeanPc/goldenmouse/recoil/RecoilDelta;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Step {
        public static final int $stable;
        private final RecoilDelta delta;
        private final long epoch;
        private final long revision;
        private final long session;

        static {
        }

        public Step(long arg2, long arg4, long arg6, RecoilDelta arg8) {
            Intrinsics.checkNotNullParameter(arg8, "delta");
            super();
            this.epoch = arg2;
            this.session = arg4;
            this.revision = arg6;
            this.delta = arg8;
        }

        public final long component1() {
            return this.epoch;
        }

        public final long component2() {
            return this.session;
        }

        public final long component3() {
            return this.revision;
        }

        public final RecoilDelta component4() {
            return this.delta;
        }

        public final Step copy(long arg9, long arg11, long arg13, RecoilDelta arg15) {
            Intrinsics.checkNotNullParameter(arg15, "delta");
            return new Step(arg9, arg11, arg13, arg15);
        }

        public static Step copy$default(Step arg8, long arg9, long arg11, long arg13, RecoilDelta arg15, int arg16, Object arg17) {
            if((arg16 & 1) != 0) {
                arg9 = arg8.epoch;
            }

            long v1 = arg9;
            if((arg16 & 2) != 0) {
                arg11 = arg8.session;
            }

            long v3 = arg11;
            if((arg16 & 4) != 0) {
                arg13 = arg8.revision;
            }

            long v5 = arg13;
            if((arg16 & 8) != 0) {
                arg15 = arg8.delta;
            }

            return arg8.copy(v1, v3, v5, arg15);
        }

        public boolean equals(Object arg8) {
            if(this == (((Step)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Step)) {
                return 0;
            }

            if(this.epoch != ((Step)arg8).epoch) {
                return 0;
            }

            if(this.session != ((Step)arg8).session) {
                return 0;
            }

            if(this.revision != ((Step)arg8).revision) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.delta, ((Step)arg8).delta)) {
                return 0;
            }

            return 1;
        }

        public final RecoilDelta getDelta() {
            return this.delta;
        }

        public final long getEpoch() {
            return this.epoch;
        }

        public final long getRevision() {
            return this.revision;
        }

        public final long getSession() {
            return this.session;
        }

        public int hashCode() {
            return ((Long.hashCode(this.epoch) * 0x1F + Long.hashCode(this.session)) * 0x1F + Long.hashCode(this.revision)) * 0x1F + this.delta.hashCode();
        }

        public String toString() {
            return "Step(epoch=" + this.epoch + ", session=" + this.session + ", revision=" + this.revision + ", delta=" + this.delta + ")";
        }
    }

    public static final int $stable = 8;
    private boolean contactSeen;
    private final RecoilController controller;
    private volatile long epoch;
    private long revision;
    private long session;

    static {
    }

    public RecoilCoordinator() {
        super();
        this.controller = new RecoilController();
    }

    public final void cancel() {
        __monitor_enter(this);
        try {
            ++this.epoch;
            this.controller.stop();
            this.contactSeen = false;
        }
        catch(Throwable v0) {
            try {
            label_12:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_12;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    public final void configure(RecoilSettings arg2) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "settings");
            this.cancel();
            this.controller.configure(arg2);
        }
        catch(Throwable v2) {
            try {
            label_9:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_9;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    public final boolean current(Step arg3, boolean arg4, long arg5, long arg7, long arg9) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "step");
            if(!arg4 || (this.controller.expired(arg9))) {
                this.cancel();
            }

            if(!this.controller.getRunning()) {
                goto label_20;
            }
            else if(arg3.getEpoch() != this.epoch) {
                goto label_20;
            }
            else if(arg3.getSession() != arg5) {
                goto label_20;
            }
            else if(arg3.getRevision() != arg7) {
                goto label_20;
            }
        }
        catch(Throwable v3) {
            try {
            label_24:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_24;
            }

            throw v3;
        }

        boolean v3_1 = true;
        goto label_21;
    label_20:
        v3_1 = false;
    label_21:
        __monitor_exit(this);
        return v3_1;
    }

    public final long getEpoch() {
        return this.epoch;
    }

    public final boolean getRunning() {
        return this.controller.getRunning();
    }

    public final long nextWakeNanos(boolean arg3, long arg4, long arg6) {
        long v3_1;
        __monitor_enter(this);
        try {
            if((this.controller.getRunning()) && (!arg3 || arg4 != this.session || arg6 != this.revision)) {
                this.cancel();
            }

            v3_1 = this.controller.nextWakeNanos();
        }
        catch(Throwable v3) {
            try {
            label_15:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_15;
            }

            throw v3;
        }

        __monitor_exit(this);
        return v3_1;
    }

    public final void observeButton(boolean arg3, boolean arg4, long arg5, long arg7, boolean arg9, long arg10) {
        __monitor_enter(this);
        try {
            boolean v0 = this.controller.getRunning();
            if(!arg4 && (v0)) {
                this.cancel();
            }

            this.controller.onLeftButton(arg3, arg4, arg10);
            if(!arg3) {
                this.cancel();
            }
            else if(!v0 && (this.controller.getRunning())) {
                ++this.epoch;
                this.session = arg5;
                this.revision = arg7;
                this.contactSeen = arg9;
            }
        }
        catch(Throwable v3) {
            try {
            label_25:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_25;
            }

            throw v3;
        }

        __monitor_exit(this);
    }

    public final void observeContact(boolean arg2) {
        __monitor_enter(this);
        try {
            if(this.controller.getRunning()) {
                goto label_6;
            }
        }
        catch(Throwable v2) {
            goto label_17;
        }

        __monitor_exit(this);
        return;
        try {
        label_6:
            if((this.contactSeen) && !arg2) {
                this.cancel();
            }
            else if(arg2) {
                this.contactSeen = true;
            }
        }
        catch(Throwable v2) {
            try {
            label_17:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_17;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    public final Step step(long arg9, boolean arg11, long arg12, long arg14, long arg16) {
        Step v10;
        __monitor_enter(this);
        try {
            int v9 = Long.compare(arg9, this.epoch);
            v10 = null;
            if(v9 == 0) {
                goto label_7;
            }
        }
        catch(Throwable v0) {
            goto label_34;
        }

        __monitor_exit(this);
        return v10;
    label_7:
        if(arg11) {
            try {
                if(arg12 == this.session) {
                    if(arg14 != this.revision) {
                    }
                    else {
                        RecoilDelta v7 = this.controller.tick(true, arg16);
                        if(!this.controller.getRunning()) {
                            this.cancel();
                        }

                        if(v7 != null) {
                            v10 = new Step(this.epoch, arg12, arg14, v7);
                        }

                        goto label_28;
                    }
                }

                goto label_30;
            }
            catch(Throwable v0) {
                goto label_34;
            }

        label_28:
            __monitor_exit(this);
            return v10;
        }

        try {
        label_30:
            this.cancel();
        }
        catch(Throwable v0) {
        label_34:
            Throwable v9_1 = v0;
            try {
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_34;
            }

            throw v9_1;
        }

        __monitor_exit(this);
        return v10;
    }
}

