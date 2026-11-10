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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_watchOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WatchOff", "Landroidx/compose/material/icons/Icons$Sharp;", "getWatchOff", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WatchOffKt {
    private static ImageVector _watchOff;

    static {
    }

    public static final ImageVector getWatchOff(Sharp arg19) {
        ImageVector v0 = WatchOffKt._watchOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.WatchOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 7f);
        v12.curveToRelative(2.76f, 0f, 5f, 2.24f, 5f, 5f);
        v12.curveToRelative(0f, 0.64f, -0.13f, 1.25f, -0.35f, 1.82f);
        v12.lineToRelative(1.5f, 1.5f);
        v12.curveTo(18.690001f, 14.33f, 19f, 13.2f, 19f, 12f);
        v12.curveToRelative(0f, -2.22f, -1.03f, -4.19f, -2.64f, -5.47f);
        v12.lineTo(15f, 2f);
        v12.horizontalLineTo(9f);
        v12.lineTo(8.04f, 5.21f);
        v12.lineToRelative(2.14f, 2.14f);
        v12.curveTo(10.75f, 7.13f, 11.36f, 7f, 12f, 7f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2.81f, 2.81f);
        v12.lineTo(1.39f, 4.22f);
        v12.lineToRelative(4.46f, 4.46f);
        v12.curveTo(5.31f, 9.67f, 5f, 10.8f, 5f, 12f);
        v12.curveToRelative(0f, 2.22f, 1.03f, 4.19f, 2.64f, 5.47f);
        v12.lineTo(9f, 22f);
        v12.horizontalLineToRelative(6f);
        v12.lineToRelative(0.96f, -3.21f);
        v12.lineToRelative(3.82f, 3.82f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.81f, 2.81f);
        v12.close();
        v12.moveTo(12f, 17f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.curveToRelative(0f, -0.64f, 0.13f, -1.25f, 0.35f, -1.82f);
        v12.lineToRelative(6.47f, 6.47f);
        v12.curveTo(13.25f, 16.870001f, 12.64f, 17f, 12f, 17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WatchOffKt._watchOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

