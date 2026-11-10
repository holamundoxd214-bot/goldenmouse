package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_evStation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EvStation", "Landroidx/compose/material/icons/Icons$Sharp;", "getEvStation", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EvStationKt {
    private static ImageVector _evStation;

    static {
    }

    public static final ImageVector getEvStation(Sharp arg19) {
        ImageVector v0 = EvStationKt._evStation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.EvStation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.77f, 7.23f);
        v12.lineToRelative(0.01f, -0.01f);
        v12.lineToRelative(-3.72f, -3.72f);
        v12.lineTo(15f, 4.56f);
        v12.lineToRelative(2.11f, 2.11f);
        v12.curveToRelative(-1.05f, 0.4f, -1.76f, 1.47f, -1.58f, 2.71f);
        v12.curveToRelative(0.16f, 1.1f, 1.1f, 1.99f, 2.2f, 2.11f);
        v12.curveToRelative(0.47f, 0.05f, 0.88f, -0.03f, 1.27f, -0.2f);
        v12.verticalLineToRelative(8.21f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(12f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(18f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(-7.5f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, -0.69f, -0.28f, -1.32f, -0.73f, -1.77f);
        v12.close();
        v12.moveTo(18f, 10f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.close();
        v12.moveTo(8f, 18f);
        v12.verticalLineToRelative(-4.5f);
        v12.horizontalLineTo(6f);
        v12.lineTo(10f, 6f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(2f);
        v12.lineToRelative(-4f, 7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EvStationKt._evStation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

