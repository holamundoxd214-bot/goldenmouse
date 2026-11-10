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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifi2Bar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Wifi2Bar", "Landroidx/compose/material/icons/Icons$Rounded;", "getWifi2Bar", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Wifi2BarKt {
    private static ImageVector _wifi2Bar;

    static {
    }

    public static final ImageVector getWifi2Bar(Rounded arg19) {
        ImageVector v0 = Wifi2BarKt._wifi2Bar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Wifi2Bar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveToRelative(2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveTo(13.1f, 16f, 12f, 16f);
        v12.close();
        v12.moveTo(5.38f, 14.37f);
        v12.curveToRelative(-0.63f, -0.63f, -0.59f, -1.71f, 0.13f, -2.24f);
        v12.curveTo(7.33f, 10.79f, 9.57f, 10f, 12f, 10f);
        v12.curveToRelative(2.43f, 0f, 4.67f, 0.79f, 6.49f, 2.13f);
        v12.curveToRelative(0.72f, 0.53f, 0.76f, 1.6f, 0.13f, 2.24f);
        v12.curveToRelative(-0.53f, 0.54f, -1.37f, 0.57f, -1.98f, 0.12f);
        v12.curveTo(15.33f, 13.55f, 13.73f, 13f, 12f, 13f);
        v12.curveToRelative(-1.73f, 0f, -3.33f, 0.55f, -4.64f, 1.49f);
        v12.curveTo(6.75f, 14.93f, 5.91f, 14.9f, 5.38f, 14.37f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Wifi2BarKt._wifi2Bar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

