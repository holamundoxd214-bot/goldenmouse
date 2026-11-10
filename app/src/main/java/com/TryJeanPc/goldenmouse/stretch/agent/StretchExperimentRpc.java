package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import android.os.Parcel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005J(\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014J.\u0010 \u001A\u00020\t2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\u00052\u0006\u0010$\u001A\u00020\t2\u0006\u0010%\u001A\u00020\u0005JK\u0010&\u001A\u0002H\'\"\u0004\b\u0000\u0010\'2\u0006\u0010(\u001A\u00020)2\u0006\u0010\u0011\u001A\u00020\u00052\u0014\b\u0002\u0010*\u001A\u000E\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u0002H\'0+¢\u0006\u0002\u0010/J\u000E\u00100\u001A\u00020-2\u0006\u00101\u001A\u00020,J\u000E\u00102\u001A\u00020\u00122\u0006\u00101\u001A\u00020,R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u00063"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExperimentRpc;", "", "<init>", "()V", "TRANSACTION", "", "VERSION", "FACTOR", "acceptsFactor", "", "displayId", "factor", "acceptsReadback", "operation", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExperimentOperation;", "request", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "code", "", "evidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "CAPABILITY", "BIND", "READ", "COMMIT", "ALLOWED", "INSTALL", "FENCE", "FENCE_FLAGS", "DISPLAY_READ", "APPLY_STEP", "COMPLETE", "acceptsFencePeer", "uid", "pid", "guardianPid", "installed", "flags", "call", "T", "binder", "Landroid/os/IBinder;", "write", "Lkotlin/Function1;", "Landroid/os/Parcel;", "", "read", "(Landroid/os/IBinder;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "envelope", "data", "json", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchExperimentRpc {
    public static final int $stable = 0;
    public static final int ALLOWED = 4;
    public static final int APPLY_STEP = 8;
    public static final int BIND = 1;
    public static final String CAPABILITY = "com.TryJeanPc.goldenmouse.stretch.rescue.v1";
    public static final int COMMIT = 3;
    public static final int COMPLETE = 9;
    public static final int DISPLAY_READ = 7;
    public static final int FACTOR = 0x6F;
    public static final int FENCE = 6;
    public static final int FENCE_FLAGS = 0;
    public static final int INSTALL = 5;
    public static final StretchExperimentRpc INSTANCE = null;
    public static final int READ = 2;
    public static final int TRANSACTION = 5;
    public static final int VERSION = 3;

    static {
        StretchExperimentRpc.INSTANCE = new StretchExperimentRpc();
    }

    private StretchExperimentRpc() {
        super();
    }

    public final boolean acceptsFactor(int arg1, int arg2) {
        if(arg1 == 0 && 101 <= arg2 && arg2 < 200) {
            return 1;
        }

        return 0;
    }

    public final boolean acceptsFencePeer(int arg1, int arg2, int arg3, boolean arg4, int arg5) {
        if(arg1 == 2000 && arg3 > 0 && arg2 == arg3 && (arg4) && (StretchAgentWire.INSTANCE.isSynchronousTransport(arg5))) {
            return 1;
        }

        return 0;
    }

    public final boolean acceptsReadback(StretchExperimentOperation arg4, StretchAgentRequest arg5, String arg6, StretchOriginalEvidence arg7) {
        Object v3_1;
        Intrinsics.checkNotNullParameter(arg4, "operation");
        Intrinsics.checkNotNullParameter(arg5, "request");
        Intrinsics.checkNotNullParameter(arg6, "code");
        boolean v0 = true;
        String v1 = "APPLY_READBACK_MATCHED_UNACCREDITED";
        if(arg7 == null) {
            return Intrinsics.areEqual(arg6, v1) ^ 1;
        }

        if(arg4 == StretchExperimentOperation.APPLY_EXPERIMENT) {
            if(!Intrinsics.areEqual(arg6, v1)) {
                goto label_52;
            }

            if(!this.acceptsFactor(arg5.getLogicalDisplayId(), arg5.getFactorHundredths())) {
                goto label_52;
            }

            if(!Intrinsics.areEqual(arg7.getAgentGeneration(), arg5.getAgentGeneration())) {
                goto label_52;
            }

            if(!Intrinsics.areEqual(arg7.getOwnerGeneration(), arg5.getOwnerGeneration())) {
                goto label_52;
            }

            if(!Intrinsics.areEqual(arg7.getSnapshot().getSessionId(), arg5.getSessionId())) {
                goto label_52;
            }

            if(!Intrinsics.areEqual(arg7.getSnapshot().getOriginal().getPhysicalIdentity().getValue(), arg5.getPhysicalIdentity())) {
                goto label_52;
            }

            try {
                v3_1 = Result.constructor-impl(StretchRecoveryBinding.Companion.from(arg7));
            }
            catch(Throwable v3) {
                v3_1 = Result.constructor-impl(ResultKt.createFailure(v3));
            }

            if(!Result.isSuccess-impl(v3_1)) {
                goto label_52;
            }
        }
        else {
        label_52:
            v0 = false;
        }

        return v0;
    }

    public final Object call(IBinder arg3, int arg4, Function1 arg5, Function1 arg6) {
        Object v3_1;
        Intrinsics.checkNotNullParameter(arg3, "binder");
        Intrinsics.checkNotNullParameter(arg5, "write");
        Intrinsics.checkNotNullParameter(arg6, "read");
        Parcel v2 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v2, "obtain(...)");
        Parcel v1 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v1, "obtain(...)");
        try {
            v2.writeInterfaceToken("com.TryJeanPc.goldenmouse.stretch.rescue.v1");
            v2.writeInt(3);
            arg5.invoke(v2);
            StretchAgentWire.INSTANCE.bounded(v2);
            if(!arg3.transact(arg4, v2, v1, 0)) {
                goto label_30;
            }

            StretchAgentWire.INSTANCE.bounded(v1);
            v1.readException();
            v3_1 = arg6.invoke(v1);
            StretchAgentWire.INSTANCE.exhausted(v1);
        }
        catch(Throwable v3) {
            goto label_35;
        }

        v2.recycle();
        v1.recycle();
        return v3_1;
        try {
        label_30:
            throw new IllegalStateException("Check failed.");
        }
        catch(Throwable v3) {
        label_35:
            v2.recycle();
            v1.recycle();
            throw v3;
        }
    }

    public static Object call$default(StretchExperimentRpc arg0, IBinder arg1, int arg2, Function1 arg3, Function1 arg4, int arg5, Object arg6) {
        StretchExperimentRpc$$ExternalSyntheticLambda0 v3;
        if((arg5 & 4) != 0) {
            v3 = new StretchExperimentRpc$$ExternalSyntheticLambda0();
        }

        return arg0.call(arg1, arg2, ((Function1)v3), arg4);
    }

    static final Unit call$lambda$1(Parcel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    public final void envelope(Parcel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "data");
        StretchAgentWire.INSTANCE.bounded(arg1);
        arg1.enforceInterface("com.TryJeanPc.goldenmouse.stretch.rescue.v1");
        if(arg1.readInt() == 3) {
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final String json(Parcel arg2) {
        Intrinsics.checkNotNullParameter(arg2, "data");
        String v1 = arg2.readString();
        if(v1 != null) {
            byte[] v2 = v1.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(v2, "getBytes(...)");
            if(v2.length <= 0x2000) {
                return v1;
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

