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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_alarmAdd", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AlarmAdd", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAlarmAdd", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AlarmAddKt {
    private static ImageVector _alarmAdd;

    static {
    }

    public static final ImageVector getAlarmAdd(TwoTone arg19) {
        ImageVector v0 = AlarmAddKt._alarmAdd;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.AlarmAdd", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(-3.86f, 0f, -7f, 3.14f, -7f, 7f);
        v12.reflectiveCurveToRelative(3.14f, 7f, 7f, 7f);
        v12.reflectiveCurveToRelative(7f, -3.14f, 7f, -7f);
        v12.reflectiveCurveToRelative(-3.14f, -7f, -7f, -7f);
        v12.close();
        v12.moveTo(16f, 14f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-3f);
        v12.lineTo(8f, 14f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(3f);
        v12.lineTo(11f, 9f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(2f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(17.337f, 1.81f);
        v12.lineToRelative(4.607f, 3.845f);
        v12.lineToRelative(-1.28f, 1.535f);
        v12.lineToRelative(-4.61f, -3.843f);
        v12.close();
        v12.moveTo(6.663f, 1.81f);
        v12.lineToRelative(1.282f, 1.536f);
        v12.lineTo(3.337f, 7.19f);
        v12.lineToRelative(-1.28f, -1.536f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.reflectiveCurveToRelative(4.03f, 9f, 9f, 9f);
        v12.reflectiveCurveToRelative(9f, -4.03f, 9f, -9f);
        v12.reflectiveCurveToRelative(-4.03f, -9f, -9f, -9f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-3.86f, 0f, -7f, -3.14f, -7f, -7f);
        v12.reflectiveCurveToRelative(3.14f, -7f, 7f, -7f);
        v12.reflectiveCurveToRelative(7f, 3.14f, 7f, 7f);
        v12.reflectiveCurveToRelative(-3.14f, 7f, -7f, 7f);
        v12.close();
        v12.moveTo(13f, 9f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(3f);
        v12.lineTo(8f, 12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AlarmAddKt._alarmAdd = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

