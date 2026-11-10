package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons$TwoTone;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_map", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Map", "Landroidx/compose/material/icons/Icons$TwoTone;", "getMap", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MapKt {
    private static ImageVector _map;

    static {
    }

    public static final ImageVector getMap(TwoTone arg19) {
        ImageVector v0 = MapKt._map;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Map", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(5f, 18.309999f);
        v0_1.lineToRelative(3f, -1.16f);
        v0_1.lineTo(8f, 5.45f);
        v0_1.lineTo(5f, 6.46f);
        v0_1.close();
        v0_1.moveTo(16f, 18.549999f);
        v0_1.lineToRelative(3f, -1.01f);
        v0_1.lineTo(19f, 5.69f);
        v0_1.lineToRelative(-3f, 1.17f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.5f, 3f);
        v12.lineToRelative(-0.16f, 0.03f);
        v12.lineTo(15f, 5.1f);
        v12.lineTo(9f, 3f);
        v12.lineTo(3.36f, 4.9f);
        v12.curveToRelative(-0.21f, 0.07f, -0.36f, 0.25f, -0.36f, 0.48f);
        v12.lineTo(3f, 20.5f);
        v12.curveToRelative(0f, 0.28f, 0.22f, 0.5f, 0.5f, 0.5f);
        v12.lineToRelative(0.16f, -0.03f);
        v12.lineTo(9f, 18.9f);
        v12.lineToRelative(6f, 2.1f);
        v12.lineToRelative(5.64f, -1.9f);
        v12.curveToRelative(0.21f, -0.07f, 0.36f, -0.25f, 0.36f, -0.48f);
        v12.lineTo(21f, 3.5f);
        v12.curveToRelative(0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        v12.close();
        v12.moveTo(8f, 17.15f);
        v12.lineToRelative(-3f, 1.16f);
        v12.lineTo(5f, 6.46f);
        v12.lineToRelative(3f, -1.01f);
        v12.verticalLineToRelative(11.7f);
        v12.close();
        v12.moveTo(14f, 18.530001f);
        v12.lineToRelative(-4f, -1.4f);
        v12.lineTo(10f, 5.47f);
        v12.lineToRelative(4f, 1.4f);
        v12.verticalLineToRelative(11.66f);
        v12.close();
        v12.moveTo(19f, 17.540001f);
        v12.lineToRelative(-3f, 1.01f);
        v12.lineTo(16f, 6.86f);
        v12.lineToRelative(3f, -1.16f);
        v12.verticalLineToRelative(11.84f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MapKt._map = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

