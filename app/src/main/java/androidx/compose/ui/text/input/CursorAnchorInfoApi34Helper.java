package androidx.compose.ui.text.input;

import android.view.inputmethod.CursorAnchorInfo$Builder;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/ui/text/input/CursorAnchorInfoApi34Helper;", "", "<init>", "()V", "addVisibleLineBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "builder", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class CursorAnchorInfoApi34Helper {
    public static final CursorAnchorInfoApi34Helper INSTANCE;

    static {
        CursorAnchorInfoApi34Helper.INSTANCE = new CursorAnchorInfoApi34Helper();
    }

    private CursorAnchorInfoApi34Helper() {
        super();
    }

    @JvmStatic public static final CursorAnchorInfo$Builder addVisibleLineBounds(CursorAnchorInfo$Builder arg5, TextLayoutResult arg6, Rect arg7) {
        if(!arg7.isEmpty()) {
            int v0 = RangesKt.coerceAtLeast(arg6.getLineCount() - 1, 0);
            int v2 = RangesKt.coerceIn(arg6.getLineForVerticalPosition(arg7.getTop()), 0, v0);
            int v7 = RangesKt.coerceIn(arg6.getLineForVerticalPosition(arg7.getBottom()), 0, v0);
            if(v2 > v7) {
                return arg5;
            }

            while(true) {
                arg5.addVisibleLineBounds(arg6.getLineLeft(v2), arg6.getLineTop(v2), arg6.getLineRight(v2), arg6.getLineBottom(v2));
                if(v2 == v7) {
                    return arg5;
                }

                ++v2;
            }
        }

        return arg5;
    }
}

