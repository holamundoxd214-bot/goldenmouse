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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noFood", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoFood", "Landroidx/compose/material/icons/Icons$Outlined;", "getNoFood", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoFoodKt {
    private static ImageVector _noFood;

    static {
    }

    public static final ImageVector getNoFood(Outlined arg19) {
        ImageVector v0 = NoFoodKt._noFood;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.NoFood", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(1f, 21f);
        v12.horizontalLineToRelative(15.01f);
        v12.verticalLineToRelative(0.98f);
        v12.curveToRelative(0f, 0.56f, -0.45f, 1.01f, -1.01f, 1.01f);
        v12.horizontalLineTo(2.01f);
        v12.curveTo(1.45f, 22.99f, 1f, 22.540001f, 1f, 21.98f);
        v12.verticalLineTo(21f);
        v12.close();
        v12.moveTo(20.49f, 23.309999f);
        v12.lineTo(16f, 18.83f);
        v12.verticalLineTo(19f);
        v12.horizontalLineTo(1f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(13.17f);
        v12.lineToRelative(-2f, -2f);
        v12.horizontalLineTo(1f);
        v12.curveToRelative(0f, -3.24f, 2.46f, -5.17f, 5.38f, -5.79f);
        v12.lineToRelative(-5.7f, -5.7f);
        v12.lineTo(2.1f, 2.1f);
        v12.lineTo(13f, 13f);
        v12.lineToRelative(2f, 2f);
        v12.lineToRelative(6.9f, 6.9f);
        v12.lineTo(20.49f, 23.309999f);
        v12.close();
        v12.moveTo(10.17f, 13f);
        v12.lineToRelative(-2f, -2f);
        v12.curveToRelative(-1.42f, 0.06f, -3.52f, 0.56f, -4.55f, 2f);
        v12.horizontalLineTo(10.17f);
        v12.close();
        v12.moveTo(23f, 5f);
        v12.horizontalLineToRelative(-5f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(-5f);
        v12.lineToRelative(0.23f, 2f);
        v12.horizontalLineToRelative(9.56f);
        v12.lineToRelative(-1f, 9.97f);
        v12.lineToRelative(1.83f, 1.83f);
        v12.lineTo(23f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoFoodKt._noFood = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

