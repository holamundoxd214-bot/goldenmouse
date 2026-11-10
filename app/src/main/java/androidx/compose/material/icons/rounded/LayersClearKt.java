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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_layersClear", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LayersClear", "Landroidx/compose/material/icons/Icons$Rounded;", "getLayersClear", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class LayersClearKt {
    private static ImageVector _layersClear;

    static {
    }

    public static final ImageVector getLayersClear(Rounded arg19) {
        ImageVector v0 = LayersClearKt._layersClear;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.LayersClear", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(19.99f, 9.79f);
        v12.curveToRelative(0.51f, -0.4f, 0.51f, -1.18f, 0f, -1.58f);
        v12.lineToRelative(-6.76f, -5.26f);
        v12.curveToRelative(-0.72f, -0.56f, -1.73f, -0.56f, -2.46f, 0f);
        v12.lineTo(9.41f, 4.02f);
        v12.lineToRelative(7.88f, 7.88f);
        v12.lineToRelative(2.7f, -2.11f);
        v12.close();
        v12.moveTo(19.99f, 13.28f);
        v12.lineToRelative(-0.01f, -0.01f);
        v12.curveToRelative(-0.36f, -0.28f, -0.86f, -0.28f, -1.22f, 0f);
        v12.lineToRelative(-0.05f, 0.04f);
        v12.lineToRelative(1.4f, 1.4f);
        v12.curveToRelative(0.37f, -0.41f, 0.34f, -1.07f, -0.12f, -1.43f);
        v12.close();
        v12.moveTo(21.440001f, 18.879999f);
        v12.lineTo(4.12f, 1.56f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.lineToRelative(3.52f, 3.52f);
        v12.lineToRelative(-2.22f, 1.72f);
        v12.curveToRelative(-0.51f, 0.4f, -0.51f, 1.18f, 0f, 1.58f);
        v12.lineToRelative(6.76f, 5.26f);
        v12.curveToRelative(0.72f, 0.56f, 1.73f, 0.56f, 2.46f, 0f);
        v12.lineToRelative(0.87f, -0.68f);
        v12.lineToRelative(1.42f, 1.42f);
        v12.lineToRelative(-2.92f, 2.27f);
        v12.curveToRelative(-0.36f, 0.28f, -0.87f, 0.28f, -1.23f, 0f);
        v12.lineToRelative(-6.15f, -4.78f);
        v12.curveToRelative(-0.36f, -0.28f, -0.86f, -0.28f, -1.22f, 0f);
        v12.curveToRelative(-0.51f, 0.4f, -0.51f, 1.17f, 0f, 1.57f);
        v12.lineToRelative(6.76f, 5.26f);
        v12.curveToRelative(0.72f, 0.56f, 1.73f, 0.56f, 2.46f, 0f);
        v12.lineToRelative(3.72f, -2.89f);
        v12.lineToRelative(3.07f, 3.07f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.curveToRelative(0.41f, -0.39f, 0.41f, -1.02f, 0.02f, -1.41f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        LayersClearKt._layersClear = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

