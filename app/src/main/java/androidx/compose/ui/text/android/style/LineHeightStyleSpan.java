package androidx.compose.ui.text.android.style;

import android.graphics.Paint$FontMetricsInt;
import android.text.style.LineHeightSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.LineHeightStyle$Mode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\b\u0001\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ8\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u00052\u0006\u0010%\u001A\u00020\u00052\u0006\u0010&\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00052\u0006\u0010\'\u001A\u00020(H\u0016J\u0010\u0010)\u001A\u00020!2\u0006\u0010\'\u001A\u00020(H\u0002J\'\u0010*\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b+R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u000E\u0010\n\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000B\u001A\u00020\f¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0017\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u001C\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0015R\u001E\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0015¨\u0006,"}, d2={"Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "startIndex", "", "endIndex", "trimFirstLineTop", "", "trimLastLineBottom", "topRatio", "mode", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "<init>", "(FIIZZFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineHeight", "()F", "getTrimFirstLineTop", "()Z", "getTrimLastLineBottom", "getMode-lzQqcRY", "()I", "I", "firstAscent", "ascent", "descent", "lastDescent", "value", "firstAscentDiff", "getFirstAscentDiff", "lastDescentDiff", "getLastDescentDiff", "chooseHeight", "", "text", "", "start", "end", "spanStartVertical", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "calculateTargetMetrics", "copy", "copy$ui_text", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LineHeightStyleSpan implements LineHeightSpan {
    public static final int $stable = 8;
    private int ascent;
    private int descent;
    private final int endIndex;
    private int firstAscent;
    private int firstAscentDiff;
    private int lastDescent;
    private int lastDescentDiff;
    private final float lineHeight;
    private final int mode;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;

    static {
    }

    private LineHeightStyleSpan(float arg1, int arg2, int arg3, boolean arg4, boolean arg5, float arg6, int arg7) {
        super();
        this.lineHeight = arg1;
        this.startIndex = arg2;
        this.endIndex = arg3;
        this.trimFirstLineTop = arg4;
        this.trimLastLineBottom = arg5;
        this.topRatio = arg6;
        this.mode = arg7;
        this.firstAscent = 0x80000000;
        this.ascent = 0x80000000;
        this.descent = 0x80000000;
        this.lastDescent = 0x80000000;
        int v0 = 0f <= arg6 && arg6 <= 1f || arg6 == -1f ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
        }
    }

    public LineHeightStyleSpan(float arg1, int arg2, int arg3, boolean arg4, boolean arg5, float arg6, int arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private final void calculateTargetMetrics(Paint$FontMetricsInt arg7) {
        int v7;
        int v0 = LineHeightStyleSpan_androidKt.lineHeight(arg7);
        int v1 = ((int)(((float)Math.ceil(((double)this.lineHeight)))));
        v0 = v1 - v0;
        if((Mode.equals-impl0(this.mode, Mode.Companion.getMinimum-lzQqcRY())) && v0 <= 0) {
            this.ascent = arg7.ascent;
            v7 = arg7.descent;
            this.descent = v7;
            this.firstAscent = this.ascent;
            this.lastDescent = v7;
            this.firstAscentDiff = 0;
            this.lastDescentDiff = 0;
            return;
        }

        float v2 = this.topRatio;
        if(v2 == -1f) {
            v2 = Math.abs(((float)arg7.ascent)) / (((float)LineHeightStyleSpan_androidKt.lineHeight(arg7)));
        }

        double v4 = v0 <= 0 ? Math.ceil(((double)((((float)v0)) * v2))) : Math.ceil(((double)((((float)v0)) * (1f - v2))));
        int v4_1 = arg7.descent + (((int)(((float)v4))));
        this.descent = v4_1;
        this.ascent = v4_1 - v1;
        if(!Mode.equals-impl0(this.mode, Mode.Companion.getFixed-lzQqcRY())) {
            if(v0 >= 0) {
            }
            else {
                if(Mode.equals-impl0(this.mode, Mode.Companion.getTight-lzQqcRY())) {
                    v0 = this.trimFirstLineTop ? Math.max(arg7.ascent, this.ascent) : Math.min(arg7.ascent, this.ascent);
                    this.firstAscent = v0;
                    v7 = this.trimLastLineBottom ? Math.min(arg7.descent, this.descent) : Math.max(arg7.descent, this.descent);
                    this.lastDescent = v7;
                    this.firstAscentDiff = 0;
                    this.lastDescentDiff = 0;
                }

                return;
            }
        }

        v0 = this.trimFirstLineTop ? arg7.ascent : this.ascent;
        this.firstAscent = v0;
        v0 = this.trimLastLineBottom ? arg7.descent : this.descent;
        this.lastDescent = v0;
        this.firstAscentDiff = arg7.ascent - this.firstAscent;
        this.lastDescentDiff = this.lastDescent - arg7.descent;
    }

    public void chooseHeight(CharSequence arg1, int arg2, int arg3, int arg4, int arg5, Paint$FontMetricsInt arg6) {
        int v1;
        if(LineHeightStyleSpan_androidKt.lineHeight(arg6) <= 0) {
        }
        else {
            arg4 = 1;
            v1 = arg2 == this.startIndex ? 1 : 0;
            if(arg3 == this.endIndex) {
            }
            else {
                arg4 = 0;
            }

            if(v1 != 0 && arg4 != 0 && (this.trimFirstLineTop) && (this.trimLastLineBottom) && !Mode.equals-impl0(this.mode, Mode.Companion.getTight-lzQqcRY())) {
                return;
            }

            goto label_26;
        }

        return;
    label_26:
        if(this.firstAscent == 0x80000000) {
            this.calculateTargetMetrics(arg6);
        }

        v1 = v1 != 0 ? this.firstAscent : this.ascent;
        arg6.ascent = v1;
        int v0 = arg4 != 0 ? this.lastDescent : this.descent;
        arg6.descent = v0;
    }

    public final LineHeightStyleSpan copy$ui_text(int arg10, int arg11, boolean arg12) {
        return new LineHeightStyleSpan(this.lineHeight, arg10, arg11, arg12, this.trimLastLineBottom, this.topRatio, this.mode, null);
    }

    public static LineHeightStyleSpan copy$ui_text$default(LineHeightStyleSpan arg0, int arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0.trimFirstLineTop;
        }

        return arg0.copy$ui_text(arg1, arg2, arg3);
    }

    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final int getMode-lzQqcRY() {
        return this.mode;
    }

    public final boolean getTrimFirstLineTop() {
        return this.trimFirstLineTop;
    }

    public final boolean getTrimLastLineBottom() {
        return this.trimLastLineBottom;
    }
}

