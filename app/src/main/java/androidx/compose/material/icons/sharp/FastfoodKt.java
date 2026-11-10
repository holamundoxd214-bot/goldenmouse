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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fastfood", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Fastfood", "Landroidx/compose/material/icons/Icons$Sharp;", "getFastfood", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FastfoodKt {
    private static ImageVector _fastfood;

    static {
    }

    public static final ImageVector getFastfood(Sharp arg19) {
        ImageVector v0 = FastfoodKt._fastfood;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Fastfood", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(18f, 5f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineToRelative(-5f);
        v12.lineToRelative(0.23f, 2.31f);
        v12.curveTo(14.9f, 8.16f, 18f, 10.77f, 18f, 15f);
        v12.lineToRelative(0.02f, 8f);
        v12.horizontalLineToRelative(3.18f);
        v12.lineTo(23f, 5f);
        v12.horizontalLineToRelative(-5f);
        v12.close();
        v12.moveTo(1f, 21f);
        v12.horizontalLineToRelative(15f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(1f);
        v12.close();
        v12.moveTo(8.5f, 8.99f);
        v12.curveTo(4.75f, 8.99f, 1f, 11f, 1f, 15f);
        v12.horizontalLineToRelative(15f);
        v12.curveToRelative(0f, -4f, -3.75f, -6.01f, -7.5f, -6.01f);
        v12.close();
        v12.moveTo(1f, 17f);
        v12.horizontalLineToRelative(15f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FastfoodKt._fastfood = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

