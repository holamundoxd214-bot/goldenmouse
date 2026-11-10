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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_copyright", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Copyright", "Landroidx/compose/material/icons/Icons$Filled;", "getCopyright", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CopyrightKt {
    private static ImageVector _copyright;

    static {
    }

    public static final ImageVector getCopyright(Filled arg19) {
        ImageVector v0 = CopyrightKt._copyright;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Copyright", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.88f, 9.14f);
        v12.curveToRelative(1.28f, 0.06f, 1.61f, 1.15f, 1.63f, 1.66f);
        v12.horizontalLineToRelative(1.79f);
        v12.curveToRelative(-0.08f, -1.98f, -1.49f, -3.19f, -3.45f, -3.19f);
        v12.curveTo(9.64f, 7.61f, 8f, 9f, 8f, 12.14f);
        v12.curveToRelative(0f, 1.94f, 0.93f, 4.24f, 3.84f, 4.24f);
        v12.curveToRelative(2.22f, 0f, 3.41f, -1.65f, 3.44f, -2.95f);
        v12.horizontalLineToRelative(-1.79f);
        v12.curveToRelative(-0.03f, 0.59f, -0.45f, 1.38f, -1.63f, 1.44f);
        v12.curveTo(10.55f, 14.83f, 10f, 13.81f, 10f, 12.14f);
        v12.curveTo(10f, 9.25f, 11.28f, 9.16f, 11.88f, 9.14f);
        v12.close();
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.reflectiveCurveToRelative(4.48f, 10f, 10f, 10f);
        v12.reflectiveCurveToRelative(10f, -4.48f, 10f, -10f);
        v12.reflectiveCurveTo(17.52f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-4.41f, 0f, -8f, -3.59f, -8f, -8f);
        v12.reflectiveCurveToRelative(3.59f, -8f, 8f, -8f);
        v12.reflectiveCurveToRelative(8f, 3.59f, 8f, 8f);
        v12.reflectiveCurveTo(16.41f, 20f, 12f, 20f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CopyrightKt._copyright = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

