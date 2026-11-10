package androidx.compose.ui.text;

import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.platform.AndroidParagraph_androidKt;
import androidx.compose.ui.text.style.TextOverflow$Companion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001Ap\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0014\b\u0002\u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n0\t2\u0014\b\u0002\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\b\b\u0002\u0010\u000E\u001A\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0007\u001Ap\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00182\u0014\b\u0002\u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n0\t2\u0014\b\u0002\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\b\b\u0002\u0010\u000E\u001A\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u0010H\u0007\u001Aw\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00182\u0014\b\u0002\u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n0\t2\u0014\b\u0002\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\b\b\u0002\u0010\u000E\u001A\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u0010H\u0007¢\u0006\u0004\b\u001B\u0010\u001C\u001Au\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00182\u0014\b\u0002\u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n0\t2\u0014\b\u0002\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\b\b\u0002\u0010\u000E\u001A\u00020\u00012\b\b\u0002\u0010\u001D\u001A\u00020\u001E¢\u0006\u0004\b\u001F\u0010 \u001A,\u0010\u0002\u001A\u00020\u00032\u0006\u0010!\u001A\u00020\"2\b\b\u0002\u0010\u000E\u001A\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0007\u001A3\u0010\u0002\u001A\u00020\u00032\u0006\u0010!\u001A\u00020\"2\u0006\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u000E\u001A\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u0010H\u0007¢\u0006\u0004\b#\u0010$\u001A1\u0010\u0002\u001A\u00020\u00032\u0006\u0010!\u001A\u00020\"2\u0006\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u000E\u001A\u00020\u00012\b\b\u0002\u0010\u001D\u001A\u00020\u001E¢\u0006\u0004\b%\u0010&\u001A\f\u0010\'\u001A\u00020\u0001*\u00020\u0012H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006("}, d2={"DefaultMaxLines", "", "Paragraph", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "ellipsis", "", "width", "", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "Paragraph-UdtVg6A", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Ljava/util/List;IZ)Landroidx/compose/ui/text/Paragraph;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "Paragraph-Ul8oQg4", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Ljava/util/List;II)Landroidx/compose/ui/text/Paragraph;", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "Paragraph-_EkL_-Y", "(Landroidx/compose/ui/text/ParagraphIntrinsics;JIZ)Landroidx/compose/ui/text/Paragraph;", "Paragraph-czeN-Hc", "(Landroidx/compose/ui/text/ParagraphIntrinsics;JII)Landroidx/compose/ui/text/Paragraph;", "ceilToInt", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ParagraphKt {
    public static final int DefaultMaxLines = 0x7FFFFFFF;

    @Deprecated(message="Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith="<_subannotation>") public static final Paragraph Paragraph(ParagraphIntrinsics arg6, int arg7, boolean arg8, float arg9) {
        int v8 = arg8 ? TextOverflow.Companion.getEllipsis-gIe3tQ8() : TextOverflow.Companion.getClip-gIe3tQ8();
        return AndroidParagraph_androidKt.ActualParagraph-4FmOz70(arg6, arg7, v8, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(arg9), 0, 0, 13, null));
    }

    @Deprecated(message="Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith="<_subannotation>") public static final Paragraph Paragraph(String arg11, TextStyle arg12, float arg13, Density arg14, Resolver arg15, List arg16, List arg17, int arg18, boolean arg19) {
        Companion v0 = TextOverflow.Companion;
        int v0_1 = arg19 ? v0.getEllipsis-gIe3tQ8() : v0.getClip-gIe3tQ8();
        return AndroidParagraph_androidKt.ActualParagraph-XGqx6AY(arg11, arg12, arg16, arg17, arg18, v0_1, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(arg13), 0, 0, 13, null), arg14, arg15);
    }

    @Deprecated(message="Font.ResourceLoader is deprecated, instead pass FontFamily.Resolver", replaceWith="<_subannotation>") public static final Paragraph Paragraph(String arg0, TextStyle arg1, List arg2, List arg3, int arg4, boolean arg5, float arg6, Density arg7, ResourceLoader arg8) {
        return AndroidParagraph_androidKt.ActualParagraph(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static Paragraph Paragraph$default(ParagraphIntrinsics arg0, int arg1, boolean arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg1 = 0x7FFFFFFF;
        }

        return ParagraphKt.Paragraph(arg0, arg1, false, arg3);
    }

    public static Paragraph Paragraph$default(String arg11, TextStyle arg12, float arg13, Density arg14, Resolver arg15, List arg16, List arg17, int arg18, boolean arg19, int arg20, Object arg21) {
        int v0 = arg20;
        List v7 = (v0 & 0x20) != 0 ? CollectionsKt.emptyList() : arg16;
        List v8 = (v0 & 0x40) != 0 ? CollectionsKt.emptyList() : arg17;
        int v9 = (v0 & 0x80) != 0 ? 0x7FFFFFFF : arg18;
        boolean v10 = (v0 & 0x100) != 0 ? false : arg19;
        return ParagraphKt.Paragraph(arg11, arg12, arg13, arg14, arg15, v7, v8, v9, v10);
    }

    public static Paragraph Paragraph$default(String arg9, TextStyle arg10, List arg11, List arg12, int arg13, boolean arg14, float arg15, Density arg16, ResourceLoader arg17, int arg18, Object arg19) {
        if((arg18 & 4) != 0) {
            arg11 = CollectionsKt.emptyList();
        }

        List v2 = arg11;
        if((arg18 & 8) != 0) {
            arg12 = CollectionsKt.emptyList();
        }

        List v3 = arg12;
        if((arg18 & 16) != 0) {
            arg13 = 0x7FFFFFFF;
        }

        return ParagraphKt.Paragraph(arg9, arg10, v2, v3, arg13, false, arg15, arg16, arg17);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Paragraph that takes `ellipsis: Boolean` is deprecated, pass TextOverflow instead.") public static final Paragraph Paragraph-UdtVg6A(String arg11, TextStyle arg12, long arg13, Density arg15, Resolver arg16, List arg17, List arg18, int arg19, boolean arg20) {
        Companion v0 = TextOverflow.Companion;
        int v0_1 = arg20 ? v0.getEllipsis-gIe3tQ8() : v0.getClip-gIe3tQ8();
        return AndroidParagraph_androidKt.ActualParagraph-XGqx6AY(arg11, arg12, arg17, arg18, arg19, v0_1, arg13, arg15, arg16);
    }

    public static Paragraph Paragraph-UdtVg6A$default(String arg12, TextStyle arg13, long arg14, Density arg16, Resolver arg17, List arg18, List arg19, int arg20, boolean arg21, int arg22, Object arg23) {
        int v0 = arg22;
        List v8 = (v0 & 0x20) != 0 ? CollectionsKt.emptyList() : arg18;
        List v9 = (v0 & 0x40) != 0 ? CollectionsKt.emptyList() : arg19;
        int v10 = (v0 & 0x80) != 0 ? 0x7FFFFFFF : arg20;
        boolean v11 = (v0 & 0x100) != 0 ? false : arg21;
        return ParagraphKt.Paragraph-UdtVg6A(arg12, arg13, arg14, arg16, arg17, v8, v9, v10, v11);
    }

    public static final Paragraph Paragraph-Ul8oQg4(String arg2, TextStyle arg3, long arg4, Density arg6, Resolver arg7, List arg8, List arg9, int arg10, int arg11) {
        return AndroidParagraph_androidKt.ActualParagraph-XGqx6AY(arg2, arg3, arg8, arg9, arg10, arg11, arg4, arg6, arg7);
    }

    public static Paragraph Paragraph-Ul8oQg4$default(String arg12, TextStyle arg13, long arg14, Density arg16, Resolver arg17, List arg18, List arg19, int arg20, int arg21, int arg22, Object arg23) {
        int v0 = arg22;
        List v8 = (v0 & 0x20) != 0 ? CollectionsKt.emptyList() : arg18;
        List v9 = (v0 & 0x40) != 0 ? CollectionsKt.emptyList() : arg19;
        int v10 = (v0 & 0x80) != 0 ? 0x7FFFFFFF : arg20;
        int v11 = (v0 & 0x100) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg21;
        return ParagraphKt.Paragraph-Ul8oQg4(arg12, arg13, arg14, arg16, arg17, v8, v9, v10, v11);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Paragraph that takes ellipsis: Boolean is deprecated, pass TextOverflow instead.", replaceWith="<_subannotation>") public static final Paragraph Paragraph-_EkL_-Y(ParagraphIntrinsics arg0, long arg1, int arg3, boolean arg4) {
        int v4 = arg4 ? TextOverflow.Companion.getEllipsis-gIe3tQ8() : TextOverflow.Companion.getClip-gIe3tQ8();
        return AndroidParagraph_androidKt.ActualParagraph-4FmOz70(arg0, arg3, v4, arg1);
    }

    public static Paragraph Paragraph-_EkL_-Y$default(ParagraphIntrinsics arg0, long arg1, int arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = 0x7FFFFFFF;
        }

        return ParagraphKt.Paragraph-_EkL_-Y(arg0, arg1, arg3, false);
    }

    public static final Paragraph Paragraph-czeN-Hc(ParagraphIntrinsics arg0, long arg1, int arg3, int arg4) {
        return AndroidParagraph_androidKt.ActualParagraph-4FmOz70(arg0, arg3, arg4, arg1);
    }

    public static Paragraph Paragraph-czeN-Hc$default(ParagraphIntrinsics arg0, long arg1, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = 0x7FFFFFFF;
        }

        if((arg5 & 8) != 0) {
            arg4 = TextOverflow.Companion.getClip-gIe3tQ8();
        }

        return ParagraphKt.Paragraph-czeN-Hc(arg0, arg1, arg3, arg4);
    }

    public static final int ceilToInt(float arg2) {
        return ((int)(((float)Math.ceil(((double)arg2)))));
    }
}

