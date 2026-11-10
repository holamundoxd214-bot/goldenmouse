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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_alignVerticalCenter", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AlignVerticalCenter", "Landroidx/compose/material/icons/Icons$Rounded;", "getAlignVerticalCenter", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class AlignVerticalCenterKt {
    private static ImageVector _alignVerticalCenter;

    static {
    }

    public static final ImageVector getAlignVerticalCenter(Rounded arg19) {
        ImageVector v0 = AlignVerticalCenterKt._alignVerticalCenter;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.AlignVerticalCenter", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 11f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(7.5f);
        v12.curveTo(17f, 6.67f, 16.33f, 6f, 15.5f, 6f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(14.67f, 6f, 14f, 6.67f, 14f, 7.5f);
        v12.verticalLineTo(11f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(4.5f);
        v12.curveTo(10f, 3.67f, 9.33f, 3f, 8.5f, 3f);
        v12.horizontalLineToRelative(0f);
        v12.curveTo(7.67f, 3f, 7f, 3.67f, 7f, 4.5f);
        v12.verticalLineTo(11f);
        v12.horizontalLineTo(2.84f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(0f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(6.5f);
        v12.curveTo(7f, 20.33f, 7.67f, 21f, 8.5f, 21f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(3.5f);
        v12.curveToRelative(0f, 0.83f, 0.67f, 1.5f, 1.5f, 1.5f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.83f, 0f, 1.5f, -0.67f, 1.5f, -1.5f);
        v12.verticalLineTo(13f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(0f);
        v12.curveTo(22f, 11.45f, 21.549999f, 11f, 21f, 11f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        AlignVerticalCenterKt._alignVerticalCenter = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

