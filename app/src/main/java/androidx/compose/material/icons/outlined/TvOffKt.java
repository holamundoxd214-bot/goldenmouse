package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_tvOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "TvOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getTvOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TvOffKt {
    private static ImageVector _tvOff;

    static {
    }

    public static final ImageVector getTvOff(Outlined arg19) {
        ImageVector v0 = TvOffKt._tvOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.TvOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 7f);
        v12.verticalLineToRelative(10.88f);
        v12.lineToRelative(1.85f, 1.85f);
        v12.curveToRelative(0.09f, -0.23f, 0.15f, -0.47f, 0.15f, -0.73f);
        v12.lineTo(23f, 7f);
        v12.curveToRelative(0f, -1.11f, -0.89f, -2f, -2f, -2f);
        v12.horizontalLineToRelative(-7.58f);
        v12.lineToRelative(3.29f, -3.3f);
        v12.lineTo(16f, 1f);
        v12.lineToRelative(-4f, 4f);
        v12.lineToRelative(-4f, -4f);
        v12.lineToRelative(-0.7f, 0.7f);
        v12.lineTo(10.58f, 5f);
        v12.lineTo(8.12f, 5f);
        v12.lineToRelative(2f, 2f);
        v12.lineTo(21f, 7f);
        v12.close();
        v12.moveTo(20.459999f, 23f);
        v12.lineToRelative(1.26f, -1.27f);
        v12.lineToRelative(-1.26f, 1.26f);
        v12.close();
        v12.moveTo(2.41f, 2.13f);
        v12.lineToRelative(-0.14f, 0.14f);
        v12.lineTo(1f, 3.54f);
        v12.lineToRelative(1.53f, 1.53f);
        v12.curveTo(1.65f, 5.28f, 1f, 6.06f, 1f, 7f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(15.46f);
        v12.lineToRelative(1.99f, 1.99f);
        v12.lineToRelative(1.26f, -1.26f);
        v12.lineToRelative(0.15f, -0.15f);
        v12.lineTo(2.41f, 2.13f);
        v12.close();
        v12.moveTo(3f, 19f);
        v12.lineTo(3f, 7f);
        v12.horizontalLineToRelative(1.46f);
        v12.lineToRelative(12f, 12f);
        v12.lineTo(3f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TvOffKt._tvOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

