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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_roomPreferences", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RoomPreferences", "Landroidx/compose/material/icons/Icons$TwoTone;", "getRoomPreferences", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class RoomPreferencesKt {
    private static ImageVector _roomPreferences;

    static {
    }

    public static final ImageVector getRoomPreferences(TwoTone arg19) {
        ImageVector v0 = RoomPreferencesKt._roomPreferences;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.RoomPreferences", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 12.11f);
        v12.verticalLineTo(5f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(4.29f);
        v12.curveTo(11.1f, 18.370001f, 11f, 17.700001f, 11f, 17f);
        v12.curveTo(11f, 15.09f, 11.76f, 13.37f, 13f, 12.11f);
        v12.close();
        v12.moveTo(10f, 11f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(11f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 13f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(13f);
        v12.close();
        v12.moveTo(7f, 19f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(7.11f);
        v12.curveToRelative(0.57f, -0.59f, 1.25f, -1.07f, 2f, -1.42f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(1f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(16f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(9.26f);
        v12.curveToRelative(-0.42f, -0.6f, -0.75f, -1.28f, -0.97f, -2f);
        v12.horizontalLineTo(7f);
        v12.close();
        v12.moveTo(21.690001f, 17.629999f);
        v12.lineToRelative(1.14f, 1f);
        v12.lineToRelative(-1f, 1.73f);
        v12.lineToRelative(-1.45f, -0.49f);
        v12.curveToRelative(-0.32f, 0.27f, -0.68f, 0.48f, -1.08f, 0.63f);
        v12.lineTo(19f, 22f);
        v12.horizontalLineToRelative(-2f);
        v12.lineToRelative(-0.3f, -1.49f);
        v12.curveToRelative(-0.4f, -0.15f, -0.76f, -0.36f, -1.08f, -0.63f);
        v12.lineToRelative(-1.45f, 0.49f);
        v12.lineToRelative(-1f, -1.73f);
        v12.lineToRelative(1.14f, -1f);
        v12.curveToRelative(-0.08f, -0.5f, -0.08f, -0.76f, 0f, -1.26f);
        v12.lineToRelative(-1.14f, -1f);
        v12.lineToRelative(1f, -1.73f);
        v12.lineToRelative(1.45f, 0.49f);
        v12.curveToRelative(0.32f, -0.27f, 0.68f, -0.48f, 1.08f, -0.63f);
        v12.lineTo(17f, 12f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(0.3f, 1.49f);
        v12.curveToRelative(0.4f, 0.15f, 0.76f, 0.36f, 1.08f, 0.63f);
        v12.lineToRelative(1.45f, -0.49f);
        v12.lineToRelative(1f, 1.73f);
        v12.lineToRelative(-1.14f, 1f);
        v12.curveTo(21.77f, 16.870001f, 21.77f, 17.129999f, 21.690001f, 17.629999f);
        v12.close();
        v12.moveTo(20f, 17f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.reflectiveCurveTo(20f, 18.1f, 20f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        RoomPreferencesKt._roomPreferences = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

