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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_brightness7", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Brightness7", "Landroidx/compose/material/icons/Icons$Rounded;", "getBrightness7", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Brightness7Kt {
    private static ImageVector _brightness7;

    static {
    }

    public static final ImageVector getBrightness7(Rounded arg19) {
        ImageVector v0 = Brightness7Kt._brightness7;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Brightness7", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 8.69f);
        v12.lineTo(20f, 5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-3.69f);
        v12.lineToRelative(-2.6f, -2.6f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineTo(8.69f, 4f);
        v12.lineTo(5f, 4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3.69f);
        v12.lineToRelative(-2.6f, 2.6f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineTo(4f, 15.3f);
        v12.lineTo(4f, 19f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3.69f);
        v12.lineToRelative(2.6f, 2.6f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(2.6f, -2.6f);
        v12.lineTo(19f, 20f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-3.69f);
        v12.lineToRelative(2.6f, -2.6f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(20f, 8.69f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-3.31f, 0f, -6f, -2.69f, -6f, -6f);
        v12.reflectiveCurveToRelative(2.69f, -6f, 6f, -6f);
        v12.reflectiveCurveToRelative(6f, 2.69f, 6f, 6f);
        v12.reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f);
        v12.close();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.reflectiveCurveToRelative(-1.79f, -4f, -4f, -4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Brightness7Kt._brightness7 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

