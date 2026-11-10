package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B«\u0001\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\"\b\u0002\u0010\r\u001A\u001C\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000E\u0012\u000E\b\u0002\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00140\n\u00128\b\u0002\u0010\u0015\u001A2\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001A0\u0011\u0018\u00010\u0016¢\u0006\u0004\b\u001B\u0010\u001CJE\u0010!\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00112\u0006\u0010\"\u001A\u00020\u00172\u0006\u0010#\u001A\u00020\u00102\n\b\u0002\u0010$\u001A\u0004\u0018\u00010\u00182\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u00192\b\b\u0002\u0010&\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\'J\u0014\u0010(\u001A\b\u0012\u0004\u0012\u00020)0\u00112\u0006\u0010#\u001A\u00020\u0010J\u0014\u0010*\u001A\b\u0012\u0004\u0012\u00020)0\u00112\u0006\u0010#\u001A\u00020\u0010J\u0014\u0010+\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001A\u00020\u0010J\u0014\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001A\u00020\u0010J\u0014\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001A\u00020\u0010J\u0014\u0010.\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001A\u00020\u0010J\u0014\u0010/\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001A\u00020\u0010J\u0014\u00100\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001A\u00020\u0010J\u001E\u00101\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\"\u001A\u00020\u000F2\u0006\u0010#\u001A\u00020\u0010H\u0002J\r\u00105\u001A\u00020\u000BH\u0000¢\u0006\u0002\b6J\r\u00107\u001A\u00020\u000BH\u0000¢\u0006\u0002\b8J\b\u00109\u001A\u00020\u000BH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001A\u001C\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00140\nX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0015\u001A2\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001A0\u0011\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00102\u001A\u00020\u00148F¢\u0006\u0006\u001A\u0004\b3\u00104¨\u0006:"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentClient;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "generation", "", "calls", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCallSupervisor;", "authenticatedPeerUid", "", "unlink", "Lkotlin/Function0;", "", "closeBinding", "physicalTransport", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalOperation;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "Ljava/util/concurrent/CompletableFuture;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalReply;", "physicalUnknown", "", "experimentTransport", "Lkotlin/Function5;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExperimentOperation;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "Landroid/os/IBinder;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExperimentReply;", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCallSupervisor;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function5;)V", "getGeneration", "()Ljava/lang/String;", "getAuthenticatedPeerUid", "()I", "experiment", "operation", "request", "evidence", "endpoint", "confirmed", "experiment$app", "submit", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentReply;", "readOriginal", "preparePhysical", "applyPhysical105", "restorePhysical", "physicalStatus", "releasePhysical", "recoverPersistedPhysical", "physical", "remoteExecutionUnknown", "getRemoteExecutionUnknown", "()Z", "disconnected", "disconnected$app", "shutdown", "shutdown$app", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchAgentClient implements AutoCloseable {
    public static final int $stable = 8;
    private final int authenticatedPeerUid;
    private final StretchAgentCallSupervisor calls;
    private final Function0 closeBinding;
    private final Function5 experimentTransport;
    private final String generation;
    private final Function2 physicalTransport;
    private final Function0 physicalUnknown;
    private final Function0 unlink;

    static {
    }

    public StretchAgentClient(String arg2, StretchAgentCallSupervisor arg3, int arg4, Function0 arg5, Function0 arg6, Function2 arg7, Function0 arg8, Function5 arg9) {
        Intrinsics.checkNotNullParameter(arg2, "generation");
        Intrinsics.checkNotNullParameter(arg3, "calls");
        Intrinsics.checkNotNullParameter(arg5, "unlink");
        Intrinsics.checkNotNullParameter(arg6, "closeBinding");
        Intrinsics.checkNotNullParameter(arg8, "physicalUnknown");
        super();
        this.generation = arg2;
        this.calls = arg3;
        this.authenticatedPeerUid = arg4;
        this.unlink = arg5;
        this.closeBinding = arg6;
        this.physicalTransport = arg7;
        this.physicalUnknown = arg8;
        this.experimentTransport = arg9;
    }

    public StretchAgentClient(String arg2, StretchAgentCallSupervisor arg3, int arg4, Function0 arg5, Function0 arg6, Function2 arg7, Function0 arg8, Function5 arg9, int arg10, DefaultConstructorMarker arg11) {
        StretchAgentClient$$ExternalSyntheticLambda0 v8;
        Function2 v0 = null;
        if((arg10 & 0x20) != 0) {
            arg7 = v0;
        }

        if((arg10 & 0x40) != 0) {
            v8 = new StretchAgentClient$$ExternalSyntheticLambda0();
        }

        if((arg10 & 0x80) != 0) {
            arg9 = ((Function5)v0);
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, ((Function0)v8), arg9);
    }

    static final boolean _init_$lambda$0() {
        return 0;
    }

    public final CompletableFuture applyPhysical105(StretchAgentRequest arg16) {
        Intrinsics.checkNotNullParameter(arg16, "request");
        return this.physical(StretchPhysicalOperation.APPLY, StretchAgentRequest.copy$default(arg16, 0, null, null, null, null, 0, null, null, null, 105, null, 0x5FF, null));
    }

    public void close() {
        this.closeBinding.invoke();
    }

    public final void disconnected$app() {
        this.calls.peerDied();
    }

    public final CompletableFuture experiment$app(StretchExperimentOperation arg3, StretchAgentRequest arg4, StretchOriginalEvidence arg5, IBinder arg6, boolean arg7) {
        Intrinsics.checkNotNullParameter(arg3, "operation");
        Intrinsics.checkNotNullParameter(arg4, "request");
        if(Intrinsics.areEqual(arg4.getAgentGeneration(), this.generation)) {
            Function5 v2 = this.experimentTransport;
            if(v2 != null) {
                return v2.invoke(arg3, arg4, arg5, arg6, Boolean.valueOf(arg7));
            }
        }

        CompletableFuture v2_1 = new CompletableFuture();
        v2_1.completeExceptionally(new IllegalStateException("Experiment unavailable"));
        return v2_1;
    }

    public static CompletableFuture experiment$app$default(StretchAgentClient arg1, StretchExperimentOperation arg2, StretchAgentRequest arg3, StretchOriginalEvidence arg4, IBinder arg5, boolean arg6, int arg7, Object arg8) {
        StretchOriginalEvidence v0 = null;
        if((arg7 & 4) != 0) {
            arg4 = v0;
        }

        if((arg7 & 8) != 0) {
            arg5 = ((IBinder)v0);
        }

        return arg1.experiment$app(arg2, arg3, arg4, arg5, false);
    }

    public final int getAuthenticatedPeerUid() {
        return this.authenticatedPeerUid;
    }

    public final String getGeneration() {
        return this.generation;
    }

    public final boolean getRemoteExecutionUnknown() {
        if(!this.calls.getRemoteExecutionUnknown()) {
            if(this.physicalUnknown.invoke().booleanValue()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final CompletableFuture physical(StretchPhysicalOperation arg3, StretchAgentRequest arg4) {
        if(Intrinsics.areEqual(arg4.getAgentGeneration(), this.generation)) {
            Function2 v2 = this.physicalTransport;
            if(v2 != null) {
                return v2.invoke(arg3, arg4);
            }
        }

        CompletableFuture v2_1 = new CompletableFuture();
        v2_1.completeExceptionally(new IllegalStateException("Paired session unavailable or stale"));
        return v2_1;
    }

    public final CompletableFuture physicalStatus(StretchAgentRequest arg2) {
        Intrinsics.checkNotNullParameter(arg2, "request");
        return this.physical(StretchPhysicalOperation.STATUS, arg2);
    }

    public final CompletableFuture preparePhysical(StretchAgentRequest arg2) {
        Intrinsics.checkNotNullParameter(arg2, "request");
        return this.physical(StretchPhysicalOperation.PREPARE, arg2);
    }

    public final CompletableFuture readOriginal(StretchAgentRequest arg16) {
        Intrinsics.checkNotNullParameter(arg16, "request");
        return this.submit(StretchAgentRequest.copy$default(arg16, 0, null, null, null, null, 0, StretchAgentAction.STATUS, null, null, 0, Integer.valueOf(1), 0x3BF, null));
    }

    public final CompletableFuture recoverPersistedPhysical(StretchAgentRequest arg2) {
        Intrinsics.checkNotNullParameter(arg2, "request");
        return this.physical(StretchPhysicalOperation.RECOVER_PERSISTED, arg2);
    }

    public final CompletableFuture releasePhysical(StretchAgentRequest arg2) {
        Intrinsics.checkNotNullParameter(arg2, "request");
        return this.physical(StretchPhysicalOperation.RELEASE, arg2);
    }

    public final CompletableFuture restorePhysical(StretchAgentRequest arg2) {
        Intrinsics.checkNotNullParameter(arg2, "request");
        return this.physical(StretchPhysicalOperation.RESTORE, arg2);
    }

    public final void shutdown$app() {
        this.calls.close();
        Function0 v1 = this.unlink;
        try {
            Result.constructor-impl(v1.invoke());
            return;
        }
        catch(Throwable v1_1) {
            Result.constructor-impl(ResultKt.createFailure(v1_1));
            return;
        }
    }

    public final CompletableFuture submit(StretchAgentRequest arg11) {
        Intrinsics.checkNotNullParameter(arg11, "request");
        if(!Intrinsics.areEqual(arg11.getAgentGeneration(), this.generation)) {
            CompletableFuture v10 = CompletableFuture.completedFuture(new StretchAgentReply(arg11.getOperationId(), this.generation, StretchAgentCode.STALE_AGENT, StretchAgentPhase.RECOVERY_PENDING, null, null, 0x30, null));
            Intrinsics.checkNotNullExpressionValue(v10, "completedFuture(...)");
            return v10;
        }

        return this.calls.submit(arg11);
    }
}

