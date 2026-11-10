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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_energySavingsLeaf", "Landroidx/compose/ui/graphics/vector/ImageVector;", "EnergySavingsLeaf", "Landroidx/compose/material/icons/Icons$Filled;", "getEnergySavingsLeaf", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class EnergySavingsLeafKt {
    private static ImageVector _energySavingsLeaf;

    static {
    }

    public static final ImageVector getEnergySavingsLeaf(Filled arg19) {
        ImageVector v0 = EnergySavingsLeafKt._energySavingsLeaf;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.EnergySavingsLeaf", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 3f);
        v12.curveToRelative(-4.8f, 0f, -9f, 3.86f, -9f, 9f);
        v12.curveToRelative(0f, 2.12f, 0.74f, 4.07f, 1.97f, 5.61f);
        v12.lineTo(3f, 19.59f);
        v12.lineTo(4.41f, 21f);
        v12.lineToRelative(1.97f, -1.97f);
        v12.curveTo(7.93f, 20.26f, 9.88f, 21f, 12f, 21f);
        v12.curveToRelative(2.3f, 0f, 4.61f, -0.88f, 6.36f, -2.64f);
        v12.curveTo(20.120001f, 16.610001f, 21f, 14.3f, 21f, 12f);
        v12.lineToRelative(0f, -9f);
        v12.lineTo(12f, 3f);
        v12.close();
        v12.moveTo(15.83f, 12.26f);
        v12.lineToRelative(-5.16f, 4.63f);
        v12.curveToRelative(-0.16f, 0.15f, -0.41f, 0.14f, -0.56f, -0.01f);
        v12.curveToRelative(-0.14f, -0.14f, -0.16f, -0.36f, -0.04f, -0.52f);
        v12.lineToRelative(2.44f, -3.33f);
        v12.lineToRelative(-4.05f, -0.4f);
        v12.curveToRelative(-0.44f, -0.04f, -0.63f, -0.59f, -0.3f, -0.89f);
        v12.lineToRelative(5.16f, -4.63f);
        v12.curveToRelative(0.16f, -0.15f, 0.41f, -0.14f, 0.56f, 0.01f);
        v12.curveToRelative(0.14f, 0.14f, 0.16f, 0.36f, 0.04f, 0.52f);
        v12.lineToRelative(-2.44f, 3.33f);
        v12.lineToRelative(4.05f, 0.4f);
        v12.curveTo(15.98f, 11.41f, 16.16f, 11.96f, 15.83f, 12.26f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        EnergySavingsLeafKt._energySavingsLeaf = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

