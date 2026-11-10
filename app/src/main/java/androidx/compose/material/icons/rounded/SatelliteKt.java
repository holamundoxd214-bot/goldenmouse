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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_satellite", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Satellite", "Landroidx/compose/material/icons/Icons$Rounded;", "getSatellite", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SatelliteKt {
    private static ImageVector _satellite;

    static {
    }

    public static final ImageVector getSatellite(Rounded arg19) {
        ImageVector v0 = SatelliteKt._satellite;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Satellite", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.lineTo(5f, 3f);
        v12.curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.lineTo(21f, 5f);
        v12.curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f);
        v12.close();
        v12.moveTo(5f, 5f);
        v12.horizontalLineToRelative(3f);
        v12.curveToRelative(0f, 1.66f, -1.34f, 3f, -3f, 3f);
        v12.lineTo(5f, 5f);
        v12.close();
        v12.moveTo(5f, 10.91f);
        v12.curveToRelative(0f, -0.49f, 0.36f, -0.9f, 0.85f, -0.98f);
        v12.curveToRelative(2.08f, -0.36f, 3.72f, -2f, 4.08f, -4.08f);
        v12.curveToRelative(0.08f, -0.49f, 0.49f, -0.85f, 0.98f, -0.85f);
        v12.curveToRelative(0.61f, 0f, 1.09f, 0.53f, 1f, 1.13f);
        v12.curveToRelative(-0.48f, 2.96f, -2.81f, 5.3f, -5.77f, 5.78f);
        v12.curveToRelative(-0.6f, 0.1f, -1.14f, -0.39f, -1.14f, -1f);
        v12.close();
        v12.moveTo(5.63f, 17.190001f);
        v12.lineToRelative(2.49f, -3.2f);
        v12.curveToRelative(0.2f, -0.25f, 0.58f, -0.26f, 0.78f, -0.01f);
        v12.lineToRelative(2.1f, 2.53f);
        v12.lineToRelative(3.1f, -3.99f);
        v12.curveToRelative(0.2f, -0.26f, 0.6f, -0.26f, 0.8f, 0.01f);
        v12.lineToRelative(3.51f, 4.68f);
        v12.curveToRelative(0.25f, 0.33f, 0.01f, 0.8f, -0.4f, 0.8f);
        v12.lineTo(6.02f, 18.01f);
        v12.curveToRelative(-0.41f, -0.01f, -0.65f, -0.49f, -0.39f, -0.82f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SatelliteKt._satellite = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

