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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wbAuto", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WbAuto", "Landroidx/compose/material/icons/Icons$Rounded;", "getWbAuto", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WbAutoKt {
    private static ImageVector _wbAuto;

    static {
    }

    public static final ImageVector getWbAuto(Rounded arg19) {
        ImageVector v0 = WbAutoKt._wbAuto;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WbAuto", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.85f, 12.65f);
        v12.horizontalLineToRelative(2.3f);
        v12.lineTo(8f, 9f);
        v12.close();
        v12.moveTo(22.719999f, 7f);
        v12.curveToRelative(-0.42f, 0f, -0.77f, 0.3f, -0.85f, 0.7f);
        v12.lineToRelative(-1.07f, 5.59f);
        v12.lineToRelative(-1.31f, -5.51f);
        v12.curveToRelative(-0.11f, -0.46f, -0.52f, -0.78f, -0.99f, -0.78f);
        v12.reflectiveCurveToRelative(-0.88f, 0.32f, -0.98f, 0.78f);
        v12.lineToRelative(-1.31f, 5.51f);
        v12.lineToRelative(-1.07f, -5.59f);
        v12.curveToRelative(-0.08f, -0.4f, -0.44f, -0.7f, -0.85f, -0.7f);
        v12.curveToRelative(-0.01f, 0f, -0.03f, 0.01f, -0.04f, 0.01f);
        v12.curveTo(12.78f, 5.18f, 10.53f, 4f, 8f, 4f);
        v12.curveToRelative(-4.42f, 0f, -8f, 3.58f, -8f, 8f);
        v12.reflectiveCurveToRelative(3.58f, 8f, 8f, 8f);
        v12.curveToRelative(3.17f, 0f, 5.9f, -1.85f, 7.2f, -4.52f);
        v12.curveToRelative(0.2f, 0.32f, 0.55f, 0.52f, 0.94f, 0.52f);
        v12.curveToRelative(0.51f, 0f, 0.95f, -0.35f, 1.07f, -0.84f);
        v12.lineTo(18.5f, 9.9f);
        v12.lineToRelative(1.29f, 5.26f);
        v12.curveToRelative(0.12f, 0.49f, 0.57f, 0.84f, 1.07f, 0.84f);
        v12.curveToRelative(0.52f, 0f, 0.96f, -0.36f, 1.08f, -0.86f);
        v12.lineToRelative(1.61f, -7.08f);
        v12.curveToRelative(0.13f, -0.54f, -0.28f, -1.06f, -0.83f, -1.06f);
        v12.close();
        v12.moveTo(10.93f, 16f);
        v12.curveToRelative(-0.38f, 0f, -0.72f, -0.24f, -0.84f, -0.6f);
        v12.lineTo(9.6f, 14f);
        v12.lineTo(6.4f, 14f);
        v12.lineToRelative(-0.49f, 1.4f);
        v12.curveToRelative(-0.13f, 0.36f, -0.46f, 0.6f, -0.84f, 0.6f);
        v12.curveToRelative(-0.62f, 0f, -1.05f, -0.61f, -0.84f, -1.19f);
        v12.lineToRelative(2.44f, -6.86f);
        v12.curveTo(6.87f, 7.38f, 7.4f, 7f, 8f, 7f);
        v12.reflectiveCurveToRelative(1.13f, 0.38f, 1.34f, 0.94f);
        v12.lineToRelative(2.44f, 6.86f);
        v12.curveToRelative(0.2f, 0.59f, -0.23f, 1.2f, -0.85f, 1.2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WbAutoKt._wbAuto = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

