package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001Ar\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062H\u0010\u0007\u001AD\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\u000E\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\u0004\u0012\u0002H\u00020\u000F0\bH\u0001\"\u000E\u0010\u0011\u001A\u00020\u0012X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"draggableAnchorsV2", "Landroidx/compose/ui/Modifier;", "T", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "anchors", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "ConfirmValueChangeDeprecated", "", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DraggableAnchorsKt {
    public static final String ConfirmValueChangeDeprecated = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.";

    public static final Modifier draggableAnchorsV2(Modifier arg1, AnchoredDraggableState arg2, Orientation arg3, Function2 arg4) {
        return arg1.then(new DraggableAnchorsElementV2(arg2, arg4, arg3));
    }
}

