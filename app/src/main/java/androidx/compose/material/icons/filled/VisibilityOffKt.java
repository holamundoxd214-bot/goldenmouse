package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_visibilityOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VisibilityOff", "Landroidx/compose/material/icons/Icons$Filled;", "getVisibilityOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VisibilityOffKt {
    private static ImageVector _visibilityOff;

    static {
    }

    public static final ImageVector getVisibilityOff(Filled arg19) {
        ImageVector v0 = VisibilityOffKt._visibilityOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.VisibilityOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 7f);
        v12.curveToRelative(2.76f, 0f, 5f, 2.24f, 5f, 5f);
        v12.curveToRelative(0f, 0.65f, -0.13f, 1.26f, -0.36f, 1.83f);
        v12.lineToRelative(2.92f, 2.92f);
        v12.curveToRelative(1.51f, -1.26f, 2.7f, -2.89f, 3.43f, -4.75f);
        v12.curveToRelative(-1.73f, -4.39f, -6f, -7.5f, -11f, -7.5f);
        v12.curveToRelative(-1.4f, 0f, -2.74f, 0.25f, -3.98f, 0.7f);
        v12.lineToRelative(2.16f, 2.16f);
        v12.curveTo(10.74f, 7.13f, 11.35f, 7f, 12f, 7f);
        v12.close();
        v12.moveTo(2f, 4.27f);
        v12.lineToRelative(2.28f, 2.28f);
        v12.lineToRelative(0.46f, 0.46f);
        v12.curveTo(3.08f, 8.3f, 1.78f, 10.02f, 1f, 12f);
        v12.curveToRelative(1.73f, 4.39f, 6f, 7.5f, 11f, 7.5f);
        v12.curveToRelative(1.55f, 0f, 3.03f, -0.3f, 4.38f, -0.84f);
        v12.lineToRelative(0.42f, 0.42f);
        v12.lineTo(19.73f, 22f);
        v12.lineTo(21f, 20.73f);
        v12.lineTo(3.27f, 3f);
        v12.lineTo(2f, 4.27f);
        v12.close();
        v12.moveTo(7.53f, 9.8f);
        v12.lineToRelative(1.55f, 1.55f);
        v12.curveToRelative(-0.05f, 0.21f, -0.08f, 0.43f, -0.08f, 0.65f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.curveToRelative(0.22f, 0f, 0.44f, -0.03f, 0.65f, -0.08f);
        v12.lineToRelative(1.55f, 1.55f);
        v12.curveToRelative(-0.67f, 0.33f, -1.41f, 0.53f, -2.2f, 0.53f);
        v12.curveToRelative(-2.76f, 0f, -5f, -2.24f, -5f, -5f);
        v12.curveToRelative(0f, -0.79f, 0.2f, -1.53f, 0.53f, -2.2f);
        v12.close();
        v12.moveTo(11.84f, 9.02f);
        v12.lineToRelative(3.15f, 3.15f);
        v12.lineToRelative(0.02f, -0.16f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.lineToRelative(-0.17f, 0.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VisibilityOffKt._visibilityOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

