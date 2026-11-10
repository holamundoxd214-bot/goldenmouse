package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\u0006"}, d2={"stretchTrialJournalAdmission", "", "read", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "ownerUid", "", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryCustodianKt {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[CandidatePhase.values().length];
            try {
                v0[CandidatePhase.CLOSED_WITHOUT_MUTATION.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[CandidatePhase.CAPTURED.ordinal()] = 2;
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

    public static final String stretchTrialJournalAdmission(CandidateJournalRead arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "read");
        String v1 = "READY";
        if(Intrinsics.areEqual(arg2, Missing.INSTANCE)) {
            return v1;
        }

        if((arg2 instanceof Blocked)) {
            return "JOURNAL_" + ((Blocked)arg2).getError().name();
        }

        if((arg2 instanceof Present)) {
            StretchCandidateRecord v2 = ((Present)arg2).getRecord();
            if(v2.getOwnerUid() != arg3) {
                return "JOURNAL_OWNER_MISMATCH";
            }

            if(v2.getPhase() == CandidatePhase.RESTORED_VERIFIED && (StretchCandidateRecordCodec.INSTANCE.valid(v2))) {
                return v1;
            }

            if((v2.getIntentions().isEmpty()) && v2.getExecutorProbe() == CandidateExecutorProbe.NONE && v2.getReadback() == null) {
                if(v2.getRestorationIdentity() != null) {
                }
                else {
                    arg3 = WhenMappings.$EnumSwitchMapping$0[v2.getPhase().ordinal()];
                    if(arg3 == 1) {
                        return v1;
                    }
                    else if(arg3 != 2) {
                        return "JOURNAL_UNRESOLVED_" + v2.getPhase().name();
                    }
                    else {
                        return "RECOVER_UNMUTATED";
                    }
                }
            }

            return "PHYSICAL_RECOVERY_PENDING";
        }

        throw new NoWhenBranchMatchedException();
    }
}

