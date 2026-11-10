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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tram", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Tram", "Landroidx/compose/material/icons/Icons$Filled;", "getTram", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TramKt {
    private static ImageVector _tram;

    static {
    }

    public static final ImageVector getTram(Filled arg19) {
        ImageVector v0 = TramKt._tram;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Tram", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 16.940001f);
        v12.lineTo(19f, 8.5f);
        v12.curveToRelative(0f, -2.79f, -2.61f, -3.4f, -6.01f, -3.49f);
        v12.lineToRelative(0.76f, -1.51f);
        v12.lineTo(17f, 3.5f);
        v12.lineTo(17f, 2f);
        v12.lineTo(7f, 2f);
        v12.verticalLineToRelative(1.5f);
        v12.horizontalLineToRelative(4.75f);
        v12.lineToRelative(-0.76f, 1.52f);
        v12.curveTo(7.86f, 5.11f, 5f, 5.73f, 5f, 8.5f);
        v12.verticalLineToRelative(8.44f);
        v12.curveToRelative(0f, 1.45f, 1.19f, 2.66f, 2.59f, 2.97f);
        v12.lineTo(6f, 21.5f);
        v12.verticalLineToRelative(0.5f);
        v12.horizontalLineToRelative(2.23f);
        v12.lineToRelative(2f, -2f);
        v12.lineTo(14f, 20f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-0.5f);
        v12.lineTo(16.5f, 20f);
        v12.horizontalLineToRelative(-0.08f);
        v12.curveToRelative(1.69f, 0f, 2.58f, -1.37f, 2.58f, -3.06f);
        v12.close();
        v12.moveTo(12f, 18.5f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f);
        v12.close();
        v12.moveTo(17f, 14f);
        v12.lineTo(7f, 14f);
        v12.lineTo(7f, 9f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TramKt._tram = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

