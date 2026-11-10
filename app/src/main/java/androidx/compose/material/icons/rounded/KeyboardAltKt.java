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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_keyboardAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getKeyboardAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class KeyboardAltKt {
    private static ImageVector _keyboardAlt;

    static {
    }

    public static final ImageVector getKeyboardAlt(Rounded arg19) {
        ImageVector v0 = KeyboardAltKt._keyboardAlt;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.KeyboardAlt", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(21f, 4f);
        v12.horizontalLineTo(3f);
        v12.curveTo(1.9f, 4f, 1f, 4.9f, 1f, 6f);
        v12.verticalLineToRelative(13f);
        v12.curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f);
        v12.horizontalLineToRelative(18f);
        v12.curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f);
        v12.verticalLineTo(6f);
        v12.curveTo(23f, 4.9f, 22.1f, 4f, 21f, 4f);
        v12.close();
        v12.moveTo(7f, 12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(5f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(7f);
        v12.close();
        v12.moveTo(5f, 10f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(5f);
        v12.close();
        v12.moveTo(11f, 12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(9f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(11f);
        v12.close();
        v12.moveTo(9f, 10f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(9f);
        v12.close();
        v12.moveTo(16f, 16.5f);
        v12.lineTo(16f, 16.5f);
        v12.curveToRelative(0f, 0.28f, -0.22f, 0.5f, -0.5f, 0.5f);
        v12.horizontalLineToRelative(-7f);
        v12.curveTo(8.22f, 17f, 8f, 16.780001f, 8f, 16.5f);
        v12.lineToRelative(0f, 0f);
        v12.curveTo(8f, 16.219999f, 8.22f, 16f, 8.5f, 16f);
        v12.horizontalLineToRelative(7f);
        v12.curveTo(15.78f, 16f, 16f, 16.219999f, 16f, 16.5f);
        v12.close();
        v12.moveTo(15f, 12f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineTo(15f);
        v12.close();
        v12.moveTo(13f, 10f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(13f);
        v12.close();
        v12.moveTo(17f, 14f);
        v12.verticalLineToRelative(-2f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineTo(17f);
        v12.close();
        v12.moveTo(19f, 10f);
        v12.horizontalLineToRelative(-2f);
        v12.verticalLineTo(8f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineTo(10f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        KeyboardAltKt._keyboardAlt = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

