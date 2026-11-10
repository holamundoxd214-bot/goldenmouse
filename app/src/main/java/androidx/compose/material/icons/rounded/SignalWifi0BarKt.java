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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_signalWifi0Bar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SignalWifi0Bar", "Landroidx/compose/material/icons/Icons$Rounded;", "getSignalWifi0Bar", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SignalWifi0BarKt {
    private static ImageVector _signalWifi0Bar;

    static {
    }

    public static final ImageVector getSignalWifi0Bar(Rounded arg19) {
        ImageVector v0 = SignalWifi0BarKt._signalWifi0Bar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SignalWifi0Bar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveTo(7.7f, 4f, 3.78f, 5.6f, 0.79f, 8.24f);
        v12.curveTo(0.35f, 8.63f, 0.32f, 9.3f, 0.73f, 9.71f);
        v12.lineToRelative(10.56f, 10.58f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.42f, 0f);
        v12.lineTo(23.27f, 9.71f);
        v12.curveToRelative(0.41f, -0.41f, 0.38f, -1.08f, -0.06f, -1.47f);
        v12.curveTo(20.219999f, 5.6f, 16.299999f, 4f, 12f, 4f);
        v12.close();
        v12.moveTo(2.92f, 9.07f);
        v12.curveTo(5.51f, 7.08f, 8.67f, 6f, 12f, 6f);
        v12.reflectiveCurveToRelative(6.49f, 1.08f, 9.08f, 3.07f);
        v12.lineTo(12f, 18.17f);
        v12.lineTo(2.92f, 9.07f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SignalWifi0BarKt._signalWifi0Bar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

