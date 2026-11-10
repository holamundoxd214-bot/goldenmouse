package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0016\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0001\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000B"}, d2={"UnspecifiedNestedPrefetchCount", "", "TraversablePrefetchStateNodeKey", "", "traversablePrefetchState", "Landroidx/compose/ui/Modifier;", "lazyLayoutPrefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutPrefetchStateKt {
    private static final String TraversablePrefetchStateNodeKey = "androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode";
    public static final int UnspecifiedNestedPrefetchCount = -1;
    private static final long ZeroConstraints;

    static {
        LazyLayoutPrefetchStateKt.ZeroConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 5, null);
    }

    public static final Modifier traversablePrefetchState(Modifier arg1, LazyLayoutPrefetchState arg2) {
        if(arg2 != null) {
            Modifier v2 = arg1.then(new TraversablePrefetchStateModifierElement(arg2));
            if(v2 == null) {
            }
            else {
                return v2;
            }
        }

        return arg1;
    }
}

