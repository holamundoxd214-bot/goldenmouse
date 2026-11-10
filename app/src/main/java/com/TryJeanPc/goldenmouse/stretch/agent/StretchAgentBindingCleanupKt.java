package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001C\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0000¨\u0006\u0005"}, d2={"closeStretchAgentBinding", "Ljava/util/concurrent/CompletableFuture;", "", "unbind", "Lkotlin/Function0;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchAgentBindingCleanupKt {
    public static final CompletableFuture closeStretchAgentBinding(Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "unbind");
        CompletableFuture v0 = new CompletableFuture();
        Thread v1 = new Thread(new StretchAgentBindingCleanupKt$$ExternalSyntheticLambda0(arg3, v0), "StretchAgentUnbind");
        v1.setDaemon(true);
        v1.start();
        return v0;
    }

    static final void closeStretchAgentBinding$lambda$0(Function0 arg0, CompletableFuture arg1) {
        try {
            arg0.invoke();
            arg1.complete(Unit.INSTANCE);
            return;
        }
        catch(Exception v0) {
            arg1.completeExceptionally(((Throwable)v0));
            return;
        }
    }
}

