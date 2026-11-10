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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_signalWifiOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SignalWifiOff", "Landroidx/compose/material/icons/Icons$Filled;", "getSignalWifiOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SignalWifiOffKt {
    private static ImageVector _signalWifiOff;

    static {
    }

    public static final ImageVector getSignalWifiOff(Filled arg19) {
        ImageVector v0 = SignalWifiOffKt._signalWifiOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SignalWifiOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23.639999f, 7f);
        v12.curveToRelative(-0.45f, -0.34f, -4.93f, -4f, -11.64f, -4f);
        v12.curveToRelative(-1.5f, 0f, -2.89f, 0.19f, -4.15f, 0.48f);
        v12.lineTo(18.18f, 13.8f);
        v12.lineTo(23.639999f, 7f);
        v12.close();
        v12.moveTo(17.040001f, 15.22f);
        v12.lineTo(3.27f, 1.44f);
        v12.lineTo(2f, 2.72f);
        v12.lineToRelative(2.05f, 2.06f);
        v12.curveTo(1.91f, 5.76f, 0.59f, 6.82f, 0.36f, 7f);
        v12.lineToRelative(11.63f, 14.49f);
        v12.lineToRelative(0.01f, 0.01f);
        v12.lineToRelative(0.01f, -0.01f);
        v12.lineToRelative(3.9f, -4.86f);
        v12.lineToRelative(3.32f, 3.32f);
        v12.lineToRelative(1.27f, -1.27f);
        v12.lineToRelative(-3.46f, -3.46f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SignalWifiOffKt._signalWifiOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

