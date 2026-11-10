package androidx.compose.ui.text;

import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A \u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\bH\u0007\u001A&\u0010\t\u001A\u0004\u0018\u00010\n2\b\u0010\u0005\u001A\u0004\u0018\u00010\n2\b\u0010\u0006\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001A\u00020\bH\u0002\u001A\u0018\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u000EH\u0000\u001Ac\u0010\u000F\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00012\b\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\n2\b\u0010\u0018\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FH\u0000¢\u0006\u0004\b \u0010!\u001A\u0018\u0010\"\u001A\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001A\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006$"}, d2={"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ParagraphStyleKt {
    private static final long DefaultLineHeight;

    static {
        ParagraphStyleKt.DefaultLineHeight = TextUnit.Companion.getUnspecified-XSAIIZE();
    }

    public static final ParagraphStyle fastMerge-j5T8yCg(ParagraphStyle arg23, int arg24, int arg25, long arg26, TextIndent arg28, PlatformParagraphStyle arg29, LineHeightStyle arg30, int arg31, int arg32, TextMotion arg33) {
        long v14;
        ParagraphStyle v0 = arg23;
        int v1 = arg24;
        int v2 = arg25;
        TextIndent v3 = arg28;
        PlatformParagraphStyle v4 = arg29;
        LineHeightStyle v5 = arg30;
        int v6 = arg31;
        int v7 = arg32;
        TextMotion v8 = arg33;
        long v10 = 0;
        if((TextAlign.equals-impl0(v1, TextAlign.Companion.getUnspecified-e0LSkKk())) || (TextAlign.equals-impl0(v1, v0.getTextAlign-e0LSkKk()))) {
            int v9 = TextUnit.getRawType-impl(arg26) == v10 ? 1 : 0;
            if(v9 == 0) {
                v14 = arg26;
                if(TextUnit.equals-impl0(v14, v0.getLineHeight-XSAIIZE())) {
                }
                else {
                    goto label_69;
                }
            }
            else {
                v14 = arg26;
            }

            if(v3 != null && !Intrinsics.areEqual(v3, v0.getTextIndent())) {
                goto label_69;
            }

            if(!TextDirection.equals-impl0(v2, TextDirection.Companion.getUnspecified-s_7X-co()) && !TextDirection.equals-impl0(v2, v0.getTextDirection-s_7X-co())) {
                goto label_69;
            }

            if(v4 != null && !Intrinsics.areEqual(v4, v0.getPlatformStyle())) {
                goto label_69;
            }

            if(v5 != null && !Intrinsics.areEqual(v5, v0.getLineHeightStyle())) {
                goto label_69;
            }

            if(!LineBreak.equals-impl0(v6, LineBreak.Companion.getUnspecified-rAG3T2k()) && !LineBreak.equals-impl0(v6, v0.getLineBreak-rAG3T2k())) {
                goto label_69;
            }

            if(!Hyphens.equals-impl0(v7, Hyphens.Companion.getUnspecified-vmbZdU8()) && !Hyphens.equals-impl0(v7, v0.getHyphens-vmbZdU8())) {
                goto label_69;
            }

            if(v8 != null && !Intrinsics.areEqual(v8, v0.getTextMotion())) {
                goto label_69;
            }

            return v0;
        }
        else {
            v14 = arg26;
        }

    label_69:
        if(TextUnit.getRawType-impl(v14) == v10) {
            v14 = v0.getLineHeight-XSAIIZE();
        }

        if(v3 == null) {
            v3 = v0.getTextIndent();
        }

        TextIndent v16 = v3;
        if(!TextAlign.equals-impl0(v1, TextAlign.Companion.getUnspecified-e0LSkKk())) {
        }
        else {
            v1 = v0.getTextAlign-e0LSkKk();
        }

        int v12 = v1;
        int v13 = !TextDirection.equals-impl0(v2, TextDirection.Companion.getUnspecified-s_7X-co()) ? v2 : v0.getTextDirection-s_7X-co();
        PlatformParagraphStyle v17 = ParagraphStyleKt.mergePlatformStyle(v0, v4);
        LineHeightStyle v18 = v5 == null ? v0.getLineHeightStyle() : v5;
        int v19 = !LineBreak.equals-impl0(v6, LineBreak.Companion.getUnspecified-rAG3T2k()) ? v6 : v0.getLineBreak-rAG3T2k();
        int v20 = !Hyphens.equals-impl0(v7, Hyphens.Companion.getUnspecified-vmbZdU8()) ? v7 : v0.getHyphens-vmbZdU8();
        TextMotion v21 = v8 == null ? v0.getTextMotion() : v8;
        return new ParagraphStyle(v12, v13, v14, v16, v17, v18, v19, v20, v21, null);
    }

    public static final ParagraphStyle lerp(ParagraphStyle arg12, ParagraphStyle arg13, float arg14) {
        int v1 = SpanStyleKt.lerpDiscrete(TextAlign.box-impl(arg12.getTextAlign-e0LSkKk()), TextAlign.box-impl(arg13.getTextAlign-e0LSkKk()), arg14).unbox-impl();
        int v2 = SpanStyleKt.lerpDiscrete(TextDirection.box-impl(arg12.getTextDirection-s_7X-co()), TextDirection.box-impl(arg13.getTextDirection-s_7X-co()), arg14).unbox-impl();
        long v3 = SpanStyleKt.lerpTextUnitInheritable-C3pnCVY(arg12.getLineHeight-XSAIIZE(), arg13.getLineHeight-XSAIIZE(), arg14);
        TextIndent v5 = arg12.getTextIndent();
        if(v5 == null) {
            v5 = TextIndent.Companion.getNone();
        }

        TextIndent v6 = arg13.getTextIndent();
        if(v6 == null) {
            v6 = TextIndent.Companion.getNone();
        }

        return new ParagraphStyle(v1, v2, v3, TextIndentKt.lerp(v5, v6, arg14), ParagraphStyleKt.lerpPlatformStyle(arg12.getPlatformStyle(), arg13.getPlatformStyle(), arg14), SpanStyleKt.lerpDiscrete(arg12.getLineHeightStyle(), arg13.getLineHeightStyle(), arg14), SpanStyleKt.lerpDiscrete(LineBreak.box-impl(arg12.getLineBreak-rAG3T2k()), LineBreak.box-impl(arg13.getLineBreak-rAG3T2k()), arg14).unbox-impl(), SpanStyleKt.lerpDiscrete(Hyphens.box-impl(arg12.getHyphens-vmbZdU8()), Hyphens.box-impl(arg13.getHyphens-vmbZdU8()), arg14).unbox-impl(), SpanStyleKt.lerpDiscrete(arg12.getTextMotion(), arg13.getTextMotion(), arg14), null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle arg0, PlatformParagraphStyle arg1, float arg2) {
        if(arg0 == null && arg1 == null) {
            return null;
        }

        if(arg0 == null) {
            arg0 = PlatformParagraphStyle.Companion.getDefault();
        }

        if(arg1 == null) {
            arg1 = PlatformParagraphStyle.Companion.getDefault();
        }

        return AndroidTextStyle_androidKt.lerp(arg0, arg1, arg2);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle arg1, PlatformParagraphStyle arg2) {
        if(arg1.getPlatformStyle() == null) {
            return arg2;
        }

        if(arg2 == null) {
            return arg1.getPlatformStyle();
        }

        return arg1.getPlatformStyle().merge(arg2);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle arg12, LayoutDirection arg13) {
        int v1 = TextAlign.equals-impl0(arg12.getTextAlign-e0LSkKk(), TextAlign.Companion.getUnspecified-e0LSkKk()) ? TextAlign.Companion.getStart-e0LSkKk() : arg12.getTextAlign-e0LSkKk();
        int v2 = TextStyleKt.resolveTextDirection-IhaHGbI(arg13, arg12.getTextDirection-s_7X-co());
        long v3 = TextUnit.getRawType-impl(arg12.getLineHeight-XSAIIZE()) == 0 ? ParagraphStyleKt.DefaultLineHeight : arg12.getLineHeight-XSAIIZE();
        TextIndent v13 = arg12.getTextIndent();
        if(v13 == null) {
            v13 = TextIndent.Companion.getNone();
        }

        TextIndent v5 = v13;
        PlatformParagraphStyle v6 = arg12.getPlatformStyle();
        LineHeightStyle v7 = arg12.getLineHeightStyle();
        int v13_1 = LineBreak.equals-impl0(arg12.getLineBreak-rAG3T2k(), LineBreak.Companion.getUnspecified-rAG3T2k()) ? LineBreak.Companion.getSimple-rAG3T2k() : arg12.getLineBreak-rAG3T2k();
        int v8 = v13_1;
        v13_1 = Hyphens.equals-impl0(arg12.getHyphens-vmbZdU8(), Hyphens.Companion.getUnspecified-vmbZdU8()) ? Hyphens.Companion.getNone-vmbZdU8() : arg12.getHyphens-vmbZdU8();
        int v9 = v13_1;
        TextMotion v12 = arg12.getTextMotion();
        if(v12 == null) {
            v12 = TextMotion.Companion.getStatic();
        }

        return new ParagraphStyle(v1, v2, v3, v5, v6, v7, v8, v9, v12, null);
    }
}

