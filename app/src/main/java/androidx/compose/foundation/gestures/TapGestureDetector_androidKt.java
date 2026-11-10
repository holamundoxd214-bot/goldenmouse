package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerEvent;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\b\u0010\u0004\u001A\u00020\u0001H\u0000\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0000\u0010\u0003¨\u0006\u0005"}, d2={"isDeepPress", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "firstDownRefersToPrimaryMouseButtonOnly", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TapGestureDetector_androidKt {
    public static final boolean firstDownRefersToPrimaryMouseButtonOnly() {
        return 0;
    }

    public static final boolean isDeepPress(PointerEvent arg1) {
        if(arg1.getClassification() == 2) {
            return 1;
        }

        return 0;
    }
}

