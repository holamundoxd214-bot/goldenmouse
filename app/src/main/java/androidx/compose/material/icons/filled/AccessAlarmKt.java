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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_accessAlarm", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccessAlarm", "Landroidx/compose/material/icons/Icons$Filled;", "getAccessAlarm", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AccessAlarmKt {
    private static ImageVector _accessAlarm;

    static {
    }

    public static final ImageVector getAccessAlarm(Filled arg19) {
        ImageVector v0 = AccessAlarmKt._accessAlarm;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.AccessAlarm", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22f, 5.72f);
        v12.lineToRelative(-4.6f, -3.86f);
        v12.lineToRelative(-1.29f, 1.53f);
        v12.lineToRelative(4.6f, 3.86f);
        v12.lineTo(22f, 5.72f);
        v12.close();
        v12.moveTo(7.88f, 3.39f);
        v12.lineTo(6.6f, 1.86f);
        v12.lineTo(2f, 5.71f);
        v12.lineToRelative(1.29f, 1.53f);
        v12.lineToRelative(4.59f, -3.85f);
        v12.close();
        v12.moveTo(12.5f, 8f);
        v12.lineTo(11f, 8f);
        v12.verticalLineToRelative(6f);
        v12.lineToRelative(4.75f, 2.85f);
        v12.lineToRelative(0.75f, -1.23f);
        v12.lineToRelative(-4f, -2.37f);
        v12.lineTo(12.5f, 8f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(-4.97f, 0f, -9f, 4.03f, -9f, 9f);
        v12.reflectiveCurveToRelative(4.02f, 9f, 9f, 9f);
        v12.curveToRelative(4.97f, 0f, 9f, -4.03f, 9f, -9f);
        v12.reflectiveCurveToRelative(-4.03f, -9f, -9f, -9f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f);
        v12.reflectiveCurveToRelative(3.13f, -7f, 7f, -7f);
        v12.reflectiveCurveToRelative(7f, 3.13f, 7f, 7f);
        v12.reflectiveCurveToRelative(-3.13f, 7f, -7f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AccessAlarmKt._accessAlarm = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

