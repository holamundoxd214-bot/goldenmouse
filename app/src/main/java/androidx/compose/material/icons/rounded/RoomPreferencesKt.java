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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_roomPreferences", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RoomPreferences", "Landroidx/compose/material/icons/Icons$Rounded;", "getRoomPreferences", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RoomPreferencesKt {
    private static ImageVector _roomPreferences;

    static {
    }

    public static final ImageVector getRoomPreferences(Rounded arg19) {
        ImageVector v0 = RoomPreferencesKt._roomPreferences;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.RoomPreferences", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.75f, 17f);
        v12.curveToRelative(0f, -0.22f, -0.03f, -0.42f, -0.06f, -0.63f);
        v12.lineToRelative(0.84f, -0.73f);
        v12.curveToRelative(0.18f, -0.16f, 0.22f, -0.42f, 0.1f, -0.63f);
        v12.lineToRelative(-0.59f, -1.02f);
        v12.curveToRelative(-0.12f, -0.21f, -0.37f, -0.3f, -0.59f, -0.22f);
        v12.lineToRelative(-1.06f, 0.36f);
        v12.curveToRelative(-0.32f, -0.27f, -0.68f, -0.48f, -1.08f, -0.63f);
        v12.lineToRelative(-0.22f, -1.09f);
        v12.curveToRelative(-0.05f, -0.23f, -0.25f, -0.4f, -0.49f, -0.4f);
        v12.horizontalLineToRelative(-1.18f);
        v12.curveToRelative(-0.24f, 0f, -0.44f, 0.17f, -0.49f, 0.4f);
        v12.lineToRelative(-0.22f, 1.09f);
        v12.curveToRelative(-0.4f, 0.15f, -0.76f, 0.36f, -1.08f, 0.63f);
        v12.lineToRelative(-1.06f, -0.36f);
        v12.curveToRelative(-0.23f, -0.08f, -0.47f, 0.02f, -0.59f, 0.22f);
        v12.lineToRelative(-0.59f, 1.02f);
        v12.curveToRelative(-0.12f, 0.21f, -0.08f, 0.47f, 0.1f, 0.63f);
        v12.lineToRelative(0.84f, 0.73f);
        v12.curveToRelative(-0.03f, 0.21f, -0.06f, 0.41f, -0.06f, 0.63f);
        v12.reflectiveCurveToRelative(0.03f, 0.42f, 0.06f, 0.63f);
        v12.lineToRelative(-0.84f, 0.73f);
        v12.curveToRelative(-0.18f, 0.16f, -0.22f, 0.42f, -0.1f, 0.63f);
        v12.lineToRelative(0.59f, 1.02f);
        v12.curveToRelative(0.12f, 0.21f, 0.37f, 0.3f, 0.59f, 0.22f);
        v12.lineToRelative(1.06f, -0.36f);
        v12.curveToRelative(0.32f, 0.27f, 0.68f, 0.48f, 1.08f, 0.63f);
        v12.lineToRelative(0.22f, 1.09f);
        v12.curveToRelative(0.05f, 0.23f, 0.25f, 0.4f, 0.49f, 0.4f);
        v12.horizontalLineToRelative(1.18f);
        v12.curveToRelative(0.24f, 0f, 0.44f, -0.17f, 0.49f, -0.4f);
        v12.lineToRelative(0.22f, -1.09f);
        v12.curveToRelative(0.4f, -0.15f, 0.76f, -0.36f, 1.08f, -0.63f);
        v12.lineToRelative(1.06f, 0.36f);
        v12.curveToRelative(0.23f, 0.08f, 0.47f, -0.02f, 0.59f, -0.22f);
        v12.lineToRelative(0.59f, -1.02f);
        v12.curveToRelative(0.12f, -0.21f, 0.08f, -0.47f, -0.1f, -0.63f);
        v12.lineToRelative(-0.84f, -0.73f);
        v12.curveTo(21.719999f, 17.42f, 21.75f, 17.219999f, 21.75f, 17f);
        v12.close();
        v12.moveTo(18f, 19f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.reflectiveCurveToRelative(0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveTo(19.1f, 19f, 18f, 19f);
        v12.close();
        v12.moveTo(14f, 11.26f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(5f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(6f);
        v12.curveTo(5.45f, 3f, 5f, 3.45f, 5f, 4f);
        v12.verticalLineToRelative(15f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(8.26f);
        v12.curveTo(11.47f, 19.870001f, 11f, 18.49f, 11f, 17f);
        v12.curveTo(11f, 14.62f, 12.19f, 12.53f, 14f, 11.26f);
        v12.close();
        v12.moveTo(10f, 12f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveTo(10f, 12.55f, 10f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RoomPreferencesKt._roomPreferences = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

