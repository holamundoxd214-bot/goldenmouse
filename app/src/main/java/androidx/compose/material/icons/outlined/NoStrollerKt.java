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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noStroller", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoStroller", "Landroidx/compose/material/icons/Icons$Outlined;", "getNoStroller", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoStrollerKt {
    private static ImageVector _noStroller;

    static {
    }

    public static final ImageVector getNoStroller(Outlined arg19) {
        ImageVector v0 = NoStrollerKt._noStroller;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.NoStroller", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8f, 20f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.reflectiveCurveToRelative(-2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveTo(8f, 18.9f, 8f, 20f);
        v12.close();
        v12.moveTo(15f, 8.66f);
        v12.verticalLineToRelative(3.51f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineToRelative(-7.9f);
        v12.curveTo(17.58f, 5.59f, 17.969999f, 5f, 18.65f, 5f);
        v12.curveTo(19.42f, 5f, 20f, 5.66f, 20f, 6.48f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(6.48f);
        v12.curveTo(22f, 4.56f, 20.52f, 3f, 18.65f, 3f);
        v12.curveToRelative(-1.66f, 0f, -2.54f, 1.27f, -3.18f, 2.03f);
        v12.lineToRelative(-3.5f, 4.11f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.lineTo(15f, 8.66f);
        v12.close();
        v12.moveTo(19.780001f, 22.610001f);
        v12.lineToRelative(-1.91f, -1.91f);
        v12.curveTo(17.58f, 21.459999f, 16.860001f, 22f, 16f, 22f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -0.86f, 0.54f, -1.58f, 1.3f, -1.87f);
        v12.lineTo(14.17f, 17f);
        v12.horizontalLineTo(7.43f);
        v12.curveToRelative(-0.85f, 0f, -1.31f, -1f, -0.76f, -1.65f);
        v12.lineToRelative(2.69f, -3.16f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(7.86f, 7.86f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.lineToRelative(0f, 0f);
        v12.lineToRelative(9.11f, 9.11f);
        v12.lineTo(19.780001f, 22.610001f);
        v12.close();
        v12.moveTo(12.17f, 15f);
        v12.lineToRelative(-1.39f, -1.39f);
        v12.lineTo(9.6f, 15f);
        v12.horizontalLineTo(12.17f);
        v12.close();
        v12.moveTo(10f, 5f);
        v12.curveToRelative(0.29f, 0f, 0.58f, 0.02f, 0.86f, 0.05f);
        v12.lineTo(9.49f, 6.67f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.lineTo(14.3f, 4.1f);
        v12.curveTo(13.03f, 3.4f, 11.56f, 3f, 10f, 3f);
        v12.curveTo(8.77f, 3f, 7.6f, 3.25f, 6.53f, 3.7f);
        v12.lineTo(8.1f, 5.27f);
        v12.curveTo(8.71f, 5.1f, 9.35f, 5f, 10f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoStrollerKt._noStroller = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

