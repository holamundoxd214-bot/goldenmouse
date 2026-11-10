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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_scale", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Scale", "Landroidx/compose/material/icons/Icons$Rounded;", "getScale", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class ScaleKt {
    private static ImageVector _scale;

    static {
    }

    public static final ImageVector getScale(Rounded arg19) {
        ImageVector v0 = ScaleKt._scale;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Scale", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16f, 21f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.lineToRelative(3.43f, 0f);
        v12.curveToRelative(0.87f, 0f, 1.58f, -0.75f, 1.5f, -1.62f);
        v12.curveTo(21.34f, 14.18f, 17.4f, 11.68f, 14f, 11f);
        v12.verticalLineTo(8f);
        v12.curveToRelative(3.31f, -0.42f, 6.03f, -1.86f, 7.27f, -3.73f);
        v12.curveTo(21.92f, 3.3f, 21.15f, 2f, 19.98f, 2f);
        v12.horizontalLineTo(4.02f);
        v12.curveTo(2.85f, 2f, 2.08f, 3.3f, 2.73f, 4.27f);
        v12.curveTo(3.97f, 6.14f, 6.69f, 7.58f, 10f, 8f);
        v12.lineToRelative(0f, 3f);
        v12.curveToRelative(-3.4f, 0.68f, -7.34f, 3.18f, -7.93f, 9.38f);
        v12.curveTo(1.99f, 21.25f, 2.7f, 22f, 3.57f, 22f);
        v12.lineTo(7f, 22f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineTo(4.13f);
        v12.curveToRelative(0.93f, -6.83f, 6.65f, -7.2f, 7.87f, -7.2f);
        v12.reflectiveCurveToRelative(6.94f, 0.37f, 7.87f, 7.2f);
        v12.horizontalLineTo(17f);
        v12.curveTo(16.450001f, 20f, 16f, 20.450001f, 16f, 21f);
        v12.close();
        v12.moveTo(11.5f, 21.940001f);
        v12.curveToRelative(-0.7f, -0.17f, -1.27f, -0.74f, -1.44f, -1.44f);
        v12.curveToRelative(-0.18f, -0.74f, 0.06f, -1.44f, 0.53f, -1.91f);
        v12.curveToRelative(0.55f, -0.55f, 2.91f, -1.57f, 4.33f, -2.15f);
        v12.curveToRelative(0.41f, -0.17f, 0.82f, 0.24f, 0.65f, 0.65f);
        v12.curveToRelative(-0.58f, 1.42f, -1.6f, 3.78f, -2.15f, 4.33f);
        v12.curveTo(12.95f, 21.879999f, 12.25f, 22.120001f, 11.5f, 21.940001f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        ScaleKt._scale = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

