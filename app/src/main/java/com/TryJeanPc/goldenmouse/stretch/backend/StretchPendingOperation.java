package com.TryJeanPc.goldenmouse.stretch.backend;

import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B5\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000B\u0010\fJ\u0006\u0010\u0012\u001A\u00020\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchPendingOperation;", "", "operationId", "", "sessionId", "result", "Ljava/util/concurrent/CompletableFuture;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchOperationResult;", "cancelOperation", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/CompletableFuture;Lkotlin/jvm/functions/Function0;)V", "getOperationId", "()Ljava/lang/String;", "getSessionId", "getResult", "()Ljava/util/concurrent/CompletableFuture;", "cancel", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPendingOperation {
    public static final int $stable = 8;
    private final Function0 cancelOperation;
    private final String operationId;
    private final CompletableFuture result;
    private final String sessionId;

    static {
    }

    public StretchPendingOperation(String arg2, String arg3, CompletableFuture arg4, Function0 arg5) {
        Intrinsics.checkNotNullParameter(arg2, "operationId");
        Intrinsics.checkNotNullParameter(arg3, "sessionId");
        Intrinsics.checkNotNullParameter(arg4, "result");
        Intrinsics.checkNotNullParameter(arg5, "cancelOperation");
        super();
        this.operationId = arg2;
        this.sessionId = arg3;
        this.result = arg4;
        this.cancelOperation = arg5;
    }

    public final void cancel() {
        this.cancelOperation.invoke();
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final CompletableFuture getResult() {
        return this.result;
    }

    public final String getSessionId() {
        return this.sessionId;
    }
}

