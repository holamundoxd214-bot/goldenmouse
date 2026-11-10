package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020E2\u0006\u0010F\u001A\u00020GJ\u0012\u0010H\u001A\u00020C2\n\u0010I\u001A\u00060Jj\u0002`KJ\u001C\u0010L\u001A\u00020C2\n\u0010I\u001A\u00060Jj\u0002`K2\b\b\u0002\u0010M\u001A\u00020\u0017J\u0012\u0010N\u001A\u000E\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020>0OR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001A\u0010\u0013\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001A\u0010\u0016\u001A\u00020\u0017X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001A\u0010\u001C\u001A\u00020\u0017X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0019\"\u0004\b\u001E\u0010\u001BR\u001E\u0010\u001F\u001A\u0004\u0018\u00010\u000BX\u0086\u000E¢\u0006\u0010\n\u0002\u0010$\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001A\u0010%\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0007\"\u0004\b\'\u0010\tR\u001A\u0010(\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001A\u0010+\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001A\u0010.\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001A\u00101\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\u0010\u00104\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00105\u001A\u0004\u0018\u000106X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u00107\u001A\u000208X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000E\u0010=\u001A\u00020>X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010?\u001A\u00020>X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010@\u001A\u00020>X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010A\u001A\u00020>X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006P"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentConnectionDiagnostics;", "", "<init>", "()V", "backendRunning", "", "getBackendRunning", "()Z", "setBackendRunning", "(Z)V", "backendVersion", "", "getBackendVersion", "()I", "setBackendVersion", "(I)V", "backendUid", "getBackendUid", "setBackendUid", "permissionGranted", "getPermissionGranted", "setPermissionGranted", "step", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchConnectStep;", "getStep", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchConnectStep;", "setStep", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchConnectStep;)V", "callbackStep", "getCallbackStep", "setCallbackStep", "callbackUid", "getCallbackUid", "()Ljava/lang/Integer;", "setCallbackUid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "callbackVerified", "getCallbackVerified", "setCallbackVerified", "bindReturned", "getBindReturned", "setBindReturned", "serviceConnected", "getServiceConnected", "setServiceConnected", "binderDeathNotified", "getBinderDeathNotified", "setBinderDeathNotified", "serviceDisconnected", "getServiceDisconnected", "setServiceDisconnected", "failureStep", "remoteRejection", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchConnectRejection;", "originalRpcStage", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalRpcStage;", "getOriginalRpcStage", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalRpcStage;", "setOriginalRpcStage", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalRpcStage;)V", "originalRpcErrorType", "", "originalRpcErrorAt", "originalRpcReplyCode", "originalRpcMismatches", "originalReply", "", "reply", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentReply;", "request", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "originalFailed", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failed", "at", "snapshot", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchAgentConnectionDiagnostics {
    public static final int $stable = 8;
    private volatile boolean backendRunning;
    private volatile int backendUid;
    private volatile int backendVersion;
    private volatile boolean bindReturned;
    private volatile boolean binderDeathNotified;
    private volatile StretchConnectStep callbackStep;
    private volatile Integer callbackUid;
    private volatile boolean callbackVerified;
    private StretchConnectStep failureStep;
    private volatile String originalRpcErrorAt;
    private volatile String originalRpcErrorType;
    private volatile String originalRpcMismatches;
    private volatile String originalRpcReplyCode;
    private volatile StretchOriginalRpcStage originalRpcStage;
    private volatile boolean permissionGranted;
    private StretchConnectRejection remoteRejection;
    private volatile boolean serviceConnected;
    private volatile boolean serviceDisconnected;
    private volatile StretchConnectStep step;

    static {
    }

    public StretchAgentConnectionDiagnostics() {
        super();
        this.backendVersion = -1;
        this.backendUid = -1;
        this.step = StretchConnectStep.NOT_STARTED;
        this.callbackStep = StretchConnectStep.NOT_STARTED;
        this.originalRpcStage = StretchOriginalRpcStage.NOT_STARTED;
        this.originalRpcErrorType = "NONE";
        this.originalRpcErrorAt = "UNKNOWN";
        this.originalRpcReplyCode = "UNKNOWN";
        this.originalRpcMismatches = "UNKNOWN";
    }

    public final void failed(Exception arg6, StretchConnectStep arg7) {
        Object v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg6, "error");
            Intrinsics.checkNotNullParameter(arg7, "at");
            if(this.failureStep == null) {
                goto label_9;
            }
        }
        catch(Throwable v6) {
            goto label_36;
        }

        __monitor_exit(this);
        return;
        try {
        label_9:
            this.failureStep = arg7;
            if(arg7 == StretchConnectStep.ATTEST_REPLY && ((arg6 instanceof SecurityException))) {
                Iterator v7 = StretchConnectRejection.getEntries().iterator();
                do {
                    if(v7.hasNext()) {
                        v0 = v7.next();
                        if(!Intrinsics.areEqual(arg6.getMessage(), "GOLDEN_STRETCH_4B:" + v0.name())) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_31;
                    }
                }
                while(true);

                goto label_32;
            label_31:
                StretchConnectRejection v0_1 = null;
            label_32:
                this.remoteRejection = ((StretchConnectRejection)v0);
            }
        }
        catch(Throwable v6) {
            try {
            label_36:
                __monitor_exit(this);
            }
            catch(Throwable v6) {
                goto label_36;
            }

            throw v6;
        }

        __monitor_exit(this);
    }

    public static void failed$default(StretchAgentConnectionDiagnostics arg0, Exception arg1, StretchConnectStep arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0.step;
        }

        arg0.failed(arg1, arg2);
    }

    public final boolean getBackendRunning() {
        return this.backendRunning;
    }

    public final int getBackendUid() {
        return this.backendUid;
    }

    public final int getBackendVersion() {
        return this.backendVersion;
    }

    public final boolean getBindReturned() {
        return this.bindReturned;
    }

    public final boolean getBinderDeathNotified() {
        return this.binderDeathNotified;
    }

    public final StretchConnectStep getCallbackStep() {
        return this.callbackStep;
    }

    public final Integer getCallbackUid() {
        return this.callbackUid;
    }

    public final boolean getCallbackVerified() {
        return this.callbackVerified;
    }

    public final StretchOriginalRpcStage getOriginalRpcStage() {
        return this.originalRpcStage;
    }

    public final boolean getPermissionGranted() {
        return this.permissionGranted;
    }

    public final boolean getServiceConnected() {
        return this.serviceConnected;
    }

    public final boolean getServiceDisconnected() {
        return this.serviceDisconnected;
    }

    public final StretchConnectStep getStep() {
        return this.step;
    }

    public final void originalFailed(Exception arg12) {
        String v12_1;
        StackTraceElement v6;
        String v5;
        int v4;
        Intrinsics.checkNotNullParameter(arg12, "error");
        String v0 = arg12.getClass().getSimpleName();
        Intrinsics.checkNotNull(v0);
        Object v2 = null;
        if(new Regex("[A-Za-z0-9_]{1,80}").matches(v0)) {
        }
        else {
            v0 = ((String)v2);
        }

        if(v0 == null) {
            v0 = "READ_FAILED";
        }

        this.originalRpcErrorType = v0;
        StackTraceElement[] v12 = arg12.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(v12, "getStackTrace(...)");
        int v0_1 = v12.length;
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = 2;
            v5 = "getClassName(...)";
            if(v3 >= v0_1) {
                break;
            }

            v6 = v12[v3];
            StackTraceElement v7 = v6;
            String v8 = v7.getClassName();
            Intrinsics.checkNotNullExpressionValue(v8, v5);
            if(!StringsKt.startsWith$default(v8, "com.TryJeanPc.goldenmouse.stretch.agent.", false, v4, v2)) {
                v8 = v7.getClassName();
                Intrinsics.checkNotNullExpressionValue(v8, v5);
                if(StringsKt.startsWith$default(v8, "com.TryJeanPc.goldenmouse.stretch.recovery.", false, v4, v2)) {
                    goto label_38;
                }
            }
            else {
            label_38:
                v8 = v7.getClassName();
                Intrinsics.checkNotNullExpressionValue(v8, v5);
                if(new Regex("[A-Za-z0-9_.$]{1,180}").matches(((CharSequence)v8))) {
                    v8 = v7.getMethodName();
                    Intrinsics.checkNotNullExpressionValue(v8, "getMethodName(...)");
                    if((new Regex("[A-Za-z0-9_$<>]{1,80}").matches(((CharSequence)v8))) && v7.getLineNumber() > 0) {
                        goto label_59;
                    }
                }
            }
        }

        v6 = ((StackTraceElement)v2);
    label_59:
        if(v6 != null) {
            v12_1 = v6.getClassName();
            Intrinsics.checkNotNullExpressionValue(v12_1, v5);
            v12_1 = StringsKt.substringAfter$default(v12_1, ".stretch.", ((String)v2), v4, v2) + "." + v6.getMethodName() + ":" + v6.getLineNumber();
            if(v12_1 != null) {
            }
            else {
                goto label_78;
            }
        }
        else {
        label_78:
            v12_1 = "UNKNOWN";
        }

        this.originalRpcErrorAt = v12_1;
    }

    public final void originalReply(StretchAgentReply arg10, StretchAgentRequest arg11) {
        Intrinsics.checkNotNullParameter(arg10, "reply");
        Intrinsics.checkNotNullParameter(arg11, "request");
        this.originalRpcReplyCode = arg10.getCode().name();
        String[] v0 = new String[2];
        String v2 = null;
        String v1 = !Intrinsics.areEqual(arg10.getOperationId(), arg11.getOperationId()) ? "OPERATION" : v2;
        v0[0] = v1;
        if(!Intrinsics.areEqual(arg10.getAgentGeneration(), arg11.getAgentGeneration())) {
            v2 = "AGENT";
        }

        v0[1] = v2;
        String v10 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(((Object[])v0)), ",", null, null, 0, null, null, 62, null);
        if(((CharSequence)v10).length() == 0) {
            v10 = "NONE";
        }

        this.originalRpcMismatches = v10;
    }

    public final void setBackendRunning(boolean arg1) {
        this.backendRunning = arg1;
    }

    public final void setBackendUid(int arg1) {
        this.backendUid = arg1;
    }

    public final void setBackendVersion(int arg1) {
        this.backendVersion = arg1;
    }

    public final void setBindReturned(boolean arg1) {
        this.bindReturned = arg1;
    }

    public final void setBinderDeathNotified(boolean arg1) {
        this.binderDeathNotified = arg1;
    }

    public final void setCallbackStep(StretchConnectStep arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.callbackStep = arg2;
    }

    public final void setCallbackUid(Integer arg1) {
        this.callbackUid = arg1;
    }

    public final void setCallbackVerified(boolean arg1) {
        this.callbackVerified = arg1;
    }

    public final void setOriginalRpcStage(StretchOriginalRpcStage arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.originalRpcStage = arg2;
    }

    public final void setPermissionGranted(boolean arg1) {
        this.permissionGranted = arg1;
    }

    public final void setServiceConnected(boolean arg1) {
        this.serviceConnected = arg1;
    }

    public final void setServiceDisconnected(boolean arg1) {
        this.serviceDisconnected = arg1;
    }

    public final void setStep(StretchConnectStep arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.step = arg2;
    }

    public final Map snapshot() {
        String v2_1;
        __monitor_enter(this);
        int v0 = 19;
        try {
            Pair[] v0_2 = new Pair[v0];
            v0_2[0] = TuplesKt.to("backendRunning", String.valueOf(this.backendRunning));
            v0_2[1] = TuplesKt.to("backendVersion", String.valueOf(this.backendVersion));
            v0_2[2] = TuplesKt.to("backendUid", String.valueOf(this.backendUid));
            v0_2[3] = TuplesKt.to("permissionGranted", String.valueOf(this.permissionGranted));
            v0_2[4] = TuplesKt.to("connectionStep", this.step.name());
            String v1 = "connectionFailureStep";
            StretchConnectStep v2 = this.failureStep;
            if(v2 != null) {
                v2_1 = v2.name();
                if(v2_1 == null) {
                    goto label_38;
                }
            }
            else {
            label_38:
                v2_1 = "NONE";
            }

            v0_2[5] = TuplesKt.to(v1, v2_1);
            v1 = "serviceReportedRejection";
            StretchConnectRejection v2_2 = this.remoteRejection;
            if(v2_2 != null) {
                v2_1 = v2_2.name();
                if(v2_1 == null) {
                    goto label_47;
                }
            }
            else {
            label_47:
                v2_1 = "UNKNOWN";
            }

            v0_2[6] = TuplesKt.to(v1, v2_1);
            v0_2[7] = TuplesKt.to("bindReturned", String.valueOf(this.bindReturned));
            v0_2[8] = TuplesKt.to("serviceConnected", String.valueOf(this.serviceConnected));
            v0_2[9] = TuplesKt.to("agentBinderDeathNotified", String.valueOf(this.binderDeathNotified));
            v0_2[10] = TuplesKt.to("agentServiceDisconnected", String.valueOf(this.serviceDisconnected));
            v0_2[11] = TuplesKt.to("callbackStep", this.callbackStep.name());
            v1 = "callbackUid";
            Integer v2_3 = this.callbackUid;
            if(v2_3 != null) {
                v2_1 = v2_3.toString();
                if(v2_1 == null) {
                    goto label_86;
                }
            }
            else {
            label_86:
                v2_1 = "UNKNOWN";
            }

            v0_2[12] = TuplesKt.to(v1, v2_1);
            v0_2[13] = TuplesKt.to("callbackVerified", String.valueOf(this.callbackVerified));
            v0_2[14] = TuplesKt.to("originalRpcStage", this.originalRpcStage.name());
            v0_2[15] = TuplesKt.to("originalRpcErrorType", this.originalRpcErrorType);
            v0_2[16] = TuplesKt.to("originalRpcErrorAt", this.originalRpcErrorAt);
            v0_2[17] = TuplesKt.to("originalRpcReplyCode", this.originalRpcReplyCode);
            v0_2[18] = TuplesKt.to("originalRpcMismatches", this.originalRpcMismatches);
            __monitor_exit(this);
            return MapsKt.linkedMapOf(v0_2);
        }
        catch(Throwable v0_1) {
            try {
            label_126:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_126;
            }

            throw v0_1;
        }
    }
}

