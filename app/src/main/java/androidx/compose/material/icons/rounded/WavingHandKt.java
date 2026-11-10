package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wavingHand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WavingHand", "Landroidx/compose/material/icons/Icons$Rounded;", "getWavingHand", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WavingHandKt {
    private static ImageVector _wavingHand;

    static {
    }

    public static final ImageVector getWavingHand(Rounded arg19) {
        ImageVector v0 = WavingHandKt._wavingHand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WavingHand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.07f, 9.8f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(1.07f, 1.07f, 1.16f, 2.75f, 0.28f, 3.92f);
        v12.curveToRelative(-0.15f, 0.2f, -0.12f, 0.47f, 0.05f, 0.65f);
        v12.curveToRelative(0.22f, 0.22f, 0.57f, 0.19f, 0.76f, -0.05f);
        v12.curveToRelative(1.07f, -1.43f, 1.06f, -3.43f, -0.04f, -4.85f);
        v12.lineToRelative(7.62f, -7.62f);
        v12.curveToRelative(0.49f, -0.49f, 1.28f, -0.49f, 1.77f, 0f);
        v12.reflectiveCurveToRelative(0.49f, 1.28f, 0f, 1.77f);
        v12.lineToRelative(-5.13f, 5.13f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.reflectiveCurveToRelative(0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(6.54f, -6.54f);
        v12.curveToRelative(0.49f, -0.49f, 1.28f, -0.49f, 1.77f, 0f);
        v12.reflectiveCurveToRelative(0.49f, 1.28f, 0f, 1.77f);
        v12.lineToRelative(-6.54f, 6.54f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.reflectiveCurveToRelative(0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(5.48f, -5.48f);
        v12.curveToRelative(0.49f, -0.49f, 1.28f, -0.49f, 1.77f, 0f);
        v12.reflectiveCurveToRelative(0.49f, 1.28f, 0f, 1.77f);
        v12.lineToRelative(-6.19f, 6.19f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(4.07f, -4.07f);
        v12.curveToRelative(0.49f, -0.49f, 1.28f, -0.49f, 1.77f, 0f);
        v12.curveToRelative(0.49f, 0.49f, 0.49f, 1.28f, 0f, 1.77f);
        v12.lineToRelative(-7.07f, 7.07f);
        v12.curveToRelative(-3.22f, 3.22f, -8.45f, 3.22f, -11.67f, 0f);
        v12.reflectiveCurveToRelative(-3.22f, -8.45f, 0f, -11.67f);
        v12.lineToRelative(4.6f, -4.6f);
        v12.curveToRelative(0.49f, -0.49f, 1.28f, -0.49f, 1.77f, 0f);
        v12.curveToRelative(0.49f, 0.49f, 0.49f, 1.28f, 0f, 1.77f);
        v12.lineTo(6.07f, 9.8f);
        v12.close();
        v12.moveTo(7f, 1.8f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.curveToRelative(-0.04f, 0f, -0.07f, 0f, -0.11f, 0.01f);
        v12.curveToRelative(-2.63f, 0.38f, -4.7f, 2.46f, -5.08f, 5.08f);
        v12.curveToRelative(0f, 0.03f, -0.01f, 0.07f, -0.01f, 0.11f);
        v12.curveTo(1.05f, 6.66f, 1.39f, 7f, 1.8f, 7f);
        v12.curveToRelative(0.38f, 0f, 0.69f, -0.28f, 0.74f, -0.64f);
        v12.curveToRelative(0.28f, -1.97f, 1.84f, -3.53f, 3.81f, -3.81f);
        v12.curveTo(6.72f, 2.49f, 7f, 2.18f, 7f, 1.8f);
        v12.close();
        v12.moveTo(17f, 22.200001f);
        v12.curveToRelative(0f, 0.41f, 0.34f, 0.75f, 0.75f, 0.75f);
        v12.curveToRelative(0.04f, 0f, 0.07f, 0f, 0.11f, -0.01f);
        v12.curveToRelative(2.63f, -0.38f, 4.7f, -2.46f, 5.08f, -5.08f);
        v12.curveToRelative(0f, -0.03f, 0.01f, -0.07f, 0.01f, -0.11f);
        v12.curveToRelative(0f, -0.41f, -0.34f, -0.75f, -0.75f, -0.75f);
        v12.curveToRelative(-0.38f, 0f, -0.69f, 0.28f, -0.74f, 0.64f);
        v12.curveToRelative(-0.28f, 1.97f, -1.84f, 3.53f, -3.81f, 3.81f);
        v12.curveTo(17.280001f, 21.51f, 17f, 21.82f, 17f, 22.200001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WavingHandKt._wavingHand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

