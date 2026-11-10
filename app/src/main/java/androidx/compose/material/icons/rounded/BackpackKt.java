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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_backpack", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Backpack", "Landroidx/compose/material/icons/Icons$Rounded;", "getBackpack", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BackpackKt {
    private static ImageVector _backpack;

    static {
    }

    public static final ImageVector getBackpack(Rounded arg19) {
        ImageVector v0 = BackpackKt._backpack;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Backpack", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 8f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f);
        v12.horizontalLineTo(6f);
        v12.curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -1.86f, 1.28f, -3.41f, 3f, -3.86f);
        v12.verticalLineTo(3.5f);
        v12.curveTo(7f, 2.67f, 7.67f, 2f, 8.5f, 2f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(9.33f, 2f, 10f, 2.67f, 10f, 3.5f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(3.5f);
        v12.curveTo(14f, 2.67f, 14.67f, 2f, 15.5f, 2f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(16.33f, 2f, 17f, 2.67f, 17f, 3.5f);
        v12.verticalLineToRelative(0.64f);
        v12.curveTo(18.719999f, 4.59f, 20f, 6.14f, 20f, 8f);
        v12.close();
        v12.moveTo(6f, 13f);
        v12.lineTo(6f, 13f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(9f);
        v12.verticalLineToRelative(1f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(7f);
        v12.curveTo(6.45f, 12f, 6f, 12.45f, 6f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BackpackKt._backpack = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

