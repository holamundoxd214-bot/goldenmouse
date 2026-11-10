package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_donutSmall", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DonutSmall", "Landroidx/compose/material/icons/Icons$TwoTone;", "getDonutSmall", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DonutSmallKt {
    private static ImageVector _donutSmall;

    static {
    }

    public static final ImageVector getDonutSmall(TwoTone arg19) {
        ImageVector v0 = DonutSmallKt._donutSmall;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.DonutSmall", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.99f, 9f);
        v12.horizontalLineToRelative(3.43f);
        v12.curveTo(18.6f, 7f, 17f, 5.4f, 15f, 4.58f);
        v12.verticalLineToRelative(3.43f);
        v12.curveToRelative(0.37f, 0.28f, 0.71f, 0.62f, 0.99f, 0.99f);
        v12.close();
        v12.moveTo(4f, 12f);
        v12.curveToRelative(0f, 3.35f, 2.04f, 6.24f, 5f, 7.42f);
        v12.verticalLineToRelative(-3.44f);
        v12.curveToRelative(-1.23f, -0.93f, -2f, -2.4f, -2f, -3.99f);
        v12.curveTo(7f, 10.4f, 7.77f, 8.93f, 9f, 8f);
        v12.lineTo(9f, 4.58f);
        v12.curveTo(6.04f, 5.76f, 4f, 8.65f, 4f, 12f);
        v12.close();
        v12.moveTo(15f, 15.99f);
        v12.verticalLineToRelative(3.43f);
        v12.curveToRelative(2f, -0.82f, 3.6f, -2.42f, 4.42f, -4.42f);
        v12.horizontalLineToRelative(-3.43f);
        v12.curveToRelative(-0.28f, 0.37f, -0.62f, 0.71f, -0.99f, 0.99f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(14.82f, 11f);
        v12.horizontalLineToRelative(7.13f);
        v12.curveToRelative(-0.47f, -4.72f, -4.23f, -8.48f, -8.95f, -8.95f);
        v12.verticalLineToRelative(7.13f);
        v12.curveToRelative(0.85f, 0.31f, 1.51f, 0.97f, 1.82f, 1.82f);
        v12.close();
        v12.moveTo(15f, 4.58f);
        v12.curveTo(17f, 5.4f, 18.6f, 7f, 19.42f, 9f);
        v12.horizontalLineToRelative(-3.43f);
        v12.curveToRelative(-0.28f, -0.37f, -0.62f, -0.71f, -0.99f, -0.99f);
        v12.lineTo(15f, 4.58f);
        v12.close();
        v12.moveTo(2f, 12f);
        v12.curveToRelative(0f, 5.19f, 3.95f, 9.45f, 9f, 9.95f);
        v12.verticalLineToRelative(-7.13f);
        v12.curveTo(9.84f, 14.4f, 9f, 13.3f, 9f, 12f);
        v12.curveToRelative(0f, -1.3f, 0.84f, -2.4f, 2f, -2.82f);
        v12.lineTo(11f, 2.05f);
        v12.curveToRelative(-5.05f, 0.5f, -9f, 4.76f, -9f, 9.95f);
        v12.close();
        v12.moveTo(9f, 4.58f);
        v12.verticalLineToRelative(3.44f);
        v12.curveToRelative(-1.23f, 0.92f, -2f, 2.39f, -2f, 3.98f);
        v12.curveToRelative(0f, 1.59f, 0.77f, 3.06f, 2f, 3.99f);
        v12.verticalLineToRelative(3.44f);
        v12.curveTo(6.04f, 18.24f, 4f, 15.35f, 4f, 12f);
        v12.curveToRelative(0f, -3.35f, 2.04f, -6.24f, 5f, -7.42f);
        v12.close();
        v12.moveTo(13f, 14.82f);
        v12.verticalLineToRelative(7.13f);
        v12.curveToRelative(4.72f, -0.47f, 8.48f, -4.23f, 8.95f, -8.95f);
        v12.horizontalLineToRelative(-7.13f);
        v12.curveToRelative(-0.31f, 0.85f, -0.97f, 1.51f, -1.82f, 1.82f);
        v12.close();
        v12.moveTo(15f, 15.99f);
        v12.curveToRelative(0.37f, -0.28f, 0.71f, -0.61f, 0.99f, -0.99f);
        v12.horizontalLineToRelative(3.43f);
        v12.curveTo(18.6f, 17f, 17f, 18.6f, 15f, 19.42f);
        v12.verticalLineToRelative(-3.43f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DonutSmallKt._donutSmall = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

