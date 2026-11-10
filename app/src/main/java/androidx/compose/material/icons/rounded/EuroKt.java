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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_euro", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Euro", "Landroidx/compose/material/icons/Icons$Rounded;", "getEuro", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EuroKt {
    private static ImageVector _euro;

    static {
    }

    public static final ImageVector getEuro(Rounded arg19) {
        ImageVector v0 = EuroKt._euro;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Euro", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 18.5f);
        v12.curveToRelative(-2.51f, 0f, -4.68f, -1.42f, -5.76f, -3.5f);
        v12.horizontalLineToRelative(5.14f);
        v12.curveToRelative(0.38f, 0f, 0.73f, -0.21f, 0.89f, -0.55f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.33f, -0.66f, -0.15f, -1.45f, -0.89f, -1.45f);
        v12.horizontalLineToRelative(-5.8f);
        v12.curveToRelative(-0.05f, -0.33f, -0.08f, -0.66f, -0.08f, -1f);
        v12.reflectiveCurveToRelative(0.03f, -0.67f, 0.08f, -1f);
        v12.horizontalLineToRelative(5.8f);
        v12.curveToRelative(0.38f, 0f, 0.73f, -0.21f, 0.89f, -0.55f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(15.61f, 9.78f, 15.13f, 9f, 14.38f, 9f);
        v12.horizontalLineTo(9.24f);
        v12.curveTo(10.32f, 6.92f, 12.5f, 5.5f, 15f, 5.5f);
        v12.curveToRelative(1.25f, 0f, 2.42f, 0.36f, 3.42f, 0.97f);
        v12.curveToRelative(0.5f, 0.31f, 1.15f, 0.26f, 1.57f, -0.16f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(0.58f, -0.58f, 0.45f, -1.53f, -0.25f, -1.96f);
        v12.curveTo(18.360001f, 3.5f, 16.73f, 3f, 15f, 3f);
        v12.curveToRelative(-3.92f, 0f, -7.24f, 2.51f, -8.48f, 6f);
        v12.horizontalLineToRelative(-2.9f);
        v12.curveTo(3.24f, 9f, 2.89f, 9.21f, 2.72f, 9.55f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(2.39f, 10.22f, 2.87f, 11f, 3.62f, 11f);
        v12.horizontalLineToRelative(2.44f);
        v12.curveTo(6.02f, 11.33f, 6f, 11.66f, 6f, 12f);
        v12.reflectiveCurveToRelative(0.02f, 0.67f, 0.06f, 1f);
        v12.horizontalLineTo(3.62f);
        v12.curveToRelative(-0.38f, 0f, -0.73f, 0.21f, -0.89f, 0.55f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(2.39f, 14.22f, 2.87f, 15f, 3.62f, 15f);
        v12.horizontalLineToRelative(2.9f);
        v12.curveToRelative(1.24f, 3.49f, 4.56f, 6f, 8.48f, 6f);
        v12.curveToRelative(1.74f, 0f, 3.36f, -0.49f, 4.74f, -1.35f);
        v12.curveToRelative(0.69f, -0.43f, 0.82f, -1.39f, 0.24f, -1.97f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.42f, -0.42f, -1.07f, -0.47f, -1.57f, -0.15f);
        v12.curveTo(17.42f, 18.15f, 16.26f, 18.5f, 15f, 18.5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EuroKt._euro = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

