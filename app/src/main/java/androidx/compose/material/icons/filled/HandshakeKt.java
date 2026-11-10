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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001A\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"_handshake", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Handshake", "Landroidx/compose/material/icons/Icons$Filled;", "getHandshake", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class HandshakeKt {
    private static ImageVector _handshake;

    static {
    }

    public static final ImageVector getHandshake(Filled arg19) {
        ImageVector v0 = HandshakeKt._handshake;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0;
        }

        Builder v1 = new Builder("Filled.Handshake", Dp.constructor-impl(24f), Dp.constructor-impl(24f), 24f, 24f, 0, 0, false, 0x60, null);
        int v3 = VectorKt.getDefaultFillType();
        SolidColor v5 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), null);
        int v10 = StrokeCap.Companion.getButt-KaPHkGw();
        int v11 = StrokeJoin.Companion.getBevel-LxFBmk8();
        PathBuilder v12 = new PathBuilder();
        v12.moveTo(16.48f, 10.41f);
        v12.curveToRelative(-0.39f, 0.39f, -1.04f, 0.39f, -1.43f, 0f);
        v12.lineToRelative(-4.47f, -4.46f);
        v12.lineToRelative(-7.05f, 7.04f);
        v12.lineToRelative(-0.66f, -0.63f);
        v12.curveToRelative(-1.17f, -1.17f, -1.17f, -3.07f, 0f, -4.24f);
        v12.lineToRelative(4.24f, -4.24f);
        v12.curveToRelative(1.17f, -1.17f, 3.07f, -1.17f, 4.24f, 0f);
        v12.lineTo(16.48f, 9f);
        v12.curveTo(16.870001f, 9.39f, 16.870001f, 10.02f, 16.48f, 10.41f);
        v12.close();
        v12.moveTo(17.18f, 8.29f);
        v12.curveToRelative(0.78f, 0.78f, 0.78f, 2.05f, 0f, 2.83f);
        v12.curveToRelative(-1.27f, 1.27f, -2.61f, 0.22f, -2.83f, 0f);
        v12.lineToRelative(-3.76f, -3.76f);
        v12.lineToRelative(-5.57f, 5.57f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.42f, 0f);
        v12.lineToRelative(4.62f, -4.62f);
        v12.lineToRelative(0.71f, 0.71f);
        v12.lineToRelative(-4.62f, 4.62f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.42f, 0f);
        v12.lineToRelative(4.62f, -4.62f);
        v12.lineToRelative(0.71f, 0.71f);
        v12.lineToRelative(-4.62f, 4.62f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(4.62f, -4.62f);
        v12.lineToRelative(0.71f, 0.71f);
        v12.lineToRelative(-4.62f, 4.62f);
        v12.curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f);
        v12.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f);
        v12.lineToRelative(8.32f, -8.34f);
        v12.curveToRelative(1.17f, -1.17f, 1.17f, -3.07f, 0f, -4.24f);
        v12.lineToRelative(-4.24f, -4.24f);
        v12.curveToRelative(-1.15f, -1.15f, -3.01f, -1.17f, -4.18f, -0.06f);
        v12.lineTo(17.18f, 8.29f);
        v12.close();
        v0 = Builder.addPath-oIyEayM$default(v1, v12.getNodes(), v3, "", ((Brush)v5), 1f, null, 1f, 1f, v10, v11, 1f, 0f, 0f, 0f, 0x3800, null).build();
        HandshakeKt._handshake = v0;
        Intrinsics.checkNotNull(v0);
        return v0;
    }
}

