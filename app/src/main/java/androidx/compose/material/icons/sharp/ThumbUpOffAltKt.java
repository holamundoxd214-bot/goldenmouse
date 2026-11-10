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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_thumbUpOffAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ThumbUpOffAlt", "Landroidx/compose/material/icons/Icons$Sharp;", "getThumbUpOffAlt", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ThumbUpOffAltKt {
    private static ImageVector _thumbUpOffAlt;

    static {
    }

    public static final ImageVector getThumbUpOffAlt(Sharp arg18) {
        ImageVector v0 = ThumbUpOffAltKt._thumbUpOffAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.ThumbUpOffAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(14.17f, 1f);
        v0_1.lineTo(7f, 8.18f);
        v0_1.verticalLineTo(21f);
        v0_1.horizontalLineToRelative(12.31f);
        v0_1.lineTo(23f, 12.4f);
        v0_1.verticalLineTo(8f);
        v0_1.horizontalLineToRelative(-8.31f);
        v0_1.lineToRelative(1.12f, -5.38f);
        v0_1.lineTo(14.17f, 1f);
        v0_1.close();
        v0_1.moveTo(1f, 9f);
        v0_1.horizontalLineToRelative(4f);
        v0_1.verticalLineToRelative(12f);
        v0_1.horizontalLineTo(1f);
        v0_1.verticalLineTo(9f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ThumbUpOffAltKt._thumbUpOffAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

