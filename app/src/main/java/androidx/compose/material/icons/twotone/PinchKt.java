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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_pinch", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pinch", "Landroidx/compose/material/icons/Icons$TwoTone;", "getPinch", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PinchKt {
    private static ImageVector _pinch;

    static {
    }

    public static final ImageVector getPinch(TwoTone arg19) {
        ImageVector v0 = PinchKt._pinch;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("TwoTone.Pinch", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 15.56f);
        v12.lineToRelative(-4.24f, -1.89f);
        v12.horizontalLineTo(15f);
        v12.verticalLineTo(7.5f);
        v12.curveTo(15f, 7.22f, 14.78f, 7f, 14.5f, 7f);
        v12.reflectiveCurveTo(14f, 7.22f, 14f, 7.5f);
        v12.verticalLineToRelative(10.61f);
        v12.lineToRelative(-4.17f, -0.89f);
        v12.lineToRelative(3.7f, 3.78f);
        v12.horizontalLineToRelative(6.55f);
        v12.lineTo(21f, 15.56f);
        v12.close();
        Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 0.3f, null, 0.3f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null);
        v3 = VectorKt.getDefaultFillType();
        v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        v10 = StrokeCap.Companion.getButt-KaPHkGw();
        v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        v12 = new PathBuilder();
        v12.moveTo(6f, 2.5f);
        v12.verticalLineTo(1f);
        v12.horizontalLineToRelative(5f);
        v12.verticalLineToRelative(5f);
        v12.horizontalLineTo(9.5f);
        v12.verticalLineTo(3.56f);
        v12.lineTo(3.56f, 9.5f);
        v12.horizontalLineTo(6f);
        v12.verticalLineTo(11f);
        v12.horizontalLineTo(1f);
        v12.verticalLineTo(6f);
        v12.horizontalLineToRelative(1.5f);
        v12.verticalLineToRelative(2.44f);
        v12.lineTo(8.44f, 2.5f);
        v12.horizontalLineTo(6f);
        v12.close();
        v12.moveTo(21.889999f, 13.77f);
        v12.lineToRelative(-3.8f, -1.67f);
        v12.curveTo(17.959999f, 12.04f, 17.809999f, 12f, 17.65f, 12f);
        v12.horizontalLineTo(17f);
        v12.verticalLineTo(7.5f);
        v12.curveTo(17f, 6.12f, 15.88f, 5f, 14.5f, 5f);
        v12.reflectiveCurveTo(12f, 6.12f, 12f, 7.5f);
        v12.verticalLineToRelative(8.15f);
        v12.lineToRelative(-1.87f, -0.4f);
        v12.curveToRelative(-0.19f, -0.03f, -1.02f, -0.15f, -1.73f, 0.56f);
        v12.lineTo(7f, 17.219999f);
        v12.lineToRelative(5.12f, 5.19f);
        v12.curveTo(12.49f, 22.790001f, 13f, 23f, 13.53f, 23f);
        v12.horizontalLineToRelative(6.55f);
        v12.curveToRelative(0.98f, 0f, 1.81f, -0.7f, 1.97f, -1.67f);
        v12.lineToRelative(0.92f, -5.44f);
        v12.curveTo(23.120001f, 15.03f, 22.68f, 14.17f, 21.889999f, 13.77f);
        v12.close();
        v12.moveTo(20.08f, 21f);
        v12.horizontalLineToRelative(-6.55f);
        v12.lineToRelative(-3.7f, -3.78f);
        v12.lineTo(14f, 18.110001f);
        v12.verticalLineTo(7.5f);
        v12.curveTo(14f, 7.22f, 14.22f, 7f, 14.5f, 7f);
        v12.reflectiveCurveTo(15f, 7.22f, 15f, 7.5f);
        v12.verticalLineToRelative(6.18f);
        v12.horizontalLineToRelative(1.76f);
        v12.lineTo(21f, 15.56f);
        v12.lineTo(20.08f, 21f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        PinchKt._pinch = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

