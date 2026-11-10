package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001AR\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E\u001A\\\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E¨\u0006\u0011"}, d2={"scrollableArea", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseScrolling", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ScrollableAreaKt {
    public static final Modifier scrollableArea(Modifier arg10, ScrollableState arg11, Orientation arg12, OverscrollEffect arg13, boolean arg14, boolean arg15, FlingBehavior arg16, MutableInteractionSource arg17, BringIntoViewSpec arg18) {
        return ClipScrollableContainerKt.clipScrollableContainer(arg10, arg12).then(new ScrollableAreaElement(arg11, arg12, arg14, arg15, arg16, arg17, arg18, false, arg13));
    }

    public static final Modifier scrollableArea(Modifier arg10, ScrollableState arg11, Orientation arg12, boolean arg13, boolean arg14, FlingBehavior arg15, MutableInteractionSource arg16, BringIntoViewSpec arg17) {
        return ClipScrollableContainerKt.clipScrollableContainer(arg10, arg12).then(new ScrollableAreaElement(arg11, arg12, arg13, arg14, arg15, arg16, arg17, true, null));
    }

    public static Modifier scrollableArea$default(Modifier arg8, ScrollableState arg9, Orientation arg10, boolean arg11, boolean arg12, FlingBehavior arg13, MutableInteractionSource arg14, BringIntoViewSpec arg15, int arg16, Object arg17) {
        FlingBehavior v12 = null;
        FlingBehavior v5 = (arg16 & 16) != 0 ? v12 : arg13;
        MutableInteractionSource v6 = (arg16 & 0x20) != 0 ? ((MutableInteractionSource)v12) : arg14;
        BringIntoViewSpec v7 = (arg16 & 0x40) != 0 ? ((BringIntoViewSpec)v12) : arg15;
        return ScrollableAreaKt.scrollableArea(arg8, arg9, arg10, true, false, v5, v6, v7);
    }

    public static Modifier scrollableArea$default(Modifier arg9, ScrollableState arg10, Orientation arg11, OverscrollEffect arg12, boolean arg13, boolean arg14, FlingBehavior arg15, MutableInteractionSource arg16, BringIntoViewSpec arg17, int arg18, Object arg19) {
        ScrollableState v1_1;
        OverscrollEffect v3;
        Orientation v2;
        Modifier v0_1;
        BringIntoViewSpec v8;
        int v0 = arg18;
        boolean v5 = (v0 & 16) != 0 ? false : arg14;
        FlingBehavior v1 = null;
        FlingBehavior v6 = (v0 & 0x20) != 0 ? v1 : arg15;
        MutableInteractionSource v7 = (v0 & 0x40) != 0 ? ((MutableInteractionSource)v1) : arg16;
        if((v0 & 0x80) != 0) {
            v8 = ((BringIntoViewSpec)v1);
            v0_1 = arg9;
            v2 = arg11;
            v3 = arg12;
            v1_1 = arg10;
        }
        else {
            v8 = arg17;
            v0_1 = arg9;
            v1_1 = arg10;
            v2 = arg11;
            v3 = arg12;
        }

        return ScrollableAreaKt.scrollableArea(v0_1, v1_1, v2, v3, true, v5, v6, v7, v8);
    }
}

