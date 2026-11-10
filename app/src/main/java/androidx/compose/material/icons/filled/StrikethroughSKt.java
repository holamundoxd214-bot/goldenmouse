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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_strikethroughS", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StrikethroughS", "Landroidx/compose/material/icons/Icons$Filled;", "getStrikethroughS", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class StrikethroughSKt {
    private static ImageVector _strikethroughS;

    static {
    }

    public static final ImageVector getStrikethroughS(Filled arg19) {
        ImageVector v0 = StrikethroughSKt._strikethroughS;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.StrikethroughS", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(6.85f, 7.08f);
        v12.curveTo(6.85f, 4.37f, 9.45f, 3f, 12.24f, 3f);
        v12.curveToRelative(1.64f, 0f, 3f, 0.49f, 3.9f, 1.28f);
        v12.curveToRelative(0.77f, 0.65f, 1.46f, 1.73f, 1.46f, 3.24f);
        v12.horizontalLineToRelative(-3.01f);
        v12.curveToRelative(0f, -0.31f, -0.05f, -0.59f, -0.15f, -0.85f);
        v12.curveToRelative(-0.29f, -0.86f, -1.2f, -1.28f, -2.25f, -1.28f);
        v12.curveToRelative(-1.86f, 0f, -2.34f, 1.02f, -2.34f, 1.7f);
        v12.curveToRelative(0f, 0.48f, 0.25f, 0.88f, 0.74f, 1.21f);
        v12.curveTo(10.97f, 8.55f, 11.36f, 8.78f, 12f, 9f);
        v12.horizontalLineTo(7.39f);
        v12.curveTo(7.18f, 8.66f, 6.85f, 8.11f, 6.85f, 7.08f);
        v12.close();
        v12.moveTo(21f, 12f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(9.62f);
        v12.curveToRelative(1.15f, 0.45f, 1.96f, 0.75f, 1.96f, 1.97f);
        v12.curveToRelative(0f, 1f, -0.81f, 1.67f, -2.28f, 1.67f);
        v12.curveToRelative(-1.54f, 0f, -2.93f, -0.54f, -2.93f, -2.51f);
        v12.horizontalLineTo(6.4f);
        v12.curveToRelative(0f, 0.55f, 0.08f, 1.13f, 0.24f, 1.58f);
        v12.curveToRelative(0.81f, 2.29f, 3.29f, 3.3f, 5.67f, 3.3f);
        v12.curveToRelative(2.27f, 0f, 5.3f, -0.89f, 5.3f, -4.05f);
        v12.curveToRelative(0f, -0.3f, -0.01f, -1.16f, -0.48f, -1.94f);
        v12.horizontalLineTo(21f);
        v12.verticalLineTo(12f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        StrikethroughSKt._strikethroughS = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

