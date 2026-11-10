package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder$DeathRecipient;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import com.TryJeanPc.goldenmouse.stretch.physical.StretchPhysicalCommandPermit;
import com.TryJeanPc.goldenmouse.stretch.recovery.AndroidRecoverySupport;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 32\u00020\u0001:\u00013B\u001F\b\u0007\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001A\u00020\u000EH\u0002J*\u0010-\u001A\u00020\u00052\u0006\u0010.\u001A\u00020\t2\u0006\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u0001002\u0006\u00102\u001A\u00020\tH\u0014R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\u0017\u001A\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0019\u0010\u001AR\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001F\u001A\u0004\u0018\u00010 X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001A\u0004\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010$\u001A\u0004\u0018\u00010%X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010&\u001A\u0004\u0018\u00010\'X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010(\u001A\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001C\u001A\u0004\b*\u0010+¨\u00064"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/GoldenStretchDisplayService;", "Landroid/os/Binder;", "context", "Landroid/content/Context;", "rescueOnly", "", "<init>", "(Landroid/content/Context;Z)V", "effectiveUid", "", "ownerLookup", "Lkotlin/Result;", "ownerUid", "newAgent", "Lcom/TryJeanPc/goldenmouse/stretch/agent/GoldenStretchDisplayAgent;", "agent", "applying", "activeReply", "restoreOnlyOwner", "owner", "Landroid/os/IBinder;", "ownerChallenge", "", "physical", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalSession;", "getPhysical", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalSession;", "physical$delegate", "Lkotlin/Lazy;", "death", "Landroid/os/IBinder$DeathRecipient;", "watchdog", "Ljava/util/concurrent/ScheduledExecutorService;", "destroyed", "originalReader", "Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchOriginalReader;", "originalEvidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "experiment", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchApplyEndpoint;", "rescue", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRescueHost;", "getRescue", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRescueHost;", "rescue$delegate", "onTransact", "code", "data", "Landroid/os/Parcel;", "reply", "flags", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public class GoldenStretchDisplayService extends Binder {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/GoldenStretchDisplayService$Companion;", "", "<init>", "()V", "BUILD_REVISION", "", "PACKAGE", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StretchExperimentOperation.values().length];
            try {
                v0[StretchExperimentOperation.ENDPOINT.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StretchExperimentOperation.ARM.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StretchExperimentOperation.VERIFY_EXECUTOR.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[StretchExperimentOperation.APPLY_EXPERIMENT.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[StretchExperimentOperation.RESTORE.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[StretchExperimentOperation.STATUS.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                label_27:
                                    WhenMappings.$EnumSwitchMapping$0 = v0;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final int BUILD_REVISION = 13;
    public static final Companion Companion = null;
    public static final String PACKAGE = "com.TryJeanPc.goldenmouse";
    private volatile boolean activeReply;
    private volatile GoldenStretchDisplayAgent agent;
    private volatile boolean applying;
    private final Context context;
    private IBinder$DeathRecipient death;
    private volatile boolean destroyed;
    private final int effectiveUid;
    private StretchApplyEndpoint experiment;
    private StretchOriginalEvidence originalEvidence;
    private AndroidStretchOriginalReader originalReader;
    private volatile IBinder owner;
    private String ownerChallenge;
    private final Result ownerLookup;
    private final int ownerUid;
    private final Lazy physical$delegate;
    private final Lazy rescue$delegate;
    private final boolean rescueOnly;
    private boolean restoreOnlyOwner;
    private ScheduledExecutorService watchdog;

    static {
        GoldenStretchDisplayService.Companion = new Companion(null);
        GoldenStretchDisplayService.$stable = 8;
    }

    public GoldenStretchDisplayService() {
        this(null, false, 3, null);
    }

    public GoldenStretchDisplayService(Context arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        this(arg1, false);
    }

    public GoldenStretchDisplayService(Context arg4) {
        this(arg4, false, 2, null);
    }

    public GoldenStretchDisplayService(Context arg3, boolean arg4) {
        int v3_3;
        Result v3_2;
        Object v3_1;
        super();
        this.context = arg3;
        this.rescueOnly = arg4;
        this.effectiveUid = Process.myUid();
        Object v4 = null;
        if(arg3 != null) {
            try {
                v3_1 = Result.constructor-impl(Integer.valueOf(arg3.getPackageManager().getApplicationInfo("com.TryJeanPc.goldenmouse", 0).uid));
            }
            catch(Throwable v3) {
                v3_1 = Result.constructor-impl(ResultKt.createFailure(v3));
            }

            v3_2 = Result.box-impl(v3_1);
        }
        else {
            v3_2 = ((Result)v4);
        }

        this.ownerLookup = v3_2;
        if(v3_2 != null) {
            v3_1 = v3_2.unbox-impl();
            if(Result.isFailure-impl(v3_1)) {
            }
            else {
                v4 = v3_1;
            }

            if(v4 == null) {
                goto label_34;
            }

            v3_3 = ((Integer)v4).intValue();
        }
        else {
        label_34:
            v3_3 = -1;
        }

        this.ownerUid = v3_3;
        this.agent = this.newAgent();
        this.physical$delegate = LazyKt.lazy(new GoldenStretchDisplayService$$ExternalSyntheticLambda2(this));
        this.rescue$delegate = LazyKt.lazy(new GoldenStretchDisplayService$$ExternalSyntheticLambda3(this));
    }

    private final StretchPhysicalSession getPhysical() {
        return this.physical$delegate.getValue();
    }

    private final StretchRescueHost getRescue() {
        return this.rescue$delegate.getValue();
    }

    private final GoldenStretchDisplayAgent newAgent() {
        int v1 = this.ownerUid;
        int v2 = this.effectiveUid;
        String v3 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(v3, "toString(...)");
        return new GoldenStretchDisplayAgent(v1, v2, v3, new GoldenStretchDisplayService$$ExternalSyntheticLambda6(this), AndroidRecoverySupport.INSTANCE.getClock());
    }

    static final StretchAgentBaseline newAgent$lambda$2(GoldenStretchDisplayService arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "session");
        Context v1 = arg1.context;
        if(v1 != null) {
            return new AndroidStretchBaselineProbe(v1).capture(arg2);
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    protected boolean onTransact(int arg26, Parcel arg27, Parcel arg28, int arg29) {
        ObjectRef v3_5;
        StretchAgentRequest v14_1;
        Object v10_3;
        StretchApplyEndpoint v5_1;
        long v15;
        boolean v0_10;
        StretchPairResult v3_2;
        StretchOriginalEvidence v1_2;
        StretchPairResult v0_9;
        String v0_7;
        long v9_1;
        StretchAgentRequest v3_1;
        Object v0_6;
        IBinder v0_5;
        StretchAgentReply v15_3;
        Object v15_2;
        Object v1_7;
        StretchOriginalAgentProgress v14_2;
        StretchAgentRequest v0_15;
        GoldenStretchDisplayService v9_2;
        int v24;
        StretchPhysicalReply v0_14;
        int v2_2;
        ObjectRef v10_4;
        StretchOriginalEvidence v5_3;
        Object v3_7;
        GoldenStretchDisplayService$$ExternalSyntheticLambda8 v6_1;
        long v3_6;
        StretchPhysicalSession v13_2;
        long v11_2;
        long v17_1;
        long v10_6;
        Parcel v5_4;
        Parcel v4_4;
        GoldenStretchDisplayAgent v3_9;
        IBinder v2_3;
        int v1_8;
        StretchConnectRejection v0_18;
        int v13;
        int v12;
        int v11;
        IBinder v1_1;
        int v6;
        IBinder v5;
        int v9;
        GoldenStretchDisplayService v2 = this;
        int v0 = arg26;
        Parcel v1 = arg27;
        Parcel v7 = arg28;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(v1, "data");
            if(v0 != 0x5F4E5446) {
                goto label_16;
            }

            if(v7 != null) {
                v7.writeString("com.TryJeanPc.goldenmouse.stretch.agent.v2");
            }
        }
        catch(Throwable v0_1) {
            goto label_913;
        }

        __monitor_exit(this);
        return 1;
        try {
        label_16:
            v9 = Binder.getCallingUid();
            int v4 = 2000;
            v5 = null;
            v6 = 0;
            if(v0 != 0xFFFF9B) {
                goto label_67;
            }

            if(v2.effectiveUid == v4 && v9 == v4) {
                v2.getPhysical().requestRecovery();
                v2.getPhysical().poll(false);
                if(!v2.getPhysical().getRetained()) {
                    if((v2.rescueOnly) && (v2.getRescue().getRetained())) {
                        goto label_60;
                    }

                    v2.destroyed = true;
                    v2.agent.ownerLost();
                    ScheduledExecutorService v0_2 = v2.watchdog;
                    if(v0_2 != null) {
                        v0_2.shutdownNow();
                    }

                    AndroidStretchOriginalReader v0_3 = v2.originalReader;
                    if(v0_3 != null) {
                        v0_3.close();
                    }

                    IBinder$DeathRecipient v0_4 = v2.death;
                    if(v0_4 != null) {
                        v1_1 = v2.owner;
                        if(v1_1 != null) {
                            Boolean.valueOf(v1_1.unlinkToDeath(v0_4, 0));
                        }
                    }

                    v2.owner = v5;
                    v2.ownerChallenge = ((String)v5);
                    Process.killProcess(Process.myPid());
                    goto label_58;
                }

                goto label_60;
            }

            goto label_62;
        }
        catch(Throwable v0_1) {
            goto label_913;
        }

    label_58:
        __monitor_exit(this);
        return 1;
    label_60:
        __monitor_exit(this);
        return 0;
        try {
        label_62:
            throw new IllegalArgumentException("Failed requirement.".toString());
        label_67:
            int v3 = 5;
            Integer[] v10 = new Integer[v3];
            v10[0] = Integer.valueOf(1);
            v11 = 2;
            v10[1] = Integer.valueOf(v11);
            v12 = 3;
            v10[v11] = Integer.valueOf(v12);
            v13 = 4;
            v10[v12] = Integer.valueOf(v13);
            v10[v13] = Integer.valueOf(v3);
            if(SetsKt.setOf(((Object[])v10)).contains(Integer.valueOf(v0))) {
                goto label_88;
            }
        }
        catch(Throwable v0_1) {
            goto label_913;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_88:
            int v14 = 10000;
            if(!v2.destroyed && v2.effectiveUid == v4) {
                int v10_1 = v2.ownerUid;
                if(v10_1 >= v14 && v9 == v10_1) {
                    if(!StretchAgentWire.INSTANCE.isSynchronousTransport(arg29)) {
                    }
                    else if(v7 != null) {
                        StretchAgentWire.INSTANCE.bounded(v1);
                        try {
                            v1.enforceInterface("com.TryJeanPc.goldenmouse.stretch.agent.v2");
                            if(v0 != 1) {
                                goto label_107;
                            }
                            else {
                                goto label_739;
                            }
                        }
                        catch(SecurityException ) {
                            goto label_860;
                        }
                    }
                    else {
                        goto label_864;
                    }
                }
            }

            goto label_870;
        }
        catch(Throwable v0_1) {
            goto label_913;
        }

    label_107:
        if(v0 == v11) {
            goto label_684;
            try {
            label_779:
                v4_4.writeInterfaceToken("com.TryJeanPc.goldenmouse.stretch.agent.v2.peer");
                v4_4.writeString(v0_7);
                v4_4.writeString(v3_9.getGeneration());
                if(!v2_3.transact(1, v4_4, v5_4, 0)) {
                    goto label_840;
                }

                try {
                    v5_4.readException();
                }
                catch(SecurityException ) {
                    goto label_837;
                }

                if(v5_4.readInt() != 1) {
                    goto label_832;
                }

                StretchAgentWire.INSTANCE.exhausted(v5_4);
                if(v9_2.owner == null || v1_8 != 0) {
                    GoldenStretchDisplayService$$ExternalSyntheticLambda0 v12_2 = new GoldenStretchDisplayService$$ExternalSyntheticLambda0(v9_2, v3_9);
                    v2_3.linkToDeath(((IBinder$DeathRecipient)v12_2), 0);
                    IBinder$DeathRecipient v13_3 = v9_2.death;
                    if(v13_3 != null) {
                        IBinder v14_3 = v9_2.owner;
                        if(v14_3 != null) {
                            Boolean.valueOf(v14_3.unlinkToDeath(v13_3, 0));
                        }
                    }

                    if(v1_8 != 0) {
                        v9_2.agent.ownerLost();
                        v9_2.agent = v3_9;
                        v9_2.restoreOnlyOwner = true;
                    }

                    v9_2.death = ((IBinder$DeathRecipient)v12_2);
                    v9_2.owner = v2_3;
                    v9_2.ownerChallenge = v0_7;
                }

                if(v9_2.watchdog == null) {
                    ScheduledExecutorService v12_3 = Executors.newSingleThreadScheduledExecutor(new GoldenStretchDisplayService$$ExternalSyntheticLambda9());
                    v12_3.scheduleWithFixedDelay(new GoldenStretchDisplayService$$ExternalSyntheticLambda10(v9_2), 0xFA, 0xFA, TimeUnit.MILLISECONDS);
                    v9_2.watchdog = v12_3;
                }
            }
            catch(Throwable v0_1) {
                goto label_846;
            }

            try {
                Binder.restoreCallingIdentity(v10_6);
                v4_4.recycle();
                v5_4.recycle();
                v7.writeNoException();
                v7.writeString(v9_2.agent.getGeneration());
                goto label_830;
            }
            catch(Throwable v0_1) {
                goto label_916;
            }

            try {
            label_832:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_837:
                throw StretchAgentConnectionDiagnosticsKt.stretchConnectSecurityError(StretchConnectRejection.SERVICE_CALLBACK_RETURN);
            label_840:
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            catch(Throwable v0_1) {
                try {
                label_846:
                    Binder.restoreCallingIdentity(v10_6);
                    v4_4.recycle();
                    v5_4.recycle();
                    throw v0_1;
                label_850:
                    throw new IllegalArgumentException("Required value was null.".toString());
                label_855:
                    throw new IllegalArgumentException("Failed requirement.".toString());
                label_860:
                    throw StretchAgentConnectionDiagnosticsKt.stretchConnectSecurityError(StretchConnectRejection.SERVICE_INTERFACE);
                label_864:
                    throw new IllegalArgumentException("Required value was null.".toString());
                label_870:
                    v24 = v9;
                    v9_2 = v2;
                    v2_2 = v24;
                    if(v9_2.destroyed) {
                        v0_18 = StretchConnectRejection.SERVICE_DESTROYED;
                    }
                    else if(v9_2.effectiveUid != v4) {
                        v0_18 = StretchConnectRejection.SERVICE_UID_NOT_SHELL;
                    }
                    else if(v9_2.context != null) {
                        Result v0_17 = v9_2.ownerLookup;
                        if(v0_17 != null) {
                            Throwable v5_5 = Result.exceptionOrNull-impl(v0_17.unbox-impl());
                        }

                        if(!((((Throwable)v5)) instanceof SecurityException)) {
                            v0_17 = v9_2.ownerLookup;
                            if(v0_17 != null) {
                                if(!Result.isFailure-impl(v0_17.unbox-impl())) {
                                }
                                else {
                                    v0_18 = StretchConnectRejection.OWNER_LOOKUP_FAILED;
                                    goto label_909;
                                }
                            }

                            v0 = v9_2.ownerUid;
                            if(v0 >= v14) {
                                if(v2_2 != v0) {
                                    v0_18 = StretchConnectRejection.CALLER_UID_MISMATCH;
                                    goto label_909;
                                }

                                v0_18 = StretchConnectRejection.CALL_FLAGS_INVALID;
                                goto label_909;
                            }

                            v0_18 = StretchConnectRejection.OWNER_UID_INVALID;
                            goto label_909;
                        }

                        v0_18 = StretchConnectRejection.OWNER_LOOKUP_SECURITY;
                    }
                    else {
                        v0_18 = StretchConnectRejection.SERVICE_CONTEXT_MISSING;
                    }

                label_909:
                    throw StretchAgentConnectionDiagnosticsKt.stretchConnectSecurityError(v0_18);
                }
                catch(Throwable v0_1) {
                    goto label_916;
                }
            }

            try {
            label_171:
                v1_2 = ((StretchOriginalEvidence)v5);
                v3_2 = ((StretchPairResult)v1_2);
            label_323:
                v7.writeNoException();
                v7.writeString(v0_7);
                v7.writeStrongBinder(((IBinder)v5_1));
                if(v1_2 == null) {
                }
                else {
                    v6 = 1;
                }

                v7.writeInt(v6);
                if(v1_2 != null) {
                    v7.writeString(StretchOriginalEvidenceCodec.INSTANCE.encode(v1_2));
                }

                long v0_19 = -1;
                long v4_5 = v3_2 != null ? v3_2.getWritesMillis() : v0_19;
                v7.writeLong(v4_5);
                v4_5 = v3_2 != null ? v3_2.getProjectionApplyMillis() : v0_19;
                v7.writeLong(v4_5);
                if(v3_2 != null) {
                    v0_19 = v3_2.getReadbackMillis();
                }

                v7.writeLong(v0_19);
            }
            catch(Throwable v0_1) {
                goto label_375;
            }

            try {
                Binder.restoreCallingIdentity(v9_1);
                goto label_830;
            }
            catch(Throwable v0_1) {
                goto label_913;
            }

            try {
            label_375:
                Binder.restoreCallingIdentity(v9_1);
                throw v0_1;
            }
            catch(Throwable v0_1) {
                goto label_913;
            }
        }
        else if(v0 == v12) {
            goto label_565;
            try {
            label_631:
                v10_3 = v14_2.step(StretchOriginalAgentStep.READER_CREATE, new GoldenStretchDisplayService$$ExternalSyntheticLambda14(v9_2));
                StretchAgentBaseline v11_3 = ((StretchAgentReply)v15_2).getBaseline();
                if(v11_3 != null) {
                    v1_2 = AndroidStretchOriginalReader.capture$default(((AndroidStretchOriginalReader)v10_3), v11_3, v9_2.agent.getGeneration(), v0_15.getOwnerGeneration(), v14_2, false, 16, null);
                }
                else {
                    goto label_656;
                }
            }
            catch(Throwable v0_1) {
                goto label_662;
            }

            try {
                Binder.restoreCallingIdentity(v3_6);
                v15_2 = v14_2.step(StretchOriginalAgentStep.SESSION_RECHECK, new GoldenStretchDisplayService$$ExternalSyntheticLambda15(v9_2, v2_2, v0_15, v1_2));
            label_651:
                StretchOriginalAgentStep v0_16 = StretchOriginalAgentStep.REPLY_ENCODE;
                v14_2.step(v0_16, new GoldenStretchDisplayService$$ExternalSyntheticLambda16(v7, v15_3));
                goto label_830;
            }
            catch(Throwable v0_1) {
                goto label_916;
            }

            try {
            label_656:
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            catch(Throwable v0_1) {
                try {
                label_662:
                    Binder.restoreCallingIdentity(v3_6);
                    throw v0_1;
                label_664:
                    throw new IllegalArgumentException("Required value was null.".toString());
                label_669:
                    throw new IllegalArgumentException("Required value was null.".toString());
                label_674:
                    throw new IllegalArgumentException("Failed requirement.".toString());
                label_679:
                    throw new IllegalArgumentException("Failed requirement.".toString());
                label_684:
                    v24 = v9;
                    v9_2 = v2;
                    v2_2 = v24;
                    v0_5 = v9_2.owner;
                    if(v0_5 != null && (v0_5.isBinderAlive())) {
                        v0_15 = StretchAgentWire.INSTANCE.readRequest(v1);
                        StretchAgentWire.INSTANCE.exhausted(v1);
                        v1_8 = v0_15.getAction() != StretchAgentAction.CLOSE || !v9_2.getPhysical().getRetained() || !v9_2.agent.authorizePhysical$app(v2_2, v0_15, true) ? 0 : 1;
                        if(v1_8 != 0) {
                            v9_2.getPhysical().requestRecovery();
                            v9_2.getPhysical().poll(false);
                        }

                        StretchAgentReply v10_5 = v1_8 == 0 || !v9_2.getPhysical().getRetained() ? v9_2.agent.handle(v2_2, v0_15) : new StretchAgentReply(v0_15.getOperationId(), v9_2.agent.getGeneration(), StretchAgentCode.RECOVERY_PENDING, StretchAgentPhase.RECOVERY_PENDING, null, null, 0x30, null);
                        v7.writeNoException();
                        StretchAgentWire.INSTANCE.writeReply(v7, v10_5);
                        goto label_830;
                    }

                    throw new IllegalArgumentException("Failed requirement.".toString());
                label_739:
                    v9_2 = v2;
                    if(v1.readInt() != v11) {
                        goto label_855;
                    }

                    v0_7 = StretchAgentWire.INSTANCE.text(v1);
                    v2_3 = v1.readStrongBinder();
                    if(v2_3 == null) {
                        goto label_850;
                    }

                    StretchAgentWire.INSTANCE.exhausted(v1);
                    v1_8 = v9_2.owner == null || (Intrinsics.areEqual(v9_2.owner, v2_3)) ? 0 : 1;
                    if(v1_8 != 0 && (!v9_2.rescueOnly || !v9_2.getRescue().getAllowsRestoreHandoff())) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }

                    v3_9 = v1_8 != 0 ? v9_2.newAgent() : v9_2.agent;
                    v4_4 = Parcel.obtain();
                    Intrinsics.checkNotNullExpressionValue(v4_4, "obtain(...)");
                    v5_4 = Parcel.obtain();
                    Intrinsics.checkNotNullExpressionValue(v5_4, "obtain(...)");
                    v10_6 = Binder.clearCallingIdentity();
                    goto label_779;
                }
                catch(Throwable v0_1) {
                    goto label_916;
                }
            }
        }
        else if(v0 == v13) {
            goto label_397;
            try {
            label_436:
                v17_1 = v1.readLong();
                goto label_443;
            label_442:
                v17_1 = v15;
            label_443:
                if(v0_10) {
                    v15 = v1.readLong();
                }

                if(v0_10) {
                    v3_5.element = ParcelFileDescriptor.CREATOR.createFromParcel(v1);
                }

                StretchAgentWire.INSTANCE.exhausted(v1);
                if(v14_1.getAction() == StretchAgentAction.STATUS) {
                    GoldenStretchDisplayAgent v1_4 = v2.agent;
                    StretchPhysicalOperation[] v4_2 = new StretchPhysicalOperation[v13];
                    v4_2[0] = StretchPhysicalOperation.RESTORE;
                    v4_2[1] = StretchPhysicalOperation.STATUS;
                    v4_2[v11] = StretchPhysicalOperation.RELEASE;
                    v4_2[v12] = StretchPhysicalOperation.RECOVER_PERSISTED;
                    if(v1_4.authorizePhysical$app(v9, v14_1, SetsKt.setOf(((Object[])v4_2)).contains(v10_3))) {
                        v11_2 = Binder.clearCallingIdentity();
                        goto label_469;
                    }
                }

                goto label_516;
            }
            catch(Throwable v0_1) {
                goto label_440;
            }

            try {
            label_469:
                v13_2 = v2.getPhysical();
                v1_2 = v2.originalEvidence;
                if(v0_10) {
                }
                else {
                    goto label_490;
                }
            }
            catch(Throwable v0_1) {
                goto label_513;
            }

            long v5_2 = v15;
            StretchOriginalEvidence v15_1 = v1_2;
            ObjectRef v1_5 = v3_5;
            v3_6 = v17_1;
            try {
                v6_1 = new GoldenStretchDisplayService$$ExternalSyntheticLambda8(v1_5, v2, v3_6, v5_2);
                v3_7 = v10_3;
                v5_3 = v15_1;
                v10_4 = v1_5;
                goto label_495;
            }
            catch(Throwable v0_1) {
                goto label_487;
            }

            v1_5 = ((ObjectRef)v3_6);
        label_487:
            v10_4 = v1_5;
            goto label_514;
        label_490:
            Object v2_1 = v10_3;
            v10_4 = v3_5;
            v3_7 = v2_1;
            Function0 v6_2 = ((Function0)v5);
            v5_3 = v1_2;
        label_495:
            v2_2 = v9;
            StretchAgentRequest v4_3 = v14_1;
            StretchPhysicalSession v1_6 = v13_2;
            try {
                v0_14 = v1_6.execute(v2_2, ((StretchPhysicalOperation)v3_7), v4_3, v5_3, ((Function0)v6_1));
            }
            catch(Throwable v0_1) {
                goto label_510;
            }

            try {
                Binder.restoreCallingIdentity(v11_2);
                v7.writeNoException();
                StretchPhysicalRpc.INSTANCE.writeReply(v7, v0_14);
            }
            catch(Throwable v0_1) {
                goto label_524;
            }

            try {
                v0_6 = v10_4.element;
                if(v0_6 == null) {
                    goto label_830;
                }

                ((ParcelFileDescriptor)v0_6).close();
                goto label_830;
            }
            catch(Throwable v0_1) {
                goto label_916;
            }

        label_510:
            goto label_514;
        label_513:
            v10_4 = v3_5;
            try {
            label_514:
                Binder.restoreCallingIdentity(v11_2);
                throw v0_1;
            label_516:
                v10_4 = v3_5;
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            catch(Throwable v0_1) {
                goto label_524;
            }

            try {
            label_529:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_535:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_541:
                throw new IllegalStateException("Unknown paired operation".toString());
            label_547:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_553:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_559:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_565:
                v24 = v9;
                v9_2 = v2;
                v2_2 = v24;
                v0_5 = v9_2.owner;
                if(v0_5 != null && (v0_5.isBinderAlive())) {
                    v0_15 = StretchAgentRequest.copy$default(StretchAgentWire.INSTANCE.readRequest(v1), 0, null, null, null, null, 0, null, null, null, 0, Integer.valueOf(v1.readInt()), 0x3FF, null);
                    StretchAgentWire.INSTANCE.exhausted(v1);
                    if(StretchOriginalEvidenceRpc.INSTANCE.accepts(v0_15)) {
                        v1_1 = v9_2.owner;
                        if(v1_1 != null) {
                            String v3_8 = v9_2.ownerChallenge;
                            if(v3_8 != null) {
                                v14_2 = new StretchOriginalAgentProgress(new GoldenStretchDisplayService$$ExternalSyntheticLambda11(v1_1, v3_8, v0_15, new IntRef()));
                                v14_2.step(StretchOriginalAgentStep.REQUEST_ACCEPTED, new GoldenStretchDisplayService$$ExternalSyntheticLambda12());
                                v1_7 = v14_2.step(StretchOriginalAgentStep.BASELINE_VALIDATION, new GoldenStretchDisplayService$$ExternalSyntheticLambda13(v9_2, v2_2, v0_15));
                                v15_2 = ((Pair)v1_7).component1();
                                if(((Pair)v1_7).component2().booleanValue()) {
                                    v3_6 = Binder.clearCallingIdentity();
                                    goto label_631;
                                }
                                else if(((StretchAgentReply)v15_2).getCode() == StretchAgentCode.ACCEPTED) {
                                    v15_3 = StretchAgentReply.copy$default(((StretchAgentReply)v15_2), null, null, StretchAgentCode.INVALID_REQUEST, null, null, null, 59, null);
                                }

                                goto label_651;
                            }
                            else {
                                goto label_664;
                            }
                        }
                        else {
                            goto label_669;
                        }
                    }
                    else {
                        goto label_674;
                    }
                }

                goto label_679;
            }
            catch(Throwable v0_1) {
                goto label_916;
            }
        }
        else if(v0 != v3) {
        }
        else {
            try {
                v0_5 = v2.owner;
                if(v0_5 != null && (v0_5.isBinderAlive())) {
                    if(v1.readInt() == v12 && (Intrinsics.areEqual(StretchAgentWire.INSTANCE.text(v1), v2.ownerChallenge))) {
                        v0_6 = CollectionsKt.getOrNull(StretchExperimentOperation.getEntries(), v1.readInt());
                        if(v0_6 != null) {
                            v3_1 = StretchAgentWire.INSTANCE.readRequest(v1);
                            if(v3_1.getAction() == StretchAgentAction.STATUS && (StretchExperimentRpc.INSTANCE.acceptsFactor(v3_1.getLogicalDisplayId(), v3_1.getFactorHundredths()))) {
                                GoldenStretchDisplayAgent v4_1 = v2.agent;
                                boolean v10_2 = v0_6 != StretchExperimentOperation.APPLY_EXPERIMENT ? true : false;
                                if(!v4_1.authorizePhysical$app(v9, v3_1, v10_2)) {
                                    goto label_377;
                                }

                                v9_1 = Binder.clearCallingIdentity();
                                goto label_147;
                            }

                            goto label_377;
                        }
                        else {
                            goto label_382;
                        }
                    }

                    goto label_387;
                }

                goto label_392;
            }
            catch(Throwable v0_1) {
                goto label_913;
            }

            try {
            label_147:
                switch(WhenMappings.$EnumSwitchMapping$0[((StretchExperimentOperation)v0_6).ordinal()]) {
                    case 1: {
                        goto label_293;
                    }
                    case 2: {
                        goto label_245;
                    }
                    case 3: {
                        goto label_219;
                    }
                    case 4: {
                        goto label_179;
                    }
                    case 5: {
                        goto label_165;
                    }
                    case 6: {
                        goto label_153;
                    }
                }

                goto label_372;
            label_153:
                if(v2.rescueOnly) {
                    StretchAgentWire.INSTANCE.exhausted(v1);
                    v0_7 = v2.getRescue().status();
                    goto label_171;
                }

                throw new IllegalArgumentException("Failed requirement.".toString());
            label_165:
                if(v2.rescueOnly) {
                    StretchAgentWire.INSTANCE.exhausted(v1);
                    v0_7 = v2.getRescue().restore();
                    goto label_171;
                }

                throw new IllegalArgumentException("Failed requirement.".toString());
            label_179:
                if(v2.rescueOnly) {
                    goto label_214;
                }

                StretchAgentWire.INSTANCE.exhausted(v1);
                v2.applying = true;
            }
            catch(Throwable v0_1) {
                goto label_375;
            }

            try {
                StretchApplyEndpoint v0_8 = v2.experiment;
                if(v0_8 != null) {
                    v0_9 = v0_8.apply(v3_1.getFactorHundredths());
                    if(v0_9 == null) {
                        goto label_189;
                    }
                }
                else {
                label_189:
                    v0_9 = new StretchPairResult("RESCUE_NOT_READY", null, null, 0, 0, 0, 62, null);
                }
            }
            catch(Throwable v0_1) {
                goto label_212;
            }

            try {
                v2.applying = false;
                v2.activeReply = Intrinsics.areEqual(v0_9.getCode(), "APPLY_READBACK_MATCHED_UNACCREDITED");
                v1_2 = v0_9.getAppliedReadback();
                v3_2 = v0_9;
                v0_7 = v0_9.safeCode();
                goto label_323;
            label_212:
                v2.applying = false;
                throw v0_1;
            label_214:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_219:
                if((v2.rescueOnly) && !v2.restoreOnlyOwner) {
                    v0 = v1.readInt();
                    if(v0 >= 0 && v0 < v11) {
                        v0_10 = v0 == 1 ? true : false;
                        StretchAgentWire.INSTANCE.exhausted(v1);
                        v0_7 = v2.getRescue().verify(v0_10);
                        goto label_171;
                    }

                    throw new IllegalArgumentException("Failed requirement.".toString());
                }

                throw new IllegalArgumentException("Failed requirement.".toString());
            label_245:
                if((v2.rescueOnly) && !v2.restoreOnlyOwner) {
                    StretchOriginalEvidence v17 = StretchOriginalEvidenceCodec.INSTANCE.decode(StretchExperimentRpc.INSTANCE.json(v1));
                    if(Intrinsics.areEqual(v17.getSnapshot().getOriginal().getPhysicalIdentity().getValue(), v3_1.getPhysicalIdentity())) {
                        IBinder v19 = v1.readStrongBinder();
                        if(v19 != null) {
                            long v13_1 = v1.readLong();
                            v15 = v1.readLong();
                            Object v12_1 = ParcelFileDescriptor.CREATOR.createFromParcel(v1);
                            try {
                                StretchAgentWire v0_12 = StretchAgentWire.INSTANCE;
                                v0_12.exhausted(v1);
                            }
                            catch(Exception v0_11) {
                                goto label_276;
                            }

                            StretchRescueHost v11_1 = v2.getRescue();
                            Intrinsics.checkNotNull(v12_1);
                            v0_7 = v11_1.arm(((ParcelFileDescriptor)v12_1), v13_1, v15, v17, v3_1.getOwnerGeneration(), v19, v3_1.getFactorHundredths());
                            goto label_171;
                        label_276:
                            ((ParcelFileDescriptor)v12_1).close();
                            throw v0_11;
                        }
                        else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                    else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }

                throw new IllegalArgumentException("Failed requirement.".toString());
            label_293:
                if(!v2.rescueOnly && !v2.getPhysical().getRetained()) {
                    StretchAgentWire.INSTANCE.exhausted(v1);
                    StretchOriginalEvidence v0_13 = v2.originalEvidence;
                    if(v0_13 != null) {
                        if((StretchOriginalEvidenceRpc.INSTANCE.boundTo(v0_13, v3_1)) && (StretchPhysicalPair.Companion.missingOriginal(v0_13).isEmpty())) {
                            StretchApplyEndpoint v1_3 = v2.experiment;
                            if(v1_3 != null) {
                            }
                            else {
                                Context v3_3 = v2.context;
                                if(v3_3 != null) {
                                    v1_3 = new StretchApplyEndpoint(v3_3, v0_13, new GoldenStretchDisplayService$$ExternalSyntheticLambda1(v2));
                                    v2.experiment = v1_3;
                                }
                                else {
                                    goto label_352;
                                }
                            }

                            v0_7 = "APPLIER_ENDPOINT_READY";
                            v3_2 = ((StretchPairResult)v5);
                            v5_1 = v1_3;
                            v1_2 = ((StretchOriginalEvidence)v3_2);
                            goto label_323;
                        }

                        goto label_357;
                    }
                    else {
                        goto label_362;
                    }
                }

                goto label_367;
            }
            catch(Throwable v0_1) {
                goto label_375;
            }

            try {
            label_352:
                throw new IllegalArgumentException("Required value was null.".toString());
            label_357:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_362:
                throw new IllegalArgumentException("Required value was null.".toString());
            label_367:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_372:
                throw new NoWhenBranchMatchedException();
            }
            catch(Throwable v0_1) {
                goto label_375;
            }

            try {
            label_377:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_382:
                throw new IllegalStateException("Invalid experiment operation".toString());
            label_387:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_392:
                throw new IllegalArgumentException("Failed requirement.".toString());
            label_397:
                if(v2.rescueOnly) {
                    goto label_559;
                }

                v0_5 = v2.owner;
                if(v0_5 != null && (v0_5.isBinderAlive())) {
                    if(v1.readInt() == 1 && (Intrinsics.areEqual(StretchAgentWire.INSTANCE.text(v1), v2.ownerChallenge))) {
                        v10_3 = CollectionsKt.getOrNull(StretchPhysicalOperation.getEntries(), v1.readInt());
                        if(v10_3 != null) {
                            v14_1 = StretchAgentWire.INSTANCE.readRequest(v1);
                            v0 = v1.readInt();
                            if(v0 >= 0 && v0 < v11) {
                                v0_10 = v0 == 1 ? true : false;
                                StretchPhysicalOperation[] v3_4 = new StretchPhysicalOperation[v11];
                                v3_4[0] = StretchPhysicalOperation.PREPARE;
                                v3_4[1] = StretchPhysicalOperation.RECOVER_PERSISTED;
                                if(v0_10 != SetsKt.setOf(((Object[])v3_4)).contains(v10_3)) {
                                    goto label_529;
                                }

                                v3_5 = new ObjectRef();
                                v15 = 0;
                                if(v0_10) {
                                    goto label_436;
                                }
                                else {
                                    goto label_442;
                                }
                            }

                            goto label_535;
                        }
                        else {
                            goto label_541;
                        }
                    }

                    goto label_547;
                }

                goto label_553;
            }
            catch(Throwable v0_1) {
                goto label_913;
            }
        }

    label_830:
        __monitor_exit(this);
        return 1;
        goto label_913;
    label_440:
        v10_4 = v3_5;
        try {
        label_524:
            v1_7 = v10_4.element;
            if(v1_7 != null) {
                ((ParcelFileDescriptor)v1_7).close();
            }

            throw v0_1;
        label_913:
            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            goto label_916;
        }

        throw v0_1;
    label_916:
        goto label_913;
    }

    static final Thread onTransact$lambda$12(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchAgentOwnerLease");
        v0.setDaemon(true);
        return v0;
    }

    static final void onTransact$lambda$15$lambda$14(GoldenStretchDisplayService arg4) {
        ScheduledExecutorService v0_2;
        IBinder v0;
        arg4.agent.tick();
        if(!arg4.agent.getNeedsRecovery()) {
            v0 = arg4.owner;
            if(v0 == null) {
                goto label_11;
            }
            else if(v0.isBinderAlive()) {
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            arg4.getPhysical().requestRecovery();
        }

        StretchPhysicalSession.poll$default(arg4.getPhysical(), false, 1, null);
        if(arg4.rescueOnly) {
            arg4.getRescue().poll();
        }

        __monitor_enter(arg4);
        try {
            if((arg4.rescueOnly) && (arg4.agent.getNeedsRecovery()) && !arg4.getRescue().getRetained()) {
                if(!Intrinsics.areEqual(arg4.getRescue().status(), "NOT_ARMED")) {
                    v0 = arg4.owner;
                    if(v0 != null && (v0.isBinderAlive())) {
                        goto label_48;
                    }
                }

                if(arg4.destroyed) {
                    goto label_48;
                }

                arg4.destroyed = true;
                v0_2 = arg4.watchdog;
                if(v0_2 != null) {
                    v0_2.shutdown();
                }

                Process.killProcess(Process.myPid());
            }

        label_48:
            if(!arg4.rescueOnly) {
                if((arg4.applying) || (arg4.activeReply)) {
                    v0 = arg4.owner;
                    if(v0 != null && (v0.isBinderAlive())) {
                        goto label_81;
                    }
                }

                if(!arg4.agent.getNeedsRecovery()) {
                    v0 = arg4.owner;
                    if(v0 != null && (v0.isBinderAlive())) {
                        goto label_81;
                    }
                }

                if(arg4.getPhysical().getRetained()) {
                    goto label_81;
                }

                if(arg4.destroyed) {
                    goto label_81;
                }

                arg4.destroyed = true;
                AndroidStretchOriginalReader v0_3 = arg4.originalReader;
                if(v0_3 != null) {
                    v0_3.close();
                }

                v0_2 = arg4.watchdog;
                if(v0_2 != null) {
                    v0_2.shutdown();
                }

                Process.killProcess(Process.myPid());
            }

        label_81:
        }
        catch(Throwable v0_1) {
            __monitor_exit(arg4);
            throw v0_1;
        }

        __monitor_exit(arg4);
    }

    static final Unit onTransact$lambda$16(IBinder arg8, String arg9, StretchAgentRequest arg10, IntRef arg11, StretchOriginalAgentStep arg12, boolean arg13) {
        Intrinsics.checkNotNullParameter(arg12, "step");
        StretchOriginalProgressWire v0 = StretchOriginalProgressWire.INSTANCE;
        ++arg11.element;
        v0.send(arg8, new StretchOriginalCheckpoint(1, arg9, arg10, arg11.element, arg12, arg13));
        return Unit.INSTANCE;
    }

    static final Unit onTransact$lambda$17() {
        return Unit.INSTANCE;
    }

    static final Pair onTransact$lambda$18(GoldenStretchDisplayService arg0, int arg1, StretchAgentRequest arg2) {
        StretchAgentReply v0 = arg0.agent.handle(arg1, arg2);
        return TuplesKt.to(v0, Boolean.valueOf(StretchOriginalEvidenceRpc.INSTANCE.eligible(v0, arg2)));
    }

    static final AndroidStretchOriginalReader onTransact$lambda$20(GoldenStretchDisplayService arg2) {
        AndroidStretchOriginalReader v0 = arg2.originalReader;
        if(v0 == null) {
            Context v1 = arg2.context;
            if(v1 != null) {
                v0 = new AndroidStretchOriginalReader(v1);
                arg2.originalReader = v0;
                return v0;
            }

            throw new IllegalArgumentException("Required value was null.".toString());
        }

        return v0;
    }

    static final StretchAgentReply onTransact$lambda$21(GoldenStretchDisplayService arg10, int arg11, StretchAgentRequest arg12, StretchOriginalEvidence arg13) {
        StretchAgentReply v1 = arg10.agent.handle(arg11, arg12);
        if(StretchOriginalEvidenceRpc.INSTANCE.eligible(v1, arg12)) {
            if((arg13.getStable()) && !arg10.getPhysical().getRetained()) {
                arg10.originalEvidence = arg13;
            }

            return StretchAgentReply.copy$default(v1, null, null, null, null, null, arg13, 0x1F, null);
        }

        return v1;
    }

    static final Unit onTransact$lambda$22(Parcel arg1, StretchAgentReply arg2) {
        arg1.writeNoException();
        StretchOriginalEvidenceRpc.INSTANCE.writeReply(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final boolean onTransact$lambda$23(GoldenStretchDisplayService arg2) {
        IBinder v0 = arg2.owner;
        if(v0 != null && (v0.isBinderAlive()) && (!arg2.agent.getNeedsRecovery() || (arg2.applying))) {
            return 1;
        }

        return 0;
    }

    static final StretchCandidateJournal onTransact$lambda$28(ObjectRef arg11, GoldenStretchDisplayService arg12, long arg13, long arg15) {
        Object v0 = arg11.element;
        if(v0 != null) {
            arg11.element = null;
            return AndroidStretchJournalDescriptor.adopt$default(AndroidStretchJournalDescriptor.INSTANCE, v0, arg12.ownerUid, arg13, arg15, null, 16, null);
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    static final void onTransact$lambda$9(GoldenStretchDisplayService arg1, GoldenStretchDisplayAgent arg2) {
        if(arg1.agent == arg2) {
            arg2.ownerLost();
            arg1.getPhysical().requestRecovery();
        }
    }

    static final StretchPhysicalSession physical_delegate$lambda$6(GoldenStretchDisplayService arg7) {
        return new StretchPhysicalSession(arg7.ownerUid, arg7.agent.getGeneration(), AndroidRecoverySupport.INSTANCE.getClock(), new GoldenStretchDisplayService$physical$2$1(AndroidStretchBootIdentity.INSTANCE), new GoldenStretchDisplayService$$ExternalSyntheticLambda4(arg7), new GoldenStretchDisplayService$$ExternalSyntheticLambda5(arg7));
    }

    static final StretchPhysicalIo physical_delegate$lambda$6$lambda$4(GoldenStretchDisplayService arg4, StretchOriginalEvidence arg5, StretchRestorationIdentity arg6) {
        Intrinsics.checkNotNullParameter(arg5, "evidence");
        Context v1 = arg4.context;
        if(v1 != null) {
            StretchPhysicalCommandPermit v4 = arg6 != null ? StretchPhysicalCommandPermit.Companion.forRestoration(new GoldenStretchDisplayService$$ExternalSyntheticLambda7(arg4)) : null;
            return new AndroidStretchPhysicalIo(v1, arg5, arg6, v4);
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    static final boolean physical_delegate$lambda$6$lambda$4$lambda$3(GoldenStretchDisplayService arg1) {
        if((arg1.getPhysical().getRetained()) && !arg1.destroyed) {
            return 1;
        }

        return 0;
    }

    static final boolean physical_delegate$lambda$6$lambda$5(GoldenStretchDisplayService arg2) {
        IBinder v0 = arg2.owner;
        if(v0 != null && (v0.isBinderAlive()) && !arg2.agent.getNeedsRecovery()) {
            return 1;
        }

        return 0;
    }

    static final StretchRescueHost rescue_delegate$lambda$7(GoldenStretchDisplayService arg3) {
        Context v1 = arg3.context;
        if(v1 != null) {
            return new StretchRescueHost(v1, arg3.ownerUid, arg3.agent.getGeneration());
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

