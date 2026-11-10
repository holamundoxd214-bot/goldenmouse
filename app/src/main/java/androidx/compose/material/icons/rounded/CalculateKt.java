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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_calculate", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Calculate", "Landroidx/compose/material/icons/Icons$Rounded;", "getCalculate", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CalculateKt {
    private static ImageVector _calculate;

    static {
    }

    public static final ImageVector getCalculate(Rounded arg19) {
        ImageVector v0 = CalculateKt._calculate;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Calculate", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(21f, 3.9f, 20.1f, 3f, 19f, 3f);
        v12.close();
        v12.moveTo(13.56f, 6.53f);
        v12.lineTo(13.56f, 6.53f);
        v12.curveToRelative(0.29f, -0.29f, 0.77f, -0.29f, 1.06f, 0f);
        v12.lineToRelative(0.88f, 0.88f);
        v12.lineToRelative(0.88f, -0.88f);
        v12.curveToRelative(0.29f, -0.29f, 0.77f, -0.29f, 1.06f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.29f, 0.29f, 0.29f, 0.77f, 0f, 1.06f);
        v12.lineToRelative(-0.88f, 0.88f);
        v12.lineToRelative(0.88f, 0.88f);
        v12.curveToRelative(0.29f, 0.29f, 0.29f, 0.77f, 0f, 1.06f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(-0.29f, 0.29f, -0.77f, 0.29f, -1.06f, 0f);
        v12.lineTo(15.5f, 9.54f);
        v12.lineToRelative(-0.88f, 0.88f);
        v12.curveToRelative(-0.29f, 0.29f, -0.77f, 0.29f, -1.06f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.29f, -0.29f, -0.29f, -0.77f, 0f, -1.06f);
        v12.lineToRelative(0.88f, -0.88f);
        v12.lineToRelative(-0.88f, -0.88f);
        v12.curveTo(13.26f, 7.3f, 13.26f, 6.82f, 13.56f, 6.53f);
        v12.close();
        v12.moveTo(7f, 7.72f);
        v12.horizontalLineToRelative(3.5f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(6.25f, 8.06f, 6.59f, 7.72f, 7f, 7.72f);
        v12.close();
        v12.moveTo(10.75f, 16f);
        v12.horizontalLineTo(9.5f);
        v12.verticalLineToRelative(1.25f);
        v12.curveTo(9.5f, 17.66f, 9.16f, 18f, 8.75f, 18f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(8.34f, 18f, 8f, 17.66f, 8f, 17.25f);
        v12.verticalLineTo(16f);
        v12.horizontalLineTo(6.75f);
        v12.curveTo(6.34f, 16f, 6f, 15.66f, 6f, 15.25f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(-1.25f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(1.25f);
        v12.horizontalLineToRelative(1.25f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(11.5f, 15.66f, 11.16f, 16f, 10.75f, 16f);
        v12.close();
        v12.moveTo(17.25f, 17.25f);
        v12.horizontalLineToRelative(-3.5f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineToRelative(3.5f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(18f, 16.91f, 17.66f, 17.25f, 17.25f, 17.25f);
        v12.close();
        v12.moveTo(17.25f, 14.75f);
        v12.horizontalLineToRelative(-3.5f);
        v12.curveTo(13.34f, 14.75f, 13f, 14.41f, 13f, 14f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineToRelative(3.5f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(18f, 14.41f, 17.66f, 14.75f, 17.25f, 14.75f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CalculateKt._calculate = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

