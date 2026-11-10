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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_waterDrop", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WaterDrop", "Landroidx/compose/material/icons/Icons$Outlined;", "getWaterDrop", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WaterDropKt {
    private static ImageVector _waterDrop;

    static {
    }

    public static final ImageVector getWaterDrop(Outlined arg19) {
        ImageVector v0 = WaterDropKt._waterDrop;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.WaterDrop", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveToRelative(-5.33f, 4.55f, -8f, 8.48f, -8f, 11.8f);
        v12.curveToRelative(0f, 4.98f, 3.8f, 8.2f, 8f, 8.2f);
        v12.reflectiveCurveToRelative(8f, -3.22f, 8f, -8.2f);
        v12.curveTo(20f, 10.48f, 17.33f, 6.55f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.curveToRelative(-3.35f, 0f, -6f, -2.57f, -6f, -6.2f);
        v12.curveToRelative(0f, -2.34f, 1.95f, -5.44f, 6f, -9.14f);
        v12.curveToRelative(4.05f, 3.7f, 6f, 6.79f, 6f, 9.14f);
        v12.curveTo(18f, 17.43f, 15.35f, 20f, 12f, 20f);
        v12.close();
        v12.moveTo(7.83f, 14f);
        v12.curveToRelative(0.37f, 0f, 0.67f, 0.26f, 0.74f, 0.62f);
        v12.curveToRelative(0.41f, 2.22f, 2.28f, 2.98f, 3.64f, 2.87f);
        v12.curveToRelative(0.43f, -0.02f, 0.79f, 0.32f, 0.79f, 0.75f);
        v12.curveToRelative(0f, 0.4f, -0.32f, 0.73f, -0.72f, 0.75f);
        v12.curveToRelative(-2.13f, 0.13f, -4.62f, -1.09f, -5.19f, -4.12f);
        v12.curveTo(7.01f, 14.42f, 7.37f, 14f, 7.83f, 14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WaterDropKt._waterDrop = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

