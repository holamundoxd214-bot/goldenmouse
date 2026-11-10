package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead;", "", "Available", "Unavailable", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead$Available;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead$Unavailable;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface StretchDisplayRead {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead$Available;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead;", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplaySnapshot;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplaySnapshot;)V", "getSnapshot", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplaySnapshot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Available implements StretchDisplayRead {
        public static final int $stable;
        private final StretchDisplaySnapshot snapshot;

        static {
        }

        public Available(StretchDisplaySnapshot arg2) {
            Intrinsics.checkNotNullParameter(arg2, "snapshot");
            super();
            this.snapshot = arg2;
        }

        public final StretchDisplaySnapshot component1() {
            return this.snapshot;
        }

        public final Available copy(StretchDisplaySnapshot arg1) {
            Intrinsics.checkNotNullParameter(arg1, "snapshot");
            return new Available(arg1);
        }

        public static Available copy$default(Available arg0, StretchDisplaySnapshot arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.snapshot;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Available)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Available)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.snapshot, ((Available)arg4).snapshot)) {
                return 0;
            }

            return 1;
        }

        public final StretchDisplaySnapshot getSnapshot() {
            return this.snapshot;
        }

        public int hashCode() {
            return this.snapshot.hashCode();
        }

        public String toString() {
            return "Available(snapshot=" + this.snapshot + ")";
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead$Unavailable;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead;", "reason", "Lcom/TryJeanPc/goldenmouse/stretch/StretchReadIssue;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchReadIssue;)V", "getReason", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchReadIssue;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Unavailable implements StretchDisplayRead {
        public static final int $stable;
        private final StretchReadIssue reason;

        static {
        }

        public Unavailable(StretchReadIssue arg2) {
            Intrinsics.checkNotNullParameter(arg2, "reason");
            super();
            this.reason = arg2;
        }

        public final StretchReadIssue component1() {
            return this.reason;
        }

        public final Unavailable copy(StretchReadIssue arg1) {
            Intrinsics.checkNotNullParameter(arg1, "reason");
            return new Unavailable(arg1);
        }

        public static Unavailable copy$default(Unavailable arg0, StretchReadIssue arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.reason;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Unavailable)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Unavailable)) {
                return 0;
            }

            if(this.reason != ((Unavailable)arg4).reason) {
                return 0;
            }

            return 1;
        }

        public final StretchReadIssue getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Unavailable(reason=" + this.reason + ")";
        }
    }

}

