package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "", "Missing", "Present", "Blocked", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead$Blocked;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead$Missing;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead$Present;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface CandidateJournalRead {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead$Blocked;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "error", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalError;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalError;)V", "getError", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Blocked implements CandidateJournalRead {
        public static final int $stable;
        private final CandidateJournalError error;

        static {
        }

        public Blocked(CandidateJournalError arg2) {
            Intrinsics.checkNotNullParameter(arg2, "error");
            super();
            this.error = arg2;
        }

        public final CandidateJournalError component1() {
            return this.error;
        }

        public final Blocked copy(CandidateJournalError arg1) {
            Intrinsics.checkNotNullParameter(arg1, "error");
            return new Blocked(arg1);
        }

        public static Blocked copy$default(Blocked arg0, CandidateJournalError arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.error;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Blocked)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Blocked)) {
                return 0;
            }

            if(this.error != ((Blocked)arg4).error) {
                return 0;
            }

            return 1;
        }

        public final CandidateJournalError getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Blocked(error=" + this.error + ")";
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead$Missing;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Missing implements CandidateJournalRead {
        public static final int $stable;
        public static final Missing INSTANCE;

        static {
            Missing.INSTANCE = new Missing();
        }

        private Missing() {
            super();
        }

        public boolean equals(Object arg2) {
            if(this == (((Missing)arg2))) {
                return 1;
            }

            if(!(arg2 instanceof Missing)) {
                return 0;
            }

            return 1;
        }

        public int hashCode() {
            return 0x65F418AB;
        }

        public String toString() {
            return "Missing";
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead$Present;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "record", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;)V", "getRecord", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Present implements CandidateJournalRead {
        public static final int $stable = 8;
        private final StretchCandidateRecord record;

        static {
        }

        public Present(StretchCandidateRecord arg2) {
            Intrinsics.checkNotNullParameter(arg2, "record");
            super();
            this.record = arg2;
        }

        public final StretchCandidateRecord component1() {
            return this.record;
        }

        public final Present copy(StretchCandidateRecord arg1) {
            Intrinsics.checkNotNullParameter(arg1, "record");
            return new Present(arg1);
        }

        public static Present copy$default(Present arg0, StretchCandidateRecord arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.record;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Present)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Present)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.record, ((Present)arg4).record)) {
                return 0;
            }

            return 1;
        }

        public final StretchCandidateRecord getRecord() {
            return this.record;
        }

        public int hashCode() {
            return this.record.hashCode();
        }

        public String toString() {
            return "Present(record=" + this.record + ")";
        }
    }

}

