package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AH\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0003H\u0000¨\u0006\f"}, d2={"calculateDistanceToDesiredSnapPosition", "", "mainAxisViewPortSize", "", "beforeContentPadding", "afterContentPadding", "itemSize", "itemOffset", "itemIndex", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "itemCount", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SnapPositionKt {
    public static final float calculateDistanceToDesiredSnapPosition(int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, SnapPosition arg13, int arg14) {
        return (((float)arg11)) - (((float)arg13.position(arg7, arg10, arg8, arg9, arg12, arg14)));
    }
}

