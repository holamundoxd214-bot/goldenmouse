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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_stadium", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Stadium", "Landroidx/compose/material/icons/Icons$Rounded;", "getStadium", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StadiumKt {
    private static ImageVector _stadium;

    static {
    }

    public static final ImageVector getStadium(Rounded arg19) {
        ImageVector v0 = StadiumKt._stadium;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Stadium", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.11f, 5.45f);
        v12.lineTo(3.72f, 6.64f);
        v12.curveTo(3.39f, 6.8f, 3f, 6.56f, 3f, 6.19f);
        v12.verticalLineTo(3.81f);
        v12.curveTo(3f, 3.44f, 3.39f, 3.2f, 3.72f, 3.36f);
        v12.lineToRelative(2.38f, 1.19f);
        v12.curveTo(6.47f, 4.74f, 6.47f, 5.26f, 6.11f, 5.45f);
        v12.close();
        v12.moveTo(18f, 3.81f);
        v12.verticalLineToRelative(2.38f);
        v12.curveToRelative(0f, 0.37f, 0.39f, 0.61f, 0.72f, 0.45f);
        v12.lineToRelative(2.38f, -1.19f);
        v12.curveToRelative(0.37f, -0.18f, 0.37f, -0.71f, 0f, -0.89f);
        v12.lineToRelative(-2.38f, -1.19f);
        v12.curveTo(18.389999f, 3.2f, 18f, 3.44f, 18f, 3.81f);
        v12.close();
        v12.moveTo(11f, 2.81f);
        v12.verticalLineToRelative(2.38f);
        v12.curveToRelative(0f, 0.37f, 0.39f, 0.61f, 0.72f, 0.45f);
        v12.lineToRelative(2.38f, -1.19f);
        v12.curveToRelative(0.37f, -0.18f, 0.37f, -0.71f, 0f, -0.89f);
        v12.lineToRelative(-2.38f, -1.19f);
        v12.curveTo(11.39f, 2.2f, 11f, 2.44f, 11f, 2.81f);
        v12.close();
        v12.moveTo(5f, 10.04f);
        v12.curveTo(6.38f, 10.53f, 8.77f, 11f, 12f, 11f);
        v12.reflectiveCurveToRelative(5.62f, -0.47f, 7f, -0.96f);
        v12.curveTo(19f, 9.86f, 16.219999f, 9f, 12f, 9f);
        v12.reflectiveCurveTo(5f, 9.86f, 5f, 10.04f);
        v12.close();
        v12.moveTo(14f, 17f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.lineToRelative(0f, 3.88f);
        v12.curveTo(4.94f, 21.49f, 2f, 20.34f, 2f, 19f);
        v12.verticalLineToRelative(-9f);
        v12.curveToRelative(0f, -1.66f, 4.48f, -3f, 10f, -3f);
        v12.reflectiveCurveToRelative(10f, 1.34f, 10f, 3f);
        v12.verticalLineToRelative(9f);
        v12.curveToRelative(0f, 1.34f, -2.94f, 2.48f, -7f, 2.87f);
        v12.lineTo(15f, 18f);
        v12.curveTo(15f, 17.450001f, 14.55f, 17f, 14f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StadiumKt._stadium = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

