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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"__1xMobiledata", "Landroidx/compose/ui/graphics/vector/ImageVector;", "_1xMobiledata", "Landroidx/compose/material/icons/Icons$Rounded;", "get_1xMobiledata", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class _1xMobiledataKt {
    private static ImageVector __1xMobiledata;

    static {
    }

    public static final ImageVector get_1xMobiledata(Rounded arg19) {
        ImageVector v0 = _1xMobiledataKt.__1xMobiledata;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded._1xMobiledata", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5f, 7f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(8f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineTo(9f);
        v12.horizontalLineTo(5f);
        v12.curveTo(4.45f, 9f, 4f, 8.55f, 4f, 8f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(4f, 7.45f, 4.45f, 7f, 5f, 7f);
        v12.close();
        v12.moveTo(15.83f, 11.72f);
        v12.lineToRelative(1.92f, -3.21f);
        v12.curveTo(18.15f, 7.85f, 17.67f, 7f, 16.9f, 7f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.35f, 0f, -0.68f, 0.18f, -0.86f, 0.49f);
        v12.lineToRelative(-1.37f, 2.28f);
        v12.lineToRelative(-1.38f, -2.29f);
        v12.curveTo(13.11f, 7.18f, 12.79f, 7f, 12.44f, 7f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.78f, 0f, -1.26f, 0.85f, -0.86f, 1.51f);
        v12.lineToRelative(1.92f, 3.21f);
        v12.lineToRelative(-2.26f, 3.77f);
        v12.curveToRelative(-0.4f, 0.67f, 0.08f, 1.51f, 0.86f, 1.51f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.35f, 0f, 0.68f, -0.18f, 0.86f, -0.49f);
        v12.lineToRelative(1.71f, -2.85f);
        v12.lineToRelative(1.71f, 2.85f);
        v12.curveToRelative(0.18f, 0.3f, 0.51f, 0.49f, 0.86f, 0.49f);
        v12.horizontalLineToRelative(0.01f);
        v12.curveToRelative(0.78f, 0f, 1.26f, -0.85f, 0.86f, -1.51f);
        v12.lineTo(15.83f, 11.72f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        _1xMobiledataKt.__1xMobiledata = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

