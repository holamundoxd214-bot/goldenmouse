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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_signalWifiOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SignalWifiOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getSignalWifiOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SignalWifiOffKt {
    private static ImageVector _signalWifiOff;

    static {
    }

    public static final ImageVector getSignalWifiOff(Rounded arg19) {
        ImageVector v0 = SignalWifiOffKt._signalWifiOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SignalWifiOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23.639999f, 7f);
        v12.curveToRelative(-0.45f, -0.34f, -4.93f, -4f, -11.64f, -4f);
        v12.curveToRelative(-1.32f, 0f, -2.55f, 0.14f, -3.69f, 0.38f);
        v12.lineTo(18.43f, 13.5f);
        v12.lineTo(23.639999f, 7f);
        v12.close();
        v12.moveTo(4.12f, 2.01f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(1.35f, 1.35f);
        v12.curveTo(1.91f, 5.76f, 0.59f, 6.82f, 0.36f, 7f);
        v12.lineToRelative(10.08f, 12.56f);
        v12.curveToRelative(0.8f, 1f, 2.32f, 1f, 3.12f, 0f);
        v12.lineToRelative(2.35f, -2.93f);
        v12.lineToRelative(2.61f, 2.61f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(4.12f, 2.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SignalWifiOffKt._signalWifiOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

