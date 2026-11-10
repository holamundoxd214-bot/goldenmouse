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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_colorize", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Colorize", "Landroidx/compose/material/icons/Icons$TwoTone;", "getColorize", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ColorizeKt {
    private static ImageVector _colorize;

    static {
    }

    public static final ImageVector getColorize(TwoTone arg20) {
        ImageVector v0 = ColorizeKt._colorize;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Colorize", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(15.896f, 9.023f);
        v0_1.lineToRelative(-0.92f, -0.92f);
        v0_1.lineTo(17.67f, 5.41f);
        v0_1.lineToRelative(0.92f, 0.92f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.709999f, 5.63f);
        v12.lineToRelative(-2.34f, -2.34f);
        v12.curveToRelative(-0.2f, -0.2f, -0.45f, -0.29f, -0.71f, -0.29f);
        v12.reflectiveCurveToRelative(-0.51f, 0.1f, -0.7f, 0.29f);
        v12.lineToRelative(-3.12f, 3.12f);
        v12.lineToRelative(-1.93f, -1.91f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.lineTo(3f, 16.25f);
        v12.lineTo(3f, 21f);
        v12.horizontalLineToRelative(4.75f);
        v12.lineToRelative(8.92f, -8.92f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(-1.92f, -1.92f);
        v12.lineToRelative(3.12f, -3.12f);
        v12.curveToRelative(0.4f, -0.4f, 0.4f, -1.03f, 0.01f, -1.42f);
        v12.close();
        v12.moveTo(6.92f, 19f);
        v12.lineTo(5f, 17.08f);
        v12.lineToRelative(8.06f, -8.06f);
        v12.lineToRelative(1.92f, 1.92f);
        v12.lineTo(6.92f, 19f);
        v12.close();
        v12.moveTo(15.9f, 9.03f);
        v12.lineToRelative(-0.93f, -0.93f);
        v12.lineToRelative(2.69f, -2.69f);
        v12.lineToRelative(0.92f, 0.92f);
        v12.lineToRelative(-2.68f, 2.7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ColorizeKt._colorize = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

