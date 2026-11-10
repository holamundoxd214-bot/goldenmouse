package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A&\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0001H\u0002¨\u0006\u0006"}, d2={"binarySearch", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "itemIndex", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IntervalListKt {
    public static final int access$binarySearch(MutableVector arg0, int arg1) {
        return IntervalListKt.binarySearch(arg0, arg1);
    }

    private static final int binarySearch(MutableVector arg4, int arg5) {
        int v0 = arg4.getSize() - 1;
        int v1 = 0;
        while(v1 < v0) {
            int v2 = (v0 - v1) / 2 + v1;
            int v3 = arg4.content[v2].getStartIndex();
            if(v3 == arg5) {
            }
            else if(v3 < arg5) {
                v1 = v2 + 1;
                if(arg5 < arg4.content[v1].getStartIndex()) {
                    return v2;
                }

                continue;
            }
            else {
                goto label_19;
            }

            return v2;
        label_19:
            v0 = v2 - 1;
        }

        return v1;
    }
}

