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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_mapsHomeWork", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MapsHomeWork", "Landroidx/compose/material/icons/Icons$Rounded;", "getMapsHomeWork", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class MapsHomeWorkKt {
    private static ImageVector _mapsHomeWork;

    static {
    }

    public static final ImageVector getMapsHomeWork(Rounded arg19) {
        ImageVector v0 = MapsHomeWorkKt._mapsHomeWork;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.MapsHomeWork", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.16f, 10.4f);
        v12.lineToRelative(-5f, -3.57f);
        v12.curveToRelative(-0.7f, -0.5f, -1.63f, -0.5f, -2.32f, 0f);
        v12.lineToRelative(-5f, 3.57f);
        v12.curveTo(1.31f, 10.78f, 1f, 11.38f, 1f, 12.03f);
        v12.verticalLineTo(20f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(-6f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(6f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-7.97f);
        v12.curveTo(15f, 11.38f, 14.69f, 10.78f, 14.16f, 10.4f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(21.030001f, 3f);
        v12.horizontalLineToRelative(-9.06f);
        v12.curveTo(10.88f, 3f, 10f, 3.88f, 10f, 4.97f);
        v12.lineToRelative(0.09f, 0.09f);
        v12.curveToRelative(0.08f, 0.05f, 0.16f, 0.09f, 0.24f, 0.14f);
        v12.lineToRelative(5f, 3.57f);
        v12.curveToRelative(0.76f, 0.54f, 1.3f, 1.34f, 1.54f, 2.23f);
        v12.horizontalLineTo(19f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(3f);
        v12.verticalLineToRelative(1f);
        v12.horizontalLineToRelative(4.03f);
        v12.curveToRelative(1.09f, 0f, 1.97f, -0.88f, 1.97f, -1.97f);
        v12.verticalLineTo(4.97f);
        v12.curveTo(23f, 3.88f, 22.120001f, 3f, 21.030001f, 3f);
        v12.close();
        v12.moveTo(19f, 9f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(7f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(9f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        MapsHomeWorkKt._mapsHomeWork = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

