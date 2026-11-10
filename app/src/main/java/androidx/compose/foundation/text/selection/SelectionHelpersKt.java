package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u0014\u0010\u0005\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0002¨\u0006\u0007"}, d2={"getTextDirectionForOffset", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isOffsetAnEmptyLine", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionHelpersKt {
    public static final ResolvedTextDirection getTextDirectionForOffset(TextLayoutResult arg1, int arg2) {
        if(SelectionHelpersKt.isOffsetAnEmptyLine(arg1, arg2)) {
            return arg1.getParagraphDirection(arg2);
        }

        return arg1.getBidiRunDirection(arg2);
    }

    private static final boolean isOffsetAnEmptyLine(TextLayoutResult arg3, int arg4) {
        if(arg3.getLayoutInput().getText().length() == 0) {
        }
        else {
            int v0 = arg3.getLineForOffset(arg4);
            if(arg4 == 0 || v0 != arg3.getLineForOffset(arg4 - 1)) {
                if(arg4 == arg3.getLayoutInput().getText().length()) {
                    return 1;
                }
                else if(v0 != arg3.getLineForOffset(arg4 + 1)) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }
}

