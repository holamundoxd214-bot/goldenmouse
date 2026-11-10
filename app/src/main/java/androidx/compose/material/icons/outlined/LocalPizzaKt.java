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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_localPizza", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalPizza", "Landroidx/compose/material/icons/Icons$Outlined;", "getLocalPizza", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LocalPizzaKt {
    private static ImageVector _localPizza;

    static {
    }

    public static final ImageVector getLocalPizza(Outlined arg19) {
        ImageVector v0 = LocalPizzaKt._localPizza;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.LocalPizza", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 2f);
        v12.curveTo(8.43f, 2f, 5.23f, 3.54f, 3.01f, 6f);
        v12.lineTo(12f, 22f);
        v12.lineToRelative(8.99f, -16f);
        v12.curveTo(18.780001f, 3.55f, 15.57f, 2f, 12f, 2f);
        v12.close();
        v12.moveTo(12f, 17.92f);
        v12.lineTo(5.51f, 6.36f);
        v12.curveTo(7.32f, 4.85f, 9.62f, 4f, 12f, 4f);
        v12.reflectiveCurveToRelative(4.68f, 0.85f, 6.49f, 2.36f);
        v12.lineTo(12f, 17.92f);
        v12.close();
        v12.moveTo(9f, 5.5f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, 0.67f, -1.5f, 1.5f);
        v12.reflectiveCurveTo(8.17f, 8.5f, 9f, 8.5f);
        v12.reflectiveCurveToRelative(1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveTo(9.82f, 5.5f, 9f, 5.5f);
        v12.close();
        v12.moveTo(10.5f, 13f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.curveToRelative(0.82f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-0.68f, -1.5f, -1.5f, -1.5f);
        v12.reflectiveCurveToRelative(-1.5f, 0.67f, -1.5f, 1.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LocalPizzaKt._localPizza = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

