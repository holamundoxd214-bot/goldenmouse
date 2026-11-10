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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_loop", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Loop", "Landroidx/compose/material/icons/Icons$Rounded;", "getLoop", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LoopKt {
    private static ImageVector _loop;

    static {
    }

    public static final ImageVector getLoop(Rounded arg19) {
        ImageVector v0 = LoopKt._loop;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Loop", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 4f);
        v12.lineTo(12f, 2.21f);
        v12.curveToRelative(0f, -0.45f, -0.54f, -0.67f, -0.85f, -0.35f);
        v12.lineToRelative(-2.8f, 2.79f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(2.79f, 2.79f);
        v12.curveToRelative(0.32f, 0.31f, 0.86f, 0.09f, 0.86f, -0.36f);
        v12.lineTo(12f, 6f);
        v12.curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f);
        v12.curveToRelative(0f, 0.79f, -0.15f, 1.56f, -0.44f, 2.25f);
        v12.curveToRelative(-0.15f, 0.36f, -0.04f, 0.77f, 0.23f, 1.04f);
        v12.curveToRelative(0.51f, 0.51f, 1.37f, 0.33f, 1.64f, -0.34f);
        v12.curveToRelative(0.37f, -0.91f, 0.57f, -1.91f, 0.57f, -2.95f);
        v12.curveToRelative(0f, -4.42f, -3.58f, -8f, -8f, -8f);
        v12.close();
        v12.moveTo(12f, 18f);
        v12.curveToRelative(-3.31f, 0f, -6f, -2.69f, -6f, -6f);
        v12.curveToRelative(0f, -0.79f, 0.15f, -1.56f, 0.44f, -2.25f);
        v12.curveToRelative(0.15f, -0.36f, 0.04f, -0.77f, -0.23f, -1.04f);
        v12.curveToRelative(-0.51f, -0.51f, -1.37f, -0.33f, -1.64f, 0.34f);
        v12.curveTo(4.2f, 9.96f, 4f, 10.96f, 4f, 12f);
        v12.curveToRelative(0f, 4.42f, 3.58f, 8f, 8f, 8f);
        v12.verticalLineToRelative(1.79f);
        v12.curveToRelative(0f, 0.45f, 0.54f, 0.67f, 0.85f, 0.35f);
        v12.lineToRelative(2.79f, -2.79f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(-2.79f, -2.79f);
        v12.curveToRelative(-0.31f, -0.31f, -0.85f, -0.09f, -0.85f, 0.36f);
        v12.lineTo(12f, 18f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LoopKt._loop = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

