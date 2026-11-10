package androidx.compose.material.icons.automirrored.filled;

import androidx.compose.material.icons.Icons$AutoMirrored$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_nextPlan", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NextPlan", "Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;", "getNextPlan", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NextPlanKt {
    private static ImageVector _nextPlan;

    static {
    }

    public static final ImageVector getNextPlan(Filled arg19) {
        ImageVector v0 = NextPlanKt._nextPlan;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Filled.NextPlan", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 5.52f, 4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(18f, 13.97f);
        v12.horizontalLineToRelative(-5f);
        v12.lineToRelative(2.26f, -2.26f);
        v12.curveToRelative(-0.91f, -1.06f, -2.25f, -1.74f, -3.76f, -1.74f);
        v12.curveToRelative(-2.37f, 0f, -4.35f, 1.66f, -4.86f, 3.88f);
        v12.lineToRelative(-0.96f, -0.32f);
        v12.curveToRelative(0.64f, -2.62f, 3f, -4.56f, 5.82f, -4.56f);
        v12.curveToRelative(1.78f, 0f, 3.37f, 0.79f, 4.47f, 2.03f);
        v12.lineTo(18f, 8.97f);
        v12.verticalLineTo(13.97f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NextPlanKt._nextPlan = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

