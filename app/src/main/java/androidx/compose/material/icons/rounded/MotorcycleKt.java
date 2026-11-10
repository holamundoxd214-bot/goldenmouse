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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_motorcycle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Motorcycle", "Landroidx/compose/material/icons/Icons$Rounded;", "getMotorcycle", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MotorcycleKt {
    private static ImageVector _motorcycle;

    static {
    }

    public static final ImageVector getMotorcycle(Rounded arg19) {
        ImageVector v0 = MotorcycleKt._motorcycle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Motorcycle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.440001f, 9.03f);
        v12.lineTo(17.309999f, 6.9f);
        v12.lineToRelative(-1.6f, -1.6f);
        v12.curveToRelative(-0.19f, -0.19f, -0.45f, -0.3f, -0.71f, -0.3f);
        v12.horizontalLineToRelative(-3f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2.59f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(5f, 9f);
        v12.curveToRelative(-2.8f, 0f, -5f, 2.2f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.2f, 5f, 5f, 5f);
        v12.curveToRelative(2.46f, 0f, 4.45f, -1.69f, 4.9f, -4f);
        v12.horizontalLineToRelative(0.82f);
        v12.curveToRelative(0.53f, 0f, 1.04f, -0.21f, 1.41f, -0.59f);
        v12.lineToRelative(2.18f, -2.18f);
        v12.curveToRelative(-0.2f, 0.54f, -0.31f, 1.14f, -0.31f, 1.77f);
        v12.curveToRelative(0f, 2.8f, 2.2f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.2f, 5f, -5f);
        v12.curveToRelative(0f, -2.65f, -1.97f, -4.77f, -4.56f, -4.97f);
        v12.close();
        v12.moveTo(5f, 15f);
        v12.horizontalLineToRelative(2.82f);
        v12.curveTo(7.4f, 16.15f, 6.28f, 17f, 5f, 17f);
        v12.curveToRelative(-1.63f, 0f, -3f, -1.37f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.37f, -3f, 3f, -3f);
        v12.curveToRelative(1.28f, 0f, 2.4f, 0.85f, 2.82f, 2f);
        v12.lineTo(5f, 13f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.close();
        v12.moveTo(19f, 17f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveToRelative(-1.34f, 3f, -3f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MotorcycleKt._motorcycle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

