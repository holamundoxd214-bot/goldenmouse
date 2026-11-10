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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_keyboardCommandKey", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardCommandKey", "Landroidx/compose/material/icons/Icons$Sharp;", "getKeyboardCommandKey", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class KeyboardCommandKeyKt {
    private static ImageVector _keyboardCommandKey;

    static {
    }

    public static final ImageVector getKeyboardCommandKey(Sharp arg19) {
        ImageVector v0 = KeyboardCommandKeyKt._keyboardCommandKey;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Sharp.KeyboardCommandKey", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(17.5f, 3f);
        v12.curveTo(15.57f, 3f, 14f, 4.57f, 14f, 6.5f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(-4f);
        v12.verticalLineTo(6.5f);
        v12.curveTo(10f, 4.57f, 8.43f, 3f, 6.5f, 3f);
        v12.reflectiveCurveTo(3f, 4.57f, 3f, 6.5f);
        v12.reflectiveCurveTo(4.57f, 10f, 6.5f, 10f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(6.5f);
        v12.curveTo(4.57f, 14f, 3f, 15.57f, 3f, 17.5f);
        v12.reflectiveCurveTo(4.57f, 21f, 6.5f, 21f);
        v12.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        v12.verticalLineTo(16f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(1.5f);
        v12.curveToRelative(0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        v12.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveTo(19.43f, 14f, 17.5f, 14f);
        v12.horizontalLineTo(16f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveToRelative(1.93f, 0f, 3.5f, -1.57f, 3.5f, -3.5f);
        v12.reflectiveCurveTo(19.43f, 3f, 17.5f, 3f);
        v12.lineTo(17.5f, 3f);
        v12.close();
        v12.moveTo(16f, 8f);
        v12.verticalLineTo(6.5f);
        v12.curveTo(16f, 5.67f, 16.67f, 5f, 17.5f, 5f);
        v12.reflectiveCurveTo(19f, 5.67f, 19f, 6.5f);
        v12.reflectiveCurveTo(18.33f, 8f, 17.5f, 8f);
        v12.horizontalLineTo(16f);
        v12.lineTo(16f, 8f);
        v12.close();
        v12.moveTo(6.5f, 8f);
        v12.curveTo(5.67f, 8f, 5f, 7.33f, 5f, 6.5f);
        v12.reflectiveCurveTo(5.67f, 5f, 6.5f, 5f);
        v12.reflectiveCurveTo(8f, 5.67f, 8f, 6.5f);
        v12.verticalLineTo(8f);
        v12.horizontalLineTo(6.5f);
        v12.lineTo(6.5f, 8f);
        v12.close();
        v12.moveTo(10f, 14f);
        v12.verticalLineToRelative(-4f);
        v12.horizontalLineToRelative(4f);
        v12.verticalLineToRelative(4f);
        v12.horizontalLineTo(10f);
        v12.lineTo(10f, 14f);
        v12.close();
        v12.moveTo(17.5f, 19f);
        v12.curveToRelative(-0.83f, 0f, -1.5f, -0.67f, -1.5f, -1.5f);
        v12.verticalLineTo(16f);
        v12.horizontalLineToRelative(1.5f);
        v12.curveToRelative(0.83f, 0f, 1.5f, 0.67f, 1.5f, 1.5f);
        v12.reflectiveCurveTo(18.33f, 19f, 17.5f, 19f);
        v12.lineTo(17.5f, 19f);
        v12.close();
        v12.moveTo(6.5f, 19f);
        v12.curveTo(5.67f, 19f, 5f, 18.33f, 5f, 17.5f);
        v12.reflectiveCurveTo(5.67f, 16f, 6.5f, 16f);
        v12.horizontalLineTo(8f);
        v12.verticalLineToRelative(1.5f);
        v12.curveTo(8f, 18.33f, 7.33f, 19f, 6.5f, 19f);
        v12.lineTo(6.5f, 19f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        KeyboardCommandKeyKt._keyboardCommandKey = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

