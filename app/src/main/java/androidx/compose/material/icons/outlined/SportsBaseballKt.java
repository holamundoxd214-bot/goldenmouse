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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsBaseball", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsBaseball", "Landroidx/compose/material/icons/Icons$Outlined;", "getSportsBaseball", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsBaseballKt {
    private static ImageVector _sportsBaseball;

    static {
    }

    public static final ImageVector getSportsBaseball(Outlined arg19) {
        ImageVector v0 = SportsBaseballKt._sportsBaseball;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.SportsBaseball", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(5.61f, 16.780001f);
        v12.curveTo(4.6f, 15.45f, 4f, 13.8f, 4f, 12f);
        v12.reflectiveCurveToRelative(0.6f, -3.45f, 1.61f, -4.78f);
        v12.curveTo(7.06f, 8.31f, 8f, 10.05f, 8f, 12f);
        v12.reflectiveCurveTo(7.06f, 15.69f, 5.61f, 16.780001f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-1.89f, 0f, -3.63f, -0.66f, -5f, -1.76f);
        v12.curveToRelative(1.83f, -1.47f, 3f, -3.71f, 3f, -6.24f);
        v12.reflectiveCurveTo(8.83f, 7.23f, 7f, 5.76f);
        v12.curveTo(8.37f, 4.66f, 10.11f, 4f, 12f, 4f);
        v12.reflectiveCurveToRelative(3.63f, 0.66f, 5f, 1.76f);
        v12.curveToRelative(-1.83f, 1.47f, -3f, 3.71f, -3f, 6.24f);
        v12.reflectiveCurveToRelative(1.17f, 4.77f, 3f, 6.24f);
        v12.curveTo(15.63f, 19.34f, 13.89f, 20f, 12f, 20f);
        v12.close();
        v12.moveTo(18.389999f, 16.780001f);
        v12.curveTo(16.940001f, 15.69f, 16f, 13.95f, 16f, 12f);
        v12.reflectiveCurveToRelative(0.94f, -3.69f, 2.39f, -4.78f);
        v12.curveTo(19.4f, 8.55f, 20f, 10.2f, 20f, 12f);
        v12.reflectiveCurveTo(19.4f, 15.45f, 18.389999f, 16.780001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsBaseballKt._sportsBaseball = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

