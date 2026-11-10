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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panTool", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanTool", "Landroidx/compose/material/icons/Icons$Rounded;", "getPanTool", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanToolKt {
    private static ImageVector _panTool;

    static {
    }

    public static final ImageVector getPanTool(Rounded arg19) {
        ImageVector v0 = PanToolKt._panTool;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.PanTool", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.5f, 4f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-8f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(16f, 1.67f, 16f, 2.5f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-9f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(12f, 0.67f, 12f, 1.5f);
        v12.verticalLineToRelative(8.99f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.reflectiveCurveToRelative(-0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineTo(4.5f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(8f, 3.67f, 8f, 4.5f);
        v12.verticalLineToRelative(11.41f);
        v12.lineToRelative(-4.12f, -2.35f);
        v12.curveToRelative(-0.58f, -0.33f, -1.3f, -0.24f, -1.78f, 0.22f);
        v12.curveToRelative(-0.6f, 0.58f, -0.62f, 1.54f, -0.03f, 2.13f);
        v12.lineToRelative(6.78f, 6.89f);
        v12.curveToRelative(0.75f, 0.77f, 1.77f, 1.2f, 2.85f, 1.2f);
        v12.horizontalLineTo(19f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.verticalLineTo(5.5f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanToolKt._panTool = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

