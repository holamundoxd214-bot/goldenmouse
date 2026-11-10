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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_terrain", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Terrain", "Landroidx/compose/material/icons/Icons$Rounded;", "getTerrain", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class TerrainKt {
    private static ImageVector _terrain;

    static {
    }

    public static final ImageVector getTerrain(Rounded arg19) {
        ImageVector v0 = TerrainKt._terrain;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Terrain", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(13.2f, 7.07f);
        v12.lineTo(10.25f, 11f);
        v12.lineToRelative(2.25f, 3f);
        v12.curveToRelative(0.33f, 0.44f, 0.24f, 1.07f, -0.2f, 1.4f);
        v12.curveToRelative(-0.44f, 0.33f, -1.07f, 0.25f, -1.4f, -0.2f);
        v12.curveToRelative(-1.05f, -1.4f, -2.31f, -3.07f, -3.1f, -4.14f);
        v12.curveToRelative(-0.4f, -0.53f, -1.2f, -0.53f, -1.6f, 0f);
        v12.lineToRelative(-4f, 5.33f);
        v12.curveToRelative(-0.49f, 0.67f, -0.02f, 1.61f, 0.8f, 1.61f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(0.82f, 0f, 1.29f, -0.94f, 0.8f, -1.6f);
        v12.lineToRelative(-7f, -9.33f);
        v12.curveToRelative(-0.4f, -0.54f, -1.2f, -0.54f, -1.6f, 0f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        TerrainKt._terrain = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

