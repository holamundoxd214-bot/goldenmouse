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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pestControl", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PestControl", "Landroidx/compose/material/icons/Icons$Outlined;", "getPestControl", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PestControlKt {
    private static ImageVector _pestControl;

    static {
    }

    public static final ImageVector getPestControl(Outlined arg19) {
        ImageVector v0 = PestControlKt._pestControl;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.PestControl", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 15f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-3.07f);
        v12.curveToRelative(-0.05f, -0.39f, -0.12f, -0.77f, -0.22f, -1.14f);
        v12.lineToRelative(2.58f, -1.49f);
        v12.lineToRelative(-1f, -1.73f);
        v12.lineTo(16.92f, 10f);
        v12.curveToRelative(-0.28f, -0.48f, -0.62f, -0.91f, -0.99f, -1.29f);
        v12.curveToRelative(0.1f, -0.56f, 0.2f, -1.69f, -0.58f, -2.89f);
        v12.lineTo(17f, 4.17f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.lineToRelative(-1.72f, 1.72f);
        v12.curveToRelative(-1.68f, -0.89f, -3.1f, -0.33f, -3.73f, 0f);
        v12.lineTo(8.41f, 2.76f);
        v12.lineTo(7f, 4.17f);
        v12.lineToRelative(1.65f, 1.65f);
        v12.curveToRelative(-0.78f, 1.2f, -0.68f, 2.34f, -0.58f, 2.89f);
        v12.curveTo(7.7f, 9.1f, 7.36f, 9.53f, 7.08f, 10f);
        v12.lineTo(4.71f, 8.63f);
        v12.lineToRelative(-1f, 1.73f);
        v12.lineToRelative(2.58f, 1.49f);
        v12.curveToRelative(-0.1f, 0.37f, -0.17f, 0.75f, -0.22f, 1.14f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3.07f);
        v12.curveToRelative(0.05f, 0.39f, 0.12f, 0.77f, 0.22f, 1.14f);
        v12.lineToRelative(-2.58f, 1.49f);
        v12.lineToRelative(1f, 1.73f);
        v12.lineTo(7.08f, 18f);
        v12.curveToRelative(1.08f, 1.81f, 2.88f, 3f, 4.92f, 3f);
        v12.reflectiveCurveToRelative(3.84f, -1.19f, 4.92f, -3f);
        v12.lineToRelative(2.37f, 1.37f);
        v12.lineToRelative(1f, -1.73f);
        v12.lineToRelative(-2.58f, -1.49f);
        v12.curveToRelative(0.1f, -0.37f, 0.17f, -0.75f, 0.22f, -1.14f);
        v12.horizontalLineTo(21f);
        v12.close();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(0.88f, 0f, 1.62f, 0.57f, 1.88f, 1.36f);
        v12.curveTo(13.29f, 7.13f, 12.66f, 7f, 12f, 7f);
        v12.reflectiveCurveToRelative(-1.29f, 0.13f, -1.88f, 0.36f);
        v12.curveTo(10.38f, 6.57f, 11.12f, 6f, 12f, 6f);
        v12.close();
        v12.moveTo(12f, 19f);
        v12.curveToRelative(-2.21f, 0f, -4f, -2.24f, -4f, -5f);
        v12.reflectiveCurveToRelative(1.79f, -5f, 4f, -5f);
        v12.reflectiveCurveToRelative(4f, 2.24f, 4f, 5f);
        v12.reflectiveCurveTo(14.21f, 19f, 12f, 19f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(11f, 11f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(6f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PestControlKt._pestControl = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

