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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_stroller", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Stroller", "Landroidx/compose/material/icons/Icons$Sharp;", "getStroller", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StrollerKt {
    private static ImageVector _stroller;

    static {
    }

    public static final ImageVector getStroller(Sharp arg19) {
        ImageVector v0 = StrollerKt._stroller;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Stroller", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 20f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveTo(18f, 18.9f, 18f, 20f);
        v12.close();
        v12.moveTo(6f, 18f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(7.1f, 18f, 6f, 18f);
        v12.close();
        v12.moveTo(22f, 7f);
        v12.verticalLineTo(6.48f);
        v12.curveTo(22f, 4.56f, 20.52f, 3f, 18.65f, 3f);
        v12.curveToRelative(-1.66f, 0f, -2.54f, 1.27f, -3.18f, 2.03f);
        v12.lineTo(5.27f, 17f);
        v12.horizontalLineTo(17f);
        v12.verticalLineTo(6.27f);
        v12.curveTo(17.58f, 5.59f, 17.969999f, 5f, 18.65f, 5f);
        v12.curveTo(19.42f, 5f, 20f, 5.66f, 20f, 6.48f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(22f);
        v12.close();
        v12.moveTo(14.3f, 4.1f);
        v12.curveTo(13.03f, 3.4f, 11.56f, 3f, 10f, 3f);
        v12.curveTo(8.03f, 3f, 6.21f, 3.64f, 4.72f, 4.72f);
        v12.lineToRelative(4.89f, 4.89f);
        v12.lineTo(14.3f, 4.1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StrollerKt._stroller = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

