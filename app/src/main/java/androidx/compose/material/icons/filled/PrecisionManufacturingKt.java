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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_precisionManufacturing", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PrecisionManufacturing", "Landroidx/compose/material/icons/Icons$Filled;", "getPrecisionManufacturing", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PrecisionManufacturingKt {
    private static ImageVector _precisionManufacturing;

    static {
    }

    public static final ImageVector getPrecisionManufacturing(Filled arg19) {
        ImageVector v0 = PrecisionManufacturingKt._precisionManufacturing;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PrecisionManufacturing", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.93f, 8.21f);
        v12.lineToRelative(-3.6f, 1.68f);
        v12.lineTo(14f, 7.7f);
        v12.verticalLineTo(6.3f);
        v12.lineToRelative(2.33f, -2.19f);
        v12.lineToRelative(3.6f, 1.68f);
        v12.curveToRelative(0.38f, 0.18f, 0.82f, 0.01f, 1f, -0.36f);
        v12.curveToRelative(0.18f, -0.38f, 0.01f, -0.82f, -0.36f, -1f);
        v12.lineTo(16.65f, 2.6f);
        v12.curveToRelative(-0.38f, -0.18f, -0.83f, -0.1f, -1.13f, 0.2f);
        v12.lineToRelative(-1.74f, 1.6f);
        v12.curveTo(13.6f, 4.16f, 13.32f, 4f, 13f, 4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(8.82f);
        v12.curveTo(8.34f, 4.65f, 6.98f, 3.73f, 5.4f, 4.07f);
        v12.curveTo(4.24f, 4.32f, 3.25f, 5.32f, 3.04f, 6.5f);
        v12.curveTo(2.82f, 7.82f, 3.5f, 8.97f, 4.52f, 9.58f);
        v12.lineTo(7.08f, 18f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(13f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(-3.62f);
        v12.lineTo(8.41f, 8.77f);
        v12.curveTo(8.58f, 8.53f, 8.72f, 8.28f, 8.82f, 8f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.curveToRelative(0.32f, 0f, 0.6f, -0.16f, 0.78f, -0.4f);
        v12.lineToRelative(1.74f, 1.6f);
        v12.curveToRelative(0.3f, 0.3f, 0.75f, 0.38f, 1.13f, 0.2f);
        v12.lineToRelative(3.92f, -1.83f);
        v12.curveToRelative(0.38f, -0.18f, 0.54f, -0.62f, 0.36f, -1f);
        v12.curveTo(20.75f, 8.2f, 20.309999f, 8.03f, 19.93f, 8.21f);
        v12.close();
        v12.moveTo(6f, 8f);
        v12.curveTo(5.45f, 8f, 5f, 7.55f, 5f, 7f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveTo(6.55f, 8f, 6f, 8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PrecisionManufacturingKt._precisionManufacturing = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

