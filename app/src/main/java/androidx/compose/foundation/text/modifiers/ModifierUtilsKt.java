package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A#\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"maxWidthForTextLayout", "", "Landroidx/compose/ui/unit/Constraints;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxWidthForTextLayout-R2G3SPE", "(JZI)I", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ModifierUtilsKt {
    public static final int maxWidthForTextLayout-R2G3SPE(long arg0, boolean arg2, int arg3) {
        if(((arg2) || (TextOverflow.equals-impl0(arg3, TextOverflow.Companion.getEllipsis-gIe3tQ8()))) && (Constraints.getHasBoundedWidth-impl(arg0))) {
            return Constraints.getMaxWidth-impl(arg0);
        }

        return 0x7FFFFFFF;
    }
}

