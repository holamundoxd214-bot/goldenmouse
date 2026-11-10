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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_donutSmall", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DonutSmall", "Landroidx/compose/material/icons/Icons$Filled;", "getDonutSmall", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DonutSmallKt {
    private static ImageVector _donutSmall;

    static {
    }

    public static final ImageVector getDonutSmall(Filled arg19) {
        ImageVector v0 = DonutSmallKt._donutSmall;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.DonutSmall", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11f, 9.16f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(-5f, 0.5f, -9f, 4.79f, -9f, 10f);
        v12.reflectiveCurveToRelative(4f, 9.5f, 9f, 10f);
        v12.verticalLineToRelative(-7.16f);
        v12.curveToRelative(-1f, -0.41f, -2f, -1.52f, -2f, -2.84f);
        v12.reflectiveCurveToRelative(1f, -2.43f, 2f, -2.84f);
        v12.close();
        v12.moveTo(14.86f, 11f);
        v12.horizontalLineTo(22f);
        v12.curveToRelative(-0.48f, -4.75f, -4f, -8.53f, -9f, -9f);
        v12.verticalLineToRelative(7.16f);
        v12.curveToRelative(1f, 0.3f, 1.52f, 0.98f, 1.86f, 1.84f);
        v12.close();
        v12.moveTo(13f, 14.84f);
        v12.verticalLineTo(22f);
        v12.curveToRelative(5f, -0.47f, 8.52f, -4.25f, 9f, -9f);
        v12.horizontalLineToRelative(-7.14f);
        v12.curveToRelative(-0.34f, 0.86f, -0.86f, 1.54f, -1.86f, 1.84f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DonutSmallKt._donutSmall = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

