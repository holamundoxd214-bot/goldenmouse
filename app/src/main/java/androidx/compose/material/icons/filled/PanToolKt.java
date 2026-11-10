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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_panTool", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanTool", "Landroidx/compose/material/icons/Icons$Filled;", "getPanTool", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PanToolKt {
    private static ImageVector _panTool;

    static {
    }

    public static final ImageVector getPanTool(Filled arg19) {
        ImageVector v0 = PanToolKt._panTool;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PanTool", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23f, 5.5f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 2.2f, -1.8f, 4f, -4f, 4f);
        v12.horizontalLineToRelative(-7.3f);
        v12.curveToRelative(-1.08f, 0f, -2.1f, -0.43f, -2.85f, -1.19f);
        v12.lineTo(1f, 14.83f);
        v12.curveToRelative(0f, 0f, 1.26f, -1.23f, 1.3f, -1.25f);
        v12.curveToRelative(0.22f, -0.19f, 0.49f, -0.29f, 0.79f, -0.29f);
        v12.curveToRelative(0.22f, 0f, 0.42f, 0.06f, 0.6f, 0.16f);
        v12.curveTo(3.73f, 13.46f, 8f, 15.91f, 8f, 15.91f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveTo(11f, 3.17f, 11f, 4f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(1.5f);
        v12.curveTo(12f, 0.67f, 12.67f, 0f, 13.5f, 0f);
        v12.reflectiveCurveTo(15f, 0.67f, 15f, 1.5f);
        v12.verticalLineTo(11f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(2.5f);
        v12.curveTo(16f, 1.67f, 16.67f, 1f, 17.5f, 1f);
        v12.reflectiveCurveTo(19f, 1.67f, 19f, 2.5f);
        v12.verticalLineTo(11f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(5.5f);
        v12.curveTo(20f, 4.67f, 20.67f, 4f, 21.5f, 4f);
        v12.reflectiveCurveTo(23f, 4.67f, 23f, 5.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PanToolKt._panTool = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

