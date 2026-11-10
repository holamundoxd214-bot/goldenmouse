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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsRun", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsRun", "Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;", "getDirectionsRun", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsRunKt {
    private static ImageVector _directionsRun;

    static {
    }

    public static final ImageVector getDirectionsRun(Rounded arg19) {
        ImageVector v0 = DirectionsRunKt._directionsRun;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Rounded.DirectionsRun", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.49f, 5.48f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(10.32f, 17.48f);
        v12.lineToRelative(0.57f, -2.5f);
        v12.lineToRelative(2.1f, 2f);
        v12.verticalLineToRelative(5f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-5.64f);
        v12.curveToRelative(0f, -0.55f, -0.22f, -1.07f, -0.62f, -1.45f);
        v12.lineToRelative(-1.48f, -1.41f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveToRelative(1.07f, 1.24f, 2.62f, 2.13f, 4.36f, 2.41f);
        v12.curveToRelative(0.6f, 0.09f, 1.14f, -0.39f, 1.14f, -1f);
        v12.curveToRelative(0f, -0.49f, -0.36f, -0.9f, -0.85f, -0.98f);
        v12.curveToRelative(-1.52f, -0.25f, -2.78f, -1.15f, -3.45f, -2.33f);
        v12.lineToRelative(-1f, -1.6f);
        v12.curveToRelative(-0.4f, -0.6f, -1f, -1f, -1.7f, -1f);
        v12.curveToRelative(-0.3f, 0f, -0.5f, 0.1f, -0.8f, 0.1f);
        v12.lineTo(7.21f, 7.76f);
        v12.curveToRelative(-0.74f, 0.32f, -1.22f, 1.04f, -1.22f, 1.85f);
        v12.verticalLineToRelative(2.37f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.reflectiveCurveToRelative(1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2.4f);
        v12.lineToRelative(1.8f, -0.7f);
        v12.lineToRelative(-1.6f, 8.1f);
        v12.lineToRelative(-3.92f, -0.8f);
        v12.curveToRelative(-0.54f, -0.11f, -1.07f, 0.24f, -1.18f, 0.78f);
        v12.lineTo(3.09f, 17f);
        v12.curveToRelative(-0.11f, 0.54f, 0.24f, 1.07f, 0.78f, 1.18f);
        v12.lineToRelative(4.11f, 0.82f);
        v12.curveToRelative(1.06f, 0.21f, 2.1f, -0.46f, 2.34f, -1.52f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsRunKt._directionsRun = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

