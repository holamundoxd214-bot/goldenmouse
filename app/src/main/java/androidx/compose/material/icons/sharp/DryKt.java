package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dry", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Dry", "Landroidx/compose/material/icons/Icons$Sharp;", "getDry", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DryKt {
    private static ImageVector _dry;

    static {
    }

    public static final ImageVector getDry(Sharp arg19) {
        ImageVector v0 = DryKt._dry;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Dry", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(1f, 12.68f);
        v12.verticalLineTo(23f);
        v12.horizontalLineToRelative(18f);
        v12.verticalLineToRelative(-2.5f);
        v12.horizontalLineToRelative(-7f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(9f);
        v12.verticalLineTo(17f);
        v12.horizontalLineToRelative(-9f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(10f);
        v12.verticalLineToRelative(-2.5f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(-1f);
        v12.horizontalLineToRelative(8f);
        v12.verticalLineTo(10f);
        v12.horizontalLineTo(8.86f);
        v12.lineToRelative(1.88f, -3.3f);
        v12.lineTo(9.12f, 5f);
        v12.lineTo(1f, 12.68f);
        v12.close();
        v12.moveTo(15.65f, 4.86f);
        v12.lineToRelative(-0.07f, -0.07f);
        v12.curveToRelative(-0.57f, -0.62f, -0.82f, -1.41f, -0.67f, -2.2f);
        v12.lineTo(15f, 2f);
        v12.horizontalLineToRelative(-1.89f);
        v12.lineToRelative(-0.06f, 0.43f);
        v12.curveToRelative(-0.2f, 1.36f, 0.27f, 2.71f, 1.3f, 3.72f);
        v12.lineToRelative(0.07f, 0.06f);
        v12.curveToRelative(0.57f, 0.62f, 0.82f, 1.41f, 0.67f, 2.2f);
        v12.lineTo(14.98f, 9f);
        v12.horizontalLineToRelative(1.91f);
        v12.lineToRelative(0.06f, -0.43f);
        v12.curveTo(17.16f, 7.21f, 16.68f, 5.86f, 15.65f, 4.86f);
        v12.close();
        v12.moveTo(19.65f, 4.86f);
        v12.lineToRelative(-0.07f, -0.07f);
        v12.curveToRelative(-0.57f, -0.62f, -0.82f, -1.41f, -0.67f, -2.2f);
        v12.lineTo(19f, 2f);
        v12.horizontalLineToRelative(-1.89f);
        v12.lineToRelative(-0.06f, 0.43f);
        v12.curveToRelative(-0.2f, 1.36f, 0.27f, 2.71f, 1.3f, 3.72f);
        v12.lineToRelative(0.07f, 0.06f);
        v12.curveToRelative(0.57f, 0.62f, 0.82f, 1.41f, 0.67f, 2.2f);
        v12.lineTo(18.98f, 9f);
        v12.horizontalLineToRelative(1.91f);
        v12.lineToRelative(0.06f, -0.43f);
        v12.curveTo(21.16f, 7.21f, 20.68f, 5.86f, 19.65f, 4.86f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DryKt._dry = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

