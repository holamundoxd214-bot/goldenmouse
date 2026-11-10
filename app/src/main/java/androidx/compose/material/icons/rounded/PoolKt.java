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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pool", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pool", "Landroidx/compose/material/icons/Icons$Rounded;", "getPool", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PoolKt {
    private static ImageVector _pool;

    static {
    }

    public static final ImageVector getPool(Rounded arg20) {
        ImageVector v0 = PoolKt._pool;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Pool", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.11f, 5.56f);
        v12.curveTo(7.3f, 5.7f, 8.14f, 6.14f, 9f, 7f);
        v12.lineToRelative(1f, 1f);
        v12.lineToRelative(-3.25f, 3.25f);
        v12.curveToRelative(0.31f, 0.12f, 0.56f, 0.27f, 0.77f, 0.39f);
        v12.curveToRelative(0.37f, 0.23f, 0.59f, 0.36f, 1.15f, 0.36f);
        v12.reflectiveCurveToRelative(0.78f, -0.13f, 1.15f, -0.36f);
        v12.curveToRelative(0.46f, -0.27f, 1.08f, -0.64f, 2.19f, -0.64f);
        v12.reflectiveCurveToRelative(1.73f, 0.37f, 2.18f, 0.64f);
        v12.curveToRelative(0.37f, 0.22f, 0.6f, 0.36f, 1.15f, 0.36f);
        v12.curveToRelative(0.55f, 0f, 0.78f, -0.13f, 1.15f, -0.36f);
        v12.curveToRelative(0.12f, -0.07f, 0.26f, -0.15f, 0.41f, -0.23f);
        v12.lineTo(10.48f, 5f);
        v12.curveTo(9.22f, 3.74f, 8.04f, 3.2f, 6.3f, 3.05f);
        v12.curveTo(5.6f, 2.99f, 5f, 3.56f, 5f, 4.26f);
        v12.verticalLineToRelative(0.09f);
        v12.curveToRelative(0f, 0.63f, 0.49f, 1.13f, 1.11f, 1.21f);
        v12.close();
        v12.moveTo(21.35f, 18.91f);
        v12.curveToRelative(-0.17f, -0.06f, -0.32f, -0.15f, -0.5f, -0.27f);
        v12.curveToRelative(-0.45f, -0.27f, -1.07f, -0.64f, -2.18f, -0.64f);
        v12.reflectiveCurveToRelative(-1.73f, 0.37f, -2.18f, 0.64f);
        v12.curveToRelative(-0.37f, 0.23f, -0.6f, 0.36f, -1.15f, 0.36f);
        v12.curveToRelative(-0.55f, 0f, -0.78f, -0.14f, -1.15f, -0.36f);
        v12.curveToRelative(-0.45f, -0.27f, -1.07f, -0.64f, -2.18f, -0.64f);
        v12.reflectiveCurveToRelative(-1.73f, 0.37f, -2.19f, 0.64f);
        v12.curveToRelative(-0.37f, 0.23f, -0.59f, 0.36f, -1.15f, 0.36f);
        v12.reflectiveCurveToRelative(-0.78f, -0.13f, -1.15f, -0.36f);
        v12.curveToRelative(-0.45f, -0.27f, -1.07f, -0.64f, -2.18f, -0.64f);
        v12.reflectiveCurveToRelative(-1.73f, 0.37f, -2.19f, 0.64f);
        v12.curveToRelative(-0.18f, 0.11f, -0.33f, 0.2f, -0.5f, 0.27f);
        v12.curveToRelative(-0.38f, 0.13f, -0.65f, 0.45f, -0.65f, 0.85f);
        v12.verticalLineToRelative(0.12f);
        v12.curveToRelative(0f, 0.67f, 0.66f, 1.13f, 1.3f, 0.91f);
        v12.curveToRelative(0.37f, -0.13f, 0.65f, -0.3f, 0.89f, -0.44f);
        v12.curveToRelative(0.37f, -0.22f, 0.6f, -0.35f, 1.15f, -0.35f);
        v12.curveToRelative(0.55f, 0f, 0.78f, 0.13f, 1.15f, 0.36f);
        v12.curveToRelative(0.45f, 0.27f, 1.07f, 0.64f, 2.18f, 0.64f);
        v12.reflectiveCurveToRelative(1.73f, -0.37f, 2.19f, -0.64f);
        v12.curveToRelative(0.37f, -0.23f, 0.59f, -0.36f, 1.15f, -0.36f);
        v12.curveToRelative(0.55f, 0f, 0.78f, 0.14f, 1.15f, 0.36f);
        v12.curveToRelative(0.45f, 0.27f, 1.07f, 0.64f, 2.18f, 0.64f);
        v12.reflectiveCurveToRelative(1.72f, -0.37f, 2.18f, -0.64f);
        v12.curveToRelative(0.37f, -0.23f, 0.59f, -0.36f, 1.15f, -0.36f);
        v12.curveToRelative(0.55f, 0f, 0.78f, 0.14f, 1.15f, 0.36f);
        v12.curveToRelative(0.23f, 0.14f, 0.51f, 0.31f, 0.88f, 0.44f);
        v12.curveToRelative(0.63f, 0.22f, 1.3f, -0.24f, 1.3f, -0.91f);
        v12.verticalLineToRelative(-0.12f);
        v12.curveToRelative(0f, -0.41f, -0.27f, -0.73f, -0.65f, -0.86f);
        v12.close();
        v12.moveTo(3.11f, 16.35f);
        v12.curveToRelative(0.47f, -0.13f, 0.81f, -0.33f, 1.09f, -0.49f);
        v12.curveToRelative(0.37f, -0.23f, 0.6f, -0.36f, 1.15f, -0.36f);
        v12.curveToRelative(0.55f, 0f, 0.78f, 0.14f, 1.15f, 0.36f);
        v12.curveToRelative(0.45f, 0.27f, 1.07f, 0.64f, 2.18f, 0.64f);
        v12.reflectiveCurveToRelative(1.73f, -0.37f, 2.18f, -0.64f);
        v12.curveToRelative(0.37f, -0.23f, 0.59f, -0.36f, 1.15f, -0.36f);
        v12.curveToRelative(0.55f, 0f, 0.78f, 0.14f, 1.15f, 0.36f);
        v12.curveToRelative(0.45f, 0.27f, 1.07f, 0.64f, 2.18f, 0.64f);
        v12.reflectiveCurveToRelative(1.73f, -0.37f, 2.18f, -0.64f);
        v12.curveToRelative(0.37f, -0.23f, 0.59f, -0.36f, 1.15f, -0.36f);
        v12.curveToRelative(0.55f, 0f, 0.78f, 0.14f, 1.15f, 0.36f);
        v12.curveToRelative(0.23f, 0.14f, 0.5f, 0.3f, 0.85f, 0.43f);
        v12.curveToRelative(0.63f, 0.23f, 1.31f, -0.24f, 1.31f, -0.91f);
        v12.verticalLineToRelative(-0.12f);
        v12.curveToRelative(0f, -0.4f, -0.27f, -0.72f, -0.64f, -0.86f);
        v12.curveToRelative(-0.17f, -0.06f, -0.32f, -0.15f, -0.51f, -0.26f);
        v12.curveToRelative(-0.45f, -0.27f, -1.07f, -0.64f, -2.18f, -0.64f);
        v12.reflectiveCurveToRelative(-1.73f, 0.37f, -2.18f, 0.64f);
        v12.curveToRelative(-0.37f, 0.23f, -0.6f, 0.36f, -1.15f, 0.36f);
        v12.reflectiveCurveToRelative(-0.78f, -0.14f, -1.15f, -0.36f);
        v12.curveToRelative(-0.45f, -0.27f, -1.07f, -0.64f, -2.18f, -0.64f);
        v12.reflectiveCurveToRelative(-1.73f, 0.37f, -2.18f, 0.64f);
        v12.curveToRelative(-0.37f, 0.23f, -0.59f, 0.36f, -1.15f, 0.36f);
        v12.curveToRelative(-0.55f, 0f, -0.78f, -0.14f, -1.15f, -0.36f);
        v12.curveToRelative(-0.45f, -0.27f, -1.07f, -0.64f, -2.18f, -0.64f);
        v12.reflectiveCurveToRelative(-1.73f, 0.37f, -2.18f, 0.64f);
        v12.curveToRelative(-0.18f, 0.11f, -0.33f, 0.2f, -0.5f, 0.27f);
        v12.curveToRelative(-0.38f, 0.13f, -0.65f, 0.45f, -0.65f, 0.85f);
        v12.verticalLineToRelative(0.23f);
        v12.curveToRelative(0f, 0.58f, 0.55f, 1.02f, 1.11f, 0.86f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.5f, 5.5f);
        v12.moveToRelative(-2.5f, 0f);
        v12.arcToRelative(2.5f, 2.5f, 0f, true, true, 5f, 0f);
        v12.arcToRelative(2.5f, 2.5f, 0f, true, true, -5f, 0f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PoolKt._pool = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

