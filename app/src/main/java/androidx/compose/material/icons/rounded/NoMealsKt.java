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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_noMeals", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoMeals", "Landroidx/compose/material/icons/Icons$Rounded;", "getNoMeals", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NoMealsKt {
    private static ImageVector _noMeals;

    static {
    }

    public static final ImageVector getNoMeals(Rounded arg19) {
        ImageVector v0 = NoMealsKt._noMeals;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.NoMeals", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 18.17f);
        v12.lineToRelative(-2f, -2f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(-1f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveToRelative(0f, -1.49f, 1.6f, -3.32f, 3.76f, -3.85f);
        v12.curveTo(20.389999f, 2f, 21f, 2.48f, 21f, 3.13f);
        v12.verticalLineTo(18.17f);
        v12.close();
        v12.moveTo(21.190001f, 22.610001f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.lineToRelative(-9.76f, -9.76f);
        v12.curveTo(9.69f, 12.94f, 9.36f, 13f, 9f, 13f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-8f);
        v12.curveToRelative(-2.21f, 0f, -4f, -1.79f, -4f, -4f);
        v12.verticalLineTo(5.83f);
        v12.lineTo(1.39f, 4.22f);
        v12.curveTo(1f, 3.83f, 1f, 3.2f, 1.39f, 2.81f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(18.379999f, 18.379999f);
        v12.curveTo(21.58f, 21.58f, 21.58f, 22.219999f, 21.190001f, 22.610001f);
        v12.close();
        v12.moveTo(6.17f, 9f);
        v12.lineTo(5f, 7.83f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(6.17f);
        v12.close();
        v12.moveTo(13f, 9f);
        v12.verticalLineTo(3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveToRelative(-1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(5.17f);
        v12.lineToRelative(1.85f, 1.85f);
        v12.curveTo(12.94f, 9.69f, 13f, 9.36f, 13f, 9f);
        v12.close();
        v12.moveTo(9f, 3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.reflectiveCurveTo(7f, 2.45f, 7f, 3f);
        v12.verticalLineToRelative(1.17f);
        v12.lineToRelative(2f, 2f);
        v12.verticalLineTo(3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NoMealsKt._noMeals = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

