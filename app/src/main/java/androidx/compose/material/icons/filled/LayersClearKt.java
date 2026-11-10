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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_layersClear", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LayersClear", "Landroidx/compose/material/icons/Icons$Filled;", "getLayersClear", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LayersClearKt {
    private static ImageVector _layersClear;

    static {
    }

    public static final ImageVector getLayersClear(Filled arg18) {
        ImageVector v0 = LayersClearKt._layersClear;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.LayersClear", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(19.809999f, 14.99f);
        v0_1.lineToRelative(1.19f, -0.92f);
        v0_1.lineToRelative(-1.43f, -1.43f);
        v0_1.lineToRelative(-1.19f, 0.92f);
        v0_1.lineToRelative(1.43f, 1.43f);
        v0_1.close();
        v0_1.moveTo(19.360001f, 10.27f);
        v0_1.lineTo(21f, 9f);
        v0_1.lineToRelative(-9f, -7f);
        v0_1.lineToRelative(-2.91f, 2.27f);
        v0_1.lineToRelative(7.87f, 7.88f);
        v0_1.lineToRelative(2.4f, -1.88f);
        v0_1.close();
        v0_1.moveTo(3.27f, 1f);
        v0_1.lineTo(2f, 2.27f);
        v0_1.lineToRelative(4.22f, 4.22f);
        v0_1.lineTo(3f, 9f);
        v0_1.lineToRelative(1.63f, 1.27f);
        v0_1.lineTo(12f, 16f);
        v0_1.lineToRelative(2.1f, -1.63f);
        v0_1.lineToRelative(1.43f, 1.43f);
        v0_1.lineTo(12f, 18.540001f);
        v0_1.lineToRelative(-7.37f, -5.73f);
        v0_1.lineTo(3f, 14.07f);
        v0_1.lineToRelative(9f, 7f);
        v0_1.lineToRelative(4.95f, -3.85f);
        v0_1.lineTo(20.73f, 21f);
        v0_1.lineTo(22f, 19.73f);
        v0_1.lineTo(3.27f, 1f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LayersClearKt._layersClear = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

