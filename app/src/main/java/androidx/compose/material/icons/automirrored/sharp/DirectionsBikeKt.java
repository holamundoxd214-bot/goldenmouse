package androidx.compose.material.icons.automirrored.sharp;

import androidx.compose.material.icons.Icons$AutoMirrored$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsBike", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsBike", "Landroidx/compose/material/icons/Icons$AutoMirrored$Sharp;", "getDirectionsBike", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsBikeKt {
    private static ImageVector _directionsBike;

    static {
    }

    public static final ImageVector getDirectionsBike(Sharp arg19) {
        ImageVector v0 = DirectionsBikeKt._directionsBike;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Sharp.DirectionsBike", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.5f, 5.5f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f);
        v12.reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f);
        v12.reflectiveCurveToRelative(0.9f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(5f, 12f);
        v12.curveToRelative(-2.8f, 0f, -5f, 2.2f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.2f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.2f, 5f, -5f);
        v12.reflectiveCurveToRelative(-2.2f, -5f, -5f, -5f);
        v12.close();
        v12.moveTo(5f, 20.5f);
        v12.curveToRelative(-1.9f, 0f, -3.5f, -1.6f, -3.5f, -3.5f);
        v12.reflectiveCurveToRelative(1.6f, -3.5f, 3.5f, -3.5f);
        v12.reflectiveCurveToRelative(3.5f, 1.6f, 3.5f, 3.5f);
        v12.reflectiveCurveToRelative(-1.6f, 3.5f, -3.5f, 3.5f);
        v12.close();
        v12.moveTo(10.8f, 10.5f);
        v12.lineToRelative(2.4f, -2.4f);
        v12.lineToRelative(0.8f, 0.8f);
        v12.curveToRelative(1.3f, 1.3f, 3f, 2.1f, 5.1f, 2.1f);
        v12.lineTo(19.1f, 9f);
        v12.curveToRelative(-1.5f, 0f, -2.7f, -0.6f, -3.6f, -1.5f);
        v12.lineToRelative(-1.9f, -1.9f);
        v12.curveToRelative(-0.5f, -0.4f, -1f, -0.6f, -1.6f, -0.6f);
        v12.reflectiveCurveToRelative(-1.1f, 0.2f, -1.4f, 0.6f);
        v12.lineTo(6.31f, 9.9f);
        v12.lineTo(11f, 14f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-6.2f);
        v12.lineToRelative(-2.2f, -2.3f);
        v12.close();
        v12.moveTo(19f, 12f);
        v12.curveToRelative(-2.8f, 0f, -5f, 2.2f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.2f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.2f, 5f, -5f);
        v12.reflectiveCurveToRelative(-2.2f, -5f, -5f, -5f);
        v12.close();
        v12.moveTo(19f, 20.5f);
        v12.curveToRelative(-1.9f, 0f, -3.5f, -1.6f, -3.5f, -3.5f);
        v12.reflectiveCurveToRelative(1.6f, -3.5f, 3.5f, -3.5f);
        v12.reflectiveCurveToRelative(3.5f, 1.6f, 3.5f, 3.5f);
        v12.reflectiveCurveToRelative(-1.6f, 3.5f, -3.5f, 3.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsBikeKt._directionsBike = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

