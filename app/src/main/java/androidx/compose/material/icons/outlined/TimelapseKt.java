package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_timelapse", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Timelapse", "Landroidx/compose/material/icons/Icons$Outlined;", "getTimelapse", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TimelapseKt {
    private static ImageVector _timelapse;

    static {
    }

    public static final ImageVector getTimelapse(Outlined arg19) {
        ImageVector v0 = TimelapseKt._timelapse;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Timelapse", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.24f, 7.75f);
        v12.curveToRelative(-1.17f, -1.17f, -2.7f, -1.76f, -4.24f, -1.76f);
        v12.verticalLineToRelative(6f);
        v12.lineToRelative(-4.24f, 4.24f);
        v12.curveToRelative(2.34f, 2.34f, 6.14f, 2.34f, 8.49f, 0f);
        v12.curveToRelative(2.34f, -2.34f, 2.34f, -6.14f, -0.01f, -8.48f);
        v12.close();
        v12.moveTo(12f, 1.99f);
        v12.curveToRelative(-5.52f, 0f, -10f, 4.48f, -10f, 10f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveToRelative(-4.48f, -10f, -10f, -10f);
        v12.close();
        v12.moveTo(12f, 19.99f);
        v12.curveToRelative(-4.42f, 0f, -8f, -3.58f, -8f, -8f);
        v12.reflectiveCurveToRelative(3.58f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.58f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.58f, 8f, -8f, 8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TimelapseKt._timelapse = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

