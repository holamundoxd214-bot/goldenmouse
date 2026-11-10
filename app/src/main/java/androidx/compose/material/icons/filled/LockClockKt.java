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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_lockClock", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LockClock", "Landroidx/compose/material/icons/Icons$Filled;", "getLockClock", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LockClockKt {
    private static ImageVector _lockClock;

    static {
    }

    public static final ImageVector getLockClock(Filled arg19) {
        ImageVector v0 = LockClockKt._lockClock;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.LockClock", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.5f, 14.2f);
        v12.lineToRelative(2.9f, 1.7f);
        v12.lineToRelative(-0.8f, 1.3f);
        v12.lineTo(13f, 15f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(4.2f);
        v12.close();
        v12.moveTo(22f, 14f);
        v12.curveToRelative(0f, 4.41f, -3.59f, 8f, -8f, 8f);
        v12.curveToRelative(-2.02f, 0f, -3.86f, -0.76f, -5.27f, -2f);
        v12.lineTo(4f, 20f);
        v12.curveToRelative(-1.15f, 0f, -2f, -0.85f, -2f, -2f);
        v12.lineTo(2f, 9f);
        v12.curveToRelative(0f, -1.12f, 0.89f, -1.96f, 2f, -2f);
        v12.verticalLineToRelative(-0.5f);
        v12.curveTo(4f, 4.01f, 6.01f, 2f, 8.5f, 2f);
        v12.curveToRelative(2.34f, 0f, 4.24f, 1.79f, 4.46f, 4.08f);
        v12.curveToRelative(0.34f, -0.05f, 0.69f, -0.08f, 1.04f, -0.08f);
        v12.curveToRelative(4.41f, 0f, 8f, 3.59f, 8f, 8f);
        v12.close();
        v12.moveTo(6f, 7f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(-0.74f);
        v12.curveTo(10.88f, 4.99f, 9.8f, 4f, 8.5f, 4f);
        v12.curveTo(7.12f, 4f, 6f, 5.12f, 6f, 6.5f);
        v12.lineTo(6f, 7f);
        v12.close();
        v12.moveTo(20f, 14f);
        v12.curveToRelative(0f, -3.31f, -2.69f, -6f, -6f, -6f);
        v12.reflectiveCurveToRelative(-6f, 2.69f, -6f, 6f);
        v12.reflectiveCurveToRelative(2.69f, 6f, 6f, 6f);
        v12.reflectiveCurveToRelative(6f, -2.69f, 6f, -6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LockClockKt._lockClock = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

