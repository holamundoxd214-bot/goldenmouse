package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u001E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\nÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScheduler;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "schedule", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryCancellation;", "delayMillis", "", "action", "Lkotlin/Function0;", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface RecoveryScheduler extends AutoCloseable {
    RecoveryCancellation schedule(long arg1, Function0 arg2);
}

