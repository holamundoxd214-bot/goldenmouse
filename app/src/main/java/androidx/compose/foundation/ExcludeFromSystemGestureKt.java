package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0007\u001A \u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¨\u0006\u0006"}, d2={"excludeFromSystemGesture", "Landroidx/compose/ui/Modifier;", "exclusion", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ExcludeFromSystemGestureKt {
    @Deprecated(message="Use systemGestureExclusion", replaceWith="<_subannotation>") public static final Modifier excludeFromSystemGesture(Modifier arg0) {
        return SystemGestureExclusionKt.systemGestureExclusion(arg0);
    }

    @Deprecated(message="Use systemGestureExclusion", replaceWith="<_subannotation>") public static final Modifier excludeFromSystemGesture(Modifier arg0, Function1 arg1) {
        return SystemGestureExclusionKt.systemGestureExclusion(arg0, arg1);
    }
}

