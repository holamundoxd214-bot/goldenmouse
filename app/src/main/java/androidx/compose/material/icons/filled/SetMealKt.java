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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_setMeal", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SetMeal", "Landroidx/compose/material/icons/Icons$Filled;", "getSetMeal", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SetMealKt {
    private static ImageVector _setMeal;

    static {
    }

    public static final ImageVector getSetMeal(Filled arg19) {
        ImageVector v0 = SetMealKt._setMeal;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SetMeal", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.049999f, 17.559999f);
        v12.lineTo(3.08f, 18.5f);
        v12.lineTo(3f, 17f);
        v12.lineToRelative(17.98f, -0.94f);
        v12.lineTo(21.049999f, 17.559999f);
        v12.close();
        v12.moveTo(21f, 19.48f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(1.5f);
        v12.horizontalLineToRelative(18f);
        v12.verticalLineTo(19.48f);
        v12.close();
        v12.moveTo(22f, 5f);
        v12.verticalLineToRelative(7f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f);
        v12.horizontalLineToRelative(16f);
        v12.curveTo(21.1f, 3f, 22f, 3.9f, 22f, 5f);
        v12.close();
        v12.moveTo(20f, 6f);
        v12.curveToRelative(-1.68f, 0f, -3.04f, 0.98f, -3.21f, 2.23f);
        v12.curveTo(16.15f, 7.5f, 14.06f, 5.5f, 10.25f, 5.5f);
        v12.curveToRelative(-4.67f, 0f, -6.75f, 3f, -6.75f, 3f);
        v12.reflectiveCurveToRelative(2.08f, 3f, 6.75f, 3f);
        v12.curveToRelative(3.81f, 0f, 5.9f, -2f, 6.54f, -2.73f);
        v12.curveTo(16.959999f, 10.02f, 18.32f, 11f, 20f, 11f);
        v12.verticalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SetMealKt._setMeal = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

