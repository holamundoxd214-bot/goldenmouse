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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_broadcastOnPersonal", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BroadcastOnPersonal", "Landroidx/compose/material/icons/Icons$Rounded;", "getBroadcastOnPersonal", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BroadcastOnPersonalKt {
    private static ImageVector _broadcastOnPersonal;

    static {
    }

    public static final ImageVector getBroadcastOnPersonal(Rounded arg19) {
        ImageVector v0 = BroadcastOnPersonalKt._broadcastOnPersonal;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.BroadcastOnPersonal", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17f, 8f);
        v12.curveToRelative(0.7f, 0f, 1.38f, 0.1f, 2.02f, 0.27f);
        v12.lineTo(12f, 3f);
        v12.lineTo(4f, 9f);
        v12.verticalLineToRelative(12f);
        v12.horizontalLineToRelative(6.76f);
        v12.curveTo(9.66f, 19.629999f, 9f, 17.889999f, 9f, 16f);
        v12.curveTo(9f, 11.58f, 12.58f, 8f, 17f, 8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 14.75f);
        v12.curveToRelative(-0.69f, 0f, -1.25f, 0.56f, -1.25f, 1.25f);
        v12.curveToRelative(0f, 0.4f, 0.2f, 0.75f, 0.5f, 0.97f);
        v12.verticalLineTo(22f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(-5.03f);
        v12.curveToRelative(0.3f, -0.23f, 0.5f, -0.57f, 0.5f, -0.97f);
        v12.curveTo(18.25f, 15.31f, 17.690001f, 14.75f, 17f, 14.75f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 12f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.curveToRelative(0f, 1.1f, 0.45f, 2.1f, 1.17f, 2.83f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.curveToRelative(-0.45f, -0.45f, -0.73f, -1.08f, -0.73f, -1.77f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        v12.curveToRelative(0f, 0.69f, -0.28f, 1.31f, -0.73f, 1.76f);
        v12.lineToRelative(1.06f, 1.06f);
        v12.curveTo(20.549999f, 18.1f, 21f, 17.1f, 21f, 16f);
        v12.curveTo(21f, 13.79f, 19.209999f, 12f, 17f, 12f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17f, 9.5f);
        v12.curveToRelative(-3.59f, 0f, -6.5f, 2.91f, -6.5f, 6.5f);
        v12.curveToRelative(0f, 1.79f, 0.73f, 3.42f, 1.9f, 4.6f);
        v12.lineToRelative(1.06f, -1.06f);
        v12.curveTo(12.56f, 18.629999f, 12f, 17.379999f, 12f, 16f);
        v12.curveToRelative(0f, -2.76f, 2.24f, -5f, 5f, -5f);
        v12.reflectiveCurveToRelative(5f, 2.24f, 5f, 5f);
        v12.curveToRelative(0f, 1.37f, -0.56f, 2.62f, -1.46f, 3.52f);
        v12.lineToRelative(1.07f, 1.06f);
        v12.curveToRelative(1.17f, -1.18f, 1.89f, -2.8f, 1.89f, -4.58f);
        v12.curveTo(23.5f, 12.41f, 20.59f, 9.5f, 17f, 9.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BroadcastOnPersonalKt._broadcastOnPersonal = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

