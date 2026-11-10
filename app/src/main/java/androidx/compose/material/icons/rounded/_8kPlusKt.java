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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"__8kPlus", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_8kPlus", "Landroidx/compose/material/icons/Icons$Rounded;", "get_8kPlus", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _8kPlusKt {
    private static ImageVector __8kPlus;

    static {
    }

    public static final ImageVector get_8kPlus(Rounded arg19) {
        ImageVector v0 = _8kPlusKt.__8kPlus;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded._8kPlus", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
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
        v12.moveTo(10f, 14f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineTo(7f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineTo(14f);
        v12.close();
        v12.moveTo(14.59f, 15f);
        v12.curveToRelative(-0.22f, 0f, -0.42f, -0.1f, -0.55f, -0.27f);
        v12.lineToRelative(-1.54f, -1.98f);
        v12.verticalLineToRelative(1.55f);
        v12.curveToRelative(0f, 0.39f, -0.31f, 0.7f, -0.7f, 0.7f);
        v12.horizontalLineTo(11.7f);
        v12.curveToRelative(-0.39f, 0f, -0.7f, -0.31f, -0.7f, -0.7f);
        v12.verticalLineTo(9.7f);
        v12.curveTo(11f, 9.31f, 11.31f, 9f, 11.7f, 9f);
        v12.horizontalLineToRelative(0.09f);
        v12.curveToRelative(0.39f, 0f, 0.7f, 0.31f, 0.7f, 0.7f);
        v12.verticalLineToRelative(1.55f);
        v12.lineToRelative(1.54f, -1.98f);
        v12.curveTo(14.17f, 9.1f, 14.38f, 9f, 14.59f, 9f);
        v12.curveToRelative(0.58f, 0f, 0.91f, 0.66f, 0.56f, 1.12f);
        v12.lineTo(13.75f, 12f);
        v12.lineToRelative(1.41f, 1.88f);
        v12.curveTo(15.5f, 14.34f, 15.17f, 15f, 14.59f, 15f);
        v12.close();
        v12.moveTo(19f, 12.5f);
        v12.horizontalLineToRelative(-1.5f);
        v12.verticalLineTo(14f);
        v12.horizontalLineToRelative(-1f);
        v12.verticalLineToRelative(-1.5f);
        v12.horizontalLineTo(15f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineTo(10f);
        v12.horizontalLineToRelative(1f);
        v12.verticalLineToRelative(1.5f);
        v12.horizontalLineTo(19f);
        v12.verticalLineTo(12.5f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(7.5f, 12.5f);
        v0_1.horizontalLineToRelative(1f);
        v0_1.verticalLineToRelative(1.5f);
        v0_1.horizontalLineToRelative(-1f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(7.5f, 10f);
        v0_1.horizontalLineToRelative(1f);
        v0_1.verticalLineToRelative(1.5f);
        v0_1.horizontalLineToRelative(-1f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _8kPlusKt.__8kPlus = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

