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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_signalCellularAlt2Bar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SignalCellularAlt2Bar", "Landroidx/compose/material/icons/Icons$Rounded;", "getSignalCellularAlt2Bar", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SignalCellularAlt2BarKt {
    private static ImageVector _signalCellularAlt2Bar;

    static {
    }

    public static final ImageVector getSignalCellularAlt2Bar(Rounded arg19) {
        ImageVector v0 = SignalCellularAlt2BarKt._signalCellularAlt2Bar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SignalCellularAlt2Bar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.5f, 20f);
        v12.curveTo(5.67f, 20f, 5f, 19.33f, 5f, 18.5f);
        v12.verticalLineToRelative(-3f);
        v12.curveTo(5f, 14.67f, 5.67f, 14f, 6.5f, 14f);
        v12.reflectiveCurveTo(8f, 14.67f, 8f, 15.5f);
        v12.verticalLineToRelative(3f);
        v12.curveTo(8f, 19.33f, 7.33f, 20f, 6.5f, 20f);
        v12.close();
        v12.moveTo(12.5f, 20f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.verticalLineToRelative(-8f);
        v12.curveTo(11f, 9.67f, 11.67f, 9f, 12.5f, 9f);
        v12.reflectiveCurveTo(14f, 9.67f, 14f, 10.5f);
        v12.verticalLineToRelative(8f);
        v12.curveTo(14f, 19.33f, 13.33f, 20f, 12.5f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SignalCellularAlt2BarKt._signalCellularAlt2Bar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

