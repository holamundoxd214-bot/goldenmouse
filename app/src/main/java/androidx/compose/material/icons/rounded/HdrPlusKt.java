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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hdrPlus", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HdrPlus", "Landroidx/compose/material/icons/Icons$Rounded;", "getHdrPlus", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HdrPlusKt {
    private static ImageVector _hdrPlus;

    static {
    }

    public static final ImageVector getHdrPlus(Rounded arg19) {
        ImageVector v0 = HdrPlusKt._hdrPlus;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.HdrPlus", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(8.5f, 14.5f);
        v0_1.horizontalLineToRelative(2f);
        v0_1.verticalLineToRelative(1f);
        v0_1.horizontalLineToRelative(-2f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(14.5f, 7.5f);
        v0_1.horizontalLineToRelative(1.5f);
        v0_1.verticalLineToRelative(3f);
        v0_1.horizontalLineToRelative(-1.5f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 15.5f);
        v12.curveToRelative(0f, 0.6f, -0.4f, 1.1f, -0.9f, 1.4f);
        v12.lineToRelative(0.49f, 1.13f);
        v12.curveToRelative(0.2f, 0.46f, -0.14f, 0.97f, -0.64f, 0.97f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.27f, 0f, -0.52f, -0.16f, -0.63f, -0.41f);
        v12.lineTo(9.6f, 17f);
        v12.horizontalLineTo(8.5f);
        v12.verticalLineToRelative(1.31f);
        v12.curveTo(8.5f, 18.690001f, 8.19f, 19f, 7.81f, 19f);
        v12.horizontalLineTo(7.69f);
        v12.curveTo(7.31f, 19f, 7f, 18.690001f, 7f, 18.309999f);
        v12.verticalLineTo(14f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(2.5f);
        v12.curveToRelative(0.82f, 0f, 1.5f, 0.68f, 1.5f, 1.5f);
        v12.verticalLineTo(15.5f);
        v12.close();
        v12.moveTo(11.25f, 12f);
        v12.lineTo(11.25f, 12f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineTo(9.5f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1.75f);
        v12.curveTo(8.5f, 11.66f, 8.16f, 12f, 7.75f, 12f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(7.34f, 12f, 7f, 11.66f, 7f, 11.25f);
        v12.verticalLineToRelative(-4.5f);
        v12.curveTo(7f, 6.34f, 7.34f, 6f, 7.75f, 6f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(8.16f, 6f, 8.5f, 6.34f, 8.5f, 6.75f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(6.75f);
        v12.curveTo(10.5f, 6.34f, 10.84f, 6f, 11.25f, 6f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(11.66f, 6f, 12f, 6.34f, 12f, 6.75f);
        v12.verticalLineToRelative(4.5f);
        v12.curveTo(12f, 11.66f, 11.66f, 12f, 11.25f, 12f);
        v12.close();
        v12.moveTo(16.75f, 16f);
        v12.horizontalLineTo(16f);
        v12.verticalLineToRelative(0.75f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.41f, 0f, -0.75f, -0.34f, -0.75f, -0.75f);
        v12.verticalLineTo(16f);
        v12.horizontalLineToRelative(-0.75f);
        v12.curveTo(13.34f, 16f, 13f, 15.66f, 13f, 15.25f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineToRelative(0.75f);
        v12.verticalLineToRelative(-0.75f);
        v12.curveToRelative(0f, -0.41f, 0.34f, -0.75f, 0.75f, -0.75f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(0.74f);
        v12.horizontalLineToRelative(0.75f);
        v12.curveToRelative(0.41f, 0f, 0.75f, 0.34f, 0.75f, 0.75f);
        v12.verticalLineToRelative(0.01f);
        v12.curveTo(17.5f, 15.66f, 17.16f, 16f, 16.75f, 16f);
        v12.close();
        v12.moveTo(17.5f, 10.5f);
        v12.curveToRelative(0f, 0.82f, -0.67f, 1.5f, -1.5f, 1.5f);
        v12.horizontalLineToRelative(-2.5f);
        v12.curveToRelative(-0.28f, 0f, -0.5f, -0.22f, -0.5f, -0.5f);
        v12.verticalLineToRelative(-5f);
        v12.curveTo(13f, 6.22f, 13.22f, 6f, 13.5f, 6f);
        v12.horizontalLineTo(16f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.68f, 1.5f, 1.5f);
        v12.verticalLineTo(10.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HdrPlusKt._hdrPlus = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

