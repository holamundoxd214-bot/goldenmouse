package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_networkLocked", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NetworkLocked", "Landroidx/compose/material/icons/Icons$Sharp;", "getNetworkLocked", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NetworkLockedKt {
    private static ImageVector _networkLocked;

    static {
    }

    public static final ImageVector getNetworkLocked(Sharp arg19) {
        ImageVector v0 = NetworkLockedKt._networkLocked;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.NetworkLocked", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 16f);
        v12.verticalLineToRelative(-0.36f);
        v12.curveToRelative(0f, -1.31f, -0.94f, -2.5f, -2.24f, -2.63f);
        v12.curveToRelative(-1.5f, -0.15f, -2.76f, 1.02f, -2.76f, 2.49f);
        v12.verticalLineToRelative(0.5f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(7f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(-1f);
        v12.close();
        v12.moveTo(21f, 16f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveToRelative(0f, -0.83f, 0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.verticalLineToRelative(0.5f);
        v12.close();
        v12.moveTo(19.5f, 11f);
        v12.curveToRelative(0.15f, 0f, 0.3f, 0.01f, 0.46f, 0.02f);
        v12.curveToRelative(0.01f, 0f, 0.03f, 0.01f, 0.04f, 0.01f);
        v12.lineTo(20f, 1f);
        v12.lineTo(1f, 20f);
        v12.horizontalLineToRelative(13f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(1.26f);
        v12.curveToRelative(0.22f, -0.63f, 0.58f, -1.2f, 1.06f, -1.68f);
        v12.curveToRelative(0.85f, -0.85f, 1.98f, -1.32f, 3.18f, -1.32f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NetworkLockedKt._networkLocked = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

