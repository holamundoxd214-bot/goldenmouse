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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flatware", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Flatware", "Landroidx/compose/material/icons/Icons$Rounded;", "getFlatware", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FlatwareKt {
    private static ImageVector _flatware;

    static {
    }

    public static final ImageVector getFlatware(Rounded arg19) {
        ImageVector v0 = FlatwareKt._flatware;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Flatware", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 7.08f);
        v12.curveToRelative(0f, 1.77f, -0.84f, 3.25f, -2f, 3.82f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.verticalLineToRelative(-9.1f);
        v12.curveToRelative(-1.16f, -0.57f, -2f, -2.05f, -2f, -3.82f);
        v12.curveTo(10.01f, 4.83f, 11.35f, 3f, 13f, 3f);
        v12.curveTo(14.66f, 3f, 16f, 4.83f, 16f, 7.08f);
        v12.close();
        v12.moveTo(18.27f, 3.18f);
        v12.curveTo(17.639999f, 2.99f, 17f, 3.49f, 17f, 4.15f);
        v12.lineTo(17f, 20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineToRelative(1f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineTo(7f);
        v12.curveTo(21f, 5.54f, 20.139999f, 3.74f, 18.27f, 3.18f);
        v12.close();
        v12.moveTo(8.28f, 3f);
        v12.curveToRelative(-0.4f, 0f, -0.72f, 0.32f, -0.72f, 0.72f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(6.72f);
        v12.verticalLineTo(3.72f);
        v12.curveTo(6.72f, 3.32f, 6.4f, 3f, 6f, 3f);
        v12.reflectiveCurveTo(5.28f, 3.32f, 5.28f, 3.72f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(4.44f);
        v12.verticalLineTo(3.72f);
        v12.curveTo(4.44f, 3.32f, 4.12f, 3f, 3.72f, 3f);
        v12.reflectiveCurveTo(3f, 3.32f, 3f, 3.72f);
        v12.verticalLineTo(9f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.verticalLineToRelative(9f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(0f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-9f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(3.72f);
        v12.curveTo(9f, 3.32f, 8.68f, 3f, 8.28f, 3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FlatwareKt._flatware = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

