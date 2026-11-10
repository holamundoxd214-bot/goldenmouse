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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_alarmOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AlarmOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAlarmOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AlarmOffKt {
    private static ImageVector _alarmOff;

    static {
    }

    public static final ImageVector getAlarmOff(TwoTone arg19) {
        ImageVector v0 = AlarmOffKt._alarmOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.AlarmOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10.04f, 6.29f);
        v12.curveTo(10.66f, 6.11f, 11.32f, 6f, 12f, 6f);
        v12.curveToRelative(3.86f, 0f, 7f, 3.14f, 7f, 7f);
        v12.curveToRelative(0f, 0.68f, -0.11f, 1.34f, -0.29f, 1.96f);
        v12.lineToRelative(1.56f, 1.56f);
        v12.curveToRelative(0.47f, -1.08f, 0.73f, -2.27f, 0.73f, -3.52f);
        v12.curveToRelative(0f, -4.97f, -4.03f, -9f, -9f, -9f);
        v12.curveToRelative(-1.25f, 0f, -2.44f, 0.26f, -3.53f, 0.72f);
        v12.lineToRelative(1.57f, 1.57f);
        v12.close();
        v12.moveTo(17.337f, 1.81f);
        v12.lineToRelative(4.607f, 3.845f);
        v12.lineToRelative(-1.28f, 1.535f);
        v12.lineToRelative(-4.61f, -3.843f);
        v12.close();
        v12.moveTo(19.24f, 18.32f);
        v12.lineToRelative(-1.43f, -1.43f);
        v12.lineToRelative(-9.7f, -9.7f);
        v12.lineToRelative(-1.43f, -1.43f);
        v12.lineToRelative(-0.74f, -0.74f);
        v12.lineTo(4.52f, 3.6f);
        v12.lineToRelative(-1.5f, -1.5f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(1.37f, 1.37f);
        v12.lineToRelative(-0.92f, 0.77f);
        v12.lineToRelative(1.28f, 1.54f);
        v12.lineToRelative(1.06f, -0.88f);
        v12.lineToRelative(0.8f, 0.8f);
        v12.curveTo(3.83f, 8.69f, 3f, 10.75f, 3f, 13f);
        v12.curveToRelative(0f, 4.97f, 4.03f, 9f, 9f, 9f);
        v12.curveToRelative(2.25f, 0f, 4.31f, -0.83f, 5.89f, -2.2f);
        v12.lineToRelative(2.1f, 2.1f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(-2.16f, -2.17f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-3.86f, 0f, -7f, -3.14f, -7f, -7f);
        v12.curveToRelative(0f, -1.7f, 0.61f, -3.26f, 1.62f, -4.47f);
        v12.lineToRelative(9.85f, 9.85f);
        v12.curveTo(15.26f, 19.389999f, 13.7f, 20f, 12f, 20f);
        v12.close();
        v12.moveTo(7.48f, 3.73f);
        v12.lineToRelative(0.46f, -0.38f);
        v12.lineToRelative(-1.28f, -1.54f);
        v12.lineToRelative(-0.6f, 0.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AlarmOffKt._alarmOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

