package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u001F\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class EditingBufferKt {
    public static final long updateRangeAfterDelete-pWDy79M(long arg3, long arg5) {
        int v3;
        int v0 = TextRange.getMin-impl(arg3);
        int v1 = TextRange.getMax-impl(arg3);
        if(TextRange.intersects-5zc-tL8(arg5, arg3)) {
            if(TextRange.contains-5zc-tL8(arg5, arg3)) {
                v0 = TextRange.getMin-impl(arg5);
                v1 = v0;
            }
            else if(TextRange.contains-5zc-tL8(arg3, arg5)) {
                v3 = TextRange.getLength-impl(arg5);
                goto label_25;
            }
            else if(TextRange.contains-impl(arg5, v0)) {
                v0 = TextRange.getMin-impl(arg5);
                v3 = TextRange.getLength-impl(arg5);
                goto label_25;
            }
            else {
                v1 = TextRange.getMin-impl(arg5);
            }
        }
        else if(v1 > TextRange.getMin-impl(arg5)) {
            v0 -= TextRange.getLength-impl(arg5);
            v3 = TextRange.getLength-impl(arg5);
        label_25:
            v1 -= v3;
        }

        return TextRangeKt.TextRange(v0, v1);
    }
}

