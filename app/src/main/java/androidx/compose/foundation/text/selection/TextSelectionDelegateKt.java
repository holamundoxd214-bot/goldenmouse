package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001A-\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0000¢\u0006\u0002\u0010\t\u001A$\u0010\n\u001A\u00020\u000B*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0000¨\u0006\f"}, d2={"getSelectionHandleCoordinates", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isStart", "", "areHandlesCrossed", "(Landroidx/compose/ui/text/TextLayoutResult;IZZ)J", "getHorizontalPosition", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextSelectionDelegateKt {
    public static final float getHorizontalPosition(TextLayoutResult arg1, int arg2, boolean arg3, boolean arg4) {
        int v3;
        boolean v0 = false;
        if(!arg3 || (arg4)) {
            if(!arg3 && (arg4)) {
            label_5:
                v3 = arg2;
                goto label_9;
            }

            v3 = Math.max(arg2 - 1, 0);
        }
        else {
            goto label_5;
        }

    label_9:
        if(arg1.getBidiRunDirection(v3) == arg1.getParagraphDirection(arg2)) {
            v0 = true;
        }

        return arg1.getHorizontalPosition(arg2, v0);
    }

    public static final long getSelectionHandleCoordinates(TextLayoutResult arg6, int arg7, boolean arg8, boolean arg9) {
        int v0 = arg6.getLineForOffset(arg7);
        if(v0 >= arg6.getLineCount()) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(RangesKt.coerceIn(TextSelectionDelegateKt.getHorizontalPosition(arg6, arg7, arg8, arg9), 0f, ((float)(((int)(arg6.getSize-YbymL2g() >> 0x20)))))))) << 0x20 | (((long)Float.floatToRawIntBits(RangesKt.coerceIn(arg6.getLineBottom(v0), 0f, ((float)(((int)(arg6.getSize-YbymL2g() & 0xFFFFFFFFL)))))))) & 0xFFFFFFFFL);
    }
}

