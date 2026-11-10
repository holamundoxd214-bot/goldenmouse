package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wavingHand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WavingHand", "Landroidx/compose/material/icons/Icons$TwoTone;", "getWavingHand", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WavingHandKt {
    private static ImageVector _wavingHand;

    static {
    }

    public static final ImageVector getWavingHand(TwoTone arg19) {
        ImageVector v0 = WavingHandKt._wavingHand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.WavingHand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.44f, 6.37f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-3.18f, 3.18f);
        v12.curveToRelative(1.17f, 1.17f, 1.17f, 3.07f, 0f, 4.24f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.curveToRelative(1.45f, -1.45f, 1.82f, -3.57f, 1.12f, -5.36f);
        v12.lineToRelative(6.3f, -6.3f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.reflectiveCurveToRelative(0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-4.6f, 4.6f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(6.01f, -6.01f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-6.01f, 6.01f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(4.95f, -4.95f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-5.66f, 5.66f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(3.54f, -3.54f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineTo(14.1f, 19.1f);
        v12.curveToRelative(-2.54f, 2.54f, -6.65f, 2.54f, -9.19f, 0f);
        v12.reflectiveCurveToRelative(-2.54f, -6.65f, 0f, -9.19f);
        v12.lineTo(8.44f, 6.37f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(7.03f, 4.95f);
        v12.lineTo(3.49f, 8.49f);
        v12.curveToRelative(-3.32f, 3.32f, -3.32f, 8.7f, 0f, 12.02f);
        v12.reflectiveCurveToRelative(8.7f, 3.32f, 12.02f, 0f);
        v12.lineToRelative(6.01f, -6.01f);
        v12.curveToRelative(0.97f, -0.97f, 0.97f, -2.56f, 0f, -3.54f);
        v12.curveToRelative(-0.12f, -0.12f, -0.25f, -0.23f, -0.39f, -0.32f);
        v12.lineToRelative(0.39f, -0.39f);
        v12.curveToRelative(0.97f, -0.97f, 0.97f, -2.56f, 0f, -3.54f);
        v12.curveToRelative(-0.16f, -0.16f, -0.35f, -0.3f, -0.54f, -0.41f);
        v12.curveToRelative(0.4f, -0.92f, 0.23f, -2.02f, -0.52f, -2.77f);
        v12.curveToRelative(-0.87f, -0.87f, -2.22f, -0.96f, -3.2f, -0.28f);
        v12.curveToRelative(-0.1f, -0.15f, -0.21f, -0.29f, -0.34f, -0.42f);
        v12.curveToRelative(-0.97f, -0.97f, -2.56f, -0.97f, -3.54f, 0f);
        v12.lineToRelative(-2.51f, 2.51f);
        v12.curveToRelative(-0.09f, -0.14f, -0.2f, -0.27f, -0.32f, -0.39f);
        v12.curveTo(9.58f, 3.98f, 8f, 3.98f, 7.03f, 4.95f);
        v12.close();
        v12.moveTo(8.44f, 6.37f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-3.18f, 3.18f);
        v12.curveToRelative(1.17f, 1.17f, 1.17f, 3.07f, 0f, 4.24f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.curveToRelative(1.45f, -1.45f, 1.82f, -3.57f, 1.12f, -5.36f);
        v12.lineToRelative(6.3f, -6.3f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.reflectiveCurveToRelative(0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-4.6f, 4.6f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(6.01f, -6.01f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-6.01f, 6.01f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(4.95f, -4.95f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-5.66f, 5.66f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(3.54f, -3.54f);
        v12.curveToRelative(0.2f, -0.2f, 0.51f, -0.2f, 0.71f, 0f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineTo(14.1f, 19.1f);
        v12.curveToRelative(-2.54f, 2.54f, -6.65f, 2.54f, -9.19f, 0f);
        v12.reflectiveCurveToRelative(-2.54f, -6.65f, 0f, -9.19f);
        v12.lineTo(8.44f, 6.37f);
        v12.close();
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
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WavingHandKt._wavingHand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

