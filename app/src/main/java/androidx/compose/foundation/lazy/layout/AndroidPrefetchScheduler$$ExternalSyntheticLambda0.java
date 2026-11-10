package androidx.compose.foundation.lazy.layout;

import java.util.Comparator;

public final class AndroidPrefetchScheduler$$ExternalSyntheticLambda0 implements Comparator {
    public AndroidPrefetchScheduler$$ExternalSyntheticLambda0() {
        super();
    }

    public final int compare(Object arg1, Object arg2) {
        return AndroidPrefetchScheduler.prefetchRequests$lambda$0(((PriorityTask)arg1), ((PriorityTask)arg2));
    }
}

