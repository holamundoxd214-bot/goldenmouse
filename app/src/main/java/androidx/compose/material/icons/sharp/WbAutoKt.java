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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wbAuto", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WbAuto", "Landroidx/compose/material/icons/Icons$Sharp;", "getWbAuto", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WbAutoKt {
    private static ImageVector _wbAuto;

    static {
    }

    public static final ImageVector getWbAuto(Sharp arg19) {
        ImageVector v0 = WbAutoKt._wbAuto;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.WbAuto", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.85f, 12.65f);
        v12.horizontalLineToRelative(2.3f);
        v12.lineTo(8f, 9f);
        v12.lineToRelative(-1.15f, 3.65f);
        v12.close();
        v12.moveTo(22f, 7f);
        v12.lineToRelative(-1.2f, 6.29f);
        v12.lineTo(19.299999f, 7f);
        v12.horizontalLineToRelative(-1.6f);
        v12.lineToRelative(-1.49f, 6.29f);
        v12.lineTo(15f, 7f);
        v12.horizontalLineToRelative(-0.76f);
        v12.curveTo(12.77f, 5.17f, 10.53f, 4f, 8f, 4f);
        v12.curveToRelative(-4.42f, 0f, -8f, 3.58f, -8f, 8f);
        v12.reflectiveCurveToRelative(3.58f, 8f, 8f, 8f);
        v12.curveToRelative(3.13f, 0f, 5.84f, -1.81f, 7.15f, -4.43f);
        v12.lineToRelative(0.1f, 0.43f);
        v12.lineTo(17f, 16f);
        v12.lineToRelative(1.5f, -6.1f);
        v12.lineTo(20f, 16f);
        v12.horizontalLineToRelative(1.75f);
        v12.lineToRelative(2.05f, -9f);
        v12.lineTo(22f, 7f);
        v12.close();
        v12.moveTo(10.3f, 16f);
        v12.lineToRelative(-0.7f, -2f);
        v12.lineTo(6.4f, 14f);
        v12.lineToRelative(-0.7f, 2f);
        v12.lineTo(3.8f, 16f);
        v12.lineTo(7f, 7f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(3.2f, 9f);
        v12.horizontalLineToRelative(-1.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WbAutoKt._wbAuto = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

