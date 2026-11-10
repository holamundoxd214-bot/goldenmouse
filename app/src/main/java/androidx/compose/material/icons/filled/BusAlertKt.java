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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_busAlert", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BusAlert", "Landroidx/compose/material/icons/Icons$Filled;", "getBusAlert", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BusAlertKt {
    private static ImageVector _busAlert;

    static {
    }

    public static final ImageVector getBusAlert(Filled arg20) {
        ImageVector v0 = BusAlertKt._busAlert;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.BusAlert", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 1f);
        v12.arcToRelative(7f, 7f, 0f, false, false, -5.78f, 3.05f);
        v12.lineToRelative(0.02f, -0.03f);
        v12.curveTo(9.84f, 4f, 9.42f, 4f, 9f, 4f);
        v12.curveToRelative(-4.42f, 0f, -8f, 0.5f, -8f, 4f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 0.88f, 0.39f, 1.67f, 1f, 2.22f);
        v12.lineTo(2f, 22f);
        v12.arcToRelative(1f, 1f, 0f, false, false, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.arcToRelative(1f, 1f, 0f, false, false, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(1f);
        v12.arcToRelative(1f, 1f, 0f, false, false, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.arcToRelative(1f, 1f, 0f, false, false, 1f, -1f);
        v12.verticalLineToRelative(-1.78f);
        v12.curveToRelative(0.61f, -0.55f, 1f, -1.34f, 1f, -2.22f);
        v12.verticalLineToRelative(-3.08f);
        v12.arcTo(7f, 7f, 0f, false, false, 16f, 1f);
        v12.close();
        v12.moveTo(4.5f, 19f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 0f, -3f);
        v12.arcToRelative(1.5f, 1.5f, 0f, false, true, 0f, 3f);
        v12.close();
        v12.moveTo(3f, 13f);
        v12.lineTo(3f, 8f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0f, 1.96f, 0.81f, 3.73f, 2.11f, 5f);
        v12.lineTo(3f, 13f);
        v12.close();
        v12.moveTo(13.5f, 19f);
        v12.arcToRelative(1.5f, 1.5f, 0f, true, true, 0f, -3f);
        v12.arcToRelative(1.5f, 1.5f, 0f, false, true, 0f, 3f);
        v12.close();
        v12.moveTo(16f, 13f);
        v12.arcToRelative(5f, 5f, 0f, true, true, 0f, -10f);
        v12.arcToRelative(5f, 5f, 0f, false, true, 0f, 10f);
        v12.close();
        v12.moveTo(15f, 4f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v12.moveTo(15f, 10f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BusAlertKt._busAlert = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

