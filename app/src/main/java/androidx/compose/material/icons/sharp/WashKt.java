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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Wash", "Landroidx/compose/material/icons/Icons$Sharp;", "getWash", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WashKt {
    private static ImageVector _wash;

    static {
    }

    public static final ImageVector getWash(Sharp arg19) {
        ImageVector v0 = WashKt._wash;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Wash", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(9.12f, 5f);
        v12.lineTo(1f, 12.68f);
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
        v12.lineTo(9.12f, 5f);
        v12.close();
        v12.moveTo(13.5f, 9f);
        v12.curveTo(14.33f, 9f, 15f, 8.33f, 15f, 7.5f);
        v12.curveTo(15f, 6.66f, 13.5f, 5f, 13.5f, 5f);
        v12.reflectiveCurveTo(12f, 6.66f, 12f, 7.5f);
        v12.curveTo(12f, 8.33f, 12.67f, 9f, 13.5f, 9f);
        v12.close();
        v12.moveTo(18.5f, 1f);
        v12.curveToRelative(0f, 0f, -2.5f, 2.83f, -2.5f, 4.5f);
        v12.curveTo(16f, 6.88f, 17.120001f, 8f, 18.5f, 8f);
        v12.reflectiveCurveTo(21f, 6.88f, 21f, 5.5f);
        v12.curveTo(21f, 3.83f, 18.5f, 1f, 18.5f, 1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WashKt._wash = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

