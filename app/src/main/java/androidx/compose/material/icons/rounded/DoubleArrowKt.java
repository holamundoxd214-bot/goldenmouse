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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_doubleArrow", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DoubleArrow", "Landroidx/compose/material/icons/Icons$Rounded;", "getDoubleArrow", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DoubleArrowKt {
    private static ImageVector _doubleArrow;

    static {
    }

    public static final ImageVector getDoubleArrow(Rounded arg19) {
        ImageVector v0 = DoubleArrowKt._doubleArrow;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DoubleArrow", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.08f, 11.42f);
        v12.lineToRelative(-4.04f, -5.65f);
        v12.curveTo(15.7f, 5.29f, 15.15f, 5f, 14.56f, 5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-1.49f, 0f, -2.35f, 1.68f, -1.49f, 2.89f);
        v12.lineTo(16f, 12f);
        v12.lineToRelative(-2.93f, 4.11f);
        v12.curveToRelative(-0.87f, 1.21f, 0f, 2.89f, 1.49f, 2.89f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.59f, 0f, 1.15f, -0.29f, 1.49f, -0.77f);
        v12.lineToRelative(4.04f, -5.65f);
        v12.curveTo(20.33f, 12.23f, 20.33f, 11.77f, 20.08f, 11.42f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(13.08f, 11.42f);
        v12.lineTo(9.05f, 5.77f);
        v12.curveTo(8.7f, 5.29f, 8.15f, 5f, 7.56f, 5f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(6.07f, 5f, 5.2f, 6.68f, 6.07f, 7.89f);
        v12.lineTo(9f, 12f);
        v12.lineToRelative(-2.93f, 4.11f);
        v12.curveTo(5.2f, 17.32f, 6.07f, 19f, 7.56f, 19f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.59f, 0f, 1.15f, -0.29f, 1.49f, -0.77f);
        v12.lineToRelative(4.04f, -5.65f);
        v12.curveTo(13.33f, 12.23f, 13.33f, 11.77f, 13.08f, 11.42f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DoubleArrowKt._doubleArrow = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

