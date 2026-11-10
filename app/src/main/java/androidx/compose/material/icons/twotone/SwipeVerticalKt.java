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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_swipeVertical", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeVertical", "Landroidx/compose/material/icons/Icons$TwoTone;", "getSwipeVertical", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class SwipeVerticalKt {
    private static ImageVector _swipeVertical;

    static {
    }

    public static final ImageVector getSwipeVertical(TwoTone arg19) {
        ImageVector v0 = SwipeVerticalKt._swipeVertical;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.SwipeVertical", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21.49f, 17.34f);
        v12.lineTo(15.5f, 20f);
        v12.lineToRelative(-4.92f, -1.96f);
        v12.lineToRelative(4.18f, -0.88f);
        v12.lineToRelative(-4.3f, -9.7f);
        v12.curveToRelative(-0.11f, -0.25f, 0f, -0.55f, 0.25f, -0.66f);
        v12.curveToRelative(0.25f, -0.11f, 0.55f, 0f, 0.66f, 0.25f);
        v12.lineToRelative(2.5f, 5.65f);
        v12.lineToRelative(1.61f, -0.71f);
        v12.lineTo(20.129999f, 12f);
        v12.lineTo(21.49f, 17.34f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(1f, 2f);
        v12.horizontalLineToRelative(3.5f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(1.5f);
        v12.verticalLineTo(7f);
        v12.horizontalLineTo(4.5f);
        v12.verticalLineTo(4.09f);
        v12.curveToRelative(-1.86f, 2.11f, -3f, 4.88f, -3f, 7.91f);
        v12.reflectiveCurveToRelative(1.14f, 5.79f, 3f, 7.91f);
        v12.verticalLineTo(17f);
        v12.horizontalLineTo(6f);
        v12.verticalLineToRelative(3.5f);
        v12.verticalLineTo(22f);
        v12.horizontalLineTo(4.5f);
        v12.horizontalLineTo(1f);
        v12.verticalLineToRelative(-1.5f);
        v12.horizontalLineToRelative(2.02f);
        v12.curveTo(1.13f, 18.18f, 0f, 15.22f, 0f, 12f);
        v12.reflectiveCurveToRelative(1.13f, -6.18f, 3.02f, -8.5f);
        v12.horizontalLineTo(1f);
        v12.verticalLineTo(2f);
        v12.close();
        v12.moveTo(20.219999f, 10f);
        v12.lineToRelative(-4.15f, 0.01f);
        v12.curveToRelative(-0.16f, -0.01f, -0.31f, 0.02f, -0.45f, 0.08f);
        v12.lineToRelative(-0.59f, 0.26f);
        v12.lineTo(13.2f, 6.25f);
        v12.curveToRelative(-0.56f, -1.26f, -2.04f, -1.83f, -3.3f, -1.27f);
        v12.reflectiveCurveToRelative(-1.83f, 2.04f, -1.27f, 3.3f);
        v12.lineToRelative(3.3f, 7.45f);
        v12.lineToRelative(-1.87f, 0.39f);
        v12.curveToRelative(-0.19f, 0.05f, -0.99f, 0.27f, -1.36f, 1.21f);
        v12.lineTo(8f, 19.190001f);
        v12.lineToRelative(6.78f, 2.67f);
        v12.curveToRelative(0.49f, 0.19f, 1.05f, 0.18f, 1.53f, -0.04f);
        v12.lineToRelative(5.99f, -2.65f);
        v12.curveToRelative(0.89f, -0.4f, 1.37f, -1.38f, 1.13f, -2.32f);
        v12.lineToRelative(-1.36f, -5.34f);
        v12.curveTo(21.85f, 10.65f, 21.1f, 10.04f, 20.219999f, 10f);
        v12.close();
        v12.moveTo(21.49f, 17.34f);
        v12.lineTo(15.5f, 20f);
        v12.lineToRelative(-4.92f, -1.96f);
        v12.lineToRelative(4.18f, -0.88f);
        v12.lineToRelative(-4.3f, -9.7f);
        v12.curveToRelative(-0.11f, -0.25f, 0f, -0.55f, 0.25f, -0.66f);
        v12.curveToRelative(0.25f, -0.11f, 0.55f, 0f, 0.66f, 0.25f);
        v12.lineToRelative(2.5f, 5.65f);
        v12.lineToRelative(1.61f, -0.71f);
        v12.lineTo(20.129999f, 12f);
        v12.lineTo(21.49f, 17.34f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        SwipeVerticalKt._swipeVertical = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

