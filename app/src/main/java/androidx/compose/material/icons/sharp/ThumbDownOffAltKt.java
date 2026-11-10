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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_thumbDownOffAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbDownOffAlt", "Landroidx/compose/material/icons/Icons$Sharp;", "getThumbDownOffAlt", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ThumbDownOffAltKt {
    private static ImageVector _thumbDownOffAlt;

    static {
    }

    public static final ImageVector getThumbDownOffAlt(Sharp arg20) {
        ImageVector v0 = ThumbDownOffAltKt._thumbDownOffAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ThumbDownOffAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(19f, 3f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.verticalLineToRelative(12f);
        v0_1.horizontalLineToRelative(-4f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(1f, 11.6f);
        v0_1.verticalLineTo(16f);
        v0_1.horizontalLineToRelative(8.31f);
        v0_1.lineToRelative(-1.12f, 5.38f);
        v0_1.lineTo(9.83f, 23f);
        v0_1.lineTo(17f, 15.82f);
        v0_1.verticalLineTo(3f);
        v0_1.horizontalLineTo(4.69f);
        v0_1.lineTo(1f, 11.6f);
        v0_1.close();
        v0_1.moveTo(15f, 5f);
        v0_1.verticalLineToRelative(9.99f);
        v0_1.lineToRelative(-4.34f, 4.35f);
        v0_1.lineToRelative(0.61f, -2.93f);
        v0_1.lineToRelative(0.5f, -2.41f);
        v0_1.horizontalLineTo(9.31f);
        v0_1.horizontalLineTo(3f);
        v0_1.verticalLineToRelative(-1.99f);
        v0_1.lineTo(6.01f, 5f);
        v0_1.horizontalLineTo(15f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ThumbDownOffAltKt._thumbDownOffAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

