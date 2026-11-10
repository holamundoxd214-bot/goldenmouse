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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_replay", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Replay", "Landroidx/compose/material/icons/Icons$Rounded;", "getReplay", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ReplayKt {
    private static ImageVector _replay;

    static {
    }

    public static final ImageVector getReplay(Rounded arg19) {
        ImageVector v0 = ReplayKt._replay;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Replay", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 5f);
        v12.verticalLineTo(2.21f);
        v12.curveToRelative(0f, -0.45f, -0.54f, -0.67f, -0.85f, -0.35f);
        v12.lineToRelative(-3.8f, 3.79f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(3.79f, 3.79f);
        v12.curveToRelative(0.32f, 0.31f, 0.86f, 0.09f, 0.86f, -0.36f);
        v12.verticalLineTo(7f);
        v12.curveToRelative(3.73f, 0f, 6.68f, 3.42f, 5.86f, 7.29f);
        v12.curveToRelative(-0.47f, 2.27f, -2.31f, 4.1f, -4.57f, 4.57f);
        v12.curveToRelative(-3.57f, 0.75f, -6.75f, -1.7f, -7.23f, -5.01f);
        v12.curveToRelative(-0.07f, -0.48f, -0.49f, -0.85f, -0.98f, -0.85f);
        v12.curveToRelative(-0.6f, 0f, -1.08f, 0.53f, -1f, 1.13f);
        v12.curveToRelative(0.62f, 4.39f, 4.8f, 7.64f, 9.53f, 6.72f);
        v12.curveToRelative(3.12f, -0.61f, 5.63f, -3.12f, 6.24f, -6.24f);
        v12.curveTo(20.84f, 9.48f, 16.940001f, 5f, 12f, 5f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ReplayKt._replay = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

