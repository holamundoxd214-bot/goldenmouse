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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"__3k", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_3k", "Landroidx/compose/material/icons/Icons$Outlined;", "get_3k", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _3kKt {
    private static ImageVector __3k;

    static {
    }

    public static final ImageVector get_3k(Outlined arg19) {
        ImageVector v0 = _3kKt.__3k;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined._3k", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19f, 3f);
        v12.horizontalLineTo(5f);
        v12.curveTo(3.9f, 3f, 3f, 3.9f, 3f, 5f);
        v12.verticalLineToRelative(14f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(5f);
        v12.curveTo(21f, 3.9f, 20.1f, 3f, 19f, 3f);
        v12.close();
        v12.moveTo(19f, 19f);
        v12.horizontalLineTo(5f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(14f);
        v12.verticalLineTo(19f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(11f, 14f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(6.5f);
        v12.verticalLineToRelative(1.5f);
        v12.horizontalLineToRelative(3f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-3f);
        v12.verticalLineTo(15f);
        v12.horizontalLineTo(10f);
        v12.curveTo(10.55f, 15f, 11f, 14.55f, 11f, 14f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(14.5f, 12.75f);
        v0_1.lineToRelative(1.75f, 2.25f);
        v0_1.lineToRelative(1.75f, 0f);
        v0_1.lineToRelative(-2.25f, -3f);
        v0_1.lineToRelative(2.25f, -3f);
        v0_1.lineToRelative(-1.75f, 0f);
        v0_1.lineToRelative(-1.75f, 2.25f);
        v0_1.lineToRelative(0f, -2.25f);
        v0_1.lineToRelative(-1.5f, 0f);
        v0_1.lineToRelative(0f, 6f);
        v0_1.lineToRelative(1.5f, 0f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _3kKt.__3k = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

