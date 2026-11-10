package com.TryJeanPc.goldenmouse.stretch.recovery;

import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¨\u0006\u0004"}, d2={"validRecoveryRecord", "", "record", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryValidationKt {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[RecoveryResolution.values().length];
            try {
                v0[RecoveryResolution.NO_CHANGE_REQUESTED.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[RecoveryResolution.SIMULATION_VERIFIED.ordinal()] = 2;
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

    public static final boolean validRecoveryRecord(StretchRecoveryRecord arg15) {
        Object v3_4;
        Object v7_3;
        Intrinsics.checkNotNullParameter(arg15, "record");
        if(Long.compare(arg15.getRevision(), 1) >= 0 && arg15.getSnapshot().getSchemaVersion() == 1 && !StringsKt.isBlank(arg15.getSnapshot().getSessionId())) {
            int v3 = 0x80;
            if(arg15.getSnapshot().getSessionId().length() <= v3) {
                int v4 = 3;
                if(arg15.getStrategy().getSupportedSteps().size() <= v4) {
                    int v5 = 2;
                    if(arg15.getRestores().size() <= v5) {
                        int v0 = arg15.getIntendedSteps().size();
                        if(1 <= v0) {
                            int v6 = 4;
                            if(v0 < v6 && CollectionsKt.distinct(arg15.getIntendedSteps()).size() == arg15.getIntendedSteps().size()) {
                                if(arg15.getSteps().size() > v4) {
                                }
                                else {
                                    StretchRecoveryValidator v0_1 = new StretchRecoveryValidator();
                                    boolean v7 = v0_1.validate(arg15.getSnapshot(), arg15.getStrategy(), arg15.getIntendedSteps()) instanceof SimulationReady;
                                    int v9 = 5;
                                    if(arg15.getSteps().isEmpty()) {
                                        RecoveryPhase[] v8 = new RecoveryPhase[v9];
                                        v8[0] = RecoveryPhase.RECOVERY_READY;
                                        v8[1] = RecoveryPhase.APPLYING;
                                        v8[v5] = RecoveryPhase.VERIFYING;
                                        v8[v4] = RecoveryPhase.AWAITING_CONFIRMATION;
                                        v8[v6] = RecoveryPhase.CONFIRMED;
                                        if(SetsKt.setOf(((Object[])v8)).contains(arg15.getPhase())) {
                                            goto label_70;
                                        }
                                    }
                                    else {
                                    label_70:
                                        if(!v7) {
                                            return 0;
                                        }
                                    }

                                    List v7_1 = arg15.getSteps();
                                    int v10 = 10;
                                    ArrayList v8_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v7_1), v10));
                                    Iterator v7_2 = ((Iterable)v7_1).iterator();
                                    while(v7_2.hasNext()) {
                                        ((Collection)v8_1).add(v7_2.next().getStep());
                                    }

                                    if(!Intrinsics.areEqual(v8_1, CollectionsKt.take(arg15.getIntendedSteps(), arg15.getSteps().size()))) {
                                        return 0;
                                    }

                                    v7_1 = arg15.getSteps();
                                    if(!(v7_1 instanceof Collection) || !v7_1.isEmpty()) {
                                        v7_2 = ((Iterable)v7_1).iterator();
                                        do {
                                            if(v7_2.hasNext()) {
                                                if(StretchRecoveryValidationKt.validRecoveryRecord$ticket(arg15, v7_2.next().getTicket())) {
                                                    continue;
                                                }

                                                return 0;
                                            }

                                            goto label_105;
                                        }
                                        while(true);

                                        return 0;
                                    }
                                    else {
                                    }

                                label_105:
                                    v7_1 = CollectionsKt.dropLast(arg15.getSteps(), 1);
                                    if(!(v7_1 instanceof Collection) || !v7_1.isEmpty()) {
                                        v7_2 = ((Iterable)v7_1).iterator();
                                        do {
                                            if(v7_2.hasNext()) {
                                                if(v7_2.next().getOutcome() == RecoveryStepOutcome.VERIFIED) {
                                                    continue;
                                                }

                                                return 0;
                                            }

                                            goto label_121;
                                        }
                                        while(true);

                                        return 0;
                                    }
                                    else {
                                    }

                                label_121:
                                    v7_1 = arg15.getSteps();
                                    v8_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v7_1), v10));
                                    v7_2 = ((Iterable)v7_1).iterator();
                                    while(v7_2.hasNext()) {
                                        ((Collection)v8_1).add(v7_2.next().getTicket());
                                    }

                                    v7_1 = arg15.getRestores();
                                    ArrayList v11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v7_1), v10));
                                    v7_2 = ((Iterable)v7_1).iterator();
                                    while(v7_2.hasNext()) {
                                        ((Collection)v11).add(v7_2.next().getRequest().getTicket());
                                    }

                                    v7_1 = CollectionsKt.plus(((Collection)v8_1), ((Iterable)v11));
                                    List v8_2 = v7_1;
                                    v11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v8_2), v10));
                                    Iterator v12 = ((Iterable)v8_2).iterator();
                                    while(v12.hasNext()) {
                                        ((Collection)v11).add(v12.next().getOperationId());
                                    }

                                    if(CollectionsKt.distinct(((Iterable)v11)).size() != v7_1.size()) {
                                        return 0;
                                    }

                                    v7_1 = CollectionsKt.zipWithNext(((Iterable)v8_2));
                                    if(!(v7_1 instanceof Collection) || !v7_1.isEmpty()) {
                                        v7_2 = ((Iterable)v7_1).iterator();
                                        do {
                                            if(v7_2.hasNext()) {
                                                Object v8_3 = v7_2.next();
                                                if(((Pair)v8_3).component1().getRevision() < ((Pair)v8_3).component2().getRevision()) {
                                                    continue;
                                                }

                                                return 0;
                                            }

                                            goto label_177;
                                        }
                                        while(true);

                                        return 0;
                                    }
                                    else {
                                    }

                                label_177:
                                    StretchRestoreResult v11_1 = null;
                                    if(arg15.getPhase() == RecoveryPhase.APPLYING) {
                                        v7_3 = CollectionsKt.lastOrNull(arg15.getSteps());
                                        RecoveryStepOutcome v7_4 = v7_3 != null ? ((RecoveryStepRecord)v7_3).getOutcome() : ((RecoveryStepOutcome)v11_1);
                                        if(v7_4 == RecoveryStepOutcome.REQUESTED) {
                                            goto label_190;
                                        }

                                        return 0;
                                    }

                                label_190:
                                    if(arg15.getPhase() == RecoveryPhase.VERIFYING) {
                                        if(!arg15.getSteps().isEmpty()) {
                                            v7_1 = arg15.getSteps();
                                            if(((v7_1 instanceof Collection)) && (v7_1.isEmpty())) {
                                                goto label_211;
                                            }

                                            v7_2 = ((Iterable)v7_1).iterator();
                                            do {
                                                if(!v7_2.hasNext()) {
                                                    goto label_211;
                                                }

                                                if(v7_2.next().getOutcome() == RecoveryStepOutcome.VERIFIED) {
                                                    continue;
                                                }

                                                return 0;
                                            }
                                            while(true);
                                        }

                                        return 0;
                                    }

                                label_211:
                                    if(!arg15.getSteps().isEmpty()) {
                                        RecoveryPhase[] v7_5 = new RecoveryPhase[6];
                                        v7_5[0] = RecoveryPhase.IDLE;
                                        v7_5[1] = RecoveryPhase.PREPARING;
                                        v7_5[v5] = RecoveryPhase.BASELINE_CAPTURED;
                                        v7_5[v4] = RecoveryPhase.RECOVERY_READY;
                                        v7_5[v6] = RecoveryPhase.FAILED;
                                        v7_5[v9] = RecoveryPhase.NOT_RECOVERABLE;
                                        if(SetsKt.setOf(((Object[])v7_5)).contains(arg15.getPhase())) {
                                            return 0;
                                        }
                                    }

                                    List v6_1 = arg15.getRestores();
                                    if(!(v6_1 instanceof Collection) || !v6_1.isEmpty()) {
                                        Iterator v6_2 = ((Iterable)v6_1).iterator();
                                    label_241:
                                        if(v6_2.hasNext()) {
                                            v7_3 = v6_2.next();
                                            if((StretchRecoveryValidationKt.validRecoveryRecord$ticket(arg15, ((RecoveryRestoreAttempt)v7_3).getRequest().getTicket())) && (Intrinsics.areEqual(((RecoveryRestoreAttempt)v7_3).getRequest().getSnapshot(), arg15.getSnapshot()))) {
                                                v8_2 = ((RecoveryRestoreAttempt)v7_3).getRequest().getSteps();
                                                List v9_1 = arg15.getSteps();
                                                ArrayList v12_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v9_1), v10));
                                                Iterator v9_2 = ((Iterable)v9_1).iterator();
                                                while(v9_2.hasNext()) {
                                                    ((Collection)v12_1).add(v9_2.next().getStep());
                                                }

                                                if(Intrinsics.areEqual(v8_2, v12_1)) {
                                                    StretchRestoreResult v8_4 = ((RecoveryRestoreAttempt)v7_3).getResult();
                                                    if(v8_4 == null) {
                                                        goto label_241;
                                                    }

                                                    if((Intrinsics.areEqual(v8_4.getTicket(), ((RecoveryRestoreAttempt)v7_3).getRequest().getTicket())) && v8_4.getSteps().size() <= v4) {
                                                        v9_1 = v8_4.getSteps();
                                                        v12_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v9_1), v10));
                                                        v9_2 = ((Iterable)v9_1).iterator();
                                                        while(v9_2.hasNext()) {
                                                            ((Collection)v12_1).add(v9_2.next().getStep());
                                                        }

                                                        if(CollectionsKt.distinct(((Iterable)v12_1)).size() == v8_4.getSteps().size()) {
                                                            v8_2 = v8_4.getSteps();
                                                            if(((v8_2 instanceof Collection)) && (v8_2.isEmpty())) {
                                                                goto label_241;
                                                            }

                                                            Iterator v8_5 = ((Iterable)v8_2).iterator();
                                                            do {
                                                                if(!v8_5.hasNext()) {
                                                                    goto label_241;
                                                                }

                                                                if(((RecoveryRestoreAttempt)v7_3).getRequest().getSteps().contains(v8_5.next().getStep())) {
                                                                    continue;
                                                                }

                                                                return 0;
                                                            }
                                                            while(true);
                                                        }
                                                    }
                                                }
                                            }

                                            return 0;
                                        }
                                    }
                                    else {
                                    }

                                    RecoveryConfirmation v4_1 = arg15.getConfirmation();
                                    if(v4_1 != null && ((StringsKt.isBlank(v4_1.getId())) || v4_1.getId().length() > v3 || v4_1.getStartedElapsedMillis() < 0 || v4_1.getExpiresElapsedMillis() <= v4_1.getStartedElapsedMillis())) {
                                        return 0;
                                    }

                                    RecoveryPhase[] v3_1 = new RecoveryPhase[v5];
                                    v3_1[0] = RecoveryPhase.AWAITING_CONFIRMATION;
                                    v3_1[1] = RecoveryPhase.CONFIRMED;
                                    if(SetsKt.setOf(((Object[])v3_1)).contains(arg15.getPhase())) {
                                        if(v4_1 != null) {
                                            List v3_2 = arg15.getSteps();
                                            ArrayList v6_3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3_2), v10));
                                            Iterator v3_3 = ((Iterable)v3_2).iterator();
                                            while(v3_3.hasNext()) {
                                                ((Collection)v6_3).add(v3_3.next().getStep());
                                            }

                                            if(Intrinsics.areEqual(v6_3, arg15.getIntendedSteps())) {
                                                v3_2 = arg15.getSteps();
                                                if(((v3_2 instanceof Collection)) && (v3_2.isEmpty())) {
                                                    goto label_365;
                                                }

                                                v3_3 = ((Iterable)v3_2).iterator();
                                                do {
                                                    if(!v3_3.hasNext()) {
                                                        goto label_365;
                                                    }

                                                    if(v3_3.next().getOutcome() == RecoveryStepOutcome.VERIFIED) {
                                                        continue;
                                                    }

                                                    return 0;
                                                }
                                                while(true);
                                            }
                                        }

                                        return 0;
                                    }

                                label_365:
                                    if(arg15.getPhase() == RecoveryPhase.CONFIRMED && (arg15.getConfirmedAtElapsedMillis() == null || v4_1 == null || arg15.getConfirmedAtElapsedMillis().longValue() < v4_1.getStartedElapsedMillis() || arg15.getConfirmedAtElapsedMillis().longValue() >= v4_1.getExpiresElapsedMillis())) {
                                        return 0;
                                    }

                                    if(arg15.getPhase() == RecoveryPhase.RESTORING && (arg15.getRestores().isEmpty())) {
                                        return 0;
                                    }

                                    if(arg15.getPhase() == RecoveryPhase.VERIFYING_RESTORE) {
                                        v3_4 = CollectionsKt.lastOrNull(arg15.getRestores());
                                        if(v3_4 != null) {
                                            v11_1 = ((RecoveryRestoreAttempt)v3_4).getResult();
                                        }

                                        if(v11_1 != null) {
                                            goto label_396;
                                        }

                                        return 0;
                                    }

                                label_396:
                                    if(arg15.getPhase() == RecoveryPhase.RECOVERED) {
                                        RecoveryResolution v3_5 = arg15.getResolution();
                                        v4 = -1;
                                        v3 = v3_5 == null ? v4 : WhenMappings.$EnumSwitchMapping$0[v3_5.ordinal()];
                                        if(v3 != v4) {
                                            if(v3 == 1) {
                                                if(!arg15.getSteps().isEmpty()) {
                                                    return 0;
                                                }

                                                if(!arg15.getRestores().isEmpty()) {
                                                    return 0;
                                                }

                                                return 1;
                                            }
                                            else if(v3 == v5) {
                                                v3_4 = CollectionsKt.lastOrNull(arg15.getRestores());
                                                if(v3_4 != null) {
                                                    StretchRestoreResult v3_6 = ((RecoveryRestoreAttempt)v3_4).getResult();
                                                    if(v3_6 != null && (v0_1.verifiedRestore$app(arg15, v3_6))) {
                                                        return 1;
                                                    }
                                                }

                                                return 0;
                                            }
                                            else {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                        }

                                        return 0;
                                    }

                                    if(arg15.getResolution() != null) {
                                        return 0;
                                    }

                                    return 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    private static final boolean validRecoveryRecord$ticket(StretchRecoveryRecord arg6, RecoveryTicket arg7) {
        if((Intrinsics.areEqual(arg7.getSessionId(), arg6.getSnapshot().getSessionId())) && !StringsKt.isBlank(arg7.getOperationId()) && arg7.getOperationId().length() <= 0x80) {
            long v0 = arg6.getRevision();
            long v2 = arg7.getRevision();
            if(1 <= v2 && v2 <= v0 && (Intrinsics.areEqual(arg7.getSnapshotDigest(), StretchRecoveryCodec.INSTANCE.snapshotDigest(arg6.getSnapshot())))) {
                Object v0_1 = arg6.getSnapshot().getOriginal().getLogicalIdentity().getValue();
                if(v0_1 != null && arg7.getLogicalDisplayId() == ((StretchDisplayIdentity)v0_1).getLogicalId() && (Intrinsics.areEqual(arg7.getPhysicalIdentity(), arg6.getSnapshot().getOriginal().getPhysicalIdentity().getValue()))) {
                    return 1;
                }
            }
        }

        return 0;
    }
}

