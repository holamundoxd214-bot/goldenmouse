package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000\u001A\u0014\u0010\u0004\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000\u001A\u0019\u0010\u0005\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0000¢\u0006\u0002\u0010\b¨\u0006\t"}, d2={"findParagraphStart", "", "", "startIndex", "findParagraphEnd", "getParagraphBoundary", "Landroidx/compose/ui/text/TextRange;", "index", "(Ljava/lang/CharSequence;I)J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class StringHelpersKt {
    public static final int findParagraphEnd(CharSequence arg3, int arg4) {
        int v0 = arg3.length();
        while(arg4 < v0) {
            if(arg3.charAt(arg4) == 10) {
                return arg4;
            }

            ++arg4;
        }

        return arg3.length();
    }

    public static final int findParagraphStart(CharSequence arg2, int arg3) {
        while(arg3 > 0) {
            if(arg2.charAt(arg3 - 1) == 10) {
                return arg3;
            }

            --arg3;
        }

        return 0;
    }

    public static final long getParagraphBoundary(CharSequence arg1, int arg2) {
        return TextRangeKt.TextRange(StringHelpersKt.findParagraphStart(arg1, arg2), StringHelpersKt.findParagraphEnd(arg1, arg2));
    }
}

