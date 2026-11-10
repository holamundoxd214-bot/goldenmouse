package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_vapingRooms", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VapingRooms", "Landroidx/compose/material/icons/Icons$TwoTone;", "getVapingRooms", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VapingRoomsKt {
    private static ImageVector _vapingRooms;

    static {
    }

    public static final ImageVector getVapingRooms(TwoTone arg20) {
        ImageVector v0 = VapingRoomsKt._vapingRooms;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.VapingRooms", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.5f, 17.5f);
        v12.moveToRelative(-0.5f, 0f);
        v12.arcToRelative(0.5f, 0.5f, 0f, true, true, 1f, 0f);
        v12.arcToRelative(0.5f, 0.5f, 0f, true, true, -1f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2f, 16.5f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(1.33f, 0f, 2.71f, -0.18f, 4f, -0.5f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(-1.29f, -0.32f, -2.67f, -0.5f, -4f, -0.5f);
        v12.horizontalLineTo(2f);
        v12.verticalLineTo(16.5f);
        v12.close();
        v12.moveTo(22f, 16f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineTo(22f);
        v12.close();
        v12.moveTo(11f, 17.5f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.reflectiveCurveTo(10f, 17.219999f, 10f, 17.5f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.reflectiveCurveTo(11f, 17.780001f, 11f, 17.5f);
        v12.close();
        v12.moveTo(22f, 12.76f);
        v12.verticalLineTo(15f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineToRelative(-2.23f);
        v12.curveToRelative(0f, -2.24f, -1.76f, -4.07f, -4f, -4.07f);
        v12.verticalLineTo(7.2f);
        v12.curveToRelative(1.02f, 0f, 1.85f, -0.83f, 1.85f, -1.85f);
        v12.reflectiveCurveTo(17.52f, 3.5f, 16.5f, 3.5f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(1.85f, 0f, 3.35f, 1.5f, 3.35f, 3.35f);
        v12.curveToRelative(0f, 0.93f, -0.38f, 1.77f, -1f, 2.38f);
        v12.curveTo(20.719999f, 8.62f, 22f, 10.54f, 22f, 12.76f);
        v12.close();
        v12.moveTo(19.5f, 13.36f);
        v12.verticalLineTo(15f);
        v12.horizontalLineTo(18f);
        v12.verticalLineToRelative(-1.3f);
        v12.curveToRelative(0f, -1.31f, -0.92f, -2.05f, -1.97f, -2.05f);
        v12.horizontalLineTo(14.5f);
        v12.curveToRelative(-1.85f, 0f, -3.35f, -1.5f, -3.35f, -3.35f);
        v12.reflectiveCurveToRelative(1.5f, -3.35f, 3.35f, -3.35f);
        v12.verticalLineToRelative(1.5f);
        v12.curveToRelative(-1.02f, 0f, -1.85f, 0.73f, -1.85f, 1.75f);
        v12.reflectiveCurveToRelative(0.83f, 2f, 1.85f, 2f);
        v12.horizontalLineToRelative(1.53f);
        v12.curveTo(17.9f, 10.2f, 19.5f, 11.55f, 19.5f, 13.36f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VapingRoomsKt._vapingRooms = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

