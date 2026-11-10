package androidx.compose.ui.text.style;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2={"lerp", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "start", "stop", "fraction", "", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextGeometricTransformKt {
    public static final TextGeometricTransform lerp(TextGeometricTransform arg3, TextGeometricTransform arg4, float arg5) {
        return new TextGeometricTransform(MathHelpersKt.lerp(arg3.getScaleX(), arg4.getScaleX(), arg5), MathHelpersKt.lerp(arg3.getSkewX(), arg4.getSkewX(), arg5));
    }
}

