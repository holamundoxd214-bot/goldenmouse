package androidx.compose.material.icons.automirrored.rounded;

import androidx.compose.material.icons.Icons$AutoMirrored$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsWalk", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsWalk", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getDirectionsWalk", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsWalkKt {
    private static ImageVector _directionsWalk;

    static {
    }

    public static final ImageVector getDirectionsWalk(Rounded arg19) {
        ImageVector v0 = DirectionsWalkKt._directionsWalk;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.DirectionsWalk", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.5f, 5.5f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(9.8f, 8.9f);
        v12.lineTo(7.24f, 21.809999f);
        v12.curveToRelative(-0.13f, 0.61f, 0.35f, 1.19f, 0.98f, 1.19f);
        v12.horizontalLineToRelative(0.08f);
        v12.curveToRelative(0.47f, 0f, 0.87f, -0.32f, 0.98f, -0.78f);
        v12.lineTo(10.9f, 15f);
        v12.lineToRelative(2.1f, 2f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-5.64f);
        v12.curveToRelative(0f, -0.55f, -0.22f, -1.07f, -0.62f, -1.45f);
        v12.lineTo(12.9f, 13.5f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveToRelative(1.07f, 1.24f, 2.62f, 2.13f, 4.36f, 2.41f);
        v12.curveToRelative(0.6f, 0.09f, 1.14f, -0.39f, 1.14f, -1f);
        v12.curveToRelative(0f, -0.49f, -0.36f, -0.9f, -0.85f, -0.98f);
        v12.curveToRelative(-1.52f, -0.25f, -2.78f, -1.15f, -3.45f, -2.33f);
        v12.lineToRelative(-1f, -1.6f);
        v12.curveToRelative(-0.56f, -0.89f, -1.68f, -1.25f, -2.65f, -0.84f);
        v12.lineTo(7.22f, 7.78f);
        v12.curveTo(6.48f, 8.1f, 6f, 8.82f, 6f, 9.63f);
        v12.verticalLineTo(12f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(9.6f);
        v12.lineToRelative(1.8f, -0.7f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsWalkKt._directionsWalk = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

