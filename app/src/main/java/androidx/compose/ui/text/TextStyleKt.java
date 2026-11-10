package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005\u001A\u0016\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t\u001A\u001F\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000BH\u0000¢\u0006\u0004\b\u000E\u0010\u000F\u001A\u001E\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0002¨\u0006\u0016"}, d2={"lerp", "Landroidx/compose/ui/text/TextStyle;", "start", "stop", "fraction", "", "resolveDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "resolveTextDirection", "Landroidx/compose/ui/text/style/TextDirection;", "layoutDirection", "textDirection", "resolveTextDirection-IhaHGbI", "(Landroidx/compose/ui/unit/LayoutDirection;I)I", "createPlatformTextStyleInternal", "Landroidx/compose/ui/text/PlatformTextStyle;", "platformSpanStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "platformParagraphStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextStyleKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutDirection.values().length];
            try {
                v0[LayoutDirection.Ltr.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[LayoutDirection.Rtl.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final PlatformTextStyle access$createPlatformTextStyleInternal(PlatformSpanStyle arg0, PlatformParagraphStyle arg1) {
        return TextStyleKt.createPlatformTextStyleInternal(arg0, arg1);
    }

    private static final PlatformTextStyle createPlatformTextStyleInternal(PlatformSpanStyle arg0, PlatformParagraphStyle arg1) {
        if(arg0 == null && arg1 == null) {
            return null;
        }

        return AndroidTextStyle_androidKt.createPlatformTextStyle(arg0, arg1);
    }

    public static final TextStyle lerp(TextStyle arg3, TextStyle arg4, float arg5) {
        return new TextStyle(SpanStyleKt.lerp(arg3.toSpanStyle(), arg4.toSpanStyle(), arg5), ParagraphStyleKt.lerp(arg3.toParagraphStyle(), arg4.toParagraphStyle(), arg5));
    }

    public static final TextStyle resolveDefaults(TextStyle arg3, LayoutDirection arg4) {
        return new TextStyle(SpanStyleKt.resolveSpanStyleDefaults(arg3.getSpanStyle$ui_text()), ParagraphStyleKt.resolveParagraphStyleDefaults(arg3.getParagraphStyle$ui_text(), arg4), arg3.getPlatformStyle());
    }

    public static final int resolveTextDirection-IhaHGbI(LayoutDirection arg3, int arg4) {
        int v3;
        int v1 = 2;
        if(TextDirection.equals-impl0(arg4, TextDirection.Companion.getContent-s_7X-co())) {
            v3 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
            if(v3 != 1) {
                if(v3 == v1) {
                    return TextDirection.Companion.getContentOrRtl-s_7X-co();
                }

                throw new NoWhenBranchMatchedException();
            }

            return TextDirection.Companion.getContentOrLtr-s_7X-co();
        }

        if(TextDirection.equals-impl0(arg4, TextDirection.Companion.getUnspecified-s_7X-co())) {
            v3 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
            if(v3 != 1) {
                if(v3 == v1) {
                    return TextDirection.Companion.getRtl-s_7X-co();
                }

                throw new NoWhenBranchMatchedException();
            }

            return TextDirection.Companion.getLtr-s_7X-co();
        }

        return arg4;
    }
}

