package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/text/android/style/SkewXSpan;", "Landroid/text/style/MetricAffectingSpan;", "skewX", "", "<init>", "(F)V", "getSkewX", "()F", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public class SkewXSpan extends MetricAffectingSpan {
    public static final int $stable = 8;
    private final float skewX;

    static {
    }

    public SkewXSpan(float arg1) {
        super();
        this.skewX = arg1;
    }

    public final float getSkewX() {
        return this.skewX;
    }

    public void updateDrawState(TextPaint arg2) {
        arg2.setTextSkewX(this.skewX + arg2.getTextSkewX());
    }

    public void updateMeasureState(TextPaint arg2) {
        arg2.setTextSkewX(this.skewX + arg2.getTextSkewX());
    }
}

