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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_smokingRooms", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SmokingRooms", "Landroidx/compose/material/icons/Icons$Filled;", "getSmokingRooms", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SmokingRoomsKt {
    private static ImageVector _smokingRooms;

    static {
    }

    public static final ImageVector getSmokingRooms(Filled arg19) {
        ImageVector v0 = SmokingRoomsKt._smokingRooms;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SmokingRooms", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2f, 16f);
        v12.horizontalLineToRelative(15f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(2f, 19f);
        v12.close();
        v12.moveTo(20.5f, 16f);
        v12.lineTo(22f, 16f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-1.5f);
        v12.close();
        v12.moveTo(18f, 16f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(18f, 19f);
        v12.close();
        v12.moveTo(18.85f, 7.73f);
        v12.curveToRelative(0.62f, -0.61f, 1f, -1.45f, 1f, -2.38f);
        v12.curveTo(19.85f, 3.5f, 18.35f, 2f, 16.5f, 2f);
        v12.verticalLineToRelative(1.5f);
        v12.curveToRelative(1.02f, 0f, 1.85f, 0.83f, 1.85f, 1.85f);
        v12.reflectiveCurveTo(17.52f, 7.2f, 16.5f, 7.2f);
        v12.verticalLineToRelative(1.5f);
        v12.curveToRelative(2.24f, 0f, 4f, 1.83f, 4f, 4.07f);
        v12.lineTo(20.5f, 15f);
        v12.lineTo(22f, 15f);
        v12.verticalLineToRelative(-2.24f);
        v12.curveToRelative(0f, -2.22f, -1.28f, -4.14f, -3.15f, -5.03f);
        v12.close();
        v12.moveTo(16.030001f, 10.2f);
        v12.lineTo(14.5f, 10.2f);
        v12.curveToRelative(-1.02f, 0f, -1.85f, -0.98f, -1.85f, -2f);
        v12.reflectiveCurveToRelative(0.83f, -1.75f, 1.85f, -1.75f);
        v12.verticalLineToRelative(-1.5f);
        v12.curveToRelative(-1.85f, 0f, -3.35f, 1.5f, -3.35f, 3.35f);
        v12.reflectiveCurveToRelative(1.5f, 3.35f, 3.35f, 3.35f);
        v12.horizontalLineToRelative(1.53f);
        v12.curveToRelative(1.05f, 0f, 1.97f, 0.74f, 1.97f, 2.05f);
        v12.lineTo(18f, 15f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(-1.64f);
        v12.curveToRelative(0f, -1.81f, -1.6f, -3.16f, -3.47f, -3.16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SmokingRoomsKt._smokingRooms = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

