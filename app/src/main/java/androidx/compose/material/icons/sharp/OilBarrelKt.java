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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_oilBarrel", "Landroidx/compose/ui/graphics/vector/ImageVector;", "OilBarrel", "Landroidx/compose/material/icons/Icons$Sharp;", "getOilBarrel", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class OilBarrelKt {
    private static ImageVector _oilBarrel;

    static {
    }

    public static final ImageVector getOilBarrel(Sharp arg19) {
        ImageVector v0 = OilBarrelKt._oilBarrel;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.OilBarrel", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 13f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(5f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(3f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(18f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineTo(21f);
        v12.close();
        v12.moveTo(12f, 16f);
        v12.curveToRelative(-1.66f, 0f, -3f, -1.32f, -3f, -2.95f);
        v12.curveToRelative(0f, -1.3f, 0.52f, -1.67f, 3f, -4.55f);
        v12.curveToRelative(2.47f, 2.86f, 3f, 3.24f, 3f, 4.55f);
        v12.curveTo(15f, 14.68f, 13.66f, 16f, 12f, 16f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        OilBarrelKt._oilBarrel = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

