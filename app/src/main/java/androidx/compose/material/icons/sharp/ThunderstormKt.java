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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_thunderstorm", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Thunderstorm", "Landroidx/compose/material/icons/Icons$Sharp;", "getThunderstorm", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ThunderstormKt {
    private static ImageVector _thunderstorm;

    static {
    }

    public static final ImageVector getThunderstorm(Sharp arg19) {
        ImageVector v0 = ThunderstormKt._thunderstorm;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Thunderstorm", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.92f, 7.02f);
        v12.curveTo(17.450001f, 4.18f, 14.97f, 2f, 12f, 2f);
        v12.curveTo(9.82f, 2f, 7.83f, 3.18f, 6.78f, 5.06f);
        v12.curveTo(4.09f, 5.41f, 2f, 7.74f, 2f, 10.5f);
        v12.curveTo(2f, 13.53f, 4.47f, 16f, 7.5f, 16f);
        v12.horizontalLineToRelative(10f);
        v12.curveToRelative(2.48f, 0f, 4.5f, -2.02f, 4.5f, -4.5f);
        v12.curveTo(22f, 9.16f, 20.209999f, 7.23f, 17.92f, 7.02f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(14.8f, 17f);
        v0_1.lineToRelative(-2.9f, 3.32f);
        v0_1.lineToRelative(2f, 1f);
        v0_1.lineToRelative(-2.35f, 2.68f);
        v0_1.lineToRelative(2.65f, 0f);
        v0_1.lineToRelative(2.9f, -3.32f);
        v0_1.lineToRelative(-2f, -1f);
        v0_1.lineToRelative(2.35f, -2.68f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(8.8f, 17f);
        v0_1.lineToRelative(-2.9f, 3.32f);
        v0_1.lineToRelative(2f, 1f);
        v0_1.lineToRelative(-2.35f, 2.68f);
        v0_1.lineToRelative(2.65f, 0f);
        v0_1.lineToRelative(2.9f, -3.32f);
        v0_1.lineToRelative(-2f, -1f);
        v0_1.lineToRelative(2.35f, -2.68f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ThunderstormKt._thunderstorm = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

