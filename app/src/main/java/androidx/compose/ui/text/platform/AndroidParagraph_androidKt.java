package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow$Companion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001Aj\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0014\u0010\u0006\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\u0012\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\b0\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0001\u001Aq\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0014\u0010\u0006\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00072\u0012\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\b0\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u001A\u001A\u00020\u001BH\u0000¢\u0006\u0004\b\u001C\u0010\u001D\u001A/\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0000¢\u0006\u0004\b \u0010!¨\u0006\""}, d2={"ActualParagraph", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "width", "", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "ActualParagraph-XGqx6AY", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IIJLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)Landroidx/compose/ui/text/Paragraph;", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "ActualParagraph-4FmOz70", "(Landroidx/compose/ui/text/ParagraphIntrinsics;IIJ)Landroidx/compose/ui/text/Paragraph;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidParagraph_androidKt {
    @Deprecated(message="Font.ResourceLoader is deprecated, instead pass FontFamily.Resolver", replaceWith="<_subannotation>") public static final Paragraph ActualParagraph(String arg7, TextStyle arg8, List arg9, List arg10, int arg11, boolean arg12, float arg13, Density arg14, ResourceLoader arg15) {
        AndroidParagraphIntrinsics v8 = new AndroidParagraphIntrinsics(arg7, arg8, arg9, arg10, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(arg15), arg14);
        Companion v9 = TextOverflow.Companion;
        int v9_1 = arg12 ? v9.getEllipsis-gIe3tQ8() : v9.getClip-gIe3tQ8();
        return new AndroidParagraph(v8, arg11, v9_1, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(arg13), 0, 0, 13, null), null);
    }

    public static final Paragraph ActualParagraph-4FmOz70(ParagraphIntrinsics arg7, int arg8, int arg9, long arg10) {
        Intrinsics.checkNotNull(arg7, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidParagraphIntrinsics");
        return new AndroidParagraph(arg7, arg8, arg9, arg10, null);
    }

    public static final Paragraph ActualParagraph-XGqx6AY(String arg8, TextStyle arg9, List arg10, List arg11, int arg12, int arg13, long arg14, Density arg16, Resolver arg17) {
        return new AndroidParagraph(new AndroidParagraphIntrinsics(arg8, arg9, arg10, arg11, arg17, arg16), arg12, arg13, arg14, null);
    }
}

