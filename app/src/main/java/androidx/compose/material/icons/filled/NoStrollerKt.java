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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noStroller", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoStroller", "Landroidx/compose/material/icons/Icons$Filled;", "getNoStroller", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoStrollerKt {
    private static ImageVector _noStroller;

    static {
    }

    public static final ImageVector getNoStroller(Filled arg19) {
        ImageVector v0 = NoStrollerKt._noStroller;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.NoStroller", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6f, 18f);
        v12.curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveToRelative(-0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveTo(4.9f, 18f, 6f, 18f);
        v12.close();
        v12.moveTo(18.65f, 3f);
        v12.curveToRelative(-1.66f, 0f, -2.54f, 1.27f, -3.18f, 2.03f);
        v12.lineToRelative(-3.5f, 4.11f);
        v12.lineTo(17f, 14.17f);
        v12.verticalLineToRelative(-7.9f);
        v12.curveTo(17.58f, 5.59f, 17.969999f, 5f, 18.65f, 5f);
        v12.curveTo(19.42f, 5f, 20f, 5.66f, 20f, 6.48f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(6.48f);
        v12.curveTo(22f, 4.56f, 20.52f, 3f, 18.65f, 3f);
        v12.close();
        v12.moveTo(10.67f, 10.67f);
        v12.lineTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(7.97f, 7.97f);
        v12.lineTo(6.7f, 15.31f);
        v12.curveToRelative(-0.55f, 0.65f, -0.09f, 1.65f, 0.76f, 1.65f);
        v12.horizontalLineToRelative(6.66f);
        v12.lineToRelative(1.17f, 1.17f);
        v12.curveTo(14.54f, 18.42f, 14f, 19.139999f, 14f, 20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.curveToRelative(0.86f, 0f, 1.58f, -0.54f, 1.87f, -1.3f);
        v12.lineToRelative(1.91f, 1.91f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(-4.8f, -4.8f);
        v12.lineTo(10.67f, 10.67f);
        v12.close();
        v12.moveTo(13.47f, 5.03f);
        v12.curveToRelative(0.27f, -0.32f, 0.58f, -0.72f, 0.98f, -1.09f);
        v12.curveToRelative(-2.46f, -1.19f, -5.32f, -1.22f, -7.81f, -0.13f);
        v12.lineToRelative(4.25f, 4.25f);
        v12.lineTo(13.47f, 5.03f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoStrollerKt._noStroller = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

