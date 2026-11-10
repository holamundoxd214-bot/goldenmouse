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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_spa", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Spa", "Landroidx/compose/material/icons/Icons$Rounded;", "getSpa", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SpaKt {
    private static ImageVector _spa;

    static {
    }

    public static final ImageVector getSpa(Rounded arg19) {
        ImageVector v0 = SpaKt._spa;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Spa", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15.49f, 9.63f);
        v12.curveToRelative(-0.16f, -2.42f, -1.03f, -4.79f, -2.64f, -6.76f);
        v12.curveToRelative(-0.41f, -0.5f, -1.16f, -0.5f, -1.57f, 0f);
        v12.curveToRelative(-1.65f, 1.98f, -2.57f, 4.35f, -2.77f, 6.76f);
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
        v12.curveToRelative(-1.95f, -2.97f, -5.14f, -5.03f, -8.83f, -5.39f);
        v12.curveToRelative(-0.64f, -0.06f, -1.17f, 0.47f, -1.11f, 1.11f);
        v12.curveToRelative(0.45f, 4.8f, 3.65f, 8.78f, 7.98f, 10.33f);
        v12.curveToRelative(0.63f, 0.23f, 1.29f, 0.4f, 1.97f, 0.51f);
        v12.curveToRelative(0.68f, -0.12f, 1.33f, -0.29f, 1.97f, -0.51f);
        v12.curveToRelative(4.33f, -1.55f, 7.53f, -5.52f, 7.98f, -10.33f);
        v12.curveToRelative(0.06f, -0.64f, -0.48f, -1.17f, -1.11f, -1.11f);
        v12.curveToRelative(-3.71f, 0.36f, -6.9f, 2.42f, -8.85f, 5.39f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SpaKt._spa = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

