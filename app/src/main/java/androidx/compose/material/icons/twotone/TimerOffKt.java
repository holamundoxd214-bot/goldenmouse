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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_timerOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TimerOff", "Landroidx/compose/material/icons/Icons$TwoTone;", "getTimerOff", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TimerOffKt {
    private static ImageVector _timerOff;

    static {
    }

    public static final ImageVector getTimerOff(TwoTone arg19) {
        ImageVector v0 = TimerOffKt._timerOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.TimerOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(1.47f, 0f, 2.83f, -0.45f, 3.95f, -1.22f);
        v12.lineTo(6.22f, 9.05f);
        v12.curveTo(5.45f, 10.17f, 5f, 11.53f, 5f, 13f);
        v12.curveTo(5f, 16.870001f, 8.13f, 20f, 12f, 20f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(-0.94f, 0f, -1.83f, 0.19f, -2.65f, 0.52f);
        v12.lineTo(11f, 8.17f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2.17f);
        v12.lineToRelative(5.48f, 5.48f);
        v12.curveTo(18.809999f, 14.83f, 19f, 13.94f, 19f, 13f);
        v12.curveTo(19f, 9.13f, 15.87f, 6f, 12f, 6f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(9f, 1f);
        v0_1.horizontalLineToRelative(6f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(-6f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(3.87f, 0f, 7f, 3.13f, 7f, 7f);
        v12.curveToRelative(0f, 0.94f, -0.19f, 1.83f, -0.52f, 2.65f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.curveTo(20.629999f, 15.91f, 21f, 14.5f, 21f, 13f);
        v12.curveToRelative(0f, -2.12f, -0.74f, -4.07f, -1.97f, -5.61f);
        v12.lineToRelative(1.42f, -1.42f);
        v12.curveToRelative(-0.43f, -0.51f, -0.9f, -0.99f, -1.41f, -1.41f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveTo(16.07f, 4.74f, 14.12f, 4f, 12f, 4f);
        v12.curveToRelative(-1.5f, 0f, -2.91f, 0.37f, -4.15f, 1.02f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.curveTo(10.17f, 6.19f, 11.06f, 6f, 12f, 6f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(11f, 8f);
        v0_1.lineToRelative(0f, 0.17f);
        v0_1.lineToRelative(2f, 2f);
        v0_1.lineToRelative(0f, -2.17f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(3.4f, 3.4f);
        v12.curveTo(3.67f, 9.12f, 3f, 10.98f, 3f, 13f);
        v12.curveToRelative(0f, 4.97f, 4.02f, 9f, 9f, 9f);
        v12.curveToRelative(2.02f, 0f, 3.88f, -0.67f, 5.38f, -1.79f);
        v12.lineToRelative(2.4f, 2.4f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f);
        v12.curveToRelative(0f, -1.47f, 0.45f, -2.83f, 1.22f, -3.95f);
        v12.lineToRelative(9.73f, 9.73f);
        v12.curveTo(14.83f, 19.549999f, 13.47f, 20f, 12f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TimerOffKt._timerOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

