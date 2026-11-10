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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_wavingHand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WavingHand", "Landroidx/compose/material/icons/Icons$Sharp;", "getWavingHand", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class WavingHandKt {
    private static ImageVector _wavingHand;

    static {
    }

    public static final ImageVector getWavingHand(Sharp arg19) {
        ImageVector v0 = WavingHandKt._wavingHand;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.WavingHand", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23f, 17f);
        v12.curveToRelative(0f, 3.31f, -2.69f, 6f, -6f, 6f);
        v12.verticalLineToRelative(-1.5f);
        v12.curveToRelative(2.48f, 0f, 4.5f, -2.02f, 4.5f, -4.5f);
        v12.horizontalLineTo(23f);
        v12.close();
        v12.moveTo(1f, 7f);
        v12.curveToRelative(0f, -3.31f, 2.69f, -6f, 6f, -6f);
        v12.verticalLineToRelative(1.5f);
        v12.curveTo(4.52f, 2.5f, 2.5f, 4.52f, 2.5f, 7f);
        v12.horizontalLineTo(1f);
        v12.close();
        v12.moveTo(8.9f, 3.43f);
        v12.lineTo(3.42f, 8.91f);
        v12.curveToRelative(-3.22f, 3.22f, -3.22f, 8.44f, 0f, 11.67f);
        v12.reflectiveCurveToRelative(8.44f, 3.22f, 11.67f, 0f);
        v12.lineToRelative(7.95f, -7.95f);
        v12.lineToRelative(-1.77f, -1.77f);
        v12.lineToRelative(-5.3f, 5.3f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.lineToRelative(7.42f, -7.42f);
        v12.lineToRelative(-1.77f, -1.77f);
        v12.lineToRelative(-6.72f, 6.72f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.lineToRelative(7.78f, -7.78f);
        v12.lineTo(19.5f, 2.73f);
        v12.lineToRelative(-7.78f, 7.78f);
        v12.lineTo(11.02f, 9.8f);
        v12.lineToRelative(6.36f, -6.36f);
        v12.lineToRelative(-1.77f, -1.77f);
        v12.lineToRelative(-8.51f, 8.51f);
        v12.curveToRelative(1.22f, 1.57f, 1.11f, 3.84f, -0.33f, 5.28f);
        v12.lineToRelative(-0.71f, -0.71f);
        v12.curveToRelative(1.17f, -1.17f, 1.17f, -3.08f, 0f, -4.24f);
        v12.lineToRelative(-0.35f, -0.35f);
        v12.lineToRelative(4.95f, -4.95f);
        v12.lineTo(8.9f, 3.43f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        WavingHandKt._wavingHand = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

