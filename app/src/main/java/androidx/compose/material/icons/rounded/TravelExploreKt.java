package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_travelExplore", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TravelExplore", "Landroidx/compose/material/icons/Icons$Rounded;", "getTravelExplore", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TravelExploreKt {
    private static ImageVector _travelExplore;

    static {
    }

    public static final ImageVector getTravelExplore(Rounded arg19) {
        ImageVector v0 = TravelExploreKt._travelExplore;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.TravelExplore", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.299999f, 16.9f);
        v12.curveToRelative(0.58f, -1.01f, 0.95f, -2.23f, 0.51f, -3.65f);
        v12.curveToRelative(-0.53f, -1.72f, -2.04f, -3.05f, -3.84f, -3.22f);
        v12.curveToRelative(-2.87f, -0.28f, -5.23f, 2.07f, -4.95f, 4.95f);
        v12.curveToRelative(0.18f, 1.79f, 1.5f, 3.31f, 3.22f, 3.84f);
        v12.curveToRelative(1.43f, 0.44f, 2.64f, 0.07f, 3.65f, -0.51f);
        v12.lineToRelative(2.5f, 2.5f);
        v12.curveToRelative(0.39f, 0.39f, 1.01f, 0.39f, 1.4f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.01f, 0f, -1.4f);
        v12.lineTo(19.299999f, 16.9f);
        v12.close();
        v12.moveTo(15.5f, 17f);
        v12.curveToRelative(-1.4f, 0f, -2.5f, -1.1f, -2.5f, -2.5f);
        v12.reflectiveCurveToRelative(1.1f, -2.5f, 2.5f, -2.5f);
        v12.reflectiveCurveToRelative(2.5f, 1.1f, 2.5f, 2.5f);
        v12.reflectiveCurveTo(16.9f, 17f, 15.5f, 17f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.verticalLineToRelative(2f);
        v12.curveTo(6.48f, 22f, 2f, 17.52f, 2f, 12f);
        v12.curveTo(2f, 6.48f, 6.48f, 2f, 12f, 2f);
        v12.curveToRelative(4.84f, 0f, 8.87f, 3.44f, 9.8f, 8f);
        v12.horizontalLineToRelative(-2.07f);
        v12.curveToRelative(-0.64f, -2.46f, -2.4f, -4.47f, -4.73f, -5.41f);
        v12.verticalLineTo(5f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(9f);
        v12.lineToRelative(-4.79f, -4.79f);
        v12.curveTo(4.08f, 10.79f, 4f, 11.38f, 4f, 12f);
        v12.curveTo(4f, 16.41f, 7.59f, 20f, 12f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TravelExploreKt._travelExplore = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

