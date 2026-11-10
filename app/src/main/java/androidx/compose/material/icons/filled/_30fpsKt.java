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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"__30fps", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_30fps", "Landroidx/compose/material/icons/Icons$Filled;", "get_30fps", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _30fpsKt {
    private static ImageVector __30fps;

    static {
    }

    public static final ImageVector get_30fps(Filled arg19) {
        ImageVector v0 = _30fpsKt.__30fps;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled._30fps", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(2f, 5f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(2.5f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineTo(16f);
        v12.horizontalLineTo(2f);
        v12.verticalLineToRelative(3f);
        v12.horizontalLineToRelative(6f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.verticalLineToRelative(-1.9f);
        v12.curveToRelative(0f, -1.16f, -0.94f, -2.1f, -2.1f, -2.1f);
        v12.curveToRelative(1.16f, 0f, 2.1f, -0.94f, 2.1f, -2.1f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.horizontalLineTo(2f);
        v12.close();
        v12.moveTo(19f, 8f);
        v12.verticalLineToRelative(8f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(8f);
        v12.horizontalLineTo(19f);
        v12.moveTo(19f, 5f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-1.66f, 0f, -3f, 1.34f, -3f, 3f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f);
        v12.verticalLineTo(8f);
        v12.curveTo(22f, 6.34f, 20.66f, 5f, 19f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _30fpsKt.__30fps = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

