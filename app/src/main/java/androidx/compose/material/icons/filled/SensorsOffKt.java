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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sensorsOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SensorsOff", "Landroidx/compose/material/icons/Icons$Filled;", "getSensorsOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SensorsOffKt {
    private static ImageVector _sensorsOff;

    static {
    }

    public static final ImageVector getSensorsOff(Filled arg19) {
        ImageVector v0 = SensorsOffKt._sensorsOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SensorsOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.14f, 10.96f);
        v12.curveTo(8.05f, 11.29f, 8f, 11.64f, 8f, 12f);
        v12.curveToRelative(0f, 1.1f, 0.45f, 2.1f, 1.17f, 2.83f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveTo(6.67f, 15.16f, 6f, 13.66f, 6f, 12f);
        v12.curveToRelative(0f, -0.93f, 0.21f, -1.8f, 0.58f, -2.59f);
        v12.lineTo(5.11f, 7.94f);
        v12.curveTo(4.4f, 9.13f, 4f, 10.52f, 4f, 12f);
        v12.curveToRelative(0f, 2.21f, 0.9f, 4.21f, 2.35f, 5.65f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveTo(3.12f, 17.26f, 2f, 14.76f, 2f, 12f);
        v12.curveToRelative(0f, -2.04f, 0.61f, -3.93f, 1.66f, -5.51f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(18.379999f, 18.379999f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineTo(8.14f, 10.96f);
        v12.close();
        v12.moveTo(17.42f, 14.59f);
        v12.curveTo(17.790001f, 13.8f, 18f, 12.93f, 18f, 12f);
        v12.curveToRelative(0f, -1.66f, -0.67f, -3.16f, -1.76f, -4.24f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveTo(15.55f, 9.9f, 16f, 10.9f, 16f, 12f);
        v12.curveToRelative(0f, 0.36f, -0.05f, 0.71f, -0.14f, 1.04f);
        v12.lineTo(17.42f, 14.59f);
        v12.close();
        v12.moveTo(20f, 12f);
        v12.curveToRelative(0f, 1.48f, -0.4f, 2.87f, -1.11f, 4.06f);
        v12.lineToRelative(1.45f, 1.45f);
        v12.curveTo(21.389999f, 15.93f, 22f, 14.04f, 22f, 12f);
        v12.curveToRelative(0f, -2.76f, -1.12f, -5.26f, -2.93f, -7.07f);
        v12.lineToRelative(-1.42f, 1.42f);
        v12.curveTo(19.1f, 7.79f, 20f, 9.79f, 20f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SensorsOffKt._sensorsOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

