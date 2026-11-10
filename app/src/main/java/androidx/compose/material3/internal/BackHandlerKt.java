package androidx.compose.material3.internal;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import kotlin.Metadata;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2={"PredictiveBackEasing", "Landroidx/compose/animation/core/Easing;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BackHandlerKt {
    private static final Easing PredictiveBackEasing;

    static {
        BackHandlerKt.PredictiveBackEasing = new CubicBezierEasing(0.1f, 0.1f, 0f, 1f);
    }

    public static final Easing access$getPredictiveBackEasing$p() {
        return BackHandlerKt.PredictiveBackEasing;
    }
}

