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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_formatUnderlined", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FormatUnderlined", "Landroidx/compose/material/icons/Icons$Rounded;", "getFormatUnderlined", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FormatUnderlinedKt {
    private static ImageVector _formatUnderlined;

    static {
    }

    public static final ImageVector getFormatUnderlined(Rounded arg19) {
        ImageVector v0 = FormatUnderlinedKt._formatUnderlined;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FormatUnderlined", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.79f, 16.950001f);
        v12.curveToRelative(3.03f, -0.39f, 5.21f, -3.11f, 5.21f, -6.16f);
        v12.verticalLineTo(4.25f);
        v12.curveTo(18f, 3.56f, 17.440001f, 3f, 16.75f, 3f);
        v12.reflectiveCurveToRelative(-1.25f, 0.56f, -1.25f, 1.25f);
        v12.verticalLineToRelative(6.65f);
        v12.curveToRelative(0f, 1.67f, -1.13f, 3.19f, -2.77f, 3.52f);
        v12.curveToRelative(-2.25f, 0.47f, -4.23f, -1.25f, -4.23f, -3.42f);
        v12.verticalLineTo(4.25f);
        v12.curveTo(8.5f, 3.56f, 7.94f, 3f, 7.25f, 3f);
        v12.reflectiveCurveTo(6f, 3.56f, 6f, 4.25f);
        v12.verticalLineTo(11f);
        v12.curveToRelative(0f, 3.57f, 3.13f, 6.42f, 6.79f, 5.95f);
        v12.close();
        v12.moveTo(5f, 20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FormatUnderlinedKt._formatUnderlined = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

