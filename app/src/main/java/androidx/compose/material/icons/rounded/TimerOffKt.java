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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_timerOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TimerOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getTimerOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TimerOffKt {
    private static ImageVector _timerOff;

    static {
    }

    public static final ImageVector getTimerOff(Rounded arg19) {
        ImageVector v0 = TimerOffKt._timerOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TimerOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(10f, 3f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveTo(9.45f, 1f, 9f, 1.45f, 9f, 2f);
        v12.curveTo(9f, 2.55f, 9.45f, 3f, 10f, 3f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(1.17f);
        v12.lineToRelative(6.98f, 6.98f);
        v12.curveTo(20.629999f, 15.91f, 21f, 14.5f, 21f, 13f);
        v12.curveToRelative(0f, -2.12f, -0.74f, -4.07f, -1.97f, -5.61f);
        v12.lineToRelative(0.75f, -0.75f);
        v12.curveToRelative(0.38f, -0.38f, 0.39f, -1.01f, 0f, -1.4f);
        v12.curveToRelative(0f, 0f, -0.01f, -0.01f, -0.01f, -0.01f);
        v12.curveToRelative(-0.39f, -0.39f, -1.01f, -0.38f, -1.4f, 0f);
        v12.lineToRelative(-0.75f, 0.75f);
        v12.curveTo(16.07f, 4.74f, 14.12f, 4f, 12f, 4f);
        v12.curveToRelative(-1.48f, 0f, -2.89f, 0.38f, -4.13f, 1.04f);
        v12.lineToRelative(3.36f, 3.36f);
        v12.curveTo(11.41f, 8.16f, 11.68f, 8f, 12f, 8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2.1f, 3.51f);
        v12.lineTo(2.1f, 3.51f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(2.72f, 2.72f);
        v12.curveTo(3.73f, 9.09f, 3.05f, 10.86f, 3f, 12.76f);
        v12.curveTo(2.87f, 17.84f, 6.94f, 22f, 12f, 22f);
        v12.curveToRelative(2.02f, 0f, 3.88f, -0.67f, 5.38f, -1.79f);
        v12.lineToRelative(1.69f, 1.69f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveTo(3.12f, 3.12f, 2.49f, 3.12f, 2.1f, 3.51f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TimerOffKt._timerOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

