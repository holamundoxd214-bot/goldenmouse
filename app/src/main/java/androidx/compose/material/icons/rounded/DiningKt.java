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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Dining", "Landroidx/compose/material/icons/Icons$Rounded;", "getDining", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DiningKt {
    private static ImageVector _dining;

    static {
    }

    public static final ImageVector getDining(Rounded arg19) {
        ImageVector v0 = DiningKt._dining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Dining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 2f, 2f, 2.9f, 2f, 4f);
        v12.verticalLineToRelative(16f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21.1f, 2f, 20f, 2f);
        v12.close();
        v12.moveTo(11f, 10.3f);
        v12.curveToRelative(0f, 0.93f, -0.64f, 1.71f, -1.5f, 1.93f);
        v12.verticalLineToRelative(6.02f);
        v12.curveTo(9.5f, 18.66f, 9.16f, 19f, 8.75f, 19f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(8.34f, 19f, 8f, 18.66f, 8f, 18.25f);
        v12.verticalLineToRelative(-6.02f);
        v12.curveToRelative(-0.86f, -0.22f, -1.5f, -1f, -1.5f, -1.93f);
        v12.verticalLineTo(6.5f);
        v12.curveTo(6.5f, 6.22f, 6.72f, 6f, 7f, 6f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(0.75f);
        v12.verticalLineTo(6.5f);
        v12.curveToRelative(0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        v12.reflectiveCurveToRelative(0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(10f);
        v12.verticalLineTo(6.5f);
        v12.curveTo(10f, 6.22f, 10.23f, 6f, 10.5f, 6f);
        v12.curveTo(10.78f, 6f, 11f, 6.22f, 11f, 6.5f);
        v12.verticalLineTo(10.3f);
        v12.close();
        v12.moveTo(15.58f, 12.59f);
        v12.lineToRelative(-0.08f, 0.03f);
        v12.verticalLineToRelative(5.63f);
        v12.curveToRelative(0f, 0.41f, -0.34f, 0.75f, -0.75f, 0.75f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(14.34f, 19f, 14f, 18.66f, 14f, 18.25f);
        v12.verticalLineToRelative(-5.63f);
        v12.lineToRelative(-0.08f, -0.04f);
        v12.curveToRelative(-0.97f, -0.47f, -1.67f, -1.7f, -1.67f, -3.18f);
        v12.curveToRelative(0f, -1.88f, 1.13f, -3.4f, 2.5f, -3.4f);
        v12.curveToRelative(1.38f, 0f, 2.5f, 1.53f, 2.5f, 3.41f);
        v12.curveTo(17.25f, 10.89f, 16.549999f, 12.12f, 15.58f, 12.59f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DiningKt._dining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

