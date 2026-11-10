package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/text/android/style/BaselineShiftSpan;", "Landroid/text/style/MetricAffectingSpan;", "multiplier", "", "<init>", "(F)V", "getMultiplier", "()F", "updateMeasureState", "", "textPaint", "Landroid/text/TextPaint;", "updateDrawState", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public class BaselineShiftSpan extends MetricAffectingSpan {
    public static final int $stable = 8;
    private final float multiplier;

    static {
    }

    public BaselineShiftSpan(float arg1) {
        super();
        this.multiplier = arg1;
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public void updateDrawState(TextPaint arg4) {
        arg4.baselineShift += ((int)(((float)Math.ceil(((double)(arg4.ascent() * this.multiplier))))));
    }

    public void updateMeasureState(TextPaint arg4) {
        arg4.baselineShift += ((int)(((float)Math.ceil(((double)(arg4.ascent() * this.multiplier))))));
    }
}

