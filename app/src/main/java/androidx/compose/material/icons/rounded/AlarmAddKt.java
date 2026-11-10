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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_alarmAdd", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AlarmAdd", "Landroidx/compose/material/icons/Icons$Rounded;", "getAlarmAdd", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AlarmAddKt {
    private static ImageVector _alarmAdd;

    static {
    }

    public static final ImageVector getAlarmAdd(Rounded arg19) {
        ImageVector v0 = AlarmAddKt._alarmAdd;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AlarmAdd", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.18f, 5.01f);
        v12.lineTo(18.1f, 2.45f);
        v12.curveToRelative(-0.42f, -0.35f, -1.05f, -0.3f, -1.41f, 0.13f);
        v12.curveToRelative(-0.35f, 0.42f, -0.29f, 1.05f, 0.13f, 1.41f);
        v12.lineToRelative(3.07f, 2.56f);
        v12.curveToRelative(0.42f, 0.35f, 1.05f, 0.3f, 1.41f, -0.13f);
        v12.curveToRelative(0.36f, -0.42f, 0.3f, -1.05f, -0.12f, -1.41f);
        v12.close();
        v12.moveTo(4.1f, 6.55f);
        v12.lineToRelative(3.07f, -2.56f);
        v12.curveToRelative(0.43f, -0.36f, 0.49f, -0.99f, 0.13f, -1.41f);
        v12.curveToRelative(-0.35f, -0.43f, -0.98f, -0.48f, -1.4f, -0.13f);
        v12.lineTo(2.82f, 5.01f);
        v12.curveToRelative(-0.42f, 0.36f, -0.48f, 0.99f, -0.12f, 1.41f);
        v12.curveToRelative(0.35f, 0.43f, 0.98f, 0.48f, 1.4f, 0.13f);
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
        v12.moveTo(15f, 12f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(9f, 12f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AlarmAddKt._alarmAdd = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

