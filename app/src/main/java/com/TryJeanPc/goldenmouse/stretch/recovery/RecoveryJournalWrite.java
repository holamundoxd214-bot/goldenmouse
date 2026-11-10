package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalWrite;", "", "Committed", "Rejected", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalWrite$Committed;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalWrite$Rejected;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface RecoveryJournalWrite {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalWrite$Committed;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalWrite;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Committed implements RecoveryJournalWrite {
        public static final int $stable;
        public static final Committed INSTANCE;

        static {
            Committed.INSTANCE = new Committed();
        }

        private Committed() {
            super();
        }

        public boolean equals(Object arg2) {
            if(this == (((Committed)arg2))) {
                return 1;
            }

            if(!(arg2 instanceof Committed)) {
                return 0;
            }

            return 1;
        }

        public int hashCode() {
            return -2007163804;
        }

        public String toString() {
            return "Committed";
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalWrite$Rejected;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryJournalWrite;", "error", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;)V", "getError", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Rejected implements RecoveryJournalWrite {
        public static final int $stable;
        private final RecoveryError error;

        static {
        }

        public Rejected(RecoveryError arg2) {
            Intrinsics.checkNotNullParameter(arg2, "error");
            super();
            this.error = arg2;
        }

        public final RecoveryError component1() {
            return this.error;
        }

        public final Rejected copy(RecoveryError arg1) {
            Intrinsics.checkNotNullParameter(arg1, "error");
            return new Rejected(arg1);
        }

        public static Rejected copy$default(Rejected arg0, RecoveryError arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.error;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Rejected)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Rejected)) {
                return 0;
            }

            if(this.error != ((Rejected)arg4).error) {
                return 0;
            }

            return 1;
        }

        public final RecoveryError getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Rejected(error=" + this.error + ")";
        }
    }

}

