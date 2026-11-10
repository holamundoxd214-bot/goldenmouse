package androidx.compose.material.icons.automirrored.filled;

import androidx.compose.material.icons.Icons$AutoMirrored$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"__360", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_360", "Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;", "get_360", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _360Kt {
    private static ImageVector __360;

    static {
    }

    public static final ImageVector get_360(Filled arg19) {
        ImageVector v0 = _360Kt.__360;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("AutoMirrored.Filled._360", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, true, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 7f);
        v12.curveTo(6.48f, 7f, 2f, 9.24f, 2f, 12f);
        v12.curveToRelative(0f, 2.24f, 2.94f, 4.13f, 7f, 4.77f);
        v12.verticalLineTo(20f);
        v12.lineToRelative(4f, -4f);
        v12.lineToRelative(-4f, -4f);
        v12.verticalLineToRelative(2.73f);
        v12.curveToRelative(-3.15f, -0.56f, -5f, -1.9f, -5f, -2.73f);
        v12.curveToRelative(0f, -1.06f, 3.04f, -3f, 8f, -3f);
        v12.reflectiveCurveToRelative(8f, 1.94f, 8f, 3f);
        v12.curveToRelative(0f, 0.73f, -1.46f, 1.89f, -4f, 2.53f);
        v12.verticalLineToRelative(2.05f);
        v12.curveToRelative(3.53f, -0.77f, 6f, -2.53f, 6f, -4.58f);
        v12.curveToRelative(0f, -2.76f, -4.48f, -5f, -10f, -5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _360Kt.__360 = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

