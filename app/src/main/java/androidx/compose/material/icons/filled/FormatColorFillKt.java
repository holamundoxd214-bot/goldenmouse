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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_formatColorFill", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FormatColorFill", "Landroidx/compose/material/icons/Icons$Filled;", "getFormatColorFill", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FormatColorFillKt {
    private static ImageVector _formatColorFill;

    static {
    }

    public static final ImageVector getFormatColorFill(Filled arg19) {
        ImageVector v0 = FormatColorFillKt._formatColorFill;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.FormatColorFill", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.559999f, 8.94f);
        v12.lineTo(7.62f, 0f);
        v12.lineTo(6.21f, 1.41f);
        v12.lineToRelative(2.38f, 2.38f);
        v12.lineTo(3.44f, 8.94f);
        v12.curveToRelative(-0.59f, 0.59f, -0.59f, 1.54f, 0f, 2.12f);
        v12.lineToRelative(5.5f, 5.5f);
        v12.curveTo(9.23f, 16.85f, 9.62f, 17f, 10f, 17f);
        v12.reflectiveCurveToRelative(0.77f, -0.15f, 1.06f, -0.44f);
        v12.lineToRelative(5.5f, -5.5f);
        v12.curveTo(17.15f, 10.48f, 17.15f, 9.53f, 16.559999f, 8.94f);
        v12.close();
        v12.moveTo(5.21f, 10f);
        v12.lineTo(10f, 5.21f);
        v12.lineTo(14.79f, 10f);
        v12.horizontalLineTo(5.21f);
        v12.close();
        v12.moveTo(19f, 11.5f);
        v12.curveToRelative(0f, 0f, -2f, 2.17f, -2f, 3.5f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.curveTo(21f, 13.67f, 19f, 11.5f, 19f, 11.5f);
        v12.close();
        v12.moveTo(2f, 20f);
        v12.horizontalLineToRelative(20f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(2f);
        v12.verticalLineTo(20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FormatColorFillKt._formatColorFill = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

