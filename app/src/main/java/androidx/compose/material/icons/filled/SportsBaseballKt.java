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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsBaseball", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsBaseball", "Landroidx/compose/material/icons/Icons$Filled;", "getSportsBaseball", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsBaseballKt {
    private static ImageVector _sportsBaseball;

    static {
    }

    public static final ImageVector getSportsBaseball(Filled arg19) {
        ImageVector v0 = SportsBaseballKt._sportsBaseball;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SportsBaseball", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3.81f, 6.28f);
        v12.curveTo(2.67f, 7.9f, 2f, 9.87f, 2f, 12f);
        v12.reflectiveCurveToRelative(0.67f, 4.1f, 1.81f, 5.72f);
        v12.curveTo(6.23f, 16.950001f, 8f, 14.68f, 8f, 12f);
        v12.reflectiveCurveTo(6.23f, 7.05f, 3.81f, 6.28f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20.190001f, 6.28f);
        v12.curveTo(17.77f, 7.05f, 16f, 9.32f, 16f, 12f);
        v12.reflectiveCurveToRelative(1.77f, 4.95f, 4.19f, 5.72f);
        v12.curveTo(21.33f, 16.1f, 22f, 14.13f, 22f, 12f);
        v12.reflectiveCurveTo(21.33f, 7.9f, 20.190001f, 6.28f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(14f, 12f);
        v12.curveToRelative(0f, -3.28f, 1.97f, -6.09f, 4.79f, -7.33f);
        v12.curveTo(17.01f, 3.02f, 14.63f, 2f, 12f, 2f);
        v12.reflectiveCurveTo(6.99f, 3.02f, 5.21f, 4.67f);
        v12.curveTo(8.03f, 5.91f, 10f, 8.72f, 10f, 12f);
        v12.reflectiveCurveToRelative(-1.97f, 6.09f, -4.79f, 7.33f);
        v12.curveTo(6.99f, 20.98f, 9.37f, 22f, 12f, 22f);
        v12.reflectiveCurveToRelative(5.01f, -1.02f, 6.79f, -2.67f);
        v12.curveTo(15.97f, 18.09f, 14f, 15.28f, 14f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsBaseballKt._sportsBaseball = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

