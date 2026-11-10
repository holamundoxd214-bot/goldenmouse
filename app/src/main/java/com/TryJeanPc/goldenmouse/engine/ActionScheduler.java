package com.TryJeanPc.goldenmouse.engine;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001E\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\b\u001A\u00020\u0003H&¨\u0006\tÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/ActionScheduler;", "", "schedule", "", "delayMs", "", "action", "Lkotlin/Function0;", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface ActionScheduler {
    void close();

    void schedule(long arg1, Function0 arg2);
}

