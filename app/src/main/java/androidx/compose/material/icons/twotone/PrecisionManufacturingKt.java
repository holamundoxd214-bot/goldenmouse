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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_precisionManufacturing", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PrecisionManufacturing", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPrecisionManufacturing", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PrecisionManufacturingKt {
    private static ImageVector _precisionManufacturing;

    static {
    }

    public static final ImageVector getPrecisionManufacturing(TwoTone arg20) {
        ImageVector v0 = PrecisionManufacturingKt._precisionManufacturing;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.PrecisionManufacturing", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(6.71f, 10f);
        v0_1.lineToRelative(2.46f, 8f);
        v0_1.lineToRelative(1.94f, 0f);
        v0_1.lineToRelative(-4.3f, -8f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6f, 7f);
        v12.moveToRelative(-1f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, 2f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, -2f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(19.93f, 8.35f);
        v12.lineToRelative(-3.6f, 1.68f);
        v12.lineTo(14f, 7.7f);
        v12.verticalLineTo(6.3f);
        v12.lineToRelative(2.33f, -2.33f);
        v12.lineToRelative(3.6f, 1.68f);
        v12.curveToRelative(0.38f, 0.18f, 0.82f, 0.01f, 1f, -0.36f);
        v12.curveToRelative(0.18f, -0.38f, 0.01f, -0.82f, -0.36f, -1f);
        v12.lineToRelative(-3.92f, -1.83f);
        v12.curveToRelative(-0.38f, -0.18f, -0.83f, -0.1f, -1.13f, 0.2f);
        v12.lineTo(13.78f, 4.4f);
        v12.curveTo(13.6f, 4.16f, 13.32f, 4f, 13f, 4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineTo(8.82f);
        v12.curveTo(8.4f, 4.84f, 7.3f, 4f, 6f, 4f);
        v12.curveTo(4.34f, 4f, 3f, 5.34f, 3f, 7f);
        v12.curveToRelative(0f, 1.1f, 0.6f, 2.05f, 1.48f, 2.58f);
        v12.lineTo(7.08f, 18f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(13f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-1.62f);
        v12.lineTo(8.41f, 8.77f);
        v12.curveTo(8.58f, 8.53f, 8.72f, 8.28f, 8.82f, 8f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.curveToRelative(0.32f, 0f, 0.6f, -0.16f, 0.78f, -0.4f);
        v12.lineToRelative(1.74f, 1.74f);
        v12.curveToRelative(0.3f, 0.3f, 0.75f, 0.38f, 1.13f, 0.2f);
        v12.lineToRelative(3.92f, -1.83f);
        v12.curveToRelative(0.38f, -0.18f, 0.54f, -0.62f, 0.36f, -1f);
        v12.curveTo(20.75f, 8.34f, 20.309999f, 8.17f, 19.93f, 8.35f);
        v12.close();
        v12.moveTo(6f, 8f);
        v12.curveTo(5.45f, 8f, 5f, 7.55f, 5f, 7f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.curveTo(7f, 7.55f, 6.55f, 8f, 6f, 8f);
        v12.close();
        v12.moveTo(11.11f, 18f);
        v12.horizontalLineTo(9.17f);
        v12.lineToRelative(-2.46f, -8f);
        v12.horizontalLineToRelative(0.1f);
        v12.lineTo(11.11f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PrecisionManufacturingKt._precisionManufacturing = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

