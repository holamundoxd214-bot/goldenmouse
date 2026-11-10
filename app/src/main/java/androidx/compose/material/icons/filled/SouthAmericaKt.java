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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_southAmerica", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SouthAmerica", "Landroidx/compose/material/icons/Icons$Filled;", "getSouthAmerica", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SouthAmericaKt {
    private static ImageVector _southAmerica;

    static {
    }

    public static final ImageVector getSouthAmerica(Filled arg19) {
        ImageVector v0 = SouthAmericaKt._southAmerica;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SouthAmerica", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(4f, 12f);
        v12.curveToRelative(0f, -1.95f, 0.7f, -3.74f, 1.87f, -5.13f);
        v12.lineTo(9f, 10f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.verticalLineToRelative(5.59f);
        v12.curveToRelative(0f, 0.27f, 0.11f, 0.52f, 0.29f, 0.71f);
        v12.lineTo(12f, 20f);
        v12.curveTo(7.58f, 20f, 4f, 16.42f, 4f, 12f);
        v12.close();
        v12.moveTo(13f, 19.940001f);
        v12.verticalLineTo(18f);
        v12.lineToRelative(3.75f, -5.62f);
        v12.curveToRelative(0.16f, -0.25f, 0.25f, -0.54f, 0.25f, -0.83f);
        v12.verticalLineTo(10.5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-1.5f);
        v12.lineToRelative(-1.4f, -1.75f);
        v12.curveTo(12.72f, 7.28f, 12.15f, 7f, 11.54f, 7f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(5.07f);
        v12.curveTo(9.18f, 4.39f, 10.54f, 4f, 12f, 4f);
        v12.curveToRelative(4.41f, 0f, 8f, 3.59f, 8f, 8f);
        v12.curveTo(20f, 16.07f, 16.940001f, 19.440001f, 13f, 19.940001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SouthAmericaKt._southAmerica = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

