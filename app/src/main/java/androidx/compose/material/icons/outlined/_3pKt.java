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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"__3p", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_3p", "Landroidx/compose/material/icons/Icons$Outlined;", "get_3p", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _3pKt {
    private static ImageVector __3p;

    static {
    }

    public static final ImageVector get_3p(Outlined arg19) {
        ImageVector v0 = _3pKt.__3p;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined._3p", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(4.01f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.lineTo(2f, 22f);
        v12.lineToRelative(4f, -4f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21.1f, 2f, 20f, 2f);
        v12.close();
        v12.moveTo(20f, 16f);
        v12.horizontalLineTo(5.17f);
        v12.lineTo(4f, 17.17f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(16f);
        v12.close();
        v12.moveTo(12f, 10f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveTo(10.9f, 10f, 12f, 10f);
        v12.close();
        v12.moveTo(16f, 13.43f);
        v12.curveToRelative(0f, -0.81f, -0.48f, -1.53f, -1.22f, -1.85f);
        v12.curveTo(13.93f, 11.21f, 12.99f, 11f, 12f, 11f);
        v12.curveToRelative(-0.99f, 0f, -1.93f, 0.21f, -2.78f, 0.58f);
        v12.curveTo(8.48f, 11.9f, 8f, 12.62f, 8f, 13.43f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(13.43f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _3pKt.__3p = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

