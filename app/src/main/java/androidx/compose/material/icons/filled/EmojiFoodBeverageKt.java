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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_emojiFoodBeverage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EmojiFoodBeverage", "Landroidx/compose/material/icons/Icons$Filled;", "getEmojiFoodBeverage", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EmojiFoodBeverageKt {
    private static ImageVector _emojiFoodBeverage;

    static {
    }

    public static final ImageVector getEmojiFoodBeverage(Filled arg19) {
        ImageVector v0 = EmojiFoodBeverageKt._emojiFoodBeverage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.EmojiFoodBeverage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 3f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2.4f);
        v12.lineToRelative(1.81f, 1.45f);
        v12.curveTo(10.93f, 6.94f, 11f, 7.09f, 11f, 7.24f);
        v12.verticalLineToRelative(4.26f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.horizontalLineToRelative(-4f);
        v12.curveTo(6.22f, 12f, 6f, 11.78f, 6f, 11.5f);
        v12.verticalLineTo(7.24f);
        v12.curveToRelative(0f, -0.15f, 0.07f, -0.3f, 0.19f, -0.39f);
        v12.lineTo(8f, 5.4f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(4f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(2.21f, 0f, 4f, -1.79f, 4f, -4f);
        v12.verticalLineToRelative(-3f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(22f, 3.89f, 21.110001f, 3f, 20f, 3f);
        v12.close();
        v12.moveTo(20f, 8f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(4f, 19f);
        v0_1.horizontalLineToRelative(16f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(-16f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EmojiFoodBeverageKt._emojiFoodBeverage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

