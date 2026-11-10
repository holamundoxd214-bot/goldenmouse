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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_hdrEnhancedSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HdrEnhancedSelect", "Landroidx/compose/material/icons/Icons$Filled;", "getHdrEnhancedSelect", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HdrEnhancedSelectKt {
    private static ImageVector _hdrEnhancedSelect;

    static {
    }

    public static final ImageVector getHdrEnhancedSelect(Filled arg19) {
        ImageVector v0 = HdrEnhancedSelectKt._hdrEnhancedSelect;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.HdrEnhancedSelect", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f);
        v12.reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f);
        v12.reflectiveCurveToRelative(-6f, -2.69f, -6f, -6f);
        v12.reflectiveCurveToRelative(2.69f, -6f, 6f, -6f);
        v12.close();
        v12.moveTo(12f, 4f);
        v12.curveTo(9.79f, 4f, 8f, 5.79f, 8f, 8f);
        v12.reflectiveCurveToRelative(1.79f, 4f, 4f, 4f);
        v12.reflectiveCurveToRelative(4f, -1.79f, 4f, -4f);
        v12.reflectiveCurveToRelative(-1.79f, -4f, -4f, -4f);
        v12.close();
        v12.moveTo(13f, 11f);
        v12.horizontalLineToRelative(-2f);
        v12.lineTo(11f, 9f);
        v12.lineTo(9f, 9f);
        v12.lineTo(9f, 7f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(11f, 5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.close();
        v12.moveTo(24f, 20f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-1.5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-2f);
        v12.lineTo(22f, 16.5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.lineTo(24f, 20f);
        v12.close();
        v12.moveTo(18f, 18.5f);
        v12.curveToRelative(0f, 0.6f, -0.4f, 1.1f, -0.9f, 1.4f);
        v12.lineTo(18f, 22f);
        v12.horizontalLineToRelative(-1.5f);
        v12.lineToRelative(-0.9f, -2f);
        v12.horizontalLineToRelative(-1.1f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(13f, 22f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(3.5f);
        v12.curveToRelative(0.8f, 0f, 1.5f, 0.7f, 1.5f, 1.5f);
        v12.verticalLineToRelative(1f);
        v12.close();
        v12.moveTo(16.5f, 18.5f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2f);
        v12.close();
        v12.moveTo(3.5f, 18f);
        v12.verticalLineToRelative(-2f);
        v12.lineTo(5f, 16f);
        v12.verticalLineToRelative(6f);
        v12.lineTo(3.5f, 22f);
        v12.verticalLineToRelative(-2.5f);
        v12.horizontalLineToRelative(-2f);
        v12.lineTo(1.5f, 22f);
        v12.lineTo(0f, 22f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.close();
        v12.moveTo(10f, 16f);
        v12.curveToRelative(0.8f, 0f, 1.5f, 0.7f, 1.5f, 1.5f);
        v12.verticalLineToRelative(3f);
        v12.curveToRelative(0f, 0.8f, -0.7f, 1.5f, -1.5f, 1.5f);
        v12.lineTo(6.5f, 22f);
        v12.verticalLineToRelative(-6f);
        v12.lineTo(10f, 16f);
        v12.close();
        v12.moveTo(10f, 20.5f);
        v12.verticalLineToRelative(-3f);
        v12.lineTo(8f, 17.5f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HdrEnhancedSelectKt._hdrEnhancedSelect = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

