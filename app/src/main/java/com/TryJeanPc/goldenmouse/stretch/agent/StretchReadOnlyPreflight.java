package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import com.TryJeanPc.goldenmouse.stretch.StretchRect;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryCodec;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoverySnapshot;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchScaling;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0006\u0012\u0014\b\u0002\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E0\r\u0012\u001A\b\u0002\u0010\u000F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E0\r0\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001A\u00020\u0013J\u0010\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J\u0010\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J0\u0010\u001A\u001A\u00020\u000E\"\u0004\b\u0000\u0010\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u001B0\u001D2\u0012\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u0002H\u001B\u0012\u0004\u0012\u00020\u000E0\u001FH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E0\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000F\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E0\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchReadOnlyPreflight;", "", "api", "", "appUid", "connect", "Lkotlin/Function0;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentClient;", "inspectJournal", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "disconnect", "", "environment", "", "", "connectionDiagnostics", "<init>", "(IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)V", "run", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPreflightReport;", "size", "s", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "rect", "r", "Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "datum", "T", "d", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "format", "Lkotlin/Function1;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchReadOnlyPreflight {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[CompositorReadCode.values().length];
            try {
                v0[CompositorReadCode.OBSERVED_COMPOSITOR_ONLY.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[CompositorReadCode.UNSTABLE.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable = 8;
    private final int api;
    private final int appUid;
    private final Function0 connect;
    private final Function0 connectionDiagnostics;
    private final Function0 disconnect;
    private final Map environment;
    private final Function0 inspectJournal;

    static {
    }

    public StretchReadOnlyPreflight(int arg2, int arg3, Function0 arg4, Function0 arg5, Function0 arg6, Map arg7, Function0 arg8) {
        Intrinsics.checkNotNullParameter(arg4, "connect");
        Intrinsics.checkNotNullParameter(arg5, "inspectJournal");
        Intrinsics.checkNotNullParameter(arg6, "disconnect");
        Intrinsics.checkNotNullParameter(arg7, "environment");
        Intrinsics.checkNotNullParameter(arg8, "connectionDiagnostics");
        super();
        this.api = arg2;
        this.appUid = arg3;
        this.connect = arg4;
        this.inspectJournal = arg5;
        this.disconnect = arg6;
        this.environment = arg7;
        this.connectionDiagnostics = arg8;
    }

    public StretchReadOnlyPreflight(int arg9, int arg10, Function0 arg11, Function0 arg12, Function0 arg13, Map arg14, Function0 arg15, int arg16, DefaultConstructorMarker arg17) {
        StretchReadOnlyPreflight$$ExternalSyntheticLambda0 v7;
        if((arg16 & 0x20) != 0) {
            arg14 = MapsKt.emptyMap();
        }

        Map v6 = arg14;
        if((arg16 & 0x40) != 0) {
            v7 = new StretchReadOnlyPreflight$$ExternalSyntheticLambda0();
        }
        else {
            Function0 v7_1 = arg15;
        }

        this(arg9, arg10, arg11, arg12, arg13, v6, ((Function0)v7));
    }

    static final Map _init_$lambda$0() {
        return MapsKt.emptyMap();
    }

    public static final String access$size(StretchReadOnlyPreflight arg0, StretchSize arg1) {
        return arg0.size(arg1);
    }

    private final String datum(RecoveryDatum arg3, Function1 arg4) {
        String v4;
        String v2 = arg3.getState().name();
        Object v0 = arg3.getValue();
        if(v0 != null) {
            v4 = "=" + arg4.invoke(v0);
            if(v4 == null) {
                goto label_11;
            }
        }
        else {
        label_11:
            v4 = "";
        }

        return v2 + v4 + " [" + arg3.getSource().name() + "]";
    }

    private final String rect(StretchRect arg4) {
        return arg4.getLeft() + "," + arg4.getTop() + "," + arg4.getRight() + "," + arg4.getBottom();
    }

    public final StretchPreflightReport run() {
        StretchAgentRequest v19_1;
        StretchAgentReply v0_5;
        StretchAgentRequest v17_1;
        LinkedHashMap v0_4;
        OriginalViewport v0_3;
        StretchCompositorState v3_7;
        String v6_2;
        StretchOriginalEvidence v4_3;
        Object v4_2;
        LinkedHashMap v3_6;
        StretchOriginalDisplayState v45;
        String v44;
        String v43;
        int v3_5;
        String v22_1;
        StretchAgentBaseline v21_1;
        StretchOriginalDisplayState v14_3;
        StretchRecoverySnapshot v13_1;
        StretchAgentBaseline v3_2;
        Integer v40;
        String v38;
        String v37;
        String v34;
        String v33;
        String v31;
        Object v42;
        int v41;
        StretchAgentAction v36;
        String v32;
        String v47;
        String v46;
        Throwable v16_1;
        String v1_1;
        StretchAgentRequest v29;
        StretchAgentRequest v3_1;
        int v4_1;
        String v26_1;
        String v27;
        int v26;
        String v9_1;
        LinkedHashMap v6_1;
        String v24;
        Object v6;
        StretchReadOnlyPreflight v1 = this;
        String v2 = "heartbeat";
        String v0 = "originalProjection";
        String v3 = "toString(...)";
        String v4 = "Check failed.";
        String v5 = "LOCAL_ONLY";
        String v11 = "DIAGNOSTIC_COMPLETE";
        String v12 = "sessionClose";
        String v13 = "closeErrorType";
        String v14 = "errorStage";
        String v16 = "REQUESTED";
        String v7 = "BLOCKED_";
        String v17 = "localClose";
        String v18 = "remoteExecutionUnknown";
        LinkedHashMap v8 = new LinkedHashMap(v1.environment);
        LinkedHashMap v9 = v8;
        String v19 = "INCOMPLETE";
        String v20 = "errorType";
        ((Map)v9).put("androidApi", String.valueOf(v1.api));
        ((Map)v9).put("appUid", String.valueOf(v1.appUid));
        ((Map)v9).put("timeUtc", Instant.now().toString());
        String v15 = "outcome";
        ((Map)v9).put(v15, "RUNNING");
        ObjectRef v10 = new ObjectRef();
        String v21 = "connect";
        StretchAgentRequest v22 = null;
        String v23 = "close";
        try {
            v6 = v1.connect.invoke();
            v10.element = v6;
            v24 = v14;
        }
        catch(Throwable v0_1) {
            v3 = v4;
            v6_1 = v9;
            v7 = v13;
            v9_1 = v14;
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            goto label_849;
        }
        catch(Exception v0_2) {
            v3 = v4;
            v6_1 = v9;
            v7 = v13;
            v9_1 = v14;
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            goto label_864;
        }

        LinkedHashMap v14_1 = v8;
        LinkedHashMap v25 = v9;
        goto label_52;
        v3 = v4;
        v6_1 = v9;
        v7 = v13;
        v2 = v18;
        v4 = v19;
        v14 = v20;
        v13 = v23;
        v9_1 = v24;
        goto label_864;
        v3 = v4;
        v6_1 = v9;
        v7 = v13;
        v2 = v18;
        v4 = v19;
        v14 = v20;
        v13 = v23;
        v9_1 = v24;
        goto label_849;
        try {
        label_52:
            v9_1 = "agentUid";
            v26 = ((StretchAgentClient)v6).getAuthenticatedPeerUid();
            v27 = v13;
        }
        catch(Throwable v0_1) {
            v3 = v4;
            v7 = v13;
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            goto label_849;
        }
        catch(Exception v0_2) {
            v3 = v4;
            v7 = v13;
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            goto label_864;
        }

        try {
            ((Map)v14_1).put(v9_1, String.valueOf(v26));
            v9 = v8;
            v13 = "authenticated";
            v26_1 = v4;
            v4_1 = 2000;
            if(((StretchAgentClient)v6).getAuthenticatedPeerUid() != v4_1) {
                goto label_65;
            }
        }
        catch(Throwable v0_1) {
            v3 = ((String)v4_1);
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            goto label_788;
        }
        catch(Exception v0_2) {
            v3 = ((String)v4_1);
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            goto label_798;
        }

        boolean v14_2 = true;
        goto label_66;
    label_65:
        v14_2 = false;
        try {
        label_66:
            ((Map)v9).put(v13, String.valueOf(v14_2));
            if(((StretchAgentClient)v6).getAuthenticatedPeerUid() != v4_1) {
                goto label_746;
            }

            v4 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(v4, v3);
            v9_1 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(v9_1, v3);
            v3_1 = new StretchAgentRequest(2, v4, "open", v9_1, ((StretchAgentClient)v6).getGeneration(), 0, StretchAgentAction.OPEN, null, null, 0, null, 0x780, null);
            goto label_92;
        }
        catch(Throwable v0_1) {
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
        }
        catch(Exception v0_2) {
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
        label_798:
            v7 = v27;
        label_864:
            v18 = v16;
            goto label_865;
        }

    label_788:
        v7 = v27;
    label_849:
        v18 = v16;
        goto label_850;
        try {
        label_92:
            v4 = "open";
            goto label_93;
        }
        catch(Throwable v0_1) {
        }
        catch(Exception v0_2) {
            v29 = v3_1;
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            v18 = v16;
            v16 = v2;
            v1_1 = v21;
            goto label_744;
            try {
            label_93:
                StretchReadOnlyPreflight.run$exchange(v10, v8, v3_1, StretchAgentCode.ACCEPTED, "sessionOpen");
                goto label_96;
            }
            catch(Exception v0_2) {
            }
            catch(Throwable v0_1) {
                v29 = v3_1;
                v2 = v18;
                v4 = v19;
                v14 = v20;
                v13 = v23;
                v9_1 = v24;
                v6_1 = v25;
                v3 = v26_1;
                v7 = v27;
                v18 = v16;
                v16_1 = v0_1;
                v46 = v17;
                v47 = v18;
                goto label_729;
                try {
                label_96:
                    v4 = "baseline";
                    goto label_97;
                }
                catch(Throwable v0_1) {
                }
                catch(Exception v0_2) {
                    v29 = v3_1;
                    v2 = v18;
                    v14 = v20;
                    v13 = v23;
                    v9_1 = v24;
                    v6_1 = v25;
                    v3 = v26_1;
                    v7 = v27;
                    v18 = v16;
                    v16 = v4;
                    v4 = v19;
                    v1_1 = v16;
                    goto label_712;
                    try {
                    label_97:
                        v32 = "baseline";
                        v36 = StretchAgentAction.READ_BASELINE;
                        v41 = 0x7BB;
                        v42 = null;
                        v31 = null;
                        v33 = null;
                        v34 = null;
                        v37 = null;
                        v38 = null;
                        v40 = null;
                        v29 = v3_1;
                    }
                    catch(Throwable v0_1) {
                        v29 = v3_1;
                        goto label_686;
                    }
                    catch(Exception v0_2) {
                        v29 = v3_1;
                        goto label_671;
                    }
                }
            }
        }

        try {
            v3_2 = StretchReadOnlyPreflight.run$exchange(v10, v8, StretchAgentRequest.copy$default(v29, 0, v31, v32, v33, v34, 0, v36, v37, v38, 0, v40, v41, v42), StretchAgentCode.BASELINE_READ, "baselineRead").getBaseline();
        }
        catch(Exception v0_2) {
            goto label_671;
        }
        catch(Throwable v0_1) {
            goto label_666;
        }

        v9_1 = "Required value was null.";
        if(v3_2 == null) {
            goto label_647;
        }

        try {
            v13_1 = v3_2.getSnapshot();
            v14_3 = v13_1.getOriginal();
            v21_1 = v3_2;
            v3 = v13_1.getSessionId();
            v22_1 = v4;
            goto label_123;
        }
        catch(Throwable v0_1) {
        }
        catch(Exception v0_2) {
        label_671:
            v22_1 = v4;
            goto label_672;
            try {
            label_123:
                boolean v3_3 = Intrinsics.areEqual(v3, v29.getSessionId());
            }
            catch(Exception v0_2) {
                goto label_672;
            }
            catch(Throwable v0_1) {
                goto label_666;
            }

            v4 = "Failed requirement.";
            if(v3_3) {
                try {
                    Object v3_4 = v14_3.getLogicalIdentity().getValue();
                    if(v3_4 != null) {
                        v3_5 = ((StretchDisplayIdentity)v3_4).getLogicalId();
                        if(v3_5 == 0) {
                            v43 = v4;
                            v44 = v9_1;
                            v8.put("backend", v13_1.getBackend().name());
                            v8.put("displayId", "0");
                            v8.put("physicalIdentity", v14_3.getPhysicalIdentity().getState().name());
                            v45 = v14_3;
                            v8.put("logicalSize", v1.datum(v14_3.getLogicalSize(), new StretchReadOnlyPreflight$run$1(v1)));
                            v8.put("referenceSize", v1.datum(v45.getReferenceSize(), new StretchReadOnlyPreflight$run$2(v1)));
                            v8.put("rotation", v1.datum(v45.getRotation(), new StretchReadOnlyPreflight$$ExternalSyntheticLambda1()));
                            RecoveryDatum v9_2 = v45.getDensity();
                            StretchReadOnlyPreflight$$ExternalSyntheticLambda2 v14_4 = new StretchReadOnlyPreflight$$ExternalSyntheticLambda2();
                            v8.put("density", v1.datum(v9_2, ((Function1)v14_4)));
                            v8.put("displayTokenAvailability", v21_1.getProjection().getToken().name());
                            v9_1 = v21_1.getProjection().getTransactionMethod().name();
                            v8.put("projectionMethod", v9_1);
                            v3_6 = v8;
                            ((Map)v3_6).put(v0, v21_1.getProjection().getOriginalProjection().name());
                            goto label_195;
                        }
                    }

                    goto label_632;
                }
                catch(Throwable v0_1) {
                }
                catch(Exception v0_2) {
                label_672:
                    v2 = v18;
                    v14 = v20;
                    v13 = v23;
                    v9_1 = v24;
                    v6_1 = v25;
                    v3 = v26_1;
                    v7 = v27;
                    v18 = v16;
                    goto label_680;
                    try {
                    label_195:
                        StretchReadOnlyPreflight.run$exchange(v10, v8, StretchAgentRequest.copy$default(v29, 0, null, "heartbeat", null, null, 0, StretchAgentAction.HEARTBEAT, null, null, 0, null, 0x7BB, null), StretchAgentCode.ACCEPTED, v2);
                        v2 = "original";
                        goto label_212;
                    }
                    catch(Throwable v0_1) {
                    }
                    catch(Exception v0_2) {
                        v4 = v2;
                        v2 = v18;
                        v14 = v20;
                        v13 = v23;
                        v9_1 = v24;
                        v6_1 = v25;
                        v3 = v26_1;
                        v7 = v27;
                        v18 = v16;
                        v16 = v2;
                        v1_1 = v4;
                        v4 = v19;
                        goto label_744;
                        try {
                        label_212:
                            v3_1 = StretchAgentRequest.copy$default(v29, 0, null, "original", null, null, 0, null, StretchRecoveryCodec.INSTANCE.snapshotDigest(v13_1), v45.getPhysicalIdentity().getValue(), 0, null, 0x67B, null);
                            v4_2 = ((StretchAgentClient)v6).readOriginal(v3_1).get(6, TimeUnit.SECONDS);
                            v8.put("originalRead", ((StretchAgentReply)v4_2).getCode().name());
                            if(((StretchAgentReply)v4_2).getCode() == StretchAgentCode.ACCEPTED && !((StretchAgentReply)v4_2).getPhysicalMutationAllowed()) {
                                v4_3 = ((StretchAgentReply)v4_2).getOriginalEvidence();
                                if(v4_3 != null) {
                                    if(!StretchOriginalEvidenceRpc.INSTANCE.boundTo(v4_3, v3_1)) {
                                        goto label_555;
                                    }

                                    goto label_248;
                                }
                                else {
                                    goto label_574;
                                }
                            }

                            goto label_588;
                        }
                        catch(Throwable v0_1) {
                        label_666:
                            goto label_686;
                        }
                        catch(Exception v0_2) {
                            v3 = v16;
                            v16 = v2;
                            v2 = v18;
                            v18 = v3;
                            v14 = v20;
                            v13 = v23;
                            v9_1 = v24;
                            v6_1 = v25;
                            v3 = v26_1;
                            v7 = v27;
                            goto label_615;
                        }
                    }
                }
            }

            goto label_632;
        }

    label_686:
        v2 = v18;
        v14 = v20;
        v13 = v23;
        v9_1 = v24;
        v6_1 = v25;
        v3 = v26_1;
        v7 = v27;
        v18 = v16;
        goto label_694;
        try {
        label_248:
            if(!v4_3.getPhysicalRecoveryAccredited()) {
                v8.put("viewport", v4_3.getViewport().getCode().name());
                v8.put("stable", String.valueOf(v4_3.getStable()));
                v8.put("windowRead", v4_3.getWindowRead().name());
                v8.put("compositorRead", v4_3.getCompositor().getCode().name());
                v3_6 = v8;
                v6_2 = "compositorStable";
                int v9_3 = WhenMappings.$EnumSwitchMapping$0[v4_3.getCompositor().getCode().ordinal()];
                if(v9_3 != 1) {
                    goto label_281;
                }
                else {
                    goto label_313;
                }
            }

            goto label_555;
        }
        catch(Exception v0_2) {
            goto label_544;
        }
        catch(Throwable v0_1) {
            goto label_531;
        }

    label_281:
        if(v9_3 != 2) {
            try {
                v9_1 = "UNKNOWN";
                goto label_316;
            label_285:
                v9_1 = "false";
                goto label_316;
            }
            catch(Exception v0_2) {
                goto label_301;
            }
            catch(Throwable v0_1) {
                goto label_288;
            }
        }
        else {
            goto label_285;
            try {
            label_313:
                v9_1 = String.valueOf(v4_3.getCompositor().getStable());
            label_316:
                ((Map)v3_6).put(v6_2, v9_1);
                v3_7 = v4_3.getCompositor().getState();
                if(v3_7 != null) {
                    goto label_320;
                }

                goto label_361;
            }
            catch(Exception v0_2) {
                goto label_544;
            }
            catch(Throwable v0_1) {
                goto label_531;
            }
        }

        goto label_316;
        try {
        label_320:
            v8.put("compositorSourceRect", v1.rect(v3_7.getProjection().getSource()));
            v8.put("compositorDestinationRect", v1.rect(v3_7.getProjection().getDestination()));
            v8.put("compositorDisplaySize", v1.size(v3_7.getDisplaySize()));
            v8.put("compositorOrientation", String.valueOf(v3_7.getProjection().getRotation()));
            v8.put("compositorEffectiveOrientation", String.valueOf(v3_7.getEffectiveOrientation()));
            v8.put("compositorInstallOrientation", String.valueOf(v3_7.getInstallOrientation()));
            if(v4_3.getCompositor().getStable()) {
                v8.put(v0, "OBSERVED_COMPOSITOR_ONLY");
            }
        }
        catch(Exception v0_2) {
            goto label_301;
        }
        catch(Throwable v0_1) {
            goto label_288;
        }

        try {
        label_361:
            v0_3 = v4_3.getViewport().getViewport();
            if(v0_3 != null) {
                goto label_364;
            }

            goto label_383;
        }
        catch(Exception v0_2) {
            goto label_544;
        }
        catch(Throwable v0_1) {
            goto label_531;
        }

        try {
        label_364:
            v8.put("sourceRect", v1.rect(v0_3.getProjection().getSource()));
            v8.put("destinationRect", v1.rect(v0_3.getProjection().getDestination()));
            v8.put("deviceSize", v1.size(v0_3.getDeviceSize()));
        }
        catch(Exception v0_2) {
            goto label_301;
        }
        catch(Throwable v0_1) {
            goto label_288;
        }

        try {
        label_383:
            v8.put("scaling", v1.datum(v4_3.getScaling(), new StretchReadOnlyPreflight$$ExternalSyntheticLambda3()));
            v8.put("override", v1.datum(v4_3.getSizeOverride(), new StretchReadOnlyPreflight$run$8(v1)));
            v2 = "journal";
            v0_4 = v8;
            v3 = "candidateJournal";
            v4_2 = v1.inspectJournal.invoke();
            if(Intrinsics.areEqual(v4_2, Missing.INSTANCE)) {
            }
            else {
                goto label_407;
            }
        }
        catch(Exception v0_2) {
            goto label_544;
        }
        catch(Throwable v0_1) {
            goto label_531;
        }

        try {
            v4 = "MISSING";
            goto label_421;
        }
        catch(Exception v0_2) {
            goto label_301;
        }
        catch(Throwable v0_1) {
            goto label_288;
        }

        try {
        label_407:
            if((v4_2 instanceof Present)) {
            }
            else {
                goto label_413;
            }
        }
        catch(Exception v0_2) {
            goto label_544;
        }
        catch(Throwable v0_1) {
            goto label_531;
        }

        try {
            v4 = ((Present)v4_2).getRecord().getPhase().name();
            goto label_421;
        }
        catch(Throwable v0_1) {
        label_288:
            v47 = v16;
            v46 = v17;
            v2 = v18;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            v17_1 = v29;
            goto label_886;
        }
        catch(Exception v0_2) {
        label_301:
            v1_1 = v18;
            v18 = v16;
            v16 = v1_1;
            v1_1 = v2;
            v4 = v19;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            goto label_744;
        }

        try {
        label_413:
            if((v4_2 instanceof Blocked)) {
                v4 = v7 + ((Blocked)v4_2).getError().name();
            }
            else {
                goto label_516;
            }

        label_421:
            ((Map)v0_4).put(v3, v4);
            v0_4 = v8;
        }
        catch(Exception v0_2) {
            goto label_544;
        }
        catch(Throwable v0_1) {
            goto label_531;
        }

        try {
            ((Map)v0_4).put(v15, v11);
        }
        catch(Throwable v0_1) {
            v4 = v16;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            v16_1 = v0_1;
            v46 = v17;
            v47 = v4;
            v2 = v18;
            goto label_697;
        }
        catch(Throwable v0_1) {
        label_531:
            v4 = v16;
            v2 = v18;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            goto label_539;
        }
        catch(Exception v0_2) {
        label_544:
            v4 = v16;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            v16 = v2;
            v2 = v18;
            goto label_553;
        }

        Object v2_1 = v10.element;
        if(v2_1 != null) {
            if(!((StretchAgentClient)v2_1).getRemoteExecutionUnknown() && !Thread.currentThread().isInterrupted()) {
                try {
                    v0_5 = StretchReadOnlyPreflight.run$exchange(v10, v8, StretchAgentRequest.copy$default(v29, 0, null, "close", null, null, 0, StretchAgentAction.CLOSE, null, null, 0, null, 0x7BB, null), StretchAgentCode.CLOSED, v12);
                    if(v0_5.getPhase() != StretchAgentPhase.CLOSED) {
                        v8.put(v12, v5);
                    }

                    if(v0_5.getPhase() == StretchAgentPhase.CLOSED) {
                        goto label_480;
                    }

                    throw new IllegalStateException(v26_1);
                }
                catch(Exception v0_2) {
                    v6_1 = v25;
                    v7 = v27;
                    ((Map)v6_1).put(v7, StretchReadOnlyPreflightKt.preflightErrorType(v0_2));
                    v9_1 = v24;
                    if(v8.get(v9_1) == null) {
                        ((Map)v6_1).put(v9_1, v23);
                        ((Map)v6_1).put(v20, StretchReadOnlyPreflightKt.preflightErrorType(v0_2));
                    }

                    v4 = v19;
                    if(!Intrinsics.areEqual(v8.get(v15), v11)) {
                        goto label_483;
                    }

                    ((Map)v6_1).put(v15, v4);
                    goto label_483;
                }
            }

        label_480:
            v4 = v19;
            v6_1 = v25;
            v7 = v27;
        label_483:
            ((Map)v6_1).put(v18, String.valueOf(((StretchAgentClient)v2_1).getRemoteExecutionUnknown()));
            goto label_493;
        }

        v4 = v19;
        v6_1 = v25;
        v7 = v27;
        try {
        label_493:
            v1.disconnect.invoke();
            v8.put(v17, v16);
            goto label_956;
        }
        catch(Exception v0_2) {
            goto label_953;
        }

    label_516:
        v4 = v16;
        v14 = v20;
        v13 = v23;
        v9_1 = v24;
        v6_1 = v25;
        v3 = v26_1;
        v7 = v27;
        v16 = v2;
        v2 = v18;
        try {
            throw new NoWhenBranchMatchedException();
        }
        catch(Exception v0_2) {
        }
        catch(Throwable v0_1) {
        label_539:
            v16_1 = v0_1;
            v47 = v4;
            v46 = v17;
            goto label_697;
        label_555:
            v4 = v16;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            v16 = v2;
            v2 = v18;
            v18 = v4;
            goto label_566;
        }

    label_553:
        v18 = v4;
        goto label_615;
        try {
            v18 = v4;
            goto label_694;
        label_566:
            throw new IllegalArgumentException(v43.toString());
        label_574:
            v3 = v16;
            v16 = v2;
            v2 = v18;
            v18 = v3;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            throw new IllegalArgumentException(v44.toString());
        label_588:
            v3 = v16;
            v16 = v2;
            v2 = v18;
            v18 = v3;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            throw new IllegalArgumentException(v43.toString());
        }
        catch(Throwable v0_1) {
        }
        catch(Exception v0_2) {
        label_615:
            v1_1 = v16;
            v4 = v19;
        label_712:
            v19_1 = v29;
            v16 = v2;
            goto label_868;
        label_632:
            v43 = v4;
            v2 = v18;
            v14 = v20;
            v13 = v23;
            v9_1 = v24;
            v6_1 = v25;
            v3 = v26_1;
            v7 = v27;
            v18 = v16;
            try {
                throw new IllegalArgumentException(v43.toString());
            label_647:
                v22_1 = v4;
                v44 = v9_1;
                v2 = v18;
                v14 = v20;
                v13 = v23;
                v9_1 = v24;
                v6_1 = v25;
                v3 = v26_1;
                v7 = v27;
                v18 = v16;
                throw new IllegalArgumentException(v44.toString());
            }
            catch(Throwable v0_1) {
            }
            catch(Exception v0_2) {
            label_680:
                v16 = v2;
                v4 = v19;
                v1_1 = v22_1;
            label_744:
                v19_1 = v29;
                goto label_868;
            }
        }

    label_694:
        v16_1 = v0_1;
        v46 = v17;
        v47 = v18;
    label_697:
        v4 = v19;
    label_729:
        v17_1 = v29;
        goto label_969;
    label_746:
        v2 = v18;
        v4 = v19;
        v14 = v20;
        v13 = v23;
        v9_1 = v24;
        v6_1 = v25;
        v3 = v26_1;
        v7 = v27;
        v18 = v16;
        try {
            throw new SecurityException();
        }
        catch(Throwable v0_1) {
        }
        catch(Exception v0_2) {
        label_865:
            v16 = v2;
            v1_1 = v21;
            v19_1 = v22;
            try {
            label_868:
                v8.put(v15, v4);
                v8.put(v9_1, v1_1);
                v8.put(v14_3, StretchReadOnlyPreflightKt.preflightErrorType(v0_2));
                if(!(v0_2 instanceof InterruptedException)) {
                    goto label_888;
                }
            }
            catch(Throwable v0_1) {
                v2 = v16;
                v46 = v17;
                v47 = v18;
                v16_1 = v0_1;
                v17_1 = v19_1;
                goto label_969;
            }

            try {
                Thread.currentThread().interrupt();
                goto label_888;
            }
            catch(Throwable v0_1) {
                v2 = v16;
                v46 = v17;
                v47 = v18;
                v17_1 = v19_1;
            }

        label_886:
            v16_1 = v0_1;
            goto label_969;
        label_888:
            Object v1_2 = v10.element;
            if(v1_2 != null) {
                if(v19_1 != null && !((StretchAgentClient)v1_2).getRemoteExecutionUnknown() && !Thread.currentThread().isInterrupted()) {
                    try {
                        v0_5 = StretchReadOnlyPreflight.run$exchange(v10, v8, StretchAgentRequest.copy$default(v19_1, 0, null, "close", null, null, 0, StretchAgentAction.CLOSE, null, null, 0, null, 0x7BB, null), StretchAgentCode.CLOSED, v12);
                        if(v0_5.getPhase() != StretchAgentPhase.CLOSED) {
                            v8.put(v12, v5);
                        }

                        if(v0_5.getPhase() == StretchAgentPhase.CLOSED) {
                            goto label_938;
                        }

                        throw new IllegalStateException(((String)v3_5));
                    }
                    catch(Exception v0_2) {
                        ((Map)v6_1).put(v7, StretchReadOnlyPreflightKt.preflightErrorType(v0_2));
                        if(v8.get(v9_1) == null) {
                            ((Map)v6_1).put(v9_1, v13_1);
                            ((Map)v6_1).put(v14_3, StretchReadOnlyPreflightKt.preflightErrorType(v0_2));
                        }

                        if(!Intrinsics.areEqual(v8.get(v15), v11)) {
                            goto label_938;
                        }

                        ((Map)v6_1).put(v15, v4);
                    }
                }

            label_938:
                ((Map)v6_1).put(v16, String.valueOf(((StretchAgentClient)v1_2).getRemoteExecutionUnknown()));
            }

            v1 = this;
            try {
                v1.disconnect.invoke();
                v8.put(v17, v18);
                goto label_956;
            }
            catch(Exception v0_2) {
            }

        label_953:
            ((Map)v6_1).put(v7, StretchReadOnlyPreflightKt.preflightErrorType(v0_2));
            ((Map)v6_1).put(v15, v4);
        label_956:
            v8.putAll(v1.connectionDiagnostics.invoke());
            return new StretchPreflightReport(((Map)v6_1));
        }

    label_850:
        v16_1 = v0_1;
        v46 = v17;
        v47 = v18;
        v17_1 = v22;
    label_969:
        Object v31_1 = v10.element;
        if(v31_1 != null) {
            if(v17_1 != null && !((StretchAgentClient)v31_1).getRemoteExecutionUnknown() && !Thread.currentThread().isInterrupted()) {
                try {
                    v0_5 = StretchReadOnlyPreflight.run$exchange(v10, v8, StretchAgentRequest.copy$default(v17_1, 0, null, "close", null, null, 0, StretchAgentAction.CLOSE, null, null, 0, null, 0x7BB, null), StretchAgentCode.CLOSED, v12);
                    if(v0_5.getPhase() != StretchAgentPhase.CLOSED) {
                        v8.put(v12, v5);
                    }

                    if(v0_5.getPhase() == StretchAgentPhase.CLOSED) {
                        goto label_1019;
                    }

                    throw new IllegalStateException(((String)v3_5));
                }
                catch(Exception v0_2) {
                    ((Map)v6_1).put(v7, StretchReadOnlyPreflightKt.preflightErrorType(v0_2));
                    if(v8.get(v9_1) == null) {
                        ((Map)v6_1).put(v9_1, v13_1);
                        ((Map)v6_1).put(v14_3, StretchReadOnlyPreflightKt.preflightErrorType(v0_2));
                    }

                    if(!Intrinsics.areEqual(v8.get(v15), v11)) {
                        goto label_1019;
                    }

                    ((Map)v6_1).put(v15, v4);
                }
            }

        label_1019:
            ((Map)v6_1).put(v2, String.valueOf(((StretchAgentClient)v31_1).getRemoteExecutionUnknown()));
        }

        v1 = this;
        try {
            v1.disconnect.invoke();
            v8.put(v46, v47);
        }
        catch(Exception v0_2) {
            ((Map)v6_1).put(v7, StretchReadOnlyPreflightKt.preflightErrorType(v0_2));
            ((Map)v6_1).put(v15, v4);
        }

        v8.putAll(v1.connectionDiagnostics.invoke());
        throw v16_1;
    }

    private static final StretchAgentReply run$exchange(ObjectRef arg2, LinkedHashMap arg3, StretchAgentRequest arg4, StretchAgentCode arg5, String arg6) {
        Object v2 = arg2.element;
        if(v2 != null) {
            v2 = ((StretchAgentClient)v2).submit(arg4).get(6, TimeUnit.SECONDS);
            ((Map)arg3).put(arg6, ((StretchAgentReply)v2).getCode().name());
            if(Intrinsics.areEqual(arg6, "sessionClose")) {
                ((Map)arg3).put("sessionCloseReplyCode", ((StretchAgentReply)v2).getCode().name());
                ((Map)arg3).put("sessionClosePhase", ((StretchAgentReply)v2).getPhase().name());
                boolean v4 = ((StretchAgentReply)v2).getCode() != StretchAgentCode.CLOSED || ((StretchAgentReply)v2).getPhase() != StretchAgentPhase.CLOSED ? false : true;
                ((Map)arg3).put("sessionCloseRemoteAck", String.valueOf(v4));
            }

            if(((StretchAgentReply)v2).getCode() == arg5 && !((StretchAgentReply)v2).getPhysicalMutationAllowed()) {
                Intrinsics.checkNotNull(v2);
                return ((StretchAgentReply)v2);
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    static final String run$lambda$1(int arg0) {
        return String.valueOf(arg0);
    }

    static final String run$lambda$2(int arg0) {
        return String.valueOf(arg0);
    }

    static final String run$lambda$5(StretchScaling arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.name();
    }

    private final String size(StretchSize arg2) {
        return arg2.getWidth() + "x" + arg2.getHeight();
    }
}

