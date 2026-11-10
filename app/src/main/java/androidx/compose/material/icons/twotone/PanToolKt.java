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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panTool", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanTool", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPanTool", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanToolKt {
    private static ImageVector _panTool;

    static {
    }

    public static final ImageVector getPanTool(TwoTone arg19) {
        ImageVector v0 = PanToolKt._panTool;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.PanTool", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.5f, 5.65f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, 0.22f, -0.5f, 0.5f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(3.42f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(2.51f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.5f, 0.22f, -0.5f, 0.5f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(4.79f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.reflectiveCurveToRelative(-0.5f, 0.23f, -0.5f, 0.5f);
        v12.verticalLineToRelative(12.87f);
        v12.lineToRelative(-5.35f, -2.83f);
        v12.lineToRelative(-0.51f, 0.45f);
        v12.lineToRelative(5.86f, 6.1f);
        v12.curveToRelative(0.38f, 0.39f, 0.9f, 0.62f, 1.44f, 0.62f);
        v12.horizontalLineTo(18f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(6.15f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.5f, 3.65f);
        v12.curveToRelative(-0.17f, 0f, -0.34f, 0.02f, -0.5f, 0.05f);
        v12.verticalLineToRelative(-0.28f);
        v12.curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        v12.curveToRelative(-0.33f, 0f, -0.65f, 0.06f, -0.94f, 0.18f);
        v12.curveTo(15.11f, 0.44f, 14.35f, 0.01f, 13.5f, 0.01f);
        v12.curveToRelative(-1.32f, 0f, -2.41f, 1.03f, -2.49f, 2.33f);
        v12.curveToRelative(-0.16f, -0.03f, -0.33f, -0.05f, -0.51f, -0.05f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, 1.12f, -2.5f, 2.5f);
        v12.verticalLineToRelative(9.55f);
        v12.lineToRelative(-2.41f, -1.28f);
        v12.curveToRelative(-0.73f, -0.39f, -1.64f, -0.28f, -2.26f, 0.27f);
        v12.lineToRelative(-2.07f, 1.83f);
        v12.lineToRelative(7.3f, 7.61f);
        v12.curveToRelative(0.75f, 0.78f, 1.8f, 1.23f, 2.89f, 1.23f);
        v12.horizontalLineTo(18f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.verticalLineTo(6.15f);
        v12.curveToRelative(0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        v12.close();
        v12.moveTo(20f, 20f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineToRelative(-6.55f);
        v12.curveToRelative(-0.54f, 0f, -1.07f, -0.22f, -1.44f, -0.62f);
        v12.lineToRelative(-5.86f, -6.11f);
        v12.lineToRelative(0.51f, -0.45f);
        v12.lineTo(10f, 17.66f);
        v12.verticalLineTo(4.79f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.23f, 0.5f, 0.5f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(2.51f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(3.42f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(6.15f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanToolKt._panTool = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

