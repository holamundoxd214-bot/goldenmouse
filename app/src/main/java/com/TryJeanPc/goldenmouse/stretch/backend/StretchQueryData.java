package com.TryJeanPc.goldenmouse.stretch.backend;

import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;", "", "Uid", "DisplaySize", "Density", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData$Density;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData$DisplaySize;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData$Uid;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface StretchQueryData {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000FJ\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\n¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData$Density;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;", "reportedPhysical", "", "reportedOverride", "<init>", "(ILjava/lang/Integer;)V", "getReportedPhysical", "()I", "getReportedOverride", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData$Density;", "equals", "", "other", "", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Density implements StretchQueryData {
        public static final int $stable;
        private final Integer reportedOverride;
        private final int reportedPhysical;

        static {
        }

        public Density(int arg1, Integer arg2) {
            super();
            this.reportedPhysical = arg1;
            this.reportedOverride = arg2;
        }

        public final int component1() {
            return this.reportedPhysical;
        }

        public final Integer component2() {
            return this.reportedOverride;
        }

        public final Density copy(int arg1, Integer arg2) {
            return new Density(arg1, arg2);
        }

        public static Density copy$default(Density arg0, int arg1, Integer arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.reportedPhysical;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.reportedOverride;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Density)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Density)) {
                return 0;
            }

            if(this.reportedPhysical != ((Density)arg5).reportedPhysical) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.reportedOverride, ((Density)arg5).reportedOverride)) {
                return 0;
            }

            return 1;
        }

        public final Integer getReportedOverride() {
            return this.reportedOverride;
        }

        public final int getReportedPhysical() {
            return this.reportedPhysical;
        }

        public int hashCode() {
            int v0 = Integer.hashCode(this.reportedPhysical) * 0x1F;
            Integer v1 = this.reportedOverride;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return v0 + v1_1;
        }

        public String toString() {
            return "Density(reportedPhysical=" + this.reportedPhysical + ", reportedOverride=" + this.reportedOverride + ")";
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u000B\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u001F\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData$DisplaySize;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;", "reportedPhysical", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "reportedOverride", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;)V", "getReportedPhysical", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "getReportedOverride", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class DisplaySize implements StretchQueryData {
        public static final int $stable;
        private final StretchSize reportedOverride;
        private final StretchSize reportedPhysical;

        static {
        }

        public DisplaySize(StretchSize arg2, StretchSize arg3) {
            Intrinsics.checkNotNullParameter(arg2, "reportedPhysical");
            super();
            this.reportedPhysical = arg2;
            this.reportedOverride = arg3;
        }

        public final StretchSize component1() {
            return this.reportedPhysical;
        }

        public final StretchSize component2() {
            return this.reportedOverride;
        }

        public final DisplaySize copy(StretchSize arg1, StretchSize arg2) {
            Intrinsics.checkNotNullParameter(arg1, "reportedPhysical");
            return new DisplaySize(arg1, arg2);
        }

        public static DisplaySize copy$default(DisplaySize arg0, StretchSize arg1, StretchSize arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.reportedPhysical;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.reportedOverride;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((DisplaySize)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof DisplaySize)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.reportedPhysical, ((DisplaySize)arg5).reportedPhysical)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.reportedOverride, ((DisplaySize)arg5).reportedOverride)) {
                return 0;
            }

            return 1;
        }

        public final StretchSize getReportedOverride() {
            return this.reportedOverride;
        }

        public final StretchSize getReportedPhysical() {
            return this.reportedPhysical;
        }

        public int hashCode() {
            int v0 = this.reportedPhysical.hashCode() * 0x1F;
            StretchSize v1 = this.reportedOverride;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return v0 + v1_1;
        }

        public String toString() {
            return "DisplaySize(reportedPhysical=" + this.reportedPhysical + ", reportedOverride=" + this.reportedOverride + ")";
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÖ\u0001J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData$Uid;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;", "value", "", "<init>", "(I)V", "getValue", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Uid implements StretchQueryData {
        public static final int $stable;
        private final int value;

        static {
        }

        public Uid(int arg1) {
            super();
            this.value = arg1;
        }

        public final int component1() {
            return this.value;
        }

        public final Uid copy(int arg1) {
            return new Uid(arg1);
        }

        public static Uid copy$default(Uid arg0, int arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.value;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((Uid)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Uid)) {
                return 0;
            }

            if(this.value != ((Uid)arg4).value) {
                return 0;
            }

            return 1;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return Integer.hashCode(this.value);
        }

        public String toString() {
            return "Uid(value=" + this.value + ")";
        }
    }

}

