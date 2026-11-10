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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sortByAlpha", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SortByAlpha", "Landroidx/compose/material/icons/Icons$Filled;", "getSortByAlpha", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SortByAlphaKt {
    private static ImageVector _sortByAlpha;

    static {
    }

    public static final ImageVector getSortByAlpha(Filled arg18) {
        ImageVector v0 = SortByAlphaKt._sortByAlpha;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.SortByAlpha", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v0_1 = new PathBuilder();
        v0_1.moveTo(14.94f, 4.66f);
        v0_1.horizontalLineToRelative(-4.72f);
        v0_1.lineToRelative(2.36f, -2.36f);
        v0_1.close();
        v0_1.moveTo(10.25f, 19.370001f);
        v0_1.horizontalLineToRelative(4.66f);
        v0_1.lineToRelative(-2.33f, 2.33f);
        v0_1.close();
        v0_1.moveTo(6.1f, 6.27f);
        v0_1.lineTo(1.6f, 17.73f);
        v0_1.horizontalLineToRelative(1.84f);
        v0_1.lineToRelative(0.92f, -2.45f);
        v0_1.horizontalLineToRelative(5.11f);
        v0_1.lineToRelative(0.92f, 2.45f);
        v0_1.horizontalLineToRelative(1.84f);
        v0_1.lineTo(7.74f, 6.27f);
        v0_1.lineTo(6.1f, 6.27f);
        v0_1.close();
        v0_1.moveTo(4.97f, 13.64f);
        v0_1.lineToRelative(1.94f, -5.18f);
        v0_1.lineToRelative(1.94f, 5.18f);
        v0_1.lineTo(4.97f, 13.64f);
        v0_1.close();
        v0_1.moveTo(15.73f, 16.139999f);
        v0_1.horizontalLineToRelative(6.12f);
        v0_1.verticalLineToRelative(1.59f);
        v0_1.horizontalLineToRelative(-8.53f);
        v0_1.verticalLineToRelative(-1.29f);
        v0_1.lineToRelative(5.92f, -8.56f);
        v0_1.horizontalLineToRelative(-5.88f);
        v0_1.verticalLineToRelative(-1.6f);
        v0_1.horizontalLineToRelative(8.3f);
        v0_1.verticalLineToRelative(1.26f);
        v0_1.lineToRelative(-5.93f, 8.6f);
        v0_1.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v0_1.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SortByAlphaKt._sortByAlpha = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

