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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_queryStats", "Landroidx/compose/ui/graphics/vector/ImageVector;", "QueryStats", "Landroidx/compose/material/icons/Icons$Filled;", "getQueryStats", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class QueryStatsKt {
    private static ImageVector _queryStats;

    static {
    }

    public static final ImageVector getQueryStats(Filled arg19) {
        ImageVector v0 = QueryStatsKt._queryStats;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.QueryStats", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.879999f, 18.469999f);
        v12.curveToRelative(0.44f, -0.7f, 0.7f, -1.51f, 0.7f, -2.39f);
        v12.curveToRelative(0f, -2.49f, -2.01f, -4.5f, -4.5f, -4.5f);
        v12.reflectiveCurveToRelative(-4.5f, 2.01f, -4.5f, 4.5f);
        v12.reflectiveCurveToRelative(2.01f, 4.5f, 4.49f, 4.5f);
        v12.curveToRelative(0.88f, 0f, 1.7f, -0.26f, 2.39f, -0.7f);
        v12.lineTo(21.58f, 23f);
        v12.lineTo(23f, 21.58f);
        v12.lineTo(19.879999f, 18.469999f);
        v12.close();
        v12.moveTo(16.08f, 18.58f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, -1.12f, -2.5f, -2.5f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        v12.curveTo(18.58f, 17.459999f, 17.459999f, 18.58f, 16.08f, 18.58f);
        v12.close();
        v12.moveTo(15.72f, 10.08f);
        v12.curveToRelative(-0.74f, 0.02f, -1.45f, 0.18f, -2.1f, 0.45f);
        v12.lineToRelative(-0.55f, -0.83f);
        v12.lineToRelative(-3.8f, 6.18f);
        v12.lineToRelative(-3.01f, -3.52f);
        v12.lineToRelative(-3.63f, 5.81f);
        v12.lineTo(1f, 17f);
        v12.lineToRelative(5f, -8f);
        v12.lineToRelative(3f, 3.5f);
        v12.lineTo(13f, 6f);
        v12.curveTo(13f, 6f, 15.72f, 10.08f, 15.72f, 10.08f);
        v12.close();
        v12.moveTo(18.309999f, 10.58f);
        v12.curveToRelative(-0.64f, -0.28f, -1.33f, -0.45f, -2.05f, -0.49f);
        v12.curveToRelative(0f, 0f, 5.12f, -8.09f, 5.12f, -8.09f);
        v12.lineTo(23f, 3.18f);
        v12.lineTo(18.309999f, 10.58f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        QueryStatsKt._queryStats = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

