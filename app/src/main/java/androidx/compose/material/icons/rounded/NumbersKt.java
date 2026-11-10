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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_numbers", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Numbers", "Landroidx/compose/material/icons/Icons$Rounded;", "getNumbers", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NumbersKt {
    private static ImageVector _numbers;

    static {
    }

    public static final ImageVector getNumbers(Rounded arg19) {
        ImageVector v0 = NumbersKt._numbers;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Numbers", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.68f, 9.27f);
        v12.lineToRelative(0.01f, -0.06f);
        v12.curveTo(20.85f, 8.59f, 20.389999f, 8f, 19.76f, 8f);
        v12.horizontalLineTo(17f);
        v12.lineToRelative(0.7f, -2.79f);
        v12.curveTo(17.85f, 4.59f, 17.389999f, 4f, 16.76f, 4f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.45f, 0f, -0.83f, 0.3f, -0.94f, 0.73f);
        v12.lineTo(15f, 8f);
        v12.horizontalLineToRelative(-4f);
        v12.lineToRelative(0.7f, -2.79f);
        v12.curveTo(11.85f, 4.59f, 11.39f, 4f, 10.76f, 4f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.45f, 0f, -0.83f, 0.3f, -0.94f, 0.73f);
        v12.lineTo(9f, 8f);
        v12.horizontalLineTo(5.76f);
        v12.curveTo(5.31f, 8f, 4.92f, 8.3f, 4.82f, 8.73f);
        v12.lineTo(4.8f, 8.79f);
        v12.curveTo(4.65f, 9.41f, 5.11f, 10f, 5.74f, 10f);
        v12.horizontalLineTo(8.5f);
        v12.lineToRelative(-1f, 4f);
        v12.horizontalLineTo(4.26f);
        v12.curveToRelative(-0.45f, 0f, -0.83f, 0.3f, -0.94f, 0.73f);
        v12.lineTo(3.3f, 14.79f);
        v12.curveTo(3.15f, 15.41f, 3.61f, 16f, 4.24f, 16f);
        v12.horizontalLineTo(7f);
        v12.lineToRelative(-0.7f, 2.79f);
        v12.curveTo(6.15f, 19.41f, 6.61f, 20f, 7.24f, 20f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.45f, 0f, 0.83f, -0.3f, 0.94f, -0.73f);
        v12.lineTo(9f, 16f);
        v12.horizontalLineToRelative(4f);
        v12.lineToRelative(-0.7f, 2.79f);
        v12.curveTo(12.15f, 19.41f, 12.61f, 20f, 13.24f, 20f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.45f, 0f, 0.83f, -0.3f, 0.94f, -0.73f);
        v12.lineTo(15f, 16f);
        v12.horizontalLineToRelative(3.24f);
        v12.curveToRelative(0.45f, 0f, 0.83f, -0.3f, 0.94f, -0.73f);
        v12.lineToRelative(0.01f, -0.06f);
        v12.curveToRelative(0.15f, -0.61f, -0.31f, -1.21f, -0.94f, -1.21f);
        v12.horizontalLineTo(15.5f);
        v12.lineToRelative(1f, -4f);
        v12.horizontalLineToRelative(3.24f);
        v12.curveTo(20.190001f, 10f, 20.58f, 9.7f, 20.68f, 9.27f);
        v12.close();
        v12.moveTo(13.5f, 14f);
        v12.horizontalLineToRelative(-4f);
        v12.lineToRelative(1f, -4f);
        v12.horizontalLineToRelative(4f);
        v12.lineTo(13.5f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NumbersKt._numbers = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

