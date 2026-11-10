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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_icecream", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Icecream", "Landroidx/compose/material/icons/Icons$Outlined;", "getIcecream", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class IcecreamKt {
    private static ImageVector _icecream;

    static {
    }

    public static final ImageVector getIcecream(Outlined arg19) {
        ImageVector v0 = IcecreamKt._icecream;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Icecream", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.379999f, 6.24f);
        v12.curveTo(17.790001f, 3.24f, 15.14f, 1f, 12f, 1f);
        v12.reflectiveCurveTo(6.21f, 3.24f, 5.62f, 6.24f);
        v12.curveTo(4.08f, 6.81f, 3f, 8.29f, 3f, 10f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.curveToRelative(0.12f, 0f, 0.23f, -0.02f, 0.34f, -0.02f);
        v12.lineTo(12.07f, 23f);
        v12.lineToRelative(4.61f, -9.03f);
        v12.curveTo(16.790001f, 13.98f, 16.889999f, 14f, 17f, 14f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.curveTo(21f, 8.29f, 19.92f, 6.81f, 18.379999f, 6.24f);
        v12.close();
        v12.moveTo(12.05f, 18.629999f);
        v12.lineToRelative(-2.73f, -5.21f);
        v12.curveTo(10.15f, 13.79f, 11.06f, 14f, 12f, 14f);
        v12.curveToRelative(0.95f, 0f, 1.88f, -0.21f, 2.72f, -0.6f);
        v12.lineTo(12.05f, 18.629999f);
        v12.close();
        v12.moveTo(17f, 12f);
        v12.curveToRelative(-0.52f, 0f, -1.01f, -0.2f, -1.39f, -0.56f);
        v12.lineToRelative(-0.56f, -0.54f);
        v12.lineToRelative(-0.66f, 0.42f);
        v12.curveTo(13.68f, 11.76f, 12.86f, 12f, 12f, 12f);
        v12.reflectiveCurveToRelative(-1.68f, -0.24f, -2.39f, -0.69f);
        v12.lineTo(8.95f, 10.9f);
        v12.lineToRelative(-0.56f, 0.54f);
        v12.curveTo(8.01f, 11.79f, 7.52f, 12f, 7f, 12f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.89f, -2f, -2f);
        v12.curveToRelative(0f, -0.98f, 0.72f, -1.82f, 1.68f, -1.97f);
        v12.lineTo(7.45f, 7.9f);
        v12.lineToRelative(0.06f, -0.78f);
        v12.curveTo(7.71f, 4.8f, 9.66f, 3f, 12f, 3f);
        v12.reflectiveCurveToRelative(4.29f, 1.8f, 4.48f, 4.12f);
        v12.lineToRelative(0.06f, 0.78f);
        v12.lineToRelative(0.77f, 0.12f);
        v12.curveTo(18.280001f, 8.18f, 19f, 9.01f, 19f, 10f);
        v12.curveTo(19f, 11.1f, 18.1f, 12f, 17f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        IcecreamKt._icecream = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

