package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_runCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RunCircle", "Landroidx/compose/material/icons/Icons$Sharp;", "getRunCircle", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RunCircleKt {
    private static ImageVector _runCircle;

    static {
    }

    public static final ImageVector getRunCircle(Sharp arg19) {
        ImageVector v0 = RunCircleKt._runCircle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.RunCircle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(13.5f, 6f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.curveTo(12.5f, 6.45f, 12.95f, 6f, 13.5f, 6f);
        v12.close();
        v12.moveTo(16f, 12f);
        v12.curveToRelative(-0.7f, 0f, -2.01f, -0.54f, -2.91f, -1.76f);
        v12.lineToRelative(-0.41f, 2.35f);
        v12.lineTo(14f, 14.03f);
        v12.verticalLineTo(18f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-3.58f);
        v12.lineToRelative(-1.11f, -1.21f);
        v12.lineToRelative(-0.52f, 2.64f);
        v12.lineTo(7.6f, 15.08f);
        v12.lineToRelative(0.2f, -0.98f);
        v12.lineToRelative(2.78f, 0.57f);
        v12.lineToRelative(0.96f, -4.89f);
        v12.lineTo(10f, 10.35f);
        v12.verticalLineTo(12f);
        v12.horizontalLineTo(9f);
        v12.verticalLineTo(9.65f);
        v12.lineToRelative(3.28f, -1.21f);
        v12.curveToRelative(0.49f, -0.18f, 1.03f, 0.06f, 1.26f, 0.53f);
        v12.curveTo(14.37f, 10.67f, 15.59f, 11f, 16f, 11f);
        v12.verticalLineTo(12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RunCircleKt._runCircle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

