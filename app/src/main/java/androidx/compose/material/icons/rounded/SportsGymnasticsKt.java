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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsGymnastics", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsGymnastics", "Landroidx/compose/material/icons/Icons$Rounded;", "getSportsGymnastics", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsGymnasticsKt {
    private static ImageVector _sportsGymnastics;

    static {
    }

    public static final ImageVector getSportsGymnastics(Rounded arg19) {
        ImageVector v0 = SportsGymnasticsKt._sportsGymnastics;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SportsGymnastics", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 6f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.reflectiveCurveTo(7.1f, 8f, 6f, 8f);
        v12.reflectiveCurveTo(4f, 7.1f, 4f, 6f);
        v12.close();
        v12.moveTo(13f, 22f);
        v12.curveToRelative(-0.56f, 0f, -1.02f, -0.44f, -1.05f, -1f);
        v12.lineToRelative(-0.45f, -9f);
        v12.lineTo(8f, 11f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(5f);
        v12.lineToRelative(6.26f, -4.47f);
        v12.curveToRelative(0.42f, -0.3f, 1f, -0.23f, 1.34f, 0.16f);
        v12.curveToRelative(0.38f, 0.45f, 0.3f, 1.12f, -0.18f, 1.46f);
        v12.lineTo(11.14f, 8.5f);
        v12.horizontalLineTo(14f);
        v12.lineToRelative(7.09f, -4.09f);
        v12.curveToRelative(0.41f, -0.24f, 0.93f, -0.15f, 1.24f, 0.21f);
        v12.curveToRelative(0.36f, 0.43f, 0.3f, 1.07f, -0.14f, 1.41f);
        v12.lineTo(14.5f, 12f);
        v12.lineToRelative(-0.45f, 9f);
        v12.curveTo(14.02f, 21.559999f, 13.56f, 22f, 13f, 22f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsGymnasticsKt._sportsGymnastics = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

