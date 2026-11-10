package com.TryJeanPc.goldenmouse.stretch.backend;

import com.TryJeanPc.goldenmouse.stretch.GoldenStretchGeometryCalculator;
import com.TryJeanPc.goldenmouse.stretch.StretchCalculation$Valid;
import com.TryJeanPc.goldenmouse.stretch.StretchDisplayRead$Available;
import com.TryJeanPc.goldenmouse.stretch.StretchDisplayRead$Unavailable;
import com.TryJeanPc.goldenmouse.stretch.StretchDisplayRead;
import com.TryJeanPc.goldenmouse.stretch.StretchReadIssue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/GoldenStretchCapabilityDetector;", "", "<init>", "()V", "detect", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchCapabilityReport;", "sessionId", "", "androidApi", "", "publicDisplay", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead;", "inventory", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchOperationResult;", "queries", "", "preferred", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchCapabilityDetector {
    public static final int $stable;

    static {
    }

    public GoldenStretchCapabilityDetector() {
        super();
    }

    public final StretchCapabilityReport detect(String arg17, int arg18, StretchDisplayRead arg19, StretchOperationResult arg20, List arg21, StretchBackendType arg22) {
        int v16;
        StretchEvidence v7_3;
        int v10;
        StretchEvidence v0_2;
        Object v7;
        String v1 = arg17;
        StretchDisplayRead v3 = arg19;
        List v0 = arg21;
        Intrinsics.checkNotNullParameter(v1, "sessionId");
        Intrinsics.checkNotNullParameter(v3, "publicDisplay");
        StretchOperationResult v4 = arg20;
        Intrinsics.checkNotNullParameter(v4, "inventory");
        Intrinsics.checkNotNullParameter(v0, "queries");
        List v5 = null;
        if(!Intrinsics.areEqual(v4.getSessionId(), v1) || v4.getQuery() != StretchQuery.BACKEND_STATUS || v4.getStatus() != StretchExecutionStatus.SUCCEEDED) {
            v4 = ((StretchOperationResult)v5);
        }
        else {
        }

        if(v4 != null) {
            v5 = v4.getBackends();
        }

        if(v5 == null) {
            v5 = CollectionsKt.emptyList();
        }

        StretchBackendType v2 = StretchBackendModelsKt.selectStretchBackend(v5, arg22);
        ArrayList v4_1 = new ArrayList();
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            Object v6 = v0_1.next();
            v7 = v6;
            if(!Intrinsics.areEqual(((StretchOperationResult)v7).getSessionId(), v1)) {
                continue;
            }

            if(((StretchOperationResult)v7).getBackend() != v2) {
                continue;
            }

            if(v2 == StretchBackendType.NONE) {
                continue;
            }

            ((Collection)v4_1).add(v6);
        }

        ArrayList v6_1 = new ArrayList();
        v0_1 = v4_1.iterator();
        while(v0_1.hasNext()) {
            v7 = v0_1.next();
            Object v8 = v7;
            if(((StretchOperationResult)v8).getStatus() != StretchExecutionStatus.SUCCEEDED) {
                continue;
            }

            Integer v9 = ((StretchOperationResult)v8).getExitCode();
            if(v9 == null) {
                continue;
            }

            if(v9.intValue() != 0) {
                continue;
            }

            if(((StretchOperationResult)v8).getError() != null) {
                continue;
            }

            if(((StretchOperationResult)v8).getData() == null) {
                continue;
            }

            if(((StretchOperationResult)v8).getQuery() == StretchQuery.BACKEND_STATUS) {
                continue;
            }

            ((Collection)v6_1).add(v7);
        }

        if(!v5.isEmpty()) {
            v0 = v5;
            boolean v7_1 = v0 instanceof Collection;
            if(!v7_1 || !v0.isEmpty()) {
                Iterator v8_1 = ((Iterable)v0).iterator();
                do {
                    if(v8_1.hasNext()) {
                        Object v9_1 = v8_1.next();
                        if(((StretchBackendStatus)v9_1).getState() != StretchBackendState.UNKNOWN) {
                            if(((StretchBackendStatus)v9_1).getState() != StretchBackendState.ERROR) {
                                continue;
                            }

                            break;
                        }
                        else {
                            goto label_107;
                        }
                    }

                    goto label_91;
                }
                while(true);

                goto label_107;
            }
            else {
            }

        label_91:
            if(!v7_1 || !v0.isEmpty()) {
                v0_1 = ((Iterable)v0).iterator();
                do {
                    if(v0_1.hasNext()) {
                        if(v0_1.next().getState() != StretchBackendState.NOT_AUTHORIZED) {
                            continue;
                        }

                        break;
                    }

                    goto label_105;
                }
                while(true);

                v0_2 = StretchEvidence.NOT_AUTHORIZED;
                goto label_108;
            }
            else {
            }

        label_105:
            v0_2 = StretchEvidence.UNAVAILABLE;
        }
        else {
        label_107:
            v0_2 = StretchEvidence.UNKNOWN;
        }

    label_108:
        int v8_2 = 3;
        boolean v9_2 = false;
        if((v3 instanceof Available)) {
            v10 = arg18;
            if(v10 >= 26) {
                StretchDisplayRead v11 = v3;
                if((new GoldenStretchGeometryCalculator().calculate(((Available)v11).getSnapshot(), 100) instanceof Valid)) {
                    IntRange v7_2 = new IntRange(0, v8_2);
                    Integer v11_1 = ((Available)v11).getSnapshot().getRotation();
                    if(v11_1 != null && (v7_2.contains(v11_1.intValue()))) {
                        v7_3 = StretchEvidence.VERIFIED;
                        goto label_145;
                    }
                }
            }

            v7_3 = StretchEvidence.UNKNOWN;
        }
        else {
            v10 = arg18;
            if(!(v3 instanceof Unavailable)) {
                goto label_223;
            }

            if(v3.getReason() == StretchReadIssue.DISPLAY_UNAVAILABLE) {
                v7_3 = StretchEvidence.UNAVAILABLE;
                goto label_145;
            }

            v7_3 = StretchEvidence.UNKNOWN;
        }

    label_145:
        StretchCapabilityResult[] v11_2 = new StretchCapabilityResult[5];
        v11_2[0] = new StretchCapabilityResult(StretchCapability.PUBLIC_DISPLAY_READ, v7_3, "Public reader observation; mode may be absent");
        v11_2[1] = new StretchCapabilityResult(StretchCapability.QUERY_OPERATIONS, GoldenStretchCapabilityDetector.detect$evidence(v2, v0_2, ((List)v4_1), v6_1.isEmpty() ^ 1), "Only the observed typed queries; no write permission inferred");
        StretchCapability v7_4 = StretchCapability.BACKEND_DISPLAY_READ;
        if(!(v6_1 instanceof Collection) || !v6_1.isEmpty()) {
            Iterator v12 = ((Iterable)v6_1).iterator();
            while(true) {
                if(v12.hasNext()) {
                    Object v13 = v12.next();
                    v16 = v8_2;
                    if(((StretchOperationResult)v13).getQuery() != StretchQuery.DISPLAY_SIZE) {
                        if(((StretchOperationResult)v13).getQuery() == StretchQuery.DISPLAY_DENSITY) {
                        }
                        else {
                            v8_2 = v16;
                            continue;
                        }
                    }

                    break;
                }
                else {
                    goto label_168;
                }
            }

            v9_2 = true;
            goto label_185;
        label_168:
            v16 = v8_2;
        }
        else {
            goto label_168;
        }

    label_185:
        v11_2[2] = new StretchCapabilityResult(v7_4, GoldenStretchCapabilityDetector.detect$evidence(v2, v0_2, ((List)v4_1), v9_2), "wm reports its default display; does not establish identity with a different public display");
        v11_2[v16] = new StretchCapabilityResult(StretchCapability.PRIVILEGED_OPERATIONS, StretchEvidence.PENDING_VALIDATION, "Theoretical backend access is not effective permission for future operations");
        v11_2[4] = new StretchCapabilityResult(StretchCapability.REAL_PROJECTION, StretchEvidence.PENDING_VALIDATION, "No agent, setters, recovery or physical projection test in this phase");
        List v7_5 = CollectionsKt.listOf(((Object[])v11_2));
        List v4_2 = CollectionsKt.toList(((Iterable)v5));
        ArrayList v0_3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v6_1), 10));
        Iterator v5_1 = ((Iterable)v6_1).iterator();
        while(v5_1.hasNext()) {
            ((Collection)v0_3).add(v5_1.next().getQuery());
        }

        return new StretchCapabilityReport(v1, v10, v3, v4_2, v2, CollectionsKt.distinct(((Iterable)v0_3)), v7_5);
    label_223:
        throw new NoWhenBranchMatchedException();
    }

    public static StretchCapabilityReport detect$default(GoldenStretchCapabilityDetector arg7, String arg8, int arg9, StretchDisplayRead arg10, StretchOperationResult arg11, List arg12, StretchBackendType arg13, int arg14, Object arg15) {
        if((arg14 & 16) != 0) {
            arg12 = CollectionsKt.emptyList();
        }

        List v5 = arg12;
        if((arg14 & 0x20) != 0) {
            arg13 = null;
        }

        return arg7.detect(arg8, arg9, arg10, arg11, v5, arg13);
    }

    private static final StretchEvidence detect$evidence(StretchBackendType arg1, StretchEvidence arg2, List arg3, boolean arg4) {
        Iterator v2;
        if(arg1 == StretchBackendType.NONE) {
            return arg2;
        }

        if(arg4) {
            return StretchEvidence.VERIFIED;
        }

        boolean v1 = arg3 instanceof Collection;
        if(!v1 || !arg3.isEmpty()) {
            v2 = ((Iterable)arg3).iterator();
            do {
                if(v2.hasNext()) {
                    if(v2.next().getError() != StretchTransportError.PERMISSION_DENIED) {
                        continue;
                    }

                    break;
                }

                goto label_21;
            }
            while(true);

            return StretchEvidence.NOT_AUTHORIZED;
        }
        else {
        }

    label_21:
        if(!v1 || !arg3.isEmpty()) {
            v2 = ((Iterable)arg3).iterator();
            do {
                if(v2.hasNext()) {
                    if(v2.next().getError() != StretchTransportError.UNSUPPORTED) {
                        continue;
                    }

                    break;
                }

                goto label_35;
            }
            while(true);

            return StretchEvidence.UNAVAILABLE;
        }
        else {
        }

    label_35:
        if(!v1 || !arg3.isEmpty()) {
            Iterator v1_1 = ((Iterable)arg3).iterator();
            do {
                if(v1_1.hasNext()) {
                    Object v2_1 = v1_1.next();
                    if(((StretchOperationResult)v2_1).getStatus() != StretchExecutionStatus.COMPLETED_UNVERIFIED && ((StretchOperationResult)v2_1).getError() == null) {
                        continue;
                    }

                    break;
                }

                goto label_51;
            }
            while(true);

            return StretchEvidence.UNKNOWN;
        }
        else {
        }

    label_51:
        return StretchEvidence.PENDING_VALIDATION;
    }
}

