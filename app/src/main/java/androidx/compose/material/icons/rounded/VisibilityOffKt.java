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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_visibilityOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VisibilityOff", "Landroidx/compose/material/icons/Icons$Rounded;", "getVisibilityOff", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VisibilityOffKt {
    private static ImageVector _visibilityOff;

    static {
    }

    public static final ImageVector getVisibilityOff(Rounded arg19) {
        ImageVector v0 = VisibilityOffKt._visibilityOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.VisibilityOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 6.5f);
        v12.curveToRelative(2.76f, 0f, 5f, 2.24f, 5f, 5f);
        v12.curveToRelative(0f, 0.51f, -0.1f, 1f, -0.24f, 1.46f);
        v12.lineToRelative(3.06f, 3.06f);
        v12.curveToRelative(1.39f, -1.23f, 2.49f, -2.77f, 3.18f, -4.53f);
        v12.curveTo(21.27f, 7.11f, 17f, 4f, 12f, 4f);
        v12.curveToRelative(-1.27f, 0f, -2.49f, 0.2f, -3.64f, 0.57f);
        v12.lineToRelative(2.17f, 2.17f);
        v12.curveToRelative(0.47f, -0.14f, 0.96f, -0.24f, 1.47f, -0.24f);
        v12.close();
        v12.moveTo(2.71f, 3.16f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(1.97f, 1.97f);
        v12.curveTo(3.06f, 7.83f, 1.77f, 9.53f, 1f, 11.5f);
        v12.curveTo(2.73f, 15.89f, 7f, 19f, 12f, 19f);
        v12.curveToRelative(1.52f, 0f, 2.97f, -0.3f, 4.31f, -0.82f);
        v12.lineToRelative(2.72f, 2.72f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineTo(4.13f, 3.16f);
        v12.curveToRelative(-0.39f, -0.39f, -1.03f, -0.39f, -1.42f, 0f);
        v12.close();
        v12.moveTo(12f, 16.5f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.curveToRelative(0f, -0.77f, 0.18f, -1.5f, 0.49f, -2.14f);
        v12.lineToRelative(1.57f, 1.57f);
        v12.curveToRelative(-0.03f, 0.18f, -0.06f, 0.37f, -0.06f, 0.57f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.curveToRelative(0.2f, 0f, 0.38f, -0.03f, 0.57f, -0.07f);
        v12.lineTo(14.14f, 16f);
        v12.curveToRelative(-0.65f, 0.32f, -1.37f, 0.5f, -2.14f, 0.5f);
        v12.close();
        v12.moveTo(14.97f, 11.17f);
        v12.curveToRelative(-0.15f, -1.4f, -1.25f, -2.49f, -2.64f, -2.64f);
        v12.lineToRelative(2.64f, 2.64f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VisibilityOffKt._visibilityOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

