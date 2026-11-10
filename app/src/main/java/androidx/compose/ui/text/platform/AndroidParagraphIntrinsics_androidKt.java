package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import androidx.core.text.TextUtilsCompat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A#\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001AR\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0014\u0010\u000E\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u000F2\u0012\u0010\u0012\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00100\u000F2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0000\"\u0018\u0010\u0018\u001A\u00020\u0019*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2={"resolveTextDirectionHeuristics", "", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "resolveTextDirectionHeuristics-HklW4sA", "(ILandroidx/compose/ui/text/intl/LocaleList;)I", "ActualParagraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "hasEmojiCompat", "", "getHasEmojiCompat", "(Landroidx/compose/ui/text/TextStyle;)Z", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidParagraphIntrinsics_androidKt {
    public static final ParagraphIntrinsics ActualParagraphIntrinsics(String arg7, TextStyle arg8, List arg9, List arg10, Density arg11, Resolver arg12) {
        return new AndroidParagraphIntrinsics(arg7, arg8, arg9, arg10, arg12, arg11);
    }

    public static final boolean access$getHasEmojiCompat(TextStyle arg0) {
        return AndroidParagraphIntrinsics_androidKt.getHasEmojiCompat(arg0);
    }

    private static final boolean getHasEmojiCompat(TextStyle arg1) {
        int v1_3;
        EmojiSupportMatch v1_2;
        PlatformTextStyle v1 = arg1.getPlatformStyle();
        if(v1 != null) {
            PlatformParagraphStyle v1_1 = v1.getParagraphStyle();
            if(v1_1 != null) {
                v1_2 = EmojiSupportMatch.box-impl(v1_1.getEmojiSupportMatch-_3YsG6Y());
            }
            else {
                goto label_7;
            }
        }
        else {
        label_7:
            v1_2 = null;
        }

        int v0 = EmojiSupportMatch.Companion.getNone-_3YsG6Y();
        if(v1_2 == null) {
            v1_3 = 0;
        }
        else {
            boolean v1_4 = EmojiSupportMatch.equals-impl0(v1_2.unbox-impl(), v0);
        }

        return v1_3 ^ 1;
    }

    public static final int resolveTextDirectionHeuristics-HklW4sA(int arg5, LocaleList arg6) {
        Locale v5;
        int v1 = 2;
        if(TextDirection.equals-impl0(arg5, TextDirection.Companion.getContentOrLtr-s_7X-co())) {
            return v1;
        }

        int v2 = 3;
        if(TextDirection.equals-impl0(arg5, TextDirection.Companion.getContentOrRtl-s_7X-co())) {
            return v2;
        }

        if(TextDirection.equals-impl0(arg5, TextDirection.Companion.getLtr-s_7X-co())) {
            return 0;
        }

        if(TextDirection.equals-impl0(arg5, TextDirection.Companion.getRtl-s_7X-co())) {
            return 1;
        }

        if(!TextDirection.equals-impl0(arg5, TextDirection.Companion.getContent-s_7X-co())) {
            if(TextDirection.equals-impl0(arg5, TextDirection.Companion.getUnspecified-s_7X-co())) {
            }
            else {
                throw new IllegalStateException("Invalid TextDirection.".toString());
            }
        }

        if(arg6 != null) {
            v5 = arg6.get(0).getPlatformLocale();
            if(v5 == null) {
                goto label_42;
            }
        }
        else {
        label_42:
            v5 = Locale.getDefault();
        }

        arg5 = TextUtilsCompat.getLayoutDirectionFromLocale(v5);
        if(arg5 != 0) {
            if(arg5 != 1) {
                return v1;
            }

            return v2;
        }

        return v1;
    }

    public static int resolveTextDirectionHeuristics-HklW4sA$default(int arg0, LocaleList arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = null;
        }

        return AndroidParagraphIntrinsics_androidKt.resolveTextDirectionHeuristics-HklW4sA(arg0, arg1);
    }
}

