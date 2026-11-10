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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_garage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Garage", "Landroidx/compose/material/icons/Icons$Rounded;", "getGarage", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GarageKt {
    private static ImageVector _garage;

    static {
    }

    public static final ImageVector getGarage(Rounded arg20) {
        ImageVector v0 = GarageKt._garage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Garage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 13f);
        v12.moveToRelative(-1f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, 2f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, -2f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(9f, 13f);
        v12.moveToRelative(-1f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, 2f, 0f);
        v12.arcToRelative(1f, 1f, 0f, true, true, -2f, 0f);
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(8.33f, 7.5f);
        v0_1.lineToRelative(-0.66f, 2f);
        v0_1.lineToRelative(8.66f, 0f);
        v0_1.lineToRelative(-0.66f, -2f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 2f, 2f, 2.9f, 2f, 4f);
        v12.verticalLineToRelative(16f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21.1f, 2f, 20f, 2f);
        v12.close();
        v12.moveTo(19f, 17.690001f);
        v12.curveToRelative(0f, 0.45f, -0.35f, 0.81f, -0.78f, 0.81f);
        v12.horizontalLineToRelative(-0.44f);
        v12.curveToRelative(-0.44f, 0f, -0.78f, -0.36f, -0.78f, -0.81f);
        v12.verticalLineTo(16.5f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(1.19f);
        v12.curveToRelative(0f, 0.45f, -0.35f, 0.81f, -0.78f, 0.81f);
        v12.horizontalLineTo(5.78f);
        v12.curveTo(5.35f, 18.5f, 5f, 18.139999f, 5f, 17.690001f);
        v12.verticalLineToRelative(-6.5f);
        v12.curveTo(5.82f, 8.72f, 6.34f, 7.16f, 6.56f, 6.5f);
        v12.curveToRelative(0.05f, -0.16f, 0.12f, -0.29f, 0.19f, -0.4f);
        v12.curveTo(6.77f, 6.08f, 6.78f, 6.06f, 6.8f, 6.04f);
        v12.curveTo(7.18f, 5.51f, 7.72f, 5.5f, 7.72f, 5.5f);
        v12.horizontalLineToRelative(8.56f);
        v12.curveToRelative(0f, 0f, 0.54f, 0.01f, 0.92f, 0.53f);
        v12.curveToRelative(0.02f, 0.03f, 0.03f, 0.05f, 0.05f, 0.07f);
        v12.curveToRelative(0.07f, 0.11f, 0.14f, 0.24f, 0.19f, 0.4f);
        v12.curveToRelative(0.22f, 0.66f, 0.74f, 2.23f, 1.56f, 4.69f);
        v12.verticalLineTo(17.690001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GarageKt._garage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

