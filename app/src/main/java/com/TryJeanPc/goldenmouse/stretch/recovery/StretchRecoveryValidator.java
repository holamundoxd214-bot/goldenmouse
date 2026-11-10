package com.TryJeanPc.goldenmouse.stretch.recovery;

import com.TryJeanPc.goldenmouse.stretch.GoldenStretchGeometryCalculator;
import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.backend.StretchBackendType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FJ\u001D\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0000¢\u0006\u0002\b\u0016R\u0011\u0010\u0004\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryValidator;", "", "<init>", "()V", "physicalRecoveryAvailable", "", "getPhysicalRecoveryAvailable", "()Z", "validate", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReadiness;", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "strategy", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStrategy;", "intended", "", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "verifiedRestore", "record", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "result", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreResult;", "verifiedRestore$app", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryValidator {
    public static final int $stable;

    static {
    }

    public StretchRecoveryValidator() {
        super();
    }

    public final boolean getPhysicalRecoveryAvailable() {
        return 0;
    }

    public final RecoveryReadiness validate(StretchRecoverySnapshot arg10, StretchRecoveryStrategy arg11, List arg12) {
        NotRecoverable v9_2;
        Object v4_2;
        Intrinsics.checkNotNullParameter(arg10, "snapshot");
        Intrinsics.checkNotNullParameter(arg11, "strategy");
        Intrinsics.checkNotNullParameter(arg12, "intended");
        LinkedHashSet v9 = new LinkedHashSet();
        StretchOriginalDisplayState v0 = arg10.getOriginal();
        int v2 = 0x80;
        if(arg10.getSchemaVersion() != 1 || (StringsKt.isBlank(arg10.getSessionId())) || arg10.getSessionId().length() > v2 || arg10.getAndroidApi() < 26 || arg10.getCapturedAtWallMillis() < 0 || arg10.getBackend() == StretchBackendType.NONE) {
            v9.add("INVALID_METADATA");
        }

        if(arg10.getCaptureSource() != RecoverySource.SIMULATION) {
            v9.add("ORIGINAL_STATE_NOT_PROVEN");
        }

        StretchRecoveryValidator.validate$known(((Set)v9), v0.getLogicalIdentity(), "MISSING_LOGICAL_IDENTITY");
        StretchRecoveryValidator.validate$known(((Set)v9), v0.getPhysicalIdentity(), "MISSING_PHYSICAL_IDENTITY");
        StretchRecoveryValidator.validate$known(((Set)v9), v0.getLogicalSize(), "MISSING_LOGICAL_SIZE");
        StretchRecoveryValidator.validate$known(((Set)v9), v0.getScaling(), "MISSING_SCALING");
        StretchRecoveryValidator.validate$known(((Set)v9), v0.getRotation(), "MISSING_ROTATION");
        StretchRecoveryValidator.validate$known(((Set)v9), v0.getReferenceSize(), "MISSING_REFERENCE");
        StretchRecoveryValidator.validate$known(((Set)v9), v0.getProjection(), "MISSING_PROJECTION");
        int v1 = 2;
        RecoveryDatumState[] v4 = new RecoveryDatumState[v1];
        v4[0] = RecoveryDatumState.KNOWN;
        v4[1] = RecoveryDatumState.ABSENT;
        if(!SetsKt.setOf(((Object[])v4)).contains(v0.getSizeOverride().getState())) {
            v9.add("UNKNOWN_OVERRIDE");
        }

        int v4_1 = 4;
        RecoveryDatum[] v5 = new RecoveryDatum[v4_1];
        v5[0] = v0.getPhysicalIdentity();
        v5[1] = v0.getSizeOverride();
        v5[v1] = v0.getScaling();
        int v7 = 3;
        v5[v7] = v0.getProjection();
        Iterator v1_1 = CollectionsKt.listOf(((Object[])v5)).iterator();
        while(v1_1.hasNext()) {
            if(v1_1.next().getSource() == RecoverySource.SIMULATION) {
                continue;
            }

            v9.add("RECOVERY_EVIDENCE_NOT_SIMULATED");
        }

        Object v1_2 = v0.getLogicalIdentity().getValue();
        if(v1_2 == null || ((StretchDisplayIdentity)v1_2).getLogicalId() >= 0) {
            v1_2 = v0.getLogicalIdentity().getValue();
            if(v1_2 != null) {
                String v1_3 = ((StretchDisplayIdentity)v1_2).getName();
                if(v1_3 != null && v1_3.length() > v2) {
                    goto label_118;
                }
            }

            v1_2 = v0.getPhysicalIdentity().getValue();
            if(v1_2 == null) {
                goto label_121;
            }

            if(!StringsKt.isBlank(v1_2) && ((String)v1_2).length() <= v2) {
                goto label_121;
            }

        label_118:
            v9.add("INVALID_IDENTITY");
        }
        else {
            goto label_118;
        }

    label_121:
        if(!StretchRecoveryValidator.validate$positive(v0.getLogicalSize().getValue()) || !StretchRecoveryValidator.validate$positive(v0.getSizeOverride().getValue()) || !StretchRecoveryValidator.validate$positive(v0.getReferenceSize().getValue())) {
        label_138:
            v9.add("INVALID_DIMENSIONS");
        }
        else {
            v1_2 = v0.getDensity().getValue();
            if(v1_2 != null && ((Number)v1_2).intValue() <= 0) {
                goto label_138;
            }
        }

        v1_2 = v0.getRotation().getValue();
        if(v1_2 != null && !new IntRange(0, v7).contains(((Integer)v1_2).intValue())) {
            v9.add("INVALID_ROTATION");
        }

        Object v5_1 = v0.getSizeOverride().getValue();
        if(v5_1 != null) {
            if(v1_2 != null && ((Integer)v1_2).intValue() == 1 || ((Integer)v1_2).intValue() == v7) {
                StretchSize v5_2 = new StretchSize(((StretchSize)v5_1).getHeight(), ((StretchSize)v5_1).getWidth());
            }
            else if(v1_2 == null) {
            }

            if(Intrinsics.areEqual(v0.getLogicalSize().getValue(), v5_1)) {
                goto label_175;
            }

            v9.add("OVERRIDE_LOGICAL_MISMATCH");
        }

    label_175:
        v1_2 = v0.getProjection().getValue();
        v5_1 = null;
        if(v1_2 != null) {
            Object v6 = v0.getReferenceSize().getValue();
            if(v6 != null) {
                if(((StretchFullProjection)v1_2).getRotation() != 1 && ((StretchFullProjection)v1_2).getRotation() != v7) {
                    goto label_193;
                }

                StretchSize v6_1 = new StretchSize(((StretchSize)v6).getHeight(), ((StretchSize)v6).getWidth());
            }
            else {
                v6 = v5_1;
            }

        label_193:
            GoldenStretchGeometryCalculator v3 = new GoldenStretchGeometryCalculator();
            int v8 = ((StretchFullProjection)v1_2).getRotation();
            if(v8 >= 0 && v8 < v4_1) {
                v4_2 = v0.getLogicalSize().getValue();
                if(v4_2 != null && v3.validateRectangle(((StretchFullProjection)v1_2).getSource(), ((StretchSize)v4_2)) != null) {
                    goto label_209;
                }

                if(v6_1 == null) {
                    goto label_212;
                }

                if(v3.validateRectangle(((StretchFullProjection)v1_2).getDestination(), v6_1) == null) {
                    goto label_212;
                }
            }

        label_209:
            v9.add("INVALID_PROJECTION");
        }

    label_212:
        if((arg12.isEmpty()) || arg12.size() > v7 || CollectionsKt.distinct(arg12).size() != arg12.size()) {
        label_235:
            v9.add("INVALID_INTENT");
        }
        else {
            EnumEntries v1_4 = RecoveryStep.getEntries();
            ArrayList v3_1 = new ArrayList();
            v1_1 = ((Iterable)v1_4).iterator();
            while(v1_1.hasNext()) {
                v4_2 = v1_1.next();
                if(!arg12.contains(v4_2)) {
                    continue;
                }

                ((Collection)v3_1).add(v4_2);
            }

            if(!Intrinsics.areEqual(arg12, v3_1)) {
                goto label_235;
            }
        }

        try {
            String v5_3 = StretchRecoveryCodec.INSTANCE.snapshotDigest(arg10);
            goto label_240;
        }
        catch(Exception ) {
        label_240:
            if(!arg11.getIdempotent() || (StringsKt.isBlank(arg11.getId())) || arg11.getId().length() > v2 || !Intrinsics.areEqual(arg11.getSnapshotDigest(), v5_3) || !Intrinsics.areEqual(arg11.getPhysicalIdentity(), v0.getPhysicalIdentity().getValue()) || !arg11.getSupportedSteps().containsAll(((Collection)arg12))) {
                v9.add("STRATEGY_UNPROVEN");
            }

            if(((Set)v9).isEmpty()) {
                SimulationReady v9_1 = SimulationReady.INSTANCE;
            }
            else {
                v9_2 = new NotRecoverable(CollectionsKt.toSet(((Iterable)v9)));
            }

            return ((RecoveryReadiness)v9_2);
        }
    }

    private static final void validate$known(Set arg1, RecoveryDatum arg2, String arg3) {
        if(arg2.getState() != RecoveryDatumState.KNOWN) {
            ((Collection)arg1).add(arg3);
        }
    }

    private static final boolean validate$positive(StretchSize arg1) {
        if(arg1 != null && (arg1.getWidth() <= 0 || arg1.getHeight() <= 0)) {
            return 0;
        }

        return 1;
    }

    public final boolean verifiedRestore$app(StretchRecoveryRecord arg6, StretchRestoreResult arg7) {
        Intrinsics.checkNotNullParameter(arg6, "record");
        Intrinsics.checkNotNullParameter(arg7, "result");
        Object v5 = CollectionsKt.lastOrNull(arg6.getRestores());
        if(v5 != null) {
            StretchRestoreRequest v5_1 = ((RecoveryRestoreAttempt)v5).getRequest();
            if(v5_1 == null) {
            }
            else {
                List v1 = arg6.getSteps();
                int v3 = 10;
                ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v1), v3));
                Iterator v1_1 = ((Iterable)v1).iterator();
                while(v1_1.hasNext()) {
                    ((Collection)v2).add(v1_1.next().getStep());
                }

                Set v1_2 = CollectionsKt.toSet(((Iterable)v2));
                if((Intrinsics.areEqual(arg7.getTicket(), v5_1.getTicket())) && arg7.getStatus() == StretchRestoreStatus.VERIFIED && (arg7.getExecutionStopped())) {
                    List v5_2 = arg7.getSteps();
                    v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v5_2), v3));
                    Iterator v5_3 = ((Iterable)v5_2).iterator();
                    while(v5_3.hasNext()) {
                        ((Collection)v2).add(v5_3.next().getStep());
                    }

                    if((Intrinsics.areEqual(CollectionsKt.toSet(((Iterable)v2)), v1_2)) && arg7.getSteps().size() == v1_2.size()) {
                        v5_2 = arg7.getSteps();
                        if(!(v5_2 instanceof Collection) || !v5_2.isEmpty()) {
                            v5_3 = ((Iterable)v5_2).iterator();
                            while(v5_3.hasNext()) {
                                if(v5_3.next().getOutcome() == RecoveryStepOutcome.VERIFIED) {
                                    continue;
                                }
                                else {
                                    return 0;
                                }
                            }
                        }
                        else {
                        }

                        if(!Intrinsics.areEqual(arg7.getObservedOriginal(), arg6.getSnapshot().getOriginal())) {
                            return 0;
                        }

                        return 1;
                    }
                }
            }
        }

        return 0;
    }
}

