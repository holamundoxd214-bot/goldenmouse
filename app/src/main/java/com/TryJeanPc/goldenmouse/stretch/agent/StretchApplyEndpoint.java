package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import com.TryJeanPc.goldenmouse.stretch.recovery.AndroidRecoverySupport;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ*\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u001C\u001A\u00020\u0010H\u0014J\b\u0010\u001D\u001A\u00020\bH\u0002J\u000E\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u0010R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchApplyEndpoint;", "Landroid/os/Binder;", "context", "Landroid/content/Context;", "evidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "ownerPresent", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;Lkotlin/jvm/functions/Function0;)V", "installed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "consumed", "revoked", "guardianPid", "", "journal", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalJournal;", "guardian", "Landroid/os/IBinder;", "installing", "factor", "onTransact", "code", "data", "Landroid/os/Parcel;", "reply", "flags", "allowed", "apply", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPairResult;", "requestedFactor", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchApplyEndpoint extends Binder {
    public static final int $stable = 8;
    private final AtomicBoolean consumed;
    private final Context context;
    private final StretchOriginalEvidence evidence;
    private int factor;
    private volatile IBinder guardian;
    private volatile int guardianPid;
    private final AtomicBoolean installed;
    private final AtomicBoolean installing;
    private volatile StretchPhysicalJournal journal;
    private final Function0 ownerPresent;
    private final AtomicBoolean revoked;

    static {
    }

    public StretchApplyEndpoint(Context arg2, StretchOriginalEvidence arg3, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "evidence");
        Intrinsics.checkNotNullParameter(arg4, "ownerPresent");
        super();
        this.context = arg2;
        this.evidence = arg3;
        this.ownerPresent = arg4;
        this.installed = new AtomicBoolean();
        this.consumed = new AtomicBoolean();
        this.revoked = new AtomicBoolean();
        this.guardianPid = -1;
        this.installing = new AtomicBoolean();
    }

    public static final boolean access$allowed(StretchApplyEndpoint arg0) {
        return arg0.allowed();
    }

    private final boolean allowed() {
        if(!this.revoked.get() && (this.ownerPresent.invoke().booleanValue())) {
            IBinder v2 = this.guardian;
            if(v2 != null && (v2.isBinderAlive()) && (StretchExperimentRpc.call$default(StretchExperimentRpc.INSTANCE, v2, 4, null, new StretchApplyEndpoint$$ExternalSyntheticLambda1(), 4, null).booleanValue())) {
                return 1;
            }
        }

        return 0;
    }

    static final boolean allowed$lambda$4$lambda$3(Parcel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        int v1 = arg1.readInt();
        if(v1 >= 0 && v1 < 2) {
            if(v1 == 1) {
                return 1;
            }
            else {
                return 0;
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final StretchPairResult apply(int arg15) {
        Object v1;
        if(arg15 != this.factor) {
            return new StretchPairResult("FACTOR_BINDING_MISMATCH", null, null, 0, 0, 0, 62, null);
        }

        if(this.installed.get()) {
            if(!this.allowed()) {
            }
            else if(!this.consumed.compareAndSet(false, true)) {
                return new StretchPairResult("EXPERIMENT_ALREADY_USED", null, null, 0, 0, 0, 62, null);
            }
            else {
                IBinder v4 = this.guardian;
                String v15 = "Required value was null.";
                if(v4 != null) {
                    StretchApplyEndpoint$apply$io$1 v0 = new StretchApplyEndpoint$apply$io$1(this, v4);
                    StretchPhysicalJournal v6 = this.journal;
                    if(v6 != null) {
                        StretchPairResult v14 = new StretchPhysicalPair(v6, v0, this.context.getPackageManager().getApplicationInfo("com.TryJeanPc.goldenmouse", 0).uid, null, new StretchApplyEndpoint$apply$result$1(this), 8, null).apply(StretchRecoveryBinding.Companion.from(this.evidence), true, AndroidStretchBootIdentity.INSTANCE.read(), AndroidRecoverySupport.INSTANCE.getClock().elapsedRealtimeMillis(), this.factor);
                        if(!Intrinsics.areEqual(v14.getCode(), "APPLY_READBACK_MATCHED_UNACCREDITED")) {
                        }
                        else {
                            v1 = StretchExperimentRpc.call$default(StretchExperimentRpc.INSTANCE, v4, 9, null, new StretchApplyEndpoint$$ExternalSyntheticLambda0(), 4, null);
                            if(Intrinsics.areEqual(v1, "ACTIVE_READBACK_MATCHED")) {
                                return v14;
                            }

                            goto label_85;
                        }

                        return v14;
                    label_85:
                        return new StretchPairResult(((String)v1), null, null, 0, 0, 0, 62, null);
                    }
                    else {
                        throw new IllegalArgumentException(v15.toString());
                    }
                }
                else {
                    throw new IllegalArgumentException(v15.toString());
                }
            }
        }

        return new StretchPairResult("RESCUE_NOT_READY", null, null, 0, 0, 0, 62, null);
    }

    static final String apply$lambda$5(Parcel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StretchAgentWire.INSTANCE.text(arg1);
    }

    protected boolean onTransact(int arg10, Parcel arg11, Parcel arg12, int arg13) {
        Intrinsics.checkNotNullParameter(arg11, "data");
        String v2 = "Failed requirement.";
        if(Binder.getCallingUid() == 2000) {
            StretchExperimentRpc.INSTANCE.envelope(arg11);
            if(arg10 == 6) {
                if(StretchExperimentRpc.INSTANCE.acceptsFencePeer(Binder.getCallingUid(), Binder.getCallingPid(), this.guardianPid, this.installed.get(), arg13)) {
                    StretchAgentWire.INSTANCE.exhausted(arg11);
                    this.revoked.set(true);
                    Process.killProcess(Process.myPid());
                    return 1;
                }

                throw new IllegalArgumentException(v2.toString());
            }

            int v8 = arg13;
            if(arg10 == 5 && (StretchAgentWire.INSTANCE.isSynchronousTransport(v8))) {
                IBinder v10 = arg11.readStrongBinder();
                String v13 = "Required value was null.";
                if(v10 != null) {
                    StretchOriginalEvidence v0 = StretchOriginalEvidenceCodec.INSTANCE.decode(StretchExperimentRpc.INSTANCE.json(arg11));
                    int v3 = arg11.readInt();
                    if(StretchExperimentRpc.INSTANCE.acceptsFactor(0, v3)) {
                        StretchAgentWire.INSTANCE.exhausted(arg11);
                        if((Intrinsics.areEqual(v0, this.evidence)) && (this.installing.compareAndSet(false, true))) {
                            this.guardianPid = Binder.getCallingPid();
                            this.factor = v3;
                            long v2_1 = Binder.clearCallingIdentity();
                            try {
                                StretchExperimentRpc.INSTANCE.call(v10, 1, new StretchApplyEndpoint$$ExternalSyntheticLambda2(this), new StretchApplyEndpoint$$ExternalSyntheticLambda3());
                                this.guardian = v10;
                                this.journal = new StretchApplyEndpoint$onTransact$3(v10);
                                this.installed.set(true);
                            }
                            catch(Throwable v0_1) {
                                Binder.restoreCallingIdentity(v2_1);
                                throw v0_1;
                            }

                            Binder.restoreCallingIdentity(v2_1);
                            if(arg12 != null) {
                                arg12.writeNoException();
                                arg12.writeInt(1);
                                return 1;
                            }
                            else {
                                throw new IllegalArgumentException(v13.toString());
                            }
                        }

                        throw new IllegalArgumentException(v2.toString());
                    }
                    else {
                        throw new IllegalArgumentException(v2.toString());
                    }
                }
                else {
                    throw new IllegalArgumentException(v13.toString());
                }
            }

            throw new IllegalArgumentException(v2.toString());
        }

        throw new IllegalArgumentException(v2.toString());
    }

    static final Unit onTransact$lambda$0(StretchApplyEndpoint arg1, Parcel arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        arg2.writeString(arg1.evidence.getAgentGeneration());
        return Unit.INSTANCE;
    }

    static final Unit onTransact$lambda$1(Parcel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        if(arg1.readInt() == 1) {
            return Unit.INSTANCE;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

