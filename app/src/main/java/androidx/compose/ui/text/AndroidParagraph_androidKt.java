package androidx.compose.ui.text;

import android.os.Build$VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.SpannedExtensions_androidKt;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak$Strategy;
import androidx.compose.ui.text.style.LineBreak$Strictness;
import androidx.compose.ui.text.style.LineBreak$WordBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0017\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u0017\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0005\u001A\u0017\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u0005\u001A\u0017\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0005\u001A\u0017\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0005\u001A\u0014\u0010\u0016\u001A\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0001H\u0002\u001A\u0018\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001AH\u0002\u001A\f\u0010\u001E\u001A\u00020\u001F*\u00020\u001FH\u0002\u001A\u0013\u0010 \u001A\u00020\u0001*\u00020!H\u0002¢\u0006\u0004\b\"\u0010\u0005¨\u0006#"}, d2={"toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "attachIndentationFixSpan", "", "toLayoutTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toLayoutTextGranularity-duNsdkg", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidParagraph_androidKt {
    public static final CharSequence access$attachIndentationFixSpan(CharSequence arg0) {
        return AndroidParagraph_androidKt.attachIndentationFixSpan(arg0);
    }

    public static final int access$numberOfLinesThatFitMaxHeight(TextLayout arg0, int arg1) {
        return AndroidParagraph_androidKt.numberOfLinesThatFitMaxHeight(arg0, arg1);
    }

    public static final boolean access$shouldAttachIndentationFixSpan(TextStyle arg0, boolean arg1) {
        return AndroidParagraph_androidKt.shouldAttachIndentationFixSpan(arg0, arg1);
    }

    public static final int access$toLayoutAlign-aXe7zB0(int arg0) {
        return AndroidParagraph_androidKt.toLayoutAlign-aXe7zB0(arg0);
    }

    public static final int access$toLayoutBreakStrategy-xImikfE(int arg0) {
        return AndroidParagraph_androidKt.toLayoutBreakStrategy-xImikfE(arg0);
    }

    public static final int access$toLayoutHyphenationFrequency--3fSNIE(int arg0) {
        return AndroidParagraph_androidKt.toLayoutHyphenationFrequency--3fSNIE(arg0);
    }

    public static final int access$toLayoutLineBreakStyle-hpcqdu8(int arg0) {
        return AndroidParagraph_androidKt.toLayoutLineBreakStyle-hpcqdu8(arg0);
    }

    public static final int access$toLayoutLineBreakWordStyle-wPN0Rpw(int arg0) {
        return AndroidParagraph_androidKt.toLayoutLineBreakWordStyle-wPN0Rpw(arg0);
    }

    public static final int access$toLayoutTextGranularity-duNsdkg(int arg0) {
        return AndroidParagraph_androidKt.toLayoutTextGranularity-duNsdkg(arg0);
    }

    private static final CharSequence attachIndentationFixSpan(CharSequence arg3) {
        if(arg3.length() == 0) {
            return arg3;
        }

        CharSequence v0 = (arg3 instanceof Spannable) ? arg3 : null;
        if(v0 == null) {
            SpannableString v0_1 = new SpannableString(arg3);
        }

        if(!SpannedExtensions_androidKt.hasSpan(v0, IndentationFixSpan.class)) {
            SpannableExtensions_androidKt.setSpan(((Spannable)v0), new IndentationFixSpan(), ((Spannable)v0).length() - 1, ((Spannable)v0).length() - 1);
        }

        return v0;
    }

    private static final int numberOfLinesThatFitMaxHeight(TextLayout arg4, int arg5) {
        int v0 = arg4.getLineCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(arg4.getLineBottom(v1) > (((float)arg5))) {
                return v1;
            }
        }

        return arg4.getLineCount();
    }

    private static final boolean shouldAttachIndentationFixSpan(TextStyle arg5, boolean arg6) {
        if((arg6) && !TextUnit.equals-impl0(arg5.getLetterSpacing-XSAIIZE(), TextUnitKt.getSp(0)) && !TextUnit.equals-impl0(arg5.getLetterSpacing-XSAIIZE(), TextUnit.Companion.getUnspecified-XSAIIZE()) && !TextAlign.equals-impl0(arg5.getTextAlign-e0LSkKk(), TextAlign.Companion.getUnspecified-e0LSkKk()) && !TextAlign.equals-impl0(arg5.getTextAlign-e0LSkKk(), TextAlign.Companion.getStart-e0LSkKk()) && !TextAlign.equals-impl0(arg5.getTextAlign-e0LSkKk(), TextAlign.Companion.getJustify-e0LSkKk())) {
            return 1;
        }

        return 0;
    }

    private static final int toLayoutAlign-aXe7zB0(int arg2) {
        if(TextAlign.equals-impl0(arg2, TextAlign.Companion.getLeft-e0LSkKk())) {
            return 3;
        }

        if(TextAlign.equals-impl0(arg2, TextAlign.Companion.getRight-e0LSkKk())) {
            return 4;
        }

        if(TextAlign.equals-impl0(arg2, TextAlign.Companion.getCenter-e0LSkKk())) {
            return 2;
        }

        if(TextAlign.equals-impl0(arg2, TextAlign.Companion.getStart-e0LSkKk())) {
            return 0;
        }

        if(TextAlign.equals-impl0(arg2, TextAlign.Companion.getEnd-e0LSkKk())) {
            return 1;
        }

        return 0;
    }

    private static final int toLayoutBreakStrategy-xImikfE(int arg2) {
        if(Strategy.equals-impl0(arg2, Strategy.Companion.getSimple-fcGXIks())) {
            return 0;
        }

        if(Strategy.equals-impl0(arg2, Strategy.Companion.getHighQuality-fcGXIks())) {
            return 1;
        }

        if(Strategy.equals-impl0(arg2, Strategy.Companion.getBalanced-fcGXIks())) {
            return 2;
        }

        return 0;
    }

    private static final int toLayoutHyphenationFrequency--3fSNIE(int arg1) {
        if(Hyphens.equals-impl0(arg1, Hyphens.Companion.getAuto-vmbZdU8())) {
            if(Build$VERSION.SDK_INT <= 0x20) {
                return 2;
            }

            return 4;
        }

        Hyphens.equals-impl0(arg1, Hyphens.Companion.getNone-vmbZdU8());
        return 0;
    }

    private static final int toLayoutLineBreakStyle-hpcqdu8(int arg2) {
        if(Strictness.equals-impl0(arg2, Strictness.Companion.getDefault-usljTpc())) {
            return 0;
        }

        if(Strictness.equals-impl0(arg2, Strictness.Companion.getLoose-usljTpc())) {
            return 1;
        }

        if(Strictness.equals-impl0(arg2, Strictness.Companion.getNormal-usljTpc())) {
            return 2;
        }

        if(Strictness.equals-impl0(arg2, Strictness.Companion.getStrict-usljTpc())) {
            return 3;
        }

        return 0;
    }

    private static final int toLayoutLineBreakWordStyle-wPN0Rpw(int arg2) {
        if(WordBreak.equals-impl0(arg2, WordBreak.Companion.getDefault-jp8hJ3c())) {
            return 0;
        }

        if(WordBreak.equals-impl0(arg2, WordBreak.Companion.getPhrase-jp8hJ3c())) {
            return 1;
        }

        return 0;
    }

    private static final int toLayoutTextGranularity-duNsdkg(int arg2) {
        if(TextGranularity.equals-impl0(arg2, TextGranularity.Companion.getCharacter-DRrd7Zo())) {
            return 0;
        }

        if(TextGranularity.equals-impl0(arg2, TextGranularity.Companion.getWord-DRrd7Zo())) {
            return 1;
        }

        return 0;
    }
}

