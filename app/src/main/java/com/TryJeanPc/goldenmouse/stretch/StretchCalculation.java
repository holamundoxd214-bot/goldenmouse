package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation;", "", "Valid", "Invalid", "Insufficient", "Unsupported", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation$Insufficient;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation$Invalid;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation$Unsupported;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation$Valid;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface StretchCalculation {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation$Insufficient;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation;", "reason", "Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;)V", "getReason", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Insufficient implements StretchCalculation {
        public static final int $stable;
        private final StretchIssue reason;

        static {
        }

        public Insufficient(StretchIssue arg2) {
            Intrinsics.checkNotNullParameter(arg2, "reason");
            super();
            this.reason = arg2;
        }

        public final StretchIssue component1() {
            return this.reason;
        }

        public final Insufficient copy(StretchIssue arg1) {
            Intrinsics.checkNotNullParameter(arg1, "reason");
            return new Insufficient(arg1);
        }

        public static Insufficient copy$default(Insufficient arg0, StretchIssue arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.reason;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Insufficient)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Insufficient)) {
                return 0;
            }

            if(this.reason != ((Insufficient)arg4).reason) {
                return 0;
            }

            return 1;
        }

        public final StretchIssue getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Insufficient(reason=" + this.reason + ")";
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation$Invalid;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation;", "reason", "Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;)V", "getReason", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Invalid implements StretchCalculation {
        public static final int $stable;
        private final StretchIssue reason;

        static {
        }

        public Invalid(StretchIssue arg2) {
            Intrinsics.checkNotNullParameter(arg2, "reason");
            super();
            this.reason = arg2;
        }

        public final StretchIssue component1() {
            return this.reason;
        }

        public final Invalid copy(StretchIssue arg1) {
            Intrinsics.checkNotNullParameter(arg1, "reason");
            return new Invalid(arg1);
        }

        public static Invalid copy$default(Invalid arg0, StretchIssue arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.reason;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Invalid)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Invalid)) {
                return 0;
            }

            if(this.reason != ((Invalid)arg4).reason) {
                return 0;
            }

            return 1;
        }

        public final StretchIssue getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Invalid(reason=" + this.reason + ")";
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation$Unsupported;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation;", "reason", "Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;)V", "getReason", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchIssue;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Unsupported implements StretchCalculation {
        public static final int $stable;
        private final StretchIssue reason;

        static {
        }

        public Unsupported(StretchIssue arg2) {
            Intrinsics.checkNotNullParameter(arg2, "reason");
            super();
            this.reason = arg2;
        }

        public final StretchIssue component1() {
            return this.reason;
        }

        public final Unsupported copy(StretchIssue arg1) {
            Intrinsics.checkNotNullParameter(arg1, "reason");
            return new Unsupported(arg1);
        }

        public static Unsupported copy$default(Unsupported arg0, StretchIssue arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.reason;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Unsupported)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Unsupported)) {
                return 0;
            }

            if(this.reason != ((Unsupported)arg4).reason) {
                return 0;
            }

            return 1;
        }

        public final StretchIssue getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Unsupported(reason=" + this.reason + ")";
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation$Valid;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation;", "plan", "Lcom/TryJeanPc/goldenmouse/stretch/StretchGeometryPlan;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchGeometryPlan;)V", "getPlan", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchGeometryPlan;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Valid implements StretchCalculation {
        public static final int $stable = 8;
        private final StretchGeometryPlan plan;

        static {
        }

        public Valid(StretchGeometryPlan arg2) {
            Intrinsics.checkNotNullParameter(arg2, "plan");
            super();
            this.plan = arg2;
        }

        public final StretchGeometryPlan component1() {
            return this.plan;
        }

        public final Valid copy(StretchGeometryPlan arg1) {
            Intrinsics.checkNotNullParameter(arg1, "plan");
            return new Valid(arg1);
        }

        public static Valid copy$default(Valid arg0, StretchGeometryPlan arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.plan;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Valid)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Valid)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.plan, ((Valid)arg4).plan)) {
                return 0;
            }

            return 1;
        }

        public final StretchGeometryPlan getPlan() {
            return this.plan;
        }

        public int hashCode() {
            return this.plan.hashCode();
        }

        public String toString() {
            return "Valid(plan=" + this.plan + ")";
        }
    }

}

