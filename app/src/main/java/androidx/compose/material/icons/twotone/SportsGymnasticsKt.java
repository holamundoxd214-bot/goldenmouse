package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sportsGymnastics", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SportsGymnastics", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSportsGymnastics", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SportsGymnasticsKt {
    private static ImageVector _sportsGymnastics;

    static {
    }

    public static final ImageVector getSportsGymnastics(TwoTone arg19) {
        ImageVector v0 = SportsGymnasticsKt._sportsGymnastics;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.SportsGymnastics", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(1f, 9f);
        v12.horizontalLineToRelative(6f);
        v12.lineToRelative(7f, -5f);
        v12.lineToRelative(1.31f, 1.52f);
        v12.lineTo(11.14f, 8.5f);
        v12.horizontalLineTo(14f);
        v12.lineTo(21.799999f, 4f);
        v12.lineTo(23f, 5.4f);
        v12.lineTo(14.5f, 12f);
        v12.lineTo(14f, 22f);
        v12.horizontalLineToRelative(-2f);
        v12.lineToRelative(-0.5f, -10f);
        v12.lineTo(8f, 11f);
        v12.horizontalLineTo(1f);
        v12.verticalLineTo(9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SportsGymnasticsKt._sportsGymnastics = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

