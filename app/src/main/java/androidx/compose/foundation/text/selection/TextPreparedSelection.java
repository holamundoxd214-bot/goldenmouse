package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/text/selection/TextPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextPreparedSelection extends BaseTextPreparedSelection {
    public static final int $stable = 8;

    static {
    }

    private TextPreparedSelection(AnnotatedString arg9, long arg10, TextLayoutResult arg12, OffsetMapping arg13, TextPreparedSelectionState arg14) {
        super(arg9, arg10, arg12, arg13, arg14, null);
    }

    public TextPreparedSelection(AnnotatedString arg9, long arg10, TextLayoutResult arg12, OffsetMapping arg13, TextPreparedSelectionState arg14, int arg15, DefaultConstructorMarker arg16) {
        if((arg15 & 4) != 0) {
            arg12 = null;
        }

        TextLayoutResult v4 = arg12;
        if((arg15 & 8) != 0) {
            arg13 = OffsetMapping.Companion.getIdentity();
        }

        OffsetMapping v5 = arg13;
        if((arg15 & 16) != 0) {
            arg14 = new TextPreparedSelectionState();
        }

        this(arg9, arg10, v4, v5, arg14, null);
    }

    public TextPreparedSelection(AnnotatedString arg1, long arg2, TextLayoutResult arg4, OffsetMapping arg5, TextPreparedSelectionState arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg4, arg5, arg6);
    }
}

