package com.TryJeanPc.goldenmouse.stretch.backend;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\'\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0003\u0012\b\b\u0002\u0010\f\u001A\u00020\u0003\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\u000E\b\u0002\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\b\b\u0002\u0010\u0016\u001A\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00100\u001A\u00020\u0003HÆ\u0003J\t\u00101\u001A\u00020\u0003HÆ\u0003J\t\u00102\u001A\u00020\u0006HÆ\u0003J\t\u00103\u001A\u00020\bHÆ\u0003J\t\u00104\u001A\u00020\nHÆ\u0003J\t\u00105\u001A\u00020\u0003HÆ\u0003J\t\u00106\u001A\u00020\u0003HÆ\u0003J\u0010\u00107\u001A\u0004\u0018\u00010\u000EHÆ\u0003¢\u0006\u0002\u0010&J\u000B\u00108\u001A\u0004\u0018\u00010\u0010HÆ\u0003J\u000B\u00109\u001A\u0004\u0018\u00010\u0012HÆ\u0003J\u000F\u0010:\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003J\t\u0010;\u001A\u00020\u0017HÆ\u0003J\u0092\u0001\u0010<\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00122\u000E\b\u0002\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u0016\u001A\u00020\u0017HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001A\u00020?2\b\u0010@\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001A\u00020\u000EHÖ\u0001J\t\u0010B\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001BR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0011\u0010\u000B\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u001BR\u0011\u0010\f\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001BR\u0015\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\n\n\u0002\u0010\'\u001A\u0004\b%\u0010&R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001A\u0004\b(\u0010)R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u0017\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-R\u0011\u0010\u0016\u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b.\u0010/¨\u0006C"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchOperationResult;", "", "operationId", "", "sessionId", "backend", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "query", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "status", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchExecutionStatus;", "stdout", "stderr", "exitCode", "", "data", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;", "error", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "backends", "", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "elapsedMillis", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchExecutionStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;Ljava/util/List;J)V", "getOperationId", "()Ljava/lang/String;", "getSessionId", "getBackend", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "getQuery", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "getStatus", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchExecutionStatus;", "getStdout", "getStderr", "getExitCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;", "getError", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "getBackends", "()Ljava/util/List;", "getElapsedMillis", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchExecutionStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;Ljava/util/List;J)Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchOperationResult;", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOperationResult {
    public static final int $stable = 8;
    private final StretchBackendType backend;
    private final List backends;
    private final StretchQueryData data;
    private final long elapsedMillis;
    private final StretchTransportError error;
    private final Integer exitCode;
    private final String operationId;
    private final StretchQuery query;
    private final String sessionId;
    private final StretchExecutionStatus status;
    private final String stderr;
    private final String stdout;

    static {
    }

    public StretchOperationResult(String arg2, String arg3, StretchBackendType arg4, StretchQuery arg5, StretchExecutionStatus arg6, String arg7, String arg8, Integer arg9, StretchQueryData arg10, StretchTransportError arg11, List arg12, long arg13) {
        Intrinsics.checkNotNullParameter(arg2, "operationId");
        Intrinsics.checkNotNullParameter(arg3, "sessionId");
        Intrinsics.checkNotNullParameter(arg4, "backend");
        Intrinsics.checkNotNullParameter(arg5, "query");
        Intrinsics.checkNotNullParameter(arg6, "status");
        Intrinsics.checkNotNullParameter(arg7, "stdout");
        Intrinsics.checkNotNullParameter(arg8, "stderr");
        Intrinsics.checkNotNullParameter(arg12, "backends");
        super();
        this.operationId = arg2;
        this.sessionId = arg3;
        this.backend = arg4;
        this.query = arg5;
        this.status = arg6;
        this.stdout = arg7;
        this.stderr = arg8;
        this.exitCode = arg9;
        this.data = arg10;
        this.error = arg11;
        this.backends = arg12;
        this.elapsedMillis = arg13;
    }

    public StretchOperationResult(String arg18, String arg19, StretchBackendType arg20, StretchQuery arg21, StretchExecutionStatus arg22, String arg23, String arg24, Integer arg25, StretchQueryData arg26, StretchTransportError arg27, List arg28, long arg29, int arg31, DefaultConstructorMarker arg32) {
        int v0 = arg31;
        String v2 = "";
        String v9 = (v0 & 0x20) != 0 ? v2 : arg23;
        String v10 = (v0 & 0x40) != 0 ? v2 : arg24;
        Integer v2_1 = null;
        Integer v11 = (v0 & 0x80) != 0 ? v2_1 : arg25;
        StretchQueryData v12 = (v0 & 0x100) != 0 ? ((StretchQueryData)v2_1) : arg26;
        StretchTransportError v13 = (v0 & 0x200) != 0 ? ((StretchTransportError)v2_1) : arg27;
        List v14 = (v0 & 0x400) != 0 ? CollectionsKt.emptyList() : arg28;
        long v15 = (v0 & 0x800) != 0 ? 0 : arg29;
        this(arg18, arg19, arg20, arg21, arg22, v9, v10, v11, v12, v13, v14, v15);
    }

    public final String component1() {
        return this.operationId;
    }

    public final StretchTransportError component10() {
        return this.error;
    }

    public final List component11() {
        return this.backends;
    }

    public final long component12() {
        return this.elapsedMillis;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final StretchBackendType component3() {
        return this.backend;
    }

    public final StretchQuery component4() {
        return this.query;
    }

    public final StretchExecutionStatus component5() {
        return this.status;
    }

    public final String component6() {
        return this.stdout;
    }

    public final String component7() {
        return this.stderr;
    }

    public final Integer component8() {
        return this.exitCode;
    }

    public final StretchQueryData component9() {
        return this.data;
    }

    public final StretchOperationResult copy(String arg15, String arg16, StretchBackendType arg17, StretchQuery arg18, StretchExecutionStatus arg19, String arg20, String arg21, Integer arg22, StretchQueryData arg23, StretchTransportError arg24, List arg25, long arg26) {
        Intrinsics.checkNotNullParameter(arg15, "operationId");
        Intrinsics.checkNotNullParameter(arg16, "sessionId");
        Intrinsics.checkNotNullParameter(arg17, "backend");
        Intrinsics.checkNotNullParameter(arg18, "query");
        Intrinsics.checkNotNullParameter(arg19, "status");
        Intrinsics.checkNotNullParameter(arg20, "stdout");
        Intrinsics.checkNotNullParameter(arg21, "stderr");
        Intrinsics.checkNotNullParameter(arg25, "backends");
        return new StretchOperationResult(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26);
    }

    public static StretchOperationResult copy$default(StretchOperationResult arg14, String arg15, String arg16, StretchBackendType arg17, StretchQuery arg18, StretchExecutionStatus arg19, String arg20, String arg21, Integer arg22, StretchQueryData arg23, StretchTransportError arg24, List arg25, long arg26, int arg28, Object arg29) {
        int v0 = arg28;
        String v1 = (v0 & 1) != 0 ? arg14.operationId : arg15;
        String v2 = (v0 & 2) != 0 ? arg14.sessionId : arg16;
        StretchBackendType v3 = (v0 & 4) != 0 ? arg14.backend : arg17;
        StretchQuery v4 = (v0 & 8) != 0 ? arg14.query : arg18;
        StretchExecutionStatus v5 = (v0 & 16) != 0 ? arg14.status : arg19;
        String v6 = (v0 & 0x20) != 0 ? arg14.stdout : arg20;
        String v7 = (v0 & 0x40) != 0 ? arg14.stderr : arg21;
        Integer v8 = (v0 & 0x80) != 0 ? arg14.exitCode : arg22;
        StretchQueryData v9 = (v0 & 0x100) != 0 ? arg14.data : arg23;
        StretchTransportError v10 = (v0 & 0x200) != 0 ? arg14.error : arg24;
        List v11 = (v0 & 0x400) != 0 ? arg14.backends : arg25;
        long v27 = (v0 & 0x800) != 0 ? arg14.elapsedMillis : arg26;
        return arg14.copy(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v27);
    }

    public boolean equals(Object arg6) {
        if(this == (((StretchOperationResult)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof StretchOperationResult)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.operationId, ((StretchOperationResult)arg6).operationId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sessionId, ((StretchOperationResult)arg6).sessionId)) {
            return 0;
        }

        if(this.backend != ((StretchOperationResult)arg6).backend) {
            return 0;
        }

        if(this.query != ((StretchOperationResult)arg6).query) {
            return 0;
        }

        if(this.status != ((StretchOperationResult)arg6).status) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.stdout, ((StretchOperationResult)arg6).stdout)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.stderr, ((StretchOperationResult)arg6).stderr)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.exitCode, ((StretchOperationResult)arg6).exitCode)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.data, ((StretchOperationResult)arg6).data)) {
            return 0;
        }

        if(this.error != ((StretchOperationResult)arg6).error) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.backends, ((StretchOperationResult)arg6).backends)) {
            return 0;
        }

        if(this.elapsedMillis != ((StretchOperationResult)arg6).elapsedMillis) {
            return 0;
        }

        return 1;
    }

    public final StretchBackendType getBackend() {
        return this.backend;
    }

    public final List getBackends() {
        return this.backends;
    }

    public final StretchQueryData getData() {
        return this.data;
    }

    public final long getElapsedMillis() {
        return this.elapsedMillis;
    }

    public final StretchTransportError getError() {
        return this.error;
    }

    public final Integer getExitCode() {
        return this.exitCode;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final StretchQuery getQuery() {
        return this.query;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final StretchExecutionStatus getStatus() {
        return this.status;
    }

    public final String getStderr() {
        return this.stderr;
    }

    public final String getStdout() {
        return this.stdout;
    }

    public int hashCode() {
        int v0 = ((((((this.operationId.hashCode() * 0x1F + this.sessionId.hashCode()) * 0x1F + this.backend.hashCode()) * 0x1F + this.query.hashCode()) * 0x1F + this.status.hashCode()) * 0x1F + this.stdout.hashCode()) * 0x1F + this.stderr.hashCode()) * 0x1F;
        Integer v1 = this.exitCode;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        StretchQueryData v1_2 = this.data;
        v1_1 = v1_2 == null ? 0 : v1_2.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        StretchTransportError v1_3 = this.error;
        if(v1_3 == null) {
        }
        else {
            v2 = v1_3.hashCode();
        }

        return ((v0 + v2) * 0x1F + this.backends.hashCode()) * 0x1F + Long.hashCode(this.elapsedMillis);
    }

    public String toString() {
        return "StretchOperationResult(operationId=" + this.operationId + ", sessionId=" + this.sessionId + ", backend=" + this.backend + ", query=" + this.query + ", status=" + this.status + ", stdout=" + this.stdout + ", stderr=" + this.stderr + ", exitCode=" + this.exitCode + ", data=" + this.data + ", error=" + this.error + ", backends=" + this.backends + ", elapsedMillis=" + this.elapsedMillis + ")";
    }
}

