package com.TryJeanPc.goldenmouse.stretch.recovery;

import com.TryJeanPc.goldenmouse.stretch.backend.StretchBackendType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0005HÆ\u0003J\t\u0010 \u001A\u00020\u0003HÆ\u0003J\t\u0010!\u001A\u00020\bHÆ\u0003J\t\u0010\"\u001A\u00020\nHÆ\u0003J\t\u0010#\u001A\u00020\fHÆ\u0003J\t\u0010$\u001A\u00020\u000EHÆ\u0003JO\u0010%\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000EHÆ\u0001J\u0013\u0010&\u001A\u00020\'2\b\u0010(\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001A\u00020\u0003HÖ\u0001J\t\u0010*\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001D¨\u0006+"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "", "schemaVersion", "", "sessionId", "", "androidApi", "backend", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "capturedAtWallMillis", "", "captureSource", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;", "original", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;", "<init>", "(ILjava/lang/String;ILcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;JLcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;)V", "getSchemaVersion", "()I", "getSessionId", "()Ljava/lang/String;", "getAndroidApi", "getBackend", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "getCapturedAtWallMillis", "()J", "getCaptureSource", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySource;", "getOriginal", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoverySnapshot {
    public static final int $stable;
    private final int androidApi;
    private final StretchBackendType backend;
    private final RecoverySource captureSource;
    private final long capturedAtWallMillis;
    private final StretchOriginalDisplayState original;
    private final int schemaVersion;
    private final String sessionId;

    static {
    }

    public StretchRecoverySnapshot(int arg2, String arg3, int arg4, StretchBackendType arg5, long arg6, RecoverySource arg8, StretchOriginalDisplayState arg9) {
        Intrinsics.checkNotNullParameter(arg3, "sessionId");
        Intrinsics.checkNotNullParameter(arg5, "backend");
        Intrinsics.checkNotNullParameter(arg8, "captureSource");
        Intrinsics.checkNotNullParameter(arg9, "original");
        super();
        this.schemaVersion = arg2;
        this.sessionId = arg3;
        this.androidApi = arg4;
        this.backend = arg5;
        this.capturedAtWallMillis = arg6;
        this.captureSource = arg8;
        this.original = arg9;
    }

    public final int component1() {
        return this.schemaVersion;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final int component3() {
        return this.androidApi;
    }

    public final StretchBackendType component4() {
        return this.backend;
    }

    public final long component5() {
        return this.capturedAtWallMillis;
    }

    public final RecoverySource component6() {
        return this.captureSource;
    }

    public final StretchOriginalDisplayState component7() {
        return this.original;
    }

    public final StretchRecoverySnapshot copy(int arg10, String arg11, int arg12, StretchBackendType arg13, long arg14, RecoverySource arg16, StretchOriginalDisplayState arg17) {
        Intrinsics.checkNotNullParameter(arg11, "sessionId");
        Intrinsics.checkNotNullParameter(arg13, "backend");
        Intrinsics.checkNotNullParameter(arg16, "captureSource");
        Intrinsics.checkNotNullParameter(arg17, "original");
        return new StretchRecoverySnapshot(arg10, arg11, arg12, arg13, arg14, arg16, arg17);
    }

    public static StretchRecoverySnapshot copy$default(StretchRecoverySnapshot arg0, int arg1, String arg2, int arg3, StretchBackendType arg4, long arg5, RecoverySource arg7, StretchOriginalDisplayState arg8, int arg9, Object arg10) {
        if((arg9 & 1) != 0) {
            arg1 = arg0.schemaVersion;
        }

        if((arg9 & 2) != 0) {
            arg2 = arg0.sessionId;
        }

        if((arg9 & 4) != 0) {
            arg3 = arg0.androidApi;
        }

        if((arg9 & 8) != 0) {
            arg4 = arg0.backend;
        }

        if((arg9 & 16) != 0) {
            arg5 = arg0.capturedAtWallMillis;
        }

        if((arg9 & 0x20) != 0) {
            arg7 = arg0.captureSource;
        }

        if((arg9 & 0x40) != 0) {
            arg8 = arg0.original;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg7, arg8);
    }

    public boolean equals(Object arg8) {
        if(this == (((StretchRecoverySnapshot)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof StretchRecoverySnapshot)) {
            return 0;
        }

        if(this.schemaVersion != ((StretchRecoverySnapshot)arg8).schemaVersion) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sessionId, ((StretchRecoverySnapshot)arg8).sessionId)) {
            return 0;
        }

        if(this.androidApi != ((StretchRecoverySnapshot)arg8).androidApi) {
            return 0;
        }

        if(this.backend != ((StretchRecoverySnapshot)arg8).backend) {
            return 0;
        }

        if(this.capturedAtWallMillis != ((StretchRecoverySnapshot)arg8).capturedAtWallMillis) {
            return 0;
        }

        if(this.captureSource != ((StretchRecoverySnapshot)arg8).captureSource) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.original, ((StretchRecoverySnapshot)arg8).original)) {
            return 0;
        }

        return 1;
    }

    public final int getAndroidApi() {
        return this.androidApi;
    }

    public final StretchBackendType getBackend() {
        return this.backend;
    }

    public final RecoverySource getCaptureSource() {
        return this.captureSource;
    }

    public final long getCapturedAtWallMillis() {
        return this.capturedAtWallMillis;
    }

    public final StretchOriginalDisplayState getOriginal() {
        return this.original;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.schemaVersion) * 0x1F + this.sessionId.hashCode()) * 0x1F + Integer.hashCode(this.androidApi)) * 0x1F + this.backend.hashCode()) * 0x1F + Long.hashCode(this.capturedAtWallMillis)) * 0x1F + this.captureSource.hashCode()) * 0x1F + this.original.hashCode();
    }

    public String toString() {
        return "StretchRecoverySnapshot(schemaVersion=" + this.schemaVersion + ", sessionId=" + this.sessionId + ", androidApi=" + this.androidApi + ", backend=" + this.backend + ", capturedAtWallMillis=" + this.capturedAtWallMillis + ", captureSource=" + this.captureSource + ", original=" + this.original + ")";
    }
}

