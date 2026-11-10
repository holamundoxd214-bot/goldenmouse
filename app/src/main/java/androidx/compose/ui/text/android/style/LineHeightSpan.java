package androidx.compose.ui.text.android.style;

import android.graphics.Paint$FontMetricsInt;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0002\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/android/style/LineHeightSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "<init>", "(F)V", "getLineHeight", "()F", "chooseHeight", "", "text", "", "start", "", "end", "spanstartVertical", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LineHeightSpan implements android.text.style.LineHeightSpan {
    public static final int $stable;
    private final float lineHeight;

    static {
    }

    public LineHeightSpan(float arg1) {
        super();
        this.lineHeight = arg1;
    }

    public void chooseHeight(CharSequence arg1, int arg2, int arg3, int arg4, int arg5, Paint$FontMetricsInt arg6) {
        int v1 = LineHeightStyleSpan_androidKt.lineHeight(arg6);
        if(v1 <= 0) {
            return;
        }

        int v0 = ((int)(((float)Math.ceil(((double)this.lineHeight)))));
        arg6.descent = ((int)Math.ceil((((double)arg6.descent)) * (((double)((((float)v0)) * 1f / (((float)v1)))))));
        arg6.ascent = arg6.descent - v0;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }
}

