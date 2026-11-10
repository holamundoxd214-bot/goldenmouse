package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A$\u0010\u0006\u001A\u0004\u0018\u00010\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u00012\b\u0010\u0003\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0007"}, d2={"lerpNonNull", "Landroidx/compose/ui/graphics/shadow/Shadow;", "a", "b", "t", "", "lerp", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ShadowKt {
    public static final Shadow lerp(Shadow arg0, Shadow arg1, float arg2) {
        if(arg0 == null && arg1 == null) {
            return null;
        }

        if(arg0 == null) {
            Intrinsics.checkNotNull(arg1);
            return ShadowKt.lerpNonNull(arg1.transparentCopy$ui_graphics(), arg1, arg2);
        }

        if(arg1 == null) {
            return ShadowKt.lerpNonNull(arg0, arg0.transparentCopy$ui_graphics(), arg2);
        }

        return ShadowKt.lerpNonNull(arg0, arg1, arg2);
    }

    public static final Shadow lerpNonNull(Shadow arg11, Shadow arg12, float arg13) {
        float v1 = DpKt.lerp-Md-fbLM(arg11.getRadius-D9Ej5fM(), arg12.getRadius-D9Ej5fM(), arg13);
        float v2 = DpKt.lerp-Md-fbLM(arg11.getSpread-D9Ej5fM(), arg12.getSpread-D9Ej5fM(), arg13);
        long v3 = DpKt.lerp-xhh869w(arg11.getOffset-RKDOV3M(), arg12.getOffset-RKDOV3M(), arg13);
        long v5 = ColorKt.lerp-jxsXWHM(arg11.getColor-0d7_KjU(), arg12.getColor-0d7_KjU(), arg13);
        Object v7 = Interpolatable.Companion.lerp(arg11.getBrush(), arg12.getBrush(), arg13);
        if((v7 instanceof Brush)) {
        }
        else {
            Brush v7_1 = null;
        }

        float v8 = MathHelpersKt.lerp(arg11.getAlpha(), arg12.getAlpha(), arg13);
        int v11 = arg13 < 0.5f ? arg11.getBlendMode-0nO6VwU() : arg12.getBlendMode-0nO6VwU();
        return new Shadow(v1, v2, v3, v5, ((Brush)v7), v8, v11, null);
    }
}

