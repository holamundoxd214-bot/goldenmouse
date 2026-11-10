package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.concurrent.CompletionStage;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\nH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u000BÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryExecutor;", "", "scope", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "getScope", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "restore", "Ljava/util/concurrent/CompletionStage;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreResult;", "request", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreRequest;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface StretchRecoveryExecutor {
    RecoveryScope getScope();

    CompletionStage restore(StretchRestoreRequest arg1);
}

