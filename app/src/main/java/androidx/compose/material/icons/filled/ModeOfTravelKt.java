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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_modeOfTravel", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ModeOfTravel", "Landroidx/compose/material/icons/Icons$Filled;", "getModeOfTravel", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ModeOfTravelKt {
    private static ImageVector _modeOfTravel;

    static {
    }

    public static final ImageVector getModeOfTravel(Filled arg19) {
        ImageVector v0 = ModeOfTravelKt._modeOfTravel;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.ModeOfTravel", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.31f, 18.9f);
        v12.curveToRelative(-0.96f, 1f, -2.06f, 2.03f, -3.31f, 3.1f);
        v12.curveToRelative(-5.33f, -4.55f, -8f, -8.48f, -8f, -11.8f);
        v12.curveTo(4f, 5.22f, 7.8f, 2f, 12f, 2f);
        v12.curveToRelative(4f, 0f, 7.64f, 2.92f, 7.97f, 7.5f);
        v12.lineToRelative(3.53f, 0f);
        v12.lineTo(19f, 14f);
        v12.lineToRelative(-4.5f, -4.5f);
        v12.lineToRelative(3.47f, 0f);
        v12.curveTo(17.65f, 6.24f, 15.13f, 4f, 12f, 4f);
        v12.curveToRelative(-3.35f, 0f, -6f, 2.57f, -6f, 6.2f);
        v12.curveToRelative(0f, 2.34f, 1.95f, 5.44f, 6f, 9.14f);
        v12.curveToRelative(0.64f, -0.59f, 1.23f, -1.16f, 1.77f, -1.71f);
        v12.curveToRelative(-0.17f, -0.34f, -0.27f, -0.72f, -0.27f, -1.12f);
        v12.curveToRelative(0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        v12.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        v12.reflectiveCurveTo(17.379999f, 19f, 16f, 19f);
        v12.curveTo(15.76f, 19f, 15.53f, 18.969999f, 15.31f, 18.9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ModeOfTravelKt._modeOfTravel = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

