package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_stroller", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Stroller", "Landroidx/compose/material/icons/Icons$Outlined;", "getStroller", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StrollerKt {
    private static ImageVector _stroller;

    static {
    }

    public static final ImageVector getStroller(Outlined arg19) {
        ImageVector v0 = StrollerKt._stroller;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Stroller", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(15f, 8.66f);
        v12.lineTo(9.6f, 15f);
        v12.horizontalLineTo(15f);
        v12.verticalLineTo(8.66f);
        v12.moveTo(18.65f, 3f);
        v12.curveTo(20.52f, 3f, 22f, 4.56f, 22f, 6.48f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(6.48f);
        v12.curveTo(20f, 5.66f, 19.42f, 5f, 18.65f, 5f);
        v12.curveTo(17.969999f, 5f, 17.58f, 5.59f, 17f, 6.27f);
        v12.verticalLineTo(15f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineTo(7.43f);
        v12.curveToRelative(-0.85f, 0f, -1.31f, -1f, -0.76f, -1.65f);
        v12.lineToRelative(8.8f, -10.32f);
        v12.curveTo(16.110001f, 4.27f, 16.99f, 3f, 18.65f, 3f);
        v12.lineTo(18.65f, 3f);
        v12.close();
        v12.moveTo(10f, 5f);
        v12.curveTo(9.35f, 5f, 8.71f, 5.09f, 8.09f, 5.27f);
        v12.lineToRelative(1.4f, 1.4f);
        v12.lineToRelative(1.37f, -1.61f);
        v12.curveTo(10.58f, 5.02f, 10.29f, 5f, 10f, 5f);
        v12.moveTo(10f, 3f);
        v12.curveToRelative(1.56f, 0f, 3.03f, 0.4f, 4.3f, 1.1f);
        v12.lineToRelative(-4.7f, 5.51f);
        v12.lineTo(4.72f, 4.72f);
        v12.curveTo(6.21f, 3.64f, 8.03f, 3f, 10f, 3f);
        v12.lineTo(10f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StrollerKt._stroller = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

