package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\b\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u001D\b\u0000\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u0004H\u0086\u0002J\u0006\u0010\n\u001A\u00020\u0004R\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPreflightReport;", "", "values", "", "", "<init>", "(Ljava/util/Map;)V", "fields", "get", "key", "text", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPreflightReport {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\n\u0010\u0006\u001A\u00060\u0007j\u0002`\bR*\u0010\t\u001A\u001E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B0\nj\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPreflightReport$Companion;", "", "<init>", "()V", "failure", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPreflightReport;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "DEFAULTS", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final StretchPreflightReport failure(Exception arg4) {
            Intrinsics.checkNotNullParameter(arg4, "error");
            return new StretchPreflightReport(MapsKt.mapOf(new Pair[]{TuplesKt.to("outcome", "INCOMPLETE"), TuplesKt.to("errorStage", "initialization"), TuplesKt.to("errorType", StretchReadOnlyPreflightKt.preflightErrorType(arg4))}));
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final LinkedHashMap DEFAULTS;
    private final Map fields;

    static {
        StretchPreflightReport.Companion = new Companion(null);
        StretchPreflightReport.$stable = 8;
        StretchPreflightReport.DEFAULTS = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("timeUtc", "UNKNOWN"), TuplesKt.to("androidApi", "UNKNOWN"), TuplesKt.to("appUid", "UNKNOWN"), TuplesKt.to("outcome", "NOT_RUN"), TuplesKt.to("shizukuBinder", "UNKNOWN"), TuplesKt.to("shizukuVersion", "UNKNOWN"), TuplesKt.to("shizukuUid", "UNKNOWN"), TuplesKt.to("shizukuPermission", "UNKNOWN"), TuplesKt.to("shizukuReadError", "NONE"), TuplesKt.to("authenticated", "UNKNOWN"), TuplesKt.to("agentUid", "UNKNOWN"), TuplesKt.to("sessionOpen", "UNKNOWN"), TuplesKt.to("baselineRead", "UNKNOWN"), TuplesKt.to("heartbeat", "UNKNOWN"), TuplesKt.to("originalRead", "UNKNOWN"), TuplesKt.to("originalRpcStage", "UNKNOWN"), TuplesKt.to("originalRpcErrorType", "UNKNOWN"), TuplesKt.to("originalRpcErrorAt", "UNKNOWN"), TuplesKt.to("originalRpcReplyCode", "UNKNOWN"), TuplesKt.to("originalRpcMismatches", "UNKNOWN"), TuplesKt.to("agentOriginalStep", "UNKNOWN"), TuplesKt.to("agentOriginalStepState", "UNKNOWN"), TuplesKt.to("agentOriginalLastCompleted", "UNKNOWN"), TuplesKt.to("agentOriginalCheckpointCount", "UNKNOWN"), TuplesKt.to("agentBinderDeathNotified", "UNKNOWN"), TuplesKt.to("agentServiceDisconnected", "UNKNOWN"), TuplesKt.to("backend", "UNKNOWN"), TuplesKt.to("displayId", "UNKNOWN"), TuplesKt.to("physicalIdentity", "UNKNOWN"), TuplesKt.to("logicalSize", "UNKNOWN"), TuplesKt.to("referenceSize", "UNKNOWN"), TuplesKt.to("rotation", "UNKNOWN"), TuplesKt.to("density", "UNKNOWN"), TuplesKt.to("displayTokenAvailability", "UNKNOWN"), TuplesKt.to("projectionMethod", "UNKNOWN"), TuplesKt.to("originalProjection", "UNKNOWN"), TuplesKt.to("viewport", "UNKNOWN"), TuplesKt.to("sourceRect", "UNKNOWN"), TuplesKt.to("compositorRead", "UNKNOWN"), TuplesKt.to("compositorStable", "UNKNOWN"), TuplesKt.to("compositorSourceRect", "UNKNOWN"), TuplesKt.to("compositorDestinationRect", "UNKNOWN"), TuplesKt.to("compositorDisplaySize", "UNKNOWN"), TuplesKt.to("compositorOrientation", "UNKNOWN"), TuplesKt.to("compositorEffectiveOrientation", "UNKNOWN"), TuplesKt.to("compositorInstallOrientation", "UNKNOWN"), TuplesKt.to("destinationRect", "UNKNOWN"), TuplesKt.to("deviceSize", "UNKNOWN"), TuplesKt.to("stable", "UNKNOWN"), TuplesKt.to("windowRead", "UNKNOWN"), TuplesKt.to("scaling", "UNKNOWN"), TuplesKt.to("override", "UNKNOWN"), TuplesKt.to("candidateJournal", "UNKNOWN"), TuplesKt.to("sessionClose", "UNKNOWN"), TuplesKt.to("sessionCloseReplyCode", "UNKNOWN"), TuplesKt.to("sessionClosePhase", "UNKNOWN"), TuplesKt.to("sessionCloseRemoteAck", "UNKNOWN"), TuplesKt.to("localClose", "UNKNOWN"), TuplesKt.to("agentProcessTermination", "UNKNOWN"), TuplesKt.to("remoteExecutionUnknown", "UNKNOWN"), TuplesKt.to("connectionStep", "UNKNOWN"), TuplesKt.to("connectionFailureStep", "UNKNOWN"), TuplesKt.to("serviceReportedRejection", "UNKNOWN"), TuplesKt.to("bindReturned", "UNKNOWN"), TuplesKt.to("serviceConnected", "UNKNOWN"), TuplesKt.to("callbackStep", "UNKNOWN"), TuplesKt.to("callbackUid", "UNKNOWN"), TuplesKt.to("callbackVerified", "UNKNOWN"), TuplesKt.to("errorStage", "NONE"), TuplesKt.to("errorType", "NONE"), TuplesKt.to("closeErrorType", "NONE")});
    }

    public StretchPreflightReport(Map arg6) {
        Intrinsics.checkNotNullParameter(arg6, "values");
        super();
        LinkedHashMap v0 = StretchPreflightReport.DEFAULTS;
        LinkedHashMap v1 = new LinkedHashMap(MapsKt.mapCapacity(((Map)v0).size()));
        Iterator v0_1 = ((Map)v0).entrySet().iterator();
        while(v0_1.hasNext()) {
            Object v2 = v0_1.next();
            Object v3 = ((Map$Entry)v2).getKey();
            Object v4 = ((Map$Entry)v2).getKey();
            v2 = ((Map$Entry)v2).getValue();
            v4 = arg6.get(v4);
            if(v4 == null) {
            }
            else {
                v2 = v4;
            }

            ((Map)v1).put(v3, v2);
        }

        this.fields = ((Map)v1);
    }

    public final String get(String arg2) {
        String v1_1;
        Intrinsics.checkNotNullParameter(arg2, "key");
        Object v1 = this.fields.get(arg2);
        if(v1 == null) {
            v1_1 = "UNKNOWN";
        }

        return v1_1;
    }

    public final String text() {
        StringBuilder v0 = new StringBuilder("Golden Stretch — diagnóstico de solo lectura · v4\n");
        Iterator v4 = this.fields.entrySet().iterator();
        while(v4.hasNext()) {
            Object v1 = v4.next();
            v0.append(((Map$Entry)v1).getKey() + ": " + ((Map$Entry)v1).getValue()).append('\n');
        }

        v0.append("physicalMutationAllowed: false\nphysicalRecoveryAccredited: false\nLectura informativa. No acredita restauración física. No se modificó la pantalla.");
        return v0.toString();
    }
}

