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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_keyboardVoice", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardVoice", "Landroidx/compose/material/icons/Icons$Outlined;", "getKeyboardVoice", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class KeyboardVoiceKt {
    private static ImageVector _keyboardVoice;

    static {
    }

    public static final ImageVector getKeyboardVoice(Outlined arg19) {
        ImageVector v0 = KeyboardVoiceKt._keyboardVoice;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Outlined.KeyboardVoice", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12f, 15f);
        v12.curveToRelative(1.66f, 0f, 2.99f, -1.34f, 2.99f, -3f);
        v12.lineTo(15f, 6f);
        v12.curveToRelative(0f, -1.66f, -1.34f, -3f, -3f, -3f);
        v12.reflectiveCurveTo(9f, 4.34f, 9f, 6f);
        v12.verticalLineToRelative(6f);
        v12.curveToRelative(0f, 1.66f, 1.34f, 3f, 3f, 3f);
        v12.close();
        v12.moveTo(10.8f, 5.9f);
        v12.curveToRelative(0f, -0.66f, 0.54f, -1.2f, 1.2f, -1.2f);
        v12.reflectiveCurveToRelative(1.2f, 0.54f, 1.2f, 1.2f);
        v12.lineToRelative(-0.01f, 6.2f);
        v12.curveToRelative(0f, 0.66f, -0.53f, 1.2f, -1.19f, 1.2f);
        v12.reflectiveCurveToRelative(-1.2f, -0.54f, -1.2f, -1.2f);
        v12.lineTo(10.8f, 5.9f);
        v12.close();
        v12.moveTo(17.299999f, 12f);
        v12.curveToRelative(0f, 3f, -2.54f, 5.1f, -5.3f, 5.1f);
        v12.reflectiveCurveTo(6.7f, 15f, 6.7f, 12f);
        v12.lineTo(5f, 12f);
        v12.curveToRelative(0f, 3.41f, 2.72f, 6.23f, 6f, 6.72f);
        v12.lineTo(11f, 22f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(-3.28f);
        v12.curveToRelative(3.28f, -0.48f, 6f, -3.3f, 6f, -6.72f);
        v12.horizontalLineToRelative(-1.7f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        KeyboardVoiceKt._keyboardVoice = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

