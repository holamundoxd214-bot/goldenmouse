package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001A\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"DefaultCacheSize", "", "isEllipsis", "", "Landroidx/compose/ui/text/style/TextOverflow;", "isEllipsis-MW5-ApA", "(I)Z", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextMeasurerKt {
    private static final int DefaultCacheSize = 8;

    public static final boolean access$isEllipsis-MW5-ApA(int arg0) {
        return TextMeasurerKt.isEllipsis-MW5-ApA(arg0);
    }

    private static final boolean isEllipsis-MW5-ApA(int arg1) {
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

