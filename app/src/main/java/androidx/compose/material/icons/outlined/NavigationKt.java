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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_navigation", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Navigation", "Landroidx/compose/material/icons/Icons$Outlined;", "getNavigation", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class NavigationKt {
    private static ImageVector _navigation;

    static {
    }

    public static final ImageVector getNavigation(Outlined arg18) {
        ImageVector v0 = NavigationKt._navigation;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.Navigation", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(12f, 7.27f);
        v0_1.lineToRelative(4.28f, 10.43f);
        v0_1.lineToRelative(-3.47f, -1.53f);
        v0_1.lineToRelative(-0.81f, -0.36f);
        v0_1.lineToRelative(-0.81f, 0.36f);
        v0_1.lineToRelative(-3.47f, 1.53f);
        v0_1.lineTo(12f, 7.27f);
        v0_1.moveTo(12f, 2f);
        v0_1.lineTo(4.5f, 20.290001f);
        v0_1.lineToRelative(0.71f, 0.71f);
        v0_1.lineTo(12f, 18f);
        v0_1.lineToRelative(6.79f, 3f);
        v0_1.lineToRelative(0.71f, -0.71f);
        v0_1.lineTo(12f, 2f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        NavigationKt._navigation = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

