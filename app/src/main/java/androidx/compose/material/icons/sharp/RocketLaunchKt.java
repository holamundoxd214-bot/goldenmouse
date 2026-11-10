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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_rocketLaunch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RocketLaunch", "Landroidx/compose/material/icons/Icons$Sharp;", "getRocketLaunch", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RocketLaunchKt {
    private static ImageVector _rocketLaunch;

    static {
    }

    public static final ImageVector getRocketLaunch(Sharp arg19) {
        ImageVector v0 = RocketLaunchKt._rocketLaunch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.RocketLaunch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.19f, 6.35f);
        v12.curveToRelative(-2.04f, 2.29f, -3.44f, 5.58f, -3.57f, 5.89f);
        v12.lineTo(2f, 10.69f);
        v12.lineToRelative(4.81f, -4.81f);
        v12.lineTo(9.19f, 6.35f);
        v12.lineTo(9.19f, 6.35f);
        v12.close();
        v12.moveTo(11.17f, 17f);
        v12.curveToRelative(0f, 0f, 3.74f, -1.55f, 5.89f, -3.7f);
        v12.curveToRelative(5.4f, -5.4f, 4.5f, -9.62f, 4.21f, -10.57f);
        v12.curveToRelative(-0.95f, -0.3f, -5.17f, -1.19f, -10.57f, 4.21f);
        v12.curveTo(8.55f, 9.09f, 7f, 12.83f, 7f, 12.83f);
        v12.lineTo(11.17f, 17f);
        v12.close();
        v12.moveTo(17.65f, 14.81f);
        v12.curveToRelative(-2.29f, 2.04f, -5.58f, 3.44f, -5.89f, 3.57f);
        v12.lineTo(13.31f, 22f);
        v12.lineToRelative(4.81f, -4.81f);
        v12.lineTo(17.65f, 14.81f);
        v12.lineTo(17.65f, 14.81f);
        v12.close();
        v12.moveTo(9f, 18f);
        v12.curveToRelative(0f, 0.83f, -0.34f, 1.58f, -0.88f, 2.12f);
        v12.curveTo(6.94f, 21.299999f, 2f, 22f, 2f, 22f);
        v12.reflectiveCurveToRelative(0.7f, -4.94f, 1.88f, -6.12f);
        v12.curveTo(4.42f, 15.34f, 5.17f, 15f, 6f, 15f);
        v12.curveTo(7.66f, 15f, 9f, 16.34f, 9f, 18f);
        v12.close();
        v12.moveTo(13f, 9f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveTo(13f, 10.1f, 13f, 9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RocketLaunchKt._rocketLaunch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

