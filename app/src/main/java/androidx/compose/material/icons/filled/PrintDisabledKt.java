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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_printDisabled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PrintDisabled", "Landroidx/compose/material/icons/Icons$Filled;", "getPrintDisabled", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PrintDisabledKt {
    private static ImageVector _printDisabled;

    static {
    }

    public static final ImageVector getPrintDisabled(Filled arg19) {
        ImageVector v0 = PrintDisabledKt._printDisabled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.PrintDisabled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.1f, 17f);
        v12.lineTo(22f, 17f);
        v12.verticalLineToRelative(-6f);
        v12.curveToRelative(0f, -1.7f, -1.3f, -3f, -3f, -3f);
        v12.horizontalLineToRelative(-9f);
        v12.lineToRelative(9.1f, 9f);
        v12.close();
        v12.moveTo(19f, 10f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.close();
        v12.moveTo(18f, 7f);
        v12.lineTo(18f, 3f);
        v12.lineTo(6f, 3f);
        v12.verticalLineToRelative(1.1f);
        v12.lineTo(9f, 7f);
        v12.close();
        v12.moveTo(1.2f, 1.8f);
        v12.lineTo(0f, 3f);
        v12.lineToRelative(4.9f, 5f);
        v12.curveTo(3.3f, 8.1f, 2f, 9.4f, 2f, 11f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(11.9f);
        v12.lineToRelative(3f, 3f);
        v12.lineToRelative(1.3f, -1.3f);
        v12.lineToRelative(-21f, -20.9f);
        v12.close();
        v12.moveTo(8f, 19f);
        v12.verticalLineToRelative(-5f);
        v12.horizontalLineToRelative(2.9f);
        v12.lineToRelative(5f, 5f);
        v12.lineTo(8f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PrintDisabledKt._printDisabled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

