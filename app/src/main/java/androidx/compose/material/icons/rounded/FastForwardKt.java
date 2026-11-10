package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons$Rounded;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_fastForward", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FastForward", "Landroidx/compose/material/icons/Icons$Rounded;", "getFastForward", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FastForwardKt {
    private static ImageVector _fastForward;

    static {
    }

    public static final ImageVector getFastForward(Rounded arg19) {
        ImageVector v0 = FastForwardKt._fastForward;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FastForward", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(5.58f, 16.889999f);
        v12.lineToRelative(5.77f, -4.07f);
        v12.curveToRelative(0.56f, -0.4f, 0.56f, -1.24f, 0f, -1.63f);
        v12.lineTo(5.58f, 7.11f);
        v12.curveTo(4.91f, 6.65f, 4f, 7.12f, 4f, 7.93f);
        v12.verticalLineToRelative(8.14f);
        v12.curveToRelative(0f, 0.81f, 0.91f, 1.28f, 1.58f, 0.82f);
        v12.close();
        v12.moveTo(13f, 7.93f);
        v12.verticalLineToRelative(8.14f);
        v12.curveToRelative(0f, 0.81f, 0.91f, 1.28f, 1.58f, 0.82f);
        v12.lineToRelative(5.77f, -4.07f);
        v12.curveToRelative(0.56f, -0.4f, 0.56f, -1.24f, 0f, -1.63f);
        v12.lineToRelative(-5.77f, -4.07f);
        v12.curveToRelative(-0.67f, -0.47f, -1.58f, 0f, -1.58f, 0.81f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FastForwardKt._fastForward = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

