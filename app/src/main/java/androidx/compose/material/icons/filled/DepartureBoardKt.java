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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_departureBoard", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DepartureBoard", "Landroidx/compose/material/icons/Icons$Filled;", "getDepartureBoard", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DepartureBoardKt {
    private static ImageVector _departureBoard;

    static {
    }

    public static final ImageVector getDepartureBoard(Filled arg19) {
        ImageVector v0 = DepartureBoardKt._departureBoard;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.DepartureBoard", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 1f);
        v12.curveToRelative(-2.4f, 0f, -4.52f, 1.21f, -5.78f, 3.05f);
        v12.curveToRelative(0.01f, -0.01f, 0.01f, -0.02f, 0.02f, -0.03f);
        v12.curveTo(9.84f, 4f, 9.42f, 4f, 9f, 4f);
        v12.curveToRelative(-4.42f, 0f, -8f, 0.5f, -8f, 4f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 0.88f, 0.39f, 1.67f, 1f, 2.22f);
        v12.lineTo(2f, 22f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-1.78f);
        v12.curveToRelative(0.61f, -0.55f, 1f, -1.34f, 1f, -2.22f);
        v12.verticalLineToRelative(-3.08f);
        v12.curveToRelative(3.39f, -0.49f, 6f, -3.39f, 6f, -6.92f);
        v12.curveToRelative(0f, -3.87f, -3.13f, -7f, -7f, -7f);
        v12.close();
        v12.moveTo(4.5f, 19f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(3.67f, 16f, 4.5f, 16f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(5.33f, 19f, 4.5f, 19f);
        v12.close();
        v12.moveTo(3f, 13f);
        v12.lineTo(3f, 8f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(0f, 1.96f, 0.81f, 3.73f, 2.11f, 5f);
        v12.lineTo(3f, 13f);
        v12.close();
        v12.moveTo(13.5f, 19f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f);
        v12.close();
        v12.moveTo(16f, 13f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.reflectiveCurveToRelative(2.24f, -5f, 5f, -5f);
        v12.reflectiveCurveToRelative(5f, 2.24f, 5f, 5f);
        v12.reflectiveCurveToRelative(-2.24f, 5f, -5f, 5f);
        v12.close();
        v12.moveTo(16.5f, 4f);
        v12.lineTo(15f, 4f);
        v12.verticalLineToRelative(5f);
        v12.lineToRelative(3.62f, 2.16f);
        v12.lineToRelative(0.75f, -1.23f);
        v12.lineToRelative(-2.87f, -1.68f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DepartureBoardKt._departureBoard = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

