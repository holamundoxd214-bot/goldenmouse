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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_style", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Style", "Landroidx/compose/material/icons/Icons$Filled;", "getStyle", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StyleKt {
    private static ImageVector _style;

    static {
    }

    public static final ImageVector getStyle(Filled arg19) {
        ImageVector v0 = StyleKt._style;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Style", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2.53f, 19.65f);
        v12.lineToRelative(1.34f, 0.56f);
        v12.verticalLineToRelative(-9.03f);
        v12.lineToRelative(-2.43f, 5.86f);
        v12.curveToRelative(-0.41f, 1.02f, 0.08f, 2.19f, 1.09f, 2.61f);
        v12.close();
        v12.moveTo(22.030001f, 15.95f);
        v12.lineTo(17.07f, 3.98f);
        v12.curveToRelative(-0.31f, -0.75f, -1.04f, -1.21f, -1.81f, -1.23f);
        v12.curveToRelative(-0.26f, 0f, -0.53f, 0.04f, -0.79f, 0.15f);
        v12.lineTo(7.1f, 5.95f);
        v12.curveToRelative(-0.75f, 0.31f, -1.21f, 1.03f, -1.23f, 1.8f);
        v12.curveToRelative(-0.01f, 0.27f, 0.04f, 0.54f, 0.15f, 0.8f);
        v12.lineToRelative(4.96f, 11.97f);
        v12.curveToRelative(0.31f, 0.76f, 1.05f, 1.22f, 1.83f, 1.23f);
        v12.curveToRelative(0.26f, 0f, 0.52f, -0.05f, 0.77f, -0.15f);
        v12.lineToRelative(7.36f, -3.05f);
        v12.curveToRelative(1.02f, -0.42f, 1.51f, -1.59f, 1.09f, -2.6f);
        v12.close();
        v12.moveTo(7.88f, 8.75f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.reflectiveCurveToRelative(1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.close();
        v12.moveTo(5.88f, 19.75f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(1.45f);
        v12.lineToRelative(-3.45f, -8.34f);
        v12.verticalLineToRelative(6.34f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StyleKt._style = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

