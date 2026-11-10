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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_airlineSeatFlatAngled", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AirlineSeatFlatAngled", "Landroidx/compose/material/icons/Icons$Filled;", "getAirlineSeatFlatAngled", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AirlineSeatFlatAngledKt {
    private static ImageVector _airlineSeatFlatAngled;

    static {
    }

    public static final ImageVector getAirlineSeatFlatAngled(Filled arg19) {
        ImageVector v0 = AirlineSeatFlatAngledKt._airlineSeatFlatAngled;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.AirlineSeatFlatAngled", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(22.25f, 14.29f);
        v12.lineToRelative(-0.69f, 1.89f);
        v12.lineTo(9.2f, 11.71f);
        v12.lineToRelative(2.08f, -5.66f);
        v12.lineToRelative(8.56f, 3.09f);
        v12.curveToRelative(2.1f, 0.76f, 3.18f, 3.06f, 2.41f, 5.15f);
        v12.close();
        v12.moveTo(1.5f, 12.14f);
        v12.lineTo(8f, 14.48f);
        v12.lineTo(8f, 19f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(-1.63f);
        v12.lineTo(20.52f, 19f);
        v12.lineToRelative(0.69f, -1.89f);
        v12.lineToRelative(-19.02f, -6.86f);
        v12.lineToRelative(-0.69f, 1.89f);
        v12.close();
        v12.moveTo(7.3f, 10.2f);
        v12.curveToRelative(1.49f, -0.72f, 2.12f, -2.51f, 1.41f, -4f);
        v12.curveTo(7.99f, 4.71f, 6.2f, 4.08f, 4.7f, 4.8f);
        v12.curveToRelative(-1.49f, 0.71f, -2.12f, 2.5f, -1.4f, 4f);
        v12.curveToRelative(0.71f, 1.49f, 2.5f, 2.12f, 4f, 1.4f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AirlineSeatFlatAngledKt._airlineSeatFlatAngled = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

