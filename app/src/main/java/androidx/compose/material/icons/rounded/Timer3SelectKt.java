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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_timer3Select", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Timer3Select", "Landroidx/compose/material/icons/Icons$Rounded;", "getTimer3Select", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Timer3SelectKt {
    private static ImageVector _timer3Select;

    static {
    }

    public static final ImageVector getTimer3Select(Rounded arg19) {
        ImageVector v0 = Timer3SelectKt._timer3Select;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Timer3Select", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 12f);
        v12.lineTo(21f, 12f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.68f, 1.5f, 1.5f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.83f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.horizontalLineTo(16f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(-2.5f);
        v12.curveToRelative(-0.82f, 0f, -1.5f, -0.68f, -1.5f, -1.5f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.82f, 0.68f, -1.5f, 1.5f, -1.5f);
        v12.horizontalLineTo(20f);
        v12.curveTo(20.549999f, 11f, 21f, 11.45f, 21f, 12f);
        v12.close();
        v12.moveTo(4f, 6.5f);
        v12.lineTo(4f, 6.5f);
        v12.curveTo(4f, 7.33f, 4.67f, 8f, 5.5f, 8f);
        v12.horizontalLineTo(10f);
        v12.verticalLineToRelative(2.5f);
        v12.horizontalLineTo(5.5f);
        v12.curveTo(4.67f, 10.5f, 4f, 11.17f, 4f, 12f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.horizontalLineTo(10f);
        v12.verticalLineTo(16f);
        v12.horizontalLineTo(5.5f);
        v12.curveTo(4.67f, 16f, 4f, 16.67f, 4f, 17.5f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(4f, 18.33f, 4.67f, 19f, 5.5f, 19f);
        v12.horizontalLineTo(10f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.verticalLineToRelative(-1.9f);
        v12.curveToRelative(0f, -1.16f, -0.94f, -2.1f, -2.1f, -2.1f);
        v12.curveToRelative(1.16f, 0f, 2.1f, -0.94f, 2.1f, -2.1f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.horizontalLineTo(5.5f);
        v12.curveTo(4.67f, 5f, 4f, 5.67f, 4f, 6.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Timer3SelectKt._timer3Select = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

