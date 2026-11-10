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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_spa", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Spa", "Landroidx/compose/material/icons/Icons$Filled;", "getSpa", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SpaKt {
    private static ImageVector _spa;

    static {
    }

    public static final ImageVector getSpa(Filled arg19) {
        ImageVector v0 = SpaKt._spa;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Spa", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(8.55f, 12f);
        v12.curveToRelative(-1.07f, -0.71f, -2.25f, -1.27f, -3.53f, -1.61f);
        v12.curveToRelative(1.28f, 0.34f, 2.46f, 0.9f, 3.53f, 1.61f);
        v12.close();
        v12.moveTo(18.98f, 10.39f);
        v12.curveToRelative(-1.29f, 0.34f, -2.49f, 0.91f, -3.57f, 1.64f);
        v12.curveToRelative(1.08f, -0.73f, 2.28f, -1.3f, 3.57f, -1.64f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(15.49f, 9.63f);
        v12.curveToRelative(-0.18f, -2.79f, -1.31f, -5.51f, -3.43f, -7.63f);
        v12.curveToRelative(-2.14f, 2.14f, -3.32f, 4.86f, -3.55f, 7.63f);
        v12.curveToRelative(1.28f, 0.68f, 2.46f, 1.56f, 3.49f, 2.63f);
        v12.curveToRelative(1.03f, -1.06f, 2.21f, -1.94f, 3.49f, -2.63f);
        v12.close();
        v12.moveTo(8.99f, 12.28f);
        v12.curveToRelative(-0.14f, -0.1f, -0.3f, -0.19f, -0.45f, -0.29f);
        v12.curveToRelative(0.15f, 0.11f, 0.31f, 0.19f, 0.45f, 0.29f);
        v12.close();
        v12.moveTo(15.41f, 12.03f);
        v12.curveToRelative(-0.13f, 0.09f, -0.27f, 0.16f, -0.4f, 0.26f);
        v12.curveToRelative(0.13f, -0.1f, 0.27f, -0.17f, 0.4f, -0.26f);
        v12.close();
        v12.moveTo(12f, 15.45f);
        v12.curveTo(9.85f, 12.17f, 6.18f, 10f, 2f, 10f);
        v12.curveToRelative(0f, 5.32f, 3.36f, 9.82f, 8.03f, 11.49f);
        v12.curveToRelative(0.63f, 0.23f, 1.29f, 0.4f, 1.97f, 0.51f);
        v12.curveToRelative(0.68f, -0.12f, 1.33f, -0.29f, 1.97f, -0.51f);
        v12.curveTo(18.639999f, 19.82f, 22f, 15.32f, 22f, 10f);
        v12.curveToRelative(-4.18f, 0f, -7.85f, 2.17f, -10f, 5.45f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SpaKt._spa = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

