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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pinch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pinch", "Landroidx/compose/material/icons/Icons$Sharp;", "getPinch", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PinchKt {
    private static ImageVector _pinch;

    static {
    }

    public static final ImageVector getPinch(Sharp arg19) {
        ImageVector v0 = PinchKt._pinch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.Pinch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(23.18f, 15.4f);
        v12.lineTo(22.1f, 23f);
        v12.horizontalLineToRelative(-9f);
        v12.lineTo(8f, 17.620001f);
        v12.lineToRelative(1.22f, -1.23f);
        v12.lineTo(13f, 17.24f);
        v12.verticalLineTo(6.5f);
        v12.curveTo(13f, 5.67f, 13.67f, 5f, 14.5f, 5f);
        v12.reflectiveCurveTo(16f, 5.67f, 16f, 6.5f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(1.38f);
        v12.lineTo(23.18f, 15.4f);
        v12.close();
        v12.moveTo(6f, 2.5f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineTo(9.5f);
        v12.verticalLineTo(3.56f);
        v12.lineTo(3.56f, 9.5f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(11f);
        v12.horizontalLineTo(1f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(2.44f);
        v12.lineTo(8.44f, 2.5f);
        v12.horizontalLineTo(6f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PinchKt._pinch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

