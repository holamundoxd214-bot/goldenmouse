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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_zoomOut", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ZoomOut", "Landroidx/compose/material/icons/Icons$Outlined;", "getZoomOut", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ZoomOutKt {
    private static ImageVector _zoomOut;

    static {
    }

    public static final ImageVector getZoomOut(Outlined arg19) {
        ImageVector v0 = ZoomOutKt._zoomOut;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.ZoomOut", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 14f);
        v12.horizontalLineToRelative(-0.79f);
        v12.lineToRelative(-0.28f, -0.27f);
        v12.curveTo(15.41f, 12.59f, 16f, 11.11f, 16f, 9.5f);
        v12.curveTo(16f, 5.91f, 13.09f, 3f, 9.5f, 3f);
        v12.reflectiveCurveTo(3f, 5.91f, 3f, 9.5f);
        v12.reflectiveCurveTo(5.91f, 16f, 9.5f, 16f);
        v12.curveToRelative(1.61f, 0f, 3.09f, -0.59f, 4.23f, -1.57f);
        v12.lineToRelative(0.27f, 0.28f);
        v12.verticalLineToRelative(0.79f);
        v12.lineToRelative(5f, 4.99f);
        v12.lineTo(20.49f, 19f);
        v12.lineToRelative(-4.99f, -5f);
        v12.close();
        v12.moveTo(9.5f, 14f);
        v12.curveTo(7.01f, 14f, 5f, 11.99f, 5f, 9.5f);
        v12.reflectiveCurveTo(7.01f, 5f, 9.5f, 5f);
        v12.reflectiveCurveTo(14f, 7.01f, 14f, 9.5f);
        v12.reflectiveCurveTo(11.99f, 14f, 9.5f, 14f);
        v12.close();
        v12.moveTo(7f, 9f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(1f);
        v12.lineTo(7f, 10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ZoomOutKt._zoomOut = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

