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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_park", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Park", "Landroidx/compose/material/icons/Icons$Rounded;", "getPark", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ParkKt {
    private static ImageVector _park;

    static {
    }

    public static final ImageVector getPark(Rounded arg19) {
        ImageVector v0 = ParkKt._park;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Park", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.959999f, 12f);
        v12.horizontalLineToRelative(0.08f);
        v12.curveToRelative(0.81f, 0f, 1.28f, -0.91f, 0.82f, -1.57f);
        v12.lineToRelative(-5.08f, -7.25f);
        v12.curveToRelative(-0.4f, -0.57f, -1.24f, -0.57f, -1.64f, 0f);
        v12.lineTo(6.1f, 10.43f);
        v12.curveTo(5.64f, 11.09f, 6.12f, 12f, 6.93f, 12f);
        v12.horizontalLineToRelative(0.04f);
        v12.lineToRelative(-2.9f, 4.46f);
        v12.curveTo(3.63f, 17.120001f, 4.11f, 18f, 4.91f, 18f);
        v12.horizontalLineToRelative(5.08f);
        v12.verticalLineToRelative(2.02f);
        v12.curveToRelative(0f, 1.09f, 0.89f, 1.98f, 1.98f, 1.98f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(1.09f, 0f, 1.98f, -0.89f, 1.98f, -1.98f);
        v12.verticalLineTo(18f);
        v12.horizontalLineToRelative(5.15f);
        v12.curveToRelative(0.8f, 0f, 1.28f, -0.89f, 0.83f, -1.55f);
        v12.lineTo(16.959999f, 12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ParkKt._park = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

