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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_networkCheck", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NetworkCheck", "Landroidx/compose/material/icons/Icons$Rounded;", "getNetworkCheck", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NetworkCheckKt {
    private static ImageVector _networkCheck;

    static {
    }

    public static final ImageVector getNetworkCheck(Rounded arg19) {
        ImageVector v0 = NetworkCheckKt._networkCheck;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NetworkCheck", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(2.06f, 10.06f);
        v12.curveToRelative(0.51f, 0.51f, 1.33f, 0.55f, 1.89f, 0.09f);
        v12.curveToRelative(2.76f, -2.26f, 6.24f, -3.18f, 9.58f, -2.76f);
        v12.lineToRelative(1.19f, -2.68f);
        v12.curveToRelative(-4.35f, -0.78f, -8.96f, 0.3f, -12.57f, 3.25f);
        v12.curveToRelative(-0.64f, 0.53f, -0.68f, 1.51f, -0.09f, 2.1f);
        v12.close();
        v12.moveTo(21.940001f, 10.06f);
        v12.curveToRelative(0.59f, -0.59f, 0.55f, -1.57f, -0.1f, -2.1f);
        v12.curveToRelative(-1.36f, -1.11f, -2.86f, -1.95f, -4.44f, -2.53f);
        v12.lineToRelative(-0.53f, 2.82f);
        v12.curveToRelative(1.13f, 0.47f, 2.19f, 1.09f, 3.17f, 1.89f);
        v12.curveToRelative(0.58f, 0.46f, 1.39f, 0.43f, 1.9f, -0.08f);
        v12.close();
        v12.moveTo(17.91f, 14.09f);
        v12.curveToRelative(0.6f, -0.6f, 0.56f, -1.63f, -0.14f, -2.12f);
        v12.curveToRelative(-0.46f, -0.33f, -0.94f, -0.61f, -1.44f, -0.86f);
        v12.lineToRelative(-0.55f, 2.92f);
        v12.curveToRelative(0.11f, 0.07f, 0.22f, 0.14f, 0.32f, 0.22f);
        v12.curveToRelative(0.57f, 0.4f, 1.33f, 0.32f, 1.81f, -0.16f);
        v12.close();
        v12.moveTo(6.08f, 14.08f);
        v12.curveToRelative(0.5f, 0.5f, 1.27f, 0.54f, 1.85f, 0.13f);
        v12.curveToRelative(0.94f, -0.66f, 2.01f, -1.06f, 3.1f, -1.22f);
        v12.lineToRelative(1.28f, -2.88f);
        v12.curveToRelative(-2.13f, -0.06f, -4.28f, 0.54f, -6.09f, 1.84f);
        v12.curveToRelative(-0.69f, 0.51f, -0.74f, 1.53f, -0.14f, 2.13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NetworkCheckKt._networkCheck = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

