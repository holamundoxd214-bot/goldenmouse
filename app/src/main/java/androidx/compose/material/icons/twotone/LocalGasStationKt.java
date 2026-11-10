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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localGasStation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalGasStation", "Landroidx/compose/material/icons/Icons$TwoTone;", "getLocalGasStation", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalGasStationKt {
    private static ImageVector _localGasStation;

    static {
    }

    public static final ImageVector getLocalGasStation(TwoTone arg19) {
        ImageVector v0 = LocalGasStationKt._localGasStation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.LocalGasStation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(6f, 19f);
        v0_1.horizontalLineToRelative(6f);
        v0_1.verticalLineToRelative(-7f);
        v0_1.horizontalLineTo(6f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 3f);
        v12.lineTo(6f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(16f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(-7.5f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f);
        v12.reflectiveCurveToRelative(2.5f, -1.12f, 2.5f, -2.5f);
        v12.lineTo(20.5f, 9f);
        v12.curveToRelative(0f, -0.69f, -0.28f, -1.32f, -0.73f, -1.77f);
        v12.lineToRelative(0.01f, -0.01f);
        v12.lineToRelative(-3.72f, -3.72f);
        v12.lineTo(15f, 4.56f);
        v12.lineToRelative(2.11f, 2.11f);
        v12.curveToRelative(-0.94f, 0.36f, -1.61f, 1.26f, -1.61f, 2.33f);
        v12.curveToRelative(0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f);
        v12.curveToRelative(0.36f, 0f, 0.69f, -0.08f, 1f, -0.21f);
        v12.verticalLineToRelative(7.21f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.lineTo(17f, 14f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-1f);
        v12.lineTo(14f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(12f, 13.5f);
        v12.lineTo(12f, 19f);
        v12.lineTo(6f, 19f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(1.5f);
        v12.close();
        v12.moveTo(12f, 10f);
        v12.lineTo(6f, 10f);
        v12.lineTo(6f, 5f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(5f);
        v12.close();
        v12.moveTo(18f, 10f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalGasStationKt._localGasStation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

