package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_spatialTracking", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SpatialTracking", "Landroidx/compose/material/icons/Icons$Filled;", "getSpatialTracking", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SpatialTrackingKt {
    private static ImageVector _spatialTracking;

    static {
    }

    public static final ImageVector getSpatialTracking(Filled arg20) {
        ImageVector v0 = SpatialTrackingKt._spatialTracking;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SpatialTracking", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 9f);
        v12.moveToRelative(-4f, 0f);
        v12.arcToRelative(4f, 4f, 0f, true, true, 8f, 0f);
        v12.arcToRelative(4f, 4f, 0f, true, true, -8f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(16.389999f, 15.56f);
        v12.curveTo(14.71f, 14.7f, 12.53f, 14f, 10f, 14f);
        v12.curveToRelative(-2.53f, 0f, -4.71f, 0.7f, -6.39f, 1.56f);
        v12.curveTo(2.61f, 16.07f, 2f, 17.1f, 2f, 18.219999f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-2.78f);
        v12.curveTo(18f, 17.1f, 17.389999f, 16.07f, 16.389999f, 15.56f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.049999f, 2.41f);
        v12.lineTo(18.639999f, 1f);
        v12.curveToRelative(-3.51f, 3.51f, -3.51f, 9.21f, 0f, 12.73f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.curveTo(17.32f, 9.58f, 17.32f, 5.14f, 20.049999f, 2.41f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(22.879999f, 5.24f);
        v12.lineToRelative(-1.41f, -1.41f);
        v12.curveToRelative(-1.95f, 1.95f, -1.95f, 5.12f, 0f, 7.07f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.curveTo(21.709999f, 8.32f, 21.709999f, 6.41f, 22.879999f, 5.24f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SpatialTrackingKt._spatialTracking = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

