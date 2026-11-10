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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_directionsOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirectionsOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getDirectionsOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirectionsOffKt {
    private static ImageVector _directionsOff;

    static {
    }

    public static final ImageVector getDirectionsOff(Rounded arg19) {
        ImageVector v0 = DirectionsOffKt._directionsOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DirectionsOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.709999f, 11.29f);
        v12.lineToRelative(-9f, -9f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineTo(8.21f, 5.38f);
        v12.lineTo(13f, 10.17f);
        v12.lineToRelative(0f, -2.67f);
        v12.lineToRelative(3.15f, 3.15f);
        v12.curveToRelative(0.2f, 0.2f, 0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(-0.98f, 0.98f);
        v12.lineToRelative(3.45f, 3.45f);
        v12.lineToRelative(3.09f, -3.09f);
        v12.curveTo(22.09f, 12.32f, 22.09f, 11.69f, 21.709999f, 11.29f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(6.79f, 6.79f);
        v12.lineTo(3.51f, 3.51f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(3.28f, 3.28f);
        v12.lineToRelative(-3.09f, 3.09f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(9f, 9f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(3.09f, -3.09f);
        v12.lineToRelative(3.28f, 3.28f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(6.79f, 6.79f);
        v12.close();
        v12.moveTo(9.99f, 14f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-3f);
        v12.curveToRelative(0f, -0.05f, 0.02f, -0.1f, 0.03f, -0.15f);
        v12.lineToRelative(1.97f, 1.97f);
        v12.verticalLineTo(14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirectionsOffKt._directionsOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

