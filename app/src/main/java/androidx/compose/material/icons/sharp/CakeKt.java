package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cake", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Cake", "Landroidx/compose/material/icons/Icons$Sharp;", "getCake", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CakeKt {
    private static ImageVector _cake;

    static {
    }

    public static final ImageVector getCake(Sharp arg19) {
        ImageVector v0 = CakeKt._cake;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Cake", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6f);
        v12.curveToRelative(1.11f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -0.38f, -0.1f, -0.73f, -0.29f, -1.03f);
        v12.lineTo(12f, 0f);
        v12.lineToRelative(-1.71f, 2.97f);
        v12.curveToRelative(-0.19f, 0.3f, -0.29f, 0.65f, -0.29f, 1.03f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.close();
        v12.moveTo(16.530001f, 15.92f);
        v12.lineToRelative(-1f, -1f);
        v12.lineToRelative(-1.08f, 1.07f);
        v12.curveToRelative(-1.3f, 1.3f, -3.58f, 1.31f, -4.89f, 0f);
        v12.lineToRelative(-1.07f, -1.07f);
        v12.lineToRelative(-1.09f, 1.07f);
        v12.curveTo(6.75f, 16.639999f, 5.88f, 17f, 4.96f, 17f);
        v12.curveToRelative(-0.73f, 0f, -1.4f, -0.23f, -1.96f, -0.61f);
        v12.lineTo(3f, 22f);
        v12.horizontalLineToRelative(18f);
        v12.verticalLineToRelative(-5.61f);
        v12.curveToRelative(-0.75f, 0.51f, -1.71f, 0.75f, -2.74f, 0.52f);
        v12.curveToRelative(-0.66f, -0.14f, -1.25f, -0.51f, -1.73f, -0.99f);
        v12.close();
        v12.moveTo(18f, 9f);
        v12.horizontalLineToRelative(-5f);
        v12.lineTo(13f, 7f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.lineTo(6f, 9f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.verticalLineToRelative(1.54f);
        v12.curveToRelative(0f, 1.08f, 0.88f, 1.96f, 1.96f, 1.96f);
        v12.curveToRelative(0.52f, 0f, 1.02f, -0.2f, 1.38f, -0.57f);
        v12.lineToRelative(2.14f, -2.13f);
        v12.lineToRelative(2.13f, 2.13f);
        v12.curveToRelative(0.74f, 0.74f, 2.03f, 0.74f, 2.77f, 0f);
        v12.lineToRelative(2.14f, -2.13f);
        v12.lineToRelative(2.13f, 2.13f);
        v12.curveToRelative(0.37f, 0.37f, 0.86f, 0.57f, 1.38f, 0.57f);
        v12.curveToRelative(1.08f, 0f, 1.96f, -0.88f, 1.96f, -1.96f);
        v12.lineTo(20.99f, 12f);
        v12.curveTo(21f, 10.34f, 19.66f, 9f, 18f, 9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CakeKt._cake = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

