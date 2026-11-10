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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_cleanHands", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CleanHands", "Landroidx/compose/material/icons/Icons$Sharp;", "getCleanHands", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class CleanHandsKt {
    private static ImageVector _cleanHands;

    static {
    }

    public static final ImageVector getCleanHands(Sharp arg19) {
        ImageVector v0 = CleanHandsKt._cleanHands;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.CleanHands", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(14.99f, 7f);
        v12.lineToRelative(1.37f, -0.63f);
        v12.lineTo(16.99f, 5f);
        v12.lineToRelative(0.63f, 1.37f);
        v12.lineTo(18.99f, 7f);
        v12.lineToRelative(-1.37f, 0.63f);
        v12.lineTo(16.99f, 9f);
        v12.lineToRelative(-0.63f, -1.37f);
        v12.lineTo(14.99f, 7f);
        v12.close();
        v12.moveTo(20f, 14f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.curveToRelative(0f, -1.1f, -2f, -4f, -2f, -4f);
        v12.reflectiveCurveToRelative(-2f, 2.9f, -2f, 4f);
        v12.curveTo(18f, 13.1f, 18.9f, 14f, 20f, 14f);
        v12.close();
        v12.moveTo(1f, 22f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineTo(11f);
        v12.horizontalLineTo(1f);
        v12.verticalLineTo(22f);
        v12.close();
        v12.moveTo(9.24f, 9.5f);
        v12.lineTo(15f, 11.65f);
        v12.verticalLineTo(11f);
        v12.curveToRelative(0f, -2.42f, -1.72f, -4.44f, -4f, -4.9f);
        v12.verticalLineTo(4f);
        v12.horizontalLineToRelative(2f);
        v12.curveToRelative(0.57f, 0f, 1.1f, 0.17f, 1.55f, 0.45f);
        v12.lineToRelative(1.43f, -1.43f);
        v12.curveTo(15.15f, 2.39f, 14.13f, 2f, 13f, 2f);
        v12.curveToRelative(-1.48f, 0f, -5.5f, 0f, -5.5f, 0f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(2.11f);
        v12.curveTo(7.22f, 6.48f, 5.8f, 7.79f, 5.25f, 9.5f);
        v12.horizontalLineTo(9.24f);
        v12.close();
        v12.moveTo(22f, 17f);
        v12.horizontalLineToRelative(-9f);
        v12.lineToRelative(-2.09f, -0.73f);
        v12.lineToRelative(0.33f, -0.94f);
        v12.lineTo(13f, 16f);
        v12.horizontalLineToRelative(4f);
        v12.lineToRelative(0f, -2f);
        v12.lineToRelative(-8.03f, -3f);
        v12.horizontalLineTo(7f);
        v12.verticalLineToRelative(9.02f);
        v12.lineTo(14f, 22f);
        v12.lineToRelative(8f, -3f);
        v12.verticalLineTo(17f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        CleanHandsKt._cleanHands = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

