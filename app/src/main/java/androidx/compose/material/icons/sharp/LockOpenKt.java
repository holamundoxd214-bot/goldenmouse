package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_lockOpen", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LockOpen", "Landroidx/compose/material/icons/Icons$Sharp;", "getLockOpen", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LockOpenKt {
    private static ImageVector _lockOpen;

    static {
    }

    public static final ImageVector getLockOpen(Sharp arg19) {
        ImageVector v0 = LockOpenKt._lockOpen;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.LockOpen", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 8f);
        v12.horizontalLineToRelative(-3f);
        v12.lineTo(17f, 6.21f);
        v12.curveToRelative(0f, -2.61f, -1.91f, -4.94f, -4.51f, -5.19f);
        v12.curveTo(9.51f, 0.74f, 7f, 3.08f, 7f, 6f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0f, -1.13f, 0.6f, -2.24f, 1.64f, -2.7f);
        v12.curveTo(12.85f, 2.31f, 15f, 3.9f, 15f, 6f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(4f, 8f);
        v12.verticalLineToRelative(14f);
        v12.horizontalLineToRelative(16f);
        v12.lineTo(20f, 8f);
        v12.close();
        v12.moveTo(18f, 20f);
        v12.lineTo(6f, 20f);
        v12.lineTo(6f, 10f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(10f);
        v12.close();
        v12.moveTo(12f, 17f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LockOpenKt._lockOpen = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

