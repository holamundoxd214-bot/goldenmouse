package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.AnnotatedString$Builder;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001C\u0010\u0003\u001A\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00012\b\b\u0002\u0010\u0007\u001A\u00020\u0001\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"INLINE_CONTENT_TAG", "", "REPLACEMENT_CHAR", "appendInlineContent", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "id", "alternateText", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InlineTextContentKt {
    public static final String INLINE_CONTENT_TAG = "androidx.compose.foundation.text.inlineContent";
    private static final String REPLACEMENT_CHAR = "\uFFFD";

    public static final void appendInlineContent(Builder arg1, String arg2, String arg3) {
        int v0 = arg3.length() > 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("alternateText can\'t be an empty string.");
        }

        arg1.pushStringAnnotation("androidx.compose.foundation.text.inlineContent", arg2);
        arg1.append(arg3);
        arg1.pop();
    }

    public static void appendInlineContent$default(Builder arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = "\uFFFD";
        }

        InlineTextContentKt.appendInlineContent(arg0, arg1, arg2);
    }
}

