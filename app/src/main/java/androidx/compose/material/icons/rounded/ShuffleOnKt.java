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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_shuffleOn", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ShuffleOn", "Landroidx/compose/material/icons/Icons$Rounded;", "getShuffleOn", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ShuffleOnKt {
    private static ImageVector _shuffleOn;

    static {
    }

    public static final ImageVector getShuffleOn(Rounded arg19) {
        ImageVector v0 = ShuffleOnKt._shuffleOn;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.ShuffleOn", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 1f);
        v12.horizontalLineTo(3f);
        v12.curveTo(1.9f, 1f, 1f, 1.9f, 1f, 3f);
        v12.verticalLineToRelative(18f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(3f);
        v12.curveTo(23f, 1.9f, 22.1f, 1f, 21f, 1f);
        v12.close();
        v12.moveTo(4.3f, 4.7f);
        v12.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0f);
        v12.lineToRelative(4.47f, 4.47f);
        v12.lineToRelative(-1.42f, 1.4f);
        v12.lineTo(4.3f, 6.11f);
        v12.curveTo(3.91f, 5.72f, 3.91f, 5.09f, 4.3f, 4.7f);
        v12.close();
        v12.moveTo(19.59f, 19.5f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.horizontalLineTo(15.3f);
        v12.curveToRelative(-0.45f, 0f, -0.67f, -0.54f, -0.36f, -0.85f);
        v12.lineToRelative(1.2f, -1.2f);
        v12.lineToRelative(-3.13f, -3.13f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(3.13f, 3.14f);
        v12.lineToRelative(1.19f, -1.19f);
        v12.curveToRelative(0.31f, -0.32f, 0.85f, -0.1f, 0.85f, 0.35f);
        v12.verticalLineTo(19.5f);
        v12.close();
        v12.moveTo(19.59f, 8.29f);
        v12.curveToRelative(0f, 0.45f, -0.54f, 0.67f, -0.85f, 0.36f);
        v12.lineToRelative(-1.19f, -1.19f);
        v12.lineTo(5.7f, 19.290001f);
        v12.curveToRelative(-0.39f, 0.39f, -1.02f, 0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(16.129999f, 6.04f);
        v12.lineToRelative(-1.19f, -1.19f);
        v12.curveTo(14.63f, 4.54f, 14.85f, 4f, 15.3f, 4f);
        v12.horizontalLineToRelative(3.79f);
        v12.curveToRelative(0.28f, 0f, 0.5f, 0.22f, 0.5f, 0.5f);
        v12.verticalLineTo(8.29f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ShuffleOnKt._shuffleOn = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

