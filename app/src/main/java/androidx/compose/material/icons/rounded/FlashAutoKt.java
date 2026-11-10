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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_flashAuto", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FlashAuto", "Landroidx/compose/material/icons/Icons$Rounded;", "getFlashAuto", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class FlashAutoKt {
    private static ImageVector _flashAuto;

    static {
    }

    public static final ImageVector getFlashAuto(Rounded arg19) {
        ImageVector v0 = FlashAutoKt._flashAuto;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Rounded.FlashAuto", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(3f, 3f);
        v12.verticalLineToRelative(10f);
        v12.curveToRelative(0f, 0.55f, 0.45f, 1f, 1f, 1f);
        v12.horizontalLineToRelative(2f);
        v12.verticalLineToRelative(7.15f);
        v12.curveToRelative(0f, 0.51f, 0.67f, 0.69f, 0.93f, 0.25f);
        v12.lineToRelative(5.19f, -8.9f);
        v12.curveToRelative(0.39f, -0.67f, -0.09f, -1.5f, -0.86f, -1.5f);
        v12.lineTo(9f, 11f);
        v12.lineToRelative(3.38f, -7.59f);
        v12.curveToRelative(0.29f, -0.67f, -0.2f, -1.41f, -0.92f, -1.41f);
        v12.lineTo(4f, 2f);
        v12.curveToRelative(-0.55f, 0f, -1f, 0.45f, -1f, 1f);
        v12.close();
        v12.moveTo(18f, 2f);
        v12.curveToRelative(-0.6f, 0f, -1.13f, 0.38f, -1.34f, 0.94f);
        v12.lineTo(14.22f, 9.8f);
        v12.curveToRelative(-0.2f, 0.59f, 0.23f, 1.2f, 0.85f, 1.2f);
        v12.curveToRelative(0.38f, 0f, 0.72f, -0.24f, 0.84f, -0.6f);
        v12.lineTo(16.4f, 9f);
        v12.horizontalLineToRelative(3.2f);
        v12.lineToRelative(0.49f, 1.4f);
        v12.curveToRelative(0.13f, 0.36f, 0.46f, 0.6f, 0.84f, 0.6f);
        v12.curveToRelative(0.62f, 0f, 1.05f, -0.61f, 0.84f, -1.19f);
        v12.lineToRelative(-2.44f, -6.86f);
        v12.curveTo(19.129999f, 2.38f, 18.6f, 2f, 18f, 2f);
        v12.close();
        v12.moveTo(16.85f, 7.65f);
        v12.lineTo(18f, 4f);
        v12.lineToRelative(1.15f, 3.65f);
        v12.horizontalLineToRelative(-2.3f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        FlashAutoKt._flashAuto = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

