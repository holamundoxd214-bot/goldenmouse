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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_frontHand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FrontHand", "Landroidx/compose/material/icons/Icons$Outlined;", "getFrontHand", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FrontHandKt {
    private static ImageVector _frontHand;

    static {
    }

    public static final ImageVector getFrontHand(Outlined arg19) {
        ImageVector v0 = FrontHandKt._frontHand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.FrontHand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.5f, 8f);
        v12.curveToRelative(-0.17f, 0f, -0.34f, 0.02f, -0.5f, 0.05f);
        v12.verticalLineTo(4.5f);
        v12.curveTo(18f, 3.12f, 16.879999f, 2f, 15.5f, 2f);
        v12.curveToRelative(-0.19f, 0f, -0.37f, 0.02f, -0.54f, 0.06f);
        v12.curveTo(14.75f, 0.89f, 13.73f, 0f, 12.5f, 0f);
        v12.curveToRelative(-1.06f, 0f, -1.96f, 0.66f, -2.33f, 1.59f);
        v12.curveTo(9.96f, 1.53f, 9.73f, 1.5f, 9.5f, 1.5f);
        v12.curveTo(8.12f, 1.5f, 7f, 2.62f, 7f, 4f);
        v12.verticalLineToRelative(0.55f);
        v12.curveTo(6.84f, 4.52f, 6.67f, 4.5f, 6.5f, 4.5f);
        v12.curveTo(5.12f, 4.5f, 4f, 5.62f, 4f, 7f);
        v12.verticalLineToRelative(8.5f);
        v12.curveToRelative(0f, 4.69f, 3.81f, 8.5f, 8.5f, 8.5f);
        v12.reflectiveCurveToRelative(8.5f, -3.81f, 8.5f, -8.5f);
        v12.verticalLineToRelative(-5f);
        v12.curveTo(21f, 9.12f, 19.879999f, 8f, 18.5f, 8f);
        v12.close();
        v12.moveTo(19f, 15.5f);
        v12.curveToRelative(0f, 3.59f, -2.91f, 6.5f, -6.5f, 6.5f);
        v12.reflectiveCurveTo(6f, 19.09f, 6f, 15.5f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveTo(7f, 6.72f, 7f, 7f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveTo(10f, 3.72f, 10f, 4f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(2.5f);
        v12.curveTo(12f, 2.22f, 12.22f, 2f, 12.5f, 2f);
        v12.reflectiveCurveTo(13f, 2.22f, 13f, 2.5f);
        v12.verticalLineTo(11f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(4.5f);
        v12.curveTo(15f, 4.22f, 15.22f, 4f, 15.5f, 4f);
        v12.reflectiveCurveTo(16f, 4.22f, 16f, 4.5f);
        v12.verticalLineToRelative(8.92f);
        v12.curveToRelative(-1.77f, 0.77f, -3f, 2.53f, -3f, 4.58f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -1.66f, 1.34f, -3f, 3f, -3f);
        v12.verticalLineToRelative(-4.5f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(15.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FrontHandKt._frontHand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

