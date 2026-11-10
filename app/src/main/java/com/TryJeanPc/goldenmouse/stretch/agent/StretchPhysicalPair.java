package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.GoldenStretchGeometryCalculator;
import com.TryJeanPc.goldenmouse.stretch.StretchCalculation$Valid;
import com.TryJeanPc.goldenmouse.stretch.StretchCalculation;
import com.TryJeanPc.goldenmouse.stretch.StretchDisplaySnapshot;
import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchGeometryPlan;
import com.TryJeanPc.goldenmouse.stretch.StretchProjection$Defined;
import com.TryJeanPc.goldenmouse.stretch.StretchProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchRect;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatumState;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryStep;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoverySnapshot;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchScaling;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 .2\u00020\u0001:\u0001.B;\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u0012\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J0\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\f2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u0007J \u0010\u001F\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\f2\b\b\u0002\u0010 \u001A\u00020\fJ&\u0010!\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\"\u001A\u00020#2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DJ\u0018\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020&H\u0002J\u0018\u0010(\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020&H\u0002J\u0018\u0010)\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020&H\u0002J\u0018\u0010*\u001A\u00020\f2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020&H\u0002J\u001E\u0010+\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010,\u001A\u00020\u001DJ\u000E\u0010-\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalPair;", "", "journal", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalJournal;", "io", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalIo;", "ownerUid", "", "restoration", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;", "applyStillAllowed", "Lkotlin/Function0;", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalJournal;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalIo;ILcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;Lkotlin/jvm/functions/Function0;)V", "custodian", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryCustodian;", "readbackWait", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchReadbackWait;", "record", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "binding", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryBinding;", "apply", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPairResult;", "authorized", "bootId", "", "nowElapsedMillis", "", "factorHundredths", "restore", "closeVerified", "recoverOnLoss", "event", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CustodyEvent;", "sameDisplay", "a", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "b", "sameOriginal", "sameWindowState", "samePhysicalTarget", "closeUnmutatedOriginal", "now", "verifyOriginalExecutor", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPhysicalPair {
    @Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0002\b\nJ/\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u000F\u001A\u00020\fH\u0000¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\"\u0010\u0016\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00072\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0002J\u001F\u0010\u0019\u001A\u0004\u0018\u00010\u00072\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\u001BJ\'\u0010\u001C\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00072\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\b\u001DJ\u001D\u0010\u001E\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\u001FJ\'\u0010 \u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00072\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\b!J\u001D\u0010\"\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u0007H\u0000¢\u0006\u0002\b#J\u0014\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00120%2\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010&\u001A\u00020\'2\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006("}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalPair$Companion;", "", "<init>", "()V", "plan", "Lcom/TryJeanPc/goldenmouse/stretch/StretchGeometryPlan;", "e", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "factor", "", "plan$app", "matchesApplied", "", "a", "b", "projectionRequired", "matchesApplied$app", "closedCode", "", "r", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "closedCode$app", "sameDisplay", "restoration", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;", "restorationTarget", "current", "restorationTarget$app", "matchesRestored", "matchesRestored$app", "matchesRestoredState", "matchesRestoredState$app", "matchesOriginal", "matchesOriginal$app", "matchesOriginalState", "matchesOriginalState$app", "missingOriginal", "", "route", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPairRoute;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final boolean access$sameDisplay(Companion arg0, StretchOriginalEvidence arg1, StretchOriginalEvidence arg2, StretchRestorationIdentity arg3) {
            return arg0.sameDisplay(arg1, arg2, arg3);
        }

        public final String closedCode$app(StretchCandidateRecord arg1) {
            Intrinsics.checkNotNullParameter(arg1, "r");
            if(!arg1.getIntentions().isEmpty()) {
                return "RESTORE_VERIFIED_CLOSED";
            }

            return "ORIGINAL_VERIFIED_CLOSED";
        }

        public final boolean matchesApplied$app(StretchOriginalEvidence arg6, StretchOriginalEvidence arg7, int arg8, boolean arg9) {
            Intrinsics.checkNotNullParameter(arg6, "a");
            Intrinsics.checkNotNullParameter(arg7, "b");
            StretchGeometryPlan v8 = this.plan$app(arg6, arg8);
            if(v8 == null) {
                return 0;
            }

            StretchProjection v1 = v8.getProjection();
            StretchRestorationIdentity v3 = null;
            if((v1 instanceof Defined)) {
            }
            else {
                v1 = ((StretchProjection)v3);
            }

            if(v1 != null) {
                StretchFullProjection v1_1 = ((Defined)v1).getGeometry();
                if(v1_1 == null) {
                }
                else if((this.missingOriginal(arg7).isEmpty()) && (this.sameDisplay(arg6, arg7, v3)) && (Intrinsics.areEqual(arg7.getSnapshot().getOriginal().getLogicalSize().getValue(), v8.getTargetLogical())) && (Intrinsics.areEqual(arg7.getSizeOverride().getValue(), new StretchSize(v8.getTargetLogical().getHeight(), v8.getTargetLogical().getWidth()))) && arg7.getScaling().getValue() == StretchScaling.AUTO && (Intrinsics.areEqual(arg7.getSnapshot().getOriginal().getDensity(), arg6.getSnapshot().getOriginal().getDensity()))) {
                    if(arg9) {
                        StretchCompositorState v5 = arg7.getCompositor().getState();
                        if(v5 != null) {
                            StretchFullProjection v3_1 = v5.getProjection();
                        }

                        if(!Intrinsics.areEqual(v3_1, v1_1)) {
                            return 0;
                        }
                    }

                    return 1;
                }
            }

            return 0;
        }

        public static boolean matchesApplied$app$default(Companion arg0, StretchOriginalEvidence arg1, StretchOriginalEvidence arg2, int arg3, boolean arg4, int arg5, Object arg6) {
            return arg0.matchesApplied$app(arg1, arg2, arg3, true);
        }

        public final boolean matchesOriginal$app(StretchOriginalEvidence arg2, StretchOriginalEvidence arg3, StretchRestorationIdentity arg4) {
            Intrinsics.checkNotNullParameter(arg2, "a");
            Intrinsics.checkNotNullParameter(arg3, "b");
            if((this.sameDisplay(arg2, arg3, arg4)) && (this.matchesOriginalState$app(arg2, arg3))) {
                return 1;
            }

            return 0;
        }

        public final boolean matchesOriginalState$app(StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
            Intrinsics.checkNotNullParameter(arg2, "a");
            Intrinsics.checkNotNullParameter(arg3, "b");
            if((this.missingOriginal(arg2).isEmpty()) && (this.missingOriginal(arg3).isEmpty()) && (Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getPhysicalIdentity(), arg3.getSnapshot().getOriginal().getPhysicalIdentity())) && (Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getRotation(), arg3.getSnapshot().getOriginal().getRotation())) && (Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getReferenceSize(), arg3.getSnapshot().getOriginal().getReferenceSize())) && (Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getLogicalSize().getValue(), arg3.getSnapshot().getOriginal().getLogicalSize().getValue())) && (Intrinsics.areEqual(arg2.getSizeOverride(), arg3.getSizeOverride())) && (Intrinsics.areEqual(arg2.getScaling(), arg3.getScaling())) && (Intrinsics.areEqual(arg2.getCompositor().getState(), arg3.getCompositor().getState())) && (Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getDensity(), arg3.getSnapshot().getOriginal().getDensity()))) {
                return 1;
            }

            return 0;
        }

        public final boolean matchesRestored$app(StretchOriginalEvidence arg2, StretchOriginalEvidence arg3, StretchRestorationIdentity arg4) {
            Intrinsics.checkNotNullParameter(arg2, "a");
            Intrinsics.checkNotNullParameter(arg3, "b");
            StretchOriginalEvidence v1 = this.restorationTarget$app(arg2, arg3);
            if(v1 != null && (StretchPhysicalPair.Companion.matchesOriginal$app(v1, arg3, arg4))) {
                return 1;
            }

            return 0;
        }

        public final boolean matchesRestoredState$app(StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
            Intrinsics.checkNotNullParameter(arg2, "a");
            Intrinsics.checkNotNullParameter(arg3, "b");
            StretchOriginalEvidence v1 = this.restorationTarget$app(arg2, arg3);
            if(v1 != null && (StretchPhysicalPair.Companion.matchesOriginalState$app(v1, arg3))) {
                return 1;
            }

            return 0;
        }

        public final Set missingOriginal(StretchOriginalEvidence arg5) {
            Object v0_1;
            Intrinsics.checkNotNullParameter(arg5, "e");
            Set v4 = SetsKt.createSetBuilder();
            try {
                v0_1 = Result.constructor-impl(StretchRecoveryBinding.Companion.from(arg5));
            }
            catch(Throwable v0) {
                v0_1 = Result.constructor-impl(ResultKt.createFailure(v0));
            }

            if(Result.isFailure-impl(v0_1)) {
                v4.add("COMPOSITOR_OR_IDENTITY_INVALID");
            }

            if(!SetsKt.setOf(new RecoveryDatumState[]{RecoveryDatumState.KNOWN, RecoveryDatumState.ABSENT}).contains(arg5.getSizeOverride().getState())) {
                v4.add("OVERRIDE_UNKNOWN");
            }

            v0_1 = arg5.getSizeOverride().getValue();
            if(v0_1 != null) {
                int v1 = ((StretchSize)v0_1).getWidth();
                if(1 <= v1) {
                    int v3 = 0x8001;
                    if(v1 < v3) {
                        int v0_2 = ((StretchSize)v0_1).getHeight();
                        if(1 <= v0_2 && v0_2 < v3) {
                            goto label_44;
                        }
                    }
                }

                v4.add("OVERRIDE_INVALID");
            }

        label_44:
            if(arg5.getScaling().getState() != RecoveryDatumState.KNOWN) {
                v4.add("SCALING_UNKNOWN");
            }

            if(arg5.getSnapshot().getOriginal().getDensity().getState() != RecoveryDatumState.KNOWN) {
                v4.add("DENSITY_READBACK_UNAVAILABLE");
            }

            if(arg5.getSnapshot().getOriginal().getLogicalSize().getState() != RecoveryDatumState.KNOWN) {
                v4.add("LOGICAL_SIZE_UNKNOWN");
            }

            return SetsKt.build(v4);
        }

        public final StretchGeometryPlan plan$app(StretchOriginalEvidence arg9, int arg10) {
            Intrinsics.checkNotNullParameter(arg9, "e");
            StretchOriginalDisplayState v8 = arg9.getSnapshot().getOriginal();
            StretchCalculation v8_1 = new GoldenStretchGeometryCalculator().calculate(new StretchDisplaySnapshot(v8.getLogicalIdentity().getValue(), v8.getLogicalSize().getValue(), v8.getRotation().getValue(), v8.getReferenceSize().getValue(), null, 16, null), arg10);
            StretchGeometryPlan v10 = null;
            if((v8_1 instanceof Valid)) {
            }
            else {
                v8_1 = ((StretchCalculation)v10);
            }

            if(v8_1 != null) {
                return ((Valid)v8_1).getPlan();
            }

            return v10;
        }

        public final StretchOriginalEvidence restorationTarget$app(StretchOriginalEvidence arg33, StretchOriginalEvidence arg34) {
            StretchOriginalEvidence v0 = arg33;
            StretchOriginalEvidence v1 = arg34;
            Intrinsics.checkNotNullParameter(v0, "a");
            Intrinsics.checkNotNullParameter(v1, "current");
            StretchOriginalEvidence v3 = null;
            if(this.missingOriginal(arg33).isEmpty()) {
                if(!this.missingOriginal(v1).isEmpty()) {
                }
                else {
                    StretchOriginalDisplayState v4 = v0.getSnapshot().getOriginal();
                    Object v2 = v1.getSnapshot().getOriginal().getRotation().getValue();
                    if(v2 != null) {
                        int v2_1 = ((Integer)v2).intValue();
                        Object v5 = v4.getRotation().getValue();
                        if(v5 == null) {
                        }
                        else if(((Integer)v5).intValue() == v2_1) {
                            return v0;
                        }

                        StretchCompositorState v16 = v0.getCompositor().getState();
                        if(v16 == null) {
                            return v3;
                        }

                        StretchCompositorState v5_1 = v1.getCompositor().getState();
                        if(v5_1 == null) {
                            return v3;
                        }

                        if(v16.getInstallOrientation() != 0) {
                            return v3;
                        }

                        if(v5_1.getInstallOrientation() != 0) {
                            return v3;
                        }

                        if(v16.getDisplaySize().getWidth() >= v16.getDisplaySize().getHeight()) {
                            return v3;
                        }

                        if(!Intrinsics.areEqual(v16.getDisplaySize(), v5_1.getDisplaySize())) {
                            return v3;
                        }

                        if(!Intrinsics.areEqual(v4.getPhysicalIdentity(), v1.getSnapshot().getOriginal().getPhysicalIdentity())) {
                            return v3;
                        }

                        if(!Intrinsics.areEqual(v4.getLogicalIdentity(), v1.getSnapshot().getOriginal().getLogicalIdentity())) {
                            return v3;
                        }

                        if(!Intrinsics.areEqual(v4.getReferenceSize(), v1.getSnapshot().getOriginal().getReferenceSize())) {
                            return v3;
                        }

                        v5 = v4.getLogicalSize().getValue();
                        if(v5 == null) {
                            return v3;
                        }

                        Object v6 = v4.getRotation().getValue();
                        if(v6 == null) {
                            return v3;
                        }

                        int v6_1 = ((Integer)v6).intValue();
                        StretchSize v7 = Companion.restorationTarget$oriented(((StretchSize)v5), v6_1);
                        StretchSize v8 = Companion.restorationTarget$oriented(v16.getDisplaySize(), v6_1);
                        if(v16.getEffectiveOrientation() != v6_1) {
                            return v3;
                        }

                        if(!Intrinsics.areEqual(v16.getProjection(), new StretchFullProjection(new StretchRect(0, 0, ((StretchSize)v5).getWidth(), ((StretchSize)v5).getHeight()), new StretchRect(0, 0, v8.getWidth(), v8.getHeight()), v6_1))) {
                            return v3;
                        }

                        if(v0.getSizeOverride().getValue() != null && !Intrinsics.areEqual(v0.getSizeOverride().getValue(), v7)) {
                            return v3;
                        }

                        StretchSize v20 = Companion.restorationTarget$oriented(v7, v2_1);
                        StretchSize v3_1 = Companion.restorationTarget$oriented(v16.getDisplaySize(), v2_1);
                        return StretchOriginalEvidence.copy$default(v0, StretchRecoverySnapshot.copy$default(v0.getSnapshot(), 0, null, 0, null, 0, null, StretchOriginalDisplayState.copy$default(v4, null, null, RecoveryDatum.copy$default(v4.getLogicalSize(), null, null, v20, 3, null), null, null, null, v1.getSnapshot().getOriginal().getRotation(), null, null, 443, null), 0x3F, null), null, null, null, null, null, null, false, StretchCompositorRead.copy$default(v0.getCompositor(), null, StretchCompositorState.copy$default(v16, null, new StretchFullProjection(new StretchRect(0, 0, v20.getWidth(), v20.getHeight()), new StretchRect(0, 0, v3_1.getWidth(), v3_1.getHeight()), v2_1), null, v2_1, 0, 21, null), false, 5, null), 0xFE, null);
                    }
                }
            }

            return v3;
        }

        private static final StretchSize restorationTarget$oriented(StretchSize arg1, int arg2) {
            if(arg2 % 2 == 0) {
                return arg1;
            }

            return new StretchSize(arg1.getHeight(), arg1.getWidth());
        }

        public final StretchPairRoute route(StretchOriginalEvidence arg10) {
            Intrinsics.checkNotNullParameter(arg10, "e");
            if(!this.missingOriginal(arg10).isEmpty()) {
                return StretchPairRoute.UNAVAILABLE;
            }

            StretchOriginalDisplayState v9 = arg10.getSnapshot().getOriginal();
            StretchCalculation v9_1 = new GoldenStretchGeometryCalculator().calculate(new StretchDisplaySnapshot(v9.getLogicalIdentity().getValue(), v9.getLogicalSize().getValue(), v9.getRotation().getValue(), v9.getReferenceSize().getValue(), null, 16, null), 100);
            StretchProjection v1 = null;
            if((v9_1 instanceof Valid)) {
            }
            else {
                v9_1 = ((StretchCalculation)v1);
            }

            if(v9_1 != null) {
                StretchGeometryPlan v9_2 = ((Valid)v9_1).getPlan();
                if(v9_2 != null) {
                    StretchProjection v0 = v9_2.getProjection();
                    if((v0 instanceof Defined)) {
                        v1 = v0;
                    }

                    if(v1 != null) {
                        StretchFullProjection v0_1 = ((Defined)v1).getGeometry();
                        if(v0_1 == null) {
                        }
                        else {
                            StretchCompositorState v1_1 = arg10.getCompositor().getState();
                            if(v1_1 != null) {
                                if((Intrinsics.areEqual(v1_1.getProjection().getSource(), new StretchRect(0, 0, v9_2.getLogicalBase().getWidth(), v9_2.getLogicalBase().getHeight()))) && (Intrinsics.areEqual(v1_1.getProjection().getDestination(), v0_1.getDestination()))) {
                                    if(v1_1.getProjection().getRotation() != v0_1.getRotation()) {
                                    }
                                    else if(arg10.getSizeOverride().getState() == RecoveryDatumState.KNOWN) {
                                        return StretchPairRoute.PRO_CUSTOM_BASE;
                                    }
                                    else {
                                        return StretchPairRoute.CLASSIC_FULL;
                                    }
                                }

                                return StretchPairRoute.UNAVAILABLE;
                            }
                            else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                    }

                    return StretchPairRoute.UNAVAILABLE;
                }
            }

            return StretchPairRoute.UNAVAILABLE;
        }

        private final boolean sameDisplay(StretchOriginalEvidence arg2, StretchOriginalEvidence arg3, StretchRestorationIdentity arg4) {
            boolean v1_6;
            Integer v0_3;
            Integer v1_4;
            Object v0_2;
            String v1_2;
            Object v1_1;
            try {
                v1_1 = Result.constructor-impl(StretchRecoveryBinding.Companion.from(arg3));
            }
            catch(Throwable v1) {
                v1_1 = Result.constructor-impl(ResultKt.createFailure(v1));
            }

            if(!Result.isSuccess-impl(v1_1) || !Intrinsics.areEqual(arg2.getSnapshot().getSessionId(), arg3.getSnapshot().getSessionId())) {
            label_122:
                v1_6 = false;
            }
            else {
                if(arg4 != null) {
                    v1_2 = arg4.getAgentGeneration();
                    if(v1_2 == null) {
                        goto label_20;
                    }
                }
                else {
                label_20:
                    v1_2 = arg2.getAgentGeneration();
                }

                if(!Intrinsics.areEqual(v1_2, arg3.getAgentGeneration())) {
                    goto label_122;
                }

                if(arg4 != null) {
                    v1_2 = arg4.getOwnerGeneration();
                    if(v1_2 == null) {
                        goto label_27;
                    }
                }
                else {
                label_27:
                    v1_2 = arg2.getOwnerGeneration();
                }

                if(!Intrinsics.areEqual(v1_2, arg3.getOwnerGeneration())) {
                    goto label_122;
                }

                if(!Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getPhysicalIdentity().getValue(), arg3.getSnapshot().getOriginal().getPhysicalIdentity().getValue())) {
                    goto label_122;
                }

                if(!Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getRotation().getValue(), arg3.getSnapshot().getOriginal().getRotation().getValue())) {
                    goto label_122;
                }

                if(!Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getReferenceSize().getValue(), arg3.getSnapshot().getOriginal().getReferenceSize().getValue())) {
                    goto label_122;
                }

                StretchCompositorState v1_3 = arg2.getCompositor().getState();
                Object v4 = null;
                if(v1_3 != null) {
                    v1_2 = v1_3.getPhysicalIdentity();
                }
                else {
                    v1_1 = v4;
                }

                StretchCompositorState v0 = arg3.getCompositor().getState();
                if(v0 != null) {
                    String v0_1 = v0.getPhysicalIdentity();
                }
                else {
                    v0_2 = v4;
                }

                if(!Intrinsics.areEqual(v1_1, v0_2)) {
                    goto label_122;
                }

                v1_3 = arg2.getCompositor().getState();
                if(v1_3 != null) {
                    v1_4 = Integer.valueOf(v1_3.getInstallOrientation());
                }
                else {
                    v1_1 = v4;
                }

                v0 = arg3.getCompositor().getState();
                if(v0 != null) {
                    v0_3 = Integer.valueOf(v0.getInstallOrientation());
                }
                else {
                    v0_2 = v4;
                }

                if(!Intrinsics.areEqual(v1_4, v0_2)) {
                    goto label_122;
                }

                v1_3 = arg2.getCompositor().getState();
                if(v1_3 != null) {
                    v1_4 = Integer.valueOf(v1_3.getEffectiveOrientation());
                }
                else {
                    v1_1 = v4;
                }

                v0 = arg3.getCompositor().getState();
                if(v0 != null) {
                    v0_3 = Integer.valueOf(v0.getEffectiveOrientation());
                }
                else {
                    v0_2 = v4;
                }

                if(!Intrinsics.areEqual(v1_4, v0_2)) {
                    goto label_122;
                }

                v1_3 = arg2.getCompositor().getState();
                if(v1_3 != null) {
                    StretchSize v1_5 = v1_3.getDisplaySize();
                }
                else {
                    v1_1 = v4;
                }

                StretchCompositorState v2 = arg3.getCompositor().getState();
                if(v2 != null) {
                    StretchSize v4_1 = v2.getDisplaySize();
                }

                if(!Intrinsics.areEqual(v1_5, v4)) {
                    goto label_122;
                }

                v1_6 = true;
            }

            return v1_6;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final Function0 applyStillAllowed;
    private final StretchRecoveryCustodian custodian;
    private final StretchPhysicalIo io;
    private final StretchPhysicalJournal journal;
    private final int ownerUid;
    private final StretchReadbackWait readbackWait;
    private final StretchRestorationIdentity restoration;

    static {
        StretchPhysicalPair.Companion = new Companion(null);
        StretchPhysicalPair.$stable = 8;
    }

    public StretchPhysicalPair(StretchPhysicalJournal arg7, StretchPhysicalIo arg8, int arg9, StretchRestorationIdentity arg10, Function0 arg11, int arg12, DefaultConstructorMarker arg13) {
        StretchPhysicalPair$$ExternalSyntheticLambda0 v11;
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        StretchRestorationIdentity v4 = arg10;
        if((arg12 & 16) != 0) {
            v11 = new StretchPhysicalPair$$ExternalSyntheticLambda0();
        }

        this(arg7, arg8, arg9, v4, ((Function0)v11));
    }

    public StretchPhysicalPair(StretchPhysicalJournal arg2, StretchPhysicalIo arg3, int arg4, StretchRestorationIdentity arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg2, "journal");
        Intrinsics.checkNotNullParameter(arg3, "io");
        Intrinsics.checkNotNullParameter(arg6, "applyStillAllowed");
        super();
        this.journal = arg2;
        this.io = arg3;
        this.ownerUid = arg4;
        this.restoration = arg5;
        this.applyStillAllowed = arg6;
        this.custodian = new StretchRecoveryCustodian(arg2);
        this.readbackWait = new StretchReadbackWait(null, null, 3, null);
    }

    static final boolean _init_$lambda$0() {
        return 1;
    }

    public static final StretchOriginalEvidence access$apply$readTimed(StretchPhysicalPair arg0, LongRef arg1) {
        return StretchPhysicalPair.apply$readTimed(arg0, arg1);
    }

    public final StretchPairResult apply(StretchRecoveryBinding arg25, boolean arg26, String arg27, long arg28, int arg30) {
        Exception v26;
        StretchPairResult v10_2;
        StretchPairResult v6;
        long v22;
        StretchPairResult v1_1;
        StretchPairResult v9;
        StretchCompositorState v4_1;
        StretchFullProjection v5_1;
        StretchGeometryPlan v3_3;
        StretchOriginalEvidence v0_2;
        StretchPairResult v8;
        StretchCandidateRecord v7;
        StretchPhysicalPair v1 = this;
        String v0 = arg27;
        int v2 = arg30;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg25, "binding");
            Intrinsics.checkNotNullParameter(v0, "bootId");
            v7 = this.record(arg25);
            if(v7 != null) {
                goto label_23;
            }

            v8 = new StretchPairResult("JOURNAL_OR_SESSION_INVALID", null, null, 0, 0, 0, 62, null);
        }
        catch(Throwable v0_1) {
            goto label_465;
        }

        __monitor_exit(this);
        return v8;
        try {
        label_23:
            if(v1.restoration == null) {
                goto label_37;
            }

            v8 = new StretchPairResult("RESTORE_ONLY_SESSION", null, null, 0, 0, 0, 62, null);
        }
        catch(Throwable v0_1) {
            goto label_465;
        }

        __monitor_exit(this);
        return v8;
    label_37:
        if(101 <= v2 && v2 < 200) {
            if(arg26) {
                try {
                    if(!v1.io.getCanApply()) {
                    }
                    else {
                        if(v7.getPhase() == CandidatePhase.CAPTURED) {
                            if(!v7.getIntentions().isEmpty()) {
                            }
                            else if(v1.custodian.observe(CustodyEvent.POLL, v0, arg28).getCode() != CustodyCode.OBSERVING) {
                                v8 = new StretchPairResult("RECOVERY_LEASE_INVALID", null, null, 0, 0, 0, 62, null);
                                goto label_70;
                            }
                            else {
                                goto label_72;
                            }
                        }

                        goto label_428;
                    }

                    goto label_440;
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

            label_70:
                __monitor_exit(this);
                return v8;
                try {
                label_72:
                    v0_2 = v7.getEvidence();
                    Companion v3 = StretchPhysicalPair.Companion;
                    if(!v3.missingOriginal(v0_2).isEmpty()) {
                        v8 = new StretchPairResult("ORIGINAL_INCOMPLETE", null, null, 0, 0, 0, 62, null);
                    }
                    else {
                        goto label_89;
                    }
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

                __monitor_exit(this);
                return v8;
                try {
                label_89:
                    if(v3.route(v0_2) == StretchPairRoute.UNAVAILABLE) {
                        v8 = new StretchPairResult("ORIGINAL_GEOMETRY_UNSUPPORTED", null, null, 0, 0, 0, 62, null);
                    }
                    else {
                        goto label_104;
                    }
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

                __monitor_exit(this);
                return v8;
                try {
                label_104:
                    StretchOriginalDisplayState v3_1 = v0_2.getSnapshot().getOriginal();
                    StretchCalculation v3_2 = new GoldenStretchGeometryCalculator().calculate(new StretchDisplaySnapshot(v3_1.getLogicalIdentity().getValue(), v3_1.getLogicalSize().getValue(), v3_1.getRotation().getValue(), v3_1.getReferenceSize().getValue(), null, 16, null), v2);
                    StretchProjection v5 = null;
                    if((v3_2 instanceof Valid)) {
                    }
                    else {
                        v3_2 = ((StretchCalculation)v5);
                    }

                    if(v3_2 != null) {
                        v3_3 = ((Valid)v3_2).getPlan();
                        if(v3_3 != null) {
                            StretchProjection v4 = v3_3.getProjection();
                            if((v4 instanceof Defined)) {
                                v5 = v4;
                            }

                            if(v5 != null) {
                                v5_1 = ((Defined)v5).getGeometry();
                                if(v5_1 == null) {
                                }
                                else {
                                    v4_1 = v0_2.getCompositor().getState();
                                    if(v4_1 != null) {
                                        try {
                                            if(!v1.sameOriginal(v0_2, v1.io.read())) {
                                                v9 = new StretchPairResult("ORIGINAL_CHANGED", null, null, 0, 0, 0, 62, null);
                                                goto label_159;
                                            }
                                            else {
                                                goto label_161;
                                            }
                                        }
                                        catch(Exception v0_3) {
                                            try {
                                                v1_1 = new StretchPairResult("PRECHECK_FAILED", v0_3.getClass().getSimpleName(), null, 0, 0, 0, 60, null);
                                            }
                                            catch(Throwable v0_1) {
                                                goto label_465;
                                            }

                                            __monitor_exit(this);
                                            return v1_1;
                                        }
                                    }
                                    else {
                                        goto label_399;
                                    }
                                }
                            }

                            goto label_404;
                        }
                    }

                    goto label_416;
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

            label_159:
                __monitor_exit(this);
                return v9;
                try {
                label_161:
                    if(!v1.applyStillAllowed.invoke().booleanValue()) {
                        v9 = new StretchPairResult("APPLY_REVOKED", null, null, 0, 0, 0, 62, null);
                    }
                    else {
                        goto label_177;
                    }
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

                __monitor_exit(this);
                return v9;
                try {
                label_177:
                    v22 = 1;
                    long v8_1 = v7.getRevision() + v22;
                    CandidatePhase v12 = CandidatePhase.INTENT_RESERVED;
                    EnumEntries v10 = RecoveryStep.getEntries();
                    ArrayList v11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v10), 10));
                    Iterator v10_1 = ((Iterable)v10).iterator();
                    while(v10_1.hasNext()) {
                        Object v13 = v10_1.next();
                        ((Collection)v11).add(new CandidateIntent("apply-" + v2 + "-" + ((RecoveryStep)v13).name(), ((RecoveryStep)v13)));
                        v7 = v7;
                    }

                    if(!v1.journal.commit(StretchCandidateRecord.copy$default(v7, v8_1, 0, null, v12, v11, null, null, null, null, null, null, 2022, null), v7.getRevision())) {
                        v6 = new StretchPairResult("INTENTION_NOT_DURABLE", null, null, 0, 0, 0, 62, null);
                    }
                    else {
                        goto label_237;
                    }
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

                __monitor_exit(this);
                return v6;
                try {
                label_237:
                    LongRef v6_1 = new LongRef();
                    LongRef v7_1 = new LongRef();
                    try {
                        if(v1.applyStillAllowed.invoke().booleanValue()) {
                            StretchPhysicalPair.apply$writeTimed(v6_1, new StretchPhysicalPair$$ExternalSyntheticLambda3(v1));
                            StretchSize v2_1 = new StretchSize(v3_3.getTargetLogical().getHeight(), v3_3.getTargetLogical().getWidth());
                            if(v1.applyStillAllowed.invoke().booleanValue()) {
                                StretchPhysicalPair.apply$writeTimed(v6_1, new StretchPhysicalPair$$ExternalSyntheticLambda4(v1, v2_1));
                                v1.readbackWait.await(new StretchPhysicalPair$apply$3(v1, v7_1), new StretchPhysicalPair$$ExternalSyntheticLambda5(v1, v0_2, v3_3, v2_1), v1.applyStillAllowed, new StretchPhysicalPair$$ExternalSyntheticLambda6(v1, v0_2));
                                if(v1.applyStillAllowed.invoke().booleanValue()) {
                                    StretchPhysicalPair.apply$writeTimed(v6_1, new StretchPhysicalPair$$ExternalSyntheticLambda7(v1, v4_1, v5_1));
                                    StretchOriginalEvidence v13_1 = v1.readbackWait.await(new StretchPhysicalPair$apply$after$1(v1, v7_1), new StretchPhysicalPair$$ExternalSyntheticLambda8(v1, v0_2, v3_3, v2_1, v5_1), v1.applyStillAllowed, new StretchPhysicalPair$$ExternalSyntheticLambda9(v1, v0_2));
                                    if(v1.applyStillAllowed.invoke().booleanValue()) {
                                        v10_2 = new StretchPairResult("APPLY_READBACK_MATCHED_UNACCREDITED", null, v13_1, TimeUnit.NANOSECONDS.toMillis(v6_1.element), v1.io.getProjectionApplyMillis(), TimeUnit.NANOSECONDS.toMillis(v7_1.element), 2, null);
                                        goto label_383;
                                    }
                                    else {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                }
                                else {
                                    throw new IllegalStateException("Check failed.");
                                }
                            }
                            else {
                                throw new IllegalStateException("Check failed.");
                            }
                        }
                        else {
                            throw new IllegalStateException("Check failed.");
                        }

                        goto label_404;
                    }
                    catch(Exception v0_3) {
                        try {
                            StretchCandidateRecord v2_2 = this.record(arg25);
                            if(v2_2 != null) {
                                v26 = v0_3;
                                v1.journal.commit(StretchCandidateRecord.copy$default(v2_2, v2_2.getRevision() + v22, 0, null, CandidatePhase.EXECUTION_UNKNOWN, null, null, null, null, null, null, null, 0x7F6, null), v2_2.getRevision());
                            }
                            else {
                                v26 = v0_3;
                            }

                            v10_2 = new StretchPairResult("APPLY_FAILED_" + StretchPhysicalPair.restore$default(v1, arg25, true, false, 4, null).getCode(), StretchCompatibilityKt.stretchFailureCode(v26), null, 0, 0, 0, 60, null);
                        }
                        catch(Throwable v0_1) {
                            goto label_465;
                        }
                    }
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

            label_383:
                __monitor_exit(this);
                return v10_2;
                try {
                label_399:
                    throw new IllegalArgumentException("Required value was null.".toString());
                label_404:
                    v1_1 = new StretchPairResult("GEOMETRY_UNSUPPORTED", null, null, 0, 0, 0, 62, null);
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

                __monitor_exit(this);
                return v1_1;
                try {
                label_416:
                    v1_1 = new StretchPairResult("GEOMETRY_UNSUPPORTED", null, null, 0, 0, 0, 62, null);
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

                __monitor_exit(this);
                return v1_1;
                try {
                label_428:
                    v1_1 = new StretchPairResult("SESSION_BUSY", null, null, 0, 0, 0, 62, null);
                }
                catch(Throwable v0_1) {
                    goto label_465;
                }

                __monitor_exit(this);
                return v1_1;
            }

            try {
            label_440:
                v1_1 = new StretchPairResult("EMERGENCY_RECOVERY_UNPROVEN", null, null, 0, 0, 0, 62, null);
            }
            catch(Throwable v0_1) {
                goto label_465;
            }

            __monitor_exit(this);
            return v1_1;
        }

        try {
            v1_1 = new StretchPairResult("EXPERIMENT_FACTOR_REJECTED", null, null, 0, 0, 0, 62, null);
        }
        catch(Throwable v0_1) {
            try {
            label_465:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_465;
            }

            throw v0_1;
        }

        __monitor_exit(this);
        return v1_1;
    }

    public static StretchPairResult apply$default(StretchPhysicalPair arg7, StretchRecoveryBinding arg8, boolean arg9, String arg10, long arg11, int arg13, int arg14, Object arg15) {
        if((arg14 & 16) != 0) {
            arg13 = 105;
        }

        return arg7.apply(arg8, arg9, arg10, arg11, arg13);
    }

    static final Unit apply$lambda$3(StretchPhysicalPair arg1) {
        arg1.io.scaling(StretchScaling.AUTO);
        return Unit.INSTANCE;
    }

    static final Unit apply$lambda$4(StretchPhysicalPair arg0, StretchSize arg1) {
        arg0.io.size(arg1);
        return Unit.INSTANCE;
    }

    static final boolean apply$lambda$5(StretchPhysicalPair arg1, StretchOriginalEvidence arg2, StretchGeometryPlan arg3, StretchSize arg4, StretchOriginalEvidence arg5) {
        Intrinsics.checkNotNullParameter(arg5, "resized");
        if((arg1.sameDisplay(arg2, arg5)) && (Intrinsics.areEqual(arg5.getSnapshot().getOriginal().getLogicalSize().getValue(), arg3.getTargetLogical())) && (Intrinsics.areEqual(arg5.getSizeOverride().getValue(), arg4)) && arg5.getScaling().getValue() == StretchScaling.AUTO && (Intrinsics.areEqual(arg5.getSnapshot().getOriginal().getDensity().getValue(), arg2.getSnapshot().getOriginal().getDensity().getValue()))) {
            return 1;
        }

        return 0;
    }

    static final boolean apply$lambda$6(StretchPhysicalPair arg1, StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "it");
        return arg1.samePhysicalTarget(arg2, arg3);
    }

    static final Unit apply$lambda$7(StretchPhysicalPair arg0, StretchCompositorState arg1, StretchFullProjection arg2) {
        arg0.io.projection(arg1.getPhysicalIdentity(), arg2);
        return Unit.INSTANCE;
    }

    static final boolean apply$lambda$8(StretchPhysicalPair arg1, StretchOriginalEvidence arg2, StretchGeometryPlan arg3, StretchSize arg4, StretchFullProjection arg5, StretchOriginalEvidence arg6) {
        Intrinsics.checkNotNullParameter(arg6, "after");
        if((arg1.sameDisplay(arg2, arg6)) && (Intrinsics.areEqual(arg6.getSnapshot().getOriginal().getLogicalSize().getValue(), arg3.getTargetLogical())) && (Intrinsics.areEqual(arg6.getSizeOverride().getValue(), arg4)) && arg6.getScaling().getValue() == StretchScaling.AUTO && (Intrinsics.areEqual(arg6.getSnapshot().getOriginal().getDensity().getValue(), arg2.getSnapshot().getOriginal().getDensity().getValue()))) {
            StretchCompositorState v1 = arg6.getCompositor().getState();
            if(v1 != null) {
                StretchFullProjection v1_1 = v1.getProjection();
            }
            else {
                Object v1_2 = null;
            }

            if(!Intrinsics.areEqual(v1_1, arg5)) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    static final boolean apply$lambda$9(StretchPhysicalPair arg1, StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "it");
        return arg1.samePhysicalTarget(arg2, arg3);
    }

    private static final StretchOriginalEvidence apply$readTimed(StretchPhysicalPair arg6, LongRef arg7) {
        StretchOriginalEvidence v6_1;
        long v0 = System.nanoTime();
        try {
            v6_1 = arg6.io.read();
        }
        catch(Throwable v6) {
            arg7.element += System.nanoTime() - v0;
            throw v6;
        }

        arg7.element += System.nanoTime() - v0;
        return v6_1;
    }

    private static final void apply$writeTimed(LongRef arg6, Function0 arg7) {
        long v0 = System.nanoTime();
        try {
            arg7.invoke();
        }
        catch(Throwable v7) {
            arg6.element += System.nanoTime() - v0;
            throw v7;
        }

        arg6.element += System.nanoTime() - v0;
    }

    public final StretchPairResult closeUnmutatedOriginal(StretchRecoveryBinding arg19, String arg20, long arg21) {
        StretchPairResult v2_2;
        StretchRecoveryCustody v2_1;
        StretchPairResult v4;
        StretchCandidateRecord v3;
        StretchPhysicalPair v1 = this;
        String v0 = arg20;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg19, "binding");
            Intrinsics.checkNotNullParameter(v0, "bootId");
            v3 = this.record(arg19);
            if(v3 != null) {
                goto label_22;
            }

            v4 = new StretchPairResult("JOURNAL_OR_SESSION_INVALID", null, null, 0, 0, 0, 62, null);
        }
        catch(Throwable v0_1) {
            goto label_188;
        }

        __monitor_exit(this);
        return v4;
        try {
        label_22:
            StretchRestorationIdentity v2 = v1.restoration;
            if(v2 != null && !Intrinsics.areEqual(v2.getAgentGeneration(), v3.getEvidence().getAgentGeneration())) {
                if(v1.io.getCanApply()) {
                }
                else {
                    if(v3.getPhase() == CandidatePhase.CAPTURED && (v3.getIntentions().isEmpty()) && v3.getExecutorProbe() == CandidateExecutorProbe.NONE && v3.getReadback() == null) {
                        if(v3.getRestorationIdentity() != null) {
                        }
                        else {
                            v2_1 = v3.getCustody();
                            if(v2_1 == null) {
                                v4 = new StretchPairResult("JOURNAL_LEASE_MISSING", null, null, 0, 0, 0, 62, null);
                                goto label_59;
                            }
                            else {
                                goto label_61;
                            }
                        }
                    }

                    goto label_163;
                }
            }

            goto label_175;
        }
        catch(Throwable v0_1) {
            goto label_188;
        }

    label_59:
        __monitor_exit(this);
        return v4;
        try {
        label_61:
            if(Intrinsics.areEqual(v0, v2_1.getBootId())) {
                long v4_1 = v2_1.getStartedElapsedMillis();
                if(arg21 < v2_1.getExpiresElapsedMillis() && v4_1 <= arg21) {
                    v4 = new StretchPairResult("JOURNAL_LEASE_ACTIVE", null, null, 0, 0, 0, 62, null);
                    goto label_78;
                }
            }

            goto label_80;
        }
        catch(Throwable v0_1) {
            goto label_188;
        }

    label_78:
        __monitor_exit(this);
        return v4;
        try {
        label_80:
            if(StretchPhysicalPair.Companion.missingOriginal(v3.getEvidence()).isEmpty()) {
                goto label_97;
            }

            v4 = new StretchPairResult("ORIGINAL_INCOMPLETE", null, null, 0, 0, 0, 62, null);
        }
        catch(Throwable v0_1) {
            goto label_188;
        }

        __monitor_exit(this);
        return v4;
        try {
        label_97:
            if(v1.sameOriginal(v3.getEvidence(), v1.io.read())) {
                goto label_114;
            }

            v4 = new StretchPairResult("ORIGINAL_CHANGED", null, null, 0, 0, 0, 62, null);
        }
        catch(Exception v0_2) {
            goto label_149;
        }
        catch(Throwable v0_1) {
            goto label_188;
        }

        __monitor_exit(this);
        return v4;
        try {
        label_114:
            v0 = v1.journal.commit(StretchCandidateRecord.copy$default(v3, Math.addExact(v3.getRevision(), 1), 0, null, CandidatePhase.CLOSED_WITHOUT_MUTATION, null, null, null, null, null, null, null, 0x7F6, null), v3.getRevision()) ? "NO_MUTATION_CLOSED" : "CLOSE_NOT_DURABLE";
            v4 = new StretchPairResult(v0, null, null, 0, 0, 0, 62, null);
            goto label_161;
        }
        catch(Throwable v0_1) {
        }
        catch(Exception v0_2) {
            try {
            label_149:
                v4 = new StretchPairResult("ORIGINAL_READ_FAILED", v0_2.getClass().getSimpleName(), null, 0, 0, 0, 60, null);
            }
            catch(Throwable v0_1) {
                goto label_188;
            }

        label_161:
            __monitor_exit(this);
            return v4;
            try {
            label_163:
                v2_2 = new StretchPairResult("PHYSICAL_RECOVERY_PENDING", null, null, 0, 0, 0, 62, null);
            }
            catch(Throwable v0_1) {
                goto label_188;
            }

            __monitor_exit(this);
            return v2_2;
            try {
            label_175:
                v2_2 = new StretchPairResult("READ_ONLY_RECOVERY_REQUIRED", null, null, 0, 0, 0, 62, null);
            }
            catch(Throwable v0_1) {
                try {
                label_188:
                    __monitor_exit(this);
                }
                catch(Throwable v0_1) {
                    goto label_188;
                }

                throw v0_1;
            }
        }

        __monitor_exit(this);
        return v2_2;
    }

    private final StretchCandidateRecord record(StretchRecoveryBinding arg4) {
        CandidateJournalRead v0 = this.journal.load();
        StretchCandidateRecord v2 = null;
        if((v0 instanceof Present)) {
        }
        else {
            v0 = ((CandidateJournalRead)v2);
        }

        if(v0 != null) {
            StretchCandidateRecord v0_1 = ((Present)v0).getRecord();
            if(v0_1 != null && (arg4.matches(v0_1, this.ownerUid))) {
                return v0_1;
            }
        }

        return v2;
    }

    public final StretchPairResult recoverOnLoss(StretchRecoveryBinding arg17, CustodyEvent arg18, String arg19, long arg20) {
        StretchPairResult v0_3;
        StretchPairResult v4;
        StretchPhysicalPair v1 = this;
        CustodyEvent v0 = arg18;
        String v2 = arg19;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg17, "binding");
            Intrinsics.checkNotNullParameter(v0, "event");
            Intrinsics.checkNotNullParameter(v2, "bootId");
            if(this.record(arg17) != null) {
                goto label_25;
            }

            v4 = new StretchPairResult("JOURNAL_OR_SESSION_INVALID", null, null, 0, 0, 0, 62, null);
        }
        catch(Throwable v0_1) {
            goto label_53;
        }

        __monitor_exit(this);
        return v4;
        try {
        label_25:
            StretchCustodyResult v0_2 = v1.custodian.observe(v0, v2, arg20);
            v0_3 = v0_2.getCode() == CustodyCode.RESTORE_PENDING ? StretchPhysicalPair.restore$default(v1, arg17, true, false, 4, null) : new StretchPairResult(v0_2.getCode().name(), null, null, 0, 0, 0, 62, null);
        }
        catch(Throwable v0_1) {
            try {
            label_53:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_53;
            }

            throw v0_1;
        }

        __monitor_exit(this);
        return v0_3;
    }

    public final StretchPairResult restore(StretchRecoveryBinding arg22, boolean arg23, boolean arg24) {
        StretchOriginalEvidence v9;
        CandidatePhase v7;
        long v5_2;
        String v0_3;
        StretchPhysicalIo v5_1;
        StretchPairResult v6;
        StretchOriginalEvidence v4_2;
        StretchOriginalEvidence v3_4;
        StretchCandidateRecord v3_3;
        StretchPairResult v5;
        StretchPairResult v2_1;
        StretchPairResult v4;
        Companion v0_1;
        StretchPairResult v3;
        StretchCandidateRecord v2;
        StretchPhysicalPair v1 = this;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg22, "binding");
            v2 = this.record(arg22);
            if(v2 != null) {
                goto label_19;
            }

            v3 = new StretchPairResult("JOURNAL_OR_SESSION_INVALID", null, null, 0, 0, 0, 62, null);
        }
        catch(Throwable v0) {
            goto label_423;
        }

        __monitor_exit(this);
        return v3;
    label_19:
        if(arg23) {
            try {
                if(!v1.io.getCanRestore()) {
                }
                else {
                    v0_1 = StretchPhysicalPair.Companion;
                    if(!v0_1.missingOriginal(v2.getEvidence()).isEmpty()) {
                        v4 = new StretchPairResult("ORIGINAL_INCOMPLETE", null, null, 0, 0, 0, 62, null);
                        goto label_39;
                    }
                    else {
                        goto label_41;
                    }
                }

                goto label_410;
            }
            catch(Throwable v0) {
                goto label_423;
            }

        label_39:
            __monitor_exit(this);
            return v4;
            try {
            label_41:
                if(v2.getPhase() == CandidatePhase.RESTORED_VERIFIED) {
                    try {
                        if(v0_1.matchesRestored$app(v2.getEvidence(), v1.io.read(), v1.restoration)) {
                            v4 = new StretchPairResult(v0_1.closedCode$app(v2), null, null, 0, 0, 0, 62, null);
                            goto label_85;
                        }
                        else {
                            v2_1 = new StretchPairResult("CLOSED_ORIGINAL_CHANGED", null, null, 0, 0, 0, 62, null);
                            goto label_84;
                        }
                    }
                    catch(Exception v0_2) {
                        try {
                            v2_1 = new StretchPairResult("ORIGINAL_READ_FAILED", v0_2.getClass().getSimpleName(), null, 0, 0, 0, 60, null);
                            goto label_84;
                        }
                        catch(Throwable v0) {
                            goto label_423;
                        }
                    }
                }
                else {
                    goto label_87;
                }

                goto label_410;
            }
            catch(Throwable v0) {
                goto label_423;
            }

        label_84:
            v4 = v2_1;
        label_85:
            __monitor_exit(this);
            return v4;
            try {
            label_87:
                if((v2.getIntentions().isEmpty()) && v2.getExecutorProbe() == CandidateExecutorProbe.NONE) {
                    v5 = new StretchPairResult("NO_MUTATION_REQUESTED", null, null, 0, 0, 0, 62, null);
                    goto label_103;
                }

                goto label_105;
            }
            catch(Throwable v0) {
                goto label_423;
            }

        label_103:
            __monitor_exit(this);
            return v5;
        label_105:
            int v3_1 = 3;
            try {
                CandidatePhase[] v3_2 = new CandidatePhase[v3_1];
                v3_2[0] = CandidatePhase.RESTORE_PENDING;
                v3_2[1] = CandidatePhase.RESTORE_PARTIAL;
                v3_2[2] = CandidatePhase.RESTORE_UNVERIFIED;
                long v4_1 = 1;
                if(!SetsKt.setOf(((Object[])v3_2)).contains(v2.getPhase())) {
                    v3_3 = StretchCandidateRecord.copy$default(v2, v2.getRevision() + v4_1, 0, null, CandidatePhase.RESTORE_PENDING, null, null, null, null, null, null, null, 0x7F6, null);
                    if(!v1.journal.commit(v3_3, v2.getRevision())) {
                        v4 = new StretchPairResult("RESTORE_INTENTION_NOT_DURABLE", null, null, 0, 0, 0, 62, null);
                        goto label_160;
                    }
                    else {
                        goto label_162;
                    }
                }

                goto label_163;
            }
            catch(Throwable v0) {
                goto label_423;
            }

        label_160:
            __monitor_exit(this);
            return v4;
        label_162:
            v2 = v3_3;
            try {
            label_163:
                v3_4 = v2.getEvidence();
                v4_2 = v1.io.read();
                if(v0_1.missingOriginal(v4_2).isEmpty()) {
                    goto label_181;
                }

                v6 = new StretchPairResult("CURRENT_STATE_INCOMPLETE", null, null, 0, 0, 0, 62, null);
            }
            catch(Throwable v0) {
                goto label_423;
            }
            catch(Exception v0_2) {
                goto label_398;
            }

            __monitor_exit(this);
            return v6;
            try {
            label_181:
                v3_4 = v0_1.restorationTarget$app(v3_4, v4_2);
                if(v3_4 != null) {
                    goto label_195;
                }

                v5 = new StretchPairResult("DISPLAY_TARGET_CHANGED", null, null, 0, 0, 0, 62, null);
            }
            catch(Throwable v0) {
                goto label_423;
            }
            catch(Exception v0_2) {
                goto label_398;
            }

            __monitor_exit(this);
            return v5;
            try {
            label_195:
                if(v1.sameDisplay(v3_4, v4_2)) {
                    goto label_209;
                }

                v6 = new StretchPairResult("DISPLAY_TARGET_CHANGED", null, null, 0, 0, 0, 62, null);
            }
            catch(Throwable v0) {
                goto label_423;
            }
            catch(Exception v0_2) {
                goto label_398;
            }

            __monitor_exit(this);
            return v6;
            try {
            label_209:
                if(!v1.sameOriginal(v3_4, v4_2)) {
                    v1.io.scaling(StretchScaling.AUTO);
                    v1.io.size(v3_4.getSizeOverride().getValue());
                    v5_1 = v1.io;
                    Object v6_1 = v3_4.getScaling().getValue();
                    if(v6_1 != null) {
                        v5_1.scaling(((StretchScaling)v6_1));
                        goto label_223;
                    }
                    else {
                        goto label_264;
                    }
                }

                goto label_269;
            }
            catch(Exception v0_2) {
                goto label_398;
            }

            try {
            label_223:
                StretchReadbackWait.await$default(v1.readbackWait, new StretchPhysicalPair$restore$1(v1.io), new StretchPhysicalPair$$ExternalSyntheticLambda10(v1, v3_4), null, new StretchPhysicalPair$$ExternalSyntheticLambda11(v1, v3_4), 4, null);
            }
            catch(Exception v0_2) {
                try {
                    v2_1 = new StretchPairResult("WINDOW_RESTORE_READBACK_MISMATCH", StretchCompatibilityKt.stretchFailureCode(((Throwable)v0_2)), null, 0, 0, 0, 60, null);
                }
                catch(Exception v0_2) {
                    goto label_398;
                }

                __monitor_exit(this);
                return v2_1;
            }

            try {
                v5_1 = v1.io;
                StretchCompositorState v6_2 = v3_4.getCompositor().getState();
                if(v6_2 != null) {
                    v5_1.projection(v6_2.getPhysicalIdentity(), v3_4.getCompositor().getState().getProjection());
                }
                else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                label_264:
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            catch(Exception v0_2) {
                goto label_398;
            }

            try {
            label_269:
                v4_2 = StretchReadbackWait.await$default(v1.readbackWait, new StretchPhysicalPair$restore$after$1(v1.io), new StretchPhysicalPair$$ExternalSyntheticLambda1(v1, v3_4), null, new StretchPhysicalPair$$ExternalSyntheticLambda2(v1, v3_4), 4, null);
                if(!arg24) {
                    goto label_328;
                }
            }
            catch(Exception v0_2) {
                try {
                    String v6_3 = "FULL_RESTORE_READBACK_MISMATCH";
                    v0_3 = !Intrinsics.areEqual(v3_4.getSnapshot().getOriginal().getDensity(), v4_2.getSnapshot().getOriginal().getDensity()) ? "DENSITY_CHANGED" : StretchCompatibilityKt.stretchFailureCode(((Throwable)v0_2));
                    v5 = new StretchPairResult(v6_3, v0_3, null, 0, 0, 0, 60, null);
                }
                catch(Throwable v0) {
                    goto label_423;
                }
                catch(Exception v0_2) {
                    goto label_398;
                }

                __monitor_exit(this);
                return v5;
            }

            try {
                v5_2 = Math.addExact(v2.getRevision(), 1);
                v7 = CandidatePhase.RESTORED_VERIFIED;
                StretchOriginalEvidence v8 = v2.getReadback();
                v9 = v8 == null ? v4_2 : v8;
                StretchRestorationIdentity v4_3 = v1.restoration;
                if(v4_3 == null) {
                    v4_3 = new StretchRestorationIdentity(v3_4.getAgentGeneration(), v3_4.getOwnerGeneration());
                }

                v3_3 = StretchCandidateRecord.copy$default(v2, v5_2, 0, null, v7, null, v9, null, null, null, v4_3, null, 0x5D6, null);
                v0_3 = v1.journal.commit(v3_3, v2.getRevision()) ? v0_1.closedCode$app(v3_3) : "RESTORE_CLOSE_NOT_DURABLE";
                v4 = new StretchPairResult(v0_3, null, null, 0, 0, 0, 62, null);
            }
            catch(Exception v0_2) {
                goto label_398;
            }

            __monitor_exit(this);
            return v4;
        label_328:
            long v12 = 1;
            try {
                if(v2.getPhase() != CandidatePhase.RESTORE_UNVERIFIED || v2.getReadback() == null) {
                    StretchPhysicalJournal v0_4 = v1.journal;
                    v5_2 = v2.getRevision() + v12;
                    v7 = CandidatePhase.RESTORE_UNVERIFIED;
                    v3_4 = v2.getReadback();
                    v9 = v3_4 == null ? v4_2 : v3_4;
                    if(!v0_4.commit(StretchCandidateRecord.copy$default(v2, v5_2, 0, null, v7, null, v9, null, null, null, null, null, 2006, null), v2.getRevision())) {
                        goto label_369;
                    }
                }

                v2_1 = new StretchPairResult("RESTORE_READBACK_MATCHED_UNACCREDITED", null, null, 0, 0, 0, 62, null);
                goto label_408;
            label_369:
                throw new IllegalStateException("Check failed.");
            }
            catch(Throwable v0) {
            }
            catch(Exception v0_2) {
                try {
                label_398:
                    v2_1 = new StretchPairResult("RESTORE_PENDING", StretchCompatibilityKt.stretchFailureCode(((Throwable)v0_2)), null, 0, 0, 0, 60, null);
                }
                catch(Throwable v0) {
                    goto label_423;
                }

            label_408:
                __monitor_exit(this);
                return v2_1;
                try {
                label_410:
                    v2_1 = new StretchPairResult("EMERGENCY_RECOVERY_UNPROVEN", null, null, 0, 0, 0, 62, null);
                    goto label_420;
                }
                catch(Throwable v0) {
                    try {
                    label_423:
                        __monitor_exit(this);
                    }
                    catch(Throwable v0) {
                        goto label_423;
                    }

                    throw v0;
                }
            }
        }

        goto label_410;
    label_420:
        __monitor_exit(this);
        return v2_1;
    }

    public static StretchPairResult restore$default(StretchPhysicalPair arg0, StretchRecoveryBinding arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        return arg0.restore(arg1, arg2, false);
    }

    static final boolean restore$lambda$10(StretchPhysicalPair arg1, StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "it");
        if((arg1.sameDisplay(arg2, arg3)) && (arg1.sameWindowState(arg2, arg3))) {
            return 1;
        }

        return 0;
    }

    static final boolean restore$lambda$11(StretchPhysicalPair arg1, StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "it");
        return arg1.samePhysicalTarget(arg2, arg3);
    }

    static final boolean restore$lambda$12(StretchPhysicalPair arg1, StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "it");
        return arg1.sameOriginal(arg2, arg3);
    }

    static final boolean restore$lambda$13(StretchPhysicalPair arg1, StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "it");
        return arg1.samePhysicalTarget(arg2, arg3);
    }

    private final boolean sameDisplay(StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        return Companion.access$sameDisplay(StretchPhysicalPair.Companion, arg2, arg3, this.restoration);
    }

    private final boolean sameOriginal(StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        return StretchPhysicalPair.Companion.matchesOriginal$app(arg2, arg3, this.restoration);
    }

    private final boolean samePhysicalTarget(StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        if((Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getPhysicalIdentity(), arg3.getSnapshot().getOriginal().getPhysicalIdentity())) && (Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getRotation(), arg3.getSnapshot().getOriginal().getRotation())) && (Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getReferenceSize(), arg3.getSnapshot().getOriginal().getReferenceSize()))) {
            return 1;
        }

        return 0;
    }

    private final boolean sameWindowState(StretchOriginalEvidence arg2, StretchOriginalEvidence arg3) {
        if((Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getLogicalSize().getValue(), arg3.getSnapshot().getOriginal().getLogicalSize().getValue())) && (Intrinsics.areEqual(arg2.getSizeOverride(), arg3.getSizeOverride())) && (Intrinsics.areEqual(arg2.getScaling(), arg3.getScaling()))) {
            return 1;
        }

        return 0;
    }

    public final StretchPairResult verifyOriginalExecutor(StretchRecoveryBinding arg18) {
        StretchPairResult v2_1;
        StretchPairResult v3;
        StretchCandidateRecord v2;
        StretchPhysicalPair v1 = this;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg18, "binding");
            v2 = this.record(arg18);
            if(v2 != null) {
                goto label_19;
            }

            v3 = new StretchPairResult("JOURNAL_OR_SESSION_INVALID", null, null, 0, 0, 0, 62, null);
        }
        catch(Throwable v0) {
            goto label_149;
        }

        __monitor_exit(this);
        return v3;
        try {
        label_19:
            if((v1.io.getCanRestore()) && !v1.io.getCanApply() && v2.getPhase() == CandidatePhase.CAPTURED && (v2.getIntentions().isEmpty()) && v2.getExecutorProbe() == CandidateExecutorProbe.RESERVED) {
                if(!StretchPhysicalPair.Companion.missingOriginal(v2.getEvidence()).isEmpty()) {
                    goto label_39;
                }
                else {
                    goto label_40;
                }
            }

            goto label_136;
        }
        catch(Throwable v0) {
            goto label_149;
        }

    label_39:
        goto label_136;
        try {
        label_40:
            StretchOriginalEvidence v0_2 = v2.getEvidence();
            if(v1.sameOriginal(v0_2, v1.io.read())) {
                v1.io.scaling(StretchScaling.AUTO);
                v1.io.size(v0_2.getSizeOverride().getValue());
                StretchPhysicalIo v3_1 = v1.io;
                Object v4 = v0_2.getScaling().getValue();
                if(v4 != null) {
                    v3_1.scaling(((StretchScaling)v4));
                    v3_1 = v1.io;
                    StretchCompositorState v4_1 = v0_2.getCompositor().getState();
                    if(v4_1 != null) {
                        v3_1.projection(v4_1.getPhysicalIdentity(), v0_2.getCompositor().getState().getProjection());
                        if(!v1.sameOriginal(v0_2, v1.io.read())) {
                            throw new IllegalStateException("Check failed.");
                        }
                        else if(v1.journal.commit(StretchCandidateRecord.copy$default(v2, Math.addExact(v2.getRevision(), 1), 0, null, null, null, null, null, null, CandidateExecutorProbe.MATCHED, null, null, 0x6FE, null), v2.getRevision())) {
                            v2_1 = new StretchPairResult("ORIGINAL_REASSERTED_READBACK_MATCHED", null, null, 0, 0, 0, 62, null);
                            goto label_134;
                        }
                        else {
                            throw new IllegalStateException("Check failed.");
                        }
                    }
                    else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            else {
                throw new IllegalStateException("Check failed.");
            }

            goto label_136;
        }
        catch(Throwable v0) {
        }
        catch(Exception v0_1) {
            try {
                v2_1 = new StretchPairResult("EXECUTOR_PROBE_FAILED", StretchCompatibilityKt.stretchFailureCode(((Throwable)v0_1)), null, 0, 0, 0, 60, null);
            }
            catch(Throwable v0) {
                goto label_149;
            }

        label_134:
            __monitor_exit(this);
            return v2_1;
            try {
            label_136:
                v2_1 = new StretchPairResult("EXECUTOR_PROBE_NOT_AUTHORIZED", null, null, 0, 0, 0, 62, null);
            }
            catch(Throwable v0) {
                try {
                label_149:
                    __monitor_exit(this);
                }
                catch(Throwable v0) {
                    goto label_149;
                }

                throw v0;
            }
        }

        __monitor_exit(this);
        return v2_1;
    }
}

