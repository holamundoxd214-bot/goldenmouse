package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wavingHand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WavingHand", "Landroidx/compose/material/icons/Icons$Filled;", "getWavingHand", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WavingHandKt {
    private static ImageVector _wavingHand;

    static {
    }

    public static final ImageVector getWavingHand(Filled arg19) {
        ImageVector v0 = WavingHandKt._wavingHand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.WavingHand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23f, 17f);
        v12.curveToRelative(0f, 3.31f, -2.69f, 6f, -6f, 6f);
        v12.verticalLineToRelative(-1.5f);
        v12.curveToRelative(2.48f, 0f, 4.5f, -2.02f, 4.5f, -4.5f);
        v12.horizontalLineTo(23f);
        v12.close();
        v12.moveTo(1f, 7f);
        v12.curveToRelative(0f, -3.31f, 2.69f, -6f, 6f, -6f);
        v12.verticalLineToRelative(1.5f);
        v12.curveTo(4.52f, 2.5f, 2.5f, 4.52f, 2.5f, 7f);
        v12.horizontalLineTo(1f);
        v12.close();
        v12.moveTo(8.01f, 4.32f);
        v12.lineToRelative(-4.6f, 4.6f);
        v12.curveToRelative(-3.22f, 3.22f, -3.22f, 8.45f, 0f, 11.67f);
        v12.reflectiveCurveToRelative(8.45f, 3.22f, 11.67f, 0f);
        v12.lineToRelative(7.07f, -7.07f);
        v12.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0f, -1.77f);
        v12.curveToRelative(-0.49f, -0.49f, -1.28f, -0.49f, -1.77f, 0f);
        v12.lineToRelative(-4.42f, 4.42f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.lineToRelative(6.54f, -6.54f);
        v12.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0f, -1.77f);
        v12.reflectiveCurveToRelative(-1.28f, -0.49f, -1.77f, 0f);
        v12.lineToRelative(-5.83f, 5.83f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.lineToRelative(6.89f, -6.89f);
        v12.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0f, -1.77f);
        v12.reflectiveCurveToRelative(-1.28f, -0.49f, -1.77f, 0f);
        v12.lineToRelative(-6.89f, 6.89f);
        v12.lineTo(11.02f, 9.8f);
        v12.lineToRelative(5.48f, -5.48f);
        v12.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0f, -1.77f);
        v12.reflectiveCurveToRelative(-1.28f, -0.49f, -1.77f, 0f);
        v12.lineToRelative(-7.62f, 7.62f);
        v12.curveToRelative(1.22f, 1.57f, 1.11f, 3.84f, -0.33f, 5.28f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.curveToRelative(1.17f, -1.17f, 1.17f, -3.07f, 0f, -4.24f);
        v12.lineToRelative(-0.35f, -0.35f);
        v12.lineToRelative(4.07f, -4.07f);
        v12.curveToRelative(0.49f, -0.49f, 0.49f, -1.28f, 0f, -1.77f);
        v12.curveTo(9.29f, 3.83f, 8.5f, 3.83f, 8.01f, 4.32f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WavingHandKt._wavingHand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

