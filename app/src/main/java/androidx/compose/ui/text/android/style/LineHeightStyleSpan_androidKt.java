package androidx.compose.ui.text.android.style;

import android.graphics.Paint$FontMetricsInt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2={"lineHeight", "", "Landroid/graphics/Paint$FontMetricsInt;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LineHeightStyleSpan_androidKt {
    public static final int lineHeight(Paint$FontMetricsInt arg1) {
        return arg1.descent - arg1.ascent;
    }
}

