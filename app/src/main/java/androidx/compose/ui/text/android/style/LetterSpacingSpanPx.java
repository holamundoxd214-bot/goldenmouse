package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001A\u00020\t*\u00020\nH\u0002J\u0010\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\nH\u0016J\u0010\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\nH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/ui/text/android/style/LetterSpacingSpanPx;", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "", "<init>", "(F)V", "getLetterSpacing", "()F", "updatePaint", "", "Landroid/text/TextPaint;", "updateDrawState", "textPaint", "updateMeasureState", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LetterSpacingSpanPx extends MetricAffectingSpan {
    public static final int $stable = 8;
    private final float letterSpacing;

    static {
    }

    public LetterSpacingSpanPx(float arg1) {
        super();
        this.letterSpacing = arg1;
    }

    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    public void updateDrawState(TextPaint arg1) {
        this.updatePaint(arg1);
    }

    public void updateMeasureState(TextPaint arg1) {
        this.updatePaint(arg1);
    }

    private final void updatePaint(TextPaint arg3) {
        float v0 = arg3.getTextSize() * arg3.getTextScaleX();
        if(v0 == 0f) {
            return;
        }

        arg3.setLetterSpacing(this.letterSpacing / v0);
    }
}

