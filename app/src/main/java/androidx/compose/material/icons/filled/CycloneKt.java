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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cyclone", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Cyclone", "Landroidx/compose/material/icons/Icons$Filled;", "getCyclone", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CycloneKt {
    private static ImageVector _cyclone;

    static {
    }

    public static final ImageVector getCyclone(Filled arg19) {
        ImageVector v0 = CycloneKt._cyclone;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Cyclone", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 8f);
        v12.curveToRelative(-2.21f, 0f, -4f, 1.79f, -4f, 4f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.curveTo(16f, 9.79f, 14.21f, 8f, 12f, 8f);
        v12.close();
        v12.moveTo(12f, 14f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.reflectiveCurveToRelative(2f, 0.9f, 2f, 2f);
        v12.curveTo(14f, 13.1f, 13.1f, 14f, 12f, 14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(22f, 7.47f);
        v12.verticalLineTo(5.35f);
        v12.curveTo(20.049999f, 4.77f, 16.559999f, 4f, 12f, 4f);
        v12.curveTo(9.85f, 4f, 7.89f, 4.86f, 6.46f, 6.24f);
        v12.curveTo(6.59f, 5.39f, 6.86f, 3.84f, 7.47f, 2f);
        v12.horizontalLineTo(5.35f);
        v12.curveTo(4.77f, 3.95f, 4f, 7.44f, 4f, 12f);
        v12.curveToRelative(0f, 2.15f, 0.86f, 4.11f, 2.24f, 5.54f);
        v12.curveToRelative(-0.85f, -0.14f, -2.4f, -0.4f, -4.24f, -1.01f);
        v12.verticalLineToRelative(2.12f);
        v12.curveTo(3.95f, 19.23f, 7.44f, 20f, 12f, 20f);
        v12.curveToRelative(2.15f, 0f, 4.11f, -0.86f, 5.54f, -2.24f);
        v12.curveToRelative(-0.14f, 0.85f, -0.4f, 2.4f, -1.01f, 4.24f);
        v12.horizontalLineToRelative(2.12f);
        v12.curveTo(19.23f, 20.049999f, 20f, 16.559999f, 20f, 12f);
        v12.curveToRelative(0f, -2.15f, -0.86f, -4.11f, -2.24f, -5.54f);
        v12.curveTo(18.610001f, 6.59f, 20.16f, 6.86f, 22f, 7.47f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-3.31f, 0f, -6f, -2.69f, -6f, -6f);
        v12.reflectiveCurveToRelative(2.69f, -6f, 6f, -6f);
        v12.reflectiveCurveToRelative(6f, 2.69f, 6f, 6f);
        v12.reflectiveCurveTo(15.31f, 18f, 12f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CycloneKt._cyclone = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

