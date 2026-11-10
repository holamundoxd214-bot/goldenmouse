package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0010R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryCustodian;", "", "journal", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalJournal;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalJournal;)V", "firstObservation", "", "latchedReason", "", "observe", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCustodyResult;", "event", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CustodyEvent;", "bootId", "nowElapsedMillis", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryCustodian {
    public static final int $stable = 8;
    private boolean firstObservation;
    private final StretchPhysicalJournal journal;
    private String latchedReason;

    static {
    }

    public StretchRecoveryCustodian(StretchPhysicalJournal arg2) {
        Intrinsics.checkNotNullParameter(arg2, "journal");
        super();
        this.journal = arg2;
        this.firstObservation = true;
    }

    public final StretchCustodyResult observe(CustodyEvent arg20, String arg21, long arg22) {
        StretchCustodyResult v2_2;
        CandidatePhase v9;
        CandidatePhase v2_1;
        String v7_2;
        StretchCustodyResult v0_2;
        StretchCandidateRecord v4;
        StretchRecoveryCustodian v1 = this;
        CustodyEvent v0 = arg20;
        String v2 = arg21;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(v0, "event");
            Intrinsics.checkNotNullParameter(v2, "bootId");
            CandidateJournalRead v3 = v1.journal.load();
            if((v3 instanceof Present)) {
            }
            else {
                v3 = null;
            }

            if(v3 != null) {
                v4 = ((Present)v3).getRecord();
                if(v4 == null) {
                }
                else {
                    StretchRecoveryCustody v3_1 = v4.getCustody();
                    if(v3_1 == null) {
                        v0_2 = new StretchCustodyResult(CustodyCode.BLOCKED, "CUSTODY_LEASE_MISSING");
                        goto label_24;
                    }
                    else {
                        goto label_26;
                    }
                }
            }

            goto label_156;
        }
        catch(Throwable v0_1) {
            goto label_163;
        }

    label_24:
        __monitor_exit(this);
        return v0_2;
        try {
        label_26:
            boolean v5 = v1.firstObservation;
            v1.firstObservation = false;
            if(v4.getPhase() == CandidatePhase.CLOSED_WITHOUT_MUTATION) {
                v0_2 = new StretchCustodyResult(CustodyCode.NO_MUTATION_CLOSED, "NO_INTENTION");
            }
            else {
                goto label_38;
            }
        }
        catch(Throwable v0_1) {
            goto label_163;
        }

        __monitor_exit(this);
        return v0_2;
        try {
        label_38:
            if(v4.getPhase() == CandidatePhase.RESTORED_VERIFIED) {
                v0_2 = new StretchCustodyResult(CustodyCode.OBSERVING, "RESTORE_ALREADY_VERIFIED");
            }
            else {
                goto label_47;
            }
        }
        catch(Throwable v0_1) {
            goto label_163;
        }

        __monitor_exit(this);
        return v0_2;
    label_47:
        int v7 = 4;
        try {
            CandidatePhase[] v7_1 = new CandidatePhase[v7];
            v7_1[0] = CandidatePhase.EXECUTION_UNKNOWN;
            v7_1[1] = CandidatePhase.RESTORE_PENDING;
            v7_1[2] = CandidatePhase.RESTORE_PARTIAL;
            v7_1[3] = CandidatePhase.RESTORE_UNVERIFIED;
            Set v6 = SetsKt.setOf(((Object[])v7_1));
            v7_2 = v1.latchedReason;
            if(v7_2 == null) {
                if(!Intrinsics.areEqual(v2, v3_1.getBootId())) {
                    v7_2 = "BOOT_CHANGED";
                }
                else if(arg22 < v3_1.getStartedElapsedMillis()) {
                    v7_2 = "CLOCK_REWOUND";
                }
                else if(arg22 >= v3_1.getExpiresElapsedMillis()) {
                    v7_2 = "DEADLINE_EXPIRED";
                }
                else if(v0 != CustodyEvent.POLL) {
                    v7_2 = v0.name();
                }
                else {
                    if((v5) && (!v4.getIntentions().isEmpty() || v4.getExecutorProbe() == CandidateExecutorProbe.RESERVED)) {
                        v7_2 = "CUSTODIAN_RESTARTED";
                        goto label_100;
                    }

                    if(v6.contains(v4.getPhase())) {
                        v7_2 = "PENDING_RECORD";
                        goto label_100;
                    }

                    v0_2 = new StretchCustodyResult(CustodyCode.OBSERVING, "LEASE_ACTIVE");
                    goto label_98;
                }
            }

            goto label_100;
        }
        catch(Throwable v0_1) {
            goto label_163;
        }

    label_98:
        __monitor_exit(this);
        return v0_2;
    label_100:
        String v0_3 = v7_2;
        try {
            v1.latchedReason = v0_3;
            if((v4.getIntentions().isEmpty()) && v4.getExecutorProbe() == CandidateExecutorProbe.NONE) {
                v2_1 = CandidatePhase.CLOSED_WITHOUT_MUTATION;
            }
            else if(v6.contains(v4.getPhase())) {
                v2_1 = v4.getPhase();
            }
            else {
                v2_1 = CandidatePhase.RESTORE_PENDING;
            }

            v9 = v2_1;
            if(v4.getPhase() != v9) {
                if(v4.getRevision() != 0x7FFFFFFFFFFFFFFFL && (v1.journal.commit(StretchCandidateRecord.copy$default(v4, v4.getRevision() + 1, 0, null, v9, null, null, null, null, null, null, null, 0x7F6, null), v4.getRevision()))) {
                    goto label_147;
                }

                v0_2 = new StretchCustodyResult(CustodyCode.BLOCKED, "JOURNAL_WRITE_FAILED");
                goto label_145;
            }

            goto label_147;
        }
        catch(Throwable v0_1) {
            goto label_163;
        }

    label_145:
        __monitor_exit(this);
        return v0_2;
        try {
        label_147:
            CustodyCode v3_2 = v9 == CandidatePhase.CLOSED_WITHOUT_MUTATION ? CustodyCode.NO_MUTATION_CLOSED : CustodyCode.RESTORE_PENDING;
            v2_2 = new StretchCustodyResult(v3_2, v0_3);
        }
        catch(Throwable v0_1) {
            goto label_163;
        }

        __monitor_exit(this);
        return v2_2;
        try {
        label_156:
            v0_2 = new StretchCustodyResult(CustodyCode.BLOCKED, "JOURNAL_UNAVAILABLE");
        }
        catch(Throwable v0_1) {
            try {
            label_163:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_163;
            }

            throw v0_1;
        }

        __monitor_exit(this);
        return v0_2;
    }
}

