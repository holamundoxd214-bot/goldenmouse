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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_inventory2", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Inventory2", "Landroidx/compose/material/icons/Icons$Outlined;", "getInventory2", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class Inventory2Kt {
    private static ImageVector _inventory2;

    static {
    }

    public static final ImageVector getInventory2(Outlined arg19) {
        ImageVector v0 = Inventory2Kt._inventory2;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Inventory2", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 2f);
        v12.horizontalLineTo(4f);
        v12.curveTo(3f, 2f, 2f, 2.9f, 2f, 4f);
        v12.verticalLineToRelative(3.01f);
        v12.curveTo(2f, 7.73f, 2.43f, 8.35f, 3f, 8.7f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 1.1f, 1.1f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(0.9f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(8.7f);
        v12.curveToRelative(0.57f, -0.35f, 1f, -0.97f, 1f, -1.69f);
        v12.verticalLineTo(4f);
        v12.curveTo(22f, 2.9f, 21f, 2f, 20f, 2f);
        v12.close();
        v12.moveTo(19f, 20f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(9f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineTo(20f);
        v12.close();
        v12.moveTo(20f, 7f);
        v12.horizontalLineTo(4f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(7f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(9f, 12f);
        v0_1.horizontalLineToRelative(6f);
        v0_1.verticalLineToRelative(2f);
        v0_1.horizontalLineToRelative(-6f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        Inventory2Kt._inventory2 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

