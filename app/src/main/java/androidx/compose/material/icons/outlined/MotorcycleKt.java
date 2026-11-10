package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_motorcycle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Motorcycle", "Landroidx/compose/material/icons/Icons$Outlined;", "getMotorcycle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MotorcycleKt {
    private static ImageVector _motorcycle;

    static {
    }

    public static final ImageVector getMotorcycle(Outlined arg19) {
        ImageVector v0 = MotorcycleKt._motorcycle;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Motorcycle", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.72f, 11f);
        v12.lineToRelative(-2f, 2f);
        v12.horizontalLineToRelative(-0.77f);
        v12.lineToRelative(-0.25f, -0.69f);
        v12.curveToRelative(-0.18f, -0.48f, -0.42f, -0.92f, -0.72f, -1.31f);
        v12.horizontalLineToRelative(3.74f);
        v12.moveToRelative(2.69f, -6f);
        v12.horizontalLineTo(11f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(3.59f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(5f);
        v12.curveToRelative(-2.8f, 0f, -5f, 2.2f, -5f, 5f);
        v12.reflectiveCurveToRelative(2.2f, 5f, 5f, 5f);
        v12.curveToRelative(2.46f, 0f, 4.45f, -1.69f, 4.9f, -4f);
        v12.horizontalLineToRelative(1.65f);
        v12.lineToRelative(2.77f, -2.77f);
        v12.curveToRelative(-0.21f, 0.54f, -0.32f, 1.14f, -0.32f, 1.77f);
        v12.curveToRelative(0f, 2.8f, 2.2f, 5f, 5f, 5f);
        v12.reflectiveCurveToRelative(5f, -2.2f, 5f, -5f);
        v12.curveToRelative(0f, -2.65f, -1.97f, -4.77f, -4.56f, -4.97f);
        v12.lineTo(15.41f, 5f);
        v12.close();
        v12.moveTo(19f, 17f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.34f, -3f, 3f, -3f);
        v12.reflectiveCurveToRelative(3f, 1.34f, 3f, 3f);
        v12.reflectiveCurveToRelative(-1.34f, 3f, -3f, 3f);
        v12.close();
        v12.moveTo(5f, 17f);
        v12.curveToRelative(-1.63f, 0f, -3f, -1.37f, -3f, -3f);
        v12.reflectiveCurveToRelative(1.37f, -3f, 3f, -3f);
        v12.curveToRelative(1.28f, 0f, 2.4f, 0.85f, 2.82f, 2f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2.82f);
        v12.curveTo(7.4f, 16.15f, 6.28f, 17f, 5f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MotorcycleKt._motorcycle = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

