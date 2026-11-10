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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_alignVerticalBottom", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AlignVerticalBottom", "Landroidx/compose/material/icons/Icons$Rounded;", "getAlignVerticalBottom", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AlignVerticalBottomKt {
    private static ImageVector _alignVerticalBottom;

    static {
    }

    public static final ImageVector getAlignVerticalBottom(Rounded arg19) {
        ImageVector v0 = AlignVerticalBottomKt._alignVerticalBottom;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AlignVerticalBottom", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 22f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(22f, 21.549999f, 21.549999f, 22f, 21f, 22f);
        v12.close();
        v12.moveTo(8.5f, 2f);
        v12.lineTo(8.5f, 2f);
        v12.curveTo(7.67f, 2f, 7f, 2.67f, 7f, 3.5f);
        v12.verticalLineToRelative(13f);
        v12.curveTo(7f, 17.33f, 7.67f, 18f, 8.5f, 18f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-13f);
        v12.curveTo(10f, 2.67f, 9.33f, 2f, 8.5f, 2f);
        v12.close();
        v12.moveTo(15.5f, 8f);
        v12.lineTo(15.5f, 8f);
        v12.curveTo(14.67f, 8f, 14f, 8.67f, 14f, 9.5f);
        v12.verticalLineToRelative(7f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineToRelative(-7f);
        v12.curveTo(17f, 8.67f, 16.33f, 8f, 15.5f, 8f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AlignVerticalBottomKt._alignVerticalBottom = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

