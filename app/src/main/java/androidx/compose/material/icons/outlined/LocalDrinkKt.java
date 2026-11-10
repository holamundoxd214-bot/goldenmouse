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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localDrink", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalDrink", "Landroidx/compose/material/icons/Icons$Outlined;", "getLocalDrink", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalDrinkKt {
    private static ImageVector _localDrink;

    static {
    }

    public static final ImageVector getLocalDrink(Outlined arg19) {
        ImageVector v0 = LocalDrinkKt._localDrink;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.LocalDrink", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 2f);
        v12.lineToRelative(2.01f, 18.23f);
        v12.curveTo(5.13f, 21.23f, 5.97f, 22f, 7f, 22f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(1.03f, 0f, 1.87f, -0.77f, 1.99f, -1.77f);
        v12.lineTo(21f, 2f);
        v12.lineTo(3f, 2f);
        v12.close();
        v12.moveTo(17f, 20f);
        v12.lineToRelative(-10f, 0.01f);
        v12.lineTo(5.89f, 10f);
        v12.lineTo(18.1f, 10f);
        v12.lineTo(17f, 20f);
        v12.close();
        v12.moveTo(18.33f, 8f);
        v12.lineTo(5.67f, 8f);
        v12.lineToRelative(-0.44f, -4f);
        v12.horizontalLineToRelative(13.53f);
        v12.lineToRelative(-0.43f, 4f);
        v12.close();
        v12.moveTo(12f, 19f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.curveToRelative(0f, -2f, -3f, -5.4f, -3f, -5.4f);
        v12.reflectiveCurveTo(9f, 14f, 9f, 16f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.close();
        v12.moveTo(12f, 13.91f);
        v12.curveToRelative(0.59f, 0.91f, 1f, 1.73f, 1f, 2.09f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.curveToRelative(0f, -0.37f, 0.41f, -1.19f, 1f, -2.09f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalDrinkKt._localDrink = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

