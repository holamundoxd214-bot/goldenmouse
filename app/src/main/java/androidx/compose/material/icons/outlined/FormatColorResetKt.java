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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_formatColorReset", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FormatColorReset", "Landroidx/compose/material/icons/Icons$Outlined;", "getFormatColorReset", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FormatColorResetKt {
    private static ImageVector _formatColorReset;

    static {
    }

    public static final ImageVector getFormatColorReset(Outlined arg19) {
        ImageVector v0 = FormatColorResetKt._formatColorReset;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.FormatColorReset", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6.36f);
        v12.curveToRelative(1.53f, 2f, 3.08f, 4.43f, 3.71f, 6.24f);
        v12.lineToRelative(2.23f, 2.23f);
        v12.curveToRelative(0.03f, -0.27f, 0.06f, -0.55f, 0.06f, -0.83f);
        v12.curveToRelative(0f, -3.98f, -6f, -10.8f, -6f, -10.8f);
        v12.reflectiveCurveToRelative(-1.18f, 1.35f, -2.5f, 3.19f);
        v12.lineToRelative(1.44f, 1.44f);
        v12.curveToRelative(0.34f, -0.51f, 0.7f, -1f, 1.06f, -1.47f);
        v12.close();
        v12.moveTo(5.41f, 5.14f);
        v12.lineTo(4f, 6.55f);
        v12.lineToRelative(3.32f, 3.32f);
        v12.curveTo(6.55f, 11.33f, 6f, 12.79f, 6f, 14f);
        v12.curveToRelative(0f, 3.31f, 2.69f, 6f, 6f, 6f);
        v12.curveToRelative(1.52f, 0f, 2.9f, -0.57f, 3.95f, -1.5f);
        v12.lineToRelative(2.63f, 2.63f);
        v12.lineTo(20f, 19.719999f);
        v12.lineTo(5.41f, 5.14f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.curveToRelative(0f, -0.69f, 0.32f, -1.62f, 0.81f, -2.64f);
        v12.lineToRelative(5.72f, 5.72f);
        v12.curveToRelative(-0.7f, 0.56f, -1.57f, 0.92f, -2.53f, 0.92f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FormatColorResetKt._formatColorReset = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

