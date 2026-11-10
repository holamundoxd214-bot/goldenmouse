package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_opacity", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Opacity", "Landroidx/compose/material/icons/Icons$Outlined;", "getOpacity", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class OpacityKt {
    private static ImageVector _opacity;

    static {
    }

    public static final ImageVector getOpacity(Outlined arg19) {
        ImageVector v0 = OpacityKt._opacity;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Opacity", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.66f, 8f);
        v12.lineTo(12f, 2.35f);
        v12.lineTo(6.34f, 8f);
        v12.curveTo(4.78f, 9.56f, 4f, 11.64f, 4f, 13.64f);
        v12.reflectiveCurveToRelative(0.78f, 4.11f, 2.34f, 5.67f);
        v12.reflectiveCurveToRelative(3.61f, 2.35f, 5.66f, 2.35f);
        v12.reflectiveCurveToRelative(4.1f, -0.79f, 5.66f, -2.35f);
        v12.reflectiveCurveTo(20f, 15.64f, 20f, 13.64f);
        v12.reflectiveCurveTo(19.219999f, 9.56f, 17.66f, 8f);
        v12.close();
        v12.moveTo(6f, 14f);
        v12.curveToRelative(0.01f, -2f, 0.62f, -3.27f, 1.76f, -4.4f);
        v12.lineTo(12f, 5.27f);
        v12.lineToRelative(4.24f, 4.38f);
        v12.curveTo(17.379999f, 10.77f, 17.99f, 12f, 18f, 14f);
        v12.horizontalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        OpacityKt._opacity = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

