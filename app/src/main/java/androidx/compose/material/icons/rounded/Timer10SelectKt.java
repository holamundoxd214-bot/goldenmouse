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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_timer10Select", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Timer10Select", "Landroidx/compose/material/icons/Icons$Rounded;", "getTimer10Select", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Timer10SelectKt {
    private static ImageVector _timer10Select;

    static {
    }

    public static final ImageVector getTimer10Select(Rounded arg19) {
        ImageVector v0 = Timer10SelectKt._timer10Select;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Timer10Select", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13f, 8f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(8f);
        v12.horizontalLineTo(13f);
        v12.moveTo(13f, 5f);
        v12.horizontalLineToRelative(-3f);
        v12.curveTo(8.34f, 5f, 7f, 6.34f, 7f, 8f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.verticalLineTo(8f);
        v12.curveTo(16f, 6.34f, 14.66f, 5f, 13f, 5f);
        v12.close();
        v12.moveTo(2.5f, 8f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(9.5f);
        v12.curveTo(3f, 18.33f, 3.67f, 19f, 4.5f, 19f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(5.33f, 19f, 6f, 18.33f, 6f, 17.5f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineTo(2.5f);
        v12.curveTo(1.67f, 5f, 1f, 5.67f, 1f, 6.5f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(1f, 7.33f, 1.67f, 8f, 2.5f, 8f);
        v12.close();
        v12.moveTo(18.5f, 11f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.68f, -1.5f, 1.5f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.82f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.horizontalLineTo(21f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(3.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.83f, -0.67f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineTo(19f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(18.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Timer10SelectKt._timer10Select = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

