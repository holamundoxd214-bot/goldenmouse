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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cellWifi", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CellWifi", "Landroidx/compose/material/icons/Icons$Rounded;", "getCellWifi", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CellWifiKt {
    private static ImageVector _cellWifi;

    static {
    }

    public static final ImageVector getCellWifi(Rounded arg19) {
        ImageVector v0 = CellWifiKt._cellWifi;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.CellWifi", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.290001f, 7.68f);
        v12.lineTo(7.7f, 20.290001f);
        v12.curveTo(7.07f, 20.92f, 7.52f, 22f, 8.41f, 22f);
        v12.horizontalLineTo(21f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(8.39f);
        v12.curveTo(22f, 7.5f, 20.92f, 7.05f, 20.290001f, 7.68f);
        v12.close();
        v12.moveTo(20f, 20f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-7.22f);
        v12.lineToRelative(2f, -2f);
        v12.verticalLineTo(20f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9.61f, 10.68f);
        v12.curveToRelative(-0.28f, 0.17f, -0.32f, 0.56f, -0.09f, 0.79f);
        v12.lineToRelative(0.82f, 0.82f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0.82f, -0.82f);
        v12.curveToRelative(0.23f, -0.23f, 0.18f, -0.62f, -0.09f, -0.79f);
        v12.curveTo(11.61f, 10.14f, 10.49f, 10.14f, 9.61f, 10.68f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(8.42f, 9.3f);
        v12.curveToRelative(1.57f, -1.12f, 3.7f, -1.12f, 5.27f, 0f);
        v12.curveToRelative(0.36f, 0.26f, 0.85f, 0.22f, 1.16f, -0.1f);
        v12.curveToRelative(0.39f, -0.39f, 0.35f, -1.06f, -0.1f, -1.38f);
        v12.curveToRelative(-2.2f, -1.57f, -5.19f, -1.57f, -7.4f, 0f);
        v12.curveTo(6.9f, 8.14f, 6.85f, 8.81f, 7.25f, 9.2f);
        v12.curveTo(7.57f, 9.52f, 8.06f, 9.56f, 8.42f, 9.3f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.26f, 6.69f);
        v12.curveToRelative(0.34f, 0.28f, 0.83f, 0.28f, 1.14f, -0.03f);
        v12.lineToRelative(0.12f, -0.12f);
        v12.curveToRelative(0.35f, -0.35f, 0.31f, -0.92f, -0.08f, -1.24f);
        v12.curveToRelative(-3.67f, -3.05f, -9.02f, -3.07f, -12.7f, -0.06f);
        v12.curveTo(4.31f, 5.59f, 4.27f, 6.23f, 4.66f, 6.61f);
        v12.curveTo(4.98f, 6.94f, 5.5f, 6.98f, 5.85f, 6.69f);
        v12.curveTo(8.86f, 4.21f, 13.25f, 4.21f, 16.26f, 6.69f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CellWifiKt._cellWifi = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

