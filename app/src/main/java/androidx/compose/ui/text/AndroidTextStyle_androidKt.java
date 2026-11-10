package androidx.compose.ui.text;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001A\u001C\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0000\u001A\u001E\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\f\u001A\u001E\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"DefaultIncludeFontPadding", "", "createPlatformTextStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "spanStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lerp", "start", "stop", "fraction", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidTextStyle_androidKt {
    public static final boolean DefaultIncludeFontPadding = false;

    public static final PlatformTextStyle createPlatformTextStyle(PlatformSpanStyle arg1, PlatformParagraphStyle arg2) {
        return new PlatformTextStyle(arg1, arg2);
    }

    public static final PlatformParagraphStyle lerp(PlatformParagraphStyle arg3, PlatformParagraphStyle arg4, float arg5) {
        if(arg3.getIncludeFontPadding() == arg4.getIncludeFontPadding()) {
            return arg3;
        }

        return new PlatformParagraphStyle(SpanStyleKt.lerpDiscrete(EmojiSupportMatch.box-impl(arg3.getEmojiSupportMatch-_3YsG6Y()), EmojiSupportMatch.box-impl(arg4.getEmojiSupportMatch-_3YsG6Y()), arg5).unbox-impl(), SpanStyleKt.lerpDiscrete(Boolean.valueOf(arg3.getIncludeFontPadding()), Boolean.valueOf(arg4.getIncludeFontPadding()), arg5).booleanValue(), null);
    }

    public static final PlatformSpanStyle lerp(PlatformSpanStyle arg0, PlatformSpanStyle arg1, float arg2) {
        return arg0;
    }
}

