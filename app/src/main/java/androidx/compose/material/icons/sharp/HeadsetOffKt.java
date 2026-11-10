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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_headsetOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "HeadsetOff", "Landroidx/compose/material/icons/Icons$Sharp;", "getHeadsetOff", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HeadsetOffKt {
    private static ImageVector _headsetOff;

    static {
    }

    public static final ImageVector getHeadsetOff(Sharp arg19) {
        ImageVector v0 = HeadsetOffKt._headsetOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.HeadsetOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.curveToRelative(3.87f, 0f, 7f, 3.13f, 7f, 7f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineToRelative(0.17f);
        v12.lineToRelative(6f, 6f);
        v12.verticalLineTo(11f);
        v12.curveToRelative(0f, -4.97f, -4.03f, -9f, -9f, -9f);
        v12.curveTo(9.98f, 2f, 8.12f, 2.67f, 6.62f, 3.8f);
        v12.lineToRelative(1.43f, 1.43f);
        v12.curveTo(9.17f, 4.45f, 10.53f, 4f, 12f, 4f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(2.1f, 2.1f);
        v12.lineTo(0.69f, 3.51f);
        v12.lineToRelative(3.33f, 3.33f);
        v12.curveTo(3.37f, 8.09f, 3f, 9.5f, 3f, 11f);
        v12.verticalLineToRelative(9f);
        v12.horizontalLineToRelative(6f);
        v12.verticalLineToRelative(-8f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-1f);
        v12.curveToRelative(0f, -0.94f, 0.19f, -1.83f, 0.52f, -2.65f);
        v12.lineTo(15f, 17.83f);
        v12.verticalLineTo(20f);
        v12.horizontalLineToRelative(2.17f);
        v12.lineToRelative(1f, 1f);
        v12.horizontalLineTo(12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(8.17f);
        v12.lineToRelative(0.31f, 0.31f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineTo(2.1f, 2.1f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HeadsetOffKt._headsetOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

