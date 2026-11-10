package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import android.os.IBinder$DeathRecipient;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.physical.StretchPhysicalCommandPermit;
import com.TryJeanPc.goldenmouse.stretch.recovery.AndroidRecoverySupport;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryClock;
import java.io.File;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000s\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011*\u0001$\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001F\u001A\u00020\u0019H\u0002J>\u0010&\u001A\u00020\u00072\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020\u00172\u0006\u0010-\u001A\u00020\u00072\u0006\u0010.\u001A\u00020\u000F2\u0006\u0010/\u001A\u00020\u0005J\u000E\u00100\u001A\u00020\u00072\u0006\u00101\u001A\u00020\u0019J\u0006\u00102\u001A\u00020\u0007J\u0006\u00106\u001A\u00020\u0012J\u0006\u00107\u001A\u00020\u0007J\b\u00108\u001A\u00020\u0019H\u0002J\u0010\u00109\u001A\u00020\u00122\u0006\u0010:\u001A\u00020\u000FH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010 \u001A\u00020\u00198F¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0010\u0010#\u001A\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0011\u00103\u001A\u00020\u00198F¢\u0006\u0006\u001A\u0004\b4\u0010\"R\u000E\u00105\u001A\u00020*X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006;"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRescueHost;", "", "context", "Landroid/content/Context;", "ownerUid", "", "generation", "", "<init>", "(Landroid/content/Context;ILjava/lang/String;)V", "journal", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateJournal;", "core", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExternalRescue;", "fence", "Landroid/os/IBinder;", "dead", "Ljava/util/concurrent/CompletableFuture;", "", "sourcePid", "Ljava/util/concurrent/atomic/AtomicInteger;", "originalGeneration", "originalEvidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "arming", "", "releaseFailed", "sourceDeath", "Landroid/os/IBinder$DeathRecipient;", "applierFence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchApplierFence;", "finished", "retained", "getRetained", "()Z", "capability", "com/TryJeanPc/goldenmouse/stretch/agent/StretchRescueHost$capability$1", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRescueHost$capability$1;", "arm", "fd", "Landroid/os/ParcelFileDescriptor;", "device", "", "inode", "evidence", "ownerGeneration", "endpoint", "factor", "verify", "confirmed", "restore", "allowsRestoreHandoff", "getAllowsRestoreHandoff", "lastHealthCheck", "poll", "status", "fenceAndAwait", "sendFence", "source", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRescueHost {
    public static final int $stable = 8;
    private StretchApplierFence applierFence;
    private volatile boolean arming;
    private final StretchRescueHost$capability$1 capability;
    private final Context context;
    private volatile StretchExternalRescue core;
    private final CompletableFuture dead;
    private volatile IBinder fence;
    private final String generation;
    private volatile StretchCandidateJournal journal;
    private volatile long lastHealthCheck;
    private StretchOriginalEvidence originalEvidence;
    private String originalGeneration;
    private final int ownerUid;
    private volatile boolean releaseFailed;
    private final IBinder$DeathRecipient sourceDeath;
    private final AtomicInteger sourcePid;

    static {
    }

    public StretchRescueHost(Context arg2, int arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg4, "generation");
        super();
        this.context = arg2;
        this.ownerUid = arg3;
        this.generation = arg4;
        this.dead = new CompletableFuture();
        this.sourcePid = new AtomicInteger(-1);
        this.sourceDeath = new StretchRescueHost$$ExternalSyntheticLambda4(this);
        this.capability = new StretchRescueHost$capability$1(this);
    }

    public static final boolean access$fenceAndAwait(StretchRescueHost arg0) {
        return arg0.fenceAndAwait();
    }

    public static final Context access$getContext$p(StretchRescueHost arg0) {
        return arg0.context;
    }

    public static final StretchExternalRescue access$getCore$p(StretchRescueHost arg0) {
        return arg0.core;
    }

    public static final StretchOriginalEvidence access$getOriginalEvidence$p(StretchRescueHost arg0) {
        return arg0.originalEvidence;
    }

    public static final String access$getOriginalGeneration$p(StretchRescueHost arg0) {
        return arg0.originalGeneration;
    }

    public static final AtomicInteger access$getSourcePid$p(StretchRescueHost arg0) {
        return arg0.sourcePid;
    }

    public final String arm(ParcelFileDescriptor arg25, long arg26, long arg28, StretchOriginalEvidence arg30, String arg31, IBinder arg32, int arg33) {
        StretchExternalRescue v6_2;
        StretchRescueHost$$ExternalSyntheticLambda7 v22;
        String v18;
        int v17;
        StretchCandidateJournal v21;
        StretchRescueHost$arm$session$3 v23;
        StretchRescueHost$arm$session$1 v20;
        RecoveryClock v19;
        StretchCandidateJournal v7_1;
        StretchCandidateJournal v6_1;
        long v9;
        long v11;
        File v13;
        Object v15;
        int v14;
        int v8;
        boolean v5;
        AndroidStretchJournalDescriptor v6;
        StretchRescueHost v1 = this;
        StretchOriginalEvidence v0 = arg30;
        String v2 = arg31;
        IBinder v3 = arg32;
        int v4 = arg33;
        ParcelFileDescriptor v7 = arg25;
        Intrinsics.checkNotNullParameter(v7, "fd");
        Intrinsics.checkNotNullParameter(v0, "evidence");
        Intrinsics.checkNotNullParameter(v2, "ownerGeneration");
        Intrinsics.checkNotNullParameter(v3, "endpoint");
        if(v1.core != null) {
            v7.close();
            return "EXPERIMENT_ALREADY_USED";
        }

        v1.arming = true;
        try {
            v6 = AndroidStretchJournalDescriptor.INSTANCE;
        }
        catch(Exception v0_1) {
            v5 = false;
            goto label_186;
        }

        try {
            v8 = v1.ownerUid;
            v14 = 16;
            v15 = null;
            v13 = null;
            v11 = arg28;
            v5 = false;
            v9 = arg26;
        }
        catch(Exception v0_1) {
            v5 = ((boolean)v9);
            goto label_186;
        }

        try {
            v6_1 = AndroidStretchJournalDescriptor.adopt$default(v6, v7, v8, v9, v11, v13, v14, v15);
            v7_1 = null;
            goto label_34;
        }
        catch(Exception v0_1) {
        }

    label_186:
        v1.arming = v5;
        throw v0_1;
        try {
        label_34:
            v1.journal = v6_1;
            v1.fence = v3;
            v1.originalGeneration = v0.getAgentGeneration();
            v1.originalEvidence = v0;
            v3.linkToDeath(v1.sourceDeath, 0);
            v1.applierFence = new StretchApplierFence(v1.dead, new StretchRescueHost$$ExternalSyntheticLambda5(v3), new StretchRescueHost$$ExternalSyntheticLambda6(v1, v3));
            v8 = v1.ownerUid;
            String v9_1 = v1.generation;
            v19 = AndroidRecoverySupport.INSTANCE.getClock();
            v20 = new StretchRescueHost$arm$session$1(AndroidStretchBootIdentity.INSTANCE);
            StretchRescueHost$$ExternalSyntheticLambda7 v10 = new StretchRescueHost$$ExternalSyntheticLambda7(v1);
            v23 = new StretchRescueHost$arm$session$3(v1);
            v21 = v6_1;
            v17 = v8;
            v18 = v9_1;
            v22 = v10;
        }
        catch(Throwable v0_2) {
            v21 = v6_1;
            goto label_152;
        }

        try {
            v6_2 = new StretchExternalRescue(v17, v18, v19, ((Function0)v20), v21, ((Function2)v22), ((Function0)v23));
            v2 = v6_2.arm(v0, v2, v4, true);
            if(Intrinsics.areEqual(v2, "ARMED_READ_ONLY")) {
                goto label_101;
            }
        }
        catch(Throwable v0_2) {
            goto label_149;
        }

        if(v1.core == null) {
            try {
                Result.constructor-impl(Boolean.valueOf(v3.unlinkToDeath(v1.sourceDeath, 0)));
            }
            catch(Throwable v0_2) {
                Result.constructor-impl(ResultKt.createFailure(v0_2));
            }

            try {
                v21.close();
                v1.journal = v7_1;
            }
            catch(Throwable v0_2) {
            }
            catch(Exception v0_1) {
                try {
                    v1.releaseFailed = true;
                    throw v0_1;
                }
                catch(Throwable v0_2) {
                    v1.arming = false;
                    throw v0_2;
                }
            }

            v1.arming = false;
            return v2;
        }

        v1.arming = false;
        return v2;
        try {
        label_101:
            v1.core = v6_2;
            StretchExperimentRpc.INSTANCE.call(v3, 5, new StretchRescueHost$$ExternalSyntheticLambda8(v1, v0, v4), new StretchRescueHost$$ExternalSyntheticLambda9());
            if(v1.sourcePid.get() > 0 && v1.sourcePid.get() != Process.myPid()) {
                goto label_116;
            }

            goto label_143;
        }
        catch(Throwable v0_2) {
            goto label_149;
        }

    label_116:
        if(v1.core == null) {
            try {
                Result.constructor-impl(Boolean.valueOf(v3.unlinkToDeath(v1.sourceDeath, 0)));
            }
            catch(Throwable v0_2) {
                Result.constructor-impl(ResultKt.createFailure(v0_2));
            }

            try {
                v21.close();
                v1.journal = v7_1;
            }
            catch(Throwable v0_2) {
            }
            catch(Exception v0_1) {
                try {
                    v1.releaseFailed = true;
                    throw v0_1;
                }
                catch(Throwable v0_2) {
                    v1.arming = false;
                    throw v0_2;
                }
            }

            v1.arming = false;
            return v2;
        }
        else {
            v1.arming = false;
            return v2;
        }

        try {
        label_143:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        catch(Throwable v0_2) {
        label_149:
        }

    label_152:
        Throwable v2_1 = v0_2;
        if(v1.core == null) {
            try {
                Result.constructor-impl(Boolean.valueOf(v3.unlinkToDeath(v1.sourceDeath, 0)));
            }
            catch(Throwable v0_2) {
                Result.constructor-impl(ResultKt.createFailure(v0_2));
            }

            try {
                v21.close();
                v1.journal = v7_1;
            }
            catch(Throwable v0_2) {
            }
            catch(Exception v0_1) {
                try {
                    v1.releaseFailed = true;
                    throw v0_1;
                }
                catch(Throwable v0_2) {
                    v1.arming = false;
                    throw v0_2;
                }
            }

            v1.arming = false;
        }
        else {
            v1.arming = false;
        }

        throw v2_1;
    }

    static final boolean arm$lambda$1(IBinder arg0) {
        return arg0.isBinderAlive();
    }

    static final Unit arm$lambda$2(StretchRescueHost arg0, IBinder arg1) {
        arg0.sendFence(arg1);
        return Unit.INSTANCE;
    }

    static final StretchPhysicalIo arm$lambda$4(StretchRescueHost arg4, StretchOriginalEvidence arg5, StretchRestorationIdentity arg6) {
        Intrinsics.checkNotNullParameter(arg5, "original");
        Intrinsics.checkNotNullParameter(arg6, "identity");
        return new StretchRescueHost$arm$session$2$1(new AndroidStretchPhysicalIo(arg4.context, arg5, arg6, StretchPhysicalCommandPermit.Companion.forRestoration(new StretchRescueHost$$ExternalSyntheticLambda1(arg4))), arg4);
    }

    static final boolean arm$lambda$4$lambda$3(StretchRescueHost arg2) {
        if(Process.myUid() == 2000 && arg2.core != null) {
            return 1;
        }

        return 0;
    }

    static final Unit arm$lambda$5(StretchRescueHost arg1, StretchOriginalEvidence arg2, int arg3, Parcel arg4) {
        Intrinsics.checkNotNullParameter(arg4, "it");
        arg4.writeStrongBinder(arg1.capability);
        arg4.writeString(StretchOriginalEvidenceCodec.INSTANCE.encode(arg2));
        arg4.writeInt(arg3);
        return Unit.INSTANCE;
    }

    static final Unit arm$lambda$6(Parcel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        if(arg1.readInt() == 1) {
            return Unit.INSTANCE;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final boolean fenceAndAwait() {
        StretchApplierFence v4 = this.applierFence;
        if(v4 != null) {
            return StretchApplierFence.awaitDeath$default(v4, 0, 1, null);
        }

        return 0;
    }

    private final boolean finished() {
        String v3_1;
        Set v0 = SetsKt.setOf(new String[]{"NO_MUTATION_CLOSED", "RESTORE_VERIFIED_CLOSED", "ORIGINAL_VERIFIED_CLOSED"});
        StretchExternalRescue v3 = this.core;
        if(v3 != null) {
            v3_1 = v3.getResult();
        }
        else {
            Object v3_2 = null;
        }

        return CollectionsKt.contains(((Iterable)v0), v3_1);
    }

    public final boolean getAllowsRestoreHandoff() {
        if(this.core != null && (this.getRetained())) {
            return 1;
        }

        return 0;
    }

    public final boolean getRetained() {
        if(!this.arming && this.journal == null) {
            if(this.releaseFailed) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final void poll() {
        StretchExternalRescue v0 = this.core;
        if(v0 != null) {
            long v1 = AndroidRecoverySupport.INSTANCE.getClock().elapsedRealtimeMillis();
            if((v0.getHealthyActive()) && (v1 < this.lastHealthCheck || v1 - this.lastHealthCheck >= 5000)) {
                this.lastHealthCheck = v1;
                StretchOriginalEvidence v1_1 = this.originalEvidence;
                if(v1_1 != null) {
                    v0.checkActive(new StretchRescueHost$$ExternalSyntheticLambda2(this, v1_1), new StretchRescueHost$$ExternalSyntheticLambda3(this, v1_1, v0));
                    goto label_28;
                }

                throw new IllegalArgumentException("Required value was null.".toString());
            }

        label_28:
            Object v2 = null;
            try {
                if(!this.dead.isDone()) {
                    IBinder v4 = this.fence;
                    if(v4 != null && !v4.isBinderAlive()) {
                        goto label_42;
                    }

                    StretchExternalRescue.recover$default(v0, false, false, 3, v2);
                    goto label_46;
                }

            label_42:
                v0.sourceDied();
            }
            catch(Exception ) {
                StretchExternalRescue.recover$default(v0, true, false, 2, v2);
            }

        label_46:
            if(!this.finished() && !v0.canReleaseForRecovery()) {
                return;
            }

            if(!this.releaseFailed) {
                try {
                    StretchCandidateJournal v0_1 = this.journal;
                    if(v0_1 != null) {
                        v0_1.close();
                    }

                    this.journal = ((StretchCandidateJournal)v2);
                }
                catch(Exception ) {
                    this.releaseFailed = true;
                }
            }
        }
    }

    static final Unit poll$lambda$10(StretchRescueHost arg8, StretchOriginalEvidence arg9, StretchExternalRescue arg10, String arg11, StretchFullProjection arg12) {
        Intrinsics.checkNotNullParameter(arg11, "identity");
        Intrinsics.checkNotNullParameter(arg12, "projection");
        new AndroidStretchPhysicalIo(arg8.context, arg9, null, StretchPhysicalCommandPermit.Companion.forApplication(new StretchRescueHost$$ExternalSyntheticLambda0(arg10)), 4, null).projection(arg11, arg12);
        return Unit.INSTANCE;
    }

    static final boolean poll$lambda$10$lambda$9(StretchExternalRescue arg1) {
        if((arg1.getHealthyActive()) && Process.myUid() == 2000) {
            return 1;
        }

        return 0;
    }

    static final StretchOriginalEvidence poll$lambda$8(StretchRescueHost arg7, StretchOriginalEvidence arg8) {
        return new AndroidStretchPhysicalIo(arg7.context, arg8, null, null, 12, null).read();
    }

    public final String restore() {
        if(this.core != null && this.journal == null && !this.finished()) {
            return "RECOVERY_REQUIRES_NEW_SESSION";
        }

        StretchExternalRescue v0 = this.core;
        if(v0 != null) {
            if(v0.recover(true, true) == null) {
            }
            else {
                this.poll();
                return this.status();
            }
        }

        return "NOT_ARMED";
    }

    private final void sendFence(IBinder arg4) {
        Parcel v3 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v3, "obtain(...)");
        Parcel v1 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v1, "obtain(...)");
        try {
            v3.writeInterfaceToken("com.TryJeanPc.goldenmouse.stretch.rescue.v1");
            v3.writeInt(3);
            StretchAgentWire.INSTANCE.bounded(v3);
            if(!arg4.transact(6, v3, v1, 0)) {
                goto label_23;
            }

            StretchAgentWire.INSTANCE.bounded(v1);
            v1.readException();
            StretchAgentWire.INSTANCE.exhausted(v1);
        }
        catch(Throwable v4) {
            goto label_28;
        }

        v3.recycle();
        v1.recycle();
        return;
        try {
        label_23:
            throw new IllegalStateException("Check failed.");
        }
        catch(Throwable v4) {
        label_28:
            v3.recycle();
            v1.recycle();
            throw v4;
        }
    }

    static final void sourceDeath$lambda$0(StretchRescueHost arg1) {
        arg1.dead.complete(Unit.INSTANCE);
    }

    public final String status() {
        if(this.releaseFailed) {
            return "JOURNAL_RELEASE_FAILED";
        }

        if((this.finished()) && this.journal != null) {
            return "RELEASING_JOURNAL";
        }

        StretchExternalRescue v0 = this.core;
        if(v0 != null) {
            String v0_1 = v0.getResult();
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        if(this.arming) {
            return "ARMING";
        }

        return "NOT_ARMED";
    }

    public final String verify(boolean arg1) {
        StretchExternalRescue v0 = this.core;
        if(v0 != null) {
            String v0_1 = v0.verifyExecutor(arg1);
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return "NOT_ARMED";
    }
}

