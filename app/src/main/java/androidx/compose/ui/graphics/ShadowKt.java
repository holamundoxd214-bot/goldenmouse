package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\u0006"}, d2={"lerp", "Landroidx/compose/ui/graphics/Shadow;", "start", "stop", "fraction", "", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ShadowKt {
    public static final Shadow lerp(Shadow arg7, Shadow arg8, float arg9) {
        return new Shadow(ColorKt.lerp-jxsXWHM(arg7.getColor-0d7_KjU(), arg8.getColor-0d7_KjU(), arg9), OffsetKt.lerp-Wko1d7g(arg7.getOffset-F1C5BW0(), arg8.getOffset-F1C5BW0(), arg9), MathHelpersKt.lerp(arg7.getBlurRadius(), arg8.getBlurRadius(), arg9), null);
    }
}

