package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000BH\u0016J\u0010\u0010\u000E\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000FH\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/ui/text/android/style/TypefaceSpan;", "Landroid/text/style/MetricAffectingSpan;", "typeface", "Landroid/graphics/Typeface;", "<init>", "(Landroid/graphics/Typeface;)V", "getTypeface", "()Landroid/graphics/Typeface;", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "updateMeasureState", "paint", "updateTypeface", "Landroid/graphics/Paint;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TypefaceSpan extends MetricAffectingSpan {
    public static final int $stable = 8;
    private final Typeface typeface;

    static {
    }

    public TypefaceSpan(Typeface arg1) {
        super();
        this.typeface = arg1;
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public void updateDrawState(TextPaint arg1) {
        this.updateTypeface(((Paint)arg1));
    }

    public void updateMeasureState(TextPaint arg1) {
        this.updateTypeface(((Paint)arg1));
    }

    private final void updateTypeface(Paint arg1) {
        arg1.setTypeface(this.typeface);
    }
}

