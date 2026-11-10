package com.TryJeanPc.goldenmouse.stretch.backend;

import com.TryJeanPc.goldenmouse.stretch.StretchDisplayRead;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\t\u0012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\t¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001F\u001A\u00020\u0003HÆ\u0003J\t\u0010 \u001A\u00020\u0005HÆ\u0003J\t\u0010!\u001A\u00020\u0007HÆ\u0003J\u000F\u0010\"\u001A\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010#\u001A\u00020\fHÆ\u0003J\u000F\u0010$\u001A\b\u0012\u0004\u0012\u00020\u000E0\tHÆ\u0003J\u000F\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00100\tHÆ\u0003Ja\u0010&\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\t2\u000E\b\u0002\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\tHÆ\u0001J\u0013\u0010\'\u001A\u00020(2\b\u0010)\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001A\u00020\u0005HÖ\u0001J\t\u0010+\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0017\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\t¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001AR\u0017\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\t¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001A¨\u0006,"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchCapabilityReport;", "", "sessionId", "", "androidApi", "", "publicDisplay", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead;", "backends", "", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "selectedBackend", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "verifiedQueries", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "capabilities", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchCapabilityResult;", "<init>", "(Ljava/lang/String;ILcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;Ljava/util/List;Ljava/util/List;)V", "getSessionId", "()Ljava/lang/String;", "getAndroidApi", "()I", "getPublicDisplay", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayRead;", "getBackends", "()Ljava/util/List;", "getSelectedBackend", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "getVerifiedQueries", "getCapabilities", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCapabilityReport {
    public static final int $stable = 8;
    private final int androidApi;
    private final List backends;
    private final List capabilities;
    private final StretchDisplayRead publicDisplay;
    private final StretchBackendType selectedBackend;
    private final String sessionId;
    private final List verifiedQueries;

    static {
    }

    public StretchCapabilityReport(String arg2, int arg3, StretchDisplayRead arg4, List arg5, StretchBackendType arg6, List arg7, List arg8) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        Intrinsics.checkNotNullParameter(arg4, "publicDisplay");
        Intrinsics.checkNotNullParameter(arg5, "backends");
        Intrinsics.checkNotNullParameter(arg6, "selectedBackend");
        Intrinsics.checkNotNullParameter(arg7, "verifiedQueries");
        Intrinsics.checkNotNullParameter(arg8, "capabilities");
        super();
        this.sessionId = arg2;
        this.androidApi = arg3;
        this.publicDisplay = arg4;
        this.backends = arg5;
        this.selectedBackend = arg6;
        this.verifiedQueries = arg7;
        this.capabilities = arg8;
    }

    public final String component1() {
        return this.sessionId;
    }

    public final int component2() {
        return this.androidApi;
    }

    public final StretchDisplayRead component3() {
        return this.publicDisplay;
    }

    public final List component4() {
        return this.backends;
    }

    public final StretchBackendType component5() {
        return this.selectedBackend;
    }

    public final List component6() {
        return this.verifiedQueries;
    }

    public final List component7() {
        return this.capabilities;
    }

    public final StretchCapabilityReport copy(String arg9, int arg10, StretchDisplayRead arg11, List arg12, StretchBackendType arg13, List arg14, List arg15) {
        Intrinsics.checkNotNullParameter(arg9, "sessionId");
        Intrinsics.checkNotNullParameter(arg11, "publicDisplay");
        Intrinsics.checkNotNullParameter(arg12, "backends");
        Intrinsics.checkNotNullParameter(arg13, "selectedBackend");
        Intrinsics.checkNotNullParameter(arg14, "verifiedQueries");
        Intrinsics.checkNotNullParameter(arg15, "capabilities");
        return new StretchCapabilityReport(arg9, arg10, arg11, arg12, arg13, arg14, arg15);
    }

    public static StretchCapabilityReport copy$default(StretchCapabilityReport arg0, String arg1, int arg2, StretchDisplayRead arg3, List arg4, StretchBackendType arg5, List arg6, List arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.sessionId;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.androidApi;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.publicDisplay;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.backends;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.selectedBackend;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = arg0.verifiedQueries;
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.capabilities;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchCapabilityReport)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchCapabilityReport)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sessionId, ((StretchCapabilityReport)arg5).sessionId)) {
            return 0;
        }

        if(this.androidApi != ((StretchCapabilityReport)arg5).androidApi) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.publicDisplay, ((StretchCapabilityReport)arg5).publicDisplay)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.backends, ((StretchCapabilityReport)arg5).backends)) {
            return 0;
        }

        if(this.selectedBackend != ((StretchCapabilityReport)arg5).selectedBackend) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.verifiedQueries, ((StretchCapabilityReport)arg5).verifiedQueries)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.capabilities, ((StretchCapabilityReport)arg5).capabilities)) {
            return 0;
        }

        return 1;
    }

    public final int getAndroidApi() {
        return this.androidApi;
    }

    public final List getBackends() {
        return this.backends;
    }

    public final List getCapabilities() {
        return this.capabilities;
    }

    public final StretchDisplayRead getPublicDisplay() {
        return this.publicDisplay;
    }

    public final StretchBackendType getSelectedBackend() {
        return this.selectedBackend;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final List getVerifiedQueries() {
        return this.verifiedQueries;
    }

    public int hashCode() {
        return (((((this.sessionId.hashCode() * 0x1F + Integer.hashCode(this.androidApi)) * 0x1F + this.publicDisplay.hashCode()) * 0x1F + this.backends.hashCode()) * 0x1F + this.selectedBackend.hashCode()) * 0x1F + this.verifiedQueries.hashCode()) * 0x1F + this.capabilities.hashCode();
    }

    public String toString() {
        return "StretchCapabilityReport(sessionId=" + this.sessionId + ", androidApi=" + this.androidApi + ", publicDisplay=" + this.publicDisplay + ", backends=" + this.backends + ", selectedBackend=" + this.selectedBackend + ", verifiedQueries=" + this.verifiedQueries + ", capabilities=" + this.capabilities + ")";
    }
}

