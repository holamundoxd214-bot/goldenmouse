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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_motorcycle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Motorcycle", "Landroidx/compose/material/icons/Icons$Filled;", "getMotorcycle", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MotorcycleKt {
    private static ImageVector _motorcycle;

    static {
    }

    public static final ImageVector getMotorcycle(Filled arg19) {
        ImageVector v0 = MotorcycleKt._motorcycle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Motorcycle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.5f, 10f);
        v12.curveToRelative(-0.03f, 0f, -0.05f, 0.01f, -0.08f, 0.01f);
        v12.lineTo(13.41f, 6f);
        v12.lineTo(9f, 6f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3.59f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineToRelative(-8.1f);
        v12.curveTo(4.01f, 10f, 2f, 12.02f, 2f, 14.5f);
        v12.curveTo(2f, 16.99f, 4.01f, 19f, 6.5f, 19f);
        v12.curveToRelative(2.22f, 0f, 4.06f, -1.62f, 4.42f, -3.73f);
        v12.lineTo(13.04f, 14f);
        v12.curveToRelative(-0.02f, 0.17f, -0.04f, 0.33f, -0.04f, 0.5f);
        v12.curveToRelative(0f, 2.49f, 2.01f, 4.5f, 4.5f, 4.5f);
        v12.reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f);
        v12.reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f);
        v12.close();
        v12.moveTo(8.84f, 15.26f);
        v12.curveTo(8.52f, 16.27f, 7.58f, 17f, 6.47f, 17f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, -1.12f, -2.5f, -2.5f);
        v12.reflectiveCurveTo(5.09f, 12f, 6.47f, 12f);
        v12.curveToRelative(1.12f, 0f, 2.05f, 0.74f, 2.37f, 1.75f);
        v12.lineTo(6f, 13.75f);
        v12.verticalLineToRelative(1.5f);
        v12.lineToRelative(2.84f, 0.01f);
        v12.close();
        v12.moveTo(17.469999f, 17f);
        v12.curveToRelative(-1.38f, 0f, -2.5f, -1.12f, -2.5f, -2.5f);
        v12.reflectiveCurveToRelative(1.12f, -2.5f, 2.5f, -2.5f);
        v12.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        v12.reflectiveCurveToRelative(-1.12f, 2.5f, -2.5f, 2.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MotorcycleKt._motorcycle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

