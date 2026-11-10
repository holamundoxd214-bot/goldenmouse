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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noFood", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoFood", "Landroidx/compose/material/icons/Icons$Rounded;", "getNoFood", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoFoodKt {
    private static ImageVector _noFood;

    static {
    }

    public static final ImageVector getNoFood(Rounded arg19) {
        ImageVector v0 = NoFoodKt._noFood;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NoFood", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 22f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(13f);
        v12.curveTo(15.55f, 21f, 16f, 21.450001f, 16f, 22f);
        v12.close();
        v12.moveTo(22.889999f, 6.1f);
        v12.curveTo(22.950001f, 5.51f, 22.49f, 5f, 21.9f, 5f);
        v12.horizontalLineTo(18f);
        v12.verticalLineTo(2f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(-3.9f);
        v12.curveToRelative(-0.59f, 0f, -1.05f, 0.51f, -1f, 1.1f);
        v12.lineToRelative(0.24f, 2.41f);
        v12.lineTo(18f, 15.17f);
        v12.lineToRelative(3.62f, 3.62f);
        v12.lineTo(22.889999f, 6.1f);
        v12.close();
        v12.moveTo(21.190001f, 22.610001f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(12f, 12f);
        v12.lineTo(9.01f, 9.01f);
        v12.horizontalLineToRelative(0f);
        v12.lineToRelative(-6.2f, -6.2f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(1f, 3.2f, 1f, 3.83f, 1.39f, 4.22f);
        v12.lineToRelative(4.99f, 4.99f);
        v12.curveToRelative(-2.56f, 0.54f, -4.76f, 2.08f, -5.28f, 4.63f);
        v12.curveTo(0.99f, 14.45f, 1.49f, 15f, 2.1f, 15f);
        v12.lineToRelative(10.07f, 0f);
        v12.lineToRelative(2f, 2f);
        v12.horizontalLineTo(2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.reflectiveCurveToRelative(0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(13f);
        v12.curveToRelative(0.32f, 0f, 0.59f, -0.16f, 0.78f, -0.4f);
        v12.lineToRelative(4f, 4f);
        v12.curveTo(20.17f, 23f, 20.799999f, 23f, 21.190001f, 22.610001f);
        v12.lineTo(21.190001f, 22.610001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoFoodKt._noFood = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

