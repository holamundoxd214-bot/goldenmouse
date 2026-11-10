package com.TryJeanPc.goldenmouse.recoil;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u0005J\u001E\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\tJ\u0018\u0010\u0018\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\tJ\u0006\u0010\u001A\u001A\u00020\u0013J\u0006\u0010\u001B\u001A\u00020\tJ\u000E\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u0017\u001A\u00020\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001E"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilController;", "", "<init>", "()V", "settings", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "leftHeld", "", "startedAtNanos", "", "nextTickNanos", "residueX", "", "residueY", "value", "running", "getRunning", "()Z", "configure", "", "onLeftButton", "pressed", "authorized", "nowNanos", "tick", "Lcom/TryJeanPc/goldenmouse/recoil/RecoilDelta;", "stop", "nextWakeNanos", "expired", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoilController {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilController$Companion;", "", "<init>", "()V", "TICK_NANOS", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final long TICK_NANOS = 20000000;
    private boolean leftHeld;
    private long nextTickNanos;
    private double residueX;
    private double residueY;
    private volatile boolean running;
    private RecoilSettings settings;
    private long startedAtNanos;

    static {
        RecoilController.Companion = new Companion(null);
        RecoilController.$stable = 8;
    }

    public RecoilController() {
        super();
        this.settings = new RecoilSettings(false, false, false, 0, 0, false, 0, 0, false, 0, 0x3FF, null);
    }

    public final void configure(RecoilSettings arg2) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg2, "value");
            this.stop();
            this.settings = arg2;
        }
        catch(Throwable v2) {
            try {
            label_8:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_8;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    public final boolean expired(long arg5) {
        __monitor_enter(this);
        try {
            if(!this.running) {
                goto label_16;
            }
            else if(!this.settings.getLimitDuration()) {
                goto label_16;
            }
            else if((((double)(arg5 - this.startedAtNanos))) < this.settings.getMaxDurationSeconds() * 1000000000) {
                goto label_16;
            }
        }
        catch(Throwable v5) {
            try {
            label_20:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_20;
            }

            throw v5;
        }

        boolean v5_1 = true;
        goto label_17;
    label_16:
        v5_1 = false;
    label_17:
        __monitor_exit(this);
        return v5_1;
    }

    public final boolean getRunning() {
        return this.running;
    }

    public final long nextWakeNanos() {
        long v0_1;
        long v1;
        __monitor_enter(this);
        try {
            v1 = 0x7FFFFFFFFFFFFFFFL;
            if(this.running) {
                goto label_6;
            }
        }
        catch(Throwable v0) {
            goto label_22;
        }

        __monitor_exit(this);
        return v1;
        try {
        label_6:
            if(this.settings.getLimitDuration()) {
                v1 = this.startedAtNanos + (((long)Math.ceil(this.settings.getMaxDurationSeconds() * 1000000000)));
            }

            v0_1 = Math.min(this.nextTickNanos, v1);
        }
        catch(Throwable v0) {
            try {
            label_22:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_22;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public final void onLeftButton(boolean arg5, boolean arg6, long arg7) {
        __monitor_enter(this);
        if(!arg5) {
            try {
                this.leftHeld = false;
                this.stop();
            }
            catch(Throwable v5) {
                goto label_33;
            }

            __monitor_exit(this);
            return;
        }

        try {
            if(!this.leftHeld) {
                goto label_12;
            }
        }
        catch(Throwable v5) {
            goto label_33;
        }

        __monitor_exit(this);
        return;
        try {
        label_12:
            this.leftHeld = true;
            if((arg6) && (this.settings.getEnabled())) {
                double v2 = 0;
                if(this.settings.getVerticalSpeed() == v2 && this.settings.getHorizontalSpeed() == v2) {
                    goto label_30;
                }

                this.startedAtNanos = arg7;
                this.nextTickNanos = arg7;
                this.running = true;
                goto label_28;
            }

            goto label_30;
        }
        catch(Throwable v5) {
            try {
            label_33:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_33;
            }

            throw v5;
        }

    label_28:
        __monitor_exit(this);
        return;
    label_30:
        __monitor_exit(this);
    }

    public final void stop() {
        __monitor_enter(this);
        try {
            this.running = false;
            this.startedAtNanos = 0;
            this.nextTickNanos = 0;
            this.residueX = 0;
            this.residueY = 0;
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

    public final RecoilDelta tick(boolean arg9, long arg10) {
        RecoilDelta v1;
        __monitor_enter(this);
        try {
            v1 = null;
            if(this.running) {
                goto label_6;
            }
        }
        catch(Throwable v9) {
            goto label_90;
        }

        __monitor_exit(this);
        return v1;
        try {
        label_6:
            long v2 = arg10 - this.startedAtNanos;
            if((arg9) && (this.leftHeld) && (this.settings.getEnabled()) && v2 >= 0) {
                if((this.settings.getLimitDuration()) && (((double)v2)) >= this.settings.getMaxDurationSeconds() * 1000000000) {
                    goto label_86;
                }

                if(arg10 >= this.nextTickNanos) {
                    goto label_30;
                }

                goto label_28;
            }

            goto label_86;
        }
        catch(Throwable v9) {
            goto label_90;
        }

    label_28:
        __monitor_exit(this);
        return v1;
    label_30:
        arg10 += 20000000;
        try {
            this.nextTickNanos = arg10;
            this.residueY += RecoilSpeedScale.INSTANCE.toInternal(this.settings.getSignedVerticalSpeed()) * this.settings.getCoefficient() * 0.02;
            this.residueX += RecoilSpeedScale.INSTANCE.toInternal(this.settings.getHorizontalSpeed()) * this.settings.getCoefficient() * 0.02;
            double v2_1 = 1;
            int v10 = 0;
            int v9_1 = Double.compare(Math.abs(this.residueY), v2_1) >= 0 ? ((int)this.residueY) : 0;
            if(Math.abs(this.residueX) >= v2_1) {
                v10 = ((int)this.residueX);
            }

            this.residueY -= ((double)v9_1);
            this.residueX -= ((double)v10);
            if(v10 != 0 || v9_1 != 0) {
                v1 = new RecoilDelta(v10, v9_1);
            }
            else {
            }
        }
        catch(Throwable v9) {
            goto label_90;
        }

        __monitor_exit(this);
        return v1;
        try {
        label_86:
            this.stop();
        }
        catch(Throwable v9) {
            try {
            label_90:
                __monitor_exit(this);
            }
            catch(Throwable v9) {
                goto label_90;
            }

            throw v9;
        }

        __monitor_exit(this);
        return v1;
    }
}

