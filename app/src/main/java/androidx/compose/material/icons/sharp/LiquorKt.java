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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_liquor", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Liquor", "Landroidx/compose/material/icons/Icons$Sharp;", "getLiquor", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LiquorKt {
    private static ImageVector _liquor;

    static {
    }

    public static final ImageVector getLiquor(Sharp arg23) {
        ImageVector v0 = LiquorKt._liquor;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Liquor", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 14f);
        v12.curveToRelative(0f, 1.3f, 0.84f, 2.4f, 2f, 2.82f);
        v12.verticalLineTo(20f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(-3.18f);
        v12.curveTo(8.16f, 16.4f, 9f, 15.3f, 9f, 14f);
        v12.verticalLineTo(6f);
        v12.horizontalLineTo(3f);
        v12.verticalLineTo(14f);
        v12.close();
        v12.moveTo(5f, 8f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(8f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(22f, 9f);
        v0_1.lineToRelative(-3f, -1.01f);
        v0_1.verticalLineTo(2f);
        v0_1.horizontalLineToRelative(-5f);
        v0_1.verticalLineToRelative(6f);
        v0_1.lineToRelative(-3f, 1.01f);
        v0_1.verticalLineTo(22f);
        v0_1.horizontalLineToRelative(11f);
        v0_1.verticalLineTo(9f);
        v0_1.close();
        v0_1.moveTo(16f, 4f);
        v0_1.horizontalLineToRelative(1f);
        v0_1.verticalLineToRelative(1f);
        v0_1.horizontalLineToRelative(-1f);
        v0_1.verticalLineTo(4f);
        v0_1.close();
        v0_1.moveTo(13f, 10.44f);
        v0_1.lineToRelative(3f, -0.98f);
        v0_1.verticalLineTo(7f);
        v0_1.horizontalLineToRelative(1f);
        v0_1.verticalLineToRelative(2.46f);
        v0_1.lineToRelative(3f, 0.98f);
        v0_1.verticalLineTo(12f);
        v0_1.horizontalLineToRelative(-7f);
        v0_1.verticalLineTo(10.44f);
        v0_1.close();
        v0_1.moveTo(20f, 20f);
        v0_1.horizontalLineToRelative(-7f);
        v0_1.verticalLineToRelative(-2f);
        v0_1.horizontalLineToRelative(7f);
        v0_1.verticalLineTo(20f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LiquorKt._liquor = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

