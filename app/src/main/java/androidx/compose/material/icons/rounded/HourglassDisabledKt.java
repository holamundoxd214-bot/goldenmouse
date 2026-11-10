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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hourglassDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HourglassDisabled", "Landroidx/compose/material/icons/Icons$Rounded;", "getHourglassDisabled", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HourglassDisabledKt {
    private static ImageVector _hourglassDisabled;

    static {
    }

    public static final ImageVector getHourglassDisabled(Rounded arg19) {
        ImageVector v0 = HourglassDisabledKt._hourglassDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HourglassDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.81f, 2.81f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveTo(1f, 3.2f, 1f, 3.83f, 1.39f, 4.22f);
        v12.lineToRelative(8.19f, 8.19f);
        v12.lineToRelative(-3f, 3.01f);
        v12.curveTo(6.21f, 15.8f, 6f, 16.309999f, 6f, 16.84f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(8f);
        v12.curveToRelative(0.86f, 0f, 1.58f, -0.54f, 1.87f, -1.3f);
        v12.lineToRelative(1.91f, 1.91f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.close();
        v12.moveTo(16f, 19f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(9f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-2.5f);
        v12.lineToRelative(2.84f, -2.84f);
        v12.lineTo(16f, 18.83f);
        v12.verticalLineTo(19f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8f, 5f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(2.5f);
        v12.lineToRelative(-2.84f, 2.84f);
        v12.lineToRelative(1.25f, 1.25f);
        v12.lineToRelative(3f, -2.99f);
        v12.curveTo(17.790001f, 8.22f, 18f, 7.71f, 18f, 7.18f);
        v12.verticalLineTo(4f);
        v12.curveToRelative(0f, -1.11f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(8f);
        v12.curveTo(7.14f, 2f, 6.42f, 2.54f, 6.13f, 3.3f);
        v12.lineTo(8f, 5.17f);
        v12.verticalLineTo(5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HourglassDisabledKt._hourglassDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

