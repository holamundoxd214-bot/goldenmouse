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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_avTimer", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AvTimer", "Landroidx/compose/material/icons/Icons$Sharp;", "getAvTimer", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AvTimerKt {
    private static ImageVector _avTimer;

    static {
    }

    public static final ImageVector getAvTimer(Sharp arg19) {
        ImageVector v0 = AvTimerKt._avTimer;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.AvTimer", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 17f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.close();
        v12.moveTo(11f, 3f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(13f, 5.08f);
        v12.curveToRelative(3.39f, 0.49f, 6f, 3.39f, 6f, 6.92f);
        v12.curveToRelative(0f, 3.87f, -3.13f, 7f, -7f, 7f);
        v12.reflectiveCurveToRelative(-7f, -3.13f, -7f, -7f);
        v12.curveToRelative(0f, -1.68f, 0.59f, -3.22f, 1.58f, -4.42f);
        v12.lineTo(12f, 13f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(-6.8f, -6.8f);
        v12.verticalLineToRelative(0.02f);
        v12.curveTo(4.42f, 6.45f, 3f, 9.05f, 3f, 12f);
        v12.curveToRelative(0f, 4.97f, 4.02f, 9f, 9f, 9f);
        v12.curveToRelative(4.97f, 0f, 9f, -4.03f, 9f, -9f);
        v12.reflectiveCurveToRelative(-4.03f, -9f, -9f, -9f);
        v12.horizontalLineToRelative(-1f);
        v12.close();
        v12.moveTo(18f, 12f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.close();
        v12.moveTo(6f, 12f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.reflectiveCurveToRelative(-0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AvTimerKt._avTimer = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

