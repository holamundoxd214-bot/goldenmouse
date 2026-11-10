package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons$Filled;
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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_voiceOverOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "VoiceOverOff", "Landroidx/compose/material/icons/Icons$Filled;", "getVoiceOverOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class VoiceOverOffKt {
    private static ImageVector _voiceOverOff;

    static {
    }

    public static final ImageVector getVoiceOverOff(Filled arg19) {
        ImageVector v0 = VoiceOverOffKt._voiceOverOff;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.VoiceOverOff", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(12.99f, 9.18f);
        v12.curveToRelative(0f, -0.06f, 0.01f, -0.12f, 0.01f, -0.18f);
        v12.curveToRelative(0f, -2.21f, -1.79f, -4f, -4f, -4f);
        v12.curveToRelative(-0.06f, 0f, -0.12f, 0.01f, -0.18f, 0.01f);
        v12.lineToRelative(4.17f, 4.17f);
        v12.close();
        v12.moveTo(6.89f, 5.62f);
        v12.lineTo(4.27f, 3f);
        v12.lineTo(3f, 4.27f);
        v12.lineToRelative(2.62f, 2.62f);
        v12.curveTo(5.23f, 7.5f, 5f, 8.22f, 5f, 9f);
        v12.curveToRelative(0f, 2.21f, 1.79f, 4f, 4f, 4f);
        v12.curveToRelative(0.78f, 0f, 1.5f, -0.23f, 2.11f, -0.62f);
        v12.lineTo(19.73f, 21f);
        v12.lineTo(21f, 19.73f);
        v12.lineToRelative(-8.62f, -8.62f);
        v12.lineToRelative(-5.49f, -5.49f);
        v12.close();
        v12.moveTo(9f, 15f);
        v12.curveToRelative(-2.67f, 0f, -8f, 1.34f, -8f, 4f);
        v12.verticalLineToRelative(2f);
        v12.horizontalLineToRelative(16f);
        v12.verticalLineToRelative(-2f);
        v12.curveToRelative(0f, -2.66f, -5.33f, -4f, -8f, -4f);
        v12.close();
        v12.moveTo(16.76f, 5.36f);
        v12.lineToRelative(-1.68f, 1.69f);
        v12.curveToRelative(0.84f, 1.18f, 0.84f, 2.71f, 0f, 3.89f);
        v12.lineToRelative(1.68f, 1.69f);
        v12.curveToRelative(2.02f, -2.02f, 2.02f, -5.07f, 0f, -7.27f);
        v12.close();
        v12.moveTo(20.07f, 2f);
        v12.lineToRelative(-1.63f, 1.63f);
        v12.curveToRelative(2.77f, 3.02f, 2.77f, 7.56f, 0f, 10.74f);
        v12.lineTo(20.07f, 16f);
        v12.curveToRelative(3.9f, -3.89f, 3.91f, -9.95f, 0f, -14f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        VoiceOverOffKt._voiceOverOff = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

