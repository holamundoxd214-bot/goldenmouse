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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_grass", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Grass", "Landroidx/compose/material/icons/Icons$Rounded;", "getGrass", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GrassKt {
    private static ImageVector _grass;

    static {
    }

    public static final ImageVector getGrass(Rounded arg19) {
        ImageVector v0 = GrassKt._grass;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Grass", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.64f, 11.02f);
        v12.curveToRelative(0.55f, -1.47f, 1.43f, -2.78f, 2.56f, -3.83f);
        v12.curveToRelative(0.38f, -0.36f, 0.04f, -1f, -0.46f, -0.85f);
        v12.curveToRelative(-3.32f, 0.98f, -5.75f, 4.05f, -5.74f, 7.69f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.curveTo(12.95f, 12.75f, 14.2f, 11.72f, 15.64f, 11.02f);
        v12.close();
        v12.moveTo(11.42f, 8.85f);
        v12.curveToRelative(-0.6f, -1.56f, -1.63f, -2.91f, -2.96f, -3.87f);
        v12.curveTo(8.04f, 4.68f, 7.5f, 5.17f, 7.74f, 5.63f);
        v12.curveTo(8.54f, 7.15f, 9f, 8.88f, 9f, 10.71f);
        v12.curveToRelative(0f, 0.21f, -0.03f, 0.41f, -0.04f, 0.61f);
        v12.curveToRelative(0.43f, 0.24f, 0.83f, 0.52f, 1.22f, 0.82f);
        v12.curveTo(10.39f, 10.96f, 10.83f, 9.85f, 11.42f, 8.85f);
        v12.close();
        v12.moveTo(12f, 20f);
        v12.horizontalLineTo(3f);
        v12.curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f);
        v12.reflectiveCurveToRelative(0.45f, -1f, 1f, -1f);
        v12.horizontalLineToRelative(4.75f);
        v12.curveToRelative(-0.57f, -2.19f, -2.04f, -4.02f, -4f, -5.06f);
        v12.lineToRelative(0f, 0f);
        v12.curveToRelative(-0.16f, -0.08f, -0.26f, -0.25f, -0.26f, -0.44f);
        v12.curveToRelative(0f, -0.27f, 0.22f, -0.49f, 0.49f, -0.5f);
        v12.curveToRelative(0.01f, 0f, 0.02f, 0f, 0.02f, 0f);
        v12.curveTo(8.42f, 12f, 12f, 15.58f, 12f, 20f);
        v12.close();
        v12.moveTo(20.26f, 12.94f);
        v12.lineTo(20.26f, 12.94f);
        v12.curveToRelative(-1.96f, 1.04f, -3.44f, 2.87f, -4f, 5.06f);
        v12.horizontalLineTo(21f);
        v12.curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f);
        v12.reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f);
        v12.horizontalLineToRelative(-5f);
        v12.horizontalLineToRelative(-2f);
        v12.curveToRelative(0f, -0.68f, -0.07f, -1.35f, -0.2f, -2f);
        v12.curveToRelative(-0.15f, -0.72f, -0.38f, -1.42f, -0.67f, -2.07f);
        v12.curveTo(14.52f, 13.58f, 17.07f, 12f, 20f, 12f);
        v12.curveToRelative(0.01f, 0f, 0.02f, 0f, 0.02f, 0f);
        v12.curveToRelative(0.27f, 0f, 0.49f, 0.23f, 0.49f, 0.5f);
        v12.curveTo(20.52f, 12.69f, 20.41f, 12.85f, 20.26f, 12.94f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GrassKt._grass = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

