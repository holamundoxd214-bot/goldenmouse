package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons$Sharp;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_designServices", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DesignServices", "Landroidx/compose/material/icons/Icons$Sharp;", "getDesignServices", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class DesignServicesKt {
    private static ImageVector _designServices;

    static {
    }

    public static final ImageVector getDesignServices(Sharp arg19) {
        ImageVector v0 = DesignServicesKt._designServices;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.DesignServices", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(21.790001f, 17.059999f);
        v0_1.lineToRelative(-5.55f, -5.55f);
        v0_1.lineToRelative(1.57f, -1.57f);
        v0_1.lineToRelative(-3.75f, -3.75f);
        v0_1.lineToRelative(-1.57f, 1.57f);
        v0_1.lineTo(6.94f, 2.21f);
        v0_1.lineTo(2.21f, 6.94f);
        v0_1.lineToRelative(5.55f, 5.55f);
        v0_1.lineTo(3f, 17.25f);
        v0_1.verticalLineTo(21f);
        v0_1.horizontalLineToRelative(3.75f);
        v0_1.lineToRelative(4.76f, -4.76f);
        v0_1.lineToRelative(5.55f, 5.55f);
        v0_1.lineToRelative(0f, 0f);
        v0_1.verticalLineToRelative(0f);
        v0_1.lineTo(21.790001f, 17.059999f);
        v0_1.close();
        v0_1.moveTo(9.18f, 11.07f);
        v0_1.lineTo(5.04f, 6.94f);
        v0_1.lineToRelative(1.9f, -1.9f);
        v0_1.lineToRelative(1.27f, 1.27f);
        v0_1.lineTo(7.02f, 7.5f);
        v0_1.lineToRelative(1.41f, 1.41f);
        v0_1.lineToRelative(1.19f, -1.19f);
        v0_1.lineToRelative(1.45f, 1.45f);
        v0_1.lineTo(9.18f, 11.07f);
        v0_1.close();
        v0_1.moveTo(12.93f, 14.82f);
        v0_1.lineToRelative(1.9f, -1.9f);
        v0_1.lineToRelative(1.45f, 1.45f);
        v0_1.lineToRelative(-1.19f, 1.19f);
        v0_1.lineToRelative(1.41f, 1.41f);
        v0_1.lineToRelative(1.19f, -1.19f);
        v0_1.lineToRelative(1.27f, 1.27f);
        v0_1.lineToRelative(-1.9f, 1.9f);
        v0_1.lineTo(12.93f, 14.82f);
        v0_1.close();
        Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v0_1 = new PathBuilder();
        v0_1.moveTo(15.133f, 5.123f);
        v0_1.lineToRelative(2.538f, -2.538f);
        v0_1.lineToRelative(3.748f, 3.748f);
        v0_1.lineToRelative(-2.538f, 2.538f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        DesignServicesKt._designServices = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

