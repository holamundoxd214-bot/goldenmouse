package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextLinkStyles;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\u001A\u000E\u0010\u0003\u001A\u00020\u0004*\u0004\u0018\u00010\u0005H\u0002*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0006"}, d2={"LinkRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "isNullOrEmpty", "", "Landroidx/compose/ui/text/TextLinkStyles;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextLinkScopeKt {
    public static final boolean access$isNullOrEmpty(TextLinkStyles arg0) {
        return TextLinkScopeKt.isNullOrEmpty(arg0);
    }

    private static final boolean isNullOrEmpty(TextLinkStyles arg1) {
        if(arg1 != null && (arg1.getStyle() != null || arg1.getFocusedStyle() != null || arg1.getHoveredStyle() != null || arg1.getPressedStyle() != null)) {
            return 0;
        }

        return 1;
    }
}

