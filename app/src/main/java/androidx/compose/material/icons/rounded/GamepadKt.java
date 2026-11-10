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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_gamepad", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Gamepad", "Landroidx/compose/material/icons/Icons$Rounded;", "getGamepad", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class GamepadKt {
    private static ImageVector _gamepad;

    static {
    }

    public static final ImageVector getGamepad(Rounded arg19) {
        ImageVector v0 = GamepadKt._gamepad;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.Gamepad", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(15f, 7.29f);
        v12.lineTo(15f, 3f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4.29f);
        v12.curveToRelative(0f, 0.13f, 0.05f, 0.26f, 0.15f, 0.35f);
        v12.lineToRelative(2.5f, 2.5f);
        v12.curveToRelative(0.2f, 0.2f, 0.51f, 0.2f, 0.71f, 0f);
        v12.lineToRelative(2.5f, -2.5f);
        v12.curveToRelative(0.09f, -0.09f, 0.14f, -0.21f, 0.14f, -0.35f);
        v12.close();
        v12.moveTo(7.29f, 9f);
        v12.lineTo(3f, 9f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.verticalLineToRelative(4f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4.29f);
        v12.curveToRelative(0.13f, 0f, 0.26f, -0.05f, 0.35f, -0.15f);
        v12.lineToRelative(2.5f, -2.5f);
        v12.curveToRelative(0.2f, -0.2f, 0.2f, -0.51f, 0f, -0.71f);
        v12.lineToRelative(-2.5f, -2.5f);
        v12.curveTo(7.55f, 9.05f, 7.43f, 9f, 7.29f, 9f);
        v12.close();
        v12.moveTo(9f, 16.709999f);
        v12.lineTo(9f, 21f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(4f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4.29f);
        v12.curveToRelative(0f, -0.13f, -0.05f, -0.26f, -0.15f, -0.35f);
        v12.lineToRelative(-2.5f, -2.5f);
        v12.curveToRelative(-0.2f, -0.2f, -0.51f, -0.2f, -0.71f, 0f);
        v12.lineToRelative(-2.5f, 2.5f);
        v12.curveToRelative(-0.09f, 0.09f, -0.14f, 0.21f, -0.14f, 0.35f);
        v12.close();
        v12.moveTo(16.35f, 9.15f);
        v12.lineToRelative(-2.5f, 2.5f);
        v12.curveToRelative(-0.2f, 0.2f, -0.2f, 0.51f, 0f, 0.71f);
        v12.lineToRelative(2.5f, 2.5f);
        v12.curveToRelative(0.09f, 0.09f, 0.22f, 0.15f, 0.35f, 0.15f);
        v12.lineTo(21f, 15.01f);
        v12.curveToRelative(0.55f, 0f, 1f, -0.45f, 1f, -1f);
        v12.verticalLineToRelative(-4f);
        v12.curveToRelative(0f, -0.55f, -0.45f, -1f, -1f, -1f);
        v12.horizontalLineToRelative(-4.29f);
        v12.curveToRelative(-0.14f, -0.01f, -0.26f, 0.04f, -0.36f, 0.14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        GamepadKt._gamepad = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

