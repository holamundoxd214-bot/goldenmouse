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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_connectedTv", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ConnectedTv", "Landroidx/compose/material/icons/Icons$Rounded;", "getConnectedTv", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ConnectedTvKt {
    private static ImageVector _connectedTv;

    static {
    }

    public static final ImageVector getConnectedTv(Rounded arg19) {
        ImageVector v0 = ConnectedTvKt._connectedTv;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ConnectedTv", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 3f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 3f, 2f, 3.9f, 2f, 5f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(1.1f, 0f, 1.99f, -0.9f, 1.99f, -2f);
        v12.lineTo(22f, 5f);
        v12.curveTo(22f, 3.9f, 21.1f, 3f, 20f, 3f);
        v12.close();
        v12.moveTo(20f, 17f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(17f);
        v12.close();
        v12.moveTo(7f, 15.97f);
        v12.curveTo(6.98f, 14.89f, 6.11f, 14.02f, 5.03f, 14f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(15.97f);
        v12.close();
        v12.moveTo(5.62f, 12.55f);
        v12.curveToRelative(1.44f, 0.26f, 2.58f, 1.4f, 2.83f, 2.84f);
        v12.curveTo(8.51f, 15.75f, 8.82f, 16f, 9.18f, 16f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.46f, 0f, 0.82f, -0.41f, 0.75f, -0.86f);
        v12.curveToRelative(-0.36f, -2.07f, -1.99f, -3.7f, -4.06f, -4.06f);
        v12.curveTo(5.41f, 11f, 5f, 11.36f, 5f, 11.82f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(5f, 12.19f, 5.26f, 12.49f, 5.62f, 12.55f);
        v12.close();
        v12.moveTo(5.64f, 9.53f);
        v12.curveToRelative(3.07f, 0.3f, 5.52f, 2.75f, 5.83f, 5.82f);
        v12.curveToRelative(0.04f, 0.37f, 0.37f, 0.65f, 0.74f, 0.65f);
        v12.curveToRelative(0.45f, 0f, 0.79f, -0.4f, 0.75f, -0.85f);
        v12.curveToRelative(-0.4f, -3.74f, -3.37f, -6.71f, -7.11f, -7.1f);
        v12.curveTo(5.4f, 8f, 5f, 8.34f, 5f, 8.79f);
        v12.curveTo(5f, 9.16f, 5.27f, 9.5f, 5.64f, 9.53f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ConnectedTvKt._connectedTv = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

