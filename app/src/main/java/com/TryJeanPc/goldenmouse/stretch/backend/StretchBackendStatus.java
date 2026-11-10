package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u001C\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0005HÆ\u0003J\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001F\u001A\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001A\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000B\u0010!\u001A\u0004\u0018\u00010\fHÆ\u0003JR\u0010\"\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001A\u00020\u00072\b\u0010%\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001A\u00020\nHÖ\u0001J\t\u0010\'\u001A\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014R\u0015\u0010\b\u001A\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0016\u0010\u0014R\u0015\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001B¨\u0006("}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "", "backend", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "state", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendState;", "connected", "", "authorized", "serverUid", "", "detail", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendState;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getBackend", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "getState", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendState;", "getConnected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAuthorized", "getServerUid", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDetail", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendState;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchBackendStatus {
    public static final int $stable;
    private final Boolean authorized;
    private final StretchBackendType backend;
    private final Boolean connected;
    private final String detail;
    private final Integer serverUid;
    private final StretchBackendState state;

    static {
    }

    public StretchBackendStatus(StretchBackendType arg2, StretchBackendState arg3, Boolean arg4, Boolean arg5, Integer arg6, String arg7, int arg8, DefaultConstructorMarker arg9) {
        Boolean v0 = null;
        if((arg8 & 4) != 0) {
            arg4 = v0;
        }

        if((arg8 & 8) != 0) {
            arg5 = v0;
        }

        if((arg8 & 16) != 0) {
            arg6 = ((Integer)v0);
        }

        if((arg8 & 0x20) != 0) {
            arg7 = ((String)v0);
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public StretchBackendStatus(StretchBackendType arg2, StretchBackendState arg3, Boolean arg4, Boolean arg5, Integer arg6, String arg7) {
        Intrinsics.checkNotNullParameter(arg2, "backend");
        Intrinsics.checkNotNullParameter(arg3, "state");
        super();
        this.backend = arg2;
        this.state = arg3;
        this.connected = arg4;
        this.authorized = arg5;
        this.serverUid = arg6;
        this.detail = arg7;
    }

    public final StretchBackendType component1() {
        return this.backend;
    }

    public final StretchBackendState component2() {
        return this.state;
    }

    public final Boolean component3() {
        return this.connected;
    }

    public final Boolean component4() {
        return this.authorized;
    }

    public final Integer component5() {
        return this.serverUid;
    }

    public final String component6() {
        return this.detail;
    }

    public final StretchBackendStatus copy(StretchBackendType arg8, StretchBackendState arg9, Boolean arg10, Boolean arg11, Integer arg12, String arg13) {
        Intrinsics.checkNotNullParameter(arg8, "backend");
        Intrinsics.checkNotNullParameter(arg9, "state");
        return new StretchBackendStatus(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public static StretchBackendStatus copy$default(StretchBackendStatus arg0, StretchBackendType arg1, StretchBackendState arg2, Boolean arg3, Boolean arg4, Integer arg5, String arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.backend;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.state;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.connected;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.authorized;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.serverUid;
        }

        if((arg7 & 0x20) != 0) {
            arg6 = arg0.detail;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchBackendStatus)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchBackendStatus)) {
            return 0;
        }

        if(this.backend != ((StretchBackendStatus)arg5).backend) {
            return 0;
        }

        if(this.state != ((StretchBackendStatus)arg5).state) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.connected, ((StretchBackendStatus)arg5).connected)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.authorized, ((StretchBackendStatus)arg5).authorized)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.serverUid, ((StretchBackendStatus)arg5).serverUid)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.detail, ((StretchBackendStatus)arg5).detail)) {
            return 0;
        }

        return 1;
    }

    public final Boolean getAuthorized() {
        return this.authorized;
    }

    public final StretchBackendType getBackend() {
        return this.backend;
    }

    public final Boolean getConnected() {
        return this.connected;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final Integer getServerUid() {
        return this.serverUid;
    }

    public final StretchBackendState getState() {
        return this.state;
    }

    public int hashCode() {
        int v0 = (this.backend.hashCode() * 0x1F + this.state.hashCode()) * 0x1F;
        Boolean v1 = this.connected;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.authorized;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        Integer v1_2 = this.serverUid;
        v1_1 = v1_2 == null ? 0 : v1_2.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        String v3 = this.detail;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "StretchBackendStatus(backend=" + this.backend + ", state=" + this.state + ", connected=" + this.connected + ", authorized=" + this.authorized + ", serverUid=" + this.serverUid + ", detail=" + this.detail + ")";
    }
}

