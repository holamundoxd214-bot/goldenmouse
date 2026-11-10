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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u001E\u0010\u0002\u001A\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"_directionsWalk", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsWalk", "Landroidx/compose/material/icons/Icons$Filled;", "getDirectionsWalk$annotations", "(Landroidx/compose/material/icons/Icons$Filled;)V", "getDirectionsWalk", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsWalkKt {
    private static ImageVector _directionsWalk;

    static {
    }

    public static final ImageVector getDirectionsWalk(Filled arg19) {
        ImageVector v0 = DirectionsWalkKt._directionsWalk;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.DirectionsWalk", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.lineTo(7f, 23f);
        v12.horizontalLineToRelative(2.1f);
        v12.lineToRelative(1.8f, -8f);
        v12.lineToRelative(2.1f, 2f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-7.5f);
        v12.lineToRelative(-2.1f, -2f);
        v12.lineToRelative(0.6f, -3f);
        v12.curveTo(14.8f, 12f, 16.799999f, 13f, 19f, 13f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(-1.9f, 0f, -3.5f, -1f, -4.3f, -2.4f);
        v12.lineToRelative(-1f, -1.6f);
        v12.curveToRelative(-0.4f, -0.6f, -1f, -1f, -1.7f, -1f);
        v12.curveToRelative(-0.3f, 0f, -0.5f, 0.1f, -0.8f, 0.1f);
        v12.lineTo(6f, 8.3f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9.6f);
        v12.lineToRelative(1.8f, -0.7f);
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsWalkKt._directionsWalk = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="Use the AutoMirrored version at Icons.AutoMirrored.Filled.DirectionsWalk", replaceWith="<_subannotation>") public static void getDirectionsWalk$annotations(Filled arg0) {
    }
}

