package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u001A/\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001A/\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0004\b\r\u0010\u000E\u001A\'\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0013\u001A\u00020\u0004*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2={"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxWidth", "", "finalMaxWidth-tfFHcEY", "(JZIF)I", "finalMaxLines", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "isEllipsis", "isEllipsis-MW5-ApA", "(I)Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutUtilsKt {
    public static final long finalConstraints-tfFHcEY(long arg1, boolean arg3, int arg4, float arg5) {
        return Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(0, LayoutUtilsKt.finalMaxWidth-tfFHcEY(arg1, arg3, arg4, arg5), 0, Constraints.getMaxHeight-impl(arg1));
    }

    public static final int finalMaxLines-xdlQI24(boolean arg1, int arg2, int arg3) {
        if(!arg1 && (LayoutUtilsKt.isEllipsis-MW5-ApA(arg2))) {
            return 1;
        }

        return RangesKt.coerceAtLeast(arg3, 1);
    }

    public static final int finalMaxWidth-tfFHcEY(long arg0, boolean arg2, int arg3, float arg4) {
        int v2;
        if(!arg2 && !LayoutUtilsKt.isEllipsis-MW5-ApA(arg3)) {
            goto label_7;
        }
        else if(Constraints.getHasBoundedWidth-impl(arg0)) {
            v2 = Constraints.getMaxWidth-impl(arg0);
        }
        else {
        label_7:
            v2 = 0x7FFFFFFF;
        }

        if(Constraints.getMinWidth-impl(arg0) == v2) {
            return v2;
        }

        return RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(arg4), Constraints.getMinWidth-impl(arg0), v2);
    }

    public static final boolean isEllipsis-MW5-ApA(int arg1) {
        if(!TextOverflow.equals-impl0(arg1, TextOverflow.Companion.getEllipsis-gIe3tQ8()) && !TextOverflow.equals-impl0(arg1, TextOverflow.Companion.getStartEllipsis-gIe3tQ8())) {
            if(TextOverflow.equals-impl0(arg1, TextOverflow.Companion.getMiddleEllipsis-gIe3tQ8())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

