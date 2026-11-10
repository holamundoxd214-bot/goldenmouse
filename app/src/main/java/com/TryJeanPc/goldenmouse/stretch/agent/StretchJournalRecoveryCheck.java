package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryCodec;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0013BN\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012!\u0010\u0007\u001A\u001D\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0005¢\u0006\u0004\b\u000F\u0010\u0010J\u0006\u0010\u0011\u001A\u00020\u0012R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0007\u001A\u001D\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchJournalRecoveryCheck;", "", "ownerUid", "", "connect", "Lkotlin/Function0;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentClient;", "disconnect", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "awaitDeath", "inspect", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "<init>", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "run", "", "CheckFailed", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchJournalRecoveryCheck {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchJournalRecoveryCheck$CheckFailed;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "<init>", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class CheckFailed extends Exception {
        private final String code;

        public CheckFailed(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "code");
            super();
            this.code = arg2;
        }

        public final String getCode() {
            return this.code;
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StretchPhysicalOperation.values().length];
            try {
                v0[StretchPhysicalOperation.PREPARE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StretchPhysicalOperation.RECOVER_PERSISTED.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StretchPhysicalOperation.RELEASE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[StretchPhysicalOperation.APPLY.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[StretchPhysicalOperation.RESTORE.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[StretchPhysicalOperation.STATUS.ordinal()] = 6;
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

    public static final int $stable;
    private final Function0 connect;
    private final Function1 disconnect;
    private final Function0 inspect;
    private final int ownerUid;

    static {
    }

    public StretchJournalRecoveryCheck(int arg2, Function0 arg3, Function1 arg4, Function0 arg5) {
        Intrinsics.checkNotNullParameter(arg3, "connect");
        Intrinsics.checkNotNullParameter(arg4, "disconnect");
        Intrinsics.checkNotNullParameter(arg5, "inspect");
        super();
        this.ownerUid = arg2;
        this.connect = arg3;
        this.disconnect = arg4;
        this.inspect = arg5;
    }

    public final String run() {
        int v0_6;
        Object v0_5;
        Object v7_4;
        Boolean v9_3;
        Throwable v3_1;
        StretchCandidateRecord v6_3;
        String[] v7_1;
        StretchPhysicalReply v6_2;
        String v32;
        LinkedHashMap v4_2;
        StretchOriginalEvidence v0_4;
        boolean v0_3;
        String v31;
        Object v4_1;
        boolean v18;
        String v30;
        String v6_1;
        StretchJournalRecoveryCheck v1 = this;
        String v5 = "PASS";
        Pair[] v6 = new Pair[15];
        String v7 = "descriptorDelegation";
        Pair v9 = TuplesKt.to(v7, "UNKNOWN");
        Boolean v11 = Boolean.valueOf(false);
        v6[0] = v9;
        String v9_1 = "journalIntegrity";
        Pair v12 = TuplesKt.to(v9_1, "UNKNOWN");
        Boolean v14 = Boolean.valueOf(true);
        v6[1] = v12;
        String v12_1 = "firstSessionClose";
        v6[2] = TuplesKt.to(v12_1, "UNKNOWN");
        String v15 = "oldAgentTerminated";
        v6[3] = TuplesKt.to(v15, "UNKNOWN");
        String v10 = "newAgentGeneration";
        v6[4] = TuplesKt.to(v10, "UNKNOWN");
        String v13 = "journalRecovery";
        v6[5] = TuplesKt.to(v13, "UNKNOWN");
        String v19 = "Required value was null.";
        String v4 = "applyRejected";
        v6[6] = TuplesKt.to(v4, "UNKNOWN");
        v6[7] = TuplesKt.to("prepareRejected", "UNKNOWN");
        String v21 = "JOURNAL_";
        v6[8] = TuplesKt.to("restoreWithoutMutation", "UNKNOWN");
        String v22 = ";DISCONNECT_";
        v6[9] = TuplesKt.to("journalUnchanged", "UNKNOWN");
        Boolean v23 = v11;
        String v25 = "REMOTE_CLOSE_NOT_ACKNOWLEDGED";
        v6[10] = TuplesKt.to("secondSessionClose", "UNKNOWN");
        v6[11] = TuplesKt.to("lastRpcCode", "UNKNOWN");
        v6[12] = TuplesKt.to("lastRpcErrorType", "UNKNOWN");
        v6[13] = TuplesKt.to("originalMissing", "UNKNOWN");
        v6[14] = TuplesKt.to("physicalRoute", "UNKNOWN");
        LinkedHashMap v2 = MapsKt.linkedMapOf(v6);
        ObjectRef v8 = new ObjectRef();
        String v20 = "secondSessionClose";
        ObjectRef v11_1 = new ObjectRef();
        String v26 = "journalUnchanged";
        ObjectRef v3 = new ObjectRef();
        String v27 = "restoreWithoutMutation";
        v3.element = "physicalGate";
        String v28 = "NONE";
        String v0 = "prepareRejected";
        String v29 = "FAIL";
        try {
            v6_1 = "PHYSICAL_GATE_MUST_BE_CLOSED";
            v30 = v4;
        }
        catch(Throwable v0_1) {
            goto label_484;
        }
        catch(Exception v0_2) {
            goto label_492;
        }

        try {
            StretchJournalRecoveryCheck.run$verify(true, v6_1);
        }
        catch(Throwable v0_1) {
            v18 = true;
            goto label_472;
        }
        catch(Exception v0_2) {
            v18 = true;
            goto label_478;
        }

        try {
            v3.element = "existingJournal";
            v4_1 = v1.inspect.invoke();
            if((v4_1 instanceof Blocked)) {
                goto label_453;
            }

            if((v4_1 instanceof Present)) {
            }
            else {
                goto label_143;
            }
        }
        catch(Throwable v0_1) {
            goto label_484;
        }
        catch(Exception v0_2) {
            goto label_492;
        }

        try {
            v31 = v0;
            v0_3 = v4_1.getRecord().getPhase() != CandidatePhase.CLOSED_WITHOUT_MUTATION || !v4_1.getRecord().getIntentions().isEmpty() || ((Present)v4_1).getRecord().getOwnerUid() != v1.ownerUid ? false : true;
            StretchJournalRecoveryCheck.run$verify(v0_3, "EXISTING_JOURNAL_REQUIRES_RECOVERY");
            goto label_147;
        }
        catch(Exception v0_2) {
            goto label_136;
        }
        catch(Throwable v0_1) {
            goto label_128;
        }

    label_143:
        v31 = v0;
        try {
            if(!Intrinsics.areEqual(v4_1, Missing.INSTANCE)) {
                goto label_445;
            }

        label_147:
            v0_4 = StretchJournalRecoveryCheck.run$open(v3, v1, v8, v11_1);
            v4_2 = v2;
            v6_1 = "originalMissing";
            v32 = v13;
            v13 = CollectionsKt.joinToString$default(StretchPhysicalPair.Companion.missingOriginal(v0_4), ",", null, null, 0, null, null, 62, null);
            if(((CharSequence)v13).length() == 0) {
                goto label_166;
            }

            goto label_167;
        }
        catch(Throwable v0_1) {
            goto label_484;
        }
        catch(Exception v0_2) {
            goto label_492;
        }

        try {
        label_166:
            v13 = "NONE";
        }
        catch(Exception v0_2) {
            goto label_136;
        }
        catch(Throwable v0_1) {
            goto label_128;
        }

        try {
        label_167:
            ((Map)v4_2).put(v6_1, v13);
            v2.put("physicalRoute", StretchPhysicalPair.Companion.route(v0_4).name());
            v4_1 = v8.element;
            if(v4_1 == null) {
                goto label_436;
            }

            v4 = ((StretchAgentClient)v4_1).getGeneration();
            v3.element = v7;
            v6_2 = StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.PREPARE);
            v7_1 = new String[2];
            v7_1[0] = "PREPARED_READ_ONLY";
            v13 = "ORIGINAL_INCOMPLETE";
            v18 = true;
        }
        catch(Throwable v0_1) {
            goto label_484;
        }
        catch(Exception v0_2) {
            goto label_492;
        }

        try {
            v7_1[1] = v13;
        }
        catch(Throwable v0_1) {
            goto label_472;
        }
        catch(Exception v0_2) {
            goto label_435;
        }

        try {
            if(SetsKt.setOf(((Object[])v7_1)).contains(v6_2.getCode())) {
            }
            else {
                goto label_195;
            }
        }
        catch(Throwable v0_1) {
            goto label_484;
        }
        catch(Exception v0_2) {
            goto label_492;
        }

        try {
            if(v6_2.getJournalRetained()) {
            }
            else {
                goto label_195;
            }
        }
        catch(Exception v0_2) {
            goto label_136;
        }
        catch(Throwable v0_1) {
            goto label_128;
        }

        boolean v7_2 = true;
        goto label_196;
    label_195:
        v7_2 = false;
        try {
        label_196:
            StretchJournalRecoveryCheck.run$verify(v7_2, v6_2.getCode());
            v2.put(v3.element, v5);
            v3.element = v9_1;
            v6_3 = StretchJournalRecoveryCheck.run$record(v1);
            int v7_3 = v6_3.getOwnerUid();
            int v9_2 = v1.ownerUid;
            if(v7_3 == v9_2) {
            }
            else {
                goto label_217;
            }
        }
        catch(Throwable v0_1) {
            goto label_484;
        }
        catch(Exception v0_2) {
            goto label_492;
        }

        try {
            if(!Intrinsics.areEqual(v6_3.getEvidence(), v0_4)) {
                goto label_217;
            }
            else if(!v6_3.getIntentions().isEmpty()) {
                goto label_217;
            }
            else if(v6_3.getPhase() == CandidatePhase.CAPTURED) {
            }
            else {
                goto label_217;
            }
        }
        catch(Exception v0_2) {
            goto label_136;
        }
        catch(Throwable v0_1) {
            goto label_128;
        }

        boolean v6_4 = true;
        goto label_218;
    label_217:
        v6_4 = false;
        try {
        label_218:
            StretchJournalRecoveryCheck.run$verify(v6_4, "JOURNAL_READBACK_MISMATCH");
            v2.put(v3.element, v5);
            v3.element = "releaseFirstJournal";
            v18 = true;
            StretchJournalRecoveryCheck.run$verify(StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.RELEASE).getJournalRetained() ^ 1, "JOURNAL_STILL_DELEGATED");
            v6_3 = StretchJournalRecoveryCheck.run$record(v1);
            if(Intrinsics.areEqual(v6_3.getEvidence(), v0_4)) {
            }
            else {
                goto label_244;
            }
        }
        catch(Throwable v0_1) {
            goto label_484;
        }
        catch(Exception v0_2) {
            goto label_492;
        }

        try {
            if(!v6_3.getIntentions().isEmpty()) {
                goto label_244;
            }
            else if(v6_3.getPhase() != CandidatePhase.CLOSED_WITHOUT_MUTATION) {
                goto label_244;
            }
        }
        catch(Throwable v0_1) {
        label_128:
            v3_1 = v0_1;
            v10 = v22;
            v9_3 = v23;
            v6_1 = v25;
            v4 = v28;
            v18 = true;
            goto label_633;
        }
        catch(Exception v0_2) {
        label_136:
            v10 = v22;
            v9_3 = v23;
            v6_1 = v25;
            v5 = v29;
            v7_1 = null;
            v18 = true;
            goto label_498;
        }

        v0_3 = true;
        goto label_245;
    label_244:
        v0_3 = false;
        try {
        label_245:
            StretchJournalRecoveryCheck.run$verify(v0_3, "JOURNAL_NOT_CLOSED_WITHOUT_MUTATION");
            StretchJournalRecoveryCheck.run$closeSession(v3, v8, v2, v11_1, v12_1);
            v3.element = v15;
            StretchJournalRecoveryCheck.run$verify(v1.disconnect.invoke(v14).booleanValue(), "AGENT_DEATH_NOT_CONFIRMED");
            v7_4 = null;
        }
        catch(Exception v0_2) {
            goto label_492;
        }

        try {
            v8.element = v7_4;
            v11_1.element = v7_4;
        }
        catch(Exception v0_2) {
            v10 = v22;
            v9_3 = v23;
            v6_1 = v25;
            goto label_496;
        }

        try {
            v2.put(v3.element, v5);
            StretchJournalRecoveryCheck.run$open(v3, v1, v8, v11_1);
            v3.element = v10;
            v0_5 = v8.element;
            if(v0_5 == null) {
                goto label_418;
            }

            StretchJournalRecoveryCheck.run$verify(Intrinsics.areEqual(((StretchAgentClient)v0_5).getGeneration(), v4) ^ 1, "SAME_AGENT_GENERATION");
            v2.put(v3.element, v5);
            v3.element = v32;
            StretchJournalRecoveryCheck.run$verify(Intrinsics.areEqual(StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.RECOVER_PERSISTED).getCode(), "NO_MUTATION_REQUESTED"), "RECOVERY_NOOP_NOT_ACKNOWLEDGED");
            v2.put(v3.element, v5);
            v3.element = v30;
            StretchJournalRecoveryCheck.run$verify(Intrinsics.areEqual(StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.APPLY).getCode(), "RESTORE_ONLY_SESSION"), "APPLY_NOT_REJECTED_AS_RESTORE_ONLY");
            v2.put(v3.element, v5);
            v3.element = v31;
            StretchJournalRecoveryCheck.run$verify(Intrinsics.areEqual(StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.PREPARE).getCode(), "RESTORE_ONLY_SESSION"), "PREPARE_CAN_REARM_APPLY");
            v2.put(v3.element, v5);
            v3.element = v27;
            StretchJournalRecoveryCheck.run$verify(Intrinsics.areEqual(StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.RESTORE).getCode(), "NO_MUTATION_REQUESTED"), "RESTORE_NOOP_NOT_ACKNOWLEDGED");
            v2.put(v3.element, v5);
            v3.element = "releaseSecondJournal";
            v18 = true;
            v0_6 = StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.RELEASE).getJournalRetained() ^ 1;
            goto label_328;
        }
        catch(Exception v0_2) {
        label_492:
            v10 = v22;
            v9_3 = v23;
            v6_1 = v25;
            v7_1 = null;
        }

    label_496:
        v18 = true;
        goto label_497;
    label_484:
        v10 = v22;
        v9_3 = v23;
        v6_1 = v25;
        v18 = true;
        goto label_488;
        try {
        label_328:
            StretchJournalRecoveryCheck.run$verify(((boolean)v0_6), "JOURNAL_STILL_DELEGATED");
            v3.element = v26;
            StretchJournalRecoveryCheck.run$verify(Intrinsics.areEqual(StretchJournalRecoveryCheck.run$record(v1), v6_3), "RECOVERED_JOURNAL_CHANGED");
            v2.put(v3.element, v5);
            StretchJournalRecoveryCheck.run$closeSession(v3, v8, v2, v11_1, v20);
            v3.element = "finalAgentClose";
            StretchJournalRecoveryCheck.run$verify(v1.disconnect.invoke(v14).booleanValue(), "AGENT_DEATH_NOT_CONFIRMED");
            v7_4 = null;
            goto label_349;
        }
        catch(Exception v0_2) {
        label_435:
        }

    label_478:
        v10 = v22;
        v9_3 = v23;
        v6_1 = v25;
        v7_1 = null;
        goto label_497;
        try {
        label_349:
            v8.element = v7_4;
            v11_1.element = v7_4;
        }
        catch(Exception v0_2) {
            v10 = v22;
            v9_3 = v23;
            v6_1 = v25;
            goto label_497;
        }

        try {
            v3.element = "COMPLETE";
            goto label_353;
        }
        catch(Exception v0_2) {
            v10 = v22;
            v9_3 = v23;
            v6_1 = v25;
            goto label_498;
        }

    label_472:
        v10 = v22;
        v9_3 = v23;
        v6_1 = v25;
        goto label_488;
    label_353:
        if(v8.element != null && v11_1.element != null) {
            v0_5 = v8.element;
            if(v0_5 != null) {
                if(((StretchAgentClient)v0_5).getRemoteExecutionUnknown()) {
                    goto label_391;
                }

                if(Thread.currentThread().isInterrupted()) {
                    goto label_391;
                }

                try {
                    StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.RELEASE);
                    boolean v10_1 = StretchJournalRecoveryCheck.run$exchange(v11_1, v8, StretchAgentAction.CLOSE, StretchAgentCode.CLOSED).getPhase() == StretchAgentPhase.CLOSED ? true : false;
                    StretchJournalRecoveryCheck.run$verify(v10_1, v25);
                }
                catch(Exception v0_2) {
                    v28 = "NONE;CLEANUP_" + StretchReadOnlyPreflightKt.preflightErrorType(v0_2);
                    v5 = v29;
                }
            }
            else {
                throw new IllegalArgumentException(v19.toString());
            }
        }

    label_391:
        v4 = v28;
        try {
            v1.disconnect.invoke(v23);
            goto label_395;
        }
        catch(Exception v0_2) {
            v4 = v4 + v22 + StretchReadOnlyPreflightKt.preflightErrorType(v0_2);
            v6_1 = v29;
            goto label_580;
        }

    label_418:
        v10 = v22;
        v9_3 = v23;
        v6_1 = v25;
        v7_1 = null;
        v18 = true;
        try {
            throw new IllegalArgumentException(v19.toString());
        label_436:
            v10 = v22;
            v9_3 = v23;
            v6_1 = v25;
            v7_1 = null;
            v18 = true;
            throw new IllegalArgumentException(v19.toString());
        label_445:
            v10 = v22;
            v9_3 = v23;
            v6_1 = v25;
            v7_1 = null;
            v18 = true;
            throw new NoWhenBranchMatchedException();
        label_453:
            v10 = v22;
            v9_3 = v23;
            v6_1 = v25;
            v7_1 = null;
            v18 = true;
            throw new CheckFailed(v21 + ((Blocked)v4_1).getError().name());
        }
        catch(Throwable v0_1) {
        label_632:
        }
        catch(Exception v0_2) {
        label_497:
            v5 = v29;
            try {
            label_498:
                if((v0_2 instanceof CheckFailed)) {
                    v4 = v0_2.getCode();
                    if(new Regex("[A-Z0-9_]{1,80}").matches(v4)) {
                    }
                    else {
                        String[] v4_3 = v7_1;
                    }

                    if(v4 != null) {
                        goto label_514;
                    }

                    v4 = "INVALID_REPLY_CODE";
                }
                else {
                    v4 = StretchReadOnlyPreflightKt.preflightErrorType(v0_2);
                }
            }
            catch(Throwable v0_1) {
                goto label_632;
            }

            try {
            label_514:
                if(v2.containsKey(v3.element)) {
                    v13 = v29;
                    v2.put(v3.element, v13);
                }
                else {
                    v13 = v29;
                }

                if((v0_2 instanceof InterruptedException)) {
                    Thread.currentThread().interrupt();
                }
            }
            catch(Throwable v0_1) {
                v3_1 = v0_1;
                goto label_633;
            }

            if(v8.element != null) {
                if(v11_1.element == null) {
                    goto label_567;
                }

                v0_5 = v8.element;
                if(v0_5 != null) {
                    if(((StretchAgentClient)v0_5).getRemoteExecutionUnknown()) {
                        goto label_567;
                    }

                    if(Thread.currentThread().isInterrupted()) {
                        goto label_567;
                    }

                    try {
                        StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.RELEASE);
                        v0_3 = StretchJournalRecoveryCheck.run$exchange(v11_1, v8, StretchAgentAction.CLOSE, StretchAgentCode.CLOSED).getPhase() == StretchAgentPhase.CLOSED ? v18 : false;
                        StretchJournalRecoveryCheck.run$verify(v0_3, ((String)v6_3));
                    }
                    catch(Exception v0_2) {
                        v4 = v4 + ";CLEANUP_" + StretchReadOnlyPreflightKt.preflightErrorType(v0_2);
                        v5 = v13;
                    }

                    goto label_567;
                }

                throw new IllegalArgumentException(v19.toString());
            }

            try {
            label_567:
                v1.disconnect.invoke(v9_3);
            }
            catch(Exception v0_2) {
                v4 = v4 + v10 + StretchReadOnlyPreflightKt.preflightErrorType(v0_2);
                v6_1 = v13;
                goto label_580;
            }

        label_395:
            v6_1 = v5;
        label_580:
            StringBuilder v0_7 = new StringBuilder("Golden Stretch — prueba de journal y reconexión\n");
            v0_7.append("outcome: " + v6_1).append('\n');
            Iterator v1_1 = ((Map)v2).entrySet().iterator();
            while(v1_1.hasNext()) {
                Object v2_1 = v1_1.next();
                v0_7.append(((Map$Entry)v2_1).getKey() + ": " + ((Map$Entry)v2_1).getValue()).append('\n');
            }

            v0_7.append("stage: " + v3.element).append('\n');
            v0_7.append("cause: " + v4).append("\nphysicalMutationAllowed: false\nphysicalRecoveryAccredited: false\nRESTAURAR validado solo como operación sin cambios pendientes. No acredita restauración física.");
            return v0_7.toString();
        }

    label_488:
        v3_1 = v0_1;
        v4 = v28;
    label_633:
        if(v8.element != null) {
            if(v11_1.element == null) {
                goto label_671;
            }

            v0_5 = v8.element;
            if(v0_5 != null) {
                if(((StretchAgentClient)v0_5).getRemoteExecutionUnknown()) {
                    goto label_671;
                }

                if(Thread.currentThread().isInterrupted()) {
                    goto label_671;
                }

                try {
                    StretchJournalRecoveryCheck.run$physical(v11_1, v8, v2, StretchPhysicalOperation.RELEASE);
                    v0_3 = StretchJournalRecoveryCheck.run$exchange(v11_1, v8, StretchAgentAction.CLOSE, StretchAgentCode.CLOSED).getPhase() == StretchAgentPhase.CLOSED ? v18 : false;
                    StretchJournalRecoveryCheck.run$verify(v0_3, ((String)v6_3));
                }
                catch(Exception v0_2) {
                    v4 = v4 + ";CLEANUP_" + StretchReadOnlyPreflightKt.preflightErrorType(v0_2);
                }

                goto label_671;
            }

            throw new IllegalArgumentException(v19.toString());
        }

        try {
        label_671:
            v1.disconnect.invoke(v9_3);
        }
        catch(Exception v0_2) {
            new StringBuilder().append(v4).append(v10).append(StretchReadOnlyPreflightKt.preflightErrorType(v0_2)).toString();
        }

        throw v3_1;
    }

    private static final void run$closeSession(ObjectRef arg1, ObjectRef arg2, LinkedHashMap arg3, ObjectRef arg4, String arg5) {
        boolean v1_1;
        arg1.element = arg5;
        if(StretchJournalRecoveryCheck.run$exchange(arg4, arg2, StretchAgentAction.CLOSE, StretchAgentCode.CLOSED).getPhase() == StretchAgentPhase.CLOSED) {
            Object v1 = arg2.element;
            if(v1 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            else if(!((StretchAgentClient)v1).getRemoteExecutionUnknown()) {
                v1_1 = true;
            }
            else {
                goto label_18;
            }
        }
        else {
        label_18:
            v1_1 = false;
        }

        StretchJournalRecoveryCheck.run$verify(v1_1, "REMOTE_CLOSE_NOT_ACKNOWLEDGED");
        ((Map)arg3).put(arg5, "PASS");
    }

    private static final StretchAgentReply run$exchange(ObjectRef arg16, ObjectRef arg17, StretchAgentAction arg18, StretchAgentCode arg19) {
        Object v0 = arg16.element;
        String v1 = "Required value was null.";
        if(v0 != null) {
            String v5 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
            StretchAgentRequest v0_1 = StretchAgentRequest.copy$default(v0, 0, null, v5, null, null, 0, arg18, null, null, 0, null, 0x7BB, null);
            Object v2 = arg17.element;
            if(v2 != null) {
                v0 = ((StretchAgentClient)v2).submit(v0_1).get(6, TimeUnit.SECONDS);
                boolean v1_1 = ((StretchAgentReply)v0).getCode() != arg19 || (((StretchAgentReply)v0).getPhysicalMutationAllowed()) ? false : true;
                StretchJournalRecoveryCheck.run$verify(v1_1, "RPC_" + ((StretchAgentReply)v0).getCode().name());
                Intrinsics.checkNotNull(v0);
                return ((StretchAgentReply)v0);
            }

            throw new IllegalArgumentException(v1.toString());
        }

        throw new IllegalArgumentException(v1.toString());
    }

    private static final StretchOriginalEvidence run$open(ObjectRef arg24, StretchJournalRecoveryCheck arg25, ObjectRef arg26, ObjectRef arg27) {
        ObjectRef v0 = arg24;
        ObjectRef v1 = arg26;
        ObjectRef v2 = arg27;
        v0.element = "connect";
        Object v3 = arg25.connect.invoke();
        v1.element = v3;
        boolean v6 = true;
        boolean v4 = ((StretchAgentClient)v3).getAuthenticatedPeerUid() == 2000 ? true : false;
        StretchJournalRecoveryCheck.run$verify(v4, "AGENT_UID_INVALID");
        String v10 = UUID.randomUUID().toString();
        String v4_1 = "toString(...)";
        Intrinsics.checkNotNullExpressionValue(v10, v4_1);
        String v12 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(v12, v4_1);
        v2.element = new StretchAgentRequest(2, v10, "open", v12, ((StretchAgentClient)v3).getGeneration(), 0, StretchAgentAction.OPEN, null, null, 0, null, 0x780, null);
        v0.element = "open";
        StretchJournalRecoveryCheck.run$exchange(v2, v1, StretchAgentAction.OPEN, StretchAgentCode.ACCEPTED);
        v0.element = "baseline";
        StretchAgentBaseline v5 = StretchJournalRecoveryCheck.run$exchange(v2, v1, StretchAgentAction.READ_BASELINE, StretchAgentCode.BASELINE_READ).getBaseline();
        String v8 = "Required value was null.";
        if(v5 != null) {
            Object v9 = v2.element;
            if(v9 != null) {
                v2.element = StretchAgentRequest.copy$default(v9, 0, null, null, null, null, 0, null, StretchRecoveryCodec.INSTANCE.snapshotDigest(v5.getSnapshot()), v5.getSnapshot().getOriginal().getPhysicalIdentity().getValue(), 0, null, 0x67F, null);
                StretchJournalRecoveryCheck.run$exchange(v2, v1, StretchAgentAction.HEARTBEAT, StretchAgentCode.ACCEPTED);
                v0.element = "original";
                Object v0_1 = v2.element;
                if(v0_1 != null) {
                    v12 = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(v12, v4_1);
                    v0_1 = ((StretchAgentClient)v3).readOriginal(StretchAgentRequest.copy$default(v0_1, 0, null, v12, null, null, 0, null, null, null, 0, null, 0x7FB, null)).get(6, TimeUnit.SECONDS);
                    boolean v3_1 = ((StretchAgentReply)v0_1).getCode() != StretchAgentCode.ACCEPTED || (((StretchAgentReply)v0_1).getPhysicalMutationAllowed()) ? false : true;
                    StretchJournalRecoveryCheck.run$verify(v3_1, "ORIGINAL_" + ((StretchAgentReply)v0_1).getCode().name());
                    StretchOriginalEvidence v0_2 = ((StretchAgentReply)v0_1).getOriginalEvidence();
                    if(v0_2 != null) {
                        StretchOriginalEvidenceRpc v3_2 = StretchOriginalEvidenceRpc.INSTANCE;
                        Object v4_2 = v2.element;
                        if(v4_2 != null) {
                            if(!v3_2.boundTo(v0_2, ((StretchAgentRequest)v4_2)) || !v0_2.getStable()) {
                                v6 = false;
                            }
                            else {
                            }

                            StretchJournalRecoveryCheck.run$verify(v6, "ORIGINAL_UNSTABLE_OR_UNBOUND");
                            StretchRecoveryBinding.Companion.from(v0_2);
                            StretchJournalRecoveryCheck.run$exchange(v2, v1, StretchAgentAction.HEARTBEAT, StretchAgentCode.ACCEPTED);
                            return v0_2;
                        }

                        throw new IllegalArgumentException(v8.toString());
                    }

                    throw new IllegalArgumentException(v8.toString());
                }

                throw new IllegalArgumentException(v8.toString());
            }

            throw new IllegalArgumentException(v8.toString());
        }

        throw new IllegalArgumentException(v8.toString());
    }

    private static final StretchPhysicalReply run$physical(ObjectRef arg16, ObjectRef arg17, LinkedHashMap arg18, StretchPhysicalOperation arg19) {
        Object v0 = arg16.element;
        String v1 = "Required value was null.";
        if(v0 == null) {
            goto label_95;
        }

        String v5 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
        StretchAgentRequest v0_1 = StretchAgentRequest.copy$default(v0, 0, null, v5, null, null, 0, StretchAgentAction.STATUS, null, null, 0, null, 0x7BB, null);
        Object v2 = arg17.element;
        if(v2 == null) {
            goto label_91;
        }

        switch(WhenMappings.$EnumSwitchMapping$0[arg19.ordinal()]) {
            case 1: {
                goto label_42;
            }
            case 2: {
                goto label_40;
            }
            case 3: {
                goto label_38;
            }
            case 4: {
                goto label_36;
            }
            case 5: {
                goto label_34;
            }
            case 6: {
                goto label_32;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_34:
        CompletableFuture v0_2 = ((StretchAgentClient)v2).restorePhysical(v0_1);
        goto label_43;
    label_36:
        v0_2 = ((StretchAgentClient)v2).applyPhysical105(v0_1);
        goto label_43;
    label_38:
        v0_2 = ((StretchAgentClient)v2).releasePhysical(v0_1);
        goto label_43;
    label_40:
        v0_2 = ((StretchAgentClient)v2).recoverPersistedPhysical(v0_1);
        goto label_43;
    label_42:
        v0_2 = ((StretchAgentClient)v2).preparePhysical(v0_1);
        goto label_43;
    label_32:
        v0_2 = ((StretchAgentClient)v2).physicalStatus(v0_1);
    label_43:
        v0 = v0_2.get(5, TimeUnit.SECONDS);
        Object v1_1 = v0;
        LinkedHashMap v2_1 = arg18;
        String v3 = ((StretchPhysicalReply)v1_1).getCode();
        v5 = null;
        if(new Regex("[A-Z0-9_]{1,80}").matches(v3)) {
        }
        else {
            v3 = v5;
        }

        if(v3 == null) {
            v3 = "INVALID_REPLY_CODE";
        }

        ((Map)v2_1).put("lastRpcCode", v3);
        v3 = ((StretchPhysicalReply)v1_1).getErrorType();
        if(v3 != null) {
            if(new Regex("[A-Za-z0-9_]{1,80}").matches(v3)) {
                v5 = v3;
            }

            if(v5 == null) {
                v5 = "UNKNOWN";
            }

            if(v5 != null) {
                goto label_75;
            }

            goto label_74;
        }
        else {
        label_74:
            v5 = "NONE";
        }

    label_75:
        ((Map)v2_1).put("lastRpcErrorType", v5);
        boolean v2_2 = (((StretchPhysicalReply)v1_1).getPhysicalMutationAllowed()) || (((StretchPhysicalReply)v1_1).getPhysicalRecoveryAccredited()) || (((StretchPhysicalReply)v1_1).getRecoveryPending()) ? false : true;
        StretchJournalRecoveryCheck.run$verify(v2_2, "JOURNAL_STATE_UNCERTAIN");
        Intrinsics.checkNotNullExpressionValue(v0, "also(...)");
        return ((StretchPhysicalReply)v1_1);
    label_91:
        throw new IllegalArgumentException(v1.toString());
    label_95:
        throw new IllegalArgumentException(v1.toString());
    }

    private static final StretchCandidateRecord run$record(StretchJournalRecoveryCheck arg3) {
        Object v3 = arg3.inspect.invoke();
        if((v3 instanceof Present)) {
            return ((Present)v3).getRecord();
        }

        if(!(v3 instanceof Blocked)) {
            if(Intrinsics.areEqual(v3, Missing.INSTANCE)) {
                throw new CheckFailed("JOURNAL_MISSING");
            }

            throw new NoWhenBranchMatchedException();
        }

        throw new CheckFailed("JOURNAL_" + ((Blocked)v3).getError().name());
    }

    private static final void run$verify(boolean arg0, String arg1) {
        if(arg0) {
            return;
        }

        throw new CheckFailed(arg1);
    }
}

