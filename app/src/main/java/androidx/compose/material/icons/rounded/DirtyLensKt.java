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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_dirtyLens", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DirtyLens", "Landroidx/compose/material/icons/Icons$Rounded;", "getDirtyLens", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DirtyLensKt {
    private static ImageVector _dirtyLens;

    static {
    }

    public static final ImageVector getDirtyLens(Rounded arg19) {
        ImageVector v0 = DirtyLensKt._dirtyLens;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.DirtyLens", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20f, 5f);
        v12.horizontalLineToRelative(-3.17f);
        v12.lineToRelative(-1.24f, -1.35f);
        v12.curveTo(15.22f, 3.24f, 14.68f, 3f, 14.12f, 3f);
        v12.horizontalLineTo(9.88f);
        v12.curveToRelative(-0.56f, 0f, -1.1f, 0.24f, -1.48f, 0.65f);
        v12.lineTo(7.17f, 5f);
        v12.horizontalLineTo(4f);
        v12.curveTo(2.9f, 5f, 2f, 5.9f, 2f, 7f);
        v12.verticalLineToRelative(12f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(16f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(7f);
        v12.curveTo(22f, 5.9f, 21.1f, 5f, 20f, 5f);
        v12.close();
        v12.moveTo(16.66f, 16.58f);
        v12.curveToRelative(-1.14f, 1.86f, -3f, -1.03f, -3.81f, 0.09f);
        v12.curveToRelative(-0.39f, 0.57f, -0.09f, 1.49f, 0.13f, 2.33f);
        v12.curveToRelative(0f, 0.47f, -0.38f, 0.85f, -0.85f, 0.85f);
        v12.curveToRelative(-0.47f, 0f, -0.86f, -0.38f, -0.86f, -0.85f);
        v12.curveToRelative(0.14f, -0.98f, 0.42f, -2.05f, -0.16f, -2.43f);
        v12.curveToRelative(-0.89f, -0.59f, -1.27f, 2.06f, -2.8f, 1.35f);
        v12.curveToRelative(-1.39f, -1.12f, 1.05f, -1.29f, 0.5f, -3.27f);
        v12.curveToRelative(-0.22f, -0.79f, -2.28f, 0.36f, -2.4f, -1.24f);
        v12.curveToRelative(-0.08f, -1f, 1.49f, -0.74f, 1.51f, -1.49f);
        v12.curveToRelative(0.03f, -0.75f, -1.03f, -1.05f, -0.25f, -1.91f);
        v12.curveToRelative(0.22f, -0.24f, 0.71f, -0.26f, 0.91f, -0.19f);
        v12.curveToRelative(0.79f, 0.27f, 1.55f, 1.82f, 2.51f, 1.19f);
        v12.curveToRelative(1.03f, -0.66f, -1.88f, -2.35f, 0f, -2.86f);
        v12.curveToRelative(1.64f, -0.44f, 1.31f, 2.08f, 2.65f, 2.44f);
        v12.curveToRelative(1.94f, 0.52f, 2.65f, -4.55f, 4.41f, -2.33f);
        v12.curveToRelative(1.85f, 2.33f, -3.43f, 2.27f, -2.85f, 4.01f);
        v12.curveToRelative(0.34f, 1.01f, 2.15f, -1.2f, 2.76f, 0.53f);
        v12.curveToRelative(0.64f, 1.83f, -3.09f, 0.82f, -3.04f, 1.66f);
        v12.curveTo(15.08f, 15.29f, 17.43f, 15.01f, 16.66f, 16.58f);
        v12.close();
        v12.moveTo(18.139999f, 18.01f);
        v12.curveToRelative(-0.47f, 0f, -0.86f, -0.38f, -0.86f, -0.86f);
        v12.reflectiveCurveToRelative(0.38f, -0.86f, 0.86f, -0.86f);
        v12.curveToRelative(0.47f, 0f, 0.86f, 0.38f, 0.86f, 0.86f);
        v12.reflectiveCurveTo(18.620001f, 18.01f, 18.139999f, 18.01f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DirtyLensKt._dirtyLens = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

