package androidx.compose.foundation;

import android.os.Build$VERSION;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0001\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001A!\u0010\u0006\u001A\u00020\u00012\u0016\b\b\u0010\u0002\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\u0083\b¨\u0006\u0007"}, d2={"systemGestureExclusion", "Landroidx/compose/ui/Modifier;", "exclusion", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "excludeFromSystemGestureQ", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SystemGestureExclusionKt {
    private static final Modifier excludeFromSystemGestureQ(Function1 arg1) {
        return new ExcludeFromSystemGestureElement(arg1);
    }

    public static final Modifier systemGestureExclusion(Modifier arg2) {
        if(Build$VERSION.SDK_INT < 29) {
            return arg2;
        }

        return arg2.then(new ExcludeFromSystemGestureElement(null));
    }

    public static final Modifier systemGestureExclusion(Modifier arg2, Function1 arg3) {
        if(Build$VERSION.SDK_INT < 29) {
            return arg2;
        }

        return arg2.then(new ExcludeFromSystemGestureElement(arg3));
    }
}

