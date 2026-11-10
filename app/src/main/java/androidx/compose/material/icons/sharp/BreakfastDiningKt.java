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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_breakfastDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BreakfastDining", "Landroidx/compose/material/icons/Icons$Sharp;", "getBreakfastDining", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class BreakfastDiningKt {
    private static ImageVector _breakfastDining;

    static {
    }

    public static final ImageVector getBreakfastDining(Sharp arg19) {
        ImageVector v0 = BreakfastDiningKt._breakfastDining;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.BreakfastDining", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.85f, 3f);
        v12.lineTo(6.14f, 3f);
        v12.curveTo(4.15f, 3f, 2.36f, 4.39f, 2.05f, 6.36f);
        v12.curveTo(1.78f, 8.11f, 2.64f, 9.65f, 4f, 10.45f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineTo(10.45f);
        v12.curveToRelative(1.36f, -0.79f, 2.23f, -2.36f, 1.95f, -4.11f);
        v12.curveTo(21.629999f, 4.38f, 19.83f, 3f, 17.85f, 3f);
        v12.close();
        v12.moveTo(16.41f, 13f);
        v12.lineTo(12f, 17.42f);
        v12.lineTo(7.59f, 13f);
        v12.lineTo(12f, 8.59f);
        v12.lineTo(16.41f, 13f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        BreakfastDiningKt._breakfastDining = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

