package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AC\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0010\b\u0002\u0010\u0006\u001A\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\t\u001A\u00020\nH\u0000¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"configureShadow", "Landroidx/compose/ui/graphics/Paint;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "blurFilter", "Landroid/graphics/BlurMaskFilter;", "Landroidx/compose/ui/graphics/shadow/BlurFilter;", "style", "Landroidx/compose/ui/graphics/PaintingStyle;", "configureShadow-FoewPVk", "(Landroidx/compose/ui/graphics/Paint;JILandroid/graphics/BlurMaskFilter;I)Landroidx/compose/ui/graphics/Paint;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BlurKt {
    public static final Paint configureShadow-FoewPVk(Paint arg0, long arg1, int arg3, BlurMaskFilter arg4, int arg5) {
        arg0.setColor-8_81llA(arg1);
        arg0.setBlendMode-s9anfk8(arg3);
        arg0.setStyle-k9PVt8s(arg5);
        Blur_androidKt.setBlurFilter(arg0, arg4);
        return arg0;
    }

    public static Paint configureShadow-FoewPVk$default(Paint arg6, long arg7, int arg9, BlurMaskFilter arg10, int arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg7 = Color.Companion.getBlack-0d7_KjU();
        }

        long v1 = arg7;
        if((arg12 & 2) != 0) {
            arg9 = BlendMode.Companion.getSrcOver-0nO6VwU();
        }

        int v3 = arg9;
        if((arg12 & 4) != 0) {
            arg10 = null;
        }

        BlurMaskFilter v4 = arg10;
        if((arg12 & 8) != 0) {
            arg11 = PaintingStyle.Companion.getFill-TiuSbCo();
        }

        return BlurKt.configureShadow-FoewPVk(arg6, v1, v3, v4, arg11);
    }
}

