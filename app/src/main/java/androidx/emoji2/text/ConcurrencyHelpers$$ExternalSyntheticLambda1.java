package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final class ConcurrencyHelpers$$ExternalSyntheticLambda1 implements ThreadFactory {
    public ConcurrencyHelpers$$ExternalSyntheticLambda1(String arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Thread newThread(Runnable arg1) {
        return ConcurrencyHelpers.lambda$createBackgroundPriorityExecutor$0(this.f$0, arg1);
    }
}

