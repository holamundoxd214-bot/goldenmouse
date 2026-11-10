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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"__5kPlus", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_5kPlus", "Landroidx/compose/material/icons/Icons$Sharp;", "get_5kPlus", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _5kPlusKt {
    private static ImageVector __5kPlus;

    static {
    }

    public static final ImageVector get_5kPlus(Sharp arg18) {
        ImageVector v0 = _5kPlusKt.__5kPlus;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp._5kPlus", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(21f, 3f);
        v0_1.horizontalLineTo(3f);
        v0_1.verticalLineToRelative(18f);
        v0_1.horizontalLineToRelative(18f);
        v0_1.verticalLineTo(3f);
        v0_1.close();
        v0_1.moveTo(10f, 10.5f);
        v0_1.horizontalLineTo(7.5f);
        v0_1.verticalLineToRelative(1f);
        v0_1.horizontalLineTo(10f);
        v0_1.verticalLineTo(15f);
        v0_1.horizontalLineTo(6f);
        v0_1.verticalLineToRelative(-1.5f);
        v0_1.horizontalLineToRelative(2.5f);
        v0_1.verticalLineToRelative(-1f);
        v0_1.horizontalLineTo(6f);
        v0_1.verticalLineTo(9f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.verticalLineTo(10.5f);
        v0_1.close();
        v0_1.moveTo(16f, 15f);
        v0_1.horizontalLineToRelative(-1.75f);
        v0_1.lineToRelative(-1.75f, -2.25f);
        v0_1.verticalLineTo(15f);
        v0_1.horizontalLineTo(11f);
        v0_1.verticalLineTo(9f);
        v0_1.horizontalLineToRelative(1.5f);
        v0_1.verticalLineToRelative(2.25f);
        v0_1.lineTo(14.25f, 9f);
        v0_1.horizontalLineTo(16f);
        v0_1.lineToRelative(-2.25f, 3f);
        v0_1.lineTo(16f, 15f);
        v0_1.close();
        v0_1.moveTo(19f, 12.5f);
        v0_1.horizontalLineToRelative(-1.5f);
        v0_1.verticalLineTo(14f);
        v0_1.horizontalLineToRelative(-1f);
        v0_1.verticalLineToRelative(-1.5f);
        v0_1.horizontalLineTo(15f);
        v0_1.verticalLineToRelative(-1f);
        v0_1.horizontalLineToRelative(1.5f);
        v0_1.verticalLineTo(10f);
        v0_1.horizontalLineToRelative(1f);
        v0_1.verticalLineToRelative(1.5f);
        v0_1.horizontalLineTo(19f);
        v0_1.verticalLineTo(12.5f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _5kPlusKt.__5kPlus = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

