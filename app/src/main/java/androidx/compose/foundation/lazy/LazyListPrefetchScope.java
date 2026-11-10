package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J-\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u001B\b\u0002\u0010\u0006\u001A\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "onPrefetchFinished", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListPrefetchResultScope;", "", "Lkotlin/ExtensionFunctionType;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyListPrefetchScope {
    PrefetchHandle schedulePrefetch(int arg1, Function1 arg2);

    static PrefetchHandle schedulePrefetch$default(LazyListPrefetchScope arg0, int arg1, Function1 arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = null;
            }

            return arg0.schedulePrefetch(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: schedulePrefetch");
    }
}

