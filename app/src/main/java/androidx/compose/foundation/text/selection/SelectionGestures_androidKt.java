package androidx.compose.foundation.text.selection;

import android.view.MotionEvent;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerType;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2={"isMouseOrTouchPad", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionGestures_androidKt {
    public static final boolean isMouseOrTouchPad(PointerEvent arg7) {
        List v0 = arg7.getChanges();
        int v1 = v0.size();
        int v3 = 0;
        while(v3 < v1) {
            if(!PointerType.equals-impl0(v0.get(v3).getType-T8wyACA(), PointerType.Companion.getMouse-T8wyACA())) {
                MotionEvent v0_1 = arg7.getMotionEvent();
                if(v0_1 != null && (v0_1.isFromSource(0x2002))) {
                    return 1;
                }

                MotionEvent v7 = arg7.getMotionEvent();
                if(v7 != null && (v7.isFromSource(0x100008))) {
                    return 1;
                }

                return 0;
            }
            else {
                ++v3;
                continue;
            }

            return 1;
        }

        return 1;
    }
}

