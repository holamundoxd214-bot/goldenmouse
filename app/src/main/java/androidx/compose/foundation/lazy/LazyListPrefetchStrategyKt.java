package androidx.compose.foundation.lazy;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A\u0012\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0007\"\u000E\u0010\u0004\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2={"LazyListPrefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "nestedPrefetchItemCount", "", "UnsetItemCount", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyListPrefetchStrategyKt {
    private static final int UnsetItemCount = -1;

    public static final LazyListPrefetchStrategy LazyListPrefetchStrategy(int arg1) {
        return new DefaultLazyListPrefetchStrategy(arg1);
    }

    public static LazyListPrefetchStrategy LazyListPrefetchStrategy$default(int arg0, int arg1, Object arg2) {
        if((arg1 & 1) != 0) {
            arg0 = 2;
        }

        return LazyListPrefetchStrategyKt.LazyListPrefetchStrategy(arg0);
    }
}

