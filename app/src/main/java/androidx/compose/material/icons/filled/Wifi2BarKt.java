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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wifi2Bar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Wifi2Bar", "Landroidx/compose/material/icons/Icons$Filled;", "getWifi2Bar", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Wifi2BarKt {
    private static ImageVector _wifi2Bar;

    static {
    }

    public static final ImageVector getWifi2Bar(Filled arg19) {
        ImageVector v0 = Wifi2BarKt._wifi2Bar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Wifi2Bar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 10f);
        v12.curveToRelative(3.03f, 0f, 5.78f, 1.23f, 7.76f, 3.22f);
        v12.lineToRelative(-2.12f, 2.12f);
        v12.curveTo(16.200001f, 13.9f, 14.2f, 13f, 12f, 13f);
        v12.curveToRelative(-2.2f, 0f, -4.2f, 0.9f, -5.64f, 2.35f);
        v12.lineToRelative(-2.12f, -2.12f);
        v12.curveTo(6.22f, 11.23f, 8.97f, 10f, 12f, 10f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-1.38f, 0f, -2.63f, 0.56f, -3.53f, 1.46f);
        v12.lineTo(12f, 21f);
        v12.lineToRelative(3.53f, -3.54f);
        v12.curveTo(14.63f, 16.559999f, 13.38f, 16f, 12f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Wifi2BarKt._wifi2Bar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

