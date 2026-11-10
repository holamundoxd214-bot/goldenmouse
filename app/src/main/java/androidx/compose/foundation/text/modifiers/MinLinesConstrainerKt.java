package androidx.compose.foundation.text.modifiers;

import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2={"DefaultWidthCharCount", "", "EmptyTextReplacement", "", "TwoLineTextReplacement", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MinLinesConstrainerKt {
    private static final int DefaultWidthCharCount = 10;
    private static final String EmptyTextReplacement;
    private static final String TwoLineTextReplacement;

    static {
        String v0 = StringsKt.repeat("H", '\n');
        MinLinesConstrainerKt.EmptyTextReplacement = v0;
        MinLinesConstrainerKt.TwoLineTextReplacement = v0 + '\n' + v0;
    }

    public static final String access$getEmptyTextReplacement$p() {
        return MinLinesConstrainerKt.EmptyTextReplacement;
    }

    public static final String access$getTwoLineTextReplacement$p() {
        return MinLinesConstrainerKt.TwoLineTextReplacement;
    }
}

