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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_formatColorText", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FormatColorText", "Landroidx/compose/material/icons/Icons$Rounded;", "getFormatColorText", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FormatColorTextKt {
    private static ImageVector _formatColorText;

    static {
    }

    public static final ImageVector getFormatColorText(Rounded arg19) {
        ImageVector v0 = FormatColorTextKt._formatColorText;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FormatColorText", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 20f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(21.1f, 20f, 20f, 20f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(7.11f, 17f);
        v12.lineTo(7.11f, 17f);
        v12.curveToRelative(0.48f, 0f, 0.91f, -0.3f, 1.06f, -0.75f);
        v12.lineToRelative(1.01f, -2.83f);
        v12.horizontalLineToRelative(5.65f);
        v12.lineToRelative(0.99f, 2.82f);
        v12.curveTo(15.98f, 16.700001f, 16.41f, 17f, 16.889999f, 17f);
        v12.curveToRelative(0.79f, 0f, 1.33f, -0.79f, 1.05f, -1.52f);
        v12.lineTo(13.69f, 4.17f);
        v12.curveTo(13.43f, 3.47f, 12.75f, 3f, 12f, 3f);
        v12.reflectiveCurveToRelative(-1.43f, 0.47f, -1.69f, 1.17f);
        v12.lineTo(6.06f, 15.48f);
        v12.curveTo(5.78f, 16.209999f, 6.33f, 17f, 7.11f, 17f);
        v12.close();
        v12.moveTo(11.94f, 5.6f);
        v12.horizontalLineToRelative(0.12f);
        v12.lineToRelative(2.03f, 5.79f);
        v12.horizontalLineTo(9.91f);
        v12.lineTo(11.94f, 5.6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FormatColorTextKt._formatColorText = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

