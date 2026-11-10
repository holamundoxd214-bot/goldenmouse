package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0001H\u0000¨\u0006\u0006"}, d2={"findIndexByKey", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "key", "", "lastKnownIndex", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutItemProviderKt {
    public static final int findIndexByKey(LazyLayoutItemProvider arg1, Object arg2, int arg3) {
        if(arg2 != null) {
            if(arg1.getItemCount() == 0) {
            }
            else {
                if(arg3 < arg1.getItemCount() && (Intrinsics.areEqual(arg2, arg1.getKey(arg3)))) {
                    return arg3;
                }

                int v1 = arg1.getIndex(arg2);
                if(v1 == -1) {
                    return arg3;
                }

                return v1;
            }
        }

        return arg3;
    }
}

