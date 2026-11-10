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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_sortByAlpha", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SortByAlpha", "Landroidx/compose/material/icons/Icons$Rounded;", "getSortByAlpha", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SortByAlphaKt {
    private static ImageVector _sortByAlpha;

    static {
    }

    public static final ImageVector getSortByAlpha(Rounded arg19) {
        ImageVector v0 = SortByAlphaKt._sortByAlpha;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.SortByAlpha", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.93f, 2.65f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.lineToRelative(-2.01f, 2.01f);
        v12.horizontalLineToRelative(4.72f);
        v12.lineToRelative(-2f, -2.01f);
        v12.close();
        v12.moveTo(12.23f, 21.35f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(1.98f, -1.98f);
        v12.horizontalLineToRelative(-4.66f);
        v12.lineToRelative(1.97f, 1.98f);
        v12.close();
        v12.moveTo(10.98f, 17.73f);
        v12.curveToRelative(0.6f, 0f, 1.01f, -0.6f, 0.79f, -1.16f);
        v12.lineTo(8.04f, 7.03f);
        v12.curveToRelative(-0.18f, -0.46f, -0.63f, -0.76f, -1.12f, -0.76f);
        v12.curveToRelative(-0.49f, 0f, -0.94f, 0.3f, -1.12f, 0.76f);
        v12.lineToRelative(-3.74f, 9.53f);
        v12.curveToRelative(-0.22f, 0.56f, 0.19f, 1.16f, 0.79f, 1.16f);
        v12.curveToRelative(0.35f, 0f, 0.67f, -0.22f, 0.8f, -0.55f);
        v12.lineToRelative(0.71f, -1.9f);
        v12.horizontalLineToRelative(5.11f);
        v12.lineToRelative(0.71f, 1.9f);
        v12.curveToRelative(0.13f, 0.34f, 0.45f, 0.56f, 0.8f, 0.56f);
        v12.close();
        v12.moveTo(4.97f, 13.64f);
        v12.lineToRelative(1.94f, -5.18f);
        v12.lineToRelative(1.94f, 5.18f);
        v12.lineTo(4.97f, 13.64f);
        v12.close();
        v12.moveTo(21.049999f, 16.139999f);
        v12.horizontalLineToRelative(-5.33f);
        v12.lineToRelative(5.72f, -8.29f);
        v12.curveToRelative(0.46f, -0.66f, -0.02f, -1.57f, -0.82f, -1.57f);
        v12.horizontalLineToRelative(-6.48f);
        v12.curveToRelative(-0.44f, 0f, -0.79f, 0.36f, -0.79f, 0.8f);
        v12.verticalLineToRelative(0.01f);
        v12.curveToRelative(0f, 0.44f, 0.36f, 0.8f, 0.79f, 0.8f);
        v12.horizontalLineToRelative(5.09f);
        v12.lineToRelative(-5.73f, 8.28f);
        v12.curveToRelative(-0.46f, 0.66f, 0.02f, 1.57f, 0.82f, 1.57f);
        v12.horizontalLineToRelative(6.72f);
        v12.curveToRelative(0.44f, 0f, 0.79f, -0.36f, 0.79f, -0.79f);
        v12.curveToRelative(0.02f, -0.45f, -0.34f, -0.81f, -0.78f, -0.81f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SortByAlphaKt._sortByAlpha = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

