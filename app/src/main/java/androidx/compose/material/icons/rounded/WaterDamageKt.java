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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_waterDamage", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WaterDamage", "Landroidx/compose/material/icons/Icons$Rounded;", "getWaterDamage", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WaterDamageKt {
    private static ImageVector _waterDamage;

    static {
    }

    public static final ImageVector getWaterDamage(Rounded arg19) {
        ImageVector v0 = WaterDamageKt._waterDamage;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.WaterDamage", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(11.33f, 3.6f);
        v12.lineToRelative(-8.36f, 7.53f);
        v12.curveTo(2.63f, 11.43f, 2.84f, 12f, 3.3f, 12f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(7f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(12f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineToRelative(1.7f);
        v12.curveToRelative(0.46f, 0f, 0.68f, -0.57f, 0.33f, -0.87f);
        v12.lineTo(12.67f, 3.6f);
        v12.curveTo(12.29f, 3.26f, 11.71f, 3.26f, 11.33f, 3.6f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.curveToRelative(0f, -0.78f, 0.99f, -2.44f, 1.58f, -3.36f);
        v12.curveToRelative(0.2f, -0.31f, 0.64f, -0.31f, 0.84f, 0f);
        v12.curveTo(13.01f, 11.56f, 14f, 13.22f, 14f, 14f);
        v12.curveTo(14f, 15.1f, 13.1f, 16f, 12f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WaterDamageKt._waterDamage = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

