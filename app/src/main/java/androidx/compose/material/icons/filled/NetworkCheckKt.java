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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_networkCheck", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NetworkCheck", "Landroidx/compose/material/icons/Icons$Filled;", "getNetworkCheck", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NetworkCheckKt {
    private static ImageVector _networkCheck;

    static {
    }

    public static final ImageVector getNetworkCheck(Filled arg19) {
        ImageVector v0 = NetworkCheckKt._networkCheck;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.NetworkCheck", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.9f, 5f);
        v12.curveToRelative(-0.17f, 0f, -0.32f, 0.09f, -0.41f, 0.23f);
        v12.lineToRelative(-0.07f, 0.15f);
        v12.lineToRelative(-5.18f, 11.65f);
        v12.curveToRelative(-0.16f, 0.29f, -0.26f, 0.61f, -0.26f, 0.96f);
        v12.curveToRelative(0f, 1.11f, 0.9f, 2.01f, 2.01f, 2.01f);
        v12.curveToRelative(0.96f, 0f, 1.77f, -0.68f, 1.96f, -1.59f);
        v12.lineToRelative(0.01f, -0.03f);
        v12.lineTo(16.4f, 5.5f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        v12.moveTo(1f, 9f);
        v12.lineToRelative(2f, 2f);
        v12.curveToRelative(2.88f, -2.88f, 6.79f, -4.08f, 10.53f, -3.62f);
        v12.lineToRelative(1.19f, -2.68f);
        v12.curveTo(9.89f, 3.84f, 4.74f, 5.27f, 1f, 9f);
        v12.close();
        v12.moveTo(21f, 11f);
        v12.lineToRelative(2f, -2f);
        v12.curveToRelative(-1.64f, -1.64f, -3.55f, -2.82f, -5.59f, -3.57f);
        v12.lineToRelative(-0.53f, 2.82f);
        v12.curveToRelative(1.5f, 0.62f, 2.9f, 1.53f, 4.12f, 2.75f);
        v12.close();
        v12.moveTo(17f, 15f);
        v12.lineToRelative(2f, -2f);
        v12.curveToRelative(-0.8f, -0.8f, -1.7f, -1.42f, -2.66f, -1.89f);
        v12.lineToRelative(-0.55f, 2.92f);
        v12.curveToRelative(0.42f, 0.27f, 0.83f, 0.59f, 1.21f, 0.97f);
        v12.close();
        v12.moveTo(5f, 13f);
        v12.lineToRelative(2f, 2f);
        v12.curveToRelative(1.13f, -1.13f, 2.56f, -1.79f, 4.03f, -2f);
        v12.lineToRelative(1.28f, -2.88f);
        v12.curveToRelative(-2.63f, -0.08f, -5.3f, 0.87f, -7.31f, 2.88f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NetworkCheckKt._networkCheck = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

