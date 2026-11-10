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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsBus", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsBus", "Landroidx/compose/material/icons/Icons$Sharp;", "getDirectionsBus", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsBusKt {
    private static ImageVector _directionsBus;

    static {
    }

    public static final ImageVector getDirectionsBus(Sharp arg19) {
        ImageVector v0 = DirectionsBusKt._directionsBus;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.DirectionsBus", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(4f, 16f);
        v12.curveToRelative(0f, 0.88f, 0.39f, 1.67f, 1f, 2.22f);
        v12.lineTo(5f, 21f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(-2.78f);
        v12.curveToRelative(0.61f, -0.55f, 1f, -1.34f, 1f, -2.22f);
        v12.lineTo(20f, 6f);
        v12.curveToRelative(0f, -3.5f, -3.58f, -4f, -8f, -4f);
        v12.reflectiveCurveToRelative(-8f, 0.5f, -8f, 4f);
        v12.verticalLineToRelative(10f);
        v12.close();
        v12.moveTo(7.5f, 17f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveTo(6.67f, 14f, 7.5f, 14f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(8.33f, 17f, 7.5f, 17f);
        v12.close();
        v12.moveTo(16.5f, 17f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveToRelative(-0.67f, 1.5f, -1.5f, 1.5f);
        v12.close();
        v12.moveTo(18f, 11f);
        v12.lineTo(6f, 11f);
        v12.lineTo(6f, 6f);
        v12.horizontalLineToRelative(12f);
        v12.verticalLineToRelative(5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsBusKt._directionsBus = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

