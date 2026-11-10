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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_map", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Map", "Landroidx/compose/material/icons/Icons$Rounded;", "getMap", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MapKt {
    private static ImageVector _map;

    static {
    }

    public static final ImageVector getMap(Rounded arg19) {
        ImageVector v0 = MapKt._map;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Map", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.65f, 4.98f);
        v12.lineToRelative(-5f, -1.75f);
        v12.curveToRelative(-0.42f, -0.15f, -0.88f, -0.15f, -1.3f, -0.01f);
        v12.lineTo(4.36f, 4.56f);
        v12.curveTo(3.55f, 4.84f, 3f, 5.6f, 3f, 6.46f);
        v12.verticalLineToRelative(11.85f);
        v12.curveToRelative(0f, 1.41f, 1.41f, 2.37f, 2.72f, 1.86f);
        v12.lineToRelative(2.93f, -1.14f);
        v12.curveToRelative(0.22f, -0.09f, 0.47f, -0.09f, 0.69f, -0.01f);
        v12.lineToRelative(5f, 1.75f);
        v12.curveToRelative(0.42f, 0.15f, 0.88f, 0.15f, 1.3f, 0.01f);
        v12.lineToRelative(3.99f, -1.34f);
        v12.curveToRelative(0.81f, -0.27f, 1.36f, -1.04f, 1.36f, -1.9f);
        v12.verticalLineTo(5.69f);
        v12.curveToRelative(0f, -1.41f, -1.41f, -2.37f, -2.72f, -1.86f);
        v12.lineToRelative(-2.93f, 1.14f);
        v12.curveToRelative(-0.22f, 0.08f, -0.46f, 0.09f, -0.69f, 0.01f);
        v12.close();
        v12.moveTo(15f, 18.889999f);
        v12.lineToRelative(-6f, -2.11f);
        v12.verticalLineTo(5.11f);
        v12.lineToRelative(6f, 2.11f);
        v12.verticalLineToRelative(11.67f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MapKt._map = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

