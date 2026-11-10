package androidx.compose.ui.text.font;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2={"lerp", "Landroidx/compose/ui/text/font/FontWeight;", "start", "stop", "fraction", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FontWeightKt {
    public static final FontWeight lerp(FontWeight arg0, FontWeight arg1, float arg2) {
        return new FontWeight(RangesKt.coerceIn(MathHelpersKt.lerp(arg0.getWeight(), arg1.getWeight(), arg2), 1, 1000));
    }
}

