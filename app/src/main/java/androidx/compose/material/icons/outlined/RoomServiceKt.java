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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_roomService", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RoomService", "Landroidx/compose/material/icons/Icons$Outlined;", "getRoomService", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RoomServiceKt {
    private static ImageVector _roomService;

    static {
    }

    public static final ImageVector getRoomService(Outlined arg19) {
        ImageVector v0 = RoomServiceKt._roomService;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.RoomService", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18.98f, 17f);
        v12.lineTo(2f, 17f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(20f);
        v12.verticalLineToRelative(-2f);
        v12.close();
        v12.moveTo(21f, 16f);
        v12.curveToRelative(-0.27f, -4.07f, -3.25f, -7.4f, -7.16f, -8.21f);
        v12.curveToRelative(0.1f, -0.24f, 0.16f, -0.51f, 0.16f, -0.79f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.curveToRelative(0f, 0.28f, 0.06f, 0.55f, 0.16f, 0.79f);
        v12.curveTo(6.25f, 8.6f, 3.27f, 11.93f, 3f, 16f);
        v12.horizontalLineToRelative(18f);
        v12.close();
        v12.moveTo(12f, 9.58f);
        v12.curveToRelative(2.95f, 0f, 5.47f, 1.83f, 6.5f, 4.41f);
        v12.horizontalLineToRelative(-13f);
        v12.curveToRelative(1.03f, -2.58f, 3.55f, -4.41f, 6.5f, -4.41f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RoomServiceKt._roomService = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

