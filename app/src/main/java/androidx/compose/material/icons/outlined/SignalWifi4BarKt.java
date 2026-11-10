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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_signalWifi4Bar", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SignalWifi4Bar", "Landroidx/compose/material/icons/Icons$Outlined;", "getSignalWifi4Bar", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SignalWifi4BarKt {
    private static ImageVector _signalWifi4Bar;

    static {
    }

    public static final ImageVector getSignalWifi4Bar(Outlined arg19) {
        ImageVector v0 = SignalWifi4BarKt._signalWifi4Bar;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SignalWifi4Bar", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.01f, 21.49f);
        v12.lineTo(23.639999f, 7f);
        v12.curveToRelative(-0.45f, -0.34f, -4.93f, -4f, -11.64f, -4f);
        v12.curveTo(5.28f, 3f, 0.81f, 6.66f, 0.36f, 7f);
        v12.lineToRelative(11.63f, 14.49f);
        v12.lineToRelative(0.01f, 0.01f);
        v12.lineToRelative(0.01f, -0.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SignalWifi4BarKt._signalWifi4Bar = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

