package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReadiness;", "", "SimulationReady", "NotRecoverable", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReadiness$NotRecoverable;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReadiness$SimulationReady;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface RecoveryReadiness {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EHÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReadiness$NotRecoverable;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReadiness;", "reasons", "", "", "<init>", "(Ljava/util/Set;)V", "getReasons", "()Ljava/util/Set;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class NotRecoverable implements RecoveryReadiness {
        public static final int $stable = 8;
        private final Set reasons;

        static {
        }

        public NotRecoverable(Set arg2) {
            Intrinsics.checkNotNullParameter(arg2, "reasons");
            super();
            this.reasons = arg2;
        }

        public final Set component1() {
            return this.reasons;
        }

        public final NotRecoverable copy(Set arg1) {
            Intrinsics.checkNotNullParameter(arg1, "reasons");
            return new NotRecoverable(arg1);
        }

        public static NotRecoverable copy$default(NotRecoverable arg0, Set arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.reasons;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((NotRecoverable)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof NotRecoverable)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.reasons, ((NotRecoverable)arg4).reasons)) {
                return 0;
            }

            return 1;
        }

        public final Set getReasons() {
            return this.reasons;
        }

        public int hashCode() {
            return this.reasons.hashCode();
        }

        public String toString() {
            return "NotRecoverable(reasons=" + this.reasons + ")";
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReadiness$SimulationReady;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReadiness;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class SimulationReady implements RecoveryReadiness {
        public static final int $stable;
        public static final SimulationReady INSTANCE;

        static {
            SimulationReady.INSTANCE = new SimulationReady();
        }

        private SimulationReady() {
            super();
        }

        public boolean equals(Object arg2) {
            if(this == (((SimulationReady)arg2))) {
                return 1;
            }

            if(!(arg2 instanceof SimulationReady)) {
                return 0;
            }

            return 1;
        }

        public int hashCode() {
            return 0x935950EA;
        }

        public String toString() {
            return "SimulationReady";
        }
    }

}

