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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cleanHands", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CleanHands", "Landroidx/compose/material/icons/Icons$Outlined;", "getCleanHands", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CleanHandsKt {
    private static ImageVector _cleanHands;

    static {
    }

    public static final ImageVector getCleanHands(Outlined arg19) {
        ImageVector v0 = CleanHandsKt._cleanHands;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.CleanHands", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.99f, 5f);
        v12.lineToRelative(0.63f, 1.37f);
        v12.lineTo(18.99f, 7f);
        v12.lineToRelative(-1.37f, 0.63f);
        v12.lineTo(16.99f, 9f);
        v12.lineToRelative(-0.63f, -1.37f);
        v12.lineTo(14.99f, 7f);
        v12.lineToRelative(1.37f, -0.63f);
        v12.lineTo(16.99f, 5f);
        v12.moveTo(20f, 14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -2f, -4f, -2f, -4f);
        v12.reflectiveCurveToRelative(-2f, 2.9f, -2f, 4f);
        v12.curveTo(18f, 13.1f, 18.9f, 14f, 20f, 14f);
        v12.close();
        v12.moveTo(11f, 6.1f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.57f, 0f, 1.1f, 0.17f, 1.55f, 0.45f);
        v12.lineToRelative(1.43f, -1.43f);
        v12.curveTo(15.15f, 2.39f, 14.13f, 2f, 13f, 2f);
        v12.curveToRelative(-1.47f, 0f, -5.44f, 0f, -5.5f, 0f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2.11f);
        v12.curveTo(7.22f, 6.48f, 5.8f, 7.79f, 5.25f, 9.5f);
        v12.horizontalLineToRelative(2.16f);
        v12.curveTo(7.94f, 8.61f, 8.89f, 8f, 10f, 8f);
        v12.curveToRelative(1.62f, 0f, 2.94f, 1.29f, 2.99f, 2.9f);
        v12.lineTo(15f, 11.65f);
        v12.verticalLineTo(11f);
        v12.curveTo(15f, 8.58f, 13.28f, 6.56f, 11f, 6.1f);
        v12.close();
        v12.moveTo(22f, 19f);
        v12.verticalLineToRelative(1f);
        v12.lineToRelative(-8f, 2.5f);
        v12.lineToRelative(-7f, -1.94f);
        v12.verticalLineTo(22f);
        v12.horizontalLineTo(1f);
        v12.verticalLineTo(11f);
        v12.horizontalLineToRelative(7.97f);
        v12.lineToRelative(6.16f, 2.3f);
        v12.curveTo(16.25f, 13.72f, 17f, 14.8f, 17f, 16f);
        v12.horizontalLineToRelative(2f);
        v12.curveTo(20.66f, 16f, 22f, 17.34f, 22f, 19f);
        v12.close();
        v12.moveTo(5f, 20f);
        v12.verticalLineToRelative(-7f);
        v12.horizontalLineTo(3f);
        v12.verticalLineToRelative(7f);
        v12.horizontalLineTo(5f);
        v12.close();
        v12.moveTo(19.9f, 18.57f);
        v12.curveToRelative(-0.16f, -0.33f, -0.51f, -0.56f, -0.9f, -0.56f);
        v12.horizontalLineToRelative(-5.35f);
        v12.curveToRelative(-0.54f, 0f, -1.07f, -0.09f, -1.58f, -0.26f);
        v12.lineToRelative(-2.38f, -0.79f);
        v12.lineToRelative(0.63f, -1.9f);
        v12.lineToRelative(2.38f, 0.79f);
        v12.curveTo(13.01f, 15.95f, 15f, 16f, 15f, 16f);
        v12.curveToRelative(0f, -0.37f, -0.23f, -0.7f, -0.57f, -0.83f);
        v12.lineTo(8.61f, 13f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(5.48f);
        v12.lineToRelative(6.97f, 1.93f);
        v12.lineTo(19.9f, 18.57f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CleanHandsKt._cleanHands = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

