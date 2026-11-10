package androidx.compose.ui.text.android;

import android.text.Layout$Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\"\b\u0002\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u0005\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0005\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0013\u0012\u0006\u0010\u0015\u001A\u00020\u0005\u0012\u0006\u0010\u0016\u001A\u00020\u0017\u0012\u0006\u0010\u0018\u001A\u00020\u0017\u0012\u0006\u0010\u0019\u001A\u00020\u0005\u0012\u0006\u0010\u001A\u001A\u00020\u0005\u0012\u0006\u0010\u001B\u001A\u00020\u0005\u0012\u0006\u0010\u001C\u001A\u00020\u0005\u0012\b\u0010\u001D\u001A\u0004\u0018\u00010\u001E\u0012\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E¢\u0006\u0004\b \u0010!R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b&\u0010%R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b)\u0010%R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-R\u0011\u0010\u000E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b.\u0010%R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001A\u0004\b/\u00100R\u0011\u0010\u0011\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b1\u0010%R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b2\u00103R\u0011\u0010\u0014\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b4\u00103R\u0011\u0010\u0015\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b5\u0010%R\u0011\u0010\u0016\u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b6\u00107R\u0011\u0010\u0018\u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b8\u00107R\u0011\u0010\u0019\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b9\u0010%R\u0011\u0010\u001A\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b:\u0010%R\u0011\u0010\u001B\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b;\u0010%R\u0011\u0010\u001C\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b<\u0010%R\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u001E¢\u0006\b\n\u0000\u001A\u0004\b=\u0010>R\u0013\u0010\u001F\u001A\u0004\u0018\u00010\u001E¢\u0006\b\n\u0000\u001A\u0004\b?\u0010>¨\u0006@"}, d2={"Landroidx/compose/ui/text/android/StaticLayoutParams;", "", "text", "", "start", "", "end", "paint", "Landroid/text/TextPaint;", "width", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "leftIndents", "", "rightIndents", "<init>", "(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/TextDirectionHeuristic;Landroid/text/Layout$Alignment;ILandroid/text/TextUtils$TruncateAt;IFFIZZIIII[I[I)V", "getText", "()Ljava/lang/CharSequence;", "getStart", "()I", "getEnd", "getPaint", "()Landroid/text/TextPaint;", "getWidth", "getTextDir", "()Landroid/text/TextDirectionHeuristic;", "getAlignment", "()Landroid/text/Layout$Alignment;", "getMaxLines", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "getEllipsizedWidth", "getLineSpacingMultiplier", "()F", "getLineSpacingExtra", "getJustificationMode", "getIncludePadding", "()Z", "getUseFallbackLineSpacing", "getBreakStrategy", "getLineBreakStyle", "getLineBreakWordStyle", "getHyphenationFrequency", "getLeftIndents", "()[I", "getRightIndents", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class StaticLayoutParams {
    private final Layout$Alignment alignment;
    private final int breakStrategy;
    private final TextUtils$TruncateAt ellipsize;
    private final int ellipsizedWidth;
    private final int end;
    private final int hyphenationFrequency;
    private final boolean includePadding;
    private final int justificationMode;
    private final int[] leftIndents;
    private final int lineBreakStyle;
    private final int lineBreakWordStyle;
    private final float lineSpacingExtra;
    private final float lineSpacingMultiplier;
    private final int maxLines;
    private final TextPaint paint;
    private final int[] rightIndents;
    private final int start;
    private final CharSequence text;
    private final TextDirectionHeuristic textDir;
    private final boolean useFallbackLineSpacing;
    private final int width;

    public StaticLayoutParams(CharSequence arg1, int arg2, int arg3, TextPaint arg4, int arg5, TextDirectionHeuristic arg6, Layout$Alignment arg7, int arg8, TextUtils$TruncateAt arg9, int arg10, float arg11, float arg12, int arg13, boolean arg14, boolean arg15, int arg16, int arg17, int arg18, int arg19, int[] arg20, int[] arg21) {
        super();
        this.text = arg1;
        this.start = arg2;
        this.end = arg3;
        this.paint = arg4;
        this.width = arg5;
        this.textDir = arg6;
        this.alignment = arg7;
        this.maxLines = arg8;
        this.ellipsize = arg9;
        this.ellipsizedWidth = arg10;
        this.lineSpacingMultiplier = arg11;
        this.lineSpacingExtra = arg12;
        this.justificationMode = arg13;
        this.includePadding = arg14;
        this.useFallbackLineSpacing = arg15;
        this.breakStrategy = arg16;
        this.lineBreakStyle = arg17;
        this.lineBreakWordStyle = arg18;
        this.hyphenationFrequency = arg19;
        this.leftIndents = arg20;
        this.rightIndents = arg21;
        int v0 = 1;
        arg2 = arg2 < 0 || arg2 > arg3 ? 0 : 1;
        if(arg2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid start value");
        }

        int v1 = arg1.length();
        v1 = arg3 < 0 || arg3 > v1 ? 0 : 1;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid end value");
        }

        v1 = arg8 >= 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid maxLines value");
        }

        v1 = arg5 >= 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid width value");
        }

        v1 = arg10 >= 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid ellipsizedWidth value");
        }

        if(arg11 >= 0f) {
        }
        else {
            v0 = 0;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid lineSpacingMultiplier value");
        }
    }

    public StaticLayoutParams(CharSequence arg24, int arg25, int arg26, TextPaint arg27, int arg28, TextDirectionHeuristic arg29, Layout$Alignment arg30, int arg31, TextUtils$TruncateAt arg32, int arg33, float arg34, float arg35, int arg36, boolean arg37, boolean arg38, int arg39, int arg40, int arg41, int arg42, int[] arg43, int[] arg44, int arg45, DefaultConstructorMarker arg46) {
        int v3 = (arg45 & 2) != 0 ? 0 : arg25;
        this(arg24, v3, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44);
    }

    public final Layout$Alignment getAlignment() {
        return this.alignment;
    }

    public final int getBreakStrategy() {
        return this.breakStrategy;
    }

    public final TextUtils$TruncateAt getEllipsize() {
        return this.ellipsize;
    }

    public final int getEllipsizedWidth() {
        return this.ellipsizedWidth;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final int getJustificationMode() {
        return this.justificationMode;
    }

    public final int[] getLeftIndents() {
        return this.leftIndents;
    }

    public final int getLineBreakStyle() {
        return this.lineBreakStyle;
    }

    public final int getLineBreakWordStyle() {
        return this.lineBreakWordStyle;
    }

    public final float getLineSpacingExtra() {
        return this.lineSpacingExtra;
    }

    public final float getLineSpacingMultiplier() {
        return this.lineSpacingMultiplier;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final TextPaint getPaint() {
        return this.paint;
    }

    public final int[] getRightIndents() {
        return this.rightIndents;
    }

    public final int getStart() {
        return this.start;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final TextDirectionHeuristic getTextDir() {
        return this.textDir;
    }

    public final boolean getUseFallbackLineSpacing() {
        return this.useFallbackLineSpacing;
    }

    public final int getWidth() {
        return this.width;
    }
}

