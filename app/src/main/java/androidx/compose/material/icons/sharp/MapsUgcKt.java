package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mapsUgc", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MapsUgc", "Landroidx/compose/material/icons/Icons$Sharp;", "getMapsUgc", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MapsUgcKt {
    private static ImageVector _mapsUgc;

    static {
    }

    public static final ImageVector getMapsUgc(Sharp arg19) {
        ImageVector v0 = MapsUgcKt._mapsUgc;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.MapsUgc", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(4.41f, 0f, 8f, 3.59f, 8f, 8f);
        v12.reflectiveCurveToRelative(-3.59f, 8f, -8f, 8f);
        v12.curveToRelative(-1.18f, 0f, -2.34f, -0.26f, -3.43f, -0.78f);
        v12.curveToRelative(-0.27f, -0.13f, -0.56f, -0.19f, -0.86f, -0.19f);
        v12.curveToRelative(-0.19f, 0f, -0.38f, 0.03f, -0.56f, 0.08f);
        v12.lineToRelative(-3.2f, 0.94f);
        v12.lineToRelative(0.94f, -3.2f);
        v12.curveToRelative(0.14f, -0.47f, 0.1f, -0.98f, -0.11f, -1.42f);
        v12.curveTo(4.26f, 14.34f, 4f, 13.18f, 4f, 12f);
        v12.curveTo(4f, 7.59f, 7.59f, 4f, 12f, 4f);
        v12.moveTo(12f, 2f);
        v12.curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f);
        v12.curveToRelative(0f, 1.54f, 0.36f, 2.98f, 0.97f, 4.29f);
        v12.lineTo(1f, 23f);
        v12.lineToRelative(6.71f, -1.97f);
        v12.curveTo(9.02f, 21.639999f, 10.46f, 22f, 12f, 22f);
        v12.curveToRelative(5.52f, 0f, 10f, -4.48f, 10f, -10f);
        v12.curveTo(22f, 6.48f, 17.52f, 2f, 12f, 2f);
        v12.lineTo(12f, 2f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = PathFillType.Companion.getEvenOdd-Rg-k1Os();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(13f, 8f);
        v0_1.lineToRelative(-2f, 0f);
        v0_1.lineToRelative(0f, 3f);
        v0_1.lineToRelative(-3f, 0f);
        v0_1.lineToRelative(0f, 2f);
        v0_1.lineToRelative(3f, 0f);
        v0_1.lineToRelative(0f, 3f);
        v0_1.lineToRelative(2f, 0f);
        v0_1.lineToRelative(0f, -3f);
        v0_1.lineToRelative(3f, 0f);
        v0_1.lineToRelative(0f, -2f);
        v0_1.lineToRelative(-3f, 0f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MapsUgcKt._mapsUgc = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

