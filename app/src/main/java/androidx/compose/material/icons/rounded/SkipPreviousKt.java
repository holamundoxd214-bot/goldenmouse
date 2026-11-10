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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_skipPrevious", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SkipPrevious", "Landroidx/compose/material/icons/Icons$Rounded;", "getSkipPrevious", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SkipPreviousKt {
    private static ImageVector _skipPrevious;

    static {
    }

    public static final ImageVector getSkipPrevious(Rounded arg19) {
        ImageVector v0 = SkipPreviousKt._skipPrevious;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SkipPrevious", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(7f, 6f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 0.55f, -0.45f, 1f, -1f, 1f);
        v12.reflectiveCurveToRelative(-1f, -0.45f, -1f, -1f);
        v12.lineTo(6f, 7f);
        v12.curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f);
        v12.close();
        v12.moveTo(10.66f, 12.82f);
        v12.lineToRelative(5.77f, 4.07f);
        v12.curveToRelative(0.66f, 0.47f, 1.58f, -0.01f, 1.58f, -0.82f);
        v12.lineTo(18.01f, 7.93f);
        v12.curveToRelative(0f, -0.81f, -0.91f, -1.28f, -1.58f, -0.82f);
        v12.lineToRelative(-5.77f, 4.07f);
        v12.curveToRelative(-0.57f, 0.4f, -0.57f, 1.24f, 0f, 1.64f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SkipPreviousKt._skipPrevious = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

