package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons$Outlined;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_designServices", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DesignServices", "Landroidx/compose/material/icons/Icons$Outlined;", "getDesignServices", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DesignServicesKt {
    private static ImageVector _designServices;

    static {
    }

    public static final ImageVector getDesignServices(Outlined arg19) {
        ImageVector v0 = DesignServicesKt._designServices;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.DesignServices", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(20.969999f, 7.27f);
        v12.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f);
        v12.lineToRelative(-2.83f, -2.83f);
        v12.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f);
        v12.lineToRelative(-4.49f, 4.49f);
        v12.lineTo(8.35f, 3.63f);
        v12.curveToRelative(-0.78f, -0.78f, -2.05f, -0.78f, -2.83f, 0f);
        v12.lineToRelative(-1.9f, 1.9f);
        v12.curveToRelative(-0.78f, 0.78f, -0.78f, 2.05f, 0f, 2.83f);
        v12.lineToRelative(3.89f, 3.89f);
        v12.lineTo(3f, 16.76f);
        v12.verticalLineTo(21f);
        v12.horizontalLineToRelative(4.24f);
        v12.lineToRelative(4.52f, -4.52f);
        v12.lineToRelative(3.89f, 3.89f);
        v12.curveToRelative(0.95f, 0.95f, 2.23f, 0.6f, 2.83f, 0f);
        v12.lineToRelative(1.9f, -1.9f);
        v12.curveToRelative(0.78f, -0.78f, 0.78f, -2.05f, 0f, -2.83f);
        v12.lineToRelative(-3.89f, -3.89f);
        v12.lineTo(20.969999f, 7.27f);
        v12.close();
        v12.moveTo(5.04f, 6.94f);
        v12.lineToRelative(1.89f, -1.9f);
        v12.curveToRelative(0f, 0f, 0f, 0f, 0f, 0f);
        v12.lineToRelative(1.27f, 1.27f);
        v12.lineTo(7.02f, 7.5f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(1.19f, -1.19f);
        v12.lineToRelative(1.2f, 1.2f);
        v12.lineToRelative(-1.9f, 1.9f);
        v12.lineTo(5.04f, 6.94f);
        v12.close();
        v12.moveTo(16.27f, 14.38f);
        v12.lineToRelative(-1.19f, 1.19f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(1.19f, -1.19f);
        v12.lineToRelative(1.27f, 1.27f);
        v12.lineToRelative(-1.9f, 1.9f);
        v12.lineToRelative(-3.89f, -3.89f);
        v12.lineToRelative(1.9f, -1.9f);
        v12.lineTo(16.27f, 14.38f);
        v12.close();
        v12.moveTo(6.41f, 19f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-1.41f);
        v12.lineToRelative(9.61f, -9.61f);
        v12.lineToRelative(1.3f, 1.3f);
        v12.lineToRelative(0.11f, 0.11f);
        v12.lineTo(6.41f, 19f);
        v12.close();
        v12.moveTo(16.02f, 6.56f);
        v12.lineToRelative(1.41f, -1.41f);
        v12.lineToRelative(1.41f, 1.41f);
        v12.lineToRelative(-1.41f, 1.41f);
        v12.lineTo(16.02f, 6.56f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DesignServicesKt._designServices = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

