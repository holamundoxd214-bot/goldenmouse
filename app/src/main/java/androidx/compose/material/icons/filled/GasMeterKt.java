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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_gasMeter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "GasMeter", "Landroidx/compose/material/icons/Icons$Filled;", "getGasMeter", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GasMeterKt {
    private static ImageVector _gasMeter;

    static {
    }

    public static final ImageVector getGasMeter(Filled arg19) {
        ImageVector v0 = GasMeterKt._gasMeter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.GasMeter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 4f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineTo(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(2f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(8f);
        v12.curveTo(5.79f, 4f, 4f, 5.79f, 4f, 8f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.horizontalLineToRelative(8f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.verticalLineTo(8f);
        v12.curveTo(20f, 5.79f, 18.209999f, 4f, 16f, 4f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, -1.1f, -2.5f, -2.46f);
        v12.curveToRelative(0f, -1.09f, 0.43f, -1.39f, 2.5f, -3.79f);
        v12.curveToRelative(2.05f, 2.38f, 2.5f, 2.7f, 2.5f, 3.79f);
        v12.curveTo(14.5f, 16.9f, 13.38f, 18f, 12f, 18f);
        v12.close();
        v12.moveTo(16f, 10f);
        v12.horizontalLineTo(8f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GasMeterKt._gasMeter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

