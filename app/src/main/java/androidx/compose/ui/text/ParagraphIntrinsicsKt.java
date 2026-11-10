package androidx.compose.ui.text;

import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics_androidKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001AT\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0014\b\u0002\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0014\b\u0002\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\b0\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007\u001AT\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0014\b\u0002\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0014\b\u0002\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\b0\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0011H\u0007\u001AR\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0014\u0010\u0012\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\b0\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u00112\u0014\b\u0002\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\b0\u0007¨\u0006\u0014"}, d2={"ParagraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "annotations", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ParagraphIntrinsicsKt {
    public static final ParagraphIntrinsics ParagraphIntrinsics(String arg1, TextStyle arg2, List arg3, Density arg4, Resolver arg5, List arg6) {
        return AndroidParagraphIntrinsics_androidKt.ActualParagraphIntrinsics(arg1, arg2, arg3, arg6, arg4, arg5);
    }

    @Deprecated(message="Font.ResourceLoader is deprecated, instead use FontFamily.Resolver", replaceWith="<_subannotation>") public static final ParagraphIntrinsics ParagraphIntrinsics(String arg0, TextStyle arg1, List arg2, List arg3, Density arg4, ResourceLoader arg5) {
        return AndroidParagraphIntrinsics_androidKt.ActualParagraphIntrinsics(arg0, arg1, arg2, arg3, arg4, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(arg5));
    }

    @Deprecated(message="Use an overload that takes `annotations` instead", replaceWith="<_subannotation>") public static final ParagraphIntrinsics ParagraphIntrinsics(String arg0, TextStyle arg1, List arg2, List arg3, Density arg4, Resolver arg5) {
        return AndroidParagraphIntrinsics_androidKt.ActualParagraphIntrinsics(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static ParagraphIntrinsics ParagraphIntrinsics$default(String arg6, TextStyle arg7, List arg8, Density arg9, Resolver arg10, List arg11, int arg12, Object arg13) {
        if((arg12 & 0x20) != 0) {
            arg11 = CollectionsKt.emptyList();
        }

        return ParagraphIntrinsicsKt.ParagraphIntrinsics(arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static ParagraphIntrinsics ParagraphIntrinsics$default(String arg6, TextStyle arg7, List arg8, List arg9, Density arg10, ResourceLoader arg11, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg8 = CollectionsKt.emptyList();
        }

        List v2 = arg8;
        if((arg12 & 8) != 0) {
            arg9 = CollectionsKt.emptyList();
        }

        return ParagraphIntrinsicsKt.ParagraphIntrinsics(arg6, arg7, v2, arg9, arg10, arg11);
    }

    public static ParagraphIntrinsics ParagraphIntrinsics$default(String arg6, TextStyle arg7, List arg8, List arg9, Density arg10, Resolver arg11, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg8 = CollectionsKt.emptyList();
        }

        List v2 = arg8;
        if((arg12 & 8) != 0) {
            arg9 = CollectionsKt.emptyList();
        }

        return ParagraphIntrinsicsKt.ParagraphIntrinsics(arg6, arg7, v2, arg9, arg10, arg11);
    }
}

