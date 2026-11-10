package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015Bs\b\u0017\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0016B7\b\u0017\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\u0014\u0010\u0017BO\b\u0017\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0018Bg\b\u0017\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0019J\u0014\u0010<\u001A\u00020\u00002\n\b\u0002\u0010=\u001A\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010>\u001A\u00020\u00002\u0006\u0010=\u001A\u00020\u0000H\u0087\u0002J=\u0010?\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b@\u0010AJU\u0010?\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\bB\u0010CJm\u0010?\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\bD\u0010EJy\u0010?\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\bF\u0010GJo\u0010?\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001A\u00020K2\b\u0010=\u001A\u0004\u0018\u00010LH\u0096\u0002J\b\u0010M\u001A\u00020NH\u0016J\b\u0010O\u001A\u00020PH\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\u001D\u0010\u001BR\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010 \u001A\u0004\b\u001E\u0010\u001FR\u0013\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0013\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$R\u0013\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0013\u0010\u000E\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\'\u0010\u001BR\u0013\u0010\u0010\u001A\u00020\u0011¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b(\u0010\u001BR\u0013\u0010\u0012\u001A\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001A\u0004\b)\u0010*R\u001C\u0010+\u001A\u0004\u0018\u00010\u00038GX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010-\u001A\u0004\b.\u0010/R\u001C\u00100\u001A\u0004\u0018\u00010\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b1\u0010-\u001A\u0004\b2\u00103R\u001C\u00104\u001A\u0004\u0018\u00010\u00118GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010-\u001A\u0004\b6\u00107R\u001C\u00108\u001A\u0004\u0018\u00010\u000F8GX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010-\u001A\u0004\b:\u0010;¨\u0006Q"}, d2={"Landroidx/compose/ui/text/ParagraphStyle;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "<init>", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextAlign-e0LSkKk", "()I", "I", "getTextDirection-s_7X-co", "getLineHeight-XSAIIZE", "()J", "J", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getLineBreak-rAG3T2k", "getHyphens-vmbZdU8", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "deprecated_boxing_textAlign", "getTextAlign-buA522U$annotations", "()V", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "deprecated_boxing_textDirection", "getTextDirection-mmuk1to$annotations", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "deprecated_boxing_hyphens", "getHyphens-EaSxIns$annotations", "getHyphens-EaSxIns", "()Landroidx/compose/ui/text/style/Hyphens;", "deprecated_boxing_lineBreak", "getLineBreak-LgCVezo$annotations", "getLineBreak-LgCVezo", "()Landroidx/compose/ui/text/style/LineBreak;", "merge", "other", "plus", "copy", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-xPh5V4g", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-ciSxzs0", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-NH1kkwU", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-ykzQM6k", "(IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", "", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ParagraphStyle implements Annotation {
    public static final int $stable;
    private final int hyphens;
    private final int lineBreak;
    private final long lineHeight;
    private final LineHeightStyle lineHeightStyle;
    private final PlatformParagraphStyle platformStyle;
    private final int textAlign;
    private final int textDirection;
    private final TextIndent textIndent;
    private final TextMotion textMotion;

    static {
    }

    public ParagraphStyle(int arg12, int arg13, long arg14, TextIndent arg16, PlatformParagraphStyle arg17, LineHeightStyle arg18, int arg19, int arg20, TextMotion arg21, int arg22, DefaultConstructorMarker arg23) {
        int v0 = arg22;
        int v1 = (v0 & 1) != 0 ? TextAlign.Companion.getUnspecified-e0LSkKk() : arg12;
        int v2 = (v0 & 2) != 0 ? TextDirection.Companion.getUnspecified-s_7X-co() : arg13;
        long v3 = (v0 & 4) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg14;
        TextMotion v6 = null;
        TextIndent v5 = (v0 & 8) != 0 ? ((TextIndent)v6) : arg16;
        PlatformParagraphStyle v7 = (v0 & 16) != 0 ? ((PlatformParagraphStyle)v6) : arg17;
        LineHeightStyle v8 = (v0 & 0x20) != 0 ? ((LineHeightStyle)v6) : arg18;
        int v9 = (v0 & 0x40) != 0 ? LineBreak.Companion.getUnspecified-rAG3T2k() : arg19;
        int v10 = (v0 & 0x80) != 0 ? Hyphens.Companion.getUnspecified-vmbZdU8() : arg20;
        if((v0 & 0x100) != 0) {
        }
        else {
            v6 = arg21;
        }

        this(v1, v2, v3, v5, v7, v8, v9, v10, v6, null);
    }

    private ParagraphStyle(int arg1, int arg2, long arg3, TextIndent arg5, PlatformParagraphStyle arg6, LineHeightStyle arg7, int arg8, int arg9, TextMotion arg10) {
        super();
        this.textAlign = arg1;
        this.textDirection = arg2;
        this.lineHeight = arg3;
        this.textIndent = arg5;
        this.platformStyle = arg6;
        this.lineHeightStyle = arg7;
        this.lineBreak = arg8;
        this.hyphens = arg9;
        this.textMotion = arg10;
        if(!TextUnit.equals-impl0(arg3, TextUnit.Companion.getUnspecified-XSAIIZE())) {
            int v0 = TextUnit.getValue-impl(arg3) >= 0f ? 1 : 0;
            if(v0 != 0) {
                return;
            }

            InlineClassHelperKt.throwIllegalStateException("lineHeight can\'t be negative (" + TextUnit.getValue-impl(arg3) + ')');
        }
    }

    public ParagraphStyle(int arg1, int arg2, long arg3, TextIndent arg5, PlatformParagraphStyle arg6, LineHeightStyle arg7, int arg8, int arg9, TextMotion arg10, DefaultConstructorMarker arg11) {
        this(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    private ParagraphStyle(TextAlign arg13, TextDirection arg14, long arg15, TextIndent arg17) {
        int v13 = arg13 != null ? arg13.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v1 = v13;
        v13 = arg14 != null ? arg14.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        this(v1, v13, arg15, arg17, null, null, LineBreak.Companion.getUnspecified-rAG3T2k(), Hyphens.Companion.getUnspecified-vmbZdU8(), null, null);
    }

    public ParagraphStyle(TextAlign arg2, TextDirection arg3, long arg4, TextIndent arg6, int arg7, DefaultConstructorMarker arg8) {
        TextAlign v0 = null;
        if((arg7 & 1) != 0) {
            arg2 = v0;
        }

        if((arg7 & 2) != 0) {
            arg3 = ((TextDirection)v0);
        }

        if((arg7 & 4) != 0) {
            arg4 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }

        if((arg7 & 8) != 0) {
            arg6 = ((TextIndent)v0);
        }

        this(arg2, arg3, arg4, arg6, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructor.") public ParagraphStyle(TextAlign arg1, TextDirection arg2, long arg3, TextIndent arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg5);
    }

    private ParagraphStyle(TextAlign arg13, TextDirection arg14, long arg15, TextIndent arg17, PlatformParagraphStyle arg18, LineHeightStyle arg19) {
        int v13 = arg13 != null ? arg13.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v1 = v13;
        v13 = arg14 != null ? arg14.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        this(v1, v13, arg15, arg17, arg18, arg19, LineBreak.Companion.getUnspecified-rAG3T2k(), Hyphens.Companion.getUnspecified-vmbZdU8(), null, null);
    }

    public ParagraphStyle(TextAlign arg2, TextDirection arg3, long arg4, TextIndent arg6, PlatformParagraphStyle arg7, LineHeightStyle arg8, int arg9, DefaultConstructorMarker arg10) {
        TextAlign v0 = null;
        if((arg9 & 1) != 0) {
            arg2 = v0;
        }

        if((arg9 & 2) != 0) {
            arg3 = ((TextDirection)v0);
        }

        if((arg9 & 4) != 0) {
            arg4 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }

        if((arg9 & 8) != 0) {
            arg6 = ((TextIndent)v0);
        }

        if((arg9 & 16) != 0) {
            arg7 = ((PlatformParagraphStyle)v0);
        }

        if((arg9 & 0x20) != 0) {
            arg8 = ((LineHeightStyle)v0);
        }

        this(arg2, arg3, arg4, arg6, arg7, arg8, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="ParagraphStyle constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable constructors.") public ParagraphStyle(TextAlign arg1, TextDirection arg2, long arg3, TextIndent arg5, PlatformParagraphStyle arg6, LineHeightStyle arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg5, arg6, arg7);
    }

    private ParagraphStyle(TextAlign arg13, TextDirection arg14, long arg15, TextIndent arg17, PlatformParagraphStyle arg18, LineHeightStyle arg19, LineBreak arg20, Hyphens arg21) {
        int v13 = arg13 != null ? arg13.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v1 = v13;
        v13 = arg14 != null ? arg14.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        int v2 = v13;
        v13 = arg20 != null ? arg20.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v8 = v13;
        v13 = arg21 != null ? arg21.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        this(v1, v2, arg15, arg17, arg18, arg19, v8, v13, null, null);
    }

    public ParagraphStyle(TextAlign arg2, TextDirection arg3, long arg4, TextIndent arg6, PlatformParagraphStyle arg7, LineHeightStyle arg8, LineBreak arg9, Hyphens arg10, int arg11, DefaultConstructorMarker arg12) {
        TextAlign v0 = null;
        if((arg11 & 1) != 0) {
            arg2 = v0;
        }

        if((arg11 & 2) != 0) {
            arg3 = ((TextDirection)v0);
        }

        if((arg11 & 4) != 0) {
            arg4 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }

        if((arg11 & 8) != 0) {
            arg6 = ((TextIndent)v0);
        }

        if((arg11 & 16) != 0) {
            arg7 = ((PlatformParagraphStyle)v0);
        }

        if((arg11 & 0x20) != 0) {
            arg8 = ((LineHeightStyle)v0);
        }

        if((arg11 & 0x40) != 0) {
            arg9 = ((LineBreak)v0);
        }

        if((arg11 & 0x80) != 0) {
            arg10 = ((Hyphens)v0);
        }

        this(arg2, arg3, arg4, arg6, arg7, arg8, arg9, arg10, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="ParagraphStyle constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable constructors.") public ParagraphStyle(TextAlign arg1, TextDirection arg2, long arg3, TextIndent arg5, PlatformParagraphStyle arg6, LineHeightStyle arg7, LineBreak arg8, Hyphens arg9, DefaultConstructorMarker arg10) {
        this(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9);
    }

    private ParagraphStyle(TextAlign arg13, TextDirection arg14, long arg15, TextIndent arg17, PlatformParagraphStyle arg18, LineHeightStyle arg19, LineBreak arg20, Hyphens arg21, TextMotion arg22) {
        int v13 = arg13 != null ? arg13.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v1 = v13;
        v13 = arg14 != null ? arg14.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        int v2 = v13;
        v13 = arg20 != null ? arg20.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v8 = v13;
        v13 = arg21 != null ? arg21.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        this(v1, v2, arg15, arg17, arg18, arg19, v8, v13, arg22, null);
    }

    public ParagraphStyle(TextAlign arg2, TextDirection arg3, long arg4, TextIndent arg6, PlatformParagraphStyle arg7, LineHeightStyle arg8, LineBreak arg9, Hyphens arg10, TextMotion arg11, int arg12, DefaultConstructorMarker arg13) {
        TextAlign v0 = null;
        if((arg12 & 1) != 0) {
            arg2 = v0;
        }

        if((arg12 & 2) != 0) {
            arg3 = ((TextDirection)v0);
        }

        if((arg12 & 4) != 0) {
            arg4 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }

        if((arg12 & 8) != 0) {
            arg6 = ((TextIndent)v0);
        }

        if((arg12 & 16) != 0) {
            arg7 = ((PlatformParagraphStyle)v0);
        }

        if((arg12 & 0x20) != 0) {
            arg8 = ((LineHeightStyle)v0);
        }

        if((arg12 & 0x40) != 0) {
            arg9 = ((LineBreak)v0);
        }

        if((arg12 & 0x80) != 0) {
            arg10 = ((Hyphens)v0);
        }

        if((arg12 & 0x100) != 0) {
            arg11 = ((TextMotion)v0);
        }

        this(arg2, arg3, arg4, arg6, arg7, arg8, arg9, arg10, arg11, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="ParagraphStyle constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.") public ParagraphStyle(TextAlign arg1, TextDirection arg2, long arg3, TextIndent arg5, PlatformParagraphStyle arg6, LineHeightStyle arg7, LineBreak arg8, Hyphens arg9, TextMotion arg10, DefaultConstructorMarker arg11) {
        this(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.") public final ParagraphStyle copy-Elsmlbk(TextAlign arg13, TextDirection arg14, long arg15, TextIndent arg17) {
        int v13 = arg13 != null ? arg13.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v1 = v13;
        v13 = arg14 != null ? arg14.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        return new ParagraphStyle(v1, v13, arg15, arg17, this.platformStyle, this.lineHeightStyle, this.lineBreak, this.hyphens, this.textMotion, null);
    }

    public static ParagraphStyle copy-Elsmlbk$default(ParagraphStyle arg0, TextAlign arg1, TextDirection arg2, long arg3, TextIndent arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = TextAlign.box-impl(arg0.textAlign);
        }

        if((arg6 & 2) != 0) {
            arg2 = TextDirection.box-impl(arg0.textDirection);
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.lineHeight;
        }

        if((arg6 & 8) != 0) {
            arg5 = arg0.textIndent;
        }

        return arg0.copy-Elsmlbk(arg1, arg2, arg3, arg5);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="ParagraphStyle copy constructors that take nullable TextAlign, TextDirection, LineBreak, and Hyphens are deprecated. Please use a new constructor where these parameters are non-nullable. Null value has been replaced by a special Unspecified object for performance reason.") public final ParagraphStyle copy-NH1kkwU(TextAlign arg13, TextDirection arg14, long arg15, TextIndent arg17, PlatformParagraphStyle arg18, LineHeightStyle arg19, LineBreak arg20, Hyphens arg21, TextMotion arg22) {
        int v12 = arg13 != null ? arg13.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v1 = v12;
        v12 = arg14 != null ? arg14.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        int v2 = v12;
        v12 = arg20 != null ? arg20.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v8 = v12;
        v12 = arg21 != null ? arg21.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        return new ParagraphStyle(v1, v2, arg15, arg17, arg18, arg19, v8, v12, arg22, null);
    }

    public static ParagraphStyle copy-NH1kkwU$default(ParagraphStyle arg0, TextAlign arg1, TextDirection arg2, long arg3, TextIndent arg5, PlatformParagraphStyle arg6, LineHeightStyle arg7, LineBreak arg8, Hyphens arg9, TextMotion arg10, int arg11, Object arg12) {
        if((arg11 & 1) != 0) {
            arg1 = TextAlign.box-impl(arg0.textAlign);
        }

        if((arg11 & 2) != 0) {
            arg2 = TextDirection.box-impl(arg0.textDirection);
        }

        if((arg11 & 4) != 0) {
            arg3 = arg0.lineHeight;
        }

        if((arg11 & 8) != 0) {
            arg5 = arg0.textIndent;
        }

        if((arg11 & 16) != 0) {
            arg6 = arg0.platformStyle;
        }

        if((arg11 & 0x20) != 0) {
            arg7 = arg0.lineHeightStyle;
        }

        if((arg11 & 0x40) != 0) {
            arg8 = LineBreak.box-impl(arg0.lineBreak);
        }

        if((arg11 & 0x80) != 0) {
            arg9 = Hyphens.box-impl(arg0.hyphens);
        }

        if((arg11 & 0x100) != 0) {
            arg10 = arg0.textMotion;
        }

        return arg0.copy-NH1kkwU(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="ParagraphStyle copy constructors that do not take new stable parameters like LineBreak, Hyphens, TextMotion are deprecated. Please use the new stable copy constructor.") public final ParagraphStyle copy-ciSxzs0(TextAlign arg13, TextDirection arg14, long arg15, TextIndent arg17, PlatformParagraphStyle arg18, LineHeightStyle arg19, LineBreak arg20, Hyphens arg21) {
        int v13 = arg13 != null ? arg13.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v1 = v13;
        v13 = arg14 != null ? arg14.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        int v2 = v13;
        v13 = arg20 != null ? arg20.unbox-impl() : LineBreak.Companion.getUnspecified-rAG3T2k();
        int v8 = v13;
        v13 = arg21 != null ? arg21.unbox-impl() : Hyphens.Companion.getUnspecified-vmbZdU8();
        return new ParagraphStyle(v1, v2, arg15, arg17, arg18, arg19, v8, v13, this.textMotion, null);
    }

    public static ParagraphStyle copy-ciSxzs0$default(ParagraphStyle arg0, TextAlign arg1, TextDirection arg2, long arg3, TextIndent arg5, PlatformParagraphStyle arg6, LineHeightStyle arg7, LineBreak arg8, Hyphens arg9, int arg10, Object arg11) {
        if((arg10 & 1) != 0) {
            arg1 = TextAlign.box-impl(arg0.textAlign);
        }

        if((arg10 & 2) != 0) {
            arg2 = TextDirection.box-impl(arg0.textDirection);
        }

        if((arg10 & 4) != 0) {
            arg3 = arg0.lineHeight;
        }

        if((arg10 & 8) != 0) {
            arg5 = arg0.textIndent;
        }

        if((arg10 & 16) != 0) {
            arg6 = arg0.platformStyle;
        }

        if((arg10 & 0x20) != 0) {
            arg7 = arg0.lineHeightStyle;
        }

        if((arg10 & 0x40) != 0) {
            arg8 = LineBreak.box-impl(arg0.lineBreak);
        }

        if((arg10 & 0x80) != 0) {
            arg9 = Hyphens.box-impl(arg0.hyphens);
        }

        return arg0.copy-ciSxzs0(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="ParagraphStyle copy constructors that do not take new stable parameters like LineHeightStyle, LineBreak, Hyphens are deprecated. Please use the new stable copy constructor.") public final ParagraphStyle copy-xPh5V4g(TextAlign arg13, TextDirection arg14, long arg15, TextIndent arg17, PlatformParagraphStyle arg18, LineHeightStyle arg19) {
        int v13 = arg13 != null ? arg13.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
        int v1 = v13;
        v13 = arg14 != null ? arg14.unbox-impl() : TextDirection.Companion.getUnspecified-s_7X-co();
        return new ParagraphStyle(v1, v13, arg15, arg17, arg18, arg19, this.lineBreak, this.hyphens, this.textMotion, null);
    }

    public static ParagraphStyle copy-xPh5V4g$default(ParagraphStyle arg0, TextAlign arg1, TextDirection arg2, long arg3, TextIndent arg5, PlatformParagraphStyle arg6, LineHeightStyle arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = TextAlign.box-impl(arg0.textAlign);
        }

        if((arg8 & 2) != 0) {
            arg2 = TextDirection.box-impl(arg0.textDirection);
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.lineHeight;
        }

        if((arg8 & 8) != 0) {
            arg5 = arg0.textIndent;
        }

        if((arg8 & 16) != 0) {
            arg6 = arg0.platformStyle;
        }

        if((arg8 & 0x20) != 0) {
            arg7 = arg0.lineHeightStyle;
        }

        return arg0.copy-xPh5V4g(arg1, arg2, arg3, arg5, arg6, arg7);
    }

    public final ParagraphStyle copy-ykzQM6k(int arg13, int arg14, long arg15, TextIndent arg17, PlatformParagraphStyle arg18, LineHeightStyle arg19, int arg20, int arg21, TextMotion arg22) {
        return new ParagraphStyle(arg13, arg14, arg15, arg17, arg18, arg19, arg20, arg21, arg22, null);
    }

    public static ParagraphStyle copy-ykzQM6k$default(ParagraphStyle arg0, int arg1, int arg2, long arg3, TextIndent arg5, PlatformParagraphStyle arg6, LineHeightStyle arg7, int arg8, int arg9, TextMotion arg10, int arg11, Object arg12) {
        if((arg11 & 1) != 0) {
            arg1 = arg0.textAlign;
        }

        if((arg11 & 2) != 0) {
            arg2 = arg0.textDirection;
        }

        if((arg11 & 4) != 0) {
            arg3 = arg0.lineHeight;
        }

        if((arg11 & 8) != 0) {
            arg5 = arg0.textIndent;
        }

        if((arg11 & 16) != 0) {
            arg6 = arg0.platformStyle;
        }

        if((arg11 & 0x20) != 0) {
            arg7 = arg0.lineHeightStyle;
        }

        if((arg11 & 0x40) != 0) {
            arg8 = arg0.lineBreak;
        }

        if((arg11 & 0x80) != 0) {
            arg9 = arg0.hyphens;
        }

        if((arg11 & 0x100) != 0) {
            arg10 = arg0.textMotion;
        }

        return arg0.copy-ykzQM6k(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public boolean equals(Object arg8) {
        if(this == (((ParagraphStyle)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof ParagraphStyle)) {
            return 0;
        }

        if(!TextAlign.equals-impl0(this.textAlign, ((ParagraphStyle)arg8).textAlign)) {
            return 0;
        }

        if(!TextDirection.equals-impl0(this.textDirection, ((ParagraphStyle)arg8).textDirection)) {
            return 0;
        }

        if(!TextUnit.equals-impl0(this.lineHeight, ((ParagraphStyle)arg8).lineHeight)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textIndent, ((ParagraphStyle)arg8).textIndent)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.platformStyle, ((ParagraphStyle)arg8).platformStyle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.lineHeightStyle, ((ParagraphStyle)arg8).lineHeightStyle)) {
            return 0;
        }

        if(!LineBreak.equals-impl0(this.lineBreak, ((ParagraphStyle)arg8).lineBreak)) {
            return 0;
        }

        if(!Hyphens.equals-impl0(this.hyphens, ((ParagraphStyle)arg8).hyphens)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textMotion, ((ParagraphStyle)arg8).textMotion)) {
            return 0;
        }

        return 1;
    }

    public final Hyphens getHyphens-EaSxIns() {
        return Hyphens.box-impl(this.hyphens);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Kept for backwards compatibility.") public static void getHyphens-EaSxIns$annotations() {
    }

    public final int getHyphens-vmbZdU8() {
        return this.hyphens;
    }

    public final LineBreak getLineBreak-LgCVezo() {
        return LineBreak.box-impl(this.lineBreak);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Kept for backwards compatibility.") public static void getLineBreak-LgCVezo$annotations() {
    }

    public final int getLineBreak-rAG3T2k() {
        return this.lineBreak;
    }

    public final long getLineHeight-XSAIIZE() {
        return this.lineHeight;
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final TextAlign getTextAlign-buA522U() {
        return TextAlign.box-impl(this.textAlign);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Kept for backwards compatibility.") public static void getTextAlign-buA522U$annotations() {
    }

    public final int getTextAlign-e0LSkKk() {
        return this.textAlign;
    }

    public final TextDirection getTextDirection-mmuk1to() {
        return TextDirection.box-impl(this.textDirection);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Kept for backwards compatibility.") public static void getTextDirection-mmuk1to$annotations() {
    }

    public final int getTextDirection-s_7X-co() {
        return this.textDirection;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final TextMotion getTextMotion() {
        return this.textMotion;
    }

    public int hashCode() {
        int v0 = ((TextAlign.hashCode-impl(this.textAlign) * 0x1F + TextDirection.hashCode-impl(this.textDirection)) * 0x1F + TextUnit.hashCode-impl(this.lineHeight)) * 0x1F;
        TextIndent v1 = this.textIndent;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        PlatformParagraphStyle v1_2 = this.platformStyle;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        LineHeightStyle v1_3 = this.lineHeightStyle;
        v1_1 = v1_3 != null ? v1_3.hashCode() : 0;
        v0 = (((v0 + v1_1) * 0x1F + LineBreak.hashCode-impl(this.lineBreak)) * 0x1F + Hyphens.hashCode-impl(this.hyphens)) * 0x1F;
        TextMotion v3 = this.textMotion;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public final ParagraphStyle merge(ParagraphStyle arg12) {
        if(arg12 == null) {
            return this;
        }

        return ParagraphStyleKt.fastMerge-j5T8yCg(this, arg12.textAlign, arg12.textDirection, arg12.lineHeight, arg12.textIndent, arg12.platformStyle, arg12.lineHeightStyle, arg12.lineBreak, arg12.hyphens, arg12.textMotion);
    }

    public static ParagraphStyle merge$default(ParagraphStyle arg0, ParagraphStyle arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        return arg0.merge(arg1);
    }

    public final ParagraphStyle plus(ParagraphStyle arg1) {
        return this.merge(arg1);
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + TextAlign.toString-impl(this.textAlign) + ", textDirection=" + TextDirection.toString-impl(this.textDirection) + ", lineHeight=" + TextUnit.toString-impl(this.lineHeight) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + LineBreak.toString-impl(this.lineBreak) + ", hyphens=" + Hyphens.toString-impl(this.hyphens) + ", textMotion=" + this.textMotion + ')';
    }
}

