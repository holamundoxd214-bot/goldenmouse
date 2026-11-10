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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_functions", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Functions", "Landroidx/compose/material/icons/Icons$Rounded;", "getFunctions", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FunctionsKt {
    private static ImageVector _functions;

    static {
    }

    public static final ImageVector getFunctions(Rounded arg19) {
        ImageVector v0 = FunctionsKt._functions;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Functions", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.5f, 4f);
        v12.horizontalLineTo(7.56f);
        v12.curveTo(6.7f, 4f, 6f, 4.7f, 6f, 5.56f);
        v12.curveToRelative(0f, 0.28f, 0.12f, 0.55f, 0.32f, 0.74f);
        v12.lineTo(12.5f, 12f);
        v12.lineToRelative(-6.18f, 5.7f);
        v12.curveToRelative(-0.2f, 0.19f, -0.32f, 0.46f, -0.32f, 0.74f);
        v12.curveTo(6f, 19.299999f, 6.7f, 20f, 7.56f, 20f);
        v12.horizontalLineToRelative(8.94f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-0.67f, -1.5f, -1.5f, -1.5f);
        v12.horizontalLineTo(11f);
        v12.lineToRelative(3.59f, -3.59f);
        v12.curveToRelative(0.78f, -0.78f, 0.78f, -2.05f, 0f, -2.83f);
        v12.lineTo(11f, 7f);
        v12.horizontalLineToRelative(5.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveTo(17.33f, 4f, 16.5f, 4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FunctionsKt._functions = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

