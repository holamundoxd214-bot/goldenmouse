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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_savings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Savings", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSavings", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SavingsKt {
    private static ImageVector _savings;

    static {
    }

    public static final ImageVector getSavings(TwoTone arg19) {
        ImageVector v0 = SavingsKt._savings;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Savings", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 9.5f);
        v12.lineTo(15.5f, 6f);
        v12.curveToRelative(0f, -0.65f, 0.09f, -1.29f, 0.26f, -1.91f);
        v12.curveTo(14.79f, 4.34f, 14f, 5.06f, 13.67f, 6f);
        v12.lineTo(7.5f, 6f);
        v12.curveTo(5.57f, 6f, 4f, 7.57f, 4f, 9.5f);
        v12.curveToRelative(0f, 1.88f, 1.22f, 6.65f, 2.01f, 9.5f);
        v12.lineTo(8f, 19f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(2.01f, 0f);
        v12.lineToRelative(1.55f, -5.15f);
        v12.lineTo(20f, 13.03f);
        v12.verticalLineTo(9.5f);
        v12.horizontalLineTo(19f);
        v12.close();
        v12.moveTo(13f, 9f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(16f, 11f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(17f, 10.55f, 16.549999f, 11f, 16f, 11f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15f, 10f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveTo(15f, 10.55f, 15f, 10f);
        v12.close();
        v12.moveTo(8f, 9f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(9f);
        v12.close();
        v12.moveTo(22f, 7.5f);
        v12.verticalLineToRelative(6.97f);
        v12.lineToRelative(-2.82f, 0.94f);
        v12.lineTo(17.5f, 21f);
        v12.lineTo(12f, 21f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(-5.5f, 0f);
        v12.curveTo(4.5f, 21f, 2f, 12.54f, 2f, 9.5f);
        v12.reflectiveCurveTo(4.46f, 4f, 7.5f, 4f);
        v12.lineToRelative(5f, 0f);
        v12.curveToRelative(0.91f, -1.21f, 2.36f, -2f, 4f, -2f);
        v12.curveTo(17.33f, 2f, 18f, 2.67f, 18f, 3.5f);
        v12.curveToRelative(0f, 0.21f, -0.04f, 0.4f, -0.12f, 0.58f);
        v12.curveToRelative(-0.14f, 0.34f, -0.26f, 0.73f, -0.32f, 1.15f);
        v12.lineToRelative(2.27f, 2.27f);
        v12.horizontalLineTo(22f);
        v12.close();
        v12.moveTo(20f, 9.5f);
        v12.horizontalLineToRelative(-1f);
        v12.lineTo(15.5f, 6f);
        v12.curveToRelative(0f, -0.65f, 0.09f, -1.29f, 0.26f, -1.91f);
        v12.curveTo(14.79f, 4.34f, 14f, 5.06f, 13.67f, 6f);
        v12.lineTo(7.5f, 6f);
        v12.curveTo(5.57f, 6f, 4f, 7.57f, 4f, 9.5f);
        v12.curveToRelative(0f, 1.88f, 1.22f, 6.65f, 2.01f, 9.5f);
        v12.lineTo(8f, 19f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(2f);
        v12.lineToRelative(2.01f, 0f);
        v12.lineToRelative(1.55f, -5.15f);
        v12.lineTo(20f, 13.03f);
        v12.verticalLineTo(9.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SavingsKt._savings = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

