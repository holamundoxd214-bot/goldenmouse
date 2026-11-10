package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2={"lerp", "Landroidx/compose/ui/text/style/TextIndent;", "start", "stop", "fraction", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextIndentKt {
    public static final TextIndent lerp(TextIndent arg6, TextIndent arg7, float arg8) {
        return new TextIndent(SpanStyleKt.lerpTextUnitInheritable-C3pnCVY(arg6.getFirstLine-XSAIIZE(), arg7.getFirstLine-XSAIIZE(), arg8), SpanStyleKt.lerpTextUnitInheritable-C3pnCVY(arg6.getRestLine-XSAIIZE(), arg7.getRestLine-XSAIIZE(), arg8), null);
    }
}

