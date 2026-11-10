package com.TryJeanPc.goldenmouse.aim;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition;", "", "<init>", "()V", "Request", "Status", "Result", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AimModeTransition {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001A\u00020\bHÆ\u0003J1\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001A\u00020\b2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u0006HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;", "", "sequenceId", "", "sessionId", "phase", "", "active", "", "<init>", "(JJIZ)V", "getSequenceId", "()J", "getSessionId", "getPhase", "()I", "getActive", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Request {
        public static final int $stable;
        private final boolean active;
        private final int phase;
        private final long sequenceId;
        private final long sessionId;

        static {
        }

        public Request(long arg1, long arg3, int arg5, boolean arg6) {
            super();
            this.sequenceId = arg1;
            this.sessionId = arg3;
            this.phase = arg5;
            this.active = arg6;
        }

        public final long component1() {
            return this.sequenceId;
        }

        public final long component2() {
            return this.sessionId;
        }

        public final int component3() {
            return this.phase;
        }

        public final boolean component4() {
            return this.active;
        }

        public final Request copy(long arg1, long arg3, int arg5, boolean arg6) {
            return new Request(arg1, arg3, arg5, arg6);
        }

        public static Request copy$default(Request arg7, long arg8, long arg10, int arg12, boolean arg13, int arg14, Object arg15) {
            if((arg14 & 1) != 0) {
                arg8 = arg7.sequenceId;
            }

            long v1 = arg8;
            if((arg14 & 2) != 0) {
                arg10 = arg7.sessionId;
            }

            long v3 = arg10;
            if((arg14 & 4) != 0) {
                arg12 = arg7.phase;
            }

            int v5 = arg12;
            if((arg14 & 8) != 0) {
                arg13 = arg7.active;
            }

            return arg7.copy(v1, v3, v5, arg13);
        }

        public boolean equals(Object arg8) {
            if(this == (((Request)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Request)) {
                return 0;
            }

            if(this.sequenceId != ((Request)arg8).sequenceId) {
                return 0;
            }

            if(this.sessionId != ((Request)arg8).sessionId) {
                return 0;
            }

            if(this.phase != ((Request)arg8).phase) {
                return 0;
            }

            if(this.active != ((Request)arg8).active) {
                return 0;
            }

            return 1;
        }

        public final boolean getActive() {
            return this.active;
        }

        public final int getPhase() {
            return this.phase;
        }

        public final long getSequenceId() {
            return this.sequenceId;
        }

        public final long getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            return ((Long.hashCode(this.sequenceId) * 0x1F + Long.hashCode(this.sessionId)) * 0x1F + Integer.hashCode(this.phase)) * 0x1F + Boolean.hashCode(this.active);
        }

        public String toString() {
            return "Request(sequenceId=" + this.sequenceId + ", sessionId=" + this.sessionId + ", phase=" + this.phase + ", active=" + this.active + ")";
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Result;", "", "request", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;", "cameraRevision", "", "status", "Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Status;", "<init>", "(Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;JLcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Status;)V", "getRequest", "()Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Request;", "getCameraRevision", "()J", "getStatus", "()Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Status;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Result {
        public static final int $stable;
        private final long cameraRevision;
        private final Request request;
        private final Status status;

        static {
        }

        public Result(Request arg2, long arg3, Status arg5) {
            Intrinsics.checkNotNullParameter(arg2, "request");
            Intrinsics.checkNotNullParameter(arg5, "status");
            super();
            this.request = arg2;
            this.cameraRevision = arg3;
            this.status = arg5;
        }

        public final Request component1() {
            return this.request;
        }

        public final long component2() {
            return this.cameraRevision;
        }

        public final Status component3() {
            return this.status;
        }

        public final Result copy(Request arg1, long arg2, Status arg4) {
            Intrinsics.checkNotNullParameter(arg1, "request");
            Intrinsics.checkNotNullParameter(arg4, "status");
            return new Result(arg1, arg2, arg4);
        }

        public static Result copy$default(Result arg0, Request arg1, long arg2, Status arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.request;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.cameraRevision;
            }

            if((arg5 & 4) != 0) {
                arg4 = arg0.status;
            }

            return arg0.copy(arg1, arg2, arg4);
        }

        public boolean equals(Object arg8) {
            if(this == (((Result)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Result)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.request, ((Result)arg8).request)) {
                return 0;
            }

            if(this.cameraRevision != ((Result)arg8).cameraRevision) {
                return 0;
            }

            if(this.status != ((Result)arg8).status) {
                return 0;
            }

            return 1;
        }

        public final long getCameraRevision() {
            return this.cameraRevision;
        }

        public final Request getRequest() {
            return this.request;
        }

        public final Status getStatus() {
            return this.status;
        }

        public int hashCode() {
            return (this.request.hashCode() * 0x1F + Long.hashCode(this.cameraRevision)) * 0x1F + this.status.hashCode();
        }

        public String toString() {
            return "Result(request=" + this.request + ", cameraRevision=" + this.cameraRevision + ", status=" + this.status + ")";
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/aim/AimModeTransition$Status;", "", "<init>", "(Ljava/lang/String;I)V", "COMPLETED", "CANCELLED", "FAILED", "STALE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Status {
        public static final enum Status CANCELLED;
        public static final enum Status COMPLETED;
        public static final enum Status FAILED;
        public static final enum Status STALE;

        private static final Status[] $values() {
            return new Status[]{Status.COMPLETED, Status.CANCELLED, Status.FAILED, Status.STALE};
        }

        static {
            Status.COMPLETED = new Status("COMPLETED", 0);
            Status.CANCELLED = new Status("CANCELLED", 1);
            Status.FAILED = new Status("FAILED", 2);
            Status.STALE = new Status("STALE", 3);
            Status[] v0 = Status.$values();
            Status.$VALUES = v0;
            Status.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Status(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Status.$ENTRIES;
        }

        public static Status valueOf(String arg1) {
            return Enum.valueOf(Status.class, arg1);
        }

        public static Status[] values() {
            return Status.$VALUES.clone();
        }
    }

    public static final int $stable;
    public static final AimModeTransition INSTANCE;

    static {
        AimModeTransition.INSTANCE = new AimModeTransition();
    }

    private AimModeTransition() {
        super();
    }
}

