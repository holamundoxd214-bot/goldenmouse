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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cellWifi", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CellWifi", "Landroidx/compose/material/icons/Icons$Outlined;", "getCellWifi", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CellWifiKt {
    private static ImageVector _cellWifi;

    static {
    }

    public static final ImageVector getCellWifi(Outlined arg19) {
        ImageVector v0 = CellWifiKt._cellWifi;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.CellWifi", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6f, 22f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(5.97f);
        v12.lineTo(6f, 22f);
        v12.close();
        v12.moveTo(20f, 20f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-7.22f);
        v12.lineToRelative(2f, -2f);
        v12.verticalLineTo(20f);
        v12.close();
        v12.moveTo(5.22f, 7.22f);
        v12.lineTo(3.93f, 5.93f);
        v12.curveToRelative(3.9f, -3.91f, 10.24f, -3.91f, 14.15f, 0f);
        v12.lineToRelative(-1.29f, 1.29f);
        v12.curveTo(13.6f, 4.03f, 8.41f, 4.03f, 5.22f, 7.22f);
        v12.close();
        v12.moveTo(12.93f, 11.07f);
        v12.lineTo(11f, 13f);
        v12.lineToRelative(-1.93f, -1.93f);
        v12.curveTo(10.14f, 10.01f, 11.86f, 10.01f, 12.93f, 11.07f);
        v12.close();
        v12.moveTo(14.22f, 9.79f);
        v12.curveToRelative(-1.78f, -1.77f, -4.66f, -1.77f, -6.43f, 0f);
        v12.lineTo(6.5f, 8.5f);
        v12.curveToRelative(2.48f, -2.48f, 6.52f, -2.48f, 9f, 0f);
        v12.lineTo(14.22f, 9.79f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CellWifiKt._cellWifi = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

