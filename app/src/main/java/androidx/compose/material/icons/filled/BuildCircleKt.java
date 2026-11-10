package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector$Builder;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_buildCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BuildCircle", "Landroidx/compose/material/icons/Icons$Filled;", "getBuildCircle", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BuildCircleKt {
    private static ImageVector _buildCircle;

    static {
    }

    public static final ImageVector getBuildCircle(Filled arg19) {
        ImageVector v0 = BuildCircleKt._buildCircle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.BuildCircle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
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
        v12.moveTo(16.9f, 15.49f);
        v12.lineToRelative(-1.4f, 1.4f);
        v12.curveToRelative(-0.2f, 0.2f, -0.51f, 0.2f, -0.71f, 0f);
        v12.lineToRelative(-3.41f, -3.41f);
        v12.curveToRelative(-1.22f, 0.43f, -2.64f, 0.17f, -3.62f, -0.81f);
        v12.curveToRelative(-1.11f, -1.11f, -1.3f, -2.79f, -0.59f, -4.1f);
        v12.lineToRelative(2.35f, 2.35f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(8.58f, 7.17f);
        v12.curveToRelative(1.32f, -0.71f, 2.99f, -0.52f, 4.1f, 0.59f);
        v12.curveToRelative(0.98f, 0.98f, 1.24f, 2.4f, 0.81f, 3.62f);
        v12.lineToRelative(3.41f, 3.41f);
        v12.curveTo(17.09f, 14.98f, 17.09f, 15.3f, 16.9f, 15.49f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BuildCircleKt._buildCircle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

