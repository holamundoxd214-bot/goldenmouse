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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tvOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TvOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getTvOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TvOffKt {
    private static ImageVector _tvOff;

    static {
    }

    public static final ImageVector getTvOff(Rounded arg19) {
        ImageVector v0 = TvOffKt._tvOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TvOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 8f);
        v12.verticalLineToRelative(9.88f);
        v12.lineToRelative(1.85f, 1.85f);
        v12.curveToRelative(0.1f, -0.22f, 0.15f, -0.47f, 0.15f, -0.73f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(0f, -1.11f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-7.59f);
        v12.lineToRelative(2.94f, -2.94f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.reflectiveCurveToRelative(-0.51f, -0.2f, -0.71f, 0f);
        v12.lineTo(12f, 4.99f);
        v12.lineTo(8.36f, 1.35f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.reflectiveCurveToRelative(-0.2f, 0.51f, 0f, 0.71f);
        v12.lineTo(10.59f, 5f);
        v12.horizontalLineTo(8.12f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(20f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.close();
        v12.moveTo(3.12f, 2.83f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(0.82f, 0.82f);
        v12.curveTo(1.65f, 5.28f, 1f, 6.06f, 1f, 7f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(15.46f);
        v12.lineToRelative(1.29f, 1.29f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.36f, -0.36f, 0.37f, -0.92f, 0.07f, -1.31f);
        v12.horizontalLineToRelative(0.03f);
        v12.lineTo(3.12f, 2.83f);
        v12.close();
        v12.moveTo(3f, 18f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(0.46f);
        v12.lineToRelative(12f, 12f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TvOffKt._tvOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

