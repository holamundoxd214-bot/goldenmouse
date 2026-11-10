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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_stadium", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Stadium", "Landroidx/compose/material/icons/Icons$TwoTone;", "getStadium", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StadiumKt {
    private static ImageVector _stadium;

    static {
    }

    public static final ImageVector getStadium(TwoTone arg19) {
        ImageVector v0 = StadiumKt._stadium;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Stadium", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 10.04f);
        v12.curveTo(6.38f, 10.53f, 8.77f, 11f, 12f, 11f);
        v12.reflectiveCurveToRelative(5.62f, -0.47f, 7f, -0.96f);
        v12.curveTo(19f, 9.86f, 16.219999f, 9f, 12f, 9f);
        v12.reflectiveCurveTo(5f, 9.86f, 5f, 10.04f);
        v12.close();
        v12.moveTo(20f, 11.8f);
        v12.curveToRelative(-1.82f, 0.73f, -4.73f, 1.2f, -8f, 1.2f);
        v12.reflectiveCurveToRelative(-6.18f, -0.47f, -8f, -1.2f);
        v12.verticalLineToRelative(6.78f);
        v12.curveToRelative(0.61f, 0.41f, 2.36f, 1.01f, 5f, 1.28f);
        v12.verticalLineTo(16f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(3.86f);
        v12.curveToRelative(2.64f, -0.27f, 4.39f, -0.87f, 5f, -1.28f);
        v12.verticalLineTo(11.8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(7f, 5f);
        v12.lineTo(3f, 7f);
        v12.verticalLineTo(3f);
        v12.lineTo(7f, 5f);
        v12.close();
        v12.moveTo(18f, 3f);
        v12.verticalLineToRelative(4f);
        v12.lineToRelative(4f, -2f);
        v12.lineTo(18f, 3f);
        v12.close();
        v12.moveTo(11f, 2f);
        v12.verticalLineToRelative(4f);
        v12.lineToRelative(4f, -2f);
        v12.lineTo(11f, 2f);
        v12.close();
        v12.moveTo(13f, 18f);
        v12.horizontalLineToRelative(-2f);
        v12.lineToRelative(0f, 4f);
        v12.curveToRelative(-5.05f, -0.15f, -9f, -1.44f, -9f, -3f);
        v12.verticalLineToRelative(-9f);
        v12.curveToRelative(0f, -1.66f, 4.48f, -3f, 10f, -3f);
        v12.reflectiveCurveToRelative(10f, 1.34f, 10f, 3f);
        v12.verticalLineToRelative(9f);
        v12.curveToRelative(0f, 1.56f, -3.95f, 2.85f, -9f, 3f);
        v12.lineTo(13f, 18f);
        v12.close();
        v12.moveTo(5f, 10.04f);
        v12.curveTo(6.38f, 10.53f, 8.77f, 11f, 12f, 11f);
        v12.reflectiveCurveToRelative(5.62f, -0.47f, 7f, -0.96f);
        v12.curveTo(19f, 9.86f, 16.219999f, 9f, 12f, 9f);
        v12.reflectiveCurveTo(5f, 9.86f, 5f, 10.04f);
        v12.close();
        v12.moveTo(20f, 11.8f);
        v12.curveToRelative(-1.82f, 0.73f, -4.73f, 1.2f, -8f, 1.2f);
        v12.reflectiveCurveToRelative(-6.18f, -0.47f, -8f, -1.2f);
        v12.verticalLineToRelative(6.78f);
        v12.curveToRelative(0.61f, 0.41f, 2.36f, 1.01f, 5f, 1.28f);
        v12.verticalLineTo(16f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(3.86f);
        v12.curveToRelative(2.64f, -0.27f, 4.39f, -0.87f, 5f, -1.28f);
        v12.verticalLineTo(11.8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StadiumKt._stadium = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

